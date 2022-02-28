/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class SetTestApp {
  public static void main(String[] args){
    List list = new LinkedList();

    for(int i=0; i<100; i++){
      list.add(new Integer(i%10));
    }
  
    System.out.print("List Contents: "); 
    for(Iterator i = list.iterator(); i.hasNext();){
      System.out.print(i.next().toString());
    }
    System.out.println();

    Set set = new TreeSet(list);
    System.out.print("Set Contents: ");
    for(Iterator i = set.iterator(); i.hasNext();){
      System.out.print(i.next().toString());
    }  
    System.out.println();

  } // end main()
} // end SetTestApp class definition
