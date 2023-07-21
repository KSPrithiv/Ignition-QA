package ui.pages.counting.dashboard;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import static common.setup.DriverManager.getDriver;

public class CountingDashboardPage extends BasePage {
    By dashboardPageTitle = By.className("spnmoduleNameHeader");
    By cycleCountSessionLabel = By.id("ddlCycleCountSession-label");
    By cycleCountSession = By.id("ddlCycleCountSession");
    By cycleCountAssignmentLabel = By.id("ddlCycleCountAssignment-label");
    By cycleCountAssignment = By.id("ddlCycleCountAssignment");
    By locationTab = By.xpath("//li[@role='tab']//span[text()='By location']");
    By productTab = By.xpath("//li[@role='tab']//span[text()='By product']");
    By locationCountedCardGuage = By.xpath("//div[@id='cardGuage'][.//div[text()='Locations counted']]");
    By locDiscrepanciesTitle = By.xpath("//div[@id='cardDiscrepancy'][.//div[text()='Locations with discrepancies']]");
    By cardDiscrepancy = By.id("cardDiscrepancy");
    By countedLabel = By.xpath("//span[text()='Counted']");
    By onHandLabel = By.xpath("//span[text()='On hand']");
    By productCountedCardGuage = By.xpath("//div[@id='cardGuage'][.//div[text()='Products counted']]");
    By prodDiscrepanciesTitle = By.xpath("//div[@id='cardDiscrepancy'][.//div[text()='Products with discrepancies']]");
    By dropdownList = By.id("dropdownList");

    public void waitCountingDashboardPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(cycleCountSessionLabel);
        Waiters.waitForElementToBeDisplay(cycleCountSession);
        Waiters.waitForElementToBeDisplay(cycleCountAssignmentLabel);
        Waiters.waitForElementToBeDisplay(cycleCountAssignment);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickLocationTab() {
        Waiters.waitForElementToBeDisplay(locationTab);
        clickOnElement(locationTab);
    }

    public void clickProductTab() {
        Waiters.waitForElementToBeDisplay(productTab);
        clickOnElement(productTab);
    }

    public boolean isDashboardPageTitleDisplayed() { return isElementDisplay(dashboardPageTitle); }

    public boolean isCountSessionLabelDisplayed() {
        return isElementDisplay(cycleCountSessionLabel);
    }

    public boolean isCountSessionDisplayed() {
        return isElementDisplay(cycleCountSession);
    }

    public boolean isCountAssignmentLabelDisplayed() {
        return isElementDisplay(cycleCountAssignmentLabel);
    }

    public boolean isCountAssignmentDisplayed() {
        return isElementDisplay(cycleCountAssignment);
    }

    public boolean isLocationTabDisplayed() { return isElementDisplay(locationTab); }

    public boolean isProductTabDisplayed() {
        return isElementDisplay(productTab);
    }

    public boolean isLocationCountedCardGuageDisplayed() { return isElementDisplay(locationCountedCardGuage); }

    public boolean isLocDiscrepanciesTitleDisplayed() { return isElementDisplay(locDiscrepanciesTitle); }

    public boolean isCardDiscrepancyDisplayed() { return isElementDisplay(cardDiscrepancy); }

    public boolean isCountedLabelDisplayed() {
        return isElementDisplay(countedLabel);
    }

    public boolean isOnHandLabelDisplayed() {
        return isElementDisplay(onHandLabel);
    }

    public boolean isProductCountedCardGuageDisplayed() {
        return isElementDisplay(productCountedCardGuage);
    }

    public boolean isProdDiscrepanciesTitleDisplayed() {
        return isElementDisplay(prodDiscrepanciesTitle);
    }

    public WebElement getDashboardPageTitle() { return findWebElement(dashboardPageTitle); }

    public WebElement getCycleCountSessionLabel() { return findWebElement(cycleCountSessionLabel); }

    public WebElement getCycleCountSession() { return findWebElement(cycleCountSession); }

    public WebElement getCycleCountAssignmentLabel() { return findWebElement(cycleCountAssignmentLabel); }

    public WebElement getCycleCountAssignment() { return findWebElement(cycleCountAssignment); }

    public WebElement getLocationTab() { return findWebElement(locationTab); }

    public WebElement getProductTab() { return findWebElement(productTab); }

    public WebElement getLocationCountedCardGuage() { return findWebElement(locationCountedCardGuage); }

    public WebElement getLocDiscrepanciesTitle() { return findWebElement(locDiscrepanciesTitle); }

    public WebElement getCardDiscrepancy() { return findWebElement(cardDiscrepancy); }

    public WebElement getCountedLabel() { return findWebElement(countedLabel); }

    public WebElement getOnHandLabel() { return findWebElement(onHandLabel); }

    public WebElement getProductCountedCardGuage() { return findWebElement(productCountedCardGuage); }

    public WebElement getProdDiscrepanciesTitle() { return findWebElement(prodDiscrepanciesTitle); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
