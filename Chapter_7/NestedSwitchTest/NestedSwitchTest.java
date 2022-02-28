/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class NestedSwitchTest {
  public static void main(String[] args){
     char char_c = args[0].charAt(0);
     int int_i = Integer.parseInt(args[1]);

     switch(char_c){
       case 'U' :
       case 'u' : switch(int_i){
                    case 1: 
                    case 2:
                    case 3:
                    case 4:
                    case 5: System.out.println("You entered " + char_c + " and " + int_i);
                            break;
                    default: System.out.println("Please enter: 1, 2, 3, 4, or 5"); 
                  }
                  break;
       case 'D' :
       case 'd' : switch(int_i){
                    case 1: 
                    case 2:
                    case 3:
                    case 4:
                    case 5: System.out.println("You entered " + char_c + " and " + int_i);
                            break;
                    default: System.out.println("Please enter: 1, 2, 3, 4, or 5");
                  }
                  break;
       default: System.out.println("Please enter: U, u, D, or d");

     }    
  }
}