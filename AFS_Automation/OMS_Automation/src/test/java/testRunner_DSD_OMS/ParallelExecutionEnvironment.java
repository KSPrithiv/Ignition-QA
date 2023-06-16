package testRunner_DSD_OMS;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import util.MailSend;
import util.TestBase;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
@CucumberOptions
        (features = "src/test/resources/features_DSD_OMS/AllOrderFeature",
                glue = {"stepDefination_DSD_OMS"},
                plugin = {"pretty",
                        "json:target/cucumber.json",
                        "html:target/cucumber-html-report.html",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/spark/",
                        "rerun:target/failedrerun.txt"},
                monochrome = true)

public class ParallelExecutionEnvironment extends AbstractTestNGCucumberTests
{
    /* Created by Divya.Ramadas@afsi.com */
    @Parameters({"environment"})
    @BeforeClass
    public static void beforeClass(@Optional("environment") String envi)
    {
        try
        {
            TestBase.InitializeProp(envi);
            TestBase.SetDriver(TestBase.testEnvironment.get_browser());
        }
        catch (Exception e)
        { }
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }

    @AfterClass
    public static void afterclass() throws InterruptedException, MessagingException, IOException
    {
        MailSend.sendMail();
        TestBase.CloseBrowser();
    }
}
