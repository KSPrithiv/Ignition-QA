package steps.validations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import ui.pages.DockManagementSummaryPage;

public class DockManagementSummaryPageValidations {
    DockManagementSummaryPage dockManagementSummaryPage = new DockManagementSummaryPage();
    SoftAssert softAssert = new SoftAssert();

    @Then("DockManagement Summary Page is validated")
    public void validateDockManagementSummaryPage() {
        softAssert.assertTrue(dockManagementSummaryPage.isListBoxIconVisible(), "List Box is not visible");
        softAssert.assertTrue(dockManagementSummaryPage.isTopHeaderRowVisible(), "Top Header Row is not displayed");
        softAssert.assertAll();
    }

    @And("Profile Footer is not displayed")
    public void validateUserProfileFooterIconNotDisplayed() {
        softAssert.assertFalse(dockManagementSummaryPage.isUserProfileFooterIconDisplayed(), "User Profile Footer icon is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location, Product, Dock management and Labels are displayed")
    public void validateLookupIconsDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isLocationIconVisible(), "Location Icon is not visible");
        softAssert.assertTrue(dockManagementSummaryPage.isProductIconVisible(), "Product Icon is not visible");
        softAssert.assertTrue(dockManagementSummaryPage.isDockManagementIconVisible(), "Dock Management Icon is not visible");
      //  softAssert.assertTrue(dockManagementSummaryPage. "Labels Icon is not visible");
        softAssert.assertAll();
    }

    @And("Validates Dashboard Icons are not displayed on Dashboard page")
    public void validateDashboardIconsNotDisplayed() {
        softAssert.assertFalse(dockManagementSummaryPage.isTransactionsGraphDisplayed(), "Transactions Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isTasksByTypeGraphDisplayed(), "Tasks by Type Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isOrderStatusGraphDisplayed(), "Order Status Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isInboundLoadsGraphDisplayed(), "Inbound Loads Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isOutboundRoutesGraphDisplayed(), "Outbound Routes Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isAssignmentsByGroupGraphDisplayed(), "Assignments by Group Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isInboundOrdersGraphDisplayed(), "Inbound Orders Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isOutboundOrdersGraphDisplayed(), "Outbound Orders Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isPickingStatusGraphDisplayed(), "Picking Status Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isLateInboundGraphDisplayed(), "Late Inbound Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isLateOutboundGraphDisplayed(), "Late Outbound Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isReplenishmentStatusGraphDisplayed(), "Replenishment Status Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isLaborGraphDisplayed(), "Labor Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isActiveOperatorsGraphDisplayed(), "Active Operators Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isCapacityGraphDisplayed(), "Capacity Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isWarehouseCapacityGraphDisplayed(), "Warehouse Capacity Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isByStatusGraphDisplayed(), "By Status Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isOperatorsByGroupGraphDisplayed(), "Operators by Group Graph is not displayed");
        softAssert.assertFalse(dockManagementSummaryPage.isEmptyLocationsByZoneGraphDisplayed(), "Empty Locations by Zone Graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Dashboard Icons and Spelling on Dashboard page")
    public void validateDashboardIconAndSpellingDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isTransactionsGraphDisplayed(), "Transactions Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isTasksByTypeGraphDisplayed(), "Tasks by Type Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isOrderStatusGraphDisplayed(), "Order Status Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isInboundLoadsGraphDisplayed(), "Inbound Loads Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isOutboundRoutesGraphDisplayed(), "Outbound Routes Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isAssignmentsByGroupGraphDisplayed(), "Assignments by Group Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isInboundOrdersGraphDisplayed(), "Inbound Orders Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isOutboundOrdersGraphDisplayed(), "Outbound Orders Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPickingStatusGraphDisplayed(), "Picking Status Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isLateInboundGraphDisplayed(), "Late Inbound Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isLateOutboundGraphDisplayed(), "Late Outbound Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isReplenishmentStatusGraphDisplayed(), "Replenishment Status Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isLaborGraphDisplayed(), "Labor Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isActiveOperatorsGraphDisplayed(), "Active Operators Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isCapacityGraphDisplayed(), "Capacity Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isWarehouseCapacityGraphDisplayed(), "Warehouse Capacity Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isByStatusGraphDisplayed(), "By Status Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isOperatorsByGroupGraphDisplayed(), "Operators by Group Graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isEmptyLocationsByZoneGraphDisplayed(), "Empty Locations by Zone Graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Tasks by Type widget on Dashboard page")
    public void validateTasksByTypeWidget() {
        softAssert.assertTrue(dockManagementSummaryPage.isCycleCountTaskDisplayed(), "Cycle Count is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isLetdownTaskDisplayed(), "Letdown is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isLoadCountAuditTaskDisplayed(), "Load Count Audit is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isLoadingTaskDisplayed(), "Loading Task is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isMovementTaskDisplayed(), "Movement is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPickTaskDisplayed(), "Pick is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPickFromReserveTaskDisplayed(), "Pick from reserve is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPutawayTaskDisplayed(), "Putaway is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isReplenishmentTaskDisplayed(), "Replenishment is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isShippingTaskDisplayed(), "Shipping is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isShortChasingTaskDisplayed(), "Short Chasing is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isTopOffTaskDisplayed(), "Top Off is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isWavePickTaskDisplayed(), "Wave Pick is not displayed");
        softAssert.assertAll();
    }

    @And("Validates number of Tasks popup is displayed on Dashboard page")
    public void validatesNumberOfTasks() {
        softAssert.assertTrue(dockManagementSummaryPage.isNumberOfTasksVisible(), "Number Of Tasks popup is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Picking Status graph is displayed on Dashboard page")
    public void validatesPickingStatusGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isPickingStatusGraphDisplayed(), "Picking Status graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Late Outbound graph is displayed on Dashboard page")
    public void validatesLateOutboundGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isLateOutboundGraphDisplayed(), "Late Outbound graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Late Inbound graph is displayed on Dashboard page")
    public void validatesLateInboundGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isLateInboundGraphDisplayed(), "Late Inbound graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inbound Loads graph is displayed on Dashboard page")
    public void validatesInboundLoadsGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isInboundLoadsGraphDisplayed(), "Inbound Loads graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Outbound Routes graph is displayed on Dashboard page")
    public void validatesOutboundRoutesGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isOutboundRoutesGraphDisplayed(), "Outbound Routes graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inbound Orders graph is displayed on Dashboard page")
    public void validatesInboundOrderGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isInboundOrdersGraphDisplayed(), "Inbound Orders graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Outbound Orders graph is displayed on Dashboard page")
    public void validatesOutboundOrderGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isOutboundOrdersGraphDisplayed(), "Outbound Orders graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Active Operators graph is displayed on Dashboard page")
    public void validatesActiveOperatorsGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isLaborGraphDisplayed(), "LABOR graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isActiveOperatorsGraphDisplayed(), "Active Operators graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates By Status graph widget is displayed on Dashboard page")
    public void validatesByStatusGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isInventoryGraphDisplayed(), "INVENTORY graph is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isCloseToCodeDisplayed(), "Close To Code is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isDamagedDisplayed(), "Damaged is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isExpiredDisplayed(), "Expired is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isFDAHOLDDisplayed(), "FDA HOLD is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isHoldTestDisplayed(), "Hold Test is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isQualityControlDisplayed(), "Quality Control is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isShippedDisplayed(), "Shipped is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Active Operators Time Groups is displayed on Dashboard page")
    public void validatesActiveOperatorsTimeGroups() {
        softAssert.assertTrue(dockManagementSummaryPage.isActiveOperatorsMin8hDisplayed(), "<8 hours time group is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isActiveOperators8h24hDisplayed(), "8-24 hours time group is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isActiveOperators24hPlusDisplayed(), "24+ hours time group is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isActiveOperatorsOnBreakDisplayed(), "On break time group is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Operators by Group graph is displayed on Dashboard page")
    public void validatesOperatorsByGroupGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isOperatorsByGroupGraphDisplayed(), "Operators by Group graph is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignments by Group widget on Dashboard page")
    public void validateAssignmentsByGroupWidget() {
        softAssert.assertTrue(dockManagementSummaryPage.isCountTaskDisplayed(), "Count is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isDeeTaskDisplayed(), "Dee is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isDefaultTaskDisplayed(), "Default is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isLoadTaskDisplayed(), "Load is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPalDryTaskDisplayed(), "Pal Dry is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPalFrzTaskDisplayed(), "Pal Frz  not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPickChillTaskDisplayed(), "Pick Chill is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPickDryTaskDisplayed(), "Pick Dry is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isPickFrzTaskDisplayed(), "Pick Frz is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isShortTaskDisplayed(), "Short is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isWpChillTaskDisplayed(), "WP Chill is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isXdockPalTaskDisplayed(), "XDock Pal is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isXrepNdFrzDisplayed(), "XRep ND Frz is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Warehouse Capacity graph is displayed on Dashboard page")
    public void validatesWarehouseCapacityGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isCapacityGraphDisplayed(), "Capacity is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isWarehouseCapacityGraphDisplayed(), "Warehouse Capacity is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Empty Locations by Zone graph is displayed on Dashboard page")
    public void validatesEmptyLocationsByZoneGraphDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isEmptyLocationsByZoneGraphDisplayed(), "Empty Locations by Zone is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isByPickDisplayed(), "Pick is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isByReserveDisplayed(), "Reserve is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Warehouse Capacity picture is displayed on Dashboard page")
    public void validatesWarehouseCapacityPictureDisplayed() {
        softAssert.assertTrue(dockManagementSummaryPage.isArcgaugeDisplayed(), "Warehouse Capacity picture is not displayed");
        softAssert.assertTrue(dockManagementSummaryPage.isArcgaugeLabelDisplayed(), "Warehouse Capacity Label is not displayed");
        softAssert.assertAll();
    }

}
