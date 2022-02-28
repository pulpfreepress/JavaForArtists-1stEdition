/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class MessageArray {
  public static void main(String[] args){
     BufferedReader console = new BufferedReader(new InputStreamReader(System.in));    
     String name = null; 
     int int_val = 0;

     String[] messages = {"Welcome to the Message Array Program",
			  "Please enter your name: ",
                          ", please enter an integer: ",
			  "You did not enter an integer!",
			  "Thank you for running the Message Array program",
                          "Console read error!"};

     final int WELCOME_MESSAGE     = 0;
     final int ENTER_NAME_MESSAGE  = 1;
     final int ENTER_INT_MESSAGE   = 2;
     final int INT_ERROR           = 3;
     final int THANK_YOU_MESSAGE   = 4;
     final int CONSOLE_READ_ERROR  = 5;

    System.out.println(messages[WELCOME_MESSAGE]);
    System.out.print(messages[ENTER_NAME_MESSAGE]);
    try{
        name = console.readLine();
       }catch(Exception e){ System.out.println(messages[CONSOLE_READ_ERROR]); }

    System.out.print(name + messages[ENTER_INT_MESSAGE]);

    try{
        int_val = Integer.parseInt(console.readLine());
       }catch(NumberFormatException nfe) { System.out.println(messages[INT_ERROR]); }
        catch(IOException ioe) { System.out.println(messages[CONSOLE_READ_ERROR]); }

    System.out.println(messages[THANK_YOU_MESSAGE]);            
  }
}