/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.interfaces;

import java.util.*;
import java.io.*;

public interface iModel {
  public void createHourlyEmployee(String fname, String mname, String lname,
                                    int dob_year, int dob_month, int dob_day,
                                    String gender, String employee_number,
                                    double hours_worked, double hourly_rate);

  public void createSalariedEmployee(String fname, String mname, String lname,
                                    int dob_year, int dob_month, int dob_day,
                                    String gender, String employee_number,
                                    double salary);

  public void editEmployeeInfo(String fname, String mname, String lname,
                                    int dob_year, int dob_month, int dob_day,
                                    String gender, String employee_number);

 

  public String[] getAllEmployeesInfo();

  public String getEmployeeInfo(String employee_number);

  public void sortEmployees();
  
  public void deleteEmployee(String employee_number);
  
  public void saveEmployeesToFile(File file);
  
  public void loadEmployeesFromFile(File file);

} // end iModel interface definition