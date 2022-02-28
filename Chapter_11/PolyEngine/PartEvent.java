/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class PartEvent extends EventObject {
  private String _part_name = null;
  private double _value = 0.0;
  
  public PartEvent(Object source, String part_name, double value){
    super(source);
    _part_name = part_name;
    _value = value;
   }

   public PartEvent(Object source, String part_name){
    super(source);
    _part_name = part_name;
   }


  public String getPartName(){ return  _part_name; }
 
  public double getValue(){ return _value; }

  public String toString(){ return super.toString() + " " + getPartName();}

  public String statusToString(){
   return ((Part) source).isWorking() ? " is working properly!" : " has malfunctioned!";
  }

}
