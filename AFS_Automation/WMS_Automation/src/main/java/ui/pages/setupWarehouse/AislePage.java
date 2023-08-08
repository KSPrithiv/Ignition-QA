package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class AislePage extends BasePage {
    By aisleTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Aisle')]");
    public void aisleTab() throws InterruptedException {

//        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getAisle());
            clickOnElement(getAisle());
        } catch (Exception e) {
        }
    }
    public WebElement getAisle() { return findWebElement(aisleTab); }
}
