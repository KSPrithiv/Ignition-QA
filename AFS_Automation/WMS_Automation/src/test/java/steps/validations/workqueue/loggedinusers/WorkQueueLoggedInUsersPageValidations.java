package steps.validations.workqueue.loggedinusers;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.workqueue.loggedinusers.WorkQueueLoggedInUsersPage;

import java.util.Arrays;

public class WorkQueueLoggedInUsersPageValidations {
    WorkQueueLoggedInUsersPage workQueueLoggedInUsersPage = new WorkQueueLoggedInUsersPage();

    @And("Validates User Logged In title is displayed on Work Queue Logged In Users page")
    public void validateUserLoggedInIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueLoggedInUsersPage.isLoggedInTitleDisplayed(), "User Logged In title is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isLogOutUserLabelDisplayed(), "LogOut User Label is not present");
        softAssert.assertAll();
    }

    @And("Validates currently logged in users are displayed on Work Queue Logged In Users page")
    public void validateLoggedInUsersDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueLoggedInUsersPage.getLoggedInUsersTableRowsSize() > 0, "Currently logged in users are not present");
        softAssert.assertAll();
    }

    @And("Validates table columns are displayed on Work Queue Logged In Users page")
    public void validateLoginLogoutUserIdUsernameDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueLoggedInUsersPage.isUserIdColumnDisplayed(), "User Id Column is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isUserNameColumnDisplayed(), "User Name Column is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isComputerColumnDisplayed(), "Computer Column is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isEquipmentColumnDisplayed(), "Equipment Column is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isPrinterColumnDisplayed(), "Printer Column is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isLoginDateColumnDisplayed(), "Login Date Column is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isBreakDateColumnDisplayed(), "Break Date Column is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isLaborCodeColumnDisplayed(), "Labor Code Column is not present");
        softAssert.assertAll();
    }

    @And("Validates Grid items are present on Work Queue Logged In Users page")
    public void validateGridItemsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueLoggedInUsersPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!workQueueLoggedInUsersPage.getItemsFoundText().equals("0"),"Items Found is 0");
       softAssert.assertAll();
    }

    @And("Validates Table End is displayed on Work Queue Logged In Users page")
    public void validateTableEndPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueLoggedInUsersPage.isTableEndIsDisplayed(),"Table End is not displayed");
        softAssert.assertAll();
    }

    @And("Validates filters are displayed on Work Queue Logged In Users page")
    public void validateFiltersCheckboxesDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueLoggedInUsersPage.isUserIdFilterDisplayed(), "User Id Filter is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isUserNameFilterDisplayed(), "User Name Column is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isComputerFilterDisplayed(), "Computer Filter is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isEquipmentFilterDisplayed(), "Equipment Filter is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isPrinterCodeFilterDisplayed(), "Printer Filter is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isLoginDateTimeFilterDisplayed(), "Login Date Filter is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isBreakDateTimeFilterDisplayed(), "Break Date Filter is not present");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isLaborCodeFilterDisplayed(), "Labor Code Filter is not present");
        softAssert.assertAll();
    }

    @And("Validates User Id Column Sorting Result on Work Queue Logged In Users page")
    public void validateUserIdColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueLoggedInUsersPage
                .getUserIdColumnHeaderSortingResult()),"User Id Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates User Name Column Sorting Result on Work Queue Logged In Users page")
    public void validateUserNameColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueLoggedInUsersPage
                .getUserNameColumnHeaderSortingResult()),"User Name Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Computer Column Sorting Result on Work Queue Logged In Users page")
    public void validateComputerColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueLoggedInUsersPage
                .getComputerColumnHeaderSortingResult()),"Computer Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Equipment Column Sorting Result on Work Queue Logged In Users page")
    public void validateEquipmentColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueLoggedInUsersPage
                .getEquipmentColumnHeaderSortingResult()),"Equipment Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Printer Column Sorting Result on Work Queue Logged In Users page")
    public void validatePrinterColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueLoggedInUsersPage
                .getPrinterColumnHeaderSortingResult()),"Printer Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Login Date Column Sorting Result on Work Queue Logged In Users page")
    public void validateLoginDateColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueLoggedInUsersPage
                .getLoginDateColumnHeaderSortingResult()),"Login Date Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Break Date Column Sorting Result on Work Queue Logged In Users page")
    public void validateBreakDateColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueLoggedInUsersPage
                .getBreakDateColumnHeaderSortingResult()),"Break Date Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Labor Code Column Sorting Result on Work Queue Logged In Users page")
    public void validateLaborCodeColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueLoggedInUsersPage
                .getLaborCodeColumnHeaderSortingResult()),"Labor Code Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Work Queue Logged In Users page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(workQueueLoggedInUsersPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Logout User label is enabled on Work Queue Logged In Users page")
    public void verifyLogoutUserLabelEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(workQueueLoggedInUsersPage.isLogOutUserLabelDisabled(),"Logout User label is enabled");
        softAssert.assertAll();
    }

    @And("Validates Logout User label is disabled on Work Queue Logged In Users page")
    public void verifyLogoutUserLabelDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueLoggedInUsersPage.isLogOutUserLabelDisabled(),"Logout User label is disabled");
        softAssert.assertAll();
    }

    @And("Validates OK and Cancel buttons are present on Work Queue Logged In Users page")
    public void verifyOkAndCancelButtonsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueLoggedInUsersPage.isOKButtonDisplayed(),"OK Button is not displayed");
        softAssert.assertTrue(workQueueLoggedInUsersPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates OK and Cancel buttons are not present on Work Queue Logged In Users page")
    public void verifyOkAndCancelButtonsAreNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(workQueueLoggedInUsersPage.isOKButtonDisplayed(),"OK Button is displayed");
        softAssert.assertFalse(workQueueLoggedInUsersPage.isCancelButtonDisplayed(),"Cancel Button is displayed");
        softAssert.assertAll();
    }

}
