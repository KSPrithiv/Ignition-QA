package ui.pages.lookup.lookuplabel;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import static common.setup.DriverManager.getDriver;

public class LabelLookupPage extends BasePage {
    By labelLookupTitle = By.className("spnmoduleNameHeader");
    By shippingLabel = By.xpath("//label[text()='Shipping']");
    By unitLabel = By.xpath("//label[text()='Unit']");
    By palletLabel = By.xpath("//label[text()='Pallet']");
    By locationLabel = By.xpath("//label[text()='Location']");
    By receivingUnitLabel = By.xpath("//label[text()='Receiving Unit']");
    By productLabel = By.xpath("//label[text()='Product']");
    By pickingLabel = By.xpath("//label[text()='Picking']");
    By outboundReportLabel = By.xpath("//label[text()='Outbound Report']");
    By dialogTitle = By.cssSelector(".k-dialog-title");
    By labelTypeLabel = By.xpath("//label[text()='Label type']");
    By unitInput = By.cssSelector("input[value='Unit']");
    By labelFormatLabel = By.xpath("//label[text()='Label format']");
    By labelFormatDropDown = By.xpath("//label[text()='Label format']/following-sibling::span");
    By labelNumLabel = By.xpath("//label[text()='Label #']");
    By labelNumLInput = By.xpath("//label[text()='Label #']/following-sibling::span");
    By productIndexLabel = By.cssSelector("#indexProductIndex-label");
    By productIndexInput= By.cssSelector("span[data-test-id='lookup_UnitTypeDialog_product_autocomplete']");

    By fromLocationLabel = By.xpath("//label[text()='From location']");
    By enterFromLocation= By.cssSelector("input[placeholder='Enter from location']");
    By toLocationLabel = By.xpath("//label[text()='To location']");
    By enterTomLocation= By.cssSelector("input[placeholder='Enter to location']");

    By printLabelCancelBtn = By.cssSelector("button[data-test-id='lookup_UnitTypeDialog_dialogCancelBtn']");
    By printLabelPrintBtn = By.cssSelector("button[data-test-id='lookup_UnitTypeDialog_dialogPrintBtn']");
    By loader = By.cssSelector(".loader");

    public void waitForLabelLookupPageToLoad() {
        waitUntilInvisible(5, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(labelLookupTitle);
        Waiters.waitForElementToBeDisplay(shippingLabel);
        Waiters.waitForElementToBeDisplay(unitLabel);
    }

    public void clickShippingLabel() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(shippingLabel);
        clickOnElement(shippingLabel);
    }

    public void clickUnitLabel() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(unitLabel);
        clickOnElement(unitLabel);
    }

    public void clickPalletLabel() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(palletLabel);
        clickOnElement(palletLabel);
    }

    public void clickLocationLabel() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(locationLabel);
        clickOnElement(locationLabel);
    }

    public void clickReceivingUnitLabel() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(receivingUnitLabel);
        clickOnElement(receivingUnitLabel);
    }

    public void clickProductLabel() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(productLabel);
        clickOnElement(productLabel);
    }

    public void clickPickingLabel() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(pickingLabel);
        clickOnElement(pickingLabel);
    }

    public void clickOutboundReportLabel() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(outboundReportLabel);
        clickOnElement(outboundReportLabel);
    }

    public void clickPrintLabelCancelBtn() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getPrintLabelCancelBtn());
        clickOnElement(getPrintLabelCancelBtn());
    }

    public void clickPrintLabelPrintBtn() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getPrintLabelPrintBtn());
        clickOnElement(getPrintLabelPrintBtn());
    }

    public boolean isLabelLookupTitleDisplayed() {
        Waiters.waitForElementToBeDisplay(getLabelLookupTitle());
        return isElementDisplay(getLabelLookupTitle());
    }

    public boolean isShippingLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getShippingLabel());
        return isElementDisplay(getShippingLabel());
    }

    public boolean isUnitLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getUnitLabel());
        return isElementDisplay(getUnitLabel());
    }

    public boolean isPalletLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getPalletLabel());
        return isElementDisplay(getPalletLabel());
    }

    public boolean isLocationLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLocationLabel());
        return isElementDisplay(getLocationLabel());
    }

    public boolean isReceivingUnitLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getReceivingUnitLabel());
        return isElementDisplay(getReceivingUnitLabel());
    }

    public boolean isProductLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getProductLabel());
        return isElementDisplay(getProductLabel());
    }

    public boolean isPickingLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getPickingLabel());
        return isElementDisplay(getPickingLabel());
    }

    public boolean isOutboundReportLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getOutboundReportLabel());
        return isElementDisplay(getOutboundReportLabel());
    }

    public boolean isLabelTypeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLabelTypeLabel());
        return isElementDisplay(getLabelTypeLabel());
    }

    public boolean isUnitInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getUnitInput());
        return isElementDisplay(getUnitInput());
    }

    public boolean isLabelFormatLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLabelFormatLabel());
        return isElementDisplay(getLabelFormatLabel());
    }

    public boolean isLabelFormatDropDownDisplayed() {
        Waiters.waitForElementToBeDisplay(getLabelFormatDropDown());
        return isElementDisplay(getLabelFormatDropDown());
    }

    public boolean isLabelNumLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLabelNumLabel());
        return isElementDisplay(getLabelNumLabel());
    }

    public boolean isLabelNumLInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getLabelNumLInput());
        return isElementDisplay(getLabelNumLInput());
    }

    public boolean isProductIndexLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getProductIndexLabel());
        return isElementDisplay(getProductIndexLabel());
    }

    public boolean isProductIndexInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getProductIndexInput());
        return isElementDisplay(getProductIndexInput());
    }

    public boolean isPrintLabelCancelBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getPrintLabelCancelBtn());
        return isElementDisplay(getPrintLabelCancelBtn());
    }

    public boolean isPrintLabelPrintBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getPrintLabelPrintBtn());
        return isElementDisplay(getPrintLabelPrintBtn());
    }

    public WebElement getLabelLookupTitle() { return findWebElement(labelLookupTitle); }

    public WebElement getShippingLabel() { return findWebElement(shippingLabel); }

    public WebElement getUnitLabel() { return findWebElement(unitLabel); }

    public WebElement getPalletLabel() { return findWebElement(palletLabel); }

    public WebElement getLocationLabel() { return findWebElement(locationLabel); }

    public WebElement getReceivingUnitLabel() { return findWebElement(receivingUnitLabel); }

    public WebElement getProductLabel() { return findWebElement(productLabel); }

    public WebElement getPickingLabel() { return findWebElement(pickingLabel); }

    public WebElement getOutboundReportLabel() { return findWebElement(outboundReportLabel); }

    public WebElement getDialogTitle() { return findWebElement(dialogTitle); }

    public WebElement getLabelTypeLabel() { return findWebElement(labelTypeLabel); }

    public WebElement getUnitInput() { return findWebElement(unitInput); }

    public WebElement getLabelFormatLabel() { return findWebElement(labelFormatLabel); }

    public WebElement getLabelFormatDropDown() { return findWebElement(labelFormatDropDown); }

    public WebElement getLabelNumLabel() { return findWebElement(labelNumLabel); }

    public WebElement getLabelNumLInput() { return findWebElement(labelNumLInput); }

    public WebElement getProductIndexLabel() { return findWebElement(productIndexLabel); }

    public WebElement getProductIndexInput() { return findWebElement(productIndexInput); }

    public WebElement getPrintLabelCancelBtn() { return findWebElement(printLabelCancelBtn); }

    public WebElement getPrintLabelPrintBtn() { return findWebElement(printLabelPrintBtn); }

    public WebElement getLoader() { return findWebElement(loader); }

}
