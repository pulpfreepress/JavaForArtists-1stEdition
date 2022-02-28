/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.awt.*;
import javax.swing.*;

public class Rat {
  private Image _its_image = null;
  private int _x = 0;
  private int _y = 0;

  public Rat(String image_name){
   Toolkit tool_kit = Toolkit.getDefaultToolkit();
   try{
      _its_image = tool_kit.getImage(image_name);
     }catch(Exception e){
       System.out.println("Rat constructor: Problem loading or creating Rat image!");
       e.printStackTrace();
     }
   _x = 0;
   _y = 0;
  }

  public Rat(){ 
    this("rat.gif");
  }

  public Image getImage(){
   return _its_image;
  }

  public int getX(){ 
    return _x;
   }

  public int getY(){
    return _y;
  }

  public void setX(int x){
    _x = x;
  }

  public void setY(int y){
    _y = y;
  }
} // end Rat class definition
