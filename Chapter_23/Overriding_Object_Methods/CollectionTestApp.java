/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class CollectionTestApp {
  public static void main(String[] args){
    List list = new ArrayList();
    
    list.add(new Person("Rick", "W", "Miller", 1963, 5, 6, Person.MALE));
    list.add(new Person("Debbie", "S", "Sears", 1986, 8, 3, Person.FEMALE));
    list.add(new Person("John", "L", "Thompson", 1978, 1, 4, Person.MALE));
    list.add(new Person("Riddic", "H", "Bean", 2001, 11, 15, Person.MALE));
    list.add(new Person("Gloria", "J", "Albright", 1922, 12, 2, Person.FEMALE));
    list.add(new Person("Zena", "P", "Warrior", 1968, 1, 26, Person.FEMALE));
    list.add(new Person("Shelly", "H", "Marshall", 1993, 7, 15, Person.FEMALE));
    list.add(new Person("Jessica", "A", "Simpson", 1912, 6, 3, Person.FEMALE));
    list.add(new Person("Peter", "R", "Rabbit", 1999, 4, 30, Person.MALE));
    list.add(new Person("Mohamad", "A", "Abbas", 1961, 5, 29, Person.MALE));
    list.add(new Person("Sapna", "P", "Gupta", 1988, 8, 11, Person.FEMALE));
    list.add(new Person("Marvin", "C", "Williams", 1945, 2, 18, Person.MALE));
    list.add(new Person("Kyle", "V", "Miller", 1954, 9, 13, Person.MALE));
    list.add(new Person("Joseph", "L", "Smith", 1963, 10, 23, Person.MALE));
    list.add(new Person("Nora", "G", "Jones", 1977, 11, 4, Person.FEMALE));
    list.add(new Person("Hedy", "E", "Lamarr", 1914, 2, 28, Person.FEMALE));
    
    for(Iterator i = list.iterator(); i.hasNext();){
       Person p = (Person)i.next();
       System.out.println(p.toString() + " " + p.getAge());
    }
    
    Collections.sort(list, new PersonAgeComparator());
    
    System.out.println("--------------Sorted List--------------------");
    for(Iterator i = list.iterator(); i.hasNext();){
       Person p = (Person)i.next();
       System.out.println(p.toString() + " " + p.getAge());
    }
  }
} // end CollectionTestApp
