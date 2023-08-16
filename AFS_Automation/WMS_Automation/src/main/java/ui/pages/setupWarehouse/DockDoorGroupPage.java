package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class DockDoorGroupPage extends BasePage{
    By dockDoorGroupTab=By.xpath("//div[@id='settingPage']/div[@class='row']//ul[@role='tablist']/li[9]/span[@class='k-link']");
    public void dockDoorGroupTab() {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getDockDoorGroup());
            clickOnElement(getDockDoorGroup());
        } catch (Exception e) {
        }
    }
    public WebElement getDockDoorGroup() { return findWebElement(dockDoorGroupTab); }
}
