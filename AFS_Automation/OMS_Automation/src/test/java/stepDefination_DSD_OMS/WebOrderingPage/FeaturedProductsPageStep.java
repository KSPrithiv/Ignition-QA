package stepDefination_DSD_OMS.WebOrderingPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import pages_DSD_OMS.webOrdering.FeaturedProdSettingsPage;
import pages_DSD_OMS.webOrdering.FeaturedProductsPage;
import util.TestBase;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class FeaturedProductsPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    static boolean flag1=false;
    WebDriver driver;
    Scenario scenario;
    static int MaxProd;
    static int SetProd;
    static AdminHomePage adminHomePage;
    static FeaturedProdSettingsPage featuredProdSettingsPage;
    static FeaturedProductsPage featuredProductsPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should enter menu {string} in search bar to navigate to Featured Products")
    public void userShouldEnterMenuInSearchBarToNavigateToFeaturedProducts(String arg0)
    {
       // if(flag1==false)
       // {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHumburger();
            adminHomePage.EnterValueInSearchBox(arg0);
            adminHomePage.CloseHumburger();
            featuredProdSettingsPage=new FeaturedProdSettingsPage(driver,scenario);
            featuredProdSettingsPage.validateFeatureProd();

        // flag1=true;
       // }
    }

    @Then("User should Check whether Max products to show in featured products Sheild is selected or not")
    public void userShouldCheckWhetherMaxProductsToShowInFeaturedProductsSheildIsSelectedOrNot()
    {
        featuredProdSettingsPage=new FeaturedProdSettingsPage(driver,scenario);
        featuredProdSettingsPage.validateFeatureProd();
        featuredProdSettingsPage.SheildIconSelected();
    }

    @Then("User should check max number of Featured products set")
    public void userShouldCheckMaxNumberOfFeaturedProductsSet() throws InterruptedException
    {
            featuredProdSettingsPage=new FeaturedProdSettingsPage(driver,scenario);
            featuredProdSettingsPage.ValidateFeaturedProdSetting();
            MaxProd= featuredProdSettingsPage.ReadingMaxProducts();
            scenario.log("MAXIMUM FEATURED PRODUCTS SET IS "+MaxProd);
    }

    @Then("User should navigate to {string} from horizantal menu to select Featured products list")
    public void userShouldNavigateToFromHorizantalMenuToSelectFeaturedProductsList(String arg0)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Horizantal_MenuBar(arg0);
    }

    @Then("User should select {string} from horizantal menu to select Featured products list")
    public void userShouldSelectFromHorizantalMenuToSelectFeaturedProductsList(String arg0) throws InterruptedException
    {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.Horizantal_MenuBar(arg0);
            Thread.sleep(1000);
    }

    @And("User should be on Featured products list")
    public void userShouldBeOnFeaturedProductsList()
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        featuredProductsPage.ValidateFeautedProduct();
    }

    @Then("User should list all the products in Product grid of Featured products")
    public void userShouldListAllTheProductsInProductGridOfFeaturedProducts()
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        //featuredProductsPage.ListFeaturedProduct(MaxProd);
    }

    @Then("User should increase max number of Featured products set")
    public void userShouldIncreaseMaxNumberOfFeaturedProductsSet()
    {
        featuredProdSettingsPage=new FeaturedProdSettingsPage(driver,scenario);
        MaxProd= featuredProdSettingsPage.ReadingMaxProducts();
        scenario.log("MAXIMUM FEATURED PRODUCTS SET IS "+MaxProd);
        SetProd=featuredProdSettingsPage.IncreaseMaxProducts();
        scenario.log("MAXIMUM FEATURED PRODUCTS IS INCREASED TO "+SetProd);
        featuredProdSettingsPage.ClickOnDropDown();
        featuredProdSettingsPage.SelectValueFromDropDown(SetProd);
        MaxProd=SetProd;
    }

    @And("User should be on Featured products list then User should click on Add Products button and add products to list")
    public void userShouldBeOnFeaturedProductsListThenUserShouldClickOnAddProductsButtonAndAddProductsToList()
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        featuredProductsPage.ListFeaturedProduct(MaxProd);
        featuredProductsPage.ClickAddProducts();
        featuredProductsPage.SelectProduct();
        featuredProductsPage.CatalogOkButton();
        featuredProductsPage.PopupAfterChanges();
       // featuredProductsPage.ListFeaturedProduct(SetProd);
    }

    @Then("User should decrease max number of Featured products set")
    public void userShouldDecreaseMaxNumberOfFeaturedProductsSet()
    {
        featuredProdSettingsPage=new FeaturedProdSettingsPage(driver,scenario);
        MaxProd= featuredProdSettingsPage.ReadingMaxProducts();
        scenario.log("MAXIMUM FEATURED PRODUCTS SET IS "+MaxProd);
        SetProd=featuredProdSettingsPage.DecreaseMaxProducts();
        scenario.log("MAXIMUM FEATURED PRODUCTS IS REDUCED TO "+SetProd);
        featuredProdSettingsPage.ClickOnDropDown();
        featuredProdSettingsPage.SelectValueFromDropDown(SetProd);
    }

    @And("User should be on Featured products list then User should select product from grid and click on Delete button")
    public void userShouldBeOnFeaturedProductsListThenUserShouldSelectProductFromGridAndClickOnDeleteButton()
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        featuredProductsPage.ListFeaturedProduct(MaxProd);
        featuredProductsPage.ClickOnDeleteProduct();
        featuredProductsPage.PopupAfterChanges();
        //featuredProductsPage.ListFeaturedProduct(SetProd);
    }

    @And("User should be on Featured products list then User should click on Add Products button and filter product")
    public void userShouldBeOnFeaturedProductsListThenUserShouldClickOnAddProductsButtonAndFilterProduct()
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        featuredProductsPage.ClickAddProducts();
        featuredProductsPage.CatalogFilter();
        featuredProductsPage.SelectProduct();
        featuredProductsPage.CatalogOkButton();
    }

    @Then("User changes max number of feature products and set it as {int}")
    public void userChangesMaxNumberOfFeatureProductsAndSetItAs(int arg0)
    {
        featuredProdSettingsPage=new FeaturedProdSettingsPage(driver,scenario);
        featuredProdSettingsPage.ClickOnDropDown();
        featuredProdSettingsPage.SelectValueFromDropDown(arg0);
    }

    @And("User should delete all the products in feature products list")
    public void userShouldDeleteAllTheProductsInFeatureProductsList()
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        featuredProductsPage.deleteAllFeatureProduct();
    }

    @Then("User should add new {int} products, and delete first product")
    public void userShouldAddNewProductsAndDeleteFirstProduct(int arg0)
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        featuredProductsPage.ClickAddProducts();
        for(int i=0;i<=arg0-1;i++)
        {
            featuredProductsPage.selecting3Products();
        }
        featuredProductsPage.CatalogOkButton();
        featuredProductsPage.PopupAfterChanges();
        featuredProductsPage.ListFeaturedProduct(MaxProd);
        featuredProductsPage.deleteFirstProduct();
    }

    @Then("User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder")
    public void userRefreshesPageClicksOnPermissionsByDropDownToSelectCustomerAccountGridForWebOrder() throws InterruptedException
    {
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.refreshPage();
        adminHomePage.ClickPermissionByAgain();
        adminHomePage.SelectCompany();
    }
}
