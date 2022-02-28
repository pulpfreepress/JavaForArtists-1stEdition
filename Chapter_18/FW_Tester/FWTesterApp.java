/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class FWTesterApp {
  public static void  main(String[] args){
    try{
        FileWriter fw = new FileWriter("test.txt");
        fw.write("This is a test of the FileWriter class.\n");
        fw.write("It inherits its functionality from OutputStreamWriter.\n");
	fw.write("You can overwrite the contents of a file...\n");
        fw.write("...or you can append text to the end of a file.");
        fw.close();
       }catch(Exception ignored){ }
  } // end main
} // end class