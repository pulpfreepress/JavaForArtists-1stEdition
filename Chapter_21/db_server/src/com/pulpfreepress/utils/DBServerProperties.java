/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.utils;

import java.util.*;
import java.io.*;


public class DBServerProperties extends Properties {
   
   // class constants - default key strings
   public static final String DEFAULT_RMI_PORT				= "DEFAULT_RMI_PORT";
   public static final String DEFAULT_SERVER_IP                 	= "DEFAULT_SERVER_IP";
   public static final String DEFAULT_PROPERTIES_FILE          		= "DEFAULT_PROPERTIES_FILE";
   public static final String DEFAULT_JDBC_DRIVER			= "DEFAULT_JDBC_DRIVER";
   public static final String DEFAULT_MYSQL_DB_PORT			= "DEFAULT_MYSQL_DB_PORT";
   public static final String DEFAULT_DATABASE				= "DEFAULT_DATABASE";
   public static final String DEFAULT_DB_USER				= "DEFAULT_DB_USER";
   public static final String DEFAULT_MYSQL_JDBC_PROTOCOL		= "DEFAULT_MYSQL_JDBC_PROTOCOL";
   public static final String DEFAULT_EMPLOYEE_PERSISTER_SERVICE	= "DEFAULT_EMPLOYEE_PERSISTER_SERVICE";
   
      
   // class constants - default value strings
   private static final String DEFAULT_RMI_PORT_VALUE			= "1099";
   private static final String DEFAULT_SERVER_IP_VALUE			= "127.0.0.1";
   private static final String DEFAULT_PROPERTIES_FILE_VALUE		= "DBserver.properties";
   private static final String DEFAULT_JDBC_DRIVER_VALUE		= "com.mysql.jdbc.Driver";
   private static final String DEFAULT_MYSQL_DB_PORT_VALUE		= "3306";
   private static final String DEFAULT_DATABASE_VALUE			= "chapter_21";
   private static final String DEFAULT_DB_USER_VALUE			= "swodog";
   private static final String DEFAULT_MYSQL_JDBC_PROTOCOL_VALUE	= "jdbc:mysql";
   private static final String DEFAULT_EMPLOYEE_PERSISTER_SERVICE_VALUE = "Employee_Persister_Service";
   
   // class variables
   private static DBServerProperties _properties_object = null;



   private DBServerProperties( String properties_file ){
      try{
         FileInputStream fis = new FileInputStream(properties_file);
         load(fis);
        }catch(Exception e) { 
          System.out.println("Problem opening properties file!");
          System.out.println("Bootstrapping properties..."); 
          try{
            FileOutputStream fos = new FileOutputStream(DEFAULT_PROPERTIES_FILE_VALUE);
            setProperty(DEFAULT_RMI_PORT, DEFAULT_RMI_PORT_VALUE);
            setProperty(DEFAULT_SERVER_IP, DEFAULT_SERVER_IP_VALUE);
            setProperty(DEFAULT_PROPERTIES_FILE, DEFAULT_PROPERTIES_FILE_VALUE);
            setProperty(DEFAULT_JDBC_DRIVER, DEFAULT_JDBC_DRIVER_VALUE);
            setProperty(DEFAULT_MYSQL_DB_PORT, DEFAULT_MYSQL_DB_PORT_VALUE);
            setProperty(DEFAULT_DATABASE, DEFAULT_DATABASE_VALUE);
            setProperty(DEFAULT_DB_USER, DEFAULT_DB_USER_VALUE);
            setProperty(DEFAULT_MYSQL_JDBC_PROTOCOL, DEFAULT_MYSQL_JDBC_PROTOCOL_VALUE);
            setProperty(DEFAULT_EMPLOYEE_PERSISTER_SERVICE, DEFAULT_EMPLOYEE_PERSISTER_SERVICE_VALUE);
            
            super.store(fos, "DBServerProperties File - Edit Carefully");
            fos.close();
           }catch(Exception e2){ System.out.println("Uh ohh...Bigger problems exist!"); }
        }
    }


/**************************************************************************************************
*  Private default constructor. Applications will get an instance via the getInstance() method.
*  @see getInstance()
****************************************************************************************************/
   private DBServerProperties(){
       this(DEFAULT_PROPERTIES_FILE_VALUE);
   }
   
/**************************************************************************************************
*  The store() method attempts to persist its properties collection.
****************************************************************************************************/
   public void store(){
     try{
       FileOutputStream fos = new 
			FileOutputStream(getProperty(DEFAULT_PROPERTIES_FILE));
       super.store(fos, "DBServerProperties File");
       fos.close();
     }catch(Exception e){ System.out.println("Trouble storing properties!"); }
   }

/**************************************************************************************************
*  getInstance() returns a singleton instance if the DBServerProperties object.
****************************************************************************************************/
    
   public static DBServerProperties getInstance(){
     if(_properties_object == null){
        _properties_object = new DBServerProperties();
      } 
     return _properties_object;
   }
} // end DBServerProperties class definition