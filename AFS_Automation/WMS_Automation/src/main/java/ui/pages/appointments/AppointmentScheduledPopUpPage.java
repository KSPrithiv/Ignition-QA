package ui.pages.appointments;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class AppointmentScheduledPopUpPage extends BasePage  {
    By appointmentScheduledPopUpTitle = By.cssSelector("div.k-dialog-title");
    By appointmentScheduledPopUpContent = By.cssSelector("#dialogTextContent");
    By appointmentScheduledPopUpOkButton = By.xpath("//button[@class='k-button k-primary k-button-icontext']");

    public void waitForAppointmentScheduledPopUpPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getAppointmentScheduledPopUpTitle());
        Waiters.waitForElementToBeDisplay(getAppointmentScheduledPopUpContent());
    }

    public String getAppointmentScheduledPopUpTitleText() {
        return getText(getAppointmentScheduledPopUpTitle());
    }

    public String getAppointmentScheduledContentText() {
        return getText(getAppointmentScheduledPopUpContent());
    }

    public boolean isAppointmentScheduledPopUpTitleDisplayed() {
        return isElementDisplay(getAppointmentScheduledPopUpTitle());
    }

    public boolean isAppointmentScheduledContentDisplayed() {
        return isElementDisplay(getAppointmentScheduledPopUpContent());
    }

    public boolean isAppointmentScheduledOkButtonDisplayed() {
        return isElementDisplay(getAppointmentScheduledPopUpOkButton());
    }

    public void clickAppointmentScheduledPopUpOkButton() {
        Waiters.waitForElementToBeDisplay(getAppointmentScheduledPopUpOkButton());
        clickOnElement(getAppointmentScheduledPopUpOkButton());
    }

    public WebElement getAppointmentScheduledPopUpTitle() { return findWebElement(appointmentScheduledPopUpTitle); }

    public WebElement getAppointmentScheduledPopUpContent() { return findWebElement(appointmentScheduledPopUpContent); }

    public WebElement getAppointmentScheduledPopUpOkButton() { return findWebElement(appointmentScheduledPopUpOkButton); }
}
