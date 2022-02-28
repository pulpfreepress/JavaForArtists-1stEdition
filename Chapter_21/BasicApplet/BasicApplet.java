/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.applet.*;
import java.awt.*;
import javax.swing.*;

public class BasicApplet extends JApplet {

  private static JTextArea textarea = null;
  private static JScrollPane scrollpane = null;
  
  public void init(){
    textarea = new JTextArea(10, 30);
    scrollpane = new JScrollPane(textarea);
    getContentPane().add(scrollpane);
    textarea.append("BasicApplet init() method called.\n");
    System.out.println("BasicApplet init() method called.");
  }

  public void start(){
    System.out.println("BasicApplet start() method called.");
    textarea.append("BasicApplet start() method called.\n");
  }

  public void stop(){
    System.out.println("BasicApplet stop() method called.");
    textarea.append("BasicApplet stop() method called.\n");
  }
  
  public void destroy(){
    System.out.println("BasicApplet destroy() method called.");
    textarea.append("BasicApplet destroy() method called.\n");
  }
} // end BasicApplet class definition
