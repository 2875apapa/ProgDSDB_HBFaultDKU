package dsdb.prog.fault_detector.Data;

import java.time.Instant;

public class Detector {
    private String serviceName;
    private String serviceStatus;
    private String dbStatus;
    private Instant timere;


    public Detector(String serviceName, String serviceStatus, String dbStatus, Instant timere) {
        this.serviceName = serviceName;
        this.serviceStatus = serviceStatus;
        this.dbStatus = dbStatus;
        this.timere = timere;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(String dbStatus) {
        this.dbStatus = dbStatus;
    }

    public Instant getTimere() {
        return timere;
    }

    public void setTimere(Instant timere) {
        this.timere = timere;
    }
}
