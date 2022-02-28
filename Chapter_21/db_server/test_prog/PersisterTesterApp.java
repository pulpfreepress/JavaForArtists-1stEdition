/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import com.pulpfreepress.business_objects.*;
import com.pulpfreepress.dbserver.*;
import java.util.*;

public class PersisterTesterApp {
  public static void main(String[] args){
    Persister p = new Persister();
    Vector v = p.queryByLastName("Miller");
    for(int i = 0; i<v.size(); i++){
      System.out.print(((Employee)v.elementAt(i)).getEmployeeID() + "  " +
                       ((Employee)v.elementAt(i)).getFirstName() + "  " +
                       ((Employee)v.elementAt(i)).getMiddleName() + "  " +
                       ((Employee)v.elementAt(i)).getLastName() + "  " +
                       ((Employee)v.elementAt(i)).getSSN() + "  " +
                       ((Employee)v.elementAt(i)).getDOB());
      System.out.println();
    }
    
   Employee emp = new Employee(1, "Rick", "Warren", "Miller", "222-22-2225", "1961-02-04", null);
  // p.addNewEmployee(emp);
  
     EmployeeTraining et = new EmployeeTraining(0, 1, "2004-01-04", "How To Write A Great Book", "Passed with Honors");
     p.addTrainingRecord(et);
     
    emp = p.getEmployeeTrainingRecords(emp); 
    
    Vector v2 = emp.getChildRelations();
    System.out.println();
    System.out.println();
    System.out.println("Training For " + emp.getFirstName() + " " + emp.getLastName());
    System.out.println("-------------------------------------------------------------");
    for(int i = 0; i<v2.size(); i++){
      System.out.print(((EmployeeTraining)v2.elementAt(i)).getEmployeeTrainingID() + " " +
                        ((EmployeeTraining)v2.elementAt(i)).getEmployeeID() + " " +
                        ((EmployeeTraining)v2.elementAt(i)).getDate() + " " +
                        ((EmployeeTraining)v2.elementAt(i)).getTopic() + " " +
                        ((EmployeeTraining)v2.elementAt(i)).getResult());
    System.out.println();
    
    }

    
  } // end main
}
