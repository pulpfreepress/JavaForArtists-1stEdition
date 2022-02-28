/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.util.*;
import java.io.*;

public class TokenTest{
public static void main(String[] args){
  String s = "Java is fun!";
  StringTokenizer st = new StringTokenizer(s);
  System.out.println(st.countTokens());
  while(st.hasMoreTokens()){
    System.out.print(st.nextToken()+" ");
  }

 try{
   File f = new File("TokenTest.java");
   FileReader fr = new FileReader(f);
   BufferedReader br = new BufferedReader(fr);
   String line_in;
   while((line_in = br.readLine()) != null)
	System.out.println(line_in);
   br.close();
   }catch(IOException e){}

 try{
    File f = new File("test.txt");
    FileWriter fw  = new FileWriter(f);
    PrintWriter pr = new PrintWriter(fw);
    for(int i=0; i<10; i++){
	pr.println("I love Java!");
    }
    pr.close();
    }catch(IOException e){}

}

}