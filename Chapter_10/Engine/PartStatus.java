/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class PartStatus {
  private boolean its_status = false;

  public static final PartStatus WORKING = new PartStatus(true);
  public static final PartStatus NOT_WORKING = new PartStatus(false);

  private PartStatus(boolean status){
     its_status = status;
  }

  public boolean isWorking(){ return its_status; }

}