package testRunner_DSD_OMS;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.MailSend;
import util.TestBase;
import util.readPropertiesFile;

import javax.mail.MessagingException;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
@CucumberOptions(features = "src/test/resources/features_DSD_OMS/OrderEntryFeature",
        glue={"stepDefination_DSD_OMS"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/",
                "rerun:target/failedrerun.txt"},
        monochrome = true,tags="@AddingNewPayment")

public class OMSFeatureTestRunner extends AbstractTestNGCucumberTests
{
    /* Created by Divya.Ramadas@afsi.com */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {

        // TestBase.InitializeProp("config_DSD_OMS/config_OMS");
        TestBase.SetDriver(TestBase.testEnvironment.get_browser());
    }

    @AfterClass
    public static void afterclass() throws InterruptedException, MessagingException, IOException
    {
        MailSend.sendMail();
        TestBase.CloseBrowser();
    }
}
