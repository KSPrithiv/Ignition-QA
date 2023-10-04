package stepDefination_DSD_OMS.UserManagementPage;


import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.billToBill.BillToBillPage;
import pages_DSD_OMS.billToBill.BillingSelectionPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.login.ProductPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.userManagement.ManageRegistrationPage;
import pages_DSD_OMS.userManagement.UserManagementPage;
import pages_DSD_OMS.login.UserRegistrationPage;
import util.TestBase;

import java.awt.*;
import java.io.IOException;
import java.time.Clock;
import java.util.List;

public class Manage_Registration_PageStep {

    WebDriver driver;
    Scenario scenario;
    static boolean flag = false;
    static String currentURL = null;


    static LoginPage loginpage;
    static HomePage homepage;


    ManageRegistrationPage manage_reg_page;
    OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("user is on Manage Registration Frame")
    public void user_is_on_manage_registration_Frame() throws InterruptedException, AWTException {
        if (flag == false) {
            //homepage = new HomePage(driver, scenario);
            ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);

            manage_reg_page.ClickOn_Manage_Registration();
            // manage_reg_page.clickOn_UsersearchIcon();
        }
    }

    @Then("select Customer Account")
    public void select_customer_account() throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.Click_CustomerAccountIndex();
        manage_reg_page.ValidateCustomerAccountPopup();
        manage_reg_page.SelectCustomerAccount_Manage_Registration();

    }

    @Then("select Customer Account with add filter")
    public void select_customer_account_with_add_filter() throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.Click_CustomerAccountIndex();
        manage_reg_page.ValidateCustomerAccountPopup();
        //manage_reg_page.SelectCustomerAccount_Manage_Registration();
        manage_reg_page.SelectCustomerAccount_Manage_Registration_Add_Filter();
    }

    @Then("user fetches the customer account from the index table")
    public void user_fetches_the_customer_account_from_the_index_table() {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.User_fetches_the_customer_account_from_the_index_table();
    }

    @Then("user is on User index table in Manage Registration Page with Add Filter")
    public void user_is_on_user_index_table_in_manage_registration_page_with_Add_Filter() throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.clickOn_UsersearchIcon();
        //manage_reg_page.SelectUser_UserIndexPopup();
        //Apr-4

        manage_reg_page.Select_sales_rep_User_IndexPopup_with_AddFilter();
    }


    @Then("user is on User index table without Add filter")
    public void user_is_on_user_index_table_without_add_filter() throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.clickOn_UsersearchIcon();
        manage_reg_page.SelectUser_UserIndexPopup_without_Add_Filter();
    }

    @Then("user has done changes in the manage registration page and updated")
    public void user_has_done_changes_in_the_manage_registration_page_and_updated(DataTable tabledata) throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        List<List<String>> PO_Num = tabledata.asLists(String.class);
        manage_reg_page.EnterPO_No(PO_Num.get(0).get(0));
    }

    @Then("user updates the modified UserInfo")
    public void user_updates_the_modified_UserInfo() throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.update_UserInfo();

    }

    @Then("user either deletes the primary account or leave it based on the presence of Primary delete button")
    public void user_either_deletes_the_primary_account_or_leave_it_based_on_the_presence_of_primary_delete_button() throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.Delete_Primary_Account_Details();

    }


    @Then("user enters the fetched customer account in the account field")
    public void user_enters_the_fetched_customer_account_in_the_account_field() throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        //String str = manage_reg_page.SelectCustomerAccount_Manage_Registration();

        manage_reg_page.Enter_Primary_Account_No();

    }


    @Then("user adds the primary account for that sales representative")
    public void user_adds_the_primary_account_for_that_sales_representative() throws InterruptedException, IOException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.User_Adds_Primary_Account();

    }

    @Then("enters email ID")
    public void enters_email_id() {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.enterEmail();
    }

    @Then("user adds emailID")
    public void user_adds_email_id() throws IOException, InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.User_Adds_emailID();

    }

    @Then("user lands on pending registrations page")
    public void user_lands_on_pending_registrations_page() {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.click_Pending_registrations();
    }


    @Then("select user from the dropdown")
    public void select_user_from_the_dropdown() throws InterruptedException {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.find_and_select_User_pending_registration();

    }

    @Then("sales rep confirms to activate the user")
    public void sales_rep_confirms_to_activate_the_user() {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.confirm_the_activation();
    }

    @Then("sales rep denies to activate the user")
    public void sales_rep_denies_to_activate_the_user() {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.Deny_the_activation();
    }

    @Then("user cancels the manage registration page")
    public void user_cancels_the_manage_registration_page() {
        ManageRegistrationPage manage_reg_page = new ManageRegistrationPage(driver, scenario);
        manage_reg_page.user_cancels_the_manage_registration_page();
    }

}

