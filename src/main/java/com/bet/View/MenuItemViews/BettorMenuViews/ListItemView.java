package com.bet.View.MenuItemViews.BettorMenuViews;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.bet.View.MainView;

public class ListItemView extends JFrame implements WindowListener{
    
    public ListItemView(){
        this.setSize(420, 420);
        this.setTitle("Bettor List");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x334756)); 
        this.addWindowListener(this);
        setLocationRelativeTo(null);
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
