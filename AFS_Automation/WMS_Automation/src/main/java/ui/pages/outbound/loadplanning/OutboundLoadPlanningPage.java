package ui.pages.outbound.loadplanning;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

public class OutboundLoadPlanningPage extends BasePage {
    By dialog = By.cssSelector(".k-dialog-title");
    By loadPlanningShipDate = By.id("loadPlanningShipDate");
    By loadPlanningShipDateLabel = By.id("loadPlanningShipDate-label");
    By dropDownRouteType = By.id("dropDownIconType");
    By dropDownRouteTypeLabel = By.id("dropDownIconType-label");
    By doneButton = By.cssSelector("#btnlpDone");
    By dropdownList = By.id("dropdownList");

    public void waitOutboundLoadPlanningPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitABit(7000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getLoadPlanningShipDate());
        Waiters.waitForElementToBeDisplay(getLoadPlanningShipDateLabel());
    }

    public boolean isLoadPlanningDialogDisplayed() { return isElementDisplay(getLoadPlanningDialog()); }

    public boolean isLoadPlanningShipDateDisplayed() { return isElementDisplay(getLoadPlanningShipDate()); }

    public boolean isLoadPlanningShipDateLabelDisplayed() { return isElementDisplay(getLoadPlanningShipDateLabel()); }

    public boolean isDropDownRouteTypeDisplayed() { return isElementDisplay(getDropDownRouteType()); }

    public boolean isDropDownRouteTypeLabelDisplayed() { return isElementDisplay(getDropDownRouteTypeLabel()); }

    public boolean isDoneButtonDisplayed() { return isElementDisplay(getDoneButton()); }

    public String getLoadPlanningDialogText() {
        Waiters.waitForElementToBeDisplay(getLoadPlanningDialog());
        return getText(getLoadPlanningDialog()).trim();
    }

    public String getLoadPlanningShipDateValue() {
        Waiters.waitForElementToBeDisplay(getLoadPlanningShipDate());
        return getValue(getLoadPlanningShipDate()).trim();
    }

    public String getLoadPlanningShipDateLabelText() {
        Waiters.waitForElementToBeDisplay(getLoadPlanningShipDateLabel());
        return getText(getLoadPlanningShipDateLabel()).trim();
    }

    public String getLoadPlanningRouteTypeValue() {
        Waiters.waitForElementToBeDisplay(getDropDownRouteType());
        return getValue(getDropDownRouteType()).trim();
    }

    public String getLoadPlanningRouteTypeLabelText() {
        Waiters.waitForElementToBeDisplay(getDropDownRouteTypeLabel());
        return getText(getDropDownRouteTypeLabel()).trim();
    }

    public void clickDoneButton() {
        Waiters.waitABit(3000);
        clickOnElement(getDoneButton());
    }

    public void clickRouteTypeDropDown() {
        Waiters.waitABit(4000);
        clickOnElement(getDropDownRouteType());
    }

    public void selectRoute(String route) {
        Waiters.waitABit(2000);
        WebElement option = findWebElement(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + route + "') and @role='option']"));
        clickOnElement(option);
        Waiters.waitABit(2000);
    }

    public List<WebElement> getRoutes() {
        Waiters.waitABit(4000);
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public void typeShipDate(String date) {
        Waiters.waitForElementToBeDisplay(getLoadPlanningShipDate());
        Waiters.waitABit(2000);
        doubleClick(getLoadPlanningShipDate());
        pressDelete(getLoadPlanningShipDate());
        inputText(getLoadPlanningShipDate(), date);
        pressEnter(getLoadPlanningShipDate());
        pressTab(getLoadPlanningShipDate());
        Waiters.waitABit(4000);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public WebElement getLoadPlanningDialog() { return findWebElement(dialog); }

    public WebElement getLoadPlanningShipDate() { return findWebElement(loadPlanningShipDate); }

    public WebElement getLoadPlanningShipDateLabel() { return findWebElement(loadPlanningShipDateLabel); }

    public WebElement getDropDownRouteType() { return findWebElement(dropDownRouteType); }

    public WebElement getDropDownRouteTypeLabel() { return findWebElement(dropDownRouteTypeLabel); }

    public WebElement getDoneButton() { return findWebElement(doneButton); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
