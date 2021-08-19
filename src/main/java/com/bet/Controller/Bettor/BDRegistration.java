package com.bet.Controller.Bettor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BDRegistration {
    
    public static void registration(Connection connection, String name, String cpf, String mainphonenumber, String secondaryphonenumber) {
        Statement statement;
        if (mainphonenumber.replaceAll("\\D+", "").length() <= 1) {
            mainphonenumber = null;
        }
        if (secondaryphonenumber.replaceAll("\\D+", "").length() <= 1) {
            secondaryphonenumber = null;
        }
        try {
            statement = connection.createStatement();
            String insertNewBettor = "INSERT INTO bettors(cpf,name,mainphonenumber,secondaryphonenumber) " + "VALUES ("
                    + cpf + "," + name + ", " + mainphonenumber + "," + secondaryphonenumber + ");";
            statement.executeUpdate(insertNewBettor);
            statement.close();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
