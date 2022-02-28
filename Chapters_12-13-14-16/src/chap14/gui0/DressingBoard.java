/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.gui0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;

import utils.ResourceUtils;

public class DressingBoard extends JComponent {
  private Image boyImage;
  private Garment[] order;
  private int boyWidth;
  private int boyHeight;

  public DressingBoard() {
    setOpaque(true);
    setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

    //image of completely clothed boy courtesy of www.hasslefreeclipart.com
    boyImage = ResourceUtils.loadImage("chap14/images/boy.gif", this);

    boyWidth = boyImage.getWidth(this);
    boyHeight = boyImage.getHeight(this);
    setOrder(new Garment[0]);
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int width = getWidth();
    int height = getHeight();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    int offsetX = (width - boyWidth) / 2;
    int offsetY = (height - boyHeight) / 2;
    g.drawImage(boyImage, offsetX, offsetY, this);
    for (int i = 0; i < order.length; ++i) {
      Garment garment = order[i];
      g.drawImage(
        garment.getImage(),
        garment.getX() + offsetX,
        garment.getY() + offsetY,
        this);
    }
  }
  public void setOrder(Garment[] order) {
    this.order = order;
    repaint();
  }
}