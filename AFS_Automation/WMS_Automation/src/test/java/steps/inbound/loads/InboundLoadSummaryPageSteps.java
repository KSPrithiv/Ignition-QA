package steps.inbound.loads;

import common.constants.FilePaths;
import common.utils.database.DataBaseConnection;
import common.utils.database.StoreProceduresUtils;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import objects.storeproceduresdata.inbound.InboundLoadsSummaryParams;
import objects.userdata.DataBaseData;
import steps.LoginPageSteps;
import ui.pages.inbound.loads.InboundLoadSummaryPage;

import java.sql.ResultSet;

@Slf4j
public class InboundLoadSummaryPageSteps {
    InboundLoadSummaryPage inboundLoadSummaryPage = new InboundLoadSummaryPage();
    StoreProceduresUtils storeProceduresUtils = new StoreProceduresUtils();

    @Step
    @And("Inbound Load Summary page appears")
    public void waitForInboundLoadSummaryToLoad() {
        log.info("Waiting for Inbound Load Summary Page To Load");
        inboundLoadSummaryPage.waitInboundLoadSummaryPageToLoad();
    }

    @Step
    @And("User selects warehouse {string} on Inbound Load Summary page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse {string} on Inbound Load Summary page");
        inboundLoadSummaryPage.selectWarehouse(warehouse);
    }

    @Step
    @When("User searches for Loads starting from {string} date")
    public void findLoadsFromDate(String date) {
        log.info("Finding Loads starting range " + date);
        inboundLoadSummaryPage.typeDateLoadStart(date);
     //   inboundLoadSummaryPage.clickSearchSupplierButton();
    }

    @Step
    @When("Types {string} start date on Inbound Load Summary page")
    public void typeStartDate(String date) {
        log.info("Types Start Date " + date);
        inboundLoadSummaryPage.typeDateLoadStart(date);
    }

    @Step
    @And("Types {string} end date on Inbound Load Summary page")
    public void typeEndDate(String date) {
        log.info("Types End Date " + date);
        inboundLoadSummaryPage.typeDateRouteEnd(date);
    }

    @Step
    @And("Types {string} temperature on Inbound Load Summary page")
    public void typeTemperature(String temperature) {
        log.info("Types Temperature " + temperature);
        inboundLoadSummaryPage.typeTemperature(temperature);
    }

    @Step
    @And("Types {string} seal number on Inbound Load Summary page")
    public void typeSealNumber(String sealNum) {
        log.info("Types Seal Number " + sealNum);
        inboundLoadSummaryPage.typeSealNumber(sealNum);
    }

    @Step
    @And("Types {string} driver for Load")
    public void typeDriver(String driver) {
        log.info("Types Driver " + driver);
        inboundLoadSummaryPage.typeDriver(driver);
    }

    @Step
    @And("Clicks load status {string} on Inbound Load Summary page")
    public void clickOrderStatus(String status) {
        log.info("Clicking Order Status " + status);
        inboundLoadSummaryPage.clickLoadStatus(status);
    }

    @Step
    @Then("Selects load status {string} on Inbound Load Summary page")
    public void selectOrderStatus(String status) {
        log.info("Selecting Order Status " + status);
        inboundLoadSummaryPage.selectLoadStatus(status);
    }

    @Step
    @Then("Selects {int} days ago from start date on Inbound Load Summary page")
    public void selectLoadPastStartDate(int days) {
        log.info("Selecting Load Past Start Date");
        inboundLoadSummaryPage.typePastDateLoadStart(days);
    }

    @Step
    @Then("Selects {int} days ago from end date on Inbound Load Summary page")
    public void selectLoadPastEndDate(int days) {
        log.info("Selecting Load Past End Date");
        inboundLoadSummaryPage.typePastDateLoadEnd(days);
    }

    @Step
    @Then("Selects {int} days forward from start date on Inbound Load Summary page")
    public void selectLoadForwardStartDate(int days) {
        log.info("Selecting Load Forward Start Date");
        inboundLoadSummaryPage.typeFutureDateLoadStart(days);
    }

    @Step
    @Then("Selects {int} days forward from end date on Inbound Load Summary page")
    public void selectLoadForwardEndDate(int days) {
        log.info("Selecting Load Forward End Date");
        inboundLoadSummaryPage.typeFutureDateLoadEnd(days);
    }

    @Step
    @Then("Selects load {int} on Inbound Load Summary page")
    public void selectLoadByNumber(int loadNum) {
        log.info("Selecting Load by number " + loadNum);
        inboundLoadSummaryPage.selectLoadByLoadNumber(loadNum);
    }

    @Step
    @Then("Clicks carrier {string} on Inbound Load Summary page")
    public void clickCarrier(String carrier) {
        log.info("Clicking Carrier  " + carrier);
        inboundLoadSummaryPage.clickCarrierDropdown(carrier);
    }

    @Step
    @Then("Clicks door {string} dropdown on Inbound Load Summary page")
    public void clickDoorDropdown(String door) {
        log.info("Clicking Door  " + door);
        inboundLoadSummaryPage.clickDoorDropdown(door);
    }

    @Step
    @Then("Clicks change status option on Inbound Load Summary page")
    public void clickChangeStatusOption() {
        log.info("Clicking Change Status option");
        inboundLoadSummaryPage.clickChangeStatusOption();
    }

    @Step
    @Then("Clicks door option on Inbound Load Summary page")
    public void clickDoorOption() {
        log.info("Clicking Door option");
        inboundLoadSummaryPage.clickDoorOption();
    }

    @Step
    @Then("Clicks data option on Inbound Load Summary page")
    public void clickDataOption() {
        log.info("Clicking Data option");
        inboundLoadSummaryPage.clickDataOption();
    }

    @Step
    @When("Clicks Add Product Cancel Button on Inbound Load Summary page")
    public void clickAddProductCancel() {
        log.info("Clicking Add Product Cancel button");
        inboundLoadSummaryPage.clickBtnAddProductCancel();
    }

    @Step
    @And("Clicks door on Assign doors popup on Inbound Load Summary page")
    public void clickDoor() {
        log.info("Clicking Door");
        inboundLoadSummaryPage.clickDoorDropdown();
    }

    @Step
    @And("Clicks Save button on Inbound Load Summary page")
    public void clickSave() {
        log.info("Clicking Save");
        inboundLoadSummaryPage.clickSave();
    }

    @Step
    @And("Clicks Cancel button on Inbound Load Summary page")
    public void clickCancel() {
        log.info("Clicking Cancel");
        inboundLoadSummaryPage.clickCancel();
    }

    @Step
    @And("Clicks Route Back button on Inbound Load Summary page")
    public void clickRouteBackButton() {
        log.info("Clicking Route Back");
        inboundLoadSummaryPage.clickRouteBackButton();
    }

    @Step
    @And("Clicks No button on Inbound Load Summary page")
    public void clickNoButton() {
        log.info("Clicking No");
        inboundLoadSummaryPage.clickNoButton();
    }

    @Step
    @Then("Clicks load type {string} dropdown on Inbound Load Summary page")
    public void clickLoadTypeDropdown(String loadType) {
        log.info("Clicking Load Type  " + loadType);
        inboundLoadSummaryPage.clickLoadTypeDropdown(loadType);
    }

    @Step
    @Then("Clicks buyer {string} dropdown on Inbound Load Summary page")
    public void clickBuyerDropdown(String buyer) {
        log.info("Clicking Buyer  " + buyer);
        inboundLoadSummaryPage.clickBuyerDropDown(buyer);
    }

    @Step
    @And("Selects buyer {string} dropdown on Inbound Load Summary page")
    public void selectBuyer(String buyer) {
        log.info("Selecting Buyer  " + buyer);
        inboundLoadSummaryPage.selectOption(buyer);
    }

    @Step
    @Then("Clicks door {string} on Inbound Load Summary page")
    public void clickDoor(String door) {
        log.info("Clicking Door  " + door);
        inboundLoadSummaryPage.selectOption(door);
    }

    @Step
    @Then("Clicks load type {string} on Inbound Load Summary page")
    public void clickLoadType(String loadType) {
        log.info("Clicking Load Type  " + loadType);
        inboundLoadSummaryPage.selectOption(loadType);
    }

    @Step
    @Then("Types supplier code {string} on Inbound Load Summary page")
    public void typeSupplierCode(String code) {
        log.info("Searching supplier code " + code);
        inboundLoadSummaryPage.searchSupplierByCode(code);
    }

    @Step
    @Then("Types supplier name {string} on Inbound Load Summary page")
    public void typeSupplierName(String name) {
        log.info("Searching supplier name " + name);
        inboundLoadSummaryPage.searchSupplierByName(name);
    }

    @Step
    @Then("Types product {string} on Inbound Load Summary page")
    public void typeProduct(String product) {
        log.info("Searching product " + product);
        inboundLoadSummaryPage.typeProduct(product);
    }

    @Step
    @And("Clears supplier name on Inbound Load Summary page")
    public void clearSupplierName() {
        log.info("Clear supplier name");
        inboundLoadSummaryPage.cleanSupplierName();
    }

    @Step
    @And("Clears product on Inbound Load Summary page")
    public void clearProduct() {
        log.info("Clear product");
        inboundLoadSummaryPage.cleanProduct();
    }

    @Step
    @Then("Selects carrier {string} on Inbound Load Summary page")
    public void selectCarrier(String carrier) {
        log.info("Selecting Carrier  " + carrier);
        inboundLoadSummaryPage.selectOption(carrier);
    }

    @Step
    @Then("Types load {string} on Inbound Load Summary page")
    public void typesLoad(String load) {
        log.info("Types Load " + load);
        inboundLoadSummaryPage.searchLoad(load);
    }

    @Step
    @Then("Cleans load input on Inbound Load Summary page")
    public void cleanLoad() {
        log.info("Cleans Load");
        inboundLoadSummaryPage.cleanLoad();
    }

    @Step
    @And("Selects Load with index {int} and apply {string} Load Option for Load")
    public void applyLoadOptionForLoadByLoadNumber(int loadNum, String option) {
        log.info("Applying Load option " + option + " Load by number " + loadNum);
        inboundLoadSummaryPage.selectLoadByLoadNumber(loadNum);
        inboundLoadSummaryPage.selectLoadOption(option);
    }

    @Step
    @And("Clicks Load Option dropdown for Load")
    public void clickLoadOptionForLoad() {
        log.info("Clicking Load option for Load");
        inboundLoadSummaryPage.clickLoadOptionDropDown();
    }

    @Step
    @And("Selects Load Option {string} for Load")
    public void clickLoadOption(String option) {
        log.info("Selecting Load option " + option);
        inboundLoadSummaryPage.selectLoadOption(option);
    }

    @Step
    @And("Checks Load with index {int} and apply {string} Load Option for Load")
    public void checkAndApplyLoadOptionForLoadByLoadNumber(int loadNum, String option) {
        log.info("Applying Load option " + option + " Load by number " + loadNum);
        inboundLoadSummaryPage.checkLoadByLoadRouteIndex(loadNum);
        inboundLoadSummaryPage.selectLoadOption(option);
    }

    @Step
    @And("Select Load with index {int} on Inbound Load Summary page")
    public void selectLoadByLoadNumber(int loadNum) {
        log.info("Check Load by number " + loadNum);
        inboundLoadSummaryPage.clickLoadByLoadNumber(loadNum);
    }

    @Step
    @And("Select Load Order with index {int} on Inbound Load Summary page")
    public void selectLoadOrderByLoadNumber(int num) {
        log.info("Check Load Order by number " + num);
        inboundLoadSummaryPage.clickLoadOrderByNumber(num);
    }

    @Step
    @And("Checks Load with index {int} on Inbound Load Summary page")
    public void checkLoadByLoadNumber(int loadNum) {
        log.info("Check Load by number " + loadNum);
        inboundLoadSummaryPage.checkLoadByLoadRouteIndex(loadNum);
    }

    @Step
    @And("Select Ready to Receive option on Inbound Load Summary page")
    public void selectReadyToReceive() {
        log.info("Select Ready to Receive");
        inboundLoadSummaryPage.clickReadyToReceiveStatus();
    }

    @SneakyThrows
    @Step
    @And("Selects Load Route and {string} Load Option for Load")
    public void applyLoadOptionForLoadByLoadRoute(String option) {
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        InboundLoadsSummaryParams inboundLoadsSummaryParams = new ObjectMapperWrapper()
                .getObject(FilePaths.INBOUND_LOAD_SUMMARY_DATA, InboundLoadsSummaryParams.class);
        inboundLoadsSummaryParams.setStart_date("2017-01-01");
        inboundLoadsSummaryParams.setEnd_date("2022-01-01");
        ResultSet resultSet = storeProceduresUtils.executeStoreProcedureInboundRouteSummary(DataBaseConnection
                .getDataBaseConnection(dataBaseData), inboundLoadsSummaryParams);
        inboundLoadsSummaryParams.setRoute_code(resultSet.getString(1).trim());
       // DataBaseConnection.closeDataBaseConnection();
        log.info("Applying Load option " + option + " Load by route " + inboundLoadsSummaryParams.getRoute_code());
        inboundLoadSummaryPage.selectLoadByLoadRouteCode(inboundLoadsSummaryParams.getRoute_code());
        inboundLoadSummaryPage.selectLoadOption(option);
    }

    @SneakyThrows
    @Step
    @And("Checks Load Route and {string} Load Option for Load")
    public void checkAndApplyLoadOptionForLoadByLoadRoute(String option) {
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        InboundLoadsSummaryParams inboundLoadsSummaryParams = new ObjectMapperWrapper()
                .getObject(FilePaths.INBOUND_LOAD_SUMMARY_DATA, InboundLoadsSummaryParams.class);
        inboundLoadsSummaryParams.setStart_date("2017-01-01");
        inboundLoadsSummaryParams.setEnd_date("2022-01-01");
        ResultSet resultSet = storeProceduresUtils.executeStoreProcedureInboundRouteSummary(DataBaseConnection
                .getDataBaseConnection(dataBaseData), inboundLoadsSummaryParams);
        inboundLoadsSummaryParams.setRoute_code(resultSet.getString(1).trim());
        // DataBaseConnection.closeDataBaseConnection();
        log.info("Applying Load option " + option + " Load by route " + inboundLoadsSummaryParams.getRoute_code());
        inboundLoadSummaryPage.checkLoadByLoadRouteCode(inboundLoadsSummaryParams.getRoute_code());
        inboundLoadSummaryPage.selectLoadOption(option);
    }
}
