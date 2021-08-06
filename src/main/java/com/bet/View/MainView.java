package com.bet.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.bet.Service.Database.DBConnection;
import com.bet.Service.Database.DBCreateTables;
import com.bet.View.MenuItemViews.BetMenuViews.EndBetItemView;
import com.bet.View.MenuItemViews.BetMenuViews.ListBetItemView;
import com.bet.View.MenuItemViews.BetMenuViews.NewBetItemView;
import com.bet.View.MenuItemViews.BettorMenuViews.ListItemView;
import com.bet.View.MenuItemViews.BettorMenuViews.RegisterItemView;
import com.bet.View.MenuItemViews.DrawMenuViews.DrawItemView;
import com.bet.View.MenuItemViews.DrawMenuViews.ListDrawItemView;
import com.bet.View.MenuItemViews.HelpMenuViews.AboutItemView;
import com.bet.View.MenuItemViews.HelpMenuViews.HowToUseItemView;

public class MainView extends JFrame implements ActionListener, WindowListener{

    private JMenuItem registerItem = new JMenuItem("Register");
    private JMenuItem listItem = new JMenuItem("List Bettors");

    private JMenuItem newBetItem = new JMenuItem("New Bet");
    private JMenuItem listBetItem = new JMenuItem("List Bets");
    private JMenuItem endBetItem = new JMenuItem("End Bet");

    private JMenuItem drawItem = new JMenuItem("Draw Bet");
    private JMenuItem listDrawItem = new JMenuItem("List Draws");

    private JMenuItem howToUseItem = new JMenuItem("How can i use it?");
    private JMenuItem aboutItem = new JMenuItem("About");

    
    public MainView(){
        //Frame settings----------------------------------
        this.setSize(420, 420);
        this.setTitle("Bet App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x334756));
        setLocationRelativeTo(null); //This method make the window shows in the center of the screen
        this.addWindowListener(this);
        //Menubars settings----------------------------------    
        JMenuBar menuBar = new JMenuBar();
        JMenu bettorMenu = new JMenu("Bettors");
        JMenu betMenu = new JMenu("Bets");
        JMenu drawMenu = new JMenu("Draw");
        JMenu helpMenu = new JMenu("Help");
        
        bettorMenu.add(registerItem);
        bettorMenu.add(listItem);
        betMenu.add(newBetItem);
        betMenu.add(listBetItem);
        betMenu.add(endBetItem);
        drawMenu.add(drawItem);
        drawMenu.add(listDrawItem);
        helpMenu.add(howToUseItem);
        helpMenu.add(aboutItem);

        //Menubar action Events---------------------------------------------
        registerItem.addActionListener(this);
        listItem.addActionListener(this);
        newBetItem.addActionListener(this);
        listBetItem.addActionListener(this);
        endBetItem.addActionListener(this);
        drawItem.addActionListener(this);
        listDrawItem.addActionListener(this);
        howToUseItem.addActionListener(this);
        aboutItem.addActionListener(this);

        //Menubar adds------------------------------------------------------
        menuBar.add(bettorMenu);
        menuBar.add(betMenu);
        menuBar.add(drawMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);

        //Label settings----------------------------------------------------
        JLabel welcomeLabel = new JLabel("Welcome to Bet App!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(new Color(0x082032));
        welcomeLabel.setFont(new Font("Modern No. 20",Font.PLAIN,20));

        this.add(welcomeLabel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerItem) {
            this.dispose();
            new RegisterItemView();
        }

        if (e.getSource() == listItem) {
            this.dispose();
            new ListItemView();
        }
       
        if (e.getSource() == newBetItem) {
            this.dispose();
            new NewBetItemView();
        }
        
        if (e.getSource() == listBetItem) {
            this.dispose();
            new ListBetItemView();
        }
        if (e.getSource() == endBetItem) {
            this.dispose();
            new EndBetItemView();
        }
        if (e.getSource() == drawItem) {
            this.dispose();
            new DrawItemView();
        }
        if (e.getSource() == listDrawItem) {
            this.dispose();
            new ListDrawItemView();
        }
        if (e.getSource() == howToUseItem) {
            this.dispose();
            new HowToUseItemView();
        }
        if (e.getSource() == aboutItem) {
            this.dispose();
            new AboutItemView();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        DBConnection DBconnection = new DBConnection();
        Connection connection = DBconnection.connect();
        try {
            connection.close();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
    @Override
    public void windowActivated(WindowEvent e) {
    }
    @Override
    public void windowClosed(WindowEvent e) { 
    }
    @Override
    public void windowClosing(WindowEvent e) {  
    }
    @Override
    public void windowDeactivated(WindowEvent e) { 
    }
    @Override
    public void windowDeiconified(WindowEvent e) {  
    }
    @Override
    public void windowIconified(WindowEvent e) {
    }
}

