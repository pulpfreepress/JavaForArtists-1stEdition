/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import javax.swing.*;
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import java.awt.*;

public class RobotRat extends UnicastRemoteObject implements RobotRatInterface {

  /* ***********************************
      static variables
  **************************************/
  private static JFrame _frame = null;
  private static Floor _floor = null;
  private static Vector _rats = null;
  private static int _frame_height;
  private static int _frame_width;
  private static int _frame_x_position;
  private static int _frame_y_position;
  private static NetRatServerProperties _properties = null;
  
  /* ***********************************
      instance variables
  **************************************/
  private Rat _its_rat = null;
  private int _step_size;

  
  static {
    _properties = NetRatServerProperties.getInstance();
    _rats  = new Vector();
    _floor = new Floor(_rats);
    _frame = new JFrame("Rat Movement Floor");
    _frame.getContentPane().add(_floor);
    _frame_height = Integer.parseInt(_properties.getProperty(NetRatServerProperties.DEFAULT_FRAME_HEIGHT));
    _frame_width  = Integer.parseInt(_properties.getProperty(NetRatServerProperties.DEFAULT_FRAME_WIDTH));
    _frame.setSize(_frame_height, _frame_width);
    _frame_x_position = Integer.parseInt(_properties.getProperty(NetRatServerProperties.DEFAULT_FRAME_X_POSITION));
    _frame_y_position = Integer.parseInt(_properties.getProperty(NetRatServerProperties.DEFAULT_FRAME_Y_POSITION));
    _frame.setLocation(_frame_x_position, _frame_y_position);
    _frame.show();
  }
  

  public RobotRat() throws RemoteException {
    _its_rat = new Rat();
    _rats.addElement(_its_rat);
    _step_size = Integer.parseInt(_properties.getProperty(NetRatServerProperties.DEFAULT_STEP_SIZE));
    _floor.repaint();
   }
   
  protected void finalize() throws Throwable {
    System.out.println("RobotRat finalize() called!");
    if(_its_rat != null){
       _rats.removeElement(_its_rat);
       _its_rat = null;
     }
   }
  
  public void moveEast(){
    _its_rat.setX(_its_rat.getX() + _step_size);
    _floor.repaint();
  }
  
  public void moveSouth(){
    _its_rat.setY(_its_rat.getY() + _step_size);
    _floor.repaint();
  }
  
  public void moveWest(){
    _its_rat.setX(_its_rat.getX() - _step_size);
    _floor.repaint();
  }
  
  public void moveNorth(){
    _its_rat.setY(_its_rat.getY() - _step_size);
    _floor.repaint();
  }
  
  public void moveNorthWest(){
    _its_rat.setY(_its_rat.getY() - _step_size);
    _its_rat.setX(_its_rat.getX() - _step_size);
    _floor.repaint();
  }
  
  public void moveSouthWest(){
    _its_rat.setY(_its_rat.getY() + _step_size);
    _its_rat.setX(_its_rat.getX() - _step_size);
    _floor.repaint();
  }
  
  public void moveNorthEast(){
     _its_rat.setY(_its_rat.getY() - _step_size);
     _its_rat.setX(_its_rat.getX() + _step_size);
     _floor.repaint();
  }
  
  public void moveSouthEast(){
    _its_rat.setY(_its_rat.getY() + _step_size);
    _its_rat.setX(_its_rat.getX() + _step_size);
    _floor.repaint();
  }
} // end RobotRat class definition
