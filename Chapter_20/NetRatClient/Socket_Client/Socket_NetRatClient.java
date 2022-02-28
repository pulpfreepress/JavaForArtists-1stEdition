/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Socket_NetRatClient extends JFrame implements ActionListener {
  
  private JButton _button1 = null;
  private JButton _button2 = null;
  private JButton _button3 = null;
  private JButton _button4 = null;
  private JButton _button5 = null;
  private JButton _button6 = null;
  private JButton _button7 = null;
  private JButton _button8 = null;
  private JButton _button9 = null;
  private Socket  _socket  = null;
  private DataInputStream  _dis = null;
  private DataOutputStream _dos = null;
  
  private static final int NORTH      = 0;
  private static final int NORTH_EAST = 1;
  private static final int EAST       = 2;
  private static final int SOUTH_EAST = 3;
  private static final int SOUTH      = 4;
  private static final int SOUTH_WEST = 5;
  private static final int WEST       = 6;
  private static final int NORTH_WEST = 7;
  

  public Socket_NetRatClient(String host){
    super("Robot Rat Control Panel"); 

  try{
     _socket = new Socket(host, 5001);
     _dos = new DataOutputStream(_socket.getOutputStream());
     _dis = new DataInputStream(_socket.getInputStream());
     }catch(Exception e){
      e.printStackTrace();
     }
    this.setUpGui();       
  }

  public void actionPerformed(ActionEvent ae){
   try{ 
   if(ae.getActionCommand().equals("N")){
       _dos.writeInt(NORTH);
       System.out.println(_dis.readUTF());
    }else if(ae.getActionCommand().equals("NE")){
       _dos.writeInt(NORTH_EAST);
       System.out.println(_dis.readUTF());
    }else if(ae.getActionCommand().equals("E")){
       _dos.writeInt(EAST);
       System.out.println(_dis.readUTF());
    }else if(ae.getActionCommand().equals("SE")){
       _dos.writeInt(SOUTH_EAST);
       System.out.println(_dis.readUTF());
    }else if(ae.getActionCommand().equals("S")){
       _dos.writeInt(SOUTH);
       System.out.println(_dis.readUTF());
    }else if(ae.getActionCommand().equals("SW")){
       _dos.writeInt(SOUTH_WEST);
       System.out.println(_dis.readUTF());
    }else if(ae.getActionCommand().equals("W")){
       _dos.writeInt(WEST);
       System.out.println(_dis.readUTF());
    }else if(ae.getActionCommand().equals("NW")){
       _dos.writeInt(NORTH_WEST);
       System.out.println(_dis.readUTF());
    }

   }catch(Exception e){
     System.out.println("actionPerformed(): problem with socket IO.");
     e.printStackTrace();
    }
  }

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
  } // end setUpGui() method


  public static void main(String[] args){
     try{
       new Socket_NetRatClient(args[0]);
     }catch(ArrayIndexOutOfBoundsException e1){
        System.out.println("Usage: java NetRatClient <host>");
      }
      catch(Exception e2){
        e2.printStackTrace();
      }
  }// end main() method
 
}// end Socket_NetRatClient class definition
