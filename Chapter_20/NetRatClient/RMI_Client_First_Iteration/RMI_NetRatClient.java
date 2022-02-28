/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RMI_NetRatClient extends JFrame implements ActionListener {
  
  private JButton _button1 = null;
  private JButton _button2 = null;
  private JButton _button3 = null;
  private JButton _button4 = null;
  private JButton _button5 = null;
  private JButton _button6 = null;
  private JButton _button7 = null;
  private JButton _button8 = null;
  private JButton _button9 = null;
  private RobotRatInterface _robot_rat = null;
  

  public RMI_NetRatClient(String host){
    super("Robot Rat Control Panel"); 

  try{
     _robot_rat = (RobotRatInterface)Naming.lookup("rmi://" + host + "/Robot_Rat");
           
     }catch(Exception e){
      e.printStackTrace();
     }
    this.setUpGui();       
  }

  public void actionPerformed(ActionEvent ae){
   try{ 
   if(ae.getActionCommand().equals("N")){
      _robot_rat.moveNorth();    
    }else if(ae.getActionCommand().equals("NE")){
      _robot_rat.moveNorthEast();
    }else if(ae.getActionCommand().equals("E")){
      _robot_rat.moveEast();
    }else if(ae.getActionCommand().equals("SE")){
     _robot_rat.moveSouthEast();
    }else if(ae.getActionCommand().equals("S")){
      _robot_rat.moveSouth();
    }else if(ae.getActionCommand().equals("SW")){
      _robot_rat.moveSouthWest();
    }else if(ae.getActionCommand().equals("W")){
      _robot_rat.moveWest();
    }else if(ae.getActionCommand().equals("NW")){
     _robot_rat.moveNorthWest();
    }

   }catch(RemoteException re){
     System.out.println("actionPerformed(): problem calling remote robot_rat method.");
     re.printStackTrace();
    }
  } // end constructor

  public void setUpGui(){
   _button1 = new JButton("NW");
   _button1.addActionListener(this);

   _button2 = new JButton("N");
   _button2.addActionListener(this);

   _button3 = new JButton("NE");
   _button3.addActionListener(this);

   _button4 = new JButton("W");
   _button4.addActionListener(this);

   _button5 = new JButton("");
   _button5.addActionListener(this);

   _button6 = new JButton("E");
   _button6.addActionListener(this);

   _button7 = new JButton("SW");
   _button7.addActionListener(this);

   _button8 = new JButton("S");
   _button8.addActionListener(this);

   _button9 = new JButton("SE");
   _button9.addActionListener(this);

   this.getContentPane().setLayout(new GridLayout(3,3,0,0));
   this.getContentPane().add(_button1);
   this.getContentPane().add(_button2);
   this.getContentPane().add(_button3);
   this.getContentPane().add(_button4);
   this.getContentPane().add(_button5);
   this.getContentPane().add(_button6);
   this.getContentPane().add(_button7);
   this.getContentPane().add(_button8);
   this.getContentPane().add(_button9);
   this.setSize(200, 200);
   this.setLocation(300, 300);
   this.pack();
   this.show();
  } // end setUpGui()


  public static void main(String[] args){
     try{
       new RMI_NetRatClient(args[0]);
     }catch(ArrayIndexOutOfBoundsException e1){
        System.out.println("Usage: java NetRatClient <host>");
      }
      catch(Exception e2){
        e2.printStackTrace();
      }
  }// end main()
}// end RMI_NetRatClient class definition
