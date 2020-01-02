package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class SignInPopUpElement extends ParentPage {

    @FindBy(xpath = ".//h1[@class='logo logo-primary']")
    WebElement signInLogo;

    //@FindBy(xpath = ".//div[@class='field field-username-email']//span[@class='input-wrapper']/input[@class='ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-touched']")
    @FindBy(xpath = "//*[text()='Username or Email Address']")
    WebElement loginTextField;

    @FindBy(xpath = ".//input[@type='password']")
    WebElement passwordTextField;

    @FindBy(className = "btn btn-primary btn-submit ng-isolate-scope")
    WebElement signInButton;

    public SignInPopUpElement(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public boolean isSignInLOgoDisplayed() {
        return commonActions.isElementDisplayed(signInLogo);
    }

    public void fillInUserLogin(String userLogin) {
        loginTextField.click();
        commonActions.enterText(loginTextField, userLogin);
    }

    public void fillInUserPassword(String userPassword) {
        commonActions.enterText(passwordTextField, userPassword);
    }

    public void clickOnSignInButton() {
        commonActions.clickOnElement(signInButton);
    }
}
