package com.concerto.additional.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class RunBat {
	/**
	 * @author abhijit.bhattacharya
	 * @param batName=name.bat
	 * @param Path=AbsolutePath
	 * @throws Throwable
	 */
	public static void runBatFile(String batName,String Path) throws Throwable {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", batName);
		File dir = new File(Path);
		pb.directory(dir);
		Process p = pb.start();
		Thread.sleep(10000);
		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(
                new InputStreamReader(p.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }
		int exitVal = p.waitFor();
        if (exitVal == 0) {
            System.out.println(output);
            System.exit(0);
        } else {
            //abnormal...
        }
/*		if(p.isAlive())
		p.destroy();*/
	}
	
	public static void runBatFileNotify(String batName,String Path) throws Throwable {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", batName);
		File dir = new File(Path);
		pb.directory(dir);
		Process p = pb.start();
/*		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(
                new InputStreamReader(p.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }*/
//        p.notifyAll();
	}
	
	public static void runBatFileWait(String batName,String Path) throws IOException, Throwable {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", batName);
		File dir = new File(Path);
		System.out.println(dir.toString());
		pb.directory(dir);
		Process p = pb.start();
/*		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(
                new InputStreamReader(p.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }*/
//        p.waitFor();
	}
	
	public static ArrayList<Integer> getPID(String bat,String Directory) throws Throwable {
		ArrayList<Integer> PID = new ArrayList<Integer>();
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "processes.bat");
		File dir = new File("src/test/resources/simulator/files");
		pb.directory(dir);
		Process p = pb.start();

	    //p.waitFor();


	    BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    String line;
	    int pid=0;

	    while((line = rd.readLine()) != null)
	    {
	    	if(line.contains("HDFCBASE24")||line.contains("GenerateTicket")) {
	            String[] split = line.split(" ");
	            pid=Integer.parseInt(split[split.length - 1]);
	            PID.add(pid);
	    	}	        
	    }
	    return PID;
	}
	

}
