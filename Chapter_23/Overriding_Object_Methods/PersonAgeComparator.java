/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;
import java.io.*;

public final class PersonAgeComparator implements Comparator, Serializable {
   public final int compare(Object o1, Object o2){
     int result = 0;
     if(((Person)o1).getAge() < ((Person)o2).getAge()) 
        result = -1;
        else if(((Person)o1).getAge() == ((Person)o2).getAge())
              result = 0;
              else if(((Person)o1).getAge() > ((Person)o2).getAge())
                result = 1;
     return result;
   }
   
   public final boolean equals(Object o){
     if(o == null) return false;
     boolean is_equal = false;
     if(o instanceof PersonAgeComparator){
        is_equal = true;
      }
      return is_equal;
   }
} // end PersonAgeComparator
