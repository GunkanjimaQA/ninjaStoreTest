package signintest;

import libs.ConfigProperties;
import libs.Utils;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.junit.Test;
import parenttest.ParentTest;

public class SignInTest extends ParentTest {

    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Test
    public void successfulLogin() {
        headPage.openHeadPage();
        Utils.waitABit(3000);

        upperMenuElement.clickOnMyAccount();
        upperMenuElement.clickOnLogin();
        Utils.waitABit(1000);
        loginPage.fillInUserLogin(configProperties.USER_LOGIN());
        loginPage.fillInUserPassword(configProperties.USER_PASSWORD());
        loginPage.clickLoginButton();
        Utils.waitABit(6000);
    }

    @Test
    public void failedLoginTest() {
        headPage.openHeadPage();
        Utils.waitABit(3000);

        upperMenuElement.clickOnMyAccount();
        upperMenuElement.clickOnLogin();
        Utils.waitABit(1000);
        loginPage.fillInUserLogin(configProperties.WRONG_USER_LOGIN());
        loginPage.fillInUserPassword(configProperties.WRONG_USER_PASSWORD());
        loginPage.clickLoginButton();
        checkExpectedResult("Login fail message must be shown!", loginPage.isLoginFailWarningShown());
        loginPage.scrollToBottom();
        Utils.waitABit(6000);
    }
}
