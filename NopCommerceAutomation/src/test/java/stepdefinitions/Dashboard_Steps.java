package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.AddNewCustomer_Page;
import pages.Customers_Page;
import pages.Dashboard_Page;
import pages.Login_Page;
import utilities.TestContext;

import java.util.List;

public class Dashboard_Steps {

    TestContext testContext;

    public Dashboard_Steps(TestContext testContext){
        this.testContext = testContext;
    }

    @Then("Store setting options are displayed")
    public void store_setting_options_are_displayed(DataTable storeSettingOptions) {
        List<List<String>> options = storeSettingOptions.asLists();
        testContext.dashboardPage.verifyConfigurationSettingOptions(storeSettingOptions);
    }

}
