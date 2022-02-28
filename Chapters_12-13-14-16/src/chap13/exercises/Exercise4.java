/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13.exercises;

import chap13.ListeningMainFrame0;

public class Exercise4 extends ListeningMainFrame0 {
	protected void addListeners() {
		super.addListeners();
    Exercise4Listener el = new Exercise4Listener();
    menuItem1.addMenuDragMouseListener(el);
    menuItem1.addMenuKeyListener(el);
    menuItem1.addActionListener(el);
    menuItem1.addChangeListener(el);
    menuItem1.addItemListener(el);
    menuItem1.addAncestorListener(el);
    menuItem1.addContainerListener(el);
    menuItem1.addComponentListener(el);
    menuItem1.addFocusListener(el);
    menuItem1.addHierarchyBoundsListener(el);
    menuItem1.addHierarchyListener(el);
    menuItem1.addInputMethodListener(el);
    menuItem1.addKeyListener(el);
    menuItem1.addMouseListener(el);
    menuItem1.addMouseMotionListener(el);
    menuItem1.addMouseWheelListener(el);
  }
  public static void main(String[] arg) {
		Exercise4 frame = new Exercise4();
  }
}