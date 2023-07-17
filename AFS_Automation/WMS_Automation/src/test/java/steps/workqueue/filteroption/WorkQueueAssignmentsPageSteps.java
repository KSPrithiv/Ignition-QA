package steps.workqueue.filteroption;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.workqueue.assignmentlist.filteroption.WorkQueueAssignmentsPage;

@Slf4j
public class WorkQueueAssignmentsPageSteps {
    WorkQueueAssignmentsPage workQueueAssignmentsPage = new WorkQueueAssignmentsPage();

    @Step
    @And("Waits for Work Queue Assignments page to load")
    public void waitForWorkQueueAssignmentsPageToLoad() {
        log.info("Waiting for Work Queue Assignments page to load");
        workQueueAssignmentsPage.waitWorkQueueAssignmentsPageToLoad();
    }

    @Step
    @And("User clicks Assignments Title on Work Queue Assignments page")
    public void clickAssignmentsTitle() {
        log.info("User clicks Assignments Title on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentsTitle();
    }

    @Step
    @And("User clicks Add Filter on Work Queue Assignments page")
    public void clickAddFilter() {
        log.info("User clicks Add Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAddFilter();
    }

    @Step
    @And("User clicks Edit Assignment on Work Queue Assignments page")
    public void clickEditAssignment() {
        log.info("User clicks Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.clickEditAssignment();
    }

    @Step
    @And("User clicks Delete Assignment on Work Queue Assignments page")
    public void clickDeleteAssignment() {
        log.info("User clicks Delete Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.clickDeleteAssignment();
    }

    @Step
    @And("User clicks Release Assignment on Work Queue Assignments page")
    public void clickReleaseAssignment() {
        log.info("User clicks Release Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.clickReleaseAssignment();
    }

    @Step
    @And("User clicks Print Assignment on Work Queue Assignments page")
    public void clickPrintAssignment() {
        log.info("User clicks Print Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.clickPrintAssignment();
    }

    @Step
    @And("User clicks Move Assignment on Work Queue Assignments page")
    public void clickMoveAssignment() {
        log.info("User clicks Move Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.clickMoveAssignment();
    }

    @Step
    @And("User clicks Clear All on Work Queue Assignments page")
    public void clickClearAllButton() {
        log.info("User clicks Clear All on Work Queue Assignments page");
        workQueueAssignmentsPage.clickClearAllButton();
    }

    @Step
    @And("User checks Assignment number on Work Queue Assignments page")
    public void checkAssignmentCodeFilterCheckBox() {
        log.info("User checks Assignment number on Work Queue Assignments page");
        workQueueAssignmentsPage.checkAssignmentCodeFilterCheckBox();
    }

    @Step
    @And("User checks Route Filter on Work Queue Assignments page")
    public void checkRouteFilterCheckBox() {
        log.info("User checks Route Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkRouteFilterCheckBox();
    }

    @Step
    @And("User checks Stops Filter on Work Queue Assignments page")
    public void checkStopsFilterCheckBox() {
        log.info("User checks Stops Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkStopsFilterCheckBox();
    }

    @Step
    @And("User checks Shipper Filter on Work Queue Assignments page")
    public void checkShipperFilterCheckBox() {
        log.info("User checks Shipper Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkShipperFilterCheckBox();
    }

    @Step
    @And("User checks Ship To Filter on Work Queue Assignments page")
    public void checkShipToFilterCheckBox() {
        log.info("User checks Ship To Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkShipToFilterCheckBox();
    }

    @Step
    @And("User checks Tasks Filter on Work Queue Assignments page")
    public void checkTasksFilterCheckBox() {
        log.info("User checks Tasks Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkTasksFilterCheckBox();
    }

    @Step
    @And("User checks Assign To Filter on Work Queue Assignments page")
    public void checkAssignToFilterCheckBox() {
        log.info("User checks Assign To Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkAssignToFilterCheckBox();
    }

    @Step
    @And("User checks Released Filter on Work Queue Assignments page")
    public void checkReleasedFilterCheckBox() {
        log.info("User checks Released Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkReleasedFilterCheckBox();
    }

    @Step
    @And("User checks Qty Filter on Work Queue Assignments page")
    public void checkQtyFilterCheckBox() {
        log.info("User checks Qty Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkQtyFilterCheckBox();
    }

    @Step
    @And("User checks Cube Filter on Work Queue Assignments page")
    public void checkCubeFilterCheckBox() {
        log.info("User checks Cube Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkCubeFilterCheckBox();
    }

    @Step
    @And("User checks Weight Filter on Work Queue Assignments page")
    public void checkWeightFilterCheckBox() {
        log.info("User checks Weight Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkWeightFilterCheckBox();
    }

    @Step
    @And("User checks Assignment Type Filter on Work Queue Assignments page")
    public void checkAssignmentTypeFilterCheckBox() {
        log.info("User checks Assignment Type Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkAssignmentTypeFilterCheckBox();
    }

    @Step
    @And("User checks Task Group Filter on Work Queue Assignments page")
    public void checkTaskGroupFilterCheckBox() {
        log.info("User checks Task Group Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkTaskGroupFilterCheckBox();
    }

    @Step
    @And("User checks Percent Picked Filter on Work Queue Assignments page")
    public void checkPercentPickedFilterCheckBox() {
        log.info("User checks Percent Picked Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkPercentPickedFilterCheckBox();
    }

    @Step
    @And("User checks In Use By Filter on Work Queue Assignments page")
    public void checkInUseByFilterCheckBox() {
        log.info("User checks In Use By Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkInUseByFilterCheckBox();
    }

    @Step
    @And("User checks Estimated Time Filter on Work Queue Assignments page")
    public void checkEstimatedTimeFilterCheckBox() {
        log.info("User checks Estimated Time Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkEstimatedTimeFilterCheckBox();
    }

    @Step
    @And("User checks Standard Time Filter on Work Queue Assignments page")
    public void checkStandardTimeFilterCheckBox() {
        log.info("User checks Standard Time Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkStandardTimeFilterCheckBox();
    }

    @Step
    @And("User checks Actual Time Filter on Work Queue Assignments page")
    public void checkActualTimeFilterCheckBox() {
        log.info("User checks Actual Time Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkActualTimeFilterCheckBox();
    }

    @Step
    @And("User checks Status Filter on Work Queue Assignments page")
    public void checkActivityIndicatorFilterCheckBox() {
        log.info("User checks Status Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkActivityIndicatorFilterCheckBox();
    }

    @Step
    @And("User checks Remaining Filter on Work Queue Assignments page")
    public void checkRemainingFilterCheckBox() {
        log.info("User checks Remaining Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkRemainingFilterCheckBox();
    }

    @Step
    @And("User checks Printed Filter on Work Queue Assignments page")
    public void checkPrintedFilterCheckBox() {
        log.info("User checks Printed Filter on Work Queue Assignments page");
        workQueueAssignmentsPage.checkPrintedFilterCheckBox();
    }

    @Step
    @And("Clicks Apply button on Work Queue Assignments page")
    public void clickApplyButton() {
        log.info("Clicks Apply button on Work Queue Assignments page");
        workQueueAssignmentsPage.clickApplyButton();
    }

    @Step
    @And("User searches for {string} on Work Queue Assignments page")
    public void searchOnWorkQueueAssignments(String value) {
        log.info("User searches on Work Queue Assignments page");
        workQueueAssignmentsPage.findValuesInSearch(value);
    }

    @Step
    @And("Cleans Search on Work Queue Assignments page")
    public void cleanTextFromInput() {
        log.info("Cleans Search on Work Queue Assignments page");
        workQueueAssignmentsPage.cleanTextFromInput();
    }

    @Step
    @And("Enters calendar day {string} for Edit Assignment on Work Queue Assignments page")
    public void enterDate(String day) {
        log.info("Enters calendar day for Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.enterDate(day);
    }

    @Step
    @And("Enters time {string} for Edit Assignment on Work Queue Assignments page")
    public void enterTime(String time) {
        log.info("Enters time for Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.enterTime(time);
    }

    @Step
    @And("Clicks Save Button for Assignment on Work Queue Assignments page")
    public void clickSaveButton() {
        log.info("Clicks Save Button for Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.clickSaveButton();
    }

    @Step
    @And("Clicks Cancel Button for Assignment on Work Queue Assignments page")
    public void clickCancelButton() {
        log.info("Clicks Cancel Button for Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.clickCancelButton();
    }

    @Step
    @And("Checks assignment with index {int} on Work Queue Assignments page")
    public void checkAssignmentByAssignmentIndex(int index) {
        log.info("Checks assignment with index on Work Queue Assignments page");
        workQueueAssignmentsPage.checkAssignmentByAssignmentIndex(index);
    }

    @Step
    @And("Clicks assignment with index {int} on Work Queue Assignments page")
    public void clickAssignmentByAssignmentIndex(int index) {
        log.info("Checks assignment with index on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentByAssignmentIndex(index);
    }

    @Step
    @And("Types filter {string} on Work Queue Assignments page")
    public void typeFilter(String filter) {
        log.info("Types filter on Work Queue Assignments page");
        workQueueAssignmentsPage.typeFilter(filter);
    }

    @Step
    @And("Types search {string} on Work Queue Assignments page")
    public void typeSearch(String filter) {
        log.info("Types search on Work Queue Assignments page");
        workQueueAssignmentsPage.typeSearch(filter);
    }

    @Step
    @And("Clicks Completed status on Work Queue Assignments page")
    public void clickCompletedStatus() {
        log.info("Clicks Completed status on Work Queue Assignments page");
        workQueueAssignmentsPage.clickCompletedStatus();
    }

    @Step
    @And("Clicks Not started status on Work Queue Assignments page")
    public void clickNotStartedStatus() {
        log.info("Clicks Not Started status on Work Queue Assignments page");
        workQueueAssignmentsPage.clickNotStartedStatus();
    }

    @Step
    @And("Checks Count task group on Work Queue Assignments page")
    public void clickInputCount() {
        log.info("Checks Count task group on Work Queue Assignments page");
        workQueueAssignmentsPage.clickInputCount();
    }

    @Step
    @And("Checks Dee task group on Work Queue Assignments page")
    public void clickInputDee() {
        log.info("Checks Dee task group on Work Queue Assignments page");
        workQueueAssignmentsPage.clickInputDee();
    }

    @Step
    @And("Checks Default task group on Work Queue Assignments page")
    public void clickInputDefault() {
        log.info("Checks Default task group on Work Queue Assignments page");
        workQueueAssignmentsPage.clickInputDefault();
    }

    @Step
    @And("Checks Assignment type Count on Work Queue Assignments page")
    public void clickAssignmentTypeCount() {
        log.info("Checks Assignment type Count on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypeCount();
    }

    @Step
    @And("Checks Assignment type Cross Dock Pallet on Work Queue Assignments page")
    public void clickAssignmentTypeCrossDockPallet() {
        log.info("Checks Assignment type Cross Dock Pallet on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypeCrossDockPallet();
    }

    @Step
    @And("Checks Assignment type Dynamic on Work Queue Assignments page")
    public void clickAssignmentTypeDynamic() {
        log.info("Checks Assignment type Dynamic on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypeDynamic();
    }

    @Step
    @And("Checks Assignment type Pick Cooler on Work Queue Assignments page")
    public void clickAssignmentTypePickCooler() {
        log.info("Checks Assignment type Pick Cooler on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypePickCooler();
    }

    @Step
    @And("Checks Assignment type Pick Dry on Work Queue Assignments page")
    public void clickAssignmentTypePickDry() {
        log.info("Checks Assignment type Pick Dry on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypePickDry();
    }

    @Step
    @And("Checks Assignment type Pick Freezer on Work Queue Assignments page")
    public void clickAssignmentTypePickFreezer() {
        log.info("Checks Assignment type Pick Freezer on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypePickFreezer();
    }

    @Step
    @And("Checks Assignment type Pick Do Not Split on Work Queue Assignments page")
    public void clickAssignmentTypePickDoNotSplit() {
        log.info("Checks Assignment type Pick Do Not Split on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypePickDoNotSplit();
    }

    @Step
    @And("Checks Assignment type Pick Full Pallets on Work Queue Assignments page")
    public void clickAssignmentTypePickFullPallets() {
        log.info("Checks Assignment type Pick Full Pallets on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypePickFullPallets();
    }

    @Step
    @And("User clicks from Date {string} on Work Queue Assignments page")
    public void typesFromDate(String day) {
        log.info("User clicks from Date " + day + " days");
        workQueueAssignmentsPage.enterFromDate(day);
    }

    @Step
    @And("User clicks till Date {string} on Work Queue Assignments page")
    public void typesTillDate(String day) {
        log.info("User clicks till Date " + day + " days");
        workQueueAssignmentsPage.enterTillDate(day);
    }

    @Step
    @And("User clicks Is Empty radio button on Work Queue Assignments page")
    public void clickIsEmptyButton() {
        log.info("User clicks Is Empty radio button on Work Queue Assignments page");
        workQueueAssignmentsPage.clickIsEmptyButton();
    }

    @Step
    @And("User selects Type {string} for Edit Assignment on Work Queue Assignments page")
    public void selectAssignmentType(String type) {
        log.info("User selects Type for Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.selectAssignmentType(type);
    }

    @Step
    @And("User selects Task group {string} for Edit Assignment on Work Queue Assignments page")
    public void selectAssignmentTaskGroup(String task) {
        log.info("User selects Task group for Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.selectAssignmentTaskGroup(task);
    }

    @Step
    @And("User selects User {string} for Assignment on Work Queue Assignments page")
    public void selectAssignmentUser(String user) {
        log.info("User selects Task group for Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.selectAssignmentUser(user);
    }

    @Step
    @And("User enters calendar day {string} for Assignment Release Date on Work Queue Assignments page")
    public void enterReleaseDate(String date) {
        log.info("User Enters calendar day for Assignment Release Date on Work Queue Assignments page");
        workQueueAssignmentsPage.enterReleaseDate(date);
    }

    @Step
    @And("User enters calendar time {string} for Assignment Release Date on Work Queue Assignments page")
    public void enterReleaseTime(String time) {
        log.info("User Enters calendar time for Assignment Release Date on Work Queue Assignments page");
        workQueueAssignmentsPage.enterReleaseTime(time);
    }

    @Step
    @And("User clicks Clear Release for Assignment on Work Queue Assignments page")
    public void clickClearRelease() {
        log.info("User clicks Clear Release for Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.clickClearRelease();
    }

    @Step
    @And("User clicks on Assignment Number Column Header on Work Queue Assignments page")
    public void clickAssignmentNumberColumnHeader() {
        log.info("User clicks on Assignment Number Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentNumberColumnHeader();
    }

    @Step
    @And("User clicks on Route Column Header on Work Queue Assignments page")
    public void clickRouteColumnHeader() {
        log.info("User clicks on Route Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickRouteColumnHeader();
    }

    @Step
    @And("User clicks on Stops Column Header on Work Queue Assignments page")
    public void clickStopsColumnHeader() {
        log.info("User clicks on Stops Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickStopsColumnHeader();
    }

    @Step
    @And("User clicks on Shipper Column Header on Work Queue Assignments page")
    public void clickShipperColumnHeader() {
        log.info("User clicks on Shipper Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickShipperColumnHeader();
    }

    @Step
    @And("User clicks on Ship To Column Header on Work Queue Assignments page")
    public void clickShipToColumnHeader() {
        log.info("User clicks on Ship To Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickShipToColumnHeader();
    }

    @Step
    @And("User clicks on Tasks Column Header on Work Queue Assignments page")
    public void clickTasksColumnHeader() {
        log.info("User clicks on Tasks Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickTasksColumnHeader();
    }

    @Step
    @And("User clicks on Assign To Column Header on Work Queue Assignments page")
    public void clickAssignToColumnHeader() {
        log.info("User clicks on Assign To Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignToColumnHeader();
    }

    @Step
    @And("User clicks on Released Column Header on Work Queue Assignments page")
    public void clickReleasedColumnHeader() {
        log.info("User clicks on Released Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickReleasedColumnHeader();
    }

    @Step
    @And("User clicks on Qty Column Header on Work Queue Assignments page")
    public void clickQtyColumnHeader() {
        log.info("User clicks on Qty Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickQtyColumnHeader();
    }

    @Step
    @And("User clicks on Cube Column Header on Work Queue Assignments page")
    public void clickCubeColumnHeader() {
        log.info("User clicks on Cube Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickCubeColumnHeader();
    }

    @Step
    @And("User clicks on Weight Column Header on Work Queue Assignments page")
    public void clickWeightColumnHeader() {
        log.info("User clicks on Weight Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickWeightColumnHeader();
    }

    @Step
    @And("User clicks on Assignment Type Header Column on Work Queue Assignments page")
    public void clickAssignmentTypeColumnHeader() {
        log.info("User clicks on Assignment Type Header Column on Work Queue Assignments page");
        workQueueAssignmentsPage.clickAssignmentTypeColumnHeader();
    }

    @Step
    @And("User clicks on Task Group Header Column on Work Queue Assignments page")
    public void clickTaskGroupColumnHeader() {
        log.info("User clicks on Task Group Header Column on Work Queue Assignments page");
        workQueueAssignmentsPage.clickTaskGroupColumnHeader();
    }

    @Step
    @And("User clicks on Picked Column Header on Work Queue Assignments page")
    public void clickPickedColumnHeader() {
        log.info("User clicks on Picked Column Header on Work Queue Assignments page");
        workQueueAssignmentsPage.clickPickedColumnHeader();
    }

    @Step
    @And("User clicks Close on Work Queue Assignments page")
    public void clickCloseBtn() {
        log.info("User clicks Close on Work Queue Assignments page");
        workQueueAssignmentsPage.clickCloseBtn();
    }

}
