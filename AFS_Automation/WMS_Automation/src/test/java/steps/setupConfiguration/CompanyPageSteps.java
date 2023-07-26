package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.*;

@Slf4j
public class CompanyPageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    ComapnyPage comapnyPage=new ComapnyPage();

    @And("Click on Search field on Company Page")
    public void clickCompanySearchField() throws InterruptedException {
        log.info("click on Search field");
        comapnyPage.companyTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
