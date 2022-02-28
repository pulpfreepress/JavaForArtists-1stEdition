/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClientProcessorThread extends Thread {

   private Socket _socket = null;
   private DataInputStream _dis = null;
   private DataOutputStream _dos = null;
   private JTextArea _textarea = null;

  public ClientProcessorThread(Socket socket, JTextArea text_area){
    _socket = socket;
    _textarea = text_area;
    try{
       _dos = new DataOutputStream(_socket.getOutputStream());
       _dis = new DataInputStream(_socket.getInputStream());
       }catch(Exception e){
         e.printStackTrace();
      }
  } // end constructor

  public void run(){
    try{
       String s = null;
       while((s=_dis.readUTF()) != null){
        System.out.println(s);
        _dos.writeUTF(s);
        _textarea.append(s + '\n');
       }
      }catch(Exception e){
        e.printStackTrace();
      }
      finally{
       try{
           _socket.close();
           _dis.close();
           _dos.close();
          }catch(Exception ignored){ }
      }
  } // end run() method
} // end ClientProcessorThread class definition
