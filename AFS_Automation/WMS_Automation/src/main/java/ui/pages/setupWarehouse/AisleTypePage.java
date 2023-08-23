package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class AisleTypePage extends BasePage {
    By aisleTypeTab=By.xpath("//div[@id='settingPage']/div[@class='row']//ul[@role='tablist']/li[4]/span[@class='k-link']");
    public void aisleTypeTab() throws InterruptedException {

//        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getAisleType());
            clickOnElement(getAisleType());
        } catch (Exception e) {
        }
    }
    public WebElement getAisleType() { return findWebElement(aisleTypeTab); }
}
