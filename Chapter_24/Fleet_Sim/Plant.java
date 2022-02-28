/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public abstract class Plant {
   private String its_model = null;
   public Plant(String model){
     its_model = model;
   }
   public abstract void lightoffPlant();
   public abstract void shutdownPlant();
   
   public String toString(){ return "Plant model: " + its_model; }
}
