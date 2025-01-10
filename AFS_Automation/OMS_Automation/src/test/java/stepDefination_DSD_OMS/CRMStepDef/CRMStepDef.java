package stepDefination_DSD_OMS.CRMStepDef;

import helper.HelpersMethod;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.CRMPage.CRMPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.themeBuilderPage.ThemeBuilderPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;
import java.util.List;
import java.awt.*;

public class CRMStepDef {
    WebDriver driver;
    Scenario scenario;
    AdminHomePage adminHomePage;
    CRMPage crmPage;
    ThemeBuilderPage themeBuilderPage;
    LoginPage loginpage;
    HomePage homepage;
    // Instantiate the Hooks class and pass the WebDriver instance
    //hooks = new Hooks(driver);

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }
    /*@After
    public void afterScenario() {
        // Refresh browser after each scenario (if needed)
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
        //wait.until(ExpectedConditions.jsReturnsValue("return document.readyState").equals("complete"));
    }
*/
    @Given("User able to open login page successfully")
    public void userAbleToOpenLoginPageSuccessfully() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        //HelpersMethod.waitTillPageLoaded(driver, 5000);
    }

    @When("User entered correct Admin username and password on the page")
    public void userEnteredCorrectAdminUsernameAndPasswordOnThePage() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminWord());
        loginpage.ClickSignin();
        //HelpersMethod.waitTillPageLoaded(driver, 6000);
    }

    @Then("Admin Page opened successfully")
    public void adminPageOpenedSuccessfully() throws InterruptedException {
        homepage = new HomePage(driver,scenario);
        homepage.VerifyHomePage();
        HelpersMethod.waitTillPageLoaded(driver, 5000);

    }
    @And("User click on Hamburger left Menu")
    public void userClickOnHamburgerLeftMenu() throws InterruptedException {
        //themeBuilderPage=new ThemeBuilderPage(driver,scenario);
        //themeBuilderPage.ClickOnGSHumburger();
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
    }

    @Then("Select CRM Tickets Module")
    public void selectCRMTicketsModule() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnCRMTickets();
        System.out.println("click on CRM module");
    }
    @Then("Validate CRM Tickets page get opened")
    public void validateCRMTicketsPageGetOpened() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyCRMPageOpened();
    }
    @And("Verify All four tabs in CRM module called CRM General, Purge, Notifications, Configure")
    public void verifyAllFourTabsInCRMModuleCalledCRMGeneralPurgeNotificationsConfigure() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyAllTabs();
    }

    @And("Verify CRM General tab have buttons like Export, Notes, Reason, Source, Category, Action, Feedback, Feedback type")
    public void verifyCRMGeneralTabHaveButtonsLikeExportNotesReasonSourceCategoryActionFeedbackFeedbackType() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyExportTicketsBtn();
        crmPage.verifyNotesBtn();
        crmPage.verifyReasonBtn();
        crmPage.verifySourceBtn();
        crmPage.verifyActionBtn();
        crmPage.verifyCategoryBtn();
        crmPage.verifyFeedbackBtn();
        crmPage.verifyFeedbackTypeBtn();
    }
    @Then("Also validate Ticket number is a field where user can increase or decrease the number")
    public void alsoValidateTicketNumberIsAFieldWhereUserCanIncreaseOrDecreaseTheNumber() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyTicketNumberField();
        crmPage.increaseTicketNum();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
        //Thread.sleep(3000);
        crmPage.decreaseTicketNum();
        themeBuilderPage=new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.cancelChanges();

    }
    @And("Edit any field under CRM general tab")
    public void edit_any_field_under_crm_general_tab() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.increaseTicketNum();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
        //Thread.sleep(3000);
    }

    @And("Validate Cancel and Save buttons should get enabled")
    public void validate_cancel_and_save_buttons_should_get_enabled() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyCancelAndSaveBtnEnabled();
    }

    @Then("Click on Cancel button and Validate pop up message get come")
    public void click_on_cancel_button_and_validate_pop_up_message_get_come() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickCancelAndValidatePopUp();

    }

    @Then("Click on yes option from pop up to discard the changes which we made in above steps and Validate page no any changes displaying")
    public void click_on_yes_option_from_pop_up_to_discard_the_changes_which_we_made_in_above_steps_and_validate_page_no_any_changes_displaying() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnYesAndVerifyNoChanges();
    }

    @And("Again User Edit any field under CRM general tab")
    public void again_user_edit_any_field_under_crm_general_tab() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.increaseTicketNum();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
        //Thread.sleep(3000);
    }

    @Then("Click on No option from pop up and Validate changes still displaying on the page")
    public void click_on_no_option_from_pop_up_and_validate_changes_still_displaying_on_the_page() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnNoAndVerifyChangesStillOnThePage();
        //Thread.sleep(2000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }

    @Then("Click on Save button and Validate pop up display on the screen")
    public void click_on_save_button_and_validate_pop_up_display_on_the_screen() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnSaveBtnAndVerifyPopUp();
        //Thread.sleep(2000);
    }

    @And("Click on ok button to save the changes")
    public void click_on_ok_button_to_save_the_changes() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnOkBtnFromPopUp();
        //Thread.sleep(2000);
    }

    @And("Validate Changes on the screen")
    public void validate_changes_on_the_screen() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyChangesOnThePage();
        //Thread.sleep(2000);
    }

    @When("User click on purge tab and Select any company")
    public void userClickOnPurgeTabAndSelectAnyCompany() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnPurgeTab();
        //Thread.sleep(2000);
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectCompany();
    }

    @Then("Validate purge screen should display with list of tickets")
    public void validatePurgeScreenShouldDisplayWithListOfTickets() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyPurgeTabScreenOpened();
        //Thread.sleep(2000);
        //crmPage.verifyPurgeTabHavingListOfTickets();
    }

    @And("Also validate items found field should display the number of tickets listed on the page")
    public void alsoValidateItemsFoundFieldShouldDisplayTheNumberOfTicketsListedOnThePage() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyItemFoundField();
        //Thread.sleep(2000);
    }

    @When("User click on Notification tab and Select any company")
    public void userClickOnNotificationTabAndSelectAnyCompany() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnNotificationTab();
        /*adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectCompany();*/
        //Thread.sleep(2000);
    }

    @Then("Validate notification screen should display with list of notifications records")
    public void validateNotificationScreenShouldDisplayWithListOfNotificationsRecords() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyNotificationPageOpened();
        //Thread.sleep(2000);
        crmPage.verifyItemFoundField();
        //Thread.sleep(2000);
        crmPage.verifyListOfNotifications();
        //Thread.sleep(2000);
    }

    @Then("Click on + plus button to add notification and verify notification pop up should open")
    public void clickOnPlusButtonToAddNotificationAndVerifyNotificationPopUpShouldOpen() throws InterruptedException {
        /*adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectCompany();*/
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
        //Thread.sleep(2000);
        crmPage.verifyPopUpOfAddNotification();
        //Thread.sleep(2000);
    }

    @And("Provide all the mandatory field values and click on save button")
    public void provideAllTheMandatoryFieldValuesAndClickOnSaveButton() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.addNotificationDetails();
        //Thread.sleep(2000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);
        //Thread.sleep(5000);
    }

    @And("Validate new record should get added under notifications")
    public void validateNewRecordShouldGetAddedUnderNotifications() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyListOfRecords();
        //Thread.sleep(2000);
    }

    @And("Skip any mandatory field values and Validate error message for the respective fields")
    public void skipAnyMandatoryFieldValuesAndValidateErrorMessageForTheRespectiveFields() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        //crmPage.clickOnAddNotificationBtn();
        crmPage.skipAnyMandatoryField();
        //Thread.sleep(2000);
    }

    @And("Click on Cancel button from notification pop up")
    public void clickOnCancelButtonFromNotificationPopUp() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnCancelBtn();
        //Thread.sleep(2000);
    }
    @When("User able to select any notification from the list of notifications which we want to delete")
    public void user_able_to_select_any_notification_from_the_list_of_notifications_which_we_want_to_delete() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.selectAnyNotyFromList();
        //Thread.sleep(2000);
    }
    @Then("Validate Edit and delete buttons get enabled")
    public void validate_edit_and_delete_buttons_get_enabled() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyEditAndDeleteBtnEnabled();
        //Thread.sleep(2000);
    }

    @Then("Click on delete button and click on Cancel button from pop up")
    public void click_on_delete_button_and_click_on_cancel_button_from_pop_up() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnDeleteBtnAndVerifyPopUpText();
        //Thread.sleep(2000);
        crmPage.clickOnCancelBtnFromPopUpNoty();
        //Thread.sleep(2000);
    }

    @And("Validate notification page having same notification list as before")
    public void validate_notification_page_having_same_notification_list_as_before() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyListOfRecords();
        //Thread.sleep(2000);
    }

    @And("Click on delete button and click on ok button from pop up")
    public void click_on_delete_button_and_click_on_ok_button_from_pop_up() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnDeleteBtnAndVerifyPopUpText();
        //Thread.sleep(2000);
        crmPage.clkOnOkBtnFromPopUp();
        //Thread.sleep(2000);
    }

    @And("Validate notification page having less than {int} notification as before")
    public void validate_notification_page_having_less_than_notification_as_before(Integer int1) throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyListOfRecords();
        //Thread.sleep(2000);
    }

    @When("User able to select any notification from the list of notifications which we want to Edit")
    public void userAbleToSelectAnyNotificationFromTheListOfNotificationsWhichWeWantToEdit() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.selectAnyNotyFromList();
        //Thread.sleep(2000);
    }

    @Then("Click on Edit button and Validate Notification pop up should display with all details")
    public void clickOnEditButtonAndValidateNotificationPopUpShouldDisplayWithAllDetails() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnEditBtnAndVerifyNotyPopUp();
        //Thread.sleep(2000);
        crmPage.verifyPopUpOfAddNotification();
        //Thread.sleep(2000);

    }
    @Then("Edit any field and click on save button And Validate Changes")
    public void editAnyFieldAndClickOnSaveButtonAndValidateChanges() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.editAnyFieldAndClkOnSaveBtn();
        //Thread.sleep(2000);
    }

    @Then("User click on Configure tab and select any company")
    public void userClickOnConfigureTabAndSelectAnyCompany() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        /*adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectCompany();*/
        //Thread.sleep(2000);
    }

    @And("Validate Configure page should display the list of base tables")
    public void validateConfigurePageShouldDisplayTheListOfBaseTables() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyConfigPage();
        //Thread.sleep(2000);
    }

    @Then("Select any base table record and validate record get selected and highlighted with yellow color")
    public void selectAnyBaseTableRecordAndValidateRecordGetSelectedAndHighlightedWithYellowColor() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.selectAnyBaseTableRecordAndVerify();
        //Thread.sleep(2000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }

    @And("Also verify the right side grid should display the list of Configuration of the selected base table")
    public void alsoVerifyTheRightSideGridShouldDisplayTheListOfConfigurationOfTheSelectedBaseTable() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyRightSideGridConfig();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }

    @Then("Click on plus button to add configuration under that base table")
    public void clickOnPlusButtonToAddConfigurationUnderThatBaseTable() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.addConfiguration();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }


    @And("Validate add pop up will get open with description text box")
    public void validateAddPopUpWillGetOpenWithDescriptionTextBox() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyConfigPopUp();
        HelpersMethod.waitTillPageLoaded(driver, 4000);

    }

    @Then("Provide appropriate description and click on save button")
    public void provideAppropriateDescriptionAndClickOnSaveButton() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.addDescriptionForConfigSaveBtn();
        //Thread.sleep(2000);
    }

    @And("Validate new code should get created for new configuration with next sequence number")
    public void validateNewCodeShouldGetCreatedForNewConfigurationWithNextSequenceNumber() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyTableAfterAddConfig();
        //Thread.sleep(5000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);
        crmPage.verifyRightSideGridConfig();
        //Thread.sleep(5000);
    }

    @Then("Select any row from table which we are going to edit")
    public void selectAnyRowFromTableWhichWeAreGoingToEdit() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.selectAnyRow();
        //Thread.sleep(5000);
    }
    @Then("Click on Edit button to edit configuration under that base table")
    public void clickOnEditButtonToEditConfigurationUnderThatBaseTable() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnEditBtn();
        //Thread.sleep(5000);
    }

    @And("Validate Edit pop up will get open with description text box enabled and code field disabled")
    public void validateEditPopUpWillGetOpenWithDescriptionTextBoxEnabledAndCodeFieldDisabled() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyEditPopUpAndAddDesc();
        //Thread.sleep(5000);
    }

    @Then("Provide new appropriate description and click on Cancel button from pop up")
    public void provideNewAppropriateDescriptionAndClickOnCancelButtonFromPopUp() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnCancelBtnPopUp();
        //Thread.sleep(5000);
    }

    @And("Validate the field should reverted back and display old value")
    public void validateTheFieldShouldRevertedBackAndDisplayOldValue() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyNoChangesAfterCancelBtn();
        //Thread.sleep(5000);
    }

    @Then("Provide new appropriate description and click on Edit button from pop up")
    public void provideNewAppropriateDescriptionAndClickOnEditButtonFromPopUp() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyEditPopUpAndAddDesc();
        //Thread.sleep(5000);
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
        crmPage.clickOnEditBtnPopUp();
        //Thread.sleep(5000);
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
    }

    @And("Validate the field should save with new description and display new value")
    public void validateTheFieldShouldSaveWithNewDescriptionAndDisplayNewValue() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyTableAfterAddConfig();
        //Thread.sleep(5000);
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
        crmPage.verifyRightSideGridConfig();
        //Thread.sleep(5000);
    }


    @Then("Select any row from table which we are going to Delete")
    public void selectAnyRowFromTableWhichWeAreGoingToDelete() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.selectAnyRow();
        //Thread.sleep(5000);
    }

    @Then("Click on Delete button to delete configuration under that base table")
    public void clickOnDeleteButtonToDeleteConfigurationUnderThatBaseTable() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnDeleteBtn();
        //Thread.sleep(5000);
    }

    @And("Validate Delete pop up with cancel and okay button enabled")
    public void validateDeletePopUpWithCancelAndOkayButtonEnabled() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyCancelAndOkBtnOnPopUp();
        //Thread.sleep(5000);
    }

    @Then("Click on Cancel button from pop up")
    public void clickOnCancelButtonFromPopUp() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnCancelBtnFromPopUpOfDelConfig();
        //Thread.sleep(5000);
    }

    @And("Validate the record should not get deleted")
    public void validateTheRecordShouldNotGetDeleted() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyRecordNotDeleted();
        //Thread.sleep(5000);
        crmPage.verifyRightSideGridConfig();
    }

    @Then("Click on Ok button from pop up")
    public void clickOnOkButtonFromPopUp() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnOkBtnFromPopUpOfDelConfig();
        //Thread.sleep(5000);
    }

    @And("Validate Record should get deleted successfully")
    public void validateRecordShouldGetDeletedSuccessfully() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyRightSideGridConfig();
        //Thread.sleep(5000);
        crmPage.verifyTableAfterDelConfig();
    }

    @And("Click on Logout button to logout from Admin")
    public void clickOnLogoutButtonToLogoutFromAdmin() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();
    }
    @When("Enter Client Login credentials and Click on login button")
    public void enterClientLoginCredentialsAndClickOnLoginButton() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
    }

    @Then("Client home Page opened successfully")
    public void clientHomePageOpenedSuccessfully() throws InterruptedException {
        homepage = new HomePage(driver,scenario);
        homepage.VerifyHomePage();
        //HelpersMethod.waitTillPageLoaded(driver, 5000);
        //crmPage=new CRMPage(driver,scenario);
        //crmPage.verifyHomePageLoaded();
        //Thread.sleep(5000);
        //System.out.println("Client Home page opened");
    }

    @Then("Click on settings button above of hamburger")
    public void clickOnSettingsButtonAboveOfHamburger() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        //Thread.sleep(1000);
        crmPage.clickOnSettingsBtn();
    }

    @Then("Select CRM Tickets Module and Validate CRM Tickets page get opened")
    public void selectCRMTicketsModuleAndValidateCRMTicketsPageGetOpened() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.selectCRMTicketsModule();
        //Thread.sleep(2000);
        crmPage.verifyClientCRMPageOpened();

    }

    @And("Also Verify Page should display the list of tickets created")
    public void alsoVerifyPageShouldDisplayTheListOfTicketsCreated() {
        crmPage=new CRMPage(driver,scenario);
        //crmPage.verifyListOfTickets();
        crmPage.verifyItemFoundField();
        crmPage.verifyListOfNotifications();
    }

    @When("User click on the plus button from tickets page to add new ticket")
    public void userClickOnThePlusButtonFromTicketsPageToAddNewTicket() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNewTicketBtn();
    }

    @Then("New ticket page opened successfully")
    public void newTicketPageOpenedSuccessfully() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyNewTicketPage();
    }

    @Then("Provide all the mandatory fields and click on save button")
    public void provideAllTheMandatoryFieldsAndClickOnSaveButton() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.provideAllMandatoryValuesToAddTicket();
        //Thread.sleep(5000);
    }

    @And("Validate page should navigate back to the main page and new ticket should get created")
    public void validatePageShouldNavigateBackToTheMainPageAndNewTicketShouldGetCreated() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyClientCRMPageOpened();
        crmPage.verifyItemFoundField();
        crmPage.verifyListOfNotifications();
    }

    @And("Verify new ticket is created with next sequence number")
    public void verifyNewTicketIsCreatedWithNextSequenceNumber() {
        crmPage=new CRMPage(driver,scenario);
        //crmPage.verifyOldCRMTicketsMainPageOpened();
        crmPage.verifyListOfTicketsWithNewSqeNum();
    }

    @When("User on the CRM tickets page verify Export CSV button available on the page")
    public void userOnTheCRMTicketsPageVerifyExportCSVButtonAvailableOnThePage() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.verifyExportCSVBtn();
    }

    @Then("Click on Export CSV button and verify CSV file should get generated")
    public void clickOnExportCSVButtonAndVerifyCSVFileShouldGetGenerated() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnExportCSVBtn();
        //Thread.sleep(3000);
        crmPage.verifyCSVFileGenerated();
        //Thread.sleep(2000);
    }

    @Given("User logged in as an admin")
    public void userLoggedInAsAnAdmin() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminWord());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
    }


    @When("User click on the Configuration tab under general settings menu")
    public void userClickOnTheConfigurationTabUnderGeneralSettingsMenu() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        crmPage.clickOnCRMTickets();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.CloseHamburger();
        //crmPage.clickOnHamburgerMenu();
        crmPage.clickOnConfigurationTab();
        //adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectCompany();
        //Thread.sleep(3000);
    }

    @And("User click on the Priority Configuration option")
    public void userClickOnThePriorityConfigurationOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnPriorityOption();
    }

    @Then("User should see the following priority values:")
    public void userShouldSeeTheFollowingPriorityValues(List<String> expectedPriorityValues) {
        List<String> actualPriorityValues = crmPage.getPriorityValues();
        Assert.assertEquals(expectedPriorityValues, actualPriorityValues, "not match priority values");
    }

    @Given("User logged in as a client")
    public void userLoggedInAsAClient() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
    }

    @When("User click on the New Ticket option under settings->CRM Tickets")
    public void userClickOnTheNewTicketOptionUnderSettingsCRMTickets() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        //Thread.sleep(3000);
        crmPage.selectCRMTicketsModule();
        crmPage.clickOnAddNewTicketBtn();
    }

    @Then("User should see the following priority values in the dropdown:")
    public void userShouldSeeTheFollowingPriorityValuesInTheDropdown(List<String> expectedPriorityValues) throws InterruptedException {
        List<String> actualPriorityValues = crmPage.getPriorityDropdownValues();
        Assert.assertEquals(actualPriorityValues, expectedPriorityValues);
        //System.out.println("Client dropdown");
    }

    @Then("The displayed priority values should match the client dropdown values")
    public void theDisplayedPriorityValuesShouldMatchTheClientDropdownValues() throws InterruptedException, AWTException {
        List<String> adminPriorityValues = crmPage.getPriorityValues();
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        //Thread.sleep(3000);
        crmPage.selectCRMTicketsModule();

        crmPage.clickOnAddNewTicketBtn();
        List<String> clientPriorityDropdownValues = crmPage.getPriorityDropdownValues();

        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        Assert.assertEquals(adminPriorityValues, clientPriorityDropdownValues, "Admin and client both are values are different");
        System.out.println("admin and client priority matches");
    }

    @And("User click on the Module Configuration option")
    public void userClickOnTheModuleConfigurationOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnModuleOption();
    }

    @Then("User should see the following module values:")
    public void userShouldSeeTheFollowingModuleValues(List<String> expectedModuleValues) {
        List<String> actualModuleValues = crmPage.getModuleValues();
        Assert.assertEquals(expectedModuleValues, actualModuleValues, "not match module values");
    }

    @Then("User should see the following module values in the dropdown:")
    public void userShouldSeeTheFollowingModuleValuesInTheDropdown(List<String> expectedModuleValues) throws InterruptedException {
        List<String> actualModuleValues = crmPage.getModuleDropdownValues();
        Assert.assertEquals(actualModuleValues, expectedModuleValues);
    }

    @Then("The displayed module values should match the client dropdown values")
    public void theDisplayedModuleValuesShouldMatchTheClientDropdownValues() throws InterruptedException, AWTException {
        List<String> adminModuleValues = crmPage.getModuleValues();
        OrderEntryPage orderEntryPage=new OrderEntryPage(driver, scenario);
        orderEntryPage.Click_On_Signout();
        /*themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();*/

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        //Thread.sleep(3000);
        crmPage.selectCRMTicketsModule();

        crmPage.clickOnAddNewTicketBtn();
        List<String> clientModuleDropdownValues = crmPage.getModuleDropdownValues();

        /*themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();*/

        //OrderEntryPage orderEntryPage=new OrderEntryPage(driver, scenario);
        orderEntryPage.Click_On_Signout();

        Assert.assertEquals(adminModuleValues, clientModuleDropdownValues, "Admin and client both are values are different");
        System.out.println("admin and client module column matches");
    }

    @And("User click on the Type Configuration option")
    public void userClickOnTheTypeConfigurationOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnTypeOption();
    }

    @Then("User should see the following type values:")
    public void userShouldSeeTheFollowingTypeValues(List<String> expectedTypeValues) {
        List<String> actualTypeValues = crmPage.getTypeValues();
        Assert.assertEquals(expectedTypeValues, actualTypeValues, "not match type values");

    }

    @Then("User should see the following type values in the dropdown:")
    public void userShouldSeeTheFollowingTypeValuesInTheDropdown(List<String> expectedTypeValues) throws InterruptedException {
        List<String> actualTypeValues = crmPage.getTypeDropdownValues();
        Assert.assertEquals(actualTypeValues, expectedTypeValues);
    }

    @Then("The displayed type values should match the client dropdown values")
    public void theDisplayedTypeValuesShouldMatchTheClientDropdownValues() throws InterruptedException, AWTException {
        List<String> adminTypeValues = crmPage.getTypeValues();
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        //Thread.sleep(3000);
        crmPage.selectCRMTicketsModule();
        //Thread.sleep(3000);
        crmPage.clickOnAddNewTicketBtn();
        List<String> clientTypeDropdownValues = crmPage.getTypeDropdownValues();

        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        Assert.assertEquals(adminTypeValues, clientTypeDropdownValues, "Admin and client both are values are different");
        System.out.println("admin and client type column matches");
    }

    @And("User click on the Reason Configuration option")
    public void userClickOnTheReasonConfigurationOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnReasonOption();
    }

    @Then("User should see the following reason values:")
    public void userShouldSeeTheFollowingReasonValues(List<String> expectedReasonValues) {
        List<String> actualReasonValues = crmPage.getReasonValues();
        Assert.assertEquals(expectedReasonValues, actualReasonValues, "not match type values");

    }

    @Then("User should see the following reason values in the dropdown:")
    public void userShouldSeeTheFollowingReasonValuesInTheDropdown(List<String> expectedReasonValues) throws InterruptedException {
        List<String> actualReasonValues = crmPage.getReasonDropdownValues();
        Assert.assertEquals(actualReasonValues, expectedReasonValues);
    }

    @Then("The displayed Reason values should match the client dropdown values")
    public void theDisplayedReasonValuesShouldMatchTheClientDropdownValues() throws InterruptedException, AWTException {
        List<String> adminReasonValues = crmPage.getReasonValues();
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        //Thread.sleep(3000);
        crmPage.selectCRMTicketsModule();
        //Thread.sleep(3000);
        crmPage.clickOnAddNewTicketBtn();
        List<String> clientReasonDropdownValues = crmPage.getReasonDropdownValues();

        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        Assert.assertEquals(adminReasonValues, clientReasonDropdownValues, "Admin and client both are values are different");
        System.out.println("admin and client reason column matches");

    }

    @And("User click on the Category Configuration option")
    public void userClickOnTheCategoryConfigurationOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnCategoryOption();
    }

    @Then("User should see the following Category values:")
    public void userShouldSeeTheFollowingCategoryValues(List<String> expectedCategoryValues) {
        List<String> actualCategoryValues = crmPage.getCategoryValues();
        Assert.assertEquals(expectedCategoryValues, actualCategoryValues, "not match type values");
    }

    @Then("User should see the following Category values in the dropdown:")
    public void userShouldSeeTheFollowingCategoryValuesInTheDropdown(List<String> expectedCategoryValues) throws InterruptedException {
        List<String> actualCategoryValues = crmPage.getCategoryDropdownValues();
        Assert.assertEquals(expectedCategoryValues, actualCategoryValues);

    }

    @Then("The displayed Category values should match the client dropdown values")
    public void theDisplayedCategoryValuesShouldMatchTheClientDropdownValues() throws InterruptedException, AWTException {
        List<String> adminCategoryValues = crmPage.getCategoryValues();
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        //Thread.sleep(3000);
        crmPage.selectCRMTicketsModule();
        // Thread.sleep(3000);
        crmPage.clickOnAddNewTicketBtn();
        List<String> clientCategoryDropdownValues = crmPage.getCategoryDropdownValues();

        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        Assert.assertEquals(adminCategoryValues, clientCategoryDropdownValues, "Admin and client both are values are different");
        System.out.println("admin and client category column matches");
    }

    @And("User click on the Action Configuration option")
    public void userClickOnTheActionConfigurationOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnActionOption();
    }

    @Then("User should see the following Action values:")
    public void userShouldSeeTheFollowingActionValues(List<String> expectedActionValues) {
        List<String> actualActionValues = crmPage.getActionValues();
        Assert.assertEquals(expectedActionValues, actualActionValues, "not match type values");

    }

    @Then("User should see the following Action values in the dropdown:")
    public void userShouldSeeTheFollowingActionValuesInTheDropdown(List<String> expectedActionValues) throws InterruptedException {
        List<String> actualActionValues = crmPage.getActionDropdownValues();
        Assert.assertEquals(expectedActionValues, actualActionValues);
    }

    @Then("The displayed Action values should match the client dropdown values")
    public void theDisplayedActionValuesShouldMatchTheClientDropdownValues() throws InterruptedException, AWTException {
        List<String> adminActionValues = crmPage.getActionValues();
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(8000);
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        crmPage.selectCRMTicketsModule();
        //Thread.sleep(3000);
        crmPage.clickOnAddNewTicketBtn();
        List<String> clientActionDropdownValues = crmPage.getActionDropdownValues();

        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        Assert.assertEquals(adminActionValues, clientActionDropdownValues, "Admin and client both are values are different");
        System.out.println("admin and client Action column matches");
    }

    @And("User click on the Feedback Configuration option")
    public void userClickOnTheFeedbackConfigurationOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnFeedbackOption();
    }

    @Then("User should see the following Feedback values:")
    public void userShouldSeeTheFollowingFeedbackValues(List<String> expectedFeedbackValues) {
        List<String> actualFeedbackValues = crmPage.getFeedbackValues();
        Assert.assertEquals(expectedFeedbackValues, actualFeedbackValues, "not match type values");

    }

    @Then("User should see the following Feedback values in the dropdown:")
    public void userShouldSeeTheFollowingFeedbackValuesInTheDropdown(List<String> expectedFeedbackValues) throws InterruptedException {
        List<String> actualFeedbackValues = crmPage.getFeedbackDropdownValues();
        Assert.assertEquals(expectedFeedbackValues, actualFeedbackValues);
    }

    @Then("The displayed Feedback values should match the client dropdown values")
    public void theDisplayedFeedbackValuesShouldMatchTheClientDropdownValues() throws InterruptedException, AWTException {
        List<String> adminFeedbackValues = crmPage.getFeedbackValues();
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        crmPage.selectCRMTicketsModule();
        //Thread.sleep(3000);
        crmPage.clickOnAddNewTicketBtn();
        List<String> clientFeedbackDropdownValues = crmPage.getFeedbackDropdownValues();

        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        Assert.assertEquals(adminFeedbackValues, clientFeedbackDropdownValues, "Admin and client both are values are different");
        System.out.println("admin and client Feedback column matches");
    }

    @And("User click on the FeedbackType Configuration option")
    public void userClickOnTheFeedbackTypeConfigurationOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnFeedbackTypeOption();
    }

    @Then("User should see the following FeedbackType values:")
    public void userShouldSeeTheFollowingFeedbackTypeValues(List<String> expectedFeedbackTypeValues) {
        List<String> actualFeedbackTypeValues = crmPage.getFeedbackTypeValues();
        Assert.assertEquals(expectedFeedbackTypeValues, actualFeedbackTypeValues, "not match type values");
    }

    @Then("User should see the following FeedbackType values in the dropdown:")
    public void userShouldSeeTheFollowingFeedbackTypeValuesInTheDropdown(List<String> expectedFeedbackTypeValues) throws InterruptedException {
        List<String> actualFeedbackTypeValues = crmPage.getFeedbackTypeDropdownValues();
        Assert.assertEquals(expectedFeedbackTypeValues, actualFeedbackTypeValues);
    }

    @Then("The displayed FeedbackType values should match the client dropdown values")
    public void theDisplayedFeedbackTypeValuesShouldMatchTheClientDropdownValues() throws InterruptedException, AWTException {
        List<String> adminFeedbackTypeValues = crmPage.getFeedbackTypeValues();
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.Userword());
        loginpage.ClickSignin();
        //Thread.sleep(5000);
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        //Thread.sleep(3000);
        crmPage.clickOnSettingsBtn();
        crmPage.selectCRMTicketsModule();
        //Thread.sleep(3000);
        crmPage.clickOnAddNewTicketBtn();
        List<String> clientFeedbackTypeDropdownValues = crmPage.getFeedbackTypeDropdownValues();

        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();

        Assert.assertEquals(adminFeedbackTypeValues, clientFeedbackTypeDropdownValues, "Admin and client both are values are different");
        System.out.println("admin and client Feedback type column matches");
    }

    @When("User click on the Notification tab under general settings menu")
    public void userClickOnTheNotificationTabUnderGeneralSettingsMenu() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        //crmPage.clickOnListOfOptionOfHamburger();
        crmPage.clickOnHamburgerMenu();
        crmPage.clickOnCRMTickets();
        crmPage.clickOnNotificationTab();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectCompany();
        adminHomePage.CloseHamburger();
    }

    @And("User click on the Add Notification button and under that click on status dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnStatusDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }
    @Then("User should see the following Status values in add notification dropdown:")
    public void userShouldSeeTheFollowingStatusValuesInAddNotificationDropdown(List<String> expectedStatusValues) throws InterruptedException {
        List<String> actualStatusValues = crmPage.getStatusNotyDropdownValues();
        Assert.assertEquals(expectedStatusValues, actualStatusValues, "status dropdown not match with configuration");
    }

    @And("click on cancel button from Add notification pop up")
    public void clickOnCancelButtonFromAddNotificationPopUp() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnCancelBtn();
    }
    @When("User click on the Configuration tab and click on status option")
    public void userClickOnTheConfigurationTabAndClickOnStatusOption() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnStatusTab();
    }
    @Then("User should see the following Status values:")
    public void userShouldSeeTheFollowingStatusValues(List<String> expectedStatusValues) {
        List<String> actualStatusValues = crmPage.getStatusValues();
        Assert.assertEquals(expectedStatusValues, actualStatusValues, "not match type values");
    }

    @Then("The displayed status values should match the Admin add notification pop up dropdown values")
    public void theDisplayedStatusValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigStatusValues = crmPage.getStatusValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyStatusDropdownValues = crmPage.getStatusNotyDropdownValues();
        Assert.assertEquals(ConfigStatusValues, NotyStatusDropdownValues, "configuration and notification both values are different");
        System.out.println(" Status configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on Source dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnSourceDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @Then("User should see the following Source values in add notification dropdown:")
    public void userShouldSeeTheFollowingSourceValuesInAddNotificationDropdown(List<String> expectedSourceValues) throws InterruptedException {
        List<String> actualSourceValues = crmPage.getSourceNotyDropdownValues();
        Assert.assertEquals(expectedSourceValues, actualSourceValues, "Source dropdown not match with configuration");
    }

    @When("User click on the Configuration tab and click on Source option")
    public void userClickOnTheConfigurationTabAndClickOnSourceOption() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnSourceTab();
    }

    @Then("User should see the following Source values:")
    public void userShouldSeeTheFollowingSourceValues(List<String> expectedSourceValues) {
        List<String> actualSourceValues = crmPage.getSourceValues();
        Assert.assertEquals(expectedSourceValues, actualSourceValues, "not match type values");
    }

    @Then("The displayed Source values should match the Admin add notification pop up dropdown values")
    public void theDisplayedSourceValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigSourceValues = crmPage.getSourceValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotySourceDropdownValues = crmPage.getSourceNotyDropdownValues();
        Assert.assertEquals(ConfigSourceValues, NotySourceDropdownValues, "configuration and notification both values are different");
        System.out.println(" Source configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on Priority dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnPriorityDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @Then("User should see the following Priority values in add notification dropdown:")
    public void userShouldSeeTheFollowingPriorityValuesInAddNotificationDropdown(List<String> expectedPriorityValues) throws InterruptedException {
        List<String> actualPriorityValues = crmPage.getPriorityNotyDropdownValues();
        Assert.assertEquals(expectedPriorityValues, actualPriorityValues, "Priority dropdown not match with configuration");
    }

    @When("User click on the Configuration tab and click on Priority option")
    public void userClickOnTheConfigurationTabAndClickOnPriorityOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnPriorityOption();
    }

    /*@Then("User should see the following Priority values:")
    public void userShouldSeeTheFollowingPriorityValues(List<String> expectedPriorityValues) {
        List<String> actualPriorityValues = crmPage.getPriorityValues();
        Assert.assertEquals(expectedPriorityValues, actualPriorityValues, "not match type values");
    }*/

    @Then("The displayed Priority values should match the Admin add notification pop up dropdown values")
    public void theDisplayedPriorityValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigPriorityValues = crmPage.getPriorityValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyPriorityDropdownValues = crmPage.getPriorityNotyDropdownValues();
        Assert.assertEquals(ConfigPriorityValues, NotyPriorityDropdownValues, "configuration and notification both values are different");
        System.out.println(" Priority configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on Type dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnTypeDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @Then("User should see the following Type values in add notification dropdown:")
    public void userShouldSeeTheFollowingTypeValuesInAddNotificationDropdown(List<String> expectedTypeValues) throws InterruptedException {
        List<String> actualTypeValues = crmPage.getTypeNotyDropdownValues();
        Assert.assertEquals(expectedTypeValues, actualTypeValues, "Type dropdown not match with configuration");
    }

    @When("User click on the Configuration tab and click on Type option")
    public void userClickOnTheConfigurationTabAndClickOnTypeOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnTypeOption();
    }

    /*@Then("User should see the following Type values:")
    public void userShouldSeeTheFollowingTypeValues() {

    }*/

    @Then("The displayed Type values should match the Admin add notification pop up dropdown values")
    public void theDisplayedTypeValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigTypeValues = crmPage.getModuleValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyTypeDropdownValues = crmPage.getTypeNotyDropdownValues();
        Assert.assertEquals(ConfigTypeValues, NotyTypeDropdownValues, "configuration and notification both values are different");
        System.out.println(" Type configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on Application dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnApplicationDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @When("User click on the Configuration tab and click on Module option")
    public void userClickOnTheConfigurationTabAndClickOnModuleOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnModuleOption();
    }

    @Then("User should see the following Application values in add notification dropdown:")
    public void userShouldSeeTheFollowingApplicationValuesInAddNotificationDropdown(List<String> expectedApplicationValues) throws InterruptedException {
        List<String> actualApplicationValues = crmPage.getAppNotyDropdownValues();
        Assert.assertEquals(expectedApplicationValues, actualApplicationValues, "Application dropdown not match with configuration");
    }

    @Then("The displayed Application values should match the Admin add notification pop up dropdown values")
    public void theDisplayedApplicationValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigApplicationValues = crmPage.getModuleValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyAppDropdownValues = crmPage.getAppNotyDropdownValues();
        Assert.assertEquals(ConfigApplicationValues, NotyAppDropdownValues, "configuration and notification both values are different");
        System.out.println(" Application configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on Reason dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnReasonDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @Then("User should see the following Reason values in add notification dropdown:")
    public void userShouldSeeTheFollowingReasonValuesInAddNotificationDropdown(List<String> expectedReasonValues) throws InterruptedException {
        List<String> actualReasonValues = crmPage.getReasonNotyDropdownValues();
        Assert.assertEquals(expectedReasonValues, actualReasonValues, "Reason dropdown not match with configuration");
    }

    @When("User click on the Configuration tab and click on Reason option")
    public void userClickOnTheConfigurationTabAndClickOnReasonOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnReasonOption();
    }

    @Then("The displayed Reason values should match the Admin add notification pop up dropdown values")
    public void theDisplayedReasonValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigReasonValues = crmPage.getReasonValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyReasonDropdownValues = crmPage.getReasonNotyDropdownValues();
        Assert.assertEquals(ConfigReasonValues, NotyReasonDropdownValues, "configuration and notification both values are different");
        System.out.println(" Reason configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on Category dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnCategoryDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @Then("User should see the following Category values in add notification dropdown:")
    public void userShouldSeeTheFollowingCategoryValuesInAddNotificationDropdown(List<String> expectedCategoryValues) throws InterruptedException {
        List<String> actualCategoryValues = crmPage.getCategoryNotyDropdownValues();
        Assert.assertEquals(expectedCategoryValues, actualCategoryValues, "Reason dropdown not match with configuration");
    }

    @When("User click on the Configuration tab and click on Category option")
    public void userClickOnTheConfigurationTabAndClickOnCategoryOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnCategoryOption();
    }

    @Then("The displayed Category values should match the Admin add notification pop up dropdown values")
    public void theDisplayedCategoryValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigCategoryValues = crmPage.getCategoryValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyCategoryDropdownValues = crmPage.getCategoryNotyDropdownValues();
        Assert.assertEquals(ConfigCategoryValues, NotyCategoryDropdownValues, "configuration and notification both values are different");
        System.out.println(" Category configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on Action dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnActionDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @Then("User should see the following Action values in add notification dropdown:")
    public void userShouldSeeTheFollowingActionValuesInAddNotificationDropdown(List<String> expectedActionValues) throws InterruptedException {
        List<String> actualActionValues = crmPage.getActionNotyDropdownValues();
        Assert.assertEquals(expectedActionValues, actualActionValues, "Action dropdown not match with configuration");
    }

    @When("User click on the Configuration tab and click on Action option")
    public void userClickOnTheConfigurationTabAndClickOnActionOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnActionOption();
    }

    @Then("The displayed Action values should match the Admin add notification pop up dropdown values")
    public void theDisplayedActionValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigActionValues = crmPage.getActionValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyActionDropdownValues = crmPage.getActionNotyDropdownValues();
        Assert.assertEquals(ConfigActionValues, NotyActionDropdownValues, "configuration and notification both values are different");
        System.out.println(" Action configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on Feedback dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnFeedbackDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @Then("User should see the following Feedback values in add notification dropdown:")
    public void userShouldSeeTheFollowingFeedbackValuesInAddNotificationDropdown(List<String> expectedFeedbackValues) throws InterruptedException {
        List<String> actualFeedbackValues = crmPage.getFeedbackNotyDropdownValues();
        Assert.assertEquals(expectedFeedbackValues, actualFeedbackValues, "Reason dropdown not match with configuration");
    }

    @When("User click on the Configuration tab and click on Feedback option")
    public void userClickOnTheConfigurationTabAndClickOnFeedbackOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnFeedbackOption();
    }

    @Then("The displayed Feedback values should match the Admin add notification pop up dropdown values")
    public void theDisplayedFeedbackValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigFeedbackValues = crmPage.getFeedbackValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyFeedbackDropdownValues = crmPage.getFeedbackNotyDropdownValues();
        Assert.assertEquals(ConfigFeedbackValues, NotyFeedbackDropdownValues, "configuration and notification both values are different");
        System.out.println(" Feedback configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }

    @And("User click on the Add Notification button and under that click on FeedbackType dropdown")
    public void userClickOnTheAddNotificationButtonAndUnderThatClickOnFeedbackTypeDropdown() {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnAddNotificationBtn();
    }

    @Then("User should see the following FeedbackType values in add notification dropdown:")
    public void userShouldSeeTheFollowingFeedbackTypeValuesInAddNotificationDropdown(List<String> expectedFeedbackValues) throws InterruptedException {
        List<String> actualFeedbackValues = crmPage.getFeedbackTypeNotyDropdownValues();
        Assert.assertEquals(expectedFeedbackValues, actualFeedbackValues, "Reason dropdown not match with configuration");
    }

    @When("User click on the Configuration tab and click on FeedbackType option")
    public void userClickOnTheConfigurationTabAndClickOnFeedbackTypeOption() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnConfigurationTab();
        crmPage.clickOnFeedbackTypeOption();
    }

    @Then("The displayed FeedbackType values should match the Admin add notification pop up dropdown values")
    public void theDisplayedFeedbackTypeValuesShouldMatchTheAdminAddNotificationPopUpDropdownValues() {
        crmPage=new CRMPage(driver,scenario);
        List<String> ConfigFeedbackTypeValues = crmPage.getFeedbackTypeValues();
        crmPage.clickOnNotificationTab();
        crmPage.clickOnAddNotificationBtn();
        List<String> NotyFeedbackTypeDropdownValues = crmPage.getFeedbackTypeNotyDropdownValues();
        Assert.assertEquals(ConfigFeedbackTypeValues, NotyFeedbackTypeDropdownValues, "configuration and notification both values are different");
        System.out.println(" Feedback configuration and notification column matches");
        crmPage.clickOnCancelBtn();
    }
}
