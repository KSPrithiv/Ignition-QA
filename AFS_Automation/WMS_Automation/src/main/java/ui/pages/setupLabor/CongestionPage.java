package ui.pages.setupLabor;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.BasePage;

import java.util.List;

public class CongestionPage extends BasePage {
    WebDriver driver;

    public CongestionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    By searchBox4=By.xpath("//div[@class='i-search-box']");
    By searchBox4=By.id("wmssetupsearch_59");
    By table=By.xpath("//table[@class='k-grid-table']");
    By message=By.xpath("//div[@class='i-no-data__message']");
    By congestionTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Congestion')]");



    public void searchBoxActionCongestion(){
        Waiters.waitABit(5000);

        Waiters.waitForPresenceOfElement("form > .i-icon.i-search-box__search");
//        Waiters.waitForElementToBeDisplay(searchBox4());
        clickOnElement(searchBox4);
        try {
            searchBox4().sendKeys("2", Keys.ENTER);
            Waiters.waitABit(4000);
        } catch (Exception e) {
        }
    }

    public void rownumber(){
        try {
            List<WebElement> rows = getTable().findElements(By.tagName("tr"));
            int rowCount = rows.size();
            System.out.println("TOTAL NUMBER OF ROWS: " + rowCount);

            boolean isResultCorrect = false;
            String searchKey = "2";
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
            String searchKey = "2";
//            String searchKey1="a";
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                boolean isRowMatch = false;
                for (WebElement cell : cells) {
                    String cellText = cell.getText();

                    if (cellText.toLowerCase().contains(searchKey.toLowerCase())) {
//                        System.out.println("SEARCH KEYWORD FOUND: " + cellText);
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
    public void searchBoxAction4(){
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeClickable(searchBox4());
        Waiters.waitForElementToBeDisplay(searchBox4);
        clickOnElement(searchBox4);
        try {
            searchBox4().sendKeys("z",Keys.ENTER);
            Waiters.waitABit(4000);
            String message2=getMessage().getText();
            System.out.println("MESSAGE DISPLAYED AFTER ENTERING NON EXISTING KEYWORD: "+message2);
        } catch (Exception e) {
        }
    }
    public void congestionTab() throws InterruptedException {
//        Waiters.waitUntilPageWillLoadedSelenide();
        try{
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getCongestion());
//            Waiters.waitABit(2000);
            clickOnElement(getCongestion());
        }catch (Exception e){}
    }
    public WebElement searchBox4() { return findWebElement(searchBox4);}
    public WebElement getTable() { return findWebElement(table); }
    public WebElement getMessage() { return findWebElement(message); }
    public WebElement getCongestion() { return findWebElement(congestionTab); }
}
