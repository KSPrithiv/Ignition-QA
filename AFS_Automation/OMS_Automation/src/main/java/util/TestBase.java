package util;


import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.ExceptionLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class TestBase
{
    public static Environment testEnvironment;
   // public static MenuValues testMenuValues;
    private static TestBase instanceOfDriver = null;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static String url = null;


    //Reading property file for Parallel execution of the feature files
    public static void InitializeProp(String envi/*,String menu*/) throws InterruptedException
    {
        try
        {
            ConfigFactory.setProperty("env", envi);
           // ConfigFactory.setProperty("menu",menu);
            testEnvironment = ConfigFactory.create(Environment.class);
           // testMenuValues = ConfigFactory.create(MenuValues.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Constructor of TestBase
    private TestBase() {}

    //To create instance of Class
    public static TestBase getInstanceOfDriver() throws InterruptedException, AWTException {
        if (instanceOfDriver == null) {
            instanceOfDriver = new TestBase();
        }
        return instanceOfDriver;
    }

    //To get driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static final void SetDriver(String browser) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {


        String browserName = browser;
        boolean isHeadless = false;
        switch (browserName.toLowerCase())
        {
            case "chrome":
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                chromeOptions.addArguments("--safebrowsing-disable-download-protection");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("disable-notifications");
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("window-size=1920,1080");
                chromeOptions.addArguments("PageLoadStrategy.NONE");
                chromeOptions.addArguments("test-type");
                chromeOptions.addArguments("user-data-dir=D:/temp/");

              /*  chromeOptions.addArguments("window-size=1280,720");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--no-proxy-server");
                chromeOptions.addArguments("--proxy-server='direct://'");
                chromeOptions.addArguments("--proxy-bypass-list=*");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                chromeOptions.addArguments("enable-features=NetworkServiceInProcess");
                chromeOptions.addArguments("disable-features=NetworkService");
                chromeOptions.addArguments("--disable-browser-side-navigation");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--force-device-scale-factor=1");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--aggressive-cache-discard");
                chromeOptions.addArguments("--disable-cache");
                chromeOptions.addArguments("--disable-application-cache");
                chromeOptions.addArguments("--disable-offline-load-stale-cache");
                chromeOptions.addArguments("--disk-cache-size=0");
                chromeOptions.addArguments("--dns-prefetch-disable");
                chromeOptions.addArguments("--silent");
                //chromeOptions.setProxy(null);
                System.setProperty("webdriver.chrome.silentOutput", "true");// extra -delete
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--ignore-ssl-errors");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--log-level=3");*/

                driver.set(new ChromeDriver());
            }
            break;
            case "firefox":
            {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                // firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
                // firefoxOptions.setCapability("marionette", true);

                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
                profile.setPreference("browser.download.dir", "C:\\Users\\Divya.Ramadas\\Downloads");
                profile.setPreference("browser.download.folderList", 1);
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/vnd.ms-excel");
                profile.setPreference("browser.download.manager.showWhenStarting", false);
                profile.setPreference("browser.helperApps.neverAsk.openFile", "text/csv,application/vnd.ms-excel");
                profile.setPreference("browser.helperApps.alwaysAsk.force", false);
                profile.setPreference("browser.download.manager.useWindow", false);
                profile.setPreference("browser.download.manager.focusWhenStarting", false);
                profile.setPreference("browser.download.manager.showAlertOnComplete", false);
                profile.setPreference("browser.download.manager.closeWhenDone", true);

                firefoxOptions.setProfile(profile);
                driver.set(new FirefoxDriver(firefoxOptions));
            }
            break;
            case "edge":
            {
                //WebDriverManager.edgedriver().setup();
                //EdgeOptions edgeOptions = new EdgeOptions();

                //driver.set(new EdgeDriver());
               /* WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
                ieOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                driver.set(new InternetExplorerDriver());*/
            }
            break;
            case "headless":
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("window-size=1280,720");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--no-proxy-server");
                chromeOptions.addArguments("--proxy-server='direct://'");
                chromeOptions.addArguments("--proxy-bypass-list=*");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                chromeOptions.addArguments("enable-features=NetworkServiceInProcess");
                chromeOptions.addArguments("disable-features=NetworkService");
                chromeOptions.addArguments("--disable-browser-side-navigation");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--force-device-scale-factor=1");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--aggressive-cache-discard");
                chromeOptions.addArguments("--disable-cache");
                chromeOptions.addArguments("--disable-application-cache");
                chromeOptions.addArguments("--disable-offline-load-stale-cache");
                chromeOptions.addArguments("--disk-cache-size=0");
                chromeOptions.addArguments("--dns-prefetch-disable");
                chromeOptions.addArguments("--silent");
                //chromeOptions.setProxy(null);
                System.setProperty("webdriver.chrome.silentOutput", "true");// extra -delete
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--ignore-ssl-errors");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--log-level=3");
                driver.set(new ChromeDriver(chromeOptions));
            }
            break;
            default:
                System.out.println("NO BROWSER HAS BEEN IDENTIFIED");
                break;
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        //getDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        System.out.println(testEnvironment.get_url());
        getDriver().get(testEnvironment.get_url());
        Thread.sleep(4000);
    }

    public static void unload() throws IOException {
        driver.remove();
    }

    public static void CloseBrowser() throws IOException
    {
        getDriver().close();
        unload();
    }

    //Karthik
    public static void refreshPage() throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        getDriver().navigate().refresh();
    }
}