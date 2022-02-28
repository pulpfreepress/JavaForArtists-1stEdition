/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import javax.swing.*;
import java.awt.*;


public class TestFloor {

  Floor its_floor = null;
  Rat its_rat = null;
  JFrame its_frame = null;

 public TestFloor(){
  
  its_frame = new JFrame("Rat Floor");
  its_rat = new Rat(its_frame.getToolkit(), "Rat.gif");
  its_floor = new Floor(its_rat);
  its_frame.getContentPane().add(its_floor, BorderLayout.CENTER);
  its_frame.show();

}



 public static void main(String[] args){
    new TestFloor();
    for(;;);
 }

}