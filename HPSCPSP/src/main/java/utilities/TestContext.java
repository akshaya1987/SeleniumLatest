package utilities;

import driverfactory.DriverFactory;
import manager.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pages.CustomerHomePage;
import pages.Loginpage;
import pages.PrintOSHomePage;
import pages.ScitexDashboardPage;


public class TestContext {
    public PageObjectManager pageObjectManager;
    public Loginpage loginpage;
    public PrintOSHomePage printoshomepage;
    public CustomerHomePage customerHomepage;
    public ScitexDashboardPage scitexDashboardPage;

    public TestContext() {
        System.out.println("From test context");
        pageObjectManager = new PageObjectManager(this);
        loginpage = pageObjectManager.getLoginpage();
        printoshomepage = pageObjectManager.getPrintOSHomePage();
        customerHomepage  = pageObjectManager.getCustomerHomePage();
        scitexDashboardPage = pageObjectManager.getScitexDashboardPage();
    }
}

