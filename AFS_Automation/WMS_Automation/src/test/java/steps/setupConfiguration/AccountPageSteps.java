package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.*;

@Slf4j

public class AccountPageSteps {
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    AccountPage accountPage=new AccountPage();

    @And("Click on Search field on Account Page")
    public void clickAccountSearchField() throws InterruptedException {
        log.info("click on Search field");
        accountPage.accountTab();
        accountPage.accountSearchIcon();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
