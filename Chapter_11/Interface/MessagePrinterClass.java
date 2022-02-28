/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class MessagePrinterClass implements MessagePrinter {
   private String _message = null;

   public MessagePrinterClass(String message){
      _message = message;
   }

   public MessagePrinterClass(){
     this("Default message is boring!");
   }

   public void printMessage(){
    System.out.println(_message);
   }

   public void setMessage(String message){
    _message = message;
   }
}