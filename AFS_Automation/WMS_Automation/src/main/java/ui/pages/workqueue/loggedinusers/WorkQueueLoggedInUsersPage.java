package ui.pages.workqueue.loggedinusers;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

import static common.setup.DriverManager.getDriver;

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
    By loggedInUserGridSearch = By.id("LoggedInUserGridSearch");
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
    By loader = By.cssSelector(".loader");

    public void waitWorkQueueLoggedInUsersPageToLoad() {
        waitUntilInvisible(5, loader);
        Waiters.waitForElementToBeDisplay(getLoggedInTitle());
        Waiters.waitForElementToBeDisplay(getUserIdColumn());
        Waiters.waitForElementToBeDisplay(getUserNameColumn());
        Waiters.waitForElementToBeDisplay(getComputerColumn());
        Waiters.waitForElementToBeDisplay(getEquipmentColumn());
    }

    public boolean isLoggedInTitleDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLoggedInTitle());
    }

    public boolean isUserIdColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getUserIdColumn());
    }

    public boolean isUserNameColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getUserNameColumn());
    }

    public boolean isComputerColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getComputerColumn());
    }

    public boolean isEquipmentColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getEquipmentColumn());
    }

    public boolean isPrinterColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getPrinterColumn());
    }

    public boolean isLoginDateColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLoginDateColumn());
    }

    public boolean isBreakDateColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getBreakDateColumn());
    }

    public boolean isLaborCodeColumnDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLaborCodeColumn());
    }

    public boolean isTableContentDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getTableContent());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getItemsFoundLabel());
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getItemsFoundValue());
    }

    public boolean isTableEndIsDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        WebElement el = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"))
                .get(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size()-1);
        return isElementDisplay(el);
    }

    public boolean isUserIdFilterDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getUserIdFilter());
        return isElementDisplay(getUserIdFilter());
    }

    public boolean isUserNameFilterDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getUserIdFilter());
        return isElementDisplay(getUserNameFilter());
    }

    public boolean isComputerFilterDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getUserIdFilter());
        return isElementDisplay(getComputerFilter());
    }

    public boolean isEquipmentFilterDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getUserIdFilter());
        return isElementDisplay(getEquipmentFilter());
    }

    public boolean isPrinterCodeFilterDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getUserIdFilter());
        return isElementDisplay(getPrinterCodeFilter());
    }

    public boolean isLoginDateTimeFilterDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getUserIdFilter());
        return isElementDisplay(getLoginDateTimeFilter());
    }

    public boolean isBreakDateTimeFilterDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getUserIdFilter());
        return isElementDisplay(getBreakDateTimeFilter());
    }

    public boolean isLaborCodeFilterDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getUserIdFilter());
        return isElementDisplay(getLaborCodeFilter());
    }

    public boolean isLogOutUserLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getBtnRemove());
    }

    public boolean isOKButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(okButton);
    }

    public boolean isCancelButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(cancelButton);
    }

    public boolean isLogOutUserPopUpTitleDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLogOutUserPopUpTitle());
    }

    public void clickLogoutUserDropdown() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getLogoutUserDropdown());
    }

    public void selectLogoutUserReason(String reason) {
        clickOnElement(getLogoutUserDropdown());
        WebElement option = findWebElement(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option' and contains(text(), '"
                        + reason + "')]"));
        clickOnElement(option);
        waitUntilInvisible(2, loader);
    }

    public void clickOK() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(okButton);
    }

    public void clickCancel() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(cancelButton);
    }

    public void clickLogoutUserLabel() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getBtnRemove());
    }

    public boolean isLogOutUserLabelDisabled() {
        Waiters.waitTillLoadingPage(getDriver());
        return getElementAttribute(getBtnRemove(), "class").contains("disabled");
    }

    public List<WebElement> getLoggedInUsersTableRows() {
        Waiters.waitTillLoadingPage(getDriver());
        return getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
    }

    public int getLoggedInUsersTableRowsSize() {
        Waiters.waitTillLoadingPage(getDriver());
        return getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size();
    }

    public void clickOnLoggedInUserByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        List<WebElement> rows = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
        clickOnElement(rows.get(index));
    }

    public void findValuesInSearch(String text) {
        Waiters.waitForElementToBeDisplay(getAssignmentGridSearch());
        inputText(getAssignmentGridSearch(), text);
        pressEnter(getAssignmentGridSearch());
        waitUntilInvisible(2, loader);
    }

    public void findValuesInLoggedInUserGridSearch(String text) {
        Waiters.waitForElementToBeDisplay(getLoggedInUserGridSearch());
        inputText(getLoggedInUserGridSearch(), text);
        pressEnter(getLoggedInUserGridSearch());
        waitUntilInvisible(2, loader);
    }

    public void clearValueInSearch() {
        Waiters.waitForElementToBeDisplay(getAssignmentGridSearch());
        clear(getAssignmentGridSearch());
    }

    public void scrollToLoggedInUserTableEnd() {
        Waiters.waitTillLoadingPage(getDriver());
        WebElement el = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"))
                .get(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).size()-1);
        Waiters.waitTillLoadingPage(getDriver());
        moveToElement(el);
    }

    public String getItemsFoundText() {
        Waiters.waitTillLoadingPage(getDriver());
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
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAddFilterButton());
        clickOnElement(getAddFilterButton());
    }

    public void checkUserIdFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getUserIdFilter());
        clickOnElement(getUserIdFilter());
    }

    public void checkUserNameFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getUserNameFilter());
        clickOnElement(getUserNameFilter());
    }

    public void checkComputerFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getComputerFilter());
        clickOnElement(getComputerFilter());
    }

    public void checkEquipmentFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEquipmentFilter());
        clickOnElement(getEquipmentFilter());
    }

    public void clickClearAllButton() {
        Waiters.waitForElementToBeDisplay(getClearAllButton());
        clickOnElement(getClearAllButton());
    }

    public void typeFilter(String filter) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getInputContains());
        inputText(getInputContains(), filter);
    }

    public void clickApplyButton() {
        Waiters.waitForElementToBeDisplay(getApplyButton());
        clickOnElement(getApplyButton());
    }

    public void clickBtnRemove() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getBtnRemove());
        clickOnElement(getBtnRemove());
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        waitUntilInvisible(1, loader);
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

    public WebElement getLoggedInUserGridSearch() { return findWebElement(loggedInUserGridSearch); }

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
