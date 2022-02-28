/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class QuestionOne {
  private int int_i;
  private static int int_j;
  public static final int INT_K = 25;

  public static void main(String[] args){
   System.out.println(int_j);
   System.out.println(INT_K);

   QuestionOne q1 = new QuestionOne();

   System.out.println(q1.int_i);
  }
}