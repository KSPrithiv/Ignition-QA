package steps.validations;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import ui.pages.LoginPage;

import java.sql.SQLOutput;

public class LoginPageValidations {
    LoginPage loginPage = new LoginPage();
    SoftAssert softAssert = new SoftAssert();

    @Then("Login page is displayed")
    public void validateLoginPageIsDislayed() {
        softAssert.assertTrue(loginPage.isLoginIconVisible(), "Login is not displayed");
        softAssert.assertTrue(loginPage.isPasswordFieldVisible(), "Password is not displayed");
        softAssert.assertTrue(loginPage.isSignInVisible(), "SignIn is not displayed");
        softAssert.assertAll();
    }

    @And("Wrong credentials notification error {string} is displayed")
    public void validateWrongCredsNotificationError(String text) {
        softAssert.assertTrue(loginPage.isErrorNotificationVisible(),
                    "Notification " + text + " is not displayed");
        softAssert.assertEquals(loginPage.isErrorNotificationTextCorrect(), text, "Notification text is not correct");
        softAssert.assertAll();

    }

}
