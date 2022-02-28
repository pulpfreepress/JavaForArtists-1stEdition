/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class MainTestApp {

  private IEmployeeFactory _employee_factory = null;
  private IEmployee[] _employee_array = null;
 
  
  public MainTestApp(){
    _employee_factory = new EmployeeFactory();
    _employee_array = new IEmployee[2];
    
  }

  public void createEmployees(){
    _employee_array[0] = _employee_factory.getNewSalariedEmployee("Rick", "W", "Miller", 1977, 03, 04, "Male", "12345");
    _employee_array[0].setPayInfo(new PayInfo(123000.00));
    _employee_array[1] = _employee_factory.getNewHourlyEmployee("Laura", "Jean", "Richter", 1980, 05, 06, "Female", "16273");
    _employee_array[1].setPayInfo(new PayInfo(40, 45.00));
  }
  
  public void showEmployeeInformation(){
     for(int i = 0; i < _employee_array.length; i++){
       System.out.println(_employee_array[i]);
     }
  }
  
  public static void main(String[] args){
    MainTestApp mta = new MainTestApp();
    mta.createEmployees();
    mta.showEmployeeInformation();
  }

} // end MainTestApp class definition
