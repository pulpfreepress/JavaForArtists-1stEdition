/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class OSWTesterApp {
  public static void  main(String[] args){
    try{
        FileOutputStream fos = new FileOutputStream("test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("Ohhhh do you love Java like I love Java?");
        bw.newLine();
        bw.write("The OutputStreamWriter needs a FileOutputStream object...");
        bw.newLine();
        bw.write("...and can be used with a BufferedWriter to improve output efficiency.");
        bw.newLine();
        bw.write("...and it's fun to use!");
	bw.flush();
        bw.close();
       }catch(Exception ignored){ }
  } // end main
} // end class