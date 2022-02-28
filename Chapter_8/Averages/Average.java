/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.text.*;

public class Average {
  public static void main(String[] args){
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
      double[] grades      = null;
      double   total       = 0;
      double   average     = 0;
      int      grade_count = 0;
      NumberFormat nf = NumberFormat.getInstance();

      nf.setMaximumFractionDigits(2);      
      System.out.println("Welcome to Grade Averager");
      System.out.print("Please enter the number of grades to enter: ");
      try{
          grade_count = Integer.parseInt(console.readLine());
         } catch(NumberFormatException nfe) { System.out.println("You did not enter a number!"); }
           catch(IOException ioe) { System.out.println("Problem reading console!"); }
       
       if(grade_count > 0){
           grades = new double[grade_count];
              for(int i = 0; i < grade_count; i++){
                 System.out.print("Enter grade " + (i+1) + ": ");
                   try{
                      grades[i] = Double.parseDouble(console.readLine());
                   } catch(NumberFormatException nfe) { System.out.println("You did not enter a number!"); }
                     catch(IOException ioe) { System.out.println("Problem reading console!"); }
              } //end for
             

              for(int i = 0; i < grade_count; i++){
                 total += grades[i];
              } //end for
 
             average = total/grade_count;
             System.out.println("Number of grades entered: " + grade_count);
             System.out.println("Grade average:            " + nf.format(average));

        }//end if

   } //end main
}// end Average class definition