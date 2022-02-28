/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class SimpleEngine extends Engine implements PartListener {
 

  private String[] part_names = {"FuelPump 1", "Oxygen Sensor 1"};

  public SimpleEngine(PartStatus status, String name){
   super(status, name);
   
   addSubPart(part_names[0], new FuelPump(part_names[0]));
   addSubPart(part_names[1], new OxygenSensor(part_names[1]));
   getSubPart(part_names[0]).addPartListener(this);
   getSubPart(part_names[1]).addPartListener(this);
   System.out.println("SimpleEngine object created!");
   }

 public SimpleEngine(String name){
  super(name);
   
   addSubPart(part_names[0], new FuelPump(part_names[0]));
   addSubPart(part_names[1], new OxygenSensor(part_names[1]));
   getSubPart(part_names[0]).addPartListener(this);
   getSubPart(part_names[1]).addPartListener(this);
   System.out.println("SimpleEngine object created!");
   }

  /******************************************
    IEngine Interface Method Implementations
  *******************************************/
  public void start(){
      if(isWorking()){
     ((Pump) getSubPart(part_names[0])).setSpeed(100);
      }
  }


  public void stop(){
    ((Pump) getSubPart(part_names[0])).setSpeed(0);
  }

  public void incrementThrust(){
     ((Pump) getSubPart(part_names[0])).incrementSpeed(25);
  }
 

 public void decrementThrust(){
       ((Pump) getSubPart(part_names[0])).incrementSpeed(-25);
    }


  /**********************************
     PartListener Interface Methods
   *********************************/

  public void sensorReadingChangePerformed(PartEvent pe){
    System.out.println("SimpleEngine: sensorReadingChangePerformed() method called!");
    System.out.println(pe.getPartName() + " reading changed to " + pe.getValue());
   
   }

  public void pumpSpeedChangePerformed(PartEvent pe){
     System.out.println("SimpleEngine: pumpSpeedChangePerformed() method called!");
      System.out.println(pe.getPartName() + " speed changed to " + pe.getValue());
   }

  public void partStatusChangePerformed(PartEvent pe){
     System.out.println("SimpleEngine: partStatusChangePerformed() method called!");
     System.out.println(pe.getPartName() + pe.statusToString());
   }

  

}