package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.*;

@Slf4j

public class AllocationBatchPageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    AllocationBatchPage allocationBatchPage=new AllocationBatchPage();

    @And("Click on Search field on Allocation Batch Page")
    public void clickAllocationBatchSearchField() throws InterruptedException {
        log.info("click on Search field");
        allocationBatchPage.allocationBatchTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
