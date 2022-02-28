/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.exercises;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class DragTable extends JTable implements MouseInputListener {

  private final int DEFAULT_COL = 0;

  private int dragIndex = -1;
  private BufferedImage dragImage;
  private Rectangle dragRect = new Rectangle();
  private boolean inDrag = false;

  private Point dragStart;
  private int deltaY;
  private int dragThreshold;

  private boolean allowDrag;

  private Vector listeners = new Vector();

  public DragTable() {
    this(new DefaultTableModel());
  }
  public DragTable(DefaultTableModel lm) {
    super(lm);
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  public void setModel(TableModel lm) {
    super.setModel((DefaultTableModel)lm);
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
    g.translate(0, -dragRect.y);
    setRowSelectionInterval(dragIndex, dragIndex);
    print(g);
  }
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (inDrag) {
      Graphics2D g2 = (Graphics2D)g;
      g2.setColor(getBackground());
      Rectangle r = getCellRect(dragIndex, DEFAULT_COL, false);
      r.x = 0;
      r.width = getWidth();
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
    dragIndex = rowAtPoint(dragStart);
    if (dragIndex < 0) {
      return;
    }
    dragRect = getCellRect(dragIndex, DEFAULT_COL, true);
    dragRect.width = this.getWidth();
    dragRect.x = 0;
    if (!dragRect.contains(dragStart)) {
      clearSelection();
      return;
    }
    allowDrag = true;
    DefaultTableModel model = (DefaultTableModel)getModel();
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
    clearSelection();
    if (!inDrag) {
      createDragImage();
      inDrag = true;
    }
    //remember dragRect.y
    int oldTop = dragRect.y;

    dragRect.y = mouse.y - deltaY;
    //dragRect is now at the accurate vertical location
    //shift dragRect up or down as necessary so that it doesn't 
    //spill over the top or bottom of the DragTable
    Insets insets = getInsets();
    dragRect.y = Math.max(dragRect.y, insets.top);
    dragRect.y =
      Math.min(dragRect.y, getHeight() - dragRect.height - insets.bottom);

    //index is the index of the item located at the vertical center of dragRect
    int index =
      rowAtPoint(new Point(mouse.x, dragRect.y + dragRect.height / 2));
    if (dragIndex != index) {
      DefaultTableModel model = (DefaultTableModel)getModel();
      //move dragged row to the new location in the table
      model.moveRow(dragIndex, dragIndex, index);
    }
    dragIndex = index;

    int minY = Math.min(dragRect.y, oldTop);
    int maxY = Math.max(dragRect.y, oldTop);
    repaint(dragRect.x, minY, dragRect.width, maxY + dragRect.height);
  }
  public void mouseReleased(MouseEvent e) {
    if (inDrag) {
      setRowSelectionInterval(dragIndex, dragIndex);
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
    public ReorderEvent(DragTable dragTable) {
      super(dragTable);
    }
  }
  public static interface ReorderListener extends EventListener {
    public void rowsReordered(ReorderEvent e);
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
      rl.rowsReordered(event);
    }
  }
  public static void main(String[] arg) {
    JFrame f = new JFrame();
    Object[][] data = { { "a1", "a2", "a3" }, {
        "b1", "b2", "b3" }, {
        "c1", "c2", "c3" }, {
        "d1", "d2", "d3" }
    };
    Object[] columns = { "1", "2", "3" };

    DefaultTableModel model = new DefaultTableModel(data, columns);
    DragTable table = new DragTable(model);

    //TableEditor tableEditor = new TableEditor();
		//TableColumn col0 = table.getColumnModel().getColumn(0);
		//col0.setCellEditor(tableEditor);
		//table.setDefaultEditor(Object.class, tableEditor);
    
    table.setSelectionBackground(Color.yellow);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(BorderFactory.createLineBorder(Color.red, 10));
    f.setContentPane(contentPane);
    f.getContentPane().add(BorderLayout.CENTER, new JScrollPane(table));
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.pack();
    f.setVisible(true);
  }
}