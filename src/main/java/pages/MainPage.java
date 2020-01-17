package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

import java.util.List;

public class MainPage extends ParentPage {

    @FindBy(xpath = ".//div[@class='product-thumb transition']")
    List<WebElement> featuredProducts;

    @FindBy(xpath = ".//h4/a")
    List<WebElement> featuredProductLinks;

    @FindBy(xpath = ".//div[@class='button-group']")
    List<WebElement> addFeaturedToCartButtons;

    @FindBy(xpath = ".//p[@class='price']")
    List<WebElement> featuredProductsPrices;

    @FindBy(xpath = ".//div[@class='alert alert-success alert-dismissible']")
    WebElement successfulAddToCartAlert;

    @FindBy(xpath = ".//a[@href='http://tutorialsninja.com/demo/index.php?route=common/home']")
    WebElement mainPageButton;

    public MainPage(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public void openMainPage() {
        try {
            driver.get(configProperties.base_url());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Browser has failed");
        }
    }

    public void scrollToFeaturedProductsSection() {
        commonActions.scrollToTheElement(featuredProducts.get(0));
    }

    public void getBackToMainPage() {
        commonActions.clickOnElement(mainPageButton);
    }

    public void addFeaturedProductToCart(int itemPosition) {
        addFeaturedToCartButtons.get(itemPosition).click();
    }

    public void scrollToFooter() {
        commonActions.scrollToThePageBottom();
    }

    public String getFeaturedProductNameByPosition(int itemPosition) {
        return featuredProductLinks.get(itemPosition).getText();
    }

    public boolean isFeaturedProductsSectionConsistent() {
        return featuredProducts.size() == 4;
    }

    public boolean isSpecificFeaturedProductDisplayed(int itemPosition) {
        return commonActions.isElementDisplayed(featuredProducts.get(itemPosition));
    }

    public String getCurrencyFromFeaturedProduct(int itemPosition) {
        String symbol = featuredProductsPrices
                .get(itemPosition)
                .getText()
                .replaceAll("[^£€$\\\\]", "");
        return commonActions.currencyDetector(symbol);
    }

    public boolean isSuccessfulProductAddAlertShown() {
        return commonActions.isElementDisplayed(successfulAddToCartAlert);
    }

    public String chooseNewCurrencyForTest(String currentCurrency) {
        switch (currentCurrency) {
            case "USD":
                return "EUR";
            case "EUR":
                return "GBP";
            case "GBP":
                return "USD";
            default:
                log.error("Wrong currency acronym!");
                return "none";
        }
    }
}
