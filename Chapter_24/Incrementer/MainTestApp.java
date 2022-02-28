/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class MainTestApp {
  public static void main(String[] args){
    Incrementer i1 = new Incrementer(0);
    Incrementer i2 = new DerivedIncrementer(20);
    Incrementer i3 = new WeakenedDerivedIncrementer(10);
    Incrementer i4 = new StrengthenedDerivedIncrementer(10);
       
    i1.increment(1);
    i1.increment(2);
    i1.increment(3);
    i1.increment(4);
    i1.increment(5);
    System.out.println("-----------------------------");
    i2.increment(4);
    i2.increment(5);
    System.out.println("-----------------------------");
    i3.increment(5);
    System.out.println("-----------------------------");
    i4.increment(2); // OK so far...
    i4.increment(3); // OK here too...
    i4.increment(4); // Wait a minute...this should work!
   
 } // end main() method
}// end MainTestApp clas definition
