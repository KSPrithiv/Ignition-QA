package steps.setupConfiguration;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.*;
import ui.pages.setupLabor.SetupLaborCodePage;

@Slf4j

public class TaskGroupPageSteps {
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage=new SetupLaborCodePage(driver);
    TaskGroupPage taskGroupPage=new TaskGroupPage();

    @And("Go to TaskGroup Tab")
    public void clickTaskGroupTab() throws InterruptedException {
        log.info("click on Task Group");
        taskGroupPage.taskGroupTab();
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
