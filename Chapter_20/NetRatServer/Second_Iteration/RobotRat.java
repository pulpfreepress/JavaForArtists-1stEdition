/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import javax.swing.*;
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class RobotRat extends UnicastRemoteObject implements RobotRatInterface {

  private static JFrame _frame = null;
  private static Floor _floor = null;
  private static Vector _rats = null;
  private Rat _its_rat = null;
  
  static {
    _rats  = new Vector();
    _floor = new Floor(_rats);
    _frame = new JFrame("Rat Movement Floor");
    _frame.getContentPane().add(_floor);
    _frame.setSize(300, 300);
    _frame.setLocation(200, 200);
    _frame.show();
  }
  

  public RobotRat() throws RemoteException {
    _its_rat = new Rat();
    _rats.addElement(_its_rat);
    _floor.repaint();
   }
  
  public void moveEast(){
    _its_rat.setX(_its_rat.getX() + 3);
    _floor.repaint();
  }
  
  public void moveSouth(){
    _its_rat.setY(_its_rat.getY() + 3);
    _floor.repaint();
  }
  
  public void moveWest(){
    _its_rat.setX(_its_rat.getX() - 3);
    _floor.repaint();
  }
  
  public void moveNorth(){
    _its_rat.setY(_its_rat.getY() - 3);
    _floor.repaint();
  }
  
  public void moveNorthWest(){
    _its_rat.setY(_its_rat.getY() - 3);
    _its_rat.setX(_its_rat.getX() - 3);
    _floor.repaint();
  }
  
  public void moveSouthWest(){
    _its_rat.setY(_its_rat.getY() + 3);
    _its_rat.setX(_its_rat.getX() - 3);
    _floor.repaint();
  }
  
  public void moveNorthEast(){
     _its_rat.setY(_its_rat.getY() - 3);
     _its_rat.setX(_its_rat.getX() + 3);
     _floor.repaint();
  }
  
  public void moveSouthEast(){
    _its_rat.setY(_its_rat.getY() + 3);
    _its_rat.setX(_its_rat.getX() + 3);
    _floor.repaint();
  }
} // end RobotRat class definition
