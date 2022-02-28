/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public interface InterfaceAlpha {
   int i = 0;
   void a();
  // void b(){ }  // interface methods cannot have a body!
  public class InnerClass {
    private int i;
    public InnerClass(){ }
    public void f(){}
    
   } //end InnerClass definition

   interface InnerInterface {
     void g();
     void h();
  
   }//end InnerInterface
}