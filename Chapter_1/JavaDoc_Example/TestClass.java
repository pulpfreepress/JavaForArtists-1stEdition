/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

/**********************************************************
 TestClass demonstrates the use of <b>javadoc</b> comments.

 @author Rick Miller
 @version 1.0, 09/20/03
**********************************************************/

public class TestClass {

   private int its_value;

    /******************************************************
    TestClass constructor
    @param value An integer value used to set its_value
    ******************************************************/

    public TestClass(int value){
	its_value = value;
    }
  
   /*****************************************************
    getValue method
    @return integer value of its_value
    ****************************************************/

    public int getValue(){
	return its_value;
    }

   /****************************************************
     setValue method
     @param value Used to set its_value
   ****************************************************/
  
    public void setValue(int value){
	its_value = value;
    }

}