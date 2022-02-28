/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import javax.swing.*;
import java.io.*;

public class JFileChooserTestApp {
  public static void main(String[] args){
    int   chooser_action;
    File  file;
    JFileChooser file_chooser = new JFileChooser();
    chooser_action = file_chooser.showOpenDialog(new JFrame());
    if(chooser_action == JFileChooser.APPROVE_OPTION){
       file = file_chooser.getSelectedFile();
       System.out.println(file.getName());
       System.out.println(file.getPath());
       System.out.println(file.length());
       System.exit(0);
     }else{
	   System.exit(0);
          }
   }
}

