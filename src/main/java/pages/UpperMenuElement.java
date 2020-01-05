package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

import java.util.List;

public class UpperMenuElement extends ParentPage {

    @FindBy(id = "form-currency")
    private WebElement currencySelector;

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

    public UpperMenuElement(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

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
}
