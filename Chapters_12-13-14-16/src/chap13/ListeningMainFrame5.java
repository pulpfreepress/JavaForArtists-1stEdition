/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ListeningMainFrame5
  extends ListeningMainFrame4
  implements ActionListener {

  protected void addListeners() {
    super.addListeners();

    titleBorderRadioButton.addActionListener(this);
    lineBorderRadioButton.addActionListener(this);
    etchedBorderRadioButton.addActionListener(this);
    bevelBorderRadioButton.addActionListener(this);
    noBorderRadioButton.addActionListener(this);

    vegetablesCheckBox.addActionListener(this);
    fruitsCheckBox.addActionListener(this);
    nutsCheckBox.addActionListener(this);
    cheesesCheckBox.addActionListener(this);

    lockingToggleButton.addActionListener(this);

    fontStyleComboBox.addActionListener(this);

    secretCodeField.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();

    //borders
    if (o == titleBorderRadioButton) {
      displayOptionsPanel.setBorder(new TitledBorder("Panel Options"));
      System.out.println(displayOptionsPanel.getInsets());
    } else if (o == lineBorderRadioButton) {
      displayOptionsPanel.setBorder(new LineBorder(Color.blue, 10));
      System.out.println(displayOptionsPanel.getInsets());
    } else if (o == etchedBorderRadioButton) {
      displayOptionsPanel.setBorder(new EtchedBorder());
      System.out.println(displayOptionsPanel.getInsets());
    } else if (o == bevelBorderRadioButton) {
      displayOptionsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
      System.out.println(displayOptionsPanel.getInsets());
    } else if (o == noBorderRadioButton) {
      displayOptionsPanel.setBorder(null);
      System.out.println(displayOptionsPanel.getInsets());

      //lock/unlock the textarea
    } else if (o == lockingToggleButton) {
      boolean selected = lockingToggleButton.isSelected();
      textArea.setEditable(!selected);
      textArea.setOpaque(!selected);

      //update the list
    } else if (
      o == vegetablesCheckBox
        || o == fruitsCheckBox
        || o == nutsCheckBox
        || o == cheesesCheckBox) {
      boolean selected = ((JCheckBox)o).isSelected();
      List items = null;
      if (o == vegetablesCheckBox) {
        items = vegetables;
      } else if (o == fruitsCheckBox) {
        items = fruits;
      } else if (o == nutsCheckBox) {
        items = nuts;
      } else if (o == cheesesCheckBox) {
        items = cheeses;
      }
      if (selected) {
        saladListItems.addAll(items);
      } else {
        saladListItems.removeAll(items);
      }
      saladList.setListData(saladListItems);

      //change the font style
    } else if (o == fontStyleComboBox) {
      int fontStyle = Font.PLAIN;
      int i = fontStyleComboBox.getSelectedIndex();
      if (i == 0) {
        fontStyle = Font.PLAIN;
      } else if (i == 1) {
        fontStyle = Font.BOLD;
      } else if (i == 2) {
        fontStyle = Font.ITALIC;
      } else if (i == 3) {
        fontStyle = Font.BOLD | Font.ITALIC;
      }
      textArea.setFont(textArea.getFont().deriveFont(fontStyle));

      //compare secretCodeField to chosenItemTextField
    } else if (o == secretCodeField) {
      String message;
      int messageType;
      if (secretCodeField
        .getPassword()
        .equals(chosenItemTextField.getText())) {
        message = "You guessed the secret code!";
        messageType = JOptionPane.INFORMATION_MESSAGE;
      } else {
        message = "That was not the secret code.";
        messageType = JOptionPane.ERROR_MESSAGE;
      }
      JOptionPane.showMessageDialog(
        secretCodeField,
        message,
        "Results",
        messageType);
    }
  }
  public static void main(String[] arg) {
    ListeningMainFrame5 frame = new ListeningMainFrame5();
  }
}