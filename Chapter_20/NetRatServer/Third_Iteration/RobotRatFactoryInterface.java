/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

import java.rmi.*;

interface RobotRatFactoryInterface extends Remote {

 public RobotRatInterface getRobotRat() throws RemoteException;

}