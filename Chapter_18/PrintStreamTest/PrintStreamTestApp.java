/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class PrintStreamTestApp {
  public static void main(String[] args){
    try{
        PrintStream ps = new PrintStream(new FileOutputStream("Output.txt")); // print String literal
        ps.println("This file created with a PrintStream object!");
        ps.println(343);    // print integer literal
        ps.println(2.111);  // print float literal
        ps.println(false);  // print boolean literal
        ps.println(new Person("Rick", "W", "Miller", "Male")); // print Object string
        ps.close();
       }catch(Exception ignored){}
  }// end main
}// end class