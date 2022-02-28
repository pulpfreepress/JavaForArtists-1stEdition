/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.exercises;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GoodCounter extends JFrame implements Runnable {
  private long count = 0;
  private boolean running = false;

  public GoodCounter() {
    Container contentPane = getContentPane();
    JButton startButton = new JButton("Start");

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!running) {
					running = true;
					new Thread(GoodCounter.this).start();
				}
			}
		});
		
    final JLabel countLabel = new JLabel("Press \"Start\" to start counting");
    JButton updateButton = new JButton("Update Display");
    
    updateButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        countLabel.setText(String.valueOf(count));
      }
    });
    
    contentPane.add(BorderLayout.NORTH, startButton);
    contentPane.add(BorderLayout.CENTER, countLabel);
    contentPane.add(BorderLayout.SOUTH, updateButton);
    
    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void run() {
    while (count < Long.MAX_VALUE) {
      count++;
    }
  }
  public static void main(String[] arg) {
    new GoodCounter().show();
  }
}
