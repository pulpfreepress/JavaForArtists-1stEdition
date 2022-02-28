/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

/**************************************************************************************************
*  FileName: NetRatServerProperties.java
*  @author   Rick Miller
*  
*  Description: Implements the singleton pattern. A NetRatServerProperties object implements 
*  the persistence of application information required by the NetRatServer application. 
****************************************************************************************************/
import java.util.*;
import java.io.*;

/**************************************************************************************************
* NetRatServerProperties class Description: Implements the singleton pattern. A NetRatServerProperties 
* object implements the persistence of application information required by the NetRatServer 
* application. 
* @see Properties
****************************************************************************************************/

public class NetRatServerProperties extends Properties {
   
   // class constants
   public static final String DEFAULT_RMI_PORT				= "DEFAULT_RMI_PORT";
   public static final String DEFAULT_SOCKET_PORT			= "DEFAULT_SOCKET_PORT";
   public static final String DEFAULT_SERVER_IP                 	= "DEFAULT_SERVER_IP";
   public static final String DEFAULT_PROPERTIES_FILE          		= "DEFAULT_PROPERTIES_FILE";
   public static final String DEFAULT_PROPERTIES_FILENAME		= "netratserver.properties";
   public static final String DEFAULT_FRAME_HEIGHT			= "DEFAULT_FRAME_HEIGHT";
   public static final String DEFAULT_FRAME_WIDTH			= "DEFAULT_FRAME_WIDTH";
   public static final String DEFAULT_FRAME_X_POSITION			= "DEFAULT_FRAME_X_POSITION";
   public static final String DEFAULT_FRAME_Y_POSITION			= "DEFAULT_FRAME_Y_POSITION";
   public static final String DEFAULT_STEP_SIZE				= "DEFAULT_STEP_SIZE";
   public static final String DEFAULT_ROBOTRAT_CLASS_NAME		= "DEFAULT_ROBOTRAT_CLASS_NAME";
   public static final String DEFAULT_ROBOTRAT_FACTORY_SERVICE_NAME	= 
			      "DEFAULT_ROBOTRAT_RMI_SERVICE_NAME";
   
   // class variables
   private static NetRatServerProperties _properties_object = null;


/**************************************************************************************************
*  Private constructor
*  Design Decisions:
*      -- Attempts to open properties file and load persistent properties. If that fails, it will
*         try to create the properties file, set itself up with default property values, and attempt
*         to store the property values in the file. If that fails...check your hard drive!
****************************************************************************************************/

    private NetRatServerProperties( String properties_file ){
      try{
         FileInputStream fis = new FileInputStream(properties_file);
         load(fis);
        }catch(Exception e) { 
          System.out.println("Problem opening properties file!");
          System.out.println("Bootstrapping properties..."); 
          try{
            FileOutputStream fos = new 
				FileOutputStream(NetRatServerProperties.DEFAULT_PROPERTIES_FILENAME);
            setProperty(NetRatServerProperties.DEFAULT_RMI_PORT, "1099");
            setProperty(NetRatServerProperties.DEFAULT_SOCKET_PORT, "5001");
            setProperty(NetRatServerProperties.DEFAULT_SERVER_IP, "127.0.0.1");
            setProperty(NetRatServerProperties.DEFAULT_PROPERTIES_FILE, "netratserver.properties");
            setProperty(NetRatServerProperties.DEFAULT_FRAME_HEIGHT, "300");
            setProperty(NetRatServerProperties.DEFAULT_FRAME_WIDTH, "300");
            setProperty(NetRatServerProperties.DEFAULT_FRAME_X_POSITION, "200");
            setProperty(NetRatServerProperties.DEFAULT_FRAME_Y_POSITION, "200");
            setProperty(NetRatServerProperties.DEFAULT_STEP_SIZE, "3");
            setProperty(NetRatServerProperties.DEFAULT_ROBOTRAT_CLASS_NAME, "RobotRat");
            setProperty(NetRatServerProperties.DEFAULT_ROBOTRAT_FACTORY_SERVICE_NAME, 
					       "Robot_Rat_Factory");
            
            super.store(fos, "NetRatServerProperties File - Edit Carefully");
            fos.close();
           }catch(Exception e2){ System.out.println("Uh ohh...Bigger problems exist!"); }
        }
    }


/**************************************************************************************************
*  Private default constructor. Applications will get an instance via the getInstance() method.
*  @see getInstance()
****************************************************************************************************/
   private NetRatServerProperties(){
       this(DEFAULT_PROPERTIES_FILENAME);
   }
   
/**************************************************************************************************
*  The store() method attempts to persist its properties collection.
****************************************************************************************************/
   public void store(){
     try{
       FileOutputStream fos = new 
			FileOutputStream(getProperty(NetRatServerProperties.DEFAULT_PROPERTIES_FILE));
       super.store(fos, "NetRatServerProperties File");
       fos.close();
     }catch(Exception e){ System.out.println("Trouble storing properties!"); }
   }

/**************************************************************************************************
*  getInstance() returns a singleton instance if the NetRatServerProperties object.
****************************************************************************************************/
    
   public static NetRatServerProperties getInstance(){
     if(_properties_object == null){
        _properties_object = new NetRatServerProperties();
      } 
     return _properties_object;
   }
} // end NetRatServerProperties class definition