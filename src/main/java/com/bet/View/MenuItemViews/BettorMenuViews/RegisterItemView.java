package com.bet.View.MenuItemViews.BettorMenuViews;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import com.bet.Service.CPFValidation;

import com.bet.View.MainView;

public class RegisterItemView extends JFrame implements WindowListener, ActionListener, FocusListener {
    
    Connection connection;
    private String nameMaskQuantity = "************************************************************";
    private JFormattedTextField textNameField = new JFormattedTextField();
    private JFormattedTextField textCPFField = new JFormattedTextField();
    private JFormattedTextField textFirstNumberField = new JFormattedTextField();
    private JFormattedTextField textSecondNumberField = new JFormattedTextField();
    private JButton confirmButton = new JButton("Confirm");
    private JButton cancelButton = new JButton("Cancel");
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel firstPhoneLabel;
    private JLabel secondPhoneLabel;

    public RegisterItemView(Connection connection) {
        this.connection = connection;
        this.setSize(420, 420);
        this.setTitle("Bettor Register");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x334756));
        this.addWindowListener(this);
        setLocationRelativeTo(null);
        this.setLayout(null);

        // bottons and text fields
        textNameField.setBounds(94, 34, 232, 39);
        textNameField.setToolTipText("Insert your name");
        this.add(textNameField);
        textNameField.setHorizontalAlignment(JTextField.CENTER);

        textCPFField.setBounds(94, 99, 232, 39);
        textCPFField.setHorizontalAlignment(JTextField.CENTER);
        textCPFField.setToolTipText("Insert only the numbers");
        this.add(textCPFField);

        textFirstNumberField.setBounds(94, 164, 232, 39);
        textFirstNumberField.setHorizontalAlignment(JTextField.CENTER);
        textFirstNumberField.setToolTipText("Insert only the numbers");
        this.add(textFirstNumberField);

        textSecondNumberField.setBounds(94, 229, 232, 39);
        textSecondNumberField.setHorizontalAlignment(JTextField.CENTER);
        textSecondNumberField.setToolTipText("Insert only the numbers");
        this.add(textSecondNumberField);

        confirmButton.setBounds(37, 300, 115, 43);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.green);
        this.add(confirmButton);

        cancelButton.setBounds(227, 300, 115, 43);
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.red);
        this.add(cancelButton);

        nameLabel = new JLabel("Name: ");
        idLabel = new JLabel("CPF: ");
        firstPhoneLabel = new JLabel("First phone number (optional): ");
        secondPhoneLabel = new JLabel("Second phone number (optional): ");

        nameLabel.setBounds(47, 35, 232, 31);
        nameLabel.setForeground(Color.yellow);
        idLabel.setBounds(47, 100, 232, 31);
        idLabel.setForeground(Color.yellow);
        firstPhoneLabel.setBounds(47, 135, 232, 31);
        firstPhoneLabel.setForeground(Color.yellow);
        secondPhoneLabel.setBounds(47, 200, 232, 31);
        secondPhoneLabel.setForeground(Color.yellow);

        this.add(nameLabel);
        this.add(idLabel);
        this.add(firstPhoneLabel);
        this.add(secondPhoneLabel);

        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        confirmButton.addFocusListener(this);
        cancelButton.addFocusListener(this);
        textNameField.addFocusListener(this);
        textCPFField.addFocusListener(this);
        textFirstNumberField.addFocusListener(this);
        textSecondNumberField.addFocusListener(this);

        try {
            MaskFormatter nameMask = new MaskFormatter(nameMaskQuantity);
            MaskFormatter CPFMask;
            MaskFormatter firstPhoneMask;
            MaskFormatter secondPhoneMask;
            nameMask.setValidCharacters("qwertyuiopasdfghjklzxcvbnm" + "QWERTYUIOPASDFGHJKLZXCVBNM ");
            CPFMask = new MaskFormatter("###.###.###-##");
            firstPhoneMask = new MaskFormatter("(##)9 ####-####");
            secondPhoneMask = new MaskFormatter("(##)9 ####-####");
            nameMask.install(textNameField);
            CPFMask.install(textCPFField);
            firstPhoneMask.install(textFirstNumberField);
            secondPhoneMask.install(textSecondNumberField);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
        new MainView(connection);
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            String name = textNameField.getText().replaceAll("\\s{2,}", " ").trim();
            name = "'" + name + "'";
            String cpf = "'" + textCPFField.getText() + "'";
            String mainphonenumber = "'" + textFirstNumberField.getText() + "'";
            String secondaryphonenumber = "'" + textSecondNumberField.getText() + "'";
            if (textNameField.getText().isBlank() || cpf.replaceAll("\\D+", "").length() != 11) {
                JOptionPane.showMessageDialog(null, "All fields must be filled", "Bettor Register",
                        JOptionPane.ERROR_MESSAGE);
            } else if (mainphonenumber.replaceAll("\\D+", "").length() < 11
                    && mainphonenumber.replaceAll("\\D+", "").length() > 1) {
                JOptionPane.showMessageDialog(null, "The main phone field must be completed or blank",
                        "Bettor Register", JOptionPane.ERROR_MESSAGE);
            } else if (secondaryphonenumber.replaceAll("\\D+", "").length() < 11
                    && secondaryphonenumber.replaceAll("\\D+", "").length() > 1) {
                JOptionPane.showMessageDialog(null, "The secondary phone field must be completed or blank",
                        "Bettor Register", JOptionPane.ERROR_MESSAGE);
            } else if (CPFValidation.isValid(cpf) == false) {
                JOptionPane.showMessageDialog(null, "This CPF is not valid!", "Bettor Register",
                        JOptionPane.ERROR_MESSAGE);
            } else if (CPFValidation.isRegistered(connection, cpf) == true) {
                JOptionPane.showMessageDialog(null, "This cpf is already registered!", "Bettor Register",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String confirmMainPhoneNumber = mainphonenumber;
                String confirmSecondaryPhoneNumber = secondaryphonenumber;
                if (mainphonenumber.replaceAll("\\D+", "").length() <= 1) {
                    confirmMainPhoneNumber = "X";
                }
                if (secondaryphonenumber.replaceAll("\\D+", "").length() <= 1) {
                    confirmSecondaryPhoneNumber = "X";
                }
                String confirmMessage = "Name: " + textNameField.getText() + "\n" + "CPF: " + textCPFField.getText()
                        + "\n" + "Main phone number: " + confirmMainPhoneNumber + "\n"
                        + "Secondary phone number: " + confirmSecondaryPhoneNumber + "\n"
                        + "Are you sure about the bettor's info?";

                int confirmInput = JOptionPane.showConfirmDialog(null, confirmMessage, "Bettor Register",
                        JOptionPane.YES_NO_OPTION);
                if (confirmInput == 0) {
                    bdRegistration(name, cpf, mainphonenumber, secondaryphonenumber);
                    JOptionPane.showMessageDialog(null, "Bettor registered sucessfully", "Bettor Register",
                            JOptionPane.PLAIN_MESSAGE);
                    name = "";
                    cpf = "";
                    mainphonenumber = "";
                    secondaryphonenumber = "";
                    textNameField.setText("");
                    textCPFField.setText("");
                    textFirstNumberField.setText("");
                    textSecondNumberField.setText("");
                }
            }
        }
        if (e.getSource() == cancelButton) {
            this.dispose();
        }

    }

    private void bdRegistration(String name, String cpf, String mainphonenumber, String secondaryphonenumber) {
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

    @Override
    public void focusGained(FocusEvent f) {
        if (f.getSource() == confirmButton) {
            UIManager.put("Button.select", new Color(0x2d572c));
        }

        if (f.getSource() == cancelButton) {
            UIManager.put("Button.select", new Color(0xcc0000));
        }

        if (f.getSource() == textNameField) {
            textNameField.setBorder(null);
        }

        if (f.getSource() == textCPFField) {
            textCPFField.setBorder(null);
        }

        if (f.getSource() == textFirstNumberField) {
            textFirstNumberField.setBorder(null);
        }

        if (f.getSource() == textSecondNumberField) {
            textSecondNumberField.setBorder(null);
        }
    }

    @Override
    public void focusLost(FocusEvent f) {
        UIManager.put("Button.select", new Color(0xffffff));

        if (f.getSource() == textNameField) {
            if (textNameField.getText().isBlank()) {
                textNameField.setBorder(new LineBorder(Color.red, 2));
            }
        }

        if (f.getSource() == textCPFField) {
            if (textCPFField.getText().replaceAll("\\D+", "").length() != 11) {
                textCPFField.setBorder(new LineBorder(Color.red, 2));
            }
        }

        if (f.getSource() == textFirstNumberField) {
            if (textFirstNumberField.getText().replaceAll("\\D+", "").length() < 11
                    && textFirstNumberField.getText().replaceAll("\\D+", "").length() > 1) {
                textFirstNumberField.setBorder(new LineBorder(Color.red, 2));
            }
        }

        if (f.getSource() == textSecondNumberField) {
            if (textSecondNumberField.getText().replaceAll("\\D+", "").length() < 11
                    && textSecondNumberField.getText().replaceAll("\\D+", "").length() > 1) {
                textSecondNumberField.setBorder(new LineBorder(Color.red, 2));
            }
        }
    }
}
