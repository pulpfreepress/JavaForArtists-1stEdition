/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.util.*;

public class OOSTesterApp {
	public static void main(String[] args){
      Vector<Person> people_vector = new Vector<Person>();
      people_vector.add(new Person("Rick", "W", "Miller", "Male"));
      people_vector.add(new Person("Steve", "J", "Jones", "Male"));
      people_vector.add(new Person("Elwood", "S", "Crick", "Male"));
      people_vector.add(new Person("Johnny", "Wad", "Borders", "Male"));
      people_vector.add(new Person("Michael", "L", "Morrison", "Male"));

      for(int i = 0; i<5; i++){
		System.out.println(people_vector.elementAt(i).toString());
	 }

      FileOutputStream fos;
      ObjectOutputStream oos;

      try{
		 fos = new FileOutputStream("People.dat");
         oos = new ObjectOutputStream(fos);
         oos.writeObject(people_vector);
         fos.close();


	  }catch(Exception ignored){}



  }//end main
}//end class