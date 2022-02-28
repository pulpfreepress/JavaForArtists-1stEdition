/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.clock;

import java.text.DateFormat;
import java.util.Date;

public class Clock1 {
  public static void main(String[] arg) {
    Date date = new Date();
    DateFormat dateFormatter = DateFormat.getTimeInstance();
    String lastDateString = "";

    while (true) {
      long currentMillis = System.currentTimeMillis();
      date.setTime(currentMillis);
      String curDateString = dateFormatter.format(date);
      if (!lastDateString.equals(curDateString)) {
        lastDateString = curDateString;
        System.out.println(curDateString);
      }
    }
  }
}