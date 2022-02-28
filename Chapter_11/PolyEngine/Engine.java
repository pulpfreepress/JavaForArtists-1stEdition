/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public abstract class Engine extends Part implements IEngine {

  public Engine(PartStatus status, String name){
    super(status, name);
    System.out.println("Engine object created!");
  }

  public Engine(String name){
    super(name);
    System.out.println("Engine object created!");
  }

  
  /**********************************************
              IEngine Interface Method Stubs
 
     Default behavior will do nothing. They must be
  overridden in a derived class.
  ************************************************/
  public void start(){ }
  public void stop(){ }
  public void incrementThrust(){ }
  public void decrementThrust(){ }



}