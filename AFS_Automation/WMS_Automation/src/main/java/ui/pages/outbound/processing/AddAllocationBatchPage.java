package ui.pages.outbound.processing;

import common.utils.Waiters;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import static common.setup.DriverManager.getDriver;

public class AddAllocationBatchPage extends BasePage {
    private static String batchName = null;
    By addBatchTitle = By.cssSelector(".k-window-title");
    By codeLabel = By.cssSelector("#txtBatchCode-label");
    By codeInput = By.cssSelector("#txtBatchCode");
    By batchLabel = By.cssSelector("#ddlBatchType-label");
    By batchInput = By.cssSelector("#ddlBatchType");
    By cancelButton = By.xpath("//span[contains(text(), 'Cancel')]");
    By saveButton = By.xpath("//span[contains(text(), 'Save')]");
    By notificationTitle = By.cssSelector(".toast-title");
    By notificationMessage = By.cssSelector(".toast-message");
    By loader = By.cssSelector(".loader");

    public void waitAddAllocationBatchPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getBatchLabel());
        Waiters.waitForElementToBeDisplay(getBatchInput());
    }

    public String getTitle() {
        Waiters.waitForElementToBeClickable(getAddBatchTitle());
        return getAddBatchTitle().getText().trim();
    }

    public String getNotificationTitleText() {
        Waiters.waitForElementToBeDisplay(By.cssSelector(".toast-title"));
        return getNotificationTitle().getText().trim();
    }

    public String getNotificationMessageText() {
        Waiters.waitForElementToBeDisplay(By.cssSelector(".toast-message"));
        return getNotificationMessage().getText().trim();
    }

    public void clickBatchType() {
       Waiters.waitForElementToBeDisplay(getBatchInput());
       Waiters.waitABit(1000);
       clickOnElement(getBatchInput());
    }

    public void selectBatchType(String type) {
        Waiters.waitTillLoadingPage(getDriver());
        clickBatchType();
        Waiters.waitABit(2000);
        WebElement option = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + type + "')]"));
        clickOnElement(option);
    }

    public static void generateBatchName(int length, boolean lettersInclude, boolean numbersInclude) {
        batchName = RandomStringUtils.random(length, lettersInclude, numbersInclude);
    }

    public static String getBatchName() { return batchName; }

    public void typeBatchCode(CharSequence text) {
        Waiters.waitForElementToBeDisplay(getCodeInput());
        inputText(getCodeInput(), text);
    }

    public String getBatchCodeValue() {
        Waiters.waitForElementToBeDisplay(getCodeInput());
        return getValue(codeInput);
    }

    public void clickSaveButton() {
        Waiters.waitForElementToBeDisplay(getSaveButton());
        jsClick(getSaveButton());
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeClickable(getCancelButton());
        clickOnElement(getCancelButton());
    }

    public boolean isBatchTypeDropDownDisplayed(String batchType) {
        WebElement dropdownOption = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + batchType + "')]"));               
        return isElementDisplay(dropdownOption);
    }

    public boolean isCodeLabelDisplayed() { return isElementDisplay(getCodeLabel()); }

    public boolean isCodeInputDisplayed() { return isElementDisplay(getCodeInput()); }

    public boolean isBatchLabelDisplayed() { return isElementDisplay(getBatchLabel()); }

    public boolean isBatchInputDisplayed() { return isElementDisplay(getBatchInput()); }

    public boolean isCancelButtonDisplayed() { return isElementDisplay(getCancelButton()); }

    public boolean isSaveButtonDisplayed() { return isElementDisplay(getSaveButton()); }

    public WebElement getAddBatchTitle() { return findWebElement(addBatchTitle); }

    public WebElement getCodeLabel() { return findWebElement(codeLabel); }

    public WebElement getCodeInput() { return findWebElement(codeInput); }

    public WebElement getBatchLabel() { return findWebElement(batchLabel); }

    public WebElement getBatchInput() { return findWebElement(batchInput); }

    public WebElement getCancelButton() { return findWebElement(cancelButton); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getNotificationTitle() { return findWebElement(notificationTitle); }

    public WebElement getNotificationMessage() { return findWebElement(notificationMessage); }
}
