package common.utils;

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

public class Waiters {
    private static final Logger LOG = LoggerFactory.getLogger(Waiters.class);
    public static final long defaultDurationInSeconds = 40;  //before 100
    public static final long defaultPollingTimeOut = 1;
    public static final long defaultTimeOut = 10;
    private static Wait<WebDriver> wait;
    private BasePage basePage = new BasePage();

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

    public static void waitForPresenceOfElement1(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForPresenceOfElement1(String cssSelector) {
      //  waitForPresenceOfElement(By.cssSelector(cssSelector));
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

    public static void waitForElementToBeDisplay(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForStalenessOfElement(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static void waitForElementToBeDisplay(By locator) {
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

    public static void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToDisappear(By by) {
       new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(basePage.findWebElement(by)));
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

    public static void waitUntilPageWillLoadedSelenide() {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static String returnDocumentStatus(WebDriver driver) {
        WebDriver driver1 = getDriver();
        JavascriptExecutor js=(JavascriptExecutor) driver1;
        return (String) js.executeScript("return document.readyState");
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

}
