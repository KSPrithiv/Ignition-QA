package steps.validations.workqueue.task;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.workqueue.task.WorkQueueTaskPage;

public class WorkQueueTaskPageValidations {
    WorkQueueTaskPage workQueueTaskPage = new WorkQueueTaskPage();

    @And("Validates Work Queue Task page is displayed")
    public void validateWorkQueueTaskPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueTaskPage.isTaskListTitleDisplayed(), "Task List Title is not present");
        softAssert.assertTrue(workQueueTaskPage.isAddFilterButtonDisplayed(), "Add Filter Button is not present");
        softAssert.assertTrue(workQueueTaskPage.isEditButtonDisplayed(), "Edit Button is not present");
        softAssert.assertTrue(workQueueTaskPage.isDeleteButtonDisplayed(), "Delete Button is not present");
        softAssert.assertTrue(workQueueTaskPage.isTopOffTaskButtonDisplayed(), "TopOff Task Button is not present");
        softAssert.assertTrue(workQueueTaskPage.isMoveTaskButtonDisplayed(), "Move Task Button is not present");
        softAssert.assertTrue(workQueueTaskPage.isReprocessTaskButtonDisplayed(), "Reprocess Task Button is not present");
        softAssert.assertTrue(workQueueTaskPage.isSearchInputWorkQueueTaskDisplayed(), "Search Field is not present");
        softAssert.assertAll();
    }

    @And("Validates Search Field in right top corner of the grid is displayed on Work Queue Task page")
    public void validateSearchFieldOnGridIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueTaskPage.isSearchInputWorkQueueTaskDisplayed(), "Search Field is not present");
        softAssert.assertAll();
    }

    @And("Validates Searchable items are displayed as Tool tip on Work Queue Task page")
    public void validateSearchableItemsAsToolTipDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueTaskPage.isWorkQueueTasksToolTipDisplayed(), "Searchable items as Tool tip are not present");
        softAssert.assertAll();
    }

    @And("Validates Grid items are present on Work Queue Task page")
    public void validateGridItemsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueTaskPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!workQueueTaskPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates Items Selected are present on Work Queue Task page")
    public void validateGridItemsSelected() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueTaskPage.isTasksSelectedItemsFoundDisplayed(),"Selected Items Label is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isTasksSelectedCountNumberDisplayed(),"Selected Items Value is not displayed");
        softAssert.assertTrue(!workQueueTaskPage.getSelectedItemsFoundNumber().equals("0"),"Selected Items is 0");
        softAssert.assertAll();
    }

    @And("Validates Items Selected are not present on Work Queue Task page")
    public void validateGridItemsSelectedNotSelected() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(workQueueTaskPage.isTasksSelectedItemsFoundDisplayed(),"Selected Items Label is displayed");
        softAssert.assertFalse(workQueueTaskPage.isTasksSelectedCountNumberDisplayed(),"Selected Items Value is displayed");
        softAssert.assertAll();
    }

    @And("Validates Add Filter options are present on Work Queue Task page")
    public void validateAddFilterOptionsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(workQueueTaskPage.isProductFilterDisplayed(),"Product Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isStrQtyFilterDisplayed(),"Qty Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isFromFilterDisplayed(),"From Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isToFilterDisplayed(),"To Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isTypeFilterDisplayed(),"Type Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isTaskGroupFilterDisplayed(),"Task Group Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isStatusFilterDisplayed(),"Status Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isAssignmentNumberFilterDisplayed(),"Assignment Num Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isPriorityFilterDisplayed(),"Priority Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isRouteFilterDisplayed(),"Route Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isStopFilterDisplayed(),"Stop Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isShipperFilterDisplayed(),"Shipper Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isVelocityFilterDisplayed(),"Velocity Filter is not displayed");
        softAssert.assertTrue(workQueueTaskPage.isDescriptionFilterDisplayed(),"Description Filter is not displayed");
        softAssert.assertAll();
    }

}
