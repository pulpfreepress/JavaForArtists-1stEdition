/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public class PeopleManager {
  List people_list = null;
  
  public PeopleManager(){
      people_list = new LinkedList();     
   }

  public void addPerson(String f_name, String m_name, String l_name, int dob_year, int dob_month, int dob_day, String gender){
      people_list.add(new Person(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender));
  }

  public void deletePersonAtIndex(int index){
     people_list.remove(index);
  }

  public void insertPersonAtIndex(int index, String f_name, String m_name, String l_name, int dob_year, int dob_month, int dob_day, String gender){
   people_list.add(index, new Person(f_name, m_name, l_name, dob_year, dob_month, dob_day, gender));
  }

  public void listPeople(){
    for(Iterator i = people_list.iterator(); i.hasNext();){
      System.out.println(i.next().toString());
    }
  }
}// end PeopleManager class