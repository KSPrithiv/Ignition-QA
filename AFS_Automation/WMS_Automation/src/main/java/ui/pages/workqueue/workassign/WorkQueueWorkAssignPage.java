package ui.pages.workqueue.workassign;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

import static common.setup.DriverManager.getDriver;

public class WorkQueueWorkAssignPage extends BasePage {
    By taskGroupTitle = By.xpath("//span[contains(text(), 'Task group')]");
    By taskGroupDropdown = By.id("wqListTaskGroup");
    By addFilterButton = By.xpath("//span[contains(text(), 'Add filter')]");
    By assignWorkUserForm = By.id("assignWorkUserForm");
    By saveEditButton = By.id("saveEditButton");
    By cancelEditButton = By.id("cancelEditButton");
    By wmUserHeader = By.id("wmUserHeader");
    By wmUserGrpHeader = By.id("wmUserGrpHeader");
    By wqUserFormDivUserList = By.xpath("//div[@id='wqUserFormDivUser']//div[contains(@class, 'i-btn-checkbox')]");
    By wqUserFormDivUserGroupList = By.xpath("//div[@id='wqUserFormDivUserGroup']//div[contains(@class, 'i-btn-checkbox')]");
    By notificationMsg = By.cssSelector(".toast-message");
    By userGroupCheckbox  = By.id("Description");
    By adminUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'A')]");
    By buyersUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'B')]");
    By defaultUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'D')]");
    By freezerUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'F')]");
    By managersUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'M')]");
    By operatorsUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'O')]");
    By clearAllButton = By.xpath("//button[text()='Clear all']");
    By dropdownList = By.id("dropdownList");
    By loader = By.cssSelector(".loader");

    private WebElement getUserByUserName(String name) {
        return findWebElement(By.xpath("//label[contains(text(), '" + name + "')]//preceding-sibling::input[@type='checkbox']"));
    }

    public WebElement getTaskGroupDropdownValue(String taskGroup) {
        return findWebElement(By.xpath("//span[contains(text(), '" + taskGroup + "')]"));
    }

    public void waitWorkQueueWorkAssignPageToLoad() {
        waitUntilInvisible(5, loader);
        Waiters.waitForElementToBeDisplay(getTaskGroupTitle());
        Waiters.waitForElementToBeDisplay(getSaveEditButton());
        Waiters.waitForElementToBeDisplay(getCancelEditButton());
    }

    public void selectWarehouse(String warehouse) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOnTaskGroup() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTaskGroupDropdown());
        clickOnElement(getTaskGroupDropdown());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectTaskGroup(String option) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTaskGroupDropdown());
        clickOnElement(getTaskGroupDropdown());
        WebElement taskGroupOption = findWebElement(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@class='k-item' and contains(text(), '"
                + option + "')]"));
        clickOnElement(taskGroupOption);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickSaveEditButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTaskGroupDropdown());
        clickOnElement(getSaveEditButton());
    }

    public void clickCancelEditButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getCancelEditButton());
        clickOnElement(getCancelEditButton());
    }

    public void clickFilterButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAddFilterButton());
        clickOnElement(getAddFilterButton());
    }

    public void clickUserGroupCheckbox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(userGroupCheckbox);
        clickOnElement(userGroupCheckbox);
    }

    public void clickClearAllButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getClearAllButton());
        clickOnElement(getClearAllButton());
    }

    public void checkUserByName(String name) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getUserByUserName(name));
        clickOnElement(getUserByUserName(name));
    }

    public void checkAdminUserGroup() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(adminUserGroup);
        clickOnElement(adminUserGroup);
    }

    public void checkBuyersUserGroup() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(buyersUserGroup);
        clickOnElement(buyersUserGroup);
    }

    public void checkDefaultUserGroup() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(defaultUserGroup);
        clickOnElement(defaultUserGroup);
    }

    public void checkFreezerUserGroup() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(freezerUserGroup);
        clickOnElement(freezerUserGroup);
    }

    public void checkManagersUserGroup() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(managersUserGroup);
        clickOnElement(managersUserGroup);
    }

    public void checkOperatorsUserGroup() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(operatorsUserGroup);
        clickOnElement(operatorsUserGroup);
    }

    public boolean isTaskGroupTitleDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getTaskGroupTitle());
    }

    public boolean isTaskGroupDropdownDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getTaskGroupDropdown());
    }

    public boolean isAddFilterButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getAddFilterButton());
    }

    public boolean isAssignWorkUserFormDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getAssignWorkUserForm());
    }

    public boolean isSaveEditButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getSaveEditButton());
    }

    public boolean isCancelEditButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getCancelEditButton());
    }

    public boolean isWmUserHeaderDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isVisible(wmUserHeader);
    }

    public boolean isWmUserGrpHeaderDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isVisible(wmUserGrpHeader);
    }

    public WebElement getTaskGroupTitle() { return findWebElement(taskGroupTitle); }

    public WebElement getTaskGroupDropdown() { return findWebElement(taskGroupDropdown); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getAssignWorkUserForm() { return findWebElement(assignWorkUserForm); }

    public WebElement getSaveEditButton() { return findWebElement(saveEditButton); }

    public WebElement getCancelEditButton() { return findWebElement(cancelEditButton); }

    public WebElement getWmUserHeader() { return findWebElement(wmUserHeader); }

    public WebElement getWmUserGrpHeader() { return findWebElement(wmUserGrpHeader); }

    public List<WebElement> getWqUserFormDivUserList() { return findWebElements(wqUserFormDivUserList); }

    public List<WebElement> getWqUserFormDivUserGroupList() { return findWebElements(wqUserFormDivUserGroupList); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getClearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
