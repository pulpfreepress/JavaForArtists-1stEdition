/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.rmi.*;

public class SystemMonitorClient {
  public static void main(String[] args){
    try{
       RemoteSystemMonitorInterface remote_system_monitor = (RemoteSystemMonitorInterface)
                                                            Naming.lookup("rmi://" + args[0] + "/Remote_System_Monitor");
       String[] specs = remote_system_monitor.getSystemSpecs();
       for(int i = 0; i<specs.length; i++){
         System.out.println(specs[i]);
       }
    }catch(ArrayIndexOutOfBoundsException iae){
      System.out.println("Usage: java SystemMonitorClient <hostname | hostIP>");
     }
     catch(Exception e){
       e.printStackTrace();
     }
  }
}
