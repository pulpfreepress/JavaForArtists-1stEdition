/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class WeakenedDerivedIncrementer extends Incrementer {
  /********************************************
    Class invariant: 0 <= val <= 50
  ******************************************/
  private int val = 0;

  /**********************************************
    Constructor Method: DerivedIncrementer(int i)
          precondition: ((0 <= i) && (i <= 50))
         postcondition: 0 <= val <= 50
   **********************************************/
  public WeakenedDerivedIncrementer(int i){
    super(i);
    assert((0 <= i) && (i <= 50));  // enforce precondition
    val = i;
    System.out.println("WeakenedDerivedIncrementer object created with value: " + val);
    checkInvariant();
  }

  /***********************************************
           Method: void increment(int i)
     precondition: ((0 < i) && (i <= 10)) 
    postcondition: 0 <= val <= 50
  ***********************************************/
  public void increment(int i){
    assert((0 < i) && (i <= 10)); // enforce precondition

    if((0 <= i) && (i <= 5)){  // remember, it's our job to use the base class correctly!
         super.increment(i);
     }

    if((val+i) <= 50){
       val += i;
    }else{
      int temp = val;
      temp += i;
      val = (temp - 50);
     }
     checkInvariant();  // check invariant
     System.out.println("WeakenedDerivedIncrementer value is: " + val);
  }

  private void checkInvariant(){
    assert((0 <= val) && (val <= 50));
  }

} // end WeakenedDerivedIncrementer class definition
