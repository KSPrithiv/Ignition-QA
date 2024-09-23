package stepDefination_DSD_OMS.UserManagementPage;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import jdk.vm.ci.meta.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.billToBill.BillToBillPage;
import pages_DSD_OMS.billToBill.BillingSelectionPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.userManagement.UserManagementPage;
import pages_DSD_OMS.login.UserRegistrationPage;
import util.TestBase;

import java.awt.*;
import java.time.Clock;

public class UserManagementPageStep
{
    WebDriver driver;
    Scenario scenario;
    static boolean flag = false;

    static LoginPage loginpage;
    static HomePage homepage;
    static UserManagementPage userManagementPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }


    @And("User is on User Management Frame")
    public void And_User_is_on_User_Management_Frame () throws InterruptedException {
        if (flag == false) {
            homepage = new HomePage(driver, scenario);
            String title = driver.getTitle();

            Assert.assertEquals(title, "Ignition - Admin");
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            userManagementPage = new UserManagementPage(driver, scenario);
            userManagementPage.navigateToUserManagement();
        }
    }

//        @Then("User navigate to Client side for User Management and select user Management tab")
//        public void user_navigate_to_client_side_for_user_management_and_select_user_management_tab() throws InterruptedException {
//            if (flag == false) {
//                homepage = new HomePage(driver, scenario);
//                String title = driver.getTitle();
//
//                Assert.assertEquals(title, "Ignition - Admin");
//                homepage.verifyUserinfoContainer();
//                homepage.navigateToClientSide();
//                userManagementPage = new UserManagementPage(driver, scenario);
//                userManagementPage.navigateToUserManagement();
//    }

    @Then("CompanyAdmin creates a new User and Register")
    public void company_admin_creates_a_new_user_and_register() throws InterruptedException, AWTException
    {
        userManagementPage = new UserManagementPage(driver, scenario);
        //userManagementPage.enter_all_the_fields_CreateUser();
        userManagementPage.EnterAccount_No();
        userManagementPage.EnterFirstName();
        userManagementPage.EnterLastName();
        userManagementPage.EnterUserName();
        //String str_random=userManagementPage.get_the_UserName();

        userManagementPage.ActualEmail();
        userManagementPage.EnterConfirmEmail();
        userManagementPage.EnterPassword();
        userManagementPage.EnterConfirmPass();
        userManagementPage.enter_User_Role();
        userManagementPage.ClickOnRegistration();


    }

    @Then("CompanyAdmin cancels the newly created User details")
    public void company_admin_cancels_the_newly_created_user_details() throws InterruptedException, AWTException {
        userManagementPage.EnterAccount_No();
        userManagementPage.EnterFirstName();
        userManagementPage.EnterLastName();
        userManagementPage.EnterUserName();
        userManagementPage.ActualEmail();
        userManagementPage.EnterConfirmEmail();
        userManagementPage.EnterPassword();
        userManagementPage.EnterConfirmPass();
        userManagementPage.enter_User_Role();
        userManagementPage.CancelRegistration();


    }
}

