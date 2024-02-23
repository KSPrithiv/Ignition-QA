package common.setup;

//import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.PageLoadStrategy;
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
                    //WebDriverManager.chromedriver().setup();
                    createdDriver = new ChromeDriver(buildChrome());
                    driverThreadLocal.set(createdDriver);
                    //setPageLoadTimeout(120);
                    //setScriptTimeout(120);
                    setPageLoadTimeout(50L);
                    setScriptTimeout(5L);
            }
        } catch (Exception ex) {
            System.out.println(".CoutingCucumberRunner.startBrowserInstance  ex");
            ex.printStackTrace();
        }

    }

    public static ChromeOptions buildChrome() {
        LOG.info("Building ChromeDriver");
        ChromeOptions options = new ChromeOptions();
        //Map<String, Object> prefs = new HashMap<>();
        //options.setExperimentalOption("prefs", prefs);
        
        //options.addArguments("profile-directory=PROFILE 2");

        //HEADLESS MODE CODE STARTS

        //on Feb-3//options.addArguments("--headless=new");
        //on Feb-3//options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-proxy-server");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        //options.addArguments("window-size=1920,1080");
        //options.addArguments("window-size=1280,720");
        //Fast
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER); //OCT-13
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("enable-features=NetworkServiceInProcess");
        options.addArguments("disable-features=NetworkService");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu"); //OCT-1
        options.addArguments("--force-device-scale-factor=1");//OCT-13
        options.addArguments("--no-sandbox");
        //Another imp
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--aggressive-cache-discard");
        options.addArguments("--disable-cache");
        options.addArguments("--disable-application-cache");
        options.addArguments("--disable-offline-load-stale-cache");
        options.addArguments("--disk-cache-size=0");
        options.addArguments("--dns-prefetch-disable");
        //options.addArguments("--no-proxy-server");
        options.addArguments("--silent");
        //options.setProxy(null);
        //System.setProperty("webdriver.chrome.silentOutput", "true");//extra -delete
        //Not imp
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--log-level=3");
        return options;
    }

    public static FirefoxOptions buildFirefox() {
        LOG.info("Building FirefoxDriver");
        //WebDriverManager.firefoxdriver().setup();
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
        //WebDriverManager.edgedriver().setup();
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
              //  FileUtils.forceDelete(new File("C:/Users/Irina.Holovan/Desktop/chrome/" + DriverManager.COUNTER));
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

    public static void setPageLoadTimeout(long timeout) {
        getDriver().manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }

    public static void setScriptTimeout(long timeout) {
        getDriver().manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
    }

    public static boolean driverEnabled(WebDriver driver) {
        return driver != null && !driver.toString().contains("null");
    }

    public static void openPage(String url) {
        getDriver().manage().window().maximize();
        getDriver().navigate().to(url);
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
    }

}
