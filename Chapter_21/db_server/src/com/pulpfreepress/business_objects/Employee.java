/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package com.pulpfreepress.business_objects;

import java.util.*;
import java.io.*;

public class Employee implements Serializable {

  private int            _id               = 0;
  private String         _first_name       = null;
  private String         _middle_name      = null;
  private String         _last_name        = null;
  private String         _ssn              = null;
  private String         _dob              = null;
  private Vector         _child_relations  = null; 

  public Employee(int id, String fn, String mn, String ln, String ssn, String dob, Vector cr){
    _id = id;
    _first_name = fn;
    _middle_name = mn;
    _last_name = ln;
    _ssn = ssn;
    _dob = dob;
    if(cr != null) _child_relations = (Vector) cr.clone();
  }

  public Employee(){
    this(0, null, null, null, null, null, null);
  }

  public void setEmployeeID(int id){ _id = id; }

  public void setFirstName(String fn){ _first_name = fn; }

  public void setMiddleName(String mn) { _middle_name = mn; }

  public void setLastName(String ln) { _last_name = ln; }

  public void setSSN(String ssn) { _ssn = ssn; }

  public void setDOB(String dob) { _dob = dob; }

  public  void setChildRelations(Vector cr){ _child_relations = (Vector) cr.clone(); }

  public int getEmployeeID() { return _id; }

  public String getFirstName() { return _first_name; }

  public String getMiddleName() { return _middle_name; }

  public String getLastName() { return _last_name; }

  public String getSSN() { return _ssn; }

  public String getDOB() { return _dob; }

  public Vector getChildRelations() { return (Vector) _child_relations.clone(); }

}
