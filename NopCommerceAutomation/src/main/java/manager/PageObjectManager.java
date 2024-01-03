package manager;

import org.openqa.selenium.WebDriver;
import pages.AddNewCustomer_Page;
import pages.Customers_Page;
import pages.Dashboard_Page;
import pages.Login_Page;
import utilities.TestContext;

public class PageObjectManager {
//    private final WebDriver driver;
    private AddNewCustomer_Page addNewCustomerPage;
    private Customers_Page customerPage;
    private Dashboard_Page dashboardPage;
    private Login_Page loginPage;

    TestContext testContext;

    public PageObjectManager(TestContext testContext) {
        this.testContext = testContext;
    }

    public AddNewCustomer_Page getAddNewCustomerPage(){
        return (addNewCustomerPage == null) ? addNewCustomerPage = new AddNewCustomer_Page(testContext) : addNewCustomerPage;
    }

    public Customers_Page getCustomerPage(){
        return (customerPage == null) ? customerPage = new Customers_Page(testContext) : customerPage;
    }

    public Dashboard_Page getDashboardPage(){
        return (dashboardPage == null) ? dashboardPage = new Dashboard_Page(testContext) : dashboardPage;
    }

    public Login_Page getLoginPage(){
        return (loginPage == null) ? loginPage = new Login_Page(testContext) : loginPage;
    }
}
