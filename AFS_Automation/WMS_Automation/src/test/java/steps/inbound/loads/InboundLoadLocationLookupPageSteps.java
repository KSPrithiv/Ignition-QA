package steps.inbound.loads;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.inbound.loads.InboundLoadLocationLookupPage;

@Slf4j
public class InboundLoadLocationLookupPageSteps {
    InboundLoadLocationLookupPage inboundLoadLocationLookupPage = new InboundLoadLocationLookupPage();

    @Step
    @And("Waits For Inbound Load Location Lookup page to load")
    public void waitForInboundLoadOrderDetailsPageToLoad() {
        log.info("Waiting for Inbound Load Location Lookup Page To Load ");
        inboundLoadLocationLookupPage.waitForInboundLoadLocationLookupPageToLoad();
    }
}
