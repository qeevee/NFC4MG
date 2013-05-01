package com.uni.bonn.nfc4mg.nfctag;

import java.io.IOException;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.uni.bonn.nfc4mg.TextRecord;
import com.uni.bonn.nfc4mg.exception.NfcTagException;
import com.uni.bonn.nfc4mg.exception.TagModelException;
import com.uni.bonn.nfc4mg.tagmodels.GPSTagModel;
import com.uni.bonn.nfc4mg.utility.NfcReadWrite;

/**
 * Class to deal with GPS Tag type. User has to create object of this class in
 * order to deal with any operation related to info tags.
 * 
 * @author shubham
 * 
 */
public class GpsTag {

	public boolean write2Tag(GPSTagModel model, Tag tag)
			throws TagModelException, IOException, FormatException,
			NfcTagException {

		// check id uniqueness
		if (null == model)
			throw new TagModelException("InfoTagModel is not initialized");

		String id = model.getId();

		// throw exception in case user has not defined tag id.
		if (null == id || "".equals(model.getId()))
			throw new TagModelException("Tag Id is not defined.");

		// id prefix check
		if (!id.startsWith("gps_"))
			model.setId("gps_" + model.getId());


		NdefRecord records[] = new NdefRecord[3];
		records[0] = TextRecord.createRecord(model.getId());
		records[1] = TextRecord.createRecord(model.getLatitude());
		records[2] = TextRecord.createRecord(model.getLongitude());

		NdefMessage info_msg = new NdefMessage(records);
		NfcReadWrite.writeToNfc(info_msg, tag);
		return true;
	}

	public GPSTagModel readTagData(Tag tag) throws IOException,
			FormatException {

		GPSTagModel model = new GPSTagModel();
		NdefMessage msg = NfcReadWrite.readNfcData(tag);
		NdefRecord records[] = msg.getRecords();
		
		if(null != records && 3 == records.length){
			model.setId(TextRecord.parseNdefRecord(records[0]).getData());
			model.setId(TextRecord.parseNdefRecord(records[1]).getData());
			model.setId(TextRecord.parseNdefRecord(records[2]).getData());
			return model;
		}
		return null;
	}
}
