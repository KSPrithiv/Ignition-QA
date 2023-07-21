package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class PalletTypePage extends BasePage {
    By palletTypeTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Count')]");
    public void palletTypeTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getPalletType());
            clickOnElement(getPalletType());
        } catch (Exception e) {
        }
    }
    public WebElement getPalletType() { return findWebElement(palletTypeTab); }
}
