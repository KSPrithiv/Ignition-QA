package stepDefination_DSD_OMS.OrderControlList;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import util.RandomValues;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya Ramadas
 */
public class OrderControlPageSteps2
{
    /* Created by Divya Ramadas */
    WebDriver driver;
    Scenario scenario;

    static OrderControlListPage orderControlList;
    static NewOrderEntryPage newOE;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should enter comment in comment popup with lengthy note")
    public void userShouldEnterCommentInCommentPopupWithLengthyNote() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        String commentText= RandomValues.generateRandomString(2000);
        newOE.validateCommentPopup();
        newOE.Comment_Popup(commentText);
    }
}
