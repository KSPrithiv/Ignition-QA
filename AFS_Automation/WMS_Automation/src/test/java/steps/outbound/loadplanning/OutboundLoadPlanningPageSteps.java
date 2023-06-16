package steps.outbound.loadplanning;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.outbound.loadplanning.OutboundLoadPlanningPage;

@Slf4j
public class OutboundLoadPlanningPageSteps {
    OutboundLoadPlanningPage outboundLoadPlanningPage = new OutboundLoadPlanningPage();

    @Step
    @And("Waits for Outbound Load Planning page to load")
    public void waitForOutboundLoadPlanningPageToLoad() {
        log.info("Waiting for Outbound Load Planning Page To Load");
        outboundLoadPlanningPage.waitOutboundLoadPlanningPageToLoad();
    }

    @Step
    @And("Clicks Route dropdown on Load Planning popup")
    public void clickRouteDropdown() {
        log.info("Clicks Route dropdown on Load Planning popup");
        outboundLoadPlanningPage.clickRouteTypeDropDown();
    }

    @Step
    @Then("Selects {string} Ship Date on Load Planning popup")
    public void selectsShipDate(String date) {
        log.info("Selects Ship Date on Load Planning popup");
        outboundLoadPlanningPage.typeShipDate(date);
    }

    @Step
    @And("User selects warehouse {string} on Load Planning page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse {string} on Load Planning page");
        outboundLoadPlanningPage.selectWarehouse(warehouse);
    }

    @Step
    @Then("Selects {string} Route for Load Planning")
    public void selectsRouteForLoadPlanning(String route) {
        log.info("Selects Route for Load Planning " + route);
        outboundLoadPlanningPage.selectRoute(route);
    }

    @Step
    @Then("Clicks Done button on Load Planning page")
    public void clickDoneButton() {
        log.info("Clicks Done on Load Planning");
        outboundLoadPlanningPage.clickDoneButton();
    }

}
