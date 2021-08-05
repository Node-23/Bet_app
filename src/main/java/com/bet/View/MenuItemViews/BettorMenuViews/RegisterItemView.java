package com.bet.View.MenuItemViews.BettorMenuViews;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.bet.View.MainView;
import javax.swing.JLabel;

public class RegisterItemView extends JFrame implements WindowListener { 
    
    private JTextField textNameField = new JTextField();
    private JTextField textIdField = new JTextField();
    private JTextField textFirstNumberField = new JTextField();
    private JTextField textSecondNumberField = new JTextField();
    private JButton confirmButton = new JButton("Confirm");
    private JButton cancelButton = new JButton("Cancel");
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel firstPhoneLabel;
    private JLabel secondPhoneLabel;


    public RegisterItemView(){
        this.setSize(420, 420);
        this.setTitle("Bettor Register");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x334756)); 
        this.addWindowListener(this);
        setLocationRelativeTo(null);
        this.setLayout(null);

        //bottons and text fields
        textNameField.setBounds(94, 34, 232, 39);
        this.add(textNameField);

        textIdField.setBounds(94, 99, 232, 39);
        this.add(textIdField);

        textFirstNumberField.setBounds(94, 164, 232, 39);
        this.add(textFirstNumberField);

        textSecondNumberField.setBounds(94, 229, 232, 39);
        this.add(textSecondNumberField);

        confirmButton.setBounds(37, 300, 115, 43);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.green);
        this.add(confirmButton);

        cancelButton.setBounds(227, 300, 115, 43);
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.red);
        this.add(cancelButton);

        nameLabel= new JLabel("Name: ");
        idLabel= new JLabel("CPF: ");
        firstPhoneLabel= new JLabel("First phone number (optional): ");
        secondPhoneLabel= new JLabel("Second phone number (optional): "); 

        nameLabel.setBounds(47, 35, 232, 31);
        nameLabel.setForeground(Color.yellow);
        idLabel.setBounds(47, 100, 232, 31);
        idLabel.setForeground(Color.yellow);
        firstPhoneLabel.setBounds(47, 135, 232, 31);
        firstPhoneLabel.setForeground(Color.yellow);
        secondPhoneLabel.setBounds(47,200, 232, 31);
        secondPhoneLabel.setForeground(Color.yellow);

        this.add(nameLabel);
        this.add(idLabel);
        this.add(firstPhoneLabel);
        this.add(secondPhoneLabel);


        this.setVisible(true);
    }


    @Override
    public void windowClosed(WindowEvent arg0) {
        new MainView(); 
    }
    
    @Override
    public void windowActivated(WindowEvent arg0) {}
    @Override
    public void windowClosing(WindowEvent arg0) {}
    @Override
    public void windowDeactivated(WindowEvent arg0) {}
    @Override
    public void windowDeiconified(WindowEvent arg0) {}
    @Override
    public void windowIconified(WindowEvent arg0) {}
    @Override
    public void windowOpened(WindowEvent arg0) {}
}
