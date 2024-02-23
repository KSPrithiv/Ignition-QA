package ui.pages;

import common.utils.Waiters;
import helper.HelpersMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.setup.DriverManager.getDriver;
import static helper.HelpersMethod.JScriptClick;
import org.openqa.selenium.Keys;

public class LoginPage extends BasePage {
  //  By login = By.cssSelector("input[placeholder='User name']");
    By login = By.cssSelector("input[placeholder='UserName']");
    By password = By.cssSelector("input[type='password']");
    // By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    By signInButton = By.xpath("//button[contains(text(), 'Sign In')]");

    //JIRA purpose
    By loginJIRA = By.xpath("//input[@id='login-form-username']");
    By passwordJIRA = By.xpath("//input[@id='login-form-password']");
    // By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    By signInButtonJIRA = By.xpath("//input[@id='login-form-submit']");
    By issuesTab = By.xpath("//a[@id='find_link']");

    By importIssuesOption = By.xpath("//a[@id='bulk_create_dd_link_lnk']");

    By importButton = By.xpath("//div[@class='file-input-list']/div/label/following-sibling::input[@type='file']");

    By NextButton = By.xpath("//button[@id='nextButton']");

    By ProjectNameToExport = By.xpath("//input[@id='CSV-select-field']");

    By loader = By.cssSelector(".loader");
    //==========================================================
    By notificationWrongSignIn = By.cssSelector("div[id='errorValidation'] div[class='i-notification-text'] div");


    public void waitForLoginPageToLoad() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getSignInButton());
        Waiters.waitForElementToBeDisplay(login);
        Waiters.waitForElementToBeDisplay(password);
        Waiters.waitABit(5000);
    }

    public void fillInLoginField(String login) {
        Waiters.waitForElementToBeDisplay(getLoginField());
        inputText(getLoginField(), login);
    }

    public void fillInPasswordField(String password) {
        Waiters.waitForElementToBeDisplay(getPasswordField());
        inputText(getPasswordField(), password);
    }

    public void clickSignIn() {
        Waiters.waitForElementToBeClickable(getSignInButton());
        clickOnElement(getSignInButton());
    }


    //JIRA ====================================================
    public void fillInLoginFieldJIRA(String login) {
        Waiters.waitForElementToBeDisplay(getLoginFieldJIRA());
        inputText(getLoginFieldJIRA(), login);
    }

    public void fillInPasswordFieldJIRA(String password) {
        Waiters.waitForElementToBeDisplay(getPasswordFieldJIRA());
        inputText(getPasswordFieldJIRA(), password);
    }

    public void clickSignInJIRA() {
        Waiters.waitForElementToBeClickable(getSignInButtonJIRA());
        clickOnElement(getSignInButtonJIRA());
    }

    public void importJIRATicket() throws InterruptedException {
        Waiters.waitForElementToBeDisplay(getimportButton());
        getimportButton().sendKeys("C:\\Users\\karthikeyan.Armugam\\Documents\\Testflo\\steps-issue-327715.csv");
        System.out.println("File is Uploaded Successfully");
    }

    public void nextButtonJIRA() throws InterruptedException {
        Waiters.waitForElementToBeDisplay(getimportButton());
        getimportButton().sendKeys("C:\\Users\\karthikeyan.Armugam\\Documents\\Testflo\\steps-issue-327715.csv");
        System.out.println("File is Uploaded Successfully");
    }

    public void clickProjectName() {
        //Waiters.waitTillLoadingPage(getDriver());
        deleteCookies();
        //Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getProjectNameToExport());
        //Waiters.waitTillLoadingPage(getDriver());
        waitUntilInvisible(5, loader);
        getProjectNameToExport().sendKeys(Keys.ARROW_DOWN);
        getProjectNameToExport().sendKeys(Keys.ARROW_DOWN);
        getProjectNameToExport().sendKeys(Keys.ARROW_DOWN);
        getProjectNameToExport().sendKeys(Keys.ARROW_DOWN);
        getProjectNameToExport().sendKeys(Keys.ARROW_DOWN);
        getProjectNameToExport().sendKeys(Keys.ARROW_DOWN);
        getProjectNameToExport().sendKeys(Keys.ARROW_DOWN);
        getProjectNameToExport().sendKeys(Keys.RETURN);
    }

    public void selectProject(String project) {
        //Waiters.waitTillLoadingPage(getDriver());
        deleteCookies();
        List<WebElement> options = findWebElements(By.xpath("//*[@id='CSV-select']/optgroup/option"));
        if(options.equals(null)) {
            deleteCookies();
            refresh();
        }
        //waitUntilInvisible(4, loader);
        options = findWebElements(By.xpath("//*[@id='CSV-select']/optgroup/option"));
        //waitUntilInvisible(4, loader);
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(project))
                .findFirst()
                .orElse(null);
        //waitUntilInvisible(4, loader);
        //commented by KKN//clickOnElement(option);
        //Waiters.waitABit(5000);
        try {
            clickOnElement(option);

        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            clickOnElement(option);
        }

        waitUntilInvisible(20, loader);
        //Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectProjectDropDown() throws InterruptedException {
//        WebElement option = findWebElement(By.xpath("//span[normalize-space()='[IGNI]']"));
// //select[@name='CSV_project']/optgroup/option[contains(text(),'Ignition')]
        WebElement WebEle = findWebElement(By.xpath("//input[@id='CSV-select-field']"));
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='CSV-select-field']")));
        ((JavascriptExecutor) getDriver()).executeScript("scroll(0,300)");
       Actions act1 = new Actions(getDriver());
        //options.moveToElement(option);
        //options.click().perform();
        act1.moveToElement(WebEle).click();
        Thread.sleep(3000);
        WebElement Ignition_Project= findWebElement(By.xpath("//*[@id='CSV-select']/optgroup/option[8]"));
        JScriptClick(getDriver(),Ignition_Project,10);
        //commented//act1.moveToElement(Ignition_Project).click();
        Thread.sleep(2000);
        //options.perform();
//        Select se = new Select(option);
//        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='CSV_project']")));
//        se.selectByIndex(project);
    }

    public void selectProjectDropDownJIRA() throws InterruptedException {
        //HelpersMethod.DropDownMenu(getDriver(), "Ignition");

    }

    public boolean isLoginIconVisible() {
        return isElementDisplay(getLoginField());
    }

    public boolean isPasswordFieldVisible() {
        return isElementDisplay(getPasswordField());
    }

    public boolean isSignInVisible() { return isElementDisplay(getSignInButton()); }

    public boolean isErrorNotificationVisible() {
        return isElementDisplay(getNotificationWrongSignIn());
    }

    public String isErrorNotificationTextCorrect() { return getText(getNotificationWrongSignIn()); }

    private WebElement getLoginField() { return findWebElement(login); }

    public WebElement getPasswordField() { return findWebElement(password); }

    public WebElement getSignInButton() { return findWebElement(signInButton); }

    //JIRA

    private WebElement getLoginFieldJIRA() { return findWebElement(loginJIRA); }

    public WebElement getPasswordFieldJIRA() { return findWebElement(passwordJIRA); }

    public WebElement getSignInButtonJIRA() { return findWebElement(signInButtonJIRA); }


    public WebElement getNotificationWrongSignIn() { return findWebElement(notificationWrongSignIn); }

    public WebElement getissuesTab() { return findWebElement(issuesTab); }

    public WebElement getimportIssuesOption() { return findWebElement(importIssuesOption); }



    public WebElement getimportButton() { return findWebElement(importButton); }

    public WebElement getNextButton() { return findWebElement(NextButton); }

    public WebElement getProjectNameToExport() { return findWebElement(ProjectNameToExport); }

}
