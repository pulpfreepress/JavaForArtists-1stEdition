/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

package com.pulpfreepress.jfa.chapter1;

public class ApplicationClass {
    
  public static void main(String args[]){
    SampleClass sc = new SampleClass();
    System.out.println(SampleClass.CONST_VAL);
    System.out.println(SampleClass.getClassVariable());
    System.out.println(sc.getInstanceVariable());
    SampleClass.setClassVariable(3);
    sc.setInstanceVariable(4);
    System.out.println(SampleClass.getClassVariable());
    System.out.println(sc.getInstanceVariable());
    
    System.out.println(sc.getClassVariable());
  }
}