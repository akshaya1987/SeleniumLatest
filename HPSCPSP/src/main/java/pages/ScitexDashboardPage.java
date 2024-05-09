package pages;

import generics.PageFunctions;
import org.openqa.selenium.By;
import utilities.TestContext;

public class ScitexDashboardPage {

    By serviceCenterHome = By.xpath("//h1[contains(text(), 'Home')]");
    By selectedFamily = By.xpath("//div[@class='selectedItem' and contains(text(), 'HP Scitex')]");
    public By partsToReturn = By.xpath("//div[@class='summary-item-header']/following-sibling::div[contains(text(), 'Parts to Return')]");
    public By orderedItems = By.xpath("//div[@class='summary-item-header']/following-sibling::div[contains(text(), 'Ordered Items')]");
    public By UTKs = By.xpath("//div[@class='summary-item-header']/following-sibling::div[contains(text(), 'UTKs')]");
    public By scitexPartsCatalogCard = By.xpath("//div[@class='parts-catalog-card-container-header']/span/strong[contains(text(),'Scitex Parts Catalog')]/ancestor::a[@class='parts-catalog-card-container ng-star-inserted']");
    public By supportCasesCard = By.xpath("//div[@class='cases-card-container-header']/span[contains(text(),'Support Cases')]");
    public By hpScitexIOMCard = By.xpath("//div[@class='sutk-card-container-header ng-star-inserted']/ancestor::div[@class='sutk-card-container-content ng-star-inserted']");
    public By partsReturnStatusCard = By.xpath("//div[@class='parts-card-container-header']/span[contains(text(),'Parts Return Status')]/ancestor::a[@class='parts-card-container'])");
    TestContext testContext;

    public ScitexDashboardPage(TestContext testContext) {
        this.testContext = testContext;
    }

    public boolean serviceCenterHomePageDisplayed(){
        return PageFunctions._isDisplayed(serviceCenterHome, "Home");
    }

    public boolean selectedFamily(){
        return PageFunctions._isDisplayed(selectedFamily, "Family");
    }

    public boolean partsToReturnIsDisplayed() {
        return PageFunctions._isDisplayed(partsToReturn, "Parts to return");
    }

    public boolean orderedItemsDisplayed() {
        return PageFunctions._isDisplayed(orderedItems, "Parts to return");
    }

    public boolean utksDisplayed() {
        return PageFunctions._isDisplayed(UTKs, "Parts to return");
    }

    public boolean scitexPartsCatalogCardDisplayed() {
        return PageFunctions._isDisplayed(scitexPartsCatalogCard, "scitex parts card");
    }

    public boolean supportCasesCardDisplayed() {
        return PageFunctions._isDisplayed(supportCasesCard, "support case card");
    }

    public boolean hpScitexIOMCardDisplayed() {
        return PageFunctions._isDisplayed(hpScitexIOMCard, "scitex IMO card");
    }

    public boolean partsReturnStatusCard() {
        return PageFunctions._isDisplayed(partsReturnStatusCard, "parts return status card");
    }
}
