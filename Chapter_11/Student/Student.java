/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class Student extends Person {
 private String _student_number = null;
 private String _major = null;
 
 public Student(String f_name, String m_name, String l_name, int dob_year,
                int dob_month, int dob_day, String gender, String student_number, String major){
     super(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender);
     _student_number = student_number;
     _major = major;
  }

 public String getStudentInfo(){
    return getNameAndAge() + " " + _student_number + " " + _major;
 }


}