/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class ContinueStatementTest {
  public static void main(String[] args){
     int inner_loop_limit = Integer.parseInt(args[0]);
     int outer_loop_limit = Integer.parseInt(args[1]);
     int outer_loop_counter = 0;
     int inner_loop_counter = 0;

   outer_loop: while(outer_loop_counter++ < outer_loop_limit){
                 while(inner_loop_counter++ < inner_loop_limit){
                   if((inner_loop_counter % 2) == 0)
                     continue outer_loop;
                 System.out.println(inner_loop_counter);
                 }
               }
  }
}