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

import com.bet.View.MenuItemViews.BetMenuViews.EditBetItemView;
import com.bet.View.MenuItemViews.BetMenuViews.EndBetItemView;
import com.bet.View.MenuItemViews.BetMenuViews.ListBetItemView;
import com.bet.View.MenuItemViews.BetMenuViews.NewBetItemView;
import com.bet.View.MenuItemViews.BettorMenuViews.DeleteItemView;
import com.bet.View.MenuItemViews.BettorMenuViews.EditItemView;
import com.bet.View.MenuItemViews.BettorMenuViews.ListItemView;
import com.bet.View.MenuItemViews.BettorMenuViews.RegisterItemView;
import com.bet.View.MenuItemViews.DrawMenuViews.DrawItemView;
import com.bet.View.MenuItemViews.DrawMenuViews.ListDrawItemView;
import com.bet.View.MenuItemViews.HelpMenuViews.AboutItemView;
import com.bet.View.MenuItemViews.HelpMenuViews.HowToUseItemView;

public class MainView extends JFrame implements ActionListener{

    private JMenuItem registerItem = new JMenuItem("Register");
    private JMenuItem editItem = new JMenuItem("Edit");
    private JMenuItem listItem = new JMenuItem("List Bettors");
    private JMenuItem deleteItem = new JMenuItem("Delete");

    private JMenuItem newBetItem = new JMenuItem("New Bet");
    private JMenuItem editBetItem = new JMenuItem("Edit Bet");
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
            new RegisterItemView();
        }
        if (e.getSource() == editItem) {
            this.dispose();
            new EditItemView();
        }
        if (e.getSource() == listItem) {
            this.dispose();
            new ListItemView();
        }
        if (e.getSource() == deleteItem) {
            this.dispose();
            new DeleteItemView();
        }
        if (e.getSource() == newBetItem) {
            this.dispose();
            new NewBetItemView();
        }
        if (e.getSource() == editBetItem) {
            this.dispose();
            new EditBetItemView();
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
}
