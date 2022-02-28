/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

public interface LegacyDatafileInterface {

  /**
  * Read the record indicated by the rec_no and return a string array
  * were each element contains a field value.
  */
  public String[] readRecord(long rec_no) throws RecordNotFoundException;

  /**
   * Update a record's fields. The record must be locked with the lockRecord()
   * method and the lock_token must be valid. The value for field n appears in
   * element record[n].
   */
  public void updateRecord(long rec_no, String[] record, long lock_token) throws
  RecordNotFoundException, SecurityException;

  /**
   * Marks a record for deletion by setting the deleted field to 1. The lock_token
   * must be valid otherwise a SecurityException is thrown.
   */
  public void deleteRecord(long rec_no, long lock_token) throws
  RecordNotFoundException, SecurityException;


  /**
   * Creates a new datafile record and returns the record number.
   */
  public long createRecord(String[] record) throws FailedRecordCreationException;

  /**
   * Locks a record for updates and deletes and returns an integer
   * representing a lock token.
   */
  public long lockRecord(long rec_no) throws RecordNotFoundException;

  /**
   * Unlocks a previously locked record. The lock_token must be valid or a
   * SecurityException is thrown.
   */
  public void unlockRecord(long rec_no, long lock_token) throws SecurityException;

  /**
   * Searches the records in the datafile for records that match the String
   * values of search_criteria. search_criteria[n] contains the search value
   * applied against field n.
   */
  public long[] searchRecords(String[] search_criteria);

}//end interface definition