package com.bet.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CPFValidation {
    public static boolean isValid(String cpf) {
        int sum = 0;
        int remnant;
        cpf = cpf.replaceAll("\\D+", "");
        if (hasEqualNumbers(cpf) == true) {
            return false;
        }

        int[] numbers = new int[cpf.length()]; 
        for (int i = 0; i < cpf.length(); i++) {
            numbers[i] = Character.getNumericValue(cpf.charAt(i));
        }

        for (int i = 0; i < 9; i++) {
            sum += numbers[i] * (10 - i);
        }

        sum *= 10;
        remnant = sum % 11;
        if (remnant == 10) {
            remnant = 0;
        }

        if (remnant != numbers[9]) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += numbers[i] * (11 - i);
        }

        sum *= 10;
        remnant = sum % 11;
        if (remnant == 10) {
            remnant = 0;
        }

        if (remnant != numbers[10]) {
            return false;
        }
        return true;
    }

    public static boolean isRegistered(Connection connection, String cpf) {
        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM bettors WHERE cpf=" + cpf);
            cpf = cpf.replaceAll("'", "");
            while ( rs.next() ) {
                if(rs.getString("cpf").equals(cpf)){
                    return true;
                }
             }
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CPF Validation got wrong!", "CPF registration", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;
    }

    private static boolean hasEqualNumbers(String cpf) {
        char[] numbers = cpf.toCharArray();
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
