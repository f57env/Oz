package com.chargehub.entity;


public class Station {


    private int stationId;
    private String stationName;
    private String location;
    private String chargerType;
    private int availableSlots;
    private double price;


    public int getStationId() {
        return stationId;
    }


    public void setStationId(int stationId) {
        this.stationId = stationId;
    }


    public String getStationName() {
        return stationName;
    }


    public void setStationName(String stationName) {
        this.stationName = stationName;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public String getChargerType() {
        return chargerType;
    }


    public void setChargerType(String chargerType) {
        this.chargerType = chargerType;
    }


    public int getAvailableSlots() {
        return availableSlots;
    }


    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

}