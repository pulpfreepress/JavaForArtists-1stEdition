/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.interlude;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class DemoTreeOrTableCellHandler
  extends AbstractCellEditor
  implements TreeCellEditor, TableCellEditor, TreeCellRenderer, TableCellRenderer {

  private JTextField rendererField;
  private JTextField editorField;

  public DemoTreeOrTableCellHandler() {
    rendererField = new JTextField();
    rendererField.setBorder(null);
    rendererField.setForeground(Color.blue);

    editorField = new JTextField();
    editorField.setBorder(null);
    editorField.setForeground(Color.red);

    editorField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        stopCellEditing();
      }
    });
  }
  public Object getCellEditorValue() {
    return editorField.getText();
  }
  public Component getTreeCellEditorComponent(
    JTree tree,
    Object value,
    boolean isSelected,
    boolean expanded,
    boolean leaf,
    int row) {

    editorField.setText(String.valueOf(value));
    return editorField;
  }
  public Component getTableCellEditorComponent(
    JTable table,
    Object value,
    boolean isSelected,
    int row,
    int column) {

    editorField.setText(String.valueOf(value));
    return editorField;
  }
  public Component getTreeCellRendererComponent(
    JTree tree,
    Object value,
    boolean selected,
    boolean expanded,
    boolean leaf,
    int row,
    boolean hasFocus) {

    rendererField.setText(String.valueOf(value));
    return rendererField;
  }
  public Component getTableCellRendererComponent(
    JTable table,
    Object value,
    boolean isSelected,
    boolean hasFocus,
    int row,
    int column) {

    rendererField.setText(String.valueOf(value));
    return rendererField;
  }
  private Object getValueFromEvent(EventObject e) {
    Object value = null;
    if (e instanceof MouseEvent) {
      MouseEvent event = (MouseEvent)e;
      Point p = event.getPoint();
      Object src = e.getSource();
      if (src instanceof JTree) {
        JTree tree = (JTree)src;
        TreePath path = tree.getClosestPathForLocation(p.x, p.y);
        value = path.getLastPathComponent();
      } else if (src instanceof JTable) {
        JTable table = (JTable)src;
        int row = table.rowAtPoint(p);
        int column = table.columnAtPoint(p);
        value = table.getValueAt(row, column);
      }
    }
    return value;
  }
}