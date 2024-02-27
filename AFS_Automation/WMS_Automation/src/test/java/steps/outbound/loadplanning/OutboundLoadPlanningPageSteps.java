package steps.outbound.loadplanning;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.outbound.OutboundOrderLoadsDTO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import ui.pages.outbound.loadplanning.OutboundLoadPlanningPage;
import  common.setup.DriverManager;
import java.util.List;
import org.openqa.selenium.Alert;

@Slf4j
public class OutboundLoadPlanningPageSteps {

    static boolean flag=false;
    static String currentURL=null;
    WebDriver driver;
    Scenario scenario;
    OutboundLoadPlanningPage outboundLoadPlanningPage = new OutboundLoadPlanningPage();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {

        this.scenario=scenario;
        driver= DriverManager.getDriver();
    }

    @Step
    @And("Waits for Outbound Load Planning page to load")
    public void waitForOutboundLoadPlanningPageToLoad() {
        log.info("Waiting for Outbound Load Planning Page To Load");
        outboundLoadPlanningPage.waitOutboundLoadPlanningPageToLoad();
    }

    @Step
    @And("Clicks Route dropdown on Load Planning popup")
    public void clickRouteDropdown() {
        if(flag==false) {
            log.info("Clicks Route dropdown on Load Planning popup");
            outboundLoadPlanningPage.clickRouteTypeDropDown();
        }
    }

    @Step
    @Then("Selects {string} Ship Date on Load Planning popup")
    public void selectsShipDate(String date) {
        log.info("Selects Ship Date on Load Planning popup");
        outboundLoadPlanningPage.typeShipDate(date);
    }

    @Step
    @Then("Selects Ship Date by index {int} on Load Planning popup")
    public void selectsShipDateByIndex(int index) throws InterruptedException {
        if(flag==false) {
            //outboundLoadPlanningPage.clickLoadPlanningWarningMessage();//error popup handled
            log.info("Selects Ship Date on Load Planning popup");
            List<String> dates = List.of(outboundOrderLoadsDTO.getStartDates().getStartDate1(), outboundOrderLoadsDTO
                            .getStartDates().getStartDate2(), outboundOrderLoadsDTO.getStartDates().getStartDate3(),
                    outboundOrderLoadsDTO.getStartDates().getStartDate4(), outboundOrderLoadsDTO.getStartDates().getStartDate5(),
                    outboundOrderLoadsDTO.getStartDates().getStartDate6(), outboundOrderLoadsDTO.getStartDates().getStartDate7());
            outboundLoadPlanningPage.typeShipDate(dates.get(index));
            //outboundLoadPlanningPage.clickLoadPlanningWarningMessage();//error popup
        }
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
        if(flag==false) {
            log.info("Selects Route for Load Planning by index");
            List<String> routes = List.of(outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute1(), outboundOrderLoadsDTO
                            .getOutboundRoutes().getOutboundRoute2(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute3(),
                    outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute4(), outboundOrderLoadsDTO.getOutboundRoutes()
                            .getOutboundRoute5(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute6(), outboundOrderLoadsDTO
                            .getOutboundRoutes().getOutboundRoute7());
            outboundLoadPlanningPage.selectRoute(routes.get(index));
        }
    }

    @Step
    @Then("Clicks Done button on Load Planning page")
    public void clickDoneButton() {
        if(flag==false) {
            log.info("Clicks Done on Load Planning");
            outboundLoadPlanningPage.clickDoneButton();
        }
    }


}
