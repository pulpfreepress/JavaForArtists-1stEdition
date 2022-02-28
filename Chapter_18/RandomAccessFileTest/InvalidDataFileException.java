/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.


public class InvalidDataFileException extends Exception {


/************************************************************
*   Constructor - Takes one String argument
************************************************************/
  public InvalidDataFileException(String message, Throwable cause){
     super(message, cause);
  }


/************************************************************
*  Constructor that takes Throwable argument
************************************************************/
  public InvalidDataFileException(Throwable cause){
    this("Invalid Data File Exception", cause);
  }

}