/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;

public class NetRatServer {
  public static void main(String[] args){
    NetRatServerProperties properties = NetRatServerProperties.getInstance();
    System.out.println("NetRatServer Lives!!");
    try{
    Class.forName(properties.getProperty(NetRatServerProperties.DEFAULT_ROBOTRAT_CLASS_NAME));
    System.out.println("Starting registry...");
    LocateRegistry.createRegistry(Integer.parseInt(properties.getProperty(NetRatServerProperties.DEFAULT_RMI_PORT)));
    System.out.println("Registry started on port " + properties.getProperty(NetRatServerProperties.DEFAULT_RMI_PORT) + ".");
    System.out.println("Binding service name to remote object...");
    Naming.bind(properties.getProperty(NetRatServerProperties.DEFAULT_ROBOTRAT_FACTORY_SERVICE_NAME), new RobotRatFactory());
    System.out.println("Bind successful.");
    System.out.println("Ready for remote method invocation.");
    
    System.out.println("Creating ServerSocket Object...");
    ServerSocket server_socket = new ServerSocket(Integer.parseInt(properties.getProperty(NetRatServerProperties.DEFAULT_SOCKET_PORT)));
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
