/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.rmi.*;
import java.rmi.server.*;

public class RobotRatFactory extends UnicastRemoteObject
                                           implements RobotRatFactoryInterface {

   public RobotRatFactory() throws RemoteException {
    System.out.println("RobotRatFactoryImplementation object created!");
   }

  public RobotRatInterface getRobotRat() throws RemoteException {
    RobotRatInterface new_rat = null;
    try{
       new_rat = new RobotRat();
    }catch(RemoteException re){
      System.out.println("getRobotRat(): problem creating new RobotRat object!");
      re.printStackTrace();
     }
    return new_rat;
  }
}// end RobotRatFactory class definition
