/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/



public class DynamicArray {
  private Object[] _object_array = null;
  private int _next_open_element = 0;
  private int _growth_increment = 10;
  private static final int INITIAL_SIZE = 25;

  public DynamicArray(int size){
    _object_array = new Object[size];
  }

  public DynamicArray(){
    this(INITIAL_SIZE);
  }

  public void add(Object o){
    if(_next_open_element < _object_array.length){
       _object_array[_next_open_element++] = o;
    }else{
	growArray();
	_object_array[_next_open_element++] = o;
     }
  } // end add() method;


  private void growArray(){
    Object[] temp_array = _object_array;
    _object_array = new Object[_object_array.length + _growth_increment];
    for(int i=0, j=0; i<temp_array.length; i++){
      if(temp_array[i] != null){
        _object_array[j++] = temp_array[i];
       }
       _next_open_element = j;
     }
     temp_array = null;
  } // end growArray() method


  public Object get(int index){
    if((index >= 0) && (index < _object_array.length)){
       return _object_array[index];
    }else return null;
  }

  public int size(){ return _next_open_element; }

} // end DynamicArray class definition
