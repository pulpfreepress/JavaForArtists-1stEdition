/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.exercises;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class TableEditor
  extends AbstractCellEditor
  implements TableCellEditor {

  private JTextField field = new JTextField();

  public TableEditor() {
		field = new JTextField();
		field.setForeground(Color.red);
    field.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        TableEditor.this.fireEditingStopped();
      }
    });
  }
  public Object getCellEditorValue() {
    return field.getText();
  }

  public Component getTableCellEditorComponent(
    JTable table,
    Object value,
    boolean isSelected,
    int row,
    int column) {

    field.setText(String.valueOf(value));
    return field;
  }
}
