/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13.exercises;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import chap13.ListeningMainFrame1;

public class Exercise1 extends ListeningMainFrame1 {
  protected void addListeners() {
    super.addListeners();
    MyMouseListener myMouseListener = new MyMouseListener();
    textArea.addMouseListener(myMouseListener);
    textArea.addMouseMotionListener(myMouseListener);
    textArea.addMouseWheelListener(myMouseListener);
  }
  public static void main(String[] arg) {
    Exercise1 frame = new Exercise1();
  }

  private class MyMouseListener implements MouseListener, MouseMotionListener, MouseWheelListener {
    public void mouseClicked(MouseEvent e) {
      displayEvent(e);
    }
    public void mousePressed(MouseEvent e) {
      displayEvent(e);
    }
    public void mouseReleased(MouseEvent e) {
      displayEvent(e);
    }
    public void mouseEntered(MouseEvent e) {
      displayEvent(e);
    }
    public void mouseExited(MouseEvent e) {
      displayEvent(e);
    }
    public void mouseDragged(MouseEvent e) {
      displayEvent(e);
    }
    public void mouseMoved(MouseEvent e) {
      displayEvent(e);
    }
    public void mouseWheelMoved(MouseWheelEvent e) {
      displayEvent(e);
    }
    private String getButtonName(MouseEvent e) {
      int button = e.getButton();
      if (button == MouseEvent.BUTTON1) {
        return "Button1";
      } else if (button == MouseEvent.BUTTON2) {
        return "Button2";
      } else if (button == MouseEvent.BUTTON3) {
        return "Button3";
      } else {
        return "Unidentified Button";
      }
    }
    private void displayEvent(MouseEvent e) {
      String s;
      int id = e.getID();
      if (id == MouseEvent.MOUSE_CLICKED) {
        s = getButtonName(e) + " mouseClicked[" + e.getClickCount() + "]";
      } else if (id == MouseEvent.MOUSE_PRESSED) {
        s = getButtonName(e) + " mousePressed[" + e.getClickCount() + "]";
      } else if (id == MouseEvent.MOUSE_RELEASED) {
        s = getButtonName(e) + " mouseReleased[" + e.getClickCount() + "]";
      } else if (id == MouseEvent.MOUSE_ENTERED) {
        s = "mouseEntered";
      } else if (id == MouseEvent.MOUSE_EXITED) {
        s = "mouseExited";
      } else if (id == MouseEvent.MOUSE_DRAGGED) {
        s = "mouseDragged";
      } else if (id == MouseEvent.MOUSE_MOVED) {
        s = "mouseMoved";
      } else if (id == MouseEvent.MOUSE_WHEEL) {
        s = "mouseWheelMoved";
      } else {
        s = "Unknown Event";
      }

      s += " :" + "(" + e.getX() + ", " + e.getY() + ")";
      System.out.println(s);
      eventLabel.setText(s);
    }
  }
}