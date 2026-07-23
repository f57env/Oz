package com.chargehub.service;


import java.util.ArrayList;

import com.chargehub.dao.StationDAO;
import com.chargehub.entity.Station;



public class StationService {



    StationDAO dao=new StationDAO();



    public void viewStations(){


        ArrayList<Station> stations=dao.getAllStations();



        System.out.println("\n====== AVAILABLE CHARGING STATIONS ======");



        for(Station s:stations){


            System.out.println("--------------------------------");

            System.out.println("ID       : "+s.getStationId());

            System.out.println("Name     : "+s.getStationName());

            System.out.println("Location : "+s.getLocation());

            System.out.println("Type     : "+s.getChargerType());

            System.out.println("Slots    : "+s.getAvailableSlots());

            System.out.println("Price    : ₹"+s.getPrice());


        }


    }


}