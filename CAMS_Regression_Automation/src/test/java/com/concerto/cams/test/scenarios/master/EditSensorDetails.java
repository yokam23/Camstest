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

public class EditSensorDetails extends BaseClass {

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

	@Test(description = "TC0001::Validate to update existing sensor data", groups = {
			"UI" }, dataProvider = "DataReader")
	public void validateEditSensor(String TCNo, String Description,String SensorType, String Alarm, String RestoralType)
			throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetSensorsPage();
		sensor.Editsensors(SensorType,Alarm, RestoralType );
		LoginPageUtils.Logout();
		
		MasterDBDetails.GetSensorDetails(SensorType).get(0).get("SensorType");
		Asserts.assertEqual(MasterDBDetails.GetSensorDetails(SensorType).get(0).get("SensorType"), SensorType, "Correct SensorType displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetSensorDetails(SensorType).get(0).get("Alarm"), Alarm, "Correct Alarm displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetSensorDetails(SensorType).get(0).get("RestoralType"), RestoralType, "Correct RestoralType displayed in database");
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
