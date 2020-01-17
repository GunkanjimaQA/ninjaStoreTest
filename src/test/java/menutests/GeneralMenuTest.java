package menutests;

import libs.Utils;
import org.junit.Test;
import parenttest.ParentTest;

public class GeneralMenuTest extends ParentTest {

    @Test
    public void clickMenuTest() {
        mainPage.openMainPage();
        Utils.waitABit(3000);
        headerElement.clickOnContactUS();
        headerElement.clickOnMyAccount();
        headerElement.clickOnWishlist();
        checkExpectedResult("First login page title is not shown!", loginPage.isLoginPageTitleDisplayed(0));
        checkExpectedResult("Second login page title is not shown!", loginPage.isLoginPageTitleDisplayed(1));
        checkExpectedResult("Login button is not shown!", loginPage.isLoginButtonDisplayed());
        headerElement.clickOnShoppingCart();
        checkExpectedResult("Shopping cart page title is not shown!", cartPage.isEmptyShoppingCartTitleDisplayed());
        Utils.waitABit(2000);
        headerElement.clickOnCurrencySelector();
        Utils.waitABit(2000);
        checkExpectedResult("Currencies list is empty!", headerElement.getCurrenciesFromSelector().size() != 0);

        //by position
        //headerElement.clickUpperMenuByPosition(0);
        //Utils.waitABit(2000);
        //headerElement.clickUpperMenuByPosition(1);
        //Utils.waitABit(2000);
        //clickUpperMenuByPosition(2);
        //Utils.waitABit(2000);
        //headerElement.clickUpperMenuByPosition(3);
        //Utils.waitABit(2000);
    }
}
