/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.sql.*;
import com.pulpfreepress.business_objects.*;

public class JDBCTestAppTwo {
  public static void main(String[] args){
    try{
      final int ID_COL = 1;
      final int FN_COL = 2;
      final int MN_COL = 3;
      final int LN_COL = 4;
      final int SSN_COL = 5;
      final int DOB_COL = 6;

      System.out.println("Loading MySql JDBC driver class...");
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("MySql JDBC driver class loaded successfully");

      System.out.println("Attempting to connect to the database...");
      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chapter_21?user=swodog");
      System.out.println("Database connection created successfully");

      Statement statement = conn.createStatement();
      ResultSet result_set = statement.executeQuery("select * from employees");
      ResultSetMetaData  meta_data = result_set.getMetaData();
      for(int i = 1; i <= meta_data.getColumnCount(); i++){
       System.out.print(meta_data.getColumnName(i)+ ':' + meta_data.getColumnTypeName(i) + '\t');
      }
      System.out.println();     

     while(result_set.next()){
        System.out.println(result_set.getInt(ID_COL) + "\t\t" +
                         result_set.getString(FN_COL) + '\t' +
                         result_set.getString(MN_COL) + '\t' +
                         result_set.getString(LN_COL) + '\t' +
                         result_set.getString(SSN_COL) + '\t' +
                         result_set.getDate(DOB_COL).toString());
      }// end while

      PreparedStatement pstmt = conn.prepareStatement(
        "insert into employees (employee_id, first_name, middle_name, last_name, ssn, date_of_birth)" +
        "values (?,?,?,?,?,?)" );

      pstmt.setInt(ID_COL, 0);
      pstmt.setString(FN_COL, "Coralie");
      pstmt.setString(MN_COL, "Sylvia");
      pstmt.setString(LN_COL, "Miller");
      pstmt.setString(SSN_COL, "111-11-1112");
      pstmt.setDate(DOB_COL, java.sql.Date.valueOf("1968-12-29"));
      pstmt.executeUpdate();

      PreparedStatement pstmt2 = conn.prepareStatement(
        "insert into employee_training (employee_training_id, employee_id, date, topic, result)" +
        "values(?,?,?,?,?)" );
      pstmt2.setInt(1, 0);
      pstmt2.setInt(2, 1);
      pstmt2.setDate(3, java.sql.Date.valueOf("2001-02-05"));
      pstmt2.setString(4, "How To Be A Better Leader");
      pstmt2.setString(5, "Passed");
      pstmt2.executeUpdate();

      Statement statement2 = conn.createStatement();
      ResultSet result_set2 = statement2.executeQuery("SELECT first_name, last_name, date, topic, result " +
                                                      "FROM employees, employee_training " +
                                                      "WHERE ((employees.employee_id = 1) && (employee_training.employee_id = 1))" );
                                                      
      while(result_set2.next()){
        System.out.println(result_set2.getString(1) + '\t' +
                           result_set2.getString(2) + '\t' +
                           result_set2.getDate(3).toString() + '\t' +
                           result_set2.getString(4) + '\t' +
                           result_set2.getString(5));
      }// end while


     conn.close();
     statement.close();
     result_set.close();
     pstmt.close();
     pstmt2.close();
     statement2.close();
     result_set2.close();

     }catch(Exception e){
       e.printStackTrace();
     } // end try-catch block
  }// end main()
}// end JDBCTestApp class definition
