/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.exercises;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.TreeCellEditor;

public class MyDefaultCellEditor
  extends AbstractCellEditor
  implements TableCellEditor, TreeCellEditor {

  protected JComponent editorComponent;
  protected EditorDelegate delegate;
  protected int clickCountToStart = 1;

  public MyDefaultCellEditor(final JTextField textField) {
    editorComponent = textField;
    this.clickCountToStart = 2;
    delegate = new EditorDelegate() {
      public void setValue(Object value) {
        textField.setText((value != null) ? value.toString() : "");
      }

      public Object getCellEditorValue() {
        return textField.getText();
      }
    };
    textField.addActionListener(delegate);
  }
  public MyDefaultCellEditor(final JCheckBox checkBox) {
    editorComponent = checkBox;
    delegate = new EditorDelegate() {
      public void setValue(Object value) {
        boolean selected = false;
        if (value instanceof Boolean) {
          selected = ((Boolean)value).booleanValue();
        } else if (value instanceof String) {
          selected = value.equals("true");
        }
        checkBox.setSelected(selected);
      }

      public Object getCellEditorValue() {
        return Boolean.valueOf(checkBox.isSelected());
      }
    };
    checkBox.addActionListener(delegate);
  }
  public MyDefaultCellEditor(final JComboBox comboBox) {
    editorComponent = comboBox;
    comboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
    delegate = new EditorDelegate() {
      public void setValue(Object value) {
        comboBox.setSelectedItem(value);
      }

      public Object getCellEditorValue() {
        return comboBox.getSelectedItem();
      }

      public boolean shouldSelectCell(EventObject anEvent) {
        if (anEvent instanceof MouseEvent) {
          MouseEvent e = (MouseEvent)anEvent;
          return e.getID() != MouseEvent.MOUSE_DRAGGED;
        }
        return true;
      }
      public boolean stopCellEditing() {
        if (comboBox.isEditable()) {
          // Commit edited value.
          comboBox.actionPerformed(
            new ActionEvent(MyDefaultCellEditor.this, 0, ""));
        }
        return super.stopCellEditing();
      }
    };
    comboBox.addActionListener(delegate);
  }
  public Component getComponent() {
    return editorComponent;
  }
  public void setClickCountToStart(int count) {
    clickCountToStart = count;
  }
  public int getClickCountToStart() {
    return clickCountToStart;
  }
  public Object getCellEditorValue() {
    return delegate.getCellEditorValue();
  }
  public boolean isCellEditable(EventObject anEvent) {
    return delegate.isCellEditable(anEvent);
  }
  public boolean shouldSelectCell(EventObject anEvent) {
    return delegate.shouldSelectCell(anEvent);
  }
  public boolean stopCellEditing() {
    return delegate.stopCellEditing();
  }
  public void cancelCellEditing() {
    delegate.cancelCellEditing();
  }
  public Component getTreeCellEditorComponent(
    JTree tree,
    Object value,
    boolean isSelected,
    boolean expanded,
    boolean leaf,
    int row) {
    	
    String stringValue =
      tree.convertValueToText(value, isSelected, expanded, leaf, row, false);

    delegate.setValue(stringValue);
    return editorComponent;
  }
  public Component getTableCellEditorComponent(
    JTable table,
    Object value,
    boolean isSelected,
    int row,
    int column) {
    	
    delegate.setValue(value);
    return editorComponent;
  }

  /**
   * The protected <code>EditorDelegate</code> class.
   */
  protected class EditorDelegate
    implements ActionListener, ItemListener, Serializable {
    protected Object value;

    public Object getCellEditorValue() {
      return value;
    }
    public void setValue(Object value) {
      this.value = value;
    }
    public boolean isCellEditable(EventObject anEvent) {
      if (anEvent instanceof MouseEvent) {
        return ((MouseEvent)anEvent).getClickCount() >= clickCountToStart;
      }
      return true;
    }
    public boolean shouldSelectCell(EventObject anEvent) {
      return true;
    }
    public boolean startCellEditing(EventObject anEvent) {
      return true;
    }
    public boolean stopCellEditing() {
      fireEditingStopped();
      return true;
    }
    public void cancelCellEditing() {
      fireEditingCanceled();
    }
    public void actionPerformed(ActionEvent e) {
      MyDefaultCellEditor.this.stopCellEditing();
    }
    public void itemStateChanged(ItemEvent e) {
      MyDefaultCellEditor.this.stopCellEditing();
    }
  }

} // End of class JCellEditor
