/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class Five_Inch_Gun extends Weapon {
 
   public Five_Inch_Gun(String model){
    super(model);
    System.out.println("Five Inch Gun object created!");
   }
  
   public void trainWeapon(){
    System.out.println("Five Inch Gun is locked on target!");
   }

   public void fireWeapon(){
    System.out.println("Blam! Blam! Blam!");
   }
}
