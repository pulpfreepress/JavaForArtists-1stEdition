/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class NewDataFileException extends Exception {


/************************************************************
*   Constructor - One String argument
************************************************************/
  public NewDataFileException(String message, Throwable cause){
     super(message, cause);
  }


/************************************************************
*  Constructor that takes Throwable argument
************************************************************/
  public NewDataFileException(Throwable cause){
    this("New Data File Exception", cause);
  }

}