/*****************************************************************
  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press 
     
   This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.
*****************************************************************/

public class MainTestApp {
  public static void main(String[] args){
       while(true){
	InterfaceType t1 = InterfaceTypeFactory.newObjectByClassName("ClassA");
	InterfaceType t2 = InterfaceTypeFactory.newObjectByClassName("ClassB");
	InterfaceType t3 = InterfaceTypeFactory.newObjectByClassName("ClassC");

	System.out.println(t1.getMessage());
	System.out.println(t2.getMessage());
	System.out.println(t3.getMessage());
    } // end while
  }
}