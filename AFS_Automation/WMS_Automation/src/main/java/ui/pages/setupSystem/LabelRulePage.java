package ui.pages.setupSystem;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class LabelRulePage extends BasePage {
    By labelRuleTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Label rule')]");



    public void labelRuleTab()  {

        try {
            Waiters.waitForElementToBeDisplay(getLabelRule());
            clickOnElement(getLabelRule());
        } catch (Exception e) {
        }
    }
    public WebElement getLabelRule() { return findWebElement(labelRuleTab); }
}
