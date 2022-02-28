/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class OperatorTest {

  public static void main(String[] args){
   int some_variable = 7*8/3+22-38;
   System.out.println(some_variable);
   some_variable = 7*(8/(3+(22-38)));
    System.out.println(some_variable);

    some_variable = 23 % 3;
    System.out.println(some_variable);

  }



}