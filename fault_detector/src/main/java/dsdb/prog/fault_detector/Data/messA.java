package dsdb.prog.fault_detector.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

public class messA implements Serializable {

    private String key;
    private Timestamp time;
    private Detector status;
    private String service;

    public String getKey() {
        return key;
    }

    public messA setKey(String key) {
        this.key = key;
        return this;
    }

    public Timestamp getTime() {
        return time;
    }

    public messA setTime(Instant time) {
        this.time = Timestamp.from(time);
        return this;
    }

    public Detector getStatus() {
        return status;
    }

    public messA setStatus(Detector status) {
        this.status = status;
        return this;
    }

    public String getService() {
        return service;
    }

    public messA setService(String service) {
        this.service = service;
        return this;
    }

    public messA(String key, Instant time, Detector status, String service) {
        this.key = key;
        this.time = Timestamp.from(time);
        this.status = status;
        this.service = service;
    }
}
