/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.commands;

public class DeleteEmployeeCommand extends BaseCommand {

  public void execute(){
    if((its_model != null) && (its_view != null)){
       String employee_number = its_view.getDeleteEmployeeInfo();
       if(employee_number != null) {
          its_model.deleteEmployee(its_view.getDeleteEmployeeInfo());
       }
    }
    its_view.displayEmployeeInfo(its_model.getAllEmployeesInfo());
  } // end execute() method
} // end DeleteEmployeeCommand class definition
