/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

/****************************************************************
  ActiveQueue class implements a thread-safe FIFO queue 
utilizing the java.util.LinkedList class. 
****************************************************************/

import java.util.*;


/****************************************************************
  ActiveQueue classs
  @author Rick Miller
****************************************************************/

public class ActiveQueue {
     
     private LinkedList _list = null;
     private Vector     _listeners = null;
    
    /****************************************************************
      Default constructor
    ****************************************************************/
    public ActiveQueue(){
       _list = new LinkedList();
       _listeners = new Vector();
     }  

    
    /****************************************************************
      get() - returns the object that's been waiting the longest. 
    ****************************************************************/
    public synchronized Object get(){
      return _list.getLast();
    }

    /****************************************************************
     put() - inserts an object into the queue.     
    ****************************************************************/
    public synchronized void put(Object o){
        _list.addFirst(o);      
        this.fireQueueInsertionEvent();
    }

    /****************************************************************
       addQueueListener(QueueListenerInterface listener) adds the
       argument QueueListener object to the _listeners Vector.
    ****************************************************************/
    public void addQueueListener(QueueListenerInterface listener){
      _listeners.add(listener);
    }

   /****************************************************************
      fireQueueIntertionEvent() is a protected method called in
      the body of the put() method to notify interested object
      that something has been inserted into the Queue.    
    ****************************************************************/
   protected synchronized void fireQueueInsertionEvent(){
     Vector v = (Vector) _listeners.clone();
     for(Enumeration e = v.elements(); e.hasMoreElements();){
         ((QueueListenerInterface)e.nextElement()).queueInsertionPerformed();
     }
   } 
}

