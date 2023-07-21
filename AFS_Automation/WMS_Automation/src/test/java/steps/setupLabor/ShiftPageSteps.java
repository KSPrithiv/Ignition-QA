package steps.setupLabor;
import common.utils.Waiters;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.webdav.WebDavResponse;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ui.pages.setupLabor.*;

@Slf4j
public class ShiftPageSteps {
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    CongestionPage congestionPage=new CongestionPage(driver);
    FatiguePage fatiguePage=new FatiguePage();
    ShiftPage shiftPage=new ShiftPage();

    @Step
    @And("Click on Search field on Shift Page")
    public void clickShiftSearchField() throws InterruptedException {
        log.info("click on Search field");
        shiftPage.shiftTab();
        shiftPage.searchBoxActionShift();
    }
    @Step
    @And("Verify Search functionalities on Shift Page")
    public void verifyShiftSearchFunctionality() throws InterruptedException {
        log.info("Verify Search Functionality");
        shiftPage.rownumberShift1();
        setupLaborCodePage.closeIcon();
        setupLaborCodePage.verifyTablerows();
        shiftPage.searchBoxAction6();
    }
}


