package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

import java.util.List;

public class LoginPage extends ParentPage {

    @FindBy(id = "input-email")
    private WebElement emailInputField;

    @FindBy(id = "input-password")
    private WebElement passwordInputField;

    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = ".//div[@class='alert alert-danger alert-dismissible']")
    private WebElement loginFailWarning;

    @FindBy(xpath = ".//h2")
    private List<WebElement> mediumTitles;

    public LoginPage(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public void fillInUserLogin(String userLogin) {
        commonActions.enterText(emailInputField, userLogin);
    }

    public void fillInUserPassword(String userPassword) {
        commonActions.enterText(passwordInputField, userPassword);
    }

    public void clickLoginButton() {
        commonActions.clickOnElement(loginButton);
    }

    public boolean isLoginFailWarningShown() {
        return commonActions.isElementDisplayed(loginFailWarning);
    }

    public void scrollToBottom() {
        commonActions.scrollToThePageBottom();
    }

    public void logIn(String userLogin, String userPassword) {
        fillInUserLogin(userLogin);
        fillInUserPassword(userPassword);
        clickLoginButton();
    }

    public boolean isLoginPageTitleDisplayed(int title) {
        return commonActions.isElementDisplayed(mediumTitles.get(title));
    }

    public boolean isLoginButtonDisplayed() {
        return commonActions.isElementDisplayed(loginButton);
    }
}
