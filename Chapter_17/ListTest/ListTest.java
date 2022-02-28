/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class ListTest {
  public static void main(String[] args){
	List list = new ArrayList();
	for(int i=0; i<100; i++){
	  list.add(new Integer(i%50));
	}

	for(Iterator i=list.iterator(); i.hasNext();){
      System.out.print(i.next().toString() + ", ");
    }

    System.out.println("\n\n");

    for(ListIterator li = list.listIterator(list.size()); li.hasPrevious();){
      System.out.print(li.previous() + ", ");
    }

    System.out.println("\n\n");

    Collections.shuffle(list);

    for(ListIterator li = list.listIterator(list.size()); li.hasPrevious();){
	      System.out.print(li.previous() + ", ");
    }

    System.out.println("\n\n");

  } // end main() method
} // end ListTest class definition