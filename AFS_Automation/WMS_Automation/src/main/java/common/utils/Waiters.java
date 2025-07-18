package common.utils;

import common.setup.DriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.BasePage;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static common.setup.DriverManager.getDriver;
import static utilWMS.TestBase.driver;

public class Waiters {

    private static final int TIMEOUT_SECONDS = 10;

    private static final Logger LOG = LoggerFactory.getLogger(Waiters.class);
    public static final long defaultDurationInSeconds = 40;  //before 100
    public static final long defaultPollingTimeOut = 1;
    public static final long defaultTimeOut = 10;
    private static Wait<WebDriver> wait;
    private static BasePage basePage = new BasePage();
    private static ThreadLocal<WebDriver> driver;



    @SneakyThrows
    public Waiters() {
        wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(defaultDurationInSeconds))
                .pollingEvery(Duration.ofSeconds(defaultPollingTimeOut))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(IllegalStateException.class);
    }


    public static void waitForPageToStabilize(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );
    }
    public static void waitForLoaderToDisappear(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-bg"))
        );
    }




    public static void waitForPresenceOfElement1(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForPresenceOfElement1(String cssSelector) {
        //  waitForPresenceOfElement(By.cssSelector(cssSelector));
    }

    public static void waitUntilInvisible(WebDriver driver, By by) {

    }

    public static void waitUntilElementInvisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }



    public void waitForPresenceOfNestedElement(WebElement parentElement, By locator) {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement, locator));
    }

    public static void waitForPresenceOfAllElements(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static void waitForPresenceOfAllElements(String cssSelector) {
        waitForPresenceOfAllElements(By.cssSelector(cssSelector));
    }

   // public static void waitForElementToBeDisplay(WebElement element) {
     //   wait.until(ExpectedConditions.visibilityOf(element));
   // }
   // Handles WebElement directly
   public static void waitForElementToBeDisplay(WebElement element) {
       wait.until(ExpectedConditions.visibilityOf(element));
   }

    // Handles By locators universally
    public static WebElement waitForElementToBeDisplay(By locator) {
        WebElement element = getDriver().findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }



    public static void waitForStalenessOfElement(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }
    public static void waitForVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }




    public static void waitForElementToBeVisible(By locator) {
        WebDriver driver = DriverManager.getDriver(); // or your WebDriver getter
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementsToBeDisplay(WebElement... elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitForElementsToBeDisplay(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitForAllElementsToBeDisplay(WebElement... elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitForAllElementsToBeDisplay(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void waitForForAllElementsToDisappear(WebElement... elements) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public static void waitForForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return null;
    }

    public static void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(driver -> {
                List<WebElement> elements = driver.findElements(locator);
                return elements.isEmpty() || elements.stream().allMatch(e -> !e.isDisplayed());
            });
        } catch (TimeoutException e) {
            throw new RuntimeException("Loader did not disappear within timeout");
        }
    }


    public boolean isVisible(By by) {
        LOG.debug("Checking if element visible located: " + by);
        try {
            ExpectedCondition<Boolean> elementVisible = driver -> isVisible(by);
            return basePage.until(elementVisible, 10);
        } catch (NoSuchElementException | TimeoutException ex) {
            LOG.debug("Couldn't find element located by: " + by);
            return false;
        }
    }

    public static void waitABit(long milliSeconds) {
        if (milliSeconds > 0) {
            try {
                Thread.sleep(milliSeconds);
            } catch (InterruptedException ignored) {
            }
        }
    }
    public static List<WebElement> waitForElementsToBeDisplay(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static List<WebElement> waitForElementsToBeVisible(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));
        wait.pollingEvery(Duration.ofMillis(500)); // already good
        return wait.until(driver -> {
            List<WebElement> elements = driver.findElements(locator);
            for (WebElement e : elements) {
                if (!e.isDisplayed()) return null;
            }
            return elements.isEmpty() ? null : elements;
        });
    }
    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitUntilInvisible(By locator, int timeoutSeconds) {
        WebDriver driver = getDriver();
        List<WebElement> overlays = driver.findElements(locator);

        if (!overlays.isEmpty()) {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
    }
    public static void waitUntilOverlayIsGone(By overlayLocator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
        wait.pollingEvery(Duration.ofMillis(500));

        wait.until(driver -> {
            List<WebElement> overlays = driver.findElements(overlayLocator);
            return overlays.isEmpty() || overlays.stream().noneMatch(WebElement::isDisplayed);
        });
    }
    public static void waitForElementToDisappear(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("WARNING: Element " + locator + " still visible after " + timeoutInSeconds + "s. Continuing...");
        }
    }
    public void waitUntilInvisible(int seconds, By locator) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForElementToBePresent(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void waitForElementToBeDisplay(WebDriver driver, By locator) {
        waitForElementToBeDisplay(driver, locator, 10); // default 10s
    }

    public static void waitForElementToBeDisplay(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitTillElementIsVisible(WebDriver driver, By locator) {
        if (driver == null) throw new IllegalArgumentException("WebDriver is null.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilPageWillLoadedSelenide() {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static String returnDocumentStatus(WebDriver driver) {
        WebDriver driver1 = getDriver();
        JavascriptExecutor js=(JavascriptExecutor) driver1;
        return (String) js.executeScript("return document.readyState");
    }
    public static WebElement waitUntilElementClickable(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitUntilElementPresent(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitTillLoadingPage(WebDriver driver) {
        String pageLoadStatus = "";
        boolean pageWasLoaded = false;
        do {
            try {
                pageLoadStatus = returnDocumentStatus(driver);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            if(pageLoadStatus.equals("complete") || pageLoadStatus.equals("interactive")) {
                pageWasLoaded=true;
            }
        }
        while(!pageWasLoaded);
        return pageWasLoaded;
    }

    // In Waiters.java (utility class)
    public static void waitForElementToBeDisplay(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }




}