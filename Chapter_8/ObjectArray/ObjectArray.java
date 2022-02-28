/*****************************************************************
  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press 
     
   This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.
*****************************************************************/

public class ObjectArray {
 public static void main(String[] args){
    Object[] object_array = new Object[10];

    object_array[0] = new Object();
    System.out.println(object_array[0].getClass());
    System.out.println(object_array[0].toString());
    System.out.println();
  
    object_array[1] = new Object();
    System.out.println(object_array[1].getClass());
    System.out.println(object_array[1].toString());
    System.out.println();

    for(int i = 2; i < object_array.length; i++){
        object_array[i] = new Object();
        System.out.println(object_array[i].getClass());
        System.out.println(object_array[i].toString());
        System.out.println();
    }
  }
}