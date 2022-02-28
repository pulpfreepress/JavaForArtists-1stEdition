/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class OxygenSensor extends Sensor {
 private static final int MIN_READING = 0;
 private static final int MAX_READING = 1000;
 private float _reading = 0;

 public OxygenSensor(String name){
   super(name);
   System.out.println("Oxygen Sensor " + name + " object created!");
   _reading = 0;
  }

 public OxygenSensor(PartStatus status, String name){
   super(status, name);
   System.out.println("Oxygen Sensor " + name + " object created!");
   _reading = 0;
  }


  public float getReading(){ return _reading; }

  public void setReading(float reading){
   if( (reading >= MIN_READING) && (reading <= MAX_READING)){
        _reading = reading;
        super.setReading(reading);   //call Sensor method to fire sensor reading change event
    } else {
        System.out.println("Warning: Attempt to set Oxygen Sensor outside valid range: " + MIN_READING + " - " + MAX_READING);
       }
  
  }

  public void  incrementReading(float increment){
   if(((_reading + increment) >= MIN_READING) && ((_reading + increment) <= MAX_READING)){
      _reading += increment;
      super.setReading(_reading);   //call Sensor method to fire sensor reading change event
     } else {
            System.out.println("Warning: Attempt to set Oxygen Sensor outside valid range: " + MIN_READING + " - " + MAX_READING);
          }
  }

} // end OxygenSensor class