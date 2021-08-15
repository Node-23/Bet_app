package com.bet.Service.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {
    private final String url = "jdbc:postgresql://localhost/Bet_App";
    private final String user = "postgres";
    private final String password = "88239474";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "The connection with the database got wrong!", "Connection with DB",
                        JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
}
