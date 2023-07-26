package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.AssignmentTypePage;
import ui.pages.setupConfiguration.OrderTypePage;
import ui.pages.setupConfiguration.TrailerPage;

@Slf4j
public class TrailerPageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    OrderTypePage orderTypePage=new OrderTypePage();
    TrailerPage trailerPage=new TrailerPage();

    @And("Click on Search field on Trailer Page")
    public void clickTrailerSearchField() throws InterruptedException {
        log.info("click on Search field");
        trailerPage.trailerTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
