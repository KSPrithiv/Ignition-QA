package ui.pages.inbound.inboundorders;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

import static common.setup.DriverManager.getDriver;

public class InboundOrderLineItemsDetailsScreenPage extends BasePage {
    By orderLinesTableColumnDetails = By.cssSelector(".k-grid-table tr.k-master-row");
    By orderLabel = By.xpath("//span[contains(text(), 'Order')]");
    By orderDet = By.cssSelector("#spnOrderNo");
    By orderNumber = By.xpath("//span[contains(text(),'Order')]//following-sibling::span[@id='spnOrderNo']");
    By customerField = By.xpath("//span[contains(text(), 'Customer')]");
    By sourceField = By.xpath("//span[contains(text(), 'Source')]");
    By doorField = By.xpath("//span[contains(text(), 'Door')]");
    By qaField = By.xpath("//span[contains(text(), 'QA')]");
    By carrierField = By.xpath("//span[contains(text(), 'Carrier')]");
    By loadField = By.xpath("//span[contains(text(), 'Load')]");
    By qtyField = By.xpath("//span[contains(text(), 'Qty')]");
    By cubeField = By.xpath("//span[contains(text(), 'Cube')]");
    By weightField = By.xpath("//span[contains(text(), 'Weight')]");
    By btnProductData = By.id("btnProductData");
    By btnProductEdit = By.id("btnProductEdit");
    By btnOrderLineFieldsImage = By.id("btnOrderLineFieldsImage");
    By orderLocationLink = By.xpath("//td[contains(@id, 'orderLocationlink')]//a");
    By locationColumn = By.xpath("//table[@role='presentation']//span[text() ='Location']");
    By locationTypeColumn = By.xpath("//table[@role='presentation']//span[text() ='Location type']");
    By qtyColumn = By.xpath("//table[@role='presentation']//span[text() ='Qty']");
    By uomColumn = By.xpath("//table[@role='presentation']//span[text() ='Uom']");
    By lotColumn = By.xpath("//table[@role='presentation']//span[text() ='Lot']");
    By expDateColumn = By.xpath("//table[@role='presentation']//span[text() ='Expiration date']");
    By statusColumn = By.xpath("//table[@role='presentation']//span[text() ='Status']");
    By weightColumn = By.xpath("//table[@role='presentation']//span[text() ='Weight']");
    By stagedColumn = By.xpath("//table[@role='presentation']//span[text() ='Staged?']");
    By backButton = By.cssSelector("#RouteBackButton");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By productLabel = By.xpath("//div[@id='bottomDataContainer']//span[contains(text(), 'Product:')]");
    By imagesButton = By.xpath("//button/span[@id='btnImageNo' and contains(text(), 'Images')]");
    By commentsButton = By.xpath("//button/span[@id='btnImageNo' and contains(text(), 'Comments')]");
    By routeBackButton = By.id("RouteBackButton");
    By orderLabelOnData = By.xpath("//span[contains(text(), 'Order')]");
    By temperatureLabel = By.xpath("//label[text()='Temperature']");
    By temperatureInput = By.xpath("//label[text()='Temperature']//following-sibling::input");
    By sealNumberLabel = By.xpath("//label[text()='Seal Number']");
    By sealNumberInput = By.xpath("//label[text()='Seal Number']//following-sibling::input");
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
    By saveButton = By.xpath("//button/span[contains(text(), 'Save')]");
    By cancelButton = By.xpath("//button/span[contains(text(), 'Cancel')]");
    By saveEditButton = By.id("saveEditButton");
    By inboundImageCaptureButton = By.cssSelector(".inboundImageCaptureOpButtonDiv button");
    By selectFilesBtn = By.xpath("//div[@aria-label='Select files']");
    By loadImageLabel = By.xpath("//span[text()='Load image(s)']");

    public String getUPCNumber() {
        return getProductLabel().getText().substring(4, 15);
    }

    public void clickOrderLocationLink() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getOrderLocationLink());
        clickOnElement(getOrderLocationLink());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickRouteBackButton() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(routeBackButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickProductDataBtn() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(btnProductData);
        clickOnElement(btnProductData);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickProductEditBtn() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(btnProductEdit);
        clickOnElement(btnProductEdit);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOrderLineFieldsImageBtn() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(btnOrderLineFieldsImage);
        clickOnElement(btnOrderLineFieldsImage);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickCancel() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getCancelButton());
        clickOnElement(getCancelButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public boolean isOrderLabelPresent() { return isElementPresent(getOrderLabel()); }

    public boolean isOrderDetailsPresent() { return isElementPresent(getOrderDet()); }

    public boolean isDoorFieldDisplayed() {  return isElementDisplay(getDoorField()); }

    public boolean isQaFieldDisplayed() {  return isElementDisplay(getQaField()); }

    public boolean isCustomerFieldDisplayed() { return isElementDisplay(getCustomerField()); }

    public boolean isCarrierFieldDisplayed() { return isElementDisplay(getCarrierField()); }

    public boolean isLoadFieldDisplayed() { return isElementDisplay(getLoadField()); }

    public boolean isSourceFieldDisplayed() { return isElementDisplay(getSourceField()); }

    public boolean isQtyFieldDisplayed() { return isElementDisplay(getQtyField()); }

    public boolean isCubeFieldDisplayed() { return isElementDisplay(getCubeField()); }

    public boolean isWeightFieldDisplayed() { return isElementDisplay(getWeightField()); }

    public boolean isProductLabelDisplayed() { return isElementDisplay(getProductLabel()); }

    public boolean isLocationColumnDisplayed() { return isElementDisplay(getLocationColumn()); }

    public boolean isLocationTypeColumnDisplayed() { return isElementDisplay(getLocationTypeColumn()); }

    public boolean isQtyColumnDisplayed() { return isElementDisplay(getQtyColumn()); }

    public boolean isUomColumnDisplayed() { return isElementDisplay(getUomColumn()); }

    public boolean isLotColumnDisplayed() { return isElementDisplay(getLotColumn()); }

    public boolean isExpDateColumnDisplayed() { return isElementDisplay(getExpDateColumn()); }

    public boolean isStatusColumnDisplayed() { return isElementDisplay(getStatusColumn()); }

    public boolean isWeightColumnDisplayed() { return isElementDisplay(getWeightColumn()); }

    public boolean isStagedColumnDisplayed() {
        return isElementDisplay(getStagedColumn());
    }

    public boolean areOrderLinesTableColumnsDisplayed() { return elementsArePresent(getOrderLinesTableColumnDetails()) > 0; }

    public boolean isOrderLabelOnDataDisplayed() { return isElementDisplay(orderLabelOnData); }

    public boolean isTemperatureLabelDisplayed() { return isElementDisplay(getTemperatureLabel()); }

    public boolean isTemperatureInputDisplayed() { return isElementDisplay(getTemperatureInput()); }

    public boolean isSealNumberLabelDisplayed() { return isElementDisplay(getSealNumberLabel()); }

    public boolean isSealNumberInputDisplayed() { return isElementDisplay(getSealNumberInput()); }

    public int areCommentsLabelsDisplayed() { return elementsArePresent(getCommentsLabels()); }

    public int areCommentsInputsDisplayed() { return elementsArePresent(getCommentsInputs()); }

    public int areYesRadioButtonsDisplayed() { return elementsArePresent(getYesRadioButtons()); }

    public int areNoRadioButtonsDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return elementsArePresent(getNoRadioButtons());
    }

    public boolean isBtnAddProductCancelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getBtnAddProductCancel());
    }

    public boolean isOrderedQuantityLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getOrderedQuantityLabel());
    }

    public boolean isOrderedQuantityInputDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getOrderedQuantityInput());
    }

    public boolean isLotCodeDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLotCode());
    }

    public boolean isLotCodeDropDownDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLotCodeDropDown());
    }

    public boolean isExpirationDateDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getExpirationDate());
    }

    public boolean isExpirationDateInputDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getExpirationDateInput());
    }

    public boolean isRequiredStatusDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getRequiredStatus());
    }

    public boolean isRefusedQtyLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getRefusedQtyLabel());
    }

    public boolean isRefusedQtyInputDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getRefusedQtyInput());
    }

    public boolean isCommentLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getCommentLabel());
    }

    public boolean isCommentTextAreaDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getCommentTextArea());
    }

    public boolean isReceivedWeightLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getReceivedWeightLabel());
    }

    public boolean isReceivedWeightInputDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getReceivedWeightInput());
    }

    public boolean isGtinLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
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

    public boolean isSaveEditButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getSaveEditButton());
        return isElementDisplay(getSaveEditButton());
    }

    public boolean isInboundImageCaptureButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getInboundImageCaptureButton());
        return isElementDisplay(getInboundImageCaptureButton());
    }

    public boolean isSelectFilesBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getSelectFilesBtn());
        return isElementDisplay(getSelectFilesBtn());
    }

    public boolean isLoadImageLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLoadImageLabel());
        return isElementDisplay(getLoadImageLabel());
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

    public List<WebElement> getOrderLinesTableColumnDetails() { return findWebElements(orderLinesTableColumnDetails); }

    public WebElement getOrderLabel() { return findWebElement(orderLabel); }

    public WebElement getOrderDet() { return findWebElement(orderDet); }

    public WebElement getOrderNumber() { return findWebElement(orderNumber); }

    public WebElement getDoorField() { return findWebElement(doorField); }

    public WebElement getQaField() { return findWebElement(qaField); }

    public WebElement getCustomerField() { return findWebElement(customerField); }

    public WebElement getCarrierField() { return findWebElement(carrierField); }

    public WebElement getLoadField() { return findWebElement(loadField); }

    public WebElement getSourceField() { return findWebElement(sourceField); }

    public WebElement getQtyField() { return findWebElement(qtyField); }

    public WebElement getCubeField() { return findWebElement(cubeField); }

    public WebElement getWeightField() { return findWebElement(weightField); }

    public WebElement getBtnProductData() { return findWebElement(btnProductData); }

    public WebElement getBtnProductEdit() { return findWebElement(btnProductEdit); }

    public WebElement getBtnOrderLineFieldsImage() { return findWebElement(btnOrderLineFieldsImage); }

    public WebElement getOrderLocationLink() { return findWebElement(orderLocationLink); }

    public WebElement getLocationColumn() { return findWebElement(locationColumn); }

    public WebElement getLocationTypeColumn() { return findWebElement(locationTypeColumn); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getUomColumn() { return findWebElement(uomColumn); }

    public WebElement getLotColumn() { return findWebElement(lotColumn); }

    public WebElement getExpDateColumn() { return findWebElement(expDateColumn); }

    public WebElement getStatusColumn() { return findWebElement(statusColumn); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getStagedColumn() { return findWebElement(stagedColumn); }

    public WebElement getBackButton() { return findWebElement(backButton); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getItemsFoundValue() { return findWebElement(itemsFoundValue); }

    public WebElement getProductLabel() { return findWebElement(productLabel); }

    public WebElement getImagesButton() { return findWebElement(imagesButton); }

    public WebElement getCommentsButton() { return findWebElement(commentsButton); }

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

    public WebElement getSaveEditButton() { return findWebElement(saveEditButton); }

    public WebElement getInboundImageCaptureButton() { return findWebElement(inboundImageCaptureButton); }

    public WebElement getSelectFilesBtn() { return findWebElement(selectFilesBtn); }

    public WebElement getLoadImageLabel() { return findWebElement(loadImageLabel); }


}
