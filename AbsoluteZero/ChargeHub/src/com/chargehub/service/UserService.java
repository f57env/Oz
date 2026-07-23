package com.chargehub.service;


import java.util.List;
import java.util.Scanner;

import com.chargehub.dao.UserDAO;
import com.chargehub.entity.Booking;
import com.chargehub.entity.User;



public class UserService {


    Scanner sc = new Scanner(System.in);


    UserDAO dao = new UserDAO();

    StationService stationService = new StationService();

    BookingService bookingService = new BookingService();




    // =====================================
    // USER REGISTRATION
    // =====================================

    public void registerUser() {


        System.out.println("\n===== USER REGISTRATION =====");


        System.out.print("Enter Full Name : ");
        String name = sc.nextLine();


        System.out.print("Enter Email : ");
        String email = sc.nextLine();


        System.out.print("Enter Mobile : ");
        String mobile = sc.nextLine();


        System.out.print("Enter Password : ");
        String password = sc.nextLine();



        User user = new User(
                name,
                email,
                mobile,
                password,
                "USER"
        );



        boolean status = dao.registerUser(user);



        if(status) {

            System.out.println("\nRegistration Successful.");

        }
        else {

            System.out.println("\nRegistration Failed.");

        }


    }





    // =====================================
    // LOGIN
    // =====================================

    public void login() {


        System.out.println("\n========== LOGIN ==========");


        System.out.println("1. Login using Email");
        System.out.println("2. Login using Mobile");
        System.out.println("3. Back");


        System.out.print("Choice : ");


        int choice = sc.nextInt();
        sc.nextLine();




        switch(choice) {



        case 1:


            System.out.print("Email : ");
            String email = sc.nextLine();



            System.out.print("Password : ");
            String password = sc.nextLine();




            User user = dao.loginByEmail(
                    email,
                    password
            );




            if(user != null) {


                System.out.println("\nLogin Successful");

                System.out.println(
                        "Welcome "
                        + user.getFullName()
                );



                dashboard(user);


            }
            else {


                System.out.println(
                        "Invalid Email or Password"
                );


            }


            break;





        case 2:


            System.out.println(
                    "Mobile Login Coming Soon"
            );


            break;





        case 3:


            return;





        default:


            System.out.println(
                    "Invalid Choice"
            );


        }


    }






    // =====================================
    // USER DASHBOARD
    // =====================================


    public void dashboard(User user) {



        while(true) {



            System.out.println(
                    "\n=============================="
            );


            System.out.println(
                    "WELCOME "
                    + user.getFullName()
            );


            System.out.println(
                    "=============================="
            );



            System.out.println("1. View Profile");

            System.out.println("2. View Charging Stations");

            System.out.println("3. Book Charging Slot");

            System.out.println("4. My Bookings");

            System.out.println("5. Logout");



            System.out.print("Choice : ");



            int choice = sc.nextInt();

            sc.nextLine();





            switch(choice) {



            case 1:


                viewProfile(user);

                break;





            case 2:


                stationService.viewStations();

                break;





            case 3:


                bookingService.bookSlot(user);

                break;





            case 4:


                viewBookings(user);

                break;





            case 5:


                System.out.println(
                        "\nLogged Out Successfully."
                );


                return;





            default:


                System.out.println(
                        "Invalid Choice"
                );


            }


        }


    }







    // =====================================
    // VIEW PROFILE
    // =====================================


    private void viewProfile(User user) {



        System.out.println(
                "\n------ PROFILE ------"
        );



        System.out.println(
                "ID      : "
                + user.getUserId()
        );


        System.out.println(
                "Name    : "
                + user.getFullName()
        );


        System.out.println(
                "Email   : "
                + user.getEmail()
        );


        System.out.println(
                "Mobile  : "
                + user.getMobile()
        );


        System.out.println(
                "Role    : "
                + user.getRole()
        );


    }






    // =====================================
    // VIEW BOOKINGS
    // =====================================


    private void viewBookings(User user) {


        System.out.println(
                "\n====== MY BOOKINGS ======"
        );



        List<Booking> bookings =
                bookingService.getUserBookings(
                        user.getUserId()
                );




        if(bookings == null || bookings.isEmpty()) {


            System.out.println(
                    "No bookings found."
            );


            return;

        }






        for(Booking b : bookings) {



            System.out.println(
                    "----------------------------"
            );



            System.out.println(
                    "Booking ID : "
                    + b.getBookingId()
            );



            System.out.println(
                    "Station : "
                    + b.getStationName()
            );



            System.out.println(
                    "Location : "
                    + b.getLocation()
            );



            System.out.println(
                    "Date : "
                    + b.getBookingDate()
            );



            System.out.println(
                    "Time : "
                    + b.getSlotTime()
            );



            System.out.println(
                    "Status : "
                    + b.getStatus()
            );


        }


    }



}