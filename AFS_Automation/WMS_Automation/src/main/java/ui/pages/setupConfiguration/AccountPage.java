package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class AccountPage extends BasePage{
    By accountTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Account')]");
    By accountIcon=By.cssSelector(".i-button--icon-only.i-indexfield-container__main__button.k-button.k-button-icontext.k-outline > .i-icon");
    public void accountTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitABit(4000);
            Waiters.waitForElementToBeDisplay(getAccount());
            clickOnElement(getAccount());
        } catch (Exception e) {
        }
    }
    public void accountSearchIcon(){
        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitABit(5000);
            Waiters.waitForElementToBeDisplay(getAccountIcon());
            clickOnElement(getAccountIcon());
        } catch (Exception e) {
        }

    }
    public WebElement getAccountIcon(){return findWebElement(accountIcon);}
    public WebElement getAccount() { return findWebElement(accountTab); }
}
