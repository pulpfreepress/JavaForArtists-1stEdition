/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.deadlock;

public class Breaker extends Thread {
  private Caller caller;
  private Caller answerer;

  public Breaker(Caller caller, Caller answerer) {
    this.caller = caller;
    this.answerer = answerer;
  }
  public void run() {
    while (true) {
      caller.call(answerer);
    }
  }
  public static void main(String[] arg) {
    Caller a = new Caller("A");
    Caller b = new Caller("B");

    Breaker breakerA = new Breaker(a, b);
    Breaker breakerB = new Breaker(b, a);

    breakerA.start();
    breakerB.start();
  }
}