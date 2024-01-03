package pages;

import enums.WaitStrategy;
import generics.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestContext;

import java.util.List;

import static generics.PageFunctions._performExplicitWait;
import static generics.PageFunctions._performExplicitWaitForColumnElements;

public class Customers_Page {

    TestContext testContext;

    public Customers_Page(TestContext testContext) {
        this.testContext = testContext;
    }

    By customersPageHeading = By.xpath("//div[@class='content-header clearfix']");
    By addNewCustomerButton = By.xpath("//div[@class='float-right']/a[@class='btn btn-primary']");
    By successPopup = By.xpath("//div[@class=\"alert alert-success alert-dismissable\"]/button[text()]");
    By customerEmailInTable = By.xpath("//table[@id='customers-grid']/tbody/tr/td[2]");
    By customerTableRows = By.xpath("//table[@id='customers-grid']//tbody//tr");
    By customerTableColumns = By.xpath("./td[text()]");
    By emailSearchField = By.xpath("//input[@id='SearchEmail']");
    By fNameSearchField = By.xpath("//input[@id='SearchFirstName']");
    By lNameSearchField = By.xpath("//input[@id='SearchLastName']");
    By searchButton = By.xpath("//button[@id=\"search-customers\"]");

    public boolean customerPageDisplayed() {
        return PageFunctions._performExplicitWait(customersPageHeading, WaitStrategy.VISIBLE).isDisplayed();
    }

    public void clickAddNewCustomerButton() {
        _performExplicitWait(addNewCustomerButton, WaitStrategy.PRESENCE).click();
    }

    public boolean customerAddedSuccessMessageDisplayed() {
        return PageFunctions._performExplicitWait(successPopup, WaitStrategy.VISIBLE).isDisplayed();
    }

    public boolean customerAvailableInTable() {
        boolean customerAvailable = false;
        List<WebElement> customerEmailsCellElements = PageFunctions._performExplicitWaitForElements(customerEmailInTable, WaitStrategy.PRESENCE);
        for (WebElement element : customerEmailsCellElements) {
            if (element.getText().equalsIgnoreCase(testContext.addNewCustomerPage.emailID)) {
                customerAvailable = true;
                break;
            }
        }
        return customerAvailable;
    }

    public boolean searchCustomer(String searchkey) throws InterruptedException {
        boolean customerIsPresent = false;
        Thread.sleep(1500);
        List<WebElement> customerRows = PageFunctions._performExplicitWaitForElements(customerTableRows, WaitStrategy.PRESENCE);
        for (WebElement rows : customerRows) {
            List<WebElement> customerColumns = rows.findElements(By.xpath("./td[text()]"));
            for (WebElement column : customerColumns) {
                if (column.getText().contains(searchkey)) {
                    customerIsPresent = true;
                    break;
                }
            }
        }
        return customerIsPresent;
    }

    public void fillSearchString(String searchString, String searchCriteria) {
        switch (searchCriteria) {
            case "email":
                PageFunctions._performExplicitWait(emailSearchField, WaitStrategy.PRESENCE).sendKeys(searchString);
                break;
            case "fname":
                PageFunctions._performExplicitWait(fNameSearchField, WaitStrategy.PRESENCE).sendKeys(searchString);
                break;
            case "lname":
                PageFunctions._performExplicitWait(lNameSearchField, WaitStrategy.PRESENCE).sendKeys(searchString);
                break;
            default:
                System.out.println("Unknown search criteria! search criteria should be \"email\" or \"fname\" or \"lname\" ");
                break;
        }
    }

    public void clickSearchButton() {
        _performExplicitWait(searchButton, WaitStrategy.PRESENCE).click();
    }


}

