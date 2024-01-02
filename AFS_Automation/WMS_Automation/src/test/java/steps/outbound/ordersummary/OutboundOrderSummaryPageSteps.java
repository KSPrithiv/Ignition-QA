package steps.outbound.ordersummary;

import common.constants.FilePaths;
import common.constants.TimeFormats;
import common.enums.OrderOptions;
import common.enums.Statuses;
import common.utils.database.DataBaseConnection;
import common.utils.database.StoreProceduresUtils;
import common.utils.objectmapper.ObjectMapperWrapper;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import objects.outbound.OutboundOrderLoadsDTO;
import objects.storeproceduresdata.outbound.OutboundSummaryParams;
import objects.userdata.DataBaseData;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.LoginPageSteps;
import ui.pages.BasePage;
import ui.pages.outbound.ordersummary.OutboundOrderSummaryPage;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

@Slf4j
public class OutboundOrderSummaryPageSteps extends BasePage {
    By loader = By.cssSelector(".loader");
    By enterOrder = By.cssSelector("input[placeholder='Enter order']");
    OutboundOrderSummaryPage outboundOrderSummaryPage = new OutboundOrderSummaryPage();

    StoreProceduresUtils storeProceduresUtils = new StoreProceduresUtils();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

    @Step
    @And("Waits for Outbound Order Summary page to load")
    public void waitForOutboundOrderSummaryPageToLoad() {
        log.info("Waiting for Outbound Order Summary Page To Load");
        outboundOrderSummaryPage.waitOutboundOrderSummaryPageToLoad();
    }

    @Step
    @And("Waits for Work Queue Page to load")
    public void waitForWorkPageToLoad() {
        log.info("Waiting for Work Queue Page To Load");
        outboundOrderSummaryPage.waitForWorkPageToLoad();
    }

    @Step
    @Then("Filling start date {string} and end date {string} on Outbound Order Summary page")
    public void fillingStartDateAndEndDate(String startDate, String endDate) {
        log.info("Filling Outbound Order Start Date And End Date");
        outboundOrderSummaryPage.typeOrderStartDate(startDate);
        outboundOrderSummaryPage.typeOrderEndDate(endDate);

    }

    @Step
    @Then("Filling start date {string} on Outbound Order Summary page")
    public void fillingStartDate(String startDate) {
        log.info("Filling Outbound Order Start Date");
        outboundOrderSummaryPage.typeOrderStartDate(startDate);
    }

    @Step
    @Then("Filling start date by index {int} on Outbound Order Summary page")
    public void fillingStartDateAndEndDate(int index) throws InterruptedException {
        waitUntilInvisible(15, loader);
        log.info("Filling Outbound Order Start Date by index");
        List<String> dates = List.of(outboundOrderLoadsDTO.getStartDates().getStartDate1(), outboundOrderLoadsDTO
                .getStartDates().getStartDate2(), outboundOrderLoadsDTO.getStartDates().getStartDate3(),
                outboundOrderLoadsDTO.getStartDates().getStartDate4(), outboundOrderLoadsDTO.getStartDates().getStartDate5(),
                outboundOrderLoadsDTO.getStartDates().getStartDate6(), outboundOrderLoadsDTO.getStartDates().getStartDate7());
        outboundOrderSummaryPage.typeOrderStartDate(dates.get(index));
    }

    @Step
    @And("User selects warehouse {string} on Outbound Order Summary page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse {string} on Outbound Order Summary page");
        outboundOrderSummaryPage.selectWarehouse(warehouse);
    }

    @Step
    @And("Selects order {string} on Outbound Order Summary page")
    public void selectOrderByName(String orderName) {
        log.info("Selecting Order " + orderName);
        outboundOrderSummaryPage.selectOrderByOrderName(orderName);
    }

    @Step
    @And("Selects order by index {int} on Outbound Order Summary page")
    public void selectOrderByIndex(int index) {
        log.info("Selecting Order by index");
        List<String> orders = List.of(outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder1(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder2(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder3(),
                 outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder4(), outboundOrderLoadsDTO.getOutboundOrders()
                .getOutboundOrder5(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder6(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder7());
        outboundOrderSummaryPage.selectOrderByOrderName(orders.get(index));
    }

    @Step
    @When("Filling scheduled date {string} and scheduled time {string}")
    public void fillingDateAndTime(String date, String time) {
        log.info("Filling scheduled date and time");
        outboundOrderSummaryPage.typeScheduledDate(date);
        outboundOrderSummaryPage.typeScheduledTime(time);
    }

    @Step
    @When("Filling scheduled date by index {int} and scheduled time {string}")
    public void fillingDateByIndexAndTime(int index, String time) {
        log.info("Filling scheduled date by index and time");
        List<String> dates = List.of(outboundOrderLoadsDTO.getStartDates().getStartDate1(), outboundOrderLoadsDTO
                .getStartDates().getStartDate2(), outboundOrderLoadsDTO.getStartDates().getStartDate3(),
                outboundOrderLoadsDTO.getStartDates().getStartDate4(), outboundOrderLoadsDTO.getStartDates().getStartDate5(),
                outboundOrderLoadsDTO.getStartDates().getStartDate6(), outboundOrderLoadsDTO.getStartDates().getStartDate7());
        outboundOrderSummaryPage.typeScheduledDate(dates.get(index));
        outboundOrderSummaryPage.typeScheduledTime(time);
    }

    @Step
    @Then("User add comments {string}")
    public void fillingDateAndTime(String comments) {
        log.info("Adding comments " + comments);
        outboundOrderSummaryPage.typeComments(comments);
    }

    @Step
    @And("User selects work item on Outbound Order Summary page")
    public void selectWorkItem() {
        log.info("Selecting Work Item");
        outboundOrderSummaryPage.clickWorkItem();
    }

    @Step
    @And("User selects assign item on Outbound Order Summary page")
    public void selectAssignItem() {
        log.info("Selecting Assign Item");
        outboundOrderSummaryPage.clickAssignItem();
    }

    @Step
    @And("User clicks user dropdown on Outbound Order Summary page")
    public void clickUserDropdown() {
        log.info("Clicking User dropdown");
        outboundOrderSummaryPage.clickUserDropdown();
    }

    @Step
    @And("User clicks order type dropdown on Outbound Order Summary page")
    public void clickOrderTypeDropdown() {
        log.info("Clicking Order type dropdown");
        outboundOrderSummaryPage.clickOrderTypeDropdownButton();
    }

    @Step
    @And("User selects {string} option dropdown on Outbound Order Summary page")
    public void clickCustomerOrderTypeDropdown(String type) {
        log.info("Selecting Order type " + type);
        outboundOrderSummaryPage.selectOrderType(type);
    }

    @Step
    @And("User selects option by index {int} on Outbound Order Summary page")
    public void clickCustomerOrderTypeByIndex(int index) {
        log.info("Selecting Order type by index");
        List<String> types = List.of(outboundOrderLoadsDTO.getOutboundOrderTypes().getOutboundOrderType1(), outboundOrderLoadsDTO
                .getOutboundOrderTypes().getOutboundOrderType2(), outboundOrderLoadsDTO.getOutboundOrderTypes().getOutboundOrderType3(),
                 outboundOrderLoadsDTO.getOutboundOrderTypes().getOutboundOrderType4(), outboundOrderLoadsDTO.getOutboundOrderTypes()
                .getOutboundOrderType5(), outboundOrderLoadsDTO.getOutboundOrderTypes().getOutboundOrderType6());
        outboundOrderSummaryPage.selectOrderType(types.get(index));
    }

    @Step
    @And("Selects random user from dropdown on Outbound Order Summary page")
    public void selectFirstUserFromDropdown() {
        log.info("Selecting random User from dropdown");
        outboundOrderSummaryPage.selectRandomUserFromDropdown();
    }

    @Step
    @When("User selects Tasks item on Outbound Order Summary page")
    public void selectTasksItem() {
        log.info("Selecting Tasks Item");
        outboundOrderSummaryPage.clickTaskItem();
    }

    @Step
    @When("User clicks Assignment Type on Outbound Order Summary page")
    public void clickAssignmentType() {
        log.info("Clicking Assignment type");
        outboundOrderSummaryPage.clickAssignmentType();
    }

    @Step
    @And("Clicks Edit item on Outbound Order Summary page")
    public void clickEdit() {
        log.info("Click Edit Item");
        outboundOrderSummaryPage.clickEditItem();
    }

    @Step
    @And("User selects first assignment on Outbound Order Summary page")
    public void selectFirstAssignment() {
        log.info("Selecting first assignment");
        outboundOrderSummaryPage.selectItemByNumber(0);
    }

    @Step
    @And("User selects first task on Outbound Order Summary page")
    public void selectFirstTask() {
        log.info("Selecting first task");
        outboundOrderSummaryPage.selectItemByNumber(0);
    }

    @Step
    @When("User clicks Add filter button on Outbound Order Summary page")
    public void clickAddFilter() {
        log.info("Clicking add filter");
        outboundOrderSummaryPage.clickAddFilter();
    }

    @Step
    @When("Filling current start date and tomorrow end date on Outbound Order Summary page")
    public void fillingCurrentStartDateAndTomorrowEndDate() {
        log.info("Filling Outbound Order Current start date and tomorrow end date");
        outboundOrderSummaryPage.typeOrderEndDate(TimeConversion.futureDate(1, Calendar.DATE, TimeConversion
                .getFormattedCurrentDate(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        outboundOrderSummaryPage.typeOrderStartDate(TimeConversion.getFormattedCurrentDate(TimeFormats
                .format_MMddyyyy));
    }

    @Step
    @And("Searches for order {string} on Outbound Order Summary page")
    public void fillingOrderData(String order) {
        log.info("Search Outbound Order Number");
        outboundOrderSummaryPage.searchOrder(order);
    }

    public WebElement getEnterOrderInput() {  return findWebElement(enterOrder); }
    @Step
    @And("Searches for order by index {int} on Outbound Order Summary page")
    public void fillingOrderDataByIndex(int index) throws InterruptedException {
        log.info("Search Outbound Order Number");
        //clears input box
        clear(getEnterOrderInput());
        List<String> orders = List.of(outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder1(), outboundOrderLoadsDTO
                 .getOutboundOrders().getOutboundOrder2(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder3(),
                  outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder4(), outboundOrderLoadsDTO.getOutboundOrders()
                 .getOutboundOrder5(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder6(), outboundOrderLoadsDTO
                 .getOutboundOrders().getOutboundOrder7());
        outboundOrderSummaryPage.searchOrder(orders.get(index));
        //Thread.sleep(7000);

        waitUntilInvisible(10, loader);

    }

    @Step
    @And("Clears Search on Outbound Order Summary page")
    public void clearSearchOrder() {
        log.info("Clears Search Outbound Order Number");
        outboundOrderSummaryPage.clearSearchOrder();
    }


    @Step
    @When("User searches for Order that does not exist in DB on Outbound Order Summary page")
    public void fillingRandomOrderData() {
        log.info("Search Random Outbound Order Number");
        outboundOrderSummaryPage.searchOrder(RandomStringUtils.randomAlphabetic(4));
    }

    @Step
    @And("User clicks Search Order Button on Outbound Order Summary page")
    public void clickSearchOrderButton() {
        log.info("Click Search Order Button on Outbound Order Summary page");
        outboundOrderSummaryPage.clickSearchOrderButton();
    }

    @Step
    @And("User clicks All Statuses dropdown on Outbound Order Summary page")
    public void clickAllStatusButton() {
        log.info("Click All Status Button");
        outboundOrderSummaryPage.clickAllStatusButton();
    }

    @Step
    @And("Select Outbound Order Open status")
    public void selectOutboundOrderOpenStatus() {
        log.info("Selecting Outbound Order Status " + Statuses.OPEN.getStatus());
        outboundOrderSummaryPage.selectOutboundOrderStatus(Statuses.OPEN.getStatus());
    }

    @Step
    @And("Select Outbound Order Closed status")
    public void selectOutboundOrderClosedStatus() {
        log.info("Selecting Outbound Order Status " + Statuses.CLOSED.getStatus());
        outboundOrderSummaryPage.selectOutboundOrderStatus(Statuses.CLOSED.getStatus());
    }

    @Step
    @And("Select Outbound Order Cancelled status")
    public void selectOutboundOrderCancelledStatus() {
        log.info("Selecting Outbound Order Status " + Statuses.CANCELLED.getStatus());
        outboundOrderSummaryPage.selectOutboundOrderStatus(Statuses.CANCELLED.getStatus());
    }

    @Step
    @And("Select Outbound Order Shipment In Progress status")
    public void selectOutboundOrderShipmentInProgressStatus() {
        log.info("Selecting Outbound Order Status " + Statuses.SHIPMENT_IN_PROGRESS.getStatus());
        outboundOrderSummaryPage.selectOutboundOrderStatus(Statuses.SHIPMENT_IN_PROGRESS.getStatus());
    }

    @Step
    @And("Select Outbound Order All Status status")
    public void selectOutboundOrderAllStatusStatus() {
        log.info("Selecting Outbound Order Status " + Statuses.ALL_STATUSES.getStatus());
        outboundOrderSummaryPage.selectOutboundOrderStatus(Statuses.ALL_STATUSES.getStatus());
    }

    @SneakyThrows
    @Step
    @And("Selects Account within {string} and {string} range")
    public void selectOutboundOrderAccount(String startDate, String endDate) {
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        OutboundSummaryParams outboundSummaryParams = new ObjectMapperWrapper()
                .getObject(FilePaths.OUTBOUND_ORDER_SUMMARY_DATA, OutboundSummaryParams.class);
        outboundSummaryParams.setStart_date(startDate);
        outboundSummaryParams.setEnd_date(endDate);
        ResultSet resultSet = storeProceduresUtils.executeStoreProcedureOutboundOrderSummary(DataBaseConnection
                .getDataBaseConnection(dataBaseData), outboundSummaryParams);
        outboundSummaryParams.setAccount_code(resultSet.getString(7).substring(0, 7).trim());
        log.info("Selecting Outbound Account " + outboundSummaryParams.getAccount_code());
        outboundOrderSummaryPage.clickClearButton();
        outboundOrderSummaryPage.selectOutboundOrderAccount(outboundSummaryParams.getAccount_code());
    }

    @Step
    @And("Clears Enter Account field on Outbound Order Summary page")
    public void clearAccountField() {
        log.info("Clears Account field");
        outboundOrderSummaryPage.clickClearButton();
    }

    @Step
    @And("Clears Account field on Outbound Order Summary page")
    public void clearAccount() {
        log.info("Clears Account");
        outboundOrderSummaryPage.clearAccountField();
    }

    @Step
    @And("Selects Account {string} on Outbound Order Summary page")
    public void selectAccount(String account) {
        log.info("Selecting Outbound Account " + account);
        outboundOrderSummaryPage.selectOutboundOrderAccount(account);
    }

    @Step
    @And("Selects Account by index {int} on Outbound Order Summary page")
    public void selectAccountByIndex(int index) {
        log.info("Selecting Outbound Account index");
        List<String> accounts = List.of(outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount1(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount2(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount3(),
                 outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount4(), outboundOrderLoadsDTO.getOutboundAccounts()
                .getOutboundAccount5(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount6(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount7());
        outboundOrderSummaryPage.selectOutboundOrderAccount(accounts.get(index));
    }

    @Step
    @Then("Selects Outbound Order product {string} on Outbound Order Summary page")
    public void selectOutboundOrderProduct(String product) {
        log.info("Selecting Outbound Order Product " + product);
        outboundOrderSummaryPage.selectOutboundOrderProduct(product);
    }

    @SneakyThrows
    @Step
    @And("Enter Account code within {string} and {string} range")
    public void enterAccount(String startDate, String endDate) {
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        OutboundSummaryParams outboundSummaryParams = new ObjectMapperWrapper()
                .getObject(FilePaths.OUTBOUND_ORDER_SUMMARY_DATA, OutboundSummaryParams.class);
        outboundSummaryParams.setStart_date(startDate);
        outboundSummaryParams.setEnd_date(endDate);
        ResultSet resultSet = storeProceduresUtils.executeStoreProcedureOutboundOrderSummary(DataBaseConnection
                .getDataBaseConnection(dataBaseData), outboundSummaryParams);
        outboundSummaryParams.setAccount_code(resultSet.getString(7).trim().substring(0, 2));
        log.info("Typing account " + outboundSummaryParams.getAccount_code());
        outboundOrderSummaryPage.typeAccount(outboundSummaryParams.getAccount_code());
    }

    @Step
    @When("Enter Account {string} on Outbound Order Summary page")
    public void enterAccount(String account) {
        log.info("Typing account " + account);
        outboundOrderSummaryPage.typeAccount(account);
    }

    @SneakyThrows
    @Step
    @And("Enters Product {string} on Outbound Order Summary page")
    public void enterProduct(String product) {
        log.info("Typing product " + product);
        outboundOrderSummaryPage.typeProduct(product);
    }

    @SneakyThrows
    @Step
    @And("Enters Product by index {int} on Outbound Order Summary page")
    public void enterProductByIndex(int index) {
        log.info("Typing product by index");
        List<String> products = List.of(outboundOrderLoadsDTO.getOutboundProducts().getOutboundProduct1(), outboundOrderLoadsDTO
                .getOutboundProducts().getOutboundProduct2(), outboundOrderLoadsDTO.getOutboundProducts().getOutboundProduct3(),
                 outboundOrderLoadsDTO.getOutboundProducts().getOutboundProduct4(), outboundOrderLoadsDTO.getOutboundProducts()
                .getOutboundProduct5(), outboundOrderLoadsDTO.getOutboundProducts().getOutboundProduct6());
        outboundOrderSummaryPage.typeProduct(products.get(index));
    }

    @Step
    @Then("Searches account {string} on Outbound Order Summary page")
    public void searchAccount(String account) {
        log.info("Search account " + account);
        outboundOrderSummaryPage.searchAccount(account);
    }

    @Step
    @Then("Searches account by index {int} on Outbound Order Summary page")
    public void searchAccountByIndex(int index) {
        log.info("Search account by index");
        List<String> accounts = List.of(outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount1(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount2(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount3(),
                 outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount4(), outboundOrderLoadsDTO.getOutboundAccounts()
                .getOutboundAccount5(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount6(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount7());
        outboundOrderSummaryPage.searchAccount(accounts.get(index));
    }

    @Step
    @And("Click Cancel button on Outbound Order Summary page")
    public void clickCancel() {
        log.info("Clicking cancel on Outbound Order Summary page");
        outboundOrderSummaryPage.clickCancelButton();
    }

    @Step
    @And("Click clear on Outbound Order Summary page")
    public void clickClear() {
        log.info("Clicking clear");
        outboundOrderSummaryPage.clickClearButton();
    }

    @Step
    @And("Click Clear account index on Outbound Order Summary page")
    public void clickClearAccountIndex() {
        log.info("Clicking clear account index");
        outboundOrderSummaryPage.clickClearAccountSearchButton();
    }

    @Step
    @And("Click Back button on Outbound Order Summary page")
    public void clickBack() {
        log.info("Clicking back Outbound Order Summary page");
        outboundOrderSummaryPage.clickBackButton();
    }

    @Step
    @And("Selects order checkbox with index {int} on Outbound Order Summary page")
    public void selectOrderCheckboxByNumber(int orderNum) {
        log.info("Selecting Order by number " + orderNum);
        outboundOrderSummaryPage.selectOrderDetailsBox(orderNum);
    }

    @Step
    @And("Click Back button on Outbound Order Source page")
    public void clickBackButton() {
        log.info("Clicking back Outbound Order Source page");
        outboundOrderSummaryPage.clickBackButton();
    }

    @Step
    @Then("Click Search account on Outbound Order Summary page")
    public void clickSearchAccount() {
        log.info("Clicking Search account");
        outboundOrderSummaryPage.clickSearchOrderButton();
    }

    @Step
    @And("Clear order input on Outbound Order Summary page")
    public void clearOrderInput() {
        log.info("Clearing order input");
        outboundOrderSummaryPage.clearOrderInput();
    }

    @Step
    @And("Clicks Order option on Outbound Order Summary page")
    public void clickOrderOption() {
        log.info("Clicks Order option");
        outboundOrderSummaryPage.clickOrderOption();
    }

    @Step
    @And("Selects {string} option on Outbound Order Summary page")
    public void selectDoor(String door) {
        log.info("Selecting door " + door);
        outboundOrderSummaryPage.selectDoorListOption(door);
    }

    @Step
    @And("Selects {string} door option on Outbound Order Summary page")
    public void clickDoorByValue(String door) {
        log.info("Selecting door option" + door);
        outboundOrderSummaryPage.clickDoorDropDown(door);
    }

    @Step
    @Then("Selects first order on Outbound Order Summary page")
    public void selectFirstOrder() {
        log.info("Selecting first order on Outbound Order Summary page");
        outboundOrderSummaryPage.selectDetailsRow(0);
    }

    @Step
    @When("Selects last order on Outbound Order Summary page")
    public void selectLastOrder() {
        log.info("Selecting last order");
        outboundOrderSummaryPage.selectDetailsRow(getOutboundOrdersNumber() - 1);
    }

    @Step
    @When("Select Order checkbox with index {int} on Outbound Order Summary page")
    public void selectOrderDetailsCheckbox(int number) {
        log.info("Selecting input of order " + number);
        outboundOrderSummaryPage.selectOrderDetailsBox(number);
    }

    @Step
    public void selectProductRow(int number) {
        log.info("Selecting Product Row " + number);
        outboundOrderSummaryPage.selectProductRow(number);
    }

    @Step
    @Then("Selecting Outbound Order Release option on Outbound Order Summary page")
    public void selectOutboundOrderReleaseOption() {
        log.info("Selecting Outbound Order Option " + OrderOptions.RELEASE.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.RELEASE.getOrderOption());
    }

    @Step
    @And("Selecting Outbound Order DOOR option on Outbound Order Summary page")
    public void selectOutboundOrderDOOROption() {
        log.info("Selecting Outbound Order Option " + OrderOptions.DOOR.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.DOOR.getOrderOption());
    }

    @Step
    @And("Selecting Outbound Order Log option on Outbound Order Summary page")
    public void selectOutboundOrderLogOption() {
        log.info("Selecting Outbound Order Option " + OrderOptions.LOG.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.LOG.getOrderOption());
    }

    @Step
    @And("Selecting Outbound Order Source option on Outbound Order Summary page")
    public void selectOutboundOrderSourceOption() {
        log.info("Selecting Outbound Order Option " + OrderOptions.SOURCE.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.SOURCE.getOrderOption());
    }

    @Step
    @And("Selecting Outbound Order Review option on Outbound Order Summary page")
    public void selectOutboundOrderReviewOption() {
        log.info("Selecting Outbound Order Option " + OrderOptions.REVIEW.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.REVIEW.getOrderOption());
    }

    @Step
    @And("Selecting Outbound Order Move option on Outbound Order Summary page")
    public void selectOutboundOrderMoveOption() {
        log.info("Selecting Outbound Order Option " + OrderOptions.MOVE.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.MOVE.getOrderOption());
    }

    @Step
    @And("Selecting Outbound Order Data option on Outbound Order Summary page")
    public void selectOutboundOrderDataOption() {
        log.info("Selecting Outbound Order Option " + OrderOptions.DATA.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.DATA.getOrderOption());
    }

    @Step
    @And("Selecting Outbound Order Image option on Outbound Order Summary page")
    public void selectOutboundOrderImageOption() throws InterruptedException {
        waitUntilInvisible(15, loader);
        Thread.sleep(5000);
        log.info("Selecting Outbound Order Option " + OrderOptions.IMAGE.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.IMAGE.getOrderOption());
    }

    @Step
    @And("Clicks Ok on Outbound Order Summary page")
    public void clickOK() {
        log.info("Clicking Ok");
        outboundOrderSummaryPage.clickOkButton();
    }

    @Step
    @And("Selects random route on Move popup")
    public void selectRandomRoute() {
        log.info("Selects random route");
        outboundOrderSummaryPage.selectRandomRoutePopup();
    }

    @Step
    @And("Types {string} route on Move popup")
    public void typeRandomRoute(String route) {
        log.info("Types route on Move popup");
        outboundOrderSummaryPage.typeRoute(route);
    }

    @Step
    @And("Selecting Door List {string} option on Outbound order summary page")
    public void selectDoorListDOOROption(String door) {
        log.info("Selecting Door Option " + door);
        outboundOrderSummaryPage.selectDoorListOption(door);
    }

    @Step
    @And("Clicks Save button on Outbound order summary page")
    public void clickSave() {
        log.info("Clicking Save");
        outboundOrderSummaryPage.clickSaveButton();
    }

    @Step
    @And("Clicks Route dropdown on Outbound order summary page")
    public void clickRouteDropDown() {
        log.info("Clicking Route dropdown");
        outboundOrderSummaryPage.clickRouteDropdownButton();
    }

    @Step
    @And("Select Outbound Order Edit option")
    public void selectOutboundOrderEditOption() throws InterruptedException {
        Thread.sleep(5000);
        //log.info("Selecting Outbound Order Option " + OrderOptions.EDIT.getOrderOption());
        outboundOrderSummaryPage.selectOutboundOrderOption(OrderOptions.EDIT.getOrderOption());
    }

    @Step
    public int getOutboundOrdersNumber() {
        log.info("Getting number of Orders");
        return outboundOrderSummaryPage.getOrderDetailsRowsNumber();
    }
}
