package testRunner_DSD_OMS.OMSEnv;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.TestBase;

import javax.mail.MessagingException;
import java.io.IOException;


@CucumberOptions(features = { "src/test/resources/features_DSD_OMS/CustomerInqFeature_ERPFeature"},
        glue = {"stepDefination_DSD_OMS"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/spark/",
                "rerun:target/failedrerun.txt"
        },
        monochrome = true)
/**
 * @Project DSD
 * @Author Divya.Ramadas@telusagcg.com
 */
public class TestRunnerCustInq_ERP extends AbstractTestNGCucumberTests
{
    /* Created by Divya.Ramadas@telusagcg.com */
    @Parameters({"environment"})
    @BeforeClass
    public static void beforeClass(@Optional String envi)
    {
            try
            {
                    TestBase.InitializeProp(envi);
                    TestBase.SetDriver(TestBase.testEnvironment.get_browser());
            }
            catch (Exception e)
            {}
    }

        @AfterClass
        public static void afterclass() throws InterruptedException, MessagingException, IOException
        {
                Thread.sleep(10000);
                //MailSend.sendMail();
                TestBase.CloseBrowser();
                if (TestBase.testEnvironment.get_browser().equalsIgnoreCase("Firefox"))
                {
                        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
                }
                else if (TestBase.testEnvironment.get_browser().equalsIgnoreCase("Chrome"))
                {
                        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                }
        }
}
