/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

/****************************************************************
  QueueListenerInterface - implemented by objects interested in
  getting notificaiton when objects have been inserted into an 
  ActiveQueue object.
 ****************************************************************/
 interface QueueListenerInterface {
    void queueInsertionPerformed(); 
 }
