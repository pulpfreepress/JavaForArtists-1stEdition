/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class MultiArrays {
  public static void main(String[] args){
     int rows = Integer.parseInt(args[0]);
     int cols = Integer.parseInt(args[1]);

     int[][] int_2d_array = new int[rows][cols];

     System.out.println(int_2d_array.getClass());

     for(int i = 0; i<int_2d_array.length; i++){
       for(int  j = 0; j<int_2d_array[i].length; j++){
        System.out.print(int_2d_array[i][j]);
       }
        System.out.println();
     }
  }
}