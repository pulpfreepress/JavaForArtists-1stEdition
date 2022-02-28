/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class CustomException extends Exception {
  public CustomException(String message, Throwable cause){
     super(message, cause);
  }

  public CustomException(String message){
      super(message);
  }

  public CustomException(){
   super("Custom Exception");
  }

  public CustomException(Throwable cause){
    super(cause);
  }
}