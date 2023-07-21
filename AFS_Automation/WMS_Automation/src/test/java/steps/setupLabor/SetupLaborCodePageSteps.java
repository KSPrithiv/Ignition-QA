package steps.setupLabor;
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
import ui.pages.setupLabor.SetupLaborCodePage;

import static common.setup.DriverManager.buildWebDriver;

@Slf4j

public class SetupLaborCodePageSteps {
    public static Environment environment;
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);

//    @Before
//    public void beforeClassSetup() {
//        ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
//        environment = ConfigFactory.create(Environment.class);
//        log.info("Starting app url " + environment.getUrl() + " on browser " + environment.getBrowser());
//        buildWebDriver(environment.getBrowser());
//        DriverManager.openPage(environment.getUrl());
//        new Waiters();
//    }

    @Step
    @And("Go to SetupIcon and Labor")
    public void GotoSetupIcon() {
        log.info("Go to SetupIcon and Labor");
        setupLaborCodePage.clickSetupIcon();
        setupLaborCodePage.clickSetupProductIcon();
    }

    @Step
    @And("Verify Search functionality")
    public void SearchFunctionality() throws InterruptedException {
        log.info("Verify Search functionality");
        setupLaborCodePage.searchBoxAction();
        setupLaborCodePage.rownumber1();
    }
    @Step
    @And("Verify remove icon")
    public void RemoveIcon() throws InterruptedException {
        log.info("Verify remove icon");
        setupLaborCodePage.closeIcon();
    }
    @Step
    @And("Verify Search functionality with non existing search keyword")
    public void NonexistingKeywordSearchFunctionality() throws InterruptedException {
        log.info("Verify Search functionality with non existing search keyword");
        setupLaborCodePage.verifyTablerows();
        setupLaborCodePage.searchBoxAction2();
    }

}