/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;

public class NetRatServer extends JFrame implements ActionListener {

  private JButton button1 = null;
  private RobotRatInterface _r1 = null;
  private RobotRatInterface _r2 = null;
  
  public NetRatServer(){
    try{
    _r1 = new RobotRat();
    _r2 = new RobotRat();
    }catch(Exception ignored){ ignored.printStackTrace(); }
    button1 =  new JButton("move");
    button1.addActionListener(this);
    this.getContentPane().add(button1);
    this.setSize(100, 100);
    this.setLocation(300, 300);
    this.show();
  }
  
  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("move")){
      try{
      _r1.moveEast();
      _r2.moveSouthEast();
      }catch(Exception ignored){ }
    }
  }
  
  public static void main(String[] args){
    System.out.println("NetRatServer Lives!!");
    new NetRatServer();
    try{
    System.out.println("Starting registry...");
    LocateRegistry.createRegistry(1099);
    System.out.println("Registry started on port 1099.");
    System.out.println("Binding service name to remote object...");
    Naming.bind("Robot_Rat_Factory", new RobotRatFactory());
    System.out.println("Bind successful.");
    System.out.println("Ready for remote method invocation.");
    
    System.out.println("Creating ServerSocket Object...");
    ServerSocket server_socket = new ServerSocket(5001);
    System.out.println("ServerSocket object created successfully!");
    while(true){
      System.out.println("Listening for incoming client connections...");
      Socket socket = server_socket.accept();
      System.out.println("Incoming client connection detected.");
      System.out.println("Creating ThreadedClientProcessor object...");
      ThreadedClientProcessor client_processor = new ThreadedClientProcessor(socket);
      System.out.println("ThreadedClientProcessor object created.");
      System.out.println("Calling start() method...");
      client_processor.start();
     }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}// end NetRatServer class
