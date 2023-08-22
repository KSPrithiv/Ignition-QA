package ui.pages.setupSystem;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class LabelFilePage extends BasePage {
    By labelFileTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Label File')]");

    public void labelFileTab()  {

        try {
            Waiters.waitForElementToBeDisplay(getLabelFile());
            clickOnElement(getLabelFile());
        } catch (Exception e) {
        }
    }
    public WebElement getLabelFile() { return findWebElement(labelFileTab); }

}
