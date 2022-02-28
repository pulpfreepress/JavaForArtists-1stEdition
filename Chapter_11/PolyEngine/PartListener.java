/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

import java.util.*;

public interface PartListener extends EventListener {
  public void sensorReadingChangePerformed(PartEvent pe);
  public void pumpSpeedChangePerformed(PartEvent pe);
  public void partStatusChangePerformed(PartEvent pe);
}