package steps.validations.workqueue.filteroption;

import common.constants.TimeFormats;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.workqueue.assignmentlist.filteroption.WorkQueueAssignmentsPage;

import java.util.Arrays;

public class WorkQueueAssignmentsPageValidations {
    WorkQueueAssignmentsPage workQueueAssignmentsPage = new WorkQueueAssignmentsPage();
    SoftAssert softAssert = new SoftAssert();

    @And("Work Queue Assignments Page is validated")
    public void validateWorkQueueAssignmentsPage() {
        softAssert.assertTrue(workQueueAssignmentsPage.isAssignmentsTitleDisplayed(), "Assignments Title is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isEditAssignmentBtnDisplayed(), "Edit Assignment is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isReleaseAssignmentBtnDisplayed(), "Release Assignment is not visible");
        softAssert.assertTrue(workQueueAssignmentsPage.isPrintAssignmentBtnDisplayed(), "Print Assignment is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isMoveAssignmentBtnDisplayed(), "Move Assignment is not visible");
        softAssert.assertAll();
    }

    @And("Validates Grid items are present on Work Queue Assignments page")
    public void validateGridItemsPresent() {
        softAssert.assertTrue(workQueueAssignmentsPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!workQueueAssignmentsPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates Grid items are not present on Work Queue Assignments page")
    public void validateGridItemsNotPresent() {
        softAssert.assertTrue(workQueueAssignmentsPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.getItemsFoundText().equals("0"),"Items Found is not equal 0");
        softAssert.assertAll();
    }

    @And("Validates Edit Assignment popup items are present on Work Queue Assignments page")
    public void validateEditAssignmentPopupItemsPresent() {
        softAssert.assertTrue(workQueueAssignmentsPage.isEditAssignmentTypeDisplayed(),"Edit Assignment Type is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isEditAssignmentTaskGroupDisplayed(),"Edit Assignment Task Group is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isEditAssignmentDateDisplayed(),"Edit Assignment Date is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isEditAssignmentTimeDisplayed(),"Edit Assignment Time is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isEditAssignmentUsersDisplayed(),"Edit Assignment Users is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isEditAssignmentCompleteDisplayed(),"Edit Assignment Complete checkbox is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isSaveButtonDisplayed(),"Save Button is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignment popup Cancel and OK buttons are present on Work Queue Assignments page")
    public void validateAssignmentPopupButtonsPresent() {
        softAssert.assertTrue(workQueueAssignmentsPage.isOkButtonDisplayed(),"OK Button is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignment popup Cancel and Save buttons are present on Work Queue Assignments page")
    public void validateAssignmentPopupButtons() {
        softAssert.assertTrue(workQueueAssignmentsPage.isSaveButtonDisplayed(),"Save Button is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Release Assignment elements are present on Work Queue Assignments page")
    public void validateReleaseAssignmentPopup() {
        softAssert.assertTrue(workQueueAssignmentsPage.isReleaseLabelDisplayed(),"Release Label is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isReleaseDateDisplayed(),"Release Date is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isReleaseTimeDisplayed(),"Release Time is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isAssignLabelDisplayed(),"Assign Label is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isReleaseUsersLabelDisplayed(),"Release Users Label is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isEditAssignmentUsersDisplayed(),"Edit Assignment Users is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Successful message {string} on Work Queue Assignments page")
    public void validateSuccessfulNotification(String message) {
        softAssert.assertEquals(workQueueAssignmentsPage.getNotificationMessageText(), message,
                "Notification Message is not correct");
        softAssert.assertAll();
    }

    @And("Validates current date and time for Edit Assignment on Work Queue Assignments page")
    public void validateCurrentDateAndTime() {
        softAssert.assertEquals(workQueueAssignmentsPage.getEditAssignmentDateValue(), TimeConversion
                        .getFormattedCurrentDate(TimeFormats.format_MMddyyyy),
                "Current date for Edit Assignment is not correct");
        softAssert.assertTrue(TimeConversion.getFormattedTime(TimeFormats.format_hhmmA).contains(workQueueAssignmentsPage
                        .getEditAssignmentTimeValue()),"Current time for Edit Assignment is not correct");
        softAssert.assertAll();
    }

    @And("Validates {string} message content on dialog popup on Work Queue Assignments page")
    public void validateWarningMessage(String message) {
        softAssert.assertEquals(workQueueAssignmentsPage.getDialogTextContentText(), message, "Warning Message is not correct");
        softAssert.assertAll();
    }

    @And("Validates current date and time for Release Assignment on Work Queue Assignments page")
    public void validateReleaseDateAndTime() {
        softAssert.assertEquals(workQueueAssignmentsPage.getReleaseDateValue(), TimeConversion
                        .getFormattedCurrentDate(TimeFormats.format_MMddyyyy),
                "Current date for Edit Assignment is not correct");
        softAssert.assertTrue(TimeConversion.getFormattedTime(TimeFormats.format_hhmmA).contains(workQueueAssignmentsPage
                .getReleaseTimeValue()),"Current time for Edit Assignment is not correct");
        softAssert.assertAll();
    }

    @And("Validates empty date and time for Release Assignment on Work Queue Assignments page")
    public void validateEmptyDateAndTime() {
        softAssert.assertTrue(workQueueAssignmentsPage.getReleaseDateValue().equals(""),"Release Date is not empty");
        softAssert.assertTrue(workQueueAssignmentsPage.getReleaseTimeValue().equals("hour:minute AM"),"Release Time is not empty");
        softAssert.assertAll();
    }

    @And("Validates Assignment details on Work Queue Assignments page")
    public void validateAssignmentDetails() {
        softAssert.assertTrue(workQueueAssignmentsPage.isEditTaskButtonDisplayed(),"Edit Task Button is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isDeleteAssignmentButtonDisplayed(),"Delete Assignment Button is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isAssignmentsTabDisplayed(),"Assignments Tab is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isLaborEstimateTabDisplayed(),"Labor Estimate Tab is not displayed");
        softAssert.assertTrue(workQueueAssignmentsPage.isLaborActualTabDisplayed(),"Labor Actual Tab is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignment Number Column Sorting Result on Work Queue Assignments page")
    public void validateAssignmentNumberColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getAssignmentNumberColumnHeaderSortingResult()),"Assignment Number Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Route Column Sorting Result on Work Queue Assignments page")
    public void validateRouteColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getRouteColumnHeaderSortingResult()),"Route Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Stops Column Sorting Result on Work Queue Assignments page")
    public void validateStopsColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getStopsColumnHeaderSortingResult()),"Stops Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Shipper Column Sorting Result on Work Queue Assignments page")
    public void validateShipperColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getShipperColumnHeaderSortingResult()),"Shipper Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Ship To Column Sorting Result on Work Queue Assignments page")
    public void validateShipToColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getShipToColumnHeaderSortingResult()),"Ship To Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Tasks Column Sorting Result on Work Queue Assignments page")
    public void validateTasksColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getTasksColumnHeaderSortingResult()),"Tasks Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Assign To Column Sorting Result on Work Queue Assignments page")
    public void validateAssignToColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getAssignToColumnHeaderSortingResult()),"Assign To Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Released Column Sorting Result on Work Queue Assignments page")
    public void validateReleasedColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getReleasedColumnHeaderSortingResult()),"Released Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Qty Column Sorting Result on Work Queue Assignments page")
    public void validateQtyColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getQtyColumnHeaderSortingResult()),"Qty Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Cube Column Sorting Result on Work Queue Assignments page")
    public void validateCubeColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getCubeColumnHeaderSortingResult()),"Cube Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Weight Column Sorting Result on Work Queue Assignments page")
    public void validateWeightColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getWeightColumnHeaderSortingResult()),"Weight Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Assignment Type Column Sorting Result on Work Queue Assignments page")
    public void validateAssignmentTypeColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getAssignmentTypeColumnHeaderSortingResult()),"Assignment Type Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Task Group Column Sorting Result on Work Queue Assignments page")
    public void validateTaskGroupColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getTaskGroupColumnHeaderSortingResult()),"Task Group Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Picked Column Sorting Result on Work Queue Assignments page")
    public void validatePickedColumnHeaderSortingResult() {
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(workQueueAssignmentsPage
                .getPickedColumnHeaderSortingResult()),"Picked Column does not contain Sorting Result");
        softAssert.assertAll();
    }

}
