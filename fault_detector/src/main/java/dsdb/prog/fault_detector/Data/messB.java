package dsdb.prog.fault_detector.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

public class messB implements Serializable {
    private String key;
    private Timestamp time;
    private String status;
    private String service;

    public String getKey() {
        return key;
    }

    public messB setKey(String key) {
        this.key = key;
        return this;
    }

    public Timestamp getTime() {
        return time;
    }

    public messB setTime(Instant time) {
        this.time = Timestamp.from(time);
        return this;
    }

    public String getService() {
        return service;
    }

    public messB setService(String service) {
        this.service = service;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public messB setStatus(String status) {
        this.status = status;
        return this;
    }

    public messB(String key, Instant time, String status, String service) {
        this.key = key;
        this.time = Timestamp.from(time);
        this.status = status;
        this.service = service;
    }
}
