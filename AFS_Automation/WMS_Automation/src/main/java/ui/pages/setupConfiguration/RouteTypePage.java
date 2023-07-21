package ui.pages.setupConfiguration;
import common.utils.Waiters;
//import helper.HelpersMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
//import pages_DSD_OMS.badgeBuilder_Phase1.BadgeBuilderPage;
import ui.pages.BasePage;
//import helper.HelpersMethod;
import java.util.List;

public class RouteTypePage extends BasePage{
    By routeTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Route')]");
    public void routeTypeTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getRoute());
            clickOnElement(getRoute());
        } catch (Exception e) {
        }
    }
    public WebElement getRoute() { return findWebElement(routeTab); }

}
