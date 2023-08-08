package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.setupConfiguration.*;
import org.testng.asserts.SoftAssert;
import ui.pages.setupLabor.SetupLaborCodePage;

@Slf4j

public class TaskGroupPageSteps {
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage=new SetupLaborCodePage(driver);
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();

    TaskGroupPage taskGroupPage=new TaskGroupPage();
    SoftAssert softAssert = new SoftAssert();



    @And("Validate Add is enabled and Edit, Delete are disabled")
    public void validateAddEditDeleteButtonsActivity() {
        softAssert.assertFalse(taskGroupPage.checkAddBtnDisabled() != null, "Add Button is not disabled");
//        softAssert.assertTrue(taskGroupPage.checkAddBtnDisabled().equals("true"), "Add Button is not displayed");

        softAssert.assertTrue(taskGroupPage.isEditBtnDisabled().equals("true"), "Edit Button is not disabled");
        softAssert.assertTrue(taskGroupPage.isDeleteBtnDisabled().equals("true"), "Delete Button is not disabled");
        softAssert.assertAll();
    }
    @And("Verify Search field")
    public void verifySearchfield() {
        softAssert.assertTrue(taskGroupPage.isSearchFieldDisplayed(), "Search Field is not displayed");
//        Assert.assertEquals(true, taskGroupPage.isSearchFieldDisplayed(), " Search field is not displayed");
//        taskGroupPage.verify();
    }
    @And("Verify Item found is displayed")
    public void verifyItemFound() {
        softAssert.assertTrue(taskGroupPage.isItemFoundDisplayed(), "ItemFound Field is not displayed");
//        Assert.assertEquals(true, taskGroupPage.isItemFoundDisplayed(), " Secondary colour not selected correctly");
    }
    @And("Verify Add Filter button is displayed")
    public void verifyAddFilterButton() {
        softAssert.assertTrue(taskGroupPage.isAddFilterDisplayed(), "Add Filter button is not displayed");
//        Assert.assertEquals(true, taskGroupPage.isItemFoundDisplayed(), " Secondary colour not selected correctly");
    }

    @And("Go to TaskGroup Tab")
    public void clickTaskGroupTab() throws InterruptedException {
        log.info("click on Task Group");
        taskGroupPage.taskGroupTab();
    }
    @And("Click on Search field on TaskGroup Page")
    public void clickTaskGroupTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        taskGroupPage.taskGroupTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
    @And("Creating TaskGroup with unique Code")
    public void createTaskGroupWithUniqueCode(){
        log.info("Creating TaskGroup with unique Code");
        taskGroupPage.enterCode();
        taskGroupPage.enterDescription();
    }
    @And("Enter Save")
    public void enterSave(){
        log.info("Enter Save");
        setupLaborCodePage.enterSave();
    }
}
