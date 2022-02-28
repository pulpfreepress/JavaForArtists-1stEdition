/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

public class BaseClass {
  private String _message = null;

  public BaseClass(String message){
    _message = "Message from BaseClass: " + message;
  }

  public BaseClass(){
    this("BaseClass message!");
  }

  public void printMessage(){
    System.out.println(_message);
  }

  public void setMessage(String message){
   _message = "Message from BaseClass: " + message;
  }

}