/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class DivisionTest {

  public static void main(String[] args){
    int int_i = 0;
    int int_j = 1;
    int int_k = 320;

    float float_i = 0.0f;
    float float_j = 1.0f;
    float float_k = 320.0f;

    int_i = int_j/int_k;
    System.out.println(int_i);

    float_i = int_j/int_k;
    System.out.println(float_i);
  
    /********  generates loss of precision error ********
    int_i = int_j/float_k;
    System.out.println(int_i);
    ****************************************************/

    float_i = int_j/float_k;
    System.out.println(float_i);

    float_i = float_j/int_k;
    System.out.println(float_i);

  }
}