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
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
@CucumberOptions(features = "src/test/resources/features_DSD_OMS/loginFeature.feature",
        glue={"stepDefination_DSD_OMS"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/",
                "rerun:target/failedrerun.txt"},
        monochrome = true)

public class CrossBrowserTestRunner extends AbstractTestNGCucumberTests
{
    @Parameters({"browserType","environment"})
    @BeforeClass
    public static void beforeClass(@Optional String btype,String envi) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        readPropertiesFile.InitializeProp(envi);
        //TestBase.InitializeProp(envi);
        TestBase.SetDriver(btype);
    }

    @AfterClass
    public static void afterClass() throws InterruptedException, MessagingException, IOException
    {
        MailSend.sendMail();
        TestBase.CloseBrowser();
    }
}
