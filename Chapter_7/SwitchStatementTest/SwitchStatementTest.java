/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class SwitchStatementTest {
  public static void main(String[] args){
    int int_i = Integer.parseInt(args[0]);
    String[] string_array = {"one", "two", "three", "four", "five"};
   
    switch(int_i){
      case 1 :        
      case 2 :        
      case 3 :      
      case 4 :         
      case 5 : System.out.println("You entered " + string_array[int_i - 1]);
               break;
      default: System.out.println("Please enter a value between 1 and 5");
    }
  }
}