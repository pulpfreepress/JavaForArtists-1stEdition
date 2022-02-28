/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.business_objects;

import java.io.*;

public class EmployeeTraining implements Serializable {
 
  private int     _id     = 0;
  private int     _emp_id = 0;
  private String  _date   = null;
  private String  _topic  = null;
  private String  _result = null;

  public EmployeeTraining(int id, int emp_id, String date, String topic, String result){
    _id     = id;
    _emp_id = emp_id;
    _date   = date;
    _topic  = topic;
    _result = result;
  }

  public EmployeeTraining(){
    this(0, 0, null, null, null);
  }

  public void setEmployeeTrainingID(int id) { _id = id; }

  public void setEmployeeID(int id) { _emp_id = id; }

  public void setDate(String date){ _date = date; }

  public void setTopic(String topic) { _topic = topic; }

  public void setResult(String result) { _result = result; }

  public int getEmployeeTrainingID() { return _id; }
 
  public  int getEmployeeID() { return _emp_id; }

  public String getDate() { return _date; }

  public String getTopic() { return _topic; }

  public String getResult() { return _result; }

}
