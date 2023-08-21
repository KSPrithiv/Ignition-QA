package ui.pages.appointments;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class AppointmentSchedulerLinkedOrdersPopUpPage extends BasePage {
    By linkedOrdersPopUpTitle = By.cssSelector("div.k-dialog-title");
    By linkedOrdersPopUpContent = By.cssSelector("div.k-window-content");
    By linkedOrdersPopUpCancelButton = By.xpath("//button[@class='k-button k-button-icontext']");
    By linkedOrdersPopUpOkButton = By.xpath("//button[@class='k-button k-primary k-button-icontext']");

    public void waitForAppointmentSchedulerLinkedOrdersPopUpPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getLinkedOrdersPopUpTitle());
        Waiters.waitForElementToBeDisplay(getLinkedOrdersPopUpContent());
    }

    public String getLinkedOrdersPopUpTitleText() {
        return getText(getLinkedOrdersPopUpTitle());
    }

    public String getLinkedOrdersPopUpContentText() {
        return getText(getLinkedOrdersPopUpContent());
    }

    public void clickLinkedOrdersPopUpCancelButton() {
        Waiters.waitForElementToBeDisplay(getLinkedOrdersPopUpCancelButton());
        clickOnElement(getLinkedOrdersPopUpCancelButton());
    }

    public void clickLinkedOrdersPopUpOkButton() {
        Waiters.waitForElementToBeDisplay(getLinkedOrdersPopUpOkButton());
        clickOnElement(getLinkedOrdersPopUpOkButton());
    }

    public WebElement getLinkedOrdersPopUpTitle() {
        return findWebElement(linkedOrdersPopUpTitle);
    }

    public WebElement getLinkedOrdersPopUpContent() {
        return findWebElement(linkedOrdersPopUpContent);
    }

    public WebElement getLinkedOrdersPopUpCancelButton() { return findWebElement(linkedOrdersPopUpCancelButton); }

    public WebElement getLinkedOrdersPopUpOkButton() {
        return findWebElement(linkedOrdersPopUpOkButton);
    }
}
