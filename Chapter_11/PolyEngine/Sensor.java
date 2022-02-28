/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public abstract class Sensor extends Part implements ISensor {

  public Sensor(String name){
   super(name);
   System.out.println("Sensor object created!");
  }

  public Sensor(PartStatus status, String name){
   super(status, name);
   System.out.println("Sensor object created!");
  }


   /*******************************
     ISensor Interface Methods
   ********************************/

  public float getReading(){
     return 0;
   }
  
  public void setReading(float reading){ 
    fireSensorReadingChangeEvent(reading);
   }
 
  public void incrementReading(float increment) {
    fireSensorReadingChangeEvent(getReading());
   }

}