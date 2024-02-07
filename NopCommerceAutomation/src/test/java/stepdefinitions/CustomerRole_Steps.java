package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.TestContext;

public class CustomerRole_Steps {
    TestContext testContext;

    public CustomerRole_Steps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("User is in Customer Role page")
    public void user_is_in_customer_role_page(DataTable dataTable) {
        testContext.dashboardPage.clickCustomersOptionFromHamburgerMenu();
        testContext.dashboardPage.clickCustomersLink();
        testContext.dashboardPage.clickCustomerRolesLink();
        testContext.addCustomerRolePage.clickAddNewButton();
//        testContext.customersPage.clickAddNewCustomerButton();
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

//    @Then("{pagename} page is displayed")
////    public void page_is_displayed(String pagename) {
////
////    }

    @Then("Enters the necessary data")
    public void enters_the_necessary_data() {

    }

    @Then("Customer role is added successfully")
    public void customer_role_is_added_successfully() {

    }

}
