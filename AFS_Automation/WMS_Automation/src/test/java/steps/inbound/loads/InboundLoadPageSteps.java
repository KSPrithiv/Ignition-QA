package steps.inbound.loads;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.inbound.loads.InboundLoadPage;

@Slf4j
public class InboundLoadPageSteps {
    InboundLoadPage inboundLoadPage = new InboundLoadPage();

    @Step
    @And("Waits For Inbound Load page To Load")
    public void waitForInboundLoadPageToLoad() {
        log.info("Waiting for Inbound Load Page To Load ");
        inboundLoadPage.waitForInboundLoadPageToLoad();
    }

    @Step
    @Then("User selects first order")
    public void selectOrderByLineNumber() {
        log.info("Selecting first order");
        inboundLoadPage.clickOnOrderByLineNumber(0);
    }

}
