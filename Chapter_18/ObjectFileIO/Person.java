/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public  class Person implements Serializable {

	private String _f_name;
	private String _m_name;
	private String _l_name;
	private String _gender;

	public Person(String f_name, String m_name, String l_name, String gender){
		_f_name = f_name;
		_m_name = m_name;
		_l_name = l_name;
		_gender = gender;
	}

	public String getFirstName(){ return _f_name; }
	public String getMiddleName(){ return _m_name; }
	public String getLastName(){ return _l_name; }
	public String getGender(){ return _gender; }
	public String toString(){ return _f_name + " " + _m_name + " " + _l_name + " " + _gender; }

}