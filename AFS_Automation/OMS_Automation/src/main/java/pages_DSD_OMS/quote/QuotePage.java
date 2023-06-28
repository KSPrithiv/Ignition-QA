package pages_DSD_OMS.quote;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Project DSD_ERP
 * @Author Divya.Ramadas@afsi.com
 */

public class QuotePage {
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;

    @FindBy(xpath = "//span[contains(@class,'k-icon k-i-arrow-60-down')]")
    private WebElement Downarrow;

    @FindBy(id = "quote-name")
    private WebElement QuoteName;

    @FindBy(xpath = "//label[contains(@id,'quoteEndDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]")
    private WebElement EndCalender;

    @FindBy(id = "OkButton")
    private WebElement Ok_Button;

    public QuotePage(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void EnterQuotName(String QName) {
        exists = false;
        WebElement WebEle;
        try {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'New quote')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            if (WebEle.isDisplayed()) {
                HelpersMethod.EnterText(driver, QuoteName, 10, QName);
                scenario.log("QUOTE NAME IS " + QName);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ClickOnCalender() {
        exists = false;
        try {
            if (EndCalender.isDisplayed()) {
                HelpersMethod.ActClick(driver, EndCalender, 4);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void SelectEndDate() {
        exists = false;
        String formattedDate1 = null;
        try {
            LocalDate myDateObj = LocalDate.now().plusDays(4);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            formattedDate1 = myDateObj.format(myFormatObj);
            WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
            HelpersMethod.waitTillElementDisplayed(driver, ele1, 4);
            HelpersMethod.JSScroll(driver, ele1);
            HelpersMethod.ClickBut(driver, ele1, 6);
            scenario.log("END DATE FOR QUOTE IS : " + formattedDate1);
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }

    }

    public void ClickOnOKButton() {
        exists = false;
        WebElement WebEle;
        try {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'New quote')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            if (WebEle.isDisplayed()) {
                HelpersMethod.ClickBut(driver, Ok_Button, 20);
                exists = true;
                //handling loading icon
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                if (WebEle.isDisplayed()) {
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
                }
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void validateQuote() {
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'New quote')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "New quote", "Verify Title message");
    }
}