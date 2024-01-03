package utilities;

import driverfactory.DriverFactory;
import manager.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pages.AddNewCustomer_Page;
import pages.Customers_Page;
import pages.Dashboard_Page;
import pages.Login_Page;

public class TestContext {
    PageObjectManager pageObjectManager;
    public AddNewCustomer_Page addNewCustomerPage;
    public Customers_Page customersPage;
    public Dashboard_Page dashboardPage;
    public Login_Page loginPage;

    public TestContext() {
        pageObjectManager = new PageObjectManager(this);
        addNewCustomerPage = pageObjectManager.getAddNewCustomerPage();
        customersPage = pageObjectManager.getCustomerPage();
        dashboardPage = pageObjectManager.getDashboardPage();
        loginPage = pageObjectManager.getLoginPage();
    }
}
