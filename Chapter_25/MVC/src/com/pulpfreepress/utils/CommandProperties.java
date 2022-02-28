/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.utils;

import java.util.*;
import java.io.*;

public class CommandProperties extends Properties {
   
   // class constants - default key strings
   public static final String PROPERTIES_FILE          		= "PROPERTIES_FILE";
   public static final String NEWHOURLYEMPLOYEE_COMMAND		= "NewHourlyEmployee";
   public static final String NEWSALARIEDEMPLOYEE_COMMAND	= "NewSalariedEmployee";
   public static final String EXIT_COMMAND			= "Exit";
   public static final String LIST_COMMAND			= "List";
   public static final String SORT_COMMAND			= "Sort";
   public static final String SAVE_COMMAND			= "Save";
   public static final String EDITEMPLOYEE_COMMAND		= "EditEmployee";
   public static final String DELETEEMPLOYEE_COMMAND		= "DeleteEmployee";
   public static final String LOAD_COMMAND			= "Load";
               
   // class constants - default value strings
   private static final String PROPERTIES_FILE_VALUE			
                                                    = "Command.properties";
   private static final String NEWHOURLYEMPLOYEE_COMMAND_CLASSNAME	= "com.pulpfreepress.commands.NewHourlyEmployeeCommand";
   private static final String NEWSALARIEDEMPLOYEE_COMMAND_CLASSNAME	= "com.pulpfreepress.commands.NewSalariedEmployeeCommand";
   private static final String EXIT_COMMAND_CLASSNAME			= "com.pulpfreepress.commands.ApplicationExitCommand";
   private static final String LIST_COMMAND_CLASSNAME			= "com.pulpfreepress.commands.ListEmployeesCommand";
   private static final String SORT_COMMAND_CLASSNAME			= "com.pulpfreepress.commands.SortEmployeesCommand";
   private static final String SAVE_COMMAND_CLASSNAME			= "com.pulpfreepress.commands.SaveEmployeesCommand";
   private static final String EDITEMPLOYEE_COMMAND_CLASSNAME		= "com.pulpfreepress.commands.EditEmployeeCommand";
   private static final String DELETEEMPLOYEE_COMMAND_CLASSNAME		= "com.pulpfreepress.commands.DeleteEmployeeCommand";
   private static final String LOAD_COMMAND_CLASSNAME			= "com.pulpfreepress.commands.LoadEmployeesCommand";

   // class variables
   private static CommandProperties _properties_object = null;

   private CommandProperties( String properties_file ){
      try{
         FileInputStream fis = new FileInputStream(properties_file);
         load(fis);
        }catch(Exception e) { 
          System.out.println("Problem opening properties file!");
          System.out.println("Bootstrapping properties..."); 
          try{
            FileOutputStream fos = new FileOutputStream(PROPERTIES_FILE_VALUE);
            setProperty(PROPERTIES_FILE, PROPERTIES_FILE_VALUE);
            setProperty(NEWHOURLYEMPLOYEE_COMMAND, NEWHOURLYEMPLOYEE_COMMAND_CLASSNAME);
            setProperty(NEWSALARIEDEMPLOYEE_COMMAND, NEWSALARIEDEMPLOYEE_COMMAND_CLASSNAME);
            setProperty(EXIT_COMMAND, EXIT_COMMAND_CLASSNAME);
            setProperty(LIST_COMMAND, LIST_COMMAND_CLASSNAME);
            setProperty(SORT_COMMAND, SORT_COMMAND_CLASSNAME);
            setProperty(SAVE_COMMAND, SAVE_COMMAND_CLASSNAME);
            setProperty(EDITEMPLOYEE_COMMAND, EDITEMPLOYEE_COMMAND_CLASSNAME);
            setProperty(DELETEEMPLOYEE_COMMAND, DELETEEMPLOYEE_COMMAND_CLASSNAME);
            setProperty(LOAD_COMMAND, LOAD_COMMAND_CLASSNAME);
            
            super.store(fos, "CommandProperties File - Edit Carefully");
            fos.close();
           }catch(Exception e2){ System.out.println("Uh ohh...Bigger problems exist!"); }
        }
    }


/**************************************************************************************************
*  Private default constructor. Applications will get an instance via the getInstance() method.
*  @see getInstance()
****************************************************************************************************/
   private CommandProperties(){
       this(PROPERTIES_FILE_VALUE);
   }
   
/**************************************************************************************************
*  The store() method attempts to persist its properties collection.
****************************************************************************************************/
   public void store(){
     try{
       FileOutputStream fos = new 
			FileOutputStream(getProperty(PROPERTIES_FILE));
       super.store(fos, "CommandProperties File");
       fos.close();
     }catch(Exception e){ System.out.println("Trouble storing properties!"); }
   }

/**************************************************************************************************
*  getInstance() returns a singleton instance if the CommandProperties object.
****************************************************************************************************/
    
   public static CommandProperties getInstance(){
     if(_properties_object == null){
        _properties_object = new CommandProperties();
      } 
     return _properties_object;
   }
} // end CommandProperties class definition