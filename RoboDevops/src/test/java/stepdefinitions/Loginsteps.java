package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utilities.Loggers;
import utilities.TestContext;

public class Loginsteps {
    private final TestContext testContext;
    Logger log = Loggers.log();
    public Loginsteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("User signs in to the app")
    public void user_signs_in_to_the_application() {
        testContext.loginPage.loadURL();
        log.info("Application URL is opened");
        testContext.loginPage.fillUserName();
        testContext.loginPage.fillPassword();
        testContext.loginPage.clickContinueButton();
        log.info("Signed into the application");
    }

    @Given("User opens the RoboDevops login page")
    public void user_opens_the_nop_commerce_login_page() {
//        log.info("Launching the URL");
        testContext.loginPage.loadURL();
        log.info("Application URL is opened");
    }

//    @When("Enters username and password")
//    public void entersUsernameAndPassword() {
//        testContext.loginPage.fillUserName();
//        testContext.loginPage.fillPassword();
//    }

    @When("Enters username {string} and password {string}")
    public void enters_username_and_password(String useremail, String password) {
        testContext.loginPage.fillUserNameDDT(useremail);
        testContext.loginPage.fillPasswordDDT(password);
    }

    @When("Clicks on Continue button")
    public void clicks_on_continue_button() {
        testContext.loginPage.clickContinueButton();
    }

    @Then("Successfully logged into the application")
    public void successfully_logged_into_the_application() {
        Assert.assertTrue(testContext.dashboardPage.dashboardPageDisplayed());
        log.info("Successfully logged in to the application");
    }


}
