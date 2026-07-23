package com.chargehub.app;

import com.chargehub.config.DBConnection;
import com.chargehub.menu.MainMenu;

public class Main {

    public static void main(String[] args) {

        DBConnection.getConnection();

        MainMenu menu = new MainMenu();

        menu.start();

    }

}