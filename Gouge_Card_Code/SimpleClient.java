/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.net.*;

public class SimpleClient{

 public static void main(String[] args){
 try{
   
    Socket s = new Socket("127.0.0.1",5557);
    InputStream is = s.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);

    OutputStream os = s.getOutputStream();
    PrintWriter pw =new PrintWriter(os, true);
    InputStreamReader console_reader;

    console_reader = new InputStreamReader(System.in);
    BufferedReader console;
    console = new BufferedReader(console_reader);
    String console_input;
    System.out.println("Ready to write stuff!");
    while((console_input = console.readLine()) != null){
         pw.println(console_input);
         System.out.println(br.readLine());
    }
   s.close();
   }catch(IOException e){}
 }
}