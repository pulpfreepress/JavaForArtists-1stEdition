/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class Engine {
  private Compressor its_compressor = null;
  private FuelPump its_fuelpump = null;
  private OilPump its_oilpump = null;
  private OxygenSensor its_oxygensensor = null;
  private TemperatureSensor its_temperaturesensor = null;
  private int its_engine_number = 0;
  private boolean is_running = false;
  private PartStatus its_status = null;

  public Engine(int engine_number){
    its_engine_number = engine_number;
    its_compressor = new Compressor(PartStatus.WORKING, its_engine_number);
    its_fuelpump = new FuelPump(PartStatus.WORKING, its_engine_number);
    its_oilpump = new OilPump(PartStatus.WORKING, its_engine_number);
    its_oxygensensor = new OxygenSensor(PartStatus.WORKING, its_engine_number);
    its_temperaturesensor = new TemperatureSensor(PartStatus.WORKING, its_engine_number);
    its_status = PartStatus.WORKING;
    System.out.println("Engine #" + its_engine_number + " created!");
  }

  public void setCompressorStatus(PartStatus status){
    its_compressor.setPartStatus(status);
    checkEngineStatus();
  }
  
  public void setFuelPumpStatus(PartStatus status){
    its_fuelpump.setPartStatus(status);
    checkEngineStatus();

  }

  public void setOilPumpStatus(PartStatus status){
    its_oilpump.setPartStatus(status);
    checkEngineStatus();
  }

  public void setOxygenSensorStatus(PartStatus status){
    its_oxygensensor.setPartStatus(status);
    checkEngineStatus();
  }

  public void setTemperatureSensor(PartStatus status){
    its_temperaturesensor.setPartStatus(status);
    checkEngineStatus();
  }

  public boolean checkEngineStatus(){
   if(its_compressor.isWorking() && its_fuelpump.isWorking() &&
      its_oilpump.isWorking() && its_oxygensensor.isWorking() &&
      its_temperaturesensor.isWorking()){
        its_status = PartStatus.WORKING;
        System.out.println("All engine #" + its_engine_number + " components working properly.");
      } else {
               its_status = PartStatus.NOT_WORKING;
               System.out.println("Engine #" + its_engine_number + " malfunction.");
               if(is_running){
                 System.out.println("Engine #" + its_engine_number + " shutting down!");
                 stopEngine();
               }
             }

    return its_status.isWorking();
  }

  public void startEngine(){
    if(!is_running){
     if(checkEngineStatus()){
       is_running = true;
        System.out.println("Engine #" + its_engine_number + " is running!");
      } else {
             System.out.println("There is a problem with an engine #" + its_engine_number + " component. Engine cannot start.");
             }
    } else { 
            System.out.println("Engine #" + its_engine_number + " is already running!");
           }
  }

  public void stopEngine(){
     is_running = false;
     System.out.println("Engine #" + its_engine_number + " has been stopped!");
  }
 
}