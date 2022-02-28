/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.jfa.chapter1;

import java.util.*;

public class SampleClass {
  /**************************************
    Class and instance field declarations
  ***************************************/
  public static final int CONST_VAL = 25;
  private static int class_variable = 0;
  private int instance_variable = 0;
  
  public SampleClass(){
   System.out.println("Sample Class Lives!");
  }
  
  public static void setClassVariable(int val){
        class_variable = val;
  }
  
  public static int getClassVariable(){
        return class_variable;
  }
  
  public void  setInstanceVariable(int val){
        instance_variable = val;
  }
  
  public int getInstanceVariable(){
        return instance_variable;
  }
  
}
