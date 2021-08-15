package com.bet;

import java.sql.Connection;
import java.util.Locale;

import com.bet.Service.Database.DBConnection;
import com.bet.View.MainView;

public class App {
    public static void main(String[] args) {
        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);
    
        DBConnection DBconnection = new DBConnection();
        Connection connection = DBconnection.connect();
        
        new MainView(connection);
    }
}
