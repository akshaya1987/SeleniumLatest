package stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.AddNewCustomer_Page;
import pages.Customers_Page;
import pages.Dashboard_Page;
import pages.Login_Page;
import utilities.Loggers;
import utilities.TestContext;

public class Login_Steps {

    private TestContext testContext;
    Logger log = Loggers.log();

    public Login_Steps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("User signs in to the app")
    public void user_signs_in_to_the_application() {
        testContext.loginPage.loadURL();
//        log.info("Application URL is opened");
        testContext.loginPage.fillUserName();
        testContext.loginPage.fillPassword();
        testContext.loginPage.clickLoginButton();
        log.info("Signed into the application");
    }

    @Given("User opens the nopCommerce login page")
    public void user_opens_the_nop_commerce_login_page() {
//        log.info("Launching the URL");
        testContext.loginPage.loadURL();
        log.info("Application URL is opened");
    }

    @When("Enters username and password")
    public void entersUsernameAndPassword() {
        testContext.loginPage.fillUserName();
        testContext.loginPage.fillPassword();
    }

    @When("Enters username {string} and password {string}")
    public void enters_username_and_password(String useremail, String password) {
        testContext.loginPage.fillUserNameDDT(useremail);
        testContext.loginPage.fillPasswordDDT(password);
    }

    @When("Clicks on login button")
    public void clicks_on_login_button() {
        testContext.loginPage.clickLoginButton();
    }

    @Then("Successfully logged into the application")
    public void successfully_logged_into_the_application() {
        Assert.assertTrue(testContext.dashboardPage.dashboardPageDisplayed());
        log.info("Successfully logged in to the application");
    }

    @Given("User is in Dashboard")
    public void user_is_in_dashboard() {
        Assert.assertTrue(testContext.dashboardPage.dashboardPageDisplayed());
        log.info("Dashboard is displayed");
    }

}
