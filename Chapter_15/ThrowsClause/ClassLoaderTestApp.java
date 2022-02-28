/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class ClassLoaderTestApp {
   
   Object _object = null;

   public void loadClass(String class_name) throws ClassNotFoundException, InstantiationException, 
                                                   IllegalAccessException, ArrayIndexOutOfBoundsException {
      Class loaded_class = Class.forName(class_name);
      _object = loaded_class.newInstance();
      System.out.println(_object.toString());
   } 
  
   public static void main(String[] args){
     ClassLoaderTestApp clta = new ClassLoaderTestApp();
     try{
          clta.loadClass(args[0]);
        }
        catch(ClassNotFoundException e){
          System.out.println("A class by that name does not exist. Please try again.");
          
         }
        catch(InstantiationException e){
          System.out.println("Problem creating an object of that class type. Please try again.");
         }
        catch(IllegalAccessException e){
          System.out.println(e.toString());
        }
        catch(ArrayIndexOutOfBoundsException e){
          System.out.println("You failed to enter a string when you ran the program!" 
			      + " Please try again!");
        }
   }
}