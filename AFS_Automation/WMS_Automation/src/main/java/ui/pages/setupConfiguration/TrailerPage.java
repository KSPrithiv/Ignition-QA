package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class TrailerPage extends BasePage {
    By trailerTab=By.xpath("/html//div[@id='settingPage']/div[@class='row']//ul[@role='tablist']/li[6]/span[@class='k-link']");
    public void trailerTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getTrailer());
            clickOnElement(getTrailer());
        } catch (Exception e) {
        }
    }
    public WebElement getTrailer() { return findWebElement(trailerTab); }
}
