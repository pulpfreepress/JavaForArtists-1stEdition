/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/


public class QTesterApp extends Thread implements QueueListenerInterface {
  
  private static ActiveQueue _q = null;
  
  static {
    _q = new ActiveQueue();
  }

  public QTesterApp(){
    _q.addQueueListener(this);
  }

  public void queueInsertionPerformed(){
    System.out.print("New object is in the queue!: ");
    System.out.println(_q.get().toString());
  }

  private void insertStuff(){
     for(int i = 0; i < 6; i++){
       _q.put(new Integer(i));
       try{
         this.sleep(10);
       }catch(InterruptedException ignored){ }
     }
   }
   
   public void run(){
     this.insertStuff();
   }

  public static void main(String[] args){
    QTesterApp qt1 = new QTesterApp();
    QTesterApp qt2 = new QTesterApp();
    qt1.start();
    qt2.start();
  } // end main()
} // end QTesterApp class definition
