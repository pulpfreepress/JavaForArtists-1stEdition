/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class DriverApplication {
  public static void main(String[] args){
    AbstractClass ac1 = new DerivedClass();
    DerivedClass dc1 = new DerivedClass();

    ac1.printMessage();
    ac1.setMessage("I Love Java!!!");
    ac1.printMessage();

    dc1.printMessage();
    dc1.setMessage("I hope you love Java too!!!");
    dc1.printMessage();

  }
}