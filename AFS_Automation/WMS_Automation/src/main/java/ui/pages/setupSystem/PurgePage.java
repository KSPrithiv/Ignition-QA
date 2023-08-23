package ui.pages.setupSystem;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class PurgePage extends BasePage{
    By purgeTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Purge')]");



    public void purgeTab()  {

        try {
            Waiters.waitForElementToBeDisplay(getPurge());
            clickOnElement(getPurge());
        } catch (Exception e) {
        }
    }
    public WebElement getPurge() { return findWebElement(purgeTab); }
}
