/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class HourlyEmployee extends Employee {
  private double _hours_worked = 0;
  private double _hourly_rate = 0.0;
  
  public HourlyEmployee(String f_name, String m_name, String l_name, int dob_year, int dob_month,
                   int dob_day, String gender, String employee_number){
    super(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender, employee_number);                
  }
  
  public void setHoursWorked(double hours_worked) { _hours_worked = hours_worked; }
  public void setHourlyRate(double hourly_rate) { _hourly_rate = hourly_rate; }
  public double getHourlyRate() { return _hourly_rate; }
  public double getHoursWorked() { return _hours_worked; }
  public double getPay() { return _hours_worked * _hourly_rate; }
  
}
