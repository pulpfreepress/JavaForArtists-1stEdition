/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;
import java.io.*;

public class AppProperties extends Properties {
  /*
   * Declare default property names and their values
   */
   public static final String PROPERTY_A_NAME = "PROPERTY_A_NAME";
   public static final String PROPERTY_B_NAME = "PROPERTY_B_NAME";
   public static final String PROPERTY_C_NAME = "PROPERTY_C_NAME";
   public static final String DEFAULT_PROPERTIES_FILENAME = "DEFAULT_PROPERTIES_FILENAME";
   public static final String PROPERTIES_FILE_HEADER = "PROPERTIES_FILE_HEADER";

   private static final String PROPERTY_A_VALUE = "Property A's Value";
   private static final String PROPERTY_B_VALUE = "Property B's Value";
   private static final String PROPERTY_C_VALUE = "Property C's Value";
   private static final String DEFAULT_PROPERTIES_FILENAME_VALUE = "app_prop.xml";
   private static final String PROPERTIES_FILE_HEADER_VALUE = "Application Properties File";

   /**
    *  Constructor
    */

   public AppProperties(){
      System.out.println("Attempting to read properties file...");
      FileInputStream  fis = null;
      FileOutputStream fos = null;
       try{
         fis = new FileInputStream(DEFAULT_PROPERTIES_FILENAME_VALUE);
         this.loadFromXML(fis);
	   }catch(Exception e1){
		  System.out.println("AppProperties: Problem loading properties file.");
		  System.out.println(e1.toString());
		  System.out.println("Creating new default properties file.");
		  this.setProperty(PROPERTY_A_NAME, PROPERTY_A_VALUE);
		  this.setProperty(PROPERTY_B_NAME, PROPERTY_B_VALUE);
		  this.setProperty(PROPERTY_C_NAME, PROPERTY_C_VALUE);
		  this.setProperty(DEFAULT_PROPERTIES_FILENAME, DEFAULT_PROPERTIES_FILENAME_VALUE);
		  this.setProperty(PROPERTIES_FILE_HEADER, PROPERTIES_FILE_HEADER_VALUE);
		  try{
			 fos = new FileOutputStream(DEFAULT_PROPERTIES_FILENAME_VALUE);
			 this.storeToXML(fos, PROPERTIES_FILE_HEADER_VALUE);
		  }catch(Exception e2){
			 System.out.println("AppProperties: Problem creating default properties file.");
			 System.out.println(e2.toString());
		  }finally{
			  if(fis != null){
				  try{
					  fis.close();
				  }catch(Exception ignored){ }
			  }

			  if(fos != null){
				  try{
				  	fos.close();
				  }catch(Exception ignored){ }
			  }

		  }// end finally
	   }// end primary try/catch block
   }// end constructor
}// end AppProperties class definition