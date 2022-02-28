/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class RobotRat {
   /**
    * private attributes
    **/
      private BufferedReader console = null;
  
      public RobotRat(){
        //Initialize RobotRat attributes
        console = new BufferedReader(new InputStreamReader(System.in));
      }

      public void run(){
        while(true){
          printMenu();
          processMenuChoice();
        }
      }

      public void printMenu(){
         System.out.println("\n\n");
         System.out.println("      Robot Rat Control Menu");
         System.out.println("\n");
         System.out.println("   1. Pen Up");
         System.out.println("   2. Pen Down");
         System.out.println("   3. Turn Right");
         System.out.println("   4. Turn Left");
         System.out.println("   5. Move Forward");
         System.out.println("   6. Print Floor");
         System.out.println("   7. Exit");
         System.out.println("\n\n\n");
      }

      public char readChar(){
         String s = null;
         System.out.print("Please select from the menu: ");
         try{
           s = console.readLine();
         }catch(Exception ignored){}
         return s.charAt(0);
       }

       public void processMenuChoice(){
      
         switch(readChar()){
           case '1': setPenUp();
		     break;
           case '2': setPenDown();
		     break;
           case '3': turnRight();
		     break;
           case '4': turnLeft();
	  	     break;
	    case '5': move();
		     break;
            case '6': printFloor();
		     break;
            case '7': exit();
            default: printErrorMessage();
         }
       }


      public void setPenUp(){System.out.println("SetPenUp() method");}
      public void setPenDown(){System.out.println("SetPenDown() method");}
      public void turnRight(){System.out.println("turnRight() method");}
      public void turnLeft(){System.out.println("turnLeft() method");}
      public void move(){System.out.println("move() method");}
      public void printFloor(){System.out.println("printFloor() method");}
  
      public void exit(){
	 System.exit(0);
      }

      public void printErrorMessage(){
	System.out.println("Please enter a valid menu choice!");
      }

      public static void main(String[] args){
       RobotRat rr = new RobotRat();
       rr.run();
     }
}
