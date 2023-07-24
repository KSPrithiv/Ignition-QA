package steps.setupConfiguration;
import common.constants.FilePaths;
import common.setup.DriverManager;
import common.setup.Environment;
import common.utils.Waiters;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.AssignmentTypePage;
import ui.pages.setupConfiguration.RouteTypePage;
import ui.pages.setupLabor.CongestionPage;
import ui.pages.setupLabor.FatiguePage;
import ui.pages.setupLabor.SetupLaborCodePage;

import static common.setup.DriverManager.buildWebDriver;
@Slf4j
public class RouteTpePageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    RouteTypePage routeTypePage=new RouteTypePage();

    @And("Click on Search field on Route Type Page")
    public void clickRouteTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        routeTypePage.routeTypeTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
