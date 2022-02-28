/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.util.*;

public class UTFTesterApp {
  public static void main(String[] args){
	File file = null;
	FileInputStream fis = null;
	DataInputStream dis = null;

	FileOutputStream fos = null;
	DataOutputStream dos = null;



	try{
	 file = new File(args[0]);
	 fos = new FileOutputStream(file);

	 dos = new DataOutputStream(fos);


	 for(int i=1010; i<1040; i++){
		 dos.writeUTF(String.valueOf(i));
	 }


	 dos.close();

	 fis = new FileInputStream(file);
	 dis = new DataInputStream(fis);
     while(true ){
       try{
		 System.out.println(dis.readUTF());

	   }catch(Exception e){
		 e.printStackTrace();
		 break;
	   }

	 }

	 dis.close();

	}catch(Exception e){
	  e.printStackTrace();
	}

  } // end main()
} // end class definition