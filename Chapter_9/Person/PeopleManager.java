/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class PeopleManager {
  Person[] people_array = null;
  int index = 0;

  public PeopleManager(int size){
      people_array = new Person[size];     
   }

  public PeopleManager(){
     this(10);
   }

  public void addPerson(String f_name, String m_name, String l_name, int dob_year, int dob_month, int dob_day, String gender){
     if(people_array[index] == null){
       people_array[index++] = new Person(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender);
     }
     if(index >= people_array.length){
       index = 0;
     }
   }

  public void deletePersonAtIndex(int index){
      assert((index >= 0) && (index < people_array.length));
      people_array[index] = null;
  }

  public void insertPersonAtIndex(int index, String f_name, String m_name, String l_name, int dob_year, int dob_month, int dob_day, String gender){
     assert((index >= 0) && (index < people_array.length));
     people_array[index] = new Person(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender);
  }

  public void listPeople(){
    for(int i = 0; i < people_array.length; i++){
      if(people_array[i] != null){
         System.out.println(people_array[i].getNameAndAge()); 
       }
    }
  }
}// end PeopleManager class