package testRunner_DSD_OMS.DSDEnv;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.TestBase;

import java.io.IOException;

/**
 * @Project Divya.Ramadas@teluagcg.com
 * @Author Divya.Ramadas
 */
@CucumberOptions
        (features = {
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/catalogAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/inventoryAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/orderControlListAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/orderEntryAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/orderEntryAdminToClientFeature1.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/orderEntryAdminToClientFeatureDSD.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/orderGuideAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/webOrderingAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/standingOrderAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/quotesAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/loginPageAdminToClientFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/disconnectedModeAdminFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/orderFactorOrderEntryFeature.feature",
                "src/test/resources/features_DSD_OMS/AdminToClientNavigation/customerInqAdminClientFeatureDSD.feature",
                //"src/test/resources/features_DSD_OMS/AdminToClientNavigation/reportsAdminToClientFeature.feature",
        },
                glue = {"stepDefination_DSD_OMS"},
                plugin = {"pretty",
                        "json:target/cucumber.json",
                        "html:target/cucumber-html-report.html",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/spark/",
                        "rerun:target/failedrerun.txt"},
                monochrome = true)

public class TestRunnerAdminClientNavigationDSD extends AbstractTestNGCucumberTests
{
    /* Created by Divya.Ramadas */
    @Parameters({"environment"})
    @BeforeMethod
    public static void beforeMethod(@Optional("environment") String envi)
    {
        try
        {
            //readPropertiesFile.InitializeProp(envi);
            TestBase.InitializeProp(envi);
            TestBase.SetDriver(TestBase.testEnvironment.get_browser());
        }
        catch (Exception e) { }
    }

    @AfterMethod
    public static void afterMethod() throws InterruptedException, IOException
    {
        Thread.sleep(500);
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
