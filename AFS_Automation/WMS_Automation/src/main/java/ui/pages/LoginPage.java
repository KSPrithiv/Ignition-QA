package ui.pages;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
//    By login = By.cssSelector("input[placeholder='User name']");
    By login = By.cssSelector("input[placeholder='UserName']");
    By password = By.cssSelector("input[type='password']");
    By signInButton = By.xpath("//button[contains(text(), 'Sign In')]");

//    By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
//    By signInButton = By.xpath("//button[contains(text(), 'Sign In')]");
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

    public WebElement getNotificationWrongSignIn() { return findWebElement(notificationWrongSignIn); }
}
