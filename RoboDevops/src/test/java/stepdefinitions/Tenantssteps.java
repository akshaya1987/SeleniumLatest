package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Addtenantspage;
import utilities.TestContext;

import javax.xml.crypto.Data;

public class Tenantssteps {

    TestContext testContext;

    public Tenantssteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("User clicks on Tenants menu")
    public void user_clicks_on_tenants_menu() {
        testContext.homepage.clickTenatsMenu();
    }

    @Then("Tenants page is displayed")
    public void tenants_page_is_displayed() {
        Assert.assertTrue(testContext.tenantspage.tenantsPageDsiplayed());
    }

    @Then("Clicks on Add button")
    public void clicks_on_add_button() {
        testContext.tenantspage.clickAddButton();
    }

    @Then("Create tenant page is displayed")
    public void create_tenant_page_is_displayed() {
        Assert.assertTrue(testContext.addtenantspage.addTenantsPageDsiplayed());
    }

    @When("Enters tenants details and clicks on Create button")
    public void enters_tenants_details_and_clicks_on_create_button(DataTable dataTable) {
        testContext.addtenantspage.fillTenantInformation(dataTable);
        testContext.addtenantspage.clickAddButton();
    }

    @Then("Tenant created successfully message is displayed")
    public void tenant_created_successfully_message_is_displayed() {
        testContext.addtenantspage.addTenantsSuccessPageDisplayed();
    }

    @Then("Tenant is listed in tenants list")
    public void tenant_is_listed_in_tenants_list() {
        Assert.assertTrue(testContext.tenantspage.tenantAddedSuccessfully(testContext.addtenantspage.organizationName));
    }

    @Then("Clicks on Delete button and confirms deletion")
    public void clicks_on_delete_button_and_confirms_deletion(DataTable dataTable) throws InterruptedException {
        testContext.tenantspage.deleteTenant(dataTable);
    }

    @Then("Tenant deleted successfully message is displayed")
    public void tenant_deleted_successfully_message_is_displayed() {
        Assert.assertTrue(testContext.tenantspage.tenantDeletedSuccessfully());
    }

    @Then("Tenant is removed from the tenants list")
    public void tenant_is_removed_from_the_tenants_list(DataTable dataTable) {

    }

    @Then("Clicks on Update button")
    public void clicks_on_update_button(DataTable dataTable) {
        testContext.tenantspage.clickEditTenantButton(dataTable);
    }

    @Then("Update tenant page is displayed")
    public void update_tenant_page_is_displayed() {
        Assert.assertTrue(testContext.updatetenantspage.updateTenantPageDisplayed());
    }

    @Then("Update the tenant information")
    public void update_the_tenant_information(DataTable dataTable) {
        testContext.addtenantspage.fillTenantInformation(dataTable);
    }

    @Then("Click on Update button")
    public void click_on_update_button() {
        testContext.updatetenantspage.clickUpdateButton();
    }

    @Then("Tenant updated successfully message is displayed")
    public void tenant_updated_successfully_message_is_displayed() {
        testContext.updatetenantspage.updateTenantsSuccessPageDisplayed();
    }

    @Then("Tenant is updated in the tenants list")
    public void tenant_is_updated_in_the_tenants_list(DataTable dataTable) {
        Assert.assertTrue(testContext.tenantspage.tenantUpdatedSuccessfully(dataTable));
    }
}