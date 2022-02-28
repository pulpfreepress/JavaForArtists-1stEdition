/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class ArrayLiterals {
  public static void main(String[] args){
    int[] int_array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    double[] double_array = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};

    for(int i = 0; i < int_array.length; i++){
       System.out.print(int_array[i] + " ");
    }
    System.out.println();
    System.out.println(int_array.getClass().getName());
    System.out.println(int_array.getClass().isArray());
 
    System.out.println();
   
    for(int i = 0; i < double_array.length; i++){
       System.out.print(double_array[i] + " ");
    }
    System.out.println();
    System.out.println(double_array.getClass().getName());
    System.out.println(double_array.getClass().isArray());
  }
}