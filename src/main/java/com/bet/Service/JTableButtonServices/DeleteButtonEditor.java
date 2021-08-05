package com.bet.Service.JTableButtonServices;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;

public class DeleteButtonEditor extends DefaultCellEditor implements ActionListener {
    protected JButton button;
  
    private String label;
  
    private boolean isPushed;
  
    public DeleteButtonEditor(JCheckBox checkBox) {
      super(checkBox);
      button = new JButton();
      button.setFocusable(false);
      button.setOpaque(true);
      button.addActionListener(this);
    }
  
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
           
      if (isSelected) {
        button.setForeground(new Color(0xf5f5f5));
        button.setBackground(new Color(0xcc0000));
      } else{
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
        //JOptionPane.showMessageDialog(button, label + ": Ouch!");
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
