package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class RackTypePage extends BasePage {
    By rackTypeTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Rack')]");
    public void rackTypeTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getRackType());
            clickOnElement(getRackType());
        } catch (Exception e) {
        }
    }
    public WebElement getRackType() { return findWebElement(rackTypeTab); }
}
