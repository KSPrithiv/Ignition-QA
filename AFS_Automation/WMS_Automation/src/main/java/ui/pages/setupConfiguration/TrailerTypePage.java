package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
public class TrailerTypePage extends BasePage {
    By trailerTypeTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Trailer type')]");
    public void trailerTypeTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getTrailerType());
            clickOnElement(getTrailerType());
        } catch (Exception e) {
        }
    }
    public WebElement getTrailerType() { return findWebElement(trailerTypeTab); }
}
