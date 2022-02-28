/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class EngineTester {
  public static void main(String[] args){
   Engine e1 = new Engine(1);
   e1.startEngine();
   e1.setCompressorStatus(PartStatus.NOT_WORKING);
   e1.startEngine();
   e1.startEngine();
   e1.setCompressorStatus(PartStatus.WORKING);
   e1.startEngine();
  }
}