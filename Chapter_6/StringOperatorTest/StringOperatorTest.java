/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class StringOperatorTest {
  public static void main(String[] args){
    String salutation  = "Hello "; 
    String welcome_msg = "Welcome to Java For Artists";
    String name        = args[0];
    
    String complete_msg = salutation + args[0] + ", " + welcome_msg + '!';

    System.out.println(complete_msg);
  
  }
}