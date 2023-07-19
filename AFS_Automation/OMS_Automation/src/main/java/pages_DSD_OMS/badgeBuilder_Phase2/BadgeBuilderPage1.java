package pages_DSD_OMS.badgeBuilder_Phase2;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import helper.HelpersMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.badgeBuilder_Phase1.BadgeBuilderPage;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import util.TestBase;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

//import java.io.IOException;

public class BadgeBuilderPage1 {
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;
    static String currentURL = null;
    BadgeBuilderPage badgeBuilderPage1;
    private static String Tiered_CatchColorAdmin;
    private static String Tiered_CatchColorAdmin2;
    @FindBy(xpath = "//input[contains(@placeholder,'Search products')]")
    private WebElement SearchBar;

    @FindBy(xpath = "//span[contains(@class,'search-button-addon search-button input-group-addon')]/descendant::*[local-name()='svg']")
    private WebElement SearchIndex;

    @FindBy(xpath = "//button[contains(text(),'Add product')]")
    private WebElement AddProduct;
    @FindBy(id = "shoppingCartRedBadge")
    private WebElement Cart;
    @FindBy(xpath = "//button[contains(@class,'k-button k-primary k-button-icontext')]/descendant::span[contains(@class,'i-arrow')]")
    private WebElement DropDown;
    @FindBy(xpath = "//tr[1]/descendant::div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg']")
    private WebElement OrderIcon;
//  @FindBy(xpath = "//div[@id='gridOrderControlList']//div[@role='grid']/div[2]//table[@role='presentation']//tr[@role='row']/td[13]")
//    private WebElement OrderIcon;
    @FindBy(xpath = "//tr[1]/descendant::div[contains(@class,'product-image-container')]//*[local-name()='img']")
    private WebElement imageIcon;



    public BadgeBuilderPage1(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);

    }

    public void AddProduct_Catalog() {
        exists = false;
        WebElement WebEle;
        try {

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.waitTillElementDisplayed(driver, AddProduct, 100);

            HelpersMethod.ScrollElement(driver, AddProduct);
            HelpersMethod.ClickBut(driver, AddProduct, 60);
            scenario.log("ADD PRODUCT BUTTON HAS BEEN CLICKED");
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }


    public void AddFromDropdown() {
        WebElement WebEle = null;
        exists = false;
        try {
            //HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//html//div[@id='openOrdersCard']/div[@class='i-card__card__body i-card__card__body--expanded']//div[@class='core-grid-admin-top-wrapper']/div[1]/div/button[@type='button']", 80);
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::li", "xpath", "From Catalog");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ProductNo_InSearchBar_Catalog() {
        String Product = "00000011";
        WebElement SearchIcon1;
        WebElement Account;
        exists = false;
        try {

            WebElement CatalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            WebElement SearchProduct = CatalogPopup.findElement(By.xpath("/html/body[@class='dialog']/div[2]/div[@role='dialog']//div[@role='combobox']/input"));
            //HelpersMethod.ScrollElement(driver, SearchProd);
            HelpersMethod.sendKeys(driver, SearchProduct, 10, Product);
            //HelpersMethod.ClickBut(driver,IndexSearch,4);
            exists = true;
            scenario.log("SELECTED Product NUMBER IS " + Product);
            Assert.assertEquals(exists, true);

            SearchIcon1 = driver.findElement(By.cssSelector(".k-dialog-content.k-window-content .input-group-addon.search-button.search-button-addon > .i-icon"));
            HelpersMethod.waitTillElementDisplayed(driver, SearchIcon1, 100);

            SearchIcon1.click();

        } catch (Exception e) {
        }
    }

    public void CatalogTab1() throws InterruptedException {

        {
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver)) {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");


            } else {
                scenario.log("CATALOG TAB IS NOT VISIBLE");
            }
        }
    }

    public void SearchBoxActionCat1() {
        {
            exists = false;
            WebElement WebEle = null;
            WebElement WebEle1 = null;
            //new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
            //new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
            try {
//                WebElement ProductCard = HelpersMethod.FindByElement(driver, "id", "productsCard");
//                HelpersMethod.waitTillElementLocatedDisplayed(driver, "id", "ProductCard", 80);
                //HelpersMethod.ScrollElement(driver, ProductCard);
                //Clear Search bar
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='searchBarClearBtn']//*[local-name()='svg']");
                //HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//span[@id='searchBarClearBtn']//*[local-name()='svg']", 80);

                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 30);
//                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
//                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
//                }
                HelpersMethod.EnterText(driver, SearchBar, 40, "0803");
                HelpersMethod.ActClick(driver, SearchIndex, 20);
//                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
//                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
//                }
//                scenario.log("PRODUCT SECTLECTED");
//                exists = true;
//                Assert.assertEquals(exists, true);
//                Thread.sleep(5000);
//                WebEle1=HelpersMethod.FindByElement(driver,"xpath","/html//div[@id='productsCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div//div[@class='grid-item-box']//div[@class='product-catalog-image-container']/a[@href='#']/img[@alt='product thumb']");
//
//                HelpersMethod.ActClick(driver,WebEle1,30);
//
            } catch (Exception e) {
            }
        }

    }

    public void AddTocart() {
        WebElement WebEle;
        try {

//            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
//                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
//            }
            //Click on + Button
            Thread.sleep(5000);
            WebElement AddButton = driver.findElement(By.cssSelector(".i-button--icon-only.i-numeric-box-int__buttonPlus.k-button.k-button-icontext.k-primary"));
            HelpersMethod.ScrollElement(driver, AddButton);
            HelpersMethod.ClickBut(driver, AddButton, 80);
            // Thread.sleep(2000);
//            WebElement UpdateButton = driver.findElement(By.cssSelector(".k-button.k-button-icontext.update-cart-button > .i-icon.i-icon--primary"));
//            HelpersMethod.ClickBut(driver, UpdateButton, 80);
//            Thread.sleep(2000);

           // Click on Add to cart button
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[text()='Add to cart']");
            if (WebEle.isDisplayed() && WebEle.isEnabled()) {
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ClickBut(driver, WebEle, 20);

            }

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

    public void Cart_Button() {
        exists = false;
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            if (Cart.isDisplayed() && Cart.isEnabled()) {
                HelpersMethod.JScriptClick(driver, Cart, 30);
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']", 40);
                if (HelpersMethod.IsExists("//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']", driver)) {
                    exists = true;
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'cartItemsCard')]")));
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void NavigateToOrderEntry1() {
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
            HelpersMethod.JScriptClick(driver, OEMenu, 100);
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

    public void ChangeAccount1() throws InterruptedException {
        Thread.sleep(5000);


        exists = false;
        WebElement WebEle = null;
        String account = null;

        try {
            Robot robot = new Robot();
            account = "K13033";
            // Refresh_Page(currentURL);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Actions act = new Actions(driver);
            // act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys("").build().perform();
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys(account).build().perform();
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException | InterruptedException e) {
        }
    }

    public void ChangeAccount2() {
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
            Acc_No = "K13033";
            WebEle = HelpersMethod.FindByElement(driver, "id", "customerAccountNumberComboBox");
            act.moveToElement(WebEle).click().build().perform();
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

    public void Click_On_GoToCart() throws InterruptedException {
        try {
            exists = false;
            WebElement WebEle;
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/div[@class='popup-content']");
            WebElement GoToCart = dropDown.findElement(By.xpath("/html//button[@id='goToCartButton']"));
            //HelpersMethod.ActClick(driver, GoToCart, 400);
            HelpersMethod.JScriptClick(driver, GoToCart, 400);
//            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
//                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
//            }

//            HelpersMethod.waitTillTitleContains(driver, "Ignition - Login", 60);
//            String title = driver.getTitle();
//            if (title.equals("Ignition - Login")) {
//                exists = true;
//            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
        Thread.sleep(3000);
    }

    public void POBox() {

        String str = "11X";

        WebElement POTextBox;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//input[@id='poNumber']", driver)) {
                POTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='poNumber']");
                Thread.sleep(3000);
                //HelpersMethod.Implicitwait(driver,10);
                //HelpersMethod.JScriptClick(driver, TextBox, 20);
                HelpersMethod.clearText(driver, POTextBox, 20);
                HelpersMethod.sendKeys(driver, POTextBox, 20, str);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void AddProduct() {
        exists = false;
        WebElement WebEle = null;
        HelpersMethod.Implicitwait(driver, 60);
        new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add product')]")));
        try {
            if (AddProduct.isDisplayed() && AddProduct.isEnabled()) {
                HelpersMethod.ScrollElement(driver, AddProduct);
                HelpersMethod.ActClick(driver, AddProduct, 40);
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }

    }

    public void SelectCatalogFromDropdown() {
        WebElement WebEle = null;
        exists = false;
        try {
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::li", "xpath", "From Catalog");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void PopupProductEntry() {

        String str1 = "0";
        String str2 = "8";
        String str3 = "0";
        String str4 = "3";

        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);

            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                WebElement Popup1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                WebElement ProductBox = Popup1.findElement(By.xpath("//body/div[2]/div[@role='dialog']//div[@class='core-grid-admin-top-wrapper']/div[@role='presentation']/div[@role='grid']/div[1]/div[@role='presentation']/table[@role='presentation']/thead[@role='presentation']/tr[2]/th[3]/div[@class='k-filtercell']/div[@class='k-filtercell-wrapper']/input"));
                Thread.sleep(3000);
                HelpersMethod.sendKeys(driver, ProductBox, 20, str1);
                HelpersMethod.sendKeys(driver, ProductBox, 20, str2);
                HelpersMethod.sendKeys(driver, ProductBox, 20, str3);
                HelpersMethod.sendKeys(driver, ProductBox, 20, str4);

//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public String ColorCheckCatalogSearch() throws InterruptedException {
        String ClrCheck = null;
//        String CatchWtLabel=null;
        WebElement WebEle;
        badgeBuilderPage1 = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1.ColourChange2();
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Thread.sleep(2000);
            WebElement Clr = driver.findElement(By.cssSelector("div:nth-of-type(7) > .admin-badge-icon-container > div > div>div"));

            HelpersMethod.waitTillElementDisplayed(driver, Clr, 100);
            HelpersMethod.Implicitwait(driver, 20);
            Thread.sleep(5000);
            //  OrderGuideClrCheck = OrderGuideClr.getCssValue("background-color");
            ClrCheck = Clr.getCssValue("background-color");
            System.out.println(ClrCheck);
            System.out.println(Tiered_CatchColorAdmin2);

            if (Tiered_CatchColorAdmin2.equals(ClrCheck)) {
                System.out.println("PRODUCT COLORS ARE SAME");
            } else {
                System.out.println("PRODUCT COLORS ARE NOT SAME");
            }
            // Assert.assertEquals(Tiered_CatchColorAdmin,OrderGuideClrCheck,"COLORS ARE NOT SAME");
            WebElement Popup1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            WebElement OkBtn = Popup1.findElement(By.xpath("//body/div[2]/div[@role='dialog']/div[3]/div/button[.='Ok']"));
            OkBtn.click();
        } catch (Exception e) {
        }
        return ClrCheck;


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
                Tiered_CatchColorAdmin = WebEleColour.getCssValue("background-color");
                WebEleColour2 = driver.findElement(By.cssSelector(".icon-preview-tooltip-container > .icon-preview-background.icon-preview-background-white > .icon-preview-background"));
                Tiered_CatchColorAdmin2 = WebEleColour2.getCssValue("background-color");
                //String TieredPricingColorAdmin1=WebEleColour.getCssValue("color");
                System.out.println(Tiered_CatchColorAdmin + "Tiered/Catch Color from Admin");
                System.out.println(Tiered_CatchColorAdmin2 + "Tiered/Catch Color1 from Admin");
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

    public void Click_Back() {
        WebElement ClickBack;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//button[@id='backButton']", driver)) {

                ClickBack = HelpersMethod.FindByElement(driver, "xpath", "/html//button[@id='backButton']");
                //HelpersMethod.Implicitwait(driver,10);
                HelpersMethod.waitTillElementDisplayed(driver, ClickBack, 100);
                HelpersMethod.JScriptClick(driver, ClickBack, 20);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
        }


    }

    public void Click_DropDown() {
        exists = false;
        try {
            WebElement WebEle = driver.findElement(By.id("order-search-card"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ClickBut(driver, DropDown, 20);
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void Select_PickupOrder1() {
        WebElement WebEle = null;
        exists = false;
        try {
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::li", "xpath", "Pick up order");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void SelectDate1() {
        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
            WebElement Popup2 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            //WebElement PopOk = Popup1.findElement(By.xpath("//body/div[2]/div[@role='dialog']/div[2]/div/button[.='Ok']"));
            //PopOk.click();
            //HelpersMethod.JScriptClick(driver, PopOk, 20);
            //HelpersMethod.ActClick(driver, PopOk, 400);
            WebElement Date = Popup2.findElement(By.xpath("//div[@id='date-grid']/div[@role='presentation']/div[@role='grid']/div[2]/div[@role='presentation']/div[1]/table[@role='presentation']/tbody/tr[2]//span[@class='line2']"));
            HelpersMethod.ClickBut(driver, Date, 80);
        } catch (Exception e) {
        }
    }

    public void AddQuantity1() {

        String str = "1";
        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
            WebElement Popup1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement Quantity = Popup1.findElement(By.xpath("//body[@class='dialog']/div[2]/div[@role='dialog']//div[@class='core-grid-admin-top-wrapper']/div[@role='presentation']/div[@role='grid']/div[2]/div[@role='presentation']/div[1]/table[@role='presentation']/tbody[@role='presentation']/tr[@role='row']//input[@value='0']"));
            //HelpersMethod.ScrollElement(driver, Quantity);
            //HelpersMethod.ClickBut(driver, Quantity, 80);
            HelpersMethod.clearText(driver, Quantity, 20);
            HelpersMethod.sendKeys(driver, Quantity, 20, str);
            Thread.sleep(2000);
            WebElement okButton1 = Popup1.findElement(By.xpath(".//button[text()='Ok']"));
            HelpersMethod.ClickBut(driver, okButton1, 80);
        } catch (Exception e) {
        }


    }

    public void AddProductOE() throws AWTException {


        WebElement WebEle;
        Robot robot = new Robot();


        WebElement ProductTextBox;
        WebElement SequenceTextBox;
        String str = "0803";
        String str1 = "1";

        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
            HelpersMethod.Implicitwait(driver, 10);
            ProductTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='quickProduct']");
            HelpersMethod.waitTillElementDisplayed(driver, ProductTextBox, 100);
            HelpersMethod.sendKeys(driver, ProductTextBox, 20, str);
            SequenceTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='quickUnits']");
            HelpersMethod.sendKeys(driver, SequenceTextBox, 20, str1);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }


    }

    public void POBox1() {

        String str = "22X";

        WebElement POTextBox;
//        WebElement WebEle=null;
        try {
            if (HelpersMethod.IsExists("/html//input[@id='poNumber']", driver)) {
                POTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='poNumber']");
                Thread.sleep(3000);
                //HelpersMethod.Implicitwait(driver,10);
                //HelpersMethod.JScriptClick(driver, TextBox, 20);
                HelpersMethod.clearText(driver, POTextBox, 20);
                HelpersMethod.sendKeys(driver, POTextBox, 20, str);
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        } catch (Exception e) {
        }
    }

    public void SelectProduct1() throws InterruptedException {
        Thread.sleep(3000);
        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@id='ProductIdCol0']/a[@href='#']", 100);
            WebElement Product = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='ProductIdCol0']/a[@href='#']");

            HelpersMethod.ScrollElement(driver, Product);
            WebElement ClickProduct = Product.findElement(By.xpath("//div[@id='ProductIdCol0']/a[@href='#']"));
//            HelpersMethod.ClickBut(driver,ClickProduct,80);
            HelpersMethod.JScriptClick(driver, ClickProduct, 20);
        } catch (Exception e) {
        }


    }

    public String ColorCheck() throws InterruptedException {
        String IconClrCheck = null;
//        String CatchWtLabel=null;
        WebElement WebEle;
        badgeBuilderPage1 = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1.ColourChange2();
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Thread.sleep(2000);
            WebElement IconClr = driver.findElement(By.cssSelector("span:nth-of-type(2) > .admin-badge-text-container > .label-preview-background.label-preview-background-white > .label-preview-background > div > div"));

            HelpersMethod.waitTillElementDisplayed(driver, IconClr, 100);
            HelpersMethod.Implicitwait(driver, 20);
            Thread.sleep(5000);
            //  OrderGuideClrCheck = OrderGuideClr.getCssValue("background-color");
            IconClrCheck = IconClr.getCssValue("color");
            System.out.println(IconClrCheck);

            if (Tiered_CatchColorAdmin.equals(IconClrCheck)) {
                System.out.println("PRODUCT COLORS ARE SAME");
            } else {
                System.out.println("PRODUCT COLORS ARE NOT SAME");
            }
            // Assert.assertEquals(Tiered_CatchColorAdmin,OrderGuideClrCheck,"COLORS ARE NOT SAME");


        } catch (Exception e) {
        }
        return IconClrCheck;


    }


    public void SearchBoxActionCat_2() {
        {
            exists = false;
            WebElement WebEle = null;
            WebElement WebEle1 = null;
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
                HelpersMethod.EnterText(driver, SearchBar, 40, "0803");
                Thread.sleep(5000);
                HelpersMethod.ActClick(driver, SearchIndex, 20);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                scenario.log("PRODUCT SECTLECTED IS " + "0803");
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

    public void Click_On_UserIcon_Cart() throws InterruptedException {
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "/html//div[@id='shoppingCartRedBadge']", 2400);
            WebElement UserIcon = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='shoppingCartRedBadge']");
            new WebDriverWait(driver, 6000).until(ExpectedConditions.visibilityOf(UserIcon));
            HelpersMethod.JScriptClick(driver, UserIcon, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                new WebDriverWait(driver, 8000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
//            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@id,'cartItemsCard')]", 600);
//            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ClickCart() throws InterruptedException {

        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@class='shopping-cart-container notification-center-item']", 100);
            HelpersMethod.ActClick(driver,Cart,30);


            //WebElement Icon = driver.findElement(By.xpath("//div[@class='shopping-cart-container notification-center-item']"));
            //HelpersMethod.waitTillElementDisplayed(driver, Icon, 100);
            //Icon.click();
        }
        catch (Exception e){}
    }

//    public void ValidatePopup() {
//        WebElement Popup = driver.findElement(By.xpath("//div[@class='k-animation-container k-animation-container-relative popup-with-arrow standard-view shopping-cart-popup k-animation-container-shown']"));
//        if (Popup.isDisplayed()) {
//            System.out.println("Shopping cart Pop up Displayed");
//        } else
//            System.out.println("Not displayed");
//    }

    public void GoToCart() throws InterruptedException {

        try {

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//button[@id='goToCartButton']", 100);

            WebElement CartBtn = driver.findElement(By.xpath("//button[@id='goToCartButton']"));
            if (Cart.isDisplayed()) {
                System.out.println("Go to Cart Button displayed");
                CartBtn.click();
            } else
                System.out.println("Go to Cart Button not displayed");
        }catch (Exception e){}
    }

    public void AddTocart1() throws InterruptedException {
        WebElement WebEle;
        WebElement AddButton = driver.findElement(By.cssSelector(".i-button--icon-only.i-numeric-box-int__buttonPlus.k-button.k-button-icontext.k-primary"));
        HelpersMethod.ScrollElement(driver, AddButton);
        HelpersMethod.ClickBut(driver, AddButton, 80);
        WebElement UpdateButton = driver.findElement(By.cssSelector(".k-button.k-button-icontext.update-cart-button > .i-icon.i-icon--primary"));
        WebElement AddtoCart = driver.findElement(By.cssSelector(".k-button.k-button-icontext.k-primary > .cart-actions-button-label"));
        if (UpdateButton.isEnabled()) {
            HelpersMethod.ClickBut(driver, UpdateButton, 80);
            System.out.println("Update");
        } else if (AddtoCart.isEnabled()) {
            HelpersMethod.ClickBut(driver, AddtoCart, 80);
            System.out.println("Add to cart");
        }
    }

    public void Addcart2() throws InterruptedException {
        try {
            WebElement AddButton = driver.findElement(By.cssSelector(".i-button--icon-only.i-numeric-box-int__buttonPlus.k-button.k-button-icontext.k-primary"));
            HelpersMethod.ScrollElement(driver, AddButton);
            HelpersMethod.ClickBut(driver, AddButton, 80);
            WebElement ADD = driver.findElement(By.cssSelector(".k-button.k-button-icontext.k-primary > .cart-actions-button-label"));
            System.out.println("Add button clicked");
            ADD.click();
        } catch (Exception e) {
            WebElement Update = driver.findElement(By.cssSelector(".k-button.k-button-icontext.update-cart-button > .i-icon.i-icon--primary"));
            System.out.println("Update button clicked");
            Update.click();
        }
    }

    public void ClickonProduct_Cart() {
        //WebElement Product1=driver.findElement(By.cssSelector("img[alt='MS WHIP CRM QT (16/CS)']"));
        //WebElement Product2=driver.findElement(By.linkText("MS WHIP CRM QT (16/CS)"));
        try {


            WebElement Product = driver.findElement(By.xpath("//div[@id='cartItemsCard']//div[@class='cart-items-grid-container']/div[@role='presentation']/div[@role='grid']/div[2]/div[@role='presentation']//table[@role='presentation']//tr[@role='row']//div[@class='product-name']/a[@href='#']"));
            HelpersMethod.waitTillElementDisplayed(driver, Product, 100);
            if (Product.isDisplayed()) {
                System.out.println("displayed");
                HelpersMethod.JScriptClick(driver, Product, 30);

            }

        } catch (Exception e) {
        }
    }

    public void ClickImage() {
        try {
            //WebElement ProdLink= driver.findElement(By.linkText("MS WHIP CRM QT (16/CS)"));
            WebElement TABLE = driver.findElement(By.xpath("//table[@class='k-grid-table']"));
            WebElement Prodimg = TABLE.findElement(By.xpath("//img[@class='product-image-thumb']"));

            //WebElement Prodimg=HelpersMethod.FindByElement(driver,"xpath","//table[@class='k-grid-table']/tbody/tr[1]/td[2]//a[text()=\"MS WHIP CRM QT (16/CS)\"]");
            //WebElement ProdCSS=driver.findElement(By.cssSelector("img[alt='MS WHIP CRM QT (16/CS)']"));

            //HelpersMethod.ScrollElement(driver,Prodimg);
            if (Prodimg.isDisplayed()) {
                System.out.println("Link Displayed");
                HelpersMethod.JScriptClick(driver, Prodimg, 30);

            }
        } catch (Exception e) {
        }
    }

    public void NavigateToOCL() {
        WebElement WebEle = null;
        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]");
        if (HelpersMethod.EleDisplay(WebEle)) {
            HelpersMethod.navigate_Horizantal_Tab(driver, "Order control list", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }

//            } else {
//                scenario.log("ORDER Control List TAB DOESN'T EXISTS");
//            }
        }
    }

    public void ClickonNew() {
        {
            exists = false;
            WebElement WebEle = null;
            try {
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                HelpersMethod.waitTillElementDisplayed(driver, OrderIcon, 100);
                HelpersMethod.ActClick(driver, OrderIcon, 80);
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
                }
                Assert.assertEquals(exists, true);
            } catch (Exception e) {
            }
        }
    }

    public void imageIcon1() {
        {
            exists = false;
            WebElement WebEle = null;
            WebDriverWait wait1=new WebDriverWait(driver,40);
            try {
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                //WebElement Table = HelpersMethod.FindByElement(driver,"xpath", "//table[@class='k-grid-table']");

                WebElement imageIcon1=HelpersMethod.FindByElement(driver,"xpath", "//tr[1]/descendant::img[contains(@class,'product-image-thumb')]");

                wait1.until(ExpectedConditions.elementToBeClickable(imageIcon1));
                HelpersMethod.ClickBut(driver,imageIcon1,40);
//                WebElement imageIcon1=Table.findElement(By.xpath("//tr[1]/descendant::div[contains(@class,'product-image-container')]//*[local-name()='img']"));
//               imageIcon1.click();
                //HelpersMethod.ActClick(driver, imageIcon1, 80);
//                exists = true;
//                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
//                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
//                }
//                Assert.assertEquals(exists, true);
            } catch (Exception e) {
            }
        }
    }
    public void imageIcon2() throws InterruptedException {
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingPage(driver);
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            Thread.sleep(5000);
            WebElement element = driver.findElement(By.xpath("//tr[1]/descendant::img[contains(@class,'product-image-thumb')]"));
            //WebElement element = driver.findElement(By.xpath("//div[@id='cartItemsCard']//div[@class='cart-items-grid-container']/div[@role='presentation']/div[@role='grid']/div[2]/div[@role='presentation']//table[@role='presentation']//tr[@role='row']//div[@class='product-name']/a[@href='#']"));

            //HelpersMethod.waitTillElementDisplayed(driver, element, 100);
            Actions act = new Actions(driver);
            act.click(element).build().perform();
        }
        catch (Exception e){}
    }

    public void OrderControlAccountEntry() throws InterruptedException {

        String str1 = "K";
        String str2 = "1";
        String str3 = "3";
        String str4 = "0";
        String str5 = "3";
        String str6 = "3";
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        try {
                HelpersMethod.waitTillLoadingPage(driver);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
//            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@id='gridOrderControlList']//div[@role='grid']/div[1]/div[@role='presentation']/table[@role='presentation']/thead/tr[2]/th[3]/div/div[@class='k-filtercell']/div[@class='k-filtercell-wrapper']/input", 100);

//            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
//                WebElement Popup1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement AccountBox =driver.findElement(By.xpath("//div[@id='gridOrderControlList']//div[@role='grid']/div[1]/div[@role='presentation']/table[@role='presentation']/thead/tr[2]/th[3]/div/div[@class='k-filtercell']/div[@class='k-filtercell-wrapper']/input"));
                AccountBox.click();
//                Thread.sleep(10000);
                HelpersMethod.sendKeys(driver, AccountBox, 20, str1);
                HelpersMethod.sendKeys(driver, AccountBox, 20, str2);
                HelpersMethod.sendKeys(driver, AccountBox, 20, str3);
                HelpersMethod.sendKeys(driver, AccountBox, 20, str4);
                HelpersMethod.sendKeys(driver, AccountBox, 20, str5);
                HelpersMethod.sendKeys(driver, AccountBox, 20, str6);

//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        catch(Exception e) {
        }
    }
    public void StartOrder_OpenOrder1() throws AWTException, InterruptedException {
        Thread.sleep(5000);


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
            String str = "0803";
            String str1 = "1";

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
                HelpersMethod.Implicitwait(driver, 10);
                ProductTextBox = HelpersMethod.FindByElement(driver, "xpath", "/html//input[@id='quickProduct']");
                //Thread.sleep(3000);
                HelpersMethod.waitTillElementDisplayed(driver, ProductTextBox, 100);
                //Thread.sleep(2000);
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

    public void Cart_Button1()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            if(Cart.isDisplayed() && Cart.isEnabled())
            {
                HelpersMethod.ActClick(driver,Cart,30);
                HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",40);
                if(HelpersMethod.IsExists("//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",driver))
                {
                    exists=true;
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                new WebDriverWait(driver,1000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'cartItemsCard')]")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


}















