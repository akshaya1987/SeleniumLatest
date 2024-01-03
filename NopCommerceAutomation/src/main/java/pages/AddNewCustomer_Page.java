package pages;

import enums.WaitStrategy;
import generics.PageFunctions;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.RandomStringGenerator;
import utilities.TestContext;

import java.util.Calendar;
import java.util.List;

import static generics.PageFunctions._clearAndSendKeys;
import static generics.PageFunctions.*;

public class AddNewCustomer_Page {

    TestContext testContext;

    public AddNewCustomer_Page(TestContext testContext){
        this.testContext = testContext;
    }

    // Global variables
    String name = "Ganesha";
    String emailID;

    // XPATH of page elements
    By addNewCustomerPageHeading = By.xpath("//div[contains(@class, 'content-header')]/h1[contains(text(), 'Add a new customer')]");
    By customerEmailField = By.xpath("//input[@id='Email']");
    By customerPasswordField = By.xpath("//input[@id='Password']");
    By customerFirstNameField = By.xpath("//input[@id='FirstName']");
    By customerLastNameField = By.xpath("//input[@id='LastName']");
    By customerGenderRadioButton = By.xpath("//input[@id='Gender_Male']");
    By calendarOption = By.xpath("//span[@class='k-select' and @aria-controls='DateOfBirth_dateview']");
    By calendarPreviousButton = By.xpath("//div[@class='k-header']/a[@class='k-link k-nav-prev']");
    By calendarNextButton = By.xpath("//div[@class='k-header']/a[@class='k-link k-nav-next']");
    By calendarMidButton = By.xpath("//div[@class='k-header']/a[@class='k-link k-nav-fast']");
    By calendarAllDates = By.xpath("//div[@class='k-calendar-view']//tbody/tr/td[not(contains(@class,'k-other-month'))]");
    By calendarAllMonths = By.xpath("//div[@class='k-calendar-view']//tbody/tr/td/a");
    By companyNameField = By.xpath("//input[@id='Company']");
    By taxExemptCheckbox = By.xpath("//input[@id='IsTaxExempt']");
    By newsLetterField = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/following-sibling::input");
    By getNewsLetterDropdownItem1 = By.xpath("//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[contains(text(), 'Your store name')]");
    By customerRolesField = By.xpath("//input[@aria-describedby=\"SelectedCustomerRoleIds_taglist\"]");
    By customerRolesDropdownItem1 = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']/li[contains(text(),'Administrators')]");
    By managerOfVendorDropdown = By.xpath("//Select[@id='VendorId']");
    By activeCheckbox = By.xpath("//input[@class='check-box' and @id='Active']");
    By adminCommentFiled = By.xpath("//textarea[@id='AdminComment']");
    By saveButton = By.xpath("//button[@name='save']");

    public boolean addNewCustomerPageDisplayed() {
        return PageFunctions._performExplicitWait(addNewCustomerPageHeading, WaitStrategy.VISIBLE).isDisplayed();
    }

    public void fillCustomerInformations(DataTable dataTable) throws InterruptedException {
        List<List<String>> userData = dataTable.asLists();
        emailID = RandomStringGenerator._generateRandomString() + userData.get(0).get(0);
        _clearAndSendKeys(customerEmailField, emailID, "username");
        _clearAndSendKeys(customerPasswordField, userData.get(0).get(1), "password");
        _clearAndSendKeys(customerFirstNameField, userData.get(0).get(2), "fName");
        _clearAndSendKeys(customerLastNameField, userData.get(0).get(3), "lName");
        _setDate(userData.get(0).get(4));
        _performExplicitWait(customerGenderRadioButton, WaitStrategy.CLICKABLE).click();
        _clearAndSendKeys(companyNameField, userData.get(0).get(5), "companyName");
        _performExplicitWait(taxExemptCheckbox, WaitStrategy.CLICKABLE).click();
        _performExplicitWait(newsLetterField, WaitStrategy.CLICKABLE).click();
        _performExplicitWait(getNewsLetterDropdownItem1, WaitStrategy.CLICKABLE).click();
        _performExplicitWait(customerRolesField, WaitStrategy.CLICKABLE).click();
        _performExplicitWait(customerRolesDropdownItem1, WaitStrategy.CLICKABLE).click();
        PageFunctions._select_ByVisibleText(managerOfVendorDropdown, userData.get(0).get(8), "customerRole");
        PageFunctions._checkBox_check(activeCheckbox, WaitStrategy.CLICKABLE, "activeCheckbox");
        _clearAndSendKeys(adminCommentFiled, userData.get(0).get(0), "username");

    }

    public void clickSaveButton() {
        _performExplicitWait(saveButton, WaitStrategy.CLICKABLE).click();
    }

    /**
     * Selects the desired date from calendar
     *
     * @param dateOfBirth
     **/
    public void _setDate(String dateOfBirth) throws InterruptedException {
        WebElement calendarElement;
        WebElement nextButtonElement;
        WebElement previousButtonElement;
        WebElement centerButtonElement;
        calendarElement = PageFunctions._performExplicitWait(calendarOption, WaitStrategy.PRESENCE);
        calendarElement.click();
        centerButtonElement = PageFunctions._performExplicitWait(calendarMidButton, WaitStrategy.PRESENCE);
        Thread.sleep(1000);
        centerButtonElement.click();
        String[] dateMonthYear = dateOfBirth.split(" ")[0].split("/");
        int yearDifferance = Integer.parseInt(dateMonthYear[2]) - Calendar.getInstance().get(Calendar.YEAR);
        System.out.println(yearDifferance);
        System.out.println(yearDifferance < 0);
        if (yearDifferance != 0) {
            if (yearDifferance > 0) {
                for (int i = 1; i <= yearDifferance; i++) {
                    nextButtonElement = PageFunctions._performExplicitWait(calendarNextButton, WaitStrategy.PRESENCE);
                    nextButtonElement.click();
                }
            } else {
                for (int i = 1; i <= (yearDifferance * (-1)); i++) {
                    previousButtonElement = PageFunctions._performExplicitWait(calendarPreviousButton, WaitStrategy.PRESENCE);
                    previousButtonElement.click();
                }
            }
        }
        try {
            PageFunctions._performExplicitWaitForElements(calendarAllMonths, WaitStrategy.CLICKABLE).get(Integer.parseInt(dateMonthYear[1]) - 1).click();
            Thread.sleep(1000);
            PageFunctions._performExplicitWaitForElements(calendarAllDates, WaitStrategy.CLICKABLE).get(Integer.parseInt(dateMonthYear[0]) - 1).click();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


