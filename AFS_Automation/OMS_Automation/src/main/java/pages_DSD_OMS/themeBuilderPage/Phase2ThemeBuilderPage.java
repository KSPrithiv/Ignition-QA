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

import java.time.Duration;

public class Phase2ThemeBuilderPage {
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    @FindBy(xpath = "//input[@id='DEFAULT_THEME']")
    private WebElement DefaultTheme;

    //Constructor with parameter
    public Phase2ThemeBuilderPage(WebDriver driver, Scenario scenario) {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver, this);
    }
    @BeforeMethod
    public void WaitForPage()
    {HelpersMethod.Implicitwait(driver,5);}
    private static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);
    }

    /*public void clickOnPermissionBy() throws InterruptedException {
        WebElement PermissionBy;
        //Thread.sleep(15000);
        try {
            if (HelpersMethod.IsExists("//span[@class='k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon']", driver)) {
                PermissionBy = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon']");
                HelpersMethod.JScriptClick(driver, PermissionBy, 20);
            }

        } catch (Exception e) {
        }
    }
    public void selectAnyCompany(){
        WebElement CompanyDDSelection;
                *//*=driver.findElement(By.xpath("//span[@id='dropdownList3']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(CompanyDDSelection).click().sendKeys("000112, Flowers Baking Co. of Miami").perform();*//*
        try {
            if (HelpersMethod.IsExists("//span[@id='dropdownList3']", driver)) {
                CompanyDDSelection = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='dropdownList3']");
                CompanyDDSelection.sendKeys("000189, Adelphia Seafood");
                //CompanyDDSelection.click();
                HelpersMethod.JScriptClick(driver, CompanyDDSelection, 20);
                System.out.println("Company selected as expected");
                *//*WebElement Company = HelpersMethod.FindByElement(driver, "xpath", "/html//div[@class='k-animation-container k-animation-container-relative k-animation-container-shown']/div/div[@class='i-header-toolbar-popup__content i-header-toolbar-popup__content--expanded']/div/div[2]/span[@class='dropdown-left']/span[2]/span/span[@role='listbox']/span[@class='k-input']");
                act.moveToElement(Company).sendKeys("000189, Adelphia Seafood").click().build().perform();*//*
            }
        }catch (Exception e){}

    }
    public void clickGeneralSettings()
    {
        //WebElement clickHumburger=driver.findElement(By.xpath(""));
        WebElement generalSettings=driver.findElement(By.xpath("//div[@id='menuWrapper_selected_accesscpadmingeneralsettings']//span[@class='menu-item-text']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(generalSettings).click().perform();
        System.out.println("user click on general settings tab");
    }*/
    public void loginCardPositionLeft() throws InterruptedException {

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        WebElement loginCardLeft=driver.findElement(By.xpath("//button[@id='LeftLoginCardPosition']"));
        //loginCardLeft.click();
        HelpersMethod.ActClick(driver, loginCardLeft, 1000);
        System.out.println("able to select login card as left");
    }
    public void loginCardPositionCenter() throws InterruptedException {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        WebElement loginCardCenter=driver.findElement(By.xpath("//button[@id='CenterLoginCardPosition']"));
        //loginCardCenter.click();
        HelpersMethod.ActClick(driver, loginCardCenter, 1000);
        System.out.println("able to select login card as Center");
    }
    public void loginCardPositionRight() throws InterruptedException {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        WebElement loginCardRight=driver.findElement(By.xpath("//button[@id='RightLoginCardPosition']"));
        //loginCardRight.click();
        HelpersMethod.ActClick(driver, loginCardRight, 1000);
        System.out.println("able to select login card as Right");
    }
    public void verifyPreviewOfLoginCardPosition() throws InterruptedException {
        HelpersMethod.Implicitwait(driver, 30);
        WebElement previewOfLoginCard=driver.findElement(By.xpath("//div[@class='preview2-with-logo-container']"));
        scrollToElement(driver, previewOfLoginCard);
        if(previewOfLoginCard.isDisplayed())
        {
            System.out.println("Preview of login card display as per selection of login preview page");
        }else {
            System.out.println("Preview of login card not display in proper way");
        }
        //Thread.sleep(15000);
    }
    public void verifyLoginPageAtLeftSide(){
        //578.800 * 644.525
        //// Find the login card element
        WebElement loginCardPosition = driver.findElement(By.xpath("//div[@class='i-card unauthorized-content']"));
       // Verify if the login card is displayed on the left side
        boolean isLoginCardDisplayedOnLeft = loginCardPosition.isDisplayed()
                && loginCardPosition.getLocation().getX() < driver.manage().window().getSize().getWidth() / 2;
        // Print the result
        System.out.println("Is login card displayed on the left side? " + isLoginCardDisplayedOnLeft);
    }
    public void verifyLoginPageAtCenterSide(){
        WebElement loginCardPosition = driver.findElement(By.xpath("//div[@class='i-card unauthorized-content']"));
        // Get the position of the login card element

        Point loginCard = loginCardPosition.getLocation();
        Dimension loginCardSize = loginCardPosition.getSize();
        int loginCardX = loginCard.getX();
        int loginCardY = loginCard.getY();
        int loginCardWidth = loginCardSize.getWidth();
        int loginCardHeight = loginCardSize.getHeight();

        Dimension viewportSize = driver.manage().window().getSize();
        int viewportWidth = viewportSize.getWidth();
        int viewportHeight = viewportSize.getHeight();
        int centerX = viewportWidth / 2;
        int centerY = viewportHeight / 2;

        boolean isCentered = (loginCardX + loginCardWidth / 2) == centerX &&
                (loginCardY + loginCardHeight / 2) == centerY;

        //Assert.assertTrue(isCentered);
        // or
        if (isCentered) {
            System.out.println("Login card is centered.");
        } else {
            System.out.println("Login card is not centered.");
        }
    }
    public void verifyLoginPageAtRightSide(){
        WebElement loginCardPosition = driver.findElement(By.xpath("//div[@class='i-card unauthorized-content']"));
        // Get the position of the login card element
        int loginCardX = loginCardPosition.getLocation().getX();
        int loginCardWidth = loginCardPosition.getSize().getWidth();
        int loginCardRightX = loginCardX + loginCardWidth;

        // Get the width of the browser window
        int windowWidth = driver.manage().window().getSize().getWidth();

        // Compare the position of the login card with the right side of the page
        boolean isLoginCardOnRight = loginCardRightX >= windowWidth * 0.5;

        // Print the validation result
        System.out.println("Is login card displayed on the right side? " + isLoginCardOnRight);
    }
    public void EnterTitleInTitleBox(){
        WebElement titleTextBox=driver.findElement(By.xpath("//input[@id='titleTextbox']"));
        titleTextBox.sendKeys("Ignition QA DSD");
    }
    public void verifyLoginPageTitle(){
        // Get the actual title of the web page
        //String actualTitle = driver.getTitle();
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@id='unauthorized-content']//p[@class='banner-title']", 100);
        WebElement loginPageTitle=driver.findElement(By.xpath("//div[@id='unauthorized-content']//p[@class='banner-title']"));
        //Get text of title
        String actualTitle=loginPageTitle.getText();
        //Print actual title
        System.out.println("actual title is:" +actualTitle);

        // Define the expected title
        String expectedTitle = "Ignition QA ERP";

        // Compare the actual and expected titles
        boolean isTitleValid = actualTitle.equals(expectedTitle);

        // Print the validation result
        System.out.println("Is the title valid? " + isTitleValid);
    }
    public void selectDefaultTheme(){
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "//input[@id='DEFAULT_THEME']", 2400);
            WebElement DefaultTheme1 = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='DEFAULT_THEME']");
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOf(DefaultTheme1));
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(DefaultTheme1));

            if(DefaultTheme1.isSelected()){
                System.out.println("Default theme not selected so select new theme !!!");
                WebElement DefaultTheme2 = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='general_4']");
                HelpersMethod.ActClick(driver, DefaultTheme2, 2000);

            }else {
                System.out.println("Default theme selected !!!");
                HelpersMethod.ActClick(driver, DefaultTheme1, 2000);
            }

            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
        //DefaultTheme.click();
    }
}
