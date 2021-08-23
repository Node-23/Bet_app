package com.bet.Service.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBCreation {
    private static final String url = "jdbc:postgresql://localhost/";
    private static final String user = "postgres";
    private static final String password = "88239474";

    public static void createDB() {
        String query = "CREATE DATABASE bet_app";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "The Database creation got wrong!", "Creating Data base",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
