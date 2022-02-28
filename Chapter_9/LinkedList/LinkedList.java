/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class LinkedList{
  private Node head = null;
  private Node tail = null;
  private Node current_node = null;
  private int node_count = 0;


  public LinkedList(){}

  public void insertNode(Object o){
	  if(node_count == 0){
		  head = new Node(o);
		  current_node = head;
		  tail = head;
		  head.setNext(tail);
		  head.setPrevious(tail);
		  node_count++;
	  }else{
            Node new_node = new Node(o);
            new_node.setPrevious(current_node);
            new_node.setNext(current_node.getNext());
            current_node.setNext(new_node);
            new_node.getNext().setPrevious(new_node);
            current_node = new_node;
            node_count++;
	       }

  }

  public void listNodes(){
	if(node_count > 0){
	Node temp = head;
	for(int i = 0; i<node_count; i++){
	  System.out.println(temp.getPayload().toString());
	  temp = temp.getNext();
	}// end for
   }// end if
  } // end listNodes()

}