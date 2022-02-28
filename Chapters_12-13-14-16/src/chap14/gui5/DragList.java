/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.gui5;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.EventListener;
import java.util.EventObject;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

public class DragList extends JList implements MouseInputListener {

  private Object dragItem;
  private int dragIndex = -1;
  private BufferedImage dragImage;
  private Rectangle dragRect = new Rectangle();
  private boolean inDrag = false;

  private Point dragStart;
  private int deltaY;
  private int dragThreshold;

  private boolean allowDrag;

  private Vector listeners = new Vector();

  public DragList() {
    this(new DefaultListModel());
  }
  public DragList(DefaultListModel lm) {
    super(lm);
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  public void setModel(ListModel lm) {
    super.setModel((DefaultListModel)lm);
  }
  public void setListData(Object[] listData) {
    DefaultListModel model = (DefaultListModel)getModel();
    model.clear();
    for (int i = 0; i < listData.length; ++i) {
      model.addElement(listData[i]);
    }
  }
  public void setListData(Vector listData) {
    DefaultListModel model = (DefaultListModel)getModel();
    model.clear();
    for (Iterator it = listData.iterator(); it.hasNext();) {
      model.addElement(it.next());
    }
  }
  private void createDragImage() {
    if (dragImage == null
      || dragImage.getWidth() != dragRect.width
      || dragImage.getHeight() != dragRect.height) {
      dragImage =
        new BufferedImage(
          dragRect.width,
          dragRect.height,
          BufferedImage.TYPE_INT_RGB);
    }
    Graphics g = dragImage.getGraphics();

    ListCellRenderer renderer = getCellRenderer();
    Component comp =
      renderer.getListCellRendererComponent(
        this,
        dragItem,
        dragIndex,
        true,
        true);
    SwingUtilities.paintComponent(
      g,
      comp,
      this,
      0,
      0,
      dragRect.width,
      dragRect.height);
  }
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (inDrag) {
      Graphics2D g2 = (Graphics2D)g;
      g2.setColor(getBackground());
      Rectangle r = getCellBounds(dragIndex, dragIndex);
      g2.fillRect(r.x, r.y, r.width, r.height);
      Composite saveComposite = g2.getComposite();
      g2.setComposite(
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
      g2.drawImage(dragImage, dragRect.x, dragRect.y, this);
      g2.setComposite(saveComposite);
    }
  }
  public void mousePressed(MouseEvent e) {
    allowDrag = false;
    if (!SwingUtilities.isLeftMouseButton(e)) {
      return;
    }
    dragStart = e.getPoint();
    dragIndex = locationToIndex(dragStart);
    if (dragIndex < 0) {
      return;
    }
    dragRect = getCellBounds(dragIndex, dragIndex);
    if (!dragRect.contains(dragStart)) {
      clearSelection();
      return;
    }
    allowDrag = true;
    DefaultListModel model = (DefaultListModel)getModel();
    dragItem = model.getElementAt(dragIndex);
    dragThreshold = dragRect.height / 4;
    deltaY = dragStart.y - dragRect.y;
  }
  public void mouseDragged(MouseEvent e) {
    if (!allowDrag) {
      return;
    }
    Point mouse = e.getPoint();
    if (!inDrag && Math.abs(mouse.y - dragStart.y) < dragThreshold) {
      return;
    }
    if (!inDrag) {
      clearSelection();
      createDragImage();
      inDrag = true;
    }
    //remember dragRect.y
    int oldTop = dragRect.y;

    dragRect.y = mouse.y - deltaY;
    //dragRect is now at the accurate vertical location
    //shift dragRect up or down as necessary so that it doesn't 
    //spill over the top or bottom of the DragList
    Insets insets = getInsets();
    dragRect.y = Math.max(dragRect.y, insets.top);
    dragRect.y =
      Math.min(dragRect.y, getHeight() - dragRect.height - insets.bottom);

    //index is the index of the item located at the vertical center of dragRect
    int index =
      locationToIndex(new Point(mouse.x, dragRect.y + dragRect.height / 2));
    if (dragIndex != index) {
      DefaultListModel model = (DefaultListModel)getModel();
      //move dragItem to the new location in the list
      model.remove(dragIndex);
      model.add(index, dragItem);
      dragIndex = index;
    }

    int minY = Math.min(dragRect.y, oldTop);
    int maxY = Math.max(dragRect.y, oldTop);
    repaint(dragRect.x, minY, dragRect.width, maxY + dragRect.height);
  }
  public void mouseReleased(MouseEvent e) {
    if (inDrag) {
      setSelectedIndex(dragIndex);
      inDrag = false;
      repaint(dragRect);
      notifyListeners(new ReorderEvent(this));
    }
  }

  public void mouseClicked(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  public static class ReorderEvent extends EventObject {
    public ReorderEvent(DragList dragList) {
      super(dragList);
    }
  }
  public static interface ReorderListener extends EventListener {
    public void listReordered(ReorderEvent e);
  }
  public void addReorderListener(ReorderListener rl) {
    listeners.add(rl);
  }
  public void removeReorderListener(ReorderListener rl) {
    listeners.remove(rl);
  }
  private void notifyListeners(ReorderEvent event) {
    for (Iterator it = listeners.iterator(); it.hasNext();) {
      ReorderListener rl = (ReorderListener)it.next();
      rl.listReordered(event);
    }
  }
}