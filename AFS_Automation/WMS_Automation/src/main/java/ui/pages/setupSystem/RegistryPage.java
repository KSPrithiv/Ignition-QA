package ui.pages.setupSystem;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class RegistryPage extends BasePage {
    By registryTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Registry')]");



    public void registryTab()  {

        try {
            Waiters.waitForElementToBeDisplay(getRegistry());
            clickOnElement(getRegistry());
        } catch (Exception e) {
        }
    }
    public WebElement getRegistry() { return findWebElement(registryTab); }
}
