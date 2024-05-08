package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminCustomerInq.customerInqAdminPage;
import pages_DSD_OMS.customerInquiry_DSD.CustomerInquiryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import pages_DSD_OMS.webOrdering.AdminOrderEntryPage;
import util.TestBase;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminCustomerInqStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static AdminHomePage adminHomePage;
    static customerInqAdminPage custInqPageAdmin;
    static CustomerInquiryPage customerInquiryPage;
    static String storeNoValue;
    static String deptNoValue;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        //TestBase driver1=TestBase.getInstanceOfDriver();
        driver= TestBase.getDriver();
    }

    @And("User should enter menu {string} in search bar to navigate to Customer inq")
    public void userShouldEnterMenuInSearchBarToNavigateToCustomerInq(String arg0)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.removeUnwantedDialogbox();
        adminHomePage.ClickOnHamburger();
        adminHomePage.EnterValueInSearchBox(arg0);
        custInqPageAdmin=new customerInqAdminPage(driver,scenario);
        custInqPageAdmin.validatingAdminCustomerInqPage();
    }

    @Then("User should enable Auto populate next available customer number when creating new or copy customers")
    public void userShouldEnableAutoPopulateNextAvailableCustomerNumberWhenCreatingNewOrCopyCustomers()
    {
        custInqPageAdmin=new customerInqAdminPage(driver,scenario);
        custInqPageAdmin.enableAutoPopulateNextTogglebutton();
    }

    @Then("User should disable Auto populate next available customer number when creating new or copy customers")
    public void userShouldDisableAutoPopulateNextAvailableCustomerNumberWhenCreatingNewOrCopyCustomers()
    {
        custInqPageAdmin=new customerInqAdminPage(driver,scenario);
        custInqPageAdmin.disableAutoPopulateNextTogglebutton();
    }

    @And("User should enable Use default Settings for Store Number, variable radio button")
    public void userShouldEnableUseDefaultSettingsForStoreNumberVariableRadioButton()
    {
        custInqPageAdmin=new customerInqAdminPage(driver,scenario);
        custInqPageAdmin.useDefaultSettingsForStoreNumberVariable();
        custInqPageAdmin.useDefaultSettingsDepartmentNumberVariable();
    }

    @Then("User should select customer inq tab for admin for variable values, for store and dept")
    public void userShouldSelectCustomerInqTabForAdminForVariableValuesForStoreAndDept()
    {
        customerInquiryPage= new CustomerInquiryPage(driver, scenario);
        customerInquiryPage.NavigateToCustomerInquiry();
        customerInquiryPage.New_ButtonClick();
        customerInquiryPage.getBillValueVariable();
        customerInquiryPage.storeNoValueVariable();
        customerInquiryPage.deptNovalueVariable();
    }

    @And("User should enable Use default Settings for Store Number and Dept Number, Fixed radio button")
    public void userShouldEnableUseDefaultSettingsForStoreNumberAndDeptNumberFixedRadioButton()
    {
        custInqPageAdmin=new customerInqAdminPage(driver,scenario);
        custInqPageAdmin.useDefaultSettingsForStoreNumberFixed();
        custInqPageAdmin.useDefaultSettingsDepartmentNumberFixed();
        storeNoValue= custInqPageAdmin.readStoreNoValue();
        deptNoValue= custInqPageAdmin.readDeptNovalue();
    }

    @Then("User should select customer inq tab for admin for Fixed values, for store and dept")
    public void userShouldSelectCustomerInqTabForAdminForFixedValuesForStoreAndDept()
    {
        customerInquiryPage= new CustomerInquiryPage(driver, scenario);
        customerInquiryPage.NavigateToCustomerInquiry();
        customerInquiryPage.New_ButtonClick();
        customerInquiryPage.getBillValueFixed();
        customerInquiryPage.getStoreValueFixed(storeNoValue);
        customerInquiryPage.getDepartmentValueFixed(deptNoValue);
    }

    @And("User should enable Use default Settings for Store Number and Dept Number, Manual radio button")
    public void userShouldEnableUseDefaultSettingsForStoreNumberAndDeptNumberManualRadioButton()
    {
        custInqPageAdmin=new customerInqAdminPage(driver,scenario);
        custInqPageAdmin.useDefaultSettingsForStoreNumberManual();
        custInqPageAdmin.useDefaultSettingsDepartmentNumberManual();
    }

    @Then("User should select customer inq tab for admin for Manual values, for store and dept")
    public void userShouldSelectCustomerInqTabForAdminForManualValuesForStoreAndDept()
    {
        customerInquiryPage= new CustomerInquiryPage(driver, scenario);
        customerInquiryPage.NavigateToCustomerInquiry();
        customerInquiryPage.New_ButtonClick();
        customerInquiryPage.getBillValueManual();
        customerInquiryPage.getStoreValueManual();
        customerInquiryPage.getDepartmentValueManual();
    }
}
