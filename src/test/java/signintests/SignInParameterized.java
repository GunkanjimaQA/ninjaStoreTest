package signintests;

import libs.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parenttest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SignInParameterized extends ParentTest {

    String userLogin, userPassword;

    public SignInParameterized(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection credsDataProvider() {
        return Arrays.asList(new Object[][] {
            {"wer34@@mail.com", "99999999999999999"},
            {"denis3000@@meta.ua", "Qwerty*asd"},
            {"denis_300O@meta.ua", "Qwerty*56asD"},
            {"denis_3000@meta.ua.", "qwertY*56asd"},
        });
    }

    @Test
    public void failedLoginTestWithParameters() {
        mainPage.openMainPage();
        Utils.waitABit(3000);
        headerElement.clickOnMyAccount();
        headerElement.clickOnLogin();
        Utils.waitABit(1000);
        loginPage.fillInUserLogin(userLogin);
        loginPage.fillInUserPassword(userPassword);
        loginPage.clickLoginButton();
        checkExpectedResult("Login fail message must be shown!", loginPage.isLoginFailWarningShown());
        loginPage.scrollToBottom();
    }
}
