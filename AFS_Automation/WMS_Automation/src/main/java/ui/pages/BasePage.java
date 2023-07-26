package ui.pages;

import common.utils.Waiters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.Optional;

import static common.setup.DriverManager.getDriver;

public class BasePage {

    public void deleteCookies() {
        getDriver().manage().deleteAllCookies();
    }

    public boolean isElementPresent(By locator) {
        try {
            return findWebElement(locator) != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.getLocation() != null;
        } catch (NullPointerException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public int elementsArePresent(List<WebElement> elements) {
        try {
            return elements.size();
        } catch (NullPointerException | NoSuchElementException | StaleElementReferenceException e) {
            return 0;
        }
    }

    public boolean isElementDisplay(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    public boolean elementIsEnabled(By locator) {
        try {
            return findWebElement(locator).isEnabled();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            throw new IllegalArgumentException("Element with locator " + locator + " is not found");
        }
    }

    public boolean isElementClickable(WebElement webElement) {
        try {
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isElementClickable(By locator) {
        try {
            return isElementClickable(findWebElement(locator));
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isElementDisplay(By locator) {
        try {
            return findWebElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterText(WebElement element, CharSequence... dataToSend) {
        element.clear();
        element.sendKeys(dataToSend);
    }

    public void refresh() { getDriver().navigate().refresh(); }

    public void inputText(WebElement element, CharSequence... dataToSend) {
       element.sendKeys(dataToSend);
    }

    public void typeText(WebElement element, CharSequence... dataToSend) {
        Actions actions = new Actions(getDriver());
        actions.pause(2000)
               .sendKeys(element, dataToSend)
               .pause(2000)
               .build().perform();
    }

    public void deleteCharacter(WebElement element) {
        element.sendKeys("\u0008");
    }

    public void pressTab(WebElement element) { element.sendKeys(Keys.TAB); }

    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void pressBackSpace(WebElement element) { element.sendKeys(Keys.BACK_SPACE); }

    public void pressLeftArrow(WebElement element) {
        element.sendKeys(Keys.ARROW_LEFT);
    }

    public void pressDelete(WebElement element) { element.sendKeys(Keys.DELETE); }

    public void pressRightArrow(WebElement element) {
        element.sendKeys(Keys.ARROW_RIGHT);
    }

    public void pressPageUp(WebElement element) {
        element.sendKeys(Keys.PAGE_UP);
    }

    public String getText(WebElement element) { return element.getText().trim(); }

    public String getText(By locator) {return findWebElement(locator).getText().trim(); }

    public String getValue(By locator) { return findWebElement(locator).getAttribute("value").trim(); }

    public String getValue(WebElement element) { return element.getAttribute("value").trim(); }

    public void clickOnElement(WebElement element) {
        try {
            Waiters.waitForElementToBeClickable(element);
            element.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            clickOnElement(element);
        } catch (WebDriverException e) {
            throw new IllegalStateException("WebDriver exception encountered: " + e.getMessage(), e);
        }
    }

    public void click(WebElement element) {
        Actions actions = new Actions(getDriver());
        try {
            actions.click(element).build().perform();
        } catch (WebDriverException e) {
            throw new IllegalStateException("WebDriver exception encountered: " + e.getMessage(), e);
        }
    }

    public void jsClick(WebElement element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        } catch (WebDriverException e) {
            throw new IllegalStateException("WebDriver exception encountered: " + e.getMessage(), e);
        }
    }

    public void scrollAndClick(WebElement element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            element.click();
        } catch (WebDriverException e) {
            throw new IllegalStateException("WebDriver exception encountered: " + e.getMessage(), e);
        }
    }

    public void scrollToCenter(WebElement element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        } catch (WebDriverException e) {
            throw new IllegalStateException("WebDriver exception encountered: " + e.getMessage(), e);
        }
    }

    public void clear(WebElement element) {
        try {
            element.clear();
        } catch (WebDriverException e) {
            throw new IllegalStateException("WebDriver exception encountered: " + e.getMessage(), e);
        }
    }

    public void clearText(WebElement element) {
        int value = getValue(element).split("").length;
        try {
            for(int i = 0; i < value; i++) {
                pressBackSpace(element);
            }
        } catch (WebDriverException e) {
            throw new IllegalStateException("WebDriver exception encountered: " + e.getMessage(), e);
        }
    }

    public void clickOnElement(By locator) {
        try {
            findWebElement(locator).click();
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element found by locator '" + locator + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public boolean isElementSelected(By locator) {
        try {
            return findWebElement(locator).isSelected();
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element found by locator '" + locator + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void scrollTo(By locator) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", findWebElement(locator));
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element found by locator '" + locator + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element '" + element + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void doubleClick(By locator) {
        try {
            new Actions(getDriver())
                    .moveToElement(findWebElement(locator))
                    .doubleClick(findWebElement(locator))
                    .build().perform();
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element found by locator '" + locator + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void doubleClick(WebElement element) {
        try {
            new Actions(getDriver())
                    .moveToElement(element)
                    .doubleClick()
                    .build().perform();
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element '" + element + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void moveToElement(WebElement element) {
        try {
            new Actions(getDriver())
                    .moveToElement(element)
                    .build().perform();
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element '" + element + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void pressEnterButton(WebElement element) {
        try {
            element.sendKeys(Keys.ENTER);
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element '" + element + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void hover(By locator) {
        try {
            new Actions(getDriver())
                    .moveToElement(findWebElement(locator))
                    .build().perform();
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element found by locator '" + locator + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void hover(WebElement element) {
        try {
            new Actions(getDriver())
                    .moveToElement(element)
                    .build().perform();
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element '" + element + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public void dragAndDropTo(WebElement elementFrom, WebElement elementTo) {
        try {
            new Actions(getDriver())
                    .clickAndHold(elementFrom)
                    .dragAndDrop(elementFrom, elementTo)
                    .build().perform();
        } catch (WebDriverException e) {
            throw new IllegalStateException(
                    "Element '" + elementFrom + "' not found on the page: " + e.getMessage(), e);
        }
    }

    public String getElementAttribute(WebElement element, String attribute) {
        return Optional.ofNullable(element.getAttribute(attribute))
                .orElseThrow(() -> new IllegalArgumentException("Attribute " + attribute + " does not exist"));
    }

    public String checkElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public WebElement findWebElement(By by) {
        WebElement element = null;
        try {
            element = getDriver().findElement(by);
        } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException | IllegalStateException ex) {
            ex.printStackTrace();
         } catch (Exception ex) {
            ex.printStackTrace();
        }
        return element;
    }

    public List <WebElement> findWebElements(By by) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(by);
        } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException | IllegalStateException ex) {
            elements = getDriver().findElements(by);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return elements;
    }
}
