package com.concerto.common.utilities;

import java.io.File;
import org.apache.commons.vfs2.FileSystemException;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSelectInfo;
import org.apache.commons.vfs2.FileSelector;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.UserAuthenticator;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.testng.annotations.Test;

public class FileTransfer {
	
	   public static void FetchFile(String domain, String userName, String password, String remoteFileLocation,String FileName,
	            String fileDestinationLocation)  {

	        File f = new File(fileDestinationLocation);
	        FileObject destn;
	        try {
//	            FileSystemManager fm = VFS.getManager();
	            

	            destn = VFS.getManager().resolveFile(f.getAbsolutePath());

	            if(!f.exists())
	            {
	                System.out.println("File : "+fileDestinationLocation +" does not exist. transferring file from : "+ remoteFileLocation+" to: "+fileDestinationLocation);
	            }
	            else
	                System.out.println("File : "+fileDestinationLocation +" exists. Transferring(override) file from : "+ remoteFileLocation+" to: "+fileDestinationLocation);

	            UserAuthenticator auth = new StaticUserAuthenticator(domain, userName, password);
	            FileSystemOptions opts = new FileSystemOptions();
	            DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
	            FileSystemManager fm = VFS.getManager();
//	            FileObject fo = fm.toFileObject(file)
	            
	            FileSelector ff = new FileSelector()
	            {
	                public boolean includeFile(FileSelectInfo fileInfo) throws Exception
	                {
	                    FileObject fo = fileInfo.getFile();
	                    return fo.getName().getBaseName().startsWith(FileName);
	                }

	                public boolean traverseDescendents(FileSelectInfo fileInfo) throws Exception
	                {
	                    return true;
	                }   		
	            };
	            
	           FileObject[] fo = VFS.getManager().resolveFile(remoteFileLocation, opts).findFiles(ff);
//	            System.out.println(fo.exists());
/*	            destn.copyFrom(fo[fo.length-1], Selectors.SELECT_SELF);
	            destn.close();
	            if(f.exists())*/
	            {
	                System.out.println("File transfer from : "+ remoteFileLocation+" to: "+fileDestinationLocation+" is successful");
	            }
	        }catch (FileSystemException e) {
	            e.printStackTrace();
	        }

	    }
	
    public static void transferFileFromRemote(String domain, String userName, String password, String remoteFileLocation,String FileName,
            String fileDestinationLocation)  {

        File f = new File(fileDestinationLocation);
        FileObject destn;
        try {
//            FileSystemManager fm = VFS.getManager();
            

            destn = VFS.getManager().resolveFile(f.getAbsolutePath());

            if(!f.exists())
            {
                System.out.println("File : "+fileDestinationLocation +" does not exist. transferring file from : "+ remoteFileLocation+" to: "+fileDestinationLocation);
            }
            else
                System.out.println("File : "+fileDestinationLocation +" exists. Transferring(override) file from : "+ remoteFileLocation+" to: "+fileDestinationLocation);

            UserAuthenticator auth = new StaticUserAuthenticator(domain, userName, password);
            FileSystemOptions opts = new FileSystemOptions();
            DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
            FileSystemManager fm = VFS.getManager();
//            FileObject fo = fm.toFileObject(file)
            
            FileSelector ff = new FileSelector()
            {
                public boolean includeFile(FileSelectInfo fileInfo) throws Exception
                {
                    FileObject fo = fileInfo.getFile();
                    return fo.getName().getBaseName().startsWith(FileName);
                }

                public boolean traverseDescendents(FileSelectInfo fileInfo) throws Exception
                {
                    return true;
                }   		
            };
            
           FileObject[] fo = VFS.getManager().resolveFile(remoteFileLocation, opts).findFiles(ff);
//            System.out.println(fo.exists());
            destn.copyFrom(fo[fo.length-1], Selectors.SELECT_SELF);
            destn.close();
            if(f.exists())
            {
                System.out.println("File transfer from : "+ remoteFileLocation+" to: "+fileDestinationLocation+" is successful");
            }
        }catch (FileSystemException e) {
            e.printStackTrace();
        }

    }
    
    @Test
    public static void TestFileTransfer() throws Throwable {
    	String domain= "CONCERTO";
    	String Username ="Superadmin";
    	String Password = "Concerto@123";
    	String RemoteFileLocation = "\\\\10.10.10.101\\e\\VegaaH\\PGConfig\\EOD\\Download_File\\CreditReports\\";
    	String File= "DailyCredit_Report_MPGS_SAR_"+DateTimeFunctions.GenerateOffsetDateDDMMYYYY(0);
    	String fileDestinationLocation ="C:\\Users\\abhijit.bhattacharya.CONCERTO\\Desktop\\DailyCreditReport\\DailyCredit_Report.xlsx";
    	
    	transferFileFromRemote(domain,Username,Password,RemoteFileLocation,File,fileDestinationLocation);
    }

}
