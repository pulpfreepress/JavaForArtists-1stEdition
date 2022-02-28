/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class NestedForLoop {
  public static void main(String[] args){
     int limit_i = Integer.parseInt(args[0]);
     int limit_j = Integer.parseInt(args[1]);
     int total = 0;

     for(int i = 1; i <= limit_i; i++){
       for(int j = 1; j <= limit_j; j++){
          total += (i*j);
        }
     }
     System.out.println("The total is: " + total);
  }
}