/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

public class ChainedIfElseTest {
  public static void main(String[] args){
   int int_i = Integer.parseInt(args[0]);
   int int_j = Integer.parseInt(args[1]);

   if(int_i < int_j) {
	System.out.print("Yes ");
        System.out.println(int_i + " is less than " + int_j);
     } else if(int_i == int_j) {
                System.out.print("Exact match! ");
                System.out.println(int_i + " is equal to " + int_j);
             } else{
        	System.out.print("No ");
        	System.out.println(int_i + " is greater than " + int_j);
        }
  }
}