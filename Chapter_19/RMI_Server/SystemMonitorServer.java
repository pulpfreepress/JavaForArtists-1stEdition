/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.rmi.*;
import java.rmi.registry.*;

public class SystemMonitorServer {
  public static void main(String[] args){
    try{
    System.out.println("Creating RemoteSystemMonitorObject...");
    RemoteSystemMonitorInterface remote_object = new RemoteSystemMonitorImplementation();
    System.out.println("Starting Registry on port 1099...");
    LocateRegistry.createRegistry(1099);
    System.out.println("Registry started on port 1099");
    System.out.println("Binding Remote_System_Monitor service name to remote_object...");
    Naming.bind("Remote_System_Monitor", remote_object);
    System.out.println("Bind successful...");
    System.out.println("Ready for remote method invocations...");
        
    }catch(Exception e){
      System.out.println("Problem creating remote object!");
      e.printStackTrace();
    }
  }
}
