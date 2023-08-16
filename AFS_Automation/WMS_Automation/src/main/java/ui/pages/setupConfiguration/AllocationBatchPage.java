package ui.pages.setupConfiguration;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class AllocationBatchPage extends BasePage {
    By allocationBatchTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Allocation')]");
    public void allocationBatchTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getAllocationBatch());
            clickOnElement(getAllocationBatch());
        } catch (Exception e) {
        }
    }
    public WebElement getAllocationBatch() { return findWebElement(allocationBatchTab); }
}
