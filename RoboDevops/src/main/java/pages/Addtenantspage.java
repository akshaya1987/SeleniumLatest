package pages;

import org.openqa.selenium.By;
import utilities.TestContext;

public class Addtenantspage {

    By addtenantsPageTitle = By.xpath("//div[@class='css-l5c1s3']");
    By addtenantsOrgName = By.xpath("//input[@name='Org_name']");
    By addtenantsAdminName = By.xpath("//input[@name='Admin_name']");
    By addtenantsAdminEmail = By.xpath("//input[@name='Admin_email']");
    By addtenantsSubdomainName = By.xpath("//input[@name='subdomain_name']");
    By tenantsAddButton = By.xpath("//button[@type='submit']");
    By tenantSuccessMessage = By.xpath("//div[@class='Toastify__toast-body']/div[contains(@class, 'Toastify__toast-icon')]");

    //table[contains(@class, 'MuiTable-root css-1trb3f4')]/tbody/tr

    TestContext testContext;

    public Addtenantspage(TestContext testContext){
        this.testContext = testContext;
    }
}
