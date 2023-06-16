package steps.validations.workqueue.userhistory;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.workqueue.userhistory.WorkQueueUserHistoryPage;

import java.util.Arrays;

public class WorkQueueUserHistoryPageValidations {
    WorkQueueUserHistoryPage workQueueUserHistoryPage = new WorkQueueUserHistoryPage();

    @And("Validates User history is displayed on Work Queue User History page")
    public void validateUserHistoryIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueUserHistoryPage.isUserHistoryTitleDisplayed(), "User history title is not present");
        softAssert.assertAll();
    }

    @And("Validates Login, Logout, User id and Username columns are displayed on Work Queue User History page")
    public void validateLoginLogoutUserIdUsernameDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueUserHistoryPage.isLoginColumnDisplayed(), "Login Column is not present");
        softAssert.assertTrue(workQueueUserHistoryPage.isLogoutColumnDisplayed(), "Logout Column is not present");
        softAssert.assertTrue(workQueueUserHistoryPage.isUserIdColumnDisplayed(), "UserId Column is not present");
        softAssert.assertTrue(workQueueUserHistoryPage.isUserNameColumnDisplayed(), "User Name Column is not present");
        softAssert.assertAll();
    }

    @And("Validates Grid items are present on Work Queue User History page")
    public void validateGridItemsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueUserHistoryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(workQueueUserHistoryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!workQueueUserHistoryPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates Table End is displayed on Work Queue User History page")
    public void validateTableEndPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueUserHistoryPage.isTableEndIsDisplayed(),"Table End is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Login Column Sorting Result on Work Queue User History page")
    public void validateLoginColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueUserHistoryPage
                .getLoginColumnHeaderSortingResult()),"Login Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Logout Column Sorting Result on Work Queue User History page")
    public void validateLogoutColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueUserHistoryPage
                .getLogoutColumnHeaderSortingResult()),"Logout Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates User Id Column Sorting Result on Work Queue User History page")
    public void validateUserIdColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueUserHistoryPage
                .getUserIdColumnHeaderSortingResult()),"User Id Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates User Name Column Sorting Result on Work Queue User History page")
    public void validateUserNameColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueUserHistoryPage
                .getUserNameColumnHeaderSortingResult()),"User Name Column does not contain Sorting Result");
        softAssert.assertAll();
    }

}
