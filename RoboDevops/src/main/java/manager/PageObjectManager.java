package manager;

import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.TestContext;

public class PageObjectManager {
    //    private final WebDriver driver;
//    private AddNewCustomer_Page addNewCustomerPage;
//    private Customers_Page customerPage;
//    private Dashboard_Page dashboardPage;
    private Loginpage loginPage;
//    private ChooseProduct_Page chooseProductPage;
//    private AddCustomerRole_Page addCustomerRolePage;

    TestContext testContext;

    public PageObjectManager(TestContext testContext) {
        this.testContext = testContext;
        System.out.println("From Page object manager");
    }

//    public AddNewCustomer_Page getAddNewCustomerPage(){
//        return (addNewCustomerPage == null) ? addNewCustomerPage = new AddNewCustomer_Page(testContext) : addNewCustomerPage;
//    }
//
//    public Customers_Page getCustomerPage(){
//        return (customerPage == null) ? customerPage = new Customers_Page(testContext) : customerPage;
//    }
//
//    public Dashboard_Page getDashboardPage(){
//        return (dashboardPage == null) ? dashboardPage = new Dashboard_Page(testContext) : dashboardPage;
//    }

    public Loginpage getLoginPage() {
        return (loginPage == null) ? loginPage = new Loginpage(testContext) : loginPage;
    }

//    public ChooseProduct_Page getChooseProductPage(){
//        return (chooseProductPage == null) ? chooseProductPage = new ChooseProduct_Page(testContext) : chooseProductPage;
//    }
//
//    public AddCustomerRole_Page getAddCustomerRolePage(){
//        return (addCustomerRolePage == null) ? addCustomerRolePage = new AddCustomerRole_Page(testContext) : addCustomerRolePage;
//    }
}
