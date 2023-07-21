package steps.setupConfiguration;

import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.AssignmentTypePage;
import ui.pages.setupConfiguration.OrderTypePage;
import ui.pages.setupConfiguration.RouteTypePage;

@Slf4j

public class OrderTypePageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    OrderTypePage orderTypePage=new OrderTypePage();

    @And("Click on Search field on Order Type Page")
    public void clickOrderTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        orderTypePage.orderTypeTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}

