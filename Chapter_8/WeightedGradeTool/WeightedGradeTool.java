/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class WeightedGradeTool {
  public static void main(String[] args){
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    double[][]   grades   = null;
    double[]  weights  = null;
    String[]  students = null;
    int student_count = 0;
    int grade_count = 0;
    double final_grade = 0;

    System.out.println("Welcome to Weighted Grade Tool");

   /**************** get student count *********************/ 
    System.out.print("Please enter the number of students: ");
    try{
       student_count = Integer.parseInt(console.readLine());
       }catch(NumberFormatException nfe){ System.out.println("That was not an integer!");
                                          System.out.println("Student count will be set to 3.");
                                          student_count = 3; }
        catch(IOException ioe){ System.out.println("Trouble reading from the console!"); 
                                System.out.println("Student count will be set to 3.");
                                student_count = 3; }

   if(student_count > 0){
      students = new String[student_count];
      /***************** get student names **********************/
      getNames: for(int i = 0; i < students.length; i++){
                  System.out.print("Enter student name: ");
                  try{
                     students[i] = console.readLine();
                      } catch(IOException ioe){ System.out.println("Problem reading console!"); 
                                                System.exit(0); }
      }//end getNames for
 
      /**************** get number of grades per student ****************************/
      System.out.print("Please enter the number of grades to average: ");
      try{
       grade_count = Integer.parseInt(console.readLine());
       }catch(NumberFormatException nfe){ System.out.println("That was not an integer!");
                                          System.out.println("Grade count will be set to 3.");
                                          grade_count = 3; }
        catch(IOException ioe){ System.out.println("Trouble reading from the console!"); 
                                System.out.println("Grade count will be set to 3.");
                                grade_count = 3; }
      
     /****************** get raw grades *****************************/
     grades = new double[student_count][grade_count];
     getGrades: for(int i = 0; i < grades.length; i++){
                   System.out.println("Enter raw grades for " + students[i]);
                   for(int j = 0; j < grades[i].length; j++){
                     System.out.print("Grade " + (j+1) + ": ");
                     try{
                         grades[i][j] = Double.parseDouble(console.readLine());
                         }catch(NumberFormatException nfe){ System.out.println("That was not a double!");
                                                            System.out.println("Grade will be set to 100");
                                                            grades[i][j] = 100; }
                          catch(IOException ioe){ System.out.println("Trouble reading from the console!"); 
                                                  System.out.println("Grade will be set to 100.");
                                                  grades[i][j] = 100; }
     
                   }//end inner for
                }// end getGrades for

    /***************** get grade weights *********************/
    weights = new double[grade_count];
    System.out.println("Enter grade weights. Make sure they total 100%");
    getWeights: for(int i = 0; i < weights.length; i++){
                  System.out.print("Weight for grade " + (i + 1) + ": ");
                  try{
                     weights[i] = Double.parseDouble(console.readLine());
                     }catch(NumberFormatException nfe){ System.out.println("That was not a double!");
                                                        System.out.println("Program will exit!");
                                                        System.exit(0); }
                      catch(IOException ioe){ System.out.println("Trouble reading from the console!"); 
                                              System.out.println("Program will exit!");
                                              System.exit(0); }
                }//end getWeights for

     /****************** calculate weighted grades ********************/
     calculateGrades: for(int i = 0; i < grades.length; i++){
                        for(int j = 0; j < grades[i].length; j++){
                           grades[i][j] *= weights[j];
                        }//end inner for
                      }//end calculateGrades for

     /***************** calculate and print final grade *********************/
     finalGrades: for(int i = 0; i < grades.length; i++){
                     System.out.println("Weighted grades for " + students[i] + ": ");
                     final_grade = 0;
                      for(int j = 0; j < grades[i].length; j++){
                       final_grade += grades[i][j];
                     System.out.print(grades[i][j] + " ");
                      }//end inner for
                     System.out.println(students[i] +"'s final grade is: " + final_grade );
                    }//end averageGrades for
    }// end if
  }// end main
}// end class