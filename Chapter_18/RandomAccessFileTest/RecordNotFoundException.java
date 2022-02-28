/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class RecordNotFoundException extends Exception {

 /************************************************************
*  Constructor - Takes one String argument
************************************************************/
  public RecordNotFoundException(String message, Throwable cause){
        super(message, cause);
   }


/************************************************************
*  Constructor that takes Throwable argument
************************************************************/
  public RecordNotFoundException(Throwable cause){
      this("Record Not Found Exception", cause);
  }

}