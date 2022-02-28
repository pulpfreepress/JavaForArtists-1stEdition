/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NetRatServer extends JFrame implements ActionListener {

  private JButton button1 = null;
  private RobotRat _r1 = null;
  private RobotRat _r2 = null;
  
  public NetRatServer(){
   
    _r1 = new RobotRat();
    _r2 = new RobotRat();
    button1 =  new JButton("move");
    button1.addActionListener(this);
    this.getContentPane().add(button1);
    this.setSize(100, 100);
    this.setLocation(300, 300);
    this.show();
  }
  
  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("move")){
      _r1.moveEast();
      _r2.moveSouthEast();
    }
  }
  
  public static void main(String[] args){
    System.out.println("NetRatServer Lives!!");
    new NetRatServer();
  } // end main() 
}// end NetRatServer class definition
