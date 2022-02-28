/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.exercises;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public abstract class CheckboxCellHandler
  implements ListCellRenderer, TableCellRenderer, TreeCellRenderer, MouseListener {

  private JLabel label;
  private JCheckBox checkBox;
  private JPanel panel;
  private Vector listeners = new Vector();

  public CheckboxCellHandler() {
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

  public Component getTableCellRendererComponent(
    JTable table,
    Object value,
    boolean isSelected,
    boolean hasFocus,
    int row,
    int column) {

    panel.setBackground(isSelected ? Color.yellow : table.getBackground());
    label.setText(String.valueOf(value));
    checkBox.setSelected(getCheckedValue(value));
    return panel;
  }

  public Component getTreeCellRendererComponent(
    JTree tree,
    Object value,
    boolean selected,
    boolean expanded,
    boolean leaf,
    int row,
    boolean hasFocus) {

    panel.setBackground(selected ? Color.yellow : tree.getBackground());
    label.setText(String.valueOf(value));
    checkBox.setSelected(getCheckedValue(value));
    return panel;
  }
  protected abstract boolean getCheckedValue(Object value);

  private Rectangle getRendererBounds(Object source, Point p) {
    Rectangle rect = null;
    if (source instanceof JList) {
      JList list = (JList)source;
      int index = list.locationToIndex(p);
      rect = list.getCellBounds(index, index);
    } else if (source instanceof JTable) {
      JTable table = (JTable)source;
      int row = table.rowAtPoint(p);
      int column = table.columnAtPoint(p);
      rect = table.getCellRect(row, column, false);
    } else if (source instanceof JTree) {
      JTree tree = (JTree)source;
      int row = tree.getRowForLocation(p.x, p.y);
      rect = tree.getRowBounds(row);
    }
    return rect;
  }

  private Object getValueAt(Object source, Point p) {
    Object value = null;
    if (source instanceof JList) {
      JList list = (JList)source;
      int index = list.locationToIndex(p);
      value = list.getModel().getElementAt(index);
    } else if (source instanceof JTable) {
      JTable table = (JTable)source;
      int row = table.rowAtPoint(p);
      int column = table.columnAtPoint(p);
      value = table.getValueAt(row, column);
    } else if (source instanceof JTree) {
      JTree tree = (JTree)source;
      TreePath path = tree.getClosestPathForLocation(p.x, p.y);
      value = path.getLastPathComponent();
    }
    return value;
  }
  public void mouseClicked(MouseEvent e) {
    JComponent source = (JComponent)e.getSource();
    Point p = e.getPoint();
    Rectangle rect = getRendererBounds(source, p);
    panel.setBounds(rect);
    if (source instanceof JList) {
      JList list = (JList)source;
      if (!rect.contains(p)) {
        if (!e.isShiftDown() && !e.isControlDown()) {
          list.clearSelection();
        }
        return;
      }
    }
    p = SwingUtilities.convertPoint(source, p, panel);
    if (!checkBox.getBounds().contains(p)) {
      return;
    }
    Object value = getValueAt(source, p);
    notifyListeners(new ToggleEvent(source, value));
    source.repaint(rect.x, rect.y, rect.width, rect.height);
  }
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  public static class ToggleEvent extends EventObject {
    private Object value;

    public ToggleEvent(Object source, Object value) {
      super(source);
      this.value = value;
    }
    public Object getValue() {
      return value;
    }
  }
  public interface ToggleListener {
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