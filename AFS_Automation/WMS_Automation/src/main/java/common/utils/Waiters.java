package common.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementIsNotClickableException;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static common.setup.DriverManager.getDriver;

public class Waiters {
    private static final Logger LOG = LoggerFactory.getLogger(Waiters.class);
    public static final long defaultDurationInSeconds = 100;
    public static final long defaultPollingTimeOut = 1;
    public static final long defaultTimeOut = 10;
    private static Wait<WebDriver> wait;

    @SneakyThrows
    public Waiters() {
        wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(defaultDurationInSeconds))
                .pollingEvery(Duration.ofSeconds(defaultPollingTimeOut))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementIsNotClickableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(IllegalStateException.class);
    }

    public SelenideWait getNewSelenideWait(long durationInSeconds, long pollingTimeOut) {
        return new SelenideWait(getDriver(), durationInSeconds, pollingTimeOut);
    }

    public static void waitForPresenceOfElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForPresenceOfElement(String cssSelector) {
        waitForPresenceOfElement(By.cssSelector(cssSelector));
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

    public static void waitABit(long milliSeconds) {
        if (milliSeconds > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(milliSeconds);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public static void waitUntilPageWillLoadedSelenide() {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
