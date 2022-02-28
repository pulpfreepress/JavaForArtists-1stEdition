/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/


public class QTesterApp implements QueueListenerInterface {
  
  private ActiveQueue _q = null;

  public QTesterApp(){
    _q = new ActiveQueue();
    _q.addQueueListener(this);
  }

  public void queueInsertionPerformed(){
    System.out.println("New object is in the queue!");
  }

  public void insertStuff(){
     for(int i = 0; i < 10; i++){
       _q.put(new Object());
     }
   }

  public static void main(String[] args){
    QTesterApp qt = new QTesterApp();
    qt.insertStuff();   
  } 

}
