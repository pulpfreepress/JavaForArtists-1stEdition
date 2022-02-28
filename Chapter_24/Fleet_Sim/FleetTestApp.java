/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class FleetTestApp {
  public static void main(String[] args){
    Vessel v1 = new Submarine(new NukePlant("Preasureized Water Mk 85"), new Torpedo("MK 50"), "USS Falls Church");
    
    v1.lightoffPlant();
    v1.trainWeapon();
    v1.fireWeapon();
    v1.shutdownPlant();
    
  }
}// end FleetTestApp class definition
