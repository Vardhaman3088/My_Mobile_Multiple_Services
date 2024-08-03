package com.gl.MyMobileCustomerService.dto;

public class SimDetails {

    private int simId;
    private long serviceNumber;
    private long simNumber;
    private String simStatus;

    public SimDetails(int simId, long serviceNumber, long simNumber, String simStatus) {
        this.simId = simId;
        this.serviceNumber = serviceNumber;
        this.simNumber = simNumber;
        this.simStatus = simStatus;
    }

    public SimDetails() {
    }

    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    public long getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(long serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public long getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(long simNumber) {
        this.simNumber = simNumber;
    }

    public String getSimStatus() {
        return simStatus;
    }

    public void setSimStatus(String simStatus) {
        this.simStatus = simStatus;
    }

    @Override
    public String toString() {
        return "SimDetails{" +
                "simId=" + simId +
                ", serviceNumber=" + serviceNumber +
                ", simNumber=" + simNumber +
                ", simStatus='" + simStatus + '\'' +
                '}';
    }
}
