package manager;

import pages.CustomerHomePage;
import pages.Loginpage;
import pages.PrintOSHomePage;
import pages.ScitexDashboardPage;
import utilities.TestContext;

public class PageObjectManager {

    private Loginpage loginpage;
    private PrintOSHomePage printoshomepage;
    private CustomerHomePage customerHomepage;
    private ScitexDashboardPage scitexDashboardPage;
    TestContext testContext;

    public PageObjectManager(TestContext testContext) {
        this.testContext = testContext;
        System.out.println("From Page object manager");
    }

    public Loginpage getLoginpage(){
        return (loginpage == null) ? loginpage = new Loginpage(testContext) : loginpage;
    }

    public PrintOSHomePage getPrintOSHomePage(){
        return (printoshomepage == null) ? printoshomepage = new PrintOSHomePage(testContext) : printoshomepage;
    }
    public CustomerHomePage getCustomerHomePage(){
        return (customerHomepage == null) ? customerHomepage = new CustomerHomePage(testContext) : customerHomepage;
    }

    public ScitexDashboardPage getScitexDashboardPage(){
        return (scitexDashboardPage == null) ? scitexDashboardPage = new ScitexDashboardPage(testContext) : scitexDashboardPage;
    }

}
