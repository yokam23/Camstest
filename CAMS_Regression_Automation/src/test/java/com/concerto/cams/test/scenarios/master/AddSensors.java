package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.SensorsPageutils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class AddSensors extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	SensorsPageutils sensor;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		sensor = new SensorsPageutils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add new sensor ", groups = { "UI" }, dataProvider = "DataReader")
	public void validateAddSensors(String TCNo, String Description, String Sensortype, String Panelmanufacturer,
			String Alarm, String RestoralType, String AlertPriority, String AlertsmsMessage, String RestoralsmsMessage,
			String AlarmEmailSubject, String RestoralEmailSubject, String AlarmEmailMessage,
			String RestoralEmailMessage, String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetSensorsPage();
		sensor.GetPageHeader();
		sensor.GetAddPageHeader();

		if (Switch.equalsIgnoreCase("AddSensor")) {
			sensor.AddNewSensor(Sensortype, Panelmanufacturer, Alarm, RestoralType, AlertPriority, AlertsmsMessage,
					RestoralsmsMessage, AlarmEmailSubject, RestoralEmailSubject, AlarmEmailMessage,
					RestoralEmailMessage);
		} else if (Switch.equalsIgnoreCase("DuplicateSensor")) {
			sensor.ValidateDuplicateEntries(Sensortype, Panelmanufacturer, Alarm, RestoralType, AlertPriority, AlertsmsMessage,
					RestoralsmsMessage, AlarmEmailSubject, RestoralEmailSubject, AlarmEmailMessage,
					RestoralEmailMessage);
		} else if (Switch.equalsIgnoreCase("ErrorMessage")) {
			sensor.GetValidationMessage(Panelmanufacturer, Alarm, RestoralType, AlertPriority, RestoralsmsMessage,
					AlarmEmailSubject, RestoralEmailSubject, AlarmEmailMessage, RestoralEmailMessage);
		} else if (Switch.equalsIgnoreCase("DeletionSensor")) {
			sensor.AddNewSensor(Sensortype, Panelmanufacturer, Alarm, RestoralType, AlertPriority, AlertsmsMessage,
					RestoralsmsMessage, AlarmEmailSubject, RestoralEmailSubject, AlarmEmailMessage,
					RestoralEmailMessage);
		}
		LoginPageUtils.Logout();
		
		if(Switch == "AddSensor" || Switch == "DeletionSensor") {
		MasterDBDetails.GetSensorDetails(Sensortype).get(0).get("SensorType");
		Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("SensorType"), Sensortype, "Correct SensorType displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("CompanyName"), Panelmanufacturer, "Correct Panelmanufacturer displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("Alarm"), Alarm, "Correct Alarm displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("AlertPriority"), AlertPriority, "Correct AlertPriority displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("Alarm_SMS_Message"), AlertsmsMessage, "Correct Alarm_SMS_Message displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("Restore_SMS_Message"), RestoralsmsMessage, "Correct Restore_SMS_Message displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("Alarm_Email_Subject"), AlarmEmailSubject, "Correct Alarm_Email_Subject displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("Restore_Email_Subject"), RestoralEmailSubject, "Correct Restore_Email_Subject displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("Alarm_Email_Message"), AlarmEmailMessage, "Correct Alarm_Email_Message displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("Restore_Email_Message"), RestoralEmailMessage, "Correct Restore_Email_Message displayed in database");
	    Asserts.assertEqual(MasterDBDetails.GetCommentDetails(Sensortype).get(0).get("RestoralType"), RestoralType, "Correct RestoralType displayed in database");
	    
		}
		Asserts.AssertAll(TCNo);
	}

	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}

}
