package com.uni.bonn.nfc4mg.utility;

import java.util.Arrays;

import android.nfc.NdefRecord;

/**
 * Help class for NFC Tag read/write operation for NFCRecord.
 * 
 * @author shubham
 * 
 */
public class NfcTagUtility {

	// Map represents possible URI mapping and their hexa values set in
	// NdefRecord payload field.
	public static final String[] URI_PREFIX_MAP = new String[] { "", // 0x00
			"http://www.", // 0x01
			"https://www.", // 0x02
			"http://", // 0x03
			"https://", // 0x04
			"tel:", // 0x05
			"mailto:", // 0x06
			"ftp://anonymous:anonymous@", // 0x07
			"ftp://ftp.", // 0x08
			"ftps://", // 0x09
			"sftp://", // 0x0A
			"smb://", // 0x0B
			"nfs://", // 0x0C
			"ftp://", // 0x0D
			"dav://", // 0x0E
			"news:", // 0x0F
			"telnet://", // 0x10
			"imap:", // 0x11
			"rtsp://", // 0x12
			"urn:", // 0x13
			"pop:", // 0x14
			"sip:", // 0x15
			"sips:", // 0x16
			"tftp:", // 0x17
			"btspp://", // 0x18
			"btl2cap://", // 0x19
			"btgoep://", // 0x1A
			"tcpobex://", // 0x1B
			"irdaobex://", // 0x1C
			"file://", // 0x1D
			"urn:epc:id:", // 0x1E
			"urn:epc:tag:", // 0x1F
			"urn:epc:pat:", // 0x20
			"urn:epc:raw:", // 0x21
			"urn:epc:", // 0x22
	};

	public static String getNFCType(NdefRecord rcd) {

		if (Arrays.equals(NdefRecord.RTD_URI, rcd.getType())) {
			return "URI";
		} else if (Arrays.equals(NdefRecord.RTD_TEXT, rcd.getType())) {
			return "TEXT";
		} else {
			return "UNKNOWN";
		}
	}	
}
