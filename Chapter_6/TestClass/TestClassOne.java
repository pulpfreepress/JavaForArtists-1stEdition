/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class TestClassOne {

  public static void main(String[] args){
    int int_variable_1 = Integer.parseInt(args[0]);
    int int_variable_2 = Integer.parseInt(args[1]);
    int int_variable_3 = Integer.parseInt(args[2]);       

    int total = int_variable_1 + int_variable_2 + int_variable_3;

    System.out.println(total);
    
  }
}