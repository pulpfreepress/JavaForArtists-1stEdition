/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class GenericTestTwo <T> {

	public T getInstance(String className){
		Object o = null;
	  try{
	    o =  Class.forName(className).newInstance();
       }catch(Exception ignored){}
       return (T)o;
	}

	public static void main(String[] args){
	  GenericTestTwo<Person> gt = new GenericTestTwo<Person>();

	  System.out.print(gt.getInstance("Person"));
	}

}

