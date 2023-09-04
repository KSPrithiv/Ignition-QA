package pages_DSD_OMS.badgeBuilder_Phase1;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

import gherkin.lexer.He;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import helper.HelpersMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;
import util.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import java.io.IOException;

public class BadgeBuilderPage {


    WebDriver driver;
    Scenario scenario;
    private static String Tcolor;
    private static String Tiered_CatchColorAdmin;
    private static String Tiered_CatchColorAdmin2;
    private static String CatchwtColor;

    static boolean exists = false;
    static String currentURL = null;

    @FindBy(xpath = "//button[contains(@class,'k-button k-primary k-button-icontext') and contains(text(),'Sign In')]")
    private WebElement SignIn;
    @FindBy(xpath = "/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[32]/div[@class='badge-gallery-code']")
    private WebElement BadgeGallery2;
    @FindBy(xpath = "/html//input[@id='nameTextbox']")
    private WebElement TextBox;
    @FindBy(xpath = "/html//input[@id='codeTextbox']")
    private WebElement TextBoxCode;
    @FindBy(xpath = " /html//div[@id='badgeTypeCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='badge-type-container']/div[2]/div/input")
    private WebElement TextRadioBtn;
    @FindBy(xpath = "/html//div[@id='badgeTypeCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='badge-type-container']/div[2]/div/input")
    private WebElement RdButton2;
    @FindBy(xpath = "/html//div[@id='badgeTypeCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='badge-type-container']/div[1]/div/input")
    private WebElement RdButton1;
    @FindBy(xpath = "/html//div[@id='app']/div[@class='authorized-wrapper']/div[@class='page-container']/main[@class='main-content']//div[@class='children-content noPanel']//div[@class='icon-preview-container']/div/div[@class='i-card__card']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='label-preview-background label-preview-background-white']/div[@class='label-preview-background']/div[@class='label-preview-label']")
    private WebElement LabelPreview;
    @FindBy(xpath = "/html//div[@id='app']/div[@class='authorized-wrapper']/div[@class='page-container']/main[@class='main-content']/div//div[@class='i-header-toolbar__secondary-actions__expandable-area']/button")
    private WebElement PermissionBy;
    //    @FindBy(xpath = "/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[11]")
//    private WebElement BGTieredPricingProduct;
    @FindBy(xpath = "/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[12]")
    private WebElement BGTieredPricingProduct;

    @FindBy(xpath = "/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[13]")
    private WebElement BGCatchWeightItem;
    @FindBy(xpath = "div:nth-of-type(11) > .badge-gallery-icon-label > .label-preview-background.label-preview-background-white > .label-preview-background")
    private WebElement BGTieredPricingProduct1;
    @FindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]")
    private WebElement ClientsideIcon1;
    @FindBy(xpath = "/html//button[@id='addButton']")
    private WebElement StartOrder;
    @FindBy(xpath = "//button[contains(text(),'Start order')]")
    private WebElement StartOrder1;
    @FindBy(id = "customerAccountIndexSearchBar")
    private WebElement SearchOrder;
    @FindBy(xpath = "/html//div[@id='orderEntryCard']/div[@class='i-card__card__body i-card__card__body--expanded']//div[@class='order-grid-heading row']/div[1]/div/button[@type='button']")
    private WebElement AddOrder;
    @FindBy(xpath = "//div[contains(@class,'search-bar-container')]/descendant::input[@placeholder='Search products']")
    private WebElement SearchProd;
    @FindBy(xpath = "/html//div[@id='orderEntryCard']/div[@class='i-card__card__body i-card__card__body--expanded']//div[@role='combobox']/input")
    private WebElement SearchProd1;
    @FindBy(xpath = "/html//div[@id='productsCard']/div[@class='i-card__card__body i-card__card__body--expanded']//div[@role='combobox']/input")
    private WebElement SearchProdCat;

    @FindBy(xpath = "//div[contains(@class,'search-bar-container')]/descendant::span[contains(@class,'search-button-addon')][1]")
    private WebElement IndexSearch;
    @FindBy(xpath = "//li[@id='react-autowhatever-searchBarAutoSuggest--item-0']/div")
    private WebElement Search;
    @FindBy(xpath = "div#customer-info > div > div:nth-of-type(2) .i-button--icon-only.i-indexfield-container__main__button.k-button.k-button-icontext.k-outline > .i-icon")
    private WebElement SearchAccountNo;
    @FindBy(xpath = "//label[@id='RouteIndex-label']/parent::div/descendant::button")
    private WebElement RouteOE;
    @FindBy(xpath = "//input[contains(@placeholder,'Search products')]")
    private WebElement SearchBar;

    @FindBy(xpath = "//span[contains(@class,'search-button-addon search-button input-group-addon')]/descendant::*[local-name()='svg']")
    private WebElement SearchIndex;
    @FindBy(id="addStandingOrder")
    private WebElement StartStandingOrder;
    @FindBy(xpath="//button[text()='Add product']")
    private WebElement AddProduct;

    @FindBy(xpath = "//span[@class='k-widget k-datepicker']/descendant::a/span")
    private WebElement Calender;
    BadgeBuilderPage badgeBuilderPage;


    //static String Tcolor=null;


    public BadgeBuilderPage(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);

    }

    public void ClicOnHumburger1()
    {
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);

        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        WebElement Humburger;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='MuiPaper-root MuiDrawer-paper drawer-closed MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0']//div[@class='item-searchbar']", driver)) {
                Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='MuiPaper-root MuiDrawer-paper drawer-closed MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0']//div[@class='item-searchbar']");
                HelpersMethod.JScriptClick(driver, Humburger, 20);
            }
        }
        catch (Exception e){}

    }

    public void ClicOnGeneralSetting() throws InterruptedException {
//        Thread.sleep(3000);
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);

        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }


        WebElement GSetting;
        try {
            if (HelpersMethod.IsExists("//span[contains(@class, 'menu-item-text')][contains(text(), 'General Settings')]", driver)) {
                GSetting = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class, 'menu-item-text')][contains(text(), 'General Settings')]");
                HelpersMethod.waitTillElementDisplayed(driver, GSetting, 100);


                HelpersMethod.JScriptClick(driver, GSetting, 20);
                //HelpersMethod.waitTillLoadingWheelDisappears(driver, Humburger, 20);
                //HelpersMethod.waitTillLoadingPage(driver);
            }
        } catch (Exception e) {
        }

    }


    public void ClickOnBadgeBuilder() throws InterruptedException {
//        Thread.sleep(3000);


        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
        }
        WebElement BadgeBuilderoption;
        try {
            if (HelpersMethod.IsExists("//div[contains(@class, 'submenu-item-text')][contains(text(), 'Badge Builder')]", driver)) {
                BadgeBuilderoption = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class, 'submenu-item-text')][contains(text(), 'Badge Builder')]");
                HelpersMethod.JScriptClick(driver, BadgeBuilderoption, 20);
            }
        } catch (Exception e) {}
    }


    public void ClickOnBadgeBuilderIcon() {

        WebElement BadgeBuildericon;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//div[@id='badgeIconCard']//div[@class='badge-icon-content']/div[3]", driver)) {
                BadgeBuildericon = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeIconCard']//div[@class='badge-icon-content']/div[3]");
                //HelpersMethod.Implicitwait(driver,10);
                HelpersMethod.JScriptClick(driver, BadgeBuildericon, 20);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
        }
    }

    public void BadgeBuilderPreviewDisplay() {
        // WebDriverWait wt = new WebDriverWait(driver,10);


        WebElement BadgeBuilderPreview;
        //wt.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".icon-preview-tooltip-container > .icon-preview-background.icon-preview-background-white > .icon-preview-background > .icon-preview-icon > .i-icon")));
        //wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-preview-tooltip-container > .icon-preview-background.icon-preview-background-white > .icon-preview-background > .icon-preview-icon > .i-icon")));
        //  BadgeBuilderPreview = driver.findElement(By.xpath("/html//div[@id='badgeIconCard']//div[@class='badge-icon-content']/div[3]"));
        //BadgeBuilderPreview = driver.findElement(By.xpath("(//*[local-name()='svg' ])[118]"));
        BadgeBuilderPreview = driver.findElement(By.cssSelector(".icon-preview-tooltip-container > .icon-preview-background.icon-preview-background-white > .icon-preview-background > .icon-preview-icon > .i-icon"));
        //new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(BadgeBuilderPreview));

        if (BadgeBuilderPreview.isDisplayed()) {
            System.out.println("Preview displayed");
        } else {
            System.out.println("Preview not displayed");

        }

    }

    public void Refresh_Page() {

        driver.navigate().refresh();
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
    }

    public void Scrolldown() throws InterruptedException {
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "/html//div[@id='badgeGalleryCard']//div[@class='badge-subsection-header']/span[1]", 40);
        WebElement BadgeGallery;
        BadgeGallery = driver.findElement(By.xpath("/html//div[@id='badgeGalleryCard']//div[@class='badge-subsection-header']/span[1]"));
        HelpersMethod.JSScroll(driver, BadgeGallery);
//        Thread.sleep(3000);
        //HelpersMethod.Implicitwait(driver, 20);

    }

    public void ClickOnBadgeGallerBadge() {

        //new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElementLocated(By.id("EditButton"),"Edit"));

        WebElement BadgeGalleryBadge;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[6]/div[@class='badge-gallery-code']", driver)) {
                BadgeGalleryBadge = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[6]/div[@class='badge-gallery-code']");
                HelpersMethod.JScriptClick(driver, BadgeGalleryBadge, 20);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void Delete() {
        WebElement DeleteButton;
        DeleteButton = driver.findElement(By.xpath("/html//button[@id='deleteButton']"));
        //new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(DeleteButton));
        if (DeleteButton.isEnabled()) {
            System.out.println("Delete Button is Enabled");
        } else {
            System.out.println("Delete Button is Disabled");
        }
    }

    public void ScrollUP() {

        WebElement BadgeIconView;
        BadgeIconView = driver.findElement(By.xpath("/html//div[@id='badgeIconCard']//div[@class='badge-icon-content']/div[3]"));

        HelpersMethod.JSScroll(driver, BadgeIconView);
    }

    public void ClickOnBadgeBuilderIcon2() {
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "/html//div[@id='badgeIconCard']//div[@class='badge-icon-content']/div[4]", 40);

        WebElement BadgeBuildericon;
        try {
            if (HelpersMethod.IsExists("/html//div[@id='badgeIconCard']//div[@class='badge-icon-content']/div[4]", driver)) {
                BadgeBuildericon = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeIconCard']//div[@class='badge-icon-content']/div[4]");
                //HelpersMethod.Implicitwait(driver,10);
                HelpersMethod.JScriptClick(driver, BadgeBuildericon, 20);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void EditTextBox() {
        String str = "LABEL20";

        WebElement TextBox;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//input[@id='nameTextbox']", driver)) {
                TextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='nameTextbox']");
                Thread.sleep(3000);
                //HelpersMethod.
                // Implicitwait(driver,10);
                //HelpersMethod.JScriptClick(driver, TextBox, 20);
                HelpersMethod.clearText(driver, TextBox, 20);
                HelpersMethod.sendKeys(driver, TextBox, 20, str);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }

    }


    public void AddToGallery() {

        WebElement Submit;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//button[@id='plusButton']", driver)) {
                Submit = HelpersMethod.FindByElement(driver, "xpath", "/html//button[@id='plusButton']");
                //HelpersMethod.Implicitwait(driver,10);
                HelpersMethod.JScriptClick(driver, Submit, 20);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
        }
    }

    public void EditVerify() {
        WebElement NamePreview;
        WebElement TextBox1;
        TextBox1 = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='nameTextbox']");
        String Text = TextBox1.getAttribute("value");
        System.out.println(Text+":Badge Name");
        //NamePreview = HelpersMethod.FindByElement(driver,"xpath", "/html//div[@id='app']/div[@class='authorized-wrapper']/div[@class='page-container']/main[@class='main-content']//div[@class='children-content noPanel']//div[@class='icon-preview-tooltip-container']/div[1]/div[@class='k-tooltip']/div[@class='k-tooltip-content']");
        NamePreview = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='app']/div[@class='authorized-wrapper']/div[@class='page-container']/main[@class='main-content']//div[@class='children-content noPanel']//div[@class='icon-preview-container']/div[2]/div[@class='i-card__card']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='label-preview-background label-preview-background-white']/div[@class='label-preview-background']/div[@class='label-preview-label']");
        String enteredName = NamePreview.getText();
        System.out.println(enteredName+":Badge Name after Edit");
        if (enteredName.equals(Text)) {
            System.out.println("Edit name text box validation successful");
        } else {
            System.out.println("Edit name text box validation failed");

        }

    }

    public void BadgeCode() {
        WebElement BadgeCodeField;
        BadgeCodeField = driver.findElement(By.xpath("/html//input[@id='codeTextbox']"));
        // new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(BadgeCodeField));
        if (BadgeCodeField.isEnabled()) {
            System.out.println("BadgeCodeField is Enabled");
        } else {
            System.out.println("BadgeCodeField is Disabled");
        }
    }

    public void Refresh_Page(String currentURL1) {
        try {
            WebElement WebEle = null;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
            }
            driver.navigate().to(currentURL1);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
            }
        } catch (Exception e) {
        }
    }

    public void EditTextBox1() {
        String str = "LABEL25";

        WebElement TextBox1;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//input[@id='nameTextbox']", driver)) {
                TextBox1 = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='nameTextbox']");
                Thread.sleep(3000);
                //HelpersMethod.Implicitwait(driver,10);
                //HelpersMethod.JScriptClick(driver, TextBox, 20);
                HelpersMethod.clearText(driver, TextBox1, 20);
                HelpersMethod.sendKeys(driver, TextBox1, 20, str);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void ColourChange() {


        WebElement WebEleColour;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//div[@id='badgeColorCard']//div[@class='colorsRow']/div[8]/div[@class='color-circle']", driver)) {
                WebEleColour = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeColorCard']//div[@class='colorsRow']/div[8]/div[@class='color-circle']");
//                Thread.sleep(3000);
                //HelpersMethod.Implicitwait(driver,10);
                //HelpersMethod.JScriptClick(driver, TextBox, 20);
                HelpersMethod.JScriptClick(driver, WebEleColour, 20);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void SavedChanges() {
        WebElement ColorWebEle1;
        WebElement ColorWebEle2;

        WebElement SavedName;
        WebElement TextBox2;
        TextBox2 = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='nameTextbox']");
        String Text2 = TextBox2.getAttribute("value");
        System.out.println(Text2+":Name");
        //NamePreview = HelpersMethod.FindByElement(driver,"xpath", "/html//div[@id='app']/div[@class='authorized-wrapper']/div[@class='page-container']/main[@class='main-content']//div[@class='children-content noPanel']//div[@class='icon-preview-tooltip-container']/div[1]/div[@class='k-tooltip']/div[@class='k-tooltip-content']");
        SavedName = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[33]/div[@class='badge-gallery-name']");
        String strSavedName = SavedName.getText();
        System.out.println(strSavedName+":Name after Saved to Gallery");
        ColorWebEle1 = driver.findElement(By.cssSelector(".icon-preview-tooltip-container > .icon-preview-background.icon-preview-background-white > .icon-preview-background > .icon-preview-icon > .i-icon"));
        //String color = ColorWebEle1.getCssValue("fill");
        String color1 = ColorWebEle1.getAttribute("fill");
        System.out.println(color1+":Color");
        ColorWebEle2 = driver.findElement(By.cssSelector("div:nth-of-type(33) > .badge-gallery-icon-label > .icon-preview-background.icon-preview-background-white > .icon-preview-background > .icon-preview-icon > .i-icon"));
        String color2 = ColorWebEle2.getAttribute("fill");
        System.out.println(color2+":Color after saved to Gallery");


        if (strSavedName.equals(Text2) && color1.equals(color2)) {
            System.out.println("Successfully submitted");
        } else {
            System.out.println("Failed");

        }


    }

    public void BadgeType() {

        WebElement RadioBt1;
        WebElement RadioBt2;
        WebElement RadioBt3;

        WebElement PreviewIcon1;
        WebElement PreviewIcon2;
        WebElement Preview;
        WebElement PreviewIcon3;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//div[@id='badgeTypeCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='badge-type-container']/div[1]/div/input", driver)) {
                RadioBt1 = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeTypeCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='badge-type-container']/div[1]/div/input");
                //HelpersMethod.Implicitwait(driver,10);
                HelpersMethod.JScriptClick(driver, RadioBt1, 20);
//                Thread.sleep(2000);
                // HelpersMethod.Implicitwait(driver,3);

                PreviewIcon1 = driver.findElement(By.cssSelector(".icon-preview-tooltip-container > .icon-preview-background.icon-preview-background-white > .icon-preview-background > .icon-preview-icon > .i-icon"));

                String InitialsrcAttribute = PreviewIcon1.getAttribute("class");
                System.out.println(InitialsrcAttribute);
                String TextValue1 = PreviewIcon1.getText();
                System.out.println(TextValue1);

                Assert.assertTrue(InitialsrcAttribute.contains("icon") && TextValue1 == "");
                System.out.println("Given Badge Type contains only Icon");


                RadioBt2 = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeTypeCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='badge-type-container']/div[2]/div/input");
                //HelpersMethod.Implicitwait(driver,10);
                HelpersMethod.JScriptClick(driver, RadioBt2, 20);
//                Thread.sleep(2000);
                PreviewIcon2 = driver.findElement(By.cssSelector(".i-card__card__body.i-card__card__body--expanded > .label-preview-background.label-preview-background-white > .label-preview-background > .label-preview-label"));
                String TextValue2 = PreviewIcon2.getText();
                Assert.assertFalse(InitialsrcAttribute.contains("icon") && TextValue2 == "");
                System.out.println("Given Badge Type contains only Text");

                //Assert.assertTrue(InitialsrcAttribute.contains("icon")&&TextValue2=="","Given Badge Type contains only Text");
                RadioBt3 = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeTypeCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='badge-type-container']/div[3]/div/input");
                HelpersMethod.JScriptClick(driver, RadioBt3, 20);
//                Thread.sleep(2000);
                // HelpersMethod.Implicitwait(driver,4);
                Preview = driver.findElement(By.cssSelector(".icon-preview-container"));
                String TextValue3 = Preview.getText();
                System.out.println(TextValue3+":Badge Name");
//                Thread.sleep(2000);

                PreviewIcon3 = driver.findElement(By.cssSelector(".icon-preview-container"));
                String InitialsrcAttribute1 = PreviewIcon3.getAttribute("class");
                System.out.println(InitialsrcAttribute1);
                Assert.assertTrue(InitialsrcAttribute1.contains("icon") && TextValue3 != "");
                System.out.println("Given Badge Type contains both Icon and Text");


//                if(TextValue2!="") {
//                    System.out.println("Given Badge Type contains Text");
//                }

//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void ClickOnBadgeGallerBadge1() {
        try {
            if (HelpersMethod.IsExists("/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[32]/div[@class='badge-gallery-code']", driver)) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                HelpersMethod.JScriptClick(driver, BadgeGallery2, 20);

//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void Scrolldown1() throws InterruptedException {
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[32]/div[@class='badge-gallery-code']", 40);
        HelpersMethod.JSScroll(driver, BadgeGallery2);
        Thread.sleep(3000);
        //HelpersMethod.Implicitwait(driver, 20);

    }

    public void EditBadgeGlry() throws InterruptedException {
        WebElement EditBtn;
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "/html//button[@id='editButton']", 40);
        EditBtn = driver.findElement(By.xpath("/html//button[@id='editButton']"));
        HelpersMethod.JScriptClick(driver, EditBtn, 20);
        //HelpersMethod.Implicitwait(driver, 20);

    }

    public void EditBadgeInfo() {
        exists = false;
        String str1 = "NoEntry";
        String str2 = "C0000002X";
        WebElement WebEle;
        try {
            Thread.sleep(3000);
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='nameTextbox']");
            HelpersMethod.clearText(driver, TextBox, 20);
            String InputValue = RandomValues.generateRandomAlphaNumeric(4);
            HelpersMethod.sendKeys(driver, WebEle, 10, InputValue);
            HelpersMethod.sendKeys(driver, TextBox, 20, str1);
            HelpersMethod.clearText(driver, TextBoxCode, 20);
//        HelpersMethod.clearText(driver, TextBoxCode, 20);
            HelpersMethod.sendKeys(driver, TextBoxCode, 20, str2);
            //PoNo=InputValue;
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ColourChangeBDType() {


        WebElement WebEleColour;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//div[@id='badgeColorCard']//div[@class='colorsRow']/div[3]/div[@class='color-circle']", driver)) {
                WebEleColour = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeColorCard']//div[@class='colorsRow']/div[3]/div[@class='color-circle']");
                HelpersMethod.Implicitwait(driver, 10);
                //HelpersMethod.Implicitwait(driver,10);
                //HelpersMethod.JScriptClick(driver, TextBox, 20);
                HelpersMethod.JScriptClick(driver, WebEleColour, 20);
                HelpersMethod.JScriptClick(driver, RdButton1, 20);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void SavedChanges1() {
        WebElement ColorWebEle1;
        WebElement ColorWebEle2;

        WebElement SavedName;
        WebElement TextBox2;
        TextBox2 = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='nameTextbox']");
        String Text2 = TextBox2.getAttribute("value");
        System.out.println(Text2+":Badge Name 1");
        //NamePreview = HelpersMethod.FindByElement(driver,"xpath", "/html//div[@id='app']/div[@class='authorized-wrapper']/div[@class='page-container']/main[@class='main-content']//div[@class='children-content noPanel']//div[@class='icon-preview-tooltip-container']/div[1]/div[@class='k-tooltip']/div[@class='k-tooltip-content']");
        SavedName = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeGalleryCard']//div[@class='badge-gallery-container']/div[32]/div[@class='badge-gallery-name']");
        String strSavedName = SavedName.getText();
        System.out.println(strSavedName+":Badge Name 2");
        ColorWebEle1 = driver.findElement(By.cssSelector(".icon-preview-tooltip-container > .icon-preview-background.icon-preview-background-white > .icon-preview-background > .icon-preview-icon > .i-icon"));
        //ColorWebEle1 = driver.findElement(By.cssSelector(".i-card__card__body.i-card__card__body--expanded > .label-preview-background.label-preview-background-white > .label-preview-background > .label-preview-label"));
        //String color = ColorWebEle1.getCssValue("fill");
        String color1 = ColorWebEle1.getAttribute("fill");
        System.out.println(color1+":Icon Color 1");
        ColorWebEle2 = driver.findElement(By.cssSelector("div:nth-of-type(32) > .badge-gallery-icon-label > .icon-preview-background.icon-preview-background-white > .icon-preview-background > .icon-preview-icon > .i-icon"));
        //ColorWebEle2 = driver.findElement(By.cssSelector("div:nth-of-type(32) > .badge-gallery-icon-label > .label-preview-background.label-preview-background-white > .label-preview-background > .label-preview-label"));
        String color2 = ColorWebEle2.getAttribute("fill");
        System.out.println(color2+":Icon color 2");
//        HelpersMethod.JScriptClick(driver, RdButton2, 20);
//        String enteredName = LabelPreview.getText();
//        System.out.println(enteredName);
        // Assert.assertTrue(enteredName != "");
        //Assert.assertTrue(strSavedName.equals(Text2) && color1.equals(color2),"Success");

//        if (strSavedName.equals(Text2) && color1.equals(color2)) {
//            System.out.println("Successfully submitted");
//        } else {
//            System.out.println("Failed");
//
//        }
        Assert.assertTrue(strSavedName.equals(Text2) && color1.equals(color2), "Success");
//
//
//    }
    }


    public void selectCompany() {
        exists = false;
        WebElement WebEle;
        Actions act = new Actions(driver);
        String company = null;
        HelpersMethod.JScriptClick(driver, PermissionBy, 20);
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver)) {
                //Click on Company drop down
                WebEle = HelpersMethod.FindByElement(driver, "id", "dropdownList3");
                HelpersMethod.ClickBut(driver, WebEle, 20);
                HelpersMethod.Implicitwait(driver, 80);
                Thread.sleep(3000);
                //Thread.sleep(10);
                //Create list of web elements in dropdown
//                company= TestBase.testEnvironment.get_CompanyNo();
//                List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
//                for(WebElement Val: Values)
//                {
//                    act.moveToElement(Val).build().perform();
//                    String Val_Text = Val.getText();
//                    HelpersMethod.Implicitwait(driver,40);
//                    if (Val_Text.equalsIgnoreCase(company) || Val_Text.contains(company))
//                    {
//                        act.click(Val).build().perform();
//                        HelpersMethod.Implicitwait(driver,40);
//                        break;
//                    }
//                }
                WebElement Company = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@class='k-animation-container k-animation-container-relative k-animation-container-shown']/div/div[@class='i-header-toolbar-popup__content i-header-toolbar-popup__content--expanded']/div/div[2]/span[@class='dropdown-left']/span[2]/span/span[@role='listbox']/span[@class='k-input']");
                act.moveToElement(Company).sendKeys("000101, Flowers Baking Co. of Thomasville").click().build().perform();
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='dropdownList3']/span[1]");
                scenario.log("COMPANY SELECTED IS " + WebEle.getText());
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }

        } catch (Exception e) {
        }
    }

    public String BGTiredPricing() {
        String TProductColor = null;


        try {
            HelpersMethod.JScriptClick(driver, BGTieredPricingProduct, 20);
            WebElement Tcolor = driver.findElement(By.cssSelector("div:nth-of-type(12) > .badge-gallery-icon-label > .label-preview-background.label-preview-background-white > .label-preview-background > .label-preview-label"));
            TProductColor = Tcolor.getCssValue("color");
            System.out.println(TProductColor);


        } catch (Exception e) {
        }
        return TProductColor;
    }

    public void ColourChange2() {


        WebElement WebEleColour;
        WebElement WebEleColour2;

//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//div[@id='badgeColorCard']//div[@class='colorsRow']/div[3]/div[@class='color-circle']", driver)) {
                WebEleColour = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='badgeColorCard']//div[@class='colorsRow']/div[3]/div[@class='color-circle']");
                HelpersMethod.Implicitwait(driver, 10);
                //HelpersMethod.Implicitwait(driver,10);
                //HelpersMethod.JScriptClick(driver, TextBox, 20);
                HelpersMethod.JScriptClick(driver, WebEleColour, 20);
                Tiered_CatchColorAdmin=WebEleColour.getCssValue("background-color");
                WebEleColour2=driver.findElement(By.cssSelector(".icon-preview-tooltip-container > .icon-preview-background.icon-preview-background-white > .icon-preview-background"));
                Tiered_CatchColorAdmin2=WebEleColour2.getCssValue("background-color");
                //String TieredPricingColorAdmin1=WebEleColour.getCssValue("color");
                System.out.println(Tiered_CatchColorAdmin+"Tiered/Catch Color from Admin");
                System.out.println(Tiered_CatchColorAdmin2+"Tiered/Catch Color1 from Admin");
            }
        } catch (Exception e) {
        }
    }

    public void Click_On_UserIcon() throws InterruptedException {
        try {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                new WebDriverWait(driver, 8000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]", 2400);
            WebElement UserIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]");
            new WebDriverWait(driver, 6000).until(ExpectedConditions.visibilityOf(UserIcon));
            HelpersMethod.JScriptClick(driver, UserIcon, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                new WebDriverWait(driver, 8000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view user-info k-animation-container-shown')]", 600);
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void Click_On_Signout() throws InterruptedException {
        try {
            exists = false;
            WebElement WebEle;
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/div[@class='popup-content']");
            WebElement signOut = dropDown.findElement(By.xpath(".//div[contains(@class,'user-info-line user-info-line-signout')]"));
            HelpersMethod.ActClick(driver, signOut, 400);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            HelpersMethod.waitTillTitleContains(driver, "Ignition - Login", 60);
            String title = driver.getTitle();
            if (title.equals("Ignition - Login")) {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
        Thread.sleep(3000);
    }

    public void ClicOnHumburger() throws InterruptedException {
        WebElement Humburger;
        try {
            if (HelpersMethod.IsExists("//div[@class='MuiPaper-root MuiDrawer-paper drawer-closed MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0']//div[@class='item-searchbar']", driver)) {
                Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='MuiPaper-root MuiDrawer-paper drawer-closed MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0']//div[@class='item-searchbar']");
                HelpersMethod.JScriptClick(driver, Humburger, 20);
            }
        } catch (Exception e) {
        }
        Thread.sleep(5000);
    }

    public void Clientside() throws InterruptedException {
        try {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                new WebDriverWait(driver, 8000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Thread.sleep(8000);
        new WebDriverWait(driver, 400).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".settings-back-container > .i-icon")));
//        Thread.sleep(5000);
        HelpersMethod.Implicitwait(driver, 30);
        WebElement ClientsideIcon;
        ClientsideIcon = driver.findElement(By.cssSelector(".settings-back-container > .i-icon"));
        HelpersMethod.waitTillElementDisplayed(driver, ClientsideIcon, 200);
        //HelpersMethod.JScriptClick(driver, ClientsideIcon, 20);
        ClientsideIcon.click();
        } catch (Exception e) {}


    }

    public void NavigateToOrderEntryScreen() {
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Order Entry").build().perform();
            WebElement OEMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Order Entry')]");
            HelpersMethod.ActClick(driver, OEMenu, 100);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));
            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).click().build().perform();
            }
            currentURL = driver.getCurrentUrl();
        } catch (Exception e) {
        }
    }

    public void ChangeAccountNumber1() {
        exists = false;
        WebElement WebEle = null;
        String Acc_No = null;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            // HelpersMethod.Implicitwait(driver,40);
            Actions act = new Actions(driver);
            Acc_No = "0040035975-000000-000295";
//            WebEle=HelpersMethod.FindByElement(driver,"id","customerAccountNumberComboBox");
//            act.moveToElement(WebEle).click().build().perform();
            //WebEle.clear();
            act.sendKeys(WebEle, Acc_No).build().perform();
            WebElement AccDrop1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-list-container ')]/descendant::li");
            HelpersMethod.JScriptClick(driver, AccDrop1, 40);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            WebEle = HelpersMethod.FindByElement(driver, "id", "customerAccountNumberComboBox");
            Acc_No = HelpersMethod.JSGetValueEle(driver, WebEle, 20);
            scenario.log("CUSTOMER ACCOUNT# SELECTED IS " + Acc_No);
            if (!Acc_No.equals(null)) {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void StartOrder() throws InterruptedException {
        WebElement WebEle = null;
        if(StartOrder.isEnabled()) {

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
            }
            //HelpersMethod.waitTillElementLocatedDisplayed(driver,StartOrder,100)
            //WebDriverWait wait=new WebDriverWait(driver,100);
            HelpersMethod.waitTillElementDisplayed(driver, StartOrder, 200);
            //wait.until(ExpectedConditions.elementToBeClickable(StartOrder));

            //Thread.sleep(10000);
            HelpersMethod.JScriptClick(driver, StartOrder, 100);
            // Thread.sleep(4000);
//        String str = "11X";
//
//        WebElement POTextBox;
////        WebElement WebEle=null;
//        try {
//            if (HelpersMethod.IsExists("/html//input[@id='poNumber']", driver)) {
//                POTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='poNumber']");
//                Thread.sleep(3000);
//                //HelpersMethod.Implicitwait(driver,10);
//                //HelpersMethod.JScriptClick(driver, TextBox, 20);
//                HelpersMethod.clearText(driver, POTextBox, 20);
//                HelpersMethod.sendKeys(driver, POTextBox, 20, str);
////                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
//            }
//        } catch (Exception e) {
//        }
            // Thread.sleep(3000);
            //HelpersMethod.JScriptClick(driver,AddOrder,20);
        }
        else{
            WebElement TableProduct= driver.findElement(By.xpath("//div[@id='order-search-card']//div[@class='order-search-grid']/div[@role='presentation']/div[@role='grid']/div[2]/div[@role='presentation']//table[@role='presentation']//tr[@role='row']//button[@type='button']"));
            HelpersMethod.ScrollElement(driver, TableProduct);
            TableProduct.click();
        }

    }
    public boolean Start_Order() {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            if (HelpersMethod.IsExistsById("addButton", driver) && StartOrder.isEnabled()) {
                HelpersMethod.ScrollElement(driver, SearchOrder);
                HelpersMethod.ClickBut(driver, StartOrder, 20);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                exists = true;
            }
//            else
//            {
//                //If start button is not enabled either skip is enabled or cutoff date has been reached
//                ClickCalender();
//                ChangedDeliveryDate();
//                SelectDate(ChangeDate,40);
//                HelpersMethod.ScrollElement(driver, SearchOrder);
//                HelpersMethod.ClickBut(driver, StartOrder, 40);
//                status = HelpersMethod.returnDocumentStatus(driver);
//                if (status.equals("loading"))
//                {
//                    HelpersMethod.waitTillLoadingPage(driver);
//                }
//                exists = true;
//            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
        return exists;
    }

    public void SearchProd() throws InterruptedException {
        WebElement WebEle;
        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        HelpersMethod.ScrollElement(driver, SearchProd);
//        Thread.sleep(5000);

        try {

            WebElement SearchIcon;
//            Thread.sleep(5000);

            HelpersMethod.sendKeys(driver, SearchProd1, 10, "10010800");
            //HelpersMethod.ClickBut(driver,IndexSearch,4);
//            Thread.sleep(5000);
            HelpersMethod.Implicitwait(driver, 30);
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
            //Thread.sleep(5000);


            SearchIcon = driver.findElement(By.cssSelector(".input-group-addon.search-button.search-button-addon > .i-icon"));
            //HelpersMethod.JScriptClick(driver, SearchIcon, 20);
            // HelpersMethod.waitTillElementDisplayed(driver, SearchIcon, 100);
            HelpersMethod.waitTillElementDisplayed(driver, SearchIcon, 100);
            // Thread.sleep(5000);

            SearchIcon.click();
        } catch (Exception e) {
        }
        //HelpersMethod.ClickBut(driver,Search,4);


    }

    public void SelectOGFromDropdown() {
        WebElement WebEle = null;
        exists = false;
        try {
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::li", "xpath", "From Order guides");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public String CompareProdColour() {
//        String Tcolor="1";


        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ColourChange2();



//            WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try {
//               if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
//                   WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//                   HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver)) {
                if (HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
                    WebElement catlogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                    //WebElement modalContentTitle = catlogPopup.findElement(By.xpath(".//div[contains(@class,'label-preview-background')]"));
                    //WebElement modalContentTitle1 = catlogPopup.findElement(By.cssSelector(".admin-badge-text-container > div > div>div"));
                    WebElement modalContentTitle1 = catlogPopup.findElement(By.cssSelector("div:nth-of-type(7) > .admin-badge-icon-container > div > div>div"));


//                    WebElement modalContentTitle1 = catlogPopup.findElement(By.cssSelector(".admin-badge-text-container .label-preview-label"));
                    //String Title = modalContentTitle.getText();
//                WebElement modalContentTitle1 = catlogPopup.findElement(By.cssSelector(".admin-badge-icon-container > div > div>div"));

                Tcolor = modalContentTitle1.getCssValue("background-color");
//                    Tcolor = modalContentTitle1.getCssValue("color");

                    //String Tcolor1 = modalContentTitle1.getCssValue("background-color");


                    System.out.println(Tcolor + "Tiered/Catch PricingColor from Client");
//                    String backgroundColor = extractBackgroundColor(Tcolor);
//                    Thread.sleep(20000);
                    WebElement CloseBtn = catlogPopup.findElement(By.cssSelector("a[role='button'] > .k-i-x.k-icon"));
                    HelpersMethod.ActClick(driver, CloseBtn, 20);
//                WebElement OkBtn = catlogPopup.findElement(By.xpath("//body/div[2]/div[@role='dialog']/div[3]/div/button[.='Ok']"));
//                WebElement OkBtn = catlogPopup.findElement(By.xpath("//body/div[2]/div[@role='dialog']/div[3]/div/button[.='Ok']"));
//                OkBtn.click();
                System.out.println(Tiered_CatchColorAdmin2);
//                    System.out.println(Tiered_CatchColorAdmin);
                    if (Tcolor.equals(Tiered_CatchColorAdmin2)) {
                        System.out.println("PRODUCT COLORS ARE SAME");
                    } else {
                        System.out.println("PRODUCT COLORS ARE NOT SAME");
                    }
                    //Assert.assertEquals(Tcolor,Tiered_CatchColorAdmin,"COLORS ARE NOT SAME");
                }
            }
            if (HelpersMethod.IsExists("//div[contains(@class,'card-view')]", driver))
            {
                if (HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
                    WebElement catlogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                    //WebElement modalContentTitle = catlogPopup.findElement(By.xpath(".//div[contains(@class,'label-preview-background')]"));
                    //WebElement modalContentTitle1 = catlogPopup.findElement(By.cssSelector("div:nth-of-type(7) > .admin-badge-icon-container > div > div"));

                    WebElement modalContentTitle1 = catlogPopup.findElement(By.cssSelector(".admin-badge-text-container .label-preview-label"));
                    //String Title = modalContentTitle.getText();
//                WebElement modalContentTitle1 = catlogPopup.findElement(By.cssSelector(".admin-badge-icon-container > div > div>div"));

//                Tcolor = modalContentTitle1.getCssValue("background-color");
                    Tcolor = modalContentTitle1.getCssValue("color");

                    //String Tcolor1 = modalContentTitle1.getCssValue("background-color");


                    System.out.println(Tcolor + "Tiered/Catch PricingColor from Client");
//                    String backgroundColor = extractBackgroundColor(Tcolor);
//                    Thread.sleep(20000);
                    WebElement CloseBtn = catlogPopup.findElement(By.cssSelector("a[role='button'] > .k-i-x.k-icon"));
                    HelpersMethod.ActClick(driver, CloseBtn, 20);
//                WebElement OkBtn = catlogPopup.findElement(By.xpath("//body/div[2]/div[@role='dialog']/div[3]/div/button[.='Ok']"));
//                WebElement OkBtn = catlogPopup.findElement(By.xpath("//body/div[2]/div[@role='dialog']/div[3]/div/button[.='Ok']"));
//                OkBtn.click();
//                System.out.println(Tiered_CatchColorAdmin2);
                    System.out.println(Tiered_CatchColorAdmin);
                    if (Tcolor.equals(Tiered_CatchColorAdmin)) {
                        System.out.println("PRODUCT COLORS ARE SAME");
                    } else {
                        System.out.println("PRODUCT COLORS ARE NOT SAME");
                    }
                    //Assert.assertEquals(Tcolor,Tiered_CatchColorAdmin,"COLORS ARE NOT SAME");
                }
            }
        } catch (Exception e) {
        }
        return Tcolor;
        //Assert.assertTrue(Color.equals(Tcolor));

    }
    public void ChangeAccount1() throws InterruptedException {
//        Thread.sleep(5000);


        exists = false;
        WebElement WebEle = null;
        String account = null;

        try {
            Robot robot = new Robot();
            account = "0040035975-000000-000295";
            // Refresh_Page(currentURL);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys("").build().perform();
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys(account).build().perform();
//            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
//           new WebDriverWait(driver,200).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container ')]/descendant::li")));
//           WebElement AccDrop = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@id,'option-')]");
//
//           WebElement AccDrop1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container ')]/descendant::li");
//           HelpersMethod.JScriptClick(driver,AccDrop1,10);
//           exists = true;
//           if (HelpersMethod.IsExists("//div[@class='loader']", driver))
//           {
//               WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//               HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
//           }
//           Assert.assertEquals(exists, true);
        } catch (Exception e) {

        }
    }



    public void Change_OldAccount()
    {
        exists = false;
        WebElement WebEle = null;
        String account;
        try
        {
            Refresh_Page(currentURL);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            account = "0040035975-000000-000295";
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys("").build().perform();
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys(account).build().perform();

            new WebDriverWait(driver,200).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container ')]/descendant::li")));
            WebElement AccDrop = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@id,'option-')]");

            WebElement AccDrop1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container ')]/descendant::li");
            HelpersMethod.JScriptClick(driver,AccDrop1,10);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }




    public void PopupOKBtn() {

        if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver)) {
    try {
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
        WebElement Popup1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
        //WebElement PopOk = Popup1.findElement(By.xpath("//body/div[2]/div[@role='dialog']/div[2]/div/button[.='Ok']"));
        //PopOk.click();
        //HelpersMethod.JScriptClick(driver, PopOk, 20);
        //HelpersMethod.ActClick(driver, PopOk, 400);
        WebElement okButton = Popup1.findElement(By.xpath(".//button[text()='Ok']"));
        HelpersMethod.ClickBut(driver, okButton, 80);
    } catch (Exception e) {}
     }
    }

    public void StartOrder1() {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            if (HelpersMethod.IsExistsById("addButton", driver) && StartOrder.isEnabled()) {
                HelpersMethod.ScrollElement(driver, SearchOrder);
                HelpersMethod.ClickBut(driver, StartOrder, 20);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                exists = true;
            }

        } catch (Exception e) {
        }
        //return exists;


    }

    public void SearchBoxAction() throws InterruptedException {
        WebElement WebEle;
//        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
//        Thread.sleep(3000);
        WebElement SearchIcon;
        //exists=false;
        String ProductNo=null;
        ProductNo= TestBase.testEnvironment.get_TieredProductNo();
        System.out.println(ProductNo);

        try {
            HelpersMethod.ScrollElement(driver, SearchProd1);
            SearchProd1.click();
//            Thread.sleep(5000);
            if (SearchProd1.isDisplayed()) {
                SearchIcon = driver.findElement(By.cssSelector(".input-group-addon.search-button.search-button-addon > .i-icon"));
                HelpersMethod.EnterText(driver, SearchProd1, 1, ProductNo);
//                Thread.sleep(4000);
                HelpersMethod.ActClick(driver, SearchIcon, 20);
                //exists = true;
            } else {
                scenario.log("SEARCH BOX IS NOT VISIBLE");
            }
            // Assert.assertEquals(exists,true);
        } catch (Exception e) {
        }
    }

    public void BGCatchWeightItem() {


        try {
            HelpersMethod.JScriptClick(driver, BGCatchWeightItem, 20);
            WebElement Ccolor = driver.findElement(By.cssSelector("div:nth-of-type(13) > .badge-gallery-icon-label > .label-preview-background.label-preview-background-white > .label-preview-background > .label-preview-label"));
            String CatchColor = Ccolor.getCssValue("color");
            System.out.println(CatchColor);


        } catch (Exception e) {
        }
    }

    public void SearchBoxActionCatchWt() {

        WebElement WebEle;
        String ProductNo1=null;
        ProductNo1=TestBase.testEnvironment.get_CatchWtProductNo();

        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebElement WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle1, 400);
            }
            WebElement SearchIcon;
            exists = false;
            HelpersMethod.ScrollElement(driver, SearchProd1);
//            Thread.sleep(5000);
            if (SearchProd1.isDisplayed()) {
                SearchIcon = driver.findElement(By.cssSelector(".input-group-addon.search-button.search-button-addon > .i-icon"));
                HelpersMethod.EnterText(driver, SearchProd1, 100, ProductNo1);
                //Thread.sleep(4000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebElement WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle1, 400);
                }
                HelpersMethod.ActClick(driver, SearchIcon, 100);
                exists = true;
            } else {
                scenario.log("SEARCH BOX IS NOT VISIBLE");
            }
            // Assert.assertEquals(exists,true);
        } catch (Exception e) {
        }
    }
    public void Comaprison1() {
        BGTiredPricing();
        CompareProdColour();
        if (BGTiredPricing() == CompareProdColour()) {

            System.out.println("Success");

        }

    }

    public void CatalogTab() throws InterruptedException {

        {
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver)) {
                //Thread.sleep(10000);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                //Thread.sleep(25000);
            } else {
                scenario.log("CATALOG TAB IS NOT VISIBLE");
            }
        }
    }


//    }

    public void SearchBoxActionCat() {
        {
            exists = false;
            WebElement WebEle = null;
            WebElement WebEle1 = null;
            String Prod_No=null;
            Prod_No=TestBase.testEnvironment.get_CatchWtProductNo();
            new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
            new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
            try {
                WebElement ProductCard = HelpersMethod.FindByElement(driver, "id", "productsCard");
                HelpersMethod.ScrollElement(driver, ProductCard);
                //Clear Search bar
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='searchBarClearBtn']//*[local-name()='svg']");
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 30);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                HelpersMethod.EnterText(driver, SearchBar, 2,Prod_No);
                Thread.sleep(5000);
                HelpersMethod.ActClick(driver, SearchIndex, 20);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                scenario.log("PRODUCT SECTLECTED IS " + Prod_No);
                exists = true;
                Assert.assertEquals(exists, true);
                Thread.sleep(5000);
//                WebEle1=HelpersMethod.FindByElement(driver,"xpath","/html//div[@id='productsCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div//div[@class='grid-item-box']//div[@class='product-catalog-image-container']/a[@href='#']/img[@alt='product thumb']");
//
//                HelpersMethod.ActClick(driver,WebEle1,30);
//                Thread.sleep(4000);
            } catch (Exception e) {
            }
        }

    }

    public String ProdColourCat() throws InterruptedException {
//        String CatchwtColor=null;
//        String CatchWtLabel=null;
          badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
          badgeBuilderPage.ColourChange2();


        try {
//            if (HelpersMethod.IsExists("/html//div[@id='productsCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div//div[@class='grid-item-box']//div[@class='product-catalog-image-container']/a[@href='#']/img[@alt='product thumb']", driver)) {
//                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "/html//div[@id='productsCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div//div[@class='grid-item-box']//div[@class='product-catalog-image-container']/a[@href='#']/img[@alt='product thumb']", 100);

                //WebElement CatchWtIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                //WebElement modalContentTitle = catlogPopup.findElement(By.xpath(".//div[contains(@class,'label-preview-background')]"));
                //WebElement modalContentTitle1 = catlogPopup.findElement(By.cssSelector(".admin-badge-text-container > div > div>div"));
//                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","/html//div[@id='productsCard']//div[@class='list-view']/div[@role='presentation']/div[@role='grid']/div[2]/div[@role='presentation']/div[1]/table[@role='presentation']/tbody[@role='presentation']/tr[@role='row']//div[@class='label-preview-background']/div/div",100);
//                Thread.sleep(2000);
//                WebElement CatchWtIcon = driver.findElement(By.cssSelector(".admin-badge-text-container .label-preview-label"));
            WebElement CatchWtIcon= driver.findElement(By.cssSelector("div:nth-of-type(2) > .admin-badge-text-container > .label-preview-background.label-preview-background-white > .label-preview-background > div > div"));

            //String Title = modalContentTitle.getText();
                CatchwtColor = CatchWtIcon.getCssValue("color");
                System.out.println(CatchwtColor);
                HelpersMethod.Implicitwait(driver, 20);
                //Thread.sleep(30000);

                if(Tiered_CatchColorAdmin.equals(CatchwtColor)){
                    System.out.println("PRODUCT COLORS ARE SAME");
                }
                else {
                    System.out.println("PRODUCT COLORS ARE NOT SAME");
                }
//                Assert.assertEquals(Tiered_CatchColorAdmin,CatchwtColor,"COLORS ARE NOT SAME");

//            }

        } catch (Exception e) {
        }
        return CatchwtColor;


    }

    public void ColorCheck() throws InterruptedException {
        BadgeBuilderPage page = new BadgeBuilderPage(driver, scenario);
        page.ProdColourCat();
        page.CompareProdColour();
        page.BGTiredPricing();
        page.BGCatchWeightItem();
        System.out.println(CatchwtColor + "ColorCheck from Cat");
        System.out.println(Tcolor + "Tiered Wt Product Clr");
        System.out.println(CatchwtColor + "Catch Wt Product Color1");

    }

    public void AddCatProdToGrid() {


        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'card-view')]", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
                WebElement Popup1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement AddButton = Popup1.findElement(By.cssSelector(".i-button--icon-only.i-numeric-box-int__buttonPlus.k-button.k-button-icontext.k-primary"));
//            WebElement AddButton = Popup1.findElement(By.cssSelector("tbody[role='presentation'] > tr[role='row'] .k-i-arrow-n.k-icon"));
                HelpersMethod.ScrollElement(driver, AddButton);
                HelpersMethod.ClickBut(driver, AddButton, 80);
//                Thread.sleep(2000);
                WebElement okButton1 = Popup1.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, okButton1, 80);
            }
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
                WebElement Popup1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
//                WebElement AddButton = Popup1.findElement(By.cssSelector(".i-button--icon-only.i-numeric-box-int__buttonPlus.k-button.k-button-icontext.k-primary"));
                WebElement AddButton = Popup1.findElement(By.cssSelector("tbody[role='presentation'] > tr[role='row'] .k-i-arrow-n.k-icon"));
                HelpersMethod.ScrollElement(driver, AddButton);
                HelpersMethod.ClickBut(driver, AddButton, 80);
//                Thread.sleep(2000);
                WebElement okButton1 = Popup1.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, okButton1, 80);
            }


            } catch (Exception e) {
        }


    }


    public String ProdColourCat2() throws InterruptedException {

        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ColourChange2();


        String CatSearchIconClr = null;
//        String CatchWtLabel=null;
        WebElement WebEle;


        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
//            Thread.sleep(2000);
            //WebElement CatSearchIcon = driver.findElement(By.cssSelector("td:nth-of-type(12) > div > div:nth-of-type(1) > .admin-badge-icon-container > div > div>div"));
//            WebElement CatSearchIcon = driver.findElement(By.cssSelector("td:nth-of-type(10) > div > div:nth-of-type(1) > .admin-badge-icon-container > div > div>div"));
            WebElement CatSearchIcon = driver.findElement(By.cssSelector("td:nth-of-type(10) > div > div:nth-of-type(1) > .admin-badge-icon-container > div > div>div"));


            //String Title = modalContentTitle.getText();
            HelpersMethod.Implicitwait(driver, 20);
            HelpersMethod.waitTillElementDisplayed(driver, CatSearchIcon, 100);

            HelpersMethod.ScrollElement(driver, CatSearchIcon);

            //String Tcolor = modalContentTitle1.getAttribute("background-color");
            //String Tcolor = modalContentTitle1.getCssValue("background-color");
            CatSearchIconClr = CatSearchIcon.getCssValue("background-color");
            //CatSearchIconClr = CatSearchIcon.getCssValue("color");
            System.out.println(CatSearchIconClr);
            HelpersMethod.Implicitwait(driver, 20);
//            Thread.sleep(8000);

            if(Tiered_CatchColorAdmin2.equals(CatSearchIconClr)){
                System.out.println("PRODUCT COLORS ARE SAME");
            }
            else {
                System.out.println("PRODUCT COLORS ARE NOT SAME");
            }
            //Assert.assertEquals(Tiered_CatchColorAdmin2,CatSearchIconClr,"COLORS ARE NOT SAME");


        } catch (Exception e) {
        }
        return CatSearchIconClr;



    }

    public void Refresh_Page1() {
        try {
            WebElement WebEle = null;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
            }
            driver.navigate().to(currentURL);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
            }
        } catch (Exception e) {
        }
    }


    public void Logout() throws InterruptedException {
        try {
            exists = false;
            WebElement WebEle;
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/div[@class='popup-content']");
            WebElement signOut = dropDown.findElement(By.xpath(".//div[contains(@class,'user-info-line user-info-line-signout')]"));
            HelpersMethod.ActClick(driver, signOut, 400);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            HelpersMethod.waitTillTitleContains(driver, "Ignition - Login", 60);
            String title = driver.getTitle();
            if (title.equals("Ignition - Login")) {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }


    public void OrderGuids() throws InterruptedException {
//        Thread.sleep(5000);

        {
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and Order Guids(text(),'Order Guids')]", driver)) {
                //Thread.sleep(10000);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Order Guids", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                //Thread.sleep(25000);


            } else {
                scenario.log("ORDER GUIDE TAB IS NOT VISIBLE");
            }
        }


    }

    public void Orders() throws InterruptedException {
        {
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]", driver)) {
                //Thread.sleep(10000);
                //HelpersMethod.navigate_Horizantal_Tab(driver, "Order Guids", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]", "xpath", "/html//div[@id='app']/div[@class='authorized-wrapper']/div[@class='page-container']/main[@class='main-content']/div[@class='authorized container-fluid']/div[@class='contentRow row']//ul[@role='tablist']/li[2]/span[@class='k-link']");
                //Thread.sleep(25000);
                WebElement OrderGuid = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='app']/div[@class='authorized-wrapper']/div[@class='page-container']/main[@class='main-content']/div[@class='authorized container-fluid']/div[@class='contentRow row']//ul[@role='tablist']/li[2]/span[@class='k-link']");
                HelpersMethod.ClickBut(driver, OrderGuid, 100);


            } else {
                scenario.log("CATALOG TAB IS NOT VISIBLE");
            }
        }


    }

    public void CreateNewOrder() throws AWTException {


        WebElement WebEle;
        try {
            Robot robot = new Robot();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
            }
                Thread.sleep(8000);
                WebElement CreateNew;
                CreateNew = driver.findElement(By.xpath("/html//button[@id='plusAdditionalAccountButtonFlat']"));
                HelpersMethod.waitTillElementDisplayed(driver, CreateNew, 100);
                HelpersMethod.JScriptClick(driver, CreateNew, 20);
                // CreateNew.click();
                //HelpersMethod.ClickBut(driver, CreateNew, 80);


//            HelpersMethod.Implicitwait(driver, 10);


            WebElement ProductTextBox;
            WebElement SequenceTextBox;
//            String str = "00000011";
            String ProductNo=null;
            ProductNo= TestBase.testEnvironment.get_TieredProductNo();
            String str1 = "1";

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
                HelpersMethod.Implicitwait(driver, 10);
                Thread.sleep(5000);
                ProductTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='quickProduct']");
                HelpersMethod.waitTillElementDisplayed(driver, ProductTextBox, 100);
                Thread.sleep(2000);
                HelpersMethod.sendKeys(driver, ProductTextBox, 20, ProductNo);
                SequenceTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='quickSequence']");
                HelpersMethod.sendKeys(driver, SequenceTextBox, 20, str1);
                SequenceTextBox.sendKeys((Keys.TAB));
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                Thread.sleep(3000);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            }
        }
//         catch (AWTException e) {}
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void PopupDiscardAll() {
        // WebDriverWait wt = new WebDriverWait(driver,10);
//        if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'without submitting')]",driver))
        if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]",driver))
            try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
            WebElement Popup1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement okButton = Popup1.findElement(By.xpath(".//button[text()='Discard all']"));
            HelpersMethod.ClickBut(driver, okButton, 80);
        } catch (Exception e) {
        }

    }
    public void RoutePopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                scenario.log("ROUTE NUMBER REQUIRED POPUP HAS BEEN HANDLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProduct() throws InterruptedException {
        Thread.sleep(8000);
        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@id='web-order-page-content']//div[@class='i-card__card']//div[@class='core-grid-admin-top-wrapper']/div[@role='presentation']/div[@role='grid']/div[3]/div[@role='presentation']/div[1]/table[@role='presentation']/tbody[@role='presentation']/tr[@role='row']//button[@type='button']", 100);
            WebElement Product = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='web-order-page-content']//div[@class='i-card__card']//div[@class='core-grid-admin-top-wrapper']/div[@role='presentation']/div[@role='grid']/div[3]/div[@role='presentation']/div[1]/table[@role='presentation']/tbody[@role='presentation']/tr[@role='row']//button[@type='button']");

            HelpersMethod.ScrollElement(driver, Product);
            WebElement ClickProduct = Product.findElement(By.xpath("//div[@id='web-order-page-content']//div[@class='i-card__card']//div[@class='core-grid-admin-top-wrapper']/div[@role='presentation']/div[@role='grid']/div[3]/div[@role='presentation']/div[1]/table[@role='presentation']/tbody[@role='presentation']/tr[@role='row']//button[@type='button']"));
//            HelpersMethod.ClickBut(driver,ClickProduct,80);
            HelpersMethod.JScriptClick(driver, ClickProduct, 20);
        } catch (Exception e) {
        }


    }

    public String OrderGuideColorCheck() throws InterruptedException {
        String OrderGuideClrCheck = null;
//        String CatchWtLabel=null;
        WebElement WebEle;
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ColourChange2();
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Thread.sleep(2000);
//            WebElement OrderGuideClr = driver.findElement(By.cssSelector(".admin-badge-text-container .label-preview-label"));
            WebElement OrderGuideClr= driver.findElement(By.cssSelector("span:nth-of-type(2) > .admin-badge-text-container .label-preview-label"));


            HelpersMethod.waitTillElementDisplayed(driver, OrderGuideClr, 100);
            HelpersMethod.Implicitwait(driver, 20);
            Thread.sleep(5000);
            //  OrderGuideClrCheck = OrderGuideClr.getCssValue("background-color");
            OrderGuideClrCheck = OrderGuideClr.getCssValue("color");
            System.out.println(OrderGuideClrCheck);

            if(Tiered_CatchColorAdmin.equals(OrderGuideClrCheck)){
                System.out.println("PRODUCT COLORS ARE SAME");
            }
            else {
                System.out.println("PRODUCT COLORS ARE NOT SAME");
            }
           // Assert.assertEquals(Tiered_CatchColorAdmin,OrderGuideClrCheck,"COLORS ARE NOT SAME");



        } catch (Exception e) {
        }
        return OrderGuideClrCheck;


    }

    public void StartOrderOpenOrder() {
        exists = false;
        WebElement WebEle;
        try {

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.waitTillElementDisplayed(driver, StartOrder1, 100);

            HelpersMethod.ScrollElement(driver, StartOrder1);
            //HelpersMethod.ClickBut(driver, StartOrder1, 60);
            HelpersMethod.JScriptClick(driver, StartOrder1, 60);
            scenario.log("START ORDER BUTTON HAS BEEN CLICKED");
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void AddFromDropdown() {
        WebElement WebEle = null;
        exists = false;
        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//html//div[@id='openOrdersCard']/div[@class='i-card__card__body i-card__card__body--expanded']//div[@class='core-grid-admin-top-wrapper']/div[1]/div/button[@type='button']", 80);
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::li", "xpath", "Add");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void EnterAccountNo_InSearchBar() {
        String Account_No = "0040035975-000000-000295";
        WebElement SearchIcon1;
        WebElement Account;
        exists = false;
        try {

            WebElement AccountPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            WebElement SearchAccount = AccountPopup.findElement(By.xpath("//div[contains(@class,'i-search-box')]/descendant::input[@placeholder='Search']"));
            //HelpersMethod.ScrollElement(driver, SearchProd);
            HelpersMethod.sendKeys(driver, SearchAccount, 10, Account_No);
            //HelpersMethod.ClickBut(driver,IndexSearch,4);
            exists = true;
            scenario.log("SELECTED ACCOUNT NUMBER IS " + Account_No);
            Assert.assertEquals(exists, true);

            SearchIcon1 = driver.findElement(By.cssSelector("form > .i-icon.i-search-box__search"));
            HelpersMethod.waitTillElementDisplayed(driver, SearchIcon1, 100);
            // Thread.sleep(5000);

            SearchIcon1.click();

            Account = driver.findElement(By.xpath("//div[@role='dialog']//div[@class='core-grid-admin-top-wrapper']/div[@role='presentation']/div[@role='grid']/div[3]/div[@role='presentation']//table[@role='presentation']//tr[@role='row']/td[3]"));
            HelpersMethod.waitTillElementDisplayed(driver, Account, 100);
            // Thread.sleep(5000);

            Account.click();
        } catch (Exception e) {
        }
    }

    public void SelectDeliveryDate() {
        //LocalDate currentDate=LocalDate.now();
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 80);


        List<WebElement> dateElements = driver.findElements(By.xpath("//table[@class='k-calendar-table k-calendar-content k-content']//.//span[@class='k-link']"));
        for (WebElement dateElement : dateElements) {
            String dateText = dateElement.getText();
//            LocalDate date = LocalDate.parse(dateText, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//            if (!date.isBefore(currentDate) && dateElement.isEnabled()) {
            dateElement.click();
            System.out.println(dateText);
            break; // Exit the loop after selecting the next enabled date
//            }
        }

    }

    public void OpenOrderPopup() {


        try {
            //HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'modal-content')]", 100);
            if (HelpersMethod.IsExists("//div[contains(@class,'modal-content')]')]", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'modal-content')]", 100);
                WebElement PopupOpenOrder = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'modal-content')]");
                System.out.println("Select Order Pop is displayed");
                WebElement Click = PopupOpenOrder.findElement(By.xpath(".//button[@class='list-group-item'][1]"));
                HelpersMethod.ClickBut(driver,Click,80);
                //HelpersMethod.ActClick(driver, Click, 400);
                //HelpersMethod.JScriptClick(driver, Click, 20);
            }
        } catch (Exception e) {
        }

    }


    public void StartOrder_OpenOrder() throws AWTException {


        WebElement WebEle;
        try {
            Robot robot = new Robot();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);

                // CreateNew.click();
                //HelpersMethod.ClickBut(driver, CreateNew, 80);
            }

            HelpersMethod.Implicitwait(driver, 10);


            WebElement ProductTextBox;
            WebElement UnitTextBox;
            String str = "00000011";
            String str1 = "1";

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
                HelpersMethod.Implicitwait(driver, 10);
                ProductTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='quickProduct']");
                Thread.sleep(3000);
                HelpersMethod.waitTillElementDisplayed(driver, ProductTextBox, 100);
                Thread.sleep(2000);
                //HelpersMethod.Implicitwait(driver,10);
                //HelpersMethod.JScriptClick(driver, TextBox, 20);
                // HelpersMethod.clearText(driver, ProductTextBox, 20);
                HelpersMethod.sendKeys(driver, ProductTextBox, 20, str);
                UnitTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='quickUnits']");
                HelpersMethod.sendKeys(driver, UnitTextBox, 20, str1);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                Thread.sleep(3000);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


    public void VerifyCalenderPopupStandingOrder() throws InterruptedException
    {
        WebElement fromDateContainer;
        WebElement WebEle;
        String FTDate=null;
        //Create WebElement for popup
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
        WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath",  "//div[contains(@class,'k-widget k-window k-dialog')]");

        // Verify the title of Add standing order popup
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Add standing order", "Verify Title message");

        //Click on From Calender icon
        WebElement startDateIcon = modalContainer.findElement(By.xpath(".//label[contains(@id,'addFromDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
        HelpersMethod.ActClick(driver, startDateIcon, 100);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        new WebDriverWait(driver,200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));

        //Select 'From' date from Start date calender
        if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]",driver))
        {
            // to fetch the web element of the modal container
            fromDateContainer = HelpersMethod.FindByElement(driver,"xpath","//table[@class='k-calendar-table']");
            WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@class,'k-state-focused')]"));
            if (ele1.isDisplayed() && ele1.isEnabled())
            {
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ActClick(driver, ele1, 100);
                exists = true;
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                WebEle = HelpersMethod.FindByElement(driver, "id", "addFromDate");
                FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 10);
                scenario.log(FTDate + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
            }
            else
            {
                scenario.log("FAILED TO SELECT START DATE");
            }
        }

        //Click on To calender icon
        WebElement toDateIcon = modalContainer.findElement(By.xpath(".//label[contains(@id,'addToDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
        HelpersMethod.ActClick(driver, toDateIcon, 80);
        new WebDriverWait(driver,100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));

        //Select 'To' date from End date calender
        if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]",driver))
        {
            // to fetch the web element of the modal container
            fromDateContainer = HelpersMethod.FindByElement(driver,"xpath","//table[@class='k-calendar-table']");
            WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@class,'k-state-focused')]"));
            if (ele1.isDisplayed() && ele1.isEnabled())
            {
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ActClick(driver, ele1, 40);
                exists = true;
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                WebEle = HelpersMethod.FindByElement(driver, "id", "addFromDate");
                FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 10);
                scenario.log(FTDate + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
            }
            else
            {
                scenario.log("FAILED TO SELECT START DATE");
            }
        }
        //Click on ADD button
        WebEle=modalContainer.findElement(By.xpath(".//button[text()='Add']"));
        HelpersMethod.ActClick(driver,WebEle,20);
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
    }

    public void ClickOnNewStandingOrderArrow() throws InterruptedException
    {
        Thread.sleep(5000);
        exists = false;
        WebElement WebEle = null;
        WebElement WebEle1;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
        }
//        Thread.sleep(6000);

//        new WebDriverWait(driver, 200).until(ExpectedConditions.presenceOfElementLocated(By.id("card1")));
        //Click on arrow if Start standing order card is not visible
        if (HelpersMethod.IsExists("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]", driver))
        {
            WebEle1= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
            new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")));
            new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")));
            HelpersMethod.ScrollElement(driver, WebEle1);
            HelpersMethod.ActClick(driver, WebEle1, 60);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }
    }

    public void ClickOnStartStandingOrder1() throws InterruptedException
    {
        Thread.sleep(8000);
        exists = false;
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        if(HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-up')]",driver))
        {
            if (StartStandingOrder.isDisplayed() && StartStandingOrder.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, StartStandingOrder);
                HelpersMethod.JScriptClick(driver, StartStandingOrder, 100);
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                new WebDriverWait(driver, 600).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(text(),'Add standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 200);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
    }

    public void ClickOnAddProductButton()
    {
//        exists=false;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,40);
        //new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add product')]")));
        try
        {
//            if(AddProduct.isDisplayed() && AddProduct.isEnabled())
//            {
                //HelpersMethod.ScrollElement(driver,AddProduct);
                HelpersMethod.ActClick(driver,AddProduct,40);
//                Thread.sleep(2000);
        }
        catch (Exception e){}
    }

    public void ClickOnAddProductButton1()
    {
        exists=false;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,40);
        new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add product')]")));
        try
        {
            if(AddProduct.isDisplayed() && AddProduct.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,AddProduct);
                HelpersMethod.ActClick(driver,AddProduct,40);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


    public void CatalogOKButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Ok')]");
                HelpersMethod.ActClick(driver,WebEle,8);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


    public void ProductNo_InSearchBar() {
//        String str1 = "0";
//        String str2 = "0";
//        String str3 = "0";
//        String str4 = "0";
//        String str5 = "0";
//        String str6 = "0";
//        String str7 = "1";
//        String str8 = "1";
//        String Product = "00000011";
        String Product=null;
        Product=TestBase.testEnvironment.get_CatchWtProductNo();

        WebElement SearchIcon1;
        WebElement Account;
        exists = false;
        try {

            WebElement CatalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            WebElement SearchProduct = CatalogPopup.findElement(By.xpath("/html/body[@class='dialog']/div[2]/div[@role='dialog']//div[@role='combobox']/input"));
//            WebElement SearchProduct = CatalogPopup.findElement(By.xpath("//div[@role='dialog']//div[@class='core-grid-admin-top-wrapper']/div[@role='presentation']/div[@role='grid']/div[1]/div[@role='presentation']/table[@role='presentation']/thead[@role='presentation']/tr[2]/th[8]/div[@class='k-filtercell']/div[@class='k-filtercell-wrapper']/input"));

            HelpersMethod.ScrollElement(driver, SearchProd);
            HelpersMethod.sendKeys(driver, SearchProduct, 10, Product);
//            HelpersMethod.ClickBut(driver,IndexSearch,4);
//            exists = true;
//            scenario.log("SELECTED Product NUMBER IS " + Product);
//            Assert.assertEquals(exists, true);
//            HelpersMethod.sendKeys(driver, SearchProduct, 20, str1);
//            HelpersMethod.sendKeys(driver, SearchProduct, 20, str2);
//            HelpersMethod.sendKeys(driver, SearchProduct, 20, str3);
//            HelpersMethod.sendKeys(driver, SearchProduct, 20, str4);
//            HelpersMethod.sendKeys(driver, SearchProduct, 20, str5);
//            HelpersMethod.sendKeys(driver, SearchProduct, 20, str6);
//            HelpersMethod.sendKeys(driver, SearchProduct, 20, str7);
//            HelpersMethod.sendKeys(driver, SearchProduct, 20, str8);

            SearchIcon1 = driver.findElement(By.cssSelector(".input-group-addon.search-button.search-button-addon > .i-icon"));
//            SearchIcon1 = driver.findElement(By.cssSelector(".admin-badge-icon-container > div > div>div"));
            HelpersMethod.waitTillElementDisplayed(driver, SearchIcon1, 100);
            SearchIcon1.click();

        } catch (Exception e) {
        }
    }
    public void TieredPricing_ProductColor_Comparison(){
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ColourChange2();
        badgeBuilderPage.CompareProdColour();
        System.out.println(Tcolor+"TieredPricingColor from Clientside");
    }


    public void EnterAccountNo_Start() {
        String Account_No = "0040035975-000000-000295";
        WebElement SearchIcon1;
        WebElement Account;
        WebElement WebEle;
        exists = false;
        try {

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }

            WebElement SearchIcon2= driver.findElement(By.cssSelector(".HeaderDetails.row .i-button--icon-only.i-indexfield-container__main__button.k-button.k-button-icontext.k-outline > .i-icon"));
            HelpersMethod.waitTillElementDisplayed(driver, SearchIcon2, 100);
            SearchIcon2.click();
            //HelpersMethod.JScriptClick(driver, SearchIcon2, 20);
//            Thread.sleep(2000);

            WebElement AccountPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            WebElement SearchAccount = AccountPopup.findElement(By.xpath("/html/body[@class='dialog']/div[2]/div[@role='dialog']/div[2]//form/input"));
            //HelpersMethod.ScrollElement(driver, SearchProd);
            HelpersMethod.sendKeys(driver, SearchAccount, 10, Account_No);
            //HelpersMethod.ClickBut(driver,IndexSearch,4);
            exists = true;
            scenario.log("SELECTED ACCOUNT NUMBER IS " + Account_No);
            Assert.assertEquals(exists, true);

            SearchIcon1 = driver.findElement(By.cssSelector(".k-dialog-content.k-window-content form > .i-icon.i-search-box__search"));
            HelpersMethod.waitTillElementDisplayed(driver, SearchIcon1, 100);
            // Thread.sleep(5000);

            SearchIcon1.click();

            Account = driver.findElement(By.xpath("//div[@role='dialog']//div[@class='core-grid-admin-top-wrapper']/div[@role='presentation']/div[@role='grid']/div[3]/div[@role='presentation']//table[@role='presentation']//tr[@role='row']/td[3]"));
            HelpersMethod.waitTillElementDisplayed(driver, Account, 100);
            // Thread.sleep(5000);

            Account.click();
        } catch (Exception e) {
        }
    }


    public void Scroll_start() throws InterruptedException
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "id", "order-search-card", 20);
            HelpersMethod.ScrollElement(driver, driver.findElement(By.id("order-search-card")));
            HelpersMethod.waitClickableOfEle(driver, StartOrder, 40);
        }
        catch (Exception e) {scenario.log(e.getMessage());scenario.log(e.getMessage());}
    }

    public void NoPendingOrderPopup()
    {
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
                WebElement noPendingOrderPopup =HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");

               // WebElement noPendingOrderContent = noPendingOrderPopup.findElement(By.xpath(".//div[contains(@class,'k-window-content k-dialog-content')]"));
                //Assert.assertEquals(noPendingOrderContent.getText(), "You already have an open order that is pending submission. Would you like to switch to that Pending order or start a new order? If you start a new order, the Pending order will be overwritten.", "Verify Title message");

                WebElement startOrder=noPendingOrderPopup.findElement(By.xpath(".//button[contains(text(),'Start new order')]"));
                HelpersMethod.ClickBut(driver,startOrder,80);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
        }
        catch (Exception e) {}
    }
    public void OrderGuideTab() {

        {
            //if(flag1==false)

            WebElement WebEle;
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]");
            if (HelpersMethod.EleDisplay(WebEle)) {
                // exists = false;
                //orderGuidePage = new OrderGuidePage(driver, scenario);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Order Guides", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                //exists = orderGuidePage.ValidateOG();
                //currentURL=driver.getCurrentUrl();
                //Assert.assertEquals(exists, true);

            } else {
                scenario.log("ORDER GUIDE TAB DOESN'T EXISTS");
            }


        }
    }
    public void OpenOrderTab() throws InterruptedException {

        {
            //if(flag1==false)

            WebElement WebEle;
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Open orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                // exists = false;
                //orderGuidePage = new OrderGuidePage(driver, scenario);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Open orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Open orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }

            }
            else

            {
                scenario.log("'OPEN ORDER TAB DOESN'T EXISTS");
            }
            //flag1=true;


        }

    }

    public void ClickCalender() throws InterruptedException
    {
        exists = false;
        WebElement WebEle;
        String status=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        new WebDriverWait(driver, 250).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='CPDeliveryDates']/descendant::span[contains(@class,'k-icon k-i-calendar')]")));
        new WebDriverWait(driver, 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='CPDeliveryDates']/descendant::span[contains(@class,'k-icon k-i-calendar')]")));
        HelpersMethod.JScriptClick(driver, Calender, 150);
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]",200);
        new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]")));
        exists = true;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Assert.assertEquals(exists, true);
    }

    public void StartOrder2() throws InterruptedException {
        {
            exists = false;
            WebElement WebEle = null;
            String status = null;
            try
            {
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                if (HelpersMethod.IsExistsById("addButton", driver) && StartOrder.isEnabled())
                {
                    //HelpersMethod.ScrollElement(driver, SearchOrder);
                    //HelpersMethod.ClickBut(driver, StartOrder, 20);
                    HelpersMethod.JScriptClick(driver, StartOrder, 100);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    exists = true;
                }
                else
                {
                    //If start button is not enabled either skip is enabled or cutoff date has been reached
                    ClickCalender();
                    SelectDeliveryDate();
                   // SelectDate(ChangeDate,40);
                   // HelpersMethod.ScrollElement(driver, SearchOrder);
                    //HelpersMethod.ClickBut(driver, StartOrder, 40);
                    HelpersMethod.JScriptClick(driver, StartOrder, 100);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    exists = true;
                }
                Assert.assertEquals(exists,true);
            }
            catch (Exception e) {}
            //return exists;
        }


//        HelpersMethod.waitTillElementDisplayed(driver, StartOrder, 200);
//        //wait.until(ExpectedConditions.elementToBeClickable(StartOrder));
//
//        //Thread.sleep(10000);
//
//
//        HelpersMethod.JScriptClick(driver, StartOrder, 100);
    }

    public void ClickSignin1() throws InterruptedException
    {
        try
        {
            exists = false;
            WebElement WebEle;
            if (HelpersMethod.IsExists("//button[contains(@class,'k-button k-primary k-button-icontext') and contains(text(),'Sign In')]", driver))
            {
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.JScriptClick(driver, SignIn, 20);
                HelpersMethod.waitTillPageLoaded(driver, 2000);

                exists = true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("SIGNIN BUTTON CLICKED");
            }
        }
        catch (Exception e){}
    }
    public void ClickOnNewStandingOrderArrow1() throws InterruptedException
    {
        exists = false;
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
        }

        new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.id("card1")));
        //Click on arrow if Start standing order card is not visible
        if (HelpersMethod.IsExists("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]", driver))
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
            new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")));
            new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ActClick(driver, WebEle, 60);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }
    }


}












































