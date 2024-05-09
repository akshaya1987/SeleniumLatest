package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.TestContext;

public class ServiceCenterSteps {

    TestContext testContext;

    public ServiceCenterSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    // Step-definitions for Login functionality

    @Given("User opens PrintOS URL")
    public void user_opens_print_os_url() {
//        testContext.loginpage.performLogin();
        testContext.loginpage.openURL();
    }

    @When("Clicks on Sign In button")
    public void clicks_on_sign_in_button() {
        testContext.loginpage.clickSignInButton();
    }

    @Then("Enters username")
    public void enters_username() {
        testContext.loginpage.enterUserName();
    }

    @Then("Clicks on Next button")
    public void clicks_on_next_button() {
        testContext.loginpage.clickNextButton();
    }

    @Then("Redirected to HP authenticate screen")
    public void redirected_to_hp_authenticate_screen() {
        Assert.assertTrue(testContext.loginpage.hpAuthenticationPageDisplayed());
    }

    @Then("Enters valid username")
    public void enters_valid_username() {
        testContext.loginpage.enterUserEmail();
    }

    @Then("Enters valid password")
    public void enters_valid_password() {
        testContext.loginpage.enterUserPassword();
    }

    @Then("Clicks on Submit button")
    public void clicks_on_submit_button() {
        testContext.loginpage.clickLogOnButton();
    }

    @Then("Logs in successfully")
    public void logs_in_successfully() {
        Assert.assertTrue(testContext.loginpage.successfullyLoggedIn());
    }


}
