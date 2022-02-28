/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.model;

import com.pulpfreepress.interfaces.*;
import java.util.*;
import java.io.*;

public class Model implements iModel {

  private List employee_list = null;
  private IEmployeeFactory employee_factory = null;
  
  public Model(){
     employee_list = new LinkedList();
     employee_factory = new EmployeeFactory();
  }

  public void createHourlyEmployee(String fname, String mname, String lname,
                                    int dob_year, int dob_month, int dob_day,
                                    String gender, String employee_number,
                                    double hours_worked, double hourly_rate){
                                    
     PayInfo pay_info = new PayInfo(hours_worked, hourly_rate);
     IEmployee employee = employee_factory.getNewHourlyEmployee(fname, mname, lname, dob_year,
                                                                dob_month, dob_day, gender,
                                                                employee_number);
     employee.setPayInfo(pay_info);
     employee_list.add(employee);
                                                                   
                                                                   
  }

  public void createSalariedEmployee(String fname, String mname, String lname,
                                    int dob_year, int dob_month, int dob_day,
                                    String gender, String employee_number,
                                    double salary){
                                    
     PayInfo pay_info = new PayInfo(salary);
     IEmployee employee = employee_factory.getNewSalariedEmployee(fname, mname, lname, dob_year,
                                                                dob_month, dob_day, gender,
                                                                employee_number);
     employee.setPayInfo(pay_info);
     employee_list.add(employee);
                                    
                                                                       
  }

  public void editEmployeeInfo(String fname, String mname, String lname,
                                    int dob_year, int dob_month, int dob_day,
                                    String gender, String employee_number){
     IEmployee employee = null;
    for(Iterator it = employee_list.iterator(); it.hasNext();){
         employee = (IEmployee)it.next();
         if(employee.getEmployeeNumber().equals(employee_number)) break;
    }
    
     employee.setFirstName(fname);
     employee.setMiddleName(mname);
     employee.setLastName(lname);
     employee.setBirthday(dob_year, dob_month, dob_day);
                                                                   
  }

  

  public String[] getAllEmployeesInfo(){
     String[] emp_info = new String[employee_list.size()];
     Iterator it = employee_list.iterator();
     for(int i = 0; it.hasNext();){
        emp_info[i++] = it.next().toString();
     }
      return emp_info;
  }

  public String getEmployeeInfo(String employee_number){
    IEmployee employee = null;
    for(Iterator it = employee_list.iterator(); it.hasNext();){
         employee = (IEmployee)it.next();
         if(employee.getEmployeeNumber().equals(employee_number)) break;
    }
     return employee.toString();
  }

  public void sortEmployees(){
    Collections.sort(employee_list);
  }
  
  public void deleteEmployee(String employee_number){
  IEmployee employee = null;
    for(Iterator it = employee_list.iterator(); it.hasNext();){
         employee = (IEmployee)it.next();
         if(employee.getEmployeeNumber().equals(employee_number)){
           employee_list.remove(employee);
           break;
         }
    }
  }
  
  public void saveEmployeesToFile(File file){
   if(file == null){
      file = new File("employees.dat");
   }
   
   FileOutputStream fos = null;
   ObjectOutputStream oos = null;
   
   try{
     fos = new FileOutputStream(file);
     oos = new ObjectOutputStream(fos);
     oos.writeObject(employee_list);
     oos.close();
     }catch(Exception e){
        System.out.println("Problem saving employees file to disk!");
     }
  } 
  
  public void loadEmployeesFromFile(File file){
    if(file == null){
      file = new File("employees.dat");
   }
   
   FileInputStream fis = null;
   ObjectInputStream ois = null;
   
   try{
     fis = new FileInputStream(file);
     ois = new ObjectInputStream(fis);
     employee_list = (LinkedList)ois.readObject();
     ois.close();
     }catch(Exception e){
        System.out.println("Problem saving employees file to disk!");
     }

  }


} // end Model class definition
