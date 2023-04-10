package com.concerto.common.utilities;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import org.testng.annotations.Test;


public class FileHandler {
	
	/**
	 * To create file
	 * @param fileName
	 */
	public static void createFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
				Logger.logConsoleMessage("Created new file" );
			} catch (Exception e) {
				Logger.logConsoleMessage("Failed to create file: " + filePath);
			}
		}
	}
	
	public static void truncateFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			file.setWritable(true);
			try {
				Files.newInputStream(file.toPath() , StandardOpenOption.TRUNCATE_EXISTING);
				Files.newBufferedWriter(file.toPath() , StandardOpenOption.TRUNCATE_EXISTING);				
			} catch (Exception e) {
				Logger.logConsoleMessage("Failed to create file: " + filePath);
			}
		}
	}
	
	public static void truncateFile() {
		String filePath="src/test/resources/com/simulator/files/Message.txt";
		File file = new File(filePath);
		if (file.exists()) {
			file.setWritable(true);
			try {
				Files.newInputStream(file.toPath() , StandardOpenOption.TRUNCATE_EXISTING);
				Files.newBufferedWriter(file.toPath() , StandardOpenOption.TRUNCATE_EXISTING);				
			} catch (Exception e) {
				Logger.logConsoleMessage("Failed to create file: " + filePath);
			}
		}
	}
	
	/**
	 * To update the file
	 * @param fileToBeUpdated
	 * @param valueToBeUpdated
	 */
	public static void updateFile(String filePath, String valueToBeUpdated) {
		FileWriter fw = null;

		try {
			fw = new FileWriter(filePath, true);
		} catch (IOException e) {
			Logger.logConsoleMessage("Failed to open file: " + filePath);
			e.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(valueToBeUpdated);
		} catch (IOException e) {
			Logger.logConsoleMessage("Failed to update file: " + filePath);
			e.printStackTrace();
		}
		try {
			bw.close();
			fw.close();
		} catch (IOException e) {
			Logger.logConsoleMessage("Failed to add close file: " + filePath);
			e.printStackTrace();
		}
	}
	
	/**
	 * To delete file
	 * @param dirPath
	 */
	public static void deleteFile(String dirPath)
	{
		File file = new File(dirPath);
		if(file.exists()) {
		file.delete();
		}
	}
	
	/**
	 * To delete files
	 * @param dirPath
	 */
	public static void deleteFiles(String dirPath)
	{
		File file = new File(dirPath);
		File[] allFiles = file.listFiles();
		for (File file2 : allFiles) 
		{
			file2.delete();
		}
	}
	
	/**
	 * To get file path
	 * @param dirPath
	 * @return
	 */
	public static String getFullFilePath(String dirPath)
	{
		File file = new File(dirPath);
		return file.getAbsolutePath();
	//	return file.listFiles()[0].getAbsolutePath();
	}

	/**
	 * To delete directory file 
	 * @param path
	 * @return
	 */
	public static boolean deleteDirectory(File dirPath) {
		if(dirPath.exists() ) {
			File[] files = dirPath.listFiles();
				for(int i=0; i<files.length; i++) 
				{
					if(files[i].isDirectory()) {
						deleteDirectory(files[i]);
				     }
				     else {
				    	 files[i].delete();
				     }
				}
		}
       return(dirPath.delete() );
    }
    
    /**
     * To open file 
     * @param filePath
     */
	public static void LaunchFile(String filePath)
	{
	    try
	    {   
	    	Desktop.getDesktop().open(new File(filePath));
	    }catch(IOException  e){  
	    	Logger.logConsoleMessage("Failed to launch file: " + filePath);
	    	e.printStackTrace();  
	    }
	}
	
	
	public static void filePermission(String File) {
		File file = new File(File);
		 boolean exists = file.exists(); 
	        if(exists == true) {
	        	boolean writable = file.canWrite();
	        	if(writable == false) {
	        		file.setWritable(true); 
//	        		FileHandler.makeWritable(file);
	        	}
	        }
	}
		

}
