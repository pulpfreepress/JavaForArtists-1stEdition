/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class StudentManagerApplication {
  public static void main(String[] args){
   StudentManager pm = new StudentManager();  // defaut constructor test

   pm.addStudent(new Student("Steven", "Jay","Jones", 1946, 8, 30, Person.MALE, "000001", "Computer Science"));
   pm.addStudent(new Student("Jeanie", "Sue", "Freeman", 1963, 10, 10, Person.FEMALE, "000002", "Business"));
   pm.addStudent(new Student("Richard", "Warren", "Miller", 1723, 2, 29, Person.MALE, "000003", "Math"));

   pm.listStudents();

   pm.deleteStudentAtIndex(1);
   pm.insertStudentAtIndex(1, new Student("Coralie", "Sylvia", "Miller", 1965, 8, 3, Person.FEMALE, "000004", "Computer Science"));

   System.out.println();
   pm.listStudents();

  // pm.deleteStudentAtIndex(-3);  // test assertion
  // pm.deleteStudentAtIndex(28);  // test assertion

   } // end main
}// end StudentManagerApplication class