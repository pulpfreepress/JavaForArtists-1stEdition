/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class FileClassTesterApp {
   public static void main(String[] args){
      File file = null;
        try{
          file = new File(args[0]);
	  System.out.println(file.getName());
	  System.out.println(file.getPath());
	  System.out.println(file.getAbsolutePath());
	  System.out.println(file.getCanonicalPath());
	  System.out.println(file.isDirectory());

	  }catch(Exception ignored){ }
    }
}


