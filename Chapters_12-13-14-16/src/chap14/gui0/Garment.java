/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.gui0;

import java.awt.Image;

public class Garment {

  private Image image;
  private int x, y;
  private boolean worn = false;
  private String name;

  public Garment(Image image, int x, int y, String name) {
    this.image = image;
    this.x = x;
    this.y = y;
    this.name = name;
  }
  public String toString() {
    return name;
  }
  public Image getImage() {
    return image;
  }
  public void setWorn(boolean worn) {
    this.worn = worn;
  }
  public boolean isWorn() {
    return worn;
  }
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public String getName() {
    return name;
  }
}