/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.client;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddNewEmployeeDialog extends JDialog {
   private JLabel _label1 = null;
   private JLabel _label2 = null;
   private JLabel _label3 = null;
   private JLabel _label4 = null;
   private JLabel _label5 = null;
   private JTextField _textfield1 = null;
   private JTextField _textfield2 = null;
   private JTextField _textfield3 = null;
   private JTextField _textfield4 = null;
   private JTextField _textfield5 = null;
   private JButton _button1 = null;
   private JPanel _panel1 = null;
   private JPanel _blank_panel = null;

   public AddNewEmployeeDialog(ActionListener al){
     super(new JFrame(), "Add New Employee Dialog", true);
    
     _label1 = new JLabel("First Name: ");
     _label2 = new JLabel("Middle Name: ");
     _label3 = new JLabel("Last Name: ");
     _label4 = new JLabel("SSN (nnn-nn-nnnn): ");
     _label5 = new JLabel("Date of Birth (yyyy-mm-dd): ");
     _textfield1 = new JTextField(20);
     _textfield2 = new JTextField(20);
     _textfield3 = new JTextField(20);
     _textfield4 = new JTextField(20);
     _textfield5 = new JTextField(20);    
     _button1 = new JButton("Submit New Employee");
     _button1.addActionListener(al);
     _panel1 = new JPanel();
     _panel1.add(_button1);
     _blank_panel = new JPanel();
     
     this.getContentPane().setLayout(new GridLayout(6, 2, 0, 0));
     this.getContentPane().add(_label1);
     this.getContentPane().add(_textfield1);
     this.getContentPane().add(_label2);
     this.getContentPane().add(_textfield2);
     this.getContentPane().add(_label3);
     this.getContentPane().add(_textfield3);
     this.getContentPane().add(_label4);
     this.getContentPane().add(_textfield4);
     this.getContentPane().add(_label5);
     this.getContentPane().add(_textfield5);
     this.getContentPane().add(_blank_panel);
     this.getContentPane().add(_panel1);
     this.pack();
     this.setSize(400, 200);
     this.setLocation(150, 150);
   } // end constructor method
   
   public void clearAllFields(){
     _textfield1.setText("");
     _textfield2.setText("");
     _textfield3.setText("");
     _textfield4.setText("");
     _textfield5.setText("");
   }
   
   public String getFirstName() { return _textfield1.getText(); }
   public String getMiddleName() { return _textfield2.getText(); }
   public String getLastName() { return _textfield3.getText(); }
   public String getSSN() { return _textfield4.getText(); }
   public String getDOB() { return _textfield5.getText(); }

} // end AddNewEmployeeDialog class definition
