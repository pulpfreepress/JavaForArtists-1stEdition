/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

import java.awt.*;

public class Floor extends Canvas{

 Rat its_rat = null;

 public Floor(Rat r){ its_rat = r;}

 public void paint(Graphics g){
    g.drawImage(its_rat.getImage(), 20, 20, this);
 }


}