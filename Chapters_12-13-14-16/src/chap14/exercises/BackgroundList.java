/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.exercises;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import utils.ResourceUtils;

public class BackgroundList extends JList {
  static final int TILE_IMAGE = 1;
  static final int FIT_IMAGE = 2;
  static final int CENTER_IMAGE = 3;
  private int mode;
  private float transparency;
  private BufferedImage image;
  private Image inputImage;
  private static boolean testNotLoadedImage = true;

  public BackgroundList(Image image, int mode, float transparency) {
    setOpaque(false);
    this.inputImage = image;
    this.mode = mode;
    this.transparency = transparency;
    final ListCellRenderer lcr = getCellRenderer();
    ListCellRenderer myLcr = new ListCellRenderer() {
      public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {
        Component c =
          lcr.getListCellRendererComponent(
            list,
            value,
            index,
            isSelected,
            cellHasFocus);
        if (c instanceof JComponent)
           ((JComponent)c).setOpaque(isSelected);
        return c;
      }
    };
    setCellRenderer(myLcr);
  }
  protected void paintComponent(Graphics g) {
    if (image == null) {
      initImage();
    }
    if (image == null) {
      return;
    }
    int w = getWidth();
    int h = getHeight();
    if (mode == FIT_IMAGE) {
      g.drawImage(image, 0, 0, w, h, this);
    } else if (mode == CENTER_IMAGE) {
      int x = (w - image.getWidth()) / 2;
      int y = (h - image.getHeight()) / 2;
      g.drawImage(image, x, y, this);
    } else if (mode == TILE_IMAGE) {
      for (int x = 0; x < w; x += image.getWidth()) {
        for (int y = 0; y < h; y += image.getHeight()) {
          g.drawImage(image, x, y, this);
        }
      }
      int x = (w - image.getWidth()) / 2;
      int y = (h - image.getHeight()) / 2;
    } else {
      g.drawImage(image, 0, 0, this);
    }
    super.paintComponent(g);
  }
  private void initImage() {
    MediaTracker tracker = new MediaTracker(this);
    tracker.addImage(inputImage, 0);
    try {
      tracker.waitForID(0);
      int imageWidth = inputImage.getWidth(this);
      int imageHeight = inputImage.getHeight(this);
      image =
        new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
      Graphics2D g2 = (Graphics2D)image.getGraphics();
      g2.setColor(Color.white);
      g2.fillRect(0, 0, imageWidth, imageWidth);
      g2.setComposite(
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
      g2.drawImage(inputImage, 0, 0, this);
    } catch (InterruptedException e) {
      System.out.println("INTERRUPTED while loading Image");
    }
    tracker.removeImage(inputImage, 0);
    if (image != null) {
      inputImage = null; //release unneeded reference
    }
  }

  public static void main(String[] arg) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    URL imageUrl =
      ResourceUtils.relativePathToUrl(
        "chap14/exercises/images/lake_scene.jpg",
        BackgroundList.class);
    Image image = null;
    if (testNotLoadedImage) {
      image = Toolkit.getDefaultToolkit().createImage(imageUrl);
    } else {
      image = ResourceUtils.loadImage(imageUrl);
    }
    BackgroundList list =
      new BackgroundList(image, BackgroundPanel.FIT_IMAGE, 0.5f);
    list.setListData(
      new String[] { "item one", "item two", "item three", "item four" });
    f.getContentPane().add(list);
    f.setSize(200, 200);
    f.show();
  }
}
