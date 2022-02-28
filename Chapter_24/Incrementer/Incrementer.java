/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class Incrementer {
  /**********************************************
    Class invariant: 0 <= Incrementer.val <= 100
   **********************************************/
   private int val = 0;

   /********************************************
     Constructor Method: Incrementor(int i) 
      precondition: ((0 <= i) &&  (i <= 100))
     postcondition:  0 <= Incrementer.val <= 100
   ********************************************/
   public Incrementer(int i){
     assert((0 <= i) && (i <= 100));
     val = i;
     System.out.println("Incrementer object created with initial value of: " + val);
     checkInvariant();   // enforce class invariant
   }

   /**********************************************
           Method: void increment(int i)
     precondition: 0 < i <= 5
    postcondition: 0 <= Incrementer.val <= 100
   *********************************************/
   public void increment(int i){
     assert((0 < i) && (i <= 5)); // enforce precondition

     if((val+i) <= 100){
       val += i;
     }else{
       int temp = val;
       temp += i;
       val = (temp - 100);
      }

     checkInvariant();           // enforce class invariant
     
     System.out.println("Incremeter value is: " + val);   
   }
   
  /*********************************************
    Method: void checkInvariant() - called
    immediately after any change to class
    invariant to ensure invariant condition
    is satisfied.
   *******************************************/
   private void checkInvariant(){
     assert((0 <= val) && (val <= 100));
   }
}// end Incrementer class definition
