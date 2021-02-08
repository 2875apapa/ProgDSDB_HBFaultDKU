package dsdb.prog.fault_detector.Controller;

import dsdb.prog.fault_detector.Data.Detector;
import dsdb.prog.fault_detector.Service.DetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DetectorController {

    @Autowired
    DetectorService detectorService;

    //GET http://localhost:1234/ping
    @GetMapping(path = "/ping")
    public @ResponseBody Map<String, String> Hello()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("serviceStatus", "up");
        map.put("dbStatus", "up");
        return map;
    }

    //For kb8
    @GetMapping(path = "/pinga")
    public @ResponseBody String ciao()
    {
        return "ponga";
    }


    //GET http://localhost:1234/host/all    -   Utilizzata per test
    @GetMapping(path = "/host/all")
    public @ResponseBody Map<String, Detector> getAllDetector()
    {
        return detectorService.getAllDetector();
    }

    //POST http://localhost:1234/ping
    @PostMapping(path = "/ping")
    public @ResponseBody Detector addDetector(@RequestBody Detector newDetector)
    {
        return detectorService.addDetector(newDetector);
    }
}
