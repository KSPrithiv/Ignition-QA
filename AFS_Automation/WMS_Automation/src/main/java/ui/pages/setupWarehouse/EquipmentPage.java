package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class EquipmentPage extends BasePage {
    By equipmentTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Equipment')]");
    public void equipmentTab() {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getEquipment());
            clickOnElement(getEquipment());
        } catch (Exception e) {
        }
    }
    public WebElement getEquipment() { return findWebElement(equipmentTab); }
}


