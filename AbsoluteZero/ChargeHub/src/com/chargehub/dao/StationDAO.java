package com.chargehub.dao;


import java.sql.*;
import java.util.ArrayList;

import com.chargehub.config.DBConnection;
import com.chargehub.entity.Station;



public class StationDAO {


    public ArrayList<Station> getAllStations(){


        ArrayList<Station> list=new ArrayList<>();


        try {


            Connection con=DBConnection.getConnection();


            String query="SELECT * FROM charging_station";


            PreparedStatement ps=con.prepareStatement(query);


            ResultSet rs=ps.executeQuery();



            while(rs.next()){


                Station s=new Station();


                s.setStationId(rs.getInt("station_id"));

                s.setStationName(rs.getString("station_name"));

                s.setLocation(rs.getString("location"));

                s.setChargerType(rs.getString("charger_type"));

                s.setAvailableSlots(rs.getInt("available_slots"));

                s.setPrice(rs.getDouble("price_per_unit"));



                list.add(s);

            }



        }

        catch(Exception e){

            e.printStackTrace();

        }


        return list;

    }


}