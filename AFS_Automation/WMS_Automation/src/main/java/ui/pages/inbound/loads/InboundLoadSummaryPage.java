package ui.pages.inbound.loads;

import common.constants.TimeFormats;
import common.utils.Waiters;
import common.utils.time.TimeConversion;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.BasePage;

import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static common.setup.DriverManager.getDriver;
import static org.testng.AssertJUnit.assertTrue;
import static utilWMS.TestBase.driver;

public class InboundLoadSummaryPage extends BasePage {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    By topIcon = By.xpath("//span[contains(text(), 'Inbound load summary')]");
    By dropdownList = By.id("dropdownList");
    By cardRouteSummaryFilter = By.cssSelector("#cardRouteSummaryFilter");
    By cardRouteSummaryGrid = By.cssSelector("#divSummaryCommon");
    By dateRouteStart = By.cssSelector("#dateRouteStart");
    By dateRouteEnd = By.cssSelector("#dateRouteEnd");
    By enterLoadInput = By.cssSelector("input[placeholder='Enter load']");
    By enterSupplierInput = By.cssSelector("input[placeholder='Enter a supplier']");
    By searchSupplierButton = By.xpath("//div[@class='i-indexfield-container w__width_100per']//button");
    By enterNameInput = By.cssSelector("input[placeholder='Enter name']");
    By enterProductInput = By.cssSelector("input[placeholder='Enter a product']");
    By searchProductButton = By.cssSelector(".autocomplete_custom button.k-button-icontext");
    By loadOptionsButton = By.xpath("//span[text()='Load options']");
    By tableContent = By.cssSelector(".k-grid-table");
    By invalidEntryPopup = By.cssSelector(".k-window-title");
    By dialogPopup = By.cssSelector(".k-dialog-title");
    By dialogContent = By.cssSelector(".k-dialog-content");
    By dialogTextContent = By.id("dialogTextContent");
    By okButton = By.xpath("//span[contains(text(), 'Ok')]");
    By saveButton = By.xpath("//span[contains(text(), 'Save')]");
    By cancelButton = By.xpath("//span[contains(text(), 'Cancel')]");
    By noButton = By.xpath("//button[contains(text(), 'No')]");
    By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    By routeBackButton = By.id("RouteBackButton");
    By clearButton = By.cssSelector("span[title=clear]");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By changeStatusOption = By.id("btnChangeStatus");
    By doorOption = By.id("ddDoorItem");
    By dataOption = By.id("ddDataItem");
    By notificationMsg = By.cssSelector(".toast-message");
    By temperatureLabel = By.xpath("//label[text()='Temperature']");
    By temperatureInput = By.xpath("//label[text()='Temperature']//following-sibling::input");
    By sealNumberLabel = By.xpath("//label[text()='Seal Number']");
    By sealNumberInput = By.xpath("//label[text()='Seal Number']//following-sibling::input");
    By commentsLabels = By.xpath("//label[text()='Comments']");
    By commentsInputs = By.xpath("//label[text()='Comments']//following-sibling::input");
    By yesRadioButtons = By.xpath("//label[text()='Yes']//preceding-sibling::input");
    By noRadioButtons = By.xpath("//label[text()='No']//preceding-sibling::input");
    By btnAddProductCancel = By.id("btnAddProductCancel");
    By loadCodeLabel = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Load code']]");
    By loadCodeInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Load code']]//input");
    By scheduledDateLabel = By.cssSelector("#cpDate-label");
    By scheduledDate = By.cssSelector("#cpDate");
    By carrierLabel = By.xpath("//label[contains(text(), 'Carrier')]");
    By carrierInput = By.xpath("(//span[@role='combobox' and //label[contains(text(), 'Carrier')]])[3]");
    By trailerLabel = By.xpath("//label[contains(text(), 'Trailer')]");
    By trailerInput = By.xpath("(//span[@role='combobox' and //label[contains(text(), 'Carrier')]])[4]");
    By doorLabel = By.xpath("//label[contains(text(), 'Door')]");
    By doorInput = By.xpath("(//span[@role='combobox' and //label[contains(text(), 'Carrier')]])[6]");
    By loadTypeLabel = By.xpath("//label[contains(text(), 'Load type')]");
    By loadTypeInput = By.xpath("(//span[@role='combobox' and //label[contains(text(), 'Carrier')]])[2]");
    By scheduledTimeLabel = By.cssSelector("#cpTile-label");
    By scheduledTimeInput = By.cssSelector("#cpTile");
    By driverLabel = By.xpath("//label[contains(text(), 'Driver')]");
    By driverInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Driver']]//input");
    By temperatureField = By.xpath("//span[contains(@class,'k-textbox-container')][.//label[text()='Temperature']]//input");
    By sourceOrderTypeColumn = By.xpath("//span[text()='Order type']");
    By sourceOrderColumn = By.xpath("//span[text()='Order no.']");
    By sourceStatusColumn = By.xpath("//span[text()='Status']");
    By readyToReceiveStatus = By.cssSelector("input[value='Ready To Receive']");
    By cancelInboundStatus = By.cssSelector("input[value='Cancel Inbound']");
    By reopenOrderStatus = By.cssSelector("input[value='Reopen Order']");
    By finishReceivingOrderStatus = By.cssSelector("input[value='Finish Receiving']");
    By loadField = By.xpath("//span[contains(text(), 'Load')]");
    By orderLoadNumber = By.xpath("//span[contains(text(), 'Order')]//following-sibling::span[contains(@id, 'spnOrderNo')]");
    By ownerField = By.xpath("//span[contains(text(), 'Owner')]");
    By sourceField = By.xpath("//span[contains(text(), 'Source')]");
    By loadNumber = By.cssSelector("#spnRouteCodeNo");
    By doorField = By.xpath("//span[contains(text(), 'Door')]");
    By qaField = By.xpath("//span[contains(text(), 'QA')]");
    By trailerField = By.xpath("//span[contains(text(), 'Trailer')]");
    By carrierField = By.xpath("//span[contains(text(), 'Carrier')]");
    By ordersField = By.xpath("//span[contains(text(), 'Orders')]");
    By qtyField = By.xpath("//span[contains(text(), 'Qty')]");
    By cubeField = By.xpath("//span[contains(text(), 'Cube')]");
    By weightField = By.xpath("//span[contains(text(), 'Weight')]");
    By imagesButton = By.xpath("(//button[@id='btnImageNo'])[2]");
    By commentsButton = By.xpath("(//button[@id='btnImageNo'])[1]");
    By receivedQty = By.xpath("//span[contains(@class, 'dot--green')]/following-sibling::span[contains(text(), 'Received')]");
    By stagedQty = By.xpath("//span[contains(@class, 'dot--yellow')]/following-sibling::span[contains(text(), 'Staged')]");
    By redQty = By.xpath("//span[contains(@class, 'dot--red')]/following-sibling::span[contains(text(), 'Over')]");
    By grayQty = By.xpath("//span[contains(@class, 'dot--gray')]/following-sibling::span[contains(text(), 'Remainder')]");
    By loadOrders = By.cssSelector("#crdInboundOrderPortrait .BarsBlock");
    By orderedLabel = By.xpath("//label[contains(text(), 'Ordered:')]");
    By stagedLabel = By.xpath("//label[contains(text(), 'Staged:')]");
    By receivedLabel = By.xpath("//label[contains(text(), 'Received:')]");
    By reviewLoadLabel = By.xpath("//label[contains(text(), 'Review load')]");
    By productColumn = By.xpath("//table[@role='presentation']//span[text() ='Product']");
    By descriptionColumn = By.xpath("//table[@role='presentation']//span[text() ='Description']");
    By qualifier1Column = By.xpath("//table[@role='presentation']//span[text() ='Qualifier 1']");
    By orderedColumn = By.xpath("//table[@role='presentation']//span[text() ='Ordered']");
    By stagedColumn = By.xpath("//table[@role='presentation']//span[text() ='Staged']");
    By receivedColumn = By.xpath("//table[@role='presentation']//span[text() ='Received']");
    By statusColumn = By.xpath("//table[@role='presentation']//span[text() ='Status']");
    By lotColumn = By.xpath("//table[@role='presentation']//span[text() ='Lot']");
    By expDateColumn = By.xpath("//table[@role='presentation']//span[text() ='Exp Date']");
    By dateCodeColumn = By.xpath("//table[@role='presentation']//span[text() ='Date code']");
    By weightColumn = By.xpath("//table[@role='presentation']//span[text() ='Weight']");
    By cancelBtn = By.id("btnReviewCancel");
    By saveBtn = By.id("btnReviewSave");
    By loader = By.cssSelector(".loader");
    By searchInput = By.cssSelector("#SummaryInboundLoad_DataSearch");
    By clearSearchButton = By.cssSelector(".i-search-box .i-search-box__clear");
    By selectFilesBtn = By.xpath("//span[contains(text(), 'Select files')]");
    By loadImageLabel = By.xpath("//span[text()='Load image(s)']");
    By saveEditButton = By.id("saveEditButton");
    By inboundImageCaptureButton = By.cssSelector(".inboundImageCaptureOpButtonDiv button");

    By layoutexpand = By.xpath("//span[@class='k-icon k-i-arrow-chevron-up']");
    By layoutcollapse = By.xpath("//*[@id='cardRouteSummaryFilter']/button/span[1]");
    private By getCarrier(String carrier) {
        return By.xpath("//span[contains(@role,'listbox')][.//span[contains(text(), '" + carrier + "')]]");
    }

    private By getStatus(String status) {
        return By.xpath("//span[@class='k-input' and text()='" + status + "']");
    }

    private By getDoorDropDown(String door) {
        return By.xpath("//span[contains(@class, 'dropdown-list')]//span[contains(text(),'" + door + "')]");
    }

    private By getLoadTypeDropDown(String loadType) {
        return By.xpath("//span[contains(text(),'" + loadType + "')]");
    }

    private By getBuyerDropDown(String buyer) {
        return By.xpath("//span[contains(text(),'" + buyer + "')]");
    }

    public void waitInboundLoadSummaryPageToLoad() {
        waitUntilInvisible(8, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTopIcon());
        Waiters.waitForElementToBeDisplay(getLoadOptionsButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectLoadOption(String option) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLoadOptionsButton());
        Waiters.waitABit(2000);
        clickOnElement(getLoadOptionsButton());
        WebElement loadedOption = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + option + "')]"));
        scrollToCenter(loadedOption);
        Waiters.waitABit(2000);
        clickOnElement(loadedOption);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(2000);
        if(isVisible(By.xpath("//button/span[text()='Ok']"))) {
            clickOnElement(findWebElement(By.xpath("//button/span[text()='Ok']")));
        }
    }

    public void clickLoadOptionDropDown() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLoadOptionsButton());
        clickOnElement(getLoadOptionsButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDoorDropdown(String door) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDoorDropDown(door));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLoadTypeDropdown(String loadType) {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getLoadTypeDropDown(loadType));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickBuyerDropDown(String buyer) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getBuyerDropDown(buyer));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLoadStatus(String status) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getStatusDropDown(status));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectLoadStatus(String status) {
        Waiters.waitTillLoadingPage(getDriver());
        List<WebElement> statuses = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']"));
        WebElement option = statuses.stream()
                    .filter(el -> el.getText().contains(status))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Status " + status + " is not found"));
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectWarehouse(String warehouse) {
        Waiters.waitTillLoadingPage(getDriver());
        List<WebElement> warehouses = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']"));
        WebElement option = warehouses.stream()
                .filter(el -> el.getText().contains(warehouse))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Warehouse " + warehouse + " is not found"));
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public int getRowsCount() {
        Waiters.waitForElementToBeDisplay(tableContent);
        return getTableContent().findElements(By.xpath(".//tr")).size();
    }

    /*public void selectLoadByLoadNumber(int loadNum) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> loads = getTableContent().findElements(By.xpath(".//tr[@class='k-detail-row']"));
        Waiters.waitTillLoadingPage(getDriver());
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(loads.get(loadNum).findElements(By.xpath(".//input")).get(0));
        waitUntilInvisible(2, loader);
    }*/

    public void clickLoadByLoadNumber(int loadNum) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> loads = findWebElements(By.xpath("//div[contains(@class, 'BarsBlock')]"));
        Waiters.waitTillLoadingPage(getDriver());
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        Waiters.waitTillLoadingPage(getDriver());
        jsClick(loads.get(loadNum));
        waitUntilInvisible(3, loader);
    }

    public void searchLoad(String load) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        enterText(getEnterLoadInput(), load);
        pressEnter(getEnterLoadInput());
        waitUntilInvisible(2, loader);
    }

    public void searchSupplierByCode(String code) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterSupplierInput());
        enterText(getEnterSupplierInput(), code);
        pressEnter(getEnterSupplierInput());
        waitUntilInvisible(2, loader);
    }

    public void searchSupplierByName(String name) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterNameInput());
        enterText(getEnterNameInput(), name);
        pressEnter(getEnterNameInput());
        waitUntilInvisible(2, loader);
    }

    public void cleanSupplierName() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterNameInput());
        clearText(getEnterNameInput());
        waitUntilInvisible(2, loader);
    }

    public void clearSearchInput() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(clearSearchButton);
        clickOnElement(clearSearchButton);
    }

   /* public void cleanSearchInput() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSearchInput());
        doubleClick(getSearchInput());
        pressDelete(getSearchInput());
        pressEnter(getSearchInput());
    }*/

    public void cleanProduct() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getClearButton());
        waitUntilInvisible(4, loader);
    }

    /*public void cleanLoad() {
        Waiters.waitForElementToBeDisplay(tableContent);
        doubleClick(getEnterLoadInput());
        pressDelete(getEnterLoadInput());
        pressEnter(getEnterLoadInput());
        waitUntilInvisible(2, loader);
    }*/

    public String getGridTableRowContent(int row) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTableContent());
        return getText(getTableContent().findElements(By.xpath(".//tr")).get(row));
    }

    /*public void clickCarrierDropdown(String carrier) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getCarrierDropdown(carrier));
        Waiters.waitTillLoadingPage(getDriver());
    }*/

    public void clickChangeStatusOption() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getChangeStatusOption());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDoorOption() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDoorOption());
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilInvisible(2, loader);
    }

    public void clickDataOption() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDataOption());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDoorDropdown() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(By.id("ddDoorList"));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectOption(String option) {
        Waiters.waitABit(3000);
        List<WebElement> warehouses = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']"));
        WebElement webElement = warehouses.stream()
                .filter(el -> el.getText().contains(option))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Option " + option + " is not found"));
        clickOnElement(webElement);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(3000);
    }

    public void clickSave() {
        clickOnElement(saveButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickCancel() {
        clickOnElement(cancelButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickRouteBackButton() {
        waitUntilInvisible(2, loader);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(routeBackButton);
        waitUntilInvisible(2, loader);
    }

    public void clickNoButton() {
        clickOnElement(noButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectLoadByLoadRouteCode(String routeCode) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> loads = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-detail-row')]"));
        Waiters.waitABit(1000);
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        WebElement route = loads.stream()
                .filter(el -> el.getText().contains(routeCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Route with Route Code " + routeCode + " is not found"));
        clickOnElement(route);
        waitUntilInvisible(2, loader);
    }

    public void checkLoadByLoadRouteCode(String routeCode) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> loads = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-detail-row')]"));
        Waiters.waitABit(1000);
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        WebElement route = loads.stream()
                .filter(el -> el.getText().contains(routeCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Route with Route Code " + routeCode + " is not found"));
        clickOnElement(route.findElement(By.xpath(".//input[@type='checkbox']")));
    }

    public void checkLoadByLoadRouteIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> loads = findWebElements(By.xpath("//div[contains(@class, 'BarsContainer')]"));
        Waiters.waitTillLoadingPage(getDriver());
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(2000);
        jsClick(findWebElements(By.xpath("//div[contains(@class, 'BarsContainer')]/parent::*//input[@type='checkbox']"))
                .get(index));
    }

    /*public void typeValueInSearch(String text) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSearchInput());
        inputText(getSearchInput(), text);
        pressEnter(getSearchInput());
    }*/

    public void typeDateLoadStart(CharSequence date) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateRouteStart());
        doubleClick(getDateRouteStart());
        pressDelete(getDateRouteStart());
        inputText(getDateRouteStart(), date);
        clickOnElement(findWebElement(By.cssSelector(".i-card__card__title-area__title")));
        waitUntilInvisible(3, loader);
    }

    public void typePastDateLoadStart(int days) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateRouteStart());
        doubleClick(getDateRouteStart());
        pressDelete(getDateRouteStart());
        inputText(getDateRouteStart(), TimeConversion.pastDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        pressEnter(getDateRouteStart());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeFutureDateLoadStart(int days) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateRouteStart());
        doubleClick(getDateRouteStart());
        pressDelete(getDateRouteStart());
        inputText(getDateRouteStart(), TimeConversion.futureDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        pressEnter(getDateRouteStart());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typePastDateLoadEnd(int days) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateRouteEnd());
        doubleClick(getDateRouteEnd());
        pressDelete(getDateRouteEnd());
        inputText(getDateRouteEnd(), TimeConversion.pastDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        pressEnter(getDateRouteEnd());
        Waiters.waitTillLoadingPage(getDriver());
    }

  /*  public void typeFutureDateLoadEnd(int days) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateRouteEnd());
        doubleClick(getDateRouteEnd());
        pressDelete(getDateRouteEnd());
        inputText(getDateRouteEnd(), TimeConversion.futureDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        pressEnter(getDateRouteEnd());
        Waiters.waitTillLoadingPage(getDriver());
    }*/

    public void typeDateRouteEnd(CharSequence date) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateRouteEnd());
        doubleClick(getDateRouteEnd());
        pressDelete(getDateRouteEnd());
        inputText(getDateRouteEnd(), date);
        pressEnter(getDateRouteEnd());
        Waiters.waitTillLoadingPage(getDriver());
    }

    /*public void typeProduct(CharSequence product) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterProductInput());
        inputText(getEnterProductInput(), product);
        pressEnter(getEnterProductInput());
        Waiters.waitTillLoadingPage(getDriver());
    }*/

    public void typeTemperature(CharSequence temperature) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTemperatureInput());
        clear(getTemperatureInput());
        inputText(getTemperatureInput(), temperature);
        pressEnter(getTemperatureInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeSealNumber(CharSequence sealNumber) {
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getSealNumberInput());
        Waiters.waitForElementToBeDisplay(getSealNumberInput());
        clear(getSealNumberInput());
        inputText(getSealNumberInput(), sealNumber);
        pressEnter(getSealNumberInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeDriver(String driver) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDriverInput());
        enterText(getDriverInput(), driver);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickSearchSupplierButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSearchSupplierButton());
        clickOnElement(getSearchSupplierButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOkButton(WebElement webElement) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getOkButton());
        clickOnElement(getOkButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickImagesButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getImagesButton());
        clickOnElement(getImagesButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickCommentsButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getCommentsButton());
        clickOnElement(getCommentsButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickBtnAddProductCancel() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getBtnAddProductCancel());
        clickOnElement(getBtnAddProductCancel());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickReadyToReceiveStatus() {
        Waiters.waitABit(4000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getReadyToReceiveStatus());
        clickOnElement(getReadyToReceiveStatus());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLoadOrderByNumber(int num) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getLoadOrders().get(num));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public boolean isTopIconPresent() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.xpath("//span[contains(text(), 'Inbound load summary')]"));
        return isElementPresent(getTopIcon());
    }

    public boolean isDropdownListDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDropdownList());
        return isElementPresent(getDropdownList());
    }

    public boolean isDateRouteStartPresent() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector("#dateRouteStart"));
        return isElementPresent(getDateRouteStart());
    }

    public boolean isDateRouteEndPresent() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector("#dateRouteEnd"));
        return isElementPresent(getDateRouteEnd());
    }

    public boolean isStatusDropDownPresent() {
       /* Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.xpath("//span[@class='k-input' and text()='All statuses']"));
        return isElementPresent(getStatusDropDown("All statuses"));*/
        Waiters.waitTillLoadingPage(getDriver());
        By statusDropdownLocator = By.xpath("//span[contains(@class,'k-chip-label') and contains(text(),'Status selected')]");
        Waiters.waitForElementToBeDisplay(statusDropdownLocator);
        return isElementPresent(statusDropdownLocator);
    }

    public boolean isCardRouteSummaryFilterPresent() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector("#cardRouteSummaryFilter"));
        return isElementPresent(getCardRouteSummaryFilter());
    }

    public boolean isCardRouteSummaryGridPresent() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector("#divSummaryCommon"));
        return isElementPresent(getCardRouteSummaryGrid());
    }

    public boolean isInvalidEntryPopUpDisplayed() {
        return isElementDisplay(getInvalidEntryPopup());
    }

    public boolean isTemperatureLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(3000);
        scrollToCenter(getTemperatureLabel());
        Waiters.waitForElementToBeDisplay(getTemperatureLabel());
        return isElementDisplay(getTemperatureLabel());
    }

    public boolean isTemperatureInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getTemperatureInput());
        Waiters.waitForElementToBeDisplay(getTemperatureInput());
        return isElementDisplay(getTemperatureInput());
    }

    public boolean isSealNumberLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getSealNumberLabel());
        Waiters.waitForElementToBeDisplay(getSealNumberLabel());
        return isElementDisplay(getSealNumberLabel());
    }

    public boolean isSealNumberInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        scrollToCenter(getSealNumberInput());
        Waiters.waitForElementToBeDisplay(getSealNumberInput());
        return isElementDisplay(getSealNumberInput());
    }

    public int areCommentsLabelsDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForAllElementsToBeDisplay(getCommentsLabels().get(0));
        return elementsArePresent(getCommentsLabels());
    }

    public int areCommentsInputsDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForAllElementsToBeDisplay(getCommentsInputs().get(0));
        return elementsArePresent(getCommentsInputs());
    }

    public int areYesRadioButtonsDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForAllElementsToBeDisplay(getYesRadioButtons().get(0));
        return elementsArePresent(getYesRadioButtons());
    }

    public int areNoRadioButtonsDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForAllElementsToBeDisplay(getNoRadioButtons().get(0));
        return elementsArePresent(getNoRadioButtons());
    }

    public boolean isBtnAddProductCancelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getBtnAddProductCancel());
        return isElementDisplay(getBtnAddProductCancel());
    }

    public boolean isLoadCodeLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLoadCodeLabel());
        return isElementDisplay(getLoadCodeLabel());
    }

    public boolean isLoadCodeInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLoadCodeInput());
        return isElementDisplay(getLoadCodeInput());
    }

    public boolean isScheduledDateLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getScheduledDateLabel());
        return isElementDisplay(getScheduledDateLabel());
    }

    public boolean isScheduledDateDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getScheduledDate());
        return isElementDisplay(getScheduledDate());
    }

    public boolean isCarrierLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getCarrierLabel());
        return isElementDisplay(getCarrierLabel());
    }

    public boolean isCarrierInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getCarrierInput());
        return isElementDisplay(getCarrierInput());
    }

    public boolean isTrailerLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTrailerLabel());
        return isElementDisplay(getTrailerLabel());
    }

    public boolean isTrailerInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTrailerInput());
        return isElementDisplay(getTrailerInput());
    }

    public boolean isDoorLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDoorLabel());
        return isElementDisplay(getDoorLabel());
    }

    public boolean isDoorInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDoorInput());
        return isElementDisplay(getDoorInput());
    }

    public boolean isLoadTypeLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLoadTypeLabel());
        return isElementDisplay(getLoadTypeLabel());
    }

    public boolean isLoadTypeInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLoadTypeInput());
        return isElementDisplay(getLoadTypeInput());
    }

    public boolean isScheduledTimeLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getScheduledTimeLabel());
        return isElementDisplay(getScheduledTimeLabel());
    }

    public boolean isScheduledTimeInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getScheduledTimeInput());
        return isElementDisplay(getScheduledTimeInput());
    }

    public boolean isDriverLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDriverLabel());
        return isElementDisplay(getDriverLabel());
    }

    public boolean isDriverInputDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDriverInput());
        return isElementDisplay(getDriverInput());
    }

    public boolean isTemperatureFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTemperatureField());
        return isElementDisplay(getTemperatureField());
    }

    public boolean isSourceOrderTypeDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSourceOrderType());
        return isElementDisplay(getSourceOrderType());
    }

    public boolean isSourceOrderDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSourceOrder());
        return isElementDisplay(getSourceOrder());
    }

    public boolean isSourceStatusDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSourceStatus());
        return isElementDisplay(getSourceStatus());
    }

    public boolean isReadyToReceiveStatusDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getReadyToReceiveStatus());
        return isElementDisplay(getReadyToReceiveStatus());
    }

    public boolean isCancelInboundStatusDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getCancelInboundStatus());
        return isElementDisplay(getCancelInboundStatus());
    }

    public boolean isReopenOrderStatusDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getReopenOrderStatus());
        return isElementDisplay(getReopenOrderStatus());
    }

    public boolean isFinishReceivingOrderDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getFinishReceivingOrderStatus());
        return isElementDisplay(getFinishReceivingOrderStatus());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(itemsFoundLabel);
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(itemsFoundValue);
    }

    public boolean isLoadFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLoadField());
    }

    public boolean isLoadNumberDisplayed() {
        Waiters.waitABit(4000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getLoadNumber());
    }

    public boolean isDoorFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getDoorField());
    }

    public boolean isQaFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getQaField());
    }

    public boolean isCarrierFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(carrierField);
    }

    public boolean isOrdersFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getOrdersField());
    }

    public boolean isQtyFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getQtyField());
    }

    public boolean isCubeFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getCubeField());
    }

    public boolean isWeightFieldDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getWeightField());
    }

    public boolean isImagesButtonDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getImagesButton());
    }

    public boolean isWarehouseDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getDropdownList());
    }

    public boolean isCommentsButtonDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getCommentsButton());
    }

    public boolean isReceivedQtyDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getReceivedQty());
    }

    public boolean isStagedQtyDisplayed() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getStagedQty());
    }

    public boolean isRedQtyDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getRedQty());
    }

    public boolean isGrayQtyDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getGrayQty());
    }

    public boolean isSaveButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(saveButton);
    }

    public boolean isCancelButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(cancelButton);
    }

    public boolean isYesButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(yesButton);
    }

    public boolean isNoButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(noButton);
    }

    public int isLoadOrdersListDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return elementsArePresent(getLoadOrders());
    }

    public String getItemsFoundText() {
        Waiters.waitABit(3000);
        Waiters.waitTillLoadingPage(getDriver());
        return getText(itemsFoundValue);
    }

    public String getInvalidEntryPopUpText() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector(".k-window-title"));
        return getText(getInvalidEntryPopup());
    }

    public String getDialogPopUpText() {
        waitUntilInvisible(3, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector(".k-dialog-title"));
        return getText(getDialogPopup());
    }

    public String getDialogTextTitle() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector("#dialogTextContent"));
        return getText(getDialogTextContent());
    }

    public String getDialogPopUpContentText() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector(".k-dialog-content"));
        return getText(getDialogContent());
    }

    public String getDateRouteStartValue() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateRouteStart());
        return getValue(getDateRouteStart());
    }

    public String getDateRouteEndValue() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateRouteEnd());
        return getValue(getDateRouteEnd());
    }

    public boolean isOrderedLabelDisplayed() { return isElementDisplay(getOrderedLabel()); }

    public boolean isStagedLabelDisplayed() { return isElementDisplay(getStagedLabel()); }

    public boolean isReceivedLabelDisplayed() { return isElementDisplay(getReceivedLabel()); }

    public boolean isReviewLoadLabelDisplayed() { return isElementDisplay(getReviewLoadLabel()); }

    public boolean isProductColumnDisplayed() { return isElementDisplay(getProductColumn()); }

    public boolean isDescriptionColumnDisplayed() { return isElementDisplay(getDescriptionColumn()); }

    public boolean isQualifier1ColumnDisplayed() { return isElementDisplay(getQualifier1Column()); }

    public boolean isOrderedColumnDisplayed() { return isElementDisplay(getOrderedColumn()); }

    public boolean isStagedColumnDisplayed() { return isElementDisplay(getStagedColumn()); }

    public boolean isReceivedColumnDisplayed() { return isElementDisplay(getReceivedColumn()); }

    public boolean isStatusColumnDisplayed() { return isElementDisplay(getStatusColumn()); }

    public boolean isLotColumnDisplayed() { return isElementDisplay(getLotColumn()); }

    public boolean isExpDateColumnDisplayed() { return isElementDisplay(getExpDateColumn()); }

    public boolean isDateCodeColumnDisplayed() { return isElementDisplay(getDateCodeColumn()); }

    public boolean isCancelBtnDisplayed() { return isElementDisplay(getCancelBtn()); }

    public boolean isSaveBtnDisplayed() { return isElementDisplay(getSaveBtn()); }

    public boolean isSelectFilesBtnDisplayed() { return isElementDisplay(getSelectFilesBtn()); }

    public boolean isLoadImageLabelDisplayed() { return isElementDisplay(getLoadImageLabel()); }

    public boolean isSaveEditButtonDisplayed() { return isElementDisplay(getSaveEditButton()); }

    public boolean isInboundImageCaptureButtonDisplayed() { return isElementDisplay(getInboundImageCaptureButton()); }

    public String isDataOptionDisabled() {
        return getElementAttribute(getDataOption(), "aria-disabled");
    }

   /* public String isEditDisabled() {
        return getElementAttribute(findWebElement(By.xpath("//li[@role='menuItem' and text()='Edit']")), "aria-disabled");
    }*/
   public String isEditDisabled() {
       WebElement editButton = findWebElement(By.xpath("//span[text()='Edit']/ancestor::li"));
       return getElementAttribute(editButton, "aria-disabled");
   }

    public String isSourceDisabled() {
        return getElementAttribute(findWebElement(By.xpath("//span[text()='Source']/ancestor::li")), "aria-disabled");
    }

    public String isReceiveDisabled() {
        return getElementAttribute(findWebElement(By.xpath("//span[text()='Receive']/ancestor::li")), "aria-disabled");
    }

    public WebElement getTopIcon() {
        return findWebElement(topIcon);
    }

    public WebElement getDropdownList() {
        return findWebElement(dropdownList);
    }

    public WebElement getCardRouteSummaryFilter() {
        return findWebElement(cardRouteSummaryFilter);
    }

    public WebElement getCardRouteSummaryGrid() {
        return findWebElement(cardRouteSummaryGrid);
    }

    public WebElement getDateRouteStart() {
        return findWebElement(dateRouteStart);
    }

    public WebElement getDateRouteEnd() {
        return findWebElement(dateRouteEnd);
    }

    public WebElement getEnterLoadInput() {
        return findWebElement(enterLoadInput);
    }

    public WebElement getEnterNameInput() {
        return findWebElement(enterNameInput);
    }

    public WebElement getEnterSupplierInput() {
        return findWebElement(enterSupplierInput);
    }

    public WebElement getSearchSupplierButton() {
        return findWebElement(searchSupplierButton);
    }

    public WebElement getEnterProductInput() {
        return findWebElement(enterProductInput);
    }

    public WebElement getSearchProductButton() {
        return findWebElement(searchProductButton);
    }

    public WebElement getLoadOptionsButton() {
        return findWebElement(loadOptionsButton);
    }

    public WebElement getTableContent() {
        return findWebElement(tableContent);
    }

    public WebElement getInvalidEntryPopup() {
        return findWebElement(invalidEntryPopup);
    }

    public WebElement getDialogPopup() {
        return findWebElement(dialogPopup);
    }

    public WebElement getDialogContent() {
        return findWebElement(dialogContent);
    }

    public WebElement getOkButton() { return findWebElement(okButton); }

    public WebElement getClearButton() {
        return findWebElement(clearButton);
    }

    public WebElement getStatusDropDown(String status) {
        return findWebElement(getStatus(status));
    }

    public WebElement getItemsFoundLabel() {
        return findWebElement(itemsFoundLabel);
    }

    public WebElement getItemsFoundValue() {
        return findWebElement(itemsFoundValue);
    }

    public WebElement getCarrierDropdown(String carrier) {
        return findWebElement(getCarrier(carrier));
    }

    public WebElement getChangeStatusOption() {
        return findWebElement(changeStatusOption);
    }

    public WebElement getDoorOption() {
        return findWebElement(doorOption);
    }

    public WebElement getDataOption() {
        return findWebElement(dataOption);
    }

    public WebElement getNotificationMsg() {
        return findWebElement(notificationMsg);
    }

    public WebElement getTemperatureLabel() { return findWebElement(temperatureLabel); }

    public WebElement getTemperatureInput() {
        return findWebElement(temperatureInput);
    }

    public WebElement getSealNumberLabel() { return findWebElement(sealNumberLabel); }

    public WebElement getSealNumberInput() { return findWebElement(sealNumberInput); }

    public List<WebElement> getCommentsLabels() {
        return findWebElements(commentsLabels);
    }

    public List<WebElement> getCommentsInputs() {
        return findWebElements(commentsInputs);
    }

    public List<WebElement> getYesRadioButtons() {
        return findWebElements(yesRadioButtons);
    }

    public List<WebElement> getNoRadioButtons() {
        return findWebElements(noRadioButtons);
    }

    public WebElement getBtnAddProductCancel() {
        return findWebElement(btnAddProductCancel);
    }

    public WebElement getLoadCodeLabel() {
        return findWebElement(loadCodeLabel);
    }

    public WebElement getLoadCodeInput() {
        return findWebElement(loadCodeInput);
    }

    public WebElement getScheduledDateLabel() { return findWebElement(scheduledDateLabel); }

    public WebElement getScheduledDate() {
        return findWebElement(scheduledDate);
    }

    public WebElement getCarrierLabel() {
        return findWebElement(carrierLabel);
    }

    public WebElement getCarrierInput() {
        return findWebElement(carrierInput);
    }

    public WebElement getDoorLabel() {
        return findWebElement(doorLabel);
    }

    public WebElement getDoorInput() {
        return findWebElement(doorInput);
    }

    public WebElement getTrailerLabel() {
        return findWebElement(trailerLabel);
    }

    public WebElement getTrailerInput() {
        return findWebElement(trailerInput);
    }

    public WebElement getLoadTypeLabel() {
        return findWebElement(loadTypeLabel);
    }

    public WebElement getLoadTypeInput() {
        return findWebElement(loadTypeInput);
    }

    public WebElement getScheduledTimeLabel() {
        return findWebElement(scheduledTimeLabel);
    }

    public WebElement getScheduledTimeInput() {
        return findWebElement(scheduledTimeInput);
    }

    public WebElement getDriverLabel() {
        return findWebElement(driverLabel);
    }

    public WebElement getDriverInput() {
        return findWebElement(driverInput);
    }

    public WebElement getTemperatureField() {
        return findWebElement(temperatureField);
    }

    public WebElement getSourceOrderType() {
        return findWebElement(sourceOrderTypeColumn);
    }

    public WebElement getSourceOrder() {
        return findWebElement(sourceOrderColumn);
    }

    public WebElement getSourceStatus() {
        return findWebElement(sourceStatusColumn);
    }

    public WebElement getReadyToReceiveStatus() { return findWebElement(readyToReceiveStatus); }

    public WebElement getCancelInboundStatus() {
        return findWebElement(cancelInboundStatus);
    }

    public WebElement getReopenOrderStatus() {
        return findWebElement(reopenOrderStatus);
    }

    public WebElement getFinishReceivingOrderStatus() {
        return findWebElement(finishReceivingOrderStatus);
    }

    public WebElement getLoadField() {
        return findWebElement(loadField);
    }

    public WebElement getLoadNumber() {
        return findWebElement(loadNumber);
    }

    public WebElement getDoorField() {
        return findWebElement(doorField);
    }

    public WebElement getQaField() {
        return findWebElement(qaField);
    }

    public WebElement getTrailerField() {
        return findWebElement(trailerField);
    }

    public WebElement getCarrierField() {
        return findWebElement(carrierField);
    }

    public WebElement getOrdersField() {
        return findWebElement(ordersField);
    }

    public WebElement getQtyField() {
        return findWebElement(qtyField);
    }

    public WebElement getCubeField() {
        return findWebElement(cubeField);
    }

    public WebElement getWeightField() {
        return findWebElement(weightField);
    }

    public WebElement getImagesButton() { return findWebElement(imagesButton); }

    public WebElement getCommentsButton() { return findWebElement(commentsButton); }

    public WebElement getReceivedQty() {
        return findWebElement(receivedQty);
    }

    public WebElement getStagedQty() {
        return findWebElement(stagedQty);
    }

    public WebElement getRedQty() {
        return findWebElement(redQty);
    }

    public WebElement getGrayQty() {
        return findWebElement(grayQty);
    }

    public List<WebElement> getLoadOrders() {
        return findWebElements(loadOrders);
    }

    public WebElement getDialogTextContent() {
        return findWebElement(dialogTextContent);
    }

    public WebElement getOrderedLabel() {
        return findWebElement(orderedLabel);
    }

    public WebElement getStagedLabel() {
        return findWebElement(stagedLabel);
    }

    public WebElement getReceivedLabel() {
        return findWebElement(receivedLabel);
    }

    public WebElement getReviewLoadLabel() {
        return findWebElement(reviewLoadLabel);
    }

    public WebElement getProductColumn() {
        return findWebElement(productColumn);
    }

    public WebElement getDescriptionColumn() {
        return findWebElement(descriptionColumn);
    }

    public WebElement getQualifier1Column() {
        return findWebElement(qualifier1Column);
    }

    public WebElement getOrderedColumn() {
        return findWebElement(orderedColumn);
    }

    public WebElement getStagedColumn() {
        return findWebElement(stagedColumn);
    }

    public WebElement getReceivedColumn() {
        return findWebElement(receivedColumn);
    }

    public WebElement getStatusColumn() {
        return findWebElement(statusColumn);
    }

    public WebElement getLotColumn() {
        return findWebElement(lotColumn);
    }

    public WebElement getExpDateColumn() {
        return findWebElement(expDateColumn);
    }

    public WebElement getDateCodeColumn() {
        return findWebElement(dateCodeColumn);
    }

    public WebElement getWeightColumn() {
        return findWebElement(weightColumn);
    }

    public WebElement getCancelBtn() { return findWebElement(cancelBtn); }

    public WebElement getSaveBtn() { return findWebElement(saveBtn); }

    public By getSearchInput() {
        return By.id("button_212"); // Use the actual id of the button you want to interact with
    }


    public WebElement getSelectFilesBtn() { return findWebElement(selectFilesBtn); }

    public WebElement getLoadImageLabel() { return findWebElement(loadImageLabel); }

    public WebElement getSaveEditButton() { return findWebElement(saveEditButton); }

    public WebElement getInboundImageCaptureButton() { return findWebElement(inboundImageCaptureButton); }

    public List<WebElement> getlayoutexpand() { return findWebElements(layoutexpand); }

    public WebElement getlayoutcollapse() { return findWebElement(layoutcollapse); }

    public void typeFutureDateLoadEnd(int days) {
        // Wait for the page to load completely and the necessary elements to be available
        Waiters.waitTillLoadingPage(getDriver());

        // Re-locate the element just before interacting with it
        WebElement dateRouteEndElement = findWebElement(dateRouteEnd);

        // Interact with the element
        try {
            // Double click, delete previous value and type new value
            doubleClick(dateRouteEndElement);
            pressDelete(dateRouteEndElement);

            // Calculate future date and input the value
            String futureDate = TimeConversion.futureDate(days, Calendar.DATE, TimeConversion.getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy);
            inputText(dateRouteEndElement, futureDate);
            pressEnter(dateRouteEndElement);
        } catch (StaleElementReferenceException e) {
            // If the element is stale, re-fetch and interact again
            dateRouteEndElement = findWebElement(dateRouteEnd);
            doubleClick(dateRouteEndElement);
            pressDelete(dateRouteEndElement);

            String futureDate = TimeConversion.futureDate(days, Calendar.DATE, TimeConversion.getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy);
            inputText(dateRouteEndElement, futureDate);
            pressEnter(dateRouteEndElement);
        }

        // Wait for the page to finish processing after the interaction
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void cleanLoad() {
        try {
            // Wait for table content visibility with increased timeout
            Waiters.waitForElementToBeDisplay(tableContent, 90);

            // Check if the table is visible before proceeding
            if (isElementVisible(tableContent)) {
                doubleClick(getEnterLoadInput());
                pressDelete(getEnterLoadInput());
                pressEnter(getEnterLoadInput());
            } else {
                System.out.println("Table is not visible!");
            }

        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for table to be visible: " + e.getMessage());
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Element Reference Exception: " + e.getMessage());
            // Retry logic
            Waiters.waitForElementToBeDisplay(tableContent, 90);
            if (isElementVisible(tableContent)) {
                doubleClick(getEnterLoadInput());
                pressDelete(getEnterLoadInput());
                pressEnter(getEnterLoadInput());
            }
        }

        // Wait for the loader to disappear
        waitUntilInvisible(2, loader);
    }

    public void clickOrderStatus(String... statuses) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Open dropdown
            WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".k-multiselect .k-input-inner")));
            inputBox.click();
            Waiters.waitTillLoadingPage(driver);
            Waiters.waitABit(500);

            // Step 2: Deselect all current selections
            List<WebElement> selected = driver.findElements(By.cssSelector("li.k-selected input[type='checkbox']:checked"));
            for (WebElement checkbox : selected) {
                if (checkbox.isDisplayed()) {
                    checkbox.click();
                    Waiters.waitABit(300);
                }
            }

            // Step 3: Select requested statuses
            for (String status : statuses) {
                String normalized = status.equalsIgnoreCase("All statuses") ? "All" : status;

                List<WebElement> labels = driver.findElements(By.xpath("//li[@role='option']//label[normalize-space()]"));
                boolean found = false;

                for (WebElement label : labels) {
                    if (label.getText().trim().equalsIgnoreCase(normalized)) {
                        WebElement checkbox = label.findElement(By.xpath(".//preceding-sibling::input[@type='checkbox']"));
                        checkbox.click();
                        Waiters.waitABit(300);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    throw new RuntimeException("Status '" + status + "' not found.");
                }
            }

            // Step 4: Close dropdown
            inputBox.sendKeys(Keys.TAB);
            Waiters.waitTillLoadingPage(driver);

        } catch (Exception e) {
            throw new RuntimeException("Failed in clickOrderStatus: " + e.getMessage());
        }
    }

    public void selectOrderStatus(String status) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String normalizedStatus = status.equalsIgnoreCase("All statuses") ? "All" : status;

        for (int attempt = 1; attempt <= 3; attempt++) {
            try {
                // Step 1: Open dropdown
                WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".k-multiselect .k-input-inner")
                ));
                inputBox.click();
                Waiters.waitTillLoadingPage(driver);
                Waiters.waitABit(500);

                // Step 2: Deselect any selected options
                List<WebElement> checkedBoxes = driver.findElements(
                        By.cssSelector("li.k-selected input[type='checkbox']:checked")
                );
                for (WebElement checkbox : checkedBoxes) {
                    try {
                        if (checkbox.isDisplayed()) {
                            checkbox.click();
                            Waiters.waitABit(300);
                        }
                    } catch (Exception ignored) {
                    }
                }

                // Step 3: Find matching label and click checkbox next to it
                List<WebElement> labels = driver.findElements(
                        By.xpath("//li[@role='option']//label[normalize-space()]")
                );

                boolean matched = false;
                for (WebElement label : labels) {
                    String labelText = label.getText().trim().toLowerCase();
                    if (labelText.equals(normalizedStatus.toLowerCase())) {
                        WebElement checkbox = label.findElement(By.xpath(".//preceding-sibling::input[@type='checkbox']"));
                        checkbox.click();
                        matched = true;
                        break;
                    }
                }

                if (!matched) {
                    throw new TimeoutException("Status '" + normalizedStatus + "' not found.");
                }

                inputBox.sendKeys(Keys.TAB);
                Waiters.waitTillLoadingPage(driver);
                return;

            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element on attempt " + attempt + ", retrying...");
            } catch (TimeoutException e) {
                System.out.println("Timeout: Could not find status '" + status + "' on attempt " + attempt);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        throw new RuntimeException("Failed to select status: " + status + " after 3 attempts.");
    }

    public void clickCarrierDropdown(String carrier) {
        Waiters.waitTillLoadingPage(getDriver());

        // Locate the dropdown based on the visible selected value
        String xpath = "//span[contains(@class, 'k-input-value-text') and normalize-space(text())='" + carrier + "']/ancestor::span[contains(@class, 'k-dropdownlist')]";

        WebElement dropdown = findWebElement(By.xpath(xpath));
        clickOnElement(dropdown);

        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeValueInSearch(String productCode) {
        WebDriver driverInstance = getDriver();  // Ensure proper WebDriver initialization
        WebDriverWait wait = new WebDriverWait(driverInstance, Duration.ofSeconds(60)); // Use explicit wait for up to 60 seconds

        try {
            // Wait for the product input field to be clickable
            WebElement searchInputElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.k-input-inner[placeholder='Enter a product']")));

            if (searchInputElement != null) {
                // Debugging: Log to verify the element is found
                System.out.println("Element found, typing value: " + productCode);

                // Click on the input field to ensure it's focused
                searchInputElement.click();

                // Clear any existing text in the input field
                searchInputElement.clear();

                // Type the new product code into the input field
                searchInputElement.sendKeys(productCode);

                // Optionally, press Enter if necessary
                searchInputElement.sendKeys(Keys.ENTER);

                // Wait until the page is done processing (if needed)
                Waiters.waitTillLoadingPage(driverInstance);
            } else {
                // Debugging: Log an error if the element is not found
                System.out.println("Element not found.");
            }
        } catch (StaleElementReferenceException e) {
            // Handle the case where the element became stale and retry
            System.out.println("Stale element detected, retrying...");
            typeValueInSearch(productCode);  // Retry logic
        } catch (TimeoutException e) {
            // Handle the timeout exception if the element is not found within the wait time
            System.out.println("Timeout waiting for the element: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions and log the error message
            System.out.println("Error during typing product code: " + e.getMessage());
        }
    }




    public void clickClearButton() {
        // Look for the clear button using its class name
        WebElement clearButton = findWebElement(By.className("k-clear-value"));
        if (clearButton != null && clearButton.isDisplayed()) {
            clickOnElement(clearButton);  // Click on the clear button
        } else {
            System.out.println("Clear button is not visible or found.");
        }
    }



    public void typeProduct(String productCode) {
        WebElement productInputField = findWebElement(enterProductInput);

        // Wait for the element to be displayed and enabled
        Waiters.waitForElementToBeDisplay(productInputField);

        // Click on the input field to ensure it is focused
        productInputField.click();

        // Explicitly clear the field by selecting all text and deleting it
        productInputField.sendKeys(Keys.CONTROL + "a"); // Select all text
        productInputField.sendKeys(Keys.DELETE); // Delete selected text

        // Ensure the field is cleared, and enter the new product code
        inputText(productInputField, productCode);

        // Optionally press Enter after typing the product code if required
        pressEnter(productInputField);

        // Wait for the page or action to load after entering the product code
        Waiters.waitTillLoadingPage(getDriver());
    }


    public void cleanSearchInput() {
        // Wait for the page to load and the search input field to be displayed
        Waiters.waitTillLoadingPage(getDriver());

        // Get the search input element using XPath
        WebElement searchInputElement = findWebElement(By.xpath("(//span[@title='clear'])[2]")); // Replace with correct XPath
        Waiters.waitForElementToBeDisplay(searchInputElement);  // Wait until it's visible

        // Explicitly clear the input field by selecting all text and sending the delete key
        searchInputElement.click();
        searchInputElement.sendKeys(Keys.CONTROL + "a"); // Select all text
        searchInputElement.sendKeys(Keys.DELETE); // Delete the selected text

        // Ensure the input field is completely cleared
        if (!searchInputElement.getAttribute("value").isEmpty()) {
            searchInputElement.clear(); // Clear the field if there is any value left
        }

        // Wait for the second clear button to be visible in the DOM
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Adjust timeout if necessary
        try {
            // Wait for the second clear button to be present and visible
            WebElement clearButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='clear'])[2]")));

            if (clearButton.isDisplayed() && clearButton.isEnabled()) {
                clearButton.click();  // Click the clear button
            } else {
                System.out.println("Clear button is not visible or enabled.");
            }
        } catch (TimeoutException e) {
            System.out.println("Clear button not found within the timeout period: " + e.getMessage());
        }

        // Wait for any loader to disappear (optional)
        waitUntilInvisible(2, loader);
    }

    public void selectLoadByLoadNumber(int orderNum) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                List<WebElement> orders = findWebElements(By.xpath("//tr[contains(@class, 'k-detail-row')]//td[contains(@class, 'k-detail-cell')]"));
                WebElement order = orders.get(orderNum);
                clickOnElement(order);
                Waiters.waitTillLoadingPage(getDriver());
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Attempt " + (attempt + 1) + ": Stale Element Reference Exception, retrying...");
                Waiters.waitABit(1000); // Wait before retrying
            }
        }
    }



    // Helper method to wait until the element is clickable
    public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }





    public void typeProductByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver()); // Wait for the page to load
        WebElement productInputField = getEnterProductInput(); // Find the product input field

        // Locate and select the product from the list by index
        List<WebElement> productCodes = getTableContent().findElements(By.xpath("//someXPathToGetProductCodes"));
        if (productCodes.size() > index) {
            String productCode = productCodes.get(index).getText();
            inputText(productInputField, productCode);  // Type the product code in the input field
            pressEnter(productInputField);  // Press Enter after typing
        }
    }
    public void clearProduct() {
        // Wait for the element to be visible
        WebElement productInputField = findWebElement(enterProductInput);  // Adjust the locator as needed

        // Ensure the element is present before interacting with it
        if (productInputField != null) {
            Waiters.waitForElementToBeDisplay(productInputField);  // Wait for the element to be visible
            clear(productInputField);  // Clear the input field
        } else {
            throw new NoSuchElementException("Product input field not found");
        }
    }




    public void typeSpecificProduct(String productCode) {
        Waiters.waitTillLoadingPage(getDriver());
        WebElement productInputField = getEnterProductInput();  // Find the product input field

        // Type the specific product code and press Enter
        inputText(productInputField, productCode);
        pressEnter(productInputField);  // Press Enter after typing the product code
    }
    public void validateItemsFoundNotDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        WebElement itemsFoundLabel = getItemsFoundLabel();

        // Check if the "Items found" label is displayed or contains any value
        boolean isItemsFoundDisplayed = isElementDisplay(itemsFoundLabel);
        if (isItemsFoundDisplayed) {
            String itemsFoundText = getText(itemsFoundLabel);
            assertTrue("Items found are displayed: " + itemsFoundText, false);  // Fail if the label is visible
        }
    }



}

