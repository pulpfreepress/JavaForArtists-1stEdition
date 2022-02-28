/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class RobotRat {

  public RobotRat(){
    printMenu();
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


   public static void main(String[] args){
    RobotRat rr = new RobotRat();
   }

}