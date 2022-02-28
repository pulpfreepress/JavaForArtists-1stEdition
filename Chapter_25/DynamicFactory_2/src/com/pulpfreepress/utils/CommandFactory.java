/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.utils;

import com.pulpfreepress.commands.*;
import com.pulpfreepress.exceptions.*;

public class CommandFactory {

private static CommandFactory command_factory_instance = null;
private static CommandProperties command_properties = null;

static {
   command_properties = CommandProperties.getInstance();
 }


private CommandFactory(){ }

public static CommandFactory getInstance(){
  if(command_factory_instance == null){
    command_factory_instance = new CommandFactory();
  }
  return command_factory_instance;
}
   
public BaseCommand getCommand(String command_string) throws CommandNotFoundException {
  BaseCommand command = null;
  if(command_string == null){
     throw new CommandNotFoundException( command_string + " command class not found!");
   } else{ try{
        String command_classname = command_properties.getProperty(command_string);
        Class command_class = Class.forName(command_classname);
        Object command_object = command_class.newInstance();
        command = (BaseCommand) command_object;
        }catch(Throwable t){
          t.printStackTrace();
          throw new CommandNotFoundException(t.toString(), t);
         }
    } // end else
    return command;
 } // end getCommand() method

} // end CommandFactory class definition
