/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class Driver {
  public static void main(String[] args){
   StringTest st = new StringTest();

   String s = st.getFName();

   System.out.println(s);
   System.out.println(st.getFName());

   s = "Hello";

   System.out.println(s);
   System.out.println(st.getFName());
   
  }

}
