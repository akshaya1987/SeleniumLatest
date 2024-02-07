package utilities;

import driverfactory.DriverFactory;
import manager.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pages.*;

public class TestContext {
    public PageObjectManager pageObjectManager;
    public AddNewCustomer_Page addNewCustomerPage;
    public Customers_Page customersPage;
    public Dashboard_Page dashboardPage;
    public Login_Page loginPage;
    public AddCustomerRole_Page addCustomerRolePage;

    public TestContext() {
        System.out.println("From test context");
        pageObjectManager = new PageObjectManager(this);
        addNewCustomerPage = pageObjectManager.getAddNewCustomerPage();
        customersPage = pageObjectManager.getCustomerPage();
        dashboardPage = pageObjectManager.getDashboardPage();
        loginPage = pageObjectManager.getLoginPage();
        addCustomerRolePage = pageObjectManager.getAddCustomerRolePage();

    }
}
