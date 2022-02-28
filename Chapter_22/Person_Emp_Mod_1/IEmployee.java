/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public interface IEmployee {
      int getAge();
   String getFullName();
   String getNameAndAge();
   String getFirstName();
   String getMiddleName();
   String getLastName();
   String getGender();
   String getEmployeeNumber();
     void setBirthday(int year, int month, int day);
     void setFirstName(String f_name);
     void setMiddleName(String m_name);
     void setLastName(String l_name);
     void setGender(String gender);
     void setEmployeeNumber(String emp_no);
   double getPay();
  

}
