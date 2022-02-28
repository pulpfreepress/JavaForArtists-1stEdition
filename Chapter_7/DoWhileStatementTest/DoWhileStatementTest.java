/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class DoWhileStatementTest {
  public static void main(String[] args){
    int int_i = 0;

    do {
       System.out.println("The value of int_i = " + int_i);
       int_i++;
       }while(int_i < 10);
  }
}