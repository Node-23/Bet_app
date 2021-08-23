package com.bet.Controller.Bettor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BettorList {
    final static int tableColumnQuantity = 6;

    public static Object[][] getBettors(Connection connection) {
        Object[][] bettorsList = null;
        int tableLenght = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM bettors");
            r.next();
            tableLenght = r.getInt("rowcount");
            r.close();
            ResultSet rs = statement.executeQuery("SELECT * FROM bettors");
            bettorsList = new Object[tableLenght][tableColumnQuantity];
            int rowCounter = 0;
            while (rs.next()) {
                bettorsList[rowCounter][0] = rs.getString("name");
                bettorsList[rowCounter][1] = rs.getString("cpf");
                bettorsList[rowCounter][2] = rs.getString("mainphonenumber");
                bettorsList[rowCounter][3] = rs.getString("secondaryphonenumber");
                bettorsList[rowCounter][4] = "Edit";
                bettorsList[rowCounter][5] = "Delete";
                rowCounter++;
            }
            statement.close();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Data base error while listing bettors!", "Bettors list",JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
        return bettorsList;
    }
}
