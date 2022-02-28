/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class BRTesterApp {
  public static void main(String[] args){
   try{
       File file = new File("test.txt");
       FileInputStream fis = new FileInputStream(file);
       InputStreamReader isr = new InputStreamReader(fis);
       BufferedReader br = new BufferedReader(isr);
       char[] char_buffer = new char[(int)file.length()];
       br.read(char_buffer);

       for(int i = 0; i<char_buffer.length; i++){
         System.out.print(char_buffer[i]);
       }
   
       br.close();
      }catch(Exception ignored){ }
  } // end main
} // end class