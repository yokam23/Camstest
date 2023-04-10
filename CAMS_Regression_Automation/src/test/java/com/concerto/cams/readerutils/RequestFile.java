package com.concerto.cams.readerutils;

import java.nio.ByteBuffer;

public class RequestFile {
	
	public static byte[] generateRequest(String PanelId,String Alert, String Zone, String CurrentTime,String CurrentDate) {
		
		 String textToHash = "092A0046\"SIA-DCS\"0001R000001L000001#"+PanelId+"[#"+PanelId+"|"+Alert+Zone+"]_"+CurrentTime+","+CurrentDate;


			byte[] data = new byte["0A".length() / 2];
			for (int i = 0; i < "0A".length(); i += 2) {
				data[i / 2] = (byte) ((Character.digit("0A".charAt(i), 16) << 4)
						+ Character.digit("0A".charAt(i+1), 16));
		 
			}
			

			byte[] data1 = new byte["0D".length() / 2];
			for (int i = 0; i < "0D".length(); i += 2) {
				data1[i / 2] = (byte) ((Character.digit("0D".charAt(i), 16) << 4)
						+ Character.digit("0D".charAt(i+1), 16));		 
			}

			
		    byte[] lfCRC = data;
		    byte[] cr = data1;
		    
		    
		    
		    
		    byte[] msg = textToHash.getBytes();
		    byte[] responseByte = new byte[lfCRC.length+cr.length+msg.length];
		    System.arraycopy(lfCRC, 0, responseByte, 0, lfCRC.length);
		    System.arraycopy(msg, 0, responseByte, lfCRC.length, msg.length);
		    System.arraycopy(cr, 0, responseByte, (lfCRC.length+msg.length), cr.length);
		    ByteBuffer byteBuffer =  ByteBuffer.allocate(responseByte.length);
		    byteBuffer = ByteBuffer.wrap(responseByte);
		    		    
		    byte[] Final =  byteBuffer.array();
		    return Final;
	}

}
