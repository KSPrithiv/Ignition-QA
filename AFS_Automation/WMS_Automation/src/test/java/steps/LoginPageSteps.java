package steps;

import com.nordstrom.automation.testng.LinkedListeners;
import common.constants.FilePaths;
import common.setup.DriverManager;
import common.setup.Environment;
import common.utils.Waiters;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import listeners.TestListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import objects.outbound.OutboundOrderLoadsDTO;
import objects.userdata.UserData;
import org.aeonbits.owner.ConfigFactory;

import org.openqa.selenium.*;

import static common.setup.DriverManager.*;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;


import static common.setup.DriverManager.getDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.BasePage;
import ui.pages.LoginPage;
import ui.pages.outbound.loadplanning.OutboundLoadPlanningPage;

import static common.setup.DriverManager.*;

@LinkedListeners({
        TestListener.class
})
@Slf4j
public class LoginPageSteps {
    Scenario scenario;
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    public Waiters waiters;
    public static Environment environment;
    public WebDriver driver;

    static boolean flag=false;
    static String currentURL=null;
    OutboundLoadPlanningPage outboundLoadPlanningPage = new OutboundLoadPlanningPage();

    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

//   @Before
//    public void beforeClassSetup() {
//        ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
//        environment = ConfigFactory.create(Environment.class);
//        log.info("Starting app url " + environment.getUrl() + " on browser " + environment.getBrowser());
//        buildWebDriver(environment.getBrowser());
//        DriverManager.openPage(environment.getUrl());
//        new Waiters();
//    }

    @Before
    public void LaunchBrowser(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        //TestBase driver1 = TestBase.getInstanceOfDriver();
        //driver = driver1.getDriver();
        //driver = TestBase.getDriver();
        driver = DriverManager.getDriver();
    }

    @After
    public void afterScenario1(Scenario scenario) {
        if (scenario.isFailed())
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src,"image/png", scenario.getName());
        }
    }

    @Step
    @Given("User signs in the application")
    public void loginToApplication() {
        if(flag==false) {
            ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
            environment = ConfigFactory.create(Environment.class);
            log.info("Login to application");
            UserData userData = UserData.builder()
                    .username(environment.getUserName())
                    .password(environment.getPassword())
                    .build();
            loginPage.waitForLoginPageToLoad();
            loginPage.fillInLoginField(userData.getUsername());
            loginPage.fillInPasswordField(userData.getPassword());
            loginPage.clickSignIn();
            //Waiters.waitTillLoadingPage(getDriver());
        }
    }

    //JIRA purpose
    @Step
    @Given("User signs in the application JIRA")
    public void loginToApplicationJIRA() {
        if(flag==false) {
            ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
            environment = ConfigFactory.create(Environment.class);
            log.info("Login to application");
            UserData userData = UserData.builder()
                    .username(environment.getUserName())
                    .password(environment.getPassword())
                    .build();
            //loginPage.waitForLoginPageToLoad();
            loginPage.fillInLoginFieldJIRA(userData.getUsername());
            loginPage.fillInPasswordFieldJIRA(userData.getPassword());
            loginPage.clickSignInJIRA();
            //Waiters.waitTillLoadingPage(getDriver());
        }
    }




    @Step
    @And("Admin user signs in the application")
    public void adminLoginToApplication() {
        ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
        environment = ConfigFactory.create(Environment.class);
        log.info("Login to application");
        UserData userData = UserData.builder()
                .adminUsername(environment.getAdminUsername())
                .adminPassword(environment.getAdminPassword())
                .build();
        loginPage.waitForLoginPageToLoad();
        loginPage.fillInLoginField(userData.getAdminUsername());
        loginPage.fillInPasswordField(userData.getAdminPassword());
        loginPage.clickSignIn();
        Waiters.waitABit(30_000);
    }

    @Step
    @And("Deletes cookies on application")
    public void deleteCookies() {
        basePage.deleteCookies();
    }

    @Step
    @And("Waits until Login page is visible")
    public void loginIsVisible() {
        loginPage.waitForLoginPageToLoad();
    }

    @Step
    @Given("User signs in the application with wrong credentials")
    public void loginToApplicationWithWrongCredentials() {
        log.info("Login to application with wrong credentials");
        UserData userData = UserData.builder()
                .username("cds")
                .password("marek123")
                .build();
        loginPage.waitForLoginPageToLoad();
        loginPage.fillInLoginField(userData.getUsername());
        loginPage.fillInPasswordField(userData.getPassword());
        loginPage.clickSignIn();

    }

/*    @SneakyThrows
    @After
    public void closeBrowserInstance(Scenario scenario) {
       if (driverEnabled(getDriver())) {
           try {
               driverThreadLocal.get().close();
               driverThreadLocal.get().quit();
               quitDriver();
           } catch (Exception e) {
                if(getDriver() instanceof ChromeDriver) {
                //   Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                }
            }
       }
    }*/


    @Step
    @Given("user navigates to issues that results waterfall options")
    public void navigateToIssuesOptionJIRA() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(loginPage.getissuesTab());
        basePage.clickOnElement(loginPage.getissuesTab());
    }

    @Step
    @Then("user clicks on import issues from CSV option")
    public void user_clicks_on_import_issues_from_csv_option_JIRA() {
        Waiters.waitForElementToBeDisplay(loginPage.getimportIssuesOption());
        basePage.clickOnElement(loginPage.getimportIssuesOption());
    }

    @Then("user chooses file to upload the JIRA ticket in CSV format")
    public void user_chooses_file_to_upload_the_jira_ticket_in_csv_format() throws InterruptedException {
        loginPage.importJIRATicket();
    }

    @Then("user goes to next wizard by clicking next button")
    public void user_goes_to_next_wizard_by_clicking_next_button() throws InterruptedException {

        Waiters.waitForElementToBeDisplay(loginPage.getNextButton());
        Thread.sleep(3000);
        basePage.clickOnElement(loginPage.getNextButton());
    }

    @Then("user selects the project to which the ticket will be exported and mapped")
    public void user_selects_the_project_to_which_the_ticket_will_be_exported_and_mapped() {
        loginPage.clickProjectName();
    }

    @Then("Selects ProjectName for HexyGen Migration")
    public void selects_project_name_for_hexy_gen_migration() throws InterruptedException {
//        log.info("Selects ProjectName for HexyGen Migration by index");
//        List<String> routes = List.of(outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute10());
//        loginPage.selectProject(routes.get(index));
        //loginPage.selectProjectDropDown(projectIndex);
        //loginPage.selectProjectDropDown();
        loginPage.selectProjectDropDownJIRA();
    }

}

