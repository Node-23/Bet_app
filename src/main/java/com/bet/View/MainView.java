package com.bet.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainView extends JFrame implements ActionListener{

    JMenuItem registerItem = new JMenuItem("Register");
    JMenuItem editItem = new JMenuItem("Edit");
    JMenuItem listItem = new JMenuItem("List Bettors");
    JMenuItem deleteItem = new JMenuItem("Delete");

    JMenuItem newBetItem = new JMenuItem("New Bet");
    JMenuItem editBetItem = new JMenuItem("Edit Bet");
    JMenuItem listBetItem = new JMenuItem("List Bets");
    JMenuItem endBetItem = new JMenuItem("End Bet");

    JMenuItem drawItem = new JMenuItem("Draw Bet");
    JMenuItem listDrawItem = new JMenuItem("List Draws");

    JMenuItem howToUseItem = new JMenuItem("How can i use it?");
    JMenuItem aboutItem = new JMenuItem("About");
    
    public MainView(){
        //Frame settings----------------------------------
        this.setSize(420, 420);
        this.setTitle("Bet App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x334756));

        //Menubars settings----------------------------------    
        JMenuBar menuBar = new JMenuBar();
        JMenu bettorMenu = new JMenu("Bettors");
        JMenu betMenu = new JMenu("Bets");
        JMenu drawMenu = new JMenu("Draw");
        JMenu helpMenu = new JMenu("Help");
        
        bettorMenu.add(registerItem);
        bettorMenu.add(editItem);
        bettorMenu.add(listItem);
        bettorMenu.add(deleteItem);
        betMenu.add(newBetItem);
        betMenu.add(editBetItem);
        betMenu.add(listBetItem);
        betMenu.add(endBetItem);
        drawMenu.add(drawItem);
        drawMenu.add(listDrawItem);
        helpMenu.add(howToUseItem);
        helpMenu.add(aboutItem);

        //Menubar action Events---------------------------------------------
        registerItem.addActionListener(this);
        editItem.addActionListener(this);
        listItem.addActionListener(this);
        deleteItem.addActionListener(this);
        newBetItem.addActionListener(this);
        editBetItem.addActionListener(this);
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
            new RegisterView();
        }
        if (e.getSource() == editItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == listItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == deleteItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == newBetItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == editBetItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == listBetItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == endBetItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == drawItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == listDrawItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == howToUseItem) {
            // TODO Auto-generated method stub
        }
        if (e.getSource() == aboutItem) {
            // TODO Auto-generated method stub
        }
        
    }
}
