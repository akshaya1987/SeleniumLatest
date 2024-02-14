package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.TestContext;

public class Tenantssteps {

    TestContext testContext;

    public  Tenantssteps(TestContext testContext){
        this.testContext = testContext;
    }

    @When("User clicks on Tenants menu")
    public void user_clicks_on_tenants_menu() {

    }

    @Then("Tenants page is displayed")
    public void tenants_page_is_displayed() {

    }

    @Then("Clicks on Add button")
    public void clicks_on_add_button() {

    }

    @Then("Create tenant page is displayed")
    public void create_tenant_page_is_displayed() {

    }

    @When("Enters tenants details and clicks on Create button")
    public void enters_tenants_details_and_clicks_on_create_button() {

    }

    @Then("Tenant created successfully message is displayed")
    public void tenant_created_successfully_message_is_displayed() {

    }

    @Then("Tenant is listed in tenants list")
    public void tenant_is_listed_in_tenants_list(DataTable dataTable) {

    }
}