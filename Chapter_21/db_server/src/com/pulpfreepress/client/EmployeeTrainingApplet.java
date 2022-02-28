/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
import java.util.*;
import com.pulpfreepress.dbserver.*;
import com.pulpfreepress.business_objects.*;
import com.pulpfreepress.utils.*;

public class EmployeeTrainingApplet extends JApplet implements ActionListener {

   private JPanel _panel1 = null;
   private JPanel _panel2 = null;
   private JPanel _south_panel = null;
   private JTextArea _textarea1 = null;
   private JScrollPane _scrollpane1 = null;
   private JButton _button1 = null;
   private JButton _button2 = null;
   private JButton _button3 = null;
   private JButton _button4 = null;
   private JTextField _textfield1 = null;
   private JLabel _label1 = null;
   private PersisterInterface _persister = null;
   private Vector _employees = null;
   private AddNewEmployeeDialog _add_employee_dialog = null;
   private AddTrainingRecordDialog _add_training_record_dialog = null;
   private static final int TEXTAREA_ROWS = 20;
   private static final int TEXTAREA_COLS = 50;
   
   public void init(){
     initializeGui();
     initializeRMI();
     initializeDialogs();
   }
   
   
   private void initializeGui(){
     _panel1 = new JPanel();
     _panel2 = new JPanel();
     _south_panel = new JPanel();
     _textarea1 = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLS);
     _textarea1.setEditable(false);
     _scrollpane1 = new JScrollPane(_textarea1);
     _button1 = new JButton("Search By Last Name");
     _button1.addActionListener(this);
     _button2 = new JButton("Add New Employee");
     _button2.addActionListener(this);
     _button3 = new JButton("Get Employee Training Records");
     _button3.addActionListener(this);
     _button3.setEnabled(false);
     _button4 = new JButton("Add Employee Training Record");
     _button4.addActionListener(this);
     _button4.setEnabled(false);
     _textfield1 = new JTextField(20);
     _label1 = new JLabel("Last Name: ");
     _panel1.add(_label1);
     _panel1.add(_textfield1);
     _panel1.add(_button1);
     _panel2.add(_button2);
     _panel2.add(_button3);
     _panel2.add(_button4);
     _south_panel.setLayout(new GridLayout(2, 1, 0, 0));
     _south_panel.add(_panel1);
     _south_panel.add(_panel2);
     this.getContentPane().add(_scrollpane1);
     this.getContentPane().add(BorderLayout.SOUTH, _south_panel);
   }
   
   private void initializeRMI(){
     try{
        System.out.println("Attempting to lookup Employee_Persister_Service on :" + 
			    this.getCodeBase().getHost());
       _persister = (PersisterInterface)Naming.lookup("rmi://" + this.getCodeBase().getHost() + "/Employee_Persister_Service");
     }catch(Exception e){
       e.printStackTrace();
     }
   }
   
   private void initializeDialogs(){
     _add_employee_dialog = new AddNewEmployeeDialog(this);
     _add_employee_dialog.setVisible(false);
     _add_training_record_dialog = new AddTrainingRecordDialog(this);
     _add_training_record_dialog.setVisible(false);
   }


  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("Search By Last Name")){
       try{    
         _employees = _persister.queryByLastName(_textfield1.getText());
         if(_employees.size() > 0){
           _button3.setEnabled(true);
           _button4.setEnabled(true);
         }
         _textarea1.setText("");
         for(int i = 0; i < _employees.size(); i++){
           _textarea1.append(((Employee)_employees.elementAt(i)).getFirstName() + '\t' +
                             ((Employee)_employees.elementAt(i)).getMiddleName() + '\t' +
                             ((Employee)_employees.elementAt(i)).getLastName() + '\t' +
                             ((Employee)_employees.elementAt(i)).getSSN() + '\n');
         }
       }catch(Exception e){
         e.printStackTrace();
       }
    } else if(ae.getActionCommand().equals("Add New Employee")){
          _add_employee_dialog.clearAllFields();
          _add_employee_dialog.setVisible(true);
    } else if(ae.getActionCommand().equals("Submit New Employee")){
       try{
          _add_employee_dialog.setVisible(false);
          Employee emp = new Employee(0, 
                                      _add_employee_dialog.getFirstName(),
                                      _add_employee_dialog.getMiddleName(),
                                      _add_employee_dialog.getLastName(),
                                      _add_employee_dialog.getSSN(),
                                      _add_employee_dialog.getDOB(),
                                      null);
          _persister.addNewEmployee(emp);
       
        }catch(Exception e){
           e.printStackTrace();
        }
    } else if(ae.getActionCommand().equals("Get Employee Training Records")){
      try{
        _button3.setEnabled(false);
        _button4.setEnabled(false);
        Employee emp = (Employee)_employees.elementAt(getSelectedLineNumber());
        emp = _persister.getEmployeeTrainingRecords(emp);
        _textarea1.setText("");
        _textarea1.append(emp.getFirstName() + '\t' +
                          emp.getMiddleName() + '\t' +
                          emp.getLastName() + '\t' +
                          emp.getSSN() + '\n');
        _textarea1.append("------------------------------------------------------\n");
        Vector training_records = emp.getChildRelations();
        for(int i = 0; i < training_records.size(); i++){
          _textarea1.append(((EmployeeTraining)training_records.elementAt(i)).getDate() + '\t' +
                            ((EmployeeTraining)training_records.elementAt(i)).getTopic() + '\t' +
                            ((EmployeeTraining)training_records.elementAt(i)).getResult() + '\n');
        }
        
      }catch(ArrayIndexOutOfBoundsException aioobe){
         System.out.println("Invalid Employee Selection");
         return;
       }
      catch(Exception e){
         e.printStackTrace();
      }
    } else if(ae.getActionCommand().equals("Add Employee Training Record")){
       _add_training_record_dialog.clearAllFields();
       _add_training_record_dialog.setVisible(true);
    } else if(ae.getActionCommand().equals("Submit Training Record")){
      try{
        _add_training_record_dialog.setVisible(false);
        Employee emp = (Employee)_employees.elementAt(getSelectedLineNumber());
        EmployeeTraining et = new EmployeeTraining(0, 
                                                   emp.getEmployeeID(),
                                                   _add_training_record_dialog.getDate(),
                                                   _add_training_record_dialog.getTopic(),
                                                   _add_training_record_dialog.getResult());
        _persister.addTrainingRecord(et);
      }catch(ArrayIndexOutOfBoundsException aioobe){
         System.out.println("Invalid employee selection");
         return;
      }
      catch(Exception e){
         e.printStackTrace();
       }
    
    }
  } // end actionPerformed() method
  
  
  private int getSelectedLineNumber(){
    int caret_position = _textarea1.getCaretPosition();
    int line_number = 0;
    int string_length = 0;
    try{
      StringTokenizer st = new StringTokenizer(_textarea1.getText(), "\n");
      while(caret_position >= (string_length += st.nextToken().length()) ){
        line_number++;
      }
    }catch(NoSuchElementException ignored){ }
    return line_number;
  }

} // end EmployeeTrainingApplet class definition
