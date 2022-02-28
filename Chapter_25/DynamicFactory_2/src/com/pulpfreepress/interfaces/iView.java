/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.interfaces;
import java.io.*;

public interface iView {
   public void displayEmployeeInfo(String[] employees_info);
   public String[] getNewHourlyEmployeeInfo();
   public String[] getNewSalariedEmployeeInfo();
   public String[] getEditEmployeeInfo();
   public String getDeleteEmployeeInfo();
   public File getSaveFile();
   public File getLoadFile();

} // end iView interface definition