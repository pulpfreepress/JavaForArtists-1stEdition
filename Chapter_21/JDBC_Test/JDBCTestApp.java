/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.sql.*;

public class JDBCTestApp {
  public static void main(String[] args){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + 
                                                      "chapter_22?user=swodog");
        String default_query = "select * from employees";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(default_query);
        ResultSetMetaData  meta_data = rs.getMetaData();
        for(int i = 1; i <= meta_data.getColumnCount(); i++){
          System.out.print(meta_data.getColumnName(i)+ ':' +
                           meta_data.getColumnTypeName(i) + '\t');
        }
        System.out.println();
        while(rs.next()){
          System.out.print(rs.getInt(1) + "\t\t");
          System.out.print(rs.getString(2) + "\t");
          System.out.print(rs.getString(3) + "\t");
          System.out.print(rs.getString(4) + "\t");
          System.out.print(rs.getString(5) + "\t");
          System.out.println(rs.getDate(6).toString());
       }
      }catch(Exception e){
        e.printStackTrace();
      }

  }// end main() method
}// end JDBCTestApp class definition
