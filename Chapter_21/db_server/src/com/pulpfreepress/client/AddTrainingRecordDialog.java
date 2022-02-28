/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.client;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddTrainingRecordDialog extends JDialog {
  private JLabel _label1 = null;
  private JLabel _label2 = null;
  private JLabel _label3 = null;
  private JTextField _textfield1 = null;
  private JTextField _textfield2 = null;
  private JTextField _textfield3 = null;
  private JButton _button1 = null;
  private JPanel _panel1 = null;
  private JPanel _blank_panel = null;

  public AddTrainingRecordDialog(ActionListener al){
    super(new JFrame(), "Add Employee Training Record Dialog", true);
    _panel1 = new JPanel();
    _blank_panel = new JPanel();
    _label1 = new JLabel("Date (yyyy-mm-dd):");
    _label2 = new JLabel("Topic: ");
    _label3 = new JLabel("Result: ");
    _textfield1 = new JTextField(20);
    _textfield2 = new JTextField(20);
    _textfield3 = new JTextField(20);
    _button1 = new JButton("Submit Training Record");
    _button1.addActionListener(al);
    _panel1.add(_button1);
    this.getContentPane().setLayout(new GridLayout(4, 2, 0, 0));
    this.getContentPane().add(_label1);
    this.getContentPane().add(_textfield1);
    this.getContentPane().add(_label2);
    this.getContentPane().add(_textfield2);
    this.getContentPane().add(_label3);
    this.getContentPane().add(_textfield3);
    this.getContentPane().add(_blank_panel);
    this.getContentPane().add(_panel1);
    this.setSize(300, 200);
    this.setLocation(150, 150);
    this.pack();
  } // end constructor

  public String getDate(){ return _textfield1.getText(); }
  public String getTopic() { return _textfield2.getText(); }
  public String getResult() { return _textfield3.getText(); }
  
  public void clearAllFields(){
    _textfield1.setText("");
    _textfield2.setText("");
    _textfield3.setText("");
  }

} // end AddTrainingRecordDialog class definition
