package ui.pages.inbound.loads;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import java.util.List;

import static common.setup.DriverManager.getDriver;

public class InboundLoadPage extends BasePage {

    By topIcon = By.xpath("//span[contains(text(), 'Inbound load summary')]");
    By summaryRouteHeader = By.cssSelector("#crdSummaryRouteHeader");
    By summaryRouteCode = By.cssSelector("#spnRouteCodeNo");
    By loadCards = By.cssSelector(".i-card__card .i-card__card");
    By toolBarContainer = By.cssSelector(".i-toolbar-container");
    By barContainer = By.cssSelector(".BarsContainer");
    By orderList = By.cssSelector("#crdInboundOrderPortrait .BarsContainer");

    public void waitForInboundLoadPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTopIcon());
        Waiters.waitForElementToBeDisplay(getSummaryRouteHeader());
        Waiters.waitForElementToBeDisplay(getSummaryRouteCode());
    }

    public boolean isSummaryRouteHeaderPresent() {
        return isElementPresent(getSummaryRouteHeader());
    }

    public void clickOnOrderByLineNumber(int num) {
        Waiters.waitForAllElementsToBeDisplay(By.cssSelector("#crdInboundOrderPortrait .BarsContainer"));
        clickOnElement(getOrderList().get(num));
    }

    public boolean checkLoadCardsSize() {
      return (elementsArePresent(getLoadCards()) != 0);
    }

    public boolean isToolBarContainerPresent() {
        return isElementPresent(getBarContainer());
    }

    public boolean isBarContainerPresent() {
        return isElementPresent(getBarContainer());
    }

    public String getLoadStatus() {
        Waiters.waitForPresenceOfAllElements(By.cssSelector(".i-card__card .i-card__card"));
        return getLoadCards().get(0).findElement(By.cssSelector("#span_Status")).getText();
    }

    public WebElement getTopIcon() {
        return findWebElement(topIcon);
    }

    public WebElement getSummaryRouteHeader() {
        return findWebElement(summaryRouteHeader);
    }

    public WebElement getSummaryRouteCode() {
        return findWebElement(summaryRouteCode);
    }

    public List<WebElement> getLoadCards() {
        return findWebElements(loadCards);
    }

    public WebElement getToolBarContainer() {
        return findWebElement(toolBarContainer);
    }

    public WebElement getBarContainer() {
        return findWebElement(barContainer);
    }

    public List<WebElement> getOrderList() {
        return findWebElements(orderList);
    }
}
