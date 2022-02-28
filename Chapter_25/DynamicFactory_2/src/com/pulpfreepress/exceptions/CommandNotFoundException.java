/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.exceptions;

public class CommandNotFoundException extends Exception {
 
 public CommandNotFoundException(String message, Throwable ex){
     super(message, ex);
 }
 
  public CommandNotFoundException(String message){
        super(message);
   }


  public CommandNotFoundException(){
      this("Command Not Found Exception");
  }
} // end CommandNotFoundException class definition