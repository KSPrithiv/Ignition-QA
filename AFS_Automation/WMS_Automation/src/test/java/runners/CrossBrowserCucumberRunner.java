package runners;

import common.constants.FilePaths;
import common.setup.Environment;
import common.utils.Waiters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import static common.setup.DriverManager.*;
import static common.setup.DriverManager.getDriver;

@CucumberOptions(features = { "WMSAutomation/src/test/resources/features" },
        glue = {"steps"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/failedrerun.txt"
        }, monochrome = true)
@Slf4j
public class CrossBrowserCucumberRunner extends AbstractTestNGCucumberTests {
   private TestNGCucumberRunner testNGCucumberRunner;
   Waiters waiters;
   public static Environment environment;

   @Parameters({"environment","browser"})
   @BeforeMethod
   public void startBrowserInstance(@Optional String env, @Optional String browser) {
      ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
      environment = ConfigFactory.create(Environment.class);
      log.info("Starting app url " + environment.getUrl() + " on browser " +  browser);
      buildWebDriver(browser);
      openPage(environment.getUrl());
      waiters = new Waiters();
   }

    @SneakyThrows
    @AfterMethod
    public void closeBrowserInstance(ITestResult iTestResult){
        if (driverEnabled(getDriver())) {
            try{
                driverThreadLocal.get().close();
                driverThreadLocal.get().quit();
            } catch(Exception e) {
                //   FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
                System.out.println("Error closing and quitting the web driver: " + e.getMessage());
                if(getDriver() instanceof ChromeDriver){
                    try {
                        //  FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
                        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                    } catch (IOException ex) {
                        System.out.println("Error force quitting the ChromeDriver process: " + ex.getMessage());
                    }
                }
            }
        }
    }

}
