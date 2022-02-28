/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class GasTurbinePlant extends Plant {
  
   public GasTurbinePlant(String model){
     super(model);
     System.out.println("GasTurbinePlant object created!");
   }

  public void lightoffPlant(){
    System.out.println("Gas Turbine is running and ready to go!");
  }

  public void shutdownPlant(){
    System.out.println("Gas Turbine is secure!");
  }
}
