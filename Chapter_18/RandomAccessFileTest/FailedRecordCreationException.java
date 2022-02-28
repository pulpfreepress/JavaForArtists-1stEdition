/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.


public class FailedRecordCreationException extends Exception {

  /*****************************************************
  *  Constructor that takes a String argument
  *****************************************************/
  public FailedRecordCreationException(String message, Throwable cause){
     super(message, cause);
  }

  /********************************************
  *  Constructor that takes Throwable argument
  ********************************************/
  public FailedRecordCreationException(Throwable cause){
    this("Failed Record Creation Exception", cause);
  }

}