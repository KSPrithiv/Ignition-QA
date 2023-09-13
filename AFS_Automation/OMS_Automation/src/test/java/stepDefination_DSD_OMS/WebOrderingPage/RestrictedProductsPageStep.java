package stepDefination_DSD_OMS.WebOrderingPage;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import pages_DSD_OMS.webOrdering.RestrictedProductListPage;
import util.TestBase;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class RestrictedProductsPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    static boolean flag=false;
    static boolean flag1=false;
    static boolean flag2=false;
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    LoginPage loginPage;
    AdminHomePage adminHomePage;
    RestrictedProductListPage restrictedProductListPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Admin setting")
    public void userEntersUrlAndIsOnLoginPageAndEnteredCredentialsForAdminSetting() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginPage = new LoginPage(driver, scenario);
            loginPage.EnterUsername(TestBase.testEnvironment.getAdminUser());
            loginPage.EnterPassword(TestBase.testEnvironment.getAdminPass());
            loginPage.ClickSignin();
        }
    }

    @When("User is on Home Page for Admin setting")
    public void userIsOnHomePageForAdminSetting() throws InterruptedException
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
        }
    }

    @Then("User Clicks on Permissions by drop down to select Customer Account#")
    public void userClicksOnPermissionsByDropDownToSelectCustomerAccount() throws InterruptedException
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickPermissionBy();
            adminHomePage.SelectCompany();
            flag=true;
        }
    }

    @Given("User is on Home Page for Admin setting to select Admin option")
    public void userIsOnHomePageForAdminSettingToSelectAdminOption() throws InterruptedException
    {
       // if(flag==false)
      //  {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
        //    flag=true;
       // }
    }

    @And("User should enter menu {string} in search bar to navigate to Authorized Products")
    public void userShouldEnterMenuInSearchBarToNavigateToAuthorizedProducts(String arg0) throws InterruptedException
    {
       // if(flag1==false)
       // {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHumburger();
            adminHomePage.EnterValueInSearchBox(arg0);
            adminHomePage.CloseHumburger();
       // }
    }

    @Then("User should select {string} from horizantal menu to select Restricted product list")
    public void userShouldSelectFromHorizantalMenuToSelectRestrictedProductList(String arg0)
    {
      //  if(flag1==false)
      //  {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.Horizantal_MenuBar(arg0);
       // }
    }

    @And("User should be on Restricted product list")
    public void userShouldBeOnRestrictedProductList()
    {
       // if(flag1==false)
       // {
            restrictedProductListPage = new RestrictedProductListPage(driver, scenario);
            restrictedProductListPage.ValidateRestrictedProductList();
         //   flag1=true;
       // }
    }

    @Then("User should list all the products in Product grid")
    public void userShouldListAllTheProductsInProductGrid()
    {
        restrictedProductListPage=new RestrictedProductListPage(driver,scenario);
        restrictedProductListPage.DisplayListOfProducts();
    }

    @And("User Clicks on Add products button and user should make sure that Product popup has appeared")
    public void userClicksOnAddProductsButtonAndUserShouldMakeSureThatProductPopupHasAppeared()
    {
        restrictedProductListPage=new RestrictedProductListPage(driver,scenario);
        restrictedProductListPage.ClickOnAddProduct();
        restrictedProductListPage.ValidateProductPopup();
    }

    @Then("User should select product no from popup and click on Ok")
    public void userShouldSelectProductNoFromPopupAndClickOnOk()
    {
        restrictedProductListPage=new RestrictedProductListPage(driver,scenario);
        restrictedProductListPage.SelectProductFromPopup();
        restrictedProductListPage.ClickOnOkInPopup();
        restrictedProductListPage.DisplayListOfProducts();
    }

    @And("User should Select product from the Product grid and click on Delete button")
    public void userShouldSelectProductFromTheProductGridAndClickOnDeleteButton()
    {
        restrictedProductListPage=new RestrictedProductListPage(driver,scenario);
        restrictedProductListPage.SelectProductFromGrid();
        restrictedProductListPage.ClickOnDeleteButton();
        restrictedProductListPage.DisplayListOfProducts();
    }

    @Then("User clicks on ProductGroup radio button and user should be navigated to Products restriction group")
    public void userClicksOnProductGroupRadioButtonAndUserShouldBeNavigatedToProductsRestrictionGroup()
    {
        //if(flag2==false)
        //{
            restrictedProductListPage = new RestrictedProductListPage(driver, scenario);
            restrictedProductListPage.ProductGroupRadioButton();
            restrictedProductListPage.ValidateProductGroup();
          //  flag2=true;
        //}
    }

    @And("User clicks on Add Product group button and select category group from popup")
    public void userClicksOnAddProductGroupButtonAndSelectCategoryGroupFromPopup()
    {
        restrictedProductListPage=new RestrictedProductListPage(driver,scenario);
        restrictedProductListPage.ClickAddProductGroup();
        restrictedProductListPage.ClickOnDropdownInPopup();
        restrictedProductListPage.ClickAddButtonPopup();
        restrictedProductListPage.ValidateSelectedProdGroup();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @And("User clicks on Delete group button")
    public void userClicksOnDeleteGroupButton()
    {
        restrictedProductListPage=new RestrictedProductListPage(driver,scenario);
        restrictedProductListPage.SelectProdutInCatGroup();
        restrictedProductListPage.ClickOnDeleteButton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }
}
