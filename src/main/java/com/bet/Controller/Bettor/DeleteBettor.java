package com.bet.Controller.Bettor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DeleteBettor {
    public static void deleteBettorAction(Connection connection, String name, String CPF, String mainPhoneNumber,
            String secondaryPhoneNumber) {
        String confirmMessage = "Name: " + name + "\n" + "CPF: " + CPF + "\n" + "Main phone number: " + mainPhoneNumber
                + "\n" + "Secondary phone number: " + secondaryPhoneNumber + "\n"
                + "Are you sure you want to delete this bettor?";
        int confirmInput = JOptionPane.showConfirmDialog(null, confirmMessage, "Bettor Delete",
                JOptionPane.YES_NO_OPTION);
        if (confirmInput == 0) {
            deleteFromDB(connection, CPF);
            JOptionPane.showMessageDialog(null, "Bettor deleted sucessfully", "Bettor Delete",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
    private static void deleteFromDB(Connection connection, String CPF){
        //CPF = "'"+ CPF + "'";
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM bettors WHERE cpf = ?");
            statement.setString(1,CPF);
            statement.executeUpdate(); 
            statement.close();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
