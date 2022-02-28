/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class FOS_TesterApp {
  public static void main(String[] args){
    FileOutputStream fos;
    File file;
    try{
	//fos = new FileOutputStream("Test.txt", true);
         fos = new FileOutputStream("Test.txt");
	 if(args.length != 0){
	   fos.write(args[0].getBytes());
	  }else{
		fos.write(("Ohhhh do you love Java like I love Java?").getBytes());
		}
          fos.close();
          file = new File("test.txt");
          System.out.println("The length of the file Text.txt in bytes is: " + file.length());
	}catch(Exception ignored){ }
  } // end main
} // end class