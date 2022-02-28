/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class GenericTest {

  public static <T> void listArrayElements(T[] a){
     for(T o : a){
       System.out.println(o);
     }
     System.out.println();
  }

  public static void main(String[] args){
    Integer[] int_array = new Integer[10];
    for(int i=0; i<int_array.length; i++){
	  int_array[i] = i;
	}

    GenericTest.listArrayElements(int_array);

    Person[] person_array = new Person[5];

    person_array[0] = new Person("Rick", "W", "Miller", 1966, 8, 28, Person.MALE);
    person_array[1] = new Person("Steve", "J", "Jones", 1986, 2, 10, Person.MALE);
    person_array[2] = new Person("Howard", "Josephus", "Stern", 1972, 5, 5, Person.MALE);
    person_array[3] = new Person("Sally", "Sue", "Smith", 1987, 7, 2, Person.FEMALE);
    person_array[4] = new Person("Karen", "H", "Stevens", 1977, 3, 18, Person.FEMALE);

    GenericTest.listArrayElements(person_array);

  }// end main()
}// end GenericTest class definition