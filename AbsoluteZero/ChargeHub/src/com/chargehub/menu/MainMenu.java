package com.chargehub.menu;

import java.util.Scanner;

import com.chargehub.service.UserService;

public class MainMenu {

    Scanner sc = new Scanner(System.in);

    UserService service = new UserService();

    public void start() {

        while(true) {

            System.out.println("\n=============================");
            System.out.println("        CHARGE HUB");
            System.out.println("=============================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

            case 1:
                service.registerUser();
                break;

            case 2:
                service.login();
                break;

            case 3:
                System.out.println("Thank You!");
                System.exit(0);

            default:
                System.out.println("Invalid Choice");

            }

        }

    }

}