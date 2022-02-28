/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.text.*;

public class EmployeeTestApp {
   public static void main(String[] args){
     Employee[] employees = new Employee[4];
     NumberFormat number_format = NumberFormat.getInstance();
     number_format.setMaximumFractionDigits(2);

     employees[0] = new SalariedEmployee("Steve", "J", "Jones", 1983, 3, 4, "M", "000-11111", 65000.00);
     employees[1] = new HourlyEmployee("Bob", "E", "Evans", 1992, 1, 2, "M", "000-22222", 23.00, 80.00);
     employees[2] = new SalariedEmployee("Janice", "A", "Brown", 1983, 3, 4, "F", "000-33333", 100000.00);
     employees[3] = new HourlyEmployee("Helen", "Of", "Troy", 1946, 4, 8, "F", "000-44444", 50.00, 80.00);

     for(int i = 0; i<employees.length; i++){
      System.out.println("Employee: " + employees[i].getEmployeeInfo() + " Pay: " + "$" + number_format.format(employees[i].pay()));
     }


   }
}