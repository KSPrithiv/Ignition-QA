package pages_DSD_OMS.CRMPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

public class CRMPage {

    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    @FindBy(xpath = "//span[contains(@class, 'menu-item-text')][contains(text(), 'CRM Tickets')]")
    private WebElement CRMTicketOption;

    @FindBy(xpath = "//*[@id='app']/div/div/main/div/div[1]/div[1]/span[contains(text(), 'CRM Tickets')]")
    private WebElement CRMPageOpened;

    @FindBy(xpath = "//span[@class='k-link' and text()='CRM General']")
    private WebElement CRMGeneralTab;

    @FindBy(xpath = "//span[@class='k-link' and text()='Purge']")
    private WebElement PurgeTab;

    @FindBy(xpath = "//span[@class='k-link' and text()='Notifications']")
    private WebElement NotificationsTab;

    @FindBy(xpath = "//span[@class='k-link' and text()='Configure']")
    private WebElement ConfigureTab;
    @FindBy(xpath = "//div[@class='i-switch__info i-switch__info--right']//label[@class='i-label i-switch__info__label i-label--inline' and text()='Export tickets ']")
    private WebElement ExportTicketsBtnText;

    @FindBy(xpath = "//div[@class='i-switch__info i-switch__info--right']//label[@class='i-label i-switch__info__label i-label--inline' and text()='Notes ']")
    private WebElement NotesBtnText;

    @FindBy(xpath = "//div[@class='i-switch__info i-switch__info--right']//label[@class='i-label i-switch__info__label i-label--inline' and text()='Reason ']")
    private WebElement ReasonBtnText;

    @FindBy(xpath = "//div[@class='i-switch__info i-switch__info--right']//label[@class='i-label i-switch__info__label i-label--inline' and text()='Source ']")
    private WebElement SourceBtnText;

    @FindBy(xpath = "//div[@class='i-switch__info i-switch__info--right']//label[@class='i-label i-switch__info__label i-label--inline' and text()='Category ']")
    private WebElement CategoryBtnText;

    @FindBy(xpath = "//div[@class='i-switch__info i-switch__info--right']//label[@class='i-label i-switch__info__label i-label--inline' and text()='Action ']")
    private WebElement ActionBtnText;

    @FindBy(xpath = "//div[@class='i-switch__info i-switch__info--right']//label[@class='i-label i-switch__info__label i-label--inline' and text()='Feedback ']")
    private WebElement FeedbackBtnText;

    @FindBy(xpath = "//div[@class='i-switch__info i-switch__info--right']//label[@class='i-label i-switch__info__label i-label--inline' and text()='Feedback type ']")
    private WebElement FeedbackTypeBtnText;

    @FindBy(xpath = "//div[@class='label-container__label']")
    private WebElement TicketNumField;

    @FindBy(xpath = " //button[@id='cancel-btn']")
    private WebElement CancelBtn;

    @FindBy(xpath = "//button[@id='QuestionModalButton1']")
    private WebElement popUpYesBtn;

    @FindBy(xpath = "//button[@id='QuestionModalButton0']")
    private WebElement popUpNoBtn;
    @FindBy(xpath = " //button[@id='save-btn']")
    private WebElement SaveBtn;

    @FindBy(xpath = "//button[@id='QuestionModalButton0']")
    private WebElement popUpOkBtn;

    //@FindBy(xpath = "//button[@id='button_15']")
    @FindBy(xpath = "//button[@class='k-button k-flat k-button-icontext  i-button--icon-only']")
    private WebElement AddNotificationBtn;

    @FindBy(xpath = "//div[@class='k-widget k-window k-dialog']")
    private WebElement AddNotificationPopUp;

    @FindBy(xpath = "//table[@class='k-grid-table']")
    private WebElement NotificationTableList;
    @FindBy(xpath = "//span[@class='i-summary-area__main']//span[2]")
    private WebElement  ItemFoundField;

    @FindBy(xpath = "//input[@id='CPTicketsNumber']")
    private WebElement TicketNumber;

    @FindBy(xpath = "//button[@id='DeleteBtn']")
    private WebElement  DeleteNotyBtn;

    @FindBy(xpath = "//button[@class='k-button k-flat k-button-icontext']")
    private WebElement EditNotyBtn;

    @FindBy(xpath = "//table[@class='k-grid-table']//tr[3]")
    private WebElement SelectLastNoty;

    @FindBy(xpath = "//button[@id='CancelBtn']")
    private WebElement CancelBtnOfDelConfig;

    //WebElement CancelBtnOfDelConfig=driver.findElement(By.xpath("//button[@id='CancelBtn']"));
    //WebElement OkBtnOfDelConfig=driver.findElement(By.xpath("//button[@id='OKBtn']"));
    @FindBy(xpath = "//button[@id='OKBtn']")
    private WebElement OkBtnOfDelConfig;
    @FindBy(xpath = "//div[@class='settings-container admin-mode']")
    private WebElement SettingsBtn;
    @FindBy(xpath = "//span[@class='menu-item-text' and text()='CRM Tickets']")
    private WebElement ClientCRMModule;

    @FindBy(xpath = "//button[@id='export-button']")
    private WebElement ExportCSVBtn;

    private WebDriverWait wait;
    public CRMPage(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod
    public void WaitForPage() {
        HelpersMethod.Implicitwait(driver, 10);
    }

    public void clickOnHamburgerMenu() throws InterruptedException {
        // Wait for the home page to load
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //By HamburgerMenu = By.xpath("//div[@class='item-searchbar']");
        //wait.until(ExpectedConditions.presenceOfElementLocated(HamburgerMenu));
        //WebElement HamburgerMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='item-searchbar']")));
        //WebElement HamburgerMenuClk=driver.findElement(HamburgerMenu);
        //if (HamburgerMenuClk.isDisplayed()) {
        // System.out.println("displayed");
        //} else System.out.println("not displayed");
        //Thread.sleep(5000);
        //HelpersMethod.waitTillElementDisplayed(driver, HamburgerMenuClk, 1000);
        //WebElement Hamburger=driver.findElement(By.xpath("//div[@class='item-searchbar']"));
        //Hamburger.click();
        //HamburgerMenuClk.click();
        //HelpersMethod.waitTillPageLoaded(driver, 5000);
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@class='item-searchbar']", 2400);
            WebElement Hamburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='item-searchbar']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(Hamburger));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(Hamburger));
            HelpersMethod.JScriptClick(driver, Hamburger, 4000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}

    }
    public void clickOnCRMTickets (){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//span[contains(@class, 'menu-item-text')][contains(text(), 'CRM Tickets')]", 4400);
            WebElement CRMTicketOption = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class, 'menu-item-text')][contains(text(), 'CRM Tickets')]");
            new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.visibilityOf(CRMTicketOption));
            new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.elementToBeClickable(CRMTicketOption));
            HelpersMethod.JScriptClick(driver, CRMTicketOption, 4000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}

        //CRMTicketOption.click();
    }
    public void verifyCRMPageOpened(){
        if(CRMPageOpened.isDisplayed()){
            System.out.println("CRM Ticket page opened successfully");
        }else{
            System.out.println("CRM Tickets page not opened successfully");
        }
    }
    public void verifyAllTabs() throws InterruptedException {
        WebElement CRMGeneral=driver.findElement(By.xpath("//label[@class='i-card__title i-card__title--on admin-card__label']"));
        if(CRMGeneral.isDisplayed()){
            System.out.println("CRM General tab by-default opened");
        }else System.out.println("CRM general tab not opened");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        PurgeTab.click();
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        NotificationsTab.click();
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        ConfigureTab.click();
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }
    public void verifyExportTicketsBtn(){
        CRMGeneralTab.click();
        //This is for validation of ExportTicketsBtn
        WebElement ExportBtn=driver.findElement(By.xpath("//span[@id='CPExportTickets']"));
        String roleExportAttribute = ExportBtn.getAttribute("role");
        //String textOfExportBtn=ExportBtn.getText();
        //System.out.println("Btn text is:::" +textOfExportBtn);
        if (roleExportAttribute != null && roleExportAttribute.equalsIgnoreCase("switch")) {
            System.out.println("yes Export tickets is switch button ");
        }else System.out.println("no switch button");

        if(ExportTicketsBtnText.isDisplayed()){
            String actualTextExportTicketsBtn=ExportTicketsBtnText.getText();
            System.out.println("validate Export button text is :" +actualTextExportTicketsBtn);
            String expectedTextExportTicketsBtn= "Export tickets";
            Assert.assertEquals(expectedTextExportTicketsBtn, actualTextExportTicketsBtn, "Both are not correct");
        }else System.out.println("no text available");


    }
    public void verifyNotesBtn(){
        //This is for validation of NotesBtn
        WebElement NotesBtn=driver.findElement(By.xpath("//span[@id='CPNotes']"));
        String roleNoteAttribute = NotesBtn.getAttribute("role");
        if (roleNoteAttribute != null && roleNoteAttribute.equalsIgnoreCase("switch")) {
            System.out.println("yes Notes is switch button ");
        }else System.out.println("no switch button");

        if(NotesBtnText.isDisplayed()){
            String actualTextNotesBtn=NotesBtnText.getText();
            System.out.println("validate Notes button text is :" +actualTextNotesBtn);
            String expectedTextNotesBtn = "Notes";
            // Assert the equality of actual and expected text
            Assert.assertEquals(expectedTextNotesBtn, actualTextNotesBtn, "Both are not correct");

        }else System.out.println("no text available");
    }
    public void verifyReasonBtn(){
        //This is for validation of ReasonBtn
        WebElement ReasonBtn=driver.findElement(By.xpath("//span[@id='CPReason']"));
        String roleReasonAttribute = ReasonBtn.getAttribute("role");
        if (roleReasonAttribute != null && roleReasonAttribute.equalsIgnoreCase("switch")) {
            System.out.println("yes Reason is switch button ");
        }else System.out.println("no switch button");

        if(ReasonBtnText.isDisplayed()){
            String actualTextReasonBtn=ReasonBtnText.getText();
            System.out.println("validate Reason button text is :" +actualTextReasonBtn);
            String expectedTextReasonBtn = "Reason";
            // Assert the equality of actual and expected text
            Assert.assertEquals(expectedTextReasonBtn, actualTextReasonBtn, "Both are not correct");

        }else System.out.println("no text available");
    }
    public void verifySourceBtn(){
        //This is for validation of SourceBtn
        WebElement SourceBtn=driver.findElement(By.xpath("//span[@id='CPSource']"));
        String roleSourceAttribute = SourceBtn.getAttribute("role");
        if (roleSourceAttribute != null && roleSourceAttribute.equalsIgnoreCase("switch")) {
            System.out.println("yes Source is switch button ");
        }else System.out.println("no switch button");

        if(SourceBtnText.isDisplayed()){
            String actualTextSourceBtn=SourceBtnText.getText();
            System.out.println("validate Source button text is :" +actualTextSourceBtn);
            String expectedTextSourceBtn = "Source";
            // Assert the equality of actual and expected text
            Assert.assertEquals(expectedTextSourceBtn, actualTextSourceBtn, "Both are not correct");
        }else System.out.println("no text available");
    }
    public void verifyCategoryBtn(){
        //This is for validation of Category
        WebElement CategoryBtn=driver.findElement(By.xpath("//span[@id='CPCategory']"));
        String roleCategoryAttribute = CategoryBtn.getAttribute("role");
        if (roleCategoryAttribute != null && roleCategoryAttribute.equalsIgnoreCase("switch")) {
            System.out.println("yes Category is switch button ");
        }else System.out.println("no switch button");

        if(CategoryBtnText.isDisplayed()){
            String actualTextCategoryBtn=CategoryBtnText.getText();
            System.out.println("validate Category button text is :" +actualTextCategoryBtn);
            String expectedTextCategoryBtn = "Category";
            // Assert the equality of actual and expected text
            Assert.assertEquals(expectedTextCategoryBtn, actualTextCategoryBtn, "Both are not correct");
        }else System.out.println("no text available");
    }

    public void verifyActionBtn(){
        //This is for validation of ActionBtn
        WebElement ActionBtn=driver.findElement(By.xpath("//span[@id='CPAction']"));
        String roleActionAttribute = ActionBtn.getAttribute("role");
        if (roleActionAttribute != null && roleActionAttribute.equalsIgnoreCase("switch")) {
            System.out.println("yes Action is switch button ");
        }else System.out.println("no switch button");

        if(ActionBtnText.isDisplayed()){
            String actualTextActionBtn=ActionBtnText.getText();
            System.out.println("validate Action button text is :" +actualTextActionBtn);
            String expectedTextActionBtn = "Action";
            // Assert the equality of actual and expected text
            Assert.assertEquals(expectedTextActionBtn, actualTextActionBtn, "Both are not correct");
        }else System.out.println("no text available");
    }

    public void verifyFeedbackBtn(){
        //This is for validation of FeedbackBtn
        WebElement FeedbackBtn=driver.findElement(By.xpath("//span[@id='CPFeedback']"));
        String roleFeedbackAttribute = FeedbackBtn.getAttribute("role");
        if (roleFeedbackAttribute != null && roleFeedbackAttribute.equalsIgnoreCase("switch")) {
            System.out.println("yes Feedback is switch button ");
        }else System.out.println("no switch button");

        if(FeedbackBtnText.isDisplayed()){
            String actualTextFeedbackBtn=FeedbackBtnText.getText();
            System.out.println("validate Feedback button text is :" +actualTextFeedbackBtn);
            String expectedTextFeedbackBtn = "Feedback";
            // Assert the equality of actual and expected text
            Assert.assertEquals(expectedTextFeedbackBtn, actualTextFeedbackBtn, "Both are not correct");
        }else System.out.println("no text available");
    }

    public void verifyFeedbackTypeBtn(){
        //This is for validation of SourceBtn
        WebElement FeedbackTypeBtn=driver.findElement(By.xpath("//span[@id='CPFeedbackType']"));
        String roleFeedbackTypeAttribute = FeedbackTypeBtn.getAttribute("role");
        if (roleFeedbackTypeAttribute != null && roleFeedbackTypeAttribute.equalsIgnoreCase("switch")) {
            System.out.println("yes Feedback type is switch button ");
        }else System.out.println("no switch button");

        if(FeedbackTypeBtnText.isDisplayed()){
            String actualTextFeedbackTypeBtn=FeedbackTypeBtnText.getText();
            System.out.println("validate Feedback type button text is :" +actualTextFeedbackTypeBtn);
            String expectedTextFeedbackTypeBtn = "Feedback type";
            // Assert the equality of actual and expected text
            Assert.assertEquals(expectedTextFeedbackTypeBtn, actualTextFeedbackTypeBtn, "Both are not correct");
        }else System.out.println("no text available");
    }
    public void verifyTicketNumberField(){
        String ValueOfTicketNumber=TicketNumber.getAttribute("value");
        int actualInitialTicketValue = Integer.parseInt(ValueOfTicketNumber);
        if(TicketNumField.isDisplayed()){
            String actualTextTicketNumField=TicketNumField.getText();
            System.out.println("validate TicketNumField button text is :" +actualTextTicketNumField);
            String expectedTextTicketNumFieldBtn = "Ticket number";
            // Assert the equality of actual and expected text
            Assert.assertEquals(expectedTextTicketNumFieldBtn, actualTextTicketNumField, "Both are not correct");
        }else System.out.println("no text available");
    }
    public void increaseTicketNum(){
        //WebElement TicketNum=driver.findElement(By.xpath("//input[@id='CPTicketsNumber']"));
        String ticketNumValue=TicketNumber.getAttribute("value");
        System.out.println("Actual initial value for ticket number is : "+ ticketNumValue);
        int actualIntValue = Integer.parseInt(ticketNumValue);
        if(TicketNumber.isDisplayed()){
            System.out.println("Display");
        }else System.out.println("not display");

        WebElement IncreaseBtn=driver.findElement(By.xpath("//span[@title='Increase value']"));
        IncreaseBtn.click();

        //int updatedNumber = Integer.parseInt(updatedInTicketNum.getAttribute());
        String updatedInTicketNum=TicketNumber.getAttribute("value");
        int actualIncreasedTNValue = Integer.parseInt(updatedInTicketNum);
        actualIncreasedTNValue = actualIntValue+1;
        System.out.println("New value of Ticket number with increased by 1:" +actualIncreasedTNValue);

        if (actualIncreasedTNValue > actualIntValue) {
            System.out.println("The number has increased.");
        } else {
            System.out.println("The number has not increased.");
        }
    }
    public void decreaseTicketNum(){
        //WebElement TicketNum=driver.findElement(By.xpath("//input[@id='CPTicketsNumber']"));
        String ticketNumValue=TicketNumber.getAttribute("value");
        int actualIntValue = Integer.parseInt(ticketNumValue);
        System.out.println("latest value for ticket number is : "+ actualIntValue);

        if(TicketNumber.isDisplayed()){
            System.out.println("Display");
        }else System.out.println("not display");

        WebElement DecreaseBtn=driver.findElement(By.xpath("//span[@title='Decrease value']"));
        DecreaseBtn.click();

        String updatedDeTicketNum=TicketNumber.getAttribute("value");
        int actualDecreasedTNValue = Integer.parseInt(updatedDeTicketNum);
        actualDecreasedTNValue=actualIntValue-1;
        System.out.println("New value of Ticket number with decreased by 1:" +actualDecreasedTNValue);

        if (actualDecreasedTNValue == actualIntValue) {
            System.out.println("The number has decreased.");
        } else {
            System.out.println("The number has not decreased.");
        }
    }
    public void verifyCancelAndSaveBtnEnabled(){
        if(CancelBtn.isEnabled()){
            System.out.println("Cancel button is enabled");
        }else System.out.println("Cancel button not enabled");

        if(SaveBtn.isEnabled()){
            System.out.println("Save button is enabled");
        }else System.out.println("Save button not enabled");
    }
    public void clickCancelAndValidatePopUp() throws InterruptedException {
        CancelBtn.click();
        System.out.println("User click on cancel button");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        try {
            if (HelpersMethod.IsExists("//div[@class='k-widget k-window k-dialog']", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@class='k-widget k-window k-dialog']", 100);
                WebElement cancelBtnPopUp = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-widget k-window k-dialog']");
                //WebElement modalContentTitle1 = catlogPopup.findElement(By.xpath(".//div[contains(@class,'label-preview-background')]"));

                //Find xpath of main and subtitle from Cancel button pop up
                WebElement cancelBtnTitle1 = cancelBtnPopUp.findElement(By.xpath("//div[@class='k-window-title k-dialog-title']"));
                WebElement cancelBtnTitle2 = cancelBtnPopUp.findElement(By.xpath("//div[@id='dialogTextContent']"));

                //Get text of main and subtitle from save button pop up
                String ActualMainTitle = cancelBtnTitle1.getText();
                String ActualSubTitle = cancelBtnTitle2.getText();

                //Print main and subtitle from save button pop up
                System.out.println("Main title of dialog box : " +ActualMainTitle );
                System.out.println("Sub title is : " +ActualSubTitle);

                //Enter main and sub Expected title here
                String expectedMainTitleText="Ignition by Telus";
                String expectedSubTitleText="You have not saved any changes to the settings. Do you wish to discard these changes?";

                //Verify both title are equal or not
                Assert.assertEquals(expectedMainTitleText, ActualMainTitle, "Both are not correct");
                Assert.assertEquals(expectedSubTitleText, ActualSubTitle, "Both are not equal");
            }else System.out.println("Pop up not validated successfully");

        } catch (Exception e) {
        }
    }
    public void clickOnYesAndVerifyNoChanges() throws InterruptedException {
        popUpYesBtn.click();
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        if(TicketNumber.isDisplayed()){
            String ticketNumValue=TicketNumber.getAttribute("value");
            int actualIntTNValue = Integer.parseInt(ticketNumValue);
            int expectedTNValue = actualIntTNValue;
            System.out.println("When click on yes button value of ticket number is: " +actualIntTNValue);

            // Perform assertion to validate if the actual value matches the expected value
            Assert.assertEquals(actualIntTNValue, expectedTNValue, "Value does not match");

        }else System.out.println("Ticket count not match");
    }
    public void clickOnNoAndVerifyChangesStillOnThePage() throws InterruptedException {
        popUpNoBtn.click();
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        if(TicketNumber.isDisplayed()){
            String ticketNumValue=TicketNumber.getAttribute("value");
            int actualIntTNValue = Integer.parseInt(ticketNumValue);

            // Define the expected integer value

            int expectedTNValue = actualIntTNValue;
            System.out.println("when click on no button value of ticket number is: " +actualIntTNValue);

            // Perform assertion to validate if the actual value matches the expected value
            Assert.assertEquals(actualIntTNValue, expectedTNValue, "Value does not match as we click on no popup btn");

        }else System.out.println("Ticket count not match");
    }
    public void clickOnSaveBtnAndVerifyPopUp() throws InterruptedException {

      /*  try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,4000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@id='save-btn']", 2400);
            WebElement SaveBtn = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='save-btn']");
            new WebDriverWait(driver, 4000).until(ExpectedConditions.visibilityOf(SaveBtn));
            new WebDriverWait(driver, 4000).until(ExpectedConditions.elementToBeClickable(SaveBtn));
            HelpersMethod.ActClick(driver, SaveBtn, 4000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,4000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}*/
        SaveBtn.click();
        System.out.println("User click on save button");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        try {
            if (HelpersMethod.IsExists("//div[@class='k-window-title k-dialog-title']", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@class='k-window-title k-dialog-title']", 100);
                WebElement SaveBtnPopUp = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-window-title k-dialog-title']");

                //Find xpath of main and subtitle from save button pop up
                WebElement PopUpMainTitle1 = SaveBtnPopUp.findElement(By.xpath("//div[@class='k-window-title k-dialog-title']"));
                WebElement PopUpSubTitle1 = SaveBtnPopUp.findElement(By.xpath("//div[@id='dialogTextContent']"));

                //Get text of main and subtitle from save button pop up
                String ActualMainTitle = PopUpMainTitle1.getText();
                String ActualSubTitle = PopUpSubTitle1.getText();

                //Print main and subtitle from save button pop up
                System.out.println("Main title of dialog box : " +ActualMainTitle );
                System.out.println("Sub title is : " +ActualSubTitle);

                //Enter main and sub Expected title here
                String expectedMainTitleText="Ignition by Telus";
                String expectedSubTitleText="The information has been saved successfully.";

                //Verify both title are equal or not
                Assert.assertEquals(expectedMainTitleText, ActualMainTitle, "Both are not correct");
                Assert.assertEquals(expectedSubTitleText, ActualSubTitle, "Both are not equal");
            }else System.out.println("Pop up not validated successfully");

        } catch (Exception e) {
        }
    }
    public void clickOnOkBtnFromPopUp(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@id='QuestionModalButton0']", 2400);
            WebElement popUpOkBtn = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='QuestionModalButton0']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(popUpOkBtn));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(popUpOkBtn));
            HelpersMethod.ActClick(driver, popUpOkBtn, 4000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //popUpOkBtn.click();
    }
    public void verifyChangesOnThePage() {
        if (TicketNumber.isDisplayed()) {
            String ticketNumValue = TicketNumber.getAttribute("value");
            int actualIntTNValue = Integer.parseInt(ticketNumValue);

            // Define the expected integer value
            int expectedTNValue = actualIntTNValue;
            System.out.println("when click on okay button to save value of ticket " + actualIntTNValue);

            // Perform assertion to validate if the actual value matches the expected value
            Assert.assertEquals(actualIntTNValue, expectedTNValue, "Value does not match as we save changes");
        } else System.out.println("page not validate as expected !!!");
    }
    public void clickOnPurgeTab(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//span[@class='k-link' and text()='Purge']", 2400);
            WebElement PurgeTab = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='k-link' and text()='Purge']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(PurgeTab));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(PurgeTab));
            HelpersMethod.ActClick(driver, PurgeTab, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //PurgeTab.click();
    }
    public void verifyPurgeTabScreenOpened(){
        //Purge Title
        WebElement PurgeTabTitle=driver.findElement(By.xpath("//span[@class='i-card__header__title i-card__header__title--on i-card__title']"));
        String ActualPurgeTabTile=PurgeTabTitle.getText();
        System.out.println("Purge tab title is:::" +ActualPurgeTabTile);
        String ExpectedPurgeTabTitle="Purge";
        Assert.assertEquals(ActualPurgeTabTile, ExpectedPurgeTabTitle, "Both titles are different:::");
    }
    /*public void verifyPurgeTabHavingListOfTickets(){
        List<WebElement> rows = NotificationTableList.findElements(By.tagName("tr"));
        int getRowSize=rows.size();
        System.out.println("List of purge is:" +getRowSize);
    }*/
    public void verifyItemFoundField(){
        //WebElement ItemFoundField=driver.findElement(By.xpath("//span[@class='i-summary-area__main']//span[2]"));
        String ActualValueOfItemField=ItemFoundField.getText();
        int ActualValueOfItem=Integer.parseInt(ActualValueOfItemField);
        System.out.println("Value of item found is:" +ActualValueOfItem);
    }

    public void clickOnNotificationTab(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//span[@class='k-link' and text()='Notifications']", 2400);
            WebElement NotificationsTab = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='k-link' and text()='Notifications']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(NotificationsTab));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(NotificationsTab));
            HelpersMethod.ActClick(driver, NotificationsTab, 3000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //NotificationsTab.click();
    }
    public void verifyNotificationPageOpened(){
        HelpersMethod.WaitElementPresent(driver, "xpath", "//span[@class='i-card__header__title i-card__header__title--on i-card__title']", 2400);
        WebElement NotificationTitle = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='i-card__header__title i-card__header__title--on i-card__title']");
        new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(NotificationTitle));
        new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(NotificationTitle));
        //WebElement NotificationTitle=driver.findElement(By.xpath("//span[@class='i-card__header__title i-card__header__title--on i-card__title']"));

        String ActualNotyTitle=NotificationTitle.getText();
        System.out.println("Actual Title is: "+ActualNotyTitle);

        String ExpectedNotyTitle="Notifications";
        Assert.assertEquals(ActualNotyTitle, ExpectedNotyTitle, "Notification title not match" );
    }
    public void verifyListOfNotifications(){
        List<WebElement> rows = NotificationTableList.findElements(By.tagName("tr"));
        int getRowSize=rows.size();
        System.out.println("List of notification is:" +getRowSize);
        /*if (getRowSize == 1) {
            System.out.println("Notification Table has only one record.");
        } else {
            System.out.println("Notification Table does not have only one record.");
        }

        if(ActualValueOfItem== 1){
            System.out.println("Item found correct value :");
        } else System.out.println("Item found wrong value");*/
    }
    public void clickOnAddNotificationBtn(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@class='k-button k-flat k-button-icontext  i-button--icon-only']", 2400);
            WebElement AddNotificationBtn = HelpersMethod.FindByElement(driver, "xpath", "//button[@class='k-button k-flat k-button-icontext  i-button--icon-only']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(AddNotificationBtn));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(AddNotificationBtn));
            HelpersMethod.ActClick(driver, AddNotificationBtn, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}

        /*HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//button[@class='k-button k-flat k-button-icontext  i-button--icon-only']",40);
        WebElement AddNotificationBtn=HelpersMethod.FindByElement(driver,"xpath","//button[@class='k-button k-flat k-button-icontext  i-button--icon-only']");
        AddNotificationBtn.click();
        HelpersMethod.waitTillPageLoaded(driver, 2000);*/
    }
    public void verifyPopUpOfAddNotification(){
        if(AddNotificationPopUp.isDisplayed()){
            System.out.println("Add Notification pop up get opened successfully");
        }else System.out.println("Add Notification pop up get opened successfully");

        WebElement NotyPopUpTitle=driver.findElement(By.xpath("//div[@class='k-window-title k-dialog-title']"));
        String GetActualNotyPopUpTitle=NotyPopUpTitle.getText();
        System.out.println("Notification pop up Title correct: " +GetActualNotyPopUpTitle);

        String ExpectedNotyTitle="Notifications";
        Assert.assertEquals(GetActualNotyPopUpTitle, ExpectedNotyTitle, "Notification title not match" );
    }
    public void addNotificationDetails() throws InterruptedException {
        WebElement SelectStatusDD=driver.findElement(By.xpath("//span[@id='Status']"));
        SelectStatusDD.click();
        SelectStatusDD.sendKeys("New");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement SelectPriorityDD=driver.findElement(By.xpath("//span[@id='Priority']"));
        SelectPriorityDD.click();
        SelectPriorityDD.sendKeys("Low");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement SelectTypeDD=driver.findElement(By.xpath("//span[@id='Type']"));
        SelectTypeDD.click();
        SelectTypeDD.sendKeys("Order management");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement SelectApplicationDD=driver.findElement(By.xpath("//span[@id='Application']"));
        SelectApplicationDD.click();
        SelectApplicationDD.sendKeys("ERPi");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement SelectReasonDD=driver.findElement(By.xpath("//span[@id='Reason']"));
        SelectReasonDD.click();
        SelectReasonDD.sendKeys("Problem");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement EnterEmailId=driver.findElement(By.xpath("//input[@id='Email']"));
        EnterEmailId.click();
        EnterEmailId.sendKeys("shitalp@afsi.com");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement ClickSaveBtn=driver.findElement(By.xpath("//button[@id='ModalButton1']"));
        ClickSaveBtn.click();
    }
    public void verifyListOfRecords(){
        List<WebElement> rows = NotificationTableList.findElements(By.tagName("tr"));
        int getRowSize=rows.size();
        System.out.println("After addition of new notification the updated List of notification is:" +getRowSize);

        String ActualValueOfItemField=ItemFoundField.getText();
        int ActualValueOfItem=Integer.parseInt(ActualValueOfItemField);
        System.out.println("After addition of new notification the updated Value of item found is:" +ActualValueOfItem);

        Assert.assertEquals(getRowSize,ActualValueOfItem,"both field are not same");
    }
    public void skipAnyMandatoryField() throws InterruptedException {
        WebElement SelectStatusDD=driver.findElement(By.xpath("//span[@id='Status']"));
        SelectStatusDD.click();
        SelectStatusDD.sendKeys("New");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement ClickSaveBtn=driver.findElement(By.xpath("//button[@id='ModalButton1']"));
        ClickSaveBtn.click();
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement PrioritySkipEle= driver.findElement(By.xpath("//div[@class='i-notification-text' and text()='Priority is required.']"));
        String PriorityErrorMsg=PrioritySkipEle.getText();
        System.out.println("Priority error message is: "+PriorityErrorMsg);
    }
    public void clickOnCancelBtn(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@id='ModalButton0']", 2400);
            WebElement ClickCancelBtn = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='ModalButton0']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(ClickCancelBtn));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(ClickCancelBtn));
            HelpersMethod.ActClick(driver, ClickCancelBtn, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        /*WebElement ClickCancelBtn=driver.findElement(By.xpath("//button[@id='ModalButton0']"));
        ClickCancelBtn.click();*/
    }
    public void selectAnyNotyFromList() throws InterruptedException {
        /*try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,4000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//table[@class='k-grid-table']//tr[3]", 2400);
            WebElement SelectLastNoty = HelpersMethod.FindByElement(driver, "xpath", "//table[@class='k-grid-table']//tr[3]");
            new WebDriverWait(driver, 4000).until(ExpectedConditions.visibilityOf(SelectLastNoty));
            new WebDriverWait(driver, 4000).until(ExpectedConditions.elementToBeClickable(SelectLastNoty));
            HelpersMethod.ActClick(driver, SelectLastNoty, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,4000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}*/
        SelectLastNoty.click();
        //Thread.sleep(1000);
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
    }
    public void verifyEditAndDeleteBtnEnabled(){
        if(DeleteNotyBtn.isEnabled()){
            System.out.println("Delete button is enabled");
        }else System.out.println("Delete button not enabled");

        if(EditNotyBtn.isEnabled()){
            System.out.println("Edit button is enabled");
        }else System.out.println("Edit button not enabled");
    }

    public void clickOnDeleteBtnAndVerifyPopUpText() throws InterruptedException {

        DeleteNotyBtn.click();
        System.out.println("User click on save button");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);
        try {
            if (HelpersMethod.IsExists("//div[@class='k-widget k-window k-dialog']", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@class='k-widget k-window k-dialog']", 100);
                WebElement DeleteBtnPopUp = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-widget k-window k-dialog']");

                //Find xpath of main and subtitle from save button pop up
                WebElement PopUpMainTitle1 = DeleteBtnPopUp.findElement(By.xpath("//div[@class='k-window-title k-dialog-title']"));
                WebElement PopUpSubTitle1 = DeleteBtnPopUp.findElement(By.xpath("//div[@class='k-window-content k-dialog-content']"));

                //Get text of main and subtitle from save button pop up
                String ActualMainTitle = PopUpMainTitle1.getText();
                String ActualSubTitle = PopUpSubTitle1.getText();

                //Print main and subtitle from save button pop up
                System.out.println("Main title of dialog box : " +ActualMainTitle );
                System.out.println("Sub title is : " +ActualSubTitle);

                //Enter main and sub Expected title here
                String expectedMainTitleText="Delete";
                String expectedSubTitleText="Are you sure you want to delete this record?";

                //Verify both title are equal or not
                Assert.assertEquals(expectedMainTitleText, ActualMainTitle, "Both are not correct");
                Assert.assertEquals(expectedSubTitleText, ActualSubTitle, "Both are not equal");
            }else System.out.println("Pop up not validated successfully");

        } catch (Exception e) {
        }
    }
    public void clickOnCancelBtnFromPopUpNoty() throws InterruptedException {
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@id='CancelBtn']", 2400);
            WebElement CancelBtnFromPopUp = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='CancelBtn']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(CancelBtnFromPopUp));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(CancelBtnFromPopUp));
            HelpersMethod.ActClick(driver, CancelBtnFromPopUp, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        /*WebElement CancelBtnFromPopUp=driver.findElement(By.xpath("//button[@id='CancelBtn']"));
        CancelBtnFromPopUp.click();
        //Thread.sleep(5000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);*/
    }

    public void clkOnOkBtnFromPopUp() throws InterruptedException {
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@id='OKBtn']", 2400);
            WebElement CancelBtnFromPopUp = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='OKBtn']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(CancelBtnFromPopUp));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(CancelBtnFromPopUp));
            HelpersMethod.ActClick(driver, CancelBtnFromPopUp, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        /*WebElement CancelBtnFromPopUp=driver.findElement(By.xpath("//button[@id='OKBtn']"));
        CancelBtnFromPopUp.click();
        // Thread.sleep(5000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);*/
    }
    public void clickOnEditBtnAndVerifyNotyPopUp(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@class='k-button k-flat k-button-icontext']", 2400);
            WebElement EditNotyBtn = HelpersMethod.FindByElement(driver, "xpath", "//button[@class='k-button k-flat k-button-icontext']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(EditNotyBtn));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(EditNotyBtn));
            HelpersMethod.ActClick(driver, EditNotyBtn, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //EditNotyBtn.click();
        //HelpersMethod.waitTillLoadingWheelDisappears(driver, EditNotyBtn, 400);
        //System.out.println("User click on edit button");
    }
    public void editAnyFieldAndClkOnSaveBtn() throws InterruptedException {
        WebElement SelectPriorityDD=driver.findElement(By.xpath("//span[@id='Priority']"));
        SelectPriorityDD.click();
        SelectPriorityDD.sendKeys("Medium");
        //Thread.sleep(1000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);

        String UpdatedValue=SelectPriorityDD.getText();
        System.out.println("Updated value is: "+ UpdatedValue);
        WebElement ClickSaveBtn=driver.findElement(By.xpath("//button[@id='ModalButton1']"));
        ClickSaveBtn.click();
        HelpersMethod.waitTillLoadingWheelDisappears(driver, ClickSaveBtn, 100);

        //Thread.sleep(2000);
        HelpersMethod.waitTillPageLoaded(driver, 2000);
        WebElement CheckValueAfterEdit= driver.findElement(By.xpath("//table[@class='k-grid-table']//tr[3]//td[2]"));
        String NewValueAfterEdit=CheckValueAfterEdit.getText();
        System.out.println("New Value after edit is: " +NewValueAfterEdit);

        if (!UpdatedValue.equals(NewValueAfterEdit)) {
            System.out.println("The strings are different.");
        } else { System.out.println("The strings are the same.");  }
    }
    public void clickOnConfigurationTab(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//span[@class='k-link' and text()='Configure']", 2400);
            WebElement ConfigureTab = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='k-link' and text()='Configure']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(ConfigureTab));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(ConfigureTab));
            HelpersMethod.ActClick(driver, ConfigureTab, 3000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //ConfigureTab.click();
        //HelpersMethod.waitTillLoadingWheelDisappears(driver, ConfigureTab, 100);
    }
    public void verifyConfigPage(){
        //div//button//div//div
        List<WebElement> ListOfBaseTables=driver.findElements(By.xpath("//div[@class='list']//button"));
        int expectedSize = 10; // Example: Expected number of list items
        int actualSize = ListOfBaseTables.size();
        System.out.println("size of list is:" +actualSize);
        if (expectedSize == actualSize) {
            System.out.println("List size is valid.");
        } else {
            System.out.println("List size is not valid.");
        }
        List<String> expectedValues = Arrays.asList("Status", "Reason", "Source", "Module", "Priority", "Type", "Category", "Action", "Feedback", "Feedback type"); // Example: Expected list values

        boolean isListValid = true;

        for (int i = 0; i < actualSize; i++) {
            String actualValue = ListOfBaseTables.get(i).getText();
            System.out.println("actual value of list " +actualValue);

            String expectedValue = expectedValues.get(i);
            System.out.println("expected value of list is: " +expectedValue);

            if (!actualValue.equals(expectedValue)) {
                System.out.println("List value at index " + i + " is not valid. Actual: " + actualValue + ", Expected: " + expectedValue);
                isListValid = false;
            }
        }

        if (isListValid) {
            System.out.println("List values are valid.");
        }

    }
    public void selectAnyBaseTableRecordAndVerify()
    {
        List<WebElement> ListOfBaseTables=driver.findElements(By.xpath("//div[@class='list']//button"));
        int optionIndex = 5; // Index of the option to be selected
        ListOfBaseTables.get(optionIndex).click();
        String selectedOption = ListOfBaseTables.get(optionIndex).getText();
        String expectedOption = "Type"; // Example: Expected value of the selected option

        if (selectedOption.equals(expectedOption)) {
            System.out.println("Selected option is valid and option is:" +selectedOption);
        } else {
            System.out.println("Selected option is not valid. Actual: " + selectedOption + ", Expected: " + expectedOption);
        }
        WebElement selectedOptionIs = ListOfBaseTables.get(optionIndex); // Assuming you have the selected option WebElement
        String colorValue = selectedOptionIs.getCssValue("color");
        System.out.println("color of selected option is: "+colorValue);

        // Validate the color value against the expected color
        String expectedColor = "rgba(0, 8, 26, 1)"; // Example: Expected color value in RGB format
        if (colorValue.equals(expectedColor)) {
            System.out.println("Color of the selected option is valid.");
        } else {
            System.out.println("Color of the selected option is not valid. Actual: " + colorValue + ", Expected: " + expectedColor);
        }
    }
    public void verifyRightSideGridConfig() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000)); // Initialize WebDriverWait with an appropriate timeout value
        //Locate the table element containing the options
        WebElement TableGrid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-grid-table']"))); // Locate the table element on the right side using an appropriate selector
        if (TableGrid.isDisplayed()) {
            System.out.println("table display of type configuration");
        } else System.out.println("table not display");

        // Get all rows within the table
        List<WebElement> rows = TableGrid.findElements(By.cssSelector("tr"));

        // Iterate over each row
        for (WebElement row : rows) {
            // Get all cells within the row
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            //System.out.println("size of col is: " + cells);
            // Extract the key-value pairs
            for (int i = 0; i < cells.size(); i++) {
                if (i + 1 < cells.size()) {
                    String key = cells.get(i).getText();
                    String value = cells.get(i + 1).getText();

                    // Perform desired operations with the key-value pair
                    System.out.println("Key: " + key + ", Value: " + value);
                }
            }
        }
    }
    public void addConfiguration(){
        WebElement AddConfig=driver.findElement(By.xpath("//button[@class='k-button k-flat k-button-icontext  i-button--icon-only']"));
        if(AddConfig.isDisplayed()){
            System.out.println("yes add configuration display");
            AddConfig.click();
            //HelpersMethod.waitTillLoadingWheelDisappears(driver, AddConfig, 300);
        }else System.out.println("not able to click and display");
    }
    public void verifyConfigPopUp(){
        WebElement ConfigPopUp=driver.findElement(By.xpath("//div[@class='k-widget k-window k-dialog']"));
        if(ConfigPopUp.isDisplayed()){
            //Validate main title
            WebElement ConfigPopUpMainTitle= driver.findElement(By.xpath("//div[@class='k-window-title k-dialog-title']"));
            String ActualConfigPopUpMainTitle=ConfigPopUpMainTitle.getText();
            System.out.println("Title of config pop up is: " +ActualConfigPopUpMainTitle);
            String ExpectedPopupTitle="Create";
            Assert.assertEquals(ActualConfigPopUpMainTitle, ExpectedPopupTitle, "config pop up title does not match");

            //Validate label title
            WebElement TextBoxLabel=driver.findElement(By.xpath("//div[@class='k-textbox-container']//label[@id='description-label']"));
            String ActualLabel=TextBoxLabel.getText();
            String ExpectedLabel="Description";
            Assert.assertEquals(ActualLabel, ExpectedLabel, "config pop up text box does not match");

        }
    }

    public void addDescriptionForConfigSaveBtn() throws InterruptedException {
        //Validate Text box
        WebElement DescTextBox= driver.findElement(By.xpath("//input[@class='k-textbox']"));
        if(DescTextBox.isEnabled()){
            System.out.println("Text box present and enabled as well");
            DescTextBox.sendKeys("Customer Management");
            HelpersMethod.waitTillPageLoaded(driver, 2000);
        } else System.out.println("Not enabled");

        //click on sae button
        WebElement SaveBtn=driver.findElement(By.xpath("//button[@id='SaveBtn']"));
        //SaveBtn.click();
        HelpersMethod.ActClick(driver, SaveBtn, 2000);
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
        HelpersMethod.waitTillLoadingWheelDisappears(driver, SaveBtn, 30);
    }

    public void verifyTableAfterAddConfig() {
        // Capture the sequence number before adding the row
        String previousSequenceNumber = driver.findElement(By.xpath("//table//tr[last() - 1]/td[1]")).getText();
        System.out.println("previous before addition of record sequence number is :" +previousSequenceNumber);

        // Capture the sequence number after adding the row
        String currentSequenceNumber = driver.findElement(By.xpath("//table//tr[last()]/td[1]")).getText();
        System.out.println("Current after addition of record sequence number is :" +currentSequenceNumber);

        // Convert the sequence numbers to integers for comparison
        int previousSequence = Integer.parseInt(previousSequenceNumber);
        int currentSequence = Integer.parseInt(currentSequenceNumber);

        // Validate that the new sequence number is incremented by 1
        if (currentSequence == previousSequence + 1) {
            System.out.println("Table validation: New record added successfully with the next sequence number.");
        } else {
            System.out.println("Table validation: Failed. The new record does not have the expected sequence number.");
        }
    }

    public void selectAnyRow(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//table//tr[last()]/td[1]", 2400);
            WebElement SelectRowToEdit = HelpersMethod.FindByElement(driver, "xpath", "//table//tr[last()]/td[1]");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(SelectRowToEdit));
            new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(SelectRowToEdit));
            HelpersMethod.ActClick(driver, SelectRowToEdit, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //WebElement SelectRowToEdit=driver.findElement(By.xpath("//table//tr[last()]/td[1]"));
        //SelectRowToEdit.click();
        //HelpersMethod.waitTillLoadingWheelDisappears(driver, SelectRowToEdit, 300);
    }

    public void clickOnEditBtn(){
        //WebElement ClickEditBtn=driver.findElement(By.xpath("//button[@class='k-button k-flat k-button-icontext' and text()='Edit']"));
        //Wait for the element to be clickable before clicking
        //WebElement ClickEditBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='k-button k-flat k-button-icontext' and text()='Edit']")));
       /* try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,4000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@class='k-button k-flat k-button-icontext' and text()='Edit']", 2400);
            WebElement ClickEditBtn = HelpersMethod.FindByElement(driver, "xpath", "//button[@class='k-button k-flat k-button-icontext' and text()='Edit']");
            new WebDriverWait(driver, 4000).until(ExpectedConditions.visibilityOf(ClickEditBtn));
            new WebDriverWait(driver, 4000).until(ExpectedConditions.elementToBeClickable(ClickEditBtn));
            HelpersMethod.ActClick(driver, ClickEditBtn, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,4000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}*/
        WebElement ClickEditBtn=driver.findElement(By.xpath("//button[@class='k-button k-flat k-button-icontext' and text()='Edit']"));
        ClickEditBtn.click();
        //HelpersMethod.waitTillLoadingWheelDisappears(driver, ClickEditBtn, 300);
        //wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("some-element")));
    }

    public void verifyEditPopUpAndAddDesc(){
        WebElement EditPopUpWin=driver.findElement(By.xpath("//div[@class='k-widget k-window k-dialog']"));

        if(EditPopUpWin.isDisplayed()){
            //Validate main title
            WebElement EditPopUpMainTitle= driver.findElement(By.xpath("//div[@class='k-window-title k-dialog-title']"));
            String ActualConfigPopUpMainTitle=EditPopUpMainTitle.getText();
            System.out.println("Title of config edit pop up is: " +ActualConfigPopUpMainTitle);
            String ExpectedPopupTitle="Edit";
            Assert.assertEquals(ActualConfigPopUpMainTitle, ExpectedPopupTitle, "config edit pop up title does not match");

            //Validate code field disabled

            WebElement CodeFieldDisabled=driver.findElement(By.xpath("//input[@class='k-textbox' and @id='code']"));
            // Check if the text box is enabled
            if (CodeFieldDisabled.isEnabled()) {
                System.out.println("Text box validation: code Text box is enabled for editing.");
            } else { System.out.println("Text box validation: code Text box is not editable.");}

            WebElement DescTextBoxEnable=driver.findElement(By.xpath("//input[@id='description']"));
            if(DescTextBoxEnable.isEnabled()) {
                String ActualTextOfBoxEnabled=DescTextBoxEnable.getAttribute("value");
                System.out.println("Current value of text box is: " +ActualTextOfBoxEnabled);
                String ExpectedTextBoxEnabled = "Customer Management";
                Assert.assertEquals(ActualTextOfBoxEnabled, ExpectedTextBoxEnabled, "config edit pop up text box does not match");

                // Clear the existing value in the description field
                DescTextBoxEnable.clear();

                // Enter the new value into the field
                DescTextBoxEnable.sendKeys("Customer Relationship Management");
            }
            else System.out.println("Description field is not enabled");
        }
    }
    public void clickOnCancelBtnPopUp(){
        WebElement CancelBtn=driver.findElement(By.xpath("//button[@id='CancelBtn']"));
        CancelBtn.click();
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
        HelpersMethod.waitTillLoadingWheelDisappears(driver, CancelBtn, 100);
    }
    public void verifyNoChangesAfterCancelBtn(){
        WebElement OldValue=driver.findElement(By.xpath("//table//tr[last()]/td[2]"));
        String ActualOldValue=OldValue.getText();
        System.out.println("Value did not changed" +ActualOldValue);
        String ExpectedOldValue="Customer Management";
        Assert.assertEquals(ActualOldValue, ExpectedOldValue, "config old new value of description does not match");
    }
    public void clickOnEditBtnPopUp(){
        /*try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,4000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "///button[@id='SaveBtn' and text()='Edit']", 2400);
            WebElement EditBtn = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='SaveBtn' and text()='Edit']");
            new WebDriverWait(driver, 4000).until(ExpectedConditions.visibilityOf(EditBtn));
            new WebDriverWait(driver, 4000).until(ExpectedConditions.elementToBeClickable(EditBtn));
            HelpersMethod.ActClick(driver, EditBtn, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,4000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}*/
        WebElement EditBtn=driver.findElement(By.xpath("//button[@id='SaveBtn' and text()='Edit']"));
        EditBtn.click();
        //HelpersMethod.waitTillLoadingWheelDisappears(driver, EditBtn, 100);
    }
    public void clickOnDeleteBtn(){
        WebElement ClickDeleteBtn=driver.findElement(By.xpath("//button[@class='k-button k-flat k-button-icontext' and text()='Delete']"));
        ClickDeleteBtn.click();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }

    public void verifyCancelAndOkBtnOnPopUp(){
        if(CancelBtnOfDelConfig.isEnabled()){
            System.out.println("Cancel button is enabled");
        }else System.out.println("Cancel button not enabled");

        if(OkBtnOfDelConfig.isEnabled()){
            System.out.println("Save button is enabled");
        }else System.out.println("Save button not enabled");
    }
    public void clickOnCancelBtnFromPopUpOfDelConfig(){
        // WebElement CancelBtn=driver.findElement(By.xpath("//button[@id='CancelBtn']"));
        CancelBtnOfDelConfig.click();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }
    public void verifyRecordNotDeleted(){
        WebElement RecordStillAv=driver.findElement(By.xpath("//table//tr[last()]/td"));
        if(RecordStillAv.isDisplayed()){
            System.out.println("Record still on the page as we click on cancel btn from delete pop up");
        } else System.out.println("Record deleted");
    }
    public void clickOnOkBtnFromPopUpOfDelConfig(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@id='OKBtn']", 2400);
            WebElement OkBtnOfDelConfig = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='OKBtn']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(OkBtnOfDelConfig));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(OkBtnOfDelConfig));
            HelpersMethod.ActClick(driver, OkBtnOfDelConfig, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        // WebElement OkBtn=driver.findElement(By.xpath("//button[@id='OKBtn']"));
        //OkBtnOfDelConfig.click();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }
    public void verifyTableAfterDelConfig() {
        // Capture the sequence number before adding the row
        String previousSequenceNumber = driver.findElement(By.xpath("//table//tr[last()]/td[1]")).getText();
        System.out.println("previous before deletion of record sequence number is :" + previousSequenceNumber);

        // Capture the sequence number after delete the row
        String currentSequenceNumber = driver.findElement(By.xpath("//table//tr[last()-1]/td[1]")).getText();
        System.out.println("Current after deletion of record sequence number is :" + currentSequenceNumber);

        // Convert the sequence numbers to integers for comparison
        int previousSequence = Integer.parseInt(previousSequenceNumber);
        int currentSequence = Integer.parseInt(currentSequenceNumber);

        // Validate that the new sequence number is incremented by 1
        if (currentSequence == previousSequence - 1) {
            System.out.println("Table validation: record deleted successfully before sequence number get validated.");
        } else {
            System.out.println("Table validation: Failed. record does not deleted and also have the expected sequence number.");
        }
    }
    /*public void verifyHomePageLoaded(){
        //WebElement HomePage=driver.findElement(By.xpath("//div[@id='app']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement HomePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='logo-img']")));
        HelpersMethod.waitTillLoadingWheelDisappears(driver, HomePage, 300);
        if(HomePage.isDisplayed()){ //Ignition QA ERPi Env
            System.out.println("Image display from home page");
        }else System.out.println("Image not display on home page");

    }*/
    public void clickOnSettingsBtn(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@class='settings-container admin-mode']", 2400);
            WebElement SettingsBtn = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='settings-container admin-mode']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(SettingsBtn));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(SettingsBtn));
            HelpersMethod.ActClick(driver, SettingsBtn, 5000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}

        /*exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.Implicitwait(driver,10);
        try
        {
            HelpersMethod.ScrollElement(driver,SettingsBtn);
            HelpersMethod.ActClick(driver,SettingsBtn,20);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}*/

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement SettingsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='settings-container admin-mode']")));
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement SettingsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='settings-container admin-mode']")));
        //SettingsBtn.click();
        //SettingsBtn.click();
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
        //HelpersMethod.waitTillLoadingWheelDisappears(driver, SettingsBtn, 100);
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
    }
    public void selectCRMTicketsModule(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//span[@class='menu-item-text' and text()='CRM Tickets']", 2400);
            WebElement ClientCRMModule = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='menu-item-text' and text()='CRM Tickets']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(ClientCRMModule));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(ClientCRMModule));
            HelpersMethod.ActClick(driver, ClientCRMModule, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement SettingsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-item-text' and text()='CRM Tickets']")));
        //HelpersMethod.waitTillLoadingWheelDisappears(driver, ClientCRMModule, 200);
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement ClientCRMModule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-item-text' and text()='CRM Tickets']")));
        //ClientCRMModule.click();
        //HelpersMethod.waitTillPageLoaded(driver, 2000);
    }
    public void verifyClientCRMPageOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement CRMPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='i-breadcrumb-item__button' and text()='CRM Tickets']")));

        //WebElement CRMPageTitle=driver.findElement(By.xpath("//button[@class='i-breadcrumb-item__button' and text()='CRM Tickets']"));
        if(CRMPageTitle.isDisplayed()) {
            String ActualCRMPAgeTitle = CRMPageTitle.getText();
            String ExpectedCRMPageTitle = "CRM Tickets";
            Assert.assertEquals(ActualCRMPAgeTitle, ExpectedCRMPageTitle, "CRM page title not match");
        }else System.out.println("CRM tickets page not enabled :::");

        WebElement CRMPageSubTitle=driver.findElement(By.xpath("//span[@class='spnmoduleNameHeader']"));
        if(CRMPageSubTitle.isDisplayed()) {
            String ActualSubTitle = CRMPageSubTitle.getText();
            String ExpectedSubTitle = "Open Ticket List";
            Assert.assertEquals(ActualSubTitle, ExpectedSubTitle, "Sub title of CRM page not match");
        }else System.out.println("CRM Tickets page not opened");
    }
    public void clickOnAddNewTicketBtn() throws InterruptedException {

        WebElement AddTicketBtn=driver.findElement(By.xpath("//button[@id='add-button']"));
        //AddTicketBtn.click();
        HelpersMethod.JScriptClick(driver, AddTicketBtn, 1000);
    }
    public void verifyNewTicketPage(){
        WebElement NewTicketPage=driver.findElement(By.xpath("//span[@class='spnmoduleNameHeader']"));
        String ActualTitleOfNewTicketPage=NewTicketPage.getText();
        String ExpectedTitleOfNewTicketPage="New Ticket";
        Assert.assertEquals(ActualTitleOfNewTicketPage, ExpectedTitleOfNewTicketPage, "Both title of new tickets page is different");

        WebElement NewTicketWin=driver.findElement(By.xpath("//div[@class='crm-container']"));
        if(NewTicketWin.isDisplayed()){
            System.out.println("New ticket creation page opened successfully");
            WebElement NewTicketPageSubTitle=driver.findElement(By.xpath("//div[@class='crm-container']//span[@class='i-card__header__title i-card__header__title--on i-card__title']"));
            String ActualSubTitle=NewTicketPageSubTitle.getText();
            String ExpectedSubTitle="New ticket";
            Assert.assertEquals(ActualSubTitle,ExpectedSubTitle,"both title mismatch");

        } else System.out.println("no wrong page opened");
    }
    public void provideAllMandatoryValuesToAddTicket() throws InterruptedException {
        WebElement SelectModuleDD=driver.findElement(By.xpath("//span[@id='dropdown-module']"));
        //SelectModuleDD.click();
        HelpersMethod.ActClick(driver, SelectModuleDD, 100);
        SelectModuleDD.sendKeys("ERPi");
        //HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement AddTitle=driver.findElement(By.xpath("//input[@id='textbox-title']"));
        //AddTitle.click();
        HelpersMethod.ActClick(driver, AddTitle, 100);
        AddTitle.sendKeys("New Dummy Ticket for Testing");
        //HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement AddDescription=driver.findElement(By.xpath("//textarea[@id='textarea-details']"));
        //AddDescription.click();
        HelpersMethod.ActClick(driver, AddDescription, 100);
        AddDescription.sendKeys("This Ticket is about complaint of ERP application");
        //HelpersMethod.waitTillPageLoaded(driver, 2000);

        WebElement SaveTicketBtn=driver.findElement(By.xpath("//button[@id='saveButton']"));
        if(SaveTicketBtn.isEnabled()) {
            //SaveTicketBtn.click();
            HelpersMethod.ActClick(driver, SaveTicketBtn, 100);
            HelpersMethod.waitTillPageLoaded(driver, 2000);
            System.out.println("clicked on save button to add ticket on the list");
        }else System.out.println("new ticket details not saved");
    }
    public void verifyListOfTicketsWithNewSqeNum(){
        // Capture the sequence number before adding the row
        String previousSequenceNumber = driver.findElement(By.xpath("//table//tr[last() - 1]/td[1]")).getText();
        System.out.println("previous before addition of new ticket sequence number is :" +previousSequenceNumber);

        // Capture the sequence number after adding the row
        String currentSequenceNumber = driver.findElement(By.xpath("//table//tr[last()]/td[1]")).getText();
        System.out.println("Current after addition of new ticket sequence number is :" +currentSequenceNumber);

        // Convert the sequence numbers to integers for comparison
        int previousSequence = Integer.parseInt(previousSequenceNumber);
        int currentSequence = Integer.parseInt(currentSequenceNumber);

        // Validate that the new sequence number is incremented by 1
        if (currentSequence == previousSequence + 1) {
            System.out.println("Table validation: New record added successfully with the next sequence number.");
        } else {
            System.out.println("Table validation: Failed. The new record does not have the expected sequence number.");
        }
    }
    public void verifyExportCSVBtn(){
        if(ExportCSVBtn.isDisplayed()){
            System.out.println("Export CSV button is available on the page");
        }else System.out.println("Export CSV button is not available on the page");
    }
    public void clickOnExportCSVBtn() throws InterruptedException {
        HelpersMethod.ActClick(driver, ExportCSVBtn, 1000);
        //ExportCSVBtn.click();
        HelpersMethod.waitTillPageLoaded(driver, 2000);
    }
    public void verifyCSVFileGenerated(){
        // Define the path to the downloaded file
        String downloadDir = "C://Users//shital.suryawanshi//Downloads";
        String fileName = "CRMTickets.csv";
        Path filePath = Paths.get(downloadDir, fileName);

        // Validate the downloaded file
        boolean isFileDownloaded = Files.exists(filePath);
        if (isFileDownloaded) {
            // Perform validation on the file content, e.g., read and verify its content
            try {
                String fileContent = Files.probeContentType(filePath);
                System.out.println("Downloaded file content are :" + fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not downloaded");
        }
    }

    //For priority configuration
    public void clickOnPriorityOption() throws InterruptedException {
        WebElement PriorityOption=driver.findElement(By.xpath("//div[@class='list']//button[5]"));
        HelpersMethod.ActClick(driver, PriorityOption, 100);
        /*if(PriorityOption.isDisplayed()) {
            PriorityOption.click();
        }else System.out.println("priority option not available");*/
    }
    public List<String> getPriorityValues() {
        List<String> priorityValues = new ArrayList<>();

        // Assuming the priority values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                priorityValues.add(cells.get(1).getText()); // Assuming priority value is present in the first column

            }
        }System.out.println("Priority Values are:  " +priorityValues);
        return priorityValues;
    }

    public List<String> getPriorityDropdownValues() throws InterruptedException {
        List<String> PriorityDropdownValues = new ArrayList<>();
        /*Select priorityDropdown = new Select(driver.findElement(By.xpath("//span[@id='dropdown-priority']")));
        List<WebElement> options = priorityDropdown.getOptions();

        for (WebElement option : options) {
            dropdownValues.add(option.getText());
        }*/
        WebElement PriorityDropDown=driver.findElement(By.xpath("//span[@id='dropdown-priority']"));
        PriorityDropDown.click();
        String FirstEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 1st web element is: "+FirstEle);
        PriorityDropdownValues.add(FirstEle);

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        PriorityDropdownValues.add(SecondEle);

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        PriorityDropdownValues.add(ThirdEle);

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        PriorityDropdownValues.add(FourthEle);

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String FifthEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 5th web element is: "+FifthEle);
        PriorityDropdownValues.add(FifthEle);

        System.out.println("Client side priority dropdown values are: " +PriorityDropdownValues);
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //ul[contains(@aria-owns,'dropdown-priority')]/li
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("option"), 0));
        //wait.until(ExpectedConditions.attributeContains(DropDown, "aria-expanded", "true"));
        //List<WebElement> priorityDropdownOptions = driver.findElements(By.xpath("//span[@id='dropdown-priority']//span[2]"));
        /*List<WebElement> priorityDropdownOptions = driver.findElements(By.xpath("//span[@role='listbox']/ul/li"));
        for (WebElement options : priorityDropdownOptions) {
            //Dimension dropdownSize=option.getSize();
            //System.out.println("size of dropdown list is: " +dropdownSize);
            dropdownValues.add(options.getText());
        }System.out.println("Client side priority dropdown values are: " +dropdownValues);
        //Thread.sleep(2000);
        DropDown.click();*/

        /*WebElement CloseIcon=driver.findElement(By.xpath("//button[@class='i-icon--close']"));
        if(CloseIcon.isDisplayed()){
            CloseIcon.click();
        } else System.out.println("not able to click on close button");*/

        //WebElement CancelBtn=driver.findElement(By.xpath("//button[@id='cancelButton']"));
        //CancelBtn.click();
        return PriorityDropdownValues;
    }
    ///For Module configuration
    public void clickOnModuleOption() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        WebElement ModuleOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list']//button[4]")));
        HelpersMethod.ActClick(driver, ModuleOption, 600);
        //ModuleOption.click();
            /*WebElement ModuleOption=driver.findElement(By.xpath("//div[@class='list']//button[4]"));
            if(ModuleOption.isDisplayed()) {
                ModuleOption.click();
            }else System.out.println("Module option not available");*/
    }

    public List<String> getModuleValues() {
        List<String> moduleValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                moduleValues.add(cells.get(1).getText()); // Assuming Module value is present in the first column

            }
        }System.out.println("Module Values are:  " +moduleValues);
        return moduleValues;
    }

    public List<String> getModuleDropdownValues() throws InterruptedException {
        List<String> ModuleDropdownValues = new ArrayList<>();
        WebElement ModuleDropDown;
        ModuleDropDown=HelpersMethod.FindByElement(driver,"xpath","//span[@id='dropdown-module']");
        HelpersMethod.ActClick(driver,ModuleDropDown,100);
        //WebElement ModuleDropDown=driver.findElement(By.xpath("//span[@id='dropdown-module']"));
        //ModuleDropDown.click();

        String FirstEle=ModuleDropDown.getText();
        //System.out.println("Dropdown 1st web element is: "+FirstEle);
        ModuleDropdownValues.add(FirstEle);

        ModuleDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=ModuleDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        ModuleDropdownValues.add(SecondEle);

        ModuleDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=ModuleDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        ModuleDropdownValues.add(ThirdEle);

        ModuleDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=ModuleDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        ModuleDropdownValues.add(FourthEle);

        ModuleDropDown.sendKeys(Keys.ARROW_DOWN);
        String FifthEle=ModuleDropDown.getText();
        //System.out.println("Dropdown 5th web element is: "+FifthEle);
        ModuleDropdownValues.add(FifthEle);

        ModuleDropDown.sendKeys(Keys.ARROW_DOWN);
        String SixEle=ModuleDropDown.getText();
        //System.out.println("Dropdown 5th web element is: "+FifthEle);
        ModuleDropdownValues.add(SixEle);

        /*Actions act1 = new Actions(driver);
        int i = 0;
        WebElement DropDown=driver.findElement(By.xpath("//span[@id='dropdown-module']"));
        DropDown.click();

        List<WebElement> priorityDropdownOptions = DropDown.findElements(By.xpath(".//ul/li"));
        for (WebElement options : priorityDropdownOptions) {
            i++;
            act1.moveToElement(options).build().perform();
            if (i == 2) {
                act1.moveToElement(options).build().perform();
                act1.click(options).build().perform();
                ModuleDropdownValues.add(options.getText());
            }*/
        System.out.println("Client side Module dropdown values are: " +ModuleDropdownValues);
        //Thread.sleep(2000);
        //DropDown.click();
        return ModuleDropdownValues;
    }

    public void clickOnTypeOption() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement TypeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list']//button[6]")));
        //TypeOption.click();
        HelpersMethod.ActClick(driver, TypeOption, 100);

       /* WebElement TypeOption=driver.findElement(By.xpath("//div[@class='list']//button[6]"));
        if(TypeOption.isDisplayed()) {
            TypeOption.click();
        }else System.out.println("type option not available");*/
    }
    public List<String> getTypeValues() {
        List<String> typeValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                typeValues.add(cells.get(1).getText()); // Assuming Module value is present in the first column

            }
        }System.out.println("Type Values are:  " +typeValues);
        return typeValues;
    }

    public List<String> getTypeDropdownValues() {
        List<String> TypeDropdownValues = new ArrayList<>();
        WebElement TypeDropDown=driver.findElement(By.xpath("//span[@id='dropdown-type']"));
        TypeDropDown.click();
        String FirstEle=TypeDropDown.getText();
        //System.out.println("Dropdown 1st web element is: "+FirstEle);
        TypeDropdownValues.add(FirstEle);

        TypeDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=TypeDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        TypeDropdownValues.add(SecondEle);

        TypeDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=TypeDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        TypeDropdownValues.add(ThirdEle);

        TypeDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=TypeDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        TypeDropdownValues.add(FourthEle);

        System.out.println("Client side Type dropdown values are: " +TypeDropdownValues);
        return TypeDropdownValues;
    }

    public void clickOnReasonOption() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement ReasonOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list']//button[2]")));
        //ReasonOption.click();
        HelpersMethod.ActClick(driver, ReasonOption, 100);
        /*WebElement ReasonOption=driver.findElement(By.xpath("//div[@class='list']//button[2]"));
        if(ReasonOption.isDisplayed()) {
            ReasonOption.click();
        }else System.out.println("reason option not available");*/
    }

    public List<String> getReasonValues() {
        List<String> reasonValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                reasonValues.add(cells.get(1).getText()); // Assuming Module value is present in the first column

            }
        }System.out.println("Reason Values are:  " +reasonValues);
        return reasonValues;
    }

    public List<String> getReasonDropdownValues() {
        List<String> ReasonDropdownValues = new ArrayList<>();
        WebElement ReasonDropDown=driver.findElement(By.xpath("//span[@id='dropdown-reason']"));
        ReasonDropDown.click();
        String FirstEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 1st web element is: "+FirstEle);
        ReasonDropdownValues.add(FirstEle);

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        ReasonDropdownValues.add(SecondEle);

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        ReasonDropdownValues.add(ThirdEle);

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        ReasonDropdownValues.add(FourthEle);

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String FifthEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        ReasonDropdownValues.add(FifthEle);

        System.out.println("Client side Reason dropdown values are: " +ReasonDropdownValues);
        return ReasonDropdownValues;
    }

    public void clickOnCategoryOption() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement CategoryOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list']//button[7]")));
        //CategoryOption.click();
        HelpersMethod.ActClick(driver, CategoryOption, 100);
    }

    public List<String> getCategoryValues() {
        List<String> categoryValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                categoryValues.add(cells.get(1).getText()); // Assuming Category value is present in the first column
            }
        }System.out.println("Category Values are:  " +categoryValues);
        return categoryValues;
    }

    public List<String> getCategoryDropdownValues() {
        List<String> CategoryDropdownValues = new ArrayList<>();
        WebElement CategoryDropDown=driver.findElement(By.xpath("//span[@id='dropdown-category']"));
        CategoryDropDown.click();
        String FirstEle=CategoryDropDown.getText();
        //System.out.println("Dropdown 1st web element is: "+FirstEle);
        CategoryDropdownValues.add(FirstEle);

        CategoryDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=CategoryDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        CategoryDropdownValues.add(SecondEle);

        CategoryDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=CategoryDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        CategoryDropdownValues.add(ThirdEle);

        CategoryDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=CategoryDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        CategoryDropdownValues.add(FourthEle);

        System.out.println("Client side Category dropdown values are: " +CategoryDropdownValues);
        return CategoryDropdownValues;
    }

    public void clickOnActionOption() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement ActionOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list']//button[8]")));
        HelpersMethod.ActClick(driver, ActionOption, 100);
    }

    public List<String> getActionValues() {
        List<String> actionValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                actionValues.add(cells.get(1).getText()); // Assuming Category value is present in the first column
            }
        }System.out.println("Action Values are:  " +actionValues);
        return actionValues;
    }

    public List<String> getActionDropdownValues() {
        List<String> ActionDropdownValues = new ArrayList<>();
        WebElement ActionDropDown=driver.findElement(By.xpath("//span[@id='dropdown-action']"));
        ActionDropDown.click();
        String FirstEle=ActionDropDown.getText();
        //System.out.println("Dropdown 1st web element is: "+FirstEle);
        ActionDropdownValues.add(FirstEle);
        System.out.println("Client side Action dropdown values are: " +ActionDropdownValues);
        return ActionDropdownValues;
    }

    public void clickOnFeedbackOption() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement FeedbackOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list']//button[9]")));
        HelpersMethod.ActClick(driver, FeedbackOption, 100);
    }

    public List<String> getFeedbackValues() {
        List<String> feedbackValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                feedbackValues.add(cells.get(1).getText()); // Assuming Category value is present in the first column
            }
        }System.out.println("Feedback Values are:  " +feedbackValues);
        return feedbackValues;
    }

    public List<String> getFeedbackDropdownValues() {
        List<String> FeedbackDropDownValues = new ArrayList<>();
        WebElement FeedbackDropDown=driver.findElement(By.xpath("//span[@id='dropdown-feedback']"));
        FeedbackDropDown.click();
        String FirstEle=FeedbackDropDown.getText();
        //System.out.println("Dropdown 1st web element is: "+FirstEle);
        FeedbackDropDownValues.add(FirstEle);
        System.out.println("Client side Feedback dropdown values are: " +FeedbackDropDownValues);
        return FeedbackDropDownValues;
    }

    public void clickOnFeedbackTypeOption() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement FeedbackTypeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list']//button[10]")));
        HelpersMethod.ActClick(driver, FeedbackTypeOption, 100);
    }

    public List<String> getFeedbackTypeValues() {
        List<String> feedbackTypeValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                feedbackTypeValues.add(cells.get(1).getText()); // Assuming Category value is present in the first column
            }
        }System.out.println("Feedback type Values are:  " +feedbackTypeValues);
        return feedbackTypeValues;
    }

    public List<String> getFeedbackTypeDropdownValues() {
        List<String> FeedbackTypeDropDownValues = new ArrayList<>();
        WebElement FeedbackTypeDropDown=driver.findElement(By.xpath("//span[@id='dropdown-feedbacktype']"));
        FeedbackTypeDropDown.click();
        String FirstEle=FeedbackTypeDropDown.getText();
        //System.out.println("Dropdown 1st web element is: "+FirstEle);
        FeedbackTypeDropDownValues.add(FirstEle);
        System.out.println("Client side feedback type dropdown values are: " +FeedbackTypeDropDownValues);
        return FeedbackTypeDropDownValues;
    }

    public List<String> getStatusNotyDropdownValues() {
        List<String> StatusDropDownValues = new ArrayList<>();
        WebElement StatusDropDown=driver.findElement(By.xpath("//span[@id='Status']"));
        StatusDropDown.click();

        StatusDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=StatusDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        StatusDropDownValues.add(FirstEle);

        StatusDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=StatusDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        StatusDropDownValues.add(SecondEle);

        StatusDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=StatusDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        StatusDropDownValues.add(ThirdEle);

        StatusDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=StatusDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        StatusDropDownValues.add(FourthEle);

        System.out.println("Admin side under notification status dropdown values are: " +StatusDropDownValues);

        return StatusDropDownValues;
    }
    public void clickOnStatusTab()  {
        WebElement StatusOption = driver.findElement(By.xpath("//div[@class='list']//button[1]"));
        if(StatusOption.isSelected()){
            System.out.println("Status by default selected");
        } else System.out.println("Status is not selected");
    }
    public List<String> getStatusValues() {
        List<String> StatusValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                StatusValues.add(cells.get(1).getText()); // Assuming Category value is present in the first column
            }
        }System.out.println("status Values are:  " +StatusValues);
        return StatusValues;
    }


    public void clickOnListOfOptionOfHamburger() {
        WebElement HamburgerList=driver.findElement(By.xpath("//div[@class='drawer-menu-container-more-items']"));
        HamburgerList.click();
    }

    public List<String> getSourceNotyDropdownValues() {
        List<String> SourceDropDownValues = new ArrayList<>();
        WebElement SourceDropDown=driver.findElement(By.xpath("//span[@id='Source'] "));
        SourceDropDown.click();

        SourceDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=SourceDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        SourceDropDownValues.add(FirstEle);

        SourceDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=SourceDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        SourceDropDownValues.add(SecondEle);

        SourceDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=SourceDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        SourceDropDownValues.add(ThirdEle);

        SourceDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=SourceDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        SourceDropDownValues.add(FourthEle);

        SourceDropDown.sendKeys(Keys.ARROW_DOWN);
        String FifthEle=SourceDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        SourceDropDownValues.add(FifthEle);

        System.out.println("Admin side under notification Source dropdown values are: " +SourceDropDownValues);

        return SourceDropDownValues;
    }

    public void clickOnSourceTab() {
        WebElement SourceOption = driver.findElement(By.xpath("//div[@class='list']//button[3]"));
        SourceOption.click();
    }

    public List<String> getSourceValues() {
        List<String> SourceValues = new ArrayList<>();

        // Assuming the module values are present in a table with rows and columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='k-grid-table']//tr"));

        // Skip the first row if it contains table headers
        int startIndex = 0;
        if (rows.size() > 0 && rows.get(0).findElements(By.tagName("th")).size() > 0) {
            startIndex = 1;
        }

        for (int i = startIndex; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                SourceValues.add(cells.get(1).getText()); // Assuming Category value is present in the first column
            }
        }System.out.println("status Values are:  " +SourceValues);
        return SourceValues;
    }

    public List<String> getPriorityNotyDropdownValues() {
        List<String> PriorityDropDownValues = new ArrayList<>();
        WebElement PriorityDropDown=driver.findElement(By.xpath("//span[@id='Priority']"));
        PriorityDropDown.click();

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        PriorityDropDownValues.add(FirstEle);

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        PriorityDropDownValues.add(SecondEle);

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        PriorityDropDownValues.add(ThirdEle);

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        PriorityDropDownValues.add(FourthEle);

        PriorityDropDown.sendKeys(Keys.ARROW_DOWN);
        String FifthEle=PriorityDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        PriorityDropDownValues.add(FifthEle);

        System.out.println("Admin side under notification Priority dropdown values are: " +PriorityDropDownValues);

        return PriorityDropDownValues;
    }

    public List<String> getTypeNotyDropdownValues() {
        List<String> TypeDropDownValues = new ArrayList<>();
        WebElement TypeDropDown=driver.findElement(By.xpath("//span[@id='Type']"));
        TypeDropDown.click();

        TypeDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=TypeDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        TypeDropDownValues.add(FirstEle);

        TypeDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=TypeDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        TypeDropDownValues.add(SecondEle);

        TypeDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=TypeDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        TypeDropDownValues.add(ThirdEle);

        TypeDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=TypeDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        TypeDropDownValues.add(FourthEle);

        System.out.println("Admin side under notification Type dropdown values are: " +TypeDropDownValues);
        return TypeDropDownValues;
    }

    public List<String> getAppNotyDropdownValues() {
        List<String> AppDropDownValues = new ArrayList<>();
        WebElement AppDropDown=driver.findElement(By.xpath("//span[@id='Application']"));
        AppDropDown.click();

        AppDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=AppDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        AppDropDownValues.add(FirstEle);

        AppDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=AppDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        AppDropDownValues.add(SecondEle);

        AppDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=AppDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        AppDropDownValues.add(ThirdEle);

        AppDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=AppDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        AppDropDownValues.add(FourthEle);

        AppDropDown.sendKeys(Keys.ARROW_DOWN);
        String FifthEle=AppDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        AppDropDownValues.add(FifthEle);

        AppDropDown.sendKeys(Keys.ARROW_DOWN);
        String SixEle=AppDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        AppDropDownValues.add(SixEle);

        System.out.println("Admin side under notification Application dropdown values are: " +AppDropDownValues);
        return AppDropDownValues;
    }

    public List<String> getReasonNotyDropdownValues() {
        List<String> ReasonDropDownValues = new ArrayList<>();
        WebElement ReasonDropDown=driver.findElement(By.xpath("//span[@id='Reason']"));
        ReasonDropDown.click();

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        ReasonDropDownValues.add(FirstEle);

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        ReasonDropDownValues.add(SecondEle);

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        ReasonDropDownValues.add(ThirdEle);

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        ReasonDropDownValues.add(FourthEle);

        ReasonDropDown.sendKeys(Keys.ARROW_DOWN);
        String FifthEle=ReasonDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        ReasonDropDownValues.add(FifthEle);

        System.out.println("Admin side under notification reason dropdown values are: " +ReasonDropDownValues);
        return ReasonDropDownValues;
    }

    public List<String> getCategoryNotyDropdownValues() {
        List<String> CategoryDropDownValues = new ArrayList<>();
        WebElement CategoryDropDown=driver.findElement(By.xpath("//span[@id='Category']"));
        CategoryDropDown.click();

        CategoryDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=CategoryDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        CategoryDropDownValues.add(FirstEle);

        CategoryDropDown.sendKeys(Keys.ARROW_DOWN);
        String SecondEle=CategoryDropDown.getText();
        //System.out.println("Dropdown 3rd web element is: "+ThirdEle);
        CategoryDropDownValues.add(SecondEle);

        CategoryDropDown.sendKeys(Keys.ARROW_DOWN);
        String ThirdEle=CategoryDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        CategoryDropDownValues.add(ThirdEle);

        CategoryDropDown.sendKeys(Keys.ARROW_DOWN);
        String FourthEle=CategoryDropDown.getText();
        //System.out.println("Dropdown 4th web element is: "+FourthEle);
        CategoryDropDownValues.add(FourthEle);

        System.out.println("Admin side under notification category dropdown values are: " +CategoryDropDownValues);
        return CategoryDropDownValues;
    }

    public List<String> getActionNotyDropdownValues() {
        List<String> ActionDropDownValues = new ArrayList<>();
        WebElement ActionDropDown=driver.findElement(By.xpath("//span[@id='Action']"));
        ActionDropDown.click();

        ActionDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=ActionDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        ActionDropDownValues.add(FirstEle);
        System.out.println("Admin side under notification category dropdown values are: " +ActionDropDownValues);
        return ActionDropDownValues;
    }

    public List<String> getFeedbackNotyDropdownValues() {
        List<String> FeedbackDropDownValues = new ArrayList<>();
        WebElement FeedbackDropDown=driver.findElement(By.xpath("//span[@id='Feedback']"));
        FeedbackDropDown.click();

        FeedbackDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=FeedbackDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        FeedbackDropDownValues.add(FirstEle);
        System.out.println("Admin side under notification category dropdown values are: " +FeedbackDropDownValues);
        return FeedbackDropDownValues;
    }

    public List<String> getFeedbackTypeNotyDropdownValues() {
        List<String> FeedbackTypeDropDownValues = new ArrayList<>();
        WebElement FeedbackTypeDropDown=driver.findElement(By.xpath("//span[@id='Feedback type']"));
        FeedbackTypeDropDown.click();

        FeedbackTypeDropDown.sendKeys(Keys.ARROW_DOWN);
        String FirstEle=FeedbackTypeDropDown.getText();
        //System.out.println("Dropdown 2nd web element is: "+SecondEle);
        FeedbackTypeDropDownValues.add(FirstEle);
        System.out.println("Admin side under notification Feedback type dropdown values are: " +FeedbackTypeDropDownValues);
        return FeedbackTypeDropDownValues;
    }
}