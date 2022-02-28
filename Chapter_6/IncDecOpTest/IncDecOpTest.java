/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class IncDecOpTest {
  public static void main(String[] args){
   int int_i = 0;
   float float_i = 0.0f;
   
   System.out.println(++int_i);  //now it's 1
   System.out.println(int_i++); //now it's 2, but after 1 is printed
   System.out.println(--int_i); // 2 - 1 = 1
   System.out.println(int_i--); // 1 - 1 = 0, but after 1 is printed
   System.out.println(int_i);   // now print 0
   
   System.out.println(++float_i);  //now it's 1
   System.out.println(float_i++);  //now it's 2, but after 1 is printed
   System.out.println(--float_i); //2 - 1 = 1 
   System.out.println(float_i--); //1 - 1 = 0, but after 1 is printed
   System.out.println(float_i);   //now print 0
  }
}