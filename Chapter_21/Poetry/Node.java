/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.poetry;

import java.awt.*;
import javax.swing.*;
import java.lang.Math;


/*****************************************************************
  Node represents an individual word to be drawn on a canvas. 
******************************************************************/
public class Node {

  private int _oldx;
  private int _oldy;
  private int _x;
  private int _y;
  private int _h;
  private int _w;
  private String _its_string = null;
  private FontMetrics _its_fontmetrics = null;
  private final int XMARGIN = 3;
  private final int YMARGIN = 3;


  public Node(String the_string, Component c){
    _its_fontmetrics = c.getFontMetrics(c.getFont());
    _its_string = the_string;
    _w = _its_fontmetrics.stringWidth(the_string) + (XMARGIN * 2);
    _h = _its_fontmetrics.getHeight() + (YMARGIN * 2);
  
    Dimension size = c.getSize();
    _x = (int)(Math.random() * size.width);
    _y = (int)(Math.random() * size.height);
  }


public void setX(int x){
  _oldx = _x;
  _x = x - 10;
}

public void setY(int y){
  _oldy = _y;
  _y = y - 5;
}

public void paint(Graphics g){
   g.setColor(Color.black);
   g.fillRect(_oldx, _oldy, _w, _h);
   g.setColor(Color.yellow);
   g.fillRect(_x, _y, _w, _h);
   g.setColor(Color.blue);
   g.drawString(_its_string, _x + XMARGIN, _y + (_h/2) + YMARGIN);
 }
 
 public boolean inNode(int x, int y){
   return((x > (_x)) && (x<(_x+_w + 10)) && (y > (_y)) && (y<=(_y+_h + 5)));
 }
 
 public String getString(){ return _its_string;}
 
 public boolean wasTouched(int x, int y, int w, int h){
    return( (x >= (_x - _w - w*4)) && (x <= (_x+_w + w*4 )) && 
            (y >= (_y - _h - h*4)) && (y <= (_y+_h + h*4))); 
 }
 
 public int getWidth(){return _w;}
 
 public int getHeight(){return _h;}

}// end Node class