package shoppingcarttests;

import libs.ConfigProperties;
import libs.Utils;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parenttest.ParentTest;

import java.util.Objects;

public class AddFeaturedProductTest extends ParentTest {

    private ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Test
    public void addFeaturedProductToCartAndCheckTest() {

        log.info("Log in to the site");
        mainPage.openMainPage();
        headerElement.goToLogin();
        loginPage.logIn(configProperties.USER_LOGIN(), configProperties.USER_PASSWORD());

        log.info("Verifying Featured products section");
        mainPage.getBackToMainPage();
        mainPage.scrollToFeaturedProductsSection();
        checkExpectedResult("Featured section is broken! Must be 4 products!", mainPage.isFeaturedProductsSectionConsistent());
        checkExpectedResult("Featured product is not displayed!", mainPage.isSpecificFeaturedProductDisplayed(Utils.limitedRandomizer(0, 3)));

        log.info("Getting featured product's data and adding to cart");
        String testFeaturedProductName = mainPage.getFeaturedProductNameByPosition(1);
        mainPage.addFeaturedProductToCart(1);
        checkExpectedResult("Successful alert is not shown for added product!", mainPage.isSuccessfulProductAddAlertShown());

        log.info("Checking product is added in cart");
        Utils.waitABit(2000);
        headerElement.clickOnShoppingCart();
        checkExpectedResult("Shopping cart is not opened!", cartPage.isGiftCertificateTitleDisplayed());
        checkExpectedResult("Wrong product is added!", Objects.equals(testFeaturedProductName, cartPage.getProductName()));

        log.info("Removing Featured product from cart");
        cartPage.removeProductFromCart();
        checkExpectedResult("Product is not correctly removed!", cartPage.isEmptyShoppingCartTitleDisplayed());
    }
}
