/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class HourlyEmployee extends Employee {
  private double _hours_worked;
  private double _hourly_wage_rate;

  public HourlyEmployee(String f_name, String m_name, String l_name, int dob_year, int dob_month, int dob_day, String gender, String employee_number, double hourly_wage_rate, double hours_worked){
    super(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender, employee_number);
    _hourly_wage_rate = hourly_wage_rate;
    _hours_worked = hours_worked;
 }

  public double pay(){
      return _hourly_wage_rate * _hours_worked;
  }

}