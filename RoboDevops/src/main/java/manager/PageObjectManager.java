package manager;

import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.TestContext;

public class PageObjectManager {
    private Dashboardpage dashboardPage;
    private Loginpage loginPage;
    private Homepage homepage;
    private Tenantspage tenantspage;
    private Addtenantspage addtenantspage;
    private Updatetenantpage updatetenantpage;


    TestContext testContext;

    public PageObjectManager(TestContext testContext) {
        this.testContext = testContext;
        System.out.println("From Page object manager");
    }

    public Loginpage getLoginPage() {
        return (loginPage == null) ? loginPage = new Loginpage(testContext) : loginPage;
    }

    public Dashboardpage getDashboardPage(){
        return (dashboardPage == null) ? dashboardPage = new Dashboardpage(testContext) : dashboardPage;
    }

    public Homepage getHomepage(){
        return (homepage == null) ? homepage = new Homepage(testContext) : homepage;
    }

    public Tenantspage getTenantspage(){
        return (tenantspage == null) ? tenantspage = new Tenantspage(testContext) : tenantspage;
    }

    public Addtenantspage getAddtenantspage(){
        return (addtenantspage == null) ? addtenantspage = new Addtenantspage(testContext) : addtenantspage;
    }

    public Updatetenantpage getUpdatetenantspage(){
        return (updatetenantpage == null) ? updatetenantpage = new Updatetenantpage(testContext) : updatetenantpage;
    }
}
