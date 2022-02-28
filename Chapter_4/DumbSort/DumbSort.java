/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class DumbSort{
 public static void main(String[] args){

 	int a[] = {11,10,9,8,7,6,5,4,3,2,1,0};
  	int innerloop = 0;	int outerloop = 0;	int swaps = 0;		for(int i = 0; i<12; i++){ 	  outerloop++;		for(int j = 1; j<12; j++){		  innerloop++;			if(a[j-1] > a[j]) {				int temp = a[j-1];				a[j-1] = a[j];				a[j] = temp;				swaps++;}}}			for(int i = 0; i<12; i++)		System.out.print(a[i] + " ");	System.out.println();	System.out.println("Outer loop executed " + outerloop + " times.");	System.out.println("Inner loop executed " + innerloop + " times.");	System.out.println(swaps + " swaps completed.");
 }
}