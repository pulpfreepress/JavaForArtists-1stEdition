/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.exercises;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JokeFrame extends JFrame {
  public JokeFrame() {
    final JPanel contentPane = new JPanel(null);
    contentPane.setBorder(null);
    final JButton quitButton = new JButton("Quit Application");
    contentPane.add(quitButton);
    setContentPane(contentPane);
    quitButton.addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent e) {
        escape(quitButton, e);
      }
    });
    quitButton.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        escape(quitButton, e);
      }
    });
    quitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	System.exit(0);
      }
    });
    quitButton.setSize(quitButton.getPreferredSize());
    setSize(300, 150);
    Rectangle bounds = getBounds();
    quitButton.setLocation(
      bounds.width / 2 - quitButton.getWidth() / 2,
      bounds.height / 2 - quitButton.getHeight() / 2);
    getRootPane().setDefaultButton(quitButton);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  }
  private void escape(Component comp, MouseEvent e) {
    Container parent = comp.getParent();
    int[] deltas = new int[4];
    Point p = e.getPoint();
    int w = comp.getWidth();
    int h = comp.getHeight();
    int x = comp.getX();
    int y = comp.getY();
    int left = deltas[0] = p.x;
    int top = deltas[1] = p.y;
    int right = deltas[2] = w - p.x;
    int bottom = deltas[3] = h - p.y;
    Arrays.sort(deltas);
    if (left == deltas[0]) {
      p.x = x + p.x + 1;
      if (p.x + w >= parent.getWidth()) {
        p.x = x - w - 1;
      }
      p.y = y;
    } else if (top == deltas[0]) {
      p.y = y + p.y + 1;
      if (p.y + h >= parent.getHeight()) {
        p.y = y - h - 1;
      }
      p.x = x;
    } else if (right == deltas[0]) {
      p.x = x - right - 1;
      if (p.x <= 0) {
        p.x = w + 1;
      }
      p.y = y;
    } else if (bottom == deltas[0]) {
      p.y = y - bottom - 1;
      if (p.y <= 0) {
        p.y = h + 1;
      }
      p.x = x;
    }
		if(p.x < 0 || p.x + w > parent.getWidth()){
			p.x = 0;
		}
		if(p.y < 0 || p.y + h > parent.getHeight()){
			p.y = 0;
		}
    comp.setLocation(p.x, p.y);
  }
  public static void main(String[] arg) {
		new JokeFrame().setVisible(true);
  }
}