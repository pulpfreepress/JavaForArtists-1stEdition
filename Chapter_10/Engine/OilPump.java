/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

public class OilPump {
  private int registered_engine_number = 0;
  private PartStatus part_status;
  
  public OilPump(PartStatus status, int engine_number){
   registered_engine_number = engine_number;
   part_status = status;
   System.out.println("OilPump Created...");
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