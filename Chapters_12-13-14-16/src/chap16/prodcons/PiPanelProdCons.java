/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.prodcons;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import chap16.pi.PiPanel1;

public class PiPanelProdCons extends PiPanel1 {
  private DigitHolder holder;

  public PiPanelProdCons(DigitHolder holder) {
    this.holder = holder;
    startConsumer();
  }
  private void startConsumer() {
    Thread consumerThread = new Thread() {
      public void run() {
        while (true) {
          int digit = holder.retrieve();
          displayDigit(digit);
        }
      }
    };
    consumerThread.start();
  }
  //called constantly by producer thread
  protected void handleDigit(int digit) {
    holder.store(digit);
  }
  public static void main(String[] arg) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    DigitHolder holder = null;
    if (arg.length > 0) {
      if ("bad".equals(arg[0])) {
        holder = new BadDigitHolder();
      } else if ("good".equals(arg[0])) {
        holder = new GoodDigitHolder();
      }
    }
    if (holder == null) {
      holder = new DefaultDigitHolder();
    }
    f.getContentPane().add(new PiPanelProdCons(holder), BorderLayout.CENTER);
    f.getContentPane().add(new chap16.clock.ClockPanel1(), BorderLayout.NORTH);
    f.pack();
    f.show();
  }
}