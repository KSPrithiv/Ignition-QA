package steps.inbound.loads;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.inbound.loads.InboundLoadOrderLineItemsPage;

@Slf4j
public class InboundLoadOrderLineItemsPageSteps {
    InboundLoadOrderLineItemsPage inboundLoadOrderLineItemsPage = new InboundLoadOrderLineItemsPage();

    @Step
    @And("Inbound Load Order Line Items Page appears")
    public void waitForInboundLoadSummaryToLoad() {
        log.info("Waiting for Inbound Load Order Line Items Page To Load");
        inboundLoadOrderLineItemsPage.waitForInboundLoadOrderLineItemsPageToLoad();
    }

    @Step
    @And("Clicks Order Line Data button on Inbound Load Order Line Items page")
    public void clickOrderLineDataBtn() {
        log.info("Click Order Line Data button");
        inboundLoadOrderLineItemsPage.clickProductDataBtn();
    }

    @Step
    @And("Clicks Order Line Edit button on Inbound Load Order Line Items page")
    public void clickOrderLineEditBtn() {
        log.info("Click Order Line Edit button");
        inboundLoadOrderLineItemsPage.clickProductEditBtn();
    }

    @Step
    @And("Clicks Order Line Image button on Inbound Load Order Line Items page")
    public void clickOrderLineImageBtn() {
        log.info("Click Order Line Image button");
        inboundLoadOrderLineItemsPage.clickOrderLineFieldsImageBtn();
    }

    @Step
    @And("Clicks Order Location Link on Inbound Load Order Line Items page")
    public void clickOrderLocationLink() {
        log.info("Click Order Location Link");
        inboundLoadOrderLineItemsPage.clickOrderLocationLink();
    }

    @Step
    @And("Clicks Cancel on Edit order line popup on Inbound Load Order Line Items page")
    public void clickCancel() {
        log.info("Click Cancel on Edit order line popup");
        inboundLoadOrderLineItemsPage.clickCancel();
    }

}
