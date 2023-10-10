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

import java.util.List;

public class ShiftPage extends BasePage {
    By shiftTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Shift')]");
    By searchBox6=By.id("wmssetupsearch_62");
    By message=By.xpath("//div[@class='i-no-data__message']");
    By table=By.xpath("//table[@class='k-grid-table']");

    public void shiftTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getShift());
            clickOnElement(getShift());
        } catch (Exception e) {
        }
    }
    public void searchBoxActionShift(){
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeDisplay(By.cssSelector("form > .i-icon.i-search-box__search"));
        Waiters.waitForElementToBeDisplay(searchBox6());
        clickOnElement(searchBox6);
        try {
            searchBox6().sendKeys("A", Keys.ENTER);
            Waiters.waitABit(4000);
        } catch (Exception e) {
        }
    }
    public void searchBoxAction6(){
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeClickable(searchBox6());
        Waiters.waitForElementToBeDisplay(searchBox6);
        clickOnElement(searchBox6);
        try {
            searchBox6().sendKeys("z",Keys.ENTER);
            Waiters.waitABit(4000);
            String message3=getMessage().getText();
            System.out.println("MESSAGE DISPLAYED AFTER ENTERING NON EXISTING KEYWORD: "+message3);
        } catch (Exception e) {
        }
    }
    public void rownumberShift(){
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
    public void rownumberShift1(){
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
    public WebElement getShift() { return findWebElement(shiftTab); }
    public WebElement searchBox6() { return findWebElement(searchBox6);}
    public WebElement getMessage() { return findWebElement(message); }
    public WebElement getTable() { return findWebElement(table); }

}


