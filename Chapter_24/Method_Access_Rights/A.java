/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class A {
  private A its_a = null;
  
  public A(A a){ 
     its_a = a;
     System.out.println("A object created!");
  }
  
  public  A(){
     its_a = this;
    System.out.println("A object created!");
  }

  public void f(A a){
    System.out.println("A.f() called!");
    System.out.println("Calling g() from A.f(): " + its_a.g());
  }
  
  private String g(){
    return "A.g()";
  }
}
