package ui.pages.setupLabor;

import common.utils.Waiters;
import gherkin.lexer.He;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BasePage;


public class FatiguePage extends BasePage {
    By fatigueTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Fatigue')]");
    By searchBox5=By.id("wmssetupsearch_60");
     By message=By.xpath("//div[@class='i-no-data__message']");



    public void fatigueTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getFatigue());
            clickOnElement(getFatigue());
        } catch (Exception e) {
        }
    }
    public void searchBoxActionFatigue(){
//        Waiters.waitABit(5000);
        Waiters.waitForElementToBeDisplay(By.cssSelector("form > .i-icon.i-search-box__search"));
        Waiters.waitForElementToBeDisplay(searchBox5());
        clickOnElement(searchBox5);
        try {
            searchBox5().sendKeys("2", Keys.ENTER);
//            Waiters.waitABit(4000);
        } catch (Exception e) {
        }
    }
    public void searchBoxAction5(){
//        Waiters.waitABit(5000);
        Waiters.waitForElementToBeClickable(searchBox5());
        Waiters.waitForElementToBeDisplay(searchBox5);
        clickOnElement(searchBox5);
        try {
            searchBox5().sendKeys("z",Keys.ENTER);
//            Waiters.waitABit(4000);
            String message2=getMessage().getText();
            System.out.println("MESSAGE DISPLAYED AFTER ENTERING NON EXISTING KEYWORD: "+message2);
        } catch (Exception e) {
        }
    }
    public WebElement getFatigue() { return findWebElement(fatigueTab); }
    public WebElement searchBox5() { return findWebElement(searchBox5);}
    public WebElement getMessage() { return findWebElement(message); }
}
