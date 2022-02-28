/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class PeopleListApp {
  public static void main(String[] args){
    List list = new LinkedList();

    list.add(new Person("Steven", "Jay","Jones", 1950, 8, 30, Person.MALE));
    list.add(new Person("Rick", "W","Miller", 1963, 9, 22, Person.MALE));
    list.add(new Person("Lori", "Lee","Smith", 1986, 1, 19, Person.MALE));
    list.add(new Person("Jay", "Stirling","Johnson", 1947, 2, 02, Person.MALE));
    list.add(new Person("Ariel", "Beau","Green", 1990, 3, 07, Person.MALE));

    for(Iterator i = list.iterator(); i.hasNext();){
      System.out.println(((Person)i.next()).getFullName());
    }
  }// end main()
} // end PeopleListApp class definition
