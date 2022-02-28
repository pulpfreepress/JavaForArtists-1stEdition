/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleClient extends JFrame implements ActionListener {
 
    private JPanel panel1 = null;
    private JPanel panel2 = null;
    private JTextArea textarea1 = null;
    private JTextArea textarea2 = null;
    private JButton button1 = null;
    private JScrollPane scrollpane1 = null;
    private JScrollPane scrollpane2 = null;

    Socket socket = null;
    DataInputStream dis = null;
    DataOutputStream dos = null;

    public SimpleClient(String url){
     super("SimpleClient");
     panel1 = new JPanel();
     panel2 = new JPanel();
     textarea1 = new JTextArea(12, 25);
     textarea1.append("Enter your message here.");
     scrollpane1 = new JScrollPane(textarea1);
     textarea2 = new JTextArea(12, 25);
     textarea2.setEnabled(false);
     textarea2.append("Server response messages will appear here.\n");
     scrollpane2 = new JScrollPane(textarea2);
     panel1.add(scrollpane1);
     panel1.add(scrollpane2);
     button1 = new JButton("Send");
     button1.addActionListener(this);
     panel2.add(button1);
     this.getContentPane().add(panel1);
     this.getContentPane().add(BorderLayout.SOUTH, panel2);
     this.setSize(620, 300);
     this.setLocation(200, 200);
     this.show();
     
     try{
       System.out.println("Creating Socket object...");
       socket = new Socket(url, 5001);
       System.out.println("Creating IOStream objects...");
       
       dos = new DataOutputStream(socket.getOutputStream());
       dis = new DataInputStream(socket.getInputStream());

      }catch(Exception e){
        e.printStackTrace();
      }
       System.out.println("Ready to send commands to the server...");
    }

    public void actionPerformed(ActionEvent ae){
      if(ae.getActionCommand().equals("Send")){
        System.out.println(textarea1.getText());     
       
       System.out.println("Sending text to server..."); 
       try{
       dos.writeUTF(textarea1.getText());
       }catch(Exception e){
         e.printStackTrace();
         }
       
       System.out.println("Reading text from server...");
        try{
        textarea2.append(dis.readUTF() + "\n");
        }catch(Exception e){
           e.printStackTrace();
           }

        if(textarea1.getText().equals("disconnect client") || 
                               textarea1.getText().equals("shutdown server")){
          System.out.println("Client shutting down...");
          try{
            socket.close();
           }catch(Exception e){
             e.printStackTrace();
             }
          System.exit(0);
         }
      }
    } // end actionPerformed() method

 
   public static void main(String[] args){
     System.out.println("SimpleClient lives!");
     try{
     new SimpleClient(args[0]);
     }catch(NullPointerException npe){
       System.out.println("Usage: java SimpleClient <host>");
     }
      catch(ArrayIndexOutOfBoundsException oobe){
       System.out.println("Usage: java SimpleClient <host>");
      }
      catch(Exception e){
       e.printStackTrace();
      }
   }// end main()
}
