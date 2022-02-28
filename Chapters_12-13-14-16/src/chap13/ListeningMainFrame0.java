/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

public class ListeningMainFrame0 extends chap12.MainFrame {

  public ListeningMainFrame0() {
    setTitle("Handling GUI Events");
    addListeners();
  }
  protected void addListeners() {}
  public static void main(String[] arg) {
    ListeningMainFrame0 frame = new ListeningMainFrame0();
  }
}