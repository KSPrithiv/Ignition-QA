package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class LocationTypePage extends BasePage {
    By locationTypeTab=By.xpath("//div[@id='settingPage']/div[@class='row']//ul[@role='tablist']/li[4]/span[@class='k-link']");
    public void locationTypeTab() throws InterruptedException {

        try {
            Waiters.waitForElementToBeDisplay(getLocationType());
            clickOnElement(getLocationType());
        } catch (Exception e) {
        }
    }
    public WebElement getLocationType() { return findWebElement(locationTypeTab); }
}
