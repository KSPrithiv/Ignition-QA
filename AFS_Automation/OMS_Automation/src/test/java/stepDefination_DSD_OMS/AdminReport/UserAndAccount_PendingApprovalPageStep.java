package stepDefination_DSD_OMS.AdminReport;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminReport.orderAdminPage;
import pages_DSD_OMS.adminReport.userAndAdmin_AddNewUserPage;
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
        userAndAdmin_PendingRegApprovalPage  userAndAdminPendingRegApprovalPage;

        @Before
        public void LaunchBrowser1(Scenario scenario) throws Exception
        {
            this.scenario=scenario;
            TestBase driver1=TestBase.getInstanceOfDriver();
            driver= driver1.getDriver();
        }

    @And("User selects user name from Pending registration drop down and click on Deny button")
    public void userSelectsUserNameFromPendingRegistrationDropDownAndClickOnDenyButton()
    {
        userAndAdminPendingRegApprovalPage=new userAndAdmin_PendingRegApprovalPage(driver,scenario);
        userAndAdminPendingRegApprovalPage.clickOnPendingRegDropDown();
        userAndAdminPendingRegApprovalPage.selectUserPendingReg();
        userAndAdminPendingRegApprovalPage.clickOnDeny();
        userAndAdminPendingRegApprovalPage.confirmDelete();
    }

    @And("User selects user name from Pending registration drop down and click on Approve button")
    public void userSelectsUserNameFromPendingRegistrationDropDownAndClickOnApproveButton()
    {
        userAndAdminPendingRegApprovalPage=new userAndAdmin_PendingRegApprovalPage(driver,scenario);
        userAndAdminPendingRegApprovalPage.clickOnPendingRegDropDown();
        userAndAdminPendingRegApprovalPage.selectUserPendingReg();
        userAndAdminPendingRegApprovalPage.clickOnConfirm();
        userAndAdminPendingRegApprovalPage.updateUserInfo();
    }
}
