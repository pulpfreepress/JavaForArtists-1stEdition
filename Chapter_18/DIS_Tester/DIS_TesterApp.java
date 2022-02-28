/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class DIS_TesterApp {
  public static void main(String[] args){
   try{
       File file = new File("Output.txt");
       FileInputStream fis = new FileInputStream(file);
       DataInputStream dis = new DataInputStream(fis);
       
       String input = null;
       while((input = dis.readLine()) != null){  //readLine() method deprecated
          System.out.println(input);
        }
       dis.close();
      }catch(Exception ignored){ }  
  }// end main
}//end class