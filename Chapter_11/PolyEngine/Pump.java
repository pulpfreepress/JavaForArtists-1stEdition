/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public abstract class Pump extends Part implements IPump {

 public Pump(PartStatus status, String name){
    super(status, name);
    System.out.println("Pump object created!");
  }

 public Pump(String name){
    super(name);
    System.out.println("Pump object created!");
  }

 public void setSpeed(int speed){
     firePumpSpeedChangeEvent(speed);
   }

 public void incrementSpeed(int increment){
    firePumpSpeedChangeEvent(getSpeed());
  }

 public int getSpeed() { return 0; }

}