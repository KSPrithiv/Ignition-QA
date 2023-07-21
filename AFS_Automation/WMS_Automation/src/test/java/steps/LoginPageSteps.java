package steps;

import com.nordstrom.automation.testng.LinkedListeners;
import common.constants.FilePaths;
import common.setup.DriverManager;
import common.setup.Environment;
import common.utils.Waiters;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import listeners.TestListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import objects.userdata.UserData;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.LoginPage;

import static common.setup.DriverManager.*;

@LinkedListeners({
        TestListener.class
})
@Slf4j
public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    public Waiters waiters;
    public static Environment environment;

    @Before
    public void beforeClassSetup() {
       ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
       environment = ConfigFactory.create(Environment.class);
       log.info("Starting app url " + environment.getUrl() + " on browser " + environment.getBrowser());
       buildWebDriver(environment.getBrowser());
       DriverManager.openPage(environment.getUrl());
       new Waiters();
    }

    @Step
    @Given("User signs in the application")
    public void loginToApplication() {
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
        Waiters.waitABit(3000);
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

    @SneakyThrows
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
    }
}