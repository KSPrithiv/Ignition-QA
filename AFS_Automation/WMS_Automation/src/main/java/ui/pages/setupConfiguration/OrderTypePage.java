package ui.pages.setupConfiguration;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class OrderTypePage extends BasePage {
    By orderTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order')]");
    public void orderTypeTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getOrder());
            clickOnElement(getOrder());
        } catch (Exception e) {
        }
    }
    public WebElement getOrder() { return findWebElement(orderTab); }
}
