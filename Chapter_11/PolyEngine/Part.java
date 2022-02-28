/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;

public abstract class Part {
  
  /*********************************
    private attributes
  *********************************/
  private PartStatus _status = null;
  private String _part_name = null;
  private Vector _part_listeners = null;
  private Hashtable _sub_parts = null;
  

  /*********************************
     constructor
  **********************************/
  public Part(PartStatus status, String part_name){
    _status = status;
    _part_name = part_name;
   System.out.println("Part object created!");
  }
  
  /*********************************
     default constructor
  **********************************/
  public Part(String part_name){
     _status = PartStatus.WORKING;
     _part_name = part_name;
     System.out.println("Part object created!");
  }

  /*********************************
     public interface methods
  **********************************/

  public PartStatus getPartStatus(){ return _status; }

  public String  getPartName(){ return _part_name; }

  public void setPartStatus(PartStatus status){
   _status = status;
   firePartStatusChangeEvent();
  }

  public boolean isWorking(){
    if(_sub_parts != null){  // there are subparts
      for(Enumeration e = getSubPartsEnumeration(); e.hasMoreElements();){
         if(((Part) e.nextElement()).isWorking()) {
            continue; //great! 
            }else{
               setPartStatus(PartStatus.NOT_WORKING);
               break;
              }  
      } 
   } 
   System.out.println(getPartName() + " " + " isWorking status = " + _status.isWorking());
   return _status.isWorking();
  }

  public void addPartListener(PartListener pl){
   if(_part_listeners == null){
       _part_listeners = new Vector();
       _part_listeners.add(pl);
    }else {
       _part_listeners.add(pl);
      }
  }

  public void removePartListener(PartListener pl){
    if(_part_listeners == null){
          ; //do nothing
       } else { 
         if(_part_listeners.isEmpty()){
             ; // do nothing
            } else { 
                _part_listeners.removeElement(pl);
               }
    }
  }

  public void enable(){
    setPartStatus(PartStatus.WORKING);
  }

  public void disable(){
    setPartStatus(PartStatus.NOT_WORKING);
  }

  
  public void fireSensorReadingChangeEvent(double reading){
    if(_part_listeners.isEmpty()){
          ;  //there's nothing to do!
       } else {
          Vector listeners_copy = null;
          synchronized(this){
               listeners_copy = (Vector)_part_listeners.clone();
             }
          PartEvent pe = new PartEvent(this, _part_name, reading);
          for(Enumeration e = listeners_copy.elements(); e.hasMoreElements();){
            ((PartListener) (e.nextElement())).sensorReadingChangePerformed(pe);
           }
         }
  }

   public void firePumpSpeedChangeEvent(double speed){
    if(_part_listeners.isEmpty()){
          ;  //there's nothing to do!
       } else {
          Vector listeners_copy = null;
          synchronized(this){
               listeners_copy = (Vector)_part_listeners.clone();
             }
          PartEvent pe = new PartEvent(this, _part_name, speed);
          for(Enumeration e = listeners_copy.elements(); e.hasMoreElements();){
            ((PartListener) (e.nextElement())).pumpSpeedChangePerformed(pe);
           }
         }
  }

  public void firePartStatusChangeEvent(){
    if(_part_listeners.isEmpty()){
          ;  //there's nothing to do!
       } else {
          Vector listeners_copy = null;
          synchronized(this){
               listeners_copy = (Vector)_part_listeners.clone();
             }
          PartEvent pe = new PartEvent(this, _part_name);
          for(Enumeration e = listeners_copy.elements(); e.hasMoreElements();){
            ((PartListener) (e.nextElement())).partStatusChangePerformed(pe);
           }
         }
  }

   public void addSubPart(String name, Part part){
    if(_sub_parts == null){
      _sub_parts = new Hashtable();
      _sub_parts.put(name, part);
    }else{
        _sub_parts.put(name, part);
      }
   }

  public Part getSubPart(String name){
    assert (_sub_parts != null);  //can't call if no subparts exist!
    return (Part)_sub_parts.get(name);

  }

   public Enumeration getSubPartsEnumeration(){
     assert (_sub_parts != null );
     return _sub_parts.elements();
  }
  

}