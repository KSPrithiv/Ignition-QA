package stepDefination_DSD_OMS.OrderEntryPage;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class OrderEntryPageSteps3
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    boolean result=false;

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

    //code for checking preceding by zero, this works only in DSD env
    @And("User should verify the account_No")
    public void user_should_verify_the_account_no() throws InterruptedException, AWTException
    {
        result=false;
        orderpage = new OrderEntryPage(driver,scenario);
        result=orderpage.Account_Zero();
        if(result==true)
        {
            scenario.log("PRECEDING BY ZERO HAS BEEN EXECUTED SUCESSFULLY,PLEASE DO CHECK ADMIN SETTINGS");
        }
        else
        {
            scenario.log("PRECEDING BY ZERO HAS BEEN FAILED, PLEASE DO CHECK ADMIN SETTINGS");
        }
        Assert.assertEquals(result,true);
    }

    //Code for Adding new Address for Delivery Address
    @Then("Click on Next button and Add new Delivery Addresss")
    public void click_on_next_button_and_add_new_delivery_address(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Address_Add=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        checkorder.Add_Delivery_Address(Address_Add.get(0).get(0),Address_Add.get(0).get(1),Address_Add.get(0).get(2),Address_Add.get(0).get(3),Address_Add.get(0).get(4),Address_Add.get(0).get(5));
        checkorder.Click_On_Without_Providing_Payment();
        checkorder.NextButton_Click();
    }

    //Code to Edit the delivery address
    @Then("Click on Next button and Edit Delivery Addresss")
    public void click_on_next_button_and_edit_delivery_address(DataTable tabledata) throws InterruptedException, AWTException
    {
        boolean result=false;
        List<List<String>> Change_Add=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        result=checkorder.Edit_DeliveryAddress(Change_Add.get(0).get(0),Change_Add.get(0).get(1));
        Assert.assertEquals(true,result);
        checkorder.Click_On_Without_Providing_Payment();
        checkorder.NextButton_Click();
    }

    //Code for Deleting Delivery Address
    @Then("Click on Next button and Delete Address")
    public void click_on_next_button_and_delete_address(DataTable tabledata) throws InterruptedException, AWTException
    {
        boolean result=false;
        List<List<String>> DelAdd=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        result=checkorder.Delete_DeliveryAddress(DelAdd.get(0).get(0));
        Assert.assertEquals(true,result);
        checkorder.Click_On_Without_Providing_Payment();
        checkorder.NextButton_Click();
    }

    //Code to display Qty as Zero, for those products which are out of stock, in summary page
    @Then("In Order Summary page check whether Low inventory products are removed or not")
    public void in_order_summary_page_check_whether_low_inventory_products_are_removed_or_not() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        int OutOfStockCount=driver.findElements(By.xpath("//tr[contains(@class,'k-master-row')]/descendant::div[contains(@class,'icon-preview-background') and contains(@title,'Out of stock')]")).size();
        List<WebElement> Heads=driver.findElements(By.xpath("//tr[1]/th"));
        int i=0;
        for(WebElement head:Heads)
        {
            i++;
            String head_Text=head.getText();
            if(head_Text.contains("Units"))
            {
                break;
            }
        }
        int OutOfStockUnit=driver.findElements(By.xpath("//div[contains(@class,'icon-preview-background ')]/ancestor::tr[contains(@class,'k-master-row')]/descendant::td["+i+"]/descendant::span[text()='0']")).size();
        Assert.assertEquals(OutOfStockCount,OutOfStockUnit);
        if(OutOfStockCount==0)
        {
            scenario.log("NO OUT OF STOCK PRODUCT HAS BEEN FOUND");
        }
        else
        {
            scenario.log(OutOfStockCount+" OUT OF STOCK PRODUCT HAS BEEN FOUND");
        }
    }

    //Code for sorting the products based on Qty entered for 'Units', in products grid of New OE page
    @And("Click on Aroow symbol to display products based on descending order of units")
    public void click_on_arrow_symbol_to_display_products_based_on_descending_order_of_units() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        boolean result=newOE.clickOnArrow_UnitsAscedning();
        Assert.assertEquals(result,false);
    }

    //Select the 1st route that appears in the Route popup in OE page
    @And("Select 1st route from Route popup")
    public void select_1st_route_from_route_popup() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.Route_Popup();
        orderpage.Route1();
    }

    //Select the 2nd route that appears in the the route popup in New OE page
    @And("Read 2nd route value and select 2nd route with that validate route has changed or not")
    public void read_2nd_route_value_and_select_2nd_route_with_that_validate_route_has_changed_or_not() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.RouteIndex();
        String Route1=newOE.SelectRoute();
        Route1=Route1.replaceAll("[-]", " ");
        Route1=Route1.replaceAll("\\s+"," ");

        String Route2=newOE.ReadRoute();
        Route2=Route2.replaceAll("[-]"," ");
        Route2=Route2.replaceAll("\\s+"," ");

        //Assert.assertEquals(Route1,Route2);
    }

    //Code for adding new Payment mode
    @Then("Click on Next button and add new Payment method")
    public void click_on_next_button_and_add_new_payment_method(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> AccDetails=tabledata.asLists(String.class);
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        checkorder.Select_PaymentMethod_ClickDownArrow();
        checkorder.Adding_New_PaymentMethod(AccDetails.get(0).get(0),AccDetails.get(0).get(1));
        checkorder.Click_On_Without_Providing_Payment();
        checkorder.Delivery_Address_ClickDownArrow();
        checkorder.DeliveryAddressCard();
        checkorder.NextButton_Click();
    }

    //Code for Deleting payment method
    @Then("Click on Next button and Delete Payment method")
    public void click_on_next_button_and_delete_payment_method(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> AccDetails=tabledata.asLists(String.class);
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        checkorder.Select_PaymentMethod_ClickDownArrow();
        checkorder.Delete_PaymentMethod();
        if(HelpersMethod.IsExists("//div[contains(text(),'Confirm delete')]/ancestor::div[@class='k-widget k-window k-dialog']",driver))
        {
            HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='Yes']"),1);
        }
        checkorder.Click_On_Without_Providing_Payment();
        checkorder.Delivery_Address_ClickDownArrow();
        checkorder.DeliveryAddressCard();
        checkorder.NextButton_Click();
    }

    @Then("User should find select first OG from popup")
    public void userShouldFindSelectFirstOGFromPopup() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.SelectOrderGuidePopup();
    }

    @Then("User should click on price override icon and Change price using What if option Price by price")
    public void userShouldClickOnPriceOverrideIconAndChangePriceUsingWhatIfOption(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> priceVal=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_On_PriceOverrideIcon();
        newOE.PriceOverridePopup_WhatIfPricePrice(priceVal.get(0).get(0));
        for(int i=0;i<=1;i++)
        {
            newOE.priceCannotBeBleowCost();
            newOE.exceedsMaxQty();
        }
    }

    @Then("User should click on price override icon and Change price using What if option Price per unit")
    public void userShouldClickOnPriceOverrideIconAndChangePriceUsingWhatIfOptionPricePerUnit(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> priceVal=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_On_PriceOverrideIcon();
        newOE.PriceOverridePopup_WhatIfPriceUnit(priceVal.get(0).get(0));
        for(int i=0;i<=1;i++)
        {
            newOE.priceCannotBeBleowCost();
            newOE.exceedsMaxQty();
        }
    }
}
