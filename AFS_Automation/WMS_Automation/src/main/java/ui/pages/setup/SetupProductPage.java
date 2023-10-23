package ui.pages.setup;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class SetupProductPage extends BasePage {
    By productLabel = By.xpath("//span[contains(text(), 'Product')]");
    By productTypeLabel = By.xpath("//span[contains(text(), 'Product type')]");
    By unitOfMeasureLabel = By.xpath("//span[contains(text(), 'Unit of measure')]");
    By unitStatusLabel = By.xpath("//span[contains(text(), 'Unit status')]");
    By qualityControlTypeLabel = By.xpath("//span[contains(text(), 'Quality control type')]");
    By putAwayRuleLabel = By.xpath("//span[contains(text(), 'Putaway rule')]");
    By aliasTypeLabel = By.xpath("//span[contains(text(), 'Alias type')]");
    By movementClassLabel = By.xpath("//span[contains(text(), 'Movement class')]");
    By genericLookupTypeLabel = By.xpath("//span[contains(text(), 'Generic lookup type')]");
    By pickSlotTypeLabel = By.xpath("//span[contains(text(), 'Pick slot type')]");
    By dateEncodingLabel = By.xpath("//span[contains(text(), 'Date encoding')]");
    By encodingLabel = By.xpath("//span[contains(text(), 'Encoding')]");
    By selectProductInput = By.xpath("//input[@placeholder='Select a product']");
    By productInputLabel = By.xpath("//h4[text()='Product']");
    By searchProductButton = By.xpath("//div[contains(@class, 'countProductSearchControl')]//button[contains(@class, 'i-button--icon-only')]");
    By addNewProductButton = By.xpath("//div[contains(@class, 'reset-padding-product')]//button[@action='New']");
    By copyProductButton = By.xpath("//div[contains(@class, 'reset-padding-product')]//button[@action='Copy']");
    By editProductButton = By.xpath("//div[contains(@class, 'reset-padding-product')]//button[@action='Edit']");
    By deleteButton = By.xpath("//div[contains(@class, 'reset-padding-product')]//button[@action='Delete']");
    By cancelButton = By.xpath("//div[contains(@class, 'reset-padding-product')]//button[@action='Cancel']");
    By saveButton = By.xpath("//div[contains(@class, 'reset-padding-product')]//button[@action='Save']");
    By cancelBtn = By.xpath("//div[contains(@class, 'k-dialog-buttongroup')]//button[@content='Cancel']");
    By saveBtn = By.xpath("//div[contains(@class, 'k-dialog-buttongroup')]//button[@content='Save']");
    By addNewWareHouseButton = By.xpath("//div[contains(@class, 'i-toolbar-container ')]//button[@action='New']");
    By setupProductLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Product']");
    By setupAliasLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Alias']");
    By setupWarehouseLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Warehouse']");
    By setupUOMLabel = By.xpath("//div[@id='setupContentPage']//span[text()='UOM']");
    By setupOwnersLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Owners']");
    By setupSuppliersLabel = By.xpath("///div[@id='setupContentPage']//span[text()='Suppliers']");
    By setupReceivingLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Receiving']");
    By setupShippingLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Shipping']");
    By isIndividualCatchWeight = By.id("IsIndividualCatchWeight");
    By setupInventoryLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Inventory']");
    By setupKittingLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Kitting']");
    By setupHazardLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Hazard']");
    By setupPickingLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Picking']");
    By setupStockingLabel = By.xpath("//div[@id='setupContentPage']//span[text()='Stocking']");
    By textProductCodeLabel = By.id("textProductCode-label");
    By textProductCode = By.id("textProductCode");
    By textLognDescriptionLabel = By.id("textLognDescription-label");
    By textLognDescription = By.id("textLognDescription");
    By txtAltDescriptionLabel = By.id("txtAltDescription-label");
    By txtAltDescription = By.id("txtAltDescription");
    By txtSizeCodeLabel = By.id("txtSizeCode-label");
    By txtSizeCode = By.id("txtSizeCode");
    By txtTieLabel = By.id("txtTie-label");
    By txtTie = By.id("txtTie");
    By txtVoicedCodeLabel = By.id("txtVoicedCode-label");
    By txtVoicedCode = By.id("txtVoicedCode");
    By productTypeLbl = By.id("ddlProductType-label");
    By productType = By.id("ddlProductType");
    By txtHighLabel = By.id("txtHigh-label");
    By txtHigh = By.id("txtHigh");
    By exclusiveOwnerLabel = By.id("ddlExclusiveOwner-label");
    By exclusiveOwner = By.id("ddlExclusiveOwner");
    By movementClassLbl = By.id("ddlMovementClass-label");
    By movementClass = By.id("ddlMovementClass");
    By maxStackLabel = By.id("txtMaxStack-label");
    By txtMaxStack = By.id("txtMaxStack");
    By productTab = By.xpath("//ul[@role='tablist']//span[contains(text(), 'Product')]");
    By warehouseTab = By.xpath("//ul[@role='tablist']//span[contains(text(), 'Warehouse')]");
    By uomTab = By.xpath("//ul[@role='tablist']//span[contains(text(), 'UOM')]");
    By suppliersTab = By.xpath("//ul[@role='tablist']//span[contains(text(), 'Suppliers')]");
    By addProductBtn = By.xpath("//div[@class='i-toolbar-container ']//button[contains(@class, 'k-button-icontext') and position()=1]");
    By editProductBtn = By.xpath("//div[@class='i-toolbar-container ']//button[contains(@class, 'k-button-icontext') and position()=2]");
    By deleteProductBtn = By.xpath("//div[@class='i-toolbar-container ']//button[contains(@class, 'k-button-icontext') and position()=3]");
    By addBtn = By.xpath("//div[@id='customPopupContainerDiv']//button[contains(@class, 'k-button-icontext') and position()=1]");
    By editBtn = By.xpath("//div[@id='customPopupContainerDiv']//button[contains(@class, 'k-button-icontext') and position()=2]");
    By deleteBtn = By.xpath("//div[@id='customPopupContainerDiv']//button[contains(@class, 'k-button-icontext') and position()=3]");
    By warehouseLabel = By.id("ddlWarehouse-label");
    By warehouse = By.id("ddlWarehouse");
    By activeLabel = By.id("ddlActive-label");
    By active = By.id("ddlActive");
    By okBtn = By.xpath("//button[@content='OK']");
    By cnlBtn = By.xpath("//button[@content='Cancel']");
    By okButton = By.xpath("//button[text()='OK']");
    By cnlButton = By.xpath("//button[text()='Cancel']");
    By receivingUOMLabel = By.id("ddlReceivingUOM-label");
    By receivingUOM = By.id("ddlReceivingUOM");
    By movementUOMLabel = By.id("ddlMovementUOM-label");
    By movementUOM = By.id("ddlMovementUOM");
    By shippingUOMLabel = By.id("ddlShippingUOM-label");
    By shippingUOM = By.id("ddlShippingUOM");
    By nameTab = By.xpath("//span[text()='Name']");
    By lengthTab = By.xpath("//span[text()='Length']");
    By widthTab = By.xpath("//span[text()='Width']");
    By heightTab = By.xpath("//span[text()='Height']");
    By cubeTab = By.xpath("//span[text()='Cube']");
    By weightTab = By.xpath("//span[text()='Weight']");
    By tareTab = By.xpath("//span[text()='Tare']");
    By packsizeTab = By.xpath("//span[text()='Packsize']");
    By itemsCount = By.cssSelector(".i-summary-area__main__value");
    By itemsFound = By.cssSelector(".i-summary-area__main__label");
    By UOMLabel = By.id("ddlUOM-label");
    By UOMdropdown = By.id("ddlUOM");
    By qtyLabel = By.id("txtQty-label");
    By txtQty = By.id("txtQty");
    By txtWeightLabel = By.id("txtWeight-label");
    By txtWeight = By.id("txtWeight");
    By txtWeightUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtWeight']]/following-sibling::div[position()=1]//span[@id='ddlWeightUnit']");
    By txtTareWeightLabel = By.id("txtTareWeight-label");
    By txtTareWeight = By.id("txtTareWeight");
    By txtTareWeightUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtTareWeight']]/following-sibling::div[position()=1]//span[@id='ddlWeightUnit']");
    By txtWidthLabel = By.id("txtWidth-label");
    By txtWidth = By.id("txtWidth");
    By txtWidthUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtWidth']]/following-sibling::div[position()=1]//span[@id='ddlLengthUnit']");
    By txtNextWidthLabel = By.id("txtNextWidthLabel");
    By txtNextWidth = By.id("txtNextWidth");
    By txtNextWidthUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtNextWidth']]/following-sibling::div[position()=1]//span[@id='ddlLengthUnit']");
    By txtHeightLabel = By.id("txtHeight-label");
    By txtHeight = By.id("txtHeight");
    By txtHeightUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtHeight']]/following-sibling::div[position()=1]//span[@id='ddlLengthUnit']");
    By txNextHeightLabel = By.id("txNextHeight-label");
    By txNextHeight = By.id("txNextHeight");
    By txNextHeightUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtNextLength']]/following-sibling::div[position()=1]//span[@id='ddlLengthUnit']");
    By txtLengthLabel = By.id("txtLength-label");
    By txtLength = By.id("txtLength");
    By txtLengthUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtLength']]/following-sibling::div[position()=1]//span[@id='ddlLengthUnit']");
    By txtNextLengthLabel = By.id("txtNextLength-label");
    By txtNextLength = By.id("txtNextLength");
    By txtNextLengthUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtNextLength']]/following-sibling::div[position()=1]//span[@id='ddlLengthUnit']");
    By txtCutTimeLabel = By.id("txtCutTime-label");
    By txtCutTime = By.id("txtCutTime");
    By txtCutTimeUnit = By.xpath("//div[contains(@class, 'col-md-4')][.//input[@id='txtCutTime']]/following-sibling::div[position()=1]//span[@id='ddlTimeValues']");
    By txtShelfUnitLabel = By.id("txtShelfUnit-label");
    By txtShelfUnit = By.id("txtShelfUnit");
    By sizeCodeLabel = By.id("txtSizeCode-label");
    By sizeCode = By.id("txtSizeCode");
    By dialogTitle = By.className("dialog-title");
    By hazardCheckbox = By.id("Hazard_checkbox");
    By uomRows = By.cssSelector(".k-grid-table tr");
    By dateEncodingTab = By.xpath("//h4[text()='Date encoding']");
    By codeTab = By.xpath("//span[text()='Code']");
    By descTab = By.xpath("//span[text()='Desc']");
    By dayMappingTab = By.xpath("//span[text()='Day mapping']");
    By monthMappingTab = By.xpath("//span[text()='Month mapping']");
    By extractDateAsTab = By.xpath("//span[text()='Extract date as']");
    By yearMappingTab = By.xpath("//span[text()='Year mapping']");
    By weekMappingTab = By.xpath("//span[text()='Week mapping']");
    By supplierColumn = By.xpath("//span[text()='Supplier']");
    By productColumn = By.xpath("//span[text()='Product']");
    By addSettingsButton = By.id("addSettingsButton");
    By editSettingsButton = By.id("editSettingsButton");
    By deleteSettingsButton = By.id("deleteSettingsButton");
    By addFilter = By.cssSelector(".i-filter-tag__main__text--add");
    By searchBox = By.cssSelector(".i-search-box");
    By isEmptyRadioButton = By.id("textRadioButton2");
    By inputContains = By.xpath("//input[@placeholder='Contains']");
    By applyButton = By.xpath("//button[text()='Apply']");
    By clearAllButton = By.xpath("//button[text()='Clear all']");
    By codeFilter = By.cssSelector(".i-btn-checkbox  #LOTENCODING_CODE");
    By descFilter = By.cssSelector(".i-btn-checkbox  #LOTENCODING_DESC");
    By dayMappingFilter = By.cssSelector(".i-btn-checkbox  #DAY_MAP_OD");
    By monthMappingFilter = By.cssSelector(".i-btn-checkbox  #MONTH_MAP_OD");
    By extractDateAsFilter = By.cssSelector(".i-btn-checkbox  #EXP_DATE_CONVERSION");
    By yearMappingFilter = By.cssSelector(".i-btn-checkbox  #YEAR_MAP_OD");
    By weekMappingFilter = By.cssSelector(".i-btn-checkbox  #WEEK_MAP_OD");
    By notification = By.cssSelector(".i-no-data__message");
    By encodingTab = By.xpath("//li[@role='tab'][.//span[text()='Encoding']]");
    By usedByTab = By.xpath("//li[@role='tab'][.//span[text()='Used by']]");
    By dayMpngTab = By.xpath("//li[@role='tab'][.//span[text()='Day mapping']]");
    By monthMpngTab = By.xpath("//li[@role='tab'][.//span[text()='Month mapping']]");
    By yearMpngTab = By.xpath("//li[@role='tab'][.//span[text()='Year mapping']]");
    By weekMpngTab = By.xpath("//li[@role='tab'][.//span[text()='Week mapping']]");
    By codeLabel = By.xpath("//label[@id='LOTENCODING_CODE-label' and text()='Code'][./span[text()='*']]");
    By inputCode = By.cssSelector("input[placeholder='Code']");
    By descLabel = By.xpath("//label[@id='LOTENCODING_DESC-label' and text()='Desc'][./span[text()='*']]");
    By inputDesc = By.cssSelector("input[placeholder='Desc']");
    By lotMaskLabel = By.xpath("//label[@id='LOTMASK-label' and text()='Lot Mask'][./span[text()='*']]");
    By inputLotMask = By.cssSelector("input[placeholder='Lot Mask']");
    By extractDateAsLabel = By.xpath("//label[@id='EXP_DATE_CONVERSION-label' and text()='Extract date as'][./span[text()='*']]");
    By extractDateAsDropDown = By.id("EXP_DATE_CONVERSION");
    By promptLabel = By.xpath("//label[@id='PROMPT-label' and text()='Prompt']");
    By inputPrompt = By.cssSelector("input[placeholder='Prompt']");
    By dayMappingLabel = By.xpath("//label[@id='DAY_MAP_OD-label' and text()='Day mapping']");
    By dayMapOdDropDown = By.id("DAY_MAP_OD");
    By monthMappingLabel = By.xpath("//label[@id='MONTH_MAP_OD-label' and text()='Month mapping']");
    By monthMapOdDropDown = By.id("MONTH_MAP_OD");
    By yearMappingLabel = By.xpath("//label[@id='YEAR_MAP_OD-label' and text()='Year mapping']");
    By yearMapOdDropDown = By.id("YEAR_MAP_OD");
    By weekMappingLabel = By.xpath("//label[@id='WEEK_MAP_OD-label' and text()='Week mapping']");
    By weekMapOdDropDown = By.id("WEEK_MAP_OD");
    By monthMapping0Label = By.id("MONTH_MAPPING_0-label");
    By monthMapping0 = By.id("MONTH_MAPPING_0");
    By monthMapping1Label = By.id("MONTH_MAPPING_1-label");
    By monthMapping1 = By.id("MONTH_MAPPING_1");
    By monthMapping2Label = By.id("MONTH_MAPPING_2-label");
    By monthMapping2 = By.id("MONTH_MAPPING_2");
    By monthMapping3Label = By.id("MONTH_MAPPING_3-label");
    By monthMapping3 = By.id("MONTH_MAPPING_3");
    By monthMapping4Label = By.id("MONTH_MAPPING_4-label");
    By monthMapping4 = By.id("MONTH_MAPPING_4");
    By monthMapping5Label = By.id("MONTH_MAPPING_5-label");
    By monthMapping5 = By.id("MONTH_MAPPING_5");
    By monthMapping6Label = By.id("MONTH_MAPPING_6-label");
    By monthMapping6 = By.id("MONTH_MAPPING_6");
    By monthMapping7Label = By.id("MONTH_MAPPING_7-label");
    By monthMapping7 = By.id("MONTH_MAPPING_7");
    By monthMapping8Label = By.id("MONTH_MAPPING_8-label");
    By monthMapping8 = By.id("MONTH_MAPPING_8");
    By monthMapping9Label = By.id("MONTH_MAPPING_9-label");
    By monthMapping9 = By.id("MONTH_MAPPING_9");
    By yearMapping0Label = By.id("YEAR_MAPPING_0-label");
    By yearMapping0 = By.id("YEAR_MAPPING_0");
    By yearMapping1Label = By.id("YEAR_MAPPING_1-label");
    By yearMapping1 = By.id("YEAR_MAPPING_1");
    By yearMapping2Label = By.id("YEAR_MAPPING_2-label");
    By yearMapping2 = By.id("YEAR_MAPPING_2");
    By yearMapping3Label = By.id("YEAR_MAPPING_3-label");
    By yearMapping3 = By.id("YEAR_MAPPING_3");
    By yearMapping4Label = By.id("YEAR_MAPPING_4-label");
    By yearMapping4 = By.id("YEAR_MAPPING_4");
    By yearMapping5Label = By.id("YEAR_MAPPING_5-label");
    By yearMapping5 = By.id("YEAR_MAPPING_5");
    By yearMapping6Label = By.id("YEAR_MAPPING_6-label");
    By yearMapping6 = By.id("YEAR_MAPPING_6");
    By yearMapping7Label = By.id("YEAR_MAPPING_7-label");
    By yearMapping7 = By.id("YEAR_MAPPING_7");
    By yearMapping8Label = By.id("YEAR_MAPPING_8-label");
    By yearMapping8 = By.id("YEAR_MAPPING_8");
    By yearMapping9Label = By.id("YEAR_MAPPING_9-label");
    By yearMapping9 = By.id("YEAR_MAPPING_9");
    By dayMapping0Label = By.id("DAY_MAPPING_0-label");
    By dayMapping0 = By.id("DAY_MAPPING_0");
    By dayMapping1Label = By.id("DAY_MAPPING_1-label");
    By dayMapping1 = By.id("DAY_MAPPING_1");
    By dayMapping2Label = By.id("DAY_MAPPING_2-label");
    By dayMapping2 = By.id("DAY_MAPPING_2");
    By dayMapping3Label = By.id("DAY_MAPPING_3-label");
    By dayMapping3 = By.id("DAY_MAPPING_3");
    By dayMapping4Label = By.id("DAY_MAPPING_4-label");
    By dayMapping4 = By.id("DAY_MAPPING_4");
    By dayMapping5Label = By.id("DAY_MAPPING_5-label");
    By dayMapping5 = By.id("DAY_MAPPING_5");
    By dayMapping6Label = By.id("DAY_MAPPING_6-label");
    By dayMapping6 = By.id("DAY_MAPPING_6");
    By dayMapping7Label = By.id("DAY_MAPPING_7-label");
    By dayMapping7 = By.id("DAY_MAPPING_7");
    By dayMapping8Label = By.id("DAY_MAPPING_8-label");
    By dayMapping8 = By.id("DAY_MAPPING_8");
    By dayMapping9Label = By.id("DAY_MAPPING_9-label");
    By dayMapping9 = By.id("DAY_MAPPING_9");
    By weekMapping0Label = By.id("WEEK_MAPPING_0-label");
    By weekMapping0 = By.id("WEEK_MAPPING_0");
    By weekMapping1Label = By.id("WEEK_MAPPING_1-label");
    By weekMapping1 = By.id("WEEK_MAPPING_1");
    By weekMapping2Label = By.id("WEEK_MAPPING_2-label");
    By weekMapping2 = By.id("WEEK_MAPPING_2");
    By weekMapping3Label = By.id("WEEK_MAPPING_3-label");
    By weekMapping3 = By.id("WEEK_MAPPING_3");
    By weekMapping4Label = By.id("WEEK_MAPPING_4-label");
    By weekMapping4 = By.id("WEEK_MAPPING_4");
    By weekMapping5Label = By.id("WEEK_MAPPING_5-label");
    By weekMapping5 = By.id("WEEK_MAPPING_5");
    By weekMapping6Label = By.id("WEEK_MAPPING_6-label");
    By weekMapping6 = By.id("WEEK_MAPPING_6");
    By weekMapping7Label = By.id("WEEK_MAPPING_7-label");
    By weekMapping7 = By.id("WEEK_MAPPING_7");
    By weekMapping8Label = By.id("WEEK_MAPPING_8-label");
    By weekMapping8 = By.id("WEEK_MAPPING_8");
    By weekMapping9Label = By.id("WEEK_MAPPING_9-label");
    By weekMapping9 = By.id("WEEK_MAPPING_9");
    By addDateEncodingBtn = By.cssSelector("#MONTH_MAPPING_CustomGrid .i-button--icon-only");
    By editDateEncodingBtn = By.xpath("//div[@id='MONTH_MAPPING_CustomGrid']//button[text()='Edit']");
    By deleteDateEncodingBtn = By.xpath("///div[@id='MONTH_MAPPING_CustomGrid']//button[text()='Delete']");
    By characterInput = By.cssSelector("input[placeholder='Character']");
    By valueInput = By.cssSelector("input[id='Value']");
    By notificationMsg = By.cssSelector(".toast-message");
    By ddlDateEncodingDropDown = By.id("ddlDateEncoding");
    By loader = By.cssSelector(".loader");

    public WebElement getDateEncodingRow(String row) {
        return findWebElement(By.xpath("//div[@role='dialog']//tr[@data-grid-row-index='" + row + "']"));
    }

    public WebElement getDateEncodingRowByCode(String code) {
        return findWebElement(By.xpath("//tr[.//td[contains(text(),'" + code + "')]]"));
    }

    public WebElement getAlert(String text) {
        return findWebElement(By.xpath("//div[@role='alert']//li[contains(text(), '" + text + "')]"));
    }

    public void waitSetupProductPageToLoad() {
        waitUntilInvisible(5, loader);
        Waiters.waitForElementToBeDisplay(productLabel);
        Waiters.waitForElementToBeDisplay(productTypeLabel);
        Waiters.waitForElementToBeDisplay(unitOfMeasureLabel);
        Waiters.waitForElementToBeDisplay(unitStatusLabel);
        Waiters.waitForElementToBeDisplay(qualityControlTypeLabel);
        Waiters.waitForElementToBeDisplay(putAwayRuleLabel);
        Waiters.waitForElementToBeDisplay(aliasTypeLabel);
        Waiters.waitForElementToBeDisplay(movementClassLabel);
        Waiters.waitForElementToBeDisplay(genericLookupTypeLabel);
        Waiters.waitForElementToBeDisplay(pickSlotTypeLabel);
        Waiters.waitForElementToBeDisplay(dateEncodingLabel);
    }

    public void selectProduct(String product) {
        typeText(getSelectProductInput(), product);
        pressTab(getSelectProductInput());
    }

    public void selectUOMFromGrid(int index) {
        clickOnElement(getUomRows().get(index));
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getWarehouse());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectActive(String active) {
        clickOnElement(getActive());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + active + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickCancelBtn() {
        Waiters.waitForElementToBeDisplay(cancelBtn);
        clickOnElement(cancelBtn);
    }

    public void clickOkBtn() {
        Waiters.waitForElementToBeDisplay(okBtn);
        clickOnElement(okBtn);
    }

    public void clickOKButton() {
        Waiters.waitForElementToBeDisplay(okButton);
        clickOnElement(okButton);
    }

    public void clickCodeFilter() {
        Waiters.waitForElementToBeDisplay(getCodeFilter());
        clickOnElement(getCodeFilter());
    }

    public void clickDescFilter() {
        Waiters.waitForElementToBeDisplay(getDescFilter());
        clickOnElement(getDescFilter());
    }

    public void clickDayMappingFilter() {
        Waiters.waitForElementToBeDisplay(getDayMappingFilter());
        clickOnElement(getDayMappingFilter());
    }

    public void clickMonthMappingFilter() {
        Waiters.waitForElementToBeDisplay(getMonthMappingFilter());
        clickOnElement(getMonthMappingFilter());
    }

    public void clickExtractDateAsFilter() {
        Waiters.waitForElementToBeDisplay(getExtractDateAsFilter());
        clickOnElement(getExtractDateAsFilter());
    }

    public void clickYearMappingFilter() {
        Waiters.waitForElementToBeDisplay(getYearMappingFilter());
        clickOnElement(getYearMappingFilter());
    }

    public void clickWeekMappingFilter() {
        Waiters.waitForElementToBeDisplay(getWeekMappingFilter());
        clickOnElement(getWeekMappingFilter());
    }

    public void clickAddFilterButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAddFilter());
        clickOnElement(getAddFilter());
    }

    public void checkIsEmptyRadioButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getIsEmptyRadioButton());
        clickOnElement(getIsEmptyRadioButton());
    }

    public void typeFilter(String filter) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getInputContains());
        inputText(getInputContains(), filter);
    }

    public void clickApplyButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getApplyButton());
        clickOnElement(getApplyButton());
    }

    public void clickClearAllButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getСlearAllButton());
        clickOnElement(getСlearAllButton());
    }

    public void selectIncludeOpportunistic() {
        if(!getHazardCheckbox().isSelected()) {
            clickOnElement(getHazardCheckbox());
        }
    }

    public void unselectIncludeOpportunistic() {
        if(getHazardCheckbox().isSelected()) {
            clickOnElement(getHazardCheckbox());
        }
    }

    public void clickProductLabel() {
        Waiters.waitForElementToBeDisplay(getProductLabel());
        clickOnElement(getProductLabel());
    }

    public void clickProductTypeLabel() {
        Waiters.waitForElementToBeDisplay(getProductTypeLabel());
        clickOnElement(getProductTypeLabel());
    }

    public void clickUnitStatusLabel() {
        Waiters.waitForElementToBeDisplay(getUnitStatusLabel());
        clickOnElement(getUnitStatusLabel());
    }

    public void clickQualityControlTypeLabel() {
        Waiters.waitForElementToBeDisplay(getQualityControlTypeLabel());
        clickOnElement(getQualityControlTypeLabel());
    }

    public void clickPutAwayRuleLabel() {
        Waiters.waitForElementToBeDisplay(getPutAwayRuleLabel());
        clickOnElement(getPutAwayRuleLabel());
    }

    public void clickAliasTypeLabel() {
        Waiters.waitForElementToBeDisplay(getAliasTypeLabel());
        clickOnElement(getAliasTypeLabel());
    }

    public void clickMovementClassLabel() {
        Waiters.waitForElementToBeDisplay(getMovementClassLabel());
        clickOnElement(getMovementClassLabel());
    }

    public void clickGenericLookupTypeLabel() {
        Waiters.waitForElementToBeDisplay(getGenericLookupTypeLabel());
        clickOnElement(getGenericLookupTypeLabel());
    }

    public void clickPickSlotTypeLabel() {
        Waiters.waitForElementToBeDisplay(getPickSlotTypeLabel());
        clickOnElement(getPickSlotTypeLabel());
    }

    public void clickDateEncodingLabel() {
        Waiters.waitForElementToBeDisplay(getDateEncodingLabel());
        clickOnElement(getDateEncodingLabel());
    }

    public void clickEncodingLabel() {
        Waiters.waitForElementToBeDisplay(encodingLabel);
        clickOnElement(encodingLabel);
    }

    public void clickUsedByTabLabel() {
        Waiters.waitForElementToBeDisplay(getUsedByTab());
        clickOnElement(getUsedByTab());
    }

    public void clickDayMappingTabLabel() {
        Waiters.waitForElementToBeDisplay(getDayMpngTab());
        clickOnElement(getDayMpngTab());
    }

    public void clickMonthMappingTabLabel() {
        Waiters.waitForElementToBeDisplay(getMonthMpngTab());
        clickOnElement(getMonthMpngTab());
    }

    public void clickYearMappingTabLabel() {
        Waiters.waitForElementToBeDisplay(getYearMpngTab());
        clickOnElement(getYearMpngTab());
    }

    public void clickWeekMappingTabLabel() {
        Waiters.waitForElementToBeDisplay(getWeekMpngTab());
        clickOnElement(getWeekMpngTab());
    }

    public void clickAddNewProduct() {
        Waiters.waitForElementToBeDisplay(getAddNewProductButton());
        clickOnElement(getAddNewProductButton());
    }

    public void clickProductTab() {
        Waiters.waitForElementToBeDisplay(getProductTab());
        clickOnElement(getProductTab());
    }

    public void clickWarehouseTab() {
        Waiters.waitForElementToBeDisplay(getWarehouseTab());
        clickOnElement(getWarehouseTab());
    }

    public void clickUomTab() {
        Waiters.waitForElementToBeDisplay(getUomTab());
        clickOnElement(getUomTab());
    }

    public void clickSuppliersTab() {
        Waiters.waitForElementToBeDisplay(getSuppliersTab());
        clickOnElement(getSuppliersTab());
    }

    public void clickAddNew() {
        Waiters.waitForElementToBeDisplay(addProductBtn);
        clickOnElement(addProductBtn);
    }

    public void clickAddDateEncoding() {
        Waiters.waitForElementToBeDisplay(getAddSettingsButton());
        clickOnElement(getAddSettingsButton());
    }

    public void selectExtractDateAs(String date) {
        clickOnElement(getExtractDateAsDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + date + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickExtractDateAsDropDown() {
        Waiters.waitForElementToBeDisplay(getExtractDateAsDropDown());
        clickOnElement(getExtractDateAsDropDown());
    }

    public String getExtractDateAsText() {
        Waiters.waitForElementToBeDisplay(getExtractDateAsDropDown());
        return getText(getExtractDateAsDropDown());
    }

    public void clickDayMappingDropDown() {
        Waiters.waitForElementToBeDisplay(getDayMapOdDropDown());
        clickOnElement(getDayMapOdDropDown());
    }

    public void selectDayMapping(String dayMapping) {
        clickOnElement(getDayMapOdDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + dayMapping + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public String getDayMappingText() {
        Waiters.waitForElementToBeDisplay(getDayMapOdDropDown());
        return getText(getDayMapOdDropDown());
    }

    public void clickMonthMappingDropDown() {
        Waiters.waitForElementToBeDisplay(getMonthMapOdDropDown());
        clickOnElement(getMonthMapOdDropDown());
    }

    public void selectMonthMapping(String monthMapping) {
        clickOnElement(getMonthMapOdDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + monthMapping + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public String getMonthMappingText() {
        Waiters.waitForElementToBeDisplay(getMonthMapOdDropDown());
        return getText(getMonthMapOdDropDown());
    }

    public String getYearMappingText() {
        Waiters.waitForElementToBeDisplay(getYearMapOdDropDown());
        return getText(getYearMapOdDropDown());
    }

    public void clickYearMappingDropDown() {
        Waiters.waitForElementToBeDisplay(getYearMapOdDropDown());
        clickOnElement(getYearMapOdDropDown());
    }

    public void selectYearMapping(String yearMapping) {
        clickOnElement(getYearMapOdDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + yearMapping + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public String getWeekMappingText() {
        Waiters.waitForElementToBeDisplay(getWeekMapOdDropDown());
        return getText(getWeekMapOdDropDown());
    }

    public void clickWeekMappingDropDown() {
        Waiters.waitForElementToBeDisplay(getWeekMapOdDropDown());
        clickOnElement(getWeekMapOdDropDown());
    }

    public void selectWeekMapping(String weekMapping) {
        clickOnElement(getWeekMapOdDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + weekMapping + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickCopyProduct() {
        Waiters.waitForElementToBeDisplay(getCopyProductButton());
        clickOnElement(getCopyProductButton());
    }

    public void clickEditProduct() {
        Waiters.waitForElementToBeDisplay(getEditProductButton());
        clickOnElement(getEditProductButton());
    }

    public void clickEditBtn() {
        Waiters.waitForElementToBeDisplay(getEditBtn());
        clickOnElement(getEditBtn());
    }

    public void clickDeleteBtn() {
        Waiters.waitForElementToBeDisplay(getDeleteBtn());
        clickOnElement(getDeleteBtn());
    }

    public void clickDeleteSettingsBtn() {
        Waiters.waitForElementToBeDisplay(getDeleteSettingsButton());
        clickOnElement(getDeleteSettingsButton());
        Waiters.waitABit(2000);
    }

    public void clickEditSettingsBtn() {
        Waiters.waitForElementToBeDisplay(getEditSettingsButton());
        clickOnElement(getEditSettingsButton());
    }

    public void checkIndividualCatchWeight() {
        Waiters.waitForElementToBeDisplay(getIndividualCatchWeightCheckBox());
        if(!isElementSelected(isIndividualCatchWeight)){
            clickOnElement(getIndividualCatchWeightCheckBox());
        }
    }

    public void clickDeleteButton() {
        Waiters.waitForElementToBeDisplay(getDeleteButton());
        clickOnElement(getDeleteButton());
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeDisplay(getCancelButton());
        clickOnElement(getCancelButton());
    }

    public void clickSaveButton() {
        Waiters.waitForElementToBeDisplay(getSaveButton());
        clickOnElement(getSaveButton());
    }

    public void clickSave() {
        Waiters.waitForElementToBeDisplay(saveBtn);
        clickOnElement(saveBtn);
    }

    public void clickCancel() {
        Waiters.waitForElementToBeDisplay(cancelBtn);
        clickOnElement(cancelBtn);
    }

    public void clickAdd() {
        Waiters.waitForElementToBeDisplay(getAdd());
        clickOnElement(getAdd());
    }

    public void clickEdit() {
        Waiters.waitForElementToBeDisplay(getEdit());
        clickOnElement(getEdit());
    }

    public void clickDelete() {
        Waiters.waitForElementToBeDisplay(getDelete());
        clickOnElement(getDelete());
    }

    public void selectRowByNum(String index) {
        Waiters.waitForElementToBeDisplay(getDateEncodingRow(index));
        clickOnElement(getDateEncodingRow(index));
    }

    public void selectRowByCode(String code) {
        Waiters.waitForElementToBeDisplay(getDateEncodingRowByCode(code));
        clickOnElement(getDateEncodingRowByCode(code));
    }

    public void typeCharacter(String code) {
        Waiters.waitForElementToBeDisplay(getCharacterInput());
        enterText(getCharacterInput(), code);
    }

    public void typeValue(String code) {
        Waiters.waitForElementToBeDisplay(getValueInput());
        enterText(getValueInput(), code);
    }

    public void clickShippingTab() {
        Waiters.waitForElementToBeDisplay(getSetupShippingLabel());
        clickOnElement(getSetupShippingLabel());
    }

    public void clickDateEncodingDropDown() {
        Waiters.waitForElementToBeDisplay(getDateEncodingDropDown());
        clickOnElement(getDateEncodingDropDown());
    }

    public void typeProductCode(String code) {
        Waiters.waitForElementToBeDisplay(getTextProductCodeInput());
        enterText(getTextProductCodeInput(), code);
    }

    public void typeLongDescription(String description) {
        Waiters.waitForElementToBeDisplay(getTextLognDescription());
        enterText(getTextLognDescription(), description);
    }

    public void typeAltDescription(String description) {
        Waiters.waitForElementToBeDisplay(getTxtAltDescription());
        enterText(getTxtAltDescription(), description);
    }

    public void typeSizeCode(String code) {
        Waiters.waitForElementToBeDisplay(getTxtSizeCode());
        enterText(getTxtSizeCode(), code);
    }

    public void typeTie(String tie) {
        Waiters.waitForElementToBeDisplay(getTxtTie());
        enterText(getTxtTie(), tie);
    }

    public void typeVoicedCode(String code) {
        Waiters.waitForElementToBeDisplay(getTxtVoicedCode());
        enterText(getTxtVoicedCode(), code);
    }

    public void typeHigh(String txt) {
        Waiters.waitForElementToBeDisplay(getTxtHigh());
        enterText(getTxtHigh(), txt);
    }

    public void typeMaxStack(String stack) {
        Waiters.waitForElementToBeDisplay(getTxtMaxStack());
        enterText(getTxtMaxStack(), stack);
    }

    public void typeInputCode(String text) {
        Waiters.waitABit(2000);
        enterText(getInputCode(), text);
    }

    public void typeInputDesc(String text) {
        Waiters.waitABit(2000);
        enterText(getInputDesc(), text);
    }

    public void typeInputLotMask(String text) {
        Waiters.waitABit(2000);
        enterText(getInputLotMask(), text);
    }

    public void typeCharacterInput(String text) {
        Waiters.waitForElementToBeDisplay(getCharacterInput());
        enterText(getCharacterInput(), text);
    }

    public void typeValueInput(String text) {
        Waiters.waitForElementToBeDisplay(getValueInput());
        enterText(getValueInput(), text);
    }

    public void selectProductType(String type) {
        clickOnElement(getProductType());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + type + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectMovementClass(String clazz) {
        clickOnElement(getMovementClass());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + clazz + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectExclusiveOwner(String owner) {
        clickOnElement(getExclusiveOwner());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + owner + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectUOM(String uom) {
        clickOnElement(getUOMdropdown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + uom + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickUOMDropdown() { clickOnElement(getUOMdropdown()); }

    public void moveToUOMDropdown() { pressTab(getUOMdropdown()); }

    public void moveToWeightUnitDropdown() { pressTab(getTxtWeightUnit()); }

    public void moveToTareWeightDropdown() { pressTab(getTxtTareWeightUnit()); }

    public void moveToWidthUnitDropdown() { pressTab(getTxtWidthUnit()); }

    public void moveToNextWidthUnitDropdown() { pressTab(getTxtNextWidthUnit()); }

    public void moveToHeightUnitDropdown() { pressTab(getTxtHeightUnit()); }

    public void moveToNextHeightUnitDropdown() { pressTab(getTxtNextHeightUnit()); }

    public void moveToLengthUnitDropdown() { pressTab(getTxtLengthUnit()); }

    public void moveToNextLengthUnitDropdown() { pressTab(getTxtNextLengthUnit()); }

    public void moveToCutTimeUnitDropdown() { pressTab(getTxtCutTimeUnit()); }

    public List<String> getOptions() {
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"))
                .stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    public String getDialogTitleText() {
        Waiters.waitForElementToBeDisplay(dialogTitle);
        return getText(dialogTitle);
    }

    public void enterPack(String pack) {
        Waiters.waitForElementToBeDisplay(getPack());
        enterText(getPack(), pack);
    }

    public void enterWeight(String weight) {
        Waiters.waitForElementToBeDisplay(getTxtWeight());
        enterText(getTxtWeight(), weight);
    }

    public String getWeightValue() {
        Waiters.waitForElementToBeDisplay(getTxtWeight());
        return getValue(getTxtWeight());
    }

    public void clickWeightUnit() { clickOnElement(getTxtWeightUnit()); }

    public void enterTareWeight(String tareWeight) {
        Waiters.waitForElementToBeDisplay(getTxtTareWeight());
        enterText(getTxtTareWeight(), tareWeight);
    }

    public String getTareWeightValue() {
        Waiters.waitForElementToBeDisplay(getTxtTareWeight());
        return getValue(getTxtTareWeight());
    }

    public void clickTareWeightUnit() { clickOnElement(getTxtTareWeightUnit()); }

    public void enterWidth(String width) {
        Waiters.waitForElementToBeDisplay(getTxtWidth());
        enterText(getTxtWidth(), width);
    }

    public String getWidthValue() {
        Waiters.waitForElementToBeDisplay(getTxtWidth());
        return getValue(getTxtWidth());
    }

    public void clickWidthUnit() { clickOnElement(getTxtWidthUnit()); }

    public void enterNextWidth(String height) {
        Waiters.waitForElementToBeDisplay(getTxtNextWidth());
        enterText(getTxtNextWidth(), height);
     }

    public String getNextWidthValue() {
        Waiters.waitForElementToBeDisplay(getTxtNextWidth());
        return getValue(getTxtNextWidth());
    }

    public void clickNextWidthUnit() { clickOnElement(getTxtNextWidthUnit()); }

    public void enterHeight(String height) {
        Waiters.waitForElementToBeDisplay(getTxtHeight());
        enterText(getTxtHeight(), height);
    }

    public String getHeightValue() {
        Waiters.waitForElementToBeDisplay(getTxtHeight());
        return getValue(getTxtHeight());
    }

    public void clickHeightUnitUnit() { clickOnElement(getTxtHeightUnit()); }

    public void enterNextHeight(String height) {
        Waiters.waitForElementToBeDisplay(getTxNextHeight());
        enterText(getTxNextHeight(), height);
    }

    public String getNextHeightValue() {
        Waiters.waitForElementToBeDisplay(getTxNextHeight());
        return getValue(getTxNextHeight());
    }

    public void clickNextHeightUnit() { clickOnElement(getTxtNextHeightUnit()); }

    public void enterLength(String length) {
        Waiters.waitForElementToBeDisplay(getTxtLength());
        enterText(getTxtLength(), length);
    }

    public String getLengthValue() {
        Waiters.waitForElementToBeDisplay(getTxtLength());
        return getValue(getTxtLength());
    }

    public void clickLengthUnit() { clickOnElement(getTxtLengthUnit()); }

    public void enterNextLength(String length) {
        Waiters.waitForElementToBeDisplay(getTxtNextLength());
        enterText(getTxtNextLength(), length);
    }

    public String getNextLengthValue() {
        Waiters.waitForElementToBeDisplay(getTxtNextLength());
        return getValue(getTxtNextLength());
    }

    public void clickNextLengthUnit() { clickOnElement(getTxtNextLengthUnit()); }

    public void enterCutTime(String time) {
        Waiters.waitForElementToBeDisplay(getTxtCutTime());
        enterText(getTxtCutTime(), time);
    }

    public String getCutTimeValue() {
        Waiters.waitForElementToBeDisplay(getTxtCutTime());
        return getValue(getTxtCutTime());
    }

    public void clickCutTimeUnit() { clickOnElement(getTxtCutTimeUnit()); }

    public void clickShelfUnit() { clickOnElement(getTxtShelfUnit()); }

    public void enterShelfUnit(String unit) {
        Waiters.waitForElementToBeDisplay(getTxtShelfUnit());
        enterText(getTxtShelfUnit(), unit);
    }

    public String getShelfUnitValue() {
        Waiters.waitForElementToBeDisplay(getTxtShelfUnit());
        return getValue(getTxtShelfUnit());
    }

    public void enterSizeCode(String code) {
        Waiters.waitForElementToBeDisplay(getSizeCode());
        enterText(getSizeCode(), code);
    }

    public String getSizeCodeValue() {
        Waiters.waitForElementToBeDisplay(getSizeCode());
        return getValue(getSizeCode());
    }

    public void enterDayMapping0(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping0());
        enterText(getDayMapping0(), mapping);
    }

    public void enterDayMapping1(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping1());
        enterText(getDayMapping1(), mapping);
    }

    public void enterDayMapping2(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping2());
        enterText(getDayMapping2(), mapping);
    }

    public void enterDayMapping3(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping3());
        enterText(getDayMapping3(), mapping);
    }

    public void enterDayMapping4(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping4());
        enterText(getDayMapping4(), mapping);
    }

    public void enterDayMapping5(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping5());
        enterText(getDayMapping5(), mapping);
    }

    public void enterDayMapping6(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping6());
        enterText(getDayMapping6(), mapping);
    }

    public void enterDayMapping7(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping7());
        enterText(getDayMapping7(), mapping);
    }

    public void enterDayMapping8(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping8());
        enterText(getDayMapping8(), mapping);
    }

    public void enterDayMapping9(String mapping) {
        Waiters.waitForElementToBeDisplay(getDayMapping9());
        enterText(getDayMapping9(), mapping);
    }

    public void enterMonthMapping0(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping0());
        enterText(getMonthMapping0(), mapping);
    }

    public void enterMonthMapping1(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping1());
        enterText(getMonthMapping1(), mapping);
    }

    public void enterMonthMapping2(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping2());
        enterText(getMonthMapping2(), mapping);
    }

    public void enterMonthMapping3(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping3());
        enterText(getMonthMapping3(), mapping);
    }

    public void enterMonthMapping4(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping4());
        enterText(getMonthMapping4(), mapping);
    }

    public void enterMonthMapping5(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping5());
        enterText(getMonthMapping5(), mapping);
    }

    public void enterMonthMapping6(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping6());
        enterText(getMonthMapping6(), mapping);
    }

    public void enterMonthMapping7(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping7());
        enterText(getMonthMapping7(), mapping);
    }

    public void enterMonthMapping8(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping8());
        enterText(getMonthMapping8(), mapping);
    }

    public void enterMonthMapping9(String mapping) {
        Waiters.waitForElementToBeDisplay(getMonthMapping9());
        enterText(getMonthMapping9(), mapping);
    }

    public void enterYearMapping0(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping0());
        enterText(getYearMapping0(), mapping);
    }

    public void enterYearMapping1(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping1());
        enterText(getYearMapping1(), mapping);
    }

    public void enterYearMapping2(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping2());
        enterText(getYearMapping2(), mapping);
    }

    public void enterYearMapping3(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping3());
        enterText(getYearMapping3(), mapping);
    }

    public void enterYearMapping4(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping4());
        enterText(getYearMapping4(), mapping);
    }

    public void enterYearMapping5(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping5());
        enterText(getYearMapping5(), mapping);
    }

    public void enterYearMapping6(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping6());
        enterText(getYearMapping6(), mapping);
    }

    public void enterYearMapping7(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping7());
        enterText(getYearMapping7(), mapping);
    }

    public void enterYearMapping8(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping8());
        enterText(getYearMapping8(), mapping);
    }

    public void enterYearMapping9(String mapping) {
        Waiters.waitForElementToBeDisplay(getYearMapping9());
        enterText(getYearMapping9(), mapping);
    }

    public void enterWeekMapping0(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping0());
        enterText(getWeekMapping0(), mapping);
    }

    public void enterWeekMapping1(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping1());
        enterText(getWeekMapping1(), mapping);
    }

    public void enterWeekMapping2(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping2());
        enterText(getWeekMapping2(), mapping);
    }

    public void enterWeekMapping3(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping3());
        enterText(getWeekMapping3(), mapping);
    }

    public void enterWeekMapping4(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping4());
        enterText(getWeekMapping4(), mapping);
    }

    public void enterWeekMapping5(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping5());
        enterText(getWeekMapping5(), mapping);
    }

    public void enterWeekMapping6(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping6());
        enterText(getWeekMapping6(), mapping);
    }

    public void enterWeekMapping7(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping7());
        enterText(getWeekMapping7(), mapping);
    }

    public void enterWeekMapping8(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping8());
        enterText(getWeekMapping8(), mapping);
    }

    public void enterWeekMapping9(String mapping) {
        Waiters.waitForElementToBeDisplay(getWeekMapping9());
        enterText(getWeekMapping9(), mapping);
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsCount);
    }

    public String getNotificationMsgText() {
        Waiters.waitABit(2000);
        return getText(getNotificationMsg());
    }

    public String getNotificationText() { return getText(getNotification()); }

    public boolean isDateEncodingRowDisplayed(String row) { return isElementDisplay(getDateEncodingRow(row)); }

    public boolean isItemsCountDisplayed() { return isElementDisplay(itemsCount); }

    public boolean isItemsFoundDisplayed() { return isElementDisplay(itemsFound); }

    public boolean isNameTabDisplayed() { return isElementDisplay(nameTab); }

    public boolean isLengthTabDisplayed() { return isElementDisplay(lengthTab); }

    public boolean isWidthTabDisplayed() { return isElementDisplay(widthTab); }

    public boolean isHeightTabDisplayed() { return isElementDisplay(heightTab); }

    public boolean isCubeTabDisplayed() { return isElementDisplay(cubeTab); }

    public boolean isWeightTabDisplayed() { return isElementDisplay(weightTab); }

    public boolean isTareTabDisplayed() { return isElementDisplay(tareTab); }

    public boolean isPacksizeTabDisplayed() { return isElementDisplay(packsizeTab); }

    public boolean isProductLabelDisplayed() { return isElementDisplay(productLabel); }

    public boolean isProductTypeLabelDisplayed() { return isElementDisplay(productTypeLabel); }

    public boolean isUnitOfMeasureLabelDisplayed() { return isElementDisplay(unitOfMeasureLabel); }

    public boolean isUnitStatusLabelDisplayed() { return isElementDisplay(unitStatusLabel); }

    public boolean isQualityControlTypeLabelDisplayed() { return isElementDisplay(qualityControlTypeLabel); }

    public boolean isPutAwayRuleLabelDisplayed() { return isElementDisplay(putAwayRuleLabel); }

    public boolean isAliasTypeLabelDisplayed() { return isElementDisplay(aliasTypeLabel); }

    public boolean isMovementClassLabelDisplayed() { return isElementDisplay(movementClassLabel); }

    public boolean isGenericLookupTypeLabelDisplayed() { return isElementDisplay(genericLookupTypeLabel); }

    public boolean isPickSlotTypeLabelDisplayed() { return isElementDisplay(pickSlotTypeLabel); }

    public boolean isDateEncodingLabelDisplayed() { return isElementDisplay(dateEncodingLabel); }

    public boolean isAddProductBtnDisplayed() { return isElementDisplay(addProductBtn); }

    public boolean isEditProductBtnDisplayed() { return isElementDisplay(editProductBtn); }

    public boolean isDeleteProductBtnDisplayed() { return isElementDisplay(deleteProductBtn); }

    public boolean isOKBtnDisplayed() { return isElementDisplay(okBtn); }

    public boolean isCancelBtnDisplayed() { return isElementDisplay(cnlBtn); }

    public boolean isReceivingUOMLabelDisplayed() { return isElementDisplay(getReceivingUOMLabel()); }

    public boolean isReceivingUOMDisplayed() { return isElementDisplay(getReceivingUOM()); }

    public boolean isMovementUOMLabelDisplayed() { return isElementDisplay(getMovementUOMLabel()); }

    public boolean isMovementUOMDisplayed() { return isElementDisplay(getMovementUOM()); }

    public boolean isShippingUOMLabelDisplayed() { return isElementDisplay(getShippingUOMLabel()); }

    public boolean isShippingUOMDisplayed() { return isElementDisplay(getShippingUOM()); }

    public boolean isDateEncodingTabDisplayed() { return isElementDisplay(getDateEncodingTab()); }

    public boolean isCodeTabDisplayed() { return isElementDisplay(getCodeTab()); }

    public boolean isDescTabDisplayed() { return isElementDisplay(getDescTab()); }

    public boolean isDayMappingTabDisplayed() { return isElementDisplay(getDayMappingTab()); }

    public boolean isMonthMappingTabDisplayed() { return isElementDisplay(getMonthMappingTab()); }

    public boolean isExtractDateAsTabDisplayed() { return isElementDisplay(getExtractDateAsTab()); }

    public boolean isYearMappingTabDisplayed() { return isElementDisplay(getYearMappingTab()); }

    public boolean isWeekMappingTabDisplayed() { return isElementDisplay(getWeekMappingTab()); }

    public boolean isAddSettingsButtonDisplayed() { return isElementDisplay(getAddSettingsButton()); }

    public boolean isEditSettingsButtonDisplayed() { return isElementDisplay(getEditSettingsButton()); }

    public boolean isDeleteSettingsDisplayed() { return isElementDisplay(getDeleteSettingsButton()); }

    public boolean isAddFilterDisplayed() { return isElementDisplay(getAddFilter()); }

    public boolean isSearchBoxDisplayed() { return isElementDisplay(getSearchBox()); }

    public String checkAddBtnDisabled() { return checkElementAttribute(getAddBtn(), "aria-disabled"); }

    public String isEditBtnDisabled() { return getElementAttribute(getEditBtn(), "aria-disabled"); }

    public String isDeleteBtnDisabled() { return getElementAttribute(getDeleteBtn(), "aria-disabled"); }

    public String checkAddDisabled() { return checkElementAttribute(getAdd(), "aria-disabled"); }

    public String isEditDisabled() { return getElementAttribute(getEdit(), "aria-disabled"); }

    public String isDeleteDisabled() { return getElementAttribute(getDelete(), "aria-disabled"); }

    public String isEncodingTabDisabled() { return checkElementAttribute(getEncodingTab(), "class"); }

    public String isUsedByTabDisabled() { return checkElementAttribute(getUsedByTab(), "class"); }

    public String isDayMappingTabDisabled() { return checkElementAttribute(getDayMpngTab(), "class"); }

    public String isMonthMappingTabDisabled() { return checkElementAttribute(getMonthMpngTab(), "class"); }

    public String isYearMappingTabDisabled() { return checkElementAttribute(getYearMpngTab(), "class"); }

    public String isWeekMappingTabDisabled() { return checkElementAttribute(getWeekMpngTab(), "class"); }

    public boolean isEncodingTabDisplayed() { return isElementDisplay(getEncodingTab()); }

    public boolean isUsedByTabDisplayed() { return isElementDisplay(getUsedByTab()); }

    public boolean isDayMpngTabDisplayed() { return isElementDisplay(getDayMpngTab()); }

    public boolean isMonthMpngTabDisplayed() { return isElementDisplay(getMonthMpngTab()); }

    public boolean isYearMpngTabDisplayed() { return isElementDisplay(getYearMpngTab()); }

    public boolean isWeekMpngTabDisplayed() { return isElementDisplay(getWeekMpngTab()); }

    public boolean isCodeLabelDisplayed() { return isElementDisplay(getCodeLabel()); }

    public boolean isInputCodeDisplayed() { return isElementDisplay(getInputCode()); }

    public boolean isDescLabelDisplayed() { return isElementDisplay(getDescLabel()); }

    public boolean isInputDescDisplayed() { return isElementDisplay(getInputDesc()); }

    public boolean isLotMaskDisplayed() { return isElementDisplay(getLotMaskLabel()); }

    public boolean isInputLotMaskDisplayed() { return isElementDisplay(getInputLotMask()); }

    public boolean isExtractDateAsLabelDisplayed() { return isElementDisplay(getExtractDateAsLabel()); }

    public boolean isExtractDateAsDropDownDisplayed() { return isElementDisplay(getExtractDateAsDropDown()); }

    public boolean isPromptLabelDisplayed() { return isElementDisplay(getPromptLabel()); }

    public boolean isInputPromptDisplayed() { return isElementDisplay(getInputPrompt()); }

    public boolean isDayMappingLabelDisplayed() { return isElementDisplay(getDayMappingLabel()); }

    public boolean isDayMapDropDownDisplayed() { return isElementDisplay(getDayMapOdDropDown()); }

    public boolean isMonthMappingLabelDisplayed() { return isElementDisplay(getMonthMappingLabel()); }

    public boolean isMonthMapDropDownDisplayed() { return isElementDisplay(getMonthMapOdDropDown()); }

    public boolean isYearMappingLabelDisplayed() { return isElementDisplay(getYearMappingLabel()); }

    public boolean isYearMapDropDownDisplayed() { return isElementDisplay(getYearMapOdDropDown()); }

    public boolean isWeekMappingLabelDisplayed() { return isElementDisplay(getWeekMappingLabel()); }

    public boolean isWeekMapDropDownDisplayed() { return isElementDisplay(getWeekMapOdDropDown()); }

    public boolean isSupplierColumnDisplayed() { return isElementDisplay(getSupplierColumn()); }

    public boolean isProductColumnDisplayed() { return isElementDisplay(getProductColumn()); }

    public boolean isMonthMapping0LabelDisplayed() { return isElementDisplay(getMonthMapping0Label()); }

    public boolean isMonthMapping0Displayed() { return isElementDisplay(getMonthMapping0()); }

    public boolean isMonthMapping1LabelDisplayed() { return isElementDisplay(getMonthMapping1Label()); }

    public boolean isMonthMapping1Displayed() { return isElementDisplay(getMonthMapping1()); }

    public boolean isMonthMapping2LabelDisplayed() { return isElementDisplay(getMonthMapping2Label()); }

    public boolean isMonthMapping2Displayed() { return isElementDisplay(getMonthMapping2()); }

    public boolean isMonthMapping3LabelDisplayed() { return isElementDisplay(getMonthMapping3Label()); }

    public boolean isMonthMapping3Displayed() { return isElementDisplay(getMonthMapping3()); }

    public boolean isMonthMapping4LabelDisplayed() { return isElementDisplay(getMonthMapping4Label()); }

    public boolean isMonthMapping4Displayed() { return isElementDisplay(getMonthMapping4()); }

    public boolean isMonthMapping5LabelDisplayed() { return isElementDisplay(getMonthMapping5Label()); }

    public boolean isMonthMapping5Displayed() { return isElementDisplay(getMonthMapping5()); }

    public boolean isMonthMapping6LabelDisplayed() { return isElementDisplay(getMonthMapping6Label()); }

    public boolean isMonthMapping6Displayed() { return isElementDisplay(getMonthMapping6()); }

    public boolean isMonthMapping7LabelDisplayed() { return isElementDisplay(getMonthMapping7Label()); }

    public boolean isMonthMapping7Displayed() { return isElementDisplay(getMonthMapping7()); }

    public boolean isMonthMapping8LabelDisplayed() { return isElementDisplay(getMonthMapping8Label()); }

    public boolean isMonthMapping8Displayed() { return isElementDisplay(getMonthMapping8()); }

    public boolean isMonthMapping9LabelDisplayed() { return isElementDisplay(getMonthMapping9Label()); }

    public boolean isMonthMapping9Displayed() { return isElementDisplay(getMonthMapping9()); }

    public WebElement getProductLabel() { return findWebElement(productLabel); }

    public WebElement getProductTypeLabel() { return findWebElement(productTypeLabel); }

    public WebElement getUnitOfMeasureLabel() { return findWebElement(unitOfMeasureLabel); }

    public WebElement getUnitStatusLabel() { return findWebElement(unitStatusLabel); }

    public WebElement getQualityControlTypeLabel() { return findWebElement(qualityControlTypeLabel); }

    public WebElement getPutAwayRuleLabel() { return findWebElement(putAwayRuleLabel); }

    public WebElement getAliasTypeLabel() { return findWebElement(aliasTypeLabel); }

    public WebElement getMovementClassLabel() { return findWebElement(movementClassLabel); }

    public WebElement getGenericLookupTypeLabel() { return findWebElement(genericLookupTypeLabel); }

    public WebElement getPickSlotTypeLabel() {  return findWebElement(pickSlotTypeLabel); }

    public WebElement getDateEncodingLabel() { return findWebElement(dateEncodingLabel); }

    public WebElement getSelectProductInput() { return findWebElement(selectProductInput); }

    public WebElement getProductInputLabel() { return findWebElement(productInputLabel); }

    public WebElement getSearchProductButton() { return findWebElement(searchProductButton); }

    public WebElement getAddNewProductButton() { return findWebElement(addNewProductButton); }

    public WebElement getCopyProductButton() { return findWebElement(copyProductButton); }

    public WebElement getEditProductButton() { return findWebElement(editProductButton); }

    public WebElement getDeleteButton() { return findWebElement(deleteButton); }

    public WebElement getCancelButton() { return findWebElement(cancelButton); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getSetupProductLabel() { return findWebElement(setupProductLabel); }

    public WebElement getSetupAliasLabel() { return findWebElement(setupAliasLabel); }

    public WebElement getSetupWarehouseLabel() { return findWebElement(setupWarehouseLabel); }

    public WebElement getSetupUOMLabel() { return findWebElement(setupUOMLabel); }

    public WebElement getSetupOwnersLabel() { return findWebElement(setupOwnersLabel); }

    public WebElement getSetupSuppliersLabel() { return findWebElement(setupSuppliersLabel); }

    public WebElement getSetupReceivingLabel() { return findWebElement(setupReceivingLabel); }

    public WebElement getSetupShippingLabel() { return findWebElement(setupShippingLabel); }

    public WebElement getIndividualCatchWeightCheckBox() { return findWebElement(isIndividualCatchWeight); }

    public WebElement getSetupInventoryLabel() { return findWebElement(setupInventoryLabel); }

    public WebElement getSetupKittingLabel() { return findWebElement(setupKittingLabel); }

    public WebElement getSetupHazardLabel() { return findWebElement(setupHazardLabel); }

    public WebElement getSetupPickingLabel() { return findWebElement(setupPickingLabel); }

    public WebElement getSetupStockingLabel() { return findWebElement(setupStockingLabel); }

    public WebElement getTextProductCodeLabel() { return findWebElement(textProductCodeLabel); }

    public WebElement getTextProductCodeInput() { return findWebElement(textProductCode); }

    public WebElement getTextLognDescriptionLabel() { return findWebElement(textLognDescriptionLabel); }

    public WebElement getTextLognDescription() { return findWebElement(textLognDescription); }

    public WebElement getTxtAltDescriptionLabel() { return findWebElement(txtAltDescriptionLabel); }

    public WebElement getTxtAltDescription() { return findWebElement(txtAltDescription); }

    public WebElement getTxtSizeCodeLabel() { return findWebElement(txtSizeCodeLabel); }

    public WebElement getTxtSizeCode() { return findWebElement(txtSizeCode); }

    public WebElement getTxtTieLabel() { return findWebElement(txtTieLabel); }

    public WebElement getTxtTie() { return findWebElement(txtTie); }

    public WebElement getTxtVoicedCodeLabel() { return findWebElement(txtVoicedCodeLabel); }

    public WebElement getTxtVoicedCode() { return findWebElement(txtVoicedCode); }

    public WebElement getProductTypeLbl() { return findWebElement(productTypeLbl); }

    public WebElement getProductType() { return findWebElement(productType); }

    public WebElement getTxtHighLabel() { return findWebElement(txtHighLabel); }

    public WebElement getTxtHigh() { return findWebElement(txtHigh); }

    public WebElement getExclusiveOwnerLabel() { return findWebElement(exclusiveOwnerLabel); }

    public WebElement getExclusiveOwner() { return findWebElement(exclusiveOwner); }

    public WebElement getMovementClassLbl() { return findWebElement(movementClassLbl); }

    public WebElement getMovementClass() { return findWebElement(movementClass); }

    public WebElement getMaxStackLabel() { return findWebElement(maxStackLabel); }

    public WebElement getTxtMaxStack() { return findWebElement(txtMaxStack); }

    public WebElement getProductTab() { return findWebElement(productTab); }

    public WebElement getWarehouseTab() { return findWebElement(warehouseTab); }

    public WebElement getUomTab() { return findWebElement(uomTab); }

    public WebElement getSuppliersTab() { return findWebElement(suppliersTab); }

    public WebElement getAddBtn() { return findWebElement(addProductBtn); }

    public WebElement getEditBtn() { return findWebElement(editProductBtn); }

    public WebElement getDeleteBtn() { return findWebElement(deleteProductBtn); }

    public WebElement getAdd() { return findWebElement(addBtn); }

    public WebElement getEdit() { return findWebElement(editBtn); }

    public WebElement getDelete() { return findWebElement(deleteBtn); }

    public WebElement getWarehouseLabel() { return findWebElement(warehouseLabel); }

    public WebElement getWarehouse() { return findWebElement(warehouse); }

    public WebElement getActiveLabel() { return findWebElement(activeLabel); }

    public WebElement getActive() { return findWebElement(active); }

    public WebElement getCancelBtn() { return findWebElement(cancelBtn); }

    public WebElement getOkBtn() { return findWebElement(okBtn); }

    public WebElement getReceivingUOMLabel() { return findWebElement(receivingUOMLabel); }

    public WebElement getReceivingUOM() { return findWebElement(receivingUOM); }

    public WebElement getMovementUOMLabel() { return findWebElement(movementUOMLabel); }

    public WebElement getMovementUOM() { return findWebElement(movementUOM); }

    public WebElement getShippingUOMLabel() { return findWebElement(shippingUOMLabel); }

    public WebElement getShippingUOM() { return findWebElement(shippingUOM); }

    public WebElement getUOMLabel() { return findWebElement(UOMLabel); }

    public WebElement getUOMdropdown() { return findWebElement(UOMdropdown); }

    public WebElement getPackLabel() { return findWebElement(qtyLabel); }

    public WebElement getPack() { return findWebElement(txtQty); }

    public WebElement getTxtWeightLabel() { return findWebElement(txtWeightLabel); }

    public WebElement getTxtWeight() { return findWebElement(txtWeight); }

    public WebElement getTxtWeightUnit() { return findWebElement(txtWeightUnit); }

    public WebElement getTxtTareWeightLabel() { return findWebElement(txtTareWeightLabel); }

    public WebElement getTxtTareWeight() { return findWebElement(txtTareWeight); }

    public WebElement getTxtTareWeightUnit() { return findWebElement(txtTareWeightUnit); }

    public WebElement getTxtWidthLabel() { return findWebElement(txtWidthLabel); }

    public WebElement getTxtWidth() { return findWebElement(txtWidth); }

    public WebElement getTxtHeightUnit() { return findWebElement(txtHeightUnit); }

    public WebElement getTxNextHeightLabel() { return findWebElement(txNextHeightLabel); }

    public WebElement getTxNextHeight() { return findWebElement(txNextHeight); }

    public WebElement getTxtNextHeightUnit() { return findWebElement(txNextHeightUnit); }

    public WebElement getTxtLengthLabel() { return findWebElement(txtLengthLabel); }

    public WebElement getTxtLength() { return findWebElement(txtLength); }

    public WebElement getTxtLengthUnit() { return findWebElement(txtLengthUnit); }

    public WebElement getTxtNextLengthLabel() { return findWebElement(txtNextLengthLabel); }

    public WebElement getTxtNextLength() { return findWebElement(txtNextLength); }

    public WebElement getTxtNextLengthUnit() { return findWebElement(txtNextLengthUnit); }

    public WebElement getTxtCutTimeLabel() { return findWebElement(txtCutTimeLabel); }

    public WebElement getTxtCutTime() { return findWebElement(txtCutTime); }

    public WebElement getTxtCutTimeUnit() { return findWebElement(txtCutTimeUnit); }

    public WebElement getTxtShelfUnitLabel() { return findWebElement(txtShelfUnitLabel); }

    public WebElement getTxtShelfUnit() { return findWebElement(txtShelfUnit); }

    public WebElement getSizeCodeLabel() { return findWebElement(sizeCodeLabel); }

    public WebElement getSizeCode() { return findWebElement(sizeCode); }

    public WebElement getTxtWidthUnit() { return findWebElement(txtWidthUnit); }

    public WebElement getTxtNextWidthLabel() { return findWebElement(txtNextWidthLabel); }

    public WebElement getTxtNextWidth() { return findWebElement(txtNextWidth); }

    public WebElement getTxtNextWidthUnit() { return findWebElement(txtNextWidthUnit); }

    public WebElement getTxtHeightLabel() { return findWebElement(txtHeightLabel); }

    public WebElement getTxtHeight() { return findWebElement(txtHeight); }

    public WebElement getHazardCheckbox() { return findWebElement(hazardCheckbox); }

    public List<WebElement> getUomRows() { return findWebElements(uomRows); }

    public WebElement getDateEncodingTab() { return findWebElement(dateEncodingTab); }

    public WebElement getCodeTab() { return findWebElement(codeTab); }

    public WebElement getDescTab() { return findWebElement(descTab); }

    public WebElement getDayMappingTab() { return findWebElement(dayMappingTab); }

    public WebElement getMonthMappingTab() { return findWebElement(monthMappingTab); }

    public WebElement getExtractDateAsTab() { return findWebElement(extractDateAsTab); }

    public WebElement getYearMappingTab() { return findWebElement(yearMappingTab); }

    public WebElement getWeekMappingTab() { return findWebElement(weekMappingTab); }

    public WebElement getAddSettingsButton() { return findWebElement(addSettingsButton); }

    public WebElement getEditSettingsButton() { return findWebElement(editSettingsButton); }

    public WebElement getDeleteSettingsButton() { return findWebElement(deleteSettingsButton); }

    public WebElement getAddFilter() { return findWebElement(addFilter); }

    public WebElement getSearchBox() { return findWebElement(searchBox); }

    public WebElement getIsEmptyRadioButton() { return findWebElement(isEmptyRadioButton); }

    public WebElement getInputContains() { return findWebElement(inputContains); }

    public WebElement getApplyButton() { return findWebElement(applyButton); }

    public WebElement getСlearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getCodeFilter() { return findWebElement(codeFilter); }

    public WebElement getDescFilter() { return findWebElement(descFilter); }

    public WebElement getDayMappingFilter() { return findWebElement(dayMappingFilter); }

    public WebElement getMonthMappingFilter() { return findWebElement(monthMappingFilter); }

    public WebElement getExtractDateAsFilter() { return findWebElement(extractDateAsFilter); }

    public WebElement getYearMappingFilter() { return findWebElement(yearMappingFilter); }

    public WebElement getWeekMappingFilter() { return findWebElement(weekMappingFilter); }

    public WebElement getNotification() { return findWebElement(notification); }

    public WebElement getEncodingTab() { return findWebElement(encodingTab); }

    public WebElement getUsedByTab() { return findWebElement(usedByTab); }

    public WebElement getDayMpngTab() { return findWebElement(dayMpngTab); }

    public WebElement getMonthMpngTab() { return findWebElement(monthMpngTab); }

    public WebElement getYearMpngTab() { return findWebElement(yearMpngTab); }

    public WebElement getWeekMpngTab() { return findWebElement(weekMpngTab); }

    public WebElement getCodeLabel() { return findWebElement(codeLabel); }

    public WebElement getInputCode() { return findWebElement(inputCode); }

    public WebElement getDescLabel() { return findWebElement(descLabel); }

    public WebElement getInputDesc() { return findWebElement(inputDesc); }

    public WebElement getLotMaskLabel() { return findWebElement(lotMaskLabel); }

    public WebElement getInputLotMask() { return findWebElement(inputLotMask); }

    public WebElement getExtractDateAsLabel() { return findWebElement(extractDateAsLabel); }

    public WebElement getExtractDateAsDropDown() { return findWebElement(extractDateAsDropDown); }

    public WebElement getPromptLabel() { return findWebElement(promptLabel); }

    public WebElement getInputPrompt() { return findWebElement(inputPrompt); }

    public WebElement getDayMappingLabel() { return findWebElement(dayMappingLabel); }

    public WebElement getDayMapOdDropDown() { return findWebElement(dayMapOdDropDown); }

    public WebElement getMonthMappingLabel() { return findWebElement(monthMappingLabel); }

    public WebElement getMonthMapOdDropDown() { return findWebElement(monthMapOdDropDown); }

    public WebElement getYearMappingLabel() { return findWebElement(yearMappingLabel); }

    public WebElement getYearMapOdDropDown() { return findWebElement(yearMapOdDropDown); }

    public WebElement getWeekMappingLabel() { return findWebElement(weekMappingLabel); }

    public WebElement getWeekMapOdDropDown() { return findWebElement(weekMapOdDropDown); }

    public WebElement getSupplierColumn() { return findWebElement(supplierColumn); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getMonthMapping0() { return findWebElement(monthMapping0); }

    public WebElement getMonthMapping1() { return findWebElement(monthMapping1); }

    public WebElement getMonthMapping2() { return findWebElement(monthMapping2); }

    public WebElement getMonthMapping3() { return findWebElement(monthMapping3); }

    public WebElement getMonthMapping4() { return findWebElement(monthMapping4); }

    public WebElement getMonthMapping5() { return findWebElement(monthMapping5); }

    public WebElement getMonthMapping6() { return findWebElement(monthMapping6); }

    public WebElement getMonthMapping7() { return findWebElement(monthMapping7); }

    public WebElement getMonthMapping8() { return findWebElement(monthMapping8); }

    public WebElement getMonthMapping9() { return findWebElement(monthMapping9); }

    public WebElement getAddDateEncodingBtn() { return findWebElement(addDateEncodingBtn); }

    public WebElement getEditDateEncodingBtn() { return findWebElement(editDateEncodingBtn); }

    public WebElement getDeleteDateEncodingBtn() { return findWebElement(deleteDateEncodingBtn); }

    public WebElement getMonthMapping0Label() { return findWebElement(monthMapping0Label); }

    public WebElement getMonthMapping1Label() { return findWebElement(monthMapping1Label); }

    public WebElement getMonthMapping2Label() { return findWebElement(monthMapping2Label); }

    public WebElement getMonthMapping3Label() { return findWebElement(monthMapping3Label); }

    public WebElement getMonthMapping4Label() { return findWebElement(monthMapping4Label); }

    public WebElement getMonthMapping5Label() { return findWebElement(monthMapping5Label); }

    public WebElement getMonthMapping6Label() { return findWebElement(monthMapping6Label); }

    public WebElement getMonthMapping7Label() { return findWebElement(monthMapping7Label); }

    public WebElement getMonthMapping8Label() { return findWebElement(monthMapping8Label); }

    public WebElement getMonthMapping9Label() { return findWebElement(monthMapping9Label); }

    public WebElement getYearMapping0Label() { return findWebElement(yearMapping0Label); }

    public WebElement getYearMapping0() { return findWebElement(yearMapping0); }

    public WebElement getYearMapping1Label() { return findWebElement(yearMapping1Label); }

    public WebElement getYearMapping1() { return findWebElement(yearMapping1); }

    public WebElement getYearMapping2Label() { return findWebElement(yearMapping2Label); }

    public WebElement getYearMapping2() { return findWebElement(yearMapping2); }

    public WebElement getYearMapping3Label() { return findWebElement(yearMapping3Label); }

    public WebElement getYearMapping3() { return findWebElement(yearMapping3); }

    public WebElement getYearMapping4Label() { return findWebElement(yearMapping4Label); }

    public WebElement getYearMapping4() { return findWebElement(yearMapping4); }

    public WebElement getYearMapping5Label() { return findWebElement(yearMapping5Label); }

    public WebElement getYearMapping5() { return findWebElement(yearMapping5); }

    public WebElement getYearMapping6Label() { return findWebElement(yearMapping6Label); }

    public WebElement getYearMapping6() { return findWebElement(yearMapping6); }

    public WebElement getYearMapping7Label() { return findWebElement(yearMapping7Label); }

    public WebElement getYearMapping7() { return findWebElement(yearMapping7); }

    public WebElement getYearMapping8Label() { return findWebElement(yearMapping8Label); }

    public WebElement getYearMapping8() { return findWebElement(yearMapping8); }

    public WebElement getYearMapping9Label() { return findWebElement(yearMapping9Label); }

    public WebElement getYearMapping9() { return findWebElement(yearMapping9); }

    public WebElement getDayMapping0Label() { return findWebElement(dayMapping0Label); }

    public WebElement getDayMapping0() { return findWebElement(dayMapping0); }

    public WebElement getDayMapping1Label() { return findWebElement(dayMapping1Label); }

    public WebElement getDayMapping1() { return findWebElement(dayMapping1); }

    public WebElement getDayMapping2Label() { return findWebElement(dayMapping2Label); }

    public WebElement getDayMapping2() { return findWebElement(dayMapping2); }

    public WebElement getDayMapping3Label() { return findWebElement(dayMapping3Label); }

    public WebElement getDayMapping3() { return findWebElement(dayMapping3); }

    public WebElement getDayMapping4Label() { return findWebElement(dayMapping4Label); }

    public WebElement getDayMapping4() { return findWebElement(dayMapping4); }

    public WebElement getDayMapping5Label() { return findWebElement(dayMapping5Label); }

    public WebElement getDayMapping5() { return findWebElement(dayMapping5); }

    public WebElement getDayMapping6Label() { return findWebElement(dayMapping6Label); }

    public WebElement getDayMapping6() { return findWebElement(dayMapping6); }

    public WebElement getDayMapping7Label() { return findWebElement(dayMapping7Label); }

    public WebElement getDayMapping7() { return findWebElement(dayMapping7); }

    public WebElement getDayMapping8Label() { return findWebElement(dayMapping8Label); }

    public WebElement getDayMapping8() { return findWebElement(dayMapping8); }

    public WebElement getDayMapping9Label() { return findWebElement(dayMapping9Label); }

    public WebElement getDayMapping9() { return findWebElement(dayMapping9); }

    public WebElement getWeekMapping0Label() { return findWebElement(weekMapping0Label); }

    public WebElement getWeekMapping0() { return findWebElement(weekMapping0); }

    public WebElement getWeekMapping1Label() { return findWebElement(weekMapping1Label); }

    public WebElement getWeekMapping1() { return findWebElement(weekMapping1); }

    public WebElement getWeekMapping2Label() { return findWebElement(weekMapping2Label); }

    public WebElement getWeekMapping2() { return findWebElement(weekMapping2); }

    public WebElement getWeekMapping3Label() { return findWebElement(weekMapping3Label); }

    public WebElement getWeekMapping3() { return findWebElement(weekMapping3); }

    public WebElement getWeekMapping4Label() { return findWebElement(weekMapping4Label); }

    public WebElement getWeekMapping4() { return findWebElement(weekMapping4); }

    public WebElement getWeekMapping5Label() { return findWebElement(weekMapping5Label); }

    public WebElement getWeekMapping5() { return findWebElement(weekMapping5); }

    public WebElement getWeekMapping6Label() { return findWebElement(weekMapping6Label); }

    public WebElement getWeekMapping6() { return findWebElement(weekMapping6); }

    public WebElement getWeekMapping7Label() { return findWebElement(weekMapping7Label); }

    public WebElement getWeekMapping7() { return findWebElement(weekMapping7); }

    public WebElement getWeekMapping8Label() { return findWebElement(weekMapping8Label); }

    public WebElement getWeekMapping8() { return findWebElement(weekMapping8); }

    public WebElement getWeekMapping9Label() { return findWebElement(weekMapping9Label); }

    public WebElement getWeekMapping9() { return findWebElement(weekMapping9); }

    public WebElement getCharacterInput() { return findWebElement(characterInput); }

    public WebElement getValueInput() { return findWebElement(valueInput); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getDateEncodingDropDown() { return findWebElement(ddlDateEncodingDropDown); }

}
