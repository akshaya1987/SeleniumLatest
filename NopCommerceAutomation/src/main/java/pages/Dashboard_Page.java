package pages;

import enums.WaitStrategy;
import generics.PageFunctions;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import utilities.TestContext;

import java.util.List;
import java.util.ListIterator;
import static generics.PageFunctions._performExplicitWait;

public class Dashboard_Page {

    TestContext testContext;

    public Dashboard_Page(TestContext testContext) {
        this.testContext = testContext;
    }

    By dashboardPagetext = By.xpath("//div[@class='content-header']");
    By storeConfigurationSteps = By.xpath("//div[@id='configuration-steps-card']//a[contains(@class, 'configuration-step-link')]//h5");
    By viewConfigurationStepsButton = By.xpath("//div[contains(@class, 'collapsed-card') and @id='configuration-steps-card']//button[@data-card-widget='collapse']");
    By customerHamburgerMenu = By.xpath("//a[@class='nav-link']/i[@class='nav-icon far fa-user']");
    By customersMenu = By.xpath("//a[@class='nav-link']//p[text()=' Customers']");

    public boolean dashboardPageDisplayed() {
        System.out.println((!PageFunctions._performExplicitWait(dashboardPagetext, WaitStrategy.VISIBLE).isDisplayed()));
        return PageFunctions._performExplicitWait(dashboardPagetext, WaitStrategy.VISIBLE).isDisplayed();
    }

    public boolean verifyConfigurationSettingOptions(DataTable data) {
        boolean desiredConfigurationSettingsAvailable = true;
        int i = 0;
        int j = 0;
        try {
            if (PageFunctions._isElementAvailable(viewConfigurationStepsButton)) {
                PageFunctions._click(viewConfigurationStepsButton, "viewStepsButton");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        List<List<String>> options = data.asLists();
        List<String> storeConfigurationStepText = PageFunctions._getAllDisplayedElementsText(storeConfigurationSteps);
        System.out.println(options.size());
        options.forEach(System.out::println);
        System.out.println("------------------------------");
        storeConfigurationStepText.forEach(System.out::println);
        ListIterator<String> listIterator = storeConfigurationStepText.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            System.out.println(storeConfigurationStepText.get(i).equalsIgnoreCase(options.get(i).get(j)));
//            if (desiredConfigurationSettingsAvailable && storeConfigurationStepText.get(i).equalsIgnoreCase(options.get(i).get(i))) {
//                desiredConfigurationSettingsAvailable = false;
//            }
            i++;
        }

        System.out.println("desiredConfigurationSettingsAvailable : " + desiredConfigurationSettingsAvailable);
        return desiredConfigurationSettingsAvailable;
    }


    public void clickCustomersOptionFromHamburgerMenu() {
        _performExplicitWait(customerHamburgerMenu, WaitStrategy.CLICKABLE).click();
    }


    public void clickCustomersLink() {
        PageFunctions._clickByJavascriptExecutor(customersMenu, WaitStrategy.CLICKABLE);
    }
}


//        List<WebElement> storeConfigurationElements = PageFunctions._performExplicitWaitForElements(storeConfigurationSteps, NONE);


