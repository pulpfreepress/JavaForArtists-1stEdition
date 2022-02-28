/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class OxygenSensor {
  private int registered_engine_number = 0;
  private PartStatus part_status;
  
  public OxygenSensor(PartStatus status, int engine_number){
   registered_engine_number = engine_number;
   part_status = status;
   System.out.println("OxygenSensor Created...");
  }

  public boolean isWorking(){ return part_status.isWorking(); }

  public void setPartStatus(PartStatus status){
    part_status = status;
  }

  public void setRegisteredEngineNumber(int engine_number){
     registered_engine_number = engine_number;
  }

  public int getRegisteredEngineNumber(){ return registered_engine_number; }
}