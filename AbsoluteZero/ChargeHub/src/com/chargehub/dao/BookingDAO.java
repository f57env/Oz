package com.chargehub.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.chargehub.config.DBConnection;
import com.chargehub.entity.Booking;



public class BookingDAO {



    // =========================================
    // CREATE BOOKING
    // =========================================


    public boolean createBooking(Booking booking) {


        boolean status = false;


        try {


            Connection con = DBConnection.getConnection();


            if(con == null) {

                System.out.println("Database Connection Failed");
                return false;

            }



            // Check duplicate slot

            String checkSql =
            "SELECT * FROM bookings WHERE station_id=? AND booking_date=? AND slot_time=?";


            PreparedStatement checkPs =
                    con.prepareStatement(checkSql);



            checkPs.setInt(1, booking.getStationId());

            checkPs.setDate(2, booking.getBookingDate());

            checkPs.setString(3, booking.getSlotTime());



            ResultSet rs = checkPs.executeQuery();



            if(rs.next()) {


                System.out.println(
                    "Slot already booked!"
                );


                return false;

            }




            // Insert booking


            String sql =
            "INSERT INTO bookings(user_id,station_id,booking_date,slot_time,status) VALUES(?,?,?,?,?)";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setInt(
                    1,
                    booking.getUserId()
            );


            ps.setInt(
                    2,
                    booking.getStationId()
            );


            ps.setDate(
                    3,
                    booking.getBookingDate()
            );


            ps.setString(
                    4,
                    booking.getSlotTime()
            );


            ps.setString(
                    5,
                    "BOOKED"
            );




            int result = ps.executeUpdate();



            if(result > 0) {

                status = true;

            }



        }
        catch(Exception e) {


            e.printStackTrace();

        }



        return status;


    }








    // =========================================
    // VIEW USER BOOKINGS
    // =========================================


    public List<Booking> getUserBookings(int userId) {



        List<Booking> list =
                new ArrayList<>();



        try {



            Connection con =
                    DBConnection.getConnection();



            String sql =
            "SELECT "
            + "b.booking_id,"
            + "b.station_id,"
            + "c.station_name,"
            + "c.location,"
            + "b.booking_date,"
            + "b.slot_time,"
            + "b.status "
            + "FROM bookings b "
            + "JOIN charging_station c "
            + "ON b.station_id=c.station_id "
            + "WHERE b.user_id=?";




            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setInt(
                    1,
                    userId
            );



            ResultSet rs =
                    ps.executeQuery();





            while(rs.next()) {



                Booking booking =
                        new Booking();



                booking.setBookingId(
                        rs.getInt("booking_id")
                );



                booking.setStationId(
                        rs.getInt("station_id")
                );



                booking.setStationName(
                        rs.getString("station_name")
                );



                booking.setLocation(
                        rs.getString("location")
                );



                booking.setBookingDate(
                        rs.getDate("booking_date")
                );



                booking.setSlotTime(
                        rs.getString("slot_time")
                );



                booking.setStatus(
                        rs.getString("status")
                );



                list.add(booking);



            }



        }
        catch(Exception e) {


            e.printStackTrace();

        }




        return list;



    }



}