/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class MainTestApp {
  public static void main(String[] args){
    Person p1 = new Person("Rick", "W", "Miller", 1963, 5, 6, Person.MALE);
    Person p2 = new Person("Rick", "W", "Miller", 1963, 5, 6, Person.MALE);
    Person p3 = new Person("Rick", "W", "Miller", 1963, 5, 6, Person.MALE);
    Person p4 = new Person("Steve", "J", "Jones", 1932, 9, 20, Person.MALE);
    
    System.out.println("P1: " + p1.toString());
    System.out.println("P2: " + p2.toString());
    System.out.println("P3: " + p3.toString());
    System.out.println("P4: " + p4.toString());
    
    System.out.println(p1.equals(p1));  // reflexive - should be true
    System.out.println(p1.equals(p2) && p2.equals(p1)); // symmetric - should be true
    System.out.println(p1.equals(p2) && p2.equals(p3) && p1.equals(p3)); // transitive - should be true
    System.out.println(p1.equals(p2)); // consistent - should be true every time this app executes
    System.out.println(p1.equals(p4)); // consistent - should be false every time this app executes
    System.out.println(p1.equals(null)); // should always return false
    
    System.out.println();
    System.out.println(p1.hashCode());
    System.out.println(p2.hashCode());
    System.out.println(p3.hashCode());
    System.out.println(p4.hashCode());
    System.out.println();
    
    try{
      Person p5 = (Person)p4.clone();
      System.out.println(p4.toString());
      System.out.println(p5.toString());
      System.out.println(p4 == p5); // is it the same object - should be false
      System.out.println(p4.equals(p5)); // are they logically equal - should be true
      System.out.println(p4.hashCode()); 
      System.out.println(p5.hashCode()); // hash codes should be the same
    }catch(CloneNotSupportedException ignored){ }
   
     System.out.println();
     System.out.println(p1.compareTo(p2));
     System.out.println(p1.compareTo(p4));
     System.out.println(p4.compareTo(p1));
   
  }
} // end MainTestApp
