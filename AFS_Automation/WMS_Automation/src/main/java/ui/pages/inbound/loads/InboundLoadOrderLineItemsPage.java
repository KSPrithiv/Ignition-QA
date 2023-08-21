package ui.pages.inbound.loads;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;
import static common.setup.DriverManager.getDriver;

public class InboundLoadOrderLineItemsPage extends BasePage {

    By topIcon = By.xpath("//span[contains(text(), 'Inbound load summary')]");
    By toolBarContainer = By.cssSelector(".i-toolbar-container");
    By orderLabel = By.xpath("//span[contains(text(), 'Order')]");
    By orderLoadNumber = By.xpath("//span[contains(@id, 'span_Status')]//preceding-sibling::span[@id='spnOrderNo']");
    By doorField = By.xpath("//span[contains(text(), 'Door')]");
    By qaField = By.xpath("//span[contains(text(), 'QA')]");
    By ownerField = By.xpath("//span[contains(text(), 'Owner')]");
    By carrierField = By.xpath("//span[contains(text(), 'Carrier')]");
    By loadField = By.xpath("//span[contains(text(), 'Load')]");
    By sourceField = By.xpath("//span[contains(text(), 'Source')]");
    By qtyField = By.xpath("//span[contains(text(), 'Qty')]");
    By cubeField = By.xpath("//span[contains(text(), 'Cube')]");
    By weightField = By.xpath("//span[contains(text(), 'Weight')]");
    By imagesButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Images')]");
    By commentsButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Comments')]");
    By btnProductData = By.id("btnProductData");
    By btnProductEdit = By.id("btnProductEdit");
    By btnOrderLineFieldsImage = By.id("btnOrderLineFieldsImage");
    By orderLocationLink = By.xpath("//td[contains(@id, 'orderLocationlink')]//a");
    By locationColumn = By.xpath("//table[@role='presentation']//span[text() ='Location']");
    By locationTypeColumn = By.xpath("//table[@role='presentation']//span[text() ='Location type']");
    By qtyColumn = By.xpath("//table[@role='presentation']//span[text() ='Qty']");
    By uomColumn = By.xpath("//table[@role='presentation']//span[text() ='UOM']");
    By lotColumn = By.xpath("//table[@role='presentation']//span[text() ='LOT']");
    By expDateColumn = By.xpath("//table[@role='presentation']//span[text() ='Expiration date']");
    By statusColumn = By.xpath("//table[@role='presentation']//span[text() ='Status']");
    By weightColumn = By.xpath("//table[@role='presentation']//span[text() ='Weight']");
    By stagedColumn = By.xpath("//table[@role='presentation']//span[text() ='Staged?']");
    By orderLinesTableColumnDetails = By.cssSelector(".k-grid-table td");
    By backButton = By.cssSelector("#RouteBackButton");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By productLabel = By.xpath("//div[@id='bottomDataContainer']//span[contains(text(), 'Product:')]");
    By upcLabel = By.xpath("//div[@id='bottomDataContainer']//span[contains(text(), 'UPC')]");
    By orderLabelOnData = By.xpath("//span[contains(text(), 'Order')]");
    By temperatureLabel = By.xpath("//label[text()='Temperature']");
    By temperatureInput = By.xpath("//label[text()='Temperature']//following-sibling::input");
    By sealNumberLabel = By.xpath("//label[text()='Seal number']");
    By sealNumberInput = By.xpath("//label[text()='Seal number']//following-sibling::input");
    By commentsLabels = By.xpath("//label[text()='Comments']");
    By commentsInputs = By.xpath("//label[text()='Comments']//following-sibling::input");
    By yesRadioButtons = By.xpath("//label[text()='Yes']//preceding-sibling::input");
    By noRadioButtons = By.xpath("//label[text()='No']//preceding-sibling::input");
    By btnAddProductCancel = By.id("btnAddProductCancel");
    By orderedQuantity = By.xpath("//label[contains(text(), 'Ordered quantity')]");
    By orderedQuantityInput = By.xpath("//label[contains(text(), 'Ordered quantity')]//following-sibling::span");
    By lotCode = By.xpath("//label[contains(text(), 'Lot code')]");
    By lotCodeDropDown = By.xpath("//label[contains(text(), 'Lot code')]//following-sibling::span");
    By expirationDate = By.xpath("//label[contains(text(), 'Expiration date')]");
    By expirationDateInput = By.xpath("//label[contains(text(), 'Expiration date')]//following-sibling::span");
    By requiredStatus = By.xpath("//label[contains(text(), 'Required status')]");
    By refusedQtyLabel = By.xpath("//label[contains(text(), 'Refused qty')]");
    By refusedQtyInput = By.xpath("//label[contains(text(), 'Refused qty')]//following-sibling::span");
    By commentLabel = By.xpath("//label[contains(text(), 'Comment')]");
    By commentTextArea = By.xpath("//label[contains(text(), 'Comment')]//following-sibling::textarea");
    By receivedWeightLabel = By.xpath("//label[contains(text(), 'Received weight')]");
    By receivedWeightInput = By.xpath("//label[contains(text(), 'Received weight')]//following-sibling::span");
    By gtinLabel = By.xpath("//label[contains(text(), 'GTIN')]");
    By gtinInput = By.xpath("//label[contains(text(), 'GTIN')]//following-sibling::span");
    By dateCodeLabel = By.xpath("//label[contains(text(), 'Date code')]");
    By dateCodeInput = By.xpath("//label[contains(text(), 'Date code')]//following-sibling::input");
    By rejectedStatusLabel = By.xpath("//label[contains(text(), 'Rejected status')]");
    By rejectedStatuses = By.xpath(" //label[contains(text(), 'Rejected status')]//following-sibling::ul");
    By refusalReasonLabel = By.xpath("//label[contains(text(), 'Refusal reason')]");
    By refusalReasonInput = By.xpath("//label[contains(text(), 'Refusal reason')]//following-sibling::span");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");

    public void waitForInboundLoadOrderLineItemsPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTopIcon());
        Waiters.waitForElementToBeDisplay(btnProductData);
        Waiters.waitForElementToBeDisplay(btnProductEdit);
        Waiters.waitForElementToBeDisplay(btnOrderLineFieldsImage);
        Waiters.waitForElementToBeDisplay(productLabel);
    }

    public boolean isToolBarContainerPresent() { return isElementPresent(getToolBarContainer()); }

    public boolean isOrderLabelPresent() {
        return isElementPresent(getOrderLabel());
    }

    public boolean isOrderLoadNumberPresent() {
        return isElementPresent(getOrderLoadNumber());
    }

    public boolean isDoorFieldDisplayed() {  return isElementDisplay(getDoorField());  }

    public boolean isQaFieldDisplayed() {  return isElementDisplay(getQaField());  }

    public boolean isOwnerFieldDisplayed() { return isElementDisplay(getOwnerField()); }

    public boolean isCarrierFieldDisplayed() { return isElementDisplay(getCarrierField()); }

    public boolean isLoadFieldDisplayed() { return isElementDisplay(getLoadField()); }

    public boolean isSourceFieldDisplayed() { return isElementDisplay(getSourceField()); }

    public boolean isQtyFieldDisplayed() { return isElementDisplay(getQtyField()); }

    public boolean isCubeFieldDisplayed() { return isElementDisplay(getCubeField()); }

    public boolean isWeightFieldDisplayed() { return isElementDisplay(getWeightField()); }

    public String getProductNumber() {
        return getProductLabel().getText().substring(9, 15);
    }

    public String getUPCNumber() { return getProductLabel().getText().substring(getProductLabel().getText().indexOf(":") + 1); }

    public boolean isLocationColumnDisplayed() { return isElementDisplay(getLocationColumn()); }

    public boolean isLocationTypeColumnDisplayed() { return isElementDisplay(getLocationTypeColumn()); }

    public boolean isQtyColumnDisplayed() { return isElementDisplay(getQtyColumn()); }

    public boolean isUomColumnDisplayed() { return isElementDisplay(getUomColumn()); }

    public boolean isLotColumnDisplayed() { return isElementDisplay(getLotColumn()); }

    public boolean isExpDateColumnDisplayed() { return isElementDisplay(getExpDateColumn()); }

    public boolean isStatusColumnDisplayed() { return isElementDisplay(getStatusColumn()); }

    public boolean isWeightColumnDisplayed() { return isElementDisplay(getWeightColumn()); }

    public boolean isStagedColumnDisplayed() { return isElementDisplay(getStagedColumn()); }

    public boolean areOrderLinesTableColumnsDisplayed() { return elementsArePresent(getOrderLinesTableColumnDetails()) > 0; }

    public boolean isOrderLocationLinkDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getOrderLocationLink());
    }

    public boolean isProductLabelDisplayed() { return isElementDisplay(getProductLabel()); }

    public boolean isOrderLabelOnDataDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(orderLabelOnData);
    }

    public boolean isTemperatureLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTemperatureLabel());
    }
    public boolean isTemperatureInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTemperatureInput());
    }

    public boolean isSealNumberLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSealNumberLabel());
    }

    public boolean isSealNumberInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSealNumberInput());
    }

    public int areCommentsLabelsDisplayed() {
        Waiters.waitABit(2000);
        return elementsArePresent(getCommentsLabels());
    }

    public int areCommentsInputsDisplayed() {
        Waiters.waitABit(2000);
        return elementsArePresent(getCommentsInputs());
    }

    public int areYesRadioButtonsDisplayed() {
        Waiters.waitABit(2000);
        return elementsArePresent(getYesRadioButtons());
    }

    public int areNoRadioButtonsDisplayed() {
        Waiters.waitABit(2000);
        return elementsArePresent(getNoRadioButtons());
    }

    public boolean isBtnAddProductCancelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getBtnAddProductCancel());
    }

    public boolean isOrderedQuantityLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getOrderedQuantityLabel());
    }

    public boolean isOrderedQuantityInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getOrderedQuantityInput());
    }

    public boolean isLotCodeDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLotCode());
    }

    public boolean isLotCodeDropDownDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLotCodeDropDown());
    }

    public boolean isExpirationDateDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getExpirationDate());
    }

    public boolean isExpirationDateInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getExpirationDateInput());
    }

    public boolean isRequiredStatusDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRequiredStatus());
    }

    public boolean isRefusedQtyLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRefusedQtyLabel());
    }

    public boolean isRefusedQtyInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRefusedQtyInput());
    }

    public boolean isCommentLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCommentLabel());
    }

    public boolean isCommentTextAreaDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCommentTextArea());
    }

    public boolean isReceivedWeightLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getReceivedWeightLabel());
    }

    public boolean isReceivedWeightInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getReceivedWeightInput());
    }

    public boolean isGtinLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getGtinLabel());
    }

    public boolean isGtinInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getGtinInput());
    }

    public boolean isDateCodeLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDateCodeLabel());
    }

    public boolean isDateCodeInputDisplayed() {
        Waiters.waitABit(4000);
        return isElementDisplay(getDateCodeInput());
    }

    public boolean isRejectedStatusLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRejectedStatusLabel());
    }

    public boolean isRejectedStatusesDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRejectedStatuses());
    }

    public boolean isRefusalReasonLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRefusalReasonLabel());
    }

    public boolean isRefusalReasonInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRefusalReasonInput());
    }

    public boolean isSaveButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSaveButton());
    }

    public boolean isCancelButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCancelButton());
    }

    public boolean isImagesButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getImagesButton());
    }

    public boolean isCommentsButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCommentsButton());
    }

    public void clickOrderLocationLink() {
        Waiters.waitForElementToBeDisplay(getOrderLocationLink());
        clickOnElement(getOrderLocationLink());
    }

    public void clickProductDataBtn() {
        Waiters.waitForElementToBeDisplay(btnProductData);
        clickOnElement(btnProductData);
    }

    public void clickProductEditBtn() {
        Waiters.waitForElementToBeDisplay(btnProductEdit);
        clickOnElement(btnProductEdit);
    }

    public void clickOrderLineFieldsImageBtn() {
        Waiters.waitForElementToBeDisplay(btnOrderLineFieldsImage);
        clickOnElement(btnOrderLineFieldsImage);
    }

    public void clickCancel() {
        Waiters.waitForElementToBeDisplay(getCancelButton());
        clickOnElement(getCancelButton());
    }

    public WebElement getTopIcon() { return findWebElement(topIcon); }

    public WebElement getToolBarContainer() { return findWebElement(toolBarContainer); }

    public WebElement getOrderLabel() { return findWebElement(orderLabel); }

    public WebElement getOrderLoadNumber() { return findWebElement(orderLoadNumber); }

    public WebElement getDoorField() { return findWebElement(doorField); }

    public WebElement getQaField() { return findWebElement(qaField); }

    public WebElement getOwnerField() { return findWebElement(ownerField); }

    public WebElement getCarrierField() { return findWebElement(carrierField); }

    public WebElement getLoadField() { return findWebElement(loadField); }

    public WebElement getSourceField() { return findWebElement(sourceField); }

    public WebElement getQtyField() { return findWebElement(qtyField); }

    public WebElement getCubeField() { return findWebElement(cubeField); }

    public WebElement getWeightField() { return findWebElement(weightField); }

    public WebElement getImagesButton() { return findWebElement(imagesButton); }

    public WebElement getCommentsButton() { return findWebElement(commentsButton); }

    public WebElement getBtnProductData() { return findWebElement(btnProductData); }

    public WebElement getBtnProductEdit() { return findWebElement(btnProductEdit); }

    public WebElement getBtnOrderLineFieldsImage() { return findWebElement(btnOrderLineFieldsImage); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getUomColumn() { return findWebElement(uomColumn); }

    public WebElement getLotColumn() { return findWebElement(lotColumn); }

    public WebElement getExpDateColumn() { return findWebElement(expDateColumn); }

    public WebElement getStatusColumn() { return findWebElement(statusColumn); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getStagedColumn() { return findWebElement(stagedColumn); }

    public List<WebElement> getOrderLinesTableColumnDetails() { return findWebElements(orderLinesTableColumnDetails); }

    public WebElement getOrderLocationLink() { return findWebElement(orderLocationLink); }

    public WebElement getLocationColumn() { return findWebElement(locationColumn); }

    public WebElement getLocationTypeColumn() { return findWebElement(locationTypeColumn); }

    public WebElement getBackButton() { return findWebElement(backButton); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getItemsFoundValue() { return findWebElement(itemsFoundValue); }

    public WebElement getProductLabel() { return findWebElement(productLabel); }

    public WebElement getUpcLabel() { return findWebElement(upcLabel); }

    public WebElement getTemperatureLabel() { return findWebElement(temperatureLabel); }

    public WebElement getTemperatureInput() { return findWebElement(temperatureInput); }

    public WebElement getSealNumberLabel() { return findWebElement(sealNumberLabel); }

    public WebElement getSealNumberInput() { return findWebElement(sealNumberInput); }

    public List<WebElement> getCommentsLabels() { return findWebElements(commentsLabels); }

    public List<WebElement> getCommentsInputs() { return findWebElements(commentsInputs); }

    public List<WebElement> getYesRadioButtons() { return findWebElements(yesRadioButtons); }

    public List<WebElement> getNoRadioButtons() { return findWebElements(noRadioButtons); }

    public WebElement getBtnAddProductCancel() { return findWebElement(btnAddProductCancel); }

    public WebElement getOrderedQuantityLabel() { return findWebElement(orderedQuantity); }

    public WebElement getOrderedQuantityInput() { return findWebElement(orderedQuantityInput); }

    public WebElement getLotCode() { return findWebElement(lotCode); }

    public WebElement getLotCodeDropDown() { return findWebElement(lotCodeDropDown); }

    public WebElement getExpirationDate() { return findWebElement(expirationDate); }

    public WebElement getExpirationDateInput() { return findWebElement(expirationDateInput); }

    public WebElement getRequiredStatus() { return findWebElement(requiredStatus); }

    public WebElement getRefusedQtyLabel() { return findWebElement(refusedQtyLabel); }

    public WebElement getRefusedQtyInput() { return findWebElement(refusedQtyInput); }

    public WebElement getCommentLabel() { return findWebElement(commentLabel); }

    public WebElement getCommentTextArea() { return findWebElement(commentTextArea); }

    public WebElement getReceivedWeightLabel() { return findWebElement(receivedWeightLabel); }

    public WebElement getReceivedWeightInput() { return findWebElement(receivedWeightInput); }

    public WebElement getGtinLabel() { return findWebElement(gtinLabel); }

    public WebElement getGtinInput() { return findWebElement(gtinInput); }

    public WebElement getDateCodeLabel() { return findWebElement(dateCodeLabel); }

    public WebElement getDateCodeInput() { return findWebElement(dateCodeInput); }

    public WebElement getRejectedStatusLabel() { return findWebElement(rejectedStatusLabel); }

    public WebElement getRejectedStatuses() { return findWebElement(rejectedStatuses); }

    public WebElement getRefusalReasonLabel() { return findWebElement(refusalReasonLabel); }

    public WebElement getRefusalReasonInput() { return findWebElement(refusalReasonInput); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getCancelButton() { return findWebElement(cancelButton); }

}
