/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class Node implements Serializable {
	private Node next = null;
	private Node previous = null;
	private Object payload = null;

	public Node(Node previous, Node next, Object payload){
		this.previous = previous;
		this.next = next;
		this.payload = payload;
	}

	public Node(Object payload){
		this(null, null, payload);

	}

	public Node getNext(){ return next;}

	public void setNext(Node next){ this.next = next; }

	public Node getPrevious(){ return previous; }

	public void setPrevious(Node previous){ this.previous = previous; }

	public Object getPayload(){ return payload; }

	public void setPayload(Object payload){ this.payload = payload; }

}