/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class BreakStatementTest {
  public static void main(String[] args){
      
     for(int i = 0; i < 2; i++){
         for(int j = 0; j < 1000; j++){
           System.out.println("Inner for loop - j = " + j);
           if(j == 3) break;
            }
        System.out.println("Outer for loop - i = " + i);
      }
    /************************************************************
      Outer_Loop: for(int i = 0; i < 2; i++){
                   for(int j = 0; j < 1000; j++){
                     System.out.println("Inner for loop - j = " + j);
                   if(j == 3) break Outer_Loop;
                   }
                System.out.println("Outer for loop - i = " + i);
                }
   *************************************************************/
  }
}