/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.net.*;
import java.io.*;

public class URLTestApplication {
  public static void main(String[] args){
    try{
       URL url = new URL("http://www.warrenworks.com/ITP_120/SampleText.txt");
       DataInputStream dsr = new DataInputStream(url.openStream());
       String s;
       while((s = dsr.readLine()) != null){
         System.out.println(s); 
       }
     }catch(Exception e){
        e.printStackTrace();
     }
  }// end main
}
