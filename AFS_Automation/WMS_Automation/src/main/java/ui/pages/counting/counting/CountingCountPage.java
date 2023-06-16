package ui.pages.counting.counting;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;
import static common.setup.DriverManager.getDriver;

public class CountingCountPage extends BasePage {
    By countPageTitle = By.className("spnmoduleNameHeader");
    By cycleCountSessionLabel = By.id("ddlCycleCountSession-label");
    By cycleCountSession = By.id("ddlCycleCountSession");
    By cycleCountAssignmentLabel = By.id("ddlCycleCountAssignment-label");
    By cycleCountAssignment = By.id("ddlCycleCountAssignment");
    By cycleProductSearch = By.id("cycleproductsearch");
    By addFilterButton = By.cssSelector(".i-filter-tag__main__text--add");
    By itemsCount = By.cssSelector(".i-summary-area__main__value");
    By itemsFound = By.cssSelector(".i-summary-area__main__label");
    By locationColumn = By.xpath("//table[@role='presentation']//span[text() ='Location']");
    By productColumn = By.xpath("//table[@role='presentation']//span[text() ='Product']");
    By upcColumn = By.xpath("//table[@role='presentation']//span[text() ='UPC']");
    By descriptionColumn = By.xpath("//table[@role='presentation']//span[text() ='Description']");
    By onHandColumn = By.xpath("//table[@role='presentation']//span[text() ='On hand']");
    By countColumn = By.xpath("//table[@role='presentation']//span[text() ='Count']");
    By uomColumn = By.xpath("//table[@role='presentation']//span[text() ='UOM']");
    By dropdownList = By.id("dropdownList");
    By locationCodeFilter = By.cssSelector(".i-btn-checkbox  #LocationCode");
    By productCodeFilter = By.cssSelector(".i-btn-checkbox  #ProductCode");
    By upcCodeFilter = By.cssSelector(".i-btn-checkbox  #UpcCode");
    By descriptionFilter = By.cssSelector(".i-btn-checkbox  #Description");
    By onHandFilter = By.cssSelector(".i-btn-checkbox  #OnHand");
    By countedQtyFilter = By.cssSelector(".i-btn-checkbox  #CountedQtty");
    By uomFilter = By.cssSelector(".i-btn-checkbox  #UOM");
    By inputContains = By.xpath("//input[@placeholder='Contains']");
    By applyButton = By.xpath("//button[text()='Apply']");
    By inputSearch = By.xpath("//input[@placeholder='Search']");
    By clearButton = By.xpath("//button[text()='Clear']");
    By clearAllButton = By.xpath("//button[text()='Clear all']");
    By table = By.cssSelector(".k-grid-table");
    By locationLabel = By.cssSelector(".menu-label");
    By locationCountQuantityRows = By.cssSelector("tr.k-master-row");
    By addProductButton = By.id("btnAddProduct");
    By productsColumn = By.xpath("//span[@class='k-column-title' and contains(text(), 'Products')]");
    By factorColumn = By.xpath("//span[@class='k-column-title' and contains(text(), 'Factor')]");
    By onhandColumn = By.xpath("//span[@class='k-column-title' and contains(text(), 'On hand')]");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found')]");
    By minusIcon = By.cssSelector("a.k-i-minus");
    By productDataTextBox = By.cssSelector("input.cycleProductCountEditDataPlusMinTextBox");
    By palletColumn = By.xpath("//td[contains(text(), 'Pallet')]");
    By layerColumn = By.xpath("//td[contains(text(), 'Layer')]");
    By eachColumn = By.xpath("//td[contains(text(), 'EACH')]");
    By bagColumn = By.xpath("//td[contains(text(), 'BAG')]");
    By casesColumn = By.xpath("//td[contains(text(), 'CASES')]");
    By btnProductCountCancel = By.id("btnProductCountCancel");
    By btnProductCountSave = By.id("btnProductCountSave");
    By reduceButton = By.xpath("//button[contains(@id, 'leftArrow')]");
    By enlargeButton = By.xpath("//button[contains(@id, 'rightArrow')]");
    By txtLpnLabel = By.id("txtLPN-label");
    By txtLpn = By.id("txtLPN");
    By palletTypeLabel = By.id("ddlPalletType-label");
    By palletType = By.id("ddlPalletType");
    By productIndexLabel = By.id("indexProductIndex-label");
    By productInput = By.xpath("//input[@placeholder='Search product']");
    By searchProductButton = By.cssSelector(".i-button--icon-only");
    By ownerLabel = By.id("ddlOwner-label");
    By ddlOwnerDropdown = By.id("ddlOwner");
    By supplierIndexLabel = By.id("ddlSupplier-label");
    By supplierDropdown = By.id("ddlSupplier");
    By txtQtyLabel = By.id("txtQty-label");
    By txtQty = By.id("txtQty");
    By uomLabel = By.id("ddlUOM-label");
    By uomDropDown = By.id("ddlUOM");
    By ddlStatusLabel = By.id("ddlStatus-label");
    By ddlStatus = By.id("ddlStatus");
    By txtDateCodeLabel = By.id("txtDateCode-label");
    By txtDateCode = By.id("txtDateCode");
    By btnCancel = By.id("btnAddProductCancel");
    By btnSave = By.id("btnAddProductSave");

    public WebElement getLocationRowByText(String text){
        return findWebElement(By.xpath("//tr[@class='k-master-row'][.//td[contains(text(), '" + text + "')]]"));
    }

    public WebElement getProductInputByRow(String text){
        return getLocationRowByText(text).findElement(By.xpath(".//input[contains(@class, 'cycleProductCountEditDataPlusMinTextBox')]"));
    }

    public void waitCountingCountPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(countPageTitle);
        Waiters.waitForElementToBeDisplay(cycleCountSessionLabel);
        Waiters.waitForElementToBeDisplay(cycleCountSession);
        Waiters.waitForElementToBeDisplay(cycleCountAssignmentLabel);
        Waiters.waitForElementToBeDisplay(cycleCountAssignment);
        Waiters.waitForElementToBeDisplay(cycleProductSearch);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectSession(String session) {
        clickOnElement(cycleCountSession);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + session + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectAssignment(String assignment) {
        clickOnElement(cycleCountAssignment);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + assignment + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectOwner(String owner) {
        Waiters.waitForElementToBeDisplay(getOwnerDropdown());
        clickOnElement(getOwnerDropdown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + owner + "') and @role='option']")));
    }

    public void selectSupplier(String supplier) {
        Waiters.waitForElementToBeDisplay(getSupplierDropdown());
        clickOnElement(getSupplierDropdown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + supplier + "') and @role='option']")));
    }

    public void typeQty(String qty) {
        Waiters.waitForElementToBeDisplay(getTxtQty());
        typeText(getTxtQty(), qty);
        pressTab(getTxtQty());
    }

    public void selectUOM(String uom) {
        Waiters.waitForElementToBeDisplay(getUomDropDown());
        clickOnElement(getUomDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + uom + "') and @role='option']")));
    }

    public void selectProductStatus(String status) {
        Waiters.waitForElementToBeDisplay(getStatus());
        clickOnElement(getStatus());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "') and @role='option']")));
    }

    public void typeDateCode(String code) {
        Waiters.waitForElementToBeDisplay(getTxtDateCode());
        typeText(getTxtDateCode(), code);
        pressTab(getTxtDateCode());
    }

    public void clickCancel() {
        Waiters.waitForElementToBeDisplay(btnCancel);
        clickOnElement(btnCancel);
    }

    public void clickSave() {
        Waiters.waitForElementToBeDisplay(btnSave);
        clickOnElement(btnSave);
    }

    public void clickSessionDropdown() {
        clickOnElement(getCycleCountSession());
    }

    public String getItemsCountText() { return getText(itemsCount); }

    public WebElement getTableRowByLocation(String location) {
        Waiters.waitABit(2000);
        List<WebElement> rows = getTable().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
        return rows.stream()
                .filter(row -> row.getText().contains(location))
                .findFirst()
                .orElseThrow(() ->  new IllegalArgumentException("Row with location " + location + " is not found on Counting page"));
    }

    public List<WebElement> getCountQuantityInputs() {
        return getTable().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]//input[@type='number']"));
    }

    public String getCountQuantityValueByIndex(int index) {
        Waiters.waitForPresenceOfAllElements(By.xpath(".//tr[contains(@class, 'k-master-row')]//input[@type='number']"));
        return getValue(getTable()
                .findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]//input[@type='number']"))
                .get(index));
    }

    public void typeQuantity(String number, int index) {
        doubleClick(getCountQuantityInput().get(index));
        clear(getCountQuantityInput().get(index));
        typeText(getCountQuantityInput().get(index), number);
        pressTab(getCountQuantityInput().get(index));
    }

    public void clickLocation(String location) {
        Waiters.waitABit(3000);
        clickOnElement(getTableRowByLocation(location));
    }

    public void clickAddProduct() {
        Waiters.waitABit(3000);
        clickOnElement(getAddProductButton());
    }

    public void typeProduct(String product) {
        Waiters.waitABit(3000);
        typeText(getProductInput(), product);
        pressEnter(getProductInput());
    }

    public void clickLProductDataByIndex(int index) {
        Waiters.waitABit(3000);
        clickOnElement(getProductDataTextBoxes().get(index));
    }

    public void clickAddFilterButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(addFilterButton);
        clickOnElement(addFilterButton);
        Waiters.waitABit(2000);
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

    public void clickClearButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getСlearButton());
        clickOnElement(getСlearButton());
    }

    public void clickClearAllButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getСlearAllButton());
        clickOnElement(getСlearAllButton());
    }

    public int getSessions() {
        return getDriver().findElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"))
                .size();
    }

    public void clickLocationFilter() {
        Waiters.waitForElementToBeDisplay(getLocationCodeFilter());
        clickOnElement(getLocationCodeFilter());
    }

    public void clickProductFilter() {
        Waiters.waitForElementToBeDisplay(getProductFilter());
        clickOnElement(getProductFilter());
    }

    public void clickUpcFilter() {
        Waiters.waitForElementToBeDisplay(getUpcFilter());
        clickOnElement(getUpcFilter());
    }

    public void clickDescriptionFilter() {
        Waiters.waitForElementToBeDisplay(getDescriptionFilter());
        clickOnElement(getDescriptionFilter());
    }

    public void clickOnHandFilter() {
        Waiters.waitForElementToBeDisplay(getOnHandFilter());
        clickOnElement(getOnHandFilter());
    }

    public void clickCountedFilter() {
        Waiters.waitForElementToBeDisplay(getCountedFilter());
        clickOnElement(getCountedFilter());
    }

    public void clickUomFilter() {
        Waiters.waitForElementToBeDisplay(getUomFilter());
        clickOnElement(getUomFilter());
    }

    public List<WebElement> getCountQuantityInput() {
        Waiters.waitForElementsToBeDisplay(getTable().findElements(By.cssSelector("tr.k-master-row")));
        return getTable().findElements(By.xpath("//tr[@class='k-master-row']//input[contains(@id, 'enterCountData')]"));
    }

    public boolean isSaveButtonEnabled() { return getElementAttribute(getBtnSave(), "class").contains("i-secondary"); }

    public boolean isCountPageTitleDisplayed() {
        return isElementDisplay(countPageTitle);
    }

    public boolean isCycleCountSessionLabelDisplayed() { return isElementDisplay(cycleCountSessionLabel); }

    public boolean isCycleCountSessionDisplayed() {
        return isElementDisplay(cycleCountSession);
    }

    public boolean isCycleCountAssignmentLabelDisplayed() {
        return isElementDisplay(cycleCountAssignmentLabel);
    }

    public boolean isCycleCountAssignmentDisplayed() {
        return isElementDisplay(cycleCountAssignment);
    }

    public boolean isCycleProductSearchDisplayed() { return isElementDisplay(cycleProductSearch); }

    public boolean isAddFilterButtonDisplayed() { return isElementDisplay(addFilterButton); }

    public boolean isItemsCountDisplayed() { return isElementDisplay(itemsCount); }

    public boolean isItemsFoundDisplayed() { return isElementDisplay(itemsFound); }

    public boolean isLocationColumnDisplayed() {
        return isElementDisplay(locationColumn);
    }

    public boolean isProductColumnDisplayed() { return isElementDisplay(productColumn); }

    public boolean isUpcColumnDisplayed() { return isElementDisplay(upcColumn); }

    public boolean isDescriptionColumnDisplayed() {  return isElementDisplay(descriptionColumn);  }

    public boolean isOnHandColumnDisplayed() { return isElementDisplay(onHandColumn); }

    public boolean isCountColumnDisplayed() { return isElementDisplay(countColumn); }

    public boolean isUomColumnDisplayed() { return isElementDisplay(uomColumn); }

    public boolean isLocationLabelDisplayed() { return isElementDisplay(locationLabel); }

    public boolean isLocationCountQuantityRowsDisplayed() {
        return isElementDisplay(locationCountQuantityRows);
    }

    public boolean isAddProductButtonDisplayed() {
        return isElementDisplay(addProductButton);
    }

    public boolean isProductsColumnDisplayed() { return isElementDisplay(productsColumn); }

    public boolean isFactorColumnDisplayed() { return isElementDisplay(factorColumn); }

    public boolean isOnhandColumnDisplayed() { return isElementDisplay(onhandColumn); }

    public boolean isItemsFoundLabelDisplayed() { return isElementDisplay(itemsFoundLabel); }

    public boolean isMinusIconDisplayed() { return isElementDisplay(minusIcon); }

    public boolean isProductDataTextBoxDisplayed() { return isElementDisplay(productDataTextBox); }

    public int areProductDataTextBoxes() { return elementsArePresent(getProductDataTextBoxes()); }

    public boolean isPalletColumnDisplayed() { return isElementDisplay(palletColumn); }

    public boolean isLayerColumnDisplayed() { return isElementDisplay(layerColumn); }

    public boolean isEachColumnDisplayed() { return isElementDisplay(eachColumn); }

    public boolean isBagColumnDisplayed() { return isElementDisplay(bagColumn); }

    public boolean isCasesColumnDisplayed() { return isElementDisplay(casesColumn); }

    public boolean isProductInputDisplayed(String text) { return isElementDisplay(getLocationRowByText(text)); }

    public boolean isCancelButtonDisplayed() { return isElementDisplay(getBtnProductCountCancel()); }

    public boolean isSaveButtonDisplayed() { return isElementDisplay(getBtnProductCountSave()); }

    public boolean isTxtLpnLabelDisplayed() { return isElementDisplay(getTxtLpnLabel()); }

    public boolean isTxtLpnDisplayed() { return isElementDisplay(getTxtLpn()); }

    public boolean isPalletTypeLabelDisplayed() { return isElementDisplay(getPalletTypeLabel()); }

    public boolean isPalletTypeDisplayed() { return isElementDisplay(getPalletType()); }

    public boolean isProductIndexLabelDisplayed() { return isElementDisplay(getProductIndexLabel()); }

    public boolean isProductInputDisplayed() { return isElementDisplay(getProductInput()); }

    public boolean isSearchProductButtonDisplayed() { return isElementDisplay(getSearchProductButton()); }

    public boolean isOwnerLabelDisplayed() { return isElementDisplay(getOwnerLabel()); }

    public boolean isOwnerDropdownDisplayed() { return isElementDisplay(getOwnerDropdown()); }

    public boolean isSupplierLabelDisplayed() { return isElementDisplay(getSupplierIndexLabel()); }

    public boolean isSupplierDropdownDisplayed() { return isElementDisplay(getSupplierDropdown()); }

    public boolean isQtyLabelDisplayed() { return isElementDisplay(getTxtQtyLabel()); }

    public boolean isQtyInputDisplayed() { return isElementDisplay(getTxtQty()); }

    public boolean isTxtQtyLabelDisplayed() { return isElementDisplay(getTxtQtyLabel()); }

    public boolean isTxtQtyDisplayed() { return isElementDisplay(getTxtQty()); }

    public boolean isUomLabelDisplayed() { return isElementDisplay(getUomLabel()); }

    public boolean isUomDropDownDisplayed() { return isElementDisplay(getUomDropDown()); }

    public boolean isStatusLabelDisplayed() { return isElementDisplay(getStatusLabel()); }

    public boolean isStatusDropDownDisplayed() { return isElementDisplay(getStatus()); }

    public boolean isDateCodeLabelDisplayed() { return isElementDisplay(getTxtDateCodeLabel()); }

    public boolean isDateCodeDisplayed() { return isElementDisplay(getTxtDateCode()); }

    public WebElement getCountPageTitle() { return findWebElement(countPageTitle); }

    public WebElement getCycleCountSessionLabel() { return findWebElement(cycleCountSessionLabel); }

    public WebElement getCycleCountSession() { return findWebElement(cycleCountSession); }

    public WebElement getCycleCountAssignmentLabel() { return findWebElement(cycleCountAssignmentLabel); }

    public WebElement getCycleCountAssignment() { return findWebElement(cycleCountAssignment); }

    public WebElement getCycleProductSearch() { return findWebElement(cycleProductSearch); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getItemsCount() { return findWebElement(itemsCount); }

    public WebElement getItemsFound() { return findWebElement(itemsFound); }

    public WebElement getLocationColumn() { return findWebElement(locationColumn); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getUpcColumn() { return findWebElement(upcColumn); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getOnHandColumn() { return findWebElement(onHandColumn); }

    public WebElement getCountColumn() { return findWebElement(countColumn); }

    public WebElement getUomColumn() { return findWebElement(uomColumn); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

    public WebElement getLocationCodeFilter() { return findWebElement(locationCodeFilter); }

    public WebElement getProductFilter() { return findWebElement(productCodeFilter); }

    public WebElement getUpcFilter() { return findWebElement(upcCodeFilter); }

    public WebElement getDescriptionFilter() { return findWebElement(descriptionFilter); }

    public WebElement getOnHandFilter() { return findWebElement(onHandFilter); }

    public WebElement getCountedFilter() { return findWebElement(countedQtyFilter); }

    public WebElement getUomFilter() { return findWebElement(uomFilter); }

    public WebElement getInputContains() { return findWebElement(inputContains); }

    public WebElement getApplyButton() { return findWebElement(applyButton); }

    public WebElement getInputSearch() { return findWebElement(inputSearch); }

    public WebElement getСlearButton() { return findWebElement(clearButton); }

    public WebElement getСlearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getTable() { return findWebElement(table); }

    public WebElement getLocationLabel() { return findWebElement(locationLabel); }

    public WebElement getLocationCountQuantityRows() { return findWebElement(locationCountQuantityRows); }

    public WebElement getAddProductButton() { return findWebElement(addProductButton); }

    public WebElement getProductsColumn() { return findWebElement(productsColumn); }

    public WebElement getFactorColumn() { return findWebElement(factorColumn); }

    public WebElement getOnHandColumnColumn() { return findWebElement(onhandColumn); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getMinusIcon() { return findWebElement(minusIcon); }

    public WebElement getProductDataTextBox() { return findWebElement(productDataTextBox); }

    public List<WebElement> getProductDataTextBoxes() { return findWebElements(productDataTextBox); }

    public WebElement getPalletColumn() { return findWebElement(palletColumn); }

    public WebElement getLayerColumn() { return findWebElement(layerColumn); }

    public WebElement getEachColumn() { return findWebElement(eachColumn); }

    public WebElement getBagColumn() { return findWebElement(bagColumn); }

    public WebElement getBtnProductCountCancel() { return findWebElement(btnProductCountCancel); }

    public WebElement getBtnProductCountSave() { return findWebElement(btnProductCountSave); }

    public WebElement getReduceButton() { return findWebElement(reduceButton); }

    public WebElement getEnlargeButton() { return findWebElement(enlargeButton); }

    public WebElement getTxtLpnLabel() { return findWebElement(txtLpnLabel); }

    public WebElement getTxtLpn() { return findWebElement(txtLpn); }

    public WebElement getPalletTypeLabel() { return findWebElement(palletTypeLabel); }

    public WebElement getPalletType() { return findWebElement(palletType); }

    public WebElement getProductIndexLabel() { return findWebElement(productIndexLabel); }

    public WebElement getProductInput() { return findWebElement(productInput); }

    public WebElement getSearchProductButton() { return findWebElement(searchProductButton); }

    public WebElement getOwnerLabel() { return findWebElement(ownerLabel); }

    public WebElement getOwnerDropdown() { return findWebElement(ddlOwnerDropdown); }

    public WebElement getSupplierIndexLabel() { return findWebElement(supplierIndexLabel); }

    public WebElement getSupplierDropdown() { return findWebElement(supplierDropdown); }

    public WebElement getTxtQtyLabel() { return findWebElement(txtQtyLabel); }

    public WebElement getTxtQty() { return findWebElement(txtQty); }

    public WebElement getUomLabel() { return findWebElement(uomLabel); }

    public WebElement getUomDropDown() { return findWebElement(uomDropDown); }

    public WebElement getStatusLabel() { return findWebElement(ddlStatusLabel); }

    public WebElement getStatus() { return findWebElement(ddlStatus); }

    public WebElement getTxtDateCodeLabel() { return findWebElement(txtDateCodeLabel); }

    public WebElement getTxtDateCode() { return findWebElement(txtDateCode); }

    public WebElement getBtnCancel() { return findWebElement(btnCancel); }

    public WebElement getBtnSave() { return findWebElement(btnSave); }

}
