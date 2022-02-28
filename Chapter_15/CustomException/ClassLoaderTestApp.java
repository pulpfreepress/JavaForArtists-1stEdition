/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class ClassLoaderTestApp {
   
   Object _object = null;

   public void loadClass(String class_name) throws CustomException {
      try{
         Class loaded_class = Class.forName(class_name);
         _object = loaded_class.newInstance();
         System.out.println(_object.toString());
        }
        catch(ClassNotFoundException e){
          throw new CustomException("A class by that name does not exist.", e);
          
         }
        catch(InstantiationException e){
          throw new CustomException("Problem creating an object of that class type.", e);
         }
        catch(IllegalAccessException e){
          throw new CustomException(e.toString(), e);
        }
   } 
  
   public static void main(String[] args){
     ClassLoaderTestApp clta = new ClassLoaderTestApp();
     try{
          clta.loadClass(args[0]);
        }
        catch(CustomException e){
          System.out.println(e.getMessage());
          System.out.println("Caused by: " + e.getCause().toString());
         }
        catch(ArrayIndexOutOfBoundsException e){
          System.out.println("You failed to enter a string! Please try again!");
        }
    }
}