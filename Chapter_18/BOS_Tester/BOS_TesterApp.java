/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class BOS_TesterApp {
  public static void main(String[] args){
    FileOutputStream fos;
    BufferedOutputStream bos;
    File file;
    try{
        file = new File("test.txt");
	fos = new FileOutputStream(file);
        bos = new BufferedOutputStream(fos); // default buffer size is 512 bytes
        while(file.length() == 0){
	 if(args.length != 0){
	   bos.write(args[0].getBytes());
	  }else{
		bos.write(("Ohhhh do you love Java like I love Java?").getBytes());
		}
         System.out.println("The length of the file Text.txt in bytes is: " + file.length());
        }
        fos.close();        
	}catch(Exception ignored){ }
  } // end main
} // end class