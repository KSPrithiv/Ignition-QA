package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class EquipmentChecklistPage extends BasePage{
    By equipmentChecklistTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Checklist')]");
    public void equipmentChecklistTab() {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getEquipmentChecklist());
            clickOnElement(getEquipmentChecklist());
        } catch (Exception e) {
        }
    }
    public WebElement getEquipmentChecklist() { return findWebElement(equipmentChecklistTab); }
}
