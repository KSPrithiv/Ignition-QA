package steps.setupLabor;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.webdav.WebDavResponse;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ui.pages.setupLabor.*;

@Slf4j
public class ExitReasonPageSteps {
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    CongestionPage congestionPage = new CongestionPage(driver);
    FatiguePage fatiguePage = new FatiguePage();
    ShiftPage shiftPage = new ShiftPage();
    ExitReasonPage exitReasonPage=new ExitReasonPage();

    @Step
    @And("Click on Search field on ExitReason Page")
    public void clickExitSearchField() throws InterruptedException {
        log.info("Click on Search field on ExitReason Page");
        exitReasonPage.exitTab();
        exitReasonPage.searchBoxActionExit();
    }

    @Step
    @And("Verify Search functionalities on ExitReason Page")
    public void verifyExitSearchFunctionality() throws InterruptedException {
        log.info("Verify Search Functionality");
        exitReasonPage.rownumberExit1();
    }
    @Step
    @And("Verify remove icon on ExitReason Page")
    public void removeIconExit() throws InterruptedException {
        log.info("Verify remove Icon");
        setupLaborCodePage.closeIcon();
    }
    @Step
    @And("Verify Search functionality with non existing search keyword on ExitReason Page")
    public void nonExistingKeywordOnExit() throws InterruptedException {
        log.info("Verify Search functionality with non existing search keyword");
        setupLaborCodePage.verifyTablerows();
        exitReasonPage.searchBoxAction7();
    }
}