/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class IdentifierTest {
  const String willItWork = "I Hope!";

 public static void main(String[] args){
      String  \u03B63_3 = "Hello - \u03B63_3 is a valid identifier!";
      System.out.println(\u03b63_3);
      System.out.println(Character.isJavaIdentifierStart('\u03B6'));
      System.out.println(Character.isJavaIdentifierStart('Ô'));
      System.out.println(Character.isJavaIdentifierStart('¢'));
      System.out.println(Character.isJavaIdentifierStart('$'));
      System.out.println(Character.isJavaIdentifierStart('a'));
      System.out.println(Character.isJavaIdentifierStart('Å'));
      System.out.println(Character.isJavaIdentifierStart('Í'));

      System.out.println('Á');

     
   }
}