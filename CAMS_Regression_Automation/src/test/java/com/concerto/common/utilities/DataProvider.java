package com.concerto.common.utilities;

public class DataProvider {
	
	
	
	public Object[][] DataProviderMethod() throws Throwable {
		
		Object[][] tabArray=ExcelDataProvider.getTableArray("Resources/data.xls", "Sheet1");
		return tabArray;
		
	}

}
