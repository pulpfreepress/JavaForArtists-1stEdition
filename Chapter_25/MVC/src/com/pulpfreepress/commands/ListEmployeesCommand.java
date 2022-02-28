/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

package com.pulpfreepress.commands;

public class ListEmployeesCommand extends BaseCommand {
  public void execute(){
    if(its_model != null){
       its_view.displayEmployeeInfo(its_model.getAllEmployeesInfo());
    }
  }
}