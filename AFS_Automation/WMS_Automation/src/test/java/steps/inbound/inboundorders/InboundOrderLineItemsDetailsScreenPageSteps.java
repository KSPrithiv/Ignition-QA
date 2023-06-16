package steps.inbound.inboundorders;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.inbound.inboundorders.InboundOrderLineItemsDetailsScreenPage;

@Slf4j
public class InboundOrderLineItemsDetailsScreenPageSteps {
    InboundOrderLineItemsDetailsScreenPage inboundOrderLineItemsDetailsScreenPage = new InboundOrderLineItemsDetailsScreenPage();

    @Step
    @And("Clicks Order Location Link on Inbound Order Line Items Details Screen page")
    public void clickOrderLocationLink() {
        log.info("Click Order Location Link");
        inboundOrderLineItemsDetailsScreenPage.clickOrderLocationLink();
    }

    @Step
    @And("Clicks Route Back button on Inbound Order Line Items Details Screen page")
    public void clickRouteBackButton() {
        log.info("Clicking Route Back");
        inboundOrderLineItemsDetailsScreenPage.clickRouteBackButton();
    }

    @Step
    @And("Clicks Order Line Data button on Inbound Order Line Items Details Screen page")
    public void clickOrderLineDataBtn() {
        log.info("Click Order Line Data button");
        inboundOrderLineItemsDetailsScreenPage.clickProductDataBtn();
    }

    @Step
    @And("Clicks Order Line Edit button on Inbound Order Line Items Details Screen page")
    public void clickOrderLineEditBtn() {
        log.info("Click Order Line Edit button");
        inboundOrderLineItemsDetailsScreenPage.clickProductEditBtn();
    }

    @Step
    @And("Clicks Order Line Image button on Inbound Order Line Items Details Screen page")
    public void clickOrderLineImageBtn() {
        log.info("Click Order Line Image button");
        inboundOrderLineItemsDetailsScreenPage.clickOrderLineFieldsImageBtn();
    }

    @Step
    @And("Clicks Cancel on Edit order line popup on Inbound Order Line Items Details Screen page")
    public void clickCancel() {
        log.info("Click Cancel on Edit order line popup");
        inboundOrderLineItemsDetailsScreenPage.clickCancel();
    }

}
