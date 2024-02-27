package stepDefination_DSD_OMS.WebOrderingPageSteps;

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
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHamburger();
            adminHomePage.EnterValueInSearchBox(arg0);
            adminHomePage.removeUnwantedDialogbox();
            adminHomePage.CloseHamburger();
            featuredProdSettingsPage=new FeaturedProdSettingsPage(driver,scenario);
            featuredProdSettingsPage.validateFeatureProd();
    }

    @Then("User should Check whether Max products to show in featured products Sheild is selected or not")
    public void userShouldCheckWhetherMaxProductsToShowInFeaturedProductsSheildIsSelectedOrNot()
    {
        featuredProdSettingsPage=new FeaturedProdSettingsPage(driver,scenario);
        featuredProdSettingsPage.validateFeatureProd();
        featuredProdSettingsPage.ShieldIconSelected();
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
            Thread.sleep(2000);
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
        featuredProductsPage.readFeaturedProduct();
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
    }

    @And("User should be on Featured products list then User should click on Add Products button and Close Product index dialogbox")
    public void userShouldBeOnFeaturedProductsListThenUserShouldClickOnAddProductsButtonAndCloseProductIndexDialogbox()
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        featuredProductsPage.ListFeaturedProduct(MaxProd);
        featuredProductsPage.ClickAddProducts();
        featuredProductsPage.CatalogOkButton();
        featuredProductsPage.PopupAfterChanges();
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
        featuredProductsPage.readFeaturedProduct();
    }

    @And("User should be on Featured products list then User should click on Add Products button and filter product")
    public void userShouldBeOnFeaturedProductsListThenUserShouldClickOnAddProductsButtonAndFilterProduct()
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        featuredProductsPage.readFeaturedProduct();
        featuredProductsPage.ClickAddProducts();
        featuredProductsPage.clickOnLoadProducts();
        featuredProductsPage.CatalogFilter();
        featuredProductsPage.SelectProduct();
        featuredProductsPage.CatalogOkButton();
        featuredProductsPage.readFeaturedProduct();
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
        featuredProductsPage.savePopup();
    }

    @Then("User should add new {int} products, and delete first product")
    public void userShouldAddNewProductsAndDeleteFirstProduct(int MaxProd)
    {
        featuredProductsPage=new FeaturedProductsPage(driver,scenario);
        //featuredProductsPage.savePopup();
        featuredProductsPage.ClickAddProducts();
        featuredProductsPage.clickOnLoadProducts();
        for(int i=0;i<=MaxProd-1;i++)
        {
            featuredProductsPage.selecting3Products();
            featuredProductsPage.PopupAfterChanges();
        }
        featuredProductsPage.CatalogOkButton();
        featuredProductsPage.savePopup();
        featuredProductsPage.ListFeaturedProduct(MaxProd);
        featuredProductsPage.deleteFirstProduct();
        featuredProductsPage.savePopup();
        featuredProductsPage.readFeaturedProduct();
    }

    @Then("User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder")
    public void userRefreshesPageClicksOnPermissionsByDropDownToSelectCustomerAccountGridForWebOrder() throws InterruptedException
    {
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.handleError_Page();
        adminHomePage.refreshPage();
        adminHomePage.ValidatingAdminHome();
        adminHomePage.ClickPermissionByAgain();
        adminHomePage.SelectCompany();
    }
}
