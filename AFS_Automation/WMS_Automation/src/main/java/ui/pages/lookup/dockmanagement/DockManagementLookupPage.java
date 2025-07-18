package ui.pages.lookup.dockmanagement;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static common.setup.DriverManager.getDriver;

public class DockManagementLookupPage extends BasePage {
    By dockManagementLookupTitle = By.className("spnmoduleNameHeader");
    By dateInputFilterDate = By.id("dateInputFilterDate");
    By dateInputFilterToDate = By.id("dateInputFilterToDate");
    By chkBoxShowAll = By.id("chkBoxShowAll");
    By chkBoxReceiving = By.id("chkBoxReceiving");
    By chkBoxShipping = By.id("chkBoxShipping");
    By chkBoxProduction = By.id("chkBoxProduction");
    By completeLabel = By.xpath("//span[contains(@class, 'dot--green')]/following-sibling::span[contains(text(), 'Complete')]");
    By inProgressLabel = By.xpath("//span[contains(@class, 'dot--yellow')]/following-sibling::span[contains(text(), 'In progress')]");
    By lateLabel = By.xpath("//span[contains(@class, 'dot--red')]/following-sibling::span[contains(text(), 'Late')]");
    By orderLabel = By.xpath("//span[@class='HeaderWithImage' and text()='Order']");
    By trailerLabel = By.xpath("//span[@class='HeaderWithImage' and text()='Trailer']");
    By scheduledLabel = By.xpath("//span[@class='HeaderWithImage' and text()='Scheduled']");
    By d1Label = By.xpath("//span[text()='D1']");
    By d2Label = By.xpath("//span[text()='D2']");
    By doorLabel = By.xpath("//span[text()='DOOR']");
    By door01Label = By.xpath("//span[text()='DOOR01']");
    By door02Label = By.xpath("//span[text()='DOOR02']");
    By door03Label = By.xpath("//span[text()='DOOR03']");
    By door04Label = By.xpath("//span[text()='DOOR04']");
    By door05Label = By.xpath("//span[text()='DOOR05']");
    By goldLabel = By.xpath("//span[text()='GOLD']");
    By productionLabel = By.xpath("//span[text()='PRODUCTION']");
    By td01Label = By.xpath("//span[text()='TD01']");
    By td02Label = By.xpath("//span[text()='TD02']");
    By outboundLabel = By.xpath("//span[text()='OUTBOUND']");
    By inboundLabel = By.xpath("//span[text()='INBOUND']");
    By items = By.xpath("//a[contains(text(), '+')]");
    By dockMgmtSummaryRows = By.xpath("//div[contains(@class,'DockManagementSummaryTableBody')]//div[contains(@class,'dockManagement_Col')]/ancestor::div[contains(@class,'DockManagementSummaryTableBody')]/div");
    By btnBack = By.id("btnBack");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By okButton = By.xpath("//button[contains(text(), 'OK')]");
    By ordersAssignToDoor = By.xpath("//span[text()='Orders assigned to door']");
    By notEmptyTrailer = By.xpath("//div[contains(@class, 'dockManagement_Col_')]//*[contains(@class, 'truckIcon')]");
    By notEmptyScheduled = By.xpath("//div[contains(@class, 'dockManagement_Col_')]//*[contains(@class, 'clockIcon')]//following-sibling::a");
    By changeTrailerPopUpTitle = By.cssSelector("div.k-dialog-title");
    By dateInputSchedDateLabel = By.id("dateInputSchedDate-label");
    By dateInputSchedDate = By.id("dateInputSchedDate");
    By timeInputFilterTimeLabel = By.id("timeInputFilterTime-label");
    By timeInputFilterTime = By.id("timeInputFilterTime");
    By ddlTrailer = By.id("ddlTrailer");
    By dropdownList = By.id("dropdownList");
    By loader = By.cssSelector(".loader");

    public void waitForDockManagementLookupPageToLoad() {
        waitUntilInvisible(5, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(dockManagementLookupTitle);
        Waiters.waitForElementToBeDisplay(dateInputFilterDate);
        Waiters.waitForElementToBeDisplay(dateInputFilterToDate);
        Waiters.waitForElementToBeDisplay(chkBoxShowAll);
        Waiters.waitForElementToBeDisplay(chkBoxReceiving);
        Waiters.waitForElementToBeDisplay(chkBoxShipping);
        Waiters.waitForElementToBeDisplay(chkBoxProduction);
    }

   /* public void clickItemByIndex(int index) {
        waitUntilInvisible(2, loader);
        Waiters.waitForElementToBeDisplay(items);
        clickOnElement(getItems().get(index));
        waitUntilInvisible(5, loader);
    }*/

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitTillLoadingPage(getDriver());
    }

  /*  public void clickDockMgmtSummaryRowsByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilVisible(1, loader);
        Waiters.waitForElementToBeDisplay(dockMgmtSummaryRows);
        clickOnElement(getDockMgmtSummaryRows().get(index).findElement(By.xpath(".//div[contains(@class, 'outerDuckCell')]//a")));
        waitUntilVisible(3, loader);
    }*/

    public void clickNotEmptyTrailerByIndex(int index) {
        waitUntilVisible(10, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(5000);
        Waiters.waitForElementsToBeDisplay(getNotEmptyTrailers());
        WebElement trailer = getNotEmptyTrailers().get(index);
        waitUntilStalenessOf(2, trailer);
        Waiters.waitABit(5000);
        clickOnElement(trailer);
    }

    public void clickNotEmptyScheduledByIndex(int index) {
        waitUntilVisible(1, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(notEmptyScheduled);
        clickOnElement(getNotEmptyScheduled().get(index));
    }

    public void clickBackButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(btnBack);
        clickOnElement(btnBack);
        Waiters.waitABit(7000);
    }

    public void clickCancelButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(cancelButton);
        clickOnElement(cancelButton);
        Waiters.waitABit(7000);
    }

    public void clickOKButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(okButton);
        clickOnElement(okButton);
        Waiters.waitABit(7000);
    }

    public void typeSchedDate(String date) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDateInputSchedDate());
        clickOnElement(getDateInputSchedDate());
        pressDelete(getDateInputSchedDate());
        inputText(getDateInputSchedDate(), date);
        pressEnter(getDateInputSchedDate());
        Waiters.waitABit(7000);
    }

    public void selectDDlTrailer(CharSequence trailer) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDDlTrailer());
        clickOnElement(getDDlTrailer());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + trailer + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public boolean isDateInputFilterDisplayed() { return isElementDisplay(dateInputFilterDate); }

    public boolean isDateToInputFilterDisplayed() { return isElementDisplay(dateInputFilterToDate); }

    public boolean isChkBoxShowAllDisplayed() { return isElementDisplay(chkBoxShowAll); }

    public boolean isChkBoxReceivingDisplayed() { return isElementDisplay(chkBoxReceiving); }

    public boolean isChkBoxShippingDisplayed() { return isElementDisplay(chkBoxShipping); }

    public boolean isChkBoxProductionDisplayed() { return isElementDisplay(chkBoxProduction); }

    public boolean isCompleteLabelDisplayed() { return isElementDisplay(completeLabel); }

    public boolean isInProgressLabelDisplayed() { return isElementDisplay(inProgressLabel); }

    public boolean isLateLabelDisplayed() { return isElementDisplay(lateLabel);}

    public boolean isOrderLabelDisplayed() { return isElementDisplay(orderLabel); }

    public boolean isTrailerLabelDisplayed() { return isElementDisplay(trailerLabel); }

    public boolean isScheduledLabelDisplayed() { return isElementDisplay(scheduledLabel);}

    public boolean isD1LabelDisplayed() { return isElementDisplay(d1Label); }

    public boolean isD2LabelDisplayed() { return isElementDisplay(d2Label); }

    public boolean isDoorLabelDisplayed() { return isElementDisplay(doorLabel); }

    public boolean isDoor01LabelDisplayed() { return isElementDisplay(door01Label); }

    public boolean isDoor02LabelDisplayed() { return isElementDisplay(door02Label); }

    public boolean isDoor03LabelDisplayed() { return isElementDisplay(door03Label); }

    public boolean isDoor04LabelDisplayed() { return isElementDisplay(door04Label); }

    public boolean isDoor05LabelDisplayed() { return isElementDisplay(door05Label); }

    public boolean isGoldLabelDisplayed() { return isElementDisplay(goldLabel); }

    public boolean isProductionLabelDisplayed() { return isElementDisplay(productionLabel); }

    public boolean isTd01LabelDisplayed() { return isElementDisplay(td01Label); }

    public boolean isTd02LabelDisplayed() { return isElementDisplay(td02Label); }

    public int areOutboundLabelsPresent() { return elementsArePresent(getOutboundLabels()); }

    public int areInboundLabelsPresent() { return elementsArePresent(getInboundLabels()); }

    public int areItemsPresent() { return elementsArePresent(getItems()); }

    public int areDockMgmtSummaryRowsPresent() { return elementsArePresent(getDockMgmtSummaryRows()); }

   /* public boolean isButtonBackDisplayed() { return isElementDisplay(btnBack); }*/

    /*public boolean isOrdersAssignToDoorLabelDisplayed() { return isElementDisplay(ordersAssignToDoor); }*/

    public boolean isСhangeTrailerPopUpTitleDisplayed() { return isElementDisplay(getСhangeTrailerPopUpTitle()); }

    public boolean isDateInputSchedDateLabelDisplayed() { return isElementDisplay(getDateInputSchedDateLabel()); }

    public boolean isInputSchedDateDisplayed() { return isElementDisplay(getDateInputSchedDate()); }

    public boolean isInputFilterTimeLabelDisplayed() { return isElementDisplay(getTimeInputFilterTimeLabel()); }

    public boolean isInputFilterTimeDisplayed() { return isElementDisplay(getTimeInputFilterTime()); }

    public String isReceivingChkDisabled() { return getElementAttribute(getChkBoxReceiving(), "disabled"); }

    public String checkElementReceivingChk() { return checkElementAttribute(getChkBoxReceiving(), "disabled"); }

    public String isShippingChkDisabled() { return getElementAttribute(getChkBoxShipping(), "disabled"); }

    public String checkElementShippingChk() { return checkElementAttribute(getChkBoxShipping(), "disabled"); }

    public String isProductionChkDisabled() { return getElementAttribute(getChkBoxProduction(), "disabled"); }

    public String checkElementProductionChk() { return checkElementAttribute(getChkBoxProduction(), "disabled"); }

    public void typeDockMgmtStartDate(String date) {
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilStalenessOf(1, getDateInputFilterDate());
        clickOnElement(getDateInputFilterDate());
        Waiters.waitABit(1000);
        waitUntilStalenessOf(1, getDateInputFilterDate());
        clearText(getDateInputFilterDate());
        Waiters.waitABit(1000);
        waitUntilStalenessOf(1, getDateInputFilterDate());
        inputText(getDateInputFilterDate(), date);
        Waiters.waitABit(1000);
        waitUntilStalenessOf(1, getDateInputFilterDate());
        pressTab(getDateInputFilterDate());
        waitUntilInvisible(10, loader);
    }

    public void typeDockMgmtToDate(String date) {
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilStalenessOf(1, getDateInputFilterToDate());
        clickOnElement(getDateInputFilterToDate());
        Waiters.waitABit(1000);
        waitUntilStalenessOf(1, getDateInputFilterToDate());
        clearText(getDateInputFilterToDate());
        Waiters.waitABit(1000);
        waitUntilStalenessOf(1, getDateInputFilterToDate());
        inputText(getDateInputFilterToDate(), date);
        Waiters.waitABit(1000);
        waitUntilStalenessOf(1, getDateInputFilterToDate());
        pressTab(getDateInputFilterToDate());
        waitUntilInvisible(2, loader);
    }

    public void clickSelectAll() {
        waitUntilInvisible(2, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(chkBoxShowAll);
        Waiters.waitABit(1000);
        jsClick(getChkBoxShowAll());
        waitUntilInvisible(2, loader);
    }

    public void clickReceiving() {
        waitUntilInvisible(2, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(chkBoxReceiving);
        Waiters.waitABit(1000);
        jsClick(getChkBoxReceiving());
        waitUntilInvisible(2, loader);
    }

    public void clickShipping() {
        waitUntilInvisible(2, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(chkBoxShipping);
        Waiters.waitABit(1000);
        jsClick(getChkBoxShipping());
        waitUntilInvisible(2, loader);
    }

    public void clickProduction() {
        waitUntilInvisible(2, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(chkBoxProduction);
        Waiters.waitABit(1000);
        jsClick(getChkBoxProduction());
        waitUntilInvisible(2, loader);
    }

    public String getСhangeTrailerPopUpTitleText() {
        Waiters.waitTillLoadingPage(getDriver());
        return getText(changeTrailerPopUpTitle);
    }

    public WebElement getDockManagementLookupTitle() { return findWebElement(dockManagementLookupTitle); }

    public WebElement getDateInputFilterDate() { return findWebElement(dateInputFilterDate); }

    public WebElement getDateInputFilterToDate() { return findWebElement(dateInputFilterToDate); }

    public WebElement getChkBoxShowAll() { return findWebElement(chkBoxShowAll); }

    public WebElement getChkBoxReceiving() { return findWebElement(chkBoxReceiving); }

    public WebElement getChkBoxShipping() { return findWebElement(chkBoxShipping); }

    public WebElement getChkBoxProduction() { return findWebElement(chkBoxProduction); }

    public WebElement getCompleteLabel() { return findWebElement(completeLabel); }

    public WebElement getInProgressLabel() { return findWebElement(inProgressLabel); }

    public WebElement getLateLabel() { return findWebElement(lateLabel); }

    public WebElement getOrderLabel() { return findWebElement(orderLabel); }

    public WebElement getTrailerLabel() { return findWebElement(trailerLabel); }

    public WebElement getScheduledLabel() { return findWebElement(scheduledLabel); }

    public WebElement getD1Label() { return findWebElement(d1Label); }

    public WebElement getD2Label() { return findWebElement(d2Label); }

    public WebElement getDoorLabel() { return findWebElement(doorLabel); }

    public WebElement getDoor01Label() { return findWebElement(door01Label); }

    public WebElement getDoor02Label() { return findWebElement(door02Label); }

    public WebElement getDoor03Label() { return findWebElement(door03Label); }

    public WebElement getDoor04Label() { return findWebElement(door04Label); }

    public WebElement getDoor05Label() { return findWebElement(door05Label); }

    public WebElement getGoldLabel() { return findWebElement(goldLabel); }

    public WebElement getProductionLabel() { return findWebElement(productionLabel); }

    public WebElement getTd01Label() { return findWebElement(td01Label); }

    public WebElement getTd02Label() { return findWebElement(td02Label); }

    public List<WebElement> getOutboundLabels() { return findWebElements(outboundLabel); }

    public List<WebElement> getInboundLabels() { return findWebElements(inboundLabel); }

    public List<WebElement> getItems() { return findWebElements(items); }

   /* public List<WebElement> getDockMgmtSummaryRows() { return findWebElements(dockMgmtSummaryRows); }*/
   public List<WebElement> getDockMgmtSummaryRows() {
       By rowLocator = By.xpath("//div[contains(@class,'dockManagement_Col_2B')]");

       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
           wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rowLocator));

           List<WebElement> rows = driver.findElements(rowLocator);
           System.out.println(" Found " + rows.size() + " Dock Mgmt summary rows.");
           return rows;
       } catch (TimeoutException e) {
           System.out.println(" Timeout: Could not locate Dock Mgmt rows.");
           System.out.println(" Current Page Title: " + driver.getTitle());
           System.out.println(" URL: " + driver.getCurrentUrl());
           System.out.println(" DOM Preview: " + driver.getPageSource().substring(0, 1000));  // preview first 1000 chars
           throw e;
       }
   }

    public void clickDockMgmtSummaryRowsByIndex(int index) {
        Waiters.waitForPageToStabilize(driver); // FIXED

        List<WebElement> rows = getDockMgmtSummaryRows(); // Re-fetch after stabilization
        if (rows.size() <= index) {
            throw new RuntimeException("Index " + index + " is out of bounds. Only " + rows.size() + " rows found.");
        }

        rows.get(index).click();
    }


    public void clickItemByIndex(int index) {
        Waiters.waitForLoaderToDisappear(driver); // Add this line

        List<WebElement> items = getDockMgmtSummaryRows(); // however you fetch them
        if (index >= items.size()) {
            throw new RuntimeException("Index out of range");
        }

        items.get(index).click();
    }

    public boolean isOrdersAssignToDoorLabelDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(text(),'Orders assigned to door')]")
            ));
            return el.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


    public boolean isButtonBackDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnBack")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }













    public WebElement getBtnBack() { return findWebElement(btnBack); }

    public List<WebElement> getNotEmptyTrailers() { return findWebElements(notEmptyTrailer); }

    public List<WebElement> getNotEmptyScheduled() { return findWebElements(notEmptyScheduled); }

    public WebElement getСhangeTrailerPopUpTitle() { return findWebElement(changeTrailerPopUpTitle); }

    public WebElement getDateInputSchedDateLabel() { return findWebElement(dateInputSchedDateLabel); }

    public WebElement getDateInputSchedDate() { return findWebElement(dateInputSchedDate); }

    public WebElement getTimeInputFilterTimeLabel() { return findWebElement(timeInputFilterTimeLabel); }

    public WebElement getTimeInputFilterTime() { return findWebElement(timeInputFilterTime); }

    public WebElement getDDlTrailer() { return findWebElement(ddlTrailer); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
