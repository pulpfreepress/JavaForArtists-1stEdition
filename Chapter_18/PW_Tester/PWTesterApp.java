/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class PWTesterApp {
  public static void  main(String[] args){
    try{
        FileOutputStream fos = new FileOutputStream("test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println(123);                                        // print integer literal
        pw.println(true);                                       // print boolean literal
        pw.println(1.234);                                      // print double literal
        pw.println("Ohhhh I love Java!!");                      // print String literal
        pw.println(new Person("Rick", "W", "Miller", "Male"));  // print String representation of Object
	pw.flush();
        pw.close();
       }catch(Exception ignored){ }
  } // end main
} // end class