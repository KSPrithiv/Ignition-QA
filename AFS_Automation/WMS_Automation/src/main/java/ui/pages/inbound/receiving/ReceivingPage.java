package ui.pages.inbound.receiving;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

import static common.setup.DriverManager.getDriver;

public class ReceivingPage extends BasePage {

    By topIcon = By.xpath("//span[contains(text(), 'Receiving')]");
    By backButton = By.cssSelector("#RouteBackButton");
    By nextButton = By.xpath("//button[contains(text(), 'Next')]");
    By okButton = By.xpath("//button[contains(text(), 'Ok')]");
    By qtyInput = By.cssSelector("input[placeholder='Enter quantity']");
    By lotInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[text()='Lot']]//input");
    By gtinInput = By.cssSelector("input[placeholder='Enter gtin']");
    By expDate = By.id("ExpDate");
    By uomLabel = By.id("ddlUOM-label");
    By uomDropDown = By.id("ddlUOM");
    By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    By noButton = By.xpath("//button[contains(text(), 'No')]");
    By reviewButton = By.xpath("//button[contains(text(), 'Review')]");
    By receiveButton = By.xpath("//button[contains(text(), 'Receive')]");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By deleteButton = By.id("btnStageDelete");
    By orderLabel = By.xpath("//label[text()='Order']");
    By orderInput = By.xpath("//label[text()='Order']//..//input");
    By loadLabel = By.cssSelector("#routeSearchBar-label");
    By loadInput = By.cssSelector("#routeSearchBar");
    By dockDoorLabel = By.cssSelector("#ddlDockDoor-label");
    By dockDoorDropdown = By.cssSelector("#ddlDockDoor");
    By statusLabel = By.cssSelector("#ddlStatus-label");
    By statusDropdown = By.cssSelector("#ddlStatus");
    By locationLabel = By.xpath("//label[text()='Location']");
    By locationInput = By.cssSelector("input[placeholder='Enter location']");
    By palletColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Pallets']");
    By productColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Product']");
    By descriptionColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Description']");
    By qtyColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Qty']");
    By uomColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Uom']");
    By lotColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Lot']");
    By expDateColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Expiration date']");
    By weightColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Weight']");
    By customerColumn = By.xpath("//div[@class='k-grid-header-wrap']//span[text()= 'Customer']");
    By tableContent = By.cssSelector(".k-grid-table");
    By dialogTextContent = By.id("dialogTextContent");
    By dialogTitle = By.cssSelector(".k-dialog-title");
    By palletsLabel = By.xpath("//span[contains(text(), 'Pallets')]");
    By palletsValue = By.xpath("//span[contains(text(), 'Pallets')]//following-sibling::span[@class='i-summary-area__main__value']");
    By totalQtyLabel = By.xpath("//span[contains(text(), 'Total qty')]");
    By totalQtyValue = By.xpath("//span[contains(text(), 'Total qty')]//following-sibling::span[@class='i-summary-area__main__value']");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By allPalletsCheckBox = By.xpath("//*[contains(@class, 'i-grid-checkbox-header')]//input");
    By loadsList = By.xpath("//div[contains(@class, 'k-window-content')]//tr");
    By dropdownList = By.id("dropdownList");
    By txtAddProductLPNLabel = By.id("txtAddProductLPN-label");
    By txtAddProductLPN = By.id("txtAddProductLPN");
    By searchProductListLabel = By.id("searchProductList-label");
    By searchProductList = By.id("searchProductList");
    By clearProduct = By.cssSelector(".k-clear-value");
    By invalidEntryTitle = By.xpath("//div[contains(text(), 'Invalid entry')]");
    By loader = By.cssSelector(".loader");

    public void waitReceivingPageToLoad() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitUntilPageWillLoadedSelenide();
        if(getInvalidEntryTitle() != null) {
            clickOkButton();
        }
        Waiters.waitForElementToBeDisplay(getIconReceiving());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public boolean isTopIconDisplayed() { return isElementDisplay(getIconReceiving()); }

    public boolean isOrderLabelPresent() { return isElementPresent(By.xpath("//label[text()='Order']")); }

    public boolean isOrderInputPresent() { return isElementPresent(By.xpath("//label[text()='Order']//..//input")); }

    public boolean isLoadLabelPresent() { return isElementDisplay(By.cssSelector("#routeSearchBar-label")); }

    public boolean isLoadInputPresent() {
        return isElementPresent(By.cssSelector("#routeSearchBar"));
    }

    public boolean isDoorLabelPresent() {
        return isElementDisplay(By.cssSelector("#ddlDockDoor-label"));
    }

    public boolean isDoorInputPresent() {
        return isElementPresent(By.cssSelector("#ddlDockDoor"));
    }

    public boolean isBackButtonOnStagePresent() {
        return isElementPresent(By.cssSelector("#btnStageBack"));
    }

    public boolean isStatusLabelDisplayed() {
        return isElementDisplay(getStatusLabel());
    }

    public boolean isStatusDropdownDisplayed() {
        return isElementPresent(getStatusDropdown());
    }

    public boolean isLocationLabelPresent() { return isElementDisplay(getLocationLabel());  }

    public boolean isLocationInputPresent() { return isElementPresent(getLocationInput()); }

    public boolean isBackButtonClickable() { return isElementClickable(By.cssSelector("#RouteBackButton")); }

    public boolean isYesButtonDisplayed() { return isElementDisplay(getYesButton()); }

    public boolean isNoButtonDisplayed() { return isElementDisplay(getNoButton()); }

    public boolean isReceiveButtonDisplayed() {
        return isElementDisplay(getReceiveButton());
    }

    public boolean isBackButtonOnStageDisplayed() { return isElementDisplay(By.cssSelector("#btnStageBack")); }

    public boolean isReceiveButtonOnStageDisplayed() {
        return isElementDisplay(By.cssSelector("#btnStageReceive"));
    }

    public boolean isCancelButtonOnStageDisplayed() {
        return isElementDisplay(By.cssSelector("#btnStageCancel"));
    }

    public boolean isNextButtonOnStageDisplayed() {
        return isElementDisplay(By.cssSelector("#btnStageNext"));
    }

    public boolean isDeleteButtonOnStageDisplayed() {
        return isElementDisplay(By.cssSelector("#btnStageDelete"));
    }

    public boolean isQtyInputDisplayed() { return isElementDisplay(getQtyInput()); }

    public boolean isUomLabelDisplayed() { return isElementDisplay(getUomLabel()); }

    public boolean isUomDropDownDisplayed() { return isElementDisplay(getUomDropDown()); }

    public boolean isGtinInputDisplayed() {
        return isElementDisplay(getGtinInput());
    }

    public boolean isExpDateInputDisplayed() { return isElementDisplay(getExpDateInput()); }

    public boolean isPalletColumnDisplayed() { return isElementDisplay(getPalletColumn()); }

    public boolean isProductColumnDisplayed() { return isElementDisplay(getProductColumn()); }

    public boolean isDescriptionColumnDisplayed() { return isElementDisplay(getDescriptionColumn()); }

    public boolean isQtyColumnDisplayed() { return isElementDisplay(getQtyColumn()); }

    public boolean isUomColumnDisplayed() { return isElementDisplay(getUomColumn()); }

    public boolean isLotColumnDisplayed() { return isElementDisplay(getLotColumn()); }

    public boolean isExpDateColumnDisplayed() { return isElementDisplay(getExpDateColumn()); }

    public boolean isWeightColumnDisplayed() {  return isElementDisplay(getWeightColumn()); }

    public boolean isCustomerColumnDisplayed() { return isElementDisplay(getCustomerColumn()); }

    public boolean isPalletsLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getPalletsLabel());
    }

    public boolean isPalletsValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getPalletsValue());
    }

    public boolean isTotalQtyLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTotalQtyLabel());
    }

    public boolean isTotalQtyValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTotalQtyValue());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getItemsFoundLabel());
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getItemsFoundValue());
    }

    public void clickBackButton() {
        Waiters.waitForElementToBeDisplay(By.cssSelector("#RouteBackButton"));
        clickOnElement(By.cssSelector("#RouteBackButton"));
    }

    public void clickNextButton() {
        Waiters.waitForElementToBeClickable(getNextButton());
        clickOnElement(getNextButton());
        Waiters.waitABit(2000);
    }

    public void clickReceiveButton() {
        Waiters.waitForElementToBeClickable(getReceiveButton());
        clickOnElement(getReceiveButton());
    }

    public void clickDeleteButton() {
        Waiters.waitForElementToBeClickable(getDeleteButton());
        clickOnElement(getDeleteButton());
    }

    public void clickReviewButton() {
        Waiters.waitForElementToBeClickable(getReviewButton());
        clickOnElement(getReviewButton());
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeClickable(getCancelButton());
        clickOnElement(getCancelButton());
    }

    public void enterLoad(String load) {
        Waiters.waitForElementToBeDisplay(getLoadInput());
        clearText(getLoadInput());
        enterText(getLoadInput(), load);
        pressEnter(getLoadInput());
    }

    public void selectDockDoor(String door) {
        Waiters.waitForElementToBeDisplay(getDockDoorDropdown());
        clickOnElement(getDockDoorDropdown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '" +
                door + "')]")));
    }

    public void checkLoad(int index) {
        Waiters.waitForAllElementsToBeDisplay(getLoads().get(index));
        Waiters.waitABit(2000);
        clickOnElement(getLoads().get(index).findElement(By.xpath(".//input[@type='radio']")));
        clickOnElement(okButton);
        Waiters.waitABit(2000);
        if(getInvalidEntryTitle() != null) {
            clickOkButton();
        }
        waitUntilInvisible(2, loader);
    }

    public void enterLocation(String location) {
        Waiters.waitForElementToBeDisplay(getLocationInput());
        clearText(getLocationInput());
        enterText(getLocationInput(), location);
    }

    public void enterProduct(String product) {
        Waiters.waitForElementToBeDisplay(getSearchProductListInput());
        enterText(getSearchProductListInput(), product);
        pressTab(getSearchProductListInput());
    }

    public void clearProduct() {
        Waiters.waitForElementToBeClickable(getSearchProductListInput());
        clickOnElement(getClearProduct());
    }

    public void enterQty(String qty) {
        Waiters.waitForElementToBeDisplay(getQtyInput());
        enterText(getQtyInput(), qty);
        pressTab(getQtyInput());
    }

    public void enterLot(String lot) {
        Waiters.waitForElementToBeDisplay(lotInput);
        enterText(getLotInput(), lot);
        pressTab(getLotInput());
    }

    public void enterExpDate(String expDate) {
        Waiters.waitForElementToBeDisplay(getExpDateInput());
        doubleClick(getExpDateInput());
        pressDelete(getExpDateInput());
        inputText(getExpDateInput(), expDate);
        pressTab(getExpDateInput());
        Waiters.waitABit(2000);
    }

    public void enterLPN(String lpn) {
        if(isVisible(By.xpath("//button[text()='No']"))) {
            clickOnElement(findWebElement(By.xpath("//button[text()='No']")));
        }
        Waiters.waitForElementToBeDisplay(getTxtAddProductLPN());
        clearText(getTxtAddProductLPN());
        Waiters.waitABit(2000);
        if(isVisible(By.xpath("//button/span[text()='Yes']"))) {
            clickOnElement(findWebElement(By.xpath("//button/span[text()='Yes']")));
        }
        Waiters.waitABit(2000);
        inputText(getTxtAddProductLPN(), lpn);
        if(isVisible(By.xpath("//button[text()='No']"))) {
            clickOnElement(findWebElement(By.xpath("//button[text()='No']")));
        }
    }

    public void clearLPN() {
        Waiters.waitForElementToBeClickable(getTxtAddProductLPN());
        doubleClick(getTxtAddProductLPN());
        pressDelete(getTxtAddProductLPN());
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void checkPalletByIndex(int index) {
        Waiters.waitForElementToBeDisplay(getTableContent());
        clickOnElement(getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]//input")).get(index));
        Waiters.waitABit(2000);
    }

    public void checkAllPallets() {
        Waiters.waitForElementToBeDisplay(getAllPalletsCheckBox());
        clickOnElement(getAllPalletsCheckBox());
        Waiters.waitABit(2000);
    }

    public void clickNoButton() {
        Waiters.waitForElementToBeDisplay(getNoButton());
        clickOnElement(getNoButton());
    }

    public void clickOkButton() {
        Waiters.waitForElementToBeDisplay(okButton);
        clickOnElement(okButton);
    }

    public String getOrderValue() {
        Waiters.waitForElementToBeDisplay(getOrderInput());
        return getValue(getOrderInput());
    }

    public String getLoadValue() {
        Waiters.waitForElementToBeDisplay(getLoadInput());
        return getValue(getLoadInput());
    }

    public String getDockDoorText() {
        Waiters.waitForElementToBeDisplay(getDockDoorDropdown());
        return getText(getDockDoorDropdown());
    }

    public String getLocationValue() {
        Waiters.waitForElementToBeDisplay(getLocationInput());
        return getValue(getLocationInput());
    }

    public String getDialogTextContentText() {
        Waiters.waitForElementToBeDisplay(getDialogTextContent());
        return getText(getDialogTextContent());
    }

    public String getWarningTitleText() {
        Waiters.waitForElementToBeDisplay(getDialogTitle());
        return getText(getDialogTitle());
    }

    public String getPalletsValueText() {
        Waiters.waitForElementToBeDisplay(getPalletsValue());
        return getText(getPalletsValue());
    }

    public String getTotalQtyValueText() {
        Waiters.waitForElementToBeDisplay(getTotalQtyValue());
        return getText(getTotalQtyValue());
    }

    public String getItemsFoundValueText() {
        Waiters.waitForElementToBeDisplay(getItemsFoundValue());
        return getText(getItemsFoundValue());
    }

    public WebElement getNextButton() { return findWebElement(nextButton); }

    public WebElement getTxtAddProductLPNLabel() { return findWebElement(txtAddProductLPNLabel); }

    public WebElement getTxtAddProductLPN() { return findWebElement(txtAddProductLPN); }

    public WebElement getSearchProductListLabel() { return findWebElement(searchProductListLabel); }

    public WebElement getSearchProductListInput() { return findWebElement(searchProductList); }

    public WebElement getClearProduct() { return findWebElement(clearProduct); }

    public WebElement getInvalidEntryTitle() { return findWebElement(invalidEntryTitle); }

    public WebElement getQtyInput() { return findWebElement(qtyInput); }

    public WebElement getLotInput() { return findWebElement(lotInput); }

    public WebElement getGtinInput() { return findWebElement(gtinInput); }

    public WebElement getExpDateInput() { return findWebElement(expDate); }

    public WebElement getUomLabel() { return findWebElement(uomLabel); }

    public WebElement getUomDropDown() { return findWebElement(uomDropDown); }

    public WebElement getYesButton() { return findWebElement(yesButton); }

    public WebElement getNoButton() { return findWebElement(noButton); }

    public WebElement getReviewButton() { return findWebElement(reviewButton); }

    public WebElement getReceiveButton() { return findWebElement(receiveButton); }

    public WebElement getCancelButton() { return findWebElement(cancelButton); }

    public WebElement getDeleteButton() { return findWebElement(deleteButton); }

    public WebElement getIconReceiving() { return findWebElement(topIcon); }

    public WebElement getOrderLabel() { return findWebElement(orderLabel); }

    public WebElement getOrderInput() { return findWebElement(orderInput); }

    public WebElement getLoadLabel() { return findWebElement(loadLabel); }

    public WebElement getLoadInput() { return findWebElement(loadInput); }

    public WebElement getDockDoorLabel() { return findWebElement(dockDoorLabel); }

    public WebElement getDockDoorDropdown() { return findWebElement(dockDoorDropdown); }

    public WebElement getStatusLabel() { return findWebElement(statusLabel); }

    public WebElement getStatusDropdown() { return findWebElement(statusDropdown); }

    public WebElement getLocationLabel() { return findWebElement(locationLabel); }

    public WebElement getLocationInput() { return findWebElement(locationInput); }

    public WebElement getPalletColumn() { return findWebElement(palletColumn); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getUomColumn() { return findWebElement(uomColumn); }

    public WebElement getLotColumn() { return findWebElement(lotColumn); }

    public WebElement getExpDateColumn() { return findWebElement(expDateColumn); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getCustomerColumn() { return findWebElement(customerColumn); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getDialogTextContent() { return findWebElement(dialogTextContent); }

    public WebElement getDialogTitle() { return findWebElement(dialogTitle); }

    public WebElement getPalletsLabel() { return findWebElement(palletsLabel); }

    public WebElement getPalletsValue() { return findWebElement(palletsValue); }

    public WebElement getTotalQtyLabel() { return findWebElement(totalQtyLabel); }

    public WebElement getTotalQtyValue() { return findWebElement(totalQtyValue); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getItemsFoundValue() { return findWebElement(itemsFoundValue); }

    public WebElement getAllPalletsCheckBox() { return findWebElement(allPalletsCheckBox); }

    public List<WebElement> getLoads() { return findWebElements(loadsList); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }
}
