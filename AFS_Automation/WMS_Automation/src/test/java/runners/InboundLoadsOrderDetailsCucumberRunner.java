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
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.mail.MessagingException;
import java.io.IOException;

import static common.setup.DriverManager.*;

@CucumberOptions(features = {"src/test/resources/features/inbound/loads/orderdetails"},
        glue = {"steps"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:Reports/Index.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/failedrerun.txt"
        }, monochrome = true, tags = "@Inbound")
@Slf4j
public class InboundLoadsOrderDetailsCucumberRunner extends AbstractTestNGCucumberTests {
    public static Environment environment;

    @Parameters({"environment","browser"})
    @BeforeMethod
    public void startBrowserInstance(@Optional String env, @Optional String browser) {
        ConfigFactory.setProperty("path", FilePaths.PROPERTIES_PATH);
        environment = ConfigFactory.create(Environment.class);
        log.info("Starting app url " + environment.getUrl() + " on browser " +  environment.getBrowser());
        buildWebDriver(environment.getBrowser());
        DriverManager.openPage(environment.getUrl());
        new Waiters();
    }

    @SneakyThrows
    @AfterMethod
    public void closeBrowserInstance(ITestResult iTestResult) {
        if (driverEnabled(getDriver())) {
            try {
                driverThreadLocal.get().close();
                driverThreadLocal.get().quit();
                quitDriver();
            } catch (Exception e) {
                //   FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
               /* System.out.println("Error closing and quitting the web driver: " + e.getMessage());
                quitDriver();
//             if(getDriver() instanceof ChromeDriver){
                    try {
                        //  FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
                        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                    } catch (IOException ex) {
                        System.out.println("Error force quitting the ChromeDriver process: " + ex.getMessage());
                    }*/
            }
        }
    }
    @AfterClass
    public static void afterClass() throws InterruptedException, MessagingException, IOException {
      //  MailSend_WMS.sendMail();


    }
}
