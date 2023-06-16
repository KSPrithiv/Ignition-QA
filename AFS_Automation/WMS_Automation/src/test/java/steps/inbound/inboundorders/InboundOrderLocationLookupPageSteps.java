package steps.inbound.inboundorders;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.inbound.inboundorders.InboundOrderLocationLookupPage;

@Slf4j
public class InboundOrderLocationLookupPageSteps {
    InboundOrderLocationLookupPage inboundOrderLocationLookupPage = new InboundOrderLocationLookupPage();

    @Step
    @And("Waits For Inbound Order Location Lookup page to load")
    public void waitForInboundOrderDetailsPageToLoad() {
        log.info("Waiting for Inbound Order Location Lookup Page To Load");
        inboundOrderLocationLookupPage.waitForInboundOrderLocationLookupPageToLoad();
    }
}
