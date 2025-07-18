package steps.outbound.loadplanning;

import common.setup.DriverManager;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.outbound.loadplanning.OutboundAssignmentsPage;

@Slf4j
public class OutboundAssignmentsPageSteps {
    OutboundAssignmentsPage outboundAssignmentsPage = new OutboundAssignmentsPage();

    @Step
    @And("Waits for Outbound Assignments page to load")
    public void waitForOutboundAssignmentsPageToLoad() {
        log.info("Waiting for  Outbound Assignments Page To Load");
        outboundAssignmentsPage.waitOutboundOrderSummaryPageToLoad();
    }

    @Step
    @And("Clicks Back button on Assignments page")
    public void clickBackButton() {
        log.info("Waiting for  Outbound Assignments Page To Load");
        outboundAssignmentsPage.clickBackButton();
    }

    @Step
    @And("Checks Assignment with index {int}")
    public void checkAssignment(int index) {
        log.info("Checks Assignment " + index);
        outboundAssignmentsPage.checkAssignment(index);
    }

}
