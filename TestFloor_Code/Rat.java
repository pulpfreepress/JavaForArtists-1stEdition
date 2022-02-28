/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.awt.*;

public class Rat {
  Image its_image = null;

  Rat(Toolkit tk, String image_name){
     its_image = tk.createImage(image_name);
  }
 
 Image getImage(){ return its_image;}


}