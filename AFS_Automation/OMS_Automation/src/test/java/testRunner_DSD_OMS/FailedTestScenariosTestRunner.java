package testRunner_DSD_OMS;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import util.MailSend;
import util.TestBase;

import javax.mail.MessagingException;
import java.awt.*;
import java.io.IOException;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
@CucumberOptions(features = {"@target/failedrerun.txt"},
        glue = {"stepDefination_DSD_OMS"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/",
                "rerun:target/failedrerun.txt"
        },
        monochrome = true)
public class FailedTestScenariosTestRunner extends AbstractTestNGCucumberTests
{
    /* Created by Divya.Ramadas@afsi.com */
    @Parameters({"environment"})
    @BeforeClass
    public static void beforeClass(@Optional("environment") String envi) throws InterruptedException, AWTException
    {
        try
        {
            TestBase.InitializeProp(envi);
            TestBase.SetDriver(TestBase.testEnvironment.get_browser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    @DataProvider()
    public Object[][] scenarios()
    {
        return super.scenarios();
    }

    @AfterClass
    public static void afterClass() throws MessagingException, IOException
    {
        MailSend.sendMail();
        TestBase.CloseBrowser();
    }
}
