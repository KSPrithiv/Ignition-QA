package steps.setupLabor;
import common.constants.FilePaths;
import common.setup.DriverManager;
import common.setup.Environment;
import common.utils.Waiters;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import ui.pages.setupLabor.CongestionPage;
import ui.pages.setupLabor.JobTypePage;
import ui.pages.setupLabor.SetupLaborCodePage;
//import util.TestBase;

import static common.setup.DriverManager.buildWebDriver;

@Slf4j
public class CongestionPageSteps {
    WebDriver driver;
    public static Environment environment;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    JobTypePage jobTypePage=new JobTypePage(driver);
    CongestionPage congestionPage=new CongestionPage(driver);


    @Step
    @And("Click on Search field on Congestion Page")
    public void clickSearchField() throws InterruptedException {
        log.info("click on Search field");
        congestionPage.congestionTab();
        congestionPage.searchBoxActionCongestion();
    }
    @Step
    @And("Verify Search functionalities on Congestion Page")
    public void verifySearchFunctionality() throws InterruptedException {
        log.info("Verify Search Functionality");
        congestionPage.rownumber1();
    }
    @Step
    @And("Verify remove icon on Congestion Page")
    public void closeIcononCongestion() throws InterruptedException {
        log.info("Verify remove Icon");
        setupLaborCodePage.closeIcon();
    }
    @Step
    @And("Verify Search functionality with non existing search keyword on Congestion Page")
    public void nonExistingKeywordOnCongestion() throws InterruptedException {
        log.info("Verify Search functionality with non existing search keyword");
        setupLaborCodePage.verifyTablerows();
        congestionPage.searchBoxAction4();
    }
}
