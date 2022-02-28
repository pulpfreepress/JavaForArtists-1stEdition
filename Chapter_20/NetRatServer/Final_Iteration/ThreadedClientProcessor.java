/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.net.*;

public class ThreadedClientProcessor extends Thread {

    private Socket                 _socket    = null;
    private DataInputStream        _dis       = null;
    private DataOutputStream       _dos       = null;
    private RobotRatInterface      _robot_rat = null;   

    private static final int NORTH      = 0;
    private static final int NORTH_EAST = 1;
    private static final int EAST       = 2;
    private static final int SOUTH_EAST = 3;
    private static final int SOUTH      = 4;
    private static final int SOUTH_WEST = 5;
    private static final int WEST       = 6;
    private static final int NORTH_WEST = 7;


   public ThreadedClientProcessor(Socket socket){
     _socket = socket;
     try{
      _dos = new DataOutputStream(_socket.getOutputStream());
      _dis = new DataInputStream(_socket.getInputStream());
      _robot_rat = new RobotRat();
     }catch(Exception e){
        System.out.println("ThreadedClientProcessor: Problem creating IOStream objects!");

        e.printStackTrace();
     }
   }// end constructor


  public void run(){
    int command = 0;
    try{
      while((command = _dis.readInt()) != -1){
        switch(command){
          case NORTH       : _robot_rat.moveNorth();
                             _dos.writeUTF("Rat moved North");
                             break;
          case NORTH_EAST  : _robot_rat.moveNorthEast();
                             _dos.writeUTF("Rat moved North-East");
                             break;
          case EAST        : _robot_rat.moveEast();
                             _dos.writeUTF("Rat moved East"); 
                             break;
          case SOUTH_EAST  : _robot_rat.moveSouthEast();
                             _dos.writeUTF("Rat moved South-East");
                             break;
          case SOUTH       : _robot_rat.moveSouth();
                             _dos.writeUTF("Rat moved South");
                             break;
          case SOUTH_WEST  : _robot_rat.moveSouthWest();
                             _dos.writeUTF("Rat moved South-West");
                             break;
          case WEST        : _robot_rat.moveWest();
                             _dos.writeUTF("Rat moved West");
                             break;
          case NORTH_WEST  : _robot_rat.moveNorthWest();
                             _dos.writeUTF("Rat moved North-West");
                             break;
          default          : _dos.writeUTF("Invalid command"); 


        }// end switch
      }// end while
    }catch(EOFException ignored){ }
    catch(Exception e){
      e.printStackTrace();
     }
     finally{
       try{
       _socket.close();
        }catch(Exception ignored){ }
     }
     
     try{
       _socket.close();
        }catch(Exception ignored){ }
  } // end run()
}// end ThreadedClientProcessor class definition
