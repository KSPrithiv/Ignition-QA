package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class YardPage extends BasePage {
    By yardTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Yard')]");
    public void yardTab() {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getYard());
            clickOnElement(getYard());
        } catch (Exception e) {
        }
    }
    public WebElement getYard() { return findWebElement(yardTab); }
}
