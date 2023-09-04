package ui.pages.lookup.lookuplocation;

import com.google.gson.internal.bind.util.ISO8601Utils;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.ls.LSOutput;
import ui.pages.BasePage;
import java.util.List;
import java.util.stream.Collectors;

import static common.setup.DriverManager.getDriver;

public class LocationLookupPage extends BasePage {
    By locationLookupTitle = By.className("spnmoduleNameHeader");
    By customLabel = By.className("autocomplete_custom_label");
    By locationSearchLabel = By.id("locationSearchACField-label");
    By locationSearchInput = By.xpath("//input[@placeholder='Enter location']");
    By searchInput = By.xpath("//input[@placeholder='Search']");
    By locationSearchButton = By.cssSelector(".i-indexfield-container__main .k-button");
    By deleteButton = By.xpath("//button[text()='Delete']");
    By addLocProdButton = By.id("addLocProdButton");
    By editLocProdButton = By.id("editLocProdButton");
    By transferButton = By.xpath("//button[text()='Transfer']");
    By statusButton = By.xpath("//button[text()='Status']");
    By btnPrintLoc = By.id("btnPrintLoc");
    By labelTypeList = By.xpath("//span[@data-test-id='ddLocPrntLabelType']//span[@role='listbox']");
    By printerList = By.xpath("//span[@data-test-id='ddLocPrntPrinterType']//span[@role='listbox']");
    By palletColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Pallet']]");
    By palletColumn = By.xpath("//span[text()='Pallet']");
    By productColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Product']]");
    By productColumn = By.xpath("//span[text()='Product']");
    By descriptionColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Description']]");
    By descriptionColumn = By.xpath("//span[text()='Description']");
    By qtyColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Qty']]");
    By qtyColumn = By.xpath("//span[text()='Qty']");
    By uomColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='UOM']]");
    By uomColumn = By.xpath("//span[text()='UOM']");
    By lotColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Lot']]");
    By lotColumn = By.xpath("//span[text()='Lot']");
    By expDateColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Exp Date']]");
    By expDateColumn = By.xpath("//span[text()='Exp Date']");
    By weightColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Weight']]");
    By weightColumn = By.xpath("//span[text()='Weight']");
    By ownerColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Owner']]");
    By ownerColumn = By.xpath("//span[text()='Owner']");
    By lookupLocationSearch = By.cssSelector("input[placeholder='Enter location']");
    By palletsLabel = By.xpath("//span[text()='Pallets:']");
    By quantityLabel = By.xpath("//span[text()='Quantity:']");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By tableContent = By.className("k-grid-table");
    By rows = By.cssSelector(".k-grid-table tr");
    By columnHeaderCheckBox = By.xpath("//th[@role='columnheader']//input[@type='checkbox']");
    By dialogTextContent = By.id("dialogTextContent");
    By okButton = By.xpath("//button[contains(text(), 'Ok')]");
    By OKButton = By.xpath("//button[contains(text(), 'OK')]");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By noButton = By.xpath("//button[contains(text(), 'No')]");
    By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    By ddlProductTransferredLabel = By.id("ddlProductTransferred-label");
    By ddlProductTransferred = By.id("ddlProductTransferred");
    By ddlAddProductOwnerLabel = By.id("ddlAddProductOwner-label");
    By ddlAddProductOwner = By.id("ddlAddProductOwner");
    By ddlAddProductSupplierLabel = By.id("ddlAddProductSupplier-label");
    By ddlAddProductSupplier = By.id("ddlAddProductSupplier");
    By ddlAddProductStatusLabel = By.id("ddlAddProductStatus-label");
    By ddlAddProductStatus = By.id("ddlAddProductStatus");
    By txtQtyLabel = By.id("txtQty-label");
    By txtQty = By.id("txtQty");
    By ddlReasonLabel = By.id("ddlReason-label");
    By ddlReason = By.id("ddlReason");
    By chkUndoTransfer = By.id("chkUndoTransfer");
    By ddlDeleteReasonLabel = By.id("ddlDeleteReason-label");
    By ddlDeleteReason = By.id("ddlDeleteReason");
    By windowTitle = By.cssSelector(".k-window-title");
    By txtEditProductLPNLabel = By.id("txtEditProductLPN-label");
    By txtEditProductLPN = By.id("txtEditProductLPN");
    By ddlEditProductPalletTypeLabel = By.id("ddlEditProductPalletType-label");
    By ddlEditProductPalletType = By.id("ddlEditProductPalletType");
    By txtEditProductCodeLabel = By.id("txtEditProductCode-label");
    By txtEditProductCode = By.id("txtEditProductCode");
    By txtEditSupplierLabel = By.id("txtEditSupplier-label");
    By txtEditSupplier = By.id("txtEditSupplier");
    By nBoxAddProductQtyLabel = By.id("nBoxAddProductQty-label");
    By nBoxAddProductQty = By.id("nBoxAddProductQty");
    By ddlEditProductUOMLabel = By.id("ddlEditProductUOM-label");
    By editProductUOMLabel = By.id("ddlEditProductUOM-label");
    By editProductUOMDropdown = By.id("ddlEditProductUOM");
    By addProductUOMLabel = By.id("ddlAddProductUOM-label");
    By addProductUOMDropdown = By.id("ddlAddProductUOM");
    By productStatusLabel = By.id("ddlAddProductStatus-label");
    By productStatusDropdown = By.id("ddlAddProductStatus");
    By ddlEditProductUOM = By.id("ddlEditProductUOM");
    By ddlEditProductStatusLabel = By.id("ddlEditProductStatus-label");
    By ddlEditProductStatus = By.id("ddlEditProductStatus");
    By autocompleteLotLabel = By.id("autocompleteLot-label");
    By autocompleteLot = By.id("autocompleteLot");
    By invoiceDateLabel = By.id("InvoiceDate-label");
    By invoiceDate = By.id("InvoiceDate");
    By receiveDateLabel = By.id("ReceiveDate-label");
    By receiveDate = By.id("ReceiveDate");
    By txtAddProductDateCodeLabel = By.xpath("//label[@for='txtAddProductDateCode']");
    By txtAddProductDateCode = By.id("txtAddProductDateCode");
    By ddlInventoryReasonLabel = By.id("ddlInventoryReason-label");
    By ddlInventoryReason = By.id("ddlInventoryReason");
    By ddlEditDeleteInventoryReasonLabel = By.id("ddlEditDeleteInventoryReason-label");
    By ddlEditDeleteInventoryReason = By.id("ddlEditDeleteInventoryReason");
    By ddlEditDateCodeReasonLabel = By.id("ddlEditDateCodeReason-label");
    By ddlEditDateCodeReason = By.id("ddlEditDateCodeReason");
    By txtAddProductLPNLabel = By.id("txtAddProductLPN-label");
    By txtAddProductLPN = By.id("txtAddProductLPN");
    By ddlPalletTypeLabel = By.id("ddlPalletType-label");
    By ddlPalletType = By.id("ddlPalletType");
    By locationSearchACFieldLabel = By.id("locationSearchACField-label");
    By enterProductInput = By.cssSelector("input[placeholder='Enter a product']");
    By toggleCalendar = By.cssSelector("a[title='Toggle calendar']");
    By ddlStatusLabel = By.id("ddlStatus-label");
    By ddlStatus = By.id("ddlStatus");
    By ddlProductionReasonLabel = By.id("ddlInventoryReason-label");
    By ddlProductionReason = By.id("ddlInventoryReason");
    By ddlEditRecDateReasonLabel = By.id("ddlEditRecDateReason-label");
    By ddlEditRecDateReason = By.id("ddlEditRecDateReason");
    By ddlEditExpDateReasonLabel = By.id("ddlEditExpDateReason-label");
    By ddlEditExpDateReason = By.id("ddlEditExpDateReason");
    By ddlStatusReasonLabel = By.id("ddlStatusReason-label");
    By ddlStatusReason = By.id("ddlStatusReason");
    By notificationText = By.cssSelector("#erChangeStatus .i-notification-text");
    By notificationMsg = By.cssSelector(".toast-message");
    By palletsIndicator= By.xpath("//span[contains(text(), 'Pallets:')]");
    By palletsIndicatorValue = By.xpath("//span[contains(text(), 'Pallets:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By quantityIndicator= By.xpath("//span[contains(text(), 'Quantity:')]");
    By quantityIndicatorValue = By.xpath("//span[contains(text(), 'Quantity:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By itemsFoundIndicator= By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundIndicatorValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By locationSearchIndexTable = By.cssSelector("#gridUtil_locationSearchIndex .k-grid-table");
    By notification = By.className("i-notification-text");
    By backLocProdButton = By.id("backLocProdButton");
    By selectAllCheckbox = By.xpath("//div[@class='k-grid-header']//input");
    By dropdownList = By.id("dropdownList");
    By productionButton = By.cssSelector("#btnProductionOnOff");
    By productionLabel = By.xpath("//label[@class='i-label autocomplete_custom_label']");
    By weightSerialLabel = By.xpath("//span[text()='Weight/Serial No']");
    String locationTableRows = "//table[@class='k-grid-table']//tr[.//a[contains(text(), '%s')]]";

    public void waitForLocationLookupPageToLoad() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(locationSearchLabel);
        Waiters.waitForElementToBeDisplay(lookupLocationSearch);
        Waiters.waitForElementToBeDisplay(locationSearchButton);
    }

    public void typeLocation(String location) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(locationSearchInput);
        clickLocationSearchButton();
        inputText(getSearchInput(), location);
        pressEnter(getSearchInput());
        findWebElement(By.xpath("//tr[.//td[text()='" + location +  "']]")).click();
        Waiters.waitABit(10_000);
    }

    public void enterLocation(String location) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(locationSearchInput);
        inputText(getLocationSearchInput(), location);
        pressEnter(getLocationSearchInput());
        Waiters.waitABit(2000);
    }

    public void clickLocationSearchButton() {
        Waiters.waitForElementToBeDisplay(getLocationSearchButton());
        clickOnElement(getLocationSearchButton());
        Waiters.waitABit(2000);
    }

    public void clickSelectAllCheckbox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(selectAllCheckbox);
        clickOnElement(selectAllCheckbox);
        Waiters.waitABit(2000);
    }

    public void clearLocation() {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getLocationSearchInput());
        doubleClick(getLocationSearchInput());
        pressDelete(getLocationSearchInput());
    }

    public void typeQty(String qty) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getnBoxAddProductQty());
        clear(getnBoxAddProductQty());
        inputText(getnBoxAddProductQty(), qty);
        pressTab(getnBoxAddProductQty());
        Waiters.waitABit(2000);
    }

    public void clearProductQty() {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getnBoxAddProductQty());
        doubleClick(getnBoxAddProductQty());
        pressDelete(getnBoxAddProductQty());
    }

    public void typeDateCode(String dateCode) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(txtAddProductDateCode);
        clear(getTxtAddProductDateCode());
        inputText(getTxtAddProductDateCode(), dateCode);
        pressTab(getTxtAddProductDateCode());
        Waiters.waitABit(2000);
    }

    public void typeAutocompleteLot(String lot) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getAutocompleteLot());
        clear(getAutocompleteLot());
        inputText(getAutocompleteLot(), lot);
        pressTab(getAutocompleteLot());
        Waiters.waitABit(2000);
    }

    public void typeLPN(String code) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getTxtAddProductLPN());
        Waiters.waitABit(1000);
        clear(getTxtAddProductLPN());
        Waiters.waitABit(1000);
        inputText(getTxtAddProductLPN(), code);
        pressTab(getTxtAddProductLPN());
        Waiters.waitABit(2000);
    }

    public void editLPN(String code) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(txtEditProductLPN);
        Waiters.waitABit(1000);
        clear(getTxtEditProductLPN());
        Waiters.waitABit(1000);
        inputText(getTxtEditProductLPN(), code);
        pressTab(getTxtEditProductLPN());
        Waiters.waitABit(2000);
    }

    public void clearEditLPN() {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(txtEditProductLPN);
        Waiters.waitABit(1000);
        doubleClick(getTxtEditProductLPN());
        pressDelete(getTxtEditProductLPN());
        pressTab(getTxtEditProductLPN());
    }

    public void typeProduct(String code) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(enterProductInput);
        clear(getEnterProductInput());
        inputText(getEnterProductInput(), code);
        pressEnter(getEnterProductInput());
        Waiters.waitABit(2000);
    }

    public void typeExpDate(String date) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getInvoiceDate());
        doubleClick(getInvoiceDate());
        Waiters.waitABit(2000);
        pressDelete(getInvoiceDate());
        Waiters.waitABit(2000);
        inputText(getInvoiceDate(), date);
        pressTab(getInvoiceDate());
        Waiters.waitABit(2000);
    }

    public void typeReceiptDate(String date) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getReceiveDate());
        doubleClick(getReceiveDate());
        Waiters.waitABit(2000);
        pressDelete(getReceiveDate());
        Waiters.waitABit(2000);
        inputText(getReceiveDate(), date);
        pressTab(getReceiveDate());
        Waiters.waitABit(2000);
    }

    public void clearProductInput() {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(enterProductInput);
        doubleClick(getEnterProductInput());
        pressDelete(getEnterProductInput());
    }

    public void clickLocationProductByIndex(int index) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(tableContent);
        Waiters.waitForPresenceOfAllElements(rows);
        List<WebElement> products = getTableContent().findElements(By
                .xpath(".//tr[contains(@class, 'k-master-row')]//td[contains(@id, 'lookupLocationlink')]"));
        clickOnElement(products.get(index));
        Waiters.waitABit(3000);
    }

    public void checksProductByIndex(int index) {
        Waiters.waitForElementToBeDisplay(tableContent);
        Waiters.waitForPresenceOfAllElements(rows);
        List<WebElement> products = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]//input"));
        clickOnElement(products.get(index));
        Waiters.waitABit(3000);
    }

    public void selectLocationByIndex(int index) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getLocationSearchIndexTable());
        List<WebElement> locations = getLocationSearchIndexTable().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
        clickOnElement(locations.get(index));
        Waiters.waitABit(3000);
    }

    public void clickColumnHeaderCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getColumnHeaderCheckBox());
        clickOnElement(columnHeaderCheckBox);
    }

    public void clickPalletType() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDdlPalletType());
        clickOnElement(getDdlPalletType());
    }

    public void cleanLocationInput() {
        Waiters.waitABit(2000);
        clear(getLocationSearchInput());
    }

    public List<WebElement> getListOfOptions() {
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']"));
    }

    public String getDialogContentText() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(dialogTextContent);
        return getText(dialogTextContent);
    }

    public String getWindowTitleText() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getWindowTitle());
        return getText(getWindowTitle());
    }

    public String getNotificationMessageText() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getNotificationText());
        return getText(getNotificationText());
    }

    public String getPalletsIndicatorValueText() {
        Waiters.waitABit(2000);
        return getText(palletsIndicatorValue);
    }

    public String getQuantityIndicatorValueText() {
        Waiters.waitABit(2000);
        return getText(quantityIndicatorValue);
    }

    public String getItemsFoundIndicatorValueText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundIndicatorValue);
    }

    public void clickEditButton() {
        Waiters.waitForElementToBeDisplay(editLocProdButton);
        clickOnElement(editLocProdButton);
        Waiters.waitABit(15000);
    }

    public void clickDeleteButton() {
        Waiters.waitForElementToBeDisplay(deleteButton);
        clickOnElement(deleteButton);
    }

    public void clickTransferButton() {
        Waiters.waitForElementToBeDisplay(transferButton);
        clickOnElement(transferButton);
    }

    public void clickStatusButton() {
        Waiters.waitForElementToBeDisplay(statusButton);
        clickOnElement(statusButton);
    }

    public void clickBackButton() {
        Waiters.waitForElementToBeDisplay(backLocProdButton);
        clickOnElement(backLocProdButton);
    }

    public void clickPrintLocButton() {
        Waiters.waitForElementToBeDisplay(getBtnPrintLoc());
        clickOnElement(getBtnPrintLoc());
    }

    public void clickOkButton() {
        Waiters.waitForElementToBeDisplay(okButton);
        clickOnElement(okButton);
    }

    public void clickOKButton() {
        Waiters.waitForElementToBeDisplay(OKButton);
        clickOnElement(OKButton);
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeDisplay(cancelButton);
        scrollAndClick(getCancelBtn());
        Waiters.waitABit(2_000);
    }

    public void clickSaveButton() {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeDisplay(saveButton);
        jsClick(getSaveBtn());
        Waiters.waitABit(2000);
    }

    public void clickYesButton() {
        Waiters.waitForElementToBeDisplay(yesButton);
        clickOnElement(yesButton);
    }

    public void clickNoButton() {
        Waiters.waitForElementToBeDisplay(noButton);
        clickOnElement(noButton);
    }

    public void clickDeleteReason() {
        Waiters.waitForElementToBeDisplay(getDeleteReason());
        clickOnElement(getDeleteReason());
    }

    public void clickAddLocProdButton() {
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeDisplay(getAddLocProdButton());
        clickOnElement(getAddLocProdButton());
        Waiters.waitABit(5000);
    }

    public void selectDeleteReason(String reason) {
        Waiters.waitForElementToBeDisplay(getDeleteReason());
        clickOnElement(getDeleteReason());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + reason + "') and @role='option']")));
    }

    public void selectStatus(String status) {
        Waiters.waitForElementToBeDisplay(getStatusButton());
        clickOnElement(getStatusButton());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "') and @role='option']")));
    }

    public void selectDateCodeReason(String reason) {
        Waiters.waitForElementToBeDisplay(ddlEditDateCodeReason);
        clickOnElement(ddlEditDateCodeReason);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + reason + "') and @role='option']")));
    }

    public void selectChangeStatus(String status) {
        Waiters.waitForElementToBeDisplay(ddlStatus);
        clickOnElement(ddlStatus);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "') and @role='option']")));
    }

    public void selectChangeUnitStatusReason(String reason) {
        Waiters.waitForElementToBeDisplay(ddlStatusReason);
        clickOnElement(ddlStatusReason);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + reason + "') and @role='option']")));
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectLabelType(String label) {
        Waiters.waitForElementToBeDisplay(labelTypeList);
        clickOnElement(labelTypeList);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + label + "') and @role='option']")));
    }

    public void selectPrinter(String printer) {
        Waiters.waitForElementToBeDisplay(printerList);
        clickOnElement(printerList);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + printer + "') and @role='option']")));
    }

    public void clickLabelTypeDropdown() {
        Waiters.waitForElementToBeDisplay(labelTypeList);
        clickOnElement(labelTypeList);
    }

    public void clickProductionButton() {
        Waiters.waitForElementToBeDisplay(productionButton);
        clickOnElement(productionButton);
    }

    public void clickInventoryReasonButton() {
        Waiters.waitForElementToBeDisplay(getDdlInventoryReason());
        clickOnElement(getDdlInventoryReason());
    }

    public void selectInventoryReason(String reason) {
        Waiters.waitForElementToBeDisplay(getDdlInventoryReason());
        clickOnElement(getDdlInventoryReason());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + reason + "') and @role='option']")));
    }

    public void checkProduct(String product) {
        Waiters.waitForPresenceOfAllElements(By.xpath(String.format(locationTableRows, product)));
        WebElement productCheckbox = findWebElements(By.xpath(String.format(locationTableRows, product))).stream()
                .map(el -> el.findElement(By.xpath(".//input")))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Record with product " + product + " does not exist"));
        clickOnElement(productCheckbox);
    }

    public void clickProductionReason() {
        Waiters.waitForElementToBeDisplay(getProductionReason());
        clickOnElement(getProductionReason());
    }

    public void selectProductionReason(String reason) {
        Waiters.waitForElementToBeDisplay(getProductionReason());
        clickOnElement(getProductionReason());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + reason + "') and @role='option']")));
    }

    public void clickEditRecDateReason() {
        Waiters.waitForElementToBeDisplay(getEditRecDateReason());
        clickOnElement(getEditRecDateReason());
    }

    public void selectRecDateChangeReason(String reason) {
        Waiters.waitForElementToBeDisplay(getEditRecDateReason());
        clickOnElement(getEditRecDateReason());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + reason + "') and @role='option']")));
    }

    public void clickEditExpDateReason() {
        Waiters.waitForElementToBeDisplay(getEditExpDateReason());
        clickOnElement(getEditRecDateReason());
    }

    public void selectExpDateChangeReason(String reason) {
        Waiters.waitForElementToBeDisplay(getEditExpDateReason());
        clickOnElement(getEditExpDateReason());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + reason + "') and @role='option']")));
    }

    public int getOptionsNumber() {
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']")).size();
    }

    public void selectOwner(String owner) {
        Waiters.waitForElementToBeDisplay(getDdlAddProductOwner());
        clickOnElement(getDdlAddProductOwner());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + owner + "') and @role='option']")));
    }

    public void clickSupplier() {
        Waiters.waitForElementToBeDisplay(getDdlAddProductSupplier());
        clickOnElement(getDdlAddProductSupplier());
    }

    public void selectSupplier(String supplier) {
        Waiters.waitForElementToBeDisplay(getDdlAddProductSupplier());
        clickOnElement(getDdlAddProductSupplier());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + supplier + "') and @role='option']")));
    }

    public void selectUOM(String uom) {
        Waiters.waitForElementToBeDisplay(getProductUOMDropdown());
        clickOnElement(getProductUOMDropdown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + uom + "') and @role='option']")));
    }

    public void selectProductStatus(String status) {
        Waiters.waitForElementToBeDisplay(ddlAddProductStatus);
        clickOnElement(ddlAddProductStatus);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "') and @role='option']")));
    }

    public List<WebElement> getLabelTypeOptions() {
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']"));
    }

    public boolean isLabelTypeOptionExists(String type) {
        List<String> types = getLabelTypeOptions().stream()
                .map(option -> option.getText().trim())
                .collect(Collectors.toList());
        return types.contains(type);
    }

    public void enterDate(String date) {
        Waiters.waitForElementToBeClickable(getToggleCalendar());
        clickOnElement(getToggleCalendar());
        Waiters.waitABit(2000);
        String day = date.substring(3, 5).contains("0") ? date.substring(4, 5) : date.substring(3, 5);
        clickOnElement(getCalendarDay(day));
        Waiters.waitABit(2000);
    }

    public boolean isOkButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(okButton);
    }

    public String getValueAddProductLPN() {
        Waiters.waitABit(2000);
        return getValue(txtAddProductLPN);
    }

    public String isProductCodeDisabled() {
        Waiters.waitABit(2000);
        return checkElementAttribute(getTxtEditProductCode(), "disabled");
    }

    public boolean isCancelButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(cancelButton);
    }

    public boolean isSaveButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(saveButton);
    }

    public boolean isYesButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(yesButton);
    }

    public boolean isNoButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(noButton);
    }

    public boolean isLocationLookupTitleDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLocationLookupTitle());
    }

    public boolean isCustomLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCustomLabel());
    }

    public boolean isLocationSearchLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLocationSearchLabel());
    }

    public boolean isLocationSearchInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLocationSearchInput());
    }

    public boolean isLocationSearchButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLocationSearchButton());
    }

    public boolean isAddLocProdButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAddLocProdButton());
    }

    public boolean isAddProductUOMLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAddProductUOMLabel());
    }

    public boolean isAddProductUOMDropdownDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAddProductUOMDropdown());
    }

    public boolean isEditButtonDisplayed() { return isElementDisplay(getEditButton()); }

    public boolean isDeleteButtonDisplayed() { return isElementDisplay(getDeleteButton()); }

    public boolean isTransferButtonDisplayed() { return isElementDisplay(getTransferButton()); }

    public boolean isStatusButtonDisplayed() { return isElementDisplay(getStatusButton());  }

    public boolean isBtnPrintLocDisplayed() { return isElementDisplay(getBtnPrintLoc()); }

    public boolean isPalletColumnHeaderDisplayed() {
        return isElementDisplay(getPalletColumnHeader());
    }

    public boolean isProductColumnHeaderDisplayed() {
        return isElementDisplay(getProductColumnHeader());
    }

    public boolean isDescriptionColumnHeaderDisplayed() {
        return isElementDisplay(getDescriptionColumnHeader());
    }

    public boolean isQtyColumnHeaderDisplayed() {
        return isElementDisplay(getQtyColumnHeader());
    }

    public boolean isUomColumnHeaderDisplayed() {
        return isElementDisplay(getUomColumnHeader());
    }

    public boolean isLotColumnHeaderDisplayed() {
        return isElementDisplay(getLotColumnHeader());
    }

    public boolean isExpDateColumnHeaderDisplayed() {
        return isElementDisplay(getExpDateColumnHeader());
    }

    public boolean isWeightColumnHeaderDisplayed() {
        return isElementDisplay(getWeightColumnHeader());
    }

    public boolean isOwnerColumnHeaderDisplayed() {
        return isElementDisplay(getOwnerColumnHeader());
    }

    public boolean isLookupLocationSearchDisplayed() {
        return isElementDisplay(getLookupLocationSearch());
    }

    public boolean isPalletsLabelDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getPalletsLabel());
    }

    public boolean isQuantityLabelDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getQuantityLabel());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getItemsFoundLabel());
    }

    public boolean isDdlProductTransferredLabelDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getDdlProductTransferredLabel());
    }

    public boolean isDdlProductTransferredDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getDdlProductTransferred());
    }

    public boolean isTxtQtyLabelDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getTxtQtyLabel());
    }

    public boolean isTxtQtyDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getTxtQty());
    }

    public boolean isDdlReasonLabelDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getDdlReasonLabel());
    }

    public boolean isDeleteReasonLabelDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getDeleteReasonLabel());
    }

    public boolean isDeleteReasonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDeleteReason());
    }

    public boolean isDdlReasonDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getDdlReason());
    }

    public boolean isChkUndoTransferDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getChkUndoTransfer());
    }

    public boolean isTxtEditProductLPNLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtEditProductLPNLabel());
        return isElementDisplay(getTxtEditProductLPNLabel());
    }

    public boolean isTxtEditProductLPNDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtEditProductLPN());
        return isElementDisplay(getTxtEditProductLPN());
    }

    public boolean isDdlEditProductPalletTypeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditProductPalletTypeLabel());
        return isElementDisplay(getDdlEditProductPalletTypeLabel());
    }

    public boolean isDdlEditProductPalletTypeDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditProductPalletType());
        return isElementDisplay(getDdlEditProductPalletType());
    }

    public boolean isTxtEditProductCodeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtEditProductCodeLabel());
        return isElementDisplay(getTxtEditProductCodeLabel());
    }

    public boolean isTxtEditProductCodeDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtEditProductCode());
        return isElementDisplay(getTxtEditProductCode());
    }

    public boolean isTxtEditSupplierLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtEditSupplierLabel());
        return isElementDisplay(getTxtEditSupplierLabel());
    }

    public boolean isTxtEditSupplierDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtEditSupplier());
        return isElementDisplay(getTxtEditSupplier());
    }

    public boolean isBoxAddProductQtyLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getnBoxAddProductQtyLabel());
        return isElementDisplay(getnBoxAddProductQtyLabel());
    }

    public boolean isBoxAddProductQtyDisplayed() {
        Waiters.waitForElementToBeDisplay(getnBoxAddProductQty());
        return isElementDisplay(getnBoxAddProductQty());
    }

    public boolean isDdlEditProductUOMLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditProductUOMLabel());
        return isElementDisplay(getDdlEditProductUOMLabel());
    }

    public boolean isDdlEditProductUOMDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditProductUOM());
        return isElementDisplay(getDdlEditProductUOM());
    }

    public boolean isDdlEditProductStatusLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditProductStatusLabel());
        return isElementDisplay(getDdlEditProductStatusLabel());
    }

    public boolean isDdlEditProductStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditProductStatus());
        return isElementDisplay(getDdlEditProductStatus());
    }

    public boolean isAutocompleteLotLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getAutocompleteLotLabel());
        return isElementDisplay(getAutocompleteLotLabel());
    }

    public boolean isAutocompleteLotDisplayed() {
        Waiters.waitForElementToBeDisplay(getAutocompleteLot());
        return isElementDisplay(getAutocompleteLot());
    }

    public boolean isInvoiceDateLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getInvoiceDateLabel());
        return isElementDisplay(getInvoiceDateLabel());
    }

    public boolean isInvoiceDateDisplayed() {
        Waiters.waitForElementToBeDisplay(getInvoiceDate());
        return isElementDisplay(getInvoiceDate());
    }

    public boolean isTxtAddProductDateCodeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtAddProductDateCodeLabel());
        return isElementDisplay(getTxtAddProductDateCodeLabel());
    }

    public boolean isTxtAddProductDateCodeDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtAddProductDateCode());
        return isElementDisplay(getTxtAddProductDateCode());
    }

    public boolean isInventoryReasonLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlInventoryReasonLabel());
        return isElementDisplay(getDdlInventoryReasonLabel());
    }

    public boolean isInventoryReasonDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlInventoryReason());
        return isElementDisplay(getDdlInventoryReason());
    }

    public boolean isWeightSerialLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(weightSerialLabel);
        return isElementDisplay(weightSerialLabel);
    }

    public boolean isDeleteInventoryReasonLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditDeleteInventoryReasonLabel());
        return isElementDisplay(getDdlEditDeleteInventoryReasonLabel());
    }

    public boolean isDeleteInventoryReasonDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditDeleteInventoryReason());
        return isElementDisplay(getDdlEditDeleteInventoryReason());
    }

    public boolean isDateCodeReasonLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditDateCodeReasonLabel());
        return isElementDisplay(getDdlEditDateCodeReasonLabel());
    }

    public boolean isDateCodeReasonDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlEditDateCodeReason());
        return isElementDisplay(getDdlEditDateCodeReason());
    }

    public boolean isAddProductLPNLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtAddProductLPNLabel());
        return isElementDisplay(getTxtAddProductLPNLabel());
    }

    public boolean isAddProductLPNDisplayed() {
        Waiters.waitForElementToBeDisplay(getTxtAddProductLPN());
        return isElementDisplay(getTxtAddProductLPN());
    }

    public boolean isPalletTypeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlPalletTypeLabel());
        return isElementDisplay(getDdlPalletTypeLabel());
    }

    public boolean isPalletTypeDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlPalletType());
        return isElementDisplay(getDdlPalletType());
    }

    public boolean isProductLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLocationSearchACFieldLabel());
        return isElementDisplay(getLocationSearchACFieldLabel());
    }

    public boolean isEnterProductInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getEnterProductInput());
        return isElementDisplay(getEnterProductInput());
    }

    public boolean isProductOwnerLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlAddProductOwnerLabel());
        return isElementDisplay(getDdlAddProductOwnerLabel());
    }

    public boolean isProductOwnerDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlAddProductOwner());
        return isElementDisplay(getDdlAddProductOwner());
    }

    public boolean isProductSupplierLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlAddProductSupplierLabel());
        return isElementDisplay(getDdlAddProductSupplierLabel());
    }

    public boolean isProductSupplierDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlAddProductSupplier());
        return isElementDisplay(getDdlAddProductSupplier());
    }

    public boolean isStatusLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlStatusLabel());
        return isElementDisplay(getDdlStatusLabel());
    }

    public boolean isStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlStatus());
        return isElementDisplay(getDdlStatus());
    }

    public boolean isStatusReasonLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlStatusReasonLabel());
        return isElementDisplay(getDdlStatusReasonLabel());
    }

    public boolean isStatusReasonDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlStatusReason());
        return isElementDisplay(getDdlStatusReason());
    }

    public boolean isProductionReasonLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getProductionReasonLabel());
        return isElementDisplay(getProductionReasonLabel());
    }

    public boolean isProductionReasonDisplayed() {
        Waiters.waitForElementToBeDisplay(getProductionReason());
        return isElementDisplay(getProductionReason());
    }

    public boolean isProductionButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getProductionButton());
        return isElementDisplay(getProductionButton());
    }

    public String getPalletsLabelText() {
        Waiters.waitABit(2000);
        return getText(palletsLabel);
    }

    public String getQuantityLabelText() {
        Waiters.waitABit(2000);
        return getText(quantityLabel);
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundLabel);
    }

    public String getNotificationWarningText() {
        Waiters.waitABit(2000);
        return getText(getNotification());
    }

    public String getProductionLabelText() {
        Waiters.waitABit(2000);
        return getText(getProductionLabel());
    }

    public String getProductionButtonText() {
        Waiters.waitABit(2000);
        return getText(getProductionButton());
    }

    public boolean isAddLocButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getAddLocProdButton(), "class").contains("disabled");
    }

    public WebElement getLocationLookupTitle() { return findWebElement(locationLookupTitle); }

    public WebElement getCustomLabel() { return findWebElement(customLabel); }

    public WebElement getLocationSearchLabel() { return findWebElement(locationSearchLabel); }

    public WebElement getLocationSearchInput() { return findWebElement(locationSearchInput); }

    public WebElement getSearchInput() { return findWebElement(searchInput); }

    public WebElement getLocationSearchButton() { return findWebElement(locationSearchButton); }

    public WebElement getAddLocProdButton() { return findWebElement(addLocProdButton); }

    public WebElement getEditButton() { return findWebElement(editLocProdButton); }

    public WebElement getDeleteButton() { return findWebElement(deleteButton); }

    public WebElement getTransferButton() { return findWebElement(transferButton); }

    public WebElement getStatusButton() { return findWebElement(statusButton); }

    public WebElement getBtnPrintLoc() { return findWebElement(btnPrintLoc); }

    public WebElement getPalletColumnHeader() { return findWebElement(palletColumnHeader); }

    public WebElement getPalletColumn() { return findWebElement(palletColumn); }

    public WebElement getProductColumnHeader() { return findWebElement(productColumnHeader); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getDescriptionColumnHeader() { return findWebElement(descriptionColumnHeader); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getQtyColumnHeader() { return findWebElement(qtyColumnHeader); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getUomColumnHeader() { return findWebElement(uomColumnHeader);}

    public WebElement getUomColumn() { return findWebElement(uomColumn); }

    public WebElement getLotColumnHeader() { return findWebElement(lotColumnHeader); }

    public WebElement getLotColumn() { return findWebElement(lotColumn); }

    public WebElement getExpDateColumnHeader() { return findWebElement(expDateColumnHeader); }

    public WebElement getExpDateColumn() { return findWebElement(expDateColumn); }

    public WebElement getWeightColumnHeader() { return findWebElement(weightColumnHeader); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getOwnerColumnHeader() { return findWebElement(ownerColumnHeader); }

    public WebElement getOwnerColumn() { return findWebElement(ownerColumn); }

    public WebElement getLookupLocationSearch() { return findWebElement(lookupLocationSearch); }

    public WebElement getPalletsLabel() { return findWebElement(palletsLabel); }

    public WebElement getQuantityLabel() { return findWebElement(quantityLabel); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public List<WebElement> getRows() { return findWebElements(rows); }

    public WebElement getColumnHeaderCheckBox() { return findWebElement(columnHeaderCheckBox); }

    public WebElement getDialogTextContent() { return findWebElement(dialogTextContent); }

    public WebElement getDdlProductTransferredLabel() { return findWebElement(ddlProductTransferredLabel); }

    public WebElement getSaveBtn() { return findWebElement(saveButton); }

    public WebElement getCancelBtn() { return findWebElement(cancelButton); }

    public WebElement getDdlProductTransferred() { return findWebElement(ddlProductTransferred); }

    public WebElement getDdlAddProductOwnerLabel() { return findWebElement(ddlAddProductOwnerLabel); }

    public WebElement getDdlAddProductOwner() { return findWebElement(ddlAddProductOwner); }

    public WebElement getDdlAddProductSupplierLabel() { return findWebElement(ddlAddProductSupplierLabel); }

    public WebElement getDdlAddProductSupplier() { return findWebElement(ddlAddProductSupplier); }

    public WebElement getProductUOMLabel() { return findWebElement(editProductUOMLabel); }

    public WebElement getProductUOMDropdown() { return findWebElement(editProductUOMDropdown); }

    public WebElement getAddProductUOMLabel() { return findWebElement(addProductUOMLabel); }

    public WebElement getAddProductUOMDropdown() { return findWebElement(addProductUOMDropdown); }

    public WebElement getProductStatusLabel() { return findWebElement(productStatusLabel); }

    public WebElement getProductStatusDropdown() { return findWebElement(productStatusDropdown); }

    public WebElement getTxtQtyLabel() { return findWebElement(txtQtyLabel); }

    public WebElement getTxtQty() { return findWebElement(txtQty); }

    public WebElement getDdlReasonLabel() { return findWebElement(ddlReasonLabel); }

    public WebElement getDeleteReasonLabel() { return findWebElement(ddlDeleteReasonLabel); }

    public WebElement getDeleteReason() { return findWebElement(ddlDeleteReason); }

    public WebElement getDdlReason() { return findWebElement(ddlReason); }

    public WebElement getChkUndoTransfer() { return findWebElement(chkUndoTransfer); }

    public WebElement getWindowTitle() { return findWebElement(windowTitle); }

    public WebElement getTxtEditProductLPNLabel() { return findWebElement(txtEditProductLPNLabel); }

    public WebElement getTxtEditProductLPN() { return findWebElement(txtEditProductLPN); }

    public WebElement getDdlEditProductPalletTypeLabel() { return findWebElement(ddlEditProductPalletTypeLabel); }

    public WebElement getDdlEditProductPalletType() { return findWebElement(ddlEditProductPalletType); }

    public WebElement getTxtEditProductCodeLabel() { return findWebElement(txtEditProductCodeLabel); }

    public WebElement getTxtEditProductCode() { return findWebElement(txtEditProductCode); }

    public WebElement getTxtEditSupplierLabel() { return findWebElement(txtEditSupplierLabel); }

    public WebElement getTxtEditSupplier() { return findWebElement(txtEditSupplier); }

    public WebElement getnBoxAddProductQtyLabel() { return findWebElement(nBoxAddProductQtyLabel); }

    public WebElement getnBoxAddProductQty() { return findWebElement(nBoxAddProductQty); }

    public WebElement getDdlEditProductUOMLabel() { return findWebElement(ddlEditProductUOMLabel); }

    public WebElement getDdlEditProductUOM() { return findWebElement(ddlEditProductUOM); }

    public WebElement getDdlEditProductStatusLabel() { return findWebElement(ddlEditProductStatusLabel); }

    public WebElement getDdlEditProductStatus() { return findWebElement(ddlEditProductStatus); }

    public WebElement getAutocompleteLotLabel() { return findWebElement(autocompleteLotLabel); }

    public WebElement getAutocompleteLot() { return findWebElement(autocompleteLot); }

    public WebElement getInvoiceDateLabel() { return findWebElement(invoiceDateLabel); }

    public WebElement getInvoiceDate() { return findWebElement(invoiceDate); }

    public WebElement getReceiveDateLabel() { return findWebElement(receiveDateLabel); }

    public WebElement getReceiveDate() { return findWebElement(receiveDate); }

    public WebElement getTxtAddProductDateCodeLabel() { return findWebElement(txtAddProductDateCodeLabel); }

    public WebElement getTxtAddProductDateCode() { return findWebElement(txtAddProductDateCode); }

    public WebElement getDdlInventoryReasonLabel() { return findWebElement(ddlInventoryReasonLabel); }

    public WebElement getDdlInventoryReason() { return findWebElement(ddlInventoryReason); }

    public WebElement getDdlEditDeleteInventoryReasonLabel() { return findWebElement(ddlEditDeleteInventoryReasonLabel); }

    public WebElement getDdlEditDeleteInventoryReason() { return findWebElement(ddlEditDeleteInventoryReason); }

    public WebElement getDdlEditDateCodeReasonLabel() { return findWebElement(ddlEditDateCodeReasonLabel); }

    public WebElement getDdlEditDateCodeReason() { return findWebElement(ddlEditDateCodeReason); }

    public WebElement getTxtAddProductLPNLabel() { return findWebElement(txtAddProductLPNLabel); }

    public WebElement getTxtAddProductLPN() { return findWebElement(txtAddProductLPN); }

    public WebElement getDdlPalletTypeLabel() { return findWebElement(ddlPalletTypeLabel); }

    public WebElement getDdlPalletType() { return findWebElement(ddlPalletType); }

    public WebElement getLocationSearchACFieldLabel() { return findWebElement(locationSearchACFieldLabel); }

    public WebElement getEnterProductInput() { return findWebElement(enterProductInput); }

    public WebElement getToggleCalendar() { return findWebElement(toggleCalendar); }

    private WebElement getCalendarDay(String text) {
        return findWebElement(By.xpath("//div[contains(@class, 'k-calendar-container')]//*[contains(text(), '" + text + "')]"));
    }

    public WebElement getDdlStatusLabel() { return findWebElement(ddlStatusLabel); }

    public WebElement getDdlStatus() { return findWebElement(ddlStatus); }

    public WebElement getProductionReasonLabel() { return findWebElement(ddlProductionReasonLabel); }

    public WebElement getProductionReason() { return findWebElement(ddlProductionReason); }

    public WebElement getEditRecDateReasonLabel() { return findWebElement(ddlEditRecDateReasonLabel); }

    public WebElement getEditRecDateReason() { return findWebElement(ddlEditRecDateReason); }

    public WebElement getEditExpDateReasonLabel() { return findWebElement(ddlEditExpDateReasonLabel); }

    public WebElement getEditExpDateReason() { return findWebElement(ddlEditExpDateReason); }

    public WebElement getDdlStatusReasonLabel() { return findWebElement(ddlStatusReasonLabel); }

    public WebElement getDdlStatusReason() { return findWebElement(ddlStatusReason); }

    public WebElement getNotificationText() { return findWebElement(notificationText); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getPalletsIndicator() { return findWebElement(palletsIndicator); }

    public WebElement getPalletsIndicatorValue() { return findWebElement(palletsIndicatorValue); }

    public WebElement getQuantityIndicator() { return findWebElement(quantityIndicator); }

    public WebElement getQuantityIndicatorValue() { return findWebElement(quantityIndicatorValue); }

    public WebElement getItemsFoundIndicator() { return findWebElement(itemsFoundIndicator); }

    public WebElement getItemsFoundIndicatorValue() { return findWebElement(itemsFoundIndicatorValue); }

    public WebElement getLocationSearchIndexTable() { return findWebElement(locationSearchIndexTable); }

    public WebElement getNotification() { return findWebElement(notification); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

    public WebElement getProductionButton() { return findWebElement(productionButton); }

    public WebElement getProductionLabel() { return findWebElement(productionLabel); }

}
