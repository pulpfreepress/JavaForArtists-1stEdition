/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class EqualityOpTest {
  public static void main(String[] args){
   
   Object object_1 = new Object();
   Object object_2 = new Object();
   Object object_3 = object_2;
   int int_i = 0;
   int int_j = 1;

   System.out.println(object_1 == object_2);
   System.out.println(object_1 != object_2);
   System.out.println(object_2 == object_3);
   System.out.println(object_2 != object_3);
   System.out.println(int_i == int_j);
   System.out.println(int_i != int_j);
   System.out.println(5 == 6);
   System.out.println('r' != 's');
  }
}