package pages;

import enums.WaitStrategy;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import utilities.TestContext;

import java.util.List;

import static generics.PageFunctions._getAllDisplayedElementsText;
import static generics.PageFunctions._performExplicitWait;

public class Updatetenantpage {

    By tenantUpdatedSuccessMessage = By.xpath("//div[@class='Toastify__toast-body']/div[contains(text(), 'Tenant Updated Successfully')]");
    By updatetenantsPageTitle = By.xpath("//div[@class='css-l5c1s3']/h4");
    By tenantsUpdateButton = By.xpath("//button[@type='submit']");
    String organizationName;

    TestContext testContext;

    public Updatetenantpage(TestContext testContext){
        this.testContext = testContext;
    }

    public boolean updateTenantPageDisplayed(){
        return _performExplicitWait(updatetenantsPageTitle, WaitStrategy.VISIBLE).isDisplayed();
    }

    public void clickUpdateButton() {
        _performExplicitWait(tenantsUpdateButton, WaitStrategy.PRESENCE).click();
    }



    public boolean updateTenantsSuccessPageDisplayed(){
        return _performExplicitWait(tenantUpdatedSuccessMessage, WaitStrategy.VISIBLE).isDisplayed();
    }
}
