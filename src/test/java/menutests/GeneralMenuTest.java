package menutests;

import libs.Utils;
import org.junit.Test;
import parenttest.ParentTest;

public class GeneralMenuTest extends ParentTest {

    @Test
    public void clickMenuTest() {
        headPage.openHeadPage();
        Utils.waitABit(3000);
        navigationMenuElement.clickOnFilms();
        Utils.waitABit(3000);
        navigationMenuElement.clickOnVideo();
        Utils.waitABit(3000);
        navigationMenuElement.clickOnSeries();
        Utils.waitABit(3000);
        navigationMenuElement.clickOnNewsBlog();
        Utils.waitABit(4000);
        headPage.clickLogInOutButton();
        Utils.waitABit(6000);
    }
}
