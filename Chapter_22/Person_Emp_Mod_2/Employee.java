/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public abstract class Employee implements IEmployee {
   private Person _person = null;
   private String  _employee_number = null;
   
   protected Employee(String f_name, String m_name, String l_name, int dob_year, int dob_month,
                   int dob_day, String gender, String employee_number){
      _person = new Person(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender);
      _employee_number = employee_number;
    } // end constructor
    
    public int getAge() { return _person.getAge(); }
    public String getFullName() { return _person.getFullName(); }
    public String getNameAndAge() { return _person.getNameAndAge(); }
    public String getFirstName() { return _person.getFirstName(); }
    public String getMiddleName() { return _person.getMiddleName(); }
    public String getLastName() { return _person.getLastName(); }
    public String getGender() { return _person.getGender(); }
    public String getEmployeeNumber() { return _employee_number; }
    public void setBirthday(int year, int month, int day) { _person.setBirthday(year, month, day); }
    public void setFirstName(String f_name) { _person.setFirstName(f_name); }
    public void setMiddleName(String m_name) { _person.setMiddleName(m_name); }
    public void setLastName(String l_name) { _person.setLastName(l_name); }
    public void setGender(String gender) { _person.setGender(gender); }
    public void setEmployeeNumber(String emp_no) { _employee_number = emp_no; }
    public String toString(){ return _person.getNameAndAge() + " " + _employee_number; }
    public abstract void setPayInfo(PayInfo pi); // defer implementation
    public abstract double getPay(); // defer implementation
    
}  // end Employee class definition
