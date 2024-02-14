package utilities;

import driverfactory.DriverFactory;
import manager.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pages.*;

public class TestContext {
    public PageObjectManager pageObjectManager;
    public Loginpage loginPage;
    public Dashboardpage dashboardPage;
    public Homepage homepage;

    public TestContext() {
        System.out.println("From test context");
        pageObjectManager = new PageObjectManager(this);
        loginPage = pageObjectManager.getLoginPage();
        dashboardPage = pageObjectManager.getDashboardPage();
        homepage = pageObjectManager.getHomepage();
    }
}
