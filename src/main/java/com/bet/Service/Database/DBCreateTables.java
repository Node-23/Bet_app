package com.bet.Service.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreateTables {
    public static void createTables(Connection connection){
        try {
            Statement statement = connection.createStatement();
            String createBettorTable = "CREATE TABLE IF NOT EXISTS Bettors " +
            "(CPF varchar(14) PRIMARY KEY     NOT NULL," +
            " NAME           varchar(60)    NOT NULL, " +
            " mainPhoneNumber            varchar(15), " +
            " secondaryPhoneNumber        varchar(15))";
            statement.executeUpdate(createBettorTable);
            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
