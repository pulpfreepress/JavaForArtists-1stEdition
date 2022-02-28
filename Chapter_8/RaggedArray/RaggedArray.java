/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class RaggedArray {
  public static void main(String[] args){
   BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
   int[][] int_2d_ragged_array = new int[5][];   //rightmost dimension omitted
   int dimension = 0;

   /**************** get dimension of each ragged array ****************/
   for(int i = 0; i < int_2d_ragged_array.length; i++){
      System.out.print("Enter the ragged array dimension: ");
      dimension = 0;
      try {
          dimension = Integer.parseInt(console.readLine());
          }catch(NumberFormatException nfe){ System.out.println("Bad number! Dimension being set to 3");
                                             dimension = 3; }
           catch(IOException ioe){ System.out.println("Problem reading console! Dimension being set to 3");
                                   dimension = 3; }

      int_2d_ragged_array[i] = new int[dimension];
   }//end for
  
   /******************** print contents of array *********************/
   for(int i = 0; i < int_2d_ragged_array.length; i++){
     for(int j = 0; j < int_2d_ragged_array[i].length; j++){
       System.out.print(int_2d_ragged_array[i][j]);
     } // end inner for
     System.out.println();
   }//end outer for

  }//end main
}//end class