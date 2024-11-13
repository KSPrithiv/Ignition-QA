package pages_DSD_OMS.quote;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
//import org.joda.time.LocalDate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages_DSD_OMS.orderEntry.OrderEntryPage;

import java.awt.*;
import java.text.ParseException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @Project DSD_ERP
 * @Author Divya.Ramadas@afsi.com
 */

public class QuotePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;

    @FindBy(xpath = "//span[contains(@class,'k-icon k-i-arrow-60-down')]")
    private WebElement Downarrow;

    @FindBy(id = "quote-name")
    private WebElement QuoteName;

    @FindBy(xpath = "//label[contains(@id,'quoteEndDate-label')]/following-sibling::span/button")
    private WebElement EndCalender;

    @FindBy(id = "OkButton")
    private WebElement OkButton;

    public QuotePage(WebDriver driver, Scenario scenario)
    {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void EnterQuotName(String QName)
    {
        exists = false;
        WebElement WebEle;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'New quote')]/ancestor::div[contains(@class,'k-window k-dialog')]");
            if (WebEle.isDisplayed())
            {
                HelpersMethod.EnterText(driver, QuoteName, 10000, QName);
                scenario.log("QUOTE NAME IS " + QName);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ClickOnCalender()
    {
        exists = false;
        try
        {
            if (EndCalender.isDisplayed())
            {
                HelpersMethod.ActClick(driver, EndCalender, 10000);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void SelectEndDate() throws ParseException, InterruptedException, AWTException
    {
        exists = false;


//            LocalDate myDateObj = LocalDate.now().plusDays(2);
//            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
//            formattedDate1 = myDateObj.format(myFormatObj);
//            WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
//            HelpersMethod.waitTillElementDisplayed(driver, ele1, 1000000);
//            HelpersMethod.JSScroll(driver, ele1);
//            HelpersMethod.ClickBut(driver, ele1, 10000);
//            scenario.log("END DATE FOR QUOTE IS : " + formattedDate1);
//            exists = true;
//            Assert.assertEquals(exists, true);

            OrderEntryPage oepa=new OrderEntryPage(driver,scenario);
            String deliverydate=oepa.Read_DeliveryDate2();
            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("EEE, MMM d, yyyy");
            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");

            try
            {
                LocalDate myDateObj = LocalDate.parse(deliverydate,inputFormat);
                String formattedDate1 = myDateObj.format(outputFormat);

                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.waitTillElementDisplayed(driver, ele1, 1000000);
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ClickBut(driver, ele1, 10000);
                scenario.log("END DATE FOR QUOTE IS : " + formattedDate1);
            }
            catch (Exception e) {}
    }

    public void ClickOnOKButton()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//span[contains(text(),'New quote')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                HelpersMethod.ClickBut(driver, OkButton, 4000);
                exists = true;
                //handling loading icon
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {}
    }

    public void validateQuote()
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        WebElement modalContainer = driver.findElement(By.xpath("//span[contains(text(),'New quote')]/ancestor::div[contains(@class,'k-window k-dialog')]"));
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "New quote", "Verify Title message");
    }
}