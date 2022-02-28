/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class MainTestApp {
  public static void main(String[] args){
    A a1 = new A();
    a1.f(new A()); // A's method called
    
    System.out.println("------------------");

    A a2 = new B();
    a2.f(new A()); // A's method called
    a2.f(new B()); // A's method called

    System.out.println("------------------");
   
    B b1 = new C();
    b1.f(new A());  // C's overriding method called
    b1.f(new B()); // B's overloaded method called
    b1.f(new C()); // B's overloaded method called

    System.out.println("------------------");

    A a3 = new C();  
    a3.f(new A()); // C's overriding method called
    a3.f(new B()); // C's overriding method called
    a3.f(new C()); // C's overriding method called

  } // end main() method
} // end MainTestApp program
