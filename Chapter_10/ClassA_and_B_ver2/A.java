/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class A {
   private B its_b = null;
   public A(B b_ref){ 
     its_b = b_ref;
     System.out.println("A object created!"); 
   }

  public void  makeContainedObjectSayHi(){
      its_b.sayHi();
  }
}