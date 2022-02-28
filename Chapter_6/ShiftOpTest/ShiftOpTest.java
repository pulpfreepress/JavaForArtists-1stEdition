/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class ShiftOpTest {
  public static void main(String[] args){
   
  byte byte_1 = 15;            //00001111
  int int_1   = 0x0002;       //00000000000000000000000000000010

  System.out.println(byte_1 << 1);  // shift left 1 bit
  System.out.println(byte_1 >> 1);  // right shift 2 bits 
  System.out.println(byte_1 >> 2);  // right shift 2 bits 
  System.out.println(byte_1 >>> 1); //unsigned right shift 1 bit
  System.out.println(int_1 << 4);  //left shift 4 bits
  System.out.println(int_1 >>> 6); //unsigned right shift 6 bits
  }
}