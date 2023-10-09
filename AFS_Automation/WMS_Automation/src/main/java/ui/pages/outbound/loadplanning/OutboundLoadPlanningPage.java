package ui.pages.outbound.loadplanning;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

import static common.setup.DriverManager.getDriver;

public class OutboundLoadPlanningPage extends BasePage {
    By dialog = By.cssSelector(".k-dialog-title");
    By loadPlanningShipDate = By.id("loadPlanningShipDate");
    By loadPlanningShipDateLabel = By.id("loadPlanningShipDate-label");
    By dropDownRouteType = By.id("dropDownIconType");
    By dropDownRouteTypeLabel = By.id("dropDownIconType-label");
    By doneButton = By.cssSelector("#btnlpDone");
    By dropdownList = By.id("dropdownList");
    By loader = By.cssSelector(".loader");

    public void waitOutboundLoadPlanningPageToLoad() {
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
        waitUntilInvisible(10, loader);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDoneButton());
        waitUntilInvisible(10, loader);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickRouteTypeDropDown() {
        Waiters.waitTillLoadingPage(getDriver());
        deleteCookies();
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDropDownRouteType());
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(4000);
    }

    public void selectRoute(String route) {
        Waiters.waitTillLoadingPage(getDriver());
        deleteCookies();
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        if(options.equals(null)) {
            refresh();
        }
        options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(route))
                .findFirst()
                .orElse(null);
        Waiters.waitABit(10000);
        clickOnElement(option);
        Waiters.waitABit(10000);
        waitUntilInvisible(20, loader);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public List<WebElement> getRoutes() {
        Waiters.waitTillLoadingPage(getDriver());
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public void typeShipDate(String date) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLoadPlanningShipDate());
        Waiters.waitABit(2000);
        doubleClick(getLoadPlanningShipDate());
        pressDelete(getLoadPlanningShipDate());
        inputText(getLoadPlanningShipDate(), date);
        pressEnter(getLoadPlanningShipDate());
        pressTab(getLoadPlanningShipDate());
        waitUntilInvisible(1, loader);
    }

    public void selectWarehouse(String warehouse) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public WebElement getLoadPlanningDialog() { return findWebElement(dialog); }

    public WebElement getLoadPlanningShipDate() { return findWebElement(loadPlanningShipDate); }

    public WebElement getLoadPlanningShipDateLabel() { return findWebElement(loadPlanningShipDateLabel); }

    public WebElement getDropDownRouteType() { return findWebElement(dropDownRouteType); }

    public WebElement getDropDownRouteTypeLabel() { return findWebElement(dropDownRouteTypeLabel); }

    public WebElement getDoneButton() { return findWebElement(doneButton); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
