package pages_DSD_OMS.themeBuilderPage;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ThemeBuilderPage {
    WebDriver driver;
    Scenario scenario;
    @FindBy(xpath = "//div[@class='theme-section-container']//*[text()='Default theme']")
    private WebElement firstradiobutton;
    @FindBy(xpath = "/html//div[@id='themeSelectionCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='theme-section-container']/div[10]/div[5]/div[@class='i-btn-radio__description']/div[.='ERP cyan']")
    private WebElement lastradiobutton;
    @FindBy(xpath = "//input[@id='general_7']")
    private WebElement selectTheme;
    @FindBy(xpath = "//input[@id='MY_OWN_THEME']")
    private WebElement customTheme;
    @FindBy(xpath = "//div[@class='preview1-container']")
    private WebElement firstPreviewPart;
    //WebElement firstPreviewPart= driver.findElement(By.xpath("//div[@class='preview1-container']"));
    @FindBy(xpath = "//div[@class='preview2-container']")
    private WebElement secondPreviewPart;
    //WebElement secondPreviewPart=driver.findElement(By.xpath("//div[@class='preview2-container']"));
    @FindBy(xpath = "//input[@id='#ffffff']")
    private WebElement lightHeaderTextRadioBtn;
    @FindBy(xpath = "//input[@id='#000000']")
    private WebElement darkHeaderTextRadioBtn;

    /* @FindBy(xpath = "//input[@id='file']")
     private WebElement fileInput;
     @FindBy(xpath = "//button[@class='k-button k-primary']")
     private  WebElement choosePhotoBtn;*/
    @FindBy(xpath = "//button[@id='save-btn']")
    private WebElement saveBtn;
    @FindBy(xpath = "//button[@id='cancel-btn']")
    private WebElement cancelBtn;
    @FindBy(xpath = "//button[@id='QuestionModalButton1']")
    private WebElement popUpYes;
    @FindBy(xpath = "//button[@id='QuestionModalButton0']")
    private WebElement popUpOk;
    @FindBy(xpath = "/html//div[@id='colorSelectionCard']/div/div[2]/div[4]/div[@class='color-circle']")
    private WebElement selectPriColour;
    @FindBy(xpath = "/html//div[@id='colorSelectionCard']/div/div[4]/div[2]/div[@class='color-circle']")
    private WebElement selectSecColour;

    /* @FindBy(xpath = "//div[@class='k-button k-upload-button']")
     private WebElement selectLogo;*/
    @FindBy(xpath = "//input[@id='general_6']")
    private WebElement selectNewThemeToCancel;
    @FindBy(xpath = "/html//div[@id='colorSelectionCard']/div/div[2]/div[5]/div[@class='color-circle']")
    private WebElement selectNewPriColourToCancel;

    @FindBy(xpath = "/html//div[@id='colorSelectionCard']/div/div[4]/div[4]/div[@class='color-circle']")
    private WebElement selectNewSecColourToCancel;
    @FindBy(xpath = "//input[@id='general_5']")
    private WebElement selectNewThToSave;

    @FindBy(xpath = "/html//div[@id='colorSelectionCard']/div/div[2]/div[5]/div[@class='color-circle']")
    private WebElement selectNewPriColorToSave;

    @FindBy(xpath = "/html//div[@id='colorSelectionCard']/div/div[4]/div[4]/div[@class='color-circle']")
    private WebElement selectNewSecColorToSave;

    @FindBy(xpath = "//div[@class='user-info-initial-container']")
    private WebElement logOutDropDown;

    //@FindBy(xpath = ".//div[contains(@class,'user-info-line user-info-line-signout')]")
    @FindBy(xpath = "//div[@class='user-info-link signout']")
    private WebElement signOutBtn;

    @FindBy(xpath = "//label[text()='Login']/following-sibling::input")
    private WebElement Username;

    @FindBy(xpath = "//label[text()='Password']/following-sibling::input")
    private WebElement Password;

    // @FindBy(xpath = "//button[contains(@class,'k-button k-primary k-button-icontext') and contains(text(),'Sign in')]")
    @FindBy(xpath = "//button[@id='signInBtn']")
    private WebElement SignIn;
    static boolean exists=false;

    public ThemeBuilderPage(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }
    @BeforeMethod
    public void WaitForPage() {
        ////HelpersMethod.Implicitwait(driver, 5);
    }

    public void ClickOnGSHumburger() {
        /*WebElement Humburger=driver.findElement(By.xpath("//span[contains(@class, 'menu-item-text')][contains(text(), 'General Settings')]"));
        Humburger.click();
        System.out.println("method1");*/
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "//span[contains(@class, 'menu-item-text')][contains(text(), 'General Settings')]", 2400);
            WebElement Hamburger = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class, 'menu-item-text')][contains(text(), 'General Settings')]");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(Hamburger));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(Hamburger));
            HelpersMethod.JScriptClick(driver, Hamburger, 4000);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //HelpersMethod.JScriptClick(driver, Hamburger, 4000);
            //Hamburger.click();
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void ClickOnThemeBuilder() {
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class, 'submenu-item-text')][contains(text(), 'Branding')]", 2400);
            WebElement ThemeBuilderOption = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class, 'submenu-item-text')][contains(text(), 'Branding')]");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(ThemeBuilderOption));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(ThemeBuilderOption));
            HelpersMethod.JScriptClick(driver, ThemeBuilderOption, 4000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}

    }

    public void verifyThemeBuilderPage() {
        //List <WebElement> countRadios = driver.findElements(By.xpath("//input[@type='radio']"));//28
        List<WebElement> countRadios = driver.findElements(By.xpath("//div[@class='theme-section-container']//input[@type='radio']")); //25 radio buttons
        System.out.println("The count of radio buttons available on the page for section 1 is:" + countRadios.size());
    }

    public void verifyAllThemeImage() {
        HelpersMethod.ScrollElement(driver, lastradiobutton);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        System.out.println("page loading");
        HelpersMethod.ScrollElement(driver, firstradiobutton);
    }

    public void selectImageforTheme() {
        //selectTheme.click();
        HelpersMethod.JScriptClick(driver, selectTheme, 10);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
    }
    public void validatePreview() throws InterruptedException {
        // Wait for the preview to load
        HelpersMethod.waitTillPageLoaded(driver, 5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        HelpersMethod.ScrollElement(driver, secondPreviewPart);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        System.out.println("page going scroll");
        HelpersMethod.ScrollElement(driver, firstPreviewPart);

        WebElement preview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='previewCardThemeBuilder']")));
        if (preview.isDisplayed()) {
            System.out.println("Preview of theme selection validate successfully");
        } else{
            System.out.println("Preview not proper");
        }
    }

    public void cancelChanges() {
        cancelBtn.click();
        popUpYes.click();//to discard the changes
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
    }

    public void saveChanges() {
        HelpersMethod.JScriptClick(driver, saveBtn, 30);
        //saveBtn.click();
        String status1 = HelpersMethod.returnDocumentStatus(driver);
        if (status1.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.JScriptClick(driver, popUpOk, 30);
        //popUpOk.click();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
    }
    public void chooseCustomThemeLight() throws AWTException {
        //customTheme.isSelected();
        //customTheme.click();
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
                new WebDriverWait(driver, Duration.ofMillis(8000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//input[@id='MY_OWN_THEME']", 2400);
            WebElement customTheme = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='MY_OWN_THEME']");
            new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.visibilityOf(customTheme));
            HelpersMethod.JScriptClick(driver, customTheme, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //HelpersMethod.JScriptClick(driver, customTheme, 10);
        // Verify the background color of the master page in preview part
        WebElement previewPart = driver.findElement(By.xpath("//div[@class='preview1-container']"));
        String backgroundColor = previewPart.getCssValue("background-color");
        System.out.println("background color is:" +backgroundColor);  //#bababa
        if (backgroundColor.equals("rgba(0, 0, 0, 0)")) {
            System.out.println("Preview part background color changed to white.");
        } else {
            System.out.println("Preview part background color did not change to white.");
        }
        //HelpersMethod.JScriptClick(driver, lightHeaderTextRadioBtn, 10);
        if(lightHeaderTextRadioBtn.isSelected()) {
            //HelpersMethod.JScriptClick(driver, lightHeaderTextRadioBtn, 10);
            //lightHeaderTextRadioBtn.click();
            //System.out.println("no need to click on light header text already selected");
            WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
            fileInput.sendKeys("C:/Users/shital.suryawanshi/Desktop/Food Images/spices-370114__340.jpg");
        } else System.out.println("Light header text not selected defaulted");
    }
    public void chooseCustomThemeDark() throws AWTException {
        //customTheme.click();//html//div[@id='themeSelectionCard']//div[@class='luminosity-radio-button-container']/div[2]
        //darkHeaderTextRadioBtn.click();
        HelpersMethod.JScriptClick(driver, customTheme, 10);
        HelpersMethod.JScriptClick(driver, darkHeaderTextRadioBtn, 10);
        if (darkHeaderTextRadioBtn.isSelected()) {
            System.out.println("Radio button opera is selected. Return: " + darkHeaderTextRadioBtn.isSelected());
        } else {
            System.out.println("Radio button opera is not selected. Return: " + darkHeaderTextRadioBtn.isSelected());
        }
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:/Users/shital.suryawanshi/Desktop/Food Images/images (1).jpg");
        //System.out.println("dark header text method part 3");
    }

    public void selectPrimaryColour() {
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "/html//div[@id='colorSelectionCard']/div/div[2]/div[4]/div[@class='color-circle']", 2400);
            WebElement selectPriColour1 = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='colorSelectionCard']/div/div[2]/div[4]/div[@class='color-circle']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(selectPriColour1));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(selectPriColour1));
            HelpersMethod.JScriptClick(driver, selectPriColour1, 2000);

            if(selectPriColour1.isSelected()){
                System.out.println("Dark blue selected so select faint color !!!");
                /*WebElement selectPriColour2 = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='colorSelectionCard']/div/div[2]/div[1]/div[@class='color-circle']");
                HelpersMethod.JScriptClick(driver, selectPriColour2, 2000);
                System.out.println("primary color is faint blue selected");*/

            }else { System.out.println("faint blue selected so select dark color !!!");
                //HelpersMethod.JScriptClick(driver, selectPriColour1, 2000);
                //System.out.println("primary color is dark blue selected");
            }

            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}

        System.out.println("primary color is selected");
    }
    public void verifyPriColorPreview(){
        WebElement previewPriColor = driver.findElement(By.xpath("//div[@class='drawer-menu-application-container']"));
        String backgroundColor = previewPriColor.getCssValue("background-color");
        System.out.println("background color of settings tab is:" +backgroundColor);  //#bababa   //rgba(63, 81, 181, 1)
        if (backgroundColor.equals("rgba(63, 81, 181, 1)")) {
            System.out.println("Preview part background color changed to primary color blue.");
        } else if (backgroundColor.equals("rgba(244, 67, 54, 1)")){
            System.out.println("Preview part background color did not change to primary color red.");
        }

    }

    public void selectSecondaryColour() {
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "/html//div[@id='colorSelectionCard']/div/div[4]/div[2]/div[@class='color-circle']", 2400);
            WebElement selectSecColour = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@id='colorSelectionCard']/div/div[4]/div[2]/div[@class='color-circle']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(selectSecColour));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(selectSecColour));
            HelpersMethod.ActClick(driver, selectSecColour, 2000);
            Assert.assertEquals(true, selectSecColour.isDisplayed(), " Secondary colour not selected correctly");

            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        /*HelpersMethod.JScriptClick(driver, selectSecColour, 20);
        //selectSecColour.click();
        Assert.assertEquals(true, selectSecColour.isDisplayed(), " Secondary colour not selected correctly");
        System.out.println("selected is secondary color is magneta");*/

    }

    public void verifySecColorPreview(){

        WebElement priColorChang=driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[2]/div[9]/div[@class='color-circle']"));
        priColorChang.click();
        WebElement previewPriColor = driver.findElement(By.xpath("//button[@id='save-btn']"));
        String backgroundColor=previewPriColor.getCssValue("background-color");
        System.out.println("background color of save button is:" +backgroundColor);
        if (backgroundColor.equals("rgba(137, 21, 69, 0.216)")) {
            System.out.println("Preview part background color changed to Secondary color.");
        } else {
            System.out.println("Preview part background color did not change to Secondary color.");
        }

        //Secondary  color already checked
        System.out.println("under this method");
        //WebElement secColorSelected=driver.findElement(By.cssSelector("div:nth-of-type(2) > .color-circle > .i-icon"));
        WebElement secColorSelected=driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[4]/div[2]/div[@class='color-circle']"));
        if(secColorSelected.isSelected()){
            System.out.println("secondary color is selected already");
        }
        else {
            System.out.println(" wrong color selected");
        }
    }

    public void resetDeThSettings() {
        WebElement resetDTS = driver.findElement(By.xpath("//button[@class='k-button k-primary reset-color-button']"));
        //resetDTS.click();
        HelpersMethod.JScriptClick(driver, resetDTS, 20);

        WebElement resetPriColor = driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[2]/div[10]/div[@class='color-circle']"));
        WebElement resetSecColor = driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[4]/div[9]/div[@class='color-circle']"));
        //if (resetPriColor.isDisplayed() && resetSecColor.isDisplayed()) {
        if (resetPriColor.isSelected() && resetSecColor.isSelected()) {
            System.out.println("colors are selected as per theme");
        } else {
            System.out.println("Colors not selected as per theme");
        }
    }

    public void validateDefaultSettings() {
        WebElement checkResetPriColor=driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[2]/div[4]/div[@class='color-circle']"));
        WebElement checkResetSecColor=driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[4]/div[2]/div[@class='color-circle']"));
        if (checkResetPriColor.isSelected() && checkResetSecColor.isSelected()) {
            System.out.println("colors are selected back to original color");
        } else {
            System.out.println("Colors are not selected back to original");
        }
    }

    public void selectCompanyLogo() {
        /*if(selectLogo.isEnabled()){
            System.out.println("logo selection enabled");
        }*/
        //selectLogo.click();
        WebElement selectLogo = driver.findElement(By.xpath("//input[@name='files']"));
        selectLogo.sendKeys("C:/Users/shital.suryawanshi/Desktop/Food Images/logo.jpg");
        System.out.println("company logo selection");
    }

    public void verifyCompanyLogo() {
       //html//div[@id='previewCardThemeBuilder']//img[@class='preview-logo-img']
        //73.662*43.075   //.preview-logo-img
        WebElement logoPreviewCenter=driver.findElement(By.xpath("//*[@id='previewCardThemeBuilder']/div[2]/div[2]/div[2]/img"));
        String textAlign = logoPreviewCenter.getCssValue("text-align");
        //System.out.println("textalign" +textAlign);
        String display = logoPreviewCenter.getCssValue("display");
        //System.out.println("display" +display);
        if (textAlign.equals("start") && display.equals("block")) {
            System.out.println("Logo is centered on the page.");
        } else {
            System.out.println("Logo is not centered on the page.");
        }
    }

    public void makeChangesToCancel() throws InterruptedException {
        //WebElement selectNewTheme=driver.findElement(By.xpath("/html//div[@id='themeSelectionCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='theme-section-container']/div[4]/div[3]/input"));
        //HelpersMethod.ActClick(driver, selectNewTheme, 20);
        /*WebElement element = driver.findElement(By.xpath("/html//div[@id='themeSelectionCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='theme-section-container']/div[4]/div[3]/input"));
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();*/
        selectNewThemeToCancel.click();
        selectNewPriColourToCancel.click();
        String verifyPriNewColor=selectNewPriColourToCancel.getCssValue("background-color");
        System.out.println("primary new color is" +verifyPriNewColor);
        selectNewSecColourToCancel.click();
        //WebElement selectNewPriColour = driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[2]/div[5]/div[@class='color-circle']"));
        //WebElement selectNewSecColour = driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[4]/div[4]/div[@class='color-circle']"));

    }

    public void verifyCancelAllChanges() {
        WebElement backToDefaultTheme = driver.findElement(By.xpath("//input[@id='oms_1']"));
        if (backToDefaultTheme.isSelected()) {
            System.out.println("Changes cancelled and page as before");
        } else System.out.println("Changes cancelled but page not as before");
    }

    public void permissionByDD() {
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
                new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@class='i-header-toolbar-expandable-button']", 4400);
            WebElement permissionDD = HelpersMethod.FindByElement(driver, "xpath", "//button[@class='i-header-toolbar-expandable-button']");
            new WebDriverWait(driver, Duration.ofMillis(8000)).until(ExpectedConditions.visibilityOf(permissionDD));
            HelpersMethod.JScriptClick(driver, permissionDD, 4000);
            
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        } catch (Exception e){}

    }

    public void selectOtherDD() {
        //select other than company value from permission by drop down
        try {
            Actions act = new Actions(driver);
            HelpersMethod.WaitElementPresent(driver, "xpath", "/html/body/div[@class='k-animation-container k-animation-container-relative k-animation-container-shown']/div/div/div/div[1]/span[@class='dropdown-left']/span[2]/span/span[@role='listbox']/span[@class='k-input']", 2400);
            WebElement selectOtherThanComp = HelpersMethod.FindByElement(driver, "xpath", "/html/body/div[@class='k-animation-container k-animation-container-relative k-animation-container-shown']/div/div/div/div[1]/span[@class='dropdown-left']/span[2]/span/span[@role='listbox']/span[@class='k-input']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(selectOtherThanComp));
            act.moveToElement(selectOtherThanComp).click().sendKeys("Chain").build().perform();
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            //WebElement selectOtherThanComp=driver.findElement(By.xpath("/html/body/div[@class='k-animation-container k-animation-container-relative k-animation-container-shown']/div/div/div/div[1]/span[@class='dropdown-left']/span[2]/span/span[@role='listbox']/span[@class='k-input']"));
            //selectOtherThanComp.click();
            System.out.println("selected value from drop down other than company");
        /*WebElement generalSettings = driver.findElement(By.xpath("//span[@class='menu-item-text' and text()='General Settings']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(generalSettings)).click();*/
            WebElement generalSettings = driver.findElement(By.xpath("//span[@class='menu-item-text' and text()='General Settings']"));
            generalSettings.click();
            //JavascriptExecutor executor = (JavascriptExecutor) driver;
            //executor.executeScript("arguments[0].click();", generalSettings);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.waitTillPageLoaded(driver, 5000);
            if (generalSettings.isDisplayed()) {
                System.out.println("general settings available but theme builder not");
            } else {
                System.out.println("General setting not clickable");
            }
        }catch (Exception e){}
    }
    public void verifyThemeBuilderDisappear(){
        //Check Theme Builder option available or not in general settings
        WebElement themeBuilderOption=driver.findElement(By.xpath("//div[contains(@class, 'submenu-item-text')][contains(text(), 'Branding')]"));
        //themeBuilderOption.click();
        if(themeBuilderOption.isDisplayed()){
            System.out.println("Theme Builder still displaying");
            /*JavascriptExecutor executor1 = (JavascriptExecutor) driver;
            executor1.executeScript("arguments[0].click();", themeBuilderOption);*/
        }else {
            System.out.println("Theme builder option not available on the page");
        }
    }
    public void makeChangesToSave() throws InterruptedException {
        /*//WebElement selectNewThToSave=driver.findElement(By.xpath("//input[@id='general_5']"));
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click();", selectNewThToSave);
        //Thread.sleep(15000);
        HelpersMethod.waitTillPageLoaded(driver, 5000);
        //selectNewThToSave.click();
        HelpersMethod.JScriptClick(driver, selectNewThToSave, 2000);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        String checkNewThStyle=selectNewThToSave.getAttribute("style");
        System.out.println("style of new theme style is:" +checkNewThStyle);
            //Thread.sleep(15000);
        HelpersMethod.waitTillPageLoaded(driver, 5000);

        System.out.println("Theme selected");
        //WebElement selectNewPriColorToSave=driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[2]/div[5]/div[@class='color-circle']"));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", selectNewPriColorToSave);
        //Thread.sleep(15000);
        HelpersMethod.waitTillPageLoaded(driver, 5000);
        //selectNewPriColorToSave.click();
        System.out.println("Primary color selected");
        // WebElement selectNewSecColorToSave=driver.findElement(By.xpath("/html//div[@id='colorSelectionCard']/div/div[4]/div[4]/div[@class='color-circle']"));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", selectNewSecColorToSave);
        HelpersMethod.waitTillPageLoaded(driver, 5000);
        //Thread.sleep(15000);
        //selectNewSecColorToSave.click();
        System.out.println("Secondary color selected");*/
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "//input[@id='general_5']", 2400);
            WebElement NewtTheme1 = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='general_5']");
            new WebDriverWait(driver,  Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(NewtTheme1));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(NewtTheme1));

            if(NewtTheme1.isSelected()){
                System.out.println("new theme1 not selected so select new theme2 !!!");
                WebElement NewTheme2 = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='general_3']");
                HelpersMethod.ActClick(driver, NewTheme2, 2000);

            }else {
                System.out.println("new theme1 selected !!!");
                HelpersMethod.ActClick(driver, NewtTheme1, 2000);
            }

            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}

    }
    public void verifySaveAllChanges() throws InterruptedException {
        //HelpersMethod.Refresh(driver);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        System.out.println("Changes save successfully");
        HelpersMethod.waitTillPageLoaded(driver, 5000);
        //Thread.sleep(15000);
        WebElement newSelectedTheme=driver.findElement(By.xpath("//input[@id='general_5']"));
        if (newSelectedTheme.isSelected()) {
            System.out.println("New Theme selected successfully");
        } else {
            System.out.println("New Theme not selected properly");
        }
    }
    public void clickToLogOut() throws InterruptedException {
        //div[@class='user-info-link signout']
        /*WebElement dropDown=HelpersMethod.FindByElement(driver, "xpath","//div[@class='user-info-initial-container']");
        WebElement signOut = dropDown.findElement(By.xpath(".//div[contains(@class,'user-info-line user-info-line-signout')]"));
        HelpersMethod.ActClick(driver, signOut, 400);*/
        //WebElement dropDown=driver.findElement(By.xpath("//div[@class='user-info-initial-container']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", logOutDropDown);
        //logOutDropDown.click();
        //WebElement signOut = driver.findElement(By.xpath(".//div[contains(@class,'user-info-line user-info-line-signout')]"));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", signOutBtn);
        //signOutBtn.click();
        System.out.println("click to sign out button");
    }

    public void verifyLoginPgWithNewTheme() {
        //WebElement loginPageTheme=driver.findElement(By.xpath("background-image: url(\"../../Images/Branding/themes/general_5.jpg\")"));
        WebElement loginPageTheme=driver.findElement(By.xpath("//div[@id='app']"));
        String backgroundTheme = loginPageTheme.getAttribute("style");
        System.out.println("background style is :" + backgroundTheme);
        //property_name
        if (backgroundTheme.contains("--page-height: 796px")) {
            System.out.println("Background image validation passed!");
        } else {
            System.out.println("Background image validation failed!");
        }
    }
    public void validateColorComp(){
        WebElement previewPriColorWithNewTh = driver.findElement(By.xpath("//div[@class='drawer-menu-application-container']"));
        String backgroundColor = previewPriColorWithNewTh.getCssValue("background-color");
        System.out.println("background color of settings tab is:" +backgroundColor);  //#bababa   //rgba(63, 81, 181, 1) //33, 150, 243, 1
        if (backgroundColor.equals("rgba(81, 167, 255, 1)")) {
            System.out.println("Preview part background color changed to primary color.");
        } else {
            System.out.println("Preview part background color did not change to primary color.");
        }
    }
    public void verifyNewThemeAfterLogin() throws InterruptedException {
        //Thread.sleep(15000);
        HelpersMethod.waitTillPageLoaded(driver, 5000);
        WebElement selectedTheme=driver.findElement(By.xpath("/html//div[@id='themeSelectionCard']/div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='theme-section-container']/div[4]/div[3]/div[@class='i-btn-radio__description']/div[.='Flow']"));
        /*if(selectedTheme.isSelected()){
            System.out.println("selected theme is correct");
        }else {
            System.out.println("Theme wrong selected");
        }*/
        String checkSelectedThemeStyle=selectedTheme.getAttribute("style");
        System.out.println("Selected theme style is:" +checkSelectedThemeStyle);

        WebElement masterPageTheme=driver.findElement(By.xpath("//*[@id='previewCardThemeBuilder']/div[2]/div[1]"));
        String checkMasterPageThemeStyle=masterPageTheme.getAttribute("style");
        System.out.println("Master page theme style is:" +checkMasterPageThemeStyle);
            if (checkSelectedThemeStyle.equals(checkMasterPageThemeStyle)) {
                System.out.println("Selected theme amd preview theme are same");
            } else {
                System.out.println("Selected Theme and preview the are different.");
            }
    }
    public void verifyEveryModuleMasterPage() throws InterruptedException {
        WebElement clickOnSettings=driver.findElement(By.xpath("//div[@class='settings-container admin-mode']"));
        clickOnSettings.click();
        System.out.println("page is moving to order entry tab");
        //Thread.sleep(15000);
        //div[@class='settings-container admin-mode']
       /* HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@id='menuWrapper__AccessCPWebOrder']/li[@role='menuitem']", 2400);
        WebElement clickOnOrderEntry = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='menuWrapper__AccessCPWebOrder']/li[@role='menuitem']");
        //new WebDriverWait(driver, 4000).until(ExpectedConditions.visibilityOf(clickOnOrderEntry));
        //new WebDriverWait(driver, 4000).until(ExpectedConditions.elementToBeClickable(clickOnOrderEntry));
        HelpersMethod.ActClick(driver, clickOnOrderEntry, 2000);
        if(clickOnOrderEntry.isDisplayed()){
            System.out.println("order entry selected");
        }else {
            System.out.println("not selected");
        }*/
        /*try {
            WebElement clickOnOrderEntry=driver.findElement(By.xpath("//div[@id='menuWrapper__AccessCPWebOrder']/li[@role='menuitem']"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", clickOnOrderEntry);
            //clickOnOrderEntry.click();
            if(clickOnOrderEntry.isDisplayed()){
                System.out.println("order entry selected");
            }else {
                System.out.println("not selected");
            }
        } catch (StaleElementReferenceException e){
            e.printStackTrace();
        }*/
        /*WebElement topViewOfMasterPage=driver.findElement(By.xpath("//*[@id='app']/div/div/main/div/div[1]"));
        String checkTopViewOfMasterPageStyle=topViewOfMasterPage.getAttribute("style");
        System.out.println("Top view master page theme style is:"+checkTopViewOfMasterPageStyle);*/
        System.out.println("no any unique value available to validate every module master page theme is selected one");
    }
    public void clickOnOrderEntry(){
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "//span[@class='menu-item-text' and text()='Order Entry']", 2400);
            WebElement clickOnOrderEntry = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='menu-item-text' and text()='Order Entry']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(clickOnOrderEntry));
            new WebDriverWait(driver,  Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(clickOnOrderEntry));
            HelpersMethod.JScriptClick(driver, clickOnOrderEntry, 2000);
            if(clickOnOrderEntry.isDisplayed()){
                System.out.println("order entry selected");
            }else {
                System.out.println("not selected");
            }
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }
}

