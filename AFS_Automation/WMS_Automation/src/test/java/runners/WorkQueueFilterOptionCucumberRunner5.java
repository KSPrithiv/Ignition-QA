package runners;

import common.constants.FilePaths;
import common.setup.DriverManager;
import common.setup.Environment;
import common.utils.Waiters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.mail.MessagingException;
import java.io.IOException;

import static common.setup.DriverManager.*;

@CucumberOptions(features = {"src/test/resources/features/workqueue/assignmentlist/filteroption/WorkQueueFilterOptionScreen5.feature"},
        glue = {"steps"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-reports/cucumber.html",
                "html:Reports/Index.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/failedrerun.txt"
        }, monochrome = true, tags = "@isofailed2")
@Slf4j
public class WorkQueueFilterOptionCucumberRunner5 extends AbstractTestNGCucumberTests {
    public static Environment environment;

    @Parameters({"environment", "browser"})
    @BeforeMethod
    public void startBrowserInstance(@Optional String env, @Optional String browser) {
        ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
        environment = ConfigFactory.create(Environment.class);
        log.info("Starting app url " + environment.getUrl() + " on browser " + environment.getBrowser());
        buildWebDriver(environment.getBrowser());
        DriverManager.openPage(environment.getUrl());
        new Waiters();
    }

    @SneakyThrows
    @AfterMethod
    public void closeBrowserInstance(ITestResult iTestResult) {

      //  MailSend_WMS.sendMail();
        if (driverEnabled(getDriver())) {
            try {

                driverThreadLocal.get().close();
                driverThreadLocal.get().quit();
            } catch (Exception e) {
                   if (getDriver() instanceof ChromeDriver) {
                    try {
                        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                    } catch (IOException ex) {
                        System.out.println("Error force quitting the ChromeDriver process: " + ex.getMessage());
                    }

                }
            }
        }
    }

    @SneakyThrows
    @AfterClass
    public static void afterClass() throws InterruptedException, MessagingException, IOException {
        //Directory_Change.uniqueReport();
    //    MailSend_WMS.sendMail();
    }
}