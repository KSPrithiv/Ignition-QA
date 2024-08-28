package stepDefination_DSD_OMS.AdminGridsPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages_DSD_OMS.adminGrids.GridConfigurationPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;

import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class GridConfigurationPageStep
{
        /* Created by Divya.Ramadas@afsi.com */
        static boolean flag=false;
        static boolean exists=false;
        static String gType;
        static String columnName;
        static String newLabel;
        static int size1;
        static int size2;
        WebDriver driver;
        Scenario scenario;
        static GridConfigurationPage gridConfigPage;
        static HomePage homePage;
        static LoginPage loginpage;
        static OrderEntryPage orderPage;
        static NewOrderEntryPage newOE;
        static AdminHomePage adminHomePage;

        @Before
        public void LaunchBrowser1(Scenario scenario) throws Exception
        {
            this.scenario=scenario;
            //TestBase driver1=TestBase.getInstanceOfDriver();
            driver= TestBase.getDriver();
        }

    @Given("User enters URL and is on login page and entered credentials for Admin setting for grid")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsForAdminSettingForGrid() throws InterruptedException, AWTException
    {
//       // if(!flag)
//        {
            loginpage = new LoginPage(driver, scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
            loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
            loginpage.ClickSignin();
   //     }
    }

    @Given("User is on Home Page for Admin setting to select Admin option for grid")
    public void userIsOnHomePageForAdminSettingToSelectAdminOptionForGrid() throws InterruptedException
    {
        //if(!flag)
      //  {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
            flag=true;
     //   }
    }

    @When("User is on Home Page for Admin setting for grid")
    public void userIsOnHomePageForAdminSettingForGrid() throws InterruptedException
    {
        //if(!flag)
     //   {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
    //    }
    }

    @Then("User Clicks on Permissions by drop down to select Customer Account# grid")
    public void userClicksOnPermissionsByDropDownToSelectCustomerAccountGrid() throws InterruptedException
    {
        //if(!flag)
    //    {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickPermissionBy();
            adminHomePage.SelectCompany();
    //    }
    }

    @Then("User navigates to Available Grid and selects one of the grid type")
    public void userNavigatesToAvailableGridAndSelectsOneOfTheGridType()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectAvailableGrid();
        gridConfigPage.selectAnyGridType();
        gType=gridConfigPage.readGridType();
    }

    @And("User navigates to {string} and the selected grid type should be loaded")
    public void userNavigatesToAndTheSelectedGridTypeShouldBeLoaded(String gType)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectGridConfiguration();
        gridConfigPage.compareSelectedGrids(gType);
    }

    @Then("User should validate that it is Grid Configuration page, then click on Grid type Drop Down")
    public void userShouldValidateThatItIsGridConfigurationPageThenClickOnGridTypeDropDown()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectGridConfiguration();
        gridConfigPage.validateGridConfigurationPage();
        gridConfigPage.clickOnGridTypeDropDown();
    }

    @And("User should select Grid type {string} from the drop down")
    public void userShouldSelectGridTypeFromTheDropDown(String arg0)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectGridTypeDropDown(arg0);
    }

    @Then("User click on column chooser and validate visiblity of column chooser popup")
    public void userClickOnColumnChooserAndValidateVisiblityOfColumnChooserPopup(DataTable tabledata1)
    {
        List<List<String>> gName=tabledata1.asLists(String.class);
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.enterGridName(gName.get(0).get(0));
        gridConfigPage.clickOnColumnChooser();
        gridConfigPage.validateColumnChooser();
    }

    @And("User should drag and drop grid header to be added")
    public void userShouldDragAndDropGridHeaderToBeAdded(DataTable tabledata)
    {
        String tab;
        List<List<String>> tabs=tabledata.asLists(String.class);
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        for (int i=0;i<=tabs.size()-1;i++)
        {
            tab= String.valueOf(tabs.get(0).get(i));
            gridConfigPage.dragAndDropColumnHeader(tab);
        }
    }

    @And("User should Click and select {string} from grids dropdown")
    public void userShouldClickAndSelectFromGridsDropdown(String arg0)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.clickGridDropDown();
        gridConfigPage.gridDropdownSelection(arg0);
    }

    @Then("User clicks on Default grid toggle button")
    public void userClicksOnDefaultGridToggleButton()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.toggleDefaultGrid();
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @Then("User logout from Admin page and log in with client credentials")
    public void userLogoutFromAdminPageAndLogInWithClientCredentials() throws InterruptedException, AWTException
    {
        homePage=new HomePage(driver,scenario);
        homePage.Click_On_UserIcon();
        homePage.Click_On_Signout();
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.password());
        loginpage.ClickSignin();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }

    @Then("User navigates to Order entry page and in new order entry page finds same grid as default grid {string}")
    public void userNavigatesToOrderEntryPageAndInNewOrderEntryPageFindsSameGridAsDefaultGrid(String selectGrid,DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> PO_No = tabledata.asLists(String.class);
        //to navigate to Client side
        homePage = new HomePage(driver,scenario);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Admin");
        homePage.verifyUserinfoContainer();
        homePage.navigateToClientSide();

        //to navigate to Order entry page and change the customer account number
        orderPage = new OrderEntryPage(driver, scenario);
        orderPage.NavigateToOrderEntry();
        orderPage.ChangeAccount();
        orderPage.PopUps_After_AccountChange();

        if(HelpersMethod.IsExists("//div[@id='order-search-card']",driver))
        {
            orderPage = new OrderEntryPage(driver, scenario);
            orderPage.ValidateOE();
            //check for 'Start Order' button
            orderPage.Scroll_start();
            exists = orderPage.Start_Order();
            orderPage.NoPendingOrderPopup();
            //Selecting no Order guide and no note popup
            for (int i = 0; i <= 1; i++)
            {
                orderPage.OrderGuidePopup();
                orderPage.NoNotePopHandling();
            }
        }
        else
        {
            newOE = new NewOrderEntryPage(driver, scenario);
            newOE.Click_Back_But();
            orderPage = new OrderEntryPage(driver, scenario);
            orderPage.ValidateOE();
            //check for 'Start Order' button
            orderPage.Scroll_start();
            exists = orderPage.Start_Order();
            orderPage.NoPendingOrderPopup();
            //Selecting no Order guide and no note popup
            for (int i = 0; i <= 1; i++)
            {
                orderPage.OrderGuidePopup();
                orderPage.NoNotePopHandling();
            }
        }

        //Validate grid name in New OE page
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validateGridSelected(selectGrid);

        //after validating default grid in New OE page signout
        homePage=new HomePage(driver,scenario);
        homePage.Click_On_UserIcon();
        homePage.Click_On_Signout();

        //signin as admin again
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }

    @Then("User should reset Default grid toggle button {string}")
    public void userShouldResetDefaultGridToggleButton(String arg0)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.clickGridDropDown();
        gridConfigPage.gridMainDropdownSelection();
        gridConfigPage.toggleDefaultGrid();
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @Then("User reads all the grid names")
    public void userReadsAllTheGridNames()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        size1=gridConfigPage.readAllGridNames();
    }

    @And("User navigate to Available grid tab and finds all the grids available and disable any grid")
    public void userNavigateToAvailableGridTabAndFindsAllTheGridsAvailableAndDisableAnyGrid()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectAvailableGrid();
        gridConfigPage.validateAvailableGrid();
        gridConfigPage.selectAnyGridInAvailableGrid();
        gridConfigPage.readGridNameDisabledInAvailableGrid();
        gridConfigPage.disableAvailableGrid();
        //gridConfigPage.clickSaveButtonInAvailablegrid();
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @Then("User navigates back to Grid configuration tab and checks for available grid type in drop down")
    public void userNavigatesBackToGridConfigurationTabAndChecksForAvailableGridTypeInDropDown()
    {
        exists=false;
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectGridConfiguration();
        gridConfigPage.validateGridConfigurationPage();
        gridConfigPage.clickOnGridTypeDropDown();
        size2=gridConfigPage.readAllGridNames();
        scenario.log("NUMBER OF GRIDS FOUND IN DROP DOWN BEFORE DISABLING GRID "+size1);
        scenario.log("NUMBER OF GRIDS FOUND IN DROP DOWN AFTER DISABLING GRID "+size2);
        if(size1!=size2)
        {
            scenario.log("CONTENT OF GRID TYPE DROP DOWN ARE NOT SAME");
            exists=true;
        }
        else
        {
            scenario.log("CONTENT OF GRID TYPE DROP DOWN ARE SAME");
            exists=false;
        }
        Assert.assertTrue(exists);
    }

    @Then("User navigates back to Grid configuration tab and checks for available grid type in drop down after enabling tab")
    public void userNavigatesBackToGridConfigurationTabAndChecksForAvailableGridTypeInDropDownAfterEnablingTab()
    {
        exists=false;
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectGridConfiguration();
        gridConfigPage.validateGridConfigurationPage();
        scenario.log("NUMBER OF GRIDS FOUND IN DROP DOWN BEFORE DISABLING GRID "+size1);
        gridConfigPage.clickOnGridTypeDropDown();
        size2=gridConfigPage.readAllGridNames();
        scenario.log("NUMBER OF GRIDS FOUND IN DROP DOWN AFTER DISABLING GRID "+size2);
        if(size1==size2)
        {
            scenario.log("CONTENT OF GRID TYPE DROP DOWN ARE SAME");
            exists=true;
        }
        else
        {
            scenario.log("CONTENT OF GRID TYPE DROP DOWN ARE NOT SAME");
            exists=false;
        }
        Assert.assertTrue(exists);
    }

    @And("User should enable disabled grid in Available grid tab")
    public void userShouldEnableDisabledGridInAvailableGridTab()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectAvailableGrid();
        gridConfigPage.validateAvailableGrid();
        gridConfigPage.readGridNameDisabledInAvailableGrid();
        gridConfigPage.enableAvailableGrid();
        //gridConfigPage.clickSaveButtonInAvailablegrid();
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @And("User navigate to Available grid tab and select one of the grid and read all the column header available for selected grid")
    public void userNavigateToAvailableGridTabAndSelectOneOfTheGridAndReadAllTheColumnHeaderAvailableForSelectedGrid()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectAvailableGrid();
        gridConfigPage.validateAvailableGrid();
        gridConfigPage.selectAnyGridInAvailableGrid();
        gridConfigPage.readGridNameDisabledInAvailableGrid();
        columnName=gridConfigPage.readColumnNameToBeDisabled();
        gridConfigPage.disableAnyColumnNameInAvailableGrid(columnName);
    }

    @Then("User validates availability of disabled column in grid {string}")
    public void userValidatesAvailabilityOfDisabledColumnInGrid(String arg0)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectGridConfiguration();
        gridConfigPage.validateGridConfigurationPage();
        gridConfigPage.clickOnGridTypeDropDown();
        gridConfigPage.selectGridTypeDropDown(arg0);
        gridConfigPage.validateColumnNamesInSelectedGrid(columnName);
    }

    @And("User again enables column availability in Available grid")
    public void userAgainEnablesColumnAvailabilityInAvailableGrid()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectAvailableGrid();
        gridConfigPage.validateAvailableGrid();
        gridConfigPage.selectAnyGridInAvailableGrid();
        gridConfigPage.readGridNameDisabledInAvailableGrid();
        columnName=gridConfigPage.readColumnNameToBeDisabled();
        gridConfigPage.enableAnyColumnNameInAvailableGrid(columnName);
        //gridConfigPage.clickSaveButtonInAvailablegrid();
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @And("User clicks on Grid option{string} to copy and selects option from drop down")
    public void userClicksOnGridOptionToCopyAndSelectsOptionFromDropDown(String arg0)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.clickOnGridOptionDropdown();
        gridConfigPage.selectCopyFromGridOptionDropDown(arg0);
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @And("User clicks on Grid option{string} and select add option from drop down")
    public void userClicksOnGridOptionAndSelectAddOptionFromDropDown(String arg0)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.clickOnGridOptionDropdown();
        gridConfigPage.selectOptionFromGridOptionDropDown(arg0);
    }

    @And("User clicks on save button to save Grid configuration")
    public void userClicksOnSaveButtonToSaveGridConfiguration()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @Then("User should navigate back to Grid configuration and click on Save button")
    public void userShouldNavigateBackToGridConfigurationAndClickOnSaveButton()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectGridConfiguration();
        gridConfigPage.validateGridConfigurationPage();
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @Then("User Clicks on Permissions by drop down to select Customer Account# for grids")
    public void userClicksOnPermissionsByDropDownToSelectCustomerAccountForGrids() throws InterruptedException
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectCompany();
    }

    @And("User should navigate back to {string} via search bar and select {string}")
    public void userShouldNavigateBackToViaSearchBarAndSelect(String arg0, String arg1) 
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.clickOnHumbergerAgain();
        adminHomePage.EnterValueInSearchBox1(arg0,arg1);
        adminHomePage.handleSaveConfirmationPopup();
    }

    @Then("User refreshes page Clicks on Permissions by drop down to select Customer Account# grid")
    public void userRefreshesPageClicksOnPermissionsByDropDownToSelectCustomerAccountGrid() throws InterruptedException
    {
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.handleError_Page();
        adminHomePage.refreshPage();
        adminHomePage.ClickPermissionByAgain();
        adminHomePage.SelectCompany();
    }

    @Then("User enters {string} in grid name input box and saves it")
    public void userEntersInGridNameInputBoxAndSavesIt(String gridName)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.enterGridName(gridName);
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.validateSavedailogbox();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @And("User clicks on Grid option{string} to delete and selects option from drop down")
    public void userClicksOnGridOptionToDeleteAndSelectsOptionFromDropDown(String arg0)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.clickOnGridOptionDropdown();
        gridConfigPage.selectOptionFromGridOptionDropDown(arg0);
        //gridConfigPage.clickOnSaveButton();
        //gridConfigPage.validateSavedailogbox();
        //gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @And("User should select {string} from grids dropdown and selects {string} to delete grid")
    public void userShouldSelectFromGridsDropdownAndSelectsToDeleteGrid(String arg0, String arg1)
    {
        String gridName;
        String gridName1;
        WebElement dummy;
        Actions act=new Actions(driver);
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        //to expand the dropdown
        gridConfigPage.clickGridDropDown();
        //to read all the values in dropdown
        List<WebElement> gridNames=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/span[contains(text(),'"+arg0+"')]");
        ArrayList<String> gridText= new ArrayList<>();
        for(int i=0;i<=gridNames.size()-1;i++)
        {
            act.moveToElement(gridNames.get(i)).build().perform();
            dummy=gridNames.get(i);
            gridName1=dummy.getText();
            gridText.add(gridName1);
        }

        //to close dropdown
        gridConfigPage.clickGridDropDown();
        for(int i=0;i<=gridText.size()-1;i++)
        {
            gridConfigPage.clickGridDropDown();
            gridName=gridText.get(i);
            gridConfigPage.gridDropdownSelection(gridName);
            //Select delete from drop down
            gridConfigPage.clickOnGridOptionDropdown();
            gridConfigPage.selectOptionFromGridOptionDropDown(arg1);
        }
    }

    @Then("User changes label of header available in grid")
    public void userChangesLabelOfHeaderAvailableInGrid()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.readGridHeaderLabel();
        newLabel=gridConfigPage.enterNewLabel();
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @Then("User navigates to Order entry page and in new order entry page enter PO and Quick entry product details")
    public void userNavigatesToOrderEntryPageAndInNewOrderEntryPageEnterPOAndQuickEntryProductDetails(DataTable tabledata) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<List<String>> PO_No = tabledata.asLists(String.class);
        //to navigate to Client side
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("Admin"))
        {
            homePage = new HomePage(driver, scenario);
            homePage.verifyUserinfoContainer();
            homePage.navigateToClientSide();
        }

        //to navigate to Order entry page and change the customer account number
        orderPage = new OrderEntryPage(driver, scenario);
        orderPage.NavigateToOrderEntry();
        orderPage.ChangeAccount();
        orderPage.PopUps_After_AccountChange();

       /* newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_Back_But();*/

        if(!HelpersMethod.IsExists("//div[contains(@class,'order-entry-page')]",driver))
        {
            orderPage = new OrderEntryPage(driver, scenario);
            orderPage.ValidateOE();
            //check for 'Start Order' button
            orderPage.Scroll_start();
            exists = orderPage.Start_Order();
            //Selecting no Order guide and no note popup
            for (int i = 0; i <= 1; i++)
            {
                orderPage.NoPendingOrderPopup();
                orderPage.OrderGuidePopup();
                orderPage.NoNotePopHandling();
            }
        }
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.EnterPO_No(PO_No.get(0).get(0));
        String prodNo= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        newOE.QuickProduct(prodNo);

        String Case=PO_No.get(0).get(1);
        String Unit=PO_No.get(0).get(2);
        String uomString=newOE.VerifyUOM();
        if(uomString.equals("Units")||uomString.equals("EA"))
        {
            newOE.CheckForQuickUnitEnabled(Unit);
            if(uomString.equals("Units"))
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
        else if(uomString.equals("Cases")||uomString.equals("CS"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            if(uomString.equals("Cases"))
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
        else if(uomString.equals("Cases, Units")||uomString.equals("Units, Cases")||uomString.equals("CS, EA")||uomString.equals("EA, CS"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            newOE.CheckForQuickUnitEnabled(Unit);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }

        //verify labels of product grid
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        newOE.verifyProductGridTitle(newLabel);

        //after validating default grid in New OE page signout
        homePage=new HomePage(driver,scenario);
        homePage.Click_On_UserIcon();
        homePage.Click_On_Signout();

        //signin as admin again
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }

    @Then("User resets the label name to previous label, in grid setting")
    public void userResetsTheLabelNameToPreviousLabelInGridSetting()
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.resetLabelToOld();
        gridConfigPage.clickOnSaveButton();
        gridConfigPage.clickOnOkButtonInSavePopup();
    }

    @Then("User should navigate back to Grid configuration {string} and check for enabled column click on Save button")
    public void userShouldNavigateBackToGridConfigurationAndCheckForEnabledColumnClickOnSaveButton(String arg0)
    {
        gridConfigPage=new GridConfigurationPage(driver,scenario);
        gridConfigPage.selectGridConfiguration();
        gridConfigPage.validateGridConfigurationPage();
        gridConfigPage.clickOnGridTypeDropDown();
        gridConfigPage.selectGridTypeDropDown(arg0);
        gridConfigPage.validateColumnNamesInExistenceSelectedGrid(columnName);
    }
}
