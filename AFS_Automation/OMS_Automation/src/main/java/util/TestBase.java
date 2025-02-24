package util;

import helper.HelpersMethod;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class TestBase
{
    public static Environment testEnvironment;
    //// public static MenuValues testMenuValues;
    private static TestBase instanceOfDriver = null;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static String url = null;
    static String download_dir = "downloads";

    //Helps in reading property file for Parallel execution of the feature files
    // public static void InitializeProp(String envi/*,String menu*/) throws InterruptedException
  /*  {
        try
        {
            ConfigFactory.setProperty("env", envi);
           // ConfigFactory.setProperty("menu",menu);
            testEnvironment = ConfigFactory.create(Environment.class);
           // testMenuValues = ConfigFactory.create(MenuValues.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/

    public static synchronized void InitializeProp(String envi) throws InterruptedException
    {
        testEnvironment= readPropertiesFile.InitializeProp(envi);
    }

    //Constructor of TestBase
    private TestBase() {}

    //To create instance of Class
    public static TestBase getInstanceOfDriver() throws InterruptedException, AWTException
    {
        if (instanceOfDriver == null)
        {
            instanceOfDriver = new TestBase();
        }
        return instanceOfDriver;
    }

    //To get driver
    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static final void SetDriver(String browserName) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        switch (browserName.toLowerCase())
        {
            case "chrome":
            {
                //WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments("--safebrowsing-disable-download-protection");
                //chromeOptions.addArguments("--disable-popup-blocking");
                //chromeOptions.addArguments("disable-notifications");
                //chromeOptions.addArguments("disable-infobars");
                HashMap<String, Object> chromePref = new HashMap<>();
                chromePref.put("download.default_directory", System.getProperty("java.io.tmpdir"));
                chromeOptions.setExperimentalOption("prefs", chromePref);

                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("window-size=1920,1080");
                //chromeOptions.addArguments("window-size=1280,720");
                chromeOptions.addArguments("PageLoadStrategy.NORMAL");
                //chromeOptions.addArguments("test-type");
                //chromeOptions.addArguments("user-data-dir=D:/temp/");
                chromeOptions.addArguments("--aggressive-cache-discard");
                chromeOptions.addArguments("--disable-cache");
                chromeOptions.addArguments("--disable-application-cache");
                chromeOptions.addArguments("--disable-offline-load-stale-cache");
                chromeOptions.addArguments("--disk-cache-size=0");
                chromeOptions.addArguments("--dns-prefetch-disable");
                chromeOptions.addArguments("--ignore-certificate-errors","--disable-extensions","--disable-dev-shm-usage");
                //chromeOptions.addArguments("--remote-allow-origins=*");
                //driver.set(ThreadGuard.protect(new ChromeDriver(chromeOptions)));
                driver.set(new ChromeDriver(chromeOptions));
            }
            break;
            case "firefox":
            {
                //WebDriverManager.firefoxdriver().setup();
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
                driver.set(ThreadGuard.protect(new FirefoxDriver(firefoxOptions)));
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
                //WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                HashMap<String, Object> chromePref = new HashMap<>();
                chromePref.put("download.default_directory", System.getProperty("java.io.tmpdir"));
                chromeOptions.setExperimentalOption("prefs", chromePref);

                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--no-proxy-server");
                chromeOptions.addArguments("--proxy-server='direct://'");
                chromeOptions.addArguments("--proxy-bypass-list=*");
                chromeOptions.addArguments("enable-features=NetworkServiceInProcess");
                chromeOptions.addArguments("disable-features=NetworkService");
                chromeOptions.addArguments("--disable-browser-side-navigation");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--force-device-scale-factor=1");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--aggressive-cache-discard");
                chromeOptions.addArguments("--disable-cache");
                chromeOptions.addArguments("--disable-application-cache");
                chromeOptions.addArguments("--disable-offline-load-stale-cache");
                chromeOptions.addArguments("--disk-cache-size=0");
                chromeOptions.addArguments("--dns-prefetch-disable");
                chromeOptions.addArguments("--silent");

                System.setProperty("webdriver.chrome.silentOutput", "true");// extra -delete

                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--ignore-ssl-errors");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--remote-debugging-port=9222");
                chromeOptions.addArguments("--log-level=3");

                chromeOptions.addArguments("--aggressive-cache-discard");
                chromeOptions.addArguments("--disable-cache");
                chromeOptions.addArguments("--disable-application-cache");
                chromeOptions.addArguments("--disable-offline-load-stale-cache");
                chromeOptions.addArguments("--disk-cache-size=0");
                chromeOptions.addArguments("--dns-prefetch-disable");
                //driver.set(ThreadGuard.protect(new ChromeDriver(chromeOptions)));
                driver.set(new ChromeDriver(chromeOptions));
            }
            break;
            default:
                System.out.println("NO BROWSER HAS BEEN IDENTIFIED");
                break;
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();

        //to verify browser is lauched
        String currHandle=getDriver().getWindowHandle();
        assertNotNull(currHandle);

        //wait until the page is completely loaded
        getDriver().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        ////getDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        //to enter the url
        getDriver().get(testEnvironment.get_url());

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='unauthorized-content']")));
    }

    public static void unload() throws IOException
    {
        driver.remove();
    }

    public static void CloseBrowser() throws IOException
    {
        getDriver().close();
        unload();
    }
}