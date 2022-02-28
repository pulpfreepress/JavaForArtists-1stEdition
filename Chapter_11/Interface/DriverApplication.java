/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class DriverApplication {
  public static void main(String[] args){
     MessagePrinter mp1 = new MessagePrinterClass("Interfaces are cool!" +  
 							" Heh, heh, aren't they Butthead?");
     MessagePrinterClass mpc1 = new MessagePrinterClass("Shut up Bevis!");

     mp1.printMessage();
     mpc1.printMessage();
   }

}