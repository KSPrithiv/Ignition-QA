package stepDefination_DSD_OMS.ParOrderPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import pages_DSD_OMS.parOrder.ParOrderPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
public class ParOrderPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static boolean exists = false;
    static String Prod_No=null;
    static int ParProd=0;
    static int ParProdEdit=0;
    static boolean flag=false;
    static boolean flag1=false;
    static boolean flag2=false;
    static boolean flag3=false;
    static String currentURL=null;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;
    static CreateOGPage createOGPage;
    static OrderGuidePage orderGuidePage;
    static ParOrderPage parOrderPage;

    @Before
    public void LaunchBrowser(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Par")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForPar() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Par")
    public void user_is_on_home_pageForPar() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Par")
    public void user_navigate_to_client_sideForPar() throws InterruptedException, AWTException
    {
        boolean result=false;
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            String title = driver.getTitle();
            //Assert.assertEquals(title, "Ignition - Admin");
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for Par")
    public void user_should_select_order_entry_tabForPar() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Then("User selects Account# for Par")
    public void user_selects_accountForPar() throws InterruptedException, AWTException, ParseException {
        if(flag1==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ChangeAccount();
            //orderpage.PopUps_After_AccountChange();
            orderpage.Read_DeliveryDate();
            flag1=true;
        }
    }
    @Given("User should navigate to OG and select {string} from grid")
    public void UserShouldNavigateToOGAndSelectOGFromGrid(String OG) throws InterruptedException, AWTException
    {
        if (flag2 == false)
        {
            exists = false;
            WebElement WebEle;
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]",driver))
            {
                //Code to navigate to Order guide
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
                HelpersMethod.navigate_Horizantal_Tab(driver, "Order Guides", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                currentURL = driver.getCurrentUrl();
                exists=true;
            }
            Assert.assertEquals(exists,true);
            flag2=true;
        }
        parOrderPage = new ParOrderPage(driver, scenario);
        parOrderPage.Refresh_Page(currentURL);
        orderGuidePage=new OrderGuidePage(driver,scenario);
        exists=false;
        exists = orderGuidePage.ValidateOG();
        Assert.assertEquals(exists, true);
        //Code to select OG from grid
        exists = false;
        exists = orderGuidePage.OGSearchBox(OG);
        Assert.assertEquals(exists, true);
        orderGuidePage.SearchOGSelect(OG);
    }

    @Then("User clicks on ParList tab and Click on New Par list button")
    public void userClicksOnParListTabAndClickOnNewParListButton() throws InterruptedException, AWTException
    {
        exists = false;
        parOrderPage = new ParOrderPage(driver, scenario);
        parOrderPage.ClickParTab();
        parOrderPage.ValidateParlistTab();

       /* orderpage=new OrderEntryPage(driver,scenario);
        //orderpage.HandleError_Page();
        //orderpage.Refresh_Page(currentURL);*/
    }

    @And("User enters code and discription for Par list")
    public void userEntersCodeAndDiscriptionForParList(DataTable tabledata)
    {
        List<List<String>> ParDetails=tabledata.asLists(String.class);
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.ClickNewPar();
        //parOrderPage.EnterCode(ParDetails.get(0).get(0));
        parOrderPage.EnterDesc(ParDetails.get(0).get(0));
    }

    @Then("User clicks on save Par list")
    public void userClicksOnSaveParList()
    {
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.SavePar();
    }

    @And("User enters code and discription to create multiple Par list and save all par lists")
    public void userEntersCodeAndDiscriptionToCreateMultipleParListAndSaveAllParLists(DataTable tabledata)
    {
        WebElement WebEle=null;
        List<List<String>> ParDetails=tabledata.asLists(String.class);
        parOrderPage=new ParOrderPage(driver,scenario);
        for(int i=0;i<=ParDetails.size()-1;i++)
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            parOrderPage.ClickNewPar();
            //parOrderPage.EnterCode(ParDetails.get(i).get(0));
            parOrderPage.EnterDesc(ParDetails.get(i).get(0));
            parOrderPage.SavePar();
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
        }
    }

    @Then("User clicks on ParList tab and Selects parlist {string} from drop down")
    public void userClicksOnParListTabAndSelectsParlistFromDropDown(String ParList)
    {
        exists=false;
        parOrderPage = new ParOrderPage(driver, scenario);
        Prod_No = parOrderPage.ReadProductValueFromOG();
        parOrderPage.ClickParTab();
        parOrderPage.ValidateParlistTab();
        parOrderPage = new ParOrderPage(driver, scenario);
        parOrderPage.ValidateParlistTab();
        parOrderPage.ClickParDropDown();
        parOrderPage.SelectParlistFromDropdown(ParList);
    }

    @And("User enters product# in search box and validates same product details displayed in Product grid")
    public void userEntersProductInSearchBoxAndValidatesSameProductDetailsDisplayedInProductGrid()
    {
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.ReadProductValueFromOG();
        parOrderPage.EnterProductNoInSearchBox();
    }

    @And("Display all product# in par list")
    public void displayAllProductInParList()
    {
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.ReadProducts();
    }

    @And("User clicks on Delete par list button and handle popup")
    public void userClicksOnDeleteParListButtonAndHandlePopup()
    {
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.DeletePar();
    }

    @Then("User clicks on ParList tab and Selects parlist {string} from drop down and count Products")
    public void userClicksOnParListTabAndSelectsParlistFromDropDownAndCountProducts(String ParList)
    {
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.ClickParTab();
        parOrderPage.ValidateParlistTab();
        parOrderPage.ClickParDropDown();
        parOrderPage.SelectParlistFromDropdown(ParList);
        ParProd=parOrderPage.ReadAllProductValueFromPar();
    }

    @And("User navigate to Product tab and adds New product and sequence no")
    public void userNavigateToProductTabAndAddsNewProductAndSequenceNo(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<List<String>> Seq_no=tabledata.asLists(String.class);
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.ClickProductTab();
        createOGPage=new CreateOGPage(driver,scenario);
        String ProdNo=DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        createOGPage.EnterQuickProduct(ProdNo,Seq_no.get(0).get(0));
        createOGPage.ClickOnSave();
    }

    @Then("User clicks on ParList tab and Selects parlist {string} from drop down and count Products after edit")
    public void userClicksOnParListTabAndSelectsParlistFromDropDownAndCountProductsAfterEdit(String ParList)
    {
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.ClickParTab();
        parOrderPage.ClickParDropDown();
        parOrderPage.SelectParlistFromDropdown(ParList);
        ParProdEdit=parOrderPage.ReadAllProductValueFromPar();
        Assert.assertEquals(ParProd,ParProdEdit);
    }

    @Then("User clicks on ParList tab and Selects parlist from drop down and user clicks on Delete Par")
    public void userClicksOnParListTabAndSelectsParlistFromDropDownAndUserClicksOnDeletePar(DataTable tabledata)
    {
        exists=false;
        WebElement WebEle=null;
        List<List<String>> ParDetails=tabledata.asLists(String.class);
        parOrderPage=new ParOrderPage(driver,scenario);
        Prod_No=parOrderPage.ReadProductValueFromOG();
        parOrderPage.ClickParTab();
     /*   parOrderPage.ValidateParlistTab();
        for(int i=0;i<=ParDetails.size()-1;i++)
        {
            parOrderPage.ClickParDropDown();
            parOrderPage.SelectParlistFromDropdown(ParDetails.get(0).get(0));
            parOrderPage.DeletePar();
        }*/

        parOrderPage=new ParOrderPage(driver,scenario);

        parOrderPage.deleteAllPar();

    }

    @And("User should enter valid value for Qty for the first product in product grid")
    public void userShouldEnterValidValueForQtyForTheFirstProductInProductGrid(DataTable dataTable)
    {
        List<List<String>> qty=dataTable.asLists(String.class);
        parOrderPage=new ParOrderPage(driver,scenario);
        for(int i=0;i<=qty.size()-1;i++)
        {
            parOrderPage.enterQtyForParQty(qty.get(i).get(0),i);
        }
    }

    @And("then user clicks on Addfilter button in Parlist card and enters the range for product part qty")
    public void thenUserClicksOnAddfilterButtonInParlistCardAndEntersTheRangeForProductPartQty(DataTable dataTable)
    {
        List<List<String>> values=dataTable.asLists(String.class);
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.clickOnAddFilter();
        parOrderPage.validateFilterPopup();
        parOrderPage.enterValueForFilter(values.get(0).get(0),values.get(0).get(1));
        parOrderPage.readParProducts();
        parOrderPage.clearFilterOption();
    }

    @Then("User enters different par qty in parlist {string}")
    public void userEntersDifferentParQtyInParlist(String qty)
    {
        parOrderPage=new ParOrderPage(driver,scenario);
        parOrderPage.enterQtyForParQty1(qty);
    }
}

