/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class ArrayTestApp {
  public static void main(String[] args){
    List da = new ArrayList();
    System.out.println("Array size is: " + da.size());
    da.add(new String("Ohhh if you loved Java like I love Java!!"));
    System.out.println(da.get(0).toString());
    for(int i = 1; i<26; i++){
      da.add(new Integer(i));
    }
    System.out.println("Array size is: " + da.size());
    for(int i=0; i<da.size(); i++){
       if(da.get(i) != null){
	 System.out.print(da.get(i).toString() + ", ");
	  }
    }
    System.out.println();
  }//end main() method
}// end ArrayTestApp class definition
