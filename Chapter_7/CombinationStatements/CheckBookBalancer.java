/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class CheckBookBalancer {
    public static void main(String[] args){
      /**** Initialize Program Variables ******/
      InputStreamReader input_stream = new InputStreamReader(System.in);
      BufferedReader console = new BufferedReader(input_stream);
      char keep_going = 'Y';
      double balance = 0.0;
      double deposits = 0.0;
      double withdrawals = 0.0;
      boolean good_double = false;

      /**** Display Welcome Message ****/
      System.out.println("Welcome to Checkbook Balancer");
      
    
      /**** Get Starting Balance *****/
      do{
       try{
         System.out.print("Please enter the opening balance: ");
         balance = Double.parseDouble(console.readLine());
         good_double = true;
         }catch(Exception e){ System.out.println("Please enter a valid balance!");}
        }while(!good_double);
        

      /**** Add All Deposits ****/
      while((keep_going == 'y') || (keep_going == 'Y')){
          good_double = false;
          do{
            try{
               System.out.print("Enter a deposit amount: ");
               deposits += Double.parseDouble(console.readLine());
               good_double = true;
               }catch(Exception e){ System.out.println("Please enter a valid deposit value!");}
             }while(!good_double);
           System.out.println("Do you have to enter another deposit? y/n");
           try{
             keep_going = console.readLine().charAt(0);
              }catch(Exception e){ System.out.println("Problem reading input!");}
      }

     /**** Subtract All Checks Written ****/
      keep_going = 'y';
      while((keep_going == 'y') || (keep_going == 'Y')){
          good_double = false;
          do{
            try{
               System.out.print("Enter a check amount: ");
               withdrawals += Double.parseDouble(console.readLine());
               good_double = true;
               }catch(Exception e){ System.out.println("Please enter a valid check amount!");}
             }while(!good_double);
           System.out.println("Do you have to enter another check? y/n");
           try{
             keep_going = console.readLine().charAt(0);
              }catch(Exception e){ System.out.println("Problem reading input!");}
      }

      /**** Display Final Tally ****/

      System.out.println("***************************************");
      System.out.println("Opening balance:     $   " + balance);
      System.out.println("Total deposits:     +$   " + deposits);
      System.out.println("Total withdrawals:  -$   " + withdrawals);
      balance = balance + (deposits - withdrawals);
      System.out.println("New balance is:      $   " + balance);
      System.out.println("\n\n");
  }
}