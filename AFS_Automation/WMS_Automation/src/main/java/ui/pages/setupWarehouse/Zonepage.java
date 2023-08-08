package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class Zonepage extends BasePage {
    By zoneTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Zone')]");
    public void zoneTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getZone());
            clickOnElement(getZone());
        } catch (Exception e) {
        }
    }
    public WebElement getZone() { return findWebElement(zoneTab); }
}
