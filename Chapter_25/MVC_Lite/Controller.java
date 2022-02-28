/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.awt.event.*;

public class Controller implements ActionListener {
   private Model its_model = null;
   private View its_view = null;

   public Controller(){
	 its_model = new Model();
	 its_view = new View(this);
   }

   public void actionPerformed(ActionEvent ae){
	 if(ae.getActionCommand().equals("Next Message")){
	   its_view.setMessage(its_model.getMessage());
	 }
   }

  public static void main(String[] args){
	 new Controller();
  }

} // end Controller class definition