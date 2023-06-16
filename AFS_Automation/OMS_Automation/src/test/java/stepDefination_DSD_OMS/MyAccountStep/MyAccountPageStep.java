package stepDefination_DSD_OMS.MyAccountStep;


import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.MyAccount.*;
import util.TestBase;

import java.io.IOException;

public class MyAccountPageStep {

        WebDriver driver;
        Scenario scenario;
        static boolean flag = false;
        static String currentURL = null;


        LoginPage loginpage;
        HomePage homepage;

        MyAccountPage myAccountPage;

        @Before
        public void LaunchBrowser1(Scenario scenario) throws Exception {
            this.scenario = scenario;
            TestBase driver1 = TestBase.getInstanceOfDriver();
            driver = driver1.getDriver();

        }




        @And("User is on My Account Frame")
        public void user_is_on_my_account_frame() {
            HelpersMethod.Implicitwait(driver,40);
            String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
            if (flag == false) {
                homepage = new HomePage(driver, scenario);
                String title = driver.getTitle();

                Assert.assertEquals(title, "Ignition - Admin");
                homepage.verifyUserinfoContainer();
                homepage.navigateToClientSide();
                myAccountPage = new MyAccountPage(driver, scenario);
                myAccountPage.navigateToMyAccount();

            }
        }

        @And("User is on Additional email recipients Frame")
        public void user_is_on_additional_email_recipients_frame() {
            myAccountPage = new MyAccountPage(driver, scenario);
            myAccountPage.landOn_AdditionalEmailRecipientPage();
        }

        @And("User enters Email Address to add Additional email recipients")
        public void user_enters_email_address_to_add_additional_email_recipients() throws InterruptedException {
            myAccountPage = new MyAccountPage(driver, scenario);
            myAccountPage.User_enters_Email_Address_recipients();

        }

//        @And("users adds the Email Address for Additional email recipients")
//        public void users_adds_the_email_address_for_additional_email_recipients() throws IOException {
//            myAccountPage = new MyAccountPage(driver, scenario);
//            myAccountPage.User_adds_Email_Address_recipients();
//        }

        @And("User selects table content of first row and validate email address is added")
        public void user_selects_table_content_of_first_row_and_validate_email_address_is_added() {
            myAccountPage = new MyAccountPage(driver, scenario);
            myAccountPage.validate_Email_Address_recipients_added();

        }

    @And("user validates Delete button is enabled")
    public void user_validates_delete_button_is_enabled() {
        myAccountPage.user_validates_delete_button_is_enabled();
    }

        @And("users deletes the Email Address for Additional email recipients")
        public void users_deletes_the_email_address_for_additional_email_recipients() {
            myAccountPage = new MyAccountPage(driver, scenario);
            myAccountPage.User_deletes_Email_Address_recipients();
            //myAccountPage.User_deletes_Email_Address_recipients_Delete_Button();
        }

    @And("users validated the delete of the Email Address for Additional email recipients")
    public void users_validated_the_delete_of_the_email_address_for_additional_email_recipients() {
        myAccountPage = new MyAccountPage(driver, scenario);
        myAccountPage.User_deletes_Email_Address_recipients();
    }



    @And("users deletes the Email Address for Additional email recipients Delete button")
    public void users_deletes_the_email_address_for_additional_email_recipients_delete_button() {
        myAccountPage = new MyAccountPage(driver, scenario);
        myAccountPage.User_deletes_Email_Address_recipients_Delete_Button();
    }
    //Additional customer accounts module
    @And("User is on Additional customer accounts")
    public void user_is_on_additional_customer_accounts() {
        //karthik
        //myAccountPage = new MyAccountPage(driver, scenario);

        myAccountPage.landOn_Additionalcust_acc_tab();
    }

    @And("user clears and clicks customer account search box")
    public void user_clears_and_clicks_customer_account_search_box() {
        //myAccountPage = new MyAccountPage(driver, scenario);
        HelpersMethod.Implicitwait(driver, 40);
        myAccountPage.Additionalcust_acc_search_box();
    }

    @And("user fetches the account number in the account details table")
    public void user_fetches_the_account_number_in_the_account_details_table() {
        //myAccountPage = new MyAccountPage(driver, scenario);
        HelpersMethod.Implicitwait(driver, 40);
        myAccountPage.user_fetches_the_account_number_MyAccount();
    }

    @And("user validates Grid should display customer account no")
    public void user_validates_grid_should_display_customer_account_no() {
        //myAccountPage = new MyAccountPage(driver, scenario);
        HelpersMethod.Implicitwait(driver, 40);
        myAccountPage.user_validates_grid_should_display_customer_account_no();
    }

    @And("user deletes details of the mentioned account number")
    public void user_deletes_details_of_the_mentioned_account_number() {
        //myAccountPage = new MyAccountPage(driver, scenario);

        myAccountPage.user_deletes_details_of_the_mentioned_account_number();
    }

    @And("User expands the My account and its associated frames by shrinking hamburger")
    public void user_expands_the_my_account_and_its_associated_frames_by_shrinking_hamburger() {
        myAccountPage.user_expands_the_my_account_and_its_associated_frames();
    }

    @And("user lands on New Address Page")
    public void user_lands_on_new_address_page() {
        myAccountPage.user_lands_on_new_address_page();
    }

    @And("user selects a customer account from the dropdown")
    public void user_selects_a_customer_account_from_the_dropdown() throws InterruptedException {
        myAccountPage.user_selects_a_customer_account_from_the_dropdown();
    }

    @And("user selects the resulted customer details from the table")
    public void user_selects_the_resulted_customer_details_from_the_table() {
        myAccountPage.user_selects_the_resulted_customer_details_from_the_table();
    }

    @And("user deletes the customer details from the table")
    public void user_deletes_the_customer_details_from_the_table() {
        myAccountPage.user_deletes_the_customer_details_from_the_table();
    }

    @And("user deletes the address button for the selected user")
    public void user_deletes_the_address_button_for_the_selected_user() {
        myAccountPage.user_deletes_the_address_button_for_the_selected_user();
    }

    @And("user adds the address button for the selected user")
    public void user_adds_the_address_button_for_the_selected_user() {
        myAccountPage.user_adds_the_address_button_for_the_selected_user();
    }

    @And("enters all the fields in the address page and saves the page")
    public void enters_all_the_fields_in_the_address_page_and_saves_the_page()  throws InterruptedException {
        myAccountPage.enters_all_the_fields_in_the_address_page();
        myAccountPage.user_selects_state_dropdown_Add_newAddress();
        myAccountPage.user_selects_country_dropdown_Add_newAddress();
        myAccountPage.user_saves_all_the_entered_address_fields();
    }

    @And("user edits the address button for the selected user")
    public void user_edits_the_address_button_for_the_selected_user() {
        myAccountPage.user_edits_the_address_button_for_the_selected_user();
    }

    @And("user lands on Payment Page My Account")
    public void user_lands_on_payment_page_my_account() {
        //myAccountPage.user_lands_on_new_address_page();
        myAccountPage.user_lands_on_payment_page_my_account();
    }

    @And("user selects a customer account from the dropdown payment info")
    public void user_selects_a_customer_account_from_the_dropdown_payment_info() throws InterruptedException {
        myAccountPage.user_selects_a_customer_account_from_the_dropdown_payment_info();
    }

    @And("enters all the fields and saves the page in Payment Info")
    public void enters_all_the_fields_and_saves_the_page_in_payment_info() {
        myAccountPage.enters_all_the_fields_and_saves_the_page_in_payment_info();
    }

    @And("user saves all the entered address fields")
    public void user_saves_all_the_entered_address_fields() {
        myAccountPage.user_saves_all_the_entered_address_fields();
    }

    @And("user cancels the process of all the entered address fields")
    public void user_cancels_the_process_of_all_the_entered_address_fields() {
        myAccountPage.user_cancels_the_process_of_all_the_entered_address_fields();
    }

    @And("user validates set Preferred option is enabled")
    public void user_validates_set_preferred_option_is_enabled() {
        myAccountPage.user_validates_set_preferred_option_is_enabled();
    }
}

