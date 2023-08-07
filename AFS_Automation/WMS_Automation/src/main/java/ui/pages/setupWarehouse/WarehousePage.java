package ui.pages.setupWarehouse;
import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

public class WarehousePage extends BasePage{
    By setupWarehouse = By.xpath("//div[contains(@id, 'accesscpwmssettingssystem')]//div[contains(text(), 'Warehouse')]");
    By warehouseTab=By.xpath("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Warehouse')]");
    By searchBox6=By.xpath("//input[@class='i-search-box__input']");
    By table=By.xpath("//table[@class='k-grid-table']");
    By message=By.xpath("//div[@class='i-no-data__message']");




    public void clickSetupWarehouse() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(setupWarehouse);
        clickOnElement(setupWarehouse);
    }
    public void warehouseTab() throws InterruptedException {

        Waiters.waitUntilPageWillLoadedSelenide();
        try {
//            Waiters.waitABit(7000);
            Waiters.waitForElementToBeDisplay(getWarehouse());
            clickOnElement(getWarehouse());
        } catch (Exception e) {
        }
    }
    public void searchBoxActionWarehouse(){
//        Waiters.waitABit(8000);
        Waiters.waitForPresenceOfElement("form > .i-icon.i-search-box__search");
        Waiters.waitForElementToBeDisplay(searchBox6());
        clickOnElement(searchBox6);
        try {
            searchBox6().sendKeys("A", Keys.ENTER);
//            Waiters.waitABit(4000);
        } catch (Exception e) {
        }
    }
    public void rownumber(){
        try {
            List<WebElement> rows = getTable().findElements(By.tagName("tr"));
            int rowCount = rows.size();
            System.out.println("TOTAL NUMBER OF ROWS: " + rowCount);

            boolean isResultCorrect = false;
            String searchKey = "A";
//            String searchKey1="a";
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    String cellText=cell.getText();

                    if (cell.getText().contains(searchKey)) {
                        System.out.println("SEARCH KEYWORD FOUND: "+cellText);

                        isResultCorrect = true;
                        break;
                    }
//                    if(cellText.equalsIgnoreCase(searchKey)){
//                        isResultCorrect = true;
//                        break;
//                    }
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

//        Waiters.waitABit(4000);
    }
    public void searchBoxAction6(){
//        Waiters.waitABit(5000);
        Waiters.waitForElementToBeClickable(searchBox6());
        Waiters.waitForElementToBeDisplay(searchBox6);
        clickOnElement(searchBox6);
        try {
            searchBox6().sendKeys("zzzzzz",Keys.ENTER);
//            Waiters.waitABit(4000);
            String message2=getMessage().getText();
            System.out.println("MESSAGE DISPLAYED AFTER ENTERING NON EXISTING KEYWORD: "+message2);
        } catch (Exception e) {
        }
    }

    public WebElement getWarehouse() { return findWebElement(warehouseTab); }
    public WebElement searchBox6() { return findWebElement(searchBox6);}
    public WebElement getTable() { return findWebElement(table); }
    public WebElement getMessage() { return findWebElement(message); }
}
