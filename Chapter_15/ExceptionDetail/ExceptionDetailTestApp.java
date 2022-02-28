/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class ExceptionDetailTestApp {
 public static void main(String[] args){
     try{
        int i = Integer.parseInt(args[0]);
        System.out.println("The number entered was: " + i);
     }catch(NumberFormatException e){
        System.out.println("The string you entered was not an integer!");
        //System.out.println(e.toString());
        e.printStackTrace();
      }
     catch(Exception e){   
        System.out.println("You must enter a string! -- Please try again!");
        //System.out.println(e.toString());
        e.printStackTrace();
      }
   }
}