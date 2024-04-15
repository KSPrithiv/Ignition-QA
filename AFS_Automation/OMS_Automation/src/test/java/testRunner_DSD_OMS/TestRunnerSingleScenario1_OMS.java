package testRunner_DSD_OMS;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.MailSend;
import util.TestBase;
import util.readPropertiesFile;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
@CucumberOptions(features = "src/test/resources/features_DSD_OMS/loginFeature.feature",
        glue = {"stepDefination_DSD_OMS"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/spark/",
                "rerun:target/failedrerun.txt"
        },
        monochrome = true,
tags="@ValidCredetials")

public class TestRunnerSingleScenario1_OMS extends AbstractTestNGCucumberTests
{
    /* Created by Divya.Ramadas@afsi.com */
    @Parameters({"environment"})
    @BeforeClass
    public static void beforeClass(@Optional String envi)
    {
        try
        {
            readPropertiesFile.InitializeProp(envi);
            //TestBase.InitializeProp(envi);
            TestBase.SetDriver(TestBase.testEnvironment.get_browser());
        }
        catch (Exception e)
        {}
    }

    @AfterClass
    public static void afterclass() throws InterruptedException, MessagingException, IOException
    {
        MailSend.sendMail();
        TestBase.CloseBrowser();
        Thread.sleep(10000);
    }
}
