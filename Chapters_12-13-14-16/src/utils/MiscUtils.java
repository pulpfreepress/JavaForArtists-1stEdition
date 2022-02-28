/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package utils;

import java.awt.Rectangle;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiscUtils {
  /**
    * Centers Window w1 with respect to Window w2. If w2 is null, centers w1 in 
    * the screen.
    * @param w1 the window whose location will be adjusted
    * @param w2 the window whose location will remain unchanged
    */
  public static void centerWindow(Window w1, Window w2) {
    Rectangle b1 = w1.getBounds();
    Rectangle b2 =
      w2 == null ? w1.getGraphicsConfiguration().getBounds() : w2.getBounds();
    b1.x = b2.x + (b2.width - b1.width) / 2;
    b1.y = b2.y + (b2.height - b1.height) / 2;
    if (b1.x < 0) {
      b1.x = 0;
    }
    if (b1.y < 0) {
      b1.y = 0;
    }
    w1.setBounds(b1);
  }
  public static void showShutdownWindow() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(
      new JLabel("Close this window to shut down the JVM"));
    f.pack();
    MiscUtils.centerWindow(f, null);
    f.show();
  }
}