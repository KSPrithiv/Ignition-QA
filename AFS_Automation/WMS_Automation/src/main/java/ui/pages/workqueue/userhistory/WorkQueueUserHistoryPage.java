package ui.pages.workqueue.userhistory;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

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

    public void waitWorkQueueUserHistoryPageToLoad() {
        Waiters.waitABit(6000);
        Waiters.waitUntilPageWillLoadedSelenide();
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
        Waiters.waitABit(2000);
    }

    public boolean isUserHistoryTitleDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getUserHistoryTitle());
    }

    public boolean isLoginColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLoginColumn());
    }

    public boolean isLogoutColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLogoutColumn());
    }

    public boolean isUserIdColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getUserIdColumn());
    }

    public boolean isUserNameColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getUserNameColumn());
    }

    public boolean isAddFilterButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAddFilterButton());
    }

    public boolean isUserHistorySearchDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getUserHistorySearch());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getItemsFoundLabel());
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getItemsFoundValue());
    }

    public boolean isTableContentDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTableContent());
    }

    public boolean isTableEndIsDisplayed() {
        Waiters.waitABit(2000);
        WebElement el = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"))
                .get(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size()-1);
        return isElementDisplay(el);
    }

    public List<WebElement> getUserHistoryTableRows() {
        Waiters.waitABit(2000);
        return getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
    }

    public int getUserHistoryTableRowsSize() {
        Waiters.waitABit(2000);
        return getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size();
    }

    public void scrollToUserHistoryTableEnd() {
        Waiters.waitABit(2000);
        WebElement el = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"))
                .get(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size()-1);
        Waiters.waitABit(2000);
        moveToElement(el);
    }

    public void findValuesInSearch(String text) {
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
