/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.rmi.*;

interface RemoteCalculatorInterface extends Remote {
   public double add(double a, double b)  throws RemoteException;
   public double sub(double minuend, double subtrahend) throws RemoteException;
   public double div(double dividend, double divisor) throws RemoteException;
   public double mul(double multiplier, double multiplicand) throws RemoteException;
}

