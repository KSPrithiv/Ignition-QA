package ui.pages.workqueue.loggedinusers;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

public class WorkQueueLoggedInUsersPage extends BasePage {
    By loggedInTitle = By.xpath("//span[contains(text(), 'Logged-in users')]");
    By userIdColumn = By.xpath("//span[text()='User id']");
    By userIdColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='User id']]");
    By userNameColumn = By.xpath("//span[text()='User name']");
    By userNameColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='User name']]");
    By computerColumn = By.xpath("//span[text()='Computer']");
    By computerColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Computer']]");
    By equipmentColumn = By.xpath("//span[text()='Equipment']");
    By equipmentColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Equipment']]");
    By printerColumn = By.xpath("//span[text()='Printer']");
    By printerColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Printer']]");
    By loginDateColumn = By.xpath("//span[text()='Login date']");
    By loginDateColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Login date']]");
    By breakDateColumn = By.xpath("//span[text()='Break date']");
    By breakDateColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Break date']]");
    By laborCodeColumn = By.xpath("//span[text()='Labor code']");
    By laborCodeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Labor code']]");
    By assignmentGridSearch = By.id("AssignmentGridSearch");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By tableContent = By.xpath("//table[@class='k-grid-table']");
    By userIdFilter = By.cssSelector(".i-btn-checkbox  #UserId");
    By userNameFilter = By.cssSelector(".i-btn-checkbox  #UserName");
    By computerFilter = By.cssSelector(".i-btn-checkbox  #Computer");
    By equipmentFilter = By.cssSelector(".i-btn-checkbox  #Equipment");
    By printerCodeFilter = By.cssSelector(".i-btn-checkbox  #PrinterCode");
    By loginDateTimeFilter = By.cssSelector(".i-btn-checkbox  #LoginDateTime");
    By breakDateTimeFilter = By.cssSelector(".i-btn-checkbox  #BreakDateTime");
    By laborCodeFilter = By.cssSelector(".i-btn-checkbox  #LaborCode");
    By addFilterButton = By.xpath("//span[contains(text(), 'Add filter')]");
    By clearAllButton = By.xpath("//button[text()='Clear all']");
    By inputContains = By.xpath("//input[@placeholder='Contains']");
    By applyButton = By.xpath("//button[text()='Apply']");
    By btnRemove = By.id("btnRemove");
    By logOutUserPopUpTitle = By.cssSelector("div.k-dialog-title");
    By logoutUserDropdown = By.xpath("//div[contains(@class, 'k-window-content')]//span[contains(@class, 'k-dropdown-wrap')]");
    By okButton = By.xpath("//button[contains(text(), 'OK')]");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By notificationMsg = By.cssSelector(".toast-message");
    By dropdownList = By.id("dropdownList");

    public void waitWorkQueueLoggedInUsersPageToLoad() {
        Waiters.waitABit(6_000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getLoggedInTitle());
        Waiters.waitForElementToBeDisplay(getUserIdColumn());
        Waiters.waitForElementToBeDisplay(getUserNameColumn());
        Waiters.waitForElementToBeDisplay(getComputerColumn());
        Waiters.waitForElementToBeDisplay(getEquipmentColumn());
    }

    public boolean isLoggedInTitleDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLoggedInTitle());
    }

    public boolean isUserIdColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getUserIdColumn());
    }

    public boolean isUserNameColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getUserNameColumn());
    }

    public boolean isComputerColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getComputerColumn());
    }

    public boolean isEquipmentColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEquipmentColumn());
    }

    public boolean isPrinterColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getPrinterColumn());
    }

    public boolean isLoginDateColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLoginDateColumn());
    }

    public boolean isBreakDateColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getBreakDateColumn());
    }

    public boolean isLaborCodeColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLaborCodeColumn());
    }

    public boolean isTableContentDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTableContent());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getItemsFoundLabel());
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getItemsFoundValue());
    }

    public boolean isTableEndIsDisplayed() {
        Waiters.waitABit(2000);
        WebElement el = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"))
                .get(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size()-1);
        return isElementDisplay(el);
    }

    public boolean isUserIdFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getUserIdFilter());
    }

    public boolean isUserNameFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getUserNameFilter());
    }

    public boolean isComputerFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getComputerFilter());
    }

    public boolean isEquipmentFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEquipmentFilter());
    }

    public boolean isPrinterCodeFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getPrinterCodeFilter());
    }

    public boolean isLoginDateTimeFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLoginDateTimeFilter());
    }

    public boolean isBreakDateTimeFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getBreakDateTimeFilter());
    }

    public boolean isLaborCodeFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLaborCodeFilter());
    }

    public boolean isLogOutUserLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getBtnRemove());
    }

    public boolean isOKButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(okButton);
    }

    public boolean isCancelButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(cancelButton);
    }

    public boolean isLogOutUserPopUpTitleDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLogOutUserPopUpTitle());
    }

    public void clickLogoutUserDropdown() {
        Waiters.waitABit(2000);
        clickOnElement(getLogoutUserDropdown());
    }

    public void selectLogoutUserReason(String reason) {
        clickOnElement(getLogoutUserDropdown());
        WebElement option = findWebElement(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option' and contains(text(), '"
                        + reason + "')]"));
        clickOnElement(option);
        Waiters.waitABit(5_000);
    }

    public void clickOK() {
        Waiters.waitABit(2000);
        clickOnElement(okButton);
    }

    public void clickCancel() {
        Waiters.waitABit(2000);
        clickOnElement(cancelButton);
    }

    public void clickLogoutUserLabel() {
        Waiters.waitABit(2000);
        clickOnElement(getBtnRemove());
    }

    public boolean isLogOutUserLabelDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getBtnRemove(), "class").contains("disabled");
    }

    public List<WebElement> getLoggedInUsersTableRows() {
        Waiters.waitABit(2000);
        return getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
    }

    public int getLoggedInUsersTableRowsSize() {
        Waiters.waitABit(2000);
        return getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size();
    }

    public void clickOnLoggedInUserByIndex(int index) {
        Waiters.waitABit(2000);
        List<WebElement> rows = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
        clickOnElement(rows.get(index));
    }

    public void findValuesInSearch(String text) {
        Waiters.waitForElementToBeDisplay(getAssignmentGridSearch());
        inputText(getAssignmentGridSearch(), text);
        pressEnter(getAssignmentGridSearch());
    }

    public void clearValueInSearch() {
        Waiters.waitForElementToBeDisplay(getAssignmentGridSearch());
        clear(getAssignmentGridSearch());
    }

    public void scrollToLoggedInUserTableEnd() {
        Waiters.waitABit(2000);
        WebElement el = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"))
                .get(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size()-1);
        Waiters.waitABit(2000);
        moveToElement(el);
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundValue);
    }

    public void clickUserIdColumnHeader() {
        Waiters.waitForElementToBeDisplay(userIdColumnHeader);
        clickOnElement(userIdColumnHeader);
    }

    public void clickUserNameColumnHeader() {
        Waiters.waitForElementToBeDisplay(userNameColumnHeader);
        clickOnElement(userNameColumnHeader);
    }

    public void clickComputerColumnHeader() {
        Waiters.waitForElementToBeDisplay(computerColumnHeader);
        clickOnElement(computerColumnHeader);
    }

    public void clickEquipmentColumnHeader() {
        Waiters.waitForElementToBeDisplay(equipmentColumnHeader);
        clickOnElement(equipmentColumnHeader);
    }

    public void clickPrinterColumnHeader() {
        Waiters.waitForElementToBeDisplay(printerColumnHeader);
        clickOnElement(printerColumnHeader);
    }

    public void clickLoginDateColumnHeader() {
        Waiters.waitForElementToBeDisplay(loginDateColumnHeader);
        clickOnElement(loginDateColumnHeader);
    }

    public void clickBreakDateColumnHeader() {
        Waiters.waitForElementToBeDisplay(breakDateColumnHeader);
        clickOnElement(breakDateColumnHeader);
    }

    public void clickLaborCodeColumnHeader() {
        Waiters.waitForElementToBeDisplay(laborCodeColumnHeader);
        clickOnElement(laborCodeColumnHeader);
    }

    public void clickAddFilter() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAddFilterButton());
        clickOnElement(getAddFilterButton());
    }

    public void checkUserIdFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getUserIdFilter());
        clickOnElement(getUserIdFilter());
    }

    public void checkUserNameFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getUserNameFilter());
        clickOnElement(getUserNameFilter());
    }

    public void checkComputerFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getComputerFilter());
        clickOnElement(getComputerFilter());
    }

    public void checkEquipmentFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getEquipmentFilter());
        clickOnElement(getEquipmentFilter());
    }

    public void clickClearAllButton() {
        Waiters.waitForElementToBeDisplay(getClearAllButton());
        clickOnElement(getClearAllButton());
    }

    public void typeFilter(String filter) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getInputContains());
        inputText(getInputContains(), filter);
    }

    public void clickApplyButton() {
        Waiters.waitForElementToBeDisplay(getApplyButton());
        clickOnElement(getApplyButton());
    }

    public void clickBtnRemove() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getBtnRemove());
        clickOnElement(getBtnRemove());
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public String getUserIdColumnHeaderSortingResult() {
        return getElementAttribute(getUserIdColumnHeader(), "aria-sort");
    }

    public String getUserNameColumnHeaderSortingResult() {
        return getElementAttribute(getUserNameColumnHeader(), "aria-sort");
    }

    public String getComputerColumnHeaderSortingResult() {
        return getElementAttribute(getComputerColumnHeader(), "aria-sort");
    }

    public String getEquipmentColumnHeaderSortingResult() {
        return getElementAttribute(getEquipmentColumnHeader(), "aria-sort");
    }

    public String getPrinterColumnHeaderSortingResult() {
        return getElementAttribute(getPrinterColumnHeader(), "aria-sort");
    }

    public String getLoginDateColumnHeaderSortingResult() {
        return getElementAttribute(getLoginDateColumnHeader(), "aria-sort");
    }

    public String getBreakDateColumnHeaderSortingResult() {
        return getElementAttribute(getBreakDateColumnHeader(), "aria-sort");
    }

    public String getLaborCodeColumnHeaderSortingResult() {
        return getElementAttribute(getLaborCodeColumnHeader(), "aria-sort");
    }

    public WebElement getLoggedInTitle() { return findWebElement(loggedInTitle); }

    public WebElement getUserIdColumn() { return findWebElement(userIdColumn); }

    public WebElement getUserIdColumnHeader() { return findWebElement(userIdColumnHeader); }

    public WebElement getUserNameColumn() { return findWebElement(userNameColumn); }

    public WebElement getUserNameColumnHeader() { return findWebElement(userNameColumnHeader); }

    public WebElement getComputerColumn() { return findWebElement(computerColumn); }

    public WebElement getComputerColumnHeader() { return findWebElement(computerColumnHeader); }

    public WebElement getEquipmentColumn() { return findWebElement(equipmentColumn); }

    public WebElement getEquipmentColumnHeader() { return findWebElement(equipmentColumnHeader); }

    public WebElement getPrinterColumn() { return findWebElement(printerColumn); }

    public WebElement getPrinterColumnHeader() { return findWebElement(printerColumnHeader); }

    public WebElement getLoginDateColumn() { return findWebElement(loginDateColumn); }

    public WebElement getLoginDateColumnHeader() { return findWebElement(loginDateColumnHeader); }

    public WebElement getBreakDateColumn() { return findWebElement(breakDateColumn); }

    public WebElement getBreakDateColumnHeader() { return findWebElement(breakDateColumnHeader); }

    public WebElement getLaborCodeColumn() { return findWebElement(laborCodeColumn); }

    public WebElement getLaborCodeColumnHeader() { return findWebElement(laborCodeColumnHeader); }

    public WebElement getAssignmentGridSearch() { return findWebElement(assignmentGridSearch); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getItemsFoundValue() { return findWebElement(itemsFoundValue); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getUserIdFilter() { return findWebElement(userIdFilter); }

    public WebElement getUserNameFilter() { return findWebElement(userNameFilter); }

    public WebElement getComputerFilter() { return findWebElement(computerFilter); }

    public WebElement getEquipmentFilter() { return findWebElement(equipmentFilter); }

    public WebElement getPrinterCodeFilter() { return findWebElement(printerCodeFilter); }

    public WebElement getLoginDateTimeFilter() { return findWebElement(loginDateTimeFilter); }

    public WebElement getBreakDateTimeFilter() { return findWebElement(breakDateTimeFilter); }

    public WebElement getLaborCodeFilter() { return findWebElement(laborCodeFilter); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getClearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getInputContains() { return findWebElement(inputContains); }

    public WebElement getApplyButton() { return findWebElement(applyButton); }

    public WebElement getBtnRemove() { return findWebElement(btnRemove); }

    public WebElement getLogOutUserPopUpTitle() { return findWebElement(logOutUserPopUpTitle); }

    public WebElement getLogoutUserDropdown() {  return findWebElement(logoutUserDropdown); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
