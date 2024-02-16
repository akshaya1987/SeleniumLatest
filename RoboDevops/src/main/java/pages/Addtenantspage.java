package pages;

import enums.WaitStrategy;
import static generics.PageFunctions.*;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import utilities.TestContext;

import java.util.List;

public class Addtenantspage {

    TestContext testContext;
    public Addtenantspage(TestContext testContext){
        this.testContext = testContext;
    }

    By addtenantsPageTitle = By.xpath("//div[@class='css-l5c1s3']");
    By addtenantsOrgName = By.xpath("//input[@name='Org_name']");
    By addtenantsAdminName = By.xpath("//input[@name='Admin_name']");
    By addtenantsAdminEmail = By.xpath("//input[@name='Admin_email']");
    By addtenantsSubdomainName = By.xpath("//input[@name='subdomain_name']");
    By tenantsAddButton = By.xpath("//button[@type='submit']");
    By tenantSuccessMessage = By.xpath("//div[@class='Toastify__toast-body']/div[contains(@class, 'Toastify__toast-icon')]");

    //table[contains(@class, 'MuiTable-root css-1trb3f4')]/tbody/tr

    public String organizationName;
    public String adminName;
    public String adminEmail;
    public String subdomainName;

    public boolean addTenantsPageDsiplayed(){
        return _performExplicitWait(addtenantsPageTitle, WaitStrategy.VISIBLE).isDisplayed();
    }

    public void fillTenantInformation(DataTable dataTable){
        List<List<String>> data = dataTable.asLists();
        organizationName = data.get(0).get(0);
        adminName =  data.get(0).get(1);
        adminEmail =  data.get(0).get(2);
        subdomainName =  data.get(0).get(3);
        _clearAndSendKeys(addtenantsOrgName,organizationName, "Organization name field");
        _clearAndSendKeys(addtenantsAdminName,adminName, "Organization admin name field");
        _clearAndSendKeys(addtenantsAdminEmail,adminEmail, "Organization admin email field");
        _clearAndSendKeys(addtenantsSubdomainName,subdomainName, "Organization subdomain name field");
    }

    public void clickAddButton() {
        _performExplicitWait(tenantsAddButton, WaitStrategy.PRESENCE).click();
    }

    public boolean addTenantsSuccessPageDisplayed(){
        return _performExplicitWait(tenantSuccessMessage, WaitStrategy.VISIBLE).isDisplayed();
    }
}
