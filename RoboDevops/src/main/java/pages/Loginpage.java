package pages;

import config.ConfigFactory;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import utilities.TestContext;

import static generics.PageFunctions.*;

public class Loginpage {
    By loginEmailField = By.xpath("//input[@name='email' and @type='email']");
    By loginPasswordField = By.xpath("//input[@name='password' and @type='password']");
    By LoginContinueButton = By.xpath("//button[@type='submit']");

    TestContext testContext;

    public Loginpage(TestContext testContext) {
        this.testContext = testContext;
        System.out.println("From login page");
    }

    public void loadURL() {
        _loadURL(ConfigFactory.getConfig().url());
    }

    public void fillUserName() {
        _clearAndSendKeys(loginEmailField, ConfigFactory.getConfig().username(), "username");
    }

    public void fillPassword() {
        _clearAndSendKeys(loginPasswordField, ConfigFactory.getConfig().password(), "password");
    }

    public void fillUserNameDDT(String username){
        _clearAndSendKeys(loginEmailField, username, "username");

    }

    public void fillPasswordDDT(String password){
        _clearAndSendKeys(loginPasswordField, password, "password");
    }

    public void clickContinueButton() {
        _performExplicitWait(LoginContinueButton, WaitStrategy.NONE).click();
    }
}
