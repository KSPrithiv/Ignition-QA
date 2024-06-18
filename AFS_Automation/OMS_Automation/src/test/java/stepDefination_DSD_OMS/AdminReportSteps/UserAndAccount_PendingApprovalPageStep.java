package stepDefination_DSD_OMS.AdminReportSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminReport.orderAdminPage;
import pages_DSD_OMS.adminReport.userAndAdmin_PendingRegApprovalPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class UserAndAccount_PendingApprovalPageStep
{
        /* Created by Divya.Ramadas@afsi.com */
        WebDriver driver;
        Scenario scenario;
        static userAndAdmin_PendingRegApprovalPage  userAndAdminPendingRegApprovalPage;
        static orderAdminPage orderadminPage;
        static AdminHomePage adminHomePage;

        @Before
        public void LaunchBrowser1(Scenario scenario) throws Exception
        {
            this.scenario=scenario;
            TestBase driver1=TestBase.getInstanceOfDriver();
            driver= driver1.getDriver();
        }

    @And("User selects user name from Pending registration drop down and click on Deny button")
    public void userSelectsUserNameFromPendingRegistrationDropDownAndClickOnDenyButton() throws InterruptedException
    {
        userAndAdminPendingRegApprovalPage=new userAndAdmin_PendingRegApprovalPage(driver,scenario);
        userAndAdminPendingRegApprovalPage.clickOnPendingRegDropDown();
        userAndAdminPendingRegApprovalPage.selectUserPendingReg();
        userAndAdminPendingRegApprovalPage.clickOnDeny();
        userAndAdminPendingRegApprovalPage.pendingReg();
        userAndAdminPendingRegApprovalPage.confirmDelete();
        userAndAdminPendingRegApprovalPage.clickOnPendingRegDropDown();
        userAndAdminPendingRegApprovalPage.findNotExistanceOfPendingRegistration();
    }

    @And("User selects user name from Pending registration drop down and click on Approve button")
    public void userSelectsUserNameFromPendingRegistrationDropDownAndClickOnApproveButton() throws InterruptedException
    {
        userAndAdminPendingRegApprovalPage=new userAndAdmin_PendingRegApprovalPage(driver,scenario);
        userAndAdminPendingRegApprovalPage.clickOnPendingRegDropDown();
        userAndAdminPendingRegApprovalPage.selectUserPendingReg();
        userAndAdminPendingRegApprovalPage.clickOnConfirm();
        userAndAdminPendingRegApprovalPage.pendingReg();
        userAndAdminPendingRegApprovalPage.updateUserInfo();
        userAndAdminPendingRegApprovalPage.clickOnPendingRegDropDown();
        userAndAdminPendingRegApprovalPage.findNotExistanceOfPendingRegistration();
    }

    @Then("User selects {string} in Orders page in admin login and validate user is in selected Tab for pending registration")
    public void userSelectsInOrdersPageInAdminLoginAndValidateUserIsInSelectedTabForPendingRegistration(String navigateTab)
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.navigateToDifferentTabsInOrder(navigateTab);
        userAndAdminPendingRegApprovalPage=new userAndAdmin_PendingRegApprovalPage(driver,scenario);
        userAndAdminPendingRegApprovalPage.validateTabNavigatedTo(navigateTab);
    }

    @Then("User refreshes page for user and account")
    public void userRefreshesPageForUserAndAccount()
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.handleError_Page();
        adminHomePage.refreshPage();
    }
}
