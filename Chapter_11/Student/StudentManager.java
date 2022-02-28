/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class StudentManager {
  Student[] student_array = null;
  int index = 0;

  public StudentManager(int size){
      student_array = new Student[size];     
   }

  public StudentManager(){
     this(10);
   }

  public void addStudent(Student student){
     if(student_array[index] == null){
       student_array[index++] = student;
     }
     if(index >= student_array.length){
       index = 0;
     }
   }

  public void deleteStudentAtIndex(int index){
      assert((index >= 0) && (index < student_array.length));
      student_array[index] = null;
  }

  public void insertStudentAtIndex(int index, Student student){
     assert((index >= 0) && (index < student_array.length));
     student_array[index] = student;
  }

  public void listStudents(){
    for(int i = 0; i < student_array.length; i++){
      if(student_array[i] != null){
         System.out.println(student_array[i].getStudentInfo()); 
       }
    }
  }
}// end StudentManager class