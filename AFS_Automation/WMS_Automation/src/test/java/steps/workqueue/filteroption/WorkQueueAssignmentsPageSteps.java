package steps.workqueue.filteroption;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.workqueuedata.WorkQueueDataDTO;
import ui.pages.workqueue.assignmentlist.filteroption.WorkQueueAssignmentsPage;

import java.util.List;

@Slf4j
public class WorkQueueAssignmentsPageSteps {
    WorkQueueAssignmentsPage workQueueAssignmentsPage = new WorkQueueAssignmentsPage();
    WorkQueueDataDTO workQueueDataDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.WORK_QUEUE_DATA, WorkQueueDataDTO.class);

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
    @And("Types Actual Time by index {int} on Work Queue Assignments page")
    public void typeActualTimeFilterByIndex(int index) {
        log.info("Types Actual Time by index on Work Queue Assignments page");
        List<String> time = List.of(workQueueDataDTO.getEstTime().getEstTime1(), workQueueDataDTO.getEstTime().getEstTime2(),
                workQueueDataDTO.getEstTime().getEstTime3(), workQueueDataDTO.getEstTime().getEstTime4(), workQueueDataDTO
                        .getEstTime().getEstTime5(), workQueueDataDTO.getEstTime().getEstTime6());
        workQueueAssignmentsPage.typeFilter(time.get(index));
    }

    @Step
    @And("Types Est Time by index {int} on Work Queue Assignments page")
    public void typeEstTimeFilterByIndex(int index) {
        log.info("Types Est Time by index on Work Queue Assignments page");
        List<String> time = List.of(workQueueDataDTO.getEstTime().getEstTime1(), workQueueDataDTO.getEstTime().getEstTime2(),
                workQueueDataDTO.getEstTime().getEstTime3(), workQueueDataDTO.getEstTime().getEstTime4(), workQueueDataDTO
                .getEstTime().getEstTime5(), workQueueDataDTO.getEstTime().getEstTime6());
        workQueueAssignmentsPage.typeFilter(time.get(index));
    }

    @Step
    @And("Types Remaining by index {int} on Work Queue Assignments page")
    public void typeRemainingFilterByIndex(int index) {
        log.info("Types Remaining by index on Work Queue Assignments page");
        List<String> remaining = List.of(workQueueDataDTO.getRemaining().getRemaining1(), workQueueDataDTO.getRemaining()
                .getRemaining2(), workQueueDataDTO.getRemaining().getRemaining3(), workQueueDataDTO.getRemaining().getRemaining4(),
                workQueueDataDTO.getRemaining().getRemaining5(), workQueueDataDTO.getRemaining().getRemaining6());
        workQueueAssignmentsPage.typeFilter(remaining.get(index));
    }

    @Step
    @And("Types Ship To by index {int} on Work Queue Assignments page")
    public void typeShipToFilterByIndex(int index) {
        log.info("Types Ship To by index on Work Queue Assignments page");
        List<String> shipTo = List.of(workQueueDataDTO.getShipTo().getShipTo1(), workQueueDataDTO.getShipTo().getShipTo2(),
                workQueueDataDTO.getShipTo().getShipTo3(), workQueueDataDTO.getShipTo().getShipTo4(), workQueueDataDTO
                .getShipTo().getShipTo5(), workQueueDataDTO.getShipTo().getShipTo6());
        workQueueAssignmentsPage.typeFilter(shipTo.get(index));
    }

    @Step
    @And("Types Shipper by index {int} on Work Queue Assignments page")
    public void typeShipperFilterByIndex(int index) {
        log.info("Types Shipper by index on Work Queue Assignments page");
        List<String> shippers = List.of(workQueueDataDTO.getShippers().getShipper1(), workQueueDataDTO.getShippers().getShipper2(),
                workQueueDataDTO.getShippers().getShipper3(), workQueueDataDTO.getShippers().getShipper4(), workQueueDataDTO
                .getShippers().getShipper5(), workQueueDataDTO.getShippers().getShipper6());
        workQueueAssignmentsPage.typeFilter(shippers.get(index));
    }

    @Step
    @And("Types Weight by index {int} on Work Queue Assignments page")
    public void typeWeightFilterByIndex(int index) {
        log.info("Types Weight by index on Work Queue Assignments page");
        List<String> weights = List.of(workQueueDataDTO.getWeights().getWeight1(), workQueueDataDTO.getWeights().getWeight2(),
                workQueueDataDTO.getWeights().getWeight3(), workQueueDataDTO.getWeights().getWeight4(), workQueueDataDTO
                .getWeights().getWeight5(), workQueueDataDTO.getWeights().getWeight6());
        workQueueAssignmentsPage.typeFilter(weights.get(index));
    }

    @Step
    @And("Types Percent Picked by index {int} on Work Queue Assignments page")
    public void typePercentPickedFilterByIndex(int index) {
        log.info("Types Percent Picked by index on Work Queue Assignments page");
        List<String> percents = List.of(workQueueDataDTO.getPicked().getPicked1(),workQueueDataDTO.getPicked().getPicked2());
        workQueueAssignmentsPage.typeFilter(percents.get(index));
    }

    @Step
    @And("Types In Use By by index {int} on Work Queue Assignments page")
    public void typeInUseByFilterByIndex(int index) {
        log.info("Types In Use By by index on Work Queue Assignments page");
        List<String> inUseBy = List.of(workQueueDataDTO.getInUseBy().getInUseBy1(), workQueueDataDTO.getInUseBy().getInUseBy2());
        workQueueAssignmentsPage.typeFilter(inUseBy.get(index));
    }

    @Step
    @And("Types Assign To by index {int} on Work Queue Assignments page")
    public void typeAssignToFilterByIndex(int index) {
        log.info("Types Assign To by index on Work Queue Assignments page");
        List<String> assignTo = List.of(workQueueDataDTO.getAssignTo().getAssignTo1(), workQueueDataDTO.getAssignTo()
                .getAssignTo2(), workQueueDataDTO.getAssignTo().getAssignTo3(), workQueueDataDTO.getAssignTo().getAssignTo4(),
                workQueueDataDTO.getAssignTo().getAssignTo5());
        workQueueAssignmentsPage.typeFilter(assignTo.get(index));
    }

    @Step
    @And("Types Cube by index {int} on Work Queue Assignments page")
    public void typeCubeByIndex(int index) {
        log.info("Types Cube by index on Work Queue Assignments page");
        List<String> cube = List.of(workQueueDataDTO.getCubes().getCube1(), workQueueDataDTO.getCubes().getCube2(),
                workQueueDataDTO.getCubes().getCube3(), workQueueDataDTO.getCubes().getCube4(), workQueueDataDTO
                .getCubes().getCube5(), workQueueDataDTO.getCubes().getCube6());
        workQueueAssignmentsPage.typeFilter(cube.get(index));
    }

    @Step
    @And("Types Qty by index {int} on Work Queue Assignments page")
    public void typeQtyByIndex(int index) {
        log.info("Types Qty by index on Work Queue Assignments page");
        List<String> qties = List.of(workQueueDataDTO.getQties().getQty1(), workQueueDataDTO.getQties().getQty2(),
                workQueueDataDTO.getQties().getQty3(), workQueueDataDTO.getQties().getQty4(), workQueueDataDTO.getQties()
                .getQty5(), workQueueDataDTO.getQties().getQty6());
        workQueueAssignmentsPage.typeFilter(qties.get(index));
    }

    @Step
    @And("Types Task by index {int} on Work Queue Assignments page")
    public void typeTaskByIndex(int index) {
        log.info("Types Task by index on Work Queue Assignments page");
        List<String> tasks = List.of(workQueueDataDTO.getTasks().getTask1(), workQueueDataDTO.getTasks().getTask2(),
                workQueueDataDTO.getTasks().getTask3(), workQueueDataDTO.getTasks().getTask4(), workQueueDataDTO.getTasks()
                .getTask5(), workQueueDataDTO.getTasks().getTask6());
        workQueueAssignmentsPage.typeFilter(tasks.get(index));
    }

    @Step
    @And("Types Stop by index {int} on Work Queue Assignments page")
    public void typeStopByIndex(int index) {
        log.info("Types Stop by index on Work Queue Assignments page");
        List<String> stops = List.of(workQueueDataDTO.getStops().getStop1(), workQueueDataDTO.getStops().getStop2(),
                workQueueDataDTO.getStops().getStop3(), workQueueDataDTO.getStops().getStop4(), workQueueDataDTO.getStops()
                .getStop5(), workQueueDataDTO.getStops().getStop6());
        workQueueAssignmentsPage.typeFilter(stops.get(index));
    }

    @Step
    @And("Types Route by index {int} on Work Queue Assignments page")
    public void typeRouteByIndex(int index) {
        log.info("Types Route by index on Work Queue Assignments page");
        List<String> routes = List.of(workQueueDataDTO.getRoutes().getRoute1(), workQueueDataDTO.getRoutes().getRoute2(),
                workQueueDataDTO.getRoutes().getRoute3(), workQueueDataDTO.getRoutes().getRoute4(), workQueueDataDTO
                .getRoutes().getRoute5());
        workQueueAssignmentsPage.typeFilter(routes.get(index));
    }

    @Step
    @And("Types Assignment Number by index {int} on Work Queue Assignments page")
    public void typeAssignmentNumberByIndex(int index) {
        log.info("Types Assignment Number by index on Work Queue Assignments page");
        List<String> numbers = List.of(workQueueDataDTO.getAssignmentNumbers().getAssignmentNumber1(), workQueueDataDTO
                .getAssignmentNumbers().getAssignmentNumber2(), workQueueDataDTO.getAssignmentNumbers().getAssignmentNumber3(),
                workQueueDataDTO.getAssignmentNumbers().getAssignmentNumber4(), workQueueDataDTO.getAssignmentNumbers()
                .getAssignmentNumber5());
        workQueueAssignmentsPage.typeFilter(numbers.get(index));
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
    @And("User selects Task group by index {int} for Edit Assignment on Work Queue Assignments page")
    public void selectAssignmentTaskGroupByIndex(int index) {
        log.info("User selects Task group by index {int} for Edit Assignment on Work Queue Assignments page");
        List<String> tasks = List.of(workQueueDataDTO.getTaskGroupDTO().getTaskGroup7(), workQueueDataDTO.getTaskGroupDTO()
                .getTaskGroup8(), workQueueDataDTO.getTaskGroupDTO().getTaskGroup9(), workQueueDataDTO.getTaskGroupDTO()
                .getTaskGroup10(), workQueueDataDTO.getTaskGroupDTO().getTaskGroup11(), workQueueDataDTO.getTaskGroupDTO()
                .getTaskGroup12());
        workQueueAssignmentsPage.selectAssignmentTaskGroup(tasks.get(index));
    }

    @Step
    @And("User selects Task group by index {int} for Assignment on Work Queue Assignments page")
    public void selectTaskGroupByIndex(int index) {
        log.info("User selects Task group by index for Assignment on Work Queue Assignments page");
        List<String> tasks = List.of(workQueueDataDTO.getTaskGroupDTO().getTaskGroup7(), workQueueDataDTO.getTaskGroupDTO()
                .getTaskGroup8(), workQueueDataDTO.getTaskGroupDTO().getTaskGroup9(), workQueueDataDTO.getTaskGroupDTO()
                .getTaskGroup10(), workQueueDataDTO.getTaskGroupDTO().getTaskGroup11(), workQueueDataDTO.getTaskGroupDTO()
                .getTaskGroup12());
        workQueueAssignmentsPage.selectAssignmentTaskGroup(tasks.get(index));
    }

    @Step
    @And("User selects User {string} for Assignment on Work Queue Assignments page")
    public void selectAssignmentUser(String user) {
        log.info("User selects Task group for Edit Assignment on Work Queue Assignments page");
        workQueueAssignmentsPage.selectAssignmentUser(user);
    }

    @Step
    @And("User selects user by index {int} for Assignment on Work Queue Assignments page")
    public void selectAssignmentUser(int index) {
        log.info("User selects user by index for Edit Assignment on Work Queue Assignments page");
        List<String> users = List.of(workQueueDataDTO.getUsersDTO().getUser1(), workQueueDataDTO.getUsersDTO().getUser2(),
                workQueueDataDTO.getUsersDTO().getUser3(), workQueueDataDTO.getUsersDTO().getUser4(), workQueueDataDTO
                .getUsersDTO().getUser5(), workQueueDataDTO.getUsersDTO().getUser6());
        workQueueAssignmentsPage.selectAssignmentUser(users.get(index));
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
