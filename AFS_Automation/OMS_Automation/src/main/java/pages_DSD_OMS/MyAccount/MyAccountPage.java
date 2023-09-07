package pages_DSD_OMS.MyAccount;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.MailSend;
import util.TestBase;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MyAccountPage {

    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;

    static String currentURL = null;

    @FindBy(xpath = "//div[@class='user-info-initial-container']")
    private WebElement IconContainer;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement MyAccount;


    @FindBy(xpath = "//span[text()='Additional email recipients']")
    private WebElement additional_email_recipients;

    //add button
    @FindBy(xpath = "//button[@id='addEmailButton']")
    private WebElement add_button;

    //Email textbox
    @FindBy(xpath = "//input[@placeholder='User@example.com']")
    private WebElement Email_textbox;

    //Selects email row
    //@FindBy(xpath = "//div[@class='k-grid-container']//td[@colspan='1']/following-sibling::td[text()='effico_proc@effico.com']")
    //@FindBy(xpath = "//div[@class='k-grid-container']//td[@colspan='1' and text()='effico_proc@efficounet.com']")
    @FindBy(xpath = "(//div[@class='k-grid-container']//td[@colspan='1' and text()='Password Request'])[1]/following-sibling::td")
    private WebElement Email_gridcontainer;

    @FindBy(xpath = "(//div[@class='k-grid-container']//td[@colspan='1' and text()='Password Request'])/following-sibling::td[text()='effico_proc@efficounet.com']/..")
    private WebElement new_Emailadded_value;

    @FindBy(xpath = "(//div[@class='k-grid-container']//td[@colspan='1' and text()='Password Request'])/following-sibling::td[text()='effico_proc@efficounet.com']")
    private WebElement email_Alone;

    //div[@class='k-grid-container']//tr
    @FindBy(xpath = "//div[@class='k-grid-container']//tr")
    private WebElement email_Row;
    @FindBy(xpath = "//button[@id='deleteEmailAddressButton']")
    private WebElement delete_button;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement confirm_delete_yes;

    @FindBy(xpath = "//span[text()='Additional customer accounts']")
    private WebElement additional_customer_accounts_tab;

    @FindBy(xpath = "//input[@id='SearchBox1']")
    private WebElement additional_customer_search_box;

    @FindBy(xpath = "(//tbody[@role='presentation']/tr/td[1])[1]")
    private WebElement Customer_Account_no_MyAccount;

    @FindBy(xpath = "(//tbody[@role='presentation']/tr/td[1])[1]/..")
    private WebElement Customer_Account_row;

    @FindBy(xpath = "//button[@id='deleteAdditionalAccountButton']")
    private WebElement delete_button_customer_acc;

    ////button[@id='NoButton']

    @FindBy(xpath = "//button[@id='NoButton']")
    private WebElement delete_NO_button_customer_acc;
    String email_address = "effico_proc@efficounet.com";

    @FindBy(xpath = "//div[@class='loader-bg']")
    private WebElement loader_bg;

    //new_address_menu
    @FindBy(xpath = "//span[text()='Address']")
    private WebElement new_address_menu;

    @FindBy(xpath = "//span[text()='Payment info']")
    private WebElement payment_info_menu;

    //customeraccount_dropdown_newAddress
    @FindBy(xpath = "//span[text()='Select one...']")
    private WebElement customeraccount_dropdown_newAddress;

    @FindBy(xpath = "//button[@id='addAddressButton']")
    private WebElement Add_newAddress;
////button[@id='addPaymentMethodButton']
    @FindBy(xpath = "//button[@id='addPaymentMethodButton']")
    private WebElement addPayment;
    @FindBy(xpath = "//input[@id='Address']")
    private WebElement address_1;

    @FindBy(xpath = "//input[@id='City']")
    private WebElement City;

    @FindBy(xpath = "(//span[text()='Select one...'])[1]")
    private WebElement state_dropdown_Add_newAddress;

    @FindBy(xpath = "//input[@id='Zip']")
    private WebElement Zip;

    @FindBy(xpath = "//label[@id='Country-label']/following-sibling::span/span")
    private WebElement Country_dropdown;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement address_save;

    @FindBy(xpath = "//button[@id='editAddressButton']")
    private WebElement address_Edit;

    @FindBy(xpath = "//button[@id='deleteAddressButton']")
    private WebElement address_Delete;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement First_name_Payment;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement Last_name_Payment;

    @FindBy(xpath = "//input[@id='CCNumber']")
    private WebElement card_no_Payment;

    @FindBy(xpath = "//input[@id='CCExpMonth']")
    private WebElement Month_Payment;

    @FindBy(xpath = "//input[@id='CCExpYear']")
    private WebElement Year_Payment;

    @FindBy(xpath = "//input[@id='CCCVC']")
    private WebElement ccv;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement cancel_Payment;

    @FindBy(xpath = "//button[@id='deletePaymentMethodButton']")
    private WebElement Delete_Payment_details;

    @FindBy(xpath = "//button[@id='setPreferedPaymentMethodButton']")
    private WebElement Set_Preferred_Payment_Info;
    String credit_Card_no = "4111111111111111";
    String month_Payment ="12";

    String year_Payment = "32";

    String CCV="212";

    String First_name="Vin";

    String Last_name="Diesel";

    //Initializing the Page Objects:
    public MyAccountPage(WebDriver driver, Scenario scenario) {
        this.scenario = scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Enter 'My Account' in search box and clicks the My Account menu to navigate
    public String navigateToMyAccount() {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("My Account").build().perform();
            //WebElement User_ManagementMenu = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='User Management']");
            HelpersMethod.ClickBut(driver, MyAccount, 100);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).build().perform();
                act.click(WebEle).build().perform();
            }
            if (HelpersMethod.IsExists("//span[text()='My Account']", driver)) {
                HelpersMethod.ClickBut(driver, MyAccount, 100);
                scenario.log("NAVIGATED TO My Account PAGE");
            }
            //apr-11
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            } else {
                scenario.log("MY ACCOUNT MODULE MAY NOT BE ENABLED FOR THE APPLICATION");
            }
            currentURL = driver.getCurrentUrl();
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
        return currentURL;
    }

    public void landOn_AdditionalEmailRecipientPage() {
        WebElement WebEle = null;
        exists = true;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.ClickBut(driver, additional_email_recipients, 100);
        String addstring = add_button.getText();
        Assert.assertEquals(addstring, "Add");
    }

    public void User_enters_Email_Address_recipients() throws InterruptedException {
        //exists=false;
        //HelpersMethod.ClickBut(driver, new_Emailadded_value, 100);
        //String Email_container = Email_gridcontainer.getText();
        //List<WebElement> email_names=driver.findElements(By.xpath("//div[@class='k-grid-container']//td[@colspan='1' and text()='effico_proc@efficounet.com']"));
        //if (Email_gridcontainer.isDisplayed() != false) {


//            HelpersMethod.ClickBut(driver, new_Emailadded_value, 100);
//            HelpersMethod.ClickBut(driver, delete_button, 100);
//            HelpersMethod.ClickBut(driver, confirm_delete_yes, 100);
        HelpersMethod.Implicitwait(driver, 40);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            new WebDriverWait(driver, Duration.ofMillis(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='k-grid-container']//td[@colspan='1' and text()='Password Request'])/following-sibling::td[text()='effico_proc@efficounet.com']/..")));
            HelpersMethod.ClickBut(driver, new_Emailadded_value, 100);
            HelpersMethod.ClickBut(driver, delete_button, 100);
            HelpersMethod.ClickBut(driver, confirm_delete_yes, 100);


        } catch (Exception e) {
            HelpersMethod.ClickBut(driver, Email_textbox, 100);
            HelpersMethod.sendKeys(driver, Email_textbox, 100, email_address);
            HelpersMethod.ClickBut(driver, add_button, 100);

        }

        //Thread.sleep(7000);
        //driver.navigate().refresh();
    }

    //How to close a browser when a exception is thrown
//    public void User_adds_Email_Address_recipients() throws IOException {
//      try {
//          HelpersMethod.ClickBut(driver, add_button, 100);
//      }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//            System.exit(1);
//            driver.quit();
//        }
//    }

//    public void User_adds_Email_Address_recipients() throws IOException {
//        try {
//            HelpersMethod.ClickBut(driver, add_button, 100);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//            System.exit(1);
//            driver.quit();
//        }
//    }

    public void User_deletes_Email_Address_recipients() {
        HelpersMethod.Implicitwait(driver, 40);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        new WebDriverWait(driver, Duration.ofMillis(200)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='k-grid-container']//td[@colspan='1' and text()='Password Request'])/following-sibling::td[text()='effico_proc@efficounet.com']/..")));
        HelpersMethod.clickOn(driver, new_Emailadded_value, 100);

        //HelpersMethod.clickOn(driver, new_Emailadded_value, 100);
//        Actions act = new Actions(driver);
//        WebElement ele = driver.findElement(By.xpath("(//div[@class='k-grid-container']//td[@colspan='1' and text()='Password Request'])/following-sibling::td[text()='effico_proc@efficounet.com']/.."));
//        act.doubleClick(ele).perform();
        if ((delete_button.isDisplayed() && delete_button.isEnabled()) == true)
        {
            System.out.println("user_validated that_delete_button_is_enabled");
        }
        HelpersMethod.ClickBut(driver, delete_button, 100);
        //HelpersMethod.Implicitwait(driver,20);
        HelpersMethod.ClickBut(driver, confirm_delete_yes, 100);
    }

    public void User_deletes_Email_Address_recipients_Delete_Button() {
        HelpersMethod.Implicitwait(driver, 40);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //if (Email_gridcontainer.isDisplayed() != false)
        if (new_Emailadded_value.isSelected() == false) {
            HelpersMethod.clickOn(driver, new_Emailadded_value, 100);
        }


        HelpersMethod.ClickBut(driver, delete_button, 100);
        HelpersMethod.Implicitwait(driver, 20);
        HelpersMethod.ClickBut(driver, confirm_delete_yes, 100);
    }

    public void validate_Email_Address_recipients_added() {
        //HelpersMethod.Implicitwait(driver, 40);
        //HelpersMethod.ClickBut(driver, new_Emailadded_value, 100);
        HelpersMethod.Implicitwait(driver, 40);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.ClickBut(driver, email_Alone, 100);
        String efficounet = email_Alone.getText();
        Assert.assertEquals(efficounet, email_address);
    }

    public void user_validates_delete_button_is_enabled()
    {
        if ((delete_button.isDisplayed() && delete_button.isEnabled()) == true)
        {
            System.out.println("user_validated that_delete_button_is_enabled");
        }

    }
    public void validate_Email_Address_recipients_deleted() {

        HelpersMethod.Implicitwait(driver, 20);

        List<WebElement> validate_Delete_email_element = HelpersMethod.FindByElements(driver, "//div[@class='k-grid-container']//td[@colspan='1']/following-sibling::td[text()='effico_proc@efficounet.com']", "xpath");
        List<WebElement> Email_gridcontainer = null;
        int emaillistsize = Email_gridcontainer.size();
        if (emaillistsize == 0) {
            Assert.assertEquals(emaillistsize, 0);
        } else {
            Assert.assertEquals(emaillistsize, 0);
        }
    }

    //Additional customer account module
    public void landOn_Additionalcust_acc_tab() {
        //HelpersMethod.waitTillloaderDisappears(driver,loader_bg,100);
        WebElement WebEle = null;
        exists = true;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.ClickBut(driver, additional_customer_accounts_tab, 100);
    }

    public void Additionalcust_acc_search_box() {
        HelpersMethod.Implicitwait(driver, 40);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.ClickBut(driver, additional_customer_search_box, 100);
        additional_customer_search_box.clear();
    }

    public void user_fetches_the_account_number_MyAccount() {
        HelpersMethod.Implicitwait(driver, 40);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        String Customer_Account_no = Customer_Account_no_MyAccount.getText();
        HelpersMethod.sendKeys(driver, additional_customer_search_box, 100, Customer_Account_no);
        additional_customer_search_box.sendKeys(Keys.ENTER);
    }

    public void user_validates_grid_should_display_customer_account_no() {
        HelpersMethod.Implicitwait(driver, 40);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        String Customer_Account_no = Customer_Account_no_MyAccount.getText();
        Assert.assertEquals(Customer_Account_no, Customer_Account_no_MyAccount.getText());
    }

    public void user_deletes_details_of_the_mentioned_account_number() {
        //Customer_Account_row
        //HelpersMethod.Implicitwait(driver,40);
        //HelpersMethod.waitTillloaderDisappears(driver,loader_bg,100);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        try {
            new WebDriverWait(driver, Duration.ofMillis(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody[@role='presentation']/tr/td[1])[1]/..")));
            HelpersMethod.ClickBut(driver, Customer_Account_row, 100);
            HelpersMethod.ClickBut(driver, delete_button_customer_acc, 100);
            HelpersMethod.ClickBut(driver, delete_NO_button_customer_acc, 100);


        } finally {

        }
    }

    public void user_expands_the_my_account_and_its_associated_frames() {
        exists = false;
        WebElement WebEle;
        try {
            //create webdriver wait instance
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //xpath for side_menu="//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]"
            WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*[1]");
            Actions act1 = new Actions(driver);
            //Move mouse on menu icon

            //submenu bar before click original pattai -reduced -hamburger
            new WebDriverWait(driver, Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));

            //submenu bar after click
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            act1.moveToElement(WebEle).build().perform();
            act1.click(WebEle).build().perform();


            //find whether side menu bar has expanded
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 800);
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*[1]");
            act1.moveToElement(side_menu).build().perform();
        } finally {

        }
    }

    public void user_lands_on_new_address_page() {
        WebElement WebEle = null;
        exists = true;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.ClickBut(driver, new_address_menu, 100);
    }

    public void user_selects_a_customer_account_from_the_dropdown() throws InterruptedException {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        exists = false;
        WebElement WebEle;
        Actions act1 = new Actions(driver);
        //String subcategories = null;
        String pending_Username = null;
        String brand = null;
        int i = 0;

        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }


        //comment-Select Sub-categories

        HelpersMethod.ScrollElement(driver, customeraccount_dropdown_newAddress);
        HelpersMethod.ActClick(driver, customeraccount_dropdown_newAddress, 100);
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@class='k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown']", 200);
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown']");
        List<WebElement> subCats = modalContainer1.findElements(By.xpath(".//ul/li"));
        for (WebElement subCat : subCats) {
            i++;
            act1.moveToElement(subCat).build().perform();
            if (i == 2) {
                pending_Username = subCat.getText();
                act1.moveToElement(subCat).build().perform();
                act1.click(subCat).build().perform();
                scenario.log("User selected a customer acc #");
                break;
            }
        }
    }

    public void user_selects_the_resulted_customer_details_from_the_table() {
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        try {
            new WebDriverWait(driver, Duration.ofMillis(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody[@role='presentation']/tr/td[1])[1]/..")));
            HelpersMethod.ClickBut(driver, Customer_Account_row, 60);


        } finally {

        }
    }

    public void user_adds_the_address_button_for_the_selected_user() {
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        //HelpersMethod.clickOn(driver,Add_newAddress,50);
        HelpersMethod.ClickBut(driver, addPayment, 50);
    }

    public void enters_all_the_fields_in_the_address_page() {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.clearText(driver, address_1, 20);
        HelpersMethod.sendKeys(driver, address_1, 20, "10/45A,winston street");
        HelpersMethod.clearText(driver, City, 20);
        HelpersMethod.sendKeys(driver, City, 20, "New Hamshire");
        HelpersMethod.clearText(driver, Zip, 20);
        HelpersMethod.sendKeys(driver, Zip, 20, "94016");
    }

    //new address state dropdown
    public void user_selects_state_dropdown_Add_newAddress() throws InterruptedException {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        exists = false;
        WebElement WebEle;
        Actions act1 = new Actions(driver);
        //String subcategories = null;
        String pending_Username = null;
        String brand = null;
        int i = 0;

        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }


        //comment-Select Sub-categories

        HelpersMethod.ScrollElement(driver, state_dropdown_Add_newAddress);
        HelpersMethod.ActClick(driver, state_dropdown_Add_newAddress, 50);
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@class='k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown']", 200);
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown']");
        List<WebElement> subCats = modalContainer1.findElements(By.xpath(".//ul/li"));
        for (WebElement subCat : subCats) {
            i++;
            act1.moveToElement(subCat).build().perform();
            if (i == 2) {
                pending_Username = subCat.getText();
                act1.moveToElement(subCat).build().perform();
                act1.click(subCat).build().perform();
                scenario.log("User selected a customer acc #");
                break;
            }
        }
    }

    //new address country dropdown
    public void user_selects_country_dropdown_Add_newAddress() throws InterruptedException {

        exists = false;
        WebElement WebEle;
        Actions act1 = new Actions(driver);
        //String subcategories = null;
        String pending_Username = null;
        String brand = null;
        int i = 0;

        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }


        //comment-Select Sub-categories

        HelpersMethod.ScrollElement(driver, Country_dropdown);
        HelpersMethod.ActClick(driver, Country_dropdown, 50);
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@class='k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown']", 200);
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown']");
        List<WebElement> subCats = modalContainer1.findElements(By.xpath(".//ul/li"));
        for (WebElement subCat : subCats) {
            i++;
            act1.moveToElement(subCat).build().perform();
            if (i == 2) {
                pending_Username = subCat.getText();
                act1.moveToElement(subCat).build().perform();
                act1.click(subCat).build().perform();
                scenario.log("User selected a customer acc #");
                break;
            }
        }
    }

    public void user_saves_all_the_entered_address_fields() {

        HelpersMethod.ClickBut(driver, address_save, 20);
    }

    public void user_edits_the_address_button_for_the_selected_user() {
        HelpersMethod.ClickBut(driver, address_Edit, 20);
    }

    public void user_deletes_the_customer_details_from_the_table() {
        if (address_Delete.isEnabled()) {
            HelpersMethod.ClickBut(driver, address_Delete, 20);
        }
    }

    public void user_lands_on_payment_page_my_account() {
        WebElement WebEle = null;
        exists = true;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.ClickBut(driver, payment_info_menu, 100);
    }

    public void user_selects_a_customer_account_from_the_dropdown_payment_info() throws InterruptedException {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        exists = false;
        WebElement WebEle;
        Actions act1 = new Actions(driver);
        //String subcategories = null;
        String pending_Username = null;
        String brand = null;
        int i = 0;

        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }


        //comment-Select Sub-categories

        HelpersMethod.ScrollElement(driver, customeraccount_dropdown_newAddress);
        HelpersMethod.ActClick(driver, customeraccount_dropdown_newAddress, 100);
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@class='k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown']", 200);
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown']");
        List<WebElement> subCats = modalContainer1.findElements(By.xpath(".//ul/li"));
        for (
                WebElement subCat : subCats) {
            i++;
            act1.moveToElement(subCat).build().perform();
            if (i == 3) {
                pending_Username = subCat.getText();
                act1.moveToElement(subCat).build().perform();
                act1.click(subCat).build().perform();
                scenario.log("User selected a customer acc #");
                break;
            }
        }
    }

    public void enters_all_the_fields_and_saves_the_page_in_payment_info()

    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
        HelpersMethod.waitTillLoadingPage(driver);
    }
        HelpersMethod.clearText(driver, First_name_Payment, 20);
        HelpersMethod.sendKeys(driver, First_name_Payment, 20, First_name);
        HelpersMethod.clearText(driver, Last_name_Payment, 20);
        HelpersMethod.sendKeys(driver, Last_name_Payment, 20, Last_name);
        HelpersMethod.clearText(driver, card_no_Payment, 20);
        HelpersMethod.sendKeys(driver, card_no_Payment, 20, credit_Card_no);
        HelpersMethod.clearText(driver, Month_Payment, 20);
        HelpersMethod.sendKeys(driver, Month_Payment, 20, month_Payment);
        HelpersMethod.clearText(driver, Year_Payment, 20);
        HelpersMethod.sendKeys(driver, Year_Payment, 20, year_Payment);
        HelpersMethod.clearText(driver, ccv, 20);
        HelpersMethod.sendKeys(driver, ccv, 20, CCV);
}
    public void user_cancels_the_process_of_all_the_entered_address_fields()
    {
        HelpersMethod.ClickBut(driver, cancel_Payment, 20);
    }

    public void user_deletes_the_address_button_for_the_selected_user()

    {
        //delete_NO_button_customer_acc
        HelpersMethod.ClickBut(driver, Delete_Payment_details, 20);
        HelpersMethod.ClickBut(driver, delete_NO_button_customer_acc, 20);
    }

    public void user_validates_set_preferred_option_is_enabled()
    {
        if ((Set_Preferred_Payment_Info.isDisplayed() && Set_Preferred_Payment_Info.isEnabled()) == true)
        {
            System.out.println("user_validated that_delete_button_is_enabled");
        }
    }
}







