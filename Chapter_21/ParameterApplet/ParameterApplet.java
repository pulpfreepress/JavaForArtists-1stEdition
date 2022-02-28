/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import javax.swing.*;
import java.util.*;

public class ParameterApplet extends JApplet {
  
    private JTextArea _textarea = null;
    private JScrollPane _scrollpane = null;

    public void init(){
      _textarea = new JTextArea(10, 20);
      _scrollpane = new JScrollPane(_textarea);
      this.getContentPane().add(_scrollpane);
   }

   public void start(){
     _textarea.append(this.getParameter("WelcomeMessage") + '\n');
     _textarea.append("\n");
     StringTokenizer st = new StringTokenizer(this.getParameter("Poem"), "-");
     while(st.hasMoreTokens()){
       _textarea.append(st.nextToken() + '\n');
     }
   }
} // end ParameterApplet class definition
