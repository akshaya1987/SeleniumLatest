package pages;

import org.openqa.selenium.By;
import utilities.TestContext;

public class Tenantspage {

    By tenantsPageTitle = By.xpath("//div[@class='css-l5c1s3']/h4");
    By tenantsAddButton = By.xpath("//span[contains(@class, 'MuiButton-startIcon')]");

    TestContext testContext;

    public Tenantspage(TestContext testContext){
        this.testContext = testContext;
    }
}
