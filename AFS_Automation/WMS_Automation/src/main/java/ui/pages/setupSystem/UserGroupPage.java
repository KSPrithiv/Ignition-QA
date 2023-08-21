package ui.pages.setupSystem;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class UserGroupPage extends BasePage {
    By setupSystem = By.xpath("//div[contains(@id, 'accesscpwmssettingssystem')]//div[contains(text(), 'System')]");
    By userGroupTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'User')]");




    public void clickSetupSystem() {
        Waiters.waitForElementToBeDisplay(setupSystem);
        clickOnElement(setupSystem);
    }

    public void userGroupTab()  {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getusergroup());
            clickOnElement(getusergroup());
        } catch (Exception e) {
        }
    }
    public WebElement getusergroup() { return findWebElement(userGroupTab); }

}
