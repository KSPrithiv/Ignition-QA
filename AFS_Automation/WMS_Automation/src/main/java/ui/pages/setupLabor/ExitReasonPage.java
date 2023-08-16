package ui.pages.setupLabor;
import common.utils.Waiters;
import gherkin.lexer.He;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.List;

public class ExitReasonPage extends BasePage {
    By exitTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Exit')]");
    By searchBox7=By.id("wmssetupsearch_63");
    By message=By.xpath("//div[@class='i-no-data__message']");
    By table=By.xpath("//table[@class='k-grid-table']");

    public void exitTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getExit());
            clickOnElement(getExit());
        } catch (Exception e) {
        }
    }
    public void searchBoxActionExit(){
//        Waiters.waitABit(5000);
        Waiters.waitForPresenceOfElement("form > .i-icon.i-search-box__search");
        Waiters.waitForElementToBeDisplay(searchBox7());
        clickOnElement(searchBox7);
        try {
            searchBox7().sendKeys("A", Keys.ENTER);
//            Waiters.waitABit(4000);
        } catch (Exception e) {
        }
    }
    public void searchBoxAction7(){
//        Waiters.waitABit(5000);
        Waiters.waitForElementToBeClickable(searchBox7());
        Waiters.waitForElementToBeDisplay(searchBox7);
        clickOnElement(searchBox7);
        try {
            searchBox7().sendKeys("z",Keys.ENTER);
//            Waiters.waitABit(4000);
            String message3=getMessage().getText();
            System.out.println("MESSAGE DISPLAYED AFTER ENTERING NON EXISTING KEYWORD: "+message3);
        } catch (Exception e) {
        }
    }
    public void rownumberExit(){
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

    public void rownumberExit1(){
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
    public WebElement getExit() { return findWebElement(exitTab); }
    public WebElement searchBox7() { return findWebElement(searchBox7);}
    public WebElement getMessage() { return findWebElement(message); }
    public WebElement getTable() { return findWebElement(table); }
}
