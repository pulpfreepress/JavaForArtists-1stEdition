/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class TestClassTwo {
  public static void main(String[] args){
   Object object_reference = new Object();
   System.out.println(object_reference.toString());
   System.out.println(object_reference.hashCode());
   object_reference = new Object(); 
   System.out.println(object_reference.toString());
   System.out.println(object_reference.hashCode());
   System.out.println(object_reference);

  }
}