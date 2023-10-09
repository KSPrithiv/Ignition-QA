package steps.validations.outbound.ordersummary;

import common.constants.FilePaths;
import common.constants.Notifications;
import common.constants.TimeFormats;
import common.enums.Statuses;
import common.utils.database.StoreProceduresUtils;
import common.utils.objectmapper.ObjectMapperWrapper;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import objects.outbound.OutboundOrderLoadsDTO;
import org.apache.commons.lang3.StringUtils;
import org.testng.asserts.SoftAssert;
import ui.pages.outbound.ordersummary.OutboundOrderSummaryPage;
import ui.pages.outbound.processing.AddAllocationBatchPage;
import java.util.Calendar;
import java.util.List;


public class OutboundOrderSummaryPageValidations {
    OutboundOrderSummaryPage outboundOrderSummaryPage = new OutboundOrderSummaryPage();
    AddAllocationBatchPage addAllocationBatchPage = new AddAllocationBatchPage();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

    @And("Validates Outbound Order Summary page is displayed")
    public void validateOutboundOrderSummaryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isOrderOptionsDisplayed(), "Order Options is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isAllStatusesDropDownDisplayed(),
                    "All Statuses DropDown is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isDoorsDropDownDisplayed(),
                    "Doors DropDown is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isTableContentDisplayed(), "Table Content is not present");
        softAssert.assertAll();
    }

    @And("Validates Outbound Order Summary start date {string} and end date {string}")
    public void validateOutboundOrderSummaryStartEndDates(String startDate, String endDate) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getOrderStartCurrentValue(), startDate,
                "Current Date on Outbound Order is not correct");
        softAssert.assertEquals(outboundOrderSummaryPage.getOrderStartFutureValue(), endDate,
                "Future Date on Outbound Order is not correct");
        softAssert.assertAll();
    }

    @And("Validates Outbound Order Summary dates")
    public void validateOutboundOrderSummaryDates() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getOrderStartCurrentValue(), TimeConversion
                        .getFormattedCurrentDate(TimeFormats.format_MMddyyyy),
                "Current Date on Outbound Order is not correct");
        softAssert.assertEquals(outboundOrderSummaryPage.getOrderStartFutureValue(), TimeConversion
                        .futureDate(1, Calendar.DATE, TimeConversion
                                .getFormattedCurrentDate(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy),
                "Future Date on Outbound Order is not correct");
        softAssert.assertAll();
    }

    @And("Validates Order types are not empty on Outbound Order Summary page")
    public void validateOrderTypesNotEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderTypes().size() > 0, "Order types are not present" );
        softAssert.assertAll();
    }

    @SneakyThrows
    @And("Validates Outbound Order Summary grid with order {string}")
    public void validateOutboundOrderSummaryGrid(String order) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getGridTableRowByIndex(0).contains(order), "Order is not in table");
        softAssert.assertAll();
    }

    @SneakyThrows
    @And("Validates Outbound Order Summary grid with order by index {int}")
    public void validateOutboundOrderSummaryGridByIndex(int index) {
        List<String> orders = List.of(outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder1(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder2(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder3(),
                 outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder4(), outboundOrderLoadsDTO.getOutboundOrders()
                .getOutboundOrder5(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder6(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getGridTableRowByIndex(0).contains(orders.get(index)), "Order is not in table");
        softAssert.assertAll();
    }

    @And("Validates No Record Outbound Order Summary grid")
    public void validateNoRecordInOutboundOrderSummaryGrid() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getNoRecordsRowContent()
                .equals(Notifications.NO_DATA), "Order is not in table");
        softAssert.assertAll();
    }

    @And("Validates Adjust filter to display data on Outbound Order Summary grid")
    public void validateAdjustFilterInOutboundOrderSummaryGrid() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getNoRecordsRowContent().contains(Notifications
                .ADJUST_FILTER_DISPLAY_DATA), "Account is not found in table");
        softAssert.assertAll();
    }

    @And("Verifies Work Item is disabled")
    public void verifyWorkItemDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isWorkItemDisabled(), "Work item is disabled");
        softAssert.assertAll();
    }

    @And("Verifies Assign Item is disabled on Outbound Order Summary page")
    public void verifyAssignItemDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isAssignItemDisabled(), "Assign item is disabled");
        softAssert.assertAll();
    }

    @And("Verifies Work Item is enabled")
    public void verifyWorkItemEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundOrderSummaryPage.isWorkItemDisabled(), "Work item is enabled");
        softAssert.assertAll();
    }

    @And("Verifies Assign Item is enabled on Outbound Order Summary page")
    public void verifyAssignItemEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundOrderSummaryPage.isAssignItemDisabled(), "Assign item is enabled");
        softAssert.assertAll();
    }

    @And("Verifies Work Queue is displayed")
    public void verifyWorkQueueDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isWorkQueueDisplayed(), "Work Queue is displayed");
        softAssert.assertAll();
    }

    @And("Verifies Assign popup is displayed on Outbound Order Summary page")
    public void verifyAssignPopupDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getAccountWindowTitleText(), Notifications.ASSIGN,
                "Assign popup is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isReleaseCheckboxDisplayed(),
                "Release Checkbox is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignment and Tasks tabs are displayed")
    public void verifyAssignmentAndTasksTabsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isAssignmentTabDisplayed(), "Assignment Tab is displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isTasksTabDisabled(), "Tasks Tab is displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignment tab is active")
    public void verifyAssignmentTabIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isAssignmentTabActive(), "Assignment Tab is not active");
        softAssert.assertAll();
    }

    @And("Validates Work Queue order {string} is displayed")
    public void verifyWorkQueueIsCorrect(String order) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getWorkQueueOrder().contains(order), "Order is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Work Queue order by index {int} is displayed")
    public void verifyWorkQueueByIndexIsCorrect(int index) {
        List<String> orders = List.of(outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder1(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder2(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder3(),
                 outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder4(), outboundOrderLoadsDTO.getOutboundOrders()
                .getOutboundOrder5(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder6(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getWorkQueueOrder().contains(orders.get(index)), "Order is not displayed");
        softAssert.assertAll();
    }


    @And("Validates Edit, Delete, Release, Labels and Move are disabled")
    public void verifyWorkQueueItemsAreDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentButtonDisabled(), "Edit Assignment Button is enabled");
        softAssert.assertTrue(outboundOrderSummaryPage.isDeleteAssignmentButtonDisabled(), "Delete Assignment Button is enabled");
        softAssert.assertTrue(outboundOrderSummaryPage.isReleaseAssignmentButtonDisabled(), "Release Assignment Button is enabled");
        softAssert.assertTrue(outboundOrderSummaryPage.isPrintAssignmentButtonDisabled(), "Print Assignment Button is enabled");
        softAssert.assertTrue(outboundOrderSummaryPage.isMoveAssignmentButtonDisabled(), "Move Assignment Button is enabled");
        softAssert.assertAll();
    }

    @And("Validates Edit, Delete, Release, Labels and Move are enabled")
    public void verifyWorkQueueItemsAreEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundOrderSummaryPage.isEditAssignmentButtonDisabled(), "Edit Assignment Button is disabled");
        softAssert.assertFalse(outboundOrderSummaryPage.isDeleteAssignmentButtonDisabled(), "Delete Assignment Button is disabled");
        softAssert.assertFalse(outboundOrderSummaryPage.isReleaseAssignmentButtonDisabled(), "Release Assignment Button is disabled");
        softAssert.assertFalse(outboundOrderSummaryPage.isPrintAssignmentButtonDisabled(), "Print Assignment Button is disabled");
        softAssert.assertFalse(outboundOrderSummaryPage.isMoveAssignmentButtonDisabled(), "Move Assignment Button is disabled");
        softAssert.assertAll();
    }

    @And("Validates Edit, Delete, Release, Labels and Move are displayed")
    public void verifyWorkQueueItemsAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentButtonDisplayed(),"Edit Assignment Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isDeleteAssignmentButtonDisplayed(),"Delete Assignment Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isReleaseAssignmentButtonDisplayed(),"Release Assignment Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isPrintAssignmentButtonDisplayed(),"Print Assignment Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isMoveAssignmentButtonDisplayed(),"Move Assignment Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit, Delete, TopOff, Move and Reprocess are displayed")
    public void verifyTasksItemsAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isEditTaskButtonDisplayed(),"Edit Task Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isRemoveTaskButtonDisplayed(),"Remove Task Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isTopOffTaskButtonDisplayed(),"Top Off Task Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isMoveAssignmentButtonDisplayed(),"Move Task Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isReprocessTasksButtonDisplayed(),"Reprocess Tasks Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Filter options are displayed")
    public void verifyFilterOptions() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isAssignmentCodeFilterDisplayed(),"Assignment Code is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isRouteFilterDisplayed(),"Route Filter is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isStopsFilterDisplayed(),"Stops Filter Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isShipperFilterDisplayed(),"Shipper Filter is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isShipToFilterDisplayed(),"ShipTo Filter is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isTasksFilterDisplayed(),"Tasks Filter is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isAssignmentTypeFilterDisplayed(),"Assignment Type is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isTaskGroupFilterDisplayed(),"Task Group is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isPercentPickedFilterDisplayed(),"Percent Picked is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isInUseByFilterDisplayed(),"In Use By is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isEstimatedTimeFilterDisplayed(),"Estimated Time is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isStandardTimeFilterDisplayed(),"Standard Time is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isActivityIndicatorFilterDisplayed(),"Activity Indicator is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isRemainingFilterDisplayed(),"Remaining is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isPrintedFilterDisplayed(),"Printed is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignment columns are present")
    public void verifyAssignmentColumnsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.areTableHeadersPresent(), "Assignment columns are not present");
        softAssert.assertAll();
    }

    @And("Validates Assignments are present")
    public void verifyAssignmentsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Integer.parseInt(outboundOrderSummaryPage.getItemsCountValue()) > 0,
                "Assignment columns are not present");
        softAssert.assertAll();
    }

    @Step
    @And("Validates Assignments Edit popup title")
    public void verifyEditAssignmentsTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getPopupTitle(), Notifications.EDIT_ASSIGNMENT,
                "Assignment columns are not present");
        softAssert.assertAll();
    }

    @And("Validates Assignments types are present")
    public void verifyAssignmentTypesArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAssignmentTypes().size() > 0,"Assignment types are not present");
        softAssert.assertAll();
    }

    @And("Validates users are present on Outbound Order Summary page")
    public void verifyUsersArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getUsers().size() > 0,"Users are not present");
        softAssert.assertAll();
    }

    @And("Validates successful message {string} on Outbound Order Summary page")
    public void validateSuccessfulNotification(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addAllocationBatchPage.getNotificationMessageText(), message,
                "Notification Message is not correct");
        softAssert.assertAll();
    }

    @And("Validates Assignments type dropdown is not empty")
    public void verifyAssignmentTypeDropdownNotEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundOrderSummaryPage.getEditAssignmentText().equals(StringUtils.EMPTY),
                "Assignment columns are not present");
        softAssert.assertAll();
    }

    @And("Validates Edit Assignment popup contains all elements")
    public void verifyEditAssignmentPopupContainsAllElements() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentTypeDisplayed(), "Assignment Type is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentTaskGroupDisplayed(), "Task Group is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentEditDateDisplayed(), "Edit Date is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentEditTimeDisplayed(), "Edit Time is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentUsersDisplayed(), "Users dropdown is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentEditCompleteDisplayed(), "Complete checkbox is not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isEditAssignmentCompleteLabelDisplayed(), "Complete Label is not present");
        softAssert.assertAll();
    }

    @And("Validates Order {string} assignments are displayed")
    public void verifyOrderAssignmentsAreDisplayed(String order) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isAssignmentTabActive(), "Assignment Tab is disabled");
        softAssert.assertTrue(outboundOrderSummaryPage.getAssignmentTableRowsNumber() > 0,
                "Assignment Table Rows are not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isGetWorkQueueOrderDisplayed(order), "Order in not Displayed");
        softAssert.assertAll();
    }

    @And("Validates Order by index {int} assignments are displayed")
    public void verifyOrderAssignmentsAreDisplayed(int index) {
        List<String> orders = List.of(outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder1(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder2(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder3(),
                 outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder4(), outboundOrderLoadsDTO.getOutboundOrders()
                .getOutboundOrder5(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder6(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isAssignmentTabActive(), "Assignment Tab is disabled");
        softAssert.assertTrue(outboundOrderSummaryPage.getAssignmentTableRowsNumber() > 0,
                "Assignment Table Rows are not present");
        softAssert.assertTrue(outboundOrderSummaryPage.isGetWorkQueueOrderDisplayed(orders.get(index)), "Order in not Displayed");
        softAssert.assertAll();
    }

    @And("Validates Cancelled status")
    public void validateOutboundOrderSummaryCancelledStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAllStatuses().contains(Statuses.CANCELLED.getStatus()),
                "Order Status " + Statuses.CANCELLED.getStatus() + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Open status")
    public void validateOutboundOrderSummaryOpenStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAllStatuses().contains(Statuses.OPEN.getStatus()),
                "Order Status " + Statuses.OPEN.getStatus() + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Open status for order")
    public void validateOutboundOrderSummaryOpenOrderStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderDetailStatusText().equalsIgnoreCase(Statuses.OPEN.getStatus()),
                "Order Status " + Statuses.OPEN.getStatus() + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Closed status")
    public void validateOutboundOrderSummaryClosedStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAllStatuses().contains(Statuses.CLOSED.getStatus()),
                "Order Status " + Statuses.CLOSED.getStatus() + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Closed status for order")
    public void validateOutboundOrderSummaryClosedOrderStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderDetailStatusText().equalsIgnoreCase(Statuses.CLOSED.getStatus()),
                "Order Status " + Statuses.CLOSED.getStatus() + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Shipment In Progress status")
    public void validateOutboundOrderSummaryShipmentInProgressStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAllStatuses().contains(Statuses.SHIPMENT_IN_PROGRESS.getStatus()),
                "Order Status " + Statuses.SHIPMENT_IN_PROGRESS.getStatus() + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Cancelled status for order")
    public void validateOutboundOrderSummaryCancelledOrderStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderDetailStatusText().equalsIgnoreCase(Statuses.CANCELLED.getStatus()),
                "Order Status " + Statuses.CANCELLED.getStatus() + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Shipment In Progress status for order")
    public void validateOutboundOrderSummaryShipmentInProgressOrderStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderDetailStatusText().equalsIgnoreCase(Statuses.SHIPMENT_IN_PROGRESS.getStatus()),
                "Order Status " + Statuses.SHIPMENT_IN_PROGRESS.getStatus() + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Outbound Order Summary status default value")
    public void validateOutboundOrderSummaryStatusText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getAllStatusDropdownText(), Statuses.ALL_STATUSES.getStatus(),
                "Outbound Order Summary status value " + Statuses.ALL_STATUSES.getStatus() + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates orders are found on Outbound Order Summary page")
    public void validateItemsFoundNotNull() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundOrderSummaryPage.getItemsFound().equals("0"),
                "Items Found amount " + outboundOrderSummaryPage.getItemsFound() + " is found");
        softAssert.assertAll();
    }

    @And("Validates default {string} door dropdown value")
    public void validateDoorDropDown(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getDoorDropDownValue(), value,
                "Door Drop Down value is " + value);
        softAssert.assertAll();
    }

    @And("Validates Outbound Order Status is Open")
    public void validateOutboundOrderOpenStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderStatusText().equalsIgnoreCase(Statuses.OPEN.getStatus()),
                "Outbound Order status " + Statuses.OPEN.getStatus() + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Outbound Order Status is Closed")
    public void validateOutboundOrderClosedStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderStatusText().equalsIgnoreCase(Statuses.CLOSED.getStatus()),
                "Outbound Order status " + Statuses.CLOSED.getStatus() + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Outbound Order Status is Cancelled")
    public void validateOutboundOrderCancelledStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderStatusText().equalsIgnoreCase(Statuses.CANCELLED.getStatus()),
                "Outbound Order status " + Statuses.CANCELLED.getStatus() + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Outbound Order Status is Shipment in progress")
    public void validateOutboundOrderShipmentInProgressStatus() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderStatusText().equalsIgnoreCase(Statuses.SHIPMENT_IN_PROGRESS.getStatus()),
                "Outbound Order status " + Statuses.SHIPMENT_IN_PROGRESS.getStatus() + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Outbound Order door {string} option")
    public void validateOutboundOrderDoor(String option) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getOrderDoorText().equalsIgnoreCase(option),
                "Outbound Order Door " + option + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Release assignment title on Outbound Order Summary page")
    public void validatePopupReleaseAssignmentTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getPopupTitleText(), Notifications.RELEASE_ASSIGNMENT,
                "Popup Title " + Notifications.RELEASE_ASSIGNMENT + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Assign doors title on Outbound Order Summary page")
    public void validatePopupAssignDoorTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getPopupTitleText(), Notifications.ASSIGN_DOORS,
                "Popup Title " + Notifications.ASSIGN_DOORS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Shipper title on Outbound Order Summary page")
    public void validatePopupShipperTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getPopupTitleText().contains(Notifications.SHIPPER),
                "Popup Title " + Notifications.SHIPPER + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Shipper columns on Outbound Order Summary page")
    public void validatePopupShipperColumns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isShipperDateDisplayed(),
                "Shipper date is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isShipperToStatusDisplayed(),
                "Shipper To Status is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isShipperFromStatusDisplayed(),
                "Shipper From Status is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isShipperUserDisplayed(),
                "Shipper User is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Source columns on Outbound Order Summary page")
    public void validatePopupSourceColumns() {
        OutboundOrderSummaryPage outboundOrderSummaryPage = new OutboundOrderSummaryPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isSourceOrderTypeDisplayed(),
                "Source Order Type is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isSourceOrderDisplayed(),
                "Source Order is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isSourceStatusDisplayed(),
                "Source Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Move popup on Outbound Order Summary page")
    public void validatePopupMoveColumns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getAccountWindowTitleText(), Notifications.MOVE,
                "Move popup page title is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isMoveShipDateDisplayed(),
                "Ship Date is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isMoveShipDateInputDisplayed(),
                "Ship Date input is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isRouteInputDisplayed(),
                "Route Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Save button is disabled on Outbound Order Summary page")
    public void validateSaveButtonIsDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isSaveButtonDisabled(), "Save button is active");
        softAssert.assertAll();
    }

    @And("Validates Save button is enabled on Outbound Order Summary page")
    public void validateSaveButtonIsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundOrderSummaryPage.isSaveButtonDisabled(), "Save button is not active");
        softAssert.assertAll();
    }

    @And("Validates {string} notification for Move popup on Outbound Order Summary page")
    public void validateNotification(String notification) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getNotificationMessageText(), notification, "Save button is not active");
        softAssert.assertAll();
    }

    @And("Validates Route dropdown is not empty on Outbound Order Summary page")
    public void validateRouteDropdownNotEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getRoutes().size() > 0,"Route list is empty");
        softAssert.assertAll();
    }

    @And("Validates Image upload is displayed")
    public void validateImageUploadIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isUploadButtonDisplayed(),"Upload button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Order Data page is displayed")
    public void validateDataPageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isRouteLabelDisplayed(),"Route Label is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isEnterNameInputDisplayed(),"Enter Name Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Review page is displayed")
    public void validateReviewPageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isReviewOrderDisplayed(),"Review Order is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Review page table is displayed")
    public void validateReviewPageTableIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isTableContentDisplayed(),"Review Order table is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Image option is not active")
    public void validateImageOptionNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isUploadButtonDisplayed(),"Upload button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Account popup is displayed")
    public void validateAccountWindowPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getAccountWindowTitleText(), Notifications.ACCOUNT_INDEX,
                    "Account Window Title " +  Notifications.ACCOUNT_INDEX + " is not correct");
        softAssert.assertTrue(outboundOrderSummaryPage.getAccountRowsNumber() > 0,
                    "Accounts are not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isAccountSearchDisplayed(),
                    "Account Search is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isAddFilterButtonDisplayed(),
                    "Add Filter Button is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isCancelButtonDisplayed(),
                    "Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} option is not active")
    public void validateOrderOptionIsNotActive(String option) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isOutboundOrderOptionActive(option),
                "Source Order Type is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Account popup is not displayed")
    public void validateAccountWindowPopupNotDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundOrderSummaryPage.isAccountSearchDisplayed(),"Account Search is displayed");
        softAssert.assertFalse(outboundOrderSummaryPage.isAddFilterButtonDisplayed(),"Add Filter Button is displayed");
        softAssert.assertFalse(outboundOrderSummaryPage.isCancelButtonDisplayed(),"Cancel Button is displayed");
        softAssert.assertAll();
    }

    @Then("Validates Account Field contains {string} text")
    public void validateAccountField(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getEnterAccountText(), text,
                "Enter Account value is not correct");
        softAssert.assertAll();
    }

    @And("Validates default {string} product value")
    public void validateProductField(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getEnterProductText(), text,
                "Enter Product value is not correct");
        softAssert.assertAll();
    }

    @SneakyThrows
    @And("Validates Account dropdown value {string} on Outbound Order Summary page")
    public void validateAccountDropDown(String account) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getEnterAccountDropDownText(account), account,
                "Enter Account name is not correct");
        softAssert.assertAll();
    }

    @SneakyThrows
    @And("Validates Account value {string} is correct on Outbound Order Summary page")
    public void validateAccountFieldValue(String account) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAccountDetailText().contains(account),
                "Account value " + account + " is not correct");
        softAssert.assertAll();
    }

    @SneakyThrows
    @And("Validates Account value by index {int} is correct on Outbound Order Summary page")
    public void validateAccountFieldValueByIndex(int index) {
        List<String> accounts = List.of(outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount1(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount2(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount3(),
                outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount4(), outboundOrderLoadsDTO.getOutboundAccounts()
                .getOutboundAccount5(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount6(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAccountDetailText().contains(accounts.get(index)),
                "Account value " + accounts.get(index) + " is not correct");
        softAssert.assertAll();
    }

    @SneakyThrows
    @And("Validates Account {string} on Outbound Order Summary page")
    public void validateAccountFieldDropDownOption(String account) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getEnterAccountDropDownOption(account).getText().contains(account),
                "Account value " + account + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Empty Account value")
    public void validateEmptyAccountValue() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getAccountDropDownValue(), StringUtils.EMPTY,
                "Account value is not empty");
        softAssert.assertAll();
    }

    @And("Validates Product {string} on Outbound Order Summary page")
    public void validateProductFieldValue(String product) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getEnterProductDropDownValue(), product,
                "Product " + product + " value is not correct");
        softAssert.assertAll();
    }

    @And("Validates product {string} in order on Outbound Order Summary page")
    public void validateProductInOrder(String product) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getProductsText().contains(product),
                "Product " + product + " is not in Order");
        softAssert.assertAll();
    }

    @And("Validates Account code {string} is correct on Outbound Order Summary page")
    public void validateOrderAccountFieldValue(String accountCode) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAccountDetailText().contains(accountCode),
                "Order Account " + accountCode + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates account {string} on Outbound Order Summary page")
    public void validateAccountData(String value) {
        SoftAssert softAssert = new SoftAssert();
        outboundOrderSummaryPage.getAccounts()
                .stream()
                .forEach(account ->
                        softAssert.assertTrue(account.toLowerCase().contains(value.toLowerCase()),
                                "Order Account " + value + " is not present"));
        softAssert.assertAll();
    }

    @And("Validates All Filters Panel is active on Outbound Order Summary page")
    public void validateAllFiltersPanelIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundOrderSummaryPage.isStatusIconActive(), "Status Icon not Active");
        softAssert.assertFalse(outboundOrderSummaryPage.isWorkIconActive(), "Work Icon not Active");
        softAssert.assertFalse(outboundOrderSummaryPage.isAssignIconActive(), "Assign Icon not Active");
        softAssert.assertAll();
    }

    @And("Validates All Filters Panel is not active on Outbound Order Summary page")
    public void validateAllFiltersPanelIsNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isStatusIconActive(), "Status Icon is Active");
        softAssert.assertTrue(outboundOrderSummaryPage.isWorkIconActive(), "Work Icon is Active");
        softAssert.assertTrue(outboundOrderSummaryPage.isAssignIconActive(), "Assign Icon is Active");
        softAssert.assertAll();
    }

    @And("Validates order columns are displayed on Outbound Order Summary page")
    public void validateOrderColumnsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isOrdersColumnDisplayed(), "Orders Column not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isQuantityColumnDisplayed(), "Quantity Column not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isLinesColumnDisplayed(), "Lines Column not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isPalletsColumnDisplayed(), "Pallets Column not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isCubeColumnDisplayed(), "Cube Column not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isWeightColumnDisplayed(), "Weight Column not Displayed");
        softAssert.assertAll();
    }

    @And("Validates order columns are not displayed")
    public void validateOrderColumnsNotDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundOrderSummaryPage.isOrdersColumnDisplayed(), "Orders Column is Displayed");
        softAssert.assertFalse(outboundOrderSummaryPage.isQuantityColumnDisplayed(), "Quantity Column is Displayed");
        softAssert.assertFalse(outboundOrderSummaryPage.isLinesColumnDisplayed(), "Lines Column is Displayed");
        softAssert.assertFalse(outboundOrderSummaryPage.isPalletsColumnDisplayed(), "Pallets Column is Displayed");
        softAssert.assertFalse(outboundOrderSummaryPage.isCubeColumnDisplayed(), "Cube Column is Displayed");
        softAssert.assertFalse(outboundOrderSummaryPage.isWeightColumnDisplayed(), "Weight Column is Displayed");
        softAssert.assertAll();
    }

    @And("Validates Order Statuses are displayed on Outbound Order Summary page")
    public void validateOrderStatusesDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isShippedStatusDisplayed(), "Shipped Status is not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isAuditStatusDisplayed(), "Audit Status is not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isPickedStatusDisplayed(), "Picked Status is not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isUnallocatedStatusDisplayed(), "Unallocated Status is not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isShortsStatusDisplayed(), "Shorts Status is not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isWaitingInboundStatusDisplayed(), "Waiting Inbound Status is not Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isRemainderStatusDisplayed(), "Remainder Status is not Displayed");
        softAssert.assertAll();
    }

    @And("Validates Order Statuses are not displayed")
    public void validateOrderStatusesNotDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isShippedStatusDisplayed(), "Shipped Status is Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isAuditStatusDisplayed(), "Audit Status is Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isPickedStatusDisplayed(), "Picked Status is Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isUnallocatedStatusDisplayed(), "Unallocated Status is Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isShortsStatusDisplayed(), "Shorts Status is Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isWaitingInboundStatusDisplayed(), "Waiting Inbound Status is Displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isRemainderStatusDisplayed(), "Remainder Status is Displayed");
        softAssert.assertAll();
    }

    @And("Validates Orders Count is displayed on Outbound Order Summary page")
    public void validateOrdersCountDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundOrderSummaryPage.getItemsFound().equals(""), "Items Found indicator is Empty");
        softAssert.assertAll();
    }

    @And("Validates Orders Count is not displayed")
    public void validateOrdersCountNotDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundOrderSummaryPage.getItemsFound().equals(""), "Items Found indicator is not Empty");
        softAssert.assertAll();
     }

    @And("Validates Edit Order popup")
    public void validateEditOrderPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAccountWindowTitleText().contains(Notifications.EDIT_ORDER),
                "Edit Order popup is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit Order {string}")
    public void validateEditOrderName(String order) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAccountWindowTitleText().contains(order),
                "Order on Edit order popup is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit Order by index {int}")
    public void validateEditOrderNameByIndex(int index) {
        List<String> orders = List.of(outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder1(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder2(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder3(),
                 outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder4(), outboundOrderLoadsDTO.getOutboundOrders()
                .getOutboundOrder5(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder6(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getAccountWindowTitleText().contains(orders.get(index)),
                "Order on Edit order popup is not displayed");
        softAssert.assertAll();
    }

    @And("Validates scheduled date {string} and scheduled time {string}")
    public void validateDateAndTime(String date, String time) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getScheduledDateValue().contains(date),
                "Scheduled date is not correct");
        softAssert.assertTrue(outboundOrderSummaryPage.getScheduledTimeValue().contains(time),
                "Scheduled time is not correct");
        softAssert.assertAll();
    }

    @And("Validates scheduled date by index {int} and scheduled time {string}")
    public void validateDateAndTime(int index, String time) {
        List<String> dates = List.of(outboundOrderLoadsDTO.getStartDates().getStartDate1(), outboundOrderLoadsDTO
                .getStartDates().getStartDate2(), outboundOrderLoadsDTO.getStartDates().getStartDate3(),
                outboundOrderLoadsDTO.getStartDates().getStartDate4(), outboundOrderLoadsDTO.getStartDates().getStartDate5(),
                outboundOrderLoadsDTO.getStartDates().getStartDate6());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getScheduledDateValue().contains(dates.get(index)),
                "Scheduled date is not correct");
        softAssert.assertTrue(outboundOrderSummaryPage.getScheduledTimeValue().contains(time),
                "Scheduled time is not correct");
        softAssert.assertAll();
    }

    @And("Validates scheduled date and scheduled time are displayed")
    public void validateDateAndTimeDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isScheduledDateInputDisplayed(),"Scheduled date is not displayed");
        softAssert.assertTrue(outboundOrderSummaryPage.isScheduledTimeInputDisplayed(),"Scheduled time is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Carrier dropdown is displayed")
    public void validateCarrierDropdown() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isCarrierDropdownDisplayed(),
                "Carrier Dropdown is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Carrier dropdown default option {string}")
    public void validateCarrierDropdownDefaultOption(String option) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundOrderSummaryPage.getCarrierDropdownText(), option,
                "Carrier Dropdown option is not correct");
        softAssert.assertAll();
    }

    @And("Validates Payment type dropdown is displayed")
    public void validatePaymentTypeDropdownDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.isPaymentTypeDropdownDisplayed(),
                "Payment type Dropdown option is not correct");
        softAssert.assertAll();
    }

    @And("Validates correct comments {string} are displayed")
    public void validateCorrectCommentsDisplayed(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundOrderSummaryPage.getCommentsText().contains(text),
                "Comments are not correct");
        softAssert.assertAll();
    }

}
