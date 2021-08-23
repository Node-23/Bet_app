package com.bet.Service.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost/bet_app";
    private static final String user = "postgres";
    private static final String password = "88239474";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (PSQLException e) {
            if (e.getSQLState().equals("3D000")) {
                DBCreation.createDB();
                return connect();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "The connection with the database got wrong!", "Connection with DB",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return connection;
    }
}
