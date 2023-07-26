package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class TaskGroupPage extends BasePage{
    By taskGroupTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Task')]");
    By codeText=By.xpath("//input[@class='k-textbox']");
    By descriptionText=By.xpath("//input[@id='REMARKS']");



    public void taskGroupTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getTaskGroup());
            clickOnElement(getTaskGroup());
        } catch (Exception e) {
        }
    }

    public void enterCode() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getCodeText());
        getCodeText().sendKeys("000ABC", Keys.ENTER);
    }
    public void enterDescription() {
        Waiters.waitABit(2000);
        getDescriptionText().sendKeys("ABCD", Keys.ENTER);
    }
    public WebElement getTaskGroup() { return findWebElement(taskGroupTab); }
    public WebElement getCodeText() { return findWebElement(codeText); }
    public WebElement getDescriptionText() { return findWebElement(descriptionText); }


}
