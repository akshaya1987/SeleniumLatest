package pages;

import config.ConfigFactory;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import utilities.TestContext;

import static generics.PageFunctions.*;

public class Login_Page {

    By LoginIDField = By.id("Email");
    By loginPasswordField = By.id("Password");
    By LoginButton = By.xpath("//button[@class='button-1 login-button']");

    TestContext testContext;

    public Login_Page(TestContext testContext) {
        this.testContext = testContext;
        System.out.println("From login page");
    }

    public void loadURL() {
        _loadURL(ConfigFactory.getConfig().url());
    }

    public void fillUserName() {
        _clearAndSendKeys(LoginIDField, ConfigFactory.getConfig().username(), "username");
    }

    public void fillPassword() {
        _clearAndSendKeys(loginPasswordField, ConfigFactory.getConfig().password(), "password");
    }

    public void fillUserNameDDT(String username){
        _clearAndSendKeys(LoginIDField, username, "username");

    }

    public void fillPasswordDDT(String password){
        _clearAndSendKeys(loginPasswordField, password, "password");
    }

    public void clickLoginButton() {
        _performExplicitWait(LoginButton, WaitStrategy.NONE).click();
    }

}
