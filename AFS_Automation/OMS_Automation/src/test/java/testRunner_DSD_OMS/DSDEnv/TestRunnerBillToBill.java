package testRunner_DSD_OMS.DSDEnv;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import util.MailSend;
import util.TestBase;
import util.readPropertiesFile;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
@CucumberOptions
        (features = "src/test/resources/features_DSD_OMS/BillToBill(DSD)Feature",
                glue = {"stepDefination_DSD_OMS"},
                plugin = {"pretty",
                        "json:target/cucumber.json",
                        "html:target/cucumber-html-report.html",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/spark/",
                        "rerun:target/failedrerun.txt"},
                monochrome = true)

public class TestRunnerBillToBill extends AbstractTestNGCucumberTests
{
    /* Created by Divya.Ramadas@afsi.com */
    @Parameters({"environment"})
    @BeforeClass
    public static void beforeClass(@Optional("environment") String envi)
    {
        try
        {
            //readPropertiesFile.InitializeProp(envi);
            TestBase.InitializeProp(envi);
            TestBase.SetDriver(TestBase.testEnvironment.get_browser());
        }
        catch (Exception e) { }
    }

    @AfterClass
    public static void afterclass() throws InterruptedException, MessagingException, IOException
    {
        Thread.sleep(500);
        //MailSend.sendMail();
        TestBase.CloseBrowser();
        if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("Firefox"))
        {
            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
        }
        else
        if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("Chrome"))
        {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        }
    }
}
