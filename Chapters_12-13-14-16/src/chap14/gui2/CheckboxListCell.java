/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public abstract class CheckboxListCell implements ListCellRenderer {

  private JLabel label;
  private JCheckBox checkBox;
  private JPanel panel;

  public CheckboxListCell() {
    panel = new JPanel(new BorderLayout());
    label = new JLabel();
    checkBox = new JCheckBox();
    checkBox.setOpaque(false);
    panel.add("Center", label);
    panel.add("West", checkBox);
  }

  public Component getListCellRendererComponent(
    JList list,
    Object value,
    int index,
    boolean isSelected,
    boolean cellHasFocus) {

    panel.setBackground(isSelected ? Color.yellow : list.getBackground());
    label.setText(String.valueOf(value));
    checkBox.setSelected(getCheckedValue(value));
    return panel;
  }
  protected abstract boolean getCheckedValue(Object value);
}