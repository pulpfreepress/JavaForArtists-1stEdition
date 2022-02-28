/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.dbserver;

import com.pulpfreepress.utils.*;
import java.rmi.*;
import java.rmi.registry.*;

public class DBServerApp {
  public static void main(String[] args){
    DBServerProperties props = DBServerProperties.getInstance();
    try{
       System.out.println("Starting registry...");
       LocateRegistry.createRegistry(Integer.parseInt(props.getProperty(props.DEFAULT_RMI_PORT)));
       System.out.println("Registry started on port " + props.getProperty(props.DEFAULT_RMI_PORT));
       System.out.println("Binding Persister service name with Persister instance...");
       Naming.bind(props.getProperty(props.DEFAULT_EMPLOYEE_PERSISTER_SERVICE), new Persister());
       System.out.println("Bind successful.");
       System.out.println("Ready for remote method invocation.");
    }catch(Exception e){
      e.printStackTrace();
    }
  } // end main() method
} // end DBServerApp class definition
