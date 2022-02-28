/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class BWTesterApp {
  public static void  main(String[] args){
    try{
        FileWriter fw = new FileWriter("test.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("This is a test of the BufferedWriter class.");
        bw.newLine();
        bw.write("It improves output efficiency by buffering individual disk writes.");
        bw.newLine();
        bw.write("You can specify the internal buffer size at the time of object creation.");
        bw.newLine();
        bw.write("...and it provides a newLine() method!");
	bw.flush();
        bw.close();
       }catch(Exception ignored){ }
  } // end main
} // end class