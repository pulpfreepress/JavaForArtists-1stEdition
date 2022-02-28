/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.net.*;
import java.io.*;

public class SimpleServer {
  public static void main(String[] args){
    try{
    System.out.println("Creating ServerSocket object binding to port 5001...");
    ServerSocket server_socket = new ServerSocket(5001);
    boolean keep_going = true;
    while(keep_going){
      System.out.println("Listening for incoming client connections on port 5001...");
      Socket socket = server_socket.accept();
      System.out.println("Incoming client connection detected...");
      System.out.println("Creating Input- and OutputStream objects...");
      
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      
      String input_string = "Ready";
      System.out.println("Processing client String input...");
      try{
        while((input_string = dis.readUTF()) != null){
          System.out.println(input_string);
          dos.writeUTF("Echo from server: " + input_string);
        
          if(input_string.equals("disconnect client")){
            System.out.println("Client disconnected...");
            socket.close();
            break;
            }else if(input_string.equals("shutdown server")){
               socket.close();
               keep_going = false;
               break;
              }
           } // end inner while loop
       }catch(EOFException ignored){ }
      catch(Exception e1){
         e1.printStackTrace();
       }
     } // end outer while loop
     System.out.println("Shutting down server...");
    }catch(Exception e){
      e.printStackTrace();
     }
  } // end main() 
}// end SimpleServer class definition
