/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.gui4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.util.EventObject;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public abstract class CheckboxListCell
  implements ListCellRenderer, MouseListener {

  private JLabel label;
  private JCheckBox checkBox;
  private JPanel panel;
  private Vector listeners = new Vector();

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
    notifyListeners(new ToggleEvent(list, index));
    list.repaint(rect.x, rect.y, rect.width, rect.height);
  }
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  public static class ToggleEvent extends EventObject {
    private int index;

    public ToggleEvent(JList list, int index) {
      super(list);
      this.index = index;
    }
    public int getIndex() {
      return index;
    }
  }
  public interface ToggleListener extends EventListener {
    public void checkboxToggled(ToggleEvent event);
  }
  private void notifyListeners(ToggleEvent event) {
    for (Iterator it = listeners.iterator(); it.hasNext();) {
      ToggleListener rl = (ToggleListener)it.next();
      rl.checkboxToggled(event);
    }
  }
  public void addToggleListener(ToggleListener rl) {
    listeners.add(rl);
  }
  public void removeToggleListener(ToggleListener rl) {
    listeners.remove(rl);
  }
}