/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class SalariedEmployee extends Employee {
  private double _annual_salary;
 
  public SalariedEmployee(String f_name, String m_name, String l_name, int dob_year, int dob_month, int dob_day, String gender, String employee_number, double annual_salary){
    super(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender, employee_number);
    _annual_salary = annual_salary;
 }

  public double pay(){
      return _annual_salary/24;  // 24 pay periods
  }

}