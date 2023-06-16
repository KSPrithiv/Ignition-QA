package steps.outbound.routesummary;

import common.enums.DockDoorOption;
import common.enums.RouteOptions;
import common.enums.Statuses;
import common.utils.Waiters;
import common.utils.database.DataBaseConnection;
import common.utils.database.StoreProceduresUtils;
import common.utils.datautils.RandomData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.storeproceduresdata.outbound.ProductsParams;
import objects.userdata.DataBaseData;
import steps.LoginPageSteps;
import ui.pages.outbound.routesummary.OutboundRouteSummaryPage;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class OutboundRouteSummaryPageSteps {
    OutboundRouteSummaryPage outboundRouteSummaryPage = new OutboundRouteSummaryPage();
    StoreProceduresUtils storeProceduresUtils = new StoreProceduresUtils();

    @Step
    @And("Waits for Outbound Route Summary page to load")
    public void waitForOutboundOrderSummaryPageToLoad() {
        log.info("Waiting for Outbound Order Summary Page To Load");
        outboundRouteSummaryPage.waitOutboundRouteSummaryPageToLoad();
    }

    @Step
    @Then("Filling route start date {string} and end date {string} on Outbound Route Summary page")
    public void fillingScheduledDateAndScheduledDate(String startDate, String endDate) {
        log.info("Filling Outbound Route Start Date And End Date");
        outboundRouteSummaryPage.typeRouteEndDate(endDate);
        outboundRouteSummaryPage.typeRouteStartDate(startDate);
    }

    @Step
    @Then("Types valid product on Outbound Route Summary page")
    public void typesProduct() throws SQLException {
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        ProductsParams productsParams = new ProductsParams();
        productsParams.setActive_only(1);
        ResultSet resultSet = storeProceduresUtils.executeStoreProcedureExportProducts(DataBaseConnection
                .getDataBaseConnection(dataBaseData), productsParams);
        String product = RandomData.getRandomResultSetRow(resultSet, RandomData.getRandomNumber(4, 8))
                .getString(1).trim();
        log.info("Typing product " + product);
        outboundRouteSummaryPage.typeProduct(product);
    }

    @Step
    @Then("Searches product on Outbound Route Summary page")
    public void searchProduct() throws SQLException {
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        ProductsParams productsParams = new ProductsParams();
        productsParams.setActive_only(1);
        ResultSet resultSet = storeProceduresUtils.executeStoreProcedureExportProducts(DataBaseConnection
                .getDataBaseConnection(dataBaseData), productsParams);
        String product = RandomData.getRandomResultSetRow(resultSet, RandomData.getRandomNumber(3, 9))
                .getString(1).trim();
        log.info("Typing product " + product);
        outboundRouteSummaryPage.searchProduct(product);
    }

    @Step
    @And("Selects product by index {int} on Outbound Route Summary page")
    public void clickProduct(int index) {
        log.info("Click product");
        outboundRouteSummaryPage.clickOnProductFromGridByIndex(index);
    }

    @Step
    @And("Types route {string} on Outbound Route Summary page")
    public void typesRoute(String route) {
        log.info("Typing route " + route);
        outboundRouteSummaryPage.typeRoute(route);
    }

    @Step
    @And("Types account {string} on Outbound Route Summary page")
    public void typesAccount(String account) {
        log.info("Typing account " + account);
        outboundRouteSummaryPage.typeAccount(account);
    }

    @Step
    @And("Deletes route input on Outbound Route Summary page")
    public void deleteRoute() {
        log.info("Deleting route on Outbound Route page");
        outboundRouteSummaryPage.deleteRoute();
    }

    @Step
    @And("Deletes account input on Outbound Route Summary page")
    public void deleteAccount() {
        log.info("Deleting account on Outbound Route page");
        outboundRouteSummaryPage.deleteAccount();
    }

    @Step
    @And("Deletes product on Outbound Route Summary page")
    public void deleteProduct() {
        log.info("Deleting product on Outbound Route page");
        outboundRouteSummaryPage.deleteProduct();
    }

    @Step
    @When("User clicks on search for product button on Outbound Route Summary page")
    public void clickSearchButton() {
        log.info("Click search product button on Outbound Route page");
        outboundRouteSummaryPage.clickSearchProduct();
    }

    @Step
    @And("User selects assign item on Outbound Route Summary page")
    public void selectAssignItem() {
        log.info("Selecting Assign Item");
        outboundRouteSummaryPage.clickAssignItem();
    }

    @Step
    @And("User selects warehouse {string} on Outbound Route Summary page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse {string} on Outbound Route page");
        outboundRouteSummaryPage.selectWarehouse(warehouse);
    }

    @Step
    @And("Clicks Add filter button on Outbound Route Summary page")
    public void clickAddFilter() {
        log.info("Clicking add filter");
        outboundRouteSummaryPage.clickAddFilter();
    }

    @Step
    @And("Clicks All Assignments checkbox on Outbound Route Summary page")
    public void clickAllAssignmentsCheckbox() {
        log.info("Clicking All Assignments");
        outboundRouteSummaryPage.clickAllAssignmentsCheckbox();
    }

    @Step
    @And("Clicks All Tasks checkbox on Outbound Route Summary page")
    public void clickAllTasksCheckbox() {
        log.info("Clicking All Tasks");
        outboundRouteSummaryPage.clickAllTasksCheckbox();
    }

    @Step
    @And("Clicks Edit option on Tasks tab page")
    public void clickEditOptionOnTasksTab() {
        log.info("Clicking Edit Option on Tasks tab page");
        outboundRouteSummaryPage.clickEditTask();
    }

    @Step
    @And("Selects Task checkbox by index {int} on Outbound Route Summary page")
    public void clickTasksCheckboxByIndex(int index) {
        log.info("Select Task checkbox by index " + index);
        outboundRouteSummaryPage.checkTasksCheckboxByIndex(index);
    }

    @Step
    @And("Selects Reprocess option on Tasks tab page")
    public void clickReprocessTasks() {
        log.info("Click Reprocess task");
        outboundRouteSummaryPage.clickReprocessTask();
    }

    @Step
    @And("Selects Delete option on Tasks tab page")
    public void clickDeleteTasks() {
        log.info("Click Delete task");
        outboundRouteSummaryPage.clickDeleteTask();
    }

    @Step
    @And("Selects Top Off option on Tasks tab page")
    public void clickTopOffTasks() {
        log.info("Click TopOff task");
        outboundRouteSummaryPage.clickTopOffTask();
    }

    @Step
    @And("Check Replenish To Clean on Outbound Route Summary page")
    public void checkReplenishToClean() {
        log.info("Check Replenish To Clean");
        outboundRouteSummaryPage.clickReplenishToCleanCheckBox();
    }

    @Step
    @And("Click Top Off Modal Zone dropdown on Outbound Route Summary page")
    public void clickTopOffModalZoneDropdown() {
        log.info("Click Top Off Modal Zone dropdown");
        outboundRouteSummaryPage.clickTopOffModalZoneDropdown();
    }

    @Step
    @And("Selects Top Off Modal Zone {string} option on Outbound Route Summary page")
    public void clickTopOffModalZoneDropdown(String option) {
        log.info("Select Top Off Modal Zone option");
        outboundRouteSummaryPage.selectTopOffModalZoneDropdown(option);
    }

    @Step
    @And("Selects Move option for Task on Outbound Route Summary page")
    public void clickMoveOptionDropdown() {
        log.info("Select Top Off Modal Zone option");
        outboundRouteSummaryPage.clickMoveTask();
    }

    @Step
    @And("Selects Move option for Assignment on Outbound Route Summary page")
    public void clickMoveAssignment() {
        outboundRouteSummaryPage.clickMoveAssignment();
    }

    @Step
    @And("Clicks Ok on Outbound Route Summary page")
    public void clickOkButton() {
        log.info("Clicking Ok");
        outboundRouteSummaryPage.clickOk();
    }

    @Step
    @And("Clicks Move To New Assignment radio button on Outbound Route Summary page")
    public void clickMoveToNewAssignment() {
        log.info("Clicking Move To New Assignment radio button");
        outboundRouteSummaryPage.clickMoveToNewAssignmentRadioButton();
    }

    @Step
    @And("Clicks Move To Existing Assignment radio button on Outbound Route Summary page")
    public void clickMoveToExistingAssignment() {
        log.info("Clicking Move To New Assignment radio button");
        outboundRouteSummaryPage.clickMoveToExistingAssignmentRadioButton();
    }

    @Step
    @And("Clicks Save button on Outbound Route Summary page")
    public void clickSave() {
        log.info("Clicking Save");
        outboundRouteSummaryPage.clickSave();
    }

    @Step
    @And("Clicks Cancel button on Outbound Route Summary page")
    public void clickCancelButton() {
        log.info("Clicking Cancel Button");
        outboundRouteSummaryPage.clickCancelButton();
    }

    @Step
    @And("Type Edit Task quantity {string} amount on Outbound Route Summary page")
    public void clickSave(String qty) {
        log.info("Typing quantity " + qty);
        outboundRouteSummaryPage.typeEditTaskQtyValue(qty);
    }

    @Step
    @Then("User selects work item on Outbound Route Summary page")
    public void selectWorkItem() {
        log.info("Selecting Work Item");
        outboundRouteSummaryPage.clickWorkItem();
    }

    @Step
    @And("User selects first assignment for route on Outbound Route Summary page")
    public void selectFirstAssignment() {
        log.info("Selecting first assignment");
        outboundRouteSummaryPage.selectRouteAssignmentByNumber(0);
    }

    @Step
    @And("User selects change status item on Outbound Route Summary page")
    public void selectChangeStatusItem() {
        log.info("Selecting Change Status Item");
        outboundRouteSummaryPage.clickChangeStatus();
    }

    @Step
    @And("User clicks Assignments tab on Outbound Route Summary page")
    public void selectAssignments() {
        log.info("Selecting Assignments tab");
        outboundRouteSummaryPage.clickAssignments();
    }

    @Step
    @And("User clicks Tasks tab on Outbound Route Summary page")
    public void selectTasks() {
        log.info("Selecting Tasks tab");
        outboundRouteSummaryPage.clickTasks();
    }

    @Step
    @And("User clicks search for account button on Outbound Route Summary page")
    public void clickSearchAccount() {
        log.info("Clicking Search account");
        outboundRouteSummaryPage.clickSearchAccount();
    }

    @Step
    @And("Searches for account {string} on Outbound Route Summary page")
    public void searchAccount(String account) {
        log.info("Search account " + account);
        outboundRouteSummaryPage.searchAccount(account);
    }

    @Step
    @And("User clicks status {string} on Outbound Route Summary page")
    public void clickStatus(String status) {
        log.info("Click status " + status);
        outboundRouteSummaryPage.clickStatus(status);
    }

    @Step
    @And("User clicks door dropdown for Route on Outbound Route Summary page")
    public void clickDoorDropdown() {
        log.info("Click door dropdown");
        outboundRouteSummaryPage.clickDoorDropdown();
    }

    @Step
    @And("User clicks door {string} on Outbound Route Summary page")
    public void clickDoor(String door) {
        log.info("Click door " + door);
        outboundRouteSummaryPage.clickDoor(door);
    }

    @Step
    @And("User clicks door {string} dropdown on Outbound Route Summary page")
    public void clickDoorDropdown(String door) {
        log.info("Click door dropdown " + door);
        outboundRouteSummaryPage.clickDoorDropdown(door);
    }

    @Step
    @And("User selects default option {string} on Outbound Route Summary page")
    public void clickOption(String option) {
        log.info("Click option " + option);
        outboundRouteSummaryPage.clickOption(option);
    }

    @Step
    @And("User searches for status Cancelled on Outbound Route Summary page")
    public void clickCancelledStatus() {
        log.info("Click status Cancelled");
        outboundRouteSummaryPage.selectOption(Statuses.CANCELLED.getStatus());
    }

    @Step
    @And("User searches for status Closed on Outbound Route Summary page")
    public void clickClosedStatus() {
        log.info("Click status Closed");
        outboundRouteSummaryPage.selectOption(Statuses.CLOSED.getStatus());
    }

    @Step
    @And("User searches for status Open on Outbound Route Summary page")
    public void clickOpenStatus() {
        log.info("Click status Open");
        outboundRouteSummaryPage.selectOption(Statuses.OPEN.getStatus());
    }

    @Step
    @And("User searches for status Shipment in Progress on Outbound Route Summary page")
    public void clickShipmentInProgressStatus() {
        log.info("Click status Shipment in Progress");
        outboundRouteSummaryPage.selectOption(Statuses.SHIPMENT_IN_PROGRESS.getStatus());
    }

    @Step
    @And("User searches for status All status on Outbound Route Summary page")
    public void clickAllStatusStatus() {
        log.info("Click status All status");
        outboundRouteSummaryPage.selectOption(Statuses.ALL_STATUSES.getStatus());
    }

    @Step
    @And("Click Cancel button on Outbound Route Summary page")
    public void clickCancel() {
        log.info("Clicking cancel");
        outboundRouteSummaryPage.clickCancelButton();
    }

    @Step
    @And("Selects Tasks Tab on Outbound Route Summary page")
    public void selectTasksItem() {
        log.info("Selecting Tasks Item");
        outboundRouteSummaryPage.clickTaskItem();
    }

    @Step
    @And("User clicks user dropdown for Assign Route on Outbound Route Summary page")
    public void clickUserDropdown() {
        log.info("Clicking User dropdown");
        outboundRouteSummaryPage.clickUserDropdown();
    }

    @Step
    @And("Selects random user from dropdown for Assign route on Outbound Route Summary page")
    public void selectFirstUserFromDropdown() {
        log.info("Selecting random user from dropdown");
        outboundRouteSummaryPage.selectRandomUserFromDropdown();
    }

    @Step
    @And("Selects route with index {int} on Outbound Route Summary page")
    public void selectRouteByIndex(int index) {
        log.info("Select route");
        outboundRouteSummaryPage.checkRouteByRowNumber(index);
    }

    @Step
    @And("Click on route with index {int} on Outbound Route Summary page")
    public void clickRouteByIndex(int index) {
        log.info("Click on route");
        outboundRouteSummaryPage.selectRouteByRowNumber(index);
    }

    @Step
    @And("Clicks Routes dropdown on Outbound Route Summary page")
    public void clickRouteOptions() {
        log.info("Click on route option");
        outboundRouteSummaryPage.clickRoutesDropdown();
    }

    @Step
    @And("Clicks Carrier dropdown on Outbound Route Summary page")
    public void clickCarrierDropdown() {
        log.info("Click on Carrier dropdown");
        outboundRouteSummaryPage.clickCarrierDropdown();
    }

    @Step
    @And("Clicks Trailer dropdown on Outbound Route Summary page")
    public void clickTrailerDropdown() {
        log.info("Click on Trailer dropdown");
        outboundRouteSummaryPage.clickTrailerDropdown();
    }

    @Step
    @And("User searches for door D1 on Outbound Route Summary page")
    public void selectD1Door() {
        log.info("Select door D1");
        outboundRouteSummaryPage.selectOption(DockDoorOption.D1.getDockDoorOption());
    }

    @Step
    @And("User searches for door DOOR on Outbound Route Summary page")
    public void selectDOORDoor() {
        log.info("Select door DOOR");
        outboundRouteSummaryPage.selectOption(DockDoorOption.DOOR.getDockDoorOption());
    }

    @Step
    @And("User searches for door DOOR01 on Outbound Route Summary page")
    public void selectDOOR01Door() {
        log.info("Select door DOOR01");
        outboundRouteSummaryPage.selectOption(DockDoorOption.DOOR01.getDockDoorOption());
    }

    @Step
    @And("User searches for door DOOR02 on Outbound Route Summary page")
    public void selectDOOR02Door() {
        log.info("Select door DOOR02");
        outboundRouteSummaryPage.selectOption(DockDoorOption.DOOR02.getDockDoorOption());
    }

    @Step
    @And("User searches for door DOOR03 on Outbound Route Summary page")
    public void selectDOOR03Door() {
        log.info("Select door DOOR03");
        outboundRouteSummaryPage.selectOption(DockDoorOption.DOOR03.getDockDoorOption());
    }

    @Step
    @And("User searches for door DOOR04 on Outbound Route Summary page")
    public void selectDOOR04Door() {
        log.info("Select door DOOR04");
        outboundRouteSummaryPage.selectOption(DockDoorOption.DOOR04.getDockDoorOption());
    }

    @Step
    @And("Click Back button on Outbound Route Summary page")
    public void clickBackButton() {
        log.info("Clicking back Outbound Route Summary page");
        outboundRouteSummaryPage.clickBack();
    }

    @Step
    @And("Click on Assignment type dropdown on Outbound Route Summary page")
    public void clickAssignmentType() {
        log.info("Click on Assignment type dropdown");
        outboundRouteSummaryPage.clickAssignmentTypeFilter();
    }

    @Step
    @And("Click on Task group dropdown on Outbound Route Summary page")
    public void clickTaskGroup() {
        log.info("Click on Task group dropdown");
        outboundRouteSummaryPage.clickTaskGroupFilter();
    }

    @Step
    @And("Click on Types dropdown on Outbound Route Summary page")
    public void clickTypes() {
        log.info("Click on Types dropdown");
        outboundRouteSummaryPage.clickTypesFilter();
    }

    @Step
    @And("Click on Status tab dropdown on Outbound Route Summary page")
    public void clickStatusTab() {
        log.info("Click on Status tab dropdown");
        outboundRouteSummaryPage.clickStatusesFilter();
    }

    @Step
    @And("Select Outbound Route carrier {string} option on Outbound Route Summary page")
    public void selectOutboundRouteCarrierOption(String carrier) {
        log.info("Selecting Outbound Route carrier " + carrier);
        outboundRouteSummaryPage.selectOutboundRouteCarrier(carrier);
    }

    @Step
    @And("Type Route driver {string} on Outbound Route Summary page")
    public void typeOutboundRouteDriver(String driver) {
        log.info("Typing Outbound Route driver " + driver);
        outboundRouteSummaryPage.typeDriver(driver);
    }

    @Step
    @And("Type Max Stops {string} on Outbound Route Summary page")
    public void typeMaxStops(String amount) {
        log.info("Typing Outbound Route max stops " + amount);
        outboundRouteSummaryPage.typeMaxStops(amount);
    }

    @Step
    @And("Type Temperature {string} on Outbound Route Summary page")
    public void typeTemperature(String temperature) {
        log.info("Typing Outbound Route temperature " + temperature);
        outboundRouteSummaryPage.typeTemperature(temperature);
    }

    @Step
    @And("Click Temperature type {string} on Outbound Route Summary page")
    public void clickTemperatureType(String type) {
        log.info("Clicking Outbound Route temperature type " + type);
        outboundRouteSummaryPage.clickTemperatureTypeDropdown(type);
    }

    @Step
    @And("Select Temperature type {string} on Outbound Route Summary page")
    public void selectTemperatureType(String type) {
        log.info("Selecting Outbound Route temperature type " + type);
        outboundRouteSummaryPage.selectTemperatureType(type);
    }

    @Step
    @And("Select Outbound Route Release option on Outbound Route Summary page")
    public void selectOutboundRouteReleaseOption() {
        log.info("Selecting Outbound Route Option " + RouteOptions.RELEASE.getRouteOption());
        outboundRouteSummaryPage.selectOutboundRouteOption(RouteOptions.RELEASE.getRouteOption());
    }

    @Step
    @And("Select Outbound Route Edit option on Outbound Route Summary page")
    public void selectOutboundRouteEditOption() {
        log.info("Selecting Outbound Route Option " + RouteOptions.EDIT.getRouteOption());
        outboundRouteSummaryPage.selectOutboundRouteOption(RouteOptions.EDIT.getRouteOption());
    }

    @Step
    @And("Select Outbound Route Door option on Outbound Route Summary page")
    public void selectOutboundRouteDoorOption() {
        log.info("Selecting Outbound Door Option " + RouteOptions.DOOR.getRouteOption());
        outboundRouteSummaryPage.selectOutboundRouteOption(RouteOptions.DOOR.getRouteOption());
    }

    @Step
    @And("Select Outbound Route Data option on Outbound Route Summary page")
    public void selectOutboundRouteDataOption() {
        log.info("Selecting Outbound Route Option " + RouteOptions.DATA.getRouteOption());
        outboundRouteSummaryPage.selectOutboundRouteOption(RouteOptions.DATA.getRouteOption());
    }

    @Step
    @And("Select Outbound Route Source option on Outbound Route Summary page")
    public void selectOutboundRouteSourceOption() {
        log.info("Selecting Outbound Route Option " + RouteOptions.SOURCE.getRouteOption());
        outboundRouteSummaryPage.selectOutboundRouteOption(RouteOptions.SOURCE.getRouteOption());
    }

    @Step
    @And("Select Outbound Route Review option on Outbound Route Summary page")
    public void selectOutboundRouteReviewOption() {
        log.info("Selecting Outbound Route Option " + RouteOptions.REVIEW.getRouteOption());
        outboundRouteSummaryPage.selectOutboundRouteOption(RouteOptions.REVIEW.getRouteOption());
    }

    @Step
    @And("Select {string} Trailer option on Outbound Route Summary page")
    public void selectTrailerOption(String option) {
        log.info("Selecting Trailer Option " + option);
        outboundRouteSummaryPage.selectTrailerOption(option);
    }

    @Step
    @And("Select Outbound Route type {string} on Outbound Route Summary page")
    public void selectOutboundRouteType(String routeType) {
        log.info("Selecting Outbound Route type " + routeType);
        outboundRouteSummaryPage.selectOutboundRouteType(routeType);
    }

    @Step
    @And("Filling scheduled date {string} and scheduled time {string} on Outbound Route Summary page")
    public void fillingScheduledDateAndTime(String date, String time) {
        log.info("Filling Outbound Route scheduled date and scheduled time");
        outboundRouteSummaryPage.typeScheduledDate(date);
        outboundRouteSummaryPage.typeScheduledTime(time);
    }

    @Step
    @And("Typing Outbound Route code {string} on Outbound Route Summary page")
    public void selectOutboundRouteEditOption(String routeCode) {
        log.info("Typing Outbound Route code  " + routeCode);
        outboundRouteSummaryPage.typeRouteCode(routeCode);
    }

    @Step
    @And("Clicks on {string} column with index {int} on Outbound Route Summary page")
    public void clickShipperColumn(String order, int index) {
        log.info("Clicking " + order + " column");
        outboundRouteSummaryPage.clickOrderTypeColumn(order, index);
    }

    @Step
    @And("Clicks on Route Back button on Outbound Route Summary page")
    public void clickRouteBackButton() {
        log.info("Click Route Back button");
        outboundRouteSummaryPage.clickRouteBack();
    }
}
