/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class Person {
  private String first_name = null;
  private String middle_name = null;
  private String last_name = null;
  private Calendar birthday = null;
  private String gender = null;

  public static final String MALE = "Male";
  public static final String FEMALE = "Female";

  public Person(String f_name, String m_name, String l_name, int dob_year, int dob_month, int dob_day, String gender){
    first_name = f_name;
    middle_name = m_name;
    last_name = l_name;
    this.gender = gender;
    
    birthday = Calendar.getInstance();
    birthday.set(dob_year, dob_month, dob_day);
  }

  public int getAge(){
    Calendar today = Calendar.getInstance();
    int now = today.get(Calendar.YEAR);
    int then = birthday.get(Calendar.YEAR);
    return (now - then);
  }

  public String getFullName(){ return (first_name + " " + middle_name + " " + last_name); } 

  public String getFirstName(){ return first_name; }
  public void setFirstName(String f_name) { first_name = f_name; }

  public String getMiddleName(){ return middle_name; }
  public void setMiddleName(String m_name){ middle_name = m_name; }

  public String getLastName(){ return last_name; }
  public void setLastName(String l_name){ last_name = l_name; }

  public String getNameAndAge(){ return (getFullName() + " " + getAge()); }

  public String getGender(){ return gender; }
  public void setGender(String gender){ this.gender = gender; }

  public void setBirthday(int year, int month, int day){ birthday.set(year, month, day); }

} //end Person class