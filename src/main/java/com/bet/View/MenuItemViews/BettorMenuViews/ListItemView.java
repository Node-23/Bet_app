package com.bet.View.MenuItemViews.BettorMenuViews;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.bet.Service.JTableButtonServices.DeleteButtonEditor;
import com.bet.Service.JTableButtonServices.DeleteButtonRenderer;
import com.bet.Service.JTableButtonServices.EditButtonEditor;
import com.bet.Service.JTableButtonServices.EditButtonRenderer;
import com.bet.View.MainView;

public class ListItemView extends JFrame implements WindowListener {

    Connection connection;
    public ListItemView(Connection connection) {
        this.connection = connection;
        this.setSize(840, 780);
        this.setTitle("Bettor List");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.addWindowListener(this);
        setLocationRelativeTo(null);

        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(
                new Object[][] {{"Matheus Vinicius L.", "07217858321", "(86) 9 9487-0130", "-", "Edit", "Delete"},
                        {"Ana Beatriz Costa", "07275984214", "(86) 9 9465-8954", "(86) 9 9435-7456", "Edit", "Delete"},
                        {"Matheus Vinicius Linhares Lemos de Oliveira", "07275984214", "(86) 9 9465-8954", "(86) 9 9435-7456", "Edit", "Delete"}},
                new Object[] { "Full Name", "CPF", "Main Phone", "Secondary Phone", "Edit Bettor", "Delete Bettor"});

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        JTable table = new JTable(dm) {
            public boolean isCellEditable(int row, int column) { // Edition disable in columns 1 to 4
                if (column == 0 || column == 1 || column == 2 || column == 3)
                    return false;
                return true;
            }
        };

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        table.getTableHeader().setReorderingAllowed(false); // Disable user to drag columns to reorder them

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount() - 1; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer); // Center cell content
        }

        table.getColumn("Edit Bettor").setCellRenderer(new EditButtonRenderer());
        table.getColumn("Edit Bettor").setCellEditor(new EditButtonEditor(new JCheckBox()));
        
        table.getColumn("Delete Bettor").setCellRenderer(new DeleteButtonRenderer());
        table.getColumn("Delete Bettor").setCellEditor(new DeleteButtonEditor(new JCheckBox()));

        Border empty = new EmptyBorder(0, 0, 0, 0);
        JScrollPane scroll = new JScrollPane(table);

        getContentPane().setBackground(new Color(0x334756));
        panel.setBackground(new Color(0x334756));
        scroll.setBackground(new Color(0x334756));

        panel.setBounds(20, 40, 800, 600);

        scroll.getViewport().setBackground(new Color(0x334756));
        scroll.setBorder(empty); // You can only remove the border of a JScrollPane,when it contains a JTable
                                 // giving it a empty border

        panel.add(scroll);
        this.add(panel);

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
}
