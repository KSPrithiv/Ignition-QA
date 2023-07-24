package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.*;

@Slf4j

public class PalletTypePageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    PalletTypePage palletTypePage=new PalletTypePage();

    @And("Click on Search field on Pallet Type Page")
    public void clickPalletTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        palletTypePage.palletTypeTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
