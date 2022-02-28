/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.applet.*;
import javax.swing.*;

public class AppletServer extends JApplet {

   JTextArea _textarea = null;
   JScrollPane _scrollpane = null;
   ServerThread _st = null;

   public void init(){
     _textarea = new JTextArea(10, 20);
     _scrollpane = new JScrollPane(_textarea);
     this.getContentPane().add(_scrollpane);
     System.out.println("AppletServer init() method called...");
  }

  public void start(){
    _st = new ServerThread(_textarea);
    _st.start();
    System.out.println("AppletServer start() method called...");
  }
} // end AppletServer class definition
