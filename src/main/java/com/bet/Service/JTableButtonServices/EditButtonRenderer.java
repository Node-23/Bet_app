package com.bet.Service.JTableButtonServices;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class EditButtonRenderer extends JButton implements TableCellRenderer {

    public EditButtonRenderer() {
      setOpaque(true);
    }
  
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      if (isSelected) {
        setForeground(new Color(0xf8f8ff));
        setBackground(new Color(0xe5e619));
      } else {
        setForeground(new Color(0xf8f8ff));
        setBackground(new Color(0xfe5e619));
      }
      setText((value == null) ? "" : value.toString());
      return this;
    }
  }
