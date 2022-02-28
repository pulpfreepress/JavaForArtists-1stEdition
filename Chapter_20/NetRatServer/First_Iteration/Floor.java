/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.awt.*;
import java.util.*;

public class Floor extends Canvas {
  private Vector _rats = null;

  public Floor(Vector rats){
    _rats = rats;
    this.setBackground(Color.BLACK);
  }   
 
  public void paint(Graphics g){
    for(int i = 0; i<_rats.size(); i++){
      if(_rats.elementAt(i) != null){
         g.drawImage(((Rat)_rats.elementAt(i)).getImage(),((Rat) _rats.elementAt(i)).getX(), 
                     ((Rat) _rats.elementAt(i)).getY(), this);
       }
    }
  }
} // end Floor class definition
