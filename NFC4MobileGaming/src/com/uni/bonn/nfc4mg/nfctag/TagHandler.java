package com.uni.bonn.nfc4mg.nfctag;

import java.io.IOException;
import java.util.Arrays;

import android.content.Context;
import android.content.Intent;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.uni.bonn.nfc4mg.utility.NfcReadWrite;
import com.uni.bonn.nfc4mg.utility.NfcTagUtility;

/**
 * Class responsible to handle scanned NFC Tag.
 * 
 * @author shubham
 * 
 */
public class TagHandler {

	private static final String TAG = "TagHandler";

	public static void processIntent(Context ctx, Intent nfcIntent) {

		Log.v(TAG, "Intent Action :: " + nfcIntent.getAction());

		if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(nfcIntent.getAction())) {

			Tag tag = nfcIntent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

			/**
			 * As per Android API we can write only one NDEFMessage in NFC tag
			 */
			if (null != tag) {

			} else {
				Toast.makeText(ctx, "Tag is Empty!", Toast.LENGTH_SHORT).show();
			}
		} else if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(nfcIntent
				.getAction())) {

		} else if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(nfcIntent
				.getAction())) {

		}
	}

	// Check the NDEFRecord type and pass it to corresponding handler to get
	// record information.
	public static void checkRecordType(NdefRecord rcd) {

		Log.v(TAG, "TNF = " + rcd.getTnf());
		Log.v(TAG, "TYPE = " + NfcTagUtility.getNFCType(rcd));
		Log.v(TAG, "PAYLOAD = " + new String(rcd.getPayload()));

		// RTD_SMART_POSTER contains NDEFMessage inside NdefRecord : So
		// we have to handle it in different way
		if (Arrays.equals(NdefRecord.RTD_SMART_POSTER, rcd.getType())) {

		} else if (Arrays.equals(NdefRecord.RTD_TEXT, rcd.getType())) {

		} else if (Arrays.equals(NdefRecord.RTD_URI, rcd.getType())) {

		}
	}

	/**
	 * Api to check data in the tag is supported by framework or not. This
	 * framework has its own tag model to structure information. First record in the tag is always represents the id of the tag.
	 * Every Id has a prefix value, which can be used to determine the tag type.
	 * 
	 * @param tag
	 */
	public static void checkTagSupport(Tag tag) {

		try {

			NdefMessage msg = NfcReadWrite.readNfcData(tag);

			NdefRecord records[] = msg.getRecords();

			if (records.length > 0) {
				
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
