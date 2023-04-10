package com.concerto.common.utilities;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class GenerateHash {

	public static String generateHash(String trackid, String terminalId, String password, String secretkey,
			String amount, String Currency) throws Throwable {
		// String textToHash
		// ="${trackid}|${terminalId}|${password}|${secretkey}|${amount}|INR";
		String textToHash = trackid + "|" + terminalId + "|" + password + "|" + secretkey + "|" + amount + "|"
				+ Currency;
		// String textToHash
		// ="M11_Track1|Simulator|password|2dbaf7bd17f51f27bbdebbfc0be229e15f37e67ffaf020162483ffde6527eeb3|10.00|INR";
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
		byte[] hashedByetArray = digest.digest(byteOfTextToHash);

		String encoded = Hex.encodeHexString(hashedByetArray);
		return encoded;
	}

}
