package stepDefination_DSD_OMS.OrderEntryPage;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderEntryPageSteps4
{
    /* Created by Divya.Ramadas@afsi.com */

    WebDriver driver;
    Scenario scenario;

    static boolean exists=false;

    static OrderEntryPage orderpage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static CheckOutOrderPage checkorder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("Click on Next button and Click on Without providing payment")
    public void click_on_next_button_and_click_on_without_providing_payment() throws InterruptedException, AWTException
    {
        exists=false;
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ClickNext();
        Assert.assertEquals(exists,true);
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        checkorder.DeliveryAddressCard();
        checkorder.Click_On_Without_Providing_Payment();
        checkorder.NextButton_Click();
    }

    //Add comment in comment popup, for product leve
    @Then("User should click on Comment icon in Product grid")
    public void user_should_click_on_comment_icon_in_product_grid() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Prod_Comment_Icon();
    }

    @And("should enter comment in comment popup")
    public void should_enter_comment_in_comment_popup(DataTable tabledata)
    {
        List<List<String>> Comment=tabledata.asLists(String.class);
        newOE.validateProductComment();
        newOE.Comment_PopupProd(Comment.get(0).get(0));
    }

    //To check whether after adding note to product in product grid, icon color has changed or not
    @Then ("Check Comment Icon color at product level has changed or not")
    public void check_comment_icon_color_at_product_level_has_changed_or_not() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        boolean color=newOE.ProNote_Color();
        Assert.assertEquals(true,color);
    }

    @And("User should enter comment in comment popup at Product level")
    public void userShouldEnterCommentInCommentPopupAtProductLevel(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> ProComm=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.AddProdComm(ProComm.get(0).get(0));
        newOE.Comment_Add();
    }

    @And("User click on Update button in popup and Validate {string}")
    public void userClickOnUpdateButtonInPopupAndValidate(String UComm) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Update_Button();
        exists=newOE.ValidateProdComment(UComm);
        Assert.assertEquals(exists,true);
        newOE.Comment_Ok();
    }

    @Then("User should select comment from grid and edit comment as {string}")
    public void userShouldSelectCommentFromGridAndEditCommentAs(String UComm) throws InterruptedException, AWTException
    {
        exists=false;
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.SelectComment();
        newOE.UpdateComment(UComm);
    }

    @Then("User should select Note from popup and select OG from OG popup")
    public void userShouldSelectNoteFromPopupAndSelectOGFromOGPopup() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        for(int i=0;i<=1;i++)
        {
            orderpage.NO_NotePopup();
            orderpage.SelectOrderGuidePopup();
        }
    }

    @And("User should navigate to New OE page, and enter Qty to product in product grid")
    public void userShouldNavigateToNewOEPageAndEnterQtyToProductInProductGrid(DataTable tabledata) throws InterruptedException, AWTException
    {
        exists=false;
        List<List<String>> UnitCase=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        Assert.assertEquals(exists,true);
        newOE.EnterUnitQtyProductLine(UnitCase.get(0).get(0));
        newOE.EnterCaseQtyProductLine(UnitCase.get(0).get(1));
    }

    @And("User should navigate to New OE page, and enter Qty to product in product grid more than Maximum limit")
    public void userShouldNavigateToNewOEPageAndEnterQtyToProductInProductGridMoreThanMaximumLimit(DataTable tabledata) throws InterruptedException, AWTException
    {
        exists=false;
        List<List<String>> UnitCase=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        Assert.assertEquals(exists,true);
        //newOE.EnterUnusualQtyProductLine(UnitCase.get(0).get(0),UnitCase.get(0).get(1));
        newOE.EnterUnusualUnitQtyProductLine(UnitCase.get(0).get(0));
        newOE.EnterUnusualCaseQtyProductLine(UnitCase.get(0).get(1));
    }

    @And("User should navigate to New OE page, and enter Qty to product in product grid for only Unit")
    public void userShouldNavigateToNewOEPageAndEnterQtyToProductInProductGridForOnlyUnit(DataTable tabledata) throws InterruptedException, AWTException
    {
        exists=false;
        List<List<String>> UnitCase=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        newOE.EnterUnusualUnitQtyProductLine(UnitCase.get(0).get(0));
    }

    @And("User should navigate to New OE page, and enter Qty to product in product grid for only Case")
    public void userShouldNavigateToNewOEPageAndEnterQtyToProductInProductGridForOnlyCase(DataTable tabledata) throws InterruptedException, AWTException
    {
        exists=false;
        List<List<String>> UnitCase=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        newOE.EnterUnusualCaseQtyProductLine(UnitCase.get(0).get(0));
    }

    @Then("User should click on Back button in NewOE page and popup should appear")
    public void userShouldClickOnBackButtonInNewOEPageAndPopupShouldAppear() throws InterruptedException, AWTException
    {
        exists=false;
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_Back_But_NextButton();
    }

    @And("In Save order without submitting popup should select next button")
    public void inSaveOrderWithoutSubmittingPopupShouldSelectNextButton() throws InterruptedException, AWTException
    {
        exists=false;
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.SaveOrderWithOutSubmitting_Next();
        Assert.assertEquals(exists,true);
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']",driver))
            {
                checkorder.SelectPaymentMethod();
                scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
            }
            else
            {
                checkorder.Click_On_Without_Providing_Payment();
                scenario.log("WITHOUT PROVIIDNG PAYMENT OPTION HAS BEEN SELECTED");
            }
        }
        checkorder.DeliveryAddressCard();
        checkorder.NextButton_Click();
    }

    @Then("User should select Note from popup")
    public void userShouldSelectNoteFromPopup() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NO_NotePopup();
    }

    @And("should enter comment in comment popup for updating")
    public void shouldEnterCommentInCommentPopupForUpdating(DataTable tabledata)
    {
        List<List<String>> Comment=tabledata.asLists(String.class);
        newOE.Comment_PopupProdUpdate(Comment.get(0).get(0));
    }
}
