package com.bet.View.MenuItemViews.DrawMenuViews;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import javax.swing.JFrame;

import com.bet.View.MainView;

public class DrawItemView extends JFrame implements WindowListener{
    
    Connection connection;
    public DrawItemView(Connection connection){
        this.connection = connection;
        this.setSize(420, 420);
        this.setTitle("Draw Bet");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x334756)); 
        this.addWindowListener(this);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
        new MainView(connection); 
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
