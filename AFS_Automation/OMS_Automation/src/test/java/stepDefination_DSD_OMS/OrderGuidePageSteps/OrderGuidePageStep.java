package stepDefination_DSD_OMS.OrderGuidePageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderGuidePageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static boolean exists = false;
    static String Prod_No=null;
    static boolean flag=false;
    static boolean flag1=false;
    static String currentURL=null;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;
    static OrderGuidePage orderGuidePage;
    static CreateOGPage createOGPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for OG")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForOG() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for OG")
    public void user_is_on_home_pageForOG() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for OG")
    public void user_navigate_to_client_sideForOG() throws InterruptedException, AWTException
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

    @Then("User should select Order Entry tab for OG")
    public void user_should_select_order_entry_tabForOG() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Then("User selects Account# for OG")
    public void user_selects_accountForOG() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ChangeAccount();
            //orderpage.PopUps_After_AccountChange();
            //orderpage.Read_DeliveryDate();
        }
    }

    @Given("User must be on Order Entry Page to select OG")
    public void user_must_be_on_order_entry_page_to_select_og() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            WebElement WebEle;
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order guides')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                exists = false;
                orderGuidePage = new OrderGuidePage(driver, scenario);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Order Guides", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order guides')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists = orderGuidePage.ValidateOG();
                currentURL=driver.getCurrentUrl();
                Assert.assertEquals(exists, true);
            }
            else
            {
                scenario.log("ORDER GUIDE TAB DOESN'T EXISTS");
            }
            flag1=true;
        }
    }

    @And("User should navigate to OG")
    public void user_should_navigate_to_og() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.HandleError_Page();
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.Refresh_Page(currentURL);
        orderGuidePage.ValidateOG();
    }

    @Then("User clicks on Create new button and should navigate to New OG page")
    public void user_clicks_on_create_new_button_and_should_navigate_to_new_og_page() throws InterruptedException, AWTException
    {
        exists=false;
        orderGuidePage=new OrderGuidePage(driver,scenario);
        exists=orderGuidePage.ValidateOG();
        Assert.assertEquals(exists,true);
        orderGuidePage.CrateOG();
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateNewOGPage();
    }

    @Then("Then User enters Description {string} and End date")
    public void thenUserEntersDescriptionAndEndDate(String Og)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateNewOGPage();
        createOGPage.DescriptionOG(Og);

        //selecting end date
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        createOGPage.CalenderEnd();
        createOGPage.SelectEndDate(formattedDate,20);
    }

    @And("User enters Quick Product number and Sequence number")
    public void user_enters_quick_product_number_and_sequence_number(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<List<String>> SeqNo=tabledata.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        Prod_No= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        createOGPage.EnterQuickProduct(Prod_No,SeqNo.get(0).get(0));
    }

    @Then("User click on Save button")
    public void user_click_on_save_button() throws InterruptedException, AWTException
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.readPtoductNo();
        createOGPage.ClickOnSave();
        createOGPage.validateSavePopup();
        createOGPage.clickOnOk();
    }

    @Then("User click on Save button to convert Quote as OG")
    public void userClickOnSaveButtonToConvertQuoteAsOG()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateNewOGPage();
        createOGPage.ClickOnSave();
        createOGPage.validateSavePopup();
        createOGPage.clickOnOk();
    }

    //code to verify whether user is on OG page or not
    @And("User should navigate back to OG page and verify OG {string}  existence")
    public void user_should_navigate_back_to_og_page(String Og) throws InterruptedException, AWTException
    {
        exists=false;
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists = orderGuidePage.ValidateOG();
        scenario.log("USER IS ON ORDER GUIDE PAGE");

        exists=false;
        //Code to verify whether OG is existing in OG grid or not
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.clearAddfilter();
        exists=orderGuidePage.OGSearchBox(Og);
        Assert.assertEquals(exists,true);
    }

    //Code to search for OG using search box//////////////////////////////////////////////
    @Then("User enters OG Description in search box")
    public void user_enters_og_description_in_search_box(DataTable tabledata) throws InterruptedException, AWTException
    {
        exists=false;
        List<List<String>> OGSearch=tabledata.asLists(String.class);
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists=orderGuidePage.OGSearchBox(OGSearch.get(0).get(0));
        Assert.assertEquals(exists,true);
        orderGuidePage.SearchOGSelect(OGSearch.get(0).get(0));
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.OGDetailValidate();
        createOGPage.readPtoductNo();
    }

    //code to enter products to exitsting OG for editing OG, using quick product entry
    @And("User enters multiple Quick Product number and Sequence number")
    public void user_enters_multiple_quick_product_number_and_sequence_number(DataTable tabledata) throws SQLException
    {
        createOGPage=new CreateOGPage(driver,scenario);
        List<List<String>> SeqList=tabledata.asLists(String.class);
        List<String> Product=DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1());
        for(int i=0;i<=SeqList.size()-1;i++)
        {
            createOGPage.EnterQuickProduct(Product.get(i),SeqList.get(i).get(0));
        }
    }

    //Code to click on Delete button to remove product from OG
    @And("User click on Delete button to remove product from OG")
    public void user_cllick_on_delete_button_to_remove_product_from_og()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.DeleteProd();
    }

    //code to click on More button in Open OG
    @Then("User click on More button")
    public void user_click_on_more_button()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.OGDetailValidate();
        exists=createOGPage.More_Button();
        Assert.assertEquals(exists,true);
    }

    //Code to select Clear sequence from drop down
    @And("User selects Clear Sequence from drop down")
    public void user_selects_clear_sequence_from_drop_down()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        exists=createOGPage.SequenceClear();
        Assert.assertEquals(exists,true);
    }

    //Code to handle sequence clear popup and select No from popup
    @And("User handles popup for clearing sequence number by selecting No")
    public void user_handles_popup_for_clearing_sequence_number_by_selecting_No()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.SequencePopupNo();
    }

    //Code to handle sequence clear popup and select Yes from popup
    @And("User handles popup for clearing sequence number by selecting Yes")
    public void user_handles_popup_for_clearing_sequence_number_by_selecting_yes()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.SequencePopupYes();
    }

    //Code to edit sequence number in Order guide, Product grid
    @And("User changes sequence number in product grid of OG")
    public void user_changes_sequence_number_in_product_grid_of_og(DataTable tabledata)
    {
        List<List<String>> SeqNo=tabledata.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        exists=createOGPage.EditSequence(SeqNo.get(0).get(0));
        Assert.assertEquals(exists,true);
    }

    @And("User enters multiple Product# Quick Product number and Sequence number")
    public void user_enters_multiple_product_quick_product_number_and_sequence_number(DataTable tabledata) throws SQLException
    {
        createOGPage=new CreateOGPage(driver,scenario);
        List<List<String>> SeqList=tabledata.asLists(String.class);
        List<String> Product=DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());

        for(int i=0;i<=SeqList.size()-1;i++)
        {
            createOGPage.EnterQuickProduct(Product.get(i),SeqList.get(i).get(0));
        }
    }

    //Code to create OG with multiple products, and to select end date
    @Then("User enters Description and End date 2 day from current date")
    public void user_enters_description_and_end_date_two_days_from_current_date(DataTable tabledata)
    {
        //entering discription
        List<List<String>> OGDesc = tabledata.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.DescriptionOG(OGDesc.get(0).get(0));

        //selecting end date
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        createOGPage.CalenderEnd();
        createOGPage.SelectEndDate(formattedDate,2);
    }

    //code for creating OG by adding OG
    @Then("User clicks on Add product button and select OG from drop down")
    public void user_clicks_on_add_product_button_and_select_OG_from_drop_down(DataTable dataTable)
    {
        List<List<String>> option=dataTable.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ClickOnAddProduct();
        createOGPage.SelectValueFromAddProduct(option.get(0).get(0));
    }

    @Then("User clicks on Add product button and select Order from drop down")
    public void user_clicks_on_add_product_button_and_select_order_from_drop_down(DataTable dataTable)
    {
        List<List<String>> option=dataTable.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ClickOnAddProduct();
        createOGPage.SelectValueFromAddProduct(option.get(0).get(0));
    }

    @And("User should select Order# from Order popup")
    public void user_should_select_order_from_order_popup()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateOrderPopup();
        createOGPage.OrderPopup();
    }

    //code for adding product from quick entry and from catalog
    @And("User enters multiple Product# Quick Product entry and catalog and Sequence number")
    public void user_enters_multiple_product_quick_product_entry_and_catalog_and_sequence_number(DataTable dataTable) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException
    {
        List<List<String>> ProdOption=dataTable.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);

        //Code to get data from database
        String Product=DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        //Enter value in  quick product, sequence input text box
        createOGPage.EnterQuickProduct(Product,ProdOption.get(0).get(0));

        //handling catalog popup. Selecting Catalog option from drop down
        createOGPage.ClickOnAddProduct();
        createOGPage.SelectValueFromAddProduct(ProdOption.get(0).get(1));
        createOGPage.ValidateCatalogDisplay();
        //createOGPage.validateProductExists();
        createOGPage.ResetFilter_Catalog();
        //createOGPage.SelectProductCatalog();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            createOGPage.ListView();
        }
        else
        {
            createOGPage.cardView();
        }
        createOGPage.CatalogPopupOk();
    }

    @Then("User enters Description {string} Start date {int} and End date {int} day from current date")
    public void userEntersDescriptionStartDateSdateAndEndDateEdateDayFromCurrentDate(String arg0,int Sdate,int Edate)
    {
        createOGPage=new CreateOGPage(driver,scenario);

        createOGPage.DescriptionOG(arg0);

        //selecting start date
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        createOGPage.CalenderStart();
        createOGPage.SelectStartDate(formattedDate, Sdate);

        //selecting end date
        LocalDate myDateObj1 = LocalDate.now();
        DateTimeFormatter myFormatObj1= DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate1 = myDateObj1.format(myFormatObj1);
        createOGPage.CalenderEnd();
        createOGPage.SelectEndDate(formattedDate1,Edate);
    }

    @Then("User enters OG {string} Description in search box")
    public void userEntersOGDescriptionInSearchBox(String Og) throws InterruptedException, AWTException
    {
        exists=false;
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists=orderGuidePage.OGSearchBox(Og);
        Assert.assertEquals(exists,true);
        orderGuidePage.SearchOGSelect(Og);

        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.OGDetailValidate();
        createOGPage.readPtoductNo();
    }

    @And("User search for Product# in New OG page")
    public void userSearchForProductInNewOGPage() throws InterruptedException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        exists=false;
        createOGPage=new CreateOGPage(driver,scenario);
        String ProdNo=DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        exists= createOGPage.SearchProd(ProdNo);

        if(exists==true)
        {
            scenario.log(ProdNo+" HAS BEEN FOUND IN PRODUCT GRID");
            exists=true;
        }
        else
        {
            scenario.log(ProdNo+" PRODUCT IS NOT PART OF OG");
            //exists=true;
        }
        Assert.assertEquals(exists,true);
    }

    @Then("Then User enters Description {string}")
    public void thenUserEntersDescription(String Og)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.DescriptionOG(Og);
    }

    @Then("User clicks on print button")
    public void userClicksOnPrintButton()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.PrintOG();
    }

    @And("User should select {string} from popup")
    public void userShouldSelectFromPopup(String OGSearch)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateOGPopup();
        createOGPage.OrderGuidePopup(OGSearch);
    }

    @Then("User click on Cancel button")
    public void userClickOnCancelButton()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateNewOG();
        createOGPage.ClickCancelButton();
    }

    @And("User should navigate back to OG page and verify OG {string}  existence when cancelled")
    public void userShouldNavigateBackToOGPageAndVerifyOGExistenceWhenCancelled(String Og) throws InterruptedException, AWTException
    {
        exists=false;
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists = orderGuidePage.ValidateOG();
        Assert.assertEquals(exists, true);
        scenario.log("USER IS ON ORDER GUIDE PAGE");

        exists=false;
        //Code to verify whether OG is existing in OG grid or not
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists=orderGuidePage.OGSearchBox(Og);
        Assert.assertEquals(exists,false);
    }

    @And("User must be on create OG page and {string} the grid header")
    public void userMustBeOnCreateOGPageAndTheGridHeader(String TableHead)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.FindtableHeader(TableHead);
        createOGPage.DisplayGroupDetails();
    }

    @Then("User should click on arrow symbol for sorting sequence numbers")
    public void userShouldClickOnArrowSymbolForSortingSequenceNumbers()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.displaySequenceValueForFirstTime();
        createOGPage.clickonArrowOfSeqeuence();
        createOGPage.displaySequenceValueForSecondTime();
        createOGPage.compareSequenceNosFound();
    }
}