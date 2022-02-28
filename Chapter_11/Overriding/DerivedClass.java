/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

public class DerivedClass extends BaseClass {
  private String _message = null;
   
   public DerivedClass(String message){
     super(message);
     _message = message;
   }

   public DerivedClass(){
     this("DerivedClass message!");
   }
 
  public void printMessage(){
    System.out.println("Message from DerivedClass: " + _message);
  }
}