package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.Homepage;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class Homepageutils {

	protected Homepage homepage;

	public Homepageutils() {
		homepage = new Homepage();
	}

	@Step("Navigate to Ticket Transaction")
	public void GetTicketTransactionPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.AlarmMonitoring);
		WebInteract.waitForVisibility(homepage.Ticket_transaction);
		Selenium.click(homepage.Ticket_transaction);
		Logger.logMessage("Ticket Transaction page is displayed");
	}
	
	@Step("Navigate to Ticket Transaction")
	public void GetReportsPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.AlarmMonitoring);
		WebInteract.waitForVisibility(homepage.Reports);
		Selenium.click(homepage.Reports);		
		Logger.logMessage("Reports page is displayed");
	}
	
	@Step("Navigate to City page")
	public void GetCityPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.City);
		Selenium.click(homepage.City);
		Logger.logMessage("City page is displayed");
	}

	@Step("Navigate to National Holiday page")
	public void GetNationalHolidayPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.National_Holiday);
		Selenium.click(homepage.National_Holiday);
		Logger.logMessage("National holiday page is displayed");
	}

	@Step("Navigate to operator comment page")
	public void GetOperatorCommentPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Operator_comments);
		Selenium.click(homepage.Operator_comments);
		Logger.logMessage("Operator comment page is displayed");
	}

	@Step("Navigate to Circle page")
	public void GetCirclePage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Circles);
		Selenium.click(homepage.Circles);
		Logger.logMessage("Circle page is displayed");
	}

	@Step("Navigate to sensors page")
	public void GetSensorsPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Sensors);
		Selenium.click(homepage.Sensors);
		Logger.logMessage("Sensors page is displayed");
	}

	@Step("Navigate to Manufacturer page")
	public void GetManufacturerPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Manufacturer);
		Selenium.click(homepage.Manufacturer);
		Logger.logMessage("Manufacturer page is displayed");
	}

	@Step("Navigate to Make model page")
	public void GetMakeModelPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Make_model);
		Selenium.click(homepage.Make_model);
		Logger.logMessage("Make model page is displayed");
	}

	@Step("Navigate to Dispatch vendor page")
	public void GetDispatchVendorPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Dispatch_Vendor);
		Selenium.click(homepage.Dispatch_Vendor);
		Logger.logMessage("Dispatch vendor page is displayed");
	}

	@Step("Navigate to Panel service vendor page")
	public void GetPanelServiceVendorPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Panel_service_vendor);
		Selenium.click(homepage.Panel_service_vendor);
		Logger.logMessage("Panel service page is displayed");
	}

	@Step("Navigate to Shift page")
	public void GetShiftPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Sensors);
		Selenium.click(homepage.Shift);
		Logger.logMessage("Shift page is displayed");
	}

	@Step("Navigate to CRA agency page")
	public void GetCRAAgencyPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.CRA_Agency);
		Selenium.click(homepage.CRA_Agency);
		Logger.logMessage("CRA agency page is displayed");
	}

	@Step("Navigate to HK Agency page")
	public void GetHKAgencyPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.HK_Agency);
		Selenium.click(homepage.HK_Agency);
		Logger.logMessage("HK agency page is displayed");
	}
	
	@Step("Navigate to HK pool Page")
    public void GetHKpoolpage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.HouseKeeping);
        WebInteract.waitForVisibility(homepage.HKPool);
        Selenium.click(homepage.HKPool);
        Logger.logMessage("HK pool page is displayed");
	}
	
	@Step("Navigate to HK Site allocation Page")
    public void GetHKSiteAllocationpage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.HouseKeeping);
        WebInteract.waitForVisibility(homepage.HKSiteAllocation);
        Selenium.click(homepage.HKSiteAllocation);
        Logger.logMessage("HK site allocation page is displayed");
	}
	
	@Step("Navigate to Brand Hygiene camera location page")
	public void GetCameraLocationPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.BrandHygiene);
        WebInteract.waitForVisibility(homepage.CameraLocationPage);
        Selenium.click(homepage.CameraLocationPage);
        Logger.logMessage("Brand hygiene camera location page is displayed");
	}
	
	@Step("Navigate to Brand Hygiene surveillance indicator page")
	public void GetBrandHygieneIndicatorPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.BrandHygiene);
        WebInteract.waitForVisibility(homepage.SurveillanceIndicatorsPage);
        Selenium.click(homepage.SurveillanceIndicatorsPage);
        Logger.logMessage("Brand hygiene surveillance indicator page is displayed");
	}
	
	@Step("Navigate to brand hygiene Site configuration page")
	public void GetBrandHygieneSiteConfigurationPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.BrandHygiene);
        WebInteract.waitForVisibility(homepage.SiteConfigurationPage);
        Selenium.click(homepage.SiteConfigurationPage);
        Logger.logMessage("Brand hygiene site configuration page is displayed");
	}
	
	@Step("Navigate to brand hygiene Site configuration page")
	public void GetBrandHygieneMonitoringPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.BrandHygiene);
        WebInteract.waitForVisibility(homepage.MonitoringPage);
        Selenium.click(homepage.MonitoringPage);
        Logger.logMessage("Brand hygiene Monitoring page is displayed");
	}
	
	@Step("Navigate to brand hygiene Reports page")
	public void GetBrandHygieneReportsPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.BrandHygiene);
        WebInteract.waitForVisibility(homepage.OfficeMonitoringReportPage);
        Selenium.click(homepage.OfficeMonitoringReportPage);
        Logger.logMessage("Brand hygiene report page is displayed");
	}
	
	@Step("Navigate to brand hygiene Reports page")
	public void GetBrandHygieneDashboardPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.BrandHygiene);
        WebInteract.waitForVisibility(homepage.OfficeMonitoringDashboardPage);
        Selenium.click(homepage.OfficeMonitoringDashboardPage);
        Logger.logMessage("Brand hygiene Dashboard page is displayed");
	}
	
	@Step("Navigate to HK Scheduler Page")
    public void GetHKSchedulerpage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.HouseKeeping);
        WebInteract.waitForVisibility(homepage.HKScheduler);
        Selenium.click(homepage.HKScheduler);
        Logger.logMessage("HK scheduler page is displayed");
	}
	
	@Step("Navigate to HK Monitoring Page")
    public void GetHKMonitoringpage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.HouseKeeping);
        WebInteract.waitForVisibility(homepage.HKMonitoring);
        Selenium.click(homepage.HKMonitoring);
        Logger.logMessage("HK Monitoring page is displayed");
	}
	
	@Step("Navigate to HK Reports Page")
    public void GetHKReportspage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
        WebInteract.mouseOver(homepage.HouseKeeping);
        WebInteract.waitForVisibility(homepage.HKReport);
        Selenium.click(homepage.HKReport);
        Logger.logMessage("HK Reports page is displayed");
	}
	
	
	@Step("Navigate to MSP Agency page")
	public void GetMSPAgencyPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.MSP_Agency);
		Selenium.click(homepage.MSP_Agency);
		Logger.logMessage("MSP agency page is displayed");
	}

	@Step("Navigate to QRT Agency page")
	public void GetQRTAgencyPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.QRT_Agency);
		Selenium.click(homepage.QRT_Agency);
		Logger.logMessage("QRT page is displayed");
	}

	@Step("Navigate to Network provider page")
	public void GetNetworkProviderPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Network_Provider);
		Selenium.click(homepage.Network_Provider);
		Logger.logMessage("Network provider page is displayed");
	}

	@Step("Navigate to Installation vendor page")
	public void GetInstallationvendorPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Installation_Vendor);
		Selenium.click(homepage.Installation_Vendor);
		Logger.logMessage("Installation vendor page is displayed");
	}

	@Step("Navigate to Territory manager page")
	public void GetTerritoryManagerPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Territory_Manager);
		Selenium.click(homepage.Territory_Manager);
		Logger.logMessage("Territory manager page is displayed");
	}

	@Step("Navigate to Escalation page")
	public void GetEscalationPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Escalation);
		Selenium.click(homepage.Escalation);
		Logger.logMessage("Escalation page is displayed");
	}
	
	@Step("Navigate to Admin page")
	public void GetAdministratorPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Administrator);
		WebInteract.waitForVisibility(homepage.Users);
		Selenium.click(homepage.Users);
		Logger.logMessage("Admin page is displayed");
	}

	@Step("Navigate to service partner page")
	public void GetServicePartnerPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Service_partner);
		Selenium.click(homepage.Service_partner);
		Logger.logMessage("Service partner page is displayed");
	}

	@Step("Navigate to Subscription page")
	public void GetSubscriptionPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Master);
		WebInteract.waitForVisibility(homepage.Subscription);
		Selenium.click(homepage.Subscription);
		Logger.logMessage("Subscription page is displayed");
	}

	public void GetMasterTemplatePage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Master_template);
		Selenium.click(homepage.Master_template);
		Logger.logMessage("Master template page is displayed");
	}

	@Step("Navigate to Client page")
	public void GetClientPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Client);
		Selenium.click(homepage.Client);
		Logger.logMessage("Client page is displayed");
	}

	@Step("Navigate to Project page")
	public void GetProjectPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Project);
		Selenium.click(homepage.Project);
		Logger.logMessage("Project page is displayed");
	}

	@Step("Navigate to Project team page")
	public void GetProjectTeamPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Project_team);
		Selenium.click(homepage.Project_team);
		Logger.logMessage("Project team page is displayed");
	}

	@Step("Navigate to Panel category page")
	public void GetPanelCategoryPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Panel_category);
		Selenium.click(homepage.Panel_category);
		Logger.logMessage("Panel category page is displayed");
	}

	@Step("Navigate to Panel page")
	public void GetPanelPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Panels);
		Selenium.click(homepage.Panels);
		Logger.logMessage("Panels page is displayed");
	}

	@Step("Navigate to Dealer page")
	public void GetDealerPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Dealers);
		Selenium.click(homepage.Dealers);
		Logger.logMessage("Dealers page is displayed");
	}

	@Step("Navigate to System maintenance page")
	public void GetSystemMaintenancePage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.System_maintenance);
		Selenium.click(homepage.System_maintenance);
		Logger.logMessage("System maintenance page is displayed");
	}

	@Step("Navigate to Block panel page")
	public void GetBlockPanelPage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Block_Panels);
		Selenium.click(homepage.Block_Panels);
		Logger.logMessage("Block panels page is displayed");
	}

	@Step("Navigate to Panel template page")
	public void GetPanelTemplatePage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Panel_Template);
		Selenium.click(homepage.Panel_Template);
		Logger.logMessage("Panel template page is displayed");
	}

	@Step("Navigate to Bulk upload page")
	public void GetBulkUpload() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Configuration);
		WebInteract.waitForVisibility(homepage.Bulk_Upload);
		Selenium.click(homepage.Bulk_Upload);
		Logger.logMessage("Bulk upload page is displayed");
	}

	@Step("Navigate to Ticket transaction page")
	public void GetTicketTransactionpage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Monitoring);
		WebInteract.waitForVisibility(homepage.Ticket_transaction);
		Selenium.click(homepage.Ticket_transaction);
		Logger.logMessage("Ticket transaction page is displayed");
	}

	@Step("Navigate to AD Image page")
	public void GetADImagepage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Monitoring);
		WebInteract.waitForVisibility(homepage.AD_Images);
		Selenium.click(homepage.AD_Images);
		Logger.logMessage("AD image page is displayed");
	}

	@Step("Navigate to SEARCH TICKET page")
	public void GetSearchTicketpage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Monitoring);
		WebInteract.waitForVisibility(homepage.Search_ticket);
		Selenium.click(homepage.Search_ticket);
		Logger.logMessage("Search ticket page is displayed");
	}

	@Step("Navigate to Panel message tracking page")
	public void GetPanelMessageTrackingpage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Monitoring);
		WebInteract.waitForVisibility(homepage.Panel_Message_tracking);
		Selenium.click(homepage.Panel_Message_tracking);
		Logger.logMessage("Panel message tracking page is displayed");
	}

	@Step("Navigate to Panel status page")
	public void GetPanelStatuspage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Monitoring);
		WebInteract.waitForVisibility(homepage.Panel_Status);
		Selenium.click(homepage.Panel_Status);
		Logger.logMessage("Panel status page is displayed");
	}

	@Step("Navigate to AD on request status page")
	public void GetADOnRequestpage() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.mouseOver(homepage.Monitoring);
		WebInteract.waitForVisibility(homepage.AD_On_Request);
		Selenium.click(homepage.AD_On_Request);
		Logger.logMessage("AD on request page is displayed");
	}

}
