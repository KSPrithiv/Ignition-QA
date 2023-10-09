package steps.validations.outbound.routesummary;

import common.constants.FilePaths;
import common.constants.Notifications;
import common.constants.TimeFormats;
import common.enums.DockDoorOption;
import common.enums.Statuses;
import common.utils.objectmapper.ObjectMapperWrapper;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import objects.outbound.OutboundOrderLoadsDTO;
import org.apache.commons.lang3.StringUtils;
import org.testng.asserts.SoftAssert;
import ui.pages.outbound.routesummary.OutboundRouteSummaryPage;
import java.util.Calendar;
import java.util.List;

public class OutboundRouteSummaryPageValidations {
    OutboundRouteSummaryPage outboundRouteSummaryPage = new OutboundRouteSummaryPage();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

    @And("Validates Outbound Route Summary page is displayed")
    public void validateOutboundRouteSummaryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteOptionsDisplayed(), "Route Options is not present");
        softAssert.assertTrue(outboundRouteSummaryPage.isStatusDropDownDisplayed(Statuses.ALL_STATUSES.getStatus()),
                    "All Statuses DropDown is not present");
        softAssert.assertTrue(outboundRouteSummaryPage.isDoorDropDownDisplayed(DockDoorOption.SELECT_DOOR.getDockDoorOption()),
                    "Doors DropDown is not present");
        softAssert.assertTrue(outboundRouteSummaryPage.isTableContentDisplayed(), "Table Content is not present");
        softAssert.assertAll();
    }

    @And("Validates Outbound Route Summary start date {string} and end date {string} on Outbound Route Summary page")
    public void validateOutboundRouteSummaryStartEndDates(String startDate, String endDate) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteStartCurrentValue(), startDate,
                "Route Start on Outbound Route is not correct");
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteStartFutureValue(), endDate,
                "Future Date on Outbound Route is not correct");
        softAssert.assertAll();
    }

    @And("Validates Outbound Route Summary dates on Outbound Route Summary page")
    public void validateOutboundRouteSummaryDates() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteStartCurrentValue(), TimeConversion
                        .getFormattedCurrentDate(TimeFormats.format_MMddyyyy),
                "Route Start on Outbound Route is not correct");
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteStartFutureValue(), TimeConversion
                        .futureDate(1, Calendar.DATE, TimeConversion
                                .getFormattedCurrentDate(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy),
                "Future Date on Outbound Route is not correct");
        softAssert.assertAll();
    }

    @And("Validates Outbound Route is empty on Outbound Route Summary page")
    public void validateOutboundRouteEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getRouteValue().isEmpty(),"Route is not empty");
        softAssert.assertAll();
    }

    @And("Route {string} is displayed on Outbound Route Summary page")
    public void validateRouteDisplayed(String route) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteValue(), route,"Route is not correct");
        softAssert.assertAll();
    }

    @And("Route by index {int} is displayed on Outbound Route Summary page")
    public void validateRouteByIndexDisplayed(int index) {
        List<String> routes = List.of(outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute1(), outboundOrderLoadsDTO
                .getOutboundRoutes().getOutboundRoute2(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute3(),
                 outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute4(), outboundOrderLoadsDTO.getOutboundRoutes()
                .getOutboundRoute5(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute6(), outboundOrderLoadsDTO
                .getOutboundRoutes().getOutboundRoute7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteValue(), routes.get(index),"Route is not correct");
        softAssert.assertAll();
    }

    @And("Account {string} is displayed on Outbound Route Summary page")
    public void validateAccountDisplayed(String account) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getAccountValue(), account, "Account is not correct");
        softAssert.assertAll();
    }

    @And("Account by index {int} is displayed on Outbound Route Summary page")
    public void validateAccountByIndexDisplayed(int index) {
        List<String> accounts = List.of(outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount1(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount2(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount3(),
                 outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount4(), outboundOrderLoadsDTO.getOutboundAccounts()
                .getOutboundAccount5(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount6(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getAccountValue(), accounts.get(index), "Account is not correct");
        softAssert.assertAll();
    }

    @And("Status All status is displayed on Outbound Route Summary page")
    public void validateAllStatusDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getStatusText(Statuses.ALL_STATUSES.getStatus()),
                Statuses.ALL_STATUSES.getStatus(),"Status is not correct");
        softAssert.assertAll();
    }

    @And("Status Select door is displayed on Outbound Route Summary page")
    public void validateDoorDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isDoorDropDownDisplayed(DockDoorOption.SELECT_DOOR.getDockDoorOption()),
                "Select door is not displayed");
        softAssert.assertAll();
    }

    @And("Door dropdown is displayed on Outbound Route Summary page")
    public void validateDoorDropDownDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isDoorDropDownDisplayed(DockDoorOption.DOOR.getDockDoorOption()),
                "Door is not displayed");
        softAssert.assertAll();
    }

    @And("Routes are displayed on Outbound Route Summary page")
    public void validateRoutesDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getRoutes().size() > 0, "Routes are not present");
        softAssert.assertAll();
    }

    @And("Routes are correct and equal {string} on Outbound Route Summary page")
    public void validateRoutesCorrect(String route) {
        SoftAssert softAssert = new SoftAssert();
        outboundRouteSummaryPage.getRoutes()
                .stream()
                .forEach(el ->
                 softAssert.assertEquals(el.getText().trim(), route,"Route is not correct"));
        softAssert.assertAll();
    }

    @And("Routes are correct and equal route by index {int} on Outbound Route Summary page")
    public void validateRoutesByIndexCorrect(int index) {
        List<String> routes = List.of(outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute1(), outboundOrderLoadsDTO
                .getOutboundRoutes().getOutboundRoute2(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute3(),
                 outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute4(), outboundOrderLoadsDTO.getOutboundRoutes()
                .getOutboundRoute5(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute6(), outboundOrderLoadsDTO
                .getOutboundRoutes().getOutboundRoute7());
        SoftAssert softAssert = new SoftAssert();
        outboundRouteSummaryPage.getRoutes()
                .stream()
                .forEach(el -> softAssert.assertEquals(el.getText().trim(), routes.get(index),"Route is not correct"));
        softAssert.assertAll();
    }

    @And("Validates No Record Outbound Route Summary grid on Outbound Route Summary page")
    public void validateNoRecordInOutboundRouteSummaryGrid() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getGridTableRowContent(0).contains(Notifications.NO_DATA), "Route is not in table");
        softAssert.assertAll();
    }

    @And("Validates Account Index popup on Outbound Route Summary page")
    public void validateAccountIndexPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.ACCOUNT_INDEX,
                "Account Index popup is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Items Count on Outbound Route Summary page")
    public void validateItemsCount() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundRouteSummaryPage.getItemsCountNumberValue().equals(StringUtils.EMPTY),
                "Routes count are not found");
        softAssert.assertAll();
    }

    @And("Validates Items Counts displayed on Outbound Route Summary page")
    public void validateItemsCountDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isItemsCountDisplayed(),"Routes items are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Save and Cancel buttons are displayed on Outbound Route Summary page")
    public void validateSaveAndCancelButtonsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isSaveButtonDisplayed(),"Save Button is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Route options from Route dropdown are disabled on Outbound Route Summary page")
    public void validateRouteOptionsDisabled() {
        SoftAssert softAssert = new SoftAssert();
        outboundRouteSummaryPage.getRouteDropdownOptions()
                .stream()
                .forEach(option ->
                 softAssert.assertTrue(option.getAttribute("class").contains("disabled"),
                         "Route option is not disabled"));
        softAssert.assertAll();
    }

    @And("Validates Route options from Route dropdown are enabled on Outbound Route Summary page")
    public void validateRouteOptionsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        outboundRouteSummaryPage.getRouteDropdownOptions()
                .stream()
                .forEach(option ->
                        softAssert.assertFalse(option.getAttribute("class").contains("disabled"),
                                "Route option is not enabled"));
        softAssert.assertAll();
    }

    @And("Validates that time for route {int} is displayed on Outbound Route Summary page")
    public void validateTimeForRouteDisplayed(int row) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundRouteSummaryPage.getGridTableRowTime(row).getText().equals(StringUtils.EMPTY),
                "Route time is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Assign door title for Route on Outbound Route Summary page")
    public void validatePopupAssignDoorTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.ASSIGN_DOORS,
                "Popup Title " + Notifications.ASSIGN_DOORS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Door dropdown is not empty by default on Outbound Route Summary page")
    public void validateDoorDropdownByDefault() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getDoorText().contains(StringUtils.EMPTY),
                "Door dropdown is empty");
        softAssert.assertAll();
    }

    @And("Validates Door {string} value is correct on Outbound Route Summary page")
    public void validateDoorValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getDoorText().contains(value),
                "Door " + value + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Doors are present in dropdown on Outbound Route Summary page")
    public void validateDoorsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getDoors().size() > 0,
                "Doors dropdown is empty");
        softAssert.assertAll();
    }

    @And("Validates Edit route window elements on Outbound Route Summary page")
    public void validateEditRouteWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteCodeLabelDisplayed(),"Route Code label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteCodeInputDisplayed(),"Route Code input is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isScheduledDateLabelDisplayed(),"Scheduled Date label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isScheduledDateDisplayed(),"Scheduled Date is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isCarrierLabelDisplayed(),"Carrier label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isCarrierInputDisplayed(),"Carrier input is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTrailerLabelDisplayed(),"Trailer label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTrailerInputDisplayed(),"Trailer input is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTemperatureLabelDisplayed(),"Temperature label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTemperatureInputDisplayed(),"Temperature input is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteTypeLabelDisplayed(),"Route Type label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteTypeInputDisplayed(),"Route Type input is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isScheduledTimeLabelDisplayed(),"Scheduled Time label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isScheduledTimeInputDisplayed(),"Scheduled Time input is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isDriverLabelDisplayed(),"Driver label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isDriverInputDisplayed(),"Driver input is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isMaxStopsLabelDisplayed(),"Max stops label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isMaxStopsInputDisplayed(),"Max stops input is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isDoorDropDownDisplayed(DockDoorOption.DOOR.getDockDoorOption()),
                "Door is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit Route code field and window title on Outbound Route Summary page")
    public void validateEditRouteCodeWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getWindowTitleText().contains(outboundRouteSummaryPage
                .getRouteCodeInputValue()) ,"Route code is not correct on window title");
        softAssert.assertAll();
    }

    @And("Validates Edit Route code field equals {string} on Outbound Route Summary page")
    public void validateEditRouteCodeFieldValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteCodeInputValue(), value,
                "Route code field is not correct");
        softAssert.assertAll();
    }

    @And("Validates Route with index {int} contains {string} on Outbound Route Summary page")
    public void validateEditRouteCodeFieldValue(int index, String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getRoutesContentTextByIndex(index).contains(value),
                "Route does not contain " + value);
        softAssert.assertAll();
    }

    @And("Validates Route type is displayed on Outbound Route Summary page")
    public void validateRouteCodeDefaultValue() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteTypeLabelDisplayed(), "Route type label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteTypeInputDisplayed(), "Route type input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Route type {string} value on Outbound Route Summary page")
    public void validateRouteTypeDefaultValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteTypeText(), value,
                "Route code value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Route type by index {int} value on Outbound Route Summary page")
    public void validateRouteTypeDefaultValueByIndex(int index) {
        List<String> types = List.of(outboundOrderLoadsDTO.getOutboundOrderTypes().getOutboundOrderType1(), outboundOrderLoadsDTO
                .getOutboundOrderTypes().getOutboundOrderType2(), outboundOrderLoadsDTO.getOutboundOrderTypes().getOutboundOrderType3(),
                 outboundOrderLoadsDTO.getOutboundOrderTypes().getOutboundOrderType4(), outboundOrderLoadsDTO.getOutboundOrderTypes()
                .getOutboundOrderType5(), outboundOrderLoadsDTO.getOutboundOrderTypes().getOutboundOrderType6());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getRouteTypeText(), types.get(index),
                "Route code value is not correct");
        softAssert.assertAll();
    }

    @And("Validates carrier {string} value on Outbound Route Summary page")
    public void validateCarrierValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getCarrierInputText().contains(value),
                "Carrier value is not correct");
        softAssert.assertAll();
    }

    @And("Validates carrier by index {int} value on Outbound Route Summary page")
    public void validateCarrierValueByIndex(int index) {
        List<String> carriers = List.of(outboundOrderLoadsDTO.getOutboundCarriers().getOutboundCarrier1(), outboundOrderLoadsDTO
                .getOutboundCarriers().getOutboundCarrier2(), outboundOrderLoadsDTO.getOutboundCarriers().getOutboundCarrier3(),
                 outboundOrderLoadsDTO.getOutboundCarriers().getOutboundCarrier4(), outboundOrderLoadsDTO.getOutboundCarriers()
                .getOutboundCarrier5(), outboundOrderLoadsDTO.getOutboundCarriers().getOutboundCarrier6());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getCarrierInputText().contains(carriers.get(index)),
                "Carrier value is not correct");
        softAssert.assertAll();
    }

    @And("Validates driver {string} value on Outbound Route Summary page")
    public void validateDriverValue(String driver) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getDriverInputValue().contains(driver),
                "Driver value is not correct");
        softAssert.assertAll();
    }

    @And("Validates max stops {string} value on Outbound Route Summary page")
    public void validateMaxStopsValue(String maxStop) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getMaxStopsValue().contains(maxStop),
                "Max Stops value is not correct");
        softAssert.assertAll();
    }

    @And("Validates max stops by index {int} value on Outbound Route Summary page")
    public void validateMaxStopsValueByIndex(int index) {
        List<String> stops = List.of(outboundOrderLoadsDTO.getOutboundMaxStops().getOutboundMaxStop1(), outboundOrderLoadsDTO
                .getOutboundMaxStops().getOutboundMaxStop2(), outboundOrderLoadsDTO.getOutboundMaxStops().getOutboundMaxStop3());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getMaxStopsValue().contains(stops.get(index)),
                "Max Stops value is not correct");
        softAssert.assertAll();
    }

    @And("Validates temperature {string} value on Outbound Route Summary page")
    public void validateTemperatureValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getTemperatureValue().contains(value),
                "Temperature value is not correct");
        softAssert.assertAll();
    }

    @And("Validates temperature by index {int} value on Outbound Route Summary page")
    public void validateTemperatureValueByIndex(int index) {
        List<String> temperatures = List.of(outboundOrderLoadsDTO.getOutboundTemperatures().getOutboundTemperature1(),
                outboundOrderLoadsDTO.getOutboundTemperatures().getOutboundTemperature2(), outboundOrderLoadsDTO
                .getOutboundTemperatures().getOutboundTemperature3());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getTemperatureValue().contains(temperatures.get(index)),
                "Temperature value is not correct");
        softAssert.assertAll();
    }

    @And("Validates driver value is empty on Outbound Route Summary page")
    public void validateDriverDefaultValue() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getDriverInputValue().equals(StringUtils.EMPTY),
                "Driver default value is not empty");
        softAssert.assertAll();
    }

    @And("Validates Scheduled Date and Scheduled Time are displayed on Outbound Route Summary page")
    public void validateScheduledDateAndScheduledTimeDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isScheduledDateDisplayed(),
                "Scheduled Date is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isScheduledTimeInputDisplayed(),
                "Scheduled Time input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates scheduled date {string} and scheduled time {string} values on Outbound Route Summary page")
    public void validateScheduledDateAndScheduledTimeValues(String date, String time) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getScheduledDateValue(), date,
                "Scheduled Date is not correct");
        softAssert.assertTrue(outboundRouteSummaryPage.getScheduledTimeValue().contains(time),
                "Scheduled Time is not correct");
        softAssert.assertAll();
    }

    @And("Validates search for product window on Outbound Route Summary page")
    public void validateProductWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.PRODUCT_INDEX,
                "Product index window popup not found");
        softAssert.assertAll();
    }

    @And("Validates change status is active on Outbound Route Summary page")
    public void validateChangeStatusIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundRouteSummaryPage.isChangeStatusDisabled(),"Change status is not active");
        softAssert.assertAll();
    }

    @And("Validates change status is not active on Outbound Route Summary page")
    public void validateChangeStatusNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isChangeStatusDisabled(),"Change status is active");
        softAssert.assertAll();
    }

    @And("Validates work item is active on Outbound Route Summary page")
    public void validateWorkItemIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundRouteSummaryPage.isWorkItemDisabled(),"Work item is not active");
        softAssert.assertAll();
    }

    @And("Validates work item is not active on Outbound Route Summary page")
    public void validateWorkItemNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isWorkItemDisabled(),"Work item is active");
        softAssert.assertAll();
    }

    @And("Validates assign item is active on Outbound Route Summary page")
    public void validateAssignItemIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundRouteSummaryPage.isAssignItemDisabled(),"Assign item is not active");
        softAssert.assertAll();
    }

    @And("Validates assign item is not active on Outbound Route Summary page")
    public void validateAssignItemNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignItemDisabled(),"Assign item is active");
        softAssert.assertAll();
    }

    @And("Validates Routes, Order, Quantity, Lines, Pallets, Cube, Weight and Amount columns displayed on Outbound Route Summary page")
    public void validateColumnsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isRoutesColumnDisplayed(),"Routes Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isOrdersColumnDisplayed(),"Orders Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isQuantityColumnDisplayed(),"Quantity Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isLinesColumnDisplayed(),"Lines Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isPalletsColumnDisplayed(),"Pallets Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isCubeColumnDisplayed(),"Cube Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isWeightColumnDisplayed(),"Weight Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isAmountColumnDisplayed(),"Amount Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Shipped, Audit, Picked, Unallocated, Shorts, Waiting inbound and Remainder status displayed on Outbound Route Summary page")
    public void validateStatusesDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isShippedStatusDisplayed(),"Shipped Status is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isAuditStatusDisplayed(),"Audit Status is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isPickedStatusDisplayed(),"Picked Status is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isUnallocatedStatusDisplayed(),"Unallocated Status is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isShortsStatusDisplayed(),"Shorts Status is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isWaitingInboundDisplayed(),"Waiting Inbound is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRemainderStatusDisplayed(),"Remainder Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignments tab and Tasks tab are displayed on Outbound Route Summary page")
    public void verifyAssignmentsAndTasksTabsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentTabDisplayed(), "Assignment Tab is displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTasksTabDisabled(), "Tasks Tab is displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignments tab is active by default on Outbound Route Summary page")
    public void verifyAssignmentTabIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentTabActive(), "Assignment Tab is not active");
        softAssert.assertAll();
    }

    @And("Validates Assignment Type filter is displayed on Outbound Route Summary page")
    public void verifyAssignmentTypeDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentTypeTabDisplayed(), "Assignment Type is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Types Tab is displayed on Outbound Route Summary page")
    public void verifyTypesTabDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTypesDropdownDisplayed(), "Types Tab is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTopOffTaskButtonDisplayed(), "Top Off Task Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Columns on Types Tab are displayed on Outbound Route Summary page")
    public void verifyTypesColumnDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isProductColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isQtyColumnDisplayed(), "Qty Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isFromColumnDisplayed(), "From Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isToColumnDisplayed(), "To Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTypeColumnDisplayed(), "Type Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTaskGroupColumnDisplayed(), "Task Group is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isStatusColumnDisplayed(), "Status Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentNumColumnDisplayed(), "Assignment Num Column is not displayed");
    //  softAssert.assertTrue(outboundRouteSummaryPage.isInUseByColumnDisplayed(), "In Use By Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isPriorityColumnDisplayed(), "Priority Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteColumnDisplayed(), "Route Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isStopColumnDisplayed(), "Stop Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isShipperColumnDisplayed(), "Shipper Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isVelocityColumnDisplayed(), "Velocity Column is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isDescriptionColumnDisplayed(), "Description Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Tasks Items Count is displayed on Outbound Route Summary page")
    public void verifyTasksCountDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundRouteSummaryPage.getTasksItemsCountNumberValue().equals(StringUtils.EMPTY), "Tasks items count is not found");
        softAssert.assertAll();
    }

    @And("Validates Tasks Items is displayed on Outbound Route Summary page")
    public void verifyTasksItemsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTasksItemsDisplayed(), "Tasks items count is not found");
        softAssert.assertAll();
    }

    @And("Validates Assignment Items Count is displayed on Outbound Route Summary page")
    public void verifyAssignmentCountDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundRouteSummaryPage.getAssignmentItemsCountNumberValue().equals("0"),
                "Assignment items count is not found");
        softAssert.assertAll();
    }

    @And("Validates Assignment Items is displayed on Outbound Route Summary page")
    public void verifyAssignmentItemsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentItemsDisplayed(), "Assignment items count is not found");
        softAssert.assertAll();
    }

    @And("Validates selected Assignment Items is displayed on Outbound Route Summary page")
    public void verifySelectedAssignmentDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentSelectedItemsFoundDisplayed(),
                "Selected Assignment Selected items is not found");
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentSelectedItemsCountNumberDisplayed(),
                "Selected Assignment Selected items count is not found");
        softAssert.assertAll();
    }

    @And("Validates selected Tasks Items is displayed on Outbound Route Summary page")
    public void verifySelectedTasksDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTasksSelectedItemsCountNumberDisplayed(),
                "Selected Tasks Selected items is not found");
        softAssert.assertTrue(outboundRouteSummaryPage.isTasksSelectedItemsCountNumberDisplayed(),
                "Selected Tasks Selected items count is not found");
        softAssert.assertAll();
    }

    @And("Validates Route Title is displayed on Outbound Route Summary page")
    public void verifyRouteTitleDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteTitleDisplayed(),"Route Title is not found");
        softAssert.assertAll();
    }

    @And("Validates Tasks options Edit, Delete, Move and Reprocess are disabled on Outbound Route Summary page")
    public void verifyTasksOptionsDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTasksButtonDisabled(),"Edit Tasks Button is enabled");
        softAssert.assertTrue(outboundRouteSummaryPage.isDeleteTasksButtonDisabled(),"Delete Tasks Button is enabled");
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveTaskDisplayed(),"Move Tasks Button is enabled");
        softAssert.assertTrue(outboundRouteSummaryPage.isReprocessButtonDisabled(),"Reprocess Tasks Button is enabled");
        softAssert.assertAll();
    }

    @And("Validates Tasks option Top Off is disabled on Outbound Route Summary page")
    public void verifyTaskTopOffOptionsDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTopOffButtonDisabled(),"Top Off Button is enabled");
        softAssert.assertAll();
    }

    @And("Validates Tasks option Top Off is enabled on Outbound Route Summary page")
    public void verifyTaskTopOffOptionsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundRouteSummaryPage.isTopOffButtonDisabled(),"Top Off Button is disabled");
        softAssert.assertAll();
    }

    @And("Validates Tasks Reprocess is disabled on Outbound Route Summary page")
    public void verifyTaskReprocessDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isReprocessButtonDisabled(),"Reprocess Tasks Button is enabled");
        softAssert.assertAll();
    }

    @And("Validates Tasks Reprocess is enabled on Outbound Route Summary page")
    public void verifyTaskReprocessEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundRouteSummaryPage.isReprocessButtonDisabled(),"Reprocess Tasks Button is disabled");
        softAssert.assertAll();
    }

    @And("Validates Tasks options Edit, Delete, Move and Reprocess are enabled on Outbound Route Summary page")
    public void verifyTasksOptionsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundRouteSummaryPage.isEditTasksButtonDisabled(),"Edit Tasks Button is disabled");
        softAssert.assertFalse(outboundRouteSummaryPage.isDeleteTasksButtonDisabled(),"Delete Tasks Button is disabled");
        softAssert.assertFalse(outboundRouteSummaryPage.isMoveTasksButtonDisabled(),"Move Tasks Button is disabled");
        softAssert.assertFalse(outboundRouteSummaryPage.isReprocessButtonDisabled(),"Reprocess Tasks Button is disabled");
        softAssert.assertAll();
    }

    @And("Validates Assignment tab options are displayed on Outbound Route Summary page")
    public void verifyAssignmentTabOptionsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditAssignmentDisplayed(), "Edit Assignment is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isDeleteAssignmentDisplayed(), "Delete Assignment is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isReleaseAssignmentDisplayed(), "Release Assignment is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isPrintAssignmentDisplayed(), "Print Assignment is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveTaskDisplayed(), "Move Task is not displayed");
        softAssert.assertAll();
    }

    @And("Validates that Add filter is displayed on Outbound Route Summary page")
    public void verifyFilterDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAddFilterButtonDisplayed(),"Add filter is not displayed");
        softAssert.assertAll();
    }

    @And("Validates that Add Filter options for Assignments are displayed on Outbound Route Summary page")
    public void verifyAssignmentsFilterOptions() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentCodeFilterDisplayed(),"Assignment Code is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteFilterDisplayed(),"Route Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isStopsFilterDisplayed(),"Stops Filter Button is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isShipperFilterDisplayed(),"Shipper Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isShipToFilterDisplayed(),"ShipTo Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTasksFilterDisplayed(),"Tasks Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignToFilterDisplayed(),"Assign To Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isReleasedFilterDisplayed(),"Released Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isQtyFilterDisplayed(),"Quantity Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isCubeFilterDisplayed(),"Cube Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isWeightFilterDisplayed(),"Weight Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentTypeFilterDisplayed(),"Assignment Type Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTaskGroupFilterDisplayed(),"Task Group Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isPercentPickedFilterDisplayed(),"Percent Picked Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isInUseByFilterDisplayed(),"InUseByd Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isEstimatedTimeFilterDisplayed(),"Estimated Time Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isStandardTimeFilterDisplayed(),"Standard Time Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isActualTimeFilterDisplayed(),"Actual Time Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isActivityIndicatorFilterDisplayed(),"Activity Indicator Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRemainingFilterDisplayed(),"Remaining Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isPrintedFilterDisplayed(),"Printed Filter is not displayed");
        softAssert.assertAll();
    }

    @And("Validates that Add Filter options for Tasks are displayed on Outbound Route Summary page")
    public void verifyFilterOptions() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isProductFilterDisplayed(),"Product Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isQuantityFilterDisplayed(),"Quantity Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isFromFilterDisplayed(),"From Filter Button is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isToFilterDisplayed(),"To Filter Button is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTypeFilterDisplayed(),"Type Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTaskGroupFilterDisplayed(),"Task Group Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isStatusFilterDisplayed(),"Status Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentNumberFilterDisplayed(),"Assignment Number Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isInUseByFilterDisplayed(),"In Use By Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isPriorityFilterDisplayed(),"Priority Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteFilterDisplayed(),"Route Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isStopFilterDisplayed(),"Stop Filter is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isShipperFilterDisplayed(),"Shipper Filter is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Task table columns are present on Outbound Route Summary page")
    public void verifyTasksColumnsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.areTaskTableHeadersPresent(), "Task table columns are not present");
        softAssert.assertAll();
    }

    @And("Validates Assignments table columns are present on Outbound Route Summary page")
    public void verifyAssignmentColumnsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.areAssignmentsHeadersPresent(), "Assignments table columns are not present");
        softAssert.assertAll();
    }

    @And("Validates Assignment types are present on Outbound Route Summary page")
    public void verifyAssignmentTypesArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getAssignmentTypes().size() > 0,"Assignment types are not present");
        softAssert.assertAll();
    }

    @And("Validates Task groups are present on Outbound Route Summary page")
    public void verifyTaskGroupArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getTaskGroupItems().size() > 0,"Task Groups are not present");
        softAssert.assertAll();
    }

    @And("Validates Types are present on Outbound Route Summary page")
    public void verifyTypesArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getTypesItems().size() > 0,"Types are not present");
        softAssert.assertAll();
    }

    @And("Validates Statuses are present on Outbound Route Summary page")
    public void verifyStatusesArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getStatusesTabItems().size() > 0,"Statuses are not present");
        softAssert.assertAll();
    }

    @And("Validates Assignments block is present on Outbound Route Summary page")
    public void verifyAssignmentsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isAssignmentTabDisplayed(),"Assignment block is not present");
        softAssert.assertAll();
    }

    @And("Verifies Assign window is displayed on Outbound Route Summary page")
    public void verifyAssignPopupDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.ASSIGN,
                "Assign popup is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isReleaseCheckboxDisplayed(),
                "Release Checkbox is not displayed");
        softAssert.assertAll();
    }

    @And("Validates users are present for Assign Route on Outbound Route Summary page")
    public void verifyUsersArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getUsers().size() > 0,"Users are not present");
        softAssert.assertAll();
    }

    @And("Validates user dropdown for Assign Route is not empty on Outbound Route Summary page")
    public void verifyUsersDropdownIsNotEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundRouteSummaryPage.getUserDropdownText().equals(StringUtils.EMPTY),
                "Users dropdown is empty");
        softAssert.assertAll();
    }

    @And("Verifies Edit Task window is displayed on Outbound Route Summary page")
    public void verifyEditTaskPopupDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getWindowTitleText().contains(Notifications.EDIT_TASK),
                "Edit Task window is not displayed");
        softAssert.assertAll();
    }

    @And("Verifies Quantity field of Edit task window is displayed on Outbound Route Summary page")
    public void verifyQtyFieldDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskQtyLabelDisplayed(),
                "Edit Task Qty Label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskQtyDisplayed(),
                "Edit Task Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Verifies Quantity input of Edit task window is not empty on Outbound Route Summary page")
    public void verifyEditTaskQtyValueDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundRouteSummaryPage.getEditTaskQtyValue().equals(StringUtils.EMPTY),
                "Edit Task Qty Label is not displayed");
        softAssert.assertAll();
    }

    @And("Verifies Priorities field of Edit task window is displayed on Outbound Route Summary page")
    public void verifyEditTaskPriorityDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskPrioritiesDisplayed(),
                "Edit Task Priorities is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskPrioritiesLabelDisplayed(),
                "Edit Task Priorities Label is not displayed");
        softAssert.assertAll();
    }

    @And("Verifies Priorities input {string} value of Edit task window on Outbound Route Summary page")
    public void verifyEditTaskPriorityDefaultValueDisplayed(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getPriorityInputDefaultText().contains(value),
                "Edit Task Priorities value is not correct");
        softAssert.assertAll();
    }

    @And("Verifies Reason field of Edit task window is displayed on Outbound Route Summary page")
    public void verifyEditTaskReasonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskReasonLabelDisplayed(),
                "Edit Task Reason label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskReasonDisplayed(),
                "Edit Task Reason is not displayed");
        softAssert.assertAll();
    }

    @And("Verifies Group field of Edit task window is displayed on Outbound Route Summary page")
    public void verifyEditTaskGroupDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskGroupLabelDisplayed(),
                "Edit Task Group label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskGroupDisplayed(),
                "Edit Task Group is not displayed");
        softAssert.assertAll();
    }

    @And("Verifies From Location field of Edit task window is displayed on Outbound Route Summary page")
    public void verifyEditTaskFromLocationDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskFromLocationLabelDisplayed(),
                "Edit Task From Location label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskFromLocationDisplayed(),
                "Edit Task From Location is not displayed");
        softAssert.assertAll();
    }

    @And("Verifies Pallets field of Edit task window is displayed on Outbound Route Summary page")
    public void verifyEditTaskPalletsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskPalletsLabelDisplayed(),
                "Edit Task Pallets label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isEditTaskPalletsDisplayed(),
                "Edit Task Pallets is not displayed");
        softAssert.assertAll();
    }

    @And("Verifies Pallets value of Edit task window is empty on Outbound Route Summary page")
    public void verifyEditTaskPalletsValueIsEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getEditTaskPalletsText().equals(StringUtils.EMPTY),
                "Edit Task Pallets value is not empty");
        softAssert.assertAll();
    }

    @And("Verifies Pallets required notification of Edit task window on Outbound Route Summary page")
    public void verifyEditTaskPalletsRequiredNotification() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTaskNotificationDisplayed(),
                "Edit Task Pallets required notification is not displayed");
        softAssert.assertEquals(outboundRouteSummaryPage.getNotificationText(), Notifications.PALLET_REQUIRED,
                "Edit Task Pallets required notification text is not correct");
        softAssert.assertAll();
    }

    @And("Validates Reprocess pick tasks window is displayed on Outbound Route Summary page")
    public void verifyEditTaskReprocessPickWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.REPROCESS_PICK,
                "Reprocess pick tasks window is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Select door notification is displayed on Outbound Route Summary page")
    public void verifySelectDoorNotificationWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getNotificationText(), Notifications.SELECT_DOOR,
                "Select door notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Outbound Route Summary page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Trailer is displayed on Outbound Route Summary page")
    public void verifyTrailerDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTrailerLabelDisplayed(),"Trailer Label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isTrailerInputDisplayed(),"Trailer Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Max Stops is displayed on Outbound Route Summary page")
    public void verifyMaxStopsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isMaxStopsLabelDisplayed(),"Max Stops Label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isMaxStopsInputDisplayed(),"Max Stops Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Temperature type {string} is displayed on Outbound Route Summary page")
    public void verifyTemperatureTypeDisplayed(String type) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTemperatureTypeDropDownDisplayed(type),"Temperature Type is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Temperature type by index {int} is displayed on Outbound Route Summary page")
    public void verifyTemperatureTypeByIndexDisplayed(int index) {
        List<String> types = List.of(outboundOrderLoadsDTO.getOutboundTemperatureTypes().getOutboundTemperatureType1(),
                outboundOrderLoadsDTO.getOutboundTemperatureTypes().getOutboundTemperatureType2(), outboundOrderLoadsDTO
               .getOutboundTemperatureTypes().getOutboundTemperatureType3());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTemperatureTypeDropDownDisplayed(types.get(index)),
                "Temperature Type is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Trailer {string} value is correct on Outbound Route Summary page")
    public void verifyTrailerValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getTrailerInputValue().contains(value),
                "Trailer value is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Trailer by index {int} is correct on Outbound Route Summary page")
    public void verifyTrailerValueByIndex(int index) {
        List<String> trailers = List.of(outboundOrderLoadsDTO.getOutboundTrailers().getOutboundTrailer1(), outboundOrderLoadsDTO
                .getOutboundTrailers().getOutboundTrailer2(), outboundOrderLoadsDTO.getOutboundTrailers().getOutboundTrailer3(),
                outboundOrderLoadsDTO.getOutboundTrailers().getOutboundTrailer4(), outboundOrderLoadsDTO.getOutboundTrailers()
                .getOutboundTrailer5(), outboundOrderLoadsDTO.getOutboundTrailers().getOutboundTrailer6());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getTrailerInputValue().contains(trailers.get(index)),
                "Trailer value is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Delete task window on Outbound Route Summary page")
    public void verifyDeleteTaskWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.DELETE,
                "Delete Task window title is not correct");
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowContentText(), Notifications.DELETE_TASK,
                "Delete Task window action is not correct");
        softAssert.assertAll();
    }

    @And("Validates Move task window on Outbound Route Summary page")
    public void verifyMoveTaskWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.MOVE_TASK,
                "Move Task window title is not correct");
        softAssert.assertAll();
    }

    @And("Validates Move assignment window on Outbound Route Summary page")
    public void verifyMoveAssignmentWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.MOVE_ASSIGNMENTS,
                "Move Assignment window title is not correct");
        softAssert.assertAll();
    }

    @And("New assignment, Existing assignment, New shipper and Existing shippers are displayed on Outbound Route Summary page")
    public void verifyMoveTaskWindowOptionsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveToAssignmentLabelDisplayed(),
                "Move To Assignment Label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveToNewAssignmentRadioButtonDisplayed(),
                "Move To New Assignment Radio Button is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveToExistingAssignmentRadioButtonDisplayed(),
                "Move To Existing Assignment Radio Button is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveToNewShipperRadioButtonDisplayed(),
                "Move To New Shipper Radio Button is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveToExistingShipperRadioButtonDisplayed(),
                "Move To Existing Shipper Radio Button is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isGetExistingAssignmentTxtBoxDisplayed(),
                "Existing Assignment TxtBox is not displayed");
        softAssert.assertAll();
    }

    @And("Validates To New or Existing Shippers disabled on Outbound Route Summary page")
    public void verifyToNewOrExistingShippersDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveToNewShipperRadioButtonDisabled().equals("true"),
                "Move To New Shipper Radio Button is not disabled");
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveToExistingShipperRadioButtonDisabled().equals("true"),
                "Move To Existing Shipper Radio Button is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Move tasks assignment window on Outbound Route Summary page")
    public void verifyMoveTasksAssignmentWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getNotificationText(), Notifications.ASSIGNMENT_REQUIRED,
                "Move Task window title is not correct");
        softAssert.assertAll();
    }

    @And("Validates New Assignment task window on Outbound Route Summary page")
    public void verifyNewAssignmentTaskWindow() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundRouteSummaryPage.getWindowTitleText(), Notifications.NEW_ASSIGNMENT,
                "Move Task window title is not correct");
        softAssert.assertAll();
    }

    @And("Validates Top Off Modal Zone dropdown is displayed on Outbound Route Summary page")
    public void verifyTopOffModalZoneDropDownDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isTopOffModalZoneDropDownDisplayed(),
                "Top Off Modal Zone dropdown is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Route Edit page is displayed on Outbound Route Summary page")
    public void validateEditPageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isDataAlt1Displayed(),"Data Alt1 is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isDataAlt2Displayed(),"Data Alt2 is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isDataAlt3Displayed(),"Data Alt3 is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Route Data page is displayed on Outbound Route Summary page")
    public void validateDataPageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteLabelDisplayed(),"Route Label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isEnterNameInputDisplayed(),"Enter Name Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Route Data page title contains {string} on Outbound Route Summary page")
    public void validateDataPageTitle(String title) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.getDataRouteCardPageTitleText().contains(title),
                "Route Data page title is not correct");
        softAssert.assertAll();
    }

    @And("Validates Source page columns for Route on Outbound Route Summary page")
    public void validateSourceColumns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceOrderTypeColumnDisplayed(),
                "Source Order Type for route is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceOrderColumnDisplayed(),
                "Source Order for route is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceStatusColumnDisplayed(),
                "Source Status for route is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Source page screens for Route on Outbound Route Summary page")
    public void validateSourcePageColumns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceListDisplayed(),
                "Source List for route is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceBlockDisplayed(),
                "Source Block for route is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Shipper on Source page for Route is displayed on Outbound Route Summary page")
    public void validatePopupSourceColumns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceShipperColumnDisplayed(),
                "Shipper Column for route is not displayed");
        softAssert.assertAll();
    }

    @And("Validates source items are displayed on Outbound Route Summary page")
    public void validateSourceItemsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceItemsFoundDisplayed(),
                "Source Items Found are not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceItemsNumberDisplayed(),
                "Source Items Number is not displayed");
        softAssert.assertAll();
    }

    @And("Validates green color for Shipped, yellow for Allocated, orange for Unallocated on Outbound Route Summary page")
    public void validateSourceStatusesColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceShippedStatusDisplayed(),
                "Shipped Status for route is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceUnallocatedStatusDisplayed(),
                "Unallocated Status for route is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceAllocatedStatusDisplayed(),
                "Allocated Status for route is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceShippedColorCorrect(),
                "Shipped Color for route is not correct");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceUnallocatedColorCorrect(),
                "Unallocated Color for route is not correct");
        softAssert.assertTrue(outboundRouteSummaryPage.isSourceAllocatedColorCorrect(),
                "Allocated Color for route is not correct");
        softAssert.assertAll();
    }

    @And("Validates Route Back button on Source page is displayed on Outbound Route Summary page")
    public void validateSourceBackButtonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isRouteBackButtonDisplayed(),"Route Back Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Route Review page is displayed on Outbound Route Summary page")
    public void validateReviewDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isReviewRouteTitleDisplayed(),"Review Route Title is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isReviewRouteTableContentDisplayed(),"Review Route Table Content is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Route Review page labels are displayed on Outbound Route Summary page")
    public void validateReviewPageLabelsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isOrderedLabelDisplayed(),"Ordered Label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isPickedLabelDisplayed(),"Picked Label is not displayed");
        softAssert.assertTrue(outboundRouteSummaryPage.isShippedLabelDisplayed(),"Shipped Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit, Delete, Release, Labels and Move for Routes are disabled on Outbound Route Summary page")
    public void verifyAssignmentItemsAreDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundRouteSummaryPage.isEditAssignmentButtonDisabled(), "Edit Assignment Button is enabled");
        softAssert.assertTrue(outboundRouteSummaryPage.isDeleteAssignmentButtonDisabled(), "Delete Assignment Button is enabled");
        softAssert.assertTrue(outboundRouteSummaryPage.isReleaseAssignmentButtonDisabled(), "Release Assignment Button is enabled");
        softAssert.assertTrue(outboundRouteSummaryPage.isPrintAssignmentButtonDisabled(), "Print Assignment Button is enabled");
        softAssert.assertTrue(outboundRouteSummaryPage.isMoveAssignmentButtonDisabled(), "Move Assignment Button is enabled");
        softAssert.assertAll();
    }

    @And("Validates Edit, Delete, Release, Labels and Move for Routes are enabled on Outbound Route Summary page")
    public void verifyAssignmentItemsAreEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundRouteSummaryPage.isEditAssignmentButtonDisabled(), "Edit Assignment Button is disabled");
        softAssert.assertFalse(outboundRouteSummaryPage.isDeleteAssignmentButtonDisabled(), "Delete Assignment Button is disabled");
        softAssert.assertFalse(outboundRouteSummaryPage.isReleaseAssignmentButtonDisabled(), "Release Assignment Button is disabled");
        softAssert.assertFalse(outboundRouteSummaryPage.isPrintAssignmentButtonDisabled(), "Print Assignment Button is disabled");
        softAssert.assertFalse(outboundRouteSummaryPage.isMoveAssignmentButtonDisabled(), "Move Assignment Button is disabled");
        softAssert.assertAll();
    }

}
