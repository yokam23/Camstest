package com.concerto.common.utilities;

import com.concerto.common.utilities.FileHandler;

public class RemoteSysUtils {
	
	
	public static void setTime() throws Throwable {
    	String Path =FileHandler.getFullFilePath("src/test/resources/com/reports/files");
//    	Path=Path.replace("/GenerateTicketSimulatorDelay.bat", "");
//    	runRemoteBatFiles.generate_ftp_run_Time();
    	RunBat.runBatFileNotify("DateUpdate.bat", Path);
	}
	
	public static void startService() throws Throwable {
    	String Path =FileHandler.getFullFilePath("src/test/resources/com/reports/files");
//    	Path=Path.replace("/GenerateTicketSimulatorDelay.bat", "");
    	RunBat.runBatFileNotify("StartService.bat", Path);
    	Thread.sleep(180000);
	}
	
	public static void MoveFile() throws Throwable {
    	String Path =FileHandler.getFullFilePath("src/test/resources/com/reports/files");
//    	Path=Path.replace("/GenerateTicketSimulatorDelay.bat", "");
    	RunBat.runBatFileNotify("MoveFile.bat", Path);
	}
	
	public static void stopService() throws Throwable {
    	String Path =FileHandler.getFullFilePath("src/test/resources/com/reports/files");
//    	Path=Path.replace("/GenerateTicketSimulatorDelay.bat", "");
    	RunBat.runBatFileNotify("StopService.bat", Path);
    	Thread.sleep(5000);
	}
	

	public static void setRemoteTime() throws Throwable {
    	String Path =FileHandler.getFullFilePath("src/test/resources/com/reports/files");
//    	Path=Path.replace("/GenerateTicketSimulatorDelay.bat", "");
    	RunBat.runBatFileNotify("GetTime.bat", Path);
	}
	
	public static void syncRemoteDate() throws Throwable {
    	String Path =FileHandler.getFullFilePath("src/test/resources/com/reports/files");
//    	Path=Path.replace("/GenerateTicketSimulatorDelay.bat", "");
    	RunBat.runBatFileNotify("SyncDate.bat", Path);
	}

}
