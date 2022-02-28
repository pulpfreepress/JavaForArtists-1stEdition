/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class TestClassThree {
  public static int static_int_variable;        // main() can access this variable
  private static int static_int_variable_2;     // and this one too...

  public int instance_int_variable;            // But it needs a reference to an object
  private int instance_int_variable_2;         // to access these instance variables...

  public static void main(String[] args){
    System.out.println(static_int_variable); 
    System.out.println(static_int_variable_2);
    System.out.println(TestClassThree.static_int_variable); 
    System.out.println(TestClassThree.static_int_variable_2); 

   TestClassThree tc3 = new TestClassThree();

   System.out.println(tc3.instance_int_variable);
   System.out.println(tc3.instance_int_variable_2);
   }
}