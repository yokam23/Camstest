package com.concerto.common.contsants;

public class Config {
	
	//Grid Config
	public static final String GRID_HUB_IP = "localHost";//"10.68.0.16" ; 
	public static final String  GRID_HUB_PORT = "4444";
	
	
	//Desired Capabilities
	public static final String BROWSER = "firefox"; //{chrome , firefox , htmlunit , internet explorer, opera, safari }.
	public static final String PLATFORM = "Windows";
	
	
	//RemoteWebdriver Config

	public static final int PAGE_LOADWAI_TTIME = 120;
	public static final int XSMALL_PAUSE = 3;
	public static final int SMALL_PAUSE = 10;
	public static final int MEDIUM_PAUSE = 30;
	public static final int LARGE_PAUSE = 60;
	public static final int XLARGE_PAUSE = 180;
	public static final int POLLING_TIME = 100;


	//File Paths
	public static final String DataProvider_File_Path=System.getProperty("user.dir")+"\\src\\test\\testdata\\testdata\\dataprovider.xls";
	public static final String TEST_DATA_FILE_PATH = System.getProperty("user.dir")+"\\src\\test\\testdata\\testdata\\ExcelData.xls";
	public static final String SELENIUM_LOG_PATH = System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\Selenium.logs";
	public static final String ALLURE_ENV_PATH = System.getProperty("user.dir")+"\\build\\allure-results\\";
	public static final String Test_Cases = System.getProperty("user.dir")+"/src/test/resources/com/application/testcases/RhythmTestCases.xls";
	public static final String Test_Cases_Sheet= "Regression Sheet";
	
	//Reader And Simulator File Paths
	public static final String SimulatorTextFile="src/test/resources/com/simulator/files/Message.txt";
	public static final String SimulatorBatFile="src/test/resources/com/simulator/files/TicketSimulatorDown/GenerateTicketSimulatorDelay.bat";
	public static final String ReaderBatFile="src/test/resources/com/reader/files/HDFC TEST 03012019";
	
	
	//Application Config
	public static final String APPURL_WooCom = "http://10.10.10.101:3000/woocom/index.php";	
	public static final String APPURL_OpenCart = "http://10.10.10.101:3000/opencart/upload/index.php";	
	public static final String APPURL_Joomla ="http://10.10.10.101:3000/Joomla/index.php";
	public static final String APPURL_PrestaShop ="http://10.10.10.101:3000/prestashop/index.php";
	public static final String APPURL_Urway ="http://10.10.10.101:8089/URWAYPG/checkUserExistance.htm";
	public static final String APPURL_VirtueMart="http://10.10.10.101:3000/virtueMart/index.php";
	public static final String APPURL_Magento="http://10.10.10.101:3000/magento";
	public static final String URL = "http://10.10.10.101:8089/URWAYPGService";
	public static final String API = "/transaction";
	public static final String Path="/jsonProcess/JSONrequest";	
	public static final String PaymentPath="http://10.10.10.101:8089/URWAYPGService/direct.jsp?paymentid=";
	public static final String Token = "&appid=829d743eb9296d9329a3d6c81ae43405";
	public static final String PaymentPath3D="http://10.10.10.101:8089/URWAYPGService/3DRedirect.jsp?paymentid=";
	public static final String APPURL_Urway_OTP ="http://10.10.10.101:8089/URWAYPG/loginUserOtpPage.htm";
	
	public static final String APPURL_CAMS ="http://10.10.10.212/CAMSPlus2.0";
	//Mail Config
	public static final String APPURL_INS ="http://10.10.10.212/ins2.0";
	
	
	public static final String host = "pop01.concertosoft.com";
	public static final String mailStoreType = "pop3";
	public static final String mailusername = "sonal.borge@concertosoft.com";
	public static final String mailpassword = "SonalDeven@2122";
	public static final String port="110";
	
	public static final String DBHost ="10.10.10.195:1433";
	public static final String DBName ="CAMSPlus2";
	// 
	public static final String loginUsername="superadmin1";
	public static final String loginPassword="Concerto@123";
	
	
	public static final String adminUsername ="admin1";
	public static final String adminPassword ="Concerto@123";
	
	public static final String supervisorun ="Supervisor5";
	public static final String supervisorpwd ="Concerto@123";
	
	public static final String Serviceuser ="Serviceuser1";
	public static final String Servicepwd ="Concerto@123";
	
	public static final String Siteuser ="Siteuser1";
	public static final String Sitepwd ="Concerto@123";
	
	public static final String Clientadmin = "Clientadmin1";
	public static final String Clientpassword = "Concerto@1";

	public static final String operatorlogin = "Operator1";
	public static final String operatorpassword = "Concerto@123";

	
	
	
	public static final String Ticketoperatorlogin = "Operator2";
	public static final String Ticketoperatorpassword = "Concerto@123";
	

}
