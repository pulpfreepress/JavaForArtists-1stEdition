/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.deadlock;

public class Caller {
  private String name;

  public Caller(String s) {
    name = s;
  }
  public synchronized void answer() {
    System.out.println(name + " is available!");
  }
  public synchronized void call(Caller other) {
    System.out.println(this +" calling " + other);
    other.answer();
  }
  public String toString() {
    return name;
  }
}