/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public class AdapterTesterApp {
   public static void main(String[] args){
     try{
     DataFileAdapter adapter = new DataFileAdapter();
     String[] rec_1 = {"C++ For Artists", "Rick Miller", "23", "1-932504-02-8", "$59.95", "80"};
     String[] rec_2 = {"Java For Artists", "Rick Miller", "23", "1-932504-04-X", "$69.95", "100"};

     String[] search_string = {"Java", " "};
     
     String[] temp_string = null;

        //adapter.createNewDataFile("books.dat");
        adapter.createRecord(rec_1);
        adapter.createRecord(rec_1);
        adapter.createRecord(rec_1);
        adapter.createRecord(rec_1);
        adapter.createRecord(rec_1);
        adapter.createRecord(rec_1);
        adapter.createRecord(rec_1);
        adapter.createRecord(rec_1);
        
        long lock_token = adapter.lockRecord(2);
        
        adapter.updateRecord(2, rec_2, lock_token);
        adapter.unlockRecord(2, lock_token);
        
        lock_token = adapter.lockRecord(1);
        adapter.deleteRecord(1, lock_token);
        adapter.unlockRecord(1, lock_token);
        
        
        
        long[] search_hits = adapter.searchRecords(search_string);
        

        System.out.println(adapter.readHeader());

        for(int i=0; i<search_hits.length; i++){
          try{
          temp_string = adapter.readRecord(search_hits[i]);
          for(int j = 0; j<temp_string.length; j++){
			System.out.print(temp_string[j]+" ");
		  }
	      System.out.println();
            }catch(RecordNotFoundException  e){ System.out.println(e.toString()); }
	   }

	   }catch(Exception e){ e.printStackTrace(); }

   }
}