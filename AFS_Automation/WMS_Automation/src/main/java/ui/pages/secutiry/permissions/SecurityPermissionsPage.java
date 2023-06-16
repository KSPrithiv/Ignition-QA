package ui.pages.secutiry.permissions;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class SecurityPermissionsPage extends BasePage {
    By byRoleTab = By.xpath("//span[text()='By role']");
    By byUserTab = By.xpath("//span[text()='By user']");
    By wmsUserDashboardCheckbox = By.xpath("//tr[.//div[text()='Allow user to access WMS Dashboard.']]//td[4]");
    By cancelBtn = By.id("cancel-btn");
    By saveBtn = By.id("save-btn");
    By OKButton = By.xpath("//button[contains(text(), 'OK')]");

    public void waitForSecurityPermissionsPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitABit(10_000);
        Waiters.waitForElementToBeClickable(byRoleTab);
        Waiters.waitForElementToBeDisplay(byUserTab);
        Waiters.waitABit(10_000);
    }

    public void selectAllowUserAccessToDashboard() {
        Waiters.waitForElementToBeDisplay(wmsUserDashboardCheckbox);
        try {
            if(!getWmsUserDashboardCheckbox().isEnabled()) {
                clickOnElement(getWmsUserDashboardCheckbox());
                clickOnElement(saveBtn);
                Waiters.waitForElementToBeDisplay(OKButton);
                clickOnElement(OKButton);
            }
        } catch(StaleElementReferenceException | TimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void unselectAllowUserAccessToDashboard() {
        Waiters.waitForElementToBeDisplay(wmsUserDashboardCheckbox);
        try {
            if(getWmsUserDashboardCheckbox().isEnabled()) {
                clickOnElement(getWmsUserDashboardCheckbox());
                clickOnElement(saveBtn);
                Waiters.waitForElementToBeDisplay(OKButton);
                clickOnElement(OKButton);
            }
        } catch(StaleElementReferenceException | TimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void clickSaveButton() {
        Waiters.waitForElementToBeDisplay(saveBtn);
        try {
            Waiters.waitForElementToBeDisplay(OKButton);
            clickOnElement(saveBtn);
        } catch(StaleElementReferenceException | TimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeDisplay(cancelBtn);
        try {
            clickOnElement(cancelBtn);
        } catch(StaleElementReferenceException | TimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public WebElement getByRoleTab() { return findWebElement(byRoleTab); }

    public WebElement getByUserTab() { return findWebElement(byUserTab); }

    public WebElement getWmsUserDashboardCheckbox() { return findWebElement(wmsUserDashboardCheckbox); }

}
