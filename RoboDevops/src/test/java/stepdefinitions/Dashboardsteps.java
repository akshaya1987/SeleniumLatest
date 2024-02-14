package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utilities.Loggers;
import utilities.TestContext;

public class Dashboardsteps {

    private final TestContext testContext;
    Logger log = Loggers.log();

    public Dashboardsteps(TestContext testContext) {
        this.testContext = testContext;
    }


    @Then("Statistics are displayed in Dashboard")
    public void statistics_are_displayed_in_dashboard(DataTable dataTable) {
        Assert.assertTrue(testContext.dashboardPage.dashboardStatisticsDsiplayed(dataTable));
    }

    @When("User is in Dashboard")
    public void user_is_in_dashboard() {
        Assert.assertTrue(testContext.dashboardPage.dashboardPageDisplayed());
        log.info("Dashboard is displayed");
    }

    @Then("Build status pie chart is displayed")
    public void build_status_pie_chart_is_displayed() {
        Assert.assertTrue(testContext.dashboardPage.buildStatusPieChartDisplayed());
    }

    @Then("Build status information are displayed")
    public void build_status_informations_are_displayed() {
        Assert.assertTrue(testContext.dashboardPage.buildStatusStatisticsDisplayed());
    }

    @Then("Technology overview pie chart is displayed")
    public void technology_overview_pie_chart_is_displayed() {
        Assert.assertTrue(testContext.dashboardPage.technologyOverviewPieChartDisplayed());
    }

}
