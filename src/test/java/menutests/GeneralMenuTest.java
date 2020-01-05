package menutests;

import libs.Utils;
import org.junit.Test;
import parenttest.ParentTest;

public class GeneralMenuTest extends ParentTest {

    @Test
    public void clickMenuTest() {
        headPage.openHeadPage();
        Utils.waitABit(3000);
        upperMenuElement.clickOnMyAccount();
        Utils.waitABit(1000);
        upperMenuElement.clickOnContactUS();
        Utils.waitABit(2000);
        upperMenuElement.clickOnWishlist();
        Utils.waitABit(2000);
        upperMenuElement.clickOnShoppingCart();
        Utils.waitABit(2000);
        upperMenuElement.clickOnCurrencySelector();
        Utils.waitABit(2000);
        upperMenuElement.clickUpperMenuByPosition(0);
        Utils.waitABit(2000);
        upperMenuElement.clickUpperMenuByPosition(1);
        Utils.waitABit(2000);
        upperMenuElement.clickUpperMenuByPosition(2);
        Utils.waitABit(2000);
        upperMenuElement.clickUpperMenuByPosition(3);
        Utils.waitABit(2000);

    }
}
