package ui.pages.outbound.loadplanning;

import common.utils.Waiters;
import common.utils.WebDriverUtils;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.BasePage;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

import common.setup.DriverManager;

public class OutboundTruckInfoPage extends BasePage {
    public OutboundTruckInfoPage() {
        this.driver = DriverManager.getDriver();  // or whatever method returns your active WebDriver
    }

    WebDriver driver;
    Scenario scenario;


    static boolean exists=false;
    static String currentURL=null;


    By truckInfoTitle = By.cssSelector(".i-card__card__title-area__title");
    By exitButton = By.xpath("//span[contains(text(), 'Exit')]/parent::button");
    By exitIcon = By.xpath("//button[.//*[text()='Exit']]//*[contains(@class, 'icon')]");
    By workButton = By.xpath("//span[contains(text(), 'Work')]/parent::button");
    By editButton = By.xpath("//span[contains(text(), 'Edit')]");
    By reprocessButton = By.xpath("//span[contains(text(), 'Reprocess')]");
    By recalculateButton = By.xpath("//span[contains(text(), 'Recalculate')]/parent::button");
    By keyButton = By.xpath("//span[contains(text(), 'Key')]/parent::button");
    By routeLabel = By.xpath("//span[text()='Route']");
    By routeValue = By.xpath("//span[text()='Route']//following-sibling::span[@class='i-summary-area__other__value']");
    By shipDateInput = By.id("dateInputA");
    By shipTimeInput = By.id("timeInput1");
    By trailerDropDown = By.id("ddTrailer");
    By doorDropDown = By.id("ddDoor");
    By inboundLink = By.xpath("//a[contains(text(), 'Inbound')]");
    By shortsLink = By.xpath("//a[contains(text(), 'Shorts')]");
    By typeLabel = By.xpath("//span[contains(text(), 'Type')]");
    By typeValue = By.xpath("//span[contains(text(), 'Type')]//following-sibling::span[@class='i-summary-area__other__value']");
    By positionsLabel = By.xpath("//span[contains(text(), 'Positions')]");
    By positionsValue = By.xpath("//span[contains(text(), 'Positions')]//following-sibling::span[@class='i-summary-area__other__value']");
    By palletsLabel = By.xpath("//span[contains(text(), 'Pallets')]");
    By palletsValue = By.xpath("//span[contains(text(), 'Pallets')]//following-sibling::span[@class='i-summary-area__other__value']");
    By trailerCubeLabel = By.xpath("//span[contains(text(), 'Trailer cube')]");
    By trailerCubeValue = By.xpath("//span[contains(text(), 'Trailer cube')]//following-sibling::span[@class='i-summary-area__other__value']");
    By routeCubeLabel = By.xpath("//span[contains(text(), 'Route cube')]");
    By routeCubeValue = By.xpath("//span[contains(text(), 'Route cube')]//following-sibling::span[@class='i-summary-area__other__value']");
    By trailerWeightLabel = By.xpath("//span[contains(text(), 'Trailer weight')]");
    By trailerWeightValue = By.xpath("//span[contains(text(), 'Trailer weight')]//following-sibling::span[@class='i-summary-area__other__value']");
    By routeWeightLabel = By.xpath("//span[contains(text(), 'Route weight')]");
    By routeWeightValue = By.xpath("//span[contains(text(), 'Route weight')]//following-sibling::span[@class='i-summary-area__other__value']");
    By truckDiagramLabel = By.xpath("//div[contains(text(), 'Truck diagram')]");
    By rightSideWeight = By.xpath("//div[@class='lp_pallet_container'][.//div[contains(text(), 'Right side')]]//span[contains(text(), 'Weight')]");
    By leftSideWeight = By.xpath("//div[@class='lp_pallet_container'][.//div[contains(text(), 'Left side')]]//span[contains(text(), 'Weight')]");
    By truckInfoArrow = By.xpath("//span[contains(@class, 'k-i-arrow-chevron')]");
    By loadPlanningScroll = By.className("loadPlanningScroll");
    By dialogContent = By.id("dialogTextContent");
    By yesButton = By.id("btnWarnYes");
    By noButton = By.id("btnWarnNo");
    By windowTitle = By.className("k-window-title");
    By warningMessage = By.className("k-window-content");
    By yesBtn = By.xpath("//span[contains(text(), 'Yes')]/parent::button");
    By noBtn = By.xpath("//span[contains(text(), 'No')]/parent::button");
    By okBtn = By.xpath("//span[contains(text(), 'Ok')]");
    By assignments = By.cssSelector(".lp_FullPalletWithDragSourceWrap");
    By editFormControl = By.xpath("//label[contains(@id, 'formControl')]");
    By editFormControlInput = By.xpath("//input[contains(@id, 'formControl')]");
    By cancelBtn = By.id("btnDialogCancel");
    By saveBtn = By.id("btnDialogSave");
    By saveButton = By.xpath("//span[contains(text(), 'Save')]/parent::button");
    By notificationMsg = By.cssSelector(".toast-message");
    By palletHead = By.className("staticPalletPHead");
    By palletContentTop = By.className("staticPalletContentTop");
    By palletContentBottom = By.className("staticPalletContentBottom");
    By palletKeyTitle = By.xpath("//div[contains(@class, 'staticTopCrossBottom') and text()='Pallet key']");
    By waitingToBePicked = By.xpath("//div[text()=' Waiting to be picked']");
    By waitingToBeLoaded = By.xpath("//div[text()=' Waiting to be loaded']");
    By loaded = By.xpath("//div[text()=' Loaded']");
    By palletDoesNotFit = By.xpath("//div[text()=' Pallet does not fit']");
    By freezerItems = By.xpath("//div[text()=' Freezer Items']");
    By coolerItems = By.xpath("//div//div[text()=' Cooler items']");
    By dryGoods = By.xpath("//div//div[text()=' Dry Goods']");
    By toggleIcon = By.xpath("//span[@aria-label='Toggle Clock']");
    By setButton = By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), 'Set')]");
    By tableGrid = By.className("k-grid-container");
    By assignmentPopupHeader = By.xpath("//div[@class='lp_overlayChildWrap'][.//div[@class='lp_overlayChildheader h5']]");
    By assignmentHeader = By.xpath("//div[contains(@class, 'lp_pallet_header')]//div[contains(@class, 'lp_pallet_no')]");
    By assignmentHeaderContainer = By.xpath("//div[contains(@class, 'lp_pallet_assignment_text')]//div[contains(@class, 'palletHeaderContainer')]");
    By assignmentFooter = By.xpath("//div[contains(@class, 'lp_pallet_header')]//div[contains(@class, 'lp_pallet_no')]");
    By assignmentBorder = By.xpath("//div[contains(@class,'lp_pallet_top_filler') and contains(@style, 'rgb(67, 113, 196)')]");
    By quantity = By.id("wqTextTaskQty");
    By reasonDropdown = By.id("wqListTaskTopOff");
    By increaseValueArrow = By.xpath("//button[@title='Increase value']");
    By decreaseValueArrow = By.xpath("//button[@title='Decrease value']");
    By notification = By.className("i-notification-text");
    By loader = By.cssSelector(".loader");





    public void waitOutboundTruckInfoPageToLoad() {
        waitUntilInvisible(15, loader);
        Waiters.waitABit(5000);
        //Waiters.waitTillLoadingPage(driver);
        Waiters.waitForElementToBeDisplay(getTruckDiagramLabel());
    }

    private WebElement getAvailableAssignment(String positionNum) {
        Waiters.waitTillLoadingPage(driver);
        return findWebElement(By.xpath("//div[contains(@class, 'lp_pallet_body')][.//div[@class='lp_pallet_no']//div[text()='"
                + positionNum + "']]//div[@class='lp_pallet_top_filler']"));
    }
    public boolean isAssignmentBorderBlue() {
        WebElement element = findWebElement(By.xpath("//div[contains(@class,'lp_pallet_top_filler') and contains(@style, 'rgb(67, 113, 196)')]"));
        return element != null && element.isDisplayed();
    }



    private WebElement getFreeAssignmentPlace(String positionNum) {
        Waiters.waitTillLoadingPage(driver);
        return findWebElement(By.xpath("//div[contains(@class, 'palletChildMainDiv')][.//div[contains(@class, 'lp_pallet_no') and text()='"
                + positionNum + "']]"));
    }

    private WebElement getFullAssignmentPlace(String positionNum) {
        Waiters.waitTillLoadingPage(driver);
        return findWebElement(By.xpath("//div[contains(@class, 'lp_pallet_wrap')][.//div[contains(@class, 'lp_pallet_no_center') and text()='"
                + positionNum + "']]"));
    }

    public List<WebElement> getAssignmentPopupRows(int number) {
        Waiters.waitTillLoadingPage(driver);
        Waiters.waitABit(2000);
        String id = getAssignments().get(number).findElement(By.cssSelector(".palletHeaderContainer")).getText().trim()
                .substring(getAssignments().get(number).findElement(By.cssSelector(".palletHeaderContainer"))
                .getText().trim().indexOf(":") + 2);
        return findWebElements(By.xpath("//div[contains(@id, 'TaskListModal_" + id + "')]//div[@class='lpDrRow']"));
    }



    private static List<String> assignmentsNumbersList = null;

    public List<WebElement> getTrailers() {
        Waiters.waitForElementToBeDisplay(getTrailerDropDown());
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public int getTrailersListSize() {
        Waiters.waitForElementToBeDisplay(getTrailerDropDown());
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']")).size();
    }

    public void selectTrailer(String trailer) {
        Waiters.waitForElementToBeDisplay(getTrailerDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option'] and contains(text(), '"
                + trailer + "')")));
        Waiters.waitTillLoadingPage(driver);
    }

    public void selectRandomTrailer() {
        waitUntilInvisible(3, loader);
        Waiters.waitForElementToBeDisplay(getTrailerDropDown());
        int size = getTrailersListSize();
        waitUntilInvisible(3, loader);
        clickOnElement(getTrailers().get(new Random().nextInt(1)));
        waitUntilInvisible(3, loader);
        //clickOnElement(findWebElement(By.xpath("button[@id='btnWarnYes'][text()='Yes']")));
        Waiters.waitTillLoadingPage(driver);
        //button[@id='btnWarnYes'][text()='Yes']
    }
 /* public void selectRandomTrailer() {
      waitUntilInvisible(3, loader);

      // Step 1: Click the trailer dropdown
      clickOnElement(getTrailerDropDown());

      // Step 2: Wait for the trailer list options to be visible
      By trailerOptionsLocator = By.xpath("//ul[contains(@id,'ddTrailer') and contains(@class,'k-list-container')]//li");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(trailerOptionsLocator, 0));

      // Step 3: Fetch the list after waiting
      List<WebElement> trailers = driver.findElements(trailerOptionsLocator);
      if (trailers == null || trailers.isEmpty()) {
          throw new NoSuchElementException("No trailers available to select on the Truck Info page.");
      }

      // Step 4: Click a random trailer
      int randomIndex = new Random().nextInt(trailers.size());
      clickOnElement(trailers.get(randomIndex));

      // Step 5: Final wait
      waitUntilInvisible(3, loader);
      Waiters.waitTillLoadingPage(driver);
  }*/




    public void clickTrailerDropDown() {
        Waiters.waitForElementToBeDisplay(getTrailerDropDown());
        clickOnElement(getTrailerDropDown());
    }

    public void clickDoorDropDown() {
        Waiters.waitForElementToBeDisplay(getDoorDropDown());
        clickOnElement(getDoorDropDown());
    }

    public void selectDoor(String door) {
        Waiters.waitForElementToBeDisplay(getDoorDropDown());
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(door))
                .findFirst()
                .orElse(null);
        clickOnElement(option);
        Waiters.waitTillLoadingPage(driver);
    }

    public void clickYesButton() {
        Waiters.waitForElementToBeDisplay(getYesButton());
        clickOnElement(getYesButton());
        Waiters.waitTillLoadingPage(driver);
    }

    public void clickNoButton() {
        Waiters.waitForElementToBeDisplay(getNoButton());
        clickOnElement(getNoButton());
    }

    public void clickYesBtn() {
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(getYesBtn());
        clickOnElement(getYesBtn());
    }

    public void clickNoBtn() {
        Waiters.waitForElementToBeDisplay(getNoBtn());
        clickOnElement(getNoBtn());
    }

    public void clickOkBtn() {
        Waiters.waitForElementToBeDisplay(getOkBtn());
        clickOnElement(getOkBtn());
    }

    public void clickCancelBtn() {
        Waiters.waitForElementToBeDisplay(getCancelBtn());
        clickOnElement(getCancelBtn());
    }

    public void clickSaveBtn() {
        Waiters.waitForElementToBeDisplay(getSaveBtn());
        clickOnElement(getSaveBtn());
    }

    public void clickSaveButton() {
        Waiters.waitForElementToBeDisplay(getSaveButton());
        clickOnElement(getSaveButton());
    }

    public void clickExitButton() {
        Waiters.waitForElementToBeDisplay(getExitButton());
        clickOnElement(getExitButton());
        waitUntilInvisible(1, loader);
    }

    public void clickWorkButton() {
        Waiters.waitForElementToBeDisplay(getWorkButton());
        clickOnElement(getWorkButton());
    }

    public void clickEditButton() {
        Waiters.waitForElementToBeDisplay(getEditButton());
        clickOnElement(getEditButton());
    }

    public void clickReprocessButton() {
        waitUntilInvisible(1, loader);
        Waiters.waitForElementToBeDisplay(getReprocessButton());
        clickOnElement(getReprocessButton());
    }
    public void waitForOverlayToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("k-overlay")));
    }


    public void clickRecalculateButton() {
        Waiters.waitForElementToBeDisplay(getRecalculateButton());
        clickOnElement(getRecalculateButton());
    }

    public void clickKeyButton() {
        Waiters.waitForElementToBeDisplay(getKeyButton());
        clickOnElement(getKeyButton());
    }

    public void clickInboundLink() {
        Waiters.waitForElementToBeDisplay(getInboundLink());
        clickOnElement(getInboundLink());
    }

    public void clickShortsLink() {
        Waiters.waitForElementToBeDisplay(getShortsLink());
        clickOnElement(getShortsLink());
    }

    public void clickAssignmentPopupHeader() {
        Waiters.waitForElementToBeDisplay(getAssignmentPopupHeader());
        clickOnElement(getAssignmentPopupHeader());
    }

    public void clickAssignmentHeaderContainer() {
        Waiters.waitForElementToBeDisplay(getAssignmentHeaderContainer());
        clickOnElement(getAssignmentHeaderContainer());
    }

    public void clickAssignmentFooter() {
        Waiters.waitForElementToBeDisplay(getAssignmentFooter());
        clickOnElement(getAssignmentFooter());
    }

    public void typeRoute(String route) {
        Waiters.waitForElementToBeDisplay(getEditFormControlInput());
        clearText(getEditFormControlInput());
        inputText(getEditFormControlInput(), route);
    }

    public void typeShipDate(String date) {
        Waiters.waitTillLoadingPage(driver);
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(getShipDateInput());
        clearText(getShipDateInput());
        inputText(getShipDateInput(), date);
        pressEnter(getShipDateInput());
    }

    public void dragAndDropAssignment(String fromPosition, String toPosition) {
        Waiters.waitTillLoadingPage(driver);
        waitUntilInvisible(4, loader);
        dragAndDropTo(getAvailableAssignment(fromPosition), getFreeAssignmentPlace(toPosition));
    }

    public void dragAndDropAssignmentToExistingAssignment(String fromPosition, String toPosition) {
        Waiters.waitTillLoadingPage(driver);
        dragAndDropTo(getAvailableAssignment(fromPosition), getFullAssignmentPlace(toPosition));
    }

    public String getShipDateValue() {
        Waiters.waitTillLoadingPage(driver);
        return getValue(getShipDateInput());
    }

    public void typeShipTime(String time) {
        Waiters.waitABit(3000);
        clickOnElement(toggleIcon);
        clickOnElement(findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@class='k-item']"))
                .stream()
                .filter(elt -> elt.getText().contains(time.split(":")[0]))
                .findFirst().orElseThrow(() ->
                        new IllegalArgumentException("Element with text " + time.split(":")[0] + " is not found")));
        Waiters.waitABit(2000);
        if(Integer.parseInt(time.split(":")[1].substring(0, 2)) < 13) {
            clickOnElement(findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@class='k-item']"))
                    .stream()
                    .filter(elt -> elt.getText().contains(time.split(":")[1].substring(0, 2)))
                    .skip(2)
                    .findFirst().orElseThrow(() ->
                            new IllegalArgumentException("Element with text " + time.split(":")[0] + " is not found")));
        } else {
            clickOnElement(findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@class='k-item']"))
                    .stream()
                    .filter(elt -> elt.getText().contains(time.split(":")[1].substring(0, 2)))
                    .findFirst().orElseThrow(() ->
                            new IllegalArgumentException("Element with text " + time.split(":")[0] + " is not found")));
        }
        Waiters.waitABit(2000);
        clickOnElement(findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@class='k-item']"))
                .stream()
                .filter(elt -> elt.getText().contains(time.split(":")[1].substring(3, 5)))
                .findFirst().orElseThrow(() ->
                        new IllegalArgumentException("Element with text " + time.split(":")[0] + " is not found")));
        Waiters.waitABit(2000);
        clickOnElement(setButton);
    }

    public String getShipTimeValue() {
        Waiters.waitTillLoadingPage(driver);
        return getValue(getShipTimeInput());
    }

    public String getDoorDropDownText() {
        Waiters.waitTillLoadingPage(driver);
        return getText(getDoorDropDown());
    }

    public void clickTruckInfoArrow() {
        Waiters.waitForElementToBeDisplay(getTruckInfoArrow());
        clickOnElement(getTruckInfoArrow());
    }

    public String getDialogWindowContentText() {
        Waiters.waitForElementToBeDisplay(getDialogContent());
        return getText(getDialogContent());
    }

    public String getWindowTitleText() {
        Waiters.waitTillLoadingPage(driver);
        return getText(getWindowTitle());
    }

    public String getWarningMessageText() {
        Waiters.waitTillLoadingPage(driver);
        return getText(getWarningMessage());
    }

    public String getRouteName() {
        Waiters.waitForElementToBeDisplay(getRouteValue());
        return getText(getRouteValue());
    }

    public String getNotificationText() {
        Waiters.waitForElementToBeDisplay(getNotification());
        return getText(getNotification());
    }

    public String getTrailerTypeText() {
        Waiters.waitForElementToBeDisplay(getTypeValue());
        return getText(getTypeValue());
    }

    public String getEditFormControlInputValue() {
        Waiters.waitForElementToBeDisplay(getEditFormControlInput());
        return getValue(getEditFormControlInput());
    }

    public void clickFirstAssignment() {
        Waiters.waitTillLoadingPage(driver);
        Waiters.waitABit(3000);
        clickOnElement(getAssignments().get(0).findElement(By.cssSelector(".lp_pallet_assignment_text")));
        waitUntilInvisible(2, loader);
    }

    public void selectTopOfAssignmentByIndex(int index) {
        Waiters.waitForAllElementsToBeDisplay(getAssignments().get(getAssignments().size()-1));
        clickOnElement(getAssignments().get(index).findElement(By.xpath(".//div[contains(@class, 'palletHeaderContainer')]")));
    }

    public void selectAssignmentPositionByIndex(int index) {
        Waiters.waitForAllElementsToBeDisplay(getAssignments().get(getAssignments().size()-1));
        clickOnElement(getAssignments().get(index).findElement(By.xpath(".//div[contains(@class, 'stopItem')]")));
    }

    public void selectBottomOfAssignmentIndex(int index) {
        Waiters.waitForAllElementsToBeDisplay(getAssignments().get(getAssignments().size()-1));
        clickOnElement(getAssignments().get(index).findElement(By.xpath(".//div[contains(@class, 'lp_pallet_footer')]")));
    }

   /*public void selectEditFirstAssignment() {
        Waiters.waitForAllElementsToBeDisplay(getAssignmentPopupRows(0).get(getAssignmentPopupRows(0).size()-1));
        clickOnElement(getAssignmentPopupRows(0).get(0).findElement(By.xpath(".//div[contains(@class, 'lp_overlayChildIcon')]")));
    }*/
   public void selectEditFirstAssignment(WebDriver driver) {
       // Locate the visible assignment popup
       WebElement popup = driver.findElement(By.xpath("//div[contains(@id, 'TaskListModal') and contains(@style, 'display: block')]"));

       // Find the edit icon inside the popup
       List<WebElement> editIcons = popup.findElements(By.cssSelector(".lp_overlayChildIcon"));

       if (editIcons.isEmpty()) {
           throw new RuntimeException("No edit icons found in assignment popup.");
       }

       WebElement editIcon = editIcons.get(0);
       Waiters.waitForElementToBeDisplay(editIcon);
       clickOnElement(editIcon);
   }





    public void clickReasonDropdown() {
        Waiters.waitForElementToBeDisplay(getReasonDropdown());
        clickOnElement(getReasonDropdown());
    }

    public void selectReason(String reason) {
        Waiters.waitForElementToBeDisplay(getReasonDropdown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option' and contains(text(), '"
                        + reason + "')]")));
        Waiters.waitTillLoadingPage(driver);
    }

    public void clickIncreaseValueArrow() {
        Waiters.waitForElementToBeDisplay(getIncreaseValueArrow());
        clickOnElement(getIncreaseValueArrow());
    }

    public void clickDecreaseValueArrow() {
        Waiters.waitForElementToBeDisplay(getDecreaseValueArrow());
        clickOnElement(getDecreaseValueArrow());
    }

    public List<String> getAssignmentsText() {
        Waiters.waitForAllElementsToBeDisplay(getAssignments().get(getAssignments().size()-1));
        return getAssignments().stream()
                .map(assignment -> assignment.getText().trim())
                .collect(Collectors.toList());
    }

    public void setAssignmentsNumbersText() {
        Waiters.waitABit(3000);
        assignmentsNumbersList = getAssignments().stream()
                .map(assignment -> assignment.findElement(By.xpath(".//div[@class='palletHeaderContainer']")).getText().trim())
                .collect(Collectors.toList());
    }

    public List<String> getAssignmentsNumbers() {
        Waiters.waitTillLoadingPage(driver);
        return assignmentsNumbersList;
    }

    public int verifyAssignmentsDisplayed() { return elementsArePresent(getAssignments()); }

    public boolean isTruckInfoTitleDisplayed() { return isElementDisplay(getTruckInfoTitle()); }

    public boolean isExitButtonDisplayed() { return isElementDisplay(getExitButton()); }

    public boolean isExitIconDisplayed() { return isElementDisplay(getExitIcon()); }

    public boolean isWorkButtonDisplayed() { return isElementDisplay(getWorkButton()); }

    public boolean isEditButtonDisplayed() { return isElementDisplay(getEditButton()); }

    public boolean isReprocessButtonDisplayed() { return isElementDisplay(getReprocessButton()); }

    public boolean isRecalculateButtonDisplayed() { return isElementDisplay(getRecalculateButton()); }

    public boolean isKeyButtonDisplayed() { return isElementDisplay(getKeyButton()); }

    public boolean isRouteLabelDisplayed() { return isElementDisplay(getRouteLabel()); }

    public boolean isShipDateInputDisplayed() { return isElementDisplay(getShipDateInput()); }

    public boolean isShipTimeInputDisplayed() { return isElementDisplay(getShipTimeInput()); }

    public boolean isTrailerDropDownDisplayed() { return isElementDisplay(getTrailerDropDown()); }

    public boolean isDoorDropDownDisplayed() { return isElementDisplay(getDoorDropDown()); }

    public boolean isInboundLinkDisplayed() { return isElementDisplay(getInboundLink()); }

    public boolean isShortsLinkDisplayed() { return isElementDisplay(getShortsLink()); }

    public boolean isTypeLabelDisplayed() { return isElementDisplay(getTypeLabel()); }

    public boolean isTypeValueDisplayed() { return isElementDisplay(getTypeValue()); }

    public boolean isPositionsLabelDisplayed() { return isElementDisplay(getPositionsLabel()); }

    public boolean isPositionsValueDisplayed() { return isElementDisplay(getPositionsValue()); }

    public boolean isPalletsLabelDisplayed() { return isElementDisplay(getPalletsLabel()); }

    public boolean isPalletsValueDisplayed() { return isElementDisplay(getPalletsValue()); }

    public boolean isTrailerCubeLabelDisplayed() { return isElementDisplay(getTrailerCubeLabel()); }

    public boolean isTrailerCubeValueDisplayed() { return isElementDisplay(getTrailerCubeValue()); }

    public boolean isRouteCubeLabelDisplayed() { return isElementDisplay(getRouteCubeLabel()); }

    public boolean isRouteCubeValueDisplayed() { return isElementDisplay(getRouteCubeValue()); }

    public boolean isTrailerWeightLabelDisplayed() { return isElementDisplay(getTrailerWeightLabel()); }

    public boolean isTrailerWeightValueDisplayed() { return isElementDisplay(getTrailerWeightValue()); }

    public boolean isRouteWeightLabelDisplayed() { return isElementDisplay(getRouteWeightLabel()); }

    public boolean isRouteWeightValueDisplayed() { return isElementDisplay(getRouteWeightValue()); }

    public boolean isTruckDiagramLabelDisplayed() { return isElementDisplay(getTruckDiagramLabel()); }

    public boolean isTruckInfoArrowDisplayed() { return isElementDisplay(getTruckInfoArrow()); }

    public boolean isLoadPlanningScrollDisplayed() { return isElementDisplay(getLoadPlanningScroll()); }

    public boolean isDialogContentDisplayed() { return isElementDisplay(getDialogContent()); }

    public boolean isYesButtonDisplayed() { return isElementDisplay(getYesButton()); }

    public boolean isNoButtonDisplayed() { return isElementDisplay(getNoButton()); }

    public boolean isEditFormControlDisplayed() { return isElementDisplay(getEditFormControl()); }

    public boolean isYesBtnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getYesBtn());
    }

    public boolean isNoBtnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getNoBtn());
    }

    public boolean isSaveBtnDisplayed() { return isElementDisplay(getSaveBtn()); }

    public boolean isCancelBtnDisplayed() { return isElementDisplay(getCancelBtn()); }

    /*public boolean isPalletHeadDisplayed() { return isElementDisplay(getPalletHead()); }*/
    public boolean isPalletHeadDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[text()='Trailer position']") // correct locator
            ));
            return header.isDisplayed();
        } catch (Exception e) {
            System.out.println("Pallet Key header not displayed: " + e.getMessage());
            return false;
        }
    }


    public boolean isPalletContentTopDisplayed() { return isElementDisplay(getPalletContentTop()); }

    public boolean isPalletContentBottomDisplayed() { return isElementDisplay(getPalletContentBottom()); }

    public boolean isPalletKeyTitleDisplayed() { return isElementDisplay(getPalletKeyTitle()); }

    public boolean isWaitingToBePickedDisplayed() { return isElementDisplay(getWaitingToBePicked()); }

    public boolean isWaitingToBeLoadedDisplayed() { return isElementDisplay(getWaitingToBeLoaded()); }

    public boolean isLoadedDisplayed() { return isElementDisplay(getLoaded()); }

    public boolean isPalletDoesNotFitDisplayed() { return isElementDisplay(getPalletDoesNotFit()); }

    public boolean isFreezerItemsDisplayed() { return isElementDisplay(getFreezerItems()); }

    public boolean isCoolerItemsDisplayed() { return isElementDisplay(getCoolerItems()); }

    public boolean isDryGoodsDisplayed() { return isElementDisplay(getDryGoods()); }

    public boolean isTableGridDisplayed() { return isElementDisplay(getTableGrid()); }

   /* public int verifyAssignmentPopupRowsDisplayed(int number) { return elementsArePresent(getAssignmentPopupRows(number)); }*/
  /* public int verifyAssignmentPopupRowsDisplayed(WebDriver driver, int number) {
       try {
           List<WebElement> assignments = getAssignments();
           if (assignments == null || assignments.size() <= number) {
               throw new RuntimeException("Assignment index " + number + " is invalid.");
           }

           WebElement assignment = assignments.get(number);
           assignment.click(); // Open the popup

           Thread.sleep(1000);

           // Extract Assignment ID from visible popup, not from pallet header
           WebElement popupTitle = driver.findElement(By.cssSelector("div.popover-title span"));
           String headerText = popupTitle.getText().trim(); // e.g., "Assignment#: 63845"

           String id;
           if (headerText.contains(":")) {
               id = headerText.split(":")[1].trim();
           } else {
               throw new RuntimeException("Expected assignment header, but got: " + headerText);
           }

           // Locate popup rows by matching TaskListModal ID
           By popupRowLocator = By.xpath("//div[contains(@id, 'TaskListModal_') and contains(@id, '" + id + "')]//div[@class='lpDrRow']");
           Waiters.waitForElementToBeDisplay(driver, popupRowLocator, 15);

           List<WebElement> popupRows = driver.findElements(popupRowLocator);
           return popupRows != null ? popupRows.size() : 0;

       } catch (TimeoutException e) {
           System.err.println("Popup rows not found or timed out: " + e.getMessage());
           return 0;
       } catch (Exception e) {
           System.err.println("Error verifying assignment popup rows: " + e.getMessage());
           return 0;
       }
   }*/

    public int verifyAssignmentPopupRowsDisplayed(WebDriver driver) {
        try {
            // Locate all elements with class 'palletHeaderContainer'
            List<WebElement> assignmentHeaders = driver.findElements(By.cssSelector(".palletHeaderContainer"));

            for (WebElement header : assignmentHeaders) {
                String headerText = header.getText().trim();

                // Only proceed if it's an Assignment, not Pallet
                if (!headerText.contains("Assignment#:")) {
                    continue;
                }

                // Extract assignment ID
                String id = headerText.split("Assignment#:")[1].trim();
                if (id.isEmpty()) {
                    System.err.println("Empty assignment ID for header: " + headerText);
                    continue;
                }

                // Find the stopItem under this assignment card
                WebElement assignmentCard = header.findElement(By.xpath("ancestor::div[contains(@class, 'lp_pallet_body')]"));
                WebElement stopItem = assignmentCard.findElement(By.cssSelector(".stopItem"));

                // Click to open popup
                stopItem.click();

                // Construct locator for popup rows
                By popupRowLocator = By.xpath("//div[starts-with(@id, 'TaskListModal_') and contains(@id,'" + id + "')]//div[@class='lpDrRow']");

                // Wait for popup
                Waiters.waitForElementToBeDisplay(driver, popupRowLocator, 15);

                // Get the popup rows
                List<WebElement> popupRows = driver.findElements(popupRowLocator);
                return popupRows != null ? popupRows.size() : 0;
            }

            System.err.println("No valid assignment headers found.");
            return 0;

        } catch (TimeoutException e) {
            System.err.println("Popup rows not found or timed out: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.err.println("Error verifying assignment popup rows: " + e.getMessage());
            return 0;
        }
    }


    public boolean isAssignmentHeaderDisplayed() { return isElementDisplay(getAssignmentHeader()); }

    public boolean isQuantityDisplayed() { return isElementDisplay(getQuantity()); }

   /* public boolean isReasonDropdownDisplayed() { return isElementDisplay(getReasonDropdown()); }*/
   public boolean isSplitTaskPopupDisplayed() {
       try {
           WebElement qtyInput = driver.findElement(By.xpath("//label[contains(text(),'Qty')]"));
           return qtyInput.isDisplayed();
       } catch (NoSuchElementException | NullPointerException e) {
           return false;
       }
   }




    public boolean isIncreaseValueArrowDisplayed() { return isElementDisplay(getIncreaseValueArrow()); }

    public boolean isDecreaseValueArrowDisplayed() { return isElementDisplay(getDecreaseValueArrow()); }

   /* public boolean isYesBtnActive() { return getElementAttribute(getYesBtn(), "class").contains("k-primary");}*/
   public boolean isYesBtnActive() {
       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           // Wait until the button appears in the DOM
           WebElement yesButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                   By.xpath("//button[.//span[text()='Yes']]")
           ));

           // Wait until it's both visible and enabled
           wait.until(ExpectedConditions.and(
                   ExpectedConditions.visibilityOf(yesButton),
                   driver -> yesButton.isEnabled()
           ));

           return yesButton.isDisplayed() && yesButton.isEnabled();
       } catch (Exception e) {
           System.out.println("Yes button is not active or not found: " + e.getMessage());
           return false;
       }
   }




   // public boolean isAssignmentBorderBlue() { return getElementAttribute(getAssignmentBorder(), "style").contains("blue"); }

    public boolean isRouteWeightGreaterTrailerWeight() { return getElementAttribute(getRouteWeightValue(), "style").contains("red"); }

    public WebElement getTruckInfoTitle() {
        Waiters.waitABit(4000);
        return findWebElement(truckInfoTitle);
    }

    public WebElement getExitButton() { return findWebElement(exitButton); }

    public WebElement getExitIcon() { return findWebElement(exitIcon); }

    public WebElement getWorkButton() { return findWebElement(workButton); }

    public WebElement getEditButton() { return findWebElement(editButton); }

    public WebElement getReprocessButton() { return findWebElement(reprocessButton); }

    public WebElement getRecalculateButton() { return findWebElement(recalculateButton); }

    public WebElement getKeyButton() { return findWebElement(keyButton); }

    public WebElement getRouteLabel() { return findWebElement(routeLabel); }

    public WebElement getRouteValue() { return findWebElement(routeValue); }

    public WebElement getShipDateInput() { return findWebElement(shipDateInput); }

    public WebElement getShipTimeInput() { return findWebElement(shipTimeInput); }

    public WebElement getTrailerDropDown() { return findWebElement(trailerDropDown); }

    public WebElement getDoorDropDown() { return findWebElement(doorDropDown); }

    public WebElement getInboundLink() { return findWebElement(inboundLink); }

    public WebElement getShortsLink() { return findWebElement(shortsLink); }

    public WebElement getTypeLabel() { return findWebElement(typeLabel); }

    public WebElement getTypeValue() { return findWebElement(typeValue); }

    public WebElement getPositionsLabel() { return findWebElement(positionsLabel); }

    public WebElement getPositionsValue() { return findWebElement(positionsValue); }

    public WebElement getPalletsLabel() { return findWebElement(palletsLabel); }

    public WebElement getPalletsValue() { return findWebElement(palletsValue); }

    public WebElement getTrailerCubeLabel() { return findWebElement(trailerCubeLabel); }

    public WebElement getTrailerCubeValue() { return findWebElement(trailerCubeValue); }

    public WebElement getRouteCubeLabel() { return findWebElement(routeCubeLabel); }

    public WebElement getRouteCubeValue() { return findWebElement(routeCubeValue); }

    public WebElement getTrailerWeightLabel() { return findWebElement(trailerWeightLabel); }

    public WebElement getTrailerWeightValue() { return findWebElement(trailerWeightValue); }

    public WebElement getRouteWeightLabel() { return findWebElement(routeWeightLabel); }

    public WebElement getRouteWeightValue() { return findWebElement(routeWeightValue); }

    public WebElement getTruckDiagramLabel() {
        Waiters.waitABit(4000);
        return findWebElement(truckDiagramLabel);
    }

    public WebElement getTruckInfoArrow() { return findWebElement(truckInfoArrow); }

    public WebElement getLoadPlanningScroll() { return findWebElement(loadPlanningScroll); }

   // public WebElement getDialogContent() { return findWebElement(dialogContent); }
   public WebElement getDialogContent() {
       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialogTextContent")));
       } catch (TimeoutException e) {
           System.out.println("dialogTextContent element not found within timeout.");
           return null;
       }
   }

    public WebElement getYesButton() { return findWebElement(yesButton); }

    public WebElement getNoButton() { return findWebElement(noButton); }

    public WebElement getWindowTitle() { return findWebElement(windowTitle); }

    public WebElement getWarningMessage() { return findWebElement(warningMessage); }

    public WebElement getYesBtn() { return findWebElement(yesBtn); }

    public WebElement getNoBtn() { return findWebElement(noBtn); }

    public WebElement getOkBtn() { return findWebElement(okBtn); }

    public List<WebElement> getAssignments() { return findWebElements(assignments); }

    public WebElement getEditFormControl() { return findWebElement(editFormControl); }

     public WebElement getEditFormControlInput() { return findWebElement(editFormControlInput); }

    public WebElement getCancelBtn() { return findWebElement(cancelBtn); }

    public WebElement getSaveBtn() { return findWebElement(saveBtn); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getPalletHead() { return findWebElement(palletHead); }

    public WebElement getPalletContentTop() { return findWebElement(palletContentTop); }

    public WebElement getPalletContentBottom() { return findWebElement(palletContentBottom); }

    public WebElement getPalletKeyTitle() { return findWebElement(palletKeyTitle); }

    public WebElement getWaitingToBePicked() { return findWebElement(waitingToBePicked); }

    public WebElement getWaitingToBeLoaded() { return findWebElement(waitingToBeLoaded); }

    public WebElement getLoaded() { return findWebElement(loaded); }

    public WebElement getPalletDoesNotFit() { return findWebElement(palletDoesNotFit); }

    public WebElement getFreezerItems() { return findWebElement(freezerItems); }

    public WebElement getCoolerItems() { return findWebElement(coolerItems); }

    public WebElement getDryGoods() { return findWebElement(dryGoods); }

    public WebElement getTableGrid() { return findWebElement(tableGrid); }

    public WebElement getAssignmentHeader() { return findWebElement(assignmentPopupHeader); }

    /*public WebElement getQuantity() { return findWebElement(quantity); }*/
    public WebElement getQuantity() {
        try {
            if (driver == null) {
                System.out.println(" WebDriver is null in getQuantity()");
                return null;
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wqTextTaskQty")));
        } catch (Exception e) {
            System.out.println(" getQuantity() failed: " + e.getMessage());
            return null;
        }
    }








    public WebElement getReasonDropdown() { return findWebElement(reasonDropdown); }

    public WebElement getIncreaseValueArrow() { return findWebElement(increaseValueArrow); }

    public WebElement getDecreaseValueArrow() { return findWebElement(decreaseValueArrow); }

    public WebElement getNotification() { return findWebElement(notification); }

    public WebElement getAssignmentPopupHeader() { return findWebElement(assignmentHeader); }

    public WebElement getAssignmentHeaderContainer() { return findWebElement(assignmentHeaderContainer); }

    public WebElement getAssignmentFooter() { return findWebElement(assignmentFooter); }

    public WebElement getAssignmentBorder() { return findWebElement(assignmentBorder); }

    public String navigateToTruckInfoPage() {
        //exists = false;
        currentURL= driver.getCurrentUrl();
        return currentURL;
    }

    public void Refresh_Page() {
        String currentURL = this.driver.getCurrentUrl();
        //currentURL=navigateToTruckInfoPage();
        driver.navigate().to(currentURL);
    }

}
