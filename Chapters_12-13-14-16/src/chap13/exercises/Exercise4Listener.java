/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13.exercises;

import java.awt.event.*;

import javax.swing.event.*;

public class Exercise4Listener
  implements
    MenuDragMouseListener,
    MenuKeyListener,
    ActionListener,
    ChangeListener,
    ItemListener,
    AncestorListener,
    ContainerListener,
    ComponentListener,
    FocusListener,
    HierarchyBoundsListener,
    HierarchyListener,
    InputMethodListener,
    KeyListener,
    MouseListener,
    MouseMotionListener,
    MouseWheelListener {

  public void actionPerformed(ActionEvent e) {
    System.out.println("actionPerformed");
  }
  public void itemStateChanged(ItemEvent e) {
    System.out.println("itemStateChanged");
  }
  public void componentAdded(ContainerEvent e) {
    System.out.println("componentAdded");
  }
  public void componentRemoved(ContainerEvent e) {
    System.out.println("componentRemoved");
  }
  public void componentResized(ComponentEvent e) {
    System.out.println("componentResized");
  }
  public void componentMoved(ComponentEvent e) {
    System.out.println("componentMoved");
  }
  public void componentShown(ComponentEvent e) {
    System.out.println("componentShown");
  }
  public void componentHidden(ComponentEvent e) {
    System.out.println("componentHidden");
  }
  public void focusGained(FocusEvent e) {
    System.out.println("focusGained");
  }
  public void focusLost(FocusEvent e) {
    System.out.println("focusLost");
  }
  public void ancestorMoved(HierarchyEvent e) {
    System.out.println("ancestorMoved");
  }
  public void ancestorResized(HierarchyEvent e) {
    System.out.println("ancestorResized");
  }
  public void hierarchyChanged(HierarchyEvent e) {
    System.out.println("hierarchyChanged");
  }
  public void inputMethodTextChanged(InputMethodEvent event) {
    System.out.println("inputMethodTextChanged");
  }
  public void caretPositionChanged(InputMethodEvent event) {
    System.out.println("caretPositionChanged");
  }
  public void keyTyped(KeyEvent e) {
    System.out.println("keyTyped");
  }
  public void keyPressed(KeyEvent e) {
    System.out.println("keyPressed");
  }
  public void keyReleased(KeyEvent e) {
    System.out.println("keyReleased");
  }
  public void mouseClicked(MouseEvent e) {
    System.out.println("mouseClicked");
  }
  public void mousePressed(MouseEvent e) {
    System.out.println("mousePressed");
  }
  public void mouseReleased(MouseEvent e) {
    System.out.println("mouseReleased");
  }
  public void mouseEntered(MouseEvent e) {
    System.out.println("mouseEntered");
  }
  public void mouseExited(MouseEvent e) {
    System.out.println("mouseExited");
  }
  public void mouseDragged(MouseEvent e) {
    System.out.println("mouseDragged");
  }
  public void mouseMoved(MouseEvent e) {
    System.out.println("mouseMoved");
  }
  public void mouseWheelMoved(MouseWheelEvent e) {
    System.out.println("mouseWheelMoved");
  }
  public void menuDragMouseEntered(MenuDragMouseEvent e) {
    System.out.println("menuDragMouseEntered");
  }
  public void menuDragMouseExited(MenuDragMouseEvent e) {
    System.out.println("menuDragMouseExited");
  }
  public void menuDragMouseDragged(MenuDragMouseEvent e) {
    System.out.println("menuDragMouseDragged");
  }
  public void menuDragMouseReleased(MenuDragMouseEvent e) {
    System.out.println("menuDragMouseReleased");
  }
  public void menuKeyTyped(MenuKeyEvent e) {
    System.out.println("menuKeyTyped");
  }
  public void menuKeyPressed(MenuKeyEvent e) {
    System.out.println("menuKeyPressed");
  }
  public void menuKeyReleased(MenuKeyEvent e) {
    System.out.println("menuKeyReleased");
  }
  public void stateChanged(ChangeEvent e) {
    System.out.println("stateChanged");
  }
  public void ancestorAdded(AncestorEvent event) {
    System.out.println("ancestorAdded");
  }
  public void ancestorRemoved(AncestorEvent event) {
    System.out.println("ancestorRemoved");
  }
  public void ancestorMoved(AncestorEvent event) {
    System.out.println("ancestorMoved");
  }
}