/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class BIS_TesterApp {
  public static void main(String[] args){
    try{
       File file = new File("Test.txt");
       FileInputStream fis = new FileInputStream(file);
       BufferedInputStream bis = new BufferedInputStream(fis);
       byte[] b = new byte[(int)file.length()]; 
       bis.read(b);
   
       for(int i = 0; i<b.length; i++){
         System.out.print(b[i]);           // print each byte
       }
       
       System.out.println();

       for(int i = 0; i<b.length; i++){
         System.out.print((char)b[i]);     // cast to char then print
       }
   
       System.out.println();

       bis.close();
     }catch(Exception ignored){ }
  } // end main
} // end class