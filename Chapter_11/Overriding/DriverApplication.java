/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class DriverApplication {
  public static void main(String[] args){
    BaseClass bcr1 = new BaseClass();
    BaseClass bcr2 = new DerivedClass();
    DerivedClass dcr1 = new DerivedClass();
    
    bcr1.printMessage();
    bcr2.printMessage();
    dcr1.printMessage();
  }

}