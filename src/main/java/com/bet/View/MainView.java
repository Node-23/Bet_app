package com.bet.View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainView extends JFrame{
    
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

        JMenuItem registerItem = new JMenuItem("Register");
        JMenuItem editItem = new JMenuItem("Edit");
        JMenuItem listItem = new JMenuItem("List Bettors");
        JMenuItem deleteItem = new JMenuItem("Delete");
        bettorMenu.add(registerItem);
        bettorMenu.add(editItem);
        bettorMenu.add(listItem);
        bettorMenu.add(deleteItem);

        JMenuItem newBetItem = new JMenuItem("New Bet");
        JMenuItem editBetItem = new JMenuItem("Edit Bet");
        JMenuItem listBetItem = new JMenuItem("List Bets");
        JMenuItem endBetItem = new JMenuItem("End Bet");
        betMenu.add(newBetItem);
        betMenu.add(editBetItem);
        betMenu.add(listBetItem);
        betMenu.add(endBetItem);

        JMenuItem drawItem = new JMenuItem("Draw Bet");
        JMenuItem listDrawItem = new JMenuItem("List Draws");
        drawMenu.add(drawItem);
        drawMenu.add(listDrawItem);

        JMenuItem howToUseItem = new JMenuItem("How can i use it?");
        helpMenu.add(howToUseItem);

        menuBar.add(bettorMenu);
        menuBar.add(betMenu);
        menuBar.add(drawMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);

        //Label settings---------------------------------- 
        JLabel welcomeLabel = new JLabel("Welcome to Bet App!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(new Color(0x082032));

        this.add(welcomeLabel);
        this.setVisible(true);
    }
}
