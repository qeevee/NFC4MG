package com.uni.bonn.nfc4mg.nfctag;

import java.io.UnsupportedEncodingException;

import android.nfc.NdefRecord;

/**
 * Interface implements CRUD method for different NdefRecord type. This interface is common for all NdefRecord type
 * @author shubham
 *
 */
public interface TagOperation {

	//Create new record
	public NdefRecord createRecord(String val, String... args) throws UnsupportedEncodingException;
	
	//Read record
	public void parseNdefRecord(NdefRecord ndefRecord) throws UnsupportedEncodingException;
	
	//Update record information
	public void editNdefRecord(NdefRecord ndefRecord, String newVal);
	
	//Delete record : or set it to null
	public boolean deleteNdefRecord(NdefRecord ndefRecord); 
	
	
}
