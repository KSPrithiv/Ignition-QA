package ui.pages.setupSystem;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class PermissionPage extends BasePage{
    By permissionTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Permission')]");



    public void permissionTab()  {

        try {
            Waiters.waitForElementToBeDisplay(getpermission());
            clickOnElement(getpermission());
        } catch (Exception e) {
        }
    }
    public WebElement getpermission() { return findWebElement(permissionTab); }
}
