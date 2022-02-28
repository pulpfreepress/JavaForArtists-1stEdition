/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.commands;

import com.pulpfreepress.interfaces.*;

public abstract class BaseCommand {
   protected static iModel its_model = null;
   protected static iView  its_view = null;

   public void setModel(iModel model){
	 if(its_model == null){
		its_model = model;
     }
   }

   public void setView(iView view){
	 if(its_view == null){
        its_view = view;
     }
   }

   public abstract void execute(); // must be implemented in derived classes

} // end BaseCommand class definition