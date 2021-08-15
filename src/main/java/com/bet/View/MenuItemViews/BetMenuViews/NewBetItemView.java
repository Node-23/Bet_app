package com.bet.View.MenuItemViews.BetMenuViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.bet.View.MainView;

public class NewBetItemView extends JFrame implements WindowListener, FocusListener, ActionListener, ChangeListener{
    Connection connection;
    private JButton confirmButton = new JButton("Confirm");
    private JButton cancelButton = new JButton("Cancel");
    private JRadioButton manyCardsButton = new JRadioButton("Many Cards");
    private JRadioButton uniqueCardButton = new JRadioButton("Unique Card");
    private ButtonGroup group = new ButtonGroup();
    private JSlider quantNumbersSlider;
    private JSlider quantCardsSlider;
    private JLabel typeBetsLabel;
    private JLabel quantNumbersLabel;
    private JLabel quantCardsLabel;
    

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
        manyCardsButton.setBounds(37, 34, 100, 39);
        manyCardsButton.setBackground(new Color(0x334756));
        manyCardsButton.setForeground(Color.white);
        manyCardsButton.addActionListener(this);
        uniqueCardButton.setBounds(227, 34, 100, 39);
        uniqueCardButton.setBackground(new Color(0x334756));
        uniqueCardButton.setForeground(Color.white);
        uniqueCardButton.addActionListener(this);
        group.add(manyCardsButton);
        group.add(uniqueCardButton);
        this.add(manyCardsButton);
        this.add(uniqueCardButton);
//------------------------------------------------------------//

//--------------------------Sliders----------------------------//

        quantNumbersSlider = new JSlider(0,15,0);
        quantNumbersSlider.setBounds(37, 99, 300, 39);
        quantNumbersSlider.setBackground(new Color(0x334756));
        quantNumbersSlider.setForeground(Color.white);
        quantNumbersSlider.setPaintTicks(true);
        quantNumbersSlider.setPaintLabels(true);
        quantNumbersSlider.setMajorTickSpacing(1);
        quantNumbersSlider.setVisible(false);
        this.add(quantNumbersSlider);

        quantCardsSlider = new JSlider(2,30,2);
        quantCardsSlider.setBounds(37, 99, 300, 39);
        quantCardsSlider.setBackground(new Color(0x334756));
        quantCardsSlider.setForeground(Color.white);
        quantCardsSlider.setPaintTicks(true);
        quantCardsSlider.setPaintLabels(true);
        quantCardsSlider.setMinorTickSpacing(1);
        quantCardsSlider.setMajorTickSpacing(2);
        quantCardsSlider.setVisible(false);
        this.add(quantCardsSlider);
//-------------------------------------------------------------//

//-------------------Button-----------------------------------//
        confirmButton.setBounds(37, 300, 115, 43);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.green);
        confirmButton.addFocusListener(this);
        confirmButton.addActionListener(this);
        this.add(confirmButton);

        cancelButton.setBounds(227, 300, 115, 43);
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.red);
        cancelButton.addFocusListener(this);
        cancelButton.addActionListener(this);
        this.add(cancelButton);
//------------------------------------------------------------//


//-------------------------Labels-----------------------------//

        typeBetsLabel = new JLabel("Choose the bet type: ");
        typeBetsLabel.setBounds(37, 5, 232, 43);
        typeBetsLabel.setForeground(Color.black);
        this.add(typeBetsLabel);
        quantNumbersLabel.setBounds(37, 200, 300, 39);
        quantNumbersLabel.setForeground(Color.GREEN);
        this.add(quantNumbersLabel);
//-----------------------------------------------------------//

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == uniqueCardButton) {
            quantNumbersSlider.setVisible(true);
            quantCardsSlider.setVisible(false);
        }
        
        if (e.getSource() == manyCardsButton) {
            quantCardsSlider.setVisible(true);
            quantNumbersSlider.setVisible(false);
        }

        if (e.getSource() == confirmButton) {
            this.dispose();
        }

        if (e.getSource() == cancelButton) {
            this.dispose();
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
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }

    @Override
    public void stateChanged(ChangeEvent e){
        quantNumbersLabel.setText("Quatity of numbers: ");
    }
}
