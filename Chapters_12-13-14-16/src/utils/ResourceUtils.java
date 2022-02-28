/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package utils;

import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceUtils {
  public static URL relativePathToUrl(String path, Object obj) {
    Class clazz = obj instanceof Class ? (Class)obj : obj.getClass();
    URL url = clazz.getClassLoader().getResource(path);
    return url;
  }
  public static BufferedImage loadImage(String path, Object obj) {
    return loadImage(relativePathToUrl(path, obj));
  }
  public static BufferedImage loadImage(URL url) {
    try {
      return ImageIO.read(url);
    } catch (IOException ignore) {}

    return null;
  }

  /*
   * For historical interest
   */
  public static Image loadImage_pre_imageio(URL url) {
    return new ImageIcon(url).getImage();
  }
  public static Image loadImage_pre_swing(URL url) {
    Component comp = new Component() {};
    MediaTracker tracker = new MediaTracker(comp);
    Image image = Toolkit.getDefaultToolkit().createImage(url);
    tracker.addImage(image, 0);
    try {
      tracker.waitForID(0);
      return image;
    } catch (InterruptedException ignore) {}

    return null;
  }
}