/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class FuelPump extends Pump{

 private static final int MIN_SPEED = 0;
 private static final int MAX_SPEED = 1000;

 private int _speed = 0;
 
 public FuelPump(PartStatus status, String name){
    super(status, name);
    System.out.println("Fuel Pump " + name + " created!");
  }

 public FuelPump(String name){
    super(name);
    System.out.println("Fuel Pump " + name + " created!");
  }

 public void setSpeed(int speed){
    if((speed >= MIN_SPEED) && (speed <= MAX_SPEED)){
        _speed = speed;
        super.setSpeed(speed);
     }else{ 
          System.out.println("Pump speed cannot exceed specified range:" + MIN_SPEED + " - " + MAX_SPEED);
       }
 }

 public void incrementSpeed(int i){
  if(((_speed + i) >= MIN_SPEED) &&  ((_speed + i) <= MAX_SPEED)){
      _speed += i;
      super.incrementSpeed(i);
   } else {
       System.out.println("Pump speed cannot exceed specified range: " + MIN_SPEED + " - " + MAX_SPEED);
     }
  }

 public int getSpeed() { return _speed; }

}