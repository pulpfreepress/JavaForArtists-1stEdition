/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

public class DerivedIncrementer extends Incrementer {
  /********************************************
    Class invariant: 0 <= val <= 50
  ******************************************/
  private int val = 0;

  /**********************************************
    Constructor Method: DerivedIncrementer(int i)
          precondition: ((0 <= i) && (i <= 50))
         postcondition: 0 <= val <= 50
   **********************************************/
  public DerivedIncrementer(int i){
    super(i);
    assert((0 <= i) && (i <= 50));  // enforce precondition
    val = i;
    System.out.println("DerivedIncrementer object created with value: " + val);
    checkInvariant();
  }

  /*********************************************
           Method: void increment(int i)
     precondition: ((0 < i) && (i <= 5))
    postcondition:  0 <= val <= 50
  ********************************************/
  public void increment(int i){
    assert((0 < i) && (i <= 5)); // enforce precondition
    super.increment(i);
    if((val+i) <= 50){
       val += i;
    }else{
      int temp = val;
      temp += i;
      val = (temp - 50);
     }
     checkInvariant();  // check invariant
     System.out.println("DerivedIncrementer value is: " + val);
  }

  private void checkInvariant(){
    assert((0 <= val) && (val <= 50));
  }
} // end DerivedIncrementer class definition