package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class ComapnyPage extends BasePage {
    By companyTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Company')]");
    public void companyTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getCompany());
            clickOnElement(getCompany());
        } catch (Exception e) {
        }
    }
    public WebElement getCompany() { return findWebElement(companyTab); }
}
