/*****************************************************************
  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press 
     
   This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.
*****************************************************************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class View extends JFrame {

	private Canvas canvas = null;
	private JButton button = null;
        private String message = "";

	public View(ActionListener al){
	  super("Motivational Messages");
	  canvas = new Canvas(){
            public void paint(Graphics g){
              g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	      g.setFont(new Font("Roman", Font.BOLD, 14));
	      g.drawString(message, 10, 20);
            }
          };
	  button = new JButton("Next Message");
	  button.addActionListener(al);
	  this.getContentPane().setLayout(new BorderLayout());
	  this.getContentPane().add(canvas);
	  this.getContentPane().add(BorderLayout.SOUTH, button);
	  this.setSize(400, 100);
	  this.show();
	}

	public void setMessage(String message){
          this.message = message;
          canvas.repaint();
	}

} // end View clas definition