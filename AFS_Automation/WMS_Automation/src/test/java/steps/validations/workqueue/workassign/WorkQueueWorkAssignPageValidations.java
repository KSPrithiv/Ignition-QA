package steps.validations.workqueue.workassign;

import common.enums.TaskGroupOption;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.workqueue.workassign.WorkQueueWorkAssignPage;

public class WorkQueueWorkAssignPageValidations {
    WorkQueueWorkAssignPage workQueueWorkAssignPage = new WorkQueueWorkAssignPage();

    @And("Validates Assign work screen is displayed on Work Queue Work Assign Page")
    public void validateWorkQueueAssignWorkPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueWorkAssignPage.isSaveEditButtonDisplayed(), "User Header is not present");
        softAssert.assertTrue(workQueueWorkAssignPage.isCancelEditButtonDisplayed(), "User Group Header is not present");
        softAssert.assertTrue(workQueueWorkAssignPage.isTaskGroupDropdownDisplayed(), "Task Group Dropdown is not present");
        softAssert.assertAll();
    }

    @And("Validates Loading Task Group is displayed on Work Queue Work Assign Page")
    public void validateLoadingTaskGroup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueWorkAssignPage.getTaskGroupDropdownValue(TaskGroupOption.LOADING.getTaskGroup())
                .getText().trim().equals(TaskGroupOption.LOADING.getTaskGroup()), "Task Group correct value is not present");
        softAssert.assertAll();
    }

    @And("Validates Shipping Task Group is displayed on Work Queue Work Assign Page")
    public void validateShippingTaskGroup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueWorkAssignPage.getTaskGroupDropdownValue(TaskGroupOption.SHIPPING.getTaskGroup())
                .getText().trim().equals(TaskGroupOption.SHIPPING.getTaskGroup()), "Task Group correct value is not present");
        softAssert.assertAll();
    }

    @And("Validates list of users and user groups is displayed on Work Queue Work Assign Page")
    public void validateWorkQueueListOfUsersDisplay() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueWorkAssignPage.isWmUserHeaderDisplayed(), "User Header is not present");
        softAssert.assertTrue(workQueueWorkAssignPage.isWmUserGrpHeaderDisplayed(), "User Group Header is not present");
        softAssert.assertTrue(workQueueWorkAssignPage.getWqUserFormDivUserList().size() > 0, "Edit Button is not present");
        softAssert.assertTrue(workQueueWorkAssignPage.getWqUserFormDivUserGroupList().size() > 0, "Delete Button is not present");
        softAssert.assertAll();
    }

    @And("Validates list of users and user groups is not displayed on Work Queue Work Assign Page")
    public void validateWorkQueueListOfUsersNotDisplay() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(workQueueWorkAssignPage.isWmUserHeaderDisplayed(), "User Header is not present");
        softAssert.assertFalse(workQueueWorkAssignPage.isWmUserGrpHeaderDisplayed(), "User Group Header is not present");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Work Queue Work Assign Page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(workQueueWorkAssignPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }
}
