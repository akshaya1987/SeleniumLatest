package pages;

import enums.WaitStrategy;
import generics.PageFunctions;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Loggers;
import utilities.TestContext;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.*;

import static generics.PageFunctions.*;

public class Tenantspage {
    TestContext testContext;

    public Tenantspage(TestContext testContext) {
        this.testContext = testContext;
    }

    By tenantsPageTitle = By.xpath("//div[@class='css-l5c1s3']/h4");
    By tenantsAddButton = By.xpath("//span[contains(@class, 'MuiButton-startIcon')]");
    By tenantsOrganizationNames = By.xpath("//table[contains(@class, 'MuiTable-root')]/tbody/tr/td[2]");
    By deleteTenantConfirmButton = By.xpath("//div[@role='dialog']/div[contains(@class, 'MuiDialogActions-')]/button[2]");
    By tenantDeletionSuccessMessage = By.xpath("//div[@class='Toastify__toast-body']/div[contains(@class, 'Toastify__toast-icon')]");

    Logger log = Loggers.log();
    String organizationName;
    String organizationNameRemoved;
    String organizationNameToDelete;

//    String orgName = testContext.addtenantspage.organizationName;
//    By tenantsEditButton = By.xpath("//table[contains(@class, 'MuiTable-root')]/tbody/tr/td/div/h6[contains(text(),'"+orgName+"')]/ancestor::td/following-sibling::td/span/a");


    public boolean tenantsPageDsiplayed() {
        return PageFunctions._performExplicitWait(tenantsPageTitle, WaitStrategy.VISIBLE).isDisplayed();
    }

    public void clickAddButton() {
        _performExplicitWait(tenantsAddButton, WaitStrategy.NONE).click();
    }

    public boolean tenantAddedSuccessfully(String orgName) {
        List<String> organizationNames = _getAllDisplayedElementsText(tenantsOrganizationNames);
        return organizationNames.contains(orgName);
    }

    public void clickEditTenantButton(DataTable dataTable) {
        List<String> organizationNameToEdit = dataTable.asList();
        System.out.println(organizationNameToEdit);
        organizationName = organizationNameToEdit.get(0);
        System.out.println(organizationName);
        _performExplicitWait(By.xpath("//table[contains(@class, 'MuiTable-root')]/tbody/tr/td/div/h6[contains(text(),'" + organizationName + "')]/ancestor::td/following-sibling::td/span/a"), WaitStrategy.VISIBLE).click();
    }

    public void deleteTenant(DataTable dataTable) {
        organizationNameToDelete = dataTable.asList().get(0);
        System.out.println(organizationNameToDelete);
        try {
            List<WebElement> organizationsToBeDeleted = _performExplicitWaitForElements(By.xpath("//table[contains(@class, 'MuiTable-root')]/tbody/tr/td/div/h6[contains(text(),'" + organizationNameToDelete + "')]/ancestor::td/following-sibling::td/span[@class='margin_marginLeft10__50tYu'][2]"), WaitStrategy.PRESENCE);
            System.out.println(organizationsToBeDeleted.size());
            for (WebElement deleteButton : organizationsToBeDeleted) {
                _moveToElementAndClick(deleteButton);
                _performExplicitWait(deleteTenantConfirmButton, WaitStrategy.NONE).click();
            }
        } catch (Exception exception) {
            log.info("No tenant with name QA organization to delete");
        }

    }

    public boolean tenantUpdatedSuccessfully(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        organizationName = data.get(0).get(0);
        System.out.println("organizationName : " + organizationName);
        List<String> organizationNames = _getAllDisplayedElementsText(tenantsOrganizationNames);
        return organizationNames.contains(organizationName);
    }

    public boolean tenantDeletedSuccessfully() {
        return _performExplicitWait(tenantDeletionSuccessMessage, WaitStrategy.VISIBLE).isDisplayed();
    }

    public boolean tenantRemovedFromTheList(DataTable dataTable) {
        List<String> data = dataTable.asList();
        organizationNameRemoved = data.get(0);
        System.out.println("organizationNameRemoved : " + organizationNameRemoved);
        List<String> organizationNames = _getAllDisplayedElementsText(tenantsOrganizationNames);
        return !organizationNames.contains(organizationNameRemoved);
    }
}
