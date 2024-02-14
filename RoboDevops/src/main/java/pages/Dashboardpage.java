package pages;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import enums.WaitStrategy;
import generics.PageFunctions;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import utilities.TestContext;

import java.util.*;

public class Dashboardpage {

    By dashboardHomeButton = By.xpath("//div[@class='css-1abzdwk']/a/button");
    By dashboardStatistics = By.xpath("//div[@class='MuiContainer-root MuiContainer-maxWidthXl css-n8ywp2']//div[@class='css-l5c1s3']/span");
    By dashboardBuildStatusPieChart = By.xpath("//span[contains(text(),'Build Status')]/ancestor::div[contains(@class, 'MuiGrid2-root MuiGrid2-direction')]/descendant::*[local-name()='svg']//*[local-name()='g']//*[local-name()='g' and @class='apexcharts-pie']");
    By dashboardBuildStatusStatistics = By.xpath("//span[contains(text(),'Build Status')]/ancestor::div[contains(@class, 'MuiGrid2-root MuiGrid2-direction')]/descendant::div[@class=\"css-mcs64e\"]");
    By dashboardTechnologyOverviewPieChart = By.xpath("//span[contains(text(),'Technology Overview')]/ancestor::div[contains(@class, 'MuiGrid2-root MuiGrid2-direction')]/descendant::*[local-name()='svg']//*[local-name()='g']//*[local-name()='g' and @class='apexcharts-pie']");
    TestContext testContext;

    public Dashboardpage(TestContext testContext) {
        this.testContext = testContext;
        System.out.println("From Dashboard page");
    }

    public boolean dashboardPageDisplayed() {
        return PageFunctions._performExplicitWait(dashboardHomeButton, WaitStrategy.VISIBLE).isDisplayed();
    }

    public boolean dashboardStatisticsDsiplayed(DataTable data) {
        boolean desiredStatisticsAvailable = true;
        List<List<String>> dashboardStatisticsTitleExpected = data.asLists();
        List<String> mergedDashboardStatisticsTitleExpected = Lists.newArrayList(Iterables.concat(dashboardStatisticsTitleExpected));
        List<String> dashboardStatisticsTitleActual = PageFunctions._getAllDisplayedElementsText(dashboardStatistics);
        for (int i=0; i<mergedDashboardStatisticsTitleExpected.size(); i++) {
            if (desiredStatisticsAvailable && !dashboardStatisticsTitleActual.get(i).equalsIgnoreCase(mergedDashboardStatisticsTitleExpected.get(i))) {
                System.out.println("Inside if");
                desiredStatisticsAvailable = false;
            }
        }
        return desiredStatisticsAvailable;
    }

    public boolean buildStatusPieChartDisplayed() {
        return PageFunctions._performExplicitWait(dashboardBuildStatusPieChart, WaitStrategy.VISIBLE).isDisplayed();
    }

    public boolean buildStatusStatisticsDisplayed() {
        return PageFunctions._performExplicitWait(dashboardBuildStatusStatistics, WaitStrategy.VISIBLE).isDisplayed();
    }

    public boolean technologyOverviewPieChartDisplayed() {
        return PageFunctions._performExplicitWait(dashboardTechnologyOverviewPieChart, WaitStrategy.VISIBLE).isDisplayed();
    }
}
