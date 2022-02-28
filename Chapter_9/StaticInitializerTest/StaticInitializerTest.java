/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class StaticInitializerTest {
   private static int static_int_val;
   private static int[] static_int_array = new int[10];
   static {
          for(int i = 0; i < static_int_array.length; i++){
              static_int_array[i] = i;
          }
   }//end static class initializer

  /****** Constructor Method ********/
   public StaticInitializerTest(){
       static_int_val++;
   }
  
  /***** printStaticArrayValues method ******/
  public void printStaticArrayValues(){
    for(int i = 0; i < static_int_array.length; i++){
	System.out.print(static_int_array[i] + " ");
    }
    System.out.println();
  }

  /****** getStaticIntVal method ******/
  public int getStaticIntVal(){ return static_int_val; }

  /***** main method ********/
  public static void main(String[] args){
   StaticInitializerTest sit1 = new StaticInitializerTest();
   System.out.println(sit1.getStaticIntVal());

   StaticInitializerTest sit2 = new StaticInitializerTest();
   System.out.println(sit2.getStaticIntVal());

   StaticInitializerTest sit3 = new StaticInitializerTest();
   System.out.println(sit3.getStaticIntVal());

   StaticInitializerTest sit4 = new StaticInitializerTest();
   System.out.println(sit4.getStaticIntVal());
  
   sit1.printStaticArrayValues();
   sit2.printStaticArrayValues();
   sit3.printStaticArrayValues();
   sit4.printStaticArrayValues();
  } //end main
} //end class 