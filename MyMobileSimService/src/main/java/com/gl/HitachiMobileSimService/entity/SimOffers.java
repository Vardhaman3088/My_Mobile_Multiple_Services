package com.gl.HitachiMobileSimService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class SimOffers {

    //For the below data members add required validations
    // Also include ORM mapping required as per given DB schema amd problem statement..

    @Id
    private int offerId;
    private int callQty;
    private int cost;
    private int dataQty;
    private int duration;
    private String offerName;
    @OneToOne
    private SimDetails simDetails;

    public SimOffers(int offerId, int callQty, int cost, int dataQty, int duration, String offerName, SimDetails simDetails) {
        this.offerId = offerId;
        this.callQty = callQty;
        this.cost = cost;
        this.dataQty = dataQty;
        this.duration = duration;
        this.offerName = offerName;
        this.simDetails = simDetails;
    }

    public SimOffers() {
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getCallQty() {
        return callQty;
    }

    public void setCallQty(int callQty) {
        this.callQty = callQty;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDataQty() {
        return dataQty;
    }

    public void setDataQty(int dataQty) {
        this.dataQty = dataQty;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public SimDetails getSimDetails() {
        return simDetails;
    }

    public void setSimDetails(SimDetails simDetails) {
        this.simDetails = simDetails;
    }

    @Override
    public String toString() {
        return "SimOffers{" +
                "offerId=" + offerId +
                ", callQty=" + callQty +
                ", cost=" + cost +
                ", dataQty=" + dataQty +
                ", duration=" + duration +
                ", offerName='" + offerName + '\'' +
                ", simDetails=" + simDetails +
                '}';
    }
}
