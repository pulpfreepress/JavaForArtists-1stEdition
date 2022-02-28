/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.security.*;

public class ServerThread extends Thread {

  private ServerSocket _server_socket = null;
  private JTextArea    _textarea      = null;
  
  public ServerThread(JTextArea text_area){
     _textarea = text_area;
     try{
       _server_socket = new ServerSocket(5001);
       }catch(Exception e){
         e.printStackTrace();
      }
  }// end constructor

  public void run(){
    while(true){
     try{
        Socket socket = _server_socket.accept();
        ClientProcessorThread cpt = new ClientProcessorThread(socket, _textarea);
        cpt.start();
        }catch(AccessControlException ace){
          _textarea.append("Unauthorized network access detected.\n");
        }
        catch(Exception e){
           e.printStackTrace();
         }
   }//end while
  }// end run() method
}// end class definition
