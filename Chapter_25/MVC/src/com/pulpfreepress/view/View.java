/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.view;

import com.pulpfreepress.interfaces.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class View extends JFrame implements iView {
 
 private JPanel panel1 = null;
 private JTextArea textarea1 = null;
 private int initial_frame_position_x = 50;
 private int initial_frame_position_y = 50;
 private int initial_frame_width = 400;
 private int initial_frame_height = 400;
 private int initial_textarea_rows = 20;
 private int initial_textarea_columns = 20;
 private EditEmployeeDialog edit_employee_dialog = null;
 private String[] current_employee_list = null;
 private JMenuItem delete_employee_menuitem = null;
 private JMenuItem edit_employee_menuitem = null;
 
 public View(ActionListener al){
   this.setupGUI(al);
 }

   public void displayEmployeeInfo(String[] employees_info){
       textarea1.setText("");
       for(int i = 0; i<employees_info.length; i++){
          textarea1.append(employees_info[i] + "\n");
       }
       current_employee_list = employees_info;
       if(current_employee_list.length == 0){
        this.delete_employee_menuitem.setEnabled(false);
        this.edit_employee_menuitem.setEnabled(false);
     }else{
        this.delete_employee_menuitem.setEnabled(true);
        this.edit_employee_menuitem.setEnabled(true);
       }
   }
   
   public String[] getNewHourlyEmployeeInfo(){
     edit_employee_dialog.setTitle("New Hourly Employee");
     edit_employee_dialog.clearTextFields();
     edit_employee_dialog.showHourlyInfo();
     edit_employee_dialog.hideSalaryInfo();
     edit_employee_dialog.enableEmployeeNumberTextField();
     edit_employee_dialog.setVisible(true);

     return edit_employee_dialog.getEmployeeInfo();
   }
   
   
   public String[] getNewSalariedEmployeeInfo(){
     edit_employee_dialog.setTitle("New Salaried Employee");
     edit_employee_dialog.clearTextFields();
     edit_employee_dialog.showSalaryInfo();
     edit_employee_dialog.hideHourlyInfo();
     edit_employee_dialog.enableEmployeeNumberTextField();
     edit_employee_dialog.setVisible(true);
     return edit_employee_dialog.getEmployeeInfo();
   }
   
   public String[] getEditEmployeeInfo(){
     edit_employee_dialog.setTitle("Edit Employee Information");
     edit_employee_dialog.clearTextFields();
     edit_employee_dialog.hideHourlyAndSalaryInfo();
     edit_employee_dialog.disableEmployeeNumberTextField();
     String emp_info_string = current_employee_list[getSelectedLineNumber()];
     String[] emp_string_array = employeeInfoStringToStringArray(emp_info_string);
     edit_employee_dialog.populateTextFields(emp_string_array);
     edit_employee_dialog.setVisible(true);
     return edit_employee_dialog.getEditedEmployeeInfo();
   
   }
   
   public String getDeleteEmployeeInfo(){
     String emp_number = "";
     if(current_employee_list != null){
       String emp_info_string = current_employee_list[getSelectedLineNumber()];
       String[] emp_string_array = employeeInfoStringToStringArray(emp_info_string);
         if(emp_string_array != null){
           emp_number = emp_string_array[7];
          }
     }
     return emp_number;
   }
   
   private JMenuBar setupMenuBar(ActionListener al){
     /*** create menubar ***/
     JMenuBar menubar = new JMenuBar();
     
     /*** create file menu and menu items ***/
     JMenu file_menu = new JMenu("File");
     JMenuItem file_loadEmployees_menuitem = new JMenuItem("Load Employees...");
     file_loadEmployees_menuitem.setActionCommand("Load");
     file_loadEmployees_menuitem.addActionListener(al);
     JMenuItem file_saveEmployees_menuitem = new JMenuItem("Save Employees...");
     file_saveEmployees_menuitem.setActionCommand("Save");
     file_saveEmployees_menuitem.addActionListener(al);
     JMenuItem file_exit_menuitem = new JMenuItem("Exit");
     file_exit_menuitem.addActionListener(al);
     
     file_menu.add(file_loadEmployees_menuitem);
     file_menu.add(file_saveEmployees_menuitem);
     file_menu.add(file_exit_menuitem);
     
     menubar.add(file_menu);
     
     /*** create employees menu and menu items ***/
     JMenu employees_menu = new JMenu("Employees");
     JMenuItem employees_list_menuitem = new JMenuItem("List");
     employees_list_menuitem.addActionListener(al);
     JMenuItem employees_sort_menuitem = new JMenuItem("Sort");
     employees_sort_menuitem.addActionListener(al);
     JMenuItem employees_newHourlyEmployee_menuitem = new JMenuItem("New Hourly...");
     employees_newHourlyEmployee_menuitem.setActionCommand("NewHourlyEmployee");
     employees_newHourlyEmployee_menuitem.addActionListener(al);
     JMenuItem employees_newSalariedEmployee_menuitem = new JMenuItem("New Salaried...");
     employees_newSalariedEmployee_menuitem.setActionCommand("NewSalariedEmployee");
     employees_newSalariedEmployee_menuitem.addActionListener(al);
     JMenuItem employees_editEmployee_menuitem = new JMenuItem("Edit Employee...");
     employees_editEmployee_menuitem.setActionCommand("EditEmployee");
     employees_editEmployee_menuitem.addActionListener(al);
     JMenuItem employees_deleteEmployee_menuitem = new JMenuItem("Delete Employee");
     employees_deleteEmployee_menuitem.setActionCommand("DeleteEmployee");
     employees_deleteEmployee_menuitem.addActionListener(al);
     this.delete_employee_menuitem = employees_deleteEmployee_menuitem;
     this.edit_employee_menuitem = employees_editEmployee_menuitem;
     if(current_employee_list == null){
        this.delete_employee_menuitem.setEnabled(false);
        this.edit_employee_menuitem.setEnabled(false);
     }
     
     employees_menu.add(employees_list_menuitem);
     employees_menu.add(employees_sort_menuitem);
     employees_menu.add(employees_newHourlyEmployee_menuitem);
     employees_menu.add(employees_newSalariedEmployee_menuitem);
     employees_menu.add(employees_editEmployee_menuitem);
     employees_menu.add(employees_deleteEmployee_menuitem);
     
     
     menubar.add(employees_menu);
     
     
     
     return menubar;
   }
   
   private void setupGUI(ActionListener al){
      edit_employee_dialog = new EditEmployeeDialog(this);
      textarea1 = new JTextArea(initial_textarea_rows, initial_textarea_columns);
      JScrollPane scrollpane = new JScrollPane(textarea1);
      this.getContentPane().add(scrollpane);
      this.setJMenuBar(this.setupMenuBar(al));
      this.setSize(initial_frame_height, initial_frame_width);
      this.setLocation(initial_frame_position_x, initial_frame_position_y);
      this.pack();
      this.show();
   }


  private int getSelectedLineNumber(){
    int caret_position = textarea1.getCaretPosition();
    int line_number = 0;
    int string_length = 0;
    try{
      StringTokenizer st = new StringTokenizer(textarea1.getText(), "\n");
      while(caret_position >= (string_length += st.nextToken().length()) ){
        line_number++;
      }
    }catch(NoSuchElementException ignored){ }
    
    if(line_number >= current_employee_list.length){
      line_number = current_employee_list.length-1;
    }
    return line_number;
  }
  
  private String[] employeeInfoStringToStringArray(String emp_string){
     StringTokenizer st = new StringTokenizer(emp_string);
     String fname = st.nextToken();
     String mname = st.nextToken();
     String lname = st.nextToken();
     String gender = st.nextToken();
     String bday = st.nextToken();
     String emp_no = st.nextToken();
     
     StringTokenizer st2 = new StringTokenizer(bday,"/");
     String day = st2.nextToken();
     String month = st2.nextToken();
     String year = st2.nextToken();
     
     String[] string_array = {fname, mname, lname, gender, year, month, day, emp_no};
     return string_array;
  }
  
  public File getSaveFile(){
     File file = null;
     JFileChooser file_chooser = new JFileChooser();
     int result = file_chooser.showSaveDialog(this);
     switch(result){
        case JFileChooser.APPROVE_OPTION: { file = file_chooser.getSelectedFile();
                                            break;
                                          }
        case JFileChooser.CANCEL_OPTION: break;
     
     } // end switch
     return file;
  }
  
  public File getLoadFile(){
    File file = null;
     JFileChooser file_chooser = new JFileChooser();
     int result = file_chooser.showOpenDialog(this);
     switch(result){
        case JFileChooser.APPROVE_OPTION: { file = file_chooser.getSelectedFile();
                                            break;
                                          }
        case JFileChooser.CANCEL_OPTION: break;
                                         
     
     } // end switch
     return file;
  }


} // end View class definition
