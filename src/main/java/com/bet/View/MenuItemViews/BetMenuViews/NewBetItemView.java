package com.bet.View.MenuItemViews.BetMenuViews;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import com.bet.View.MainView;

public class NewBetItemView extends JFrame implements WindowListener{
    Connection connection;
    private JButton confirmButton = new JButton("Confirm");
    private JButton cancelButton = new JButton("Cancel");
    private JRadioButton manyCardsButton = new JRadioButton("Many Cards");
    private JRadioButton uniqueCardButton = new JRadioButton("Unique Card");
    private ButtonGroup group = new ButtonGroup();

    public NewBetItemView(Connection connection){
        this.connection=connection;
        this.setSize(420, 420);
        this.setTitle("New Bet");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x334756)); 
        this.addWindowListener(this);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);

//-------------------Radio Button------------------------------//
        //manyCardsButton.setBounds(x, y, width, height);
        //uniqueCardButton.setBounds(x, y, width, height);
        //group.add(manyCardsButton);
        //group.add(uniqueCardButton);
        //this.add(manyCardsButton);
        //this.add(uniqueCardButton);
//------------------------------------------------------------//

//-------------------Button-----------------------------------//
        confirmButton.setBounds(37, 300, 115, 43);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.green);
        this.add(confirmButton);

        cancelButton.setBounds(227, 300, 115, 43);
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.red);
        this.add(cancelButton);
//------------------------------------------------------------//


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
