package stepDefination_DSD_OMS.AdminReport;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.adminReport.userAndAdmin_GeneralPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.login.UserRegistrationPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;

public class UserAndAccount_GeneralPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static userAndAdmin_GeneralPage userAndAdminGeneralPage;
    static AdminHomePage adminHomePage;
    static HomePage homepage;
    static LoginPage loginpage;
    static UserRegistrationPage userRegistrationPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User Clicks on Permissions by drop down to select Customer Account# to default")
    public void userClicksOnPermissionsByDropDownToSelectCustomerAccountToDefault()
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectDefaultCompany();
    }

    @And("User handles Administrator to approve all new user registrations toggle button and validate Pending registration approval Tab")
    public void userHandlesAdministratorToApproveAllNewUserRegistrationsToggleButtonAndValidatePendingRegistrationApprovalTab()
    {
        userAndAdminGeneralPage=new userAndAdmin_GeneralPage(driver,scenario);
        userAndAdminGeneralPage.enablePendingRegistrationToggle();
        userAndAdminGeneralPage.validatePendingRegirationTab();
    }

    @And("User validates all five toggle buttons presence in User and Admin General page")
    public void userValidatesAllFiveToggleButtonsPresenceInUserAndAdminGeneralPage()
    {
        userAndAdminGeneralPage=new userAndAdmin_GeneralPage(driver,scenario);
        userAndAdminGeneralPage.validateAllToggleButtons();
    }

    @And("User enables new customer registration from login page toggle button, and save")
    public void userEnablesNewCustomerRegistrationFromLoginPageToggleButtonAndSave()
    {
        userAndAdminGeneralPage=new userAndAdmin_GeneralPage(driver,scenario);
        userAndAdminGeneralPage.enableNewCustomerRegistrationFromLoginPage();
        userAndAdminGeneralPage.clickOnSaveButton();
    }

    @Then("User logout from Admin page and click on Register here button, and verify check box")
    public void userLogoutFromAdminPageAndClickOnRegisterHereButtonAndVerifyCheckBox() throws InterruptedException, AWTException
    {
        boolean Result=false;
        homepage=new HomePage(driver,scenario);
        homepage.Click_On_UserIcon();
        homepage.Click_On_Signout();
        loginpage = new LoginPage(driver, scenario);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        loginpage.RegisterHere();
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(text(),'Customer Registration')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 200);
        if (HelpersMethod.IsExists("//div[contains(text(),'Customer Registration')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
        {
            Result = true;
        }
        Assert.assertEquals(true, Result);
        userRegistrationPage=new UserRegistrationPage(driver,scenario);
        userRegistrationPage.validateDoNotHaveAccount();
        userRegistrationPage.CancelRegistration();
    }

    @And("User again login as admin and enable taggle button again")
    public void userAgainLoginAsAdminAndEnableTaggleButtonAgain() throws InterruptedException, AWTException
    {
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();
        userAndAdminGeneralPage=new userAndAdmin_GeneralPage(driver,scenario);
        userAndAdminGeneralPage.enableNewCustomerRegistrationFromLoginPage1();
        userAndAdminGeneralPage.clickOnSaveButton();
    }
}
