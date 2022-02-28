/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.rmi.*;
import java.rmi.server.*;

public class RemoteSystemMonitorImplementation extends UnicastRemoteObject 
                                               implements RemoteSystemMonitorInterface {

  public RemoteSystemMonitorImplementation()throws RemoteException{
    System.out.println("RemoteSystemMonitorImplementation object created!");
  }

  public String[] getSystemSpecs(){
    String[] specs = { System.getProperty("user.name"),
                       System.getProperty("user.home"),
                       System.getProperty("user.dir"),
                       System.getProperty("os.name"),
                       System.getProperty("os.arch"),
                       System.getProperty("java.version"),
                       System.getProperty("java.vendor"),
                       System.getProperty("java.vendor.url"),
                       System.getProperty("java.vm.name"),
                       System.getProperty("java.vm.version") };
    return specs;
  }
}
