package steps.workqueue.task;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.workqueue.task.WorkQueueTaskPage;

@Slf4j
public class WorkQueueTaskPageSteps {
    WorkQueueTaskPage workQueueTaskPage = new WorkQueueTaskPage();

    @Step
    @And("Waits for Work Queue Task page to load")
    public void waitForWorkQueueTaskPageToLoad() {
        log.info("Waiting for Work Queue Task Page To Load");
        workQueueTaskPage.waitWorkQueueTaskPageToLoad();
    }

    @Step
    @And("Clicks Task list title on Work Queue Task page")
    public void clickTaskListTitle() {
        log.info("Clicks Task list title on Work Queue Task page");
        workQueueTaskPage.clickTaskListTitle();
    }

    @Step
    @And("Hover mouse over Search on Work Queue Task page")
    public void hoverMouseOverSearchOnWorkQueueTaskPageToLoad() {
        log.info("Hover mouse over Search on Work Queue Task page");
        workQueueTaskPage.hoverOverSearchInput();
    }

    @Step
    @And("Checks Task with index {int} on Work Queue Task page")
    public void checkTaskByTaskIndex(int index) {
        log.info("Checks Task with index " + index + " on Work Queue Task page");
        workQueueTaskPage.checkTaskByTaskIndex(index);
    }

    @Step
    @And("User clicks Add filter button on Work Queue Task page")
    public void clickAddFilter() {
        log.info("Clicking add filter on Work Queue Task page");
        workQueueTaskPage.clickAddFilter();
    }

    @Step
    @And("User clicks Clear All button on Work Queue Task page")
    public void clickClearAll() {
        log.info("Clicking clear all on Work Queue Task page");
        workQueueTaskPage.clickClearAllButton();
    }

    @Step
    @And("Clicks Apply Button on Work Queue Task page")
    public void clickApplyButton() {
        log.info("Clicks Apply Button on Work Queue Task page");
        workQueueTaskPage.clickApplyButton();
    }

    @Step
    @And("Checks Product Checkbox on Work Queue Task page")
    public void checksProductCheckbox() {
        log.info("Checks Product Checkbox on Work Queue Task page");
        workQueueTaskPage.checkProductFilterCheckBox();
    }

    @Step
    @And("Checks Qty Checkbox on Work Queue Task page")
    public void checksQtyCheckbox() {
        log.info("Checks Qty Checkbox on Work Queue Task page");
        workQueueTaskPage.checkStrQtyFilterCheckBox();
    }

    @Step
    @And("Checks From Checkbox on Work Queue Task page")
    public void checksFromCheckbox() {
        log.info("Checks From Checkbox on Work Queue Task page");
        workQueueTaskPage.checkFromFilterCheckBox();
    }

    @Step
    @And("Checks To Checkbox on Work Queue Task page")
    public void checksToCheckbox() {
        log.info("Checks To Checkbox on Work Queue Task page");
        workQueueTaskPage.checkToFilterCheckBox();
    }

    @Step
    @And("Checks Type Checkbox on Work Queue Task page")
    public void checksTypeCheckbox() {
        log.info("Checks Type Checkbox on Work Queue Task page");
        workQueueTaskPage.checkTypeFilterCheckBox();
    }

    @Step
    @And("Checks Task Group Checkbox on Work Queue Task page")
    public void checksTaskGroupCheckbox() {
        log.info("Checks Task Group Checkbox on Work Queue Task page");
        workQueueTaskPage.checkTaskGroupFilterCheckBox();
    }

    @Step
    @And("Checks Status Checkbox on Work Queue Task page")
    public void checksStatusCheckbox() {
        log.info("Checks Status Checkbox on Work Queue Task page");
        workQueueTaskPage.checkStatusFilterCheckBox();
    }

    @Step
    @And("Checks Assignment Number Checkbox on Work Queue Task page")
    public void checksAssignmentNumberCheckbox() {
        log.info("Checks Assignment Number Checkbox on Work Queue Task page");
        workQueueTaskPage.checkAssignmentNumberFilterCheckBox();
    }

    @Step
    @And("Checks Priority Checkbox on Work Queue Task page")
    public void checksPriorityCheckbox() {
        log.info("Checks Priority Checkbox on Work Queue Task page");
        workQueueTaskPage.checkPriorityFilterCheckBox();
    }

    @Step
    @And("Checks Route Checkbox on Work Queue Task page")
    public void checksRouteCheckbox() {
        log.info("Checks Route Checkbox on Work Queue Task page");
        workQueueTaskPage.checkRouteFilterCheckBox();
    }

    @Step
    @And("Checks Stop Checkbox on Work Queue Task page")
    public void checksStopCheckbox() {
        log.info("Checks Stop Checkbox on Work Queue Task page");
        workQueueTaskPage.checkStopFilterCheckBox();
    }

    @Step
    @And("Checks Shipper Checkbox on Work Queue Task page")
    public void checksShipperCheckbox() {
        log.info("Checks Shipper Checkbox on Work Queue Task page");
        workQueueTaskPage.checkShipperFilterCheckBox();
    }

    @Step
    @And("Checks Velocity Checkbox on Work Queue Task page")
    public void checksVelocityCheckbox() {
        log.info("Checks Velocity Checkbox on Work Queue Task page");
        workQueueTaskPage.checkVelocityFilterCheckBox();
    }

    @Step
    @And("Checks Description Checkbox on Work Queue Task page")
    public void checksDescriptionCheckbox() {
        log.info("Checks Description Checkbox on Work Queue Task page");
        workQueueTaskPage.checkDescriptionFilterCheckBox();
    }

    @Step
    @And("Checks Check In Checkbox on Work Queue Task page")
    public void checksCheckInCheckbox() {
        log.info("Checks Check In Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputCheckIn();
    }

    @Step
    @And("Checks Cycle Count Checkbox on Work Queue Task page")
    public void checksCycleCountCheckbox() {
        log.info("Checks Cycle Count Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputCycleCount();
    }

    @Step
    @And("Checks Letdown Checkbox on Work Queue Task page")
    public void checksLetdownCheckbox() {
        log.info("Checks Letdown Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputLetdown();
    }

    @Step
    @And("Checks Load Count Audit Checkbox on Work Queue Task page")
    public void checksLoadCountAuditCheckbox() {
        log.info("Checks Load Count Audit Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputLoadCountAudit();
    }

    @Step
    @And("Checks Loading Checkbox on Work Queue Task page")
    public void checksLoadingCheckbox() {
        log.info("Checks Loading Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputLoading();
    }

    @Step
    @And("Checks Movement Checkbox on Work Queue Task page")
    public void checksMovementCheckbox() {
        log.info("Checks Movement Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputMovement();
    }

    @Step
    @And("Checks Opportunistic Count Checkbox on Work Queue Task page")
    public void checksOpportunisticCountCheckbox() {
        log.info("Checks Opportunistic Count Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputOpportunisticCount();
    }

    @Step
    @And("Checks Pack Staging Checkbox on Work Queue Task page")
    public void checksPackStagingCheckbox() {
        log.info("Checks Pack Staging Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPackStaging();
    }

    @Step
    @And("Checks Packing Checkbox on Work Queue Task page")
    public void checksPackingCheckbox() {
        log.info("Checks Packing Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPacking();
    }

    @Step
    @And("Checks Pick Checkbox on Work Queue Task page")
    public void checksPickCheckbox() {
        log.info("Checks Pick Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPick();
    }

    @Step
    @And("Checks Pick From Reserve Checkbox on Work Queue Task page")
    public void checksPickFromReserveCheckbox() {
        log.info("Checks Pick From Reserve Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPickFromReserve();
    }

    @Step
    @And("Checks Putaway Checkbox on Work Queue Task page")
    public void checksPutawayCheckbox() {
        log.info("Checks Putaway Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPutaway();
    }

    @Step
    @And("Checks Replenishment Checkbox on Work Queue Task page")
    public void checksReplenishmentCheckbox() {
        log.info("Checks Replenishment Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputReplenishment();
    }

    @Step
    @And("Checks Shipping Checkbox on Work Queue Task page")
    public void checksShippingCheckbox() {
        log.info("Checks Shipping Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputShipping();
    }

    @Step
    @And("Checks Short Chasing Checkbox on Work Queue Task page")
    public void checksShortChasingCheckbox() {
        log.info("Checks Short Chasing Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputShortChasing();
    }

    @Step
    @And("Checks Top Off Checkbox on Work Queue Task page")
    public void checksTopOffCheckbox() {
        log.info("Checks Top Off Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputTopOff();
    }

    @Step
    @And("Checks Wave Pick Checkbox on Work Queue Task page")
    public void checksWavePickCheckbox() {
        log.info("Checks Wave Pick Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputWavePick();
    }

    @Step
    @And("Checks Count Checkbox on Work Queue Task page")
    public void checksCountCheckbox() {
        log.info("Checks Count Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputCount();
    }

    @Step
    @And("Checks Dee Checkbox on Work Queue Task page")
    public void checksDeeCheckbox() {
        log.info("Checks Dee Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputDee();
    }

    @Step
    @And("Checks Default Checkbox on Work Queue Task page")
    public void checksDefaultCheckbox() {
        log.info("Checks Default Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputDefault();
    }

    @Step
    @And("Checks Load Checkbox on Work Queue Task page")
    public void checksLoadCheckbox() {
        log.info("Checks Load Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputLoad();
    }

    @Step
    @And("Checks Needs Loc Checkbox on Work Queue Task page")
    public void checksNeedsLocCheckbox() {
        log.info("Checks Needs Loc Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputNeedsLoc();
    }

    @Step
    @And("Checks Pal Chill Checkbox on Work Queue Task page")
    public void checksPalChillCheckbox() {
        log.info("Checks Wave Pick Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPalChill();
    }

    @Step
    @And("Checks Pal Dry Checkbox on Work Queue Task page")
    public void checksPalDryCheckbox() {
        log.info("Checks Pal Dry Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPalDry();
    }

    @Step
    @And("Checks Pal Frz Checkbox on Work Queue Task page")
    public void checksPalFrzCheckbox() {
        log.info("Checks Pal Frz Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPalFrz();
    }

    @Step
    @And("Checks Pick Chill Checkbox on Work Queue Task page")
    public void checksPickChillCheckbox() {
        log.info("Checks Pick Chill Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPickChill();
    }

    @Step
    @And("Checks Pick Dry Checkbox on Work Queue Task page")
    public void checksPickDryCheckbox() {
        log.info("Checks Pick Dry Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPickDry();
    }

    @Step
    @And("Checks Pick Frz Checkbox on Work Queue Task page")
    public void checksPickFrzCheckbox() {
        log.info("Checks Pick Frz Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputPickFrz();
    }

    @Step
    @And("Checks Replen Checkbox on Work Queue Task page")
    public void checksReplenCheckbox() {
        log.info("Checks Replen Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputReplen();
    }

    @Step
    @And("Checks Short Checkbox on Work Queue Task page")
    public void checksShortCheckbox() {
        log.info("Checks Short Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputShort();
    }

    @Step
    @And("Checks Testcode Checkbox on Work Queue Task page")
    public void checksTestcodeCheckbox() {
        log.info("Checks Testcode Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputTestcode();
    }

    @Step
    @And("Checks Wp Brp Med Checkbox on Work Queue Task page")
    public void checksWpBrpMedCheckbox() {
        log.info("Checks Wp Brp Med Checkbox on Work Queue Task page");
        workQueueTaskPage.checkInputWpBrpMed();
    }

    @Step
    @And("Types Product {string} on Work Queue Task page")
    public void typesProductFilter(String product) {
        log.info("Types Product on Work Queue Task page");
        workQueueTaskPage.typeFilter(product);
    }

    @Step
    @And("Types Qty {string} on Work Queue Task page")
    public void typesQtyFilter(String qty) {
        log.info("Types Qty on Work Queue Task page");
        workQueueTaskPage.typeFilter(qty);
    }

    @Step
    @And("Types From {string} on Work Queue Task page")
    public void typesFromFilter(String from) {
        log.info("Types From on Work Queue Task page");
        workQueueTaskPage.typeFilter(from);
    }

    @Step
    @And("Types To {string} on Work Queue Task page")
    public void typesToFilter(String to) {
        log.info("Types To on Work Queue Task page");
        workQueueTaskPage.typeFilter(to);
    }

    @Step
    @And("Types Status {string} on Work Queue Task page")
    public void typesStatusFilter(String status) {
        log.info("Types Status on Work Queue Task page");
        workQueueTaskPage.typeFilter(status);
    }

    @Step
    @And("Types Assignment # {string} on Work Queue Task page")
    public void typesAssignmentFilter(String assignment) {
        log.info("Types Assignment # on Work Queue Task page");
        workQueueTaskPage.typeFilter(assignment);
    }

    @Step
    @And("Types Priority {string} on Work Queue Task page")
    public void typesPriorityFilter(String priority) {
        log.info("Types Priority on Work Queue Task page");
        workQueueTaskPage.typeFilter(priority);
    }

    @Step
    @And("Types Route {string} on Work Queue Task page")
    public void typesRouteFilter(String route) {
        log.info("Types Route on Work Queue Task page");
        workQueueTaskPage.typeFilter(route);
    }

    @Step
    @And("Types Stop {string} on Work Queue Task page")
    public void typesStopFilter(String stop) {
        log.info("Types Stop on Work Queue Task page");
        workQueueTaskPage.typeFilter(stop);
    }

    @Step
    @And("Types Shipper {string} on Work Queue Task page")
    public void typesShipperFilter(String shipper) {
        log.info("Types Shipper on Work Queue Task page");
        workQueueTaskPage.typeFilter(shipper);
    }

    @Step
    @And("Types Velocity {string} on Work Queue Task page")
    public void typesVelocityFilter(String velocity) {
        log.info("Types Velocity on Work Queue Task page");
        workQueueTaskPage.typeFilter(velocity);
    }

    @Step
    @And("Types Description {string} on Work Queue Task page")
    public void typesDescriptionFilter(String description) {
        log.info("Types Description on Work Queue Task page");
        workQueueTaskPage.typeFilter(description);
    }

}
