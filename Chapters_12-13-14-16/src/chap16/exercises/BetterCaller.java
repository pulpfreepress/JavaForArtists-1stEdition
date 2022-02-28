/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.exercises;

public class BetterCaller {
  private String name;
  private Object callLock = new Object();
  private Object answerLock = new Object();

  public BetterCaller(String s) {
    name = s;
  }
  public void answer() {
    synchronized (answerLock) {
      System.out.println(name + " is available!");
    }
  }
  public void call(BetterCaller other) {
    synchronized (callLock) {
      System.out.println(this +" calling " + other);
      other.answer();
    }
  }
  public String toString() {
    return name;
  }
}
