/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.rmi.*;

interface RobotRatInterface extends Remote {

  public void moveEast() throws RemoteException;
  public void moveSouth() throws RemoteException;
  public void moveWest() throws RemoteException;
  public void moveNorth() throws RemoteException;
  public void moveNorthWest() throws RemoteException;
  public void moveSouthWest() throws RemoteException;
  public void moveNorthEast() throws RemoteException;
  public void moveSouthEast() throws RemoteException;

}
