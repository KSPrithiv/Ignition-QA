package stepDefination_DSD_OMS.AdminReportSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminReport.orderAdminPage;
import pages_DSD_OMS.adminReport.userAndAdmin_AddNewUserPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class UserAndAccount_AddNewUserPageStep
{
        /* Created by Divya.Ramadas@afsi.com */
        WebDriver driver;
        Scenario scenario;
        static AdminHomePage adminHomePage;
        static orderAdminPage orderadminPage;
        static userAndAdmin_AddNewUserPage userandAdminPage;

        @Before
        public void LaunchBrowser1(Scenario scenario) throws Exception
        {
            this.scenario=scenario;
            TestBase driver1=TestBase.getInstanceOfDriver();
            driver= driver1.getDriver();
        }

    @And("User should enable All customer toggle button and enter all the required fields, role to be selected {string} and {string}")
    public void userShouldEnableAllCustomerToggleButtonAndEnterAllTheRequiredFieldsRoleToBeSelectedAnd(String filter, String filterDesc)
    {
        userandAdminPage=new userAndAdmin_AddNewUserPage(driver,scenario);
        userandAdminPage.allCustomerAccountToggleButton();
        userandAdminPage.handleConfirmationPopupForAllCustomersToggle();
        userandAdminPage.enterFirstName();
        userandAdminPage.enterLastName();
        userandAdminPage.enterUserName();
        userandAdminPage.enterNewEmail();
        userandAdminPage.enterConfirmEmail();
        userandAdminPage.passwordInputBox();
        userandAdminPage.passwordConfirmationInputBox();
        userandAdminPage.rolesButtonClick();
        userandAdminPage.rolesIndexPopup(filter,filterDesc);
    }

    @And("User enters Account number and enter all the required fields, role to be selected {string} and {string}")
    public void userEntersAccountNumberAndEnterAllTheRequiredFieldsRoleToBeSelectedAnd(String filter, String filterDesc)
    {
        userandAdminPage=new userAndAdmin_AddNewUserPage(driver,scenario);
        userandAdminPage.enterAccountNumber();
        userandAdminPage.enterFirstName();
        userandAdminPage.enterLastName();
        userandAdminPage.enterUserName();
        userandAdminPage.enterNewEmail();
        userandAdminPage.enterConfirmEmail();
        userandAdminPage.passwordInputBox();
        userandAdminPage.passwordConfirmationInputBox();
        userandAdminPage.rolesButtonClick();
        userandAdminPage.rolesIndexPopup(filter,filterDesc);
    }

    @And("User enters Account number and enter all the required fields, role to be selected {string} and {string} with default email")
    public void userEntersAccountNumberAndEnterAllTheRequiredFieldsRoleToBeSelectedAndWithDefaultEmail(String filter, String filterDesc)
    {
        userandAdminPage=new userAndAdmin_AddNewUserPage(driver,scenario);
        userandAdminPage.allCustomerAccountToggleButton();
        userandAdminPage.enterFirstName();
        userandAdminPage.enterLastName();
        userandAdminPage.enterUserName();
        userandAdminPage.emailDefaultToggle();
        userandAdminPage.readDefaultEmailInputBox();
        userandAdminPage.readConfirmDefaultEmailInputBox();
        userandAdminPage.passwordInputBox();
        userandAdminPage.passwordConfirmationInputBox();
        userandAdminPage.rolesButtonClick();
        userandAdminPage.rolesIndexPopup(filter,filterDesc);
    }


}
