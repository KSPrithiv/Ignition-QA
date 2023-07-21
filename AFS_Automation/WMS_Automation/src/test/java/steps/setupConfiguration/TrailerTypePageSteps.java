package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.AssignmentTypePage;
import ui.pages.setupConfiguration.OrderTypePage;
import ui.pages.setupConfiguration.TrailerPage;
import ui.pages.setupConfiguration.TrailerTypePage;

@Slf4j
public class TrailerTypePageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    OrderTypePage orderTypePage=new OrderTypePage();
    TrailerTypePage trailerTypePage=new TrailerTypePage();

    @And("Click on Search field on Trailer Type Page")
    public void clickTrailerTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        trailerTypePage.trailerTypeTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
