package ui.pages.workqueue.userhistory;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

import static common.setup.DriverManager.getDriver;

public class WorkQueueUserHistoryPage extends BasePage {
    By userHistoryTitle = By.xpath("//span[contains(text(), 'User history')]");
    By loginColumn = By.xpath("//span[contains(text(), 'Login')]");
    By loginColumnHeader = By.xpath("//th[@role='columnheader'][.//span[contains(text(), 'Login')]]");
    By logoutColumn = By.xpath("//span[contains(text(), 'Logout')]");
    By logoutColumnHeader = By.xpath("//th[@role='columnheader'][.//span[contains(text(), 'Logout')]]");
    By userIdColumn = By.xpath("//span[text()='User id']");
    By userIdColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='User id']]");
    By userNameColumn = By.xpath("//span[text()='User name']");
    By userNameColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='User name']]");
    By addFilterButton = By.xpath("//span[contains(text(), 'Add filter')]");
    By userHistorySearch = By.id("UserHistorySearch");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By tableContent = By.xpath("//table[@class='k-grid-table']");
    By dropdownList = By.id("dropdownList");
    By loader = By.cssSelector(".loader");

    public void waitWorkQueueUserHistoryPageToLoad() {
        waitUntilInvisible(5, loader);
        Waiters.waitForElementToBeDisplay(getUserHistoryTitle());
        Waiters.waitForElementToBeDisplay(getLoginColumn());
        Waiters.waitForElementToBeDisplay(getLogoutColumn());
        Waiters.waitForElementToBeDisplay(getUserIdColumn());
        Waiters.waitForElementToBeDisplay(getUserNameColumn());
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public boolean isUserHistoryTitleDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getUserHistoryTitle());
    }

    public boolean isLoginColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLoginColumn());
    }

    public boolean isLogoutColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLogoutColumn());
    }

    public boolean isUserIdColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getUserIdColumn());
    }

    public boolean isUserNameColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getUserNameColumn());
    }

    public boolean isAddFilterButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getAddFilterButton());
    }

    public boolean isUserHistorySearchDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getUserHistorySearch());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getItemsFoundLabel());
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getItemsFoundValue());
    }

    public boolean isTableContentDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getTableContent());
    }

    public boolean isTableEndIsDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        WebElement el = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"))
                .get(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size()-1);
        return isElementDisplay(el);
    }

    public List<WebElement> getUserHistoryTableRows() {
        Waiters.waitTillLoadingPage(getDriver());
        return getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
    }

    public int getUserHistoryTableRowsSize() {
        Waiters.waitTillLoadingPage(getDriver());
        return getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size();
    }

    public void scrollToUserHistoryTableEnd() {
        Waiters.waitTillLoadingPage(getDriver());
        WebElement el = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"))
                .get(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size()-1);
        Waiters.waitABit(2000);
        moveToElement(el);
    }

    public void findValuesInSearch(String text) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getUserHistorySearch());
        inputText(getUserHistorySearch(), text);
        pressEnter(getUserHistorySearch());
    }

    public void clearValueInSearch() {
        Waiters.waitForElementToBeDisplay(getUserHistorySearch());
        clear(getUserHistorySearch());
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundValue);
    }

    public void clickLoginHeader() {
        Waiters.waitForElementToBeDisplay(loginColumnHeader);
        clickOnElement(loginColumnHeader);
    }

    public void clickLogoutHeader() {
        Waiters.waitForElementToBeDisplay(logoutColumnHeader);
        clickOnElement(logoutColumnHeader);
    }

    public void clickUserIdHeader() {
        Waiters.waitForElementToBeDisplay(userIdColumnHeader);
        clickOnElement(userIdColumnHeader);
    }

    public void clickUserNameHeader() {
        Waiters.waitForElementToBeDisplay(userNameColumnHeader);
        clickOnElement(userNameColumnHeader);
    }

    public String getLoginColumnHeaderSortingResult() {
        return getElementAttribute(getLoginColumnHeader(), "aria-sort");
    }

    public String getLogoutColumnHeaderSortingResult() {
        return getElementAttribute(getLogoutColumnHeader(), "aria-sort");
    }

    public String getUserIdColumnHeaderSortingResult() {
        return getElementAttribute(getUserIdColumnHeader(), "aria-sort");
    }

    public String getUserNameColumnHeaderSortingResult() {
        return getElementAttribute(getUserNameColumnHeader(), "aria-sort");
    }

    public WebElement getUserHistoryTitle() { return findWebElement(userHistoryTitle); }

    public WebElement getLoginColumn() { return findWebElement(loginColumn); }

    public WebElement getLogoutColumn() { return findWebElement(logoutColumn); }

    public WebElement getUserIdColumn() { return findWebElement(userIdColumn); }

    public WebElement getUserNameColumn() { return findWebElement(userNameColumn); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getUserHistorySearch() { return findWebElement(userHistorySearch); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getItemsFoundValue() { return findWebElement(itemsFoundValue); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getLoginColumnHeader() { return findWebElement(loginColumnHeader); }

    public WebElement getLogoutColumnHeader() { return findWebElement(logoutColumnHeader); }

    public WebElement getUserIdColumnHeader() { return findWebElement(userIdColumnHeader); }

    public WebElement getUserNameColumnHeader() { return findWebElement(userNameColumnHeader); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
