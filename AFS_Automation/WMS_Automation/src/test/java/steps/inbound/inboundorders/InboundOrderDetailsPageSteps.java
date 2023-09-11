package steps.inbound.inboundorders;

import common.constants.FilePaths;
import common.enums.DockDoorOption;
import common.utils.Waiters;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.inbound.InboundOrderLoadsDTO;
import ui.pages.inbound.inboundorders.InboundOrderDetailsPage;

import java.util.List;

@Slf4j
public class InboundOrderDetailsPageSteps {
    InboundOrderDetailsPage inboundOrderDetailsPage = new InboundOrderDetailsPage();
    InboundOrderLoadsDTO inboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.INBOUND_ORDER_LOAD_DATA, InboundOrderLoadsDTO.class);

    @Step
    @And("User waits for Inbound Order Details page to load")
    public void waitForInboundOrderSummaryPageToLoad() {
        log.info("Waiting for Inbound Order Details Page To Load ");
        inboundOrderDetailsPage.waitInboundOrderDetailsPageToLoad();
    }

    @Step
    @Then("User applies order {string} option on Inbound Order Details page")
    public void applyOrderOptionForOrder(String option) {
        log.info("Applying Order option " + option + " for order ");
        inboundOrderDetailsPage.selectOrderOption(option);
    }

    @Step
    @And("Clicks change status option on Inbound Order Details page")
    public void clickChangeStatusOption() {
        log.info("Clicking Change Status option");
        inboundOrderDetailsPage.clickChangeStatusOption();
    }

    @Step
    @And("Clicks door option on Inbound Order Details page")
    public void clickDoorOption() {
        log.info("Clicking Door option");
        inboundOrderDetailsPage.clickDoorOption();
}

    @Step
    @And("Clicks data option on Inbound Order Details page")
    public void clickDataOption() {
        log.info("Clicking Data option");
        inboundOrderDetailsPage.clickDataOption();
    }

    @Step
    @And("Clicks Cancel button on Inbound Order Details page")
    public void clickCancel() {
        log.info("Clicking Cancel");
        inboundOrderDetailsPage.clickCancel();
    }

    @Step
    @And("Clicks Save button on Inbound Order Details page")
    public void clickSave() {
        log.info("Clicking Save");
        inboundOrderDetailsPage.clickSave();
    }

    @Step
    @And("Clicks order status {string} on Inbound Order Details page")
    public void clickInboundOrderStatus(String status) {
        log.info("Clicking Order Status " + status);
        inboundOrderDetailsPage.clickOrderStatus(status);
    }

    @Step
    @Then("Selects order status {string} on Inbound Order Details page")
    public void selectInboundOrderStatus(String status) {
        log.info("Selecting Order Status " + status);
        inboundOrderDetailsPage.selectOrderStatus(status);
    }

    @Step
    @And("Selects order with index {int} on Inbound Order Details page")
    public void selectOrderByNumber(int orderNum) {
        log.info("Selecting Order by number " + orderNum);
        inboundOrderDetailsPage.selectOrderByOrderNumber(orderNum);
    }

    @Step
    @And("Clicks Route Back button on Inbound Order Details page")
    public void clickRouteBackButton() {
        log.info("Clicking Route Back");
        inboundOrderDetailsPage.clickRouteBackButton();
    }

    @Step
    @And("Clicks Select door option on Inbound Order Details page")
    public void clickSelectDoor() {
        log.info("Selecting Select door option");
        inboundOrderDetailsPage.clickDoorDropdown();
    }

    @Step
    @And("Selects DOOR option on Inbound Order Details page")
    public void selectDoor() {
        log.info("Selecting door " + DockDoorOption.DOOR.getDockDoorOption());
        inboundOrderDetailsPage.selectOption(DockDoorOption.DOOR.getDockDoorOption());
    }

    @Step
    @And("Selects DR01 option on Inbound Order Details page")
    public void selectDoor01() {
        log.info("Selecting door " + DockDoorOption.DOOR01.getDockDoorOption());
        inboundOrderDetailsPage.selectOption(DockDoorOption.DOOR01.getDockDoorOption());
    }

    @Step
    @And("Types {string} Ship Date on Inbound Order Details page")
    public void typeShipDate(String date) {
        log.info("Typing Ship Date " + date);
        inboundOrderDetailsPage.typeShipDate(date);
    }

    @Step
    @And("Types Ship Date by index {int} on Inbound Order Details page")
    public void typeShipDateByIndex(int index) {
        log.info("Typing Ship Date by index");
        List<String> dates = List.of(inboundOrderLoadsDTO.getEndDates().getEndDate1(), inboundOrderLoadsDTO
                .getEndDates().getEndDate2(), inboundOrderLoadsDTO.getEndDates().getEndDate3(), inboundOrderLoadsDTO
                .getEndDates().getEndDate4(), inboundOrderLoadsDTO.getEndDates().getEndDate5(), inboundOrderLoadsDTO
                .getEndDates().getEndDate6());
        inboundOrderDetailsPage.typeShipDate(dates.get(index));
    }

    @Step
    @And("Types {string} Load on Inbound Order Details page")
    public void typeLoad(String load) {
        log.info("Typing Load " + load);
        inboundOrderDetailsPage.typeLoad(load);
    }

    @Step
    @And("Types Load name by index {int} on Inbound Order Details page")
    public void typeLoadByIndex(int index) {
        log.info("Typing Load by index");
        List<String> loads = List.of(inboundOrderLoadsDTO.getLoadNames().getLoadName1(), inboundOrderLoadsDTO
                .getLoadNames().getLoadName2(), inboundOrderLoadsDTO.getLoadNames().getLoadName3(), inboundOrderLoadsDTO
                .getLoadNames().getLoadName4(), inboundOrderLoadsDTO.getLoadNames().getLoadName5(), inboundOrderLoadsDTO
                .getLoadNames().getLoadName6());
        inboundOrderDetailsPage.typeLoad(loads.get(index));
    }

    @Step
    @And("Clicks Add Filter button on Inbound Order Details page")
    public void clickAddFilter() {
        log.info("Clicking Add Filter");
        inboundOrderDetailsPage.clickAddFilter();
    }

    @Step
    @And("Select Order Product with index {int} on Inbound Order Details page")
    public void selectInboundOrderProductByNumber(int num) {
        log.info("Select Order Product by number " + num);
        inboundOrderDetailsPage.clickOrderProductByNumber(num);
    }

    @Step
    @And("Select Order Line Item with index {int} on Inbound Order Details page")
    public void selectInboundOrderLineItemByNumber(int num) {
        log.info("Select Order Line Item by number " + num);
        inboundOrderDetailsPage.clickOrderLineItemByNumber(num);
    }

    @Step
    @And("Clicks Order Line Data button on Inbound Order Details page")
    public void clickOrderLineDataBtn() {
        log.info("Click Order Line Data button");
        inboundOrderDetailsPage.clickProductDataBtn();
    }

    @Step
    @And("Clicks Order Line Edit button on Inbound Order Details page")
    public void clickOrderLineEditBtn() {
        log.info("Click Order Line Edit button");
        inboundOrderDetailsPage.clickProductEditBtn();
    }

    @Step
    @And("Clicks Order Line Image button on Inbound Order Details page")
    public void clickOrderLineImageBtn() {
        log.info("Click Order Line Image button");
        inboundOrderDetailsPage.clickOrderLineFieldsImageBtn();
    }
}
