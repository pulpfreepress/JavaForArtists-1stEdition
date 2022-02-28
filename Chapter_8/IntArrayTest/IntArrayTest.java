/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class IntArrayTest {
  public static void main(String[] args){
     int[] int_array = new int[10];
     for(int i=0; i<int_array.length; i++){
        System.out.print(int_array[i] + " ");
     }
     System.out.println();
     for(int i=0; i<int_array.length; i++){
        int_array[i] = i;
        System.out.print(int_array[i] + " ");
     }    
     System.out.println();

     /***** Calling Object & Class Methods *****/
     System.out.println(int_array.getClass().getName());
     System.out.println(int_array.getClass().getSuperclass());
     System.out.println(int_array.getClass().isArray());
     System.out.println(int_array.getClass().isPrimitive());
  }
}