/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package packageB;

public class ClassFive extends packageA.ClassOne {
   packageA.ClassOne c1 = new packageA.ClassOne();

  void f(){
    // c1.methodOne();   // Error - no horizontal access to outside package member
       c1.methodTwo();
    // c1.methodThree(); // Error - no horizontal access to protected member outside package
    // c1.MethodFour();  // Error - no horizontal access to private member
    // methodOne();      // Error - no vertical access outside package
       methodTwo();
       methodThree();
    // methodFour();     // Error - no vertical access - private method
   }
}