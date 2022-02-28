/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class Model {

	private int i = 0;

	private String[] messages = { "Eat right, get plenty of rest, and exercise daily.",
						          "Make love not war.",
						          "Carpe Diem!",
						          "Eat your vegatables.",
						          "Brush and floss your teeth three times daily.",
						          "A penny saved is a penny earned.",
						          "What you do today prepares you for tomorrow.",
						          "All work and no play makes Jack a dull boy.", };



	public String getMessage(){
	  if(i++ == (messages.length-1)) i = 0;
	  return messages[i];
    }

} // end model class