/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.clock;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClockPanel2 extends JPanel implements Runnable {
  private final JLabel clockLabel;
  private final DateFormat dateFormatter = DateFormat.getTimeInstance();
  private final Date date = new Date();
  private final Thread clockThread;

  public ClockPanel2() {
    clockLabel = new JLabel("Clock warming up...", JLabel.CENTER);
    setLayout(new BorderLayout());
    add(clockLabel, BorderLayout.CENTER);
    clockThread = new Thread(this);
    clockThread.setName("Clock Thread");
    clockThread.start();
  }
  public void paintComponent(Graphics g) {
    updateTime();
    super.paintComponent(g);
  }
  private void updateTime() {
    long currentMillis = System.currentTimeMillis();
    date.setTime(currentMillis);
    String curDateString = dateFormatter.format(date);
    clockLabel.setText(curDateString);
  }
  public void run() {
    while (true) {
      long currentMillis = System.currentTimeMillis();
      long sleepMillis = 1000 - (currentMillis % 1000);
      repaint();
      try {
        Thread.sleep(sleepMillis);
      } catch (InterruptedException e) {}
    }
  }
  public static void main(String[] arg) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new ClockPanel2(), BorderLayout.NORTH);
    f.getContentPane().add(
      new JScrollPane(new JTextArea(20, 50)),
      BorderLayout.CENTER);

    f.pack();
    f.show();
  }
}
