package pages;

import config.ConfigFactory;
import enums.WaitStrategy;
import generics.PageFunctions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.page.Page;
import utilities.TestContext;

public class Loginpage {

    By signInButton = By.xpath("//button[@id='button-signin-click']");
    By userNameField = By.xpath("//input[@class='css-1247jht']");
    By nextButton = By.xpath("//button[@id='user-name-form-submit']");
    By hpAuthenticationPageTitle = By.xpath("//div[@class='hpnn-header-logo']");
    By hpAuthenticationPageEmailField = By.xpath("//input[@id='username']");
    By hpAuthenticationPagePasswordField = By.xpath("//input[@id='password']");
    By getHpAuthenticationPageLogOnButton = By.xpath("//div[@class='submit-row']/input[@type='submit']");

    TestContext testContext;

    public Loginpage(TestContext testContext) {
        this.testContext = testContext;
    }

//    public void performLogin() {
//        PageFunctions._loadURL(ConfigFactory.getConfig().url());
//        PageFunctions._performExplicitWait(signInButton, WaitStrategy.CLICKABLE).click();
//        PageFunctions._clearAndSendKeys(userNameField, ConfigFactory.getConfig().username(), "email filed");
//        PageFunctions._performExplicitWait(nextButton, WaitStrategy.CLICKABLE).click();
//        try {
//            PageFunctions._clearAndSendKeys(hpAuthenticationPageEmailField, ConfigFactory.getConfig().username(), "HP authentication email filed");
//            PageFunctions._clearAndSendKeys(hpAuthenticationPagePasswordField, ConfigFactory.getConfig().password(), "HP authentication password filed");
//            PageFunctions._performExplicitWait(getHpAuthenticationPageLogOnButton, WaitStrategy.CLICKABLE).click();
//        }catch (Exception e){
//            System.out.println(" Hp login was already done!");
//        }
//
//    }

    public void openURL(){
        PageFunctions._loadURL(ConfigFactory.getConfig().url());
    }

    public void clickSignInButton(){
        PageFunctions._performExplicitWait(signInButton, WaitStrategy.CLICKABLE).click();
    }

    public void enterUserName(){
        PageFunctions._clearAndSendKeys(userNameField, ConfigFactory.getConfig().username(), "email filed");
    }

    public void clickNextButton(){
        PageFunctions._performExplicitWait(nextButton, WaitStrategy.CLICKABLE).click();
    }

    public boolean hpAuthenticationPageDisplayed(){
        return PageFunctions._isElementAvailable(hpAuthenticationPageTitle, WaitStrategy.VISIBLE);
    }

    public void enterUserEmail(){
        PageFunctions._clearAndSendKeys(hpAuthenticationPageEmailField, ConfigFactory.getConfig().username(), "HP authentication email filed");
    }

    public void enterUserPassword(){
        System.out.println("Password is :"+ConfigFactory.getConfig().password());
        PageFunctions._sendKeys(hpAuthenticationPagePasswordField, ConfigFactory.getConfig().password(), "HP authentication password filed");
    }

    public void clickLogOnButton(){
        PageFunctions._performExplicitWait(getHpAuthenticationPageLogOnButton, WaitStrategy.CLICKABLE).click();
    }

    public boolean successfullyLoggedIn(){
        return PageFunctions._isElementAvailable(testContext.printoshomepage.printOSHome, WaitStrategy.VISIBLE);
    }

}
