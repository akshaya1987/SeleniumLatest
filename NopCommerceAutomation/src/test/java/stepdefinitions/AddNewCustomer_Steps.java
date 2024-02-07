package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.TestContext;
import static org.junit.Assert.assertEquals;

public class AddNewCustomer_Steps {
    TestContext testContext;

    public AddNewCustomer_Steps(TestContext testContext){
        this.testContext = testContext;
    }

    @When("User clicks on Customers option from hamburger menu")
    public void user_clicks_on_customers_option_from_hamburger_menu() {
        testContext.dashboardPage.clickCustomersOptionFromHamburgerMenu();
    }

    @Then("Clicks on Customers menu")
    public void clicks_on_customers_menu() {
        testContext.dashboardPage.clickCustomersLink();
    }

    @Then("Customers page is displayed")
    public void customers_page_is_displayed() {
        testContext.customersPage.customerPageDisplayed();
    }

    @Then("Clicks on Add new button")
    public void clicks_on_add_new_button() {
        testContext.customersPage.clickAddNewCustomerButton();
    }

    @Then("Enters customer information")
    public void enters_customer_information(DataTable dataTable) throws InterruptedException {
//        List<List<String>> data = dataTable.asLists();
        testContext.addNewCustomerPage.fillCustomerInformations(dataTable);
    }

    @Then("Clicks on Save button")
    public void clicks_on_save_button() {
        testContext.addNewCustomerPage.clickSaveButton();
    }

    @Then("Customer is added successfully")
    public void customer_is_added_successfully() {
        testContext.customersPage.customerAddedSuccessMessageDisplayed();
    }

    @Then("Added customer is available in customers table")
    public void added_customer_is_available_in_customers_table() {
        Assert.assertTrue(testContext.customersPage.customerAvailableInTable());
    }

}
