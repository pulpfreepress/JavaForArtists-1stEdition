/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class CombinationOpTest {
  public static void main(String[] args){
    int int_i = 0;
    int int_j = 1;
    int int_k = 2;

    int_i += int_j;   // same as int_i = int_i + int_j 
    System.out.println(int_i);

    int_i *= (int_k *= int_k);
    System.out.println(int_i);

    int_i /= int_k;
    System.out.println(int_i);
  }
}