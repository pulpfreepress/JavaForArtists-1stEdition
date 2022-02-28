/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class DOS_TesterApp {
  public static void main(String[] args){
    FileOutputStream fos;
    BufferedOutputStream bos;
    DataOutputStream dos;
    File file;
    try{
        file = new File("test.txt");
	fos = new FileOutputStream(file);
        bos = new BufferedOutputStream(fos); // default buffer size is 512 bytes
        dos = new DataOutputStream(bos); 
        while(file.length() == 0){
	 if(args.length != 0){
	   dos.writeBytes(args[0]);
	  }else{
		dos.writeBytes("Ohhhh do you love Java like I love Java?");
		}
         System.out.println("The length of the file Text.txt in bytes is: " + file.length());
        }
        fos.close();        
	}catch(Exception ignored){ }
  } // end main
} // end class