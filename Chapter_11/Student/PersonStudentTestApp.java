/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class PersonStudentTestApp {
  public static void main(String[] args){

   Person p1 = new Person("Steven", "Jay","Jones", 1946, 8, 30, Person.MALE);
   Person p2 = new Student("Jeanie", "Sue", "Freeman", 1963, 10, 10, Person.FEMALE, "000002", "Business");
   Student s1 = new Student("Richard", "Warren", "Miller", 1723, 2, 29, Person.MALE, "000003", "Math");
   
   System.out.println(p1.getNameAndAge());
   System.out.println(p2.getNameAndAge());
   System.out.println(((Student)p2).getStudentInfo());  // casting resolves the issue
   System.out.println(s1.getNameAndAge());
   System.out.println(s1.getStudentInfo());
   } 
}