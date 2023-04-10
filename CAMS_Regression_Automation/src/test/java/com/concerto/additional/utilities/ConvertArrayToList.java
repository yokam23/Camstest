package com.concerto.additional.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class ConvertArrayToList {
	
	public static String[][] ListToArray(ArrayList<LinkedHashMap<String,String>> DBData) throws Throwable {
		
		String[][] tabArray=null;
		for(int i=0;i<DBData.size();i++) {
			tabArray=new String[DBData.size()][DBData.get(i).entrySet().size()];
			
			int j=0;
			for(Entry<String, String> entry:DBData.get(i).entrySet()) {
				String value = entry.getValue();
				tabArray[i][j]=value;
				j++;
			}
			return tabArray;
		}
		return tabArray;
	}

}
