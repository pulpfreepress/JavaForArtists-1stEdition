/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class StreamReaderTestApp {

  public static void main(String[] args){

    FileOutputStream fos;
    FileInputStream  fis;
    FileWriter       fw;
    FileReader       fr;
   
    String s = "I Love Java 1 2 3! Sing with me 123!";

    try{
       fos = new FileOutputStream("fos_test");
       fos.write(s.getBytes());
       fos.write(1);
       fos.write(2);
       fos.write(3);
       fos.close();

       fis = new FileInputStream("fos_test");
       int c;
       while((c = fis.read()) != -1){
        System.out.print(c);
       }
       System.out.println();

       fw = new FileWriter("fw_test");
       fw.write(s.toCharArray());
       fw.write('1');
       fw.write('2');
       fw.write('3');
       fw.close();
   
       fr = new  FileReader("fos_test");
        while((c = fr.read()) != -1){
         System.out.print(c);
       }
       fr.close();
       System.out.println();
       
       fr = new  FileReader("fw_test");
        while((c = fr.read()) != -1){
         System.out.print(c);
       }
       fr.close();
       System.out.println();

  
      

      }catch(Exception e){ }

  }
}