package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

import java.util.ArrayList;
import java.util.List;

public class HeaderElement extends ParentPage {

    //Upper menu

    @FindBy(id = "form-currency")
    private WebElement currencySelector;

    @FindBy(xpath = ".//button[@class='currency-select btn btn-link btn-block']")
    private List<WebElement> currenciesButtons;

    @FindBy(xpath = ".//a[@href='http://tutorialsninja.com/demo/index.php?route=information/contact']")
    private WebElement contactUSButton;

    @FindBy(xpath = ".//a[@href='http://tutorialsninja.com/demo/index.php?route=account/account']")
    private WebElement myAccountButton;

    //@FindBy(xpath = ".//a[@href='http://tutorialsninja.com/demo/index.php?route=account/wishlist']")
    @FindBy(id = "wishlist-total")
    private WebElement wishlistButton;

    @FindBy(xpath = ".//a[@href='http://tutorialsninja.com/demo/index.php?route=checkout/cart']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = ".//a[@href='http://tutorialsninja.com/demo/index.php?route=checkout/checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = ".//ul[@class='list-inline']/li")
    private List<WebElement> upperMenuItems;

    @FindBy(xpath = ".//a[@href='http://tutorialsninja.com/demo/index.php?route=account/login']")
    private  WebElement upperMenuLogin;

    //Cart dropdown

    //@FindBy(id = "cart-total")
    //@FindBy(xpath = ".//div[@id='cart']")
    //@FindBy(id = "cart")
    @FindBy(xpath = ".//div/div/button[@data-toggle='dropdown']")
    private WebElement cartDropdownButton;

    @FindBy(xpath = ".//button[@title='Remove']")
    private WebElement cartDropdownRemoveButton;

    @FindBy(xpath = ".//button[@title='Remove']")
    private List<WebElement> cartDropdownRemoveButtons;

    public HeaderElement(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    // Methods

    public void clickOnCurrencySelector() {
        commonActions.clickOnElement(currencySelector);
    }

    public void clickOnContactUS() {
        commonActions.clickOnElement(contactUSButton);
    }

    public void clickOnMyAccount() {
        commonActions.clickOnElement(myAccountButton);
    }

    public void clickOnWishlist() {
        commonActions.clickOnElement(wishlistButton);
    }
    
    public void clickOnShoppingCart() {
        commonActions.clickOnElement(shoppingCartButton);
    }

    public void clickOnCheckout() {
        commonActions.clickOnElement(checkoutButton);
    }

    public void clickOnLogin() {
        commonActions.clickOnElement(upperMenuLogin);
    }

    public void clickUpperMenuByPosition(int position) {
        commonActions.clickOnElement(upperMenuItems.get(position));
    }

    public void openCartDropdown() {
        commonActions.clickOnElement(cartDropdownButton);
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click();", cartDropdownButton);
    }

    public void removeProductFromCartDropdown() {
        cartDropdownRemoveButton.click();
    }

    public void removeProductFromCartDropdown(int position) {
        if (position > cartDropdownRemoveButtons.size() + 1) {
            log.error("No product with this position!");
            return;
        }
        cartDropdownRemoveButtons.get(position).click();
    }

    public List<String> getCurrenciesFromSelector() {
        List<String> currenciesListRaw = commonActions.getListOfTextsFromElements(currenciesButtons);
        List<String> currenciesListClean = new ArrayList<>();
        for (String currency : currenciesListRaw) {
            currenciesListClean.add(currency.replaceAll("[^a-zA-Z0-9\\\\]", ""));
        }
        return currenciesListClean;
    }

    // Shortcut methods

    public void goToLogin() {
        clickOnMyAccount();
        clickOnLogin();
    }
}
