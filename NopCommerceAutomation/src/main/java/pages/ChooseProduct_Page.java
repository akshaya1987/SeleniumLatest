package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import utilities.TestContext;

import static generics.PageFunctions.*;
public class ChooseProduct_Page {

    TestContext testContext;

    public ChooseProduct_Page(TestContext testContext){
        this.testContext = testContext;
    }

    By productList = By.xpath("//table/tbody//td/button");

    public void chooseProduct(){
        _performExplicitWaitForElements(productList, WaitStrategy.VISIBLE).get(0).click();
    }
}
