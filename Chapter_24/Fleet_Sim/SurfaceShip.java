/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class SurfaceShip extends Vessel {
  
   public SurfaceShip(Plant plant, Weapon weapon, String name){
     super(plant, weapon, name);
     System.out.println("SurfaceShip object created: " + toString());
   }

   public void lightoffPlant(){
     getPlant().lightoffPlant();
   }

   public void shutdownPlant(){
     getPlant().shutdownPlant();
   }

   public void trainWeapon(){
     getWeapon().trainWeapon();
   }

   public void fireWeapon(){
     getWeapon().fireWeapon();
   }

} // end SurfaceShip class definition
