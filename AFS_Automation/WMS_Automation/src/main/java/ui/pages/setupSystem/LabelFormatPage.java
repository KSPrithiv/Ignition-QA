package ui.pages.setupSystem;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class LabelFormatPage extends BasePage{
    By labelFormatTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Label Format')]");

    public void labelFormatTab()  {

        try {
            Waiters.waitForElementToBeDisplay(getLabelFormat());
            clickOnElement(getLabelFormat());
        } catch (Exception e) {
        }
    }
    public WebElement getLabelFormat() { return findWebElement(labelFormatTab); }
}
