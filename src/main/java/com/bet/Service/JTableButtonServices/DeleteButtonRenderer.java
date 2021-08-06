package com.bet.Service.JTableButtonServices;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class DeleteButtonRenderer extends JButton implements TableCellRenderer {

    public DeleteButtonRenderer() {
      setOpaque(true);
    }
  
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      if (isSelected) {
        setForeground(new Color(0xf5f5f5));
        setBackground(new Color(0xff0000));
      } else {
        setForeground(new Color(0xf5f5f5));
        setBackground(new Color(0xff0000));
      }
      setText((value == null) ? "" : value.toString());
      return this;
    }
  }
