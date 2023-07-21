package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class CountTypePage extends BasePage {
    By countTypeTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Count')]");
    public void countTypeTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getCountType());
            clickOnElement(getCountType());
        } catch (Exception e) {
        }
    }
    public WebElement getCountType() { return findWebElement(countTypeTab); }
}
