package testRunner_DSD_OMS;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import pages_DSD_OMS.login.LoginPage;
import util.MailSend;
import util.TestBase;

import javax.mail.MessagingException;
import java.awt.*;
import java.io.IOException;
import pages_DSD_OMS.login.LoginPage;


/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */

@CucumberOptions
        (features =
                {
                        "src/test/resources/features_DSD_OMS/AdminReports",
                        //"src/test/resources/features_DSD_OMS/ARInquiryFeature",
                        //"src/test/resources/features_DSD_OMS/BillToBill(DSD)",
                        //"src/test/resources/features_DSD_OMS/CatalogFeature",
                        //"src/test/resources/features_DSD_OMS/CompetitivePricingFeature",
                        //"src/test/resources/features_DSD_OMS/CustomerInqFeature_DSD",
                        //"src/test/resources/features_DSD_OMS/DisconnectedModeOEFeature",
                        //"src/test/resources/features_DSD_OMS/OrderControlListFeature",
                        //"src/test/resources/features_DSD_OMS/OrderEntryFeature/orderEntryFeature.feature",
                        //"src/test/resources/features_DSD_OMS/OrderGuideFeature",
                        //"src/test/resources/features_DSD_OMS/ParOrderFeature",
                        //"src/test/resources/features_DSD_OMS/PaymentInfoFeature",
                        //"src/test/resources/features_DSD_OMS/ProductReferenceFeature",
                        //"src/test/resources/features_DSD_OMS/QuoteFeature",
                        //"src/test/resources/features_DSD_OMS/StandingOrderFeature",
                        //"src/test/resources/features_DSD_OMS/StatementsFeature",
                        //"src/test/resources/features_DSD_OMS/WebOrderingFeature",
//                        "src/test/resources/features_DSD_OMS/loginFeature.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/UserManagementFeature/createUser_save.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/createdUserManagementFeature/User_cancel.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/UserManagementFeature/manage_registration_update.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/Additional_Email_recipient_Add.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/Additional_Email_recipient_Delete.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/Addl_Customer_Accounts.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/Addl_Customer_Accounts_Delete.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/MyAccount_NewAddress_save.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/MyAccount_NewAddress_Edit.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/MyAccount_NewAddress_Delete.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/AddPaymentInfoSave.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/AddPaymentInfo_cancel.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/AddPaymentInfoDelete.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/Additional_Email_recipient_OMSi9118DeleteFunctionality.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccountFeature/AddPaymentInfoCheckPreferred.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/ThemeBuilderFeature/themeBuilderFeatures1.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/ThemeBuilderFeature/themeBuilderFeatures2_Phase2.feature",
//                        "src/test/resources/features_Shared/features_Shared_DSD/CRMFeature/crmFeatures.feature",
//                        "src/test/resources/features_Shared/features_Shared_DSD/CRMFeature/crmFeatures1.feature",

                        //"src/test/resources/features_Shared/features_Shared_DSD/CRMFeature/crmFeatures2.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/CRMFeature/crmFeatures3.feature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/MyAccount_NewAddress_Add.feature",
                      //"src/test/resources/features_Shared/features_Shared_DSD/BadgeBuilderFeature",
                        //"src/test/resources/features_Shared/features_Shared_DSD/BadgeBuilderFeature_Phase2",


                },
                glue = {"stepDefination_DSD_OMS"},
                plugin = {"pretty",
                        "json:target/cucumber.json",
                        "html:target/cucumber-html-report.html",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/spark/",
                        "rerun:target/failedrerun.txt"},
                monochrome = true,tags = "@RegisteredUser")

public class TestRunnSingleSce extends AbstractTestNGCucumberTests {
    /* Created by Divya.Ramadas@afsi.com */

    @Parameters({"environment" })
    @BeforeClass
    public static void beforeClass(@Optional("environment") String envi) {
        try {
            TestBase.InitializeProp(envi);
            TestBase.SetDriver(TestBase.testEnvironment.get_browser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    @Parameters({"environment" })
//    @BeforeMethod
//    public static void beforeMethod(@Optional("environment") String envi) {
//        try {
//            TestBase.InitializeProp(envi);
//            TestBase.SetDriver(TestBase.testEnvironment.get_browser());
//
//            //Karthik
//            //TestBase.refreshPage();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /*@AfterMethod
    public static void afterMethod() throws InterruptedException, MessagingException, IOException {
        //Thread.sleep(10000);

        TestBase.CloseBrowser();
    }*/

    @AfterClass
    public static void afterClass() throws InterruptedException, MessagingException, IOException {
        Thread.sleep(1000);

        MailSend.sendMail();
        //TestBase.CloseBrowser() won't work since browser already got closed in AfterMethod
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
