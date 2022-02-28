/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.model;

public class PayInfo {
  private double _salary = 0;
  private double _hours_worked = 0;
  private double _hourly_rate = 0;
  
  public PayInfo(double salary){
     _salary = salary;
  }
  
  public PayInfo(double hours_worked, double hourly_rate){
     _hours_worked = hours_worked;
     _hourly_rate = hourly_rate;
  }
  
  public PayInfo(){ }
  
  public double getHoursWorked(){ return _hours_worked; }
  public double getHourlyRate(){ return _hourly_rate; }
  public double getSalary(){ return _salary; }
  
} // end PayInfo class definition
