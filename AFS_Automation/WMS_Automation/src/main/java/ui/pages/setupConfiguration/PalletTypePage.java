package ui.pages.setupConfiguration;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import ui.pages.setupLabor.SetupLaborCodePage;

import java.util.List;

import static utilWMS.TestBase.driver;

public class PalletTypePage extends BasePage {
    WebDriver driver;

    SetupLaborCodePage setupLaborCodePage;
    private static int countMoveInventory;
    private static int countDescription;


    By palletTypeTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Pallet')]");
    By saveBtn = By.xpath("//button[@class='k-button k-primary k-button-icontext']");

    By textDescription=By.xpath("//input[@placeholder='Description']");
    By message=By.xpath("//div[@class='toast-message']");
    By table=By.xpath("//table[@class='k-grid-table']");
    By codeFilter = By.xpath("//input[@id='PALLETTYPE_CODE']");
    By moveInventoryFilter = By.xpath("//input[@id='ALLOW_INVENTORYMOVE']");
    By moveInventory = By.xpath("//input[@id='textRadioButton2']");



    public void palletTypeTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getPalletType());
            clickOnElement(getPalletType());
        } catch (Exception e) {
        }
    }
    public void save(){
        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getSaveBtn());
            clickOnElement(getSaveBtn());
        } catch (Exception e) {
        }
    }
    public void enterDescription() {
//        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDescription());
        getDescription().sendKeys("Description", Keys.ENTER);


    }
    public void message(){
        try {
            Waiters.waitForElementToBeDisplay(getMessage());
            String message1=getMessage().getText();
            System.out.println("MESSAGE DISPLAYED AFTER ENTERING DUPLICATE CODE: "+message1);
        } catch (Exception e) {
        }
    }

    public void clicklastRow() {
//        WebElement table= driver.get().findElement(By.xpath("//table[@class='k-grid-table']"));
        List<WebElement> rows= getTable().findElements(By.tagName("tr"));
        if(!rows.isEmpty()){
            WebElement lastRow=rows.get(rows.size()-1);
            lastRow.click();
        }
    }
    public void clickCodeFilter() {
        Waiters.waitForElementToBeDisplay(codeFilter);
//        Waiters.waitABit(2000);
        clickOnElement(codeFilter);
    }
    public void clickMoveInventoryFilter(){
        Waiters.waitForElementToBeDisplay(moveInventoryFilter);
        clickOnElement(moveInventoryFilter);
    }
    public void countMoveInventory(){
        List<WebElement> rows = getTable().findElements(By.xpath(".//td[3]"));
        for(WebElement row:rows){
            String text = row.getText();
            if(text.contains("N")){
                countMoveInventory++;
            }
        }
        System.out.println("NUMBER OF MOVE INVENTORY CONTAINS 'No' : "+countMoveInventory);
    }
    public void verifyMoveInventoryFilter(){
        Waiters.waitABit(5000);
        List<WebElement> rows = getTable().findElements(By.tagName("tr"));
        int rowCount5 = rows.size();
        System.out.println("NUMBER OF MOVE INVENTORY CONTAINS 'No' AFTER APPLY FILTER: "+rowCount5);
        setupLaborCodePage = new SetupLaborCodePage(driver);
        if(rowCount5==countMoveInventory)
        {
            System.out.println("MOVE INVENTORY FILTER WORKING SUCCESSFULLY");
        }
    }
    public void clickMoveInventory(){
        Waiters.waitForElementToBeDisplay(moveInventory);
        clickOnElement(moveInventory);
    }
    public void countDescription(){
        List<WebElement> rows = getTable().findElements(By.xpath(".//td[2]"));
        for(WebElement row:rows){
            String text = row.getText();
            if(text.contains("A")){
                countDescription++;
            }
        }
        System.out.println("NUMBER OF DESCRIPTION CONTAINS LETTER 'A' : "+countDescription);
    }

    public WebElement getPalletType() { return findWebElement(palletTypeTab); }
    public WebElement getSaveBtn() { return findWebElement(saveBtn); }
    public WebElement getDescription() { return findWebElement(textDescription); }
    public WebElement getMessage() { return findWebElement(message); }
    public WebElement getTable() { return findWebElement(table); }



}
