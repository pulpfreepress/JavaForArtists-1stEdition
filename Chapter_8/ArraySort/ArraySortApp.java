/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class ArraySortApp {
  public static void main(String[] args){
   int[] int_array = {100, 45, 9, 1, 34, 22, 6, 4, 3, 2, 99, 66};

   for(int i=0; i<int_array.length; i++){
    System.out.print(int_array[i] + " ");
   }   
   System.out.println();

   Arrays.sort(int_array);

   for(int i=0; i<int_array.length; i++){
    System.out.print(int_array[i] + " ");
   }
   System.out.println();
  } // end main() method
} // end ArraySortApp class definition
