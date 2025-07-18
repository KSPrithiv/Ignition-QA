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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.inbound.inboundorders.InboundOrderDetailsPage;

import java.time.Duration;
import java.util.List;

import static common.setup.DriverManager.getDriver;

@Slf4j
public class InboundOrderDetailsPageSteps {
    public static final Logger LOG = LoggerFactory.getLogger(InboundOrderDetailsPageSteps.class);
    InboundOrderDetailsPage inboundOrderDetailsPage = new InboundOrderDetailsPage();
    InboundOrderLoadsDTO inboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.INBOUND_ORDER_LOAD_DATA, InboundOrderLoadsDTO.class);

    @Step
    @And("User waits for Inbound Order Details page to load")
    public void waitForInboundOrderSummaryPageToLoad() {
        LOG.info("Waiting for Inbound Order Details Page To Load ");
        inboundOrderDetailsPage.waitInboundOrderDetailsPageToLoad();
    }

    @Step
    @Then("User applies order {string} option on Inbound Order Details page")
    public void applyOrderOptionForOrder(String option) {
        LOG.info("Applying Order option " + option + " for order ");
        inboundOrderDetailsPage.selectOrderOption(option);
    }

    @Step
    @And("Clicks change status option on Inbound Order Details page")
    public void clickChangeStatusOption() {
        LOG.info("Clicking Change Status option");
        //inboundOrderDetailsPage.clickChangeStatusOption();
       // inboundOrderDetailsPage.clickOrderStatus();
        inboundOrderDetailsPage.clickChangeStatusButton();

    }

    @Step
    @And("Clicks door option on Inbound Order Details page")
    public void clickDoorOption() {
        LOG.info("Clicking Door option");
        inboundOrderDetailsPage.clickDoorOption();
}

    @Step
    @And("Clicks data option on Inbound Order Details page")
    public void clickDataOption() {
        LOG.info("Clicking Data option");
        inboundOrderDetailsPage.clickDataOption();
    }

    @Step
    @And("Clicks Cancel button on Inbound Order Details page")
    public void clickCancel() {
        LOG.info("Clicking Cancel");
        inboundOrderDetailsPage.clickCancel();
    }

    @Step
    @And("Clicks Save button on Inbound Order Details page")
    public void clickSave() {
        LOG.info("Clicking Save");
        inboundOrderDetailsPage.clickSave();
    }

    @Step
    @And("Clicks order status {string} on Inbound Order Details page")
    public void clickInboundOrderStatus(String status) {
        LOG.info("Clicking Order Status " + status);
        inboundOrderDetailsPage.clickOrderStatus(status);

    }

   /* @Step
    @Then("Selects order status {string} on Inbound Order Details page")
    public void selectInboundOrderStatus(String status) {
        LOG.info("Selecting Order Status " + status);
        inboundOrderDetailsPage.selectOrderStatus(status);

    }*/
    @Step
   @Then("Selects order status {string} on Inbound Order Details page")
   public void selectInboundOrderStatus(String status) {
       LOG.info("Clicking and selecting order status: " + status);
       inboundOrderDetailsPage.clickStatusFilterDropdown(); // <== Make sure this line exists
       Waiters.waitABit(1000);
       //inboundOrderDetailsPage.selectStatusFromDropdown(status);
        inboundOrderDetailsPage.selectOrderStatus(status);

   }






    @Step
    @And("Selects order with index {int} on Inbound Order Details page")
    public void selectOrderByNumber(int orderNum) {
      //  LOG.info("Selecting Order by number " + orderNum);
     //  inboundOrderDetailsPage.selectOrderByOrderNumber(orderNum);
        LOG.info("Selecting Order by number " + orderNum);
        List<WebElement> orders = inboundOrderDetailsPage.getOrderProducts();
        if (orders.size() > orderNum) {
            WebElement order = orders.get(orderNum);
            LOG.info("Found order element: " + order.getText());
            inboundOrderDetailsPage.clickOnElement(order);
        } else {
            LOG.error("Order not found at index: " + orderNum);
        }

    }

    @Step
    @And("Clicks Route Back button on Inbound Order Details page")
    public void clickRouteBackButton() {
        LOG.info("Clicking Route Back");
        inboundOrderDetailsPage.clickRouteBackButton();
    }

    @Step
    @And("Clicks Select door option on Inbound Order Details page")
    public void clickSelectDoor() {
        LOG.info("Selecting Select door option");
        inboundOrderDetailsPage.clickDoorDropdown();
    }

    @Step
    @And("Selects DOOR option on Inbound Order Details page")
    public void selectDoor() {
        LOG.info("Selecting door " + DockDoorOption.DOOR.getDockDoorOption());
        inboundOrderDetailsPage.selectOption(DockDoorOption.DOOR.getDockDoorOption());
    }

    @Step
    @And("Selects DR01 option on Inbound Order Details page")
    public void selectDoor01() {
        LOG.info("Selecting door " + DockDoorOption.DOOR01.getDockDoorOption());
        inboundOrderDetailsPage.selectOption(DockDoorOption.DOOR01.getDockDoorOption());
    }

    @Step
    @And("Types {string} Ship Date on Inbound Order Details page")
    public void typeShipDate(String date) {
        LOG.info("Typing Ship Date " + date);
        inboundOrderDetailsPage.typeShipDate(date);
    }

    @Step
    @And("Types Ship Date by index {int} on Inbound Order Details page")
    public void typeShipDateByIndex(int index) {
        LOG.info("Typing Ship Date by index");
        List<String> dates = List.of(inboundOrderLoadsDTO.getEndDates().getEndDate1(), inboundOrderLoadsDTO
                .getEndDates().getEndDate2(), inboundOrderLoadsDTO.getEndDates().getEndDate3(), inboundOrderLoadsDTO
                .getEndDates().getEndDate4(), inboundOrderLoadsDTO.getEndDates().getEndDate5(), inboundOrderLoadsDTO
                .getEndDates().getEndDate6());
        inboundOrderDetailsPage.typeShipDate(dates.get(index));
    }

    @Step
    @And("Types {string} Load on Inbound Order Details page")
    public void typeLoad(String load) {
        LOG.info("Typing Load " + load);
        inboundOrderDetailsPage.typeLoad(load);
    }

    @Step
    @And("Types Load name by index {int} on Inbound Order Details page")
    public void typeLoadByIndex(int index) {
        LOG.info("Typing Load by index");
        List<String> loads = List.of(inboundOrderLoadsDTO.getLoadNames().getLoadName1(), inboundOrderLoadsDTO
                .getLoadNames().getLoadName2(), inboundOrderLoadsDTO.getLoadNames().getLoadName3(), inboundOrderLoadsDTO
                .getLoadNames().getLoadName4(), inboundOrderLoadsDTO.getLoadNames().getLoadName5(), inboundOrderLoadsDTO
                .getLoadNames().getLoadName6());
        inboundOrderDetailsPage.typeLoad(loads.get(index));
    }

    @Step
    @And("Clicks Add Filter button on Inbound Order Details page")
    public void clickAddFilter() {
        LOG.info("Clicking Add Filter");
        inboundOrderDetailsPage.clickAddFilter();
    }

    @Step
    @And("Select Order Product with index {int} on Inbound Order Details page")
    public void selectInboundOrderProductByNumber(int num) {
        LOG.info("Select Order Product by number " + num);
        inboundOrderDetailsPage.clickOrderProductByNumber(num);
    }

    @Step
    @And("Select Order Line Item with index {int} on Inbound Order Details page")
    public void selectInboundOrderLineItemByNumber(int num) throws InterruptedException {
        LOG.info("Select Order Line Item by number " + num);
        inboundOrderDetailsPage.clickOrderLineItemByNumber(num);
    }

    @Step
    @And("Clicks Order Line Data button on Inbound Order Details page")
    public void clickOrderLineDataBtn() {
        LOG.info("Click Order Line Data button");
        inboundOrderDetailsPage.clickProductDataBtn();
    }

    @Step
    @And("Clicks Order Line Edit button on Inbound Order Details page")
    public void clickOrderLineEditBtn() {
        LOG.info("Click Order Line Edit button");
        inboundOrderDetailsPage.clickProductEditBtn();
    }

    @Step
    @And("Clicks Order Line Image button on Inbound Order Details page")
    public void clickOrderLineImageBtn() {
        LOG.info("Click Order Line Image button");
        inboundOrderDetailsPage.clickOrderLineFieldsImageBtn();
    }
}
