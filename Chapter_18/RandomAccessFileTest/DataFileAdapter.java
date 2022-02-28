/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;
import java.util.*;


public class DataFileAdapter implements LegacyDatafileInterface {

    /**
    * Class Constants
    */

	private static final short FILE_IDENTIFIER = 378;
	private static final int HEADER_LENGTH   =  54;
	private static final int RECORDS_START   =  54;
	private static final int RECORD_LENGTH   = 130;
	private static final int FIELD_COUNT     =   7;

	private static final short DELETED_FIELD_LENGTH  =  1;
	private static final short TITLE_FIELD_LENGTH    = 50;
	private static final short AUTHOR_FIELD_LENGTH   = 50;
	private static final short PUB_CODE_FIELD_LENGTH =  4;
	private static final short ISBN_FIELD_LENGTH     = 13;
	private static final short PRICE_FIELD_LENGTH    =  8;
	private static final short QOH_FIELD_LENGTH      =  4;

	private static final String DELETED_STRING  = "deleted";
	private static final String TITLE_STRING    = "title";
	private static final String AUTHOR_STRING   = "author";
	private static final String PUB_CODE_STRING = "pub_code";
	private static final String ISBN_STRING     = "ISBN";
	private static final String PRICE_STRING    = "price";
	private static final String QOH_STRING      = "qoh";

	private static final int TITLE_FIELD    = 0;
	private static final int AUTHOR_FIELD   = 1;
	private static final int PUB_CODE_FIELD = 2;
	private static final int ISBN_FIELD     = 3;
	private static final int PRICE_FIELD    = 4;
	private static final int QOH_FIELD      = 5;

	private static final int VALID   = 0;
	private static final int DELETED = 1;

    /**
    * Field offsets used with String.substring() method
    */
	private static final int DELETED_START_OFFSET  =   0;
	private static final int DELETED_STOP_OFFSET   =   1;
	private static final int TITLE_START_OFFSET    =   1;
	private static final int TITLE_STOP_OFFSET     =  51;
	private static final int AUTHOR_START_OFFSET   =  51;
	private static final int AUTHOR_STOP_OFFSET    = 101;
	private static final int PUB_CODE_START_OFFSET = 101;
	private static final int PUB_CODE_STOP_OFFEST  = 105;
	private static final int ISBN_START_OFFSET     = 105;
	private static final int ISBN_STOP_OFFSET      = 118;
	private static final int PRICE_START_OFFSET    = 118;
	private static final int PRICE_STOP_OFFSET     = 126;
	private static final int QOH_START_OFFSET      = 126;
	private static final int QOH_STOP_OFFSET       = 130;

	/**
	* Instance Fields
	*/

	private File             _filename               = null;
	private RandomAccessFile _raf                    = null;
	private long		 _record_count           = 0;
	private HashMap          _locked_records_map     = null;
	private Random           _token_maker            = null;
	private long              _current_record_number = 0;


    /**
    * Constructor
    *
    */
     public DataFileAdapter(String filename) throws InvalidDataFileException {
        try{
        _filename = new File(filename);
        _raf = new RandomAccessFile(_filename, "rw");
        _raf.seek(0);
        if((_raf.length() >= HEADER_LENGTH) && (_raf.readShort() == FILE_IDENTIFIER)){ // it's a valid data file
            System.out.println("Setting up data file for I/O operations");
            _record_count = ((_raf.length() - HEADER_LENGTH) / RECORD_LENGTH);
            _current_record_number = 0;
            _locked_records_map = new HashMap();
            _token_maker = new Random();
          }else if(_raf.length() == 0) { // it's an empty file - make it a data file
                  _raf.seek(0);
                  _raf.writeShort(FILE_IDENTIFIER);
                  _raf.writeBytes(DELETED_STRING);
                  _raf.writeShort(DELETED_FIELD_LENGTH);
                  _raf.writeBytes(TITLE_STRING);
                  _raf.writeShort(TITLE_FIELD_LENGTH);
                  _raf.writeBytes(AUTHOR_STRING);
                  _raf.writeShort(AUTHOR_FIELD_LENGTH);
                  _raf.writeBytes(PUB_CODE_STRING);
                  _raf.writeShort(PUB_CODE_FIELD_LENGTH);
                  _raf.writeBytes(ISBN_STRING);
                  _raf.writeShort(ISBN_FIELD_LENGTH);
                  _raf.writeBytes(PRICE_STRING);
                  _raf.writeShort(PRICE_FIELD_LENGTH);
                  _raf.writeBytes(QOH_STRING);
                  _raf.writeShort(QOH_FIELD_LENGTH);

                  _record_count       = 0;
                  _locked_records_map = new HashMap();
                  _token_maker        = new Random();
          
                } else {
                       _raf.seek(0);
                       if(_raf.readShort() != FILE_IDENTIFIER){
                          _raf.close();
                          System.out.println("Invalid data file. Closing file.");
                          throw new InvalidDataFileException(null);
                        }
                      }

        }catch(IOException e){
           System.out.println("Problem opening or creating data file.");
           System.out.println(e.toString());
          }

    } // end constructor

    
    /**
    * Default constructor
    *
    */
    public DataFileAdapter() throws InvalidDataFileException {
       this("books.dat");
    }
    


	 /**
	 * CreateNewDataFile
	 *
	 */
     public void createNewDataFile(String filename) throws NewDataFileException{
       try{
           if(_raf != null){
             _raf.close();
           }
           _raf = new RandomAccessFile(filename, "rw");

           _raf.seek(0);
           _raf.writeShort(FILE_IDENTIFIER);
           _raf.writeBytes(DELETED_STRING);
           _raf.writeShort(DELETED_FIELD_LENGTH);
           _raf.writeBytes(TITLE_STRING);
           _raf.writeShort(TITLE_FIELD_LENGTH);
           _raf.writeBytes(AUTHOR_STRING);
           _raf.writeShort(AUTHOR_FIELD_LENGTH);
           _raf.writeBytes(PUB_CODE_STRING);
           _raf.writeShort(PUB_CODE_FIELD_LENGTH);
           _raf.writeBytes(ISBN_STRING);
           _raf.writeShort(ISBN_FIELD_LENGTH);
           _raf.writeBytes(PRICE_STRING);
           _raf.writeShort(PRICE_FIELD_LENGTH);
           _raf.writeBytes(QOH_STRING);
           _raf.writeShort(QOH_FIELD_LENGTH);

           _record_count = 0;
           _locked_records_map = new HashMap();
           _token_maker        = new Random();

		  }catch(IOException e){
			   System.out.println(e.toString());
			   throw new NewDataFileException(e);
			   }

	 } // end createNewDataFile method




	 /**
	 *  OpenDataFile
	 *
	 */
     public void openDataFile(String filename) throws InvalidDataFileException {
        try{
           if(_raf != null){
           _raf.close();
           }
          _filename = new File(filename);
          _raf = new RandomAccessFile(_filename, "rw");
          _raf.seek(0);
          if((_raf.length() >= HEADER_LENGTH) && (_raf.readShort() == FILE_IDENTIFIER)){ // it's a valid data file
              System.out.println("Setting up data file for I/O operations");
              _record_count = ((_raf.length() - HEADER_LENGTH) / RECORD_LENGTH);
              _current_record_number = 0;
              _locked_records_map = new HashMap();
              _token_maker = new Random();
            }else if(_raf.length() == 0) { // it's an empty file - make it a data file
                    _raf.seek(0);
                    _raf.writeShort(FILE_IDENTIFIER);
                    _raf.writeBytes(DELETED_STRING);
                    _raf.writeShort(DELETED_FIELD_LENGTH);
                    _raf.writeBytes(TITLE_STRING);
                    _raf.writeShort(TITLE_FIELD_LENGTH);
                    _raf.writeBytes(AUTHOR_STRING);
                    _raf.writeShort(AUTHOR_FIELD_LENGTH);
                    _raf.writeBytes(PUB_CODE_STRING);
                    _raf.writeShort(PUB_CODE_FIELD_LENGTH);
                    _raf.writeBytes(ISBN_STRING);
                    _raf.writeShort(ISBN_FIELD_LENGTH);
                    _raf.writeBytes(PRICE_STRING);
                    _raf.writeShort(PRICE_FIELD_LENGTH);
                    _raf.writeBytes(QOH_STRING);
                    _raf.writeShort(QOH_FIELD_LENGTH);

                    _record_count       = 0;
                    _locked_records_map = new HashMap();
                    _token_maker        = new Random();
          
                } else {
                       _raf.seek(0);
                       if(_raf.readShort() != FILE_IDENTIFIER){
                          _raf.close();
                          System.out.println("Invalid data file. Closing file.");
                          throw new InvalidDataFileException(null);
                        }
                      }

          }catch(IOException e){
             System.out.println("Problem opening or creating data file.");
             System.out.println(e.toString());
            }

	 } // end openDataFile method




  /**
   * Read the record indicated by the rec_no and return a string array
   * were each element contains a field value.
   */
    public String[] readRecord(long rec_no) throws RecordNotFoundException {
        String[] temp_string = null;
        if((rec_no < 0) || (rec_no > _record_count)){
           System.out.println("Requested record out of range!");
           throw new RecordNotFoundException("Requested record out of range", null);
        }else{
              try{
                 gotoRecordNumber(rec_no);
                 if(_raf.readByte() == DELETED){
                   System.out.println("Record has been deleted!");
                   throw new RecordNotFoundException("Record " + rec_no + " deleted!", null);
                 }else{
                      temp_string = recordBytesToStringArray(rec_no);
                   }
                 }catch(IOException e){
                    System.out.println(e.toString());
                    throw new RecordNotFoundException("Problem in readRecord method", e);
                   }
              } // end else
         return temp_string;
    } // end readRecord()




	  /**
	   * Update a record's fields. The record must be locked with the lockRecord()
	   * method and the lock_token must be valid. The value for field n appears in
	   * element record[n]. The call to updateRecord() MUST be preceeded by a call
           * to lockRecord() and followed by a call to unlockRecord()
	   */
	  public void updateRecord(long rec_no, String[] record, long lock_token) throws
	  RecordNotFoundException, SecurityException{
             if(lock_token != ((Long)_locked_records_map.get(new Long(rec_no))).longValue()){
                System.out.println("Invalid  update record lock token.");
                throw new SecurityException("Invalid update record lock token.", null);
             }else{
                  try{
		    gotoRecordNumber(rec_no); //i.e., goto indicated record
		    _raf.writeByte((byte)0);
		    _raf.write(stringToPaddedByteField(record[TITLE_FIELD], TITLE_FIELD_LENGTH));
		    _raf.write(stringToPaddedByteField(record[AUTHOR_FIELD], AUTHOR_FIELD_LENGTH));
		    _raf.writeInt(Integer.parseInt(record[PUB_CODE_FIELD]));
		    _raf.write(stringToPaddedByteField(record[ISBN_FIELD], ISBN_FIELD_LENGTH));
		    _raf.write(stringToPaddedByteField(record[PRICE_FIELD], PRICE_FIELD_LENGTH));
		    _raf.writeInt(Integer.parseInt(record[QOH_FIELD]));
		    _current_record_number = rec_no;
		}catch(IOException e){
                          System.out.println("updateRecord(): Problem writing record information.");
			  System.out.println(e.toString());
		  }
		  catch(NumberFormatException e){
                          System.out.println("updateRecord(): Problem converting Strings to numbers.");
			  System.out.println(e.toString());
		  }
                  catch(Exception e){
                    System.out.println("updateRecord(): Exception occured.");
                    System.out.println(e.toString()); 
                  }
              }// end else
	  }// end updateRecord()




	  /**
	   * Marks a record for deletion by setting the deleted field to 1. The lock_token
	   * must be valid otherwise a SecurityException is thrown.
	   */
	  public void deleteRecord(long rec_no, long lock_token) throws
	  RecordNotFoundException, SecurityException {
            if(lock_token != ((Long)_locked_records_map.get(new Long(rec_no))).longValue()){
               System.out.println("Invalid delete record lock token.");
               throw new SecurityException("Invalid delete record lock token.", null);
            }else{
                  try{
                      gotoRecordNumber(rec_no); // goto record indicated
                      _raf.writeByte((byte)1);  // mark for deletion
                    
                     }catch (IOException e){
                        System.out.println("deleteRecord(): " + e.toString());
                       }
              }// end else
            }// end deleteRecord() 





	  /**
	   * Creates a new datafile record and returns the record number.
	   */
	  public long createRecord(String[] record) throws FailedRecordCreationException {
        try{
		    gotoRecordNumber(_record_count); //i.e., goto end of file
		    _raf.writeByte((byte)0);
		    _raf.write(stringToPaddedByteField(record[TITLE_FIELD], TITLE_FIELD_LENGTH));
		    _raf.write(stringToPaddedByteField(record[AUTHOR_FIELD], AUTHOR_FIELD_LENGTH));
		    _raf.writeInt(Integer.parseInt(record[PUB_CODE_FIELD]));
		    _raf.write(stringToPaddedByteField(record[ISBN_FIELD], ISBN_FIELD_LENGTH));
		    _raf.write(stringToPaddedByteField(record[PRICE_FIELD], PRICE_FIELD_LENGTH));
		    _raf.writeInt(Integer.parseInt(record[QOH_FIELD]));
		    _current_record_number = ++_record_count;
		}catch(IOException e){
			  System.out.println(e.toString());
			  throw new FailedRecordCreationException("IOException in createRecord method", e);
		  }
		  catch(NumberFormatException e){
			  System.out.println(e.toString());
			  throw new FailedRecordCreationException("NumberFormatException in createRecord method", e);
		  }
		  catch(RecordNotFoundException e){
			  System.out.println(e.toString());
			  throw new FailedRecordCreationException("RecordNotFoundException in createRecord method", e);
		  }
        return _current_record_number;
	  }




	  /**
	   * Locks a record for updates and deletes and returns an integer
	   * representing a lock token.
	   */
	  public long lockRecord(long rec_no) throws RecordNotFoundException {
             long lock_token = 0;
             if((rec_no < 0) || (rec_no > _record_count)){
               System.out.println("Record cannot be locked. Not in valid range.");
               throw new RecordNotFoundException("Record cannot be locked. Not in valid range.", null);
             }else synchronized(_locked_records_map){
                   while(_locked_records_map.containsKey(new Long(rec_no))){
                     try{
                         _locked_records_map.wait();
                        }catch(InterruptedException ignored){ }
                   }
                    lock_token = _token_maker.nextLong();
                    _locked_records_map.put(new Long(rec_no), new Long(lock_token));
                }

           return lock_token;
	  } // end lockRecord method




      /**
      * Unlocks a previously locked record. The lock_token must be valid or a
      * SecurityException is thrown.
      */
      public void unlockRecord(long rec_no, long lock_token) throws SecurityException {
        synchronized(_locked_records_map){
          if(_locked_records_map.containsKey(new Long(rec_no))){
             if(lock_token == ((Long)_locked_records_map.get(new Long(rec_no))).longValue()){
               _locked_records_map.remove(new Long(rec_no));
               _locked_records_map.notifyAll();
             }else{
                System.out.println("Invalid lock token.");
                throw new SecurityException("Invalid lock token", null);
               }
          }else{
                System.out.println("Invalid record unlock key.");
                throw new SecurityException("Invalid record unlock key.", null);
              }
        }
      }// end unlockRecord method




   /**
    * Searches the records in the datafile for records that match the String
    * values of search_criteria. search_criteria[n] contains the search value
    * applied against field n. Data files can be searched for Title & Author.
    * 
    */
    public long[] searchRecords(String[] search_criteria){
      Vector hit_vector = new Vector();
      for(int i=0; i<_record_count; i++){
        try{
           if(thereIsAMatch(search_criteria, readRecord(i))){
             hit_vector.addElement(new Long(i));
           }
         }catch(RecordNotFoundException ignored){ } // ignore deleted records
      } // end for
      long hits[] = new long[hit_vector.size()];
      for(int i=0; i<hits.length; i++){
        hits[i] = ((Long)hit_vector.elementAt(i)).longValue();
      }
     return hits;
    }





   /**
   * thereIsAMatch() is a utility method that actually performs
   * the record search. Implements an implied OR/AND search by detecting 
   * the first character of the Title criteria element.
   */
   private boolean thereIsAMatch(String[] search_criteria, String[] record){
   boolean match_result = false;
     final int TITLE  = 0;
     final int AUTHOR = 1;
     for(int i=0; i<search_criteria.length; i++){
       if((search_criteria[i].length() == 0) || (record[i+1].startsWith(search_criteria[i]))){
          match_result = true;
          break;
       } //end if
     } //end for
     
     if(((search_criteria[TITLE].length() > 1) && (search_criteria[AUTHOR].length() >= 1)) && 
                                                    (search_criteria[TITLE].charAt(0) == '&')) {
         if(record[TITLE+1].startsWith(search_criteria[TITLE].substring(1, search_criteria[TITLE].length()).trim()) && 
                                                                 record[AUTHOR+1].startsWith(search_criteria[AUTHOR])){
            match_result = true;                                                        
         }else {
             match_result = false;
           }
         
      } // end if
    return match_result;
   } // end thereIsAMatch()

   


       /**
       * gotoRecordNumber - utility function that handles the messy
       * details of seeking a particular record.
       *
       */
       private void gotoRecordNumber(long record_number) throws RecordNotFoundException {
         if((record_number < 0) || (record_number > _record_count)){
            throw new RecordNotFoundException(null);
          }else{
               try{
                  _raf.seek(RECORDS_START + (record_number * RECORD_LENGTH));

                  }catch(IOException e){
                      System.out.println(e.toString());
                      throw new RecordNotFoundException(e);
                    }
               }// end else

	   } // end gotoRecordNumber method



      /**
      * stringToPaddedByteField - pads the field to maintain fixed
      * field length.
      *
      */
      protected byte[] stringToPaddedByteField(String s, int field_length){
        byte[] byte_field = new byte[field_length];
        if(s.length() <= field_length){
          for(int i = 0; i<s.length(); i++){
            byte_field[i] = (byte)s.charAt(i);
          }
          for(int i = s.length(); i<field_length; i++){
            byte_field[i] = (byte)' '; //pad the field
          }
         }else{
              for(int i = 0; i<field_length; i++){
                byte_field[i] = (byte)s.charAt(i);
              }
          }
         return byte_field;
      } // end stringToPaddedByteField()


   /**
    * recordBytesToStringArray - reads an array of bytes from a data file
    * and converts them to an array of Strings. The first element of the
    * returned array is the record number. The length of the byte array
    * argument is RECORD_LENGTH -1.
    *
    */
    private String[] recordBytesToStringArray(long record_number){
      String record_string = null;
      String[] string_array = new String[FIELD_COUNT];
      byte[] title = new byte[TITLE_FIELD_LENGTH];
      byte[] author = new byte[AUTHOR_FIELD_LENGTH];
      byte[] isbn = new byte[ISBN_FIELD_LENGTH];
      byte[] price = new byte[PRICE_FIELD_LENGTH];

      try{
         string_array[0] = Long.toString(record_number);
         _raf.read(title);
         string_array[TITLE_FIELD + 1] = new String(title).trim();
         _raf.read(author);
         string_array[AUTHOR_FIELD + 1] = new String(author).trim();
         string_array[PUB_CODE_FIELD + 1] = Integer.toString(_raf.readInt());
         _raf.read(isbn);
         string_array[ISBN_FIELD + 1] = new String(isbn);
         _raf.read(price);
         string_array[PRICE_FIELD + 1] = new String(price).trim();
         string_array[QOH_FIELD + 1] = Integer.toString(_raf.readInt());
        }catch(IOException e){
            System.out.println(e.toString());
          }
      return string_array;
    } // end recordBytesToStringArray()



    /**
    * readHeader - reads the header bytes and converts them to
    * a string
    *
    */
    public String readHeader(){
      StringBuffer sb = new StringBuffer();
      byte[] deleted  = new byte[DELETED_STRING.length()];
      byte[] title    = new byte[TITLE_STRING.length()];
      byte[] author   = new byte[AUTHOR_STRING.length()];
      byte[] pub_code = new byte[PUB_CODE_STRING.length()];
      byte[] isbn     = new byte[ISBN_STRING.length()];
      byte[] price    = new byte[PRICE_STRING.length()];
      byte[] qoh      = new byte[QOH_STRING.length()];
      try{
         _raf.seek(0);
         sb.append(Short.toString(_raf.readShort()) + " ");
         _raf.read(deleted);
         sb.append(new String(deleted) + " ");
         sb.append(Short.toString(_raf.readShort()) + " ");
         _raf.read(title);
         sb.append(new String(title) + " ");
         sb.append(Short.toString(_raf.readShort()) + " ");
         _raf.read(author);
         sb.append(new String(author) + " ");
         sb.append(Short.toString(_raf.readShort()) + " ");
         _raf.read(pub_code);
         sb.append(new String(pub_code) + " ");
         sb.append(Short.toString(_raf.readShort()) + " ");
         _raf.read(isbn);
         sb.append(new String(isbn) + " ");
         sb.append(Short.toString(_raf.readShort()) + " ");
         _raf.read(price);
         sb.append(new String(price) + " ");
         sb.append(Short.toString(_raf.readShort()) + " ");
         _raf.read(qoh);
         sb.append(new String(qoh) + " ");
         sb.append(Short.toString(_raf.readShort()) + " ");
         }catch(IOException e){
             System.out.println(e.toString());
          }
      return sb.toString();
    } // end readHeader()
           
    /**
    *  getRecordCount() returns the number of records contained in the data file
    *
    */
    public long getRecordCount(){ return _record_count; }

} // end DataFileAdapter class definition