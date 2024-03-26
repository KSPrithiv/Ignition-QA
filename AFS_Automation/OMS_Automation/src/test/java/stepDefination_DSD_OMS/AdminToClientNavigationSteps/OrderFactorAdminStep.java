package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderFactorAdmin.orderFactorAdminPage;
import pages_DSD_OMS.standingOrder.NewStandingOrderPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class OrderFactorAdminStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static String prodNo;
    static String orderFactorQty;
    static String uom;
    static boolean result;
    static AdminHomePage adminHomePage;
    static orderFactorAdminPage ordFacorPage;
    static NewOrderEntryPage newOE;
    static HomePage homepage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User should navigate to {string} from horizontal menu to select Order factor, select order factor level {string}")
    public void userShouldNavigateToFromHorizontalMenuToSelectOrderFactorSelectOrderFactorLevel(String arg0, String arg1)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Horizantal_MenuBar(arg0);
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        ordFacorPage.validateOrderFactorPage();
        ordFacorPage.clickOnOrderFactorLevel();
        ordFacorPage.selectFactorLevel();
        ordFacorPage.validateOrderFactorLevel(arg1);
    }

    @Then("User should navigate to {string} from horizontal menu to select Order factor, select order factor level {string} and get product#")
    public void userShouldNavigateToFromHorizontalMenuToSelectOrderFactorSelectOrderFactorLevelAndGetProduct(String arg0, String arg1)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Horizantal_MenuBar(arg0);
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        ordFacorPage.validateOrderFactorPage();
        ordFacorPage.clickOnOrderFactorLevel();
        ordFacorPage.selectFactorLevel();
        ordFacorPage.validateOrderFactorLevel(arg1);
        prodNo=ordFacorPage.readFirstOrderFactorProduct();
        uom=ordFacorPage.readOrderFactorUom();
        orderFactorQty=ordFacorPage.readOrderFactorQty();
    }

    @And("User should add product to order factor list and add {string}")
    public void userShouldAddProductToOrderFactorListAndAdd(String qty) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        prodNo = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        result= ordFacorPage.productAlreadyExistsAsOrderFactor(prodNo);
        if(!result)
        {
            ordFacorPage.clickOnAddProducts();
            ordFacorPage.validateProductDialogbox();
            ordFacorPage.searchForProductInDialogbox(prodNo);
            ordFacorPage.selectProductInDialogbox();
            ordFacorPage.productDialogBoxOkButton();
            ordFacorPage.validateAddingOfProductInOrderFactorGrid(prodNo);
        }
        ordFacorPage.addOrderFactorQty(qty);
    }

    @Then("Enter Pro# in Quick Product Entry area for Order factor")
    public void enterProInQuickProductEntryAreaForOrderFactor() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.QuickProduct(prodNo);
    }

    @And("Check for Case and Unit input box enabled or not based on that enter value for qty to verify order factor")
    public void checkForCaseAndUnitInputBoxEnabledOrNotBasedOnThatEnterValueForQtyToVerifyOrderFactor() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        String uomString=uom;
        String oFactQty=orderFactorQty;
        if(uomString.equalsIgnoreCase("Units")||uomString.equalsIgnoreCase("EA"))
        {
            newOE.CheckForQuickUnitEnabled(oFactQty);
            if(uomString.equalsIgnoreCase("Units"))
            {
                WebElement caseIn = HelpersMethod.FindByElement(driver, "id", "quickCases");
                if (caseIn.equals(driver.switchTo().activeElement()))
                {
                    caseIn.sendKeys(Keys.TAB);
                }
            }
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        else if(uomString.equalsIgnoreCase("Cases")||uomString.equalsIgnoreCase("CS"))
        {
            newOE.CheckForQuickCaseEnabled(oFactQty);
            if(uomString.equalsIgnoreCase("Cases"))
            {
                WebElement unitIn = HelpersMethod.FindByElement(driver, "id", "quickUnits");
                if (unitIn.equals(driver.switchTo().activeElement()))
                {
                    unitIn.sendKeys(Keys.TAB);
                }
            }
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        else if(uomString.equalsIgnoreCase("CASES AND UNITS")||uomString.equals("UNITS AND CASES")||uomString.equals("CS AND EA")||uomString.equals("EA AND CS"))
        {
            newOE.CheckForQuickCaseEnabled(oFactQty);
            newOE.CheckForQuickUnitEnabled(oFactQty);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        Thread.sleep(2000);
    }

    @And("User logs out from Admin site")
    public void userLogsOutFromAdminSite() throws InterruptedException
    {
        homepage=new HomePage(driver,scenario);
        homepage.Click_On_UserIcon();
        homepage.Click_On_Signout();
    }

    @Then("Click on Next button and validate order factor dialog box")
    public void clickOnNextButtonAndValidateOrderFactorDialogBox()
    {

    }

    @And("User should delete product from order factor list")
    public void userShouldDeleteProductFromOrderFactorList()
    {
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        if(!result)
        {
            ordFacorPage.validateAddingOfProductInOrderFactorGrid(prodNo);
            ordFacorPage.clickDelete();
            ordFacorPage.validateDeleteProductInOrderFactorGrid(prodNo);
        }
    }
}
