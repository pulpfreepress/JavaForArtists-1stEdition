/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.model;

import java.util.*;
import java.io.*;
import java.text.*;

public class HourlyEmployee extends Employee implements Cloneable, Comparable, Serializable{
  private double _hours_worked = 0;
  private double _hourly_rate = 0.0;
  
  public HourlyEmployee(String f_name, String m_name, String l_name, int dob_year, int dob_month,
                   int dob_day, String gender, String employee_number){
    super(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender, employee_number);                
  }
  
   public void setPayInfo(PayInfo pi){
       _hours_worked = pi.getHoursWorked();
       _hourly_rate = pi.getHourlyRate();
   }
   
   public double getPay() { return _hours_worked * _hourly_rate; }
   
   public String toString() { 
     NumberFormat pay_format = NumberFormat.getInstance();
     return super.toString() + "  $" + pay_format.format(getPay()); 
     
   }
   
    public Object clone() throws CloneNotSupportedException {
       super.clone();
       return new HourlyEmployee(new String(getFirstName()), new String(getMiddleName()),
                           new String(getLastName()), getBirthday().get(Calendar.YEAR),
                           getBirthday().get(Calendar.MONTH), getBirthday().get(Calendar.DATE),
                           new String(getGender()), new String(getEmployeeNumber()));
    }
    
  public boolean equals(Object o){
      if(o == null) return false;
      boolean is_equal = false;
      if(o instanceof HourlyEmployee){
         if(this.toString().equals(o.toString())){
           is_equal = true;
         }
       }
       return is_equal;
    }
    
    public int hashCode(){
      return this.toString().hashCode();
    }
    
       
    public int compareTo(Object o){
       return this.toString().compareTo(o.toString());
    }

  
} // end HourlyEmployee class definition
