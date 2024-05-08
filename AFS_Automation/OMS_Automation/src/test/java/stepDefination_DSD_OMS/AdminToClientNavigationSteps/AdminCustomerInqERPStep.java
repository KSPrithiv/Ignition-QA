package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminCustomerInq.customerInqAdminPage;
import pages_DSD_OMS.customerInquiry_DSD.CustomerInquiryPage;
import pages_DSD_OMS.customerInquiry_ERP.CustomerInquiryPageERP;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminCustomerInqERPStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static CustomerInquiryPageERP customerInquiryPageERP;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        //TestBase driver1=TestBase.getInstanceOfDriver();
        driver= TestBase.getDriver();
    }

    @And("User must be on Client side and select Customer Inq in ERP for admin setting")
    public void userMustBeOnClientSideAndSelectCustomerInqInERPForAdminSetting()
    {
        customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
        customerInquiryPageERP.NavigateToCustomerInquiry();
        customerInquiryPageERP.New_ButtonClick();
    }

    @Then("User should verify customer account# default value")
    public void userShouldVerifyCustomerAccountDefaultValue()
    {
        customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
        customerInquiryPageERP.verifyCustomerAccountWithDefaultValue();
    }

    @Then("User should verify customer account# is empty")
    public void userShouldVerifyCustomerAccountIsEmpty()
    {
        customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
        customerInquiryPageERP.verifyCustomerAccountWithNoValue();
    }
}
