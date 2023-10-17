package steps.outbound.loadplanning;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.outbound.OutboundOrderLoadsDTO;
import ui.pages.outbound.loadplanning.OutboundLoadPlanningPage;

import java.util.List;

@Slf4j
public class OutboundLoadPlanningPageSteps {
    OutboundLoadPlanningPage outboundLoadPlanningPage = new OutboundLoadPlanningPage();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

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
    @Then("Selects Ship Date by index {int} on Load Planning popup")
    public void selectsShipDateByIndex(int index) {
        log.info("Selects Ship Date on Load Planning popup");
        List<String> dates = List.of(outboundOrderLoadsDTO.getStartDates().getStartDate1(), outboundOrderLoadsDTO
                .getStartDates().getStartDate2(), outboundOrderLoadsDTO.getStartDates().getStartDate3(),
                outboundOrderLoadsDTO.getStartDates().getStartDate4(), outboundOrderLoadsDTO.getStartDates().getStartDate5(),
                outboundOrderLoadsDTO.getStartDates().getStartDate6(), outboundOrderLoadsDTO.getStartDates().getStartDate7());
        outboundLoadPlanningPage.typeShipDate(dates.get(index));
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
    @Then("Selects Route by index {int} for Load Planning")
    public void selectsRouteForLoadPlanningByIndex(int index) {
        log.info("Selects Route for Load Planning by index");
        List<String> routes = List.of(outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute1(), outboundOrderLoadsDTO
                .getOutboundRoutes().getOutboundRoute2(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute3(),
                 outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute4(), outboundOrderLoadsDTO.getOutboundRoutes()
                .getOutboundRoute5(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute6(), outboundOrderLoadsDTO
                .getOutboundRoutes().getOutboundRoute7());
        outboundLoadPlanningPage.selectRoute(routes.get(index));
    }

    @Step
    @Then("Clicks Done button on Load Planning page")
    public void clickDoneButton() {
        log.info("Clicks Done on Load Planning");
        outboundLoadPlanningPage.clickDoneButton();
    }

}
