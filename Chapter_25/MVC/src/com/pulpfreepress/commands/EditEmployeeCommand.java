/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.commands;

public class EditEmployeeCommand extends BaseCommand {

  public void execute(){
    if((its_model != null) && (its_view != null)){
       String[] emp_info = its_view.getEditEmployeeInfo();
       try{
         its_model.editEmployeeInfo(emp_info[0], emp_info[1], emp_info[2],
                             Integer.parseInt(emp_info[4]), Integer.parseInt(emp_info[5]), 
                             Integer.parseInt(emp_info[6]), emp_info[3], emp_info[7]);
         }catch(Throwable t){
           System.out.println("Invalid employee information - employee edit cancled!");
         }
    }
    its_view.displayEmployeeInfo(its_model.getAllEmployeesInfo());
  } // end execute() method
} // end EditEmployeeCommand class definition
