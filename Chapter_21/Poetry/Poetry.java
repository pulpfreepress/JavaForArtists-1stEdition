/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.poetry;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import com.pulpfreepress.*;

public class Poetry extends JApplet implements MouseMotionListener, MouseListener {
        
    private Node             _nodes[];
    private Node             _selected_node = null;
    private int              _oldX, _oldY;
    private Dimension        _size = null;
    private String           _words;
    private StringTokenizer  _st;
    
    public void init() {
      this.setBackground(Color.black);
      _size = this.getSize();
      _words = new String(this.getParameter("lexicon"));
      _st = new StringTokenizer(_words, ",");
      int count = _st.countTokens();
      _nodes = new Node[count];
      for(int i=0; i<count; i++){
         _nodes[i] = new Node(_st.nextToken().trim(), this);
      }
      this.addMouseMotionListener(this);
      this.addMouseListener(this);
      repaint();
    } // end init() method
        
        
    public void paint( Graphics g ) {
      for(int i = 0; i < _nodes.length; i++) {
        _nodes[i].paint(g);
       }
    }
          
    /********************************************************
      MouseListener Interface Methods
    *********************************************************/
     public void mouseClicked(MouseEvent e){} 
     public void mouseEntered(MouseEvent e){}
     public void mouseExited(MouseEvent e){}
     
     public void mousePressed(MouseEvent e){
       for(int i = 0; i < _nodes.length; i++){
         if(_nodes[i].inNode(e.getX(), e.getY())) {
             _selected_node = _nodes[i];
            } // end if
        } // end for
      } // end mousePressed() method
      
     public void mouseReleased(MouseEvent e){
       _selected_node = null;
      }       
    
    /********************************************************
      MouseMotionListener Interface Methods
    ********************************************************/     
    public void mouseDragged(MouseEvent e){
      if(_selected_node != null){ 
      _selected_node.setX(e.getX());
      _selected_node.setY(e.getY());
      _selected_node.paint(this.getGraphics());
      for(int i = 0; i < _nodes.length; i++) {
        if(_nodes[i].wasTouched(e.getX(), e.getY(), _selected_node.getWidth(),
            _selected_node.getHeight())) {
            _nodes[i].paint(this.getGraphics());
         } // end if
       } // end for
      } // end if          
    } // end mouseDragged() method
    
    
    public void mouseMoved(MouseEvent e){}
        
} // end Poetry class definition