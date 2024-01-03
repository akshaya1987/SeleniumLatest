package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.TestContext;

public class Customers_Steps {

    TestContext testContext;

    public Customers_Steps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("Enters search key {string} in {string} field")
    public void enters_search_key_in_field(String string, String string2) {
        testContext.customersPage.fillSearchString(string, string2);
    }

    @Then("Clicks on Search button")
    public void clicks_on_search_button() {
        testContext.customersPage.clickSearchButton();
    }


    @Then("Customer with {string} is searched successfully")
    public void customer_with_is_searched_successfully(String string) throws InterruptedException {
        Assert.assertTrue(testContext.customersPage.searchCustomer(string));
    }

}