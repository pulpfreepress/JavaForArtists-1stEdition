/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class CIWS extends Weapon {
 
   public CIWS(String model){
    super(model);
    System.out.println("CIWS object created!");
   }
  
   public void trainWeapon(){
    System.out.println("CIWS is locked on target!");
   }

   public void fireWeapon(){
    System.out.println("The CIWS roars to life and fires a zillion bullets at the target!");
   }
}
