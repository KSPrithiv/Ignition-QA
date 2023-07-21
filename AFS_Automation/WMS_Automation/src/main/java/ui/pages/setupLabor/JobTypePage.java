package ui.pages.setupLabor;

import common.utils.Waiters;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import ui.pages.BasePage;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import util.RandomValues;

import java.sql.SQLOutput;
import java.util.List;

public class JobTypePage extends BasePage {
    WebDriver driver;
    public JobTypePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    By rowCode=By.xpath("//table[@class='k-grid-table']//tr[@class='k-master-row']");
    By rowCode=By.xpath("//table[@class='k-grid-table']//tr[@class='k-master-row'][1]");
    By deleteBtn=By.xpath("//button[@id='deleteSettingsButton']");
    By messageHeader=By.xpath("//h4[@class='modal-title']");
    By message=By.xpath("//div[@class='modal-body']");
    By cancelBtn=By.xpath("//button[@class='k-button k-button-icontext']");
    By deleteOKBtn=By.xpath("//button[@class='k-button k-primary k-button-icontext']");
    By table=By.xpath("//table[@class='k-grid-table']");
    By addFilterButton=By.xpath("//button[@class='k-button k-flat k-button-icontext  i-button--icon-only']");
    By editProductBtn=By.xpath("//button[@class='k-button k-flat k-button-icontext']");



    public void clickCode() {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeDisplay(rowCode);
        clickOnElement(rowCode);
    }
    public void clickDelete() {
        Waiters.waitForElementToBeDisplay(deleteBtn);
        clickOnElement(deleteBtn);
    }
    public void displayMessage(){
        Waiters.waitForElementToBeDisplay(messageHeader);
        String message1=getMessage().getText().trim();
        System.out.println("MESSAGE HEADER DISPLAYED AFTER CLICK ON DELETE BUTTON: "+message1);
        String actualHeaderMessage="Delete Record".trim();
        System.out.println(actualHeaderMessage);
//        Assert.assertEquals("The actual and expected message do not match",actualHeaderMessage,message1);
        if(actualHeaderMessage.equalsIgnoreCase(message1)){
            System.out.println("ACTUAL AND EXPECTED HEADER MESSAGES ARE SAME");
        }
        else {
            System.out.println("ACTUAL AND EXPECTED HEADER MESSAGES ARE NOT SAME");
        }
        String message2=getMessageBody().getText();
        System.out.println("MESSAGE BODY DISPLAYED AFTER CLICK ON DELETE BUTTON: "+message2);
        String actualBodyMessage="Are you sure you want to delete?";
        if(actualBodyMessage.equalsIgnoreCase(message2)){
            System.out.println("ACTUAL AND EXPECTED BODY MESSAGES ARE SAME");
        }
        else {
            System.out.println("ACTUAL AND EXPECTED BODY MESSAGES ARE NOT SAME");
        }
//        Assert.assertEquals("The actual and expected message do not match",actualBodyMessage,message2);

        Waiters.waitABit(4000);
    }

    public void clickCancel(){

            Waiters.waitForElementToBeDisplay(cancelBtn);
            clickOnElement(cancelBtn);
            Waiters.waitABit(4000);
            if(getRowcode().isDisplayed()){
                System.out.println("CANCELLED SUCCESSFULLY");
            }
    }
    public void deleteOK(){
        List<WebElement> rows1 = getTable().findElements(By.tagName("tr"));
        int rowCount1 = rows1.size();
        System.out.println("NUMBER OF ROWS BEFORE CLICK ON DELETE: "+rowCount1);
        Waiters.waitForElementToBeDisplay(deleteOKBtn);
        clickOnElement(deleteOKBtn);
        Waiters.waitABit(8000);
//        WebElement deletedCode=findWebElement(By.xpath("//table[@class='k-grid-table']//tr[@class='k-master-row']"));
//        WebElement deletedCode= driver.findElement(By.xpath("//table[@class='k-grid-table']//tr[@class='k-master-row']"));
        List<WebElement> rows = getTable().findElements(By.tagName("tr"));
        int rowCount = rows.size();
        System.out.println("NUMBER OF ROWS AFTER CLICK ON DELETE: "+rowCount);
        if(rowCount1>rowCount){
            System.out.println("DELETED SUCCESSFULLY");
        }
        else{
            System.out.println("DELETED UNSUCCESSFULLY");
        }
    }

    public WebElement getMessage() { return findWebElement(messageHeader); }
    public WebElement getMessageBody() { return findWebElement(message); }
    public WebElement getRowcode(){ return findWebElement(rowCode);}
    public WebElement getTable() { return findWebElement(table); }
    public boolean isAddFilterButtonEnabled() { return elementIsEnabled(addFilterButton); }
    public String isEditBtnDisabled() { return getElementAttribute(getEditBtn(), "aria-disabled"); }
    public WebElement getEditBtn() { return findWebElement(editProductBtn); }




}
