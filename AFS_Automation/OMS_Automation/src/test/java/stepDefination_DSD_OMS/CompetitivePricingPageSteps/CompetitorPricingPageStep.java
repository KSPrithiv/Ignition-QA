package stepDefination_DSD_OMS.CompetitivePricingPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.competitivePricing.CompetitivePricingGeneralPage;
import pages_DSD_OMS.competitivePricing.CompetitivePricingReportPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CompetitorPricingPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;

    static LoginPage loginpage;
    static HomePage homepage;
    static CompetitivePricingGeneralPage competitivePricingGeneralPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Competitior pricing")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsForCompetitiorPricing() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.Userword());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Competitior pricing")
    public void userIsOnHomePageForCompetitiorPricing()
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Competitior pricing")
    public void userNavigateToClientSideForCompetitiorPricing() throws InterruptedException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            competitivePricingGeneralPage= new CompetitivePricingGeneralPage(driver, scenario);
            competitivePricingGeneralPage.NavigateToCompetitorPricing();
            flag=true;
        }
    }

    @Given("User must be on Client side and select Competitor pricing page")
    public void userMustBeOnClientSideAndSelectCompetitorPricingPage()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.HandleError_Page();
        competitivePricingGeneralPage.Refresh_Page();
    }

    @When("User should confirm that he is in Competitor pricing page")
    public void userShouldConfirmThatHeIsInCompetitorPricingPage()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.ValidateCompetitorGeneral();
    }

    @And("User selects Customer reference {string} {string} and Select customer Account#")
    public void userSelectsCustomerReferenceAndSelectCustomerAccount(String CustRef,String CustRef1) throws InterruptedException
    {
            competitivePricingGeneralPage = new CompetitivePricingGeneralPage(driver, scenario);
            ////competitivePricingGeneralPage.Click_CustomerReferenceDropDown();
            //competitivePricingGeneralPage.Select_CustomerReference(CustRef,CustRef1);
            ////competitivePricingGeneralPage.Select_CustomerReference(CustRef);
            competitivePricingGeneralPage.Click_CustomerAccountIndex();
            competitivePricingGeneralPage.ValidateCustomerAccountPopup();
            competitivePricingGeneralPage.SelectCustomerAccount();
    }

    @Then("User click on Add competitor button and Enters Competitor details and clicks on Add button")
    public void userClickOnAddCompetitorButtonAndEntersCompetitorDetailsAndClicksOnAddButton()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.Click_NewCompetitorButton();
        competitivePricingGeneralPage.ValidateNewCompetitorPopup();
    }

    @Then("User clicks on competitor drop down and select the competitor based on previously created competitor")
    public void userClicksOnCompetitorDropDownAndSelectTheCompetitorBasedOnPreviouslyCreatedCompetitor()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.ValidateCompetitorGeneral();
        competitivePricingGeneralPage.Click_CompetitorDropdown();
    }

    @And("User should click on Plus button for adding products, using filter input box")
    public void userShouldClickOnPlusButtonForAddingProductsUsingFilterInputBox()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.Click_Plus();
        competitivePricingGeneralPage.Validate_ProductIndex();
        //competitivePricingGeneralPage.clickOnLoadAllProducts();
        competitivePricingGeneralPage.selectProductsForCompetitorPricing();
    }

    @Then("User selects Sold by uom, base uom, competitor pricing and comment, then user clicks on Save button")
    public void userSelectsSoldByUomBaseUomCompetitorPricingAndCommentThenUserClicksOnSaveButton(DataTable tabledata)
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.Selecting_SoldByUOM_Selecting_BaseUOM();
        competitivePricingGeneralPage.EnteringCompetitorPricingComment(Prod_detail);
        competitivePricingGeneralPage.Click_SaveButton();
    }

    @And("User selects one of the product from grid and delete it and click on save button")
    public void userSelectsOneOfTheProductFromGridAndDeleteItAndClickOnSaveButton()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.ValidateCompetitorGeneral();
        competitivePricingGeneralPage.Click_CheckBox();
        competitivePricingGeneralPage.Click_DeleteProd();
        competitivePricingGeneralPage.clear_Addfilter();
        competitivePricingGeneralPage.Click_SaveButton();
    }

    @And("User clicks on delete competitor record button")
    public void userClicksOnDeleteCompetitorRecordButton()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.Click_DeleteCompetitorRecord();
    }

    @And("User search for product using Add filter")
    public void userSearchForProductUsingAddFilter()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.SearchForProd();
    }

    @And("User search for product using Search bar")
    public void userSearchForProductUsingSearchBar()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.SearchForProdSearchBar();
    }

    @And("User selects Customer reference {string}")
    public void userSelectsCustomerReference(String CustRef,String CustRef1)
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.Click_CustomerReferenceDropDown();
        //competitivePricingGeneralPage.Select_CustomerReference(CustRef,CustRef1);
        competitivePricingGeneralPage.Select_CustomerReference(CustRef);
    }

    @And("User Click on Load existing data and select competitor in popup")
    public void userClickOnLoadExistingDataAndSelectCompetitorInPopup()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.Click_LoadExistingData();
        competitivePricingGeneralPage.Validate_LoadExistingDataPopUp();
        //competitivePricingGeneralPage.SearchCustomerDetails();
        competitivePricingGeneralPage.SelectCompetitorDetails();
        competitivePricingGeneralPage.DetailsOfProducts();
    }


    @And("User search for product in catalog dialog box, to make sure that duplicate products are not added to competitive pricing")
    public void userSearchForProductInCatalogDialogBoxToMakeSureThatDuplicateProductsAreNotAddedToCompetitivePricing()
    {
        competitivePricingGeneralPage=new CompetitivePricingGeneralPage(driver,scenario);
        competitivePricingGeneralPage.readFirstProductInGrid();
        competitivePricingGeneralPage.Click_Plus();
        competitivePricingGeneralPage.Validate_ProductIndex();
        competitivePricingGeneralPage.searchProductInCatalogDialogBox();
    }
}
