package ui.pages.inbound.inboundorders;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

public class InboundOrderLocationLookupPage extends BasePage {

    By topIcon = By.xpath("//span[contains(text(), 'Location lookup')]");
    By locationSearchACField = By.id("locationSearchACField-label");
    By locationInput = By.cssSelector("input[placeholder='Enter location']");
    By locationButton = By.xpath("//div[@id='locationGrid']//button[contains(@class, 'i-indexfield-container')]");
    By addLocProdButton = By.id("addLocProdButton");
    By editButton = By.xpath("//button[contains(text(), 'Edit')]");
    By deleteButton = By.xpath("//button[contains(text(), 'Delete')]");
    By transferButton = By.xpath("//button[contains(text(), 'Transfer')]");
    By statusButton = By.xpath("//button[contains(text(), 'Status')]");
    By labelsButton = By.xpath("//button[contains(text(), 'Labels')]");
    By palletColumn = By.xpath("//span[text()='Pallet']");
    By productColumn = By.xpath("//span[text()='Product']");
    By descriptionColumn = By.xpath("//span[text()='Description']");
    By qtyColumn = By.xpath("//span[text()='Qty']");
    By uomColumn = By.xpath("//span[text()='UOM']");
    By lotColumn = By.xpath("//span[text()='Lot']");
    By expDateColumn = By.xpath("//span[text()='Exp Date']");
    By weightColumn = By.xpath("//span[text()='Weight']");
    By ownerColumn = By.xpath("//span[text()='Owner']");
    By palletsLabel = By.xpath("//span[text()='Pallets:']");
    By quantityLabel = By.xpath("//span[text()='Quantity:']");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By lookupLocationSearch = By.id("lookupLocationSearch");
    By gridTable = By.cssSelector(".k-grid-table tr");

    public void waitForInboundOrderLocationLookupPageToLoad() {
        Waiters.waitABit(10000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTopIcon());
        Waiters.waitForElementToBeDisplay(addLocProdButton);
        Waiters.waitForElementToBeDisplay(editButton);
        Waiters.waitForElementToBeDisplay(deleteButton);
        Waiters.waitForElementToBeDisplay(transferButton);
        Waiters.waitForElementToBeDisplay(statusButton);
        Waiters.waitForElementToBeDisplay(labelsButton);
    }

    public boolean isTopIconPresent() {
        return isElementPresent(getTopIcon());
    }

    public boolean isLocationSearchACFieldPresent() {
        return isElementPresent(getLocationSearchACField());
    }

    public boolean isLocationInputDisplayed() {  return isElementDisplay(getLocationInput());  }

    public boolean isLocationButtonDisplayed() {  return isElementDisplay(getLocationButton());  }

    public boolean isAddLocProdButtonDisplayed() { return isElementDisplay(getAddLocProdButton()); }

    public boolean isEditButtonDisplayed() { return isElementDisplay(getEditButton()); }

    public boolean isDeleteButtonDisplayed() {  return isElementDisplay(getDeleteButton()); }

    public boolean isTransferButtonDisplayed() { return isElementDisplay(getTransferButton()); }

    public boolean isStatusButtonDisplayed() {  return isElementDisplay(getStatusButton()); }

    public boolean isLabelsButtonDisplayed() { return isElementDisplay(getLabelsButton()); }

    public boolean isPalletColumnDisplayed() { return isElementDisplay(getPalletColumn()); }

    public boolean isProductColumnDisplayed() {  return isElementDisplay(getProductColumn());  }

    public boolean isDescriptionColumnDisplayed() { return isElementDisplay(getDescriptionColumn()); }

    public boolean isQtyColumnDisplayed() { return isElementDisplay(getQtyColumn()); }

    public boolean isUomColumnDisplayed() { return isElementDisplay(getUomColumn()); }

    public boolean isLotColumnDisplayed() { return isElementDisplay(getLotColumn()); }

    public boolean isExpDateColumnDisplayed() { return isElementDisplay(getExpDateColumn()); }

    public boolean isWeightColumnDisplayed() { return isElementDisplay(getWeightColumn()); }

    public boolean isOwnerColumnDisplayed() { return isElementDisplay(getOwnerColumn()); }

    public boolean isPalletsLabelDisplayed() { return isElementDisplay(getPalletsLabel()); }

    public boolean isQuantityLabelDisplayed() { return isElementDisplay(getQuantityLabel()); }

    public boolean isItemsFoundLabelDisplayed() { return isElementDisplay(getItemsFoundLabel()); }

    public boolean isLookupLocationSearchDisplayed() { return isElementDisplay(getLookupLocationSearch()); }

    public int isLookupLocationGridTableDisplayed() { return elementsArePresent(getLookupLocationGridTable()); }

    public WebElement getTopIcon() { return findWebElement(topIcon); }

    public WebElement getLocationSearchACField() { return findWebElement(locationSearchACField); }

    public WebElement getLocationInput() { return findWebElement(locationInput); }

    public WebElement getLocationButton() { return findWebElement(locationButton); }

    public WebElement getAddLocProdButton() { return findWebElement(addLocProdButton); }

    public WebElement getEditButton() { return findWebElement(editButton); }

    public WebElement getDeleteButton() { return findWebElement(deleteButton); }

    public WebElement getTransferButton() { return findWebElement(transferButton); }

    public WebElement getStatusButton() { return findWebElement(statusButton); }

    public WebElement getLabelsButton() { return findWebElement(labelsButton); }

    public WebElement getPalletColumn() { return findWebElement(palletColumn); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getUomColumn() { return findWebElement(uomColumn); }

    public WebElement getLotColumn() { return findWebElement(lotColumn); }

    public WebElement getExpDateColumn() { return findWebElement(expDateColumn); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getOwnerColumn() { return findWebElement(ownerColumn); }

    public WebElement getPalletsLabel() { return findWebElement(palletsLabel); }

    public WebElement getQuantityLabel() { return findWebElement(quantityLabel); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getLookupLocationSearch() { return findWebElement(lookupLocationSearch); }

    public List<WebElement> getLookupLocationGridTable() { return findWebElements(gridTable); }

}
