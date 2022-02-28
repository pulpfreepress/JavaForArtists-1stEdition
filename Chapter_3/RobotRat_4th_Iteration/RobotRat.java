/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class RobotRat {
   /**
    * private instance attributes
    **/
      private BufferedReader console = null;
      private int pen_position = 0;
      private int direction = 0;
      private boolean floor[][] = null;

    /**
     * class constants 
     */
      private static final int NORTH = 0;
      private static final int SOUTH = 1;
      private static final int EAST = 2;
      private static final int WEST = 3;
      private static final int UP = 0;
      private static final int DOWN = 1;

  
      public RobotRat(int rows, int cols){
        //Initialize RobotRat attributes
        console = new BufferedReader(new InputStreamReader(System.in));
        direction = EAST;
        pen_position = UP;
        floor = new boolean[rows][cols];
        initializeFloor();
      }

      private void initializeFloor(){
        for(int i = 0; i<floor.length; i++){
           for(int j = 0; j<floor[i].length; j++){
		floor[i][j] = false;
         }
        }
      }


      public void run(){
        while(true){
          printMenu();
          processMenuChoice();
        }
      }

      private void printMenu(){
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

      private char readChar(){
         String s = null;
         System.out.print("Please select from the menu: ");
         try{
           s = console.readLine();
         }catch(Exception ignored){}
         return s.charAt(0);
       }

       private void processMenuChoice(){
      
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


      private void setPenUp(){
        pen_position = UP;
        System.out.println("The pen_position is UP");
      }

      private void setPenDown(){
        pen_position = DOWN;
        System.out.println("pen_position is DOWN");
      }


      private void turnRight(){
	switch(direction){
         case NORTH: direction = EAST;
		     System.out.println("RobotRat facing EAST");
		     break;
         case EAST:  direction = SOUTH;
		     System.out.println("RobotRat facing SOUTH");
		     break;
    	 case SOUTH: direction = WEST;
 		     System.out.println("RobotRat facing WEST");
		     break;
	 case WEST:  direction = NORTH;
                     System.out.println("RobotRat facing NORTH");
	   	     break;
         default:    direction = EAST;
		     System.out.println("RobotRat facing EAST");
        }

	System.out.println("turnRight() function");
	}


      private void turnLeft(){
        switch(direction){
         case NORTH: direction = WEST;
		     System.out.println("RobotRat facing WEST");
		     break;
         case EAST:  direction = NORTH;
		     System.out.println("RobotRat facing NORTH");
		     break;
    	 case SOUTH: direction = EAST;
 		     System.out.println("RobotRat facing EAST");
		     break;
	 case WEST:  direction = SOUTH;
                     System.out.println("RobotRat facing SOUTH");
	   	     break;
         default:    direction = EAST;
		     System.out.println("RobotRat facing EAST");
        }
     }


      private void move(){System.out.println("move() function");}

      private void printFloor(){
	 for(int i = 0; i<floor.length; i++){
           for(int j=0; j<floor[i].length; j++){
            if(floor[i][j] == true)
		System.out.print('*');
            else System.out.print('0');
           }
          System.out.println();
         }
       }
  
      private void exit(){
	 System.exit(0);
      }

      private void printErrorMessage(){
	System.out.println("Please enter a valid menu choice!");
      }

      public static void main(String[] args){
       RobotRat rr = new RobotRat(20, 20);
       rr.run();
     }
}