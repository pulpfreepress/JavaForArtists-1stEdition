/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class SetTestApp {
  public static void main(String[] args){
    List<Integer> list = new LinkedList<Integer>();

    for(int i=0; i<50; i++){
      list.add(i % 10);
    }

    System.out.print("List contents: ");
    for(Iterator i = list.iterator(); i.hasNext();){
      System.out.print(i.next());
    }
    System.out.println();

    Set<Integer> set = new TreeSet<Integer>(list);
    System.out.print("Set contents: ");
    for(Iterator i = set.iterator(); i.hasNext();){
      System.out.print(i.next());
    }
    System.out.print("\nSet contents using for-each loop: ");

    for(Integer i : set){
      System.out.print(i);
    }
  } // end main()
} // end SetTestApp class definition