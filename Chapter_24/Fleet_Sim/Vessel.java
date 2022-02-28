/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public abstract class Vessel {
  private Plant its_plant = null;
  private Weapon its_weapon = null;
  private String its_name = null;

  public Vessel(Plant plant, Weapon weapon, String name){
    its_weapon = weapon;
    its_plant = plant;
    its_name = name;
    System.out.println("The vessel " + its_name + " created!");
  }
  
  /* ********************************************************
      Public Abstract Methods - must be implemented in
      derived classes.
  *********************************************************/
  public abstract void lightoffPlant();
  public abstract void shutdownPlant();
  public abstract void trainWeapon();
  public abstract void fireWeapon();
  
  /* ********************************************************
      toString() Method - may be overridden in subclasses.
  *********************************************************/
  public String toString(){
    return "Vessel name: " + its_name + " " + its_plant.toString() +
            " " + its_weapon.toString();
  }
  protected Weapon getWeapon(){ return its_weapon; }
  protected Plant getPlant(){ return its_plant; }

}// end Vessel class definition
