package com.concerto.common.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUtilities {
	/**
	 * @author abhijit.bhattacharya
	 * @param Directory
	 * @param fileName
	 * @return name of file
	 */
	public static String searchFile(String Directory,String fileName) {
		
        File root = new File(Directory);
        try {
            boolean recursive = true;

            Collection files = FileUtils.listFiles(root, null, recursive);
            Iterator iterator = files.iterator();
            while (iterator.hasNext()) {
                File file = (File) iterator.next();
 //               System.out.println(file.getName());
                if (file.getName().equals(fileName))
                    System.out.println(file.getAbsolutePath());
          //      return file.getAbsolutePath();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return fileName;
    
		
	}
	
	public static String searchFilebyPart(String Directory,String fileName) {
		String finalFilePath=null;
        File root = new File(Directory);
        try {
            boolean recursive = true;

            Collection files = FileUtils.listFiles(root, null, recursive);
            Iterator iterator = files.iterator();
            while (iterator.hasNext()) {
                File file = (File) iterator.next();
 //               System.out.println(file.getName());
                if (file.getName().contains(fileName)) {
                	finalFilePath=file.getAbsolutePath();
                    System.out.println(file.getAbsolutePath());
                }
          //      return file.getAbsolutePath();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return finalFilePath;
    
		
	}
	
	public static void deleteAllFiles(File directory) throws Throwable {
		FileUtils.cleanDirectory(directory);
		
	}
	
	
	public static void Copyfile(File src, File dest) throws Throwable {
		FileUtils.copyFileToDirectory(src, dest);
		
	}
	
	public static void uploadFile(WebElement element,String FileName) throws Throwable {
		Selenium.sendKeys(element, FileName);
	}
	
	@Test
	public static void fileTest() {
		String root="C:/Users/abhijit.bhattacharya/Desktop/Downloads";
		String file= "Monthly Performance Report_20_08_2019_17_51_28.xls";
		searchFile(root, file);
	}

}
