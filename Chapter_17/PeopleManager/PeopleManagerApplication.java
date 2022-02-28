/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class PeopleManagerApplication {
  public static void main(String[] args){
   PeopleManager pm = new PeopleManager();

   pm.addPerson("Steven", "Jay","Jones", 1950, 8, 30, Person.MALE);
   pm.addPerson("Jeanie", "Sue", "Freeman", 1960, 10, 10, Person.FEMALE);
   pm.addPerson("Richard", "Warren", "Miller", 1970, 2, 29, Person.MALE);

   pm.listPeople();

   pm.deletePersonAtIndex(1);
   pm.insertPersonAtIndex(1, "Coralie", "Sylvia", "Miller", 1962, 8, 3, Person.FEMALE);

   System.out.println();
   pm.listPeople();

   } // end main
}// end PeopleManagerApplication class