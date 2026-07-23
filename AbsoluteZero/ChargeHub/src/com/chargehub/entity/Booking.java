package com.chargehub.entity;

import java.sql.Date;


public class Booking {


    private int bookingId;
    private int userId;
    private int stationId;

    private Date bookingDate;

    private String slotTime;

    private String status;


    private String stationName;
    private String location;



    public Booking(){}



    public Booking(int userId,int stationId,Date bookingDate,String slotTime){

        this.userId=userId;
        this.stationId=stationId;
        this.bookingDate=bookingDate;
        this.slotTime=slotTime;
        this.status="BOOKED";

    }



    public int getBookingId(){
        return bookingId;
    }


    public void setBookingId(int bookingId){
        this.bookingId=bookingId;
    }



    public int getUserId(){
        return userId;
    }


    public void setUserId(int userId){
        this.userId=userId;
    }




    public int getStationId(){
        return stationId;
    }


    public void setStationId(int stationId){
        this.stationId=stationId;
    }




    public Date getBookingDate(){
        return bookingDate;
    }


    public void setBookingDate(Date bookingDate){
        this.bookingDate=bookingDate;
    }




    public String getSlotTime(){
        return slotTime;
    }


    public void setSlotTime(String slotTime){
        this.slotTime=slotTime;
    }





    public String getStatus(){
        return status;
    }


    public void setStatus(String status){
        this.status=status;
    }




    public String getStationName(){
        return stationName;
    }


    public void setStationName(String stationName){
        this.stationName=stationName;
    }




    public String getLocation(){
        return location;
    }


    public void setLocation(String location){
        this.location=location;
    }

}