package steps.inbound.inboundorders;

import common.constants.FilePaths;
import common.utils.Waiters;
import common.utils.database.DataBaseConnection;
import common.utils.database.StoreProceduresUtils;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import objects.storeproceduresdata.inbound.InboundOrderSummaryParams;
import objects.userdata.DataBaseData;
import steps.LoginPageSteps;
import ui.pages.inbound.inboundorders.InboundOrderSummaryPage;

import java.sql.ResultSet;

@Slf4j
public class InboundOrderSummaryPageSteps {
    InboundOrderSummaryPage inboundOrderSummaryPage = new InboundOrderSummaryPage();
    StoreProceduresUtils storeProceduresUtils = new StoreProceduresUtils();

    @Step
    @And("User waits for Inbound Order Summary page to load")
    public void waitForInboundOrderSummaryPageToLoad() {
        log.info("Waiting for Inbound Order Summary Page To Load ");
        inboundOrderSummaryPage.waitInboundOrderSummaryToLoad();
    }

    @Step
    @Then("User applies order {string} option on Inbound Order Summary page")
    public void applyOrderOptionForOrder(String option) {
        log.info("Applying Order option " + option + " for order ");
        Waiters.waitABit(2000);
        inboundOrderSummaryPage.selectOrderOption(option);
    }

    @Step
    @When("User finds orders from {string} date on Inbound Order summary page")
    public void findOrdersFromDate(String date) {
        log.info("Finding Orders starting from " + date);
        inboundOrderSummaryPage.typeDateRouteStart(date);
    }


    @Step
    @When("User clicks supplier button on Inbound Order summary page")
    public void clickSupplierButton() {
        log.info("Clicks supplier button on Inbound Order summary page");
        inboundOrderSummaryPage.clickSearchSupplierButton();
    }

    @Step
    @When("User finds all orders from {string} to {string}")
    public void findOrdersFromDateToDate(String fromDate, String toDate) {
        log.info("Finding Orders starting from " + fromDate);
        inboundOrderSummaryPage.typeDateRouteStart(fromDate);
        inboundOrderSummaryPage.typeDateRouteEnd(toDate);
    }

    @Step
    @And("User selects warehouse {string} on Inbound Order Summary page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse {string} on Inbound Load Summary page");
        inboundOrderSummaryPage.selectWarehouse(warehouse);
    }

    @Step
    @And("Selects {string} door option on Inbound Order Summary page")
    public void selectDoorOption(String door) {
        log.info("Selecting door " + door);
        inboundOrderSummaryPage.selectOption(door);
    }

    @Step
    @And("Clicks {string} door option on Inbound Order Summary page")
    public void clickDoorOption(String door) {
        log.info("Clicks door " + door);
        inboundOrderSummaryPage.selectDoorDropDown(door);
    }

    @Step
    @And("Clicks {string} owner option on Inbound Order Summary page")
    public void clickOwner(String owner) {
        log.info("Clicking owner " + owner);
        inboundOrderSummaryPage.clickOwnerDropdown(owner);
    }

    @Step
    @And("Selects {string} owner option on Inbound Order Summary page")
    public void selectOwner(String owner) {
        log.info("Selecting owner " + owner);
        inboundOrderSummaryPage.selectOption(owner);
    }

    @Step
    @And("Clicks {string} option on Inbound Order Summary page")
    public void clickOption(String option) {
        log.info("Selecting door " + option);
        inboundOrderSummaryPage.selectDoorDropDown(option);
    }

    @Step
    @And("Selects order with index {int} on Inbound Order Summary page")
    public void selectOrderByNumber(int orderNum) {
        log.info("Selecting Order by number " + orderNum);
        inboundOrderSummaryPage.selectOrderByOrderNumber(orderNum);
    }

    @Step
    @And("Check order with index {int} on Inbound Order Summary page")
    public void checkOrderByNumber(int orderNum) {
        log.info("Check Order by number " + orderNum);
        inboundOrderSummaryPage.selectOrderCheckboxByOrderNumber(orderNum);
    }

    @Step
    @And("Select order {string} on Inbound Order Summary page")
    public void selectOrderByName(String name) {
        log.info("Select order by name " + name);
        inboundOrderSummaryPage.selectOrderByOrderName(name);
    }

    @Step
    @And("Selects Order with index {int} and apply {string} Order Option on Inbound Order Summary page")
    public void applyOrderOptionForOrderByOrderNumber(int orderNum, String option) {
        log.info("Applying Order option " + option + " Order by number " + orderNum);
        inboundOrderSummaryPage.checkOrderByOrderNumber(orderNum);
        inboundOrderSummaryPage.selectOrderOption(option);
    }

    @Step
    @When("Filling scheduled date {string} and scheduled time {string} on Edit popup on Inbound Order Summary page")
    public void fillingDateAndTime(String date, String time) {
        log.info("Filling scheduled date and time");
        inboundOrderSummaryPage.typeScheduledDate(date);
        inboundOrderSummaryPage.typeScheduledTime(time);
    }

    @Step
    @And("Clicks Order Option on Inbound Order Summary page")
    public void clickOrderOption() {
        log.info("Clicks Order option");
        inboundOrderSummaryPage.clickOrderOption();
    }

    @Step
    @And("Clicks Yes Button on Inbound Order Summary page")
    public void clickYes() {
        log.info("Clicks Order option");
        inboundOrderSummaryPage.clickYesButton();
    }

    @Step
    @And("Checks Order with index {int} on Inbound Order Summary page")
    public void applyOrderOptionForOrderByOrderNumber(int orderNum) {
        log.info("Check Order with index " + orderNum);
        inboundOrderSummaryPage.checkOrderByOrderNumber(orderNum);
    }

    @Step
    @And("Clear order name on Inbound Order Summary page")
    public void clearOrderName() {
        log.info("Clear order name");
        inboundOrderSummaryPage.clearOrderInput();
    }

    @SneakyThrows
    @Step
    @And("Selects Order from Inbound Order Summary table")
    public void selectOrderByOrderName() {
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        InboundOrderSummaryParams inboundOrderSummaryParams = new ObjectMapperWrapper()
                .getObject(FilePaths.INBOUND_ORDER_SUMMARY_DATA, InboundOrderSummaryParams.class);
        inboundOrderSummaryParams.setStart_date("2017-01-01");
        inboundOrderSummaryParams.setEnd_date("2022-01-01");
        ResultSet rs = storeProceduresUtils.executeStoreProcedureInboundOrderSummary(DataBaseConnection
                .getDataBaseConnection(dataBaseData), inboundOrderSummaryParams);
        inboundOrderSummaryParams.setOrder_no(rs.getString(2).trim());
        DataBaseConnection.closeDataBaseConnection();
        log.info("Selecting Order " + inboundOrderSummaryParams.getOrder_no());
        inboundOrderSummaryPage.selectOrderByOrderName(inboundOrderSummaryParams.getOrder_no());
    }

    @Step
    @And("Selects Supplier with index {int}")
    public void selectSupplierByIndex(int index) {
        log.info("Selecting Supplier by number " + index);
        inboundOrderSummaryPage.clickSupplierByNumber(index);
    }

    @Step
    @And("Types Valid product code {string} on Inbound Order Summary page")
    public void typesProductCode(String product) {
        log.info("Typing product code " + product);
        inboundOrderSummaryPage.typeProduct(product);
    }

    @Step
    @And("Types invalid product code {string} on Inbound Order Summary page")
    public void typesInvalidProductCode(String product) {
        log.info("Typing product code " + product);
        inboundOrderSummaryPage.typeProduct(product);
    }

    @Step
    @And("Deletes product on Inbound Order Summary page")
    public void deleteProduct() {
        log.info("Deleting product");
        inboundOrderSummaryPage.deleteProduct();
    }

    @Step
    @And("Clicks buyer {string} dropdown on Inbound Order Summary page")
    public void clickBuyerDropdown(String buyer) {
        log.info("Clicking Buyer " + buyer);
        inboundOrderSummaryPage.clickBuyerDropDown(buyer);
    }

    @Step
    @And("Clicks order type {string} dropdown on Inbound Order Summary page")
    public void clickOrderTypeDropdown(String orderType) {
        log.info("Clicking Order Type " + orderType);
        inboundOrderSummaryPage.clickOrderTypeDropDown(orderType);
    }

    @Step
    @And("Selects buyer {string} dropdown on Inbound Order Summary page")
    public void selectBuyer(String buyer) {
        log.info("Selecting Buyer " + buyer);
        inboundOrderSummaryPage.selectOption(buyer);
    }

    @Step
    @And("Selects order type {string} dropdown on Inbound Order Summary page")
    public void selectOrderType(String type) {
        log.info("Selecting order type " + type);
        inboundOrderSummaryPage.selectOption(type);
    }

    @Step
    @And("Types supplier code {string} on Inbound Order Summary page")
    public void typeSupplierCode(String code) {
        log.info("Searching supplier code " + code);
        inboundOrderSummaryPage.searchSupplierByCode(code);
    }

    @Step
    @And("Types supplier name {string} on Inbound Order Summary page")
    public void typeSupplierName(String name) {
        log.info("Searching supplier name " + name);
        inboundOrderSummaryPage.searchSupplierByName(name);
    }

    @Step
    @And("Cleans supplier name on Inbound Order Summary page")
    public void cleanSupplierName() {
        log.info("Cleaning supplier name");
        inboundOrderSummaryPage.cleanSupplierName();
    }

    @Step
    @And("Cleans supplier code on Inbound Order Summary page")
    public void cleanSupplierCode() {
        log.info("Cleaning supplier code");
        inboundOrderSummaryPage.cleanSupplierCode();
    }

    @Step
    @And("Clicks carrier {string} on Inbound Order Summary page")
    public void clickCarrier(String carrier) {
        log.info("Clicking Carrier  " + carrier);
        inboundOrderSummaryPage.clickCarrierDropdown(carrier);
    }

    @Step
    @And("Selects carrier {string} on Inbound Order Summary page")
    public void selectCarrier(String carrier) {
        log.info("Selecting Carrier  " + carrier);
        inboundOrderSummaryPage.selectOption(carrier);
    }

    @Step
    @And("Clicks order status {string} on Inbound Order Summary page")
    public void clickInboundOrderStatus(String status) {
        log.info("Clicking Order Status " + status);
        inboundOrderSummaryPage.clickOrderStatus(status);
    }

    @Step
    @Then("Selects order status {string} on Inbound Order Summary page")
    public void selectInboundOrderStatus(String status) {
        log.info("Selecting Order Status " + status);
        inboundOrderSummaryPage.selectOrderStatus(status);
    }

    @Step
    @And("Clicks change status option on Inbound Order Summary page")
    public void clickChangeStatusOption() {
        log.info("Clicking Change Status option");
        inboundOrderSummaryPage.clickChangeStatusOption();
    }

    @Step
    @And("Clicks door option on Inbound Order Summary page")
    public void clickDoorOption() {
        log.info("Clicking Door option");
        inboundOrderSummaryPage.clickDoorOption();
    }

    @Step
    @And("Clicks data option on Inbound Order Summary page")
    public void clickDataOption() {
        log.info("Clicking Data option");
        inboundOrderSummaryPage.clickDataOption();
    }

    @Step
    @And("Clicks Cancel button on Inbound Order Summary page")
    public void clickCancel() {
        log.info("Clicking Cancel");
        inboundOrderSummaryPage.clickCancel();
    }

    @Step
    @And("Clicks Ok button on Inbound Order Summary page")
    public void clickOk() {
        log.info("Clicking Ok");
        inboundOrderSummaryPage.clickOkButton();
    }

    @Step
    @And("Clicks Route Back button on Inbound Order Summary page")
    public void clickRouteBackButton() {
        log.info("Clicking Route Back");
        inboundOrderSummaryPage.clickRouteBackButton();
    }

    @Step
    @And("Types {string} temperature on Inbound Order Summary page")
    public void typeTemperature(String temperature) {
        log.info("Types Temperature " + temperature);
        inboundOrderSummaryPage.typeTemperature(temperature);
    }

    @Step
    @And("Types {string} seal number on Inbound Order Summary page")
    public void typeSealNumber(String sealNum) {
        log.info("Types Seal Number " + sealNum);
        inboundOrderSummaryPage.typeSealNumber(sealNum);
    }

    @Step
    @And("Clicks Add Product Cancel Button on Inbound Order Summary page")
    public void clickAddProductCancel() {
        log.info("Clicking Add Product Cancel button");
        inboundOrderSummaryPage.clickBtnAddProductCancel();
    }

    @Step
    @And("Clicks door on Assign door popup on Inbound Order Summary page")
    public void clickDoorDropDown() {
        log.info("Clicking Door");
        inboundOrderSummaryPage.clickDoorDropdown();
    }

    @Step
    @Then("Clicks door {string} on Inbound Order Summary page")
    public void clickDoor(String door) {
        log.info("Clicking Door  " + door);
        inboundOrderSummaryPage.selectOption(door);
    }

    @Step
    @And("Clicks Save button on Inbound Order Summary page")
    public void clickSave() {
        log.info("Clicking Save");
        inboundOrderSummaryPage.clickSave();
    }

    @Step
    @And("Clicks No button on Inbound Order Summary page")
    public void clickNoButton() {
        log.info("Clicking No");
        inboundOrderSummaryPage.clickNoButton();
    }

    @Step
    @And("Clicks Add Filter button on Inbound Order Summary page")
    public void clickAddFilter() {
        log.info("Clicking Add Filter");
        inboundOrderSummaryPage.clickAddFilter();
    }

    @Step
    @And("Types Ship Date {string} to move Order to Load on Inbound Order Summary page")
    public void typeShipDateForMoveOrderToLoad(String date) {
        log.info("Type Ship Date " + date);
        inboundOrderSummaryPage.typeShipDate(date);
    }

    @Step
    @And("Types Load {string} to move Order to Load on Inbound Order Summary page")
    public void typeLoadForMoveOrderToLoad(String load) {
        log.info("Type Load " + load);
        inboundOrderSummaryPage.typeLoad(load);
    }


}
