package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminSecurity.AdminSecurityPermissionPage;
import pages_DSD_OMS.customerInquiry_ERP.CustomerInquiryPageERP;
import pages_DSD_OMS.customerInquiry_ERP.MainPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.standingOrder.NewStandingOrderPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminStandingOrderOMSStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    NewStandingOrderPage standingOrder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User checks for catalog popup and searches for product in catalog for admin setting zero preceding product number in OMS env")
    public void userChecksForCatalogPopupAndSearchesForProductInCatalogForAdminSettingZeroPrecedingProductNumberInOmsEnv()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ValidateCatalogPopup();
        standingOrder.clickOnLoadAllProducts();
        standingOrder.ResetFilter_Catalog();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            standingOrder.ListViewAdminZeroPrecedingOMS();
        }
        else
        {
            standingOrder.cardViewAdminZeroPrecedingOMS();
        }
        standingOrder.CatalogOKButton();
    }



}
