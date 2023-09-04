package steps.setupLabor;

import common.utils.Waiters;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.webdav.WebDavResponse;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ui.pages.setupLabor.CongestionPage;
import ui.pages.setupLabor.FatiguePage;
import ui.pages.setupLabor.JobTypePage;
import ui.pages.setupLabor.SetupLaborCodePage;

@Slf4j
public class FatiguePageSteps {
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    CongestionPage congestionPage=new CongestionPage(driver);
    FatiguePage fatiguePage=new FatiguePage();

    @Step
    @And("Click on Search field on Fatigue Page")
    public void clickFatigueSearchField() throws InterruptedException {
        log.info("click on Search field");
        fatiguePage.fatigueTab();
        fatiguePage.searchBoxActionFatigue();
    }
    @Step
    @And("Verify Search functionalities on Fatigue Page")
    public void verifyFatigueSearchFunctionality() throws InterruptedException {
        log.info("Verify Search Functionality");
        congestionPage.rownumber1();
    }
    @Step
    @And("Verify remove icon on Fatigue Page")
    public void closeIcononFatigue() throws InterruptedException {
        log.info("Verify remove Icon");
        setupLaborCodePage.closeIcon();
    }
    @Step
    @And("Verify Search functionality with non existing search keyword on Fatigue Page")
    public void nonExistingKeywordonFatigue() throws InterruptedException {
        log.info("Verify Search functionality with non existing search keyword");
        setupLaborCodePage.verifyTablerows();
        fatiguePage.searchBoxAction5();
    }
}
