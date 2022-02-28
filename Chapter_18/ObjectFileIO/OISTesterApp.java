/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.util.*;

public class OISTesterApp {
  public static void main(String[] args){
     Vector<Person> people_vector = null;

     try{
	 FileInputStream   fis = new FileInputStream("People.dat");
	 ObjectInputStream ois = new ObjectInputStream(fis);
         people_vector = (Vector<Person>) ois.readObject();

         for(int i = 0; i<5; i++){
	   System.out.println(people_vector.elementAt(i).toString());
	 }

        ois.close();
     }catch(Exception e){System.out.println(e.getMessage()); }
  }
}