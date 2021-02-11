package dsdb.prog.fault_detector.Service;

import com.google.gson.Gson;
import dsdb.prog.fault_detector.Data.Detector;
import dsdb.prog.fault_detector.Data.messA;
import dsdb.prog.fault_detector.Data.messB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class DetectorService {

    HashMap<String, Detector> mapDetector = new HashMap<String, Detector>();

    @Value("${kafkaTopic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> template;

    public void writeMessage(String msg)
    {
        template.send(topic, msg);
        System.out.println(" ooo Write message su kafka :" + msg + "  -  OK  ooo");
    }

    public HashMap<String, Detector> getAllDetector()
    {
        return mapDetector;
    }

    public Detector getDetectorByName(String sName)
    {
        Detector found = mapDetector.get(sName);
        return found;
    }

    public Detector addDetector(Detector newDetector)
    {
        Instant instant = Instant.now();
        newDetector.setTimere(instant);
        System.out.println("*** Ricevuto e aggiunto in mappa ping da: " + newDetector.getServiceName() + " - serviceStatus: " + newDetector.getServiceStatus() + " - dbStatus: " + newDetector.getDbStatus() + " ***");
        mapDetector.put(newDetector.getServiceName(), newDetector);
        if(newDetector.getServiceStatus().equals("down") || newDetector.getDbStatus().equals("down"))
        {
            messA messres = new messA("service_down",instant,newDetector,newDetector.getServiceName());
            writeMessage(new Gson().toJson(messres));
        }
        return newDetector;
    }

    @Value("${period}")
    private long a;

    @Scheduled(fixedRateString = "${period}")
    public void reportCurrentTime()
    {
        for (Map.Entry<String, Detector> entry : mapDetector.entrySet())
        {
            Instant now = Instant.now();
            if(now.getEpochSecond() - entry.getValue().getTimere().getEpochSecond() > (a/1000))
            {
                messB messres = new messB("service_down",now,"{ serverUnavailable: No heart-beat received }",entry.getValue().getServiceName());
                writeMessage(new Gson().toJson(messres));
            }
            //System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue().getTimere());
        }
    }
}


