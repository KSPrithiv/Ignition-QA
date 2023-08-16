package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class LocationPage extends BasePage {
    By locationTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Location')]");
    By locationIcon=By.cssSelector(".i-button--icon-only.i-indexfield-container__main__button.k-button.k-button-icontext.k-outline > .i-icon");
    public void locationTab() {

        try {
//             Waiters.waitABit(5000);
             Waiters.waitForElementToBeDisplay(getlocationTab());
             clickOnElement(getlocationTab());
        } catch (Exception e) {
        }
    }
    public void locationSearchIcon(){
        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitForElementToBeDisplay(getLocation());
            clickOnElement(getLocation());
        } catch (Exception e) {
        }

    }
    public WebElement getlocationTab(){return findWebElement(locationTab);}
    public WebElement getLocation() { return findWebElement(locationIcon); }
}
