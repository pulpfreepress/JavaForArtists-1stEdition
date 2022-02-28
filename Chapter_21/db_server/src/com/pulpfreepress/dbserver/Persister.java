/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.dbserver;

import java.sql.*;
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import com.pulpfreepress.business_objects.*;
import com.pulpfreepress.utils.*;


public class Persister extends UnicastRemoteObject implements PersisterInterface {
  private static DBServerProperties _props = null;
  private Connection _conn = null;
  
  // Employees Table Column Values
  private static final int ID_COL = 1;
  private static final int FN_COL = 2;
  private static final int MN_COL = 3;
  private static final int LN_COL = 4;
  private static final int SSN_COL = 5;
  private static final int DOB_COL = 6;
  
  // EmployeeTraining Table Column Values
  private static final int TR_ID_COL = 1;
  private static final int EMP_ID_COL = 2;
  private static final int DATE_COL = 3;
  private static final int TOPIC_COL = 4;
  private static final int RESULT_COL = 5;
   

  static{
    _props = DBServerProperties.getInstance();
    }

  public Persister() throws RemoteException {
    try{
      System.out.println("Loading JDBC driver class...");
      Class.forName(_props.getProperty(_props.DEFAULT_JDBC_DRIVER));
      System.out.println("JDBC driver class loaded successfully.");
      System.out.println("Creating connection to database...");
      _conn = DriverManager.getConnection(_props.getProperty(_props.DEFAULT_MYSQL_JDBC_PROTOCOL) +
                                         "://" +
                                         _props.getProperty(_props.DEFAULT_SERVER_IP) +
                                         ":" + 
                                         _props.getProperty(_props.DEFAULT_MYSQL_DB_PORT) +
                                         "/" +
                                         _props.getProperty(_props.DEFAULT_DATABASE) +
                                         "?user=" +
                                         _props.getProperty(_props.DEFAULT_DB_USER));   
      System.out.println("Database connection created successfully.");
      System.out.println("Persister object created successfully.");                                                         
    }catch(Exception e){
      e.printStackTrace();
    }
    
  } // end constructor
  
  
  public void finalize() throws Throwable {
    _conn.close();
    super.finalize();
  }
  
  public synchronized Vector queryByLastName(String last_name){
       Vector employee_vector = new Vector();
       Statement statement = null;
       ResultSet result_set = null;
       String query = null;
       try{
         if((last_name == null) || (last_name.equals(""))){
            query = "SELECT * FROM employees";
            statement = _conn.createStatement();
            result_set = statement.executeQuery(query);
          }else{
             query = "SELECT * FROM employees WHERE (employees.last_name = '" + last_name +"')";
             statement = _conn.createStatement();
             result_set = statement.executeQuery(query);
            }

          while(result_set.next()){
            employee_vector.add(new Employee(result_set.getInt(ID_COL),
                                             result_set.getString(FN_COL),
                                             result_set.getString(MN_COL),
                                             result_set.getString(LN_COL),
                                             result_set.getString(SSN_COL),
                                             result_set.getDate(DOB_COL).toString(),
                                             null));
         }
      }catch(Exception e){
         e.printStackTrace();
       }
       finally{
         try{
         if(statement != null) statement.close();
         if(result_set != null) result_set.close();
         System.out.println("statement & result_set closed");
         }catch(Exception ignored){ }
       }
       return employee_vector;
  } // end queryByLastName() method
  
  
  
  public synchronized void addNewEmployee(Employee emp){
    PreparedStatement statement = null;
    String insert = 
         "INSERT INTO employees (employee_id, first_name, middle_name, last_name, ssn, date_of_birth)" +
         "VALUES (?,?,?,?,?,?)";
    try{
       statement = _conn.prepareStatement(insert);
       statement.setInt(ID_COL, 0);
       statement.setString(FN_COL, emp.getFirstName());
       statement.setString(MN_COL, emp.getMiddleName());
       statement.setString(LN_COL, emp.getLastName());
       statement.setString(SSN_COL, emp.getSSN());
       statement.setDate(DOB_COL, java.sql.Date.valueOf(emp.getDOB()));
       statement.executeUpdate();
    }catch(Exception e){
       e.printStackTrace();
     }
    finally{
      try{
        statement.close();
       }catch(Exception ignored){ }
    }
  } // end addNewEmployee() methhod
  
  
  public synchronized void addTrainingRecord(EmployeeTraining et){
     PreparedStatement statement = null;
     String insert = "INSERT INTO employee_training (employee_training_id, employee_id, date, topic, result)" +
                     "VALUES (?,?,?,?,?)";
     try{
        statement = _conn.prepareStatement(insert);
        statement.setInt(TR_ID_COL, 0);
        statement.setInt(EMP_ID_COL, et.getEmployeeID());
        statement.setDate(DATE_COL, java.sql.Date.valueOf(et.getDate()));
        statement.setString(TOPIC_COL, et.getTopic());
        statement.setString(RESULT_COL, et.getResult());
        statement.executeUpdate();
     
     }catch(Exception e){
       e.printStackTrace();
     }
     finally{
       try{
         statement.close();
       }catch(Exception ignored){ }
     }
  } // end addTrainingRecord() method
  
  public synchronized Employee getEmployeeTrainingRecords(Employee emp){
    PreparedStatement statement = null;
    ResultSet result_set = null;
    Vector training_records = new Vector();
    String query = "SELECT * " + 
                   "FROM employee_training " + 
                   "WHERE (employee_training.employee_id = ?)";
    try{
       statement = _conn.prepareStatement(query);
       statement.setInt(1, emp.getEmployeeID());
       result_set = statement.executeQuery();
       while(result_set.next()){
         training_records.add(new EmployeeTraining(result_set.getInt(TR_ID_COL),
                                                   result_set.getInt(EMP_ID_COL),
                                                   result_set.getDate(DATE_COL).toString(),
                                                   result_set.getString(TOPIC_COL),
                                                   result_set.getString(RESULT_COL)));
       }
       emp.setChildRelations(training_records);
    
    }catch(Exception e){
       e.printStackTrace();
     }
    finally{
      try{
         statement.close();
         result_set.close();
      }catch(Exception ignored){ }
    }
    return emp;
  }// end getEmployeeTrainingRecords() method
  
  

}// end Persister class definition
