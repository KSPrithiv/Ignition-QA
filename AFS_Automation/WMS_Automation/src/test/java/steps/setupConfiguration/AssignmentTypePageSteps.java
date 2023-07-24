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
import ui.pages.setupLabor.CongestionPage;
import ui.pages.setupLabor.FatiguePage;
import ui.pages.setupLabor.SetupLaborCodePage;

import static common.setup.DriverManager.buildWebDriver;

@Slf4j

public class AssignmentTypePageSteps {
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    CongestionPage congestionPage=new CongestionPage(driver);
    FatiguePage fatiguePage=new FatiguePage();
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();

    @Step
    @And("Go to SetupIcon and Configuration")
    public void setupIconAndConfiguration() throws InterruptedException {
        log.info("Go to SetupIcon and Configuration");
        setupLaborCodePage.clickSetupIcon();
        assignmentTypePage.clickSetupConfiguration();
    }
    @And("Click on Search field on Assignment Type Page")
    public void clickAssignmentTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        assignmentTypePage.assignmentTypeTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
    @Step
    @And("Verify Search functionalities1")
    public void verifyAssignmentTypeSearchFunctionality() throws InterruptedException {
        log.info("Verify Search Functionality");
        assignmentTypePage.rownumber1();
    }
    @Step
    @And("Verify remove icon1")
    public void closeIcononAssignmentType() throws InterruptedException {
        log.info("Verify remove Icon");
        setupLaborCodePage.closeIcon();
    }
    @Step
    @And("Verify Search functionality with non existing search keyword1")
    public void nonExistingKeywordonAssignmentType() throws InterruptedException {
        log.info("Verify Search functionality with non existing search keyword");
        setupLaborCodePage.verifyTablerows();
        assignmentTypePage.searchBoxAction6();
    }
}
