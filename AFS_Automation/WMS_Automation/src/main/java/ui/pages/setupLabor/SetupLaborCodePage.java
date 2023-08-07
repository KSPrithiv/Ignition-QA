package ui.pages.setupLabor;

import common.utils.Waiters;

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

public class SetupLaborCodePage extends BasePage {
    public SetupLaborCodePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    WebDriver driver;

    SetupLaborCodePage setupLaborCodePage;

    By setupIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Setup']");
    By setupProductIcon = By.xpath("//div[contains(@id, 'accesscpwmssettingssystem')]//div[contains(text(), 'Labor')]");

//    By searchBox=By.xpath("//div[@class='i-search-box']");
    By searchBox=By.id("wmssetupsearch_57");
    By searchBox1=By.id("wmssetupsearch_58");
    By closeBtn=By.cssSelector("form > .i-icon.i-search-box__clear");
    By table=By.xpath("//table[@class='k-grid-table']");
    By message=By.xpath("//div[@class='i-no-data__message']");
    By message3=By.xpath("//div[@class='toast-message']");
    By jobType=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Job type')]");

    By addButton=By.xpath("//button[@class='k-button k-flat k-button-icontext  i-button--icon-only']");
    By codeText=By.xpath("//input[@class='k-textbox']");
    By userTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Users')]");

    By ddlUser = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    By saveBtn = By.xpath("//button[@class='k-button k-primary k-button-icontext']");
    By addFilterButton = By.cssSelector(".i-filter-tag__main__text--add");
    By codeFilter = By.xpath("//input[@id='JOBTYPE_CODE']");
//    By codeFilter = By.cssSelector("input#JOBTYPE_CODE");
    By codeFilterText=By.xpath("//input[@class='k-textbox']");
    By applyButton=By.xpath("//button[@type='submit']");
    By clearFilterButton = By.cssSelector(".i-filter-popup__footer__button.k-button.k-button-icontext.k-flat.k-primary");
    By userGroupFilter = By.xpath("//input[@id='USERGROUP_CODE']");
    By descriptionFilter = By.xpath("//input[@id='DESCRIPTION']");
    By laborStandardFilter = By.xpath("//input[@id='IS_LABORSTANDARD']");
    By laborStandard = By.xpath("//input[@id='textRadioButton2']");



    private static int count;
    private static int countUserGroup;
    private static int countDescription;
    private static int countLaborStandard;









    public void clickSetupIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getSetupIcon());
        clickOnElement(getSetupIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }
    public void clickSetupProductIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(setupProductIcon);
        clickOnElement(setupProductIcon);
    }
    public void searchBoxAction(){
        Waiters.waitABit(5000);
        Waiters.waitForPresenceOfElement("form > .i-icon.i-search-box__search");
        clickOnElement(searchBox);
        try {
            searchBox().sendKeys("A",Keys.ENTER);
            Waiters.waitABit(4000);
        } catch (Exception e) {
        }
    }


    public void closeIcon(){
        try{
            Waiters.waitABit(4000);
            clickOnElement(getClose());
        }catch (Exception e){}
        Waiters.waitABit(14000);
    }
    public void rownumber(){
        try {
            List<WebElement> rows = getTable().findElements(By.tagName("tr"));
            int rowCount = rows.size();
            System.out.println("TOTAL NUMBER OF ROWS: " + rowCount);

            boolean isResultCorrect = false;
            String searchKey = "A";
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    if (cell.getText().contains(searchKey)) {
                        isResultCorrect = true;
                        break;
                    }
                }
            }
            if (isResultCorrect) {
                System.out.println("DISPLAYED MATCHING ELEMENTS");

            } else {

                System.out.println("DISPLAYED NON MATCHING ELEMENTS");
            }
        }
        catch (Exception e) {
        }
        Waiters.waitABit(4000);
    }
    public void rownumber1(){
        try {
            List<WebElement> rows = getTable().findElements(By.tagName("tr"));
            int rowCount = rows.size();
            System.out.println("TOTAL NUMBER OF ROWS: " + rowCount);

            boolean isResultCorrect = true;
            String searchKey = "A";
//            String searchKey1="a";
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                boolean isRowMatch = false;
                for (WebElement cell : cells) {
                    String cellText = cell.getText();

                    if (cellText.toLowerCase().contains(searchKey.toLowerCase())) {
                        System.out.println("SEARCH KEYWORD FOUND: " + cellText);
                        isRowMatch = true;

                        break;
                    }
//                    if(cellText.equalsIgnoreCase(searchKey)){
//                        isResultCorrect = true;
//                        break;
//                    }
                }

                if (!isRowMatch) {
                    isResultCorrect = false;
                    break;
                }
            }
            if(isResultCorrect){
                System.out.println("DISPLAYED MATCHING ELEMENTS, ALL ROWS CONTAINS MATCHING RECORDS");

            } else {

                System.out.println("DISPLAYED NON MATCHING ELEMENTS, NOT ALL ROWS CONTAINS MATCHING RECORDS");
            }
        }
        catch (Exception e) {
        }

        Waiters.waitABit(4000);
    }
    public void verifyTablerows(){
        try {
            List<WebElement> rows = getTable().findElements(By.tagName("tr"));
            int rowCount = rows.size();
            System.out.println("TOTAL NUMBER OF ROWS: " + rowCount);
            Waiters.waitABit(6000);
//            System.out.println("TOTAL NUMBER OF ROWS AFTER CLICK ON CLOSE ICON: " );
//            clickOnElement(searchBox);
        }
        catch(Exception e){}
    }
    public void searchBoxAction2(){
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeClickable(searchBox());
        Waiters.waitForElementToBeDisplay(searchBox);
        clickOnElement(searchBox);
        try {
            searchBox().sendKeys("z",Keys.ENTER);
            Waiters.waitABit(4000);
            String message1=getMessage().getText();
            System.out.println("MESSAGE DISPLAYED AFTER ENTERING NON EXISTING KEYWORD: "+message1);
        } catch (Exception e) {
        }
    }
    public void jobtypeTab() throws InterruptedException {

        try{
            Waiters.waitUntilPageWillLoadedSelenide();
            Waiters.waitABit(10000);
            Waiters.waitForElementToBeDisplay(getJobType());
            Waiters.waitABit(2000);
            clickOnElement(getJobType());
        }catch (Exception e){}
    }
    public void addButton() {
        Waiters.waitABit(8000);
        Waiters.waitForPresenceOfElement("form > .i-icon.i-search-box__search");
        Waiters.waitForElementToBeDisplay(getAddButton());
        clickOnElement(getAddButton());
    }

        public void enterCode() {
            Waiters.waitABit(2000);
            Waiters.waitForElementToBeDisplay(getCodeText());
            getCodeText().clear();
            getCodeText().sendKeys("08@#$a2",Keys.ENTER);

    }
    public void usersTab(){
        clickOnElement(getuserTab());
        clickOnElement(getuserTab());
        Waiters.waitABit(4000);

    }
    public void selectUser() {
        try {
            Waiters.waitForElementToBeDisplay(getUserDropdown());
            clickOnElement(getUserDropdown());
            clickOnElement(findWebElement(By.xpath("/html/body[@class='dialog']//ul[@role='listbox']/li[1]//label")));
            getUserDropdown().click();
//            getSaveBtn().click();
            Waiters.waitABit(5000);
            refresh();
            Waiters.waitABit(5000);
        }catch (Exception e){}
    }
    public void selectUser1() {
        try {
            Waiters.waitForElementToBeDisplay(getUserDropdown());
            Waiters.waitABit(5000);

            clickOnElement(findWebElement(By.xpath("//span[@class='k-icon k-i-close']")));
            Waiters.waitABit(5000);

            clickOnElement(getUserDropdown());
            clickOnElement(findWebElement(By.xpath("/html/body[@class='dialog']//ul[@role='listbox']/li[2]//label")));
            getUserDropdown().click();
//            getSaveBtn().click();
//            Waiters.waitABit(5000);
//            refresh();
//            Waiters.waitABit(5000);
        }catch (Exception e){}
    }
    public void clickAddFilterButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(addFilterButton);
        clickOnElement(addFilterButton);
        Waiters.waitABit(2000);
    }
    public void countCodeFilter(){
        List<WebElement> rows = getTable().findElements(By.xpath(".//td[1]"));
        for(WebElement row:rows){
            String text = row.getText();
            if(text.contains("A")){
                count++;
            }
        }
        System.out.println("NUMBER OF CODES CONTAINS LETTER 'A' : "+count);
    }
    public void clickCodeFilter() {
        Waiters.waitForElementToBeDisplay(codeFilter);
        Waiters.waitABit(2000);
        clickOnElement(codeFilter);
    }
    public void enterFilterLetter() {
        Waiters.waitABit(7000);
        Waiters.waitForElementToBeDisplay(getCodeFilterText());
        getCodeFilterText().sendKeys("A");

    }
    public  void clickApply(){
        Waiters.waitABit(3000);
        clickOnElement(getApplyButton());
    }
    public void verifyCodeFilter(){
        Waiters.waitABit(5000);

        List<WebElement> rows = getTable().findElements(By.tagName("tr"));
        int rowCount2 = rows.size();
        System.out.println("NUMBER OF CODES CONTAINS LETTER 'A' AFTER APPLY FILTER: "+rowCount2);
        setupLaborCodePage = new SetupLaborCodePage(driver);
        if(rowCount2==count)
        {
            System.out.println("CODE FILTER WORKING SUCCESSFULLY");
        }
    }
    public void clearAllFilterButton(){
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(clearFilterButton);
        clickOnElement(clearFilterButton);
        Waiters.waitABit(2000);
        List<WebElement> rows = getTable().findElements(By.tagName("tr"));
        int rowCount3 = rows.size();
        System.out.println("TOTAL NUMBER OF ROWS AFTER CLICK ON CLEAR ALL BUTTON: " + rowCount3);
        setupLaborCodePage = new SetupLaborCodePage(driver);
        if(rowCount3>=count){
            System.out.println("CLEAR ALL BUTTON IS WORKING FINE");
        }
    }
    public void clickUsergroupFilter(){
        Waiters.waitForElementToBeDisplay(userGroupFilter);
        Waiters.waitABit(2000);
        clickOnElement(userGroupFilter);
    }
    public void countUserGroup(){
        List<WebElement> rows = getTable().findElements(By.xpath(".//td[2]"));
//        System.out.println("ROWS TOTAL"+rows);
//        int count=0;
        for(WebElement row:rows){
            String text = row.getText();
            if(text.contains("a")){
                countUserGroup++;
            }
        }
        System.out.println("NUMBER OF USERGROUPS CONTAINS LETTER 'A' : "+countUserGroup);
    }
    public void verifyUserGroupFilter(){
        Waiters.waitABit(5000);
        List<WebElement> rows = getTable().findElements(By.tagName("tr"));
        int rowCount3 = rows.size();
        System.out.println("NUMBER OF USERGROUP CONTAINS LETTER 'A' AFTER APPLY FILTER: "+rowCount3);
        setupLaborCodePage = new SetupLaborCodePage(driver);
        if(rowCount3==countUserGroup)
        {
            System.out.println("USERGROUP FILTER WORKING SUCCESSFULLY");
        }
    }
    public void countDescription(){
        List<WebElement> rows = getTable().findElements(By.xpath(".//td[3]"));
        for(WebElement row:rows){
            String text = row.getText();
            if(text.contains("a")){
                countDescription++;
            }
        }
        System.out.println("NUMBER OF DESCRIPTION CONTAINS LETTER 'A' : "+countDescription);
    }
    public void clickDescriptionFilter(){
        Waiters.waitForElementToBeDisplay(descriptionFilter);
        Waiters.waitABit(2000);
        clickOnElement(descriptionFilter);
    }
    public void verifyDescriptionFilter(){
        Waiters.waitABit(5000);
        List<WebElement> rows = getTable().findElements(By.tagName("tr"));
        int rowCount4 = rows.size();
        System.out.println("NUMBER OF DESCRIPTIONS CONTAINS LETTER 'A' AFTER APPLY FILTER: "+rowCount4);
        setupLaborCodePage = new SetupLaborCodePage(driver);
        if(rowCount4==countDescription)
        {
            System.out.println("DESCRIPTION FILTER WORKING SUCCESSFULLY");
        }
    }
    public void countLaborStandard(){
        List<WebElement> rows = getTable().findElements(By.xpath(".//td[4]"));
        for(WebElement row:rows){
            String text = row.getText();
            if(text.contains("N")){
                countLaborStandard++;
            }
        }
        System.out.println("NUMBER OF LABOR STANDARD CONTAINS 'No' : "+countLaborStandard);
    }
    public void clickLaborStandardFilter(){
        Waiters.waitForElementToBeDisplay(laborStandardFilter);
        Waiters.waitABit(2000);
        clickOnElement(laborStandardFilter);
    }
    public void clickLaborStandared(){
        Waiters.waitForElementToBeDisplay(laborStandard);
        Waiters.waitABit(2000);
        clickOnElement(laborStandard);
    }
    public void verifyLaborStandardFilter(){
        Waiters.waitABit(5000);
        List<WebElement> rows = getTable().findElements(By.tagName("tr"));
        int rowCount5 = rows.size();
        System.out.println("NUMBER OF LABOR STANDARD CONTAINS 'No' AFTER APPLY FILTER: "+rowCount5);
        setupLaborCodePage = new SetupLaborCodePage(driver);
        if(rowCount5==countLaborStandard)
        {
            System.out.println("LABOR STANDARD FILTER WORKING SUCCESSFULLY");
        }
    }
    public void searchBoxActionJobType(){
        Waiters.waitABit(8000);
//        Waiters.waitForElementToBeClickable(searchBox1());
        Waiters.waitForElementToBeDisplay(searchBox1);
        clickOnElement(searchBox1);
        try {
            searchBox1().sendKeys("A",Keys.ENTER);
            Waiters.waitABit(4000);
        } catch (Exception e) {
        }
    }
    public void searchBoxAction3(){
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeClickable(searchBox1());
        Waiters.waitForElementToBeDisplay(searchBox1);
        clickOnElement(searchBox1);
        try {
            searchBox1().sendKeys("z",Keys.ENTER);
            Waiters.waitABit(4000);
            String message2=getMessage().getText();
            System.out.println("MESSAGE DISPLAYED AFTER ENTERING NON EXISTING KEYWORD: "+message2);
        } catch (Exception e) {
        }
    }
    public void enterSave(){
        Waiters.waitABit(8000);
        getSaveBtn().click();
        String message3=getMessage3().getText();
        System.out.println("MESSAGE DISPLAYED: "+message3);

    }
//    public void quit(){
//        quit();
//    }
    public void enterCode2() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getCodeText());
        getCodeText().sendKeys("00@$a2",Keys.ENTER);

    }


    public WebElement getSetupIcon() { return findWebElement(setupIcon); }
    public WebElement getTable() { return findWebElement(table); }
    public WebElement searchBox() { return findWebElement(searchBox); }
    public WebElement searchBox1() { return findWebElement(searchBox1); }

    public WebElement getClose() { return findWebElement(closeBtn); }
    public WebElement getMessage() { return findWebElement(message); }
    public WebElement getMessage3() { return findWebElement(message3); }

    public WebElement getJobType() { return findWebElement(jobType); }
    public WebElement getAddButton() { return findWebElement(addButton); }
    public WebElement getCodeText() { return findWebElement(codeText); }
    public WebElement getuserTab() { return findWebElement(userTab); }
    public WebElement getUserDropdown() { return findWebElement(ddlUser); }
    public WebElement getSaveBtn() { return findWebElement(saveBtn); }
    public WebElement getCodeFilter() { return findWebElement(codeFilter); }
    public WebElement getCodeFilterText() { return findWebElement(codeFilterText); }
    public WebElement getApplyButton() { return findWebElement(applyButton); }








//    public WebElement getRows() { return findWebElement(rows); }
}
