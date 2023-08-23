package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ui.pages.BasePage;

public class TaskGroupPage extends BasePage{
    By taskGroupTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Task')]");
    By codeText=By.xpath("//input[@class='k-textbox']");
    By descriptionText=By.xpath("//input[@id='REMARKS']");
    By addProductBtn = By.xpath("//div[@class='i-toolbar-container ']//button[contains(@class, 'k-button-icontext') and position()=1]");
    By editProductBtn = By.xpath("//div[@class='i-toolbar-container ']//button[contains(@class, 'k-button-icontext') and position()=2]");
    By deleteProductBtn = By.xpath("//div[@class='i-toolbar-container ']//button[contains(@class, 'k-button-icontext') and position()=3]");

    By searchField=By.xpath("//input[@class='i-search-box__input']");
    By itemFoundField=By.xpath("//span[@class='i-summary-area__main__label']");
    By addFilterbtn=By.xpath("//button[@class='i-filter-tag__main']");




    public void taskGroupTab() throws InterruptedException {

//        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
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
    public void verify(){
        if(getSearchField().isDisplayed()) {
            System.out.println("DISPLAYED");
        }else {
            System.out.println("NOT DISPLAYED");
        }
            Assert.assertTrue(getSearchField().isDisplayed(),"Search field is not displayed");
    }

    public WebElement getTaskGroup() { return findWebElement(taskGroupTab); }
    public WebElement getCodeText() { return findWebElement(codeText); }
    public WebElement getDescriptionText() { return findWebElement(descriptionText); }
    public WebElement getAddBtn() { return findWebElement(addProductBtn); }
    public WebElement getEditBtn() { return findWebElement(editProductBtn); }
    public WebElement getDeleteBtn() { return findWebElement(deleteProductBtn); }
    public WebElement getSearchField() { return findWebElement(searchField); }
    public WebElement getItemFoundField() { return findWebElement(itemFoundField); }
    public WebElement getAddFilterd() { return findWebElement(addFilterbtn); }


    public String checkAddBtnDisabled() { return checkElementAttribute(getAddBtn(), "aria-disabled"); }
    public String isEditBtnDisabled() { return getElementAttribute(getEditBtn(), "aria-disabled"); }
    public String isDeleteBtnDisabled() { return getElementAttribute(getDeleteBtn(), "aria-disabled"); }
    public boolean isSearchFieldDisplayed() { return isElementDisplay(getSearchField()); }
    public boolean isItemFoundDisplayed() { return isElementDisplay(getItemFoundField()); }
    public boolean isAddFilterDisplayed() { return isElementDisplay(getAddFilterd()); }
    public WebElement gettaskGroup() { return findWebElement(taskGroupTab); }

}
