package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.OperatorCommentsPageutils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class AddOperatorCmnt extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	OperatorCommentsPageutils operatorcmt;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		operatorcmt = new OperatorCommentsPageutils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add User comment", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateAddUserCmt(String TCNo, String Description, String comment, String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetOperatorCommentPage();
		operatorcmt.GetPageHeader();
		if (Switch.equalsIgnoreCase("User comment")) {
			operatorcmt.AddUsercomment(comment);
		} else if (Switch.equalsIgnoreCase("Closure comment")) {
			operatorcmt.AddClosurecomment(comment);
		} else if (Switch.equalsIgnoreCase("Reopen comment")) {
			operatorcmt.AddReopencomment(comment);
		} else if (Switch.equalsIgnoreCase("Duplicate User comment")) {
			operatorcmt.ValidateDuplicateEnteriesForUsercmt(comment);
		} else if (Switch.equalsIgnoreCase("Duplicate Closure comment")) {
			operatorcmt.ValidateDuplicateEnteriesForClosurecmt(comment);
		} else if (Switch.equalsIgnoreCase("Duplicate Reopen comment")) {
			operatorcmt.ValidateDuplicateEnteriesForReopencmt(comment);
		} else if (Switch.equalsIgnoreCase("Refresh User comment")) {
			operatorcmt.Refreshusercomment(comment);
		} else if (Switch.equalsIgnoreCase("Refresh Closure comment")) {
			operatorcmt.RefreshClosurecomment(comment);
		} else if (Switch.equalsIgnoreCase("Refresh Reopen comment")) {
			operatorcmt.RefreshReopencomment(comment);
		} else if (Switch.equalsIgnoreCase("Error message User comment")) {
			operatorcmt.GetValidationUsercmt();
		} else if (Switch.equalsIgnoreCase("Error message Closure comment")) {
			operatorcmt.GetValidationClosurecmt();
		} else if (Switch.equalsIgnoreCase("Error message Reopen comment")) {
			operatorcmt.GetValidationReopencmt();
		} else if (Switch.equalsIgnoreCase("DeletionUserCmnt")) {
			operatorcmt.AddUsercomment(comment);
		} else if (Switch.equalsIgnoreCase("DeletionClosureCmnt")) {
			operatorcmt.AddClosurecomment(comment);
		} else if (Switch.equalsIgnoreCase("DeletionReopenCmnt")) {
			operatorcmt.AddReopencomment(comment);

		}
		LoginPageUtils.Logout();

		if (Switch == "User comment" || Switch == "Closure comment" || Switch == "Reopen comment"
				|| Switch == "DeletionUserCmnt" || Switch == "DeletionClosureCmnt" || Switch == "DeletionReopenCmnt") {
			MasterDBDetails.GetCommentDetails(comment).get(0).get("Comments");
			Asserts.assertEqual(MasterDBDetails.GetCommentDetails(comment).get(0).get("Comments"), comment,
					"Correct comment displayed in database");
			
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