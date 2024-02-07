package pages;

import enums.WaitStrategy;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import utilities.TestContext;

import java.util.List;
import generics.PageFunctions;

import static generics.PageFunctions.*;

public class AddCustomerRole_Page {

    TestContext testContext;

    public AddCustomerRole_Page(TestContext testContext) {
        this.testContext = testContext;
    }

    By nameFIeld = By.xpath("//input[@id='Name']");
    By activeCheckbox = By.xpath("//input[@type='checkbox' and @name='Active']");
    By freeShipping = By.xpath("//input[@type='checkbox' and @name='FreeShipping']");
    By taxExemptCheckbox = By.xpath("//input[@type='checkbox' and @name='TaxExempt']");
    By overrideDefaultTaxDisplayTypeCheckbox = By.xpath("//input[@type='checkbox' and @name='OverrideTaxDisplayType']");
    By enablePasswordLifeTimeCheckbox = By.xpath("//input[@type='checkbox' and @name='EnablePasswordLifetime']");
    By chooseProductButton = By.xpath("//button[@type='submit' and contains (text(), 'Choose a product')]");
    By systemNameField = By.xpath("//input[@id='SystemName']");
    By addNewCustomerButton = By.xpath("//div[@class='float-right']/a[@class='btn btn-primary']");

    public void fillCustomerRoleInformation(DataTable datatable) {
        List<List<String>> data = datatable.asLists();
        String userRolePageTitle = data.get(0).get(0);
        _clearAndSendKeys(nameFIeld, "Akshay", "name");
        _checkBox_check(activeCheckbox, WaitStrategy.NONE, "activeCheckbox");
        _checkBox_check(freeShipping, WaitStrategy.NONE, "freeShippingCheckbox");
        _checkBox_check(taxExemptCheckbox, WaitStrategy.NONE, "taxExemptCheckbox");
        _checkBox_check(overrideDefaultTaxDisplayTypeCheckbox, WaitStrategy.NONE, "overrideDefaultTaxDisplayTypeCheckbox");
        _checkBox_check(enablePasswordLifeTimeCheckbox, WaitStrategy.NONE, "enablePasswordLifeTimeCheckbox");
        _performExplicitWait(chooseProductButton, WaitStrategy.CLICKABLE).click();
        _switchToWindow();

    }

    public void clickAddNewButton() {
        _performExplicitWait(addNewCustomerButton, WaitStrategy.CLICKABLE).click();
    }

}
