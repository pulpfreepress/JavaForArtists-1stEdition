/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class StatementTest {

  public static void main(String[] args){
   ;
   ;;
   enclosed_block_1: {
      int variable_name = 3;
      System.out.println(variable_name);
     }
 
   enclosed_block_2: {
      int variable_name = 5;
      System.out.println(variable_name);
     }

   arithmetic_operator_test: {
     int int_i = 0, int_j = 1, int_k = 2;

    int_i = int_j + int_k;
    System.out.println(int_i);

    float float_i = 0.0f, float_j = 1.1f, float_k = 2.2f;

    float_i = float_j + float_k;

   System.out.println(float_i);
    float_i  = int_i / float_k;

   System.out.println(float_i);

   float_i = float_j / int_j;

   System.out.println(float_i);
     
   byte byte_i = 125;
   for(int i = 0; i<10; i++)
   System.out.println(byte_i++);

    int_i = 32000;
    int_k = int_j / int_i;
    System.out.println(int_k);

    int_i = 320;
    int_j = 1;
    float_k = int_j / int_i;
    System.out.println(float_k);

    int_i = 320;
    float_j = 1;
    float_k = float_j / int_i;
    System.out.println(float_k);

    }

  /********  generates loss of precision warning ***********
   precision_test: {
   byte byte_i = 0;
   int int_j = 32000;

   byte_i = int_j;
   }
  *********************************************************/
    





  }
}