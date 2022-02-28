/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public abstract class Weapon {
  private String its_model = null;
  
  public Weapon(String model){
    its_model = model;
    System.out.println("Weapon object created!");
  }
  
  public abstract void trainWeapon();
  public abstract void fireWeapon();
  
  public String toString(){ return "Weapon model: " + its_model; }
}
