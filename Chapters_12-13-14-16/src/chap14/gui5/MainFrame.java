/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.gui5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.util.Collections;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;

import utils.ResourceUtils;
import chap14.gui0.DressingBoard;
import chap14.gui0.Garment;
import chap14.gui4.CheckboxListCell;

public class MainFrame
  extends JFrame
  implements DragList.ReorderListener, CheckboxListCell.ToggleListener {

  private DressingBoard dressingBoard;
  private DragList garmentList;

  public MainFrame() {
    setTitle(getClass().getName());
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel topPanel = new JPanel(new BorderLayout());
    topPanel.setBorder(BorderFactory.createEtchedBorder());

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add("Center", topPanel);

    JPanel mainPanel = new JPanel(new BorderLayout());
    topPanel.add("Center", mainPanel);
    String instructions =
      "Click the checkboxes to put on or remove garments."
        + " Drag the labels to determine order.";
    topPanel.add("North", new JLabel(instructions, JLabel.CENTER));

    dressingBoard = new DressingBoard();
    mainPanel.add("Center", dressingBoard);

    garmentList = new DragList();
    garmentList.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    CheckboxListCell ccr = new CheckboxListCell() {
      protected boolean getCheckedValue(Object value) {
        return ((Garment)value).isWorn();
      }
    };
    ccr.addToggleListener(this);
    garmentList.addMouseListener(ccr);
    garmentList.setCellRenderer(ccr);
    garmentList.addReorderListener(this);
    mainPanel.add("West", garmentList);

    initList();
  }
  private void initList() {
    String[] names =
      {
        "T-Shirt",
        "Briefs",
        "Left Sock",
        "Right Sock",
        "Shirt",
        "Pants",
        "Belt",
        "Tie",
        "Left Shoe",
        "Right Shoe" };
    Point[] points =
      {
        new Point(75, 125),
        new Point(86, 197),
        new Point(127, 256),
        new Point(45, 260),
        new Point(69, 118),
        new Point(82, 199),
        new Point(88, 203),
        new Point(84, 124),
        new Point(129, 258),
        new Point(40, 268)};

    Vector garments = new Vector(names.length);
    for (int i = 0; i < names.length; ++i) {
      Image image =
        ResourceUtils.loadImage("chap14/images/" + names[i] + ".gif", this);
      Garment garment = new Garment(image, points[i].x, points[i].y, names[i]);
      garments.add(garment);
    }
    Collections.shuffle(garments);
    garmentList.setListData(garments);
  }
  public void listReordered(DragList.ReorderEvent e) {
    redrawBoy();
  }
  public void checkboxToggled(CheckboxListCell.ToggleEvent event) {
    JList list = (JList)event.getSource();
    int index = event.getIndex();
    Garment garment = (Garment)list.getModel().getElementAt(index);
    garment.setWorn(!garment.isWorn());
    redrawBoy();
  }
  private void redrawBoy() {
    ListModel lm = garmentList.getModel();
    int stop = lm.getSize();
    Vector order = new Vector();
    for (int i = 0; i < stop; ++i) {
      Garment garment = (Garment)lm.getElementAt(i);
      if (garment.isWorn()) {
        order.add(garment);
      }
    }
    dressingBoard.setOrder((Garment[])order.toArray(new Garment[0]));
  }
  public static void main(String[] arg) {
    new MainFrame().setVisible(true);
  }
}