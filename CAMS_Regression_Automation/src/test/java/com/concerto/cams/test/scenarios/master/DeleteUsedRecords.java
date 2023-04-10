package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.CRAAgencyPageUtils;
import com.concerto.cams.test.pageutils.CityPageUtils;
import com.concerto.cams.test.pageutils.HKPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.InstallationPartnerPageUtils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.MSPAgencyPageUtils;
import com.concerto.cams.test.pageutils.ManufacturerPageUtils;
import com.concerto.cams.test.pageutils.NetworkProviderPageUtils;
import com.concerto.cams.test.pageutils.QRTAgencyPageUtils;
import com.concerto.cams.test.pageutils.SensorsPageutils;
import com.concerto.cams.test.pageutils.SubscriptionPageUtils;
import com.concerto.cams.test.pageutils.TerritoryManagerPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.LogOutUsers;

public class DeleteUsedRecords extends BaseClass {

	String PackageName;
	String ClassName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	CityPageUtils CityPageUtils;
	SensorsPageutils sensors;
	ManufacturerPageUtils manufacturer;
	CRAAgencyPageUtils CRA;
	HKPageUtils HK;
	MSPAgencyPageUtils MSP;
	QRTAgencyPageUtils QRT;
	NetworkProviderPageUtils NP;
	InstallationPartnerPageUtils IP;
	TerritoryManagerPageUtils TMP;
	SubscriptionPageUtils subscription;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		CityPageUtils = new CityPageUtils();
		sensors = new SensorsPageutils();
		manufacturer = new ManufacturerPageUtils();
		CRA = new CRAAgencyPageUtils();
		HK = new HKPageUtils();
		MSP = new MSPAgencyPageUtils();
		QRT = new QRTAgencyPageUtils();
		NP = new NetworkProviderPageUtils();
		IP = new InstallationPartnerPageUtils();
		TMP = new TerritoryManagerPageUtils();
		subscription = new SubscriptionPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001: Validate the delete used records", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateUsedRecords(String TCNo, String Description, String Searchtxt, String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		if (Switch.equalsIgnoreCase("City")) {
			Homepageutils.GetCityPage();
			CityPageUtils.DeleteUsedRecord(Searchtxt);
		} else if (Switch.equalsIgnoreCase("Sensor")) {
			Homepageutils.GetSensorsPage();
			sensors.DeleteUsedRecord(Searchtxt);
		} else if (Switch.equalsIgnoreCase("Manufacturer")) {
			Homepageutils.GetManufacturerPage();
			manufacturer.DeleteUsedManufacturer(Searchtxt);
		} else if (Switch.equalsIgnoreCase("CRA")) {
			Homepageutils.GetCRAAgencyPage();
			CRA.DeleteUsedRecord(Searchtxt);
		} else if (Switch.equalsIgnoreCase("HK")) {
			Homepageutils.GetHKAgencyPage();
			HK.DeleteUsedRecord(Searchtxt);
		} else if (Switch.equalsIgnoreCase("MSP")) {
			Homepageutils.GetMSPAgencyPage();
			MSP.DeleteUsedRecord(Searchtxt);
		} else if (Switch.equalsIgnoreCase("NetworkProvider")) {
			Homepageutils.GetNetworkProviderPage();
			NP.DeleteUsedRecord(Searchtxt);
		} else if (Switch.equalsIgnoreCase("InstallationPartner")) {
			Homepageutils.GetInstallationvendorPage();
			IP.DeleteUsedRecord(Searchtxt);
		}/* else if (Switch.equalsIgnoreCase("Territory")) {
			Homepageutils.GetTerritoryManagerPage();
			TMP.DeleteUsedRecord(Searchtxt);
		} else if (Switch.equalsIgnoreCase("Subscription")) {
			Homepageutils.GetSubscriptionPage();
			subscription.DeleteUsedRecord(Searchtxt);
		}*/
		LoginPageUtils.Logout();
		LogOutUsers.LogoutOperator();
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
