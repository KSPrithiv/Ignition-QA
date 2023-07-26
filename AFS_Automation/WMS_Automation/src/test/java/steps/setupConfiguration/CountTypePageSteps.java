package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.*;

@Slf4j
public class CountTypePageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    CountTypePage countTypePage=new CountTypePage();

    @And("Click on Search field on Count Type Page")
    public void clickCountTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        countTypePage.countTypeTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
