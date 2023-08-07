package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class DockDoorPage extends BasePage {
    By dockDoorTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Dock')]");
    public void dockDoorTab() {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getDockDoor());
            clickOnElement(getDockDoor());
        } catch (Exception e) {
        }
    }
    public WebElement getDockDoor() { return findWebElement(dockDoorTab); }
}
