/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class OutputStreamTestApp {
  
public static void main(String[] args){
   try{ 
       FileOutputStream fos = new FileOutputStream("Test");
       OutputStreamWriter osw = new OutputStreamWriter(fos);
       char[] c = {'1', '2', '3', '4', '5', 'a', 'b', 'c', 'd', '\n', 'e', 'f', 'g', 'h'};
       osw.write(c, 0, c.length);
       osw.flush();
       osw.close();

      }catch(Exception e){ } 
  }

}