package com.bet.Service.JTableButtonServices;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;

import com.bet.Controller.Bettor.DeleteBettor;
import com.bet.View.MenuItemViews.BettorMenuViews.ListItemView;

public class DeleteButtonEditor extends DefaultCellEditor implements ActionListener {
  protected JButton button;
  private String label;
  private boolean isPushed;
  private Connection connection;
  private JTable table;
  private int row;
  private JFrame frame;
  public DeleteButtonEditor(JCheckBox checkBox, Connection connection, JFrame frame) {
    super(checkBox);
    this.connection = connection;
    this.frame = frame;
    button = new JButton();
    button.setFocusable(false);
    button.setOpaque(true);
    button.addActionListener(this);
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    this.table = table;
    this.row = row;
    if (isSelected) {
      button.setForeground(new Color(0xf5f5f5));
      button.setBackground(new Color(0xcc0000));
    } else {
      button.setForeground(new Color(0xf5f5f5));
      button.setBackground(new Color(0xff0000));
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    UIManager.put("Button.select", new Color(0xcc0000));
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      String name = table.getModel().getValueAt(row, 0).toString();
      String CPF = table.getModel().getValueAt(row, 1).toString();
      String mainPhoneNumber = table.getModel().getValueAt(row, 2).toString();
      String secondaryPhoneNumber = table.getModel().getValueAt(row, 2).toString();
      DeleteBettor.deleteBettorAction(connection, name, CPF, mainPhoneNumber, secondaryPhoneNumber);
      ((ListItemView) frame).setExit();
      frame.dispose();
      new ListItemView(connection);
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    fireEditingStopped();
  }
}
