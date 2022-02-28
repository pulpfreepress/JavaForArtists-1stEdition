/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class MainTestApp {
  public static void main(String[] args){
    A a = new A();
    A a1 = new B(a);
    A a2 = new C(a1);
    A a3 = new C(a2);
    
    a1.f(a2);
    a2.f(a1);
  }
}
