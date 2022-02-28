/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.net.*;

public class SimpleServer{

 public static void main(String[] args){
 try{
    ServerSocket ss = new ServerSocket(5557);
    Socket s = ss.accept();  //wait here for connect
    //when connected create reader and writer
    InputStream is = s.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);

    OutputStream os = s.getOutputStream();
    PrintWriter pw = new PrintWriter(os, true);
    //then service client requests
    String in_line;
    System.out.println("Ready to read stuff!");
    while((in_line = br.readLine()) != null ){
       	System.out.println("From Client: " + in_line);
        pw.println("From Server: " + in_line);
       }
   ss.close();
   s.close();
   }catch(IOException e){ e.toString();}
 }
}