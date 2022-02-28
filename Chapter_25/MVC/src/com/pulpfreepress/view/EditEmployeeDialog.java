/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class EditEmployeeDialog extends JDialog implements ActionListener {
    private JLabel label1 = null;
    private JLabel label2 = null;
    private JLabel label3 = null;
    private JLabel label4 = null;
    private JLabel label5 = null;
    private JLabel label6 = null;
    private JLabel label7 = null;
    private JLabel label8 = null;
    private JLabel label9 = null;
    private JLabel label10 = null;
    private JLabel label11 = null;
    
    private JTextField textfield1 = null;
    private JTextField textfield2 = null;
    private JTextField textfield3 = null;
    private JTextField textfield4 = null;
    private JTextField textfield5 = null;
    private JTextField textfield6 = null;
    private JTextField textfield7 = null;
    private JTextField textfield8 = null;
    private JTextField textfield9 = null;
    private JTextField textfield10 = null;
    private JTextField textfield11 = null;


    
    
  public EditEmployeeDialog(JFrame frame){
    super(frame, "Employee Information Dialog", true); // modal dialog 
    this.setupGUI();
    this.setVisible(false);
  }
  
  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("Submit")){
       boolean bool_val = verifyFieldValues();
       if(bool_val){
          this.setVisible(false);
        }
    }
  }
  
  private void setupGUI(){
    label1 = new JLabel("First Name:");
    label2 = new JLabel("Middle Name:");
    label3 = new JLabel("Last Name:");
    label4 = new JLabel("Gender:");
    label5 = new JLabel("Birth Year:");
    label6 = new JLabel("Birth Month:");
    label7 = new JLabel("Birth Day:");
    label8 = new JLabel("Employee Number:");
    label9 = new JLabel("Hours Worked:");
    label10 = new JLabel("Hourly Rate");
    label11 = new JLabel("Salary:");
    
    textfield1 = new JTextField(20);
    textfield2 = new JTextField(20);
    textfield3 = new JTextField(20);
    textfield4 = new JTextField(20);
    textfield5 = new JTextField(20);
    textfield6 = new JTextField(20);
    textfield7 = new JTextField(20);
    textfield8 = new JTextField(20);
    textfield9 = new JTextField(20);
    textfield10 = new JTextField(20);
    textfield11 = new JTextField(20);
    
    
    JButton button1 = new JButton("Submit");
    button1.addActionListener(this);
    
    this.getContentPane().setLayout(new GridLayout(12, 2, 0, 0));
    this.getContentPane().add(label1);
    this.getContentPane().add(textfield1);
    this.getContentPane().add(label2);
    this.getContentPane().add(textfield2);
    this.getContentPane().add(label3);
    this.getContentPane().add(textfield3);
    this.getContentPane().add(label4);
    this.getContentPane().add(textfield4);
    this.getContentPane().add(label5);
    this.getContentPane().add(textfield5);
    this.getContentPane().add(label6);
    this.getContentPane().add(textfield6);
    this.getContentPane().add(label7);
    this.getContentPane().add(textfield7);
    this.getContentPane().add(label8);
    this.getContentPane().add(textfield8);
    this.getContentPane().add(label9);
    this.getContentPane().add(textfield9);
    this.getContentPane().add(label10);
    this.getContentPane().add(textfield10);
    this.getContentPane().add(label11);
    this.getContentPane().add(textfield11);
    this.getContentPane().add(new JPanel());
    this.getContentPane().add(new JPanel().add(button1));
    
    this.pack();
  }
  
  public String[] getEmployeeInfo(){
    String[] emp_info = new String[11];
    
    emp_info[0] = textfield1.getText();
    emp_info[1] = textfield2.getText();
    emp_info[2] = textfield3.getText();
    emp_info[3] = textfield4.getText();
    emp_info[4] = textfield5.getText();
    emp_info[5] = textfield6.getText();
    emp_info[6] = textfield7.getText();
    emp_info[7] = textfield8.getText();
    emp_info[8] = textfield9.getText();
    emp_info[9] = textfield10.getText();
    emp_info[10] = textfield11.getText();
    
    return emp_info;
    
  }
  
  public void hideSalaryInfo(){
    label11.setVisible(false);
    textfield11.setVisible(false);
  }
  
  public void showSalaryInfo(){
    label11.setVisible(true);
    textfield11.setVisible(true);
  }
  
  public void hideHourlyInfo(){
    label9.setVisible(false);
    textfield9.setVisible(false);
    label10.setVisible(false);
    textfield10.setVisible(false);
  }
  
  public void showHourlyInfo(){
    label9.setVisible(true);
    textfield9.setVisible(true);
    label10.setVisible(true);
    textfield10.setVisible(true);
  }
  
  public void clearTextFields(){
    textfield1.setText("");
    textfield2.setText("");
    textfield3.setText("");
    textfield4.setText("");
    textfield5.setText("yyyy");
    textfield6.setText("mm");
    textfield7.setText("dd");
    textfield8.setText("");
    textfield9.setText("0.00");
    textfield10.setText("0.00");
    textfield11.setText("0.00");
  }
  
  public void hideHourlyAndSalaryInfo(){
    hideSalaryInfo();
    hideHourlyInfo();
  }
  
  public void disableEmployeeNumberTextField(){
    textfield8.setEnabled(false);
  }
  
  public void enableEmployeeNumberTextField(){
    textfield8.setEnabled(true);
  }

  
  public void populateTextFields(String[] emp_info){
     textfield1.setText(emp_info[0]);
     textfield2.setText(emp_info[1]);
     textfield3.setText(emp_info[2]);
     textfield4.setText(emp_info[3]);
     textfield5.setText(emp_info[4]);
     if(Integer.parseInt(emp_info[5]) < 10) {
        textfield6.setText("0" + emp_info[5]);
      } else {
           textfield6.setText(emp_info[5]);
         }
     if(Integer.parseInt(emp_info[6]) < 10) {
        textfield7.setText("0" + emp_info[6]);
      } else {
           textfield7.setText(emp_info[6]);
         }
     textfield8.setText(emp_info[7]);
     
  }
  
  public String[] getEditedEmployeeInfo(){
    String[] emp_info = new String[8];
    
    emp_info[0] = textfield1.getText();
    emp_info[1] = textfield2.getText();
    emp_info[2] = textfield3.getText();
    emp_info[3] = textfield4.getText();
    emp_info[4] = textfield5.getText();
    emp_info[5] = textfield6.getText();
    emp_info[6] = textfield7.getText();
    emp_info[7] = textfield8.getText();
    
    
    return emp_info;
  }
  
  private boolean verifyFieldValues(){
    boolean ok = true;
    
    if(Pattern.matches("[A-Za-z]{1,64}", textfield1.getText())){
       // do nothing
    } else {
        textfield1.setText("-----Invalid First Name-----");
        ok = false;
      }
      
    if(Pattern.matches("[A-Za-z]{1,64}", textfield2.getText())){
       // do nothing
    } else {
        textfield2.setText("-----Invalid Middle Name-----");
        ok = false;
      }
      
    if(Pattern.matches("[A-Za-z]{1,64}", textfield3.getText())){
       // do nothing
    } else {
        textfield3.setText("-----Invalid Last Name-----");
        ok = false;
      }
      
      
    if(textfield4.getText().equals("Male") || textfield4.getText().equals("Female")){
      // do nothing
    } else {
        textfield4.setText("-----Male or Female-----");
        ok = false;
      }
    
    if(Pattern.matches("[1|2]{1}[0-9]{3}", textfield5.getText())){
       // do nothing
    } else {
        textfield5.setText("----invalid  Birth Year----");
        ok = false;
      }
      
    if(Pattern.matches("[0|1]{1}[0-9]{1}", textfield6.getText())){
       if((Integer.parseInt(textfield6.getText()) < 1) || (Integer.parseInt(textfield6.getText()) > 12) ){
         textfield6.setText("----invalid  Birth Month----");
         ok = false;
       }

    } else {
        textfield6.setText("----invalid  Birth Month----");
        ok = false;
      }
      
     if(Pattern.matches("[0-3]{1}[0-9]{1}", textfield7.getText())){
       if((Integer.parseInt(textfield7.getText()) < 1) || (Integer.parseInt(textfield7.getText()) > 31) ){
         textfield7.setText("----invalid  Birth Day----");
         ok = false;
       }
    } else {
        textfield7.setText("----invalid  Birth Day----");
        ok = false;
      } 
      
    if(Pattern.matches("[0-9]{6}", textfield8.getText())){
       // do nothing
    } else {
        textfield8.setText("----invalid  Employee Number----");
        ok = false;
      }
      
    if(Pattern.matches("[0-9]{1,2}[.]{1}[0-9]{2}", textfield9.getText())){
       // do nothing
    } else {
        textfield9.setText("----invalid  Hours Worked----");
        ok = false;
      }
      
    if(Pattern.matches("[0-9]{1,3}[.]{1}[0-9]{2}", textfield10.getText())){
       // do nothing
    } else {
        textfield10.setText("----invalid  Hourly Rate----");
        ok = false;
      }
      
      if(Pattern.matches("[0-9]{1,7}[.]{1}[0-9]{2}", textfield11.getText())){
       // do nothing
    } else {
        textfield11.setText("----invalid  Salary----");
        ok = false;
      }
    
    return ok;
  } 
  
    
} // end EditEmployeeDialog class definition
