/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/



public class CommandLine {
  public static void main(String[] args){
    StringBuffer sb = null;
    boolean upper_case = false;
    
   /********** check for upper case option **************/
   if(args.length > 0){
      switch(args[0].charAt(0)){
        case '-' : switch(args[0].charAt(1)){
                      case 'U' :
                      case 'u' : upper_case = true;
                                 break;
                      default:  upper_case = false;
                   }
                   break;
        default: upper_case = false;

      }// end outer switch
     
      sb = new StringBuffer();   //create StringBuffer object
 
   /******* process text string **********************/
      if(upper_case){
        for(int i = 1; i < args.length; i++){
           sb.append(args[i] + " ");
         }//end for
        System.out.println(sb.toString().toUpperCase());
      }else { 
          for(int i = 0; i < args.length; i++){
           sb.append(args[i] + " ");
         }//end for
        System.out.println(sb.toString().toLowerCase());
       }//end if/else
    
   } else { System.out.println("Usage: CommandLine [-U | -u] Text string");}

  }//end main
}//end class