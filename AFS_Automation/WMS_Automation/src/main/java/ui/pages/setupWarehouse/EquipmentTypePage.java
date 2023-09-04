package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class EquipmentTypePage extends BasePage {
    By equipmentTypeTab=By.xpath("//div[@id='settingPage']/div[@class='row']//ul[@role='tablist']/li[12]/span[@class='k-link']");
    public void equipmentTypeTab() {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getEquipmentType());
            clickOnElement(getEquipmentType());
        } catch (Exception e) {
        }
    }
    public WebElement getEquipmentType() { return findWebElement(equipmentTypeTab); }
}
