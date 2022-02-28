/*****************************************************************
  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press 
     
   This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.
*****************************************************************/
import com.pulpfreepress.utils.*;

public class InterfaceTypeFactory {

  private static CommandProperties properties = CommandProperties.getInstance();
  
  public static InterfaceType newObjectByClassName(String classname) {
    Object o = null;
    try{
        properties.reloadPropertiesFile("Command.properties");
	Class c = Class.forName(properties.getProperty(classname));
	o = c.newInstance();
	}catch(Exception e){
	    System.out.println("Problem loading class or creating instance!");
	    }
    return (InterfaceType)o;
   }
} // end InterfaceTypeFactory class definition