package com.chargehub.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            if(con == null || con.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/chargehub_db",
                        "root",
                        "root");

                System.out.println("==================================");
                System.out.println(" Database Connected Successfully ");
                System.out.println("==================================");
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}