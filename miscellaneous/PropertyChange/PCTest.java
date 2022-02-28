/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PCTest extends JFrame implements ComponentListener {


  public PCTest(){
    this.setSize(200, 200);
    this.setLocation(300, 300);
    this.addComponentListener(this);
    this.show();
  }

  public void componentHidden(ComponentEvent e){ }
  public void componentMoved(ComponentEvent e){
    Point point = this.getLocation(new Point());
    System.out.println("Location x: " + point.getX() + " " + "Location y: " + point.getY());
    }

  public void componentResized(ComponentEvent e){
    System.out.println("Height: " + this.getHeight() + " " + "Width: " + this.getWidth());
   }
  
  public void componentShown(ComponentEvent e){ }

  public static void main(String[] args){
     new PCTest();

  }

}
