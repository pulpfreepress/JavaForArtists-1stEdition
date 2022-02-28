/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.gui3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

import chap14.gui0.Garment;

public abstract class CheckboxListCell
  implements ListCellRenderer, MouseListener {

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

  public void mouseClicked(MouseEvent e) {
    JList list = (JList)e.getSource();
    Point p = e.getPoint();
    int index = list.locationToIndex(p);
    Rectangle rect = list.getCellBounds(index, index);
    panel.setBounds(rect);
    if (!rect.contains(p)) {
      if (!e.isShiftDown() && !e.isControlDown()) {
        list.clearSelection();
      }
      return;
    }
    p = SwingUtilities.convertPoint(list, p, panel);
    if (!checkBox.getBounds().contains(p)) {
      return;
    }

    /**********************************************************************/
    /* Not a good design. CheckboxCellHandler should be flexible.         */
    /* We will remove this dependence on Garment in the next iteration.   */
    /**********************************************************************/
    ListModel model = list.getModel();
    Garment garment = (Garment)model.getElementAt(index);
    garment.setWorn(!garment.isWorn());
    /**********************************************************************/

    list.repaint(rect.x, rect.y, rect.width, rect.height);
  }
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}