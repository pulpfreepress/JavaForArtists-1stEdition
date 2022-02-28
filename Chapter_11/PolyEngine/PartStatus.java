/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public  final class PartStatus {
  public static final PartStatus NOT_WORKING = new PartStatus(false);
  public static final PartStatus WORKING = new PartStatus(true);

  private boolean _is_working = false;

  private PartStatus(boolean is_working){
     _is_working = is_working;
  } 
  
 public boolean isWorking(){ return _is_working; }
}