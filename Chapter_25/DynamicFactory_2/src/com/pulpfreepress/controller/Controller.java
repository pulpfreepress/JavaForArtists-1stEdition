/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.controller;

import com.pulpfreepress.utils.*;
import com.pulpfreepress.commands.*;
import com.pulpfreepress.exceptions.*;
import com.pulpfreepress.model.*;
import com.pulpfreepress.view.*;
import com.pulpfreepress.interfaces.*;
import java.awt.event.*;

public class Controller implements ActionListener {
   
   private CommandFactory command_factory = null;
   private iModel its_model;
   private iView its_view;
   
   public Controller(){
     command_factory = CommandFactory.getInstance();
     its_model = new Model();
     its_view = new View(this);
   }
  
  
  public void actionPerformed(ActionEvent ae){
     try{
     BaseCommand command = command_factory.getCommand(ae.getActionCommand());
     command.setModel(its_model);
     command.setView(its_view);
     command.execute();
     }catch(CommandNotFoundException cnfe){
        System.out.println("Command not found!");
     }
  }

  public static void main(String[] args){
     new Controller();
  } // end main() method
} // end Controller class definition
