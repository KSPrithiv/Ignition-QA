package common.setup;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import common.utils.Waiters;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final Logger LOG = LoggerFactory.getLogger(DriverManager.class);
    private static final String WORKING_DIR = System.getProperty("user.dir");
    private static final String PATH_TO_DOWNLOADS = WORKING_DIR + File.separator + "downloads";
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static long COUNTER = System.currentTimeMillis();

    public static void buildWebDriver(String browserType) {
        WebDriver createdDriver;

        try {
            switch (browserType) {
                case "firefox":
            /*  Configuration.browserCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, buildFirefox());
                Configuration.browser = "firefox";*/
                    createdDriver = new FirefoxDriver(buildFirefox());
                    //   storedDrivers.add(createdDriver);
                    setDriver(createdDriver);
                    break;
                case "edge":
                    buildEdge();
                    createdDriver = new EdgeDriver();
                    //    storedDrivers.add(createdDriver);
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
      //              System.setProperty("webdriver.chrome.driver", "C:\\Users\\Irina.Holovan\\Documents\\WMS\\IgnitionTestAutomation\\WMSAutomation\\src\\test\\resources\\drivers\\chromedriver.exe");
                    createdDriver = new ChromeDriver(buildChrome());
                    //     storedDrivers.add(createdDriver);
                    driverThreadLocal.set(createdDriver);
                    setPageLoadTimeout(120);
                    setScriptTimeout(120);
                    System.out.println(" createdDriver " + createdDriver);
                    System.out.println(" driverThreadLocal  " + driverThreadLocal);
            }
        } catch (Exception ex) {
            System.out.println(".CoutingCucumberRunner.startBrowserInstance  ex");
            ex.printStackTrace();
        }

    }

    public static ChromeOptions buildChrome() {
        LOG.info("Building ChromeDriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        //turn off message "Let's save your password for this site"
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);        //
       // prefs.put("download.default_directory", PATH_TO_DOWNLOADS);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--no-sandbox");
        options.addArguments("--enable-automation");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("download.prompt_for_download", false);
        options.setCapability("download.directory_upgrade", true);
        options.setCapability("safebrowsing.enabled", false);
        //turn off message "Chrome is being controlled by automated test software"
     /*   options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);        //
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-logging");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-blink-features=AutomationControlled");
        options.addArguments("--no-default-browser-check");*/
     //   COUNTER++;
      //  System.out.println("counter !!!! " + COUNTER);
      //  options.addArguments("--user-data-dir=C:/Users/Irina.Holovan/Desktop/chrome/" + COUNTER);
        return options;
    }

    public static FirefoxOptions buildFirefox() {
        LOG.info("Building FirefoxDriver");
        WebDriverManager.firefoxdriver().setup();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.shell.checkDefaultBrowser", false);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setAcceptUntrustedCertificates(false);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return options;
    }

    public static void buildEdge() {
        LOG.info("Building EdgeDriver");
        WebDriverManager.edgedriver().setup();
    }

    @SneakyThrows
    public static void closeWebDriver() {
        if (driverEnabled(getDriver())) {
            try{
                driverThreadLocal.get().quit();
               /* //   storedDrivers.remove(getDriver());
                System.out.println(" BERFORE  getDriver().close(); ");
                getDriver().close();
                System.out.println(" BEFORE getDriver().quit(); ");
                getDriver().quit();
                System.out.println(" BEFORE  driverThreadLocal.remove(); ");
                driverThreadLocal.remove();
                System.out.println(" AFTER  driverThreadLocal.remove(); ");
                FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));*/
            } catch(Exception e) {
                FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
                System.out.println("Error closing and quitting the web driver: " + e.getMessage());
                if(getDriver() instanceof ChromeDriver){
                    try {
                      //  FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
                        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                    } catch (IOException ex) {
                        System.out.println("Error force quitting the ChromeDriver process: " + ex.getMessage());
                    }
                }
            }
        }
    }

    public static WebDriver getDriver() { return driverThreadLocal.get(); }

    public static void setDriver(WebDriver driver) { driverThreadLocal.set(driver); }

    public static void quitDriver() {
        if (driverEnabled(getDriver())) {
            LOG.debug("Finishing driver");
            getDriver().quit();
        }
    }

    public static void setPageLoadTimeout(int timeout) {
        getDriver().manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }

    public static void setScriptTimeout(int timeout) {
        getDriver().manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
    }

    public static boolean driverEnabled(WebDriver driver) {
        return driver != null && !driver.toString().contains("null");
    }

    public static void openPage(String url) {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().navigate().to(url);
        getDriver().manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
    }

}
