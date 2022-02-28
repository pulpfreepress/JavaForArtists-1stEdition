/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.dbserver;

import java.rmi.*;
import java.util.*;
import com.pulpfreepress.business_objects.*;

public interface PersisterInterface extends Remote {
   public Vector queryByLastName(String last_name) throws RemoteException;
   public void addNewEmployee(Employee emp) throws RemoteException;
   public void addTrainingRecord(EmployeeTraining et) throws RemoteException;
   public Employee getEmployeeTrainingRecords(Employee emp) throws RemoteException;
}
