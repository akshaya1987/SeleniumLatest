package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.TestContext;

public class Dashboardsteps {

    TestContext testContext;

    public Dashboardsteps(TestContext testContext) {
        this.testContext = testContext;
    }

// Step-definitions for SC Dashboard

    @When("User clicks on Menu in PrintOS home page")
    public void user_clicks_on_menu_in_printOS_home_page() {
        testContext.printoshomepage.clickMenu();
    }

    @Then("Clicks on organisation dropdown")
    public void clicks_on_organisation_dropdown() {
        testContext.printoshomepage.clickOrganizationDropdown();
    }

    @Then("Enters customer organisation name in search filed")
    public void enters_customer_organisation_name_in_search_filed() {
        testContext.printoshomepage.enterOrganizationName();
    }

    @Then("Clicks on customer organisation")
    public void clicks_on_customer_organisation() {
//        testContext.printoshomepage.selectOrganization();
    }

    @Then("Customer Home Screen is displayed")
    public void customer_home_screen_is_displayed() {
//        Assert.assertTrue(testContext.cu);
        Assert.assertTrue(testContext.customerHomepage.customerHomePageDisplayed());
    }

    @Then("Clicks on menu")
    public void clicks_on_menu() {
        testContext.printoshomepage.clickMenu();
    }

    @Then("Open Service Center for Scitex")
    public void open_service_centre_for_scitex() {
        testContext.customerHomepage.openScitexServiceCenter();
    }

    @Then("Clicks on Scitex Service Center dropdown option")
    public void clicks_on_scitex_service_center_dropdown_option() {
        testContext.customerHomepage.openScitexServiceCenter();
    }

    @Then("Service Center dashboard is displayed")
    public void service_center_dashboard_is_displayed() {
        Assert.assertTrue(testContext.scitexDashboardPage.serviceCenterHomePageDisplayed());
    }

    @Then("HP Scitex family is selected by default in Family dropdown")
    public void hp_scitex_family_is_selected_by_default_in_family_dropdown() {
        Assert.assertTrue(testContext.scitexDashboardPage.selectedFamily());
    }

    @Then("Parts to Return is displayed")
    public void parts_to_return_is_displayed() {
        Assert.assertTrue(testContext.scitexDashboardPage.partsToReturnIsDisplayed());
    }

    @Then("Ordered items is displayed")
    public void ordered_items_is_displayed() {
        Assert.assertTrue(testContext.scitexDashboardPage.orderedItemsDisplayed());
    }

    @Then("UTKs is displayed")
    public void ut_ks_is_displayed() {
        Assert.assertTrue(testContext.scitexDashboardPage.utksDisplayed());
    }

    @Then("Scitex Parts Catalog card is displayed")
    public void scitex_parts_catalog_card_is_displayed() {
        Assert.assertTrue(testContext.scitexDashboardPage.scitexPartsCatalogCardDisplayed());
    }

    @Then("Support cases card is displayed")
    public void support_cases_card_is_displayed() {
       Assert.assertTrue(testContext.scitexDashboardPage.supportCasesCardDisplayed());
    }

    @Then("IOM card is displayed")
    public void iom_card_is_displayed() {
        Assert.assertTrue(testContext.scitexDashboardPage.hpScitexIOMCardDisplayed());
    }

    @Then("Parts Returns Status card is displayed")
    public void parts_returns_status_card_is_displayed() {
        Assert.assertTrue(testContext.scitexDashboardPage.partsReturnStatusCard());
    }

}
