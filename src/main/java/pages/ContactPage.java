package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class ContactPage extends ParentPage {

    @FindBy(xpath = ".//input[@type='submit']")
    WebElement submitUserMessageButton;

    @FindBy(id = "input-name")
    WebElement userNameInput;

    @FindBy(id = "input-email")
    WebElement userEmailInput;

    @FindBy(id = "input-enquiry")
    WebElement userInquiryInput;

    public ContactPage(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public void scrollToContactForm() {
        commonActions.scrollToTheElement(submitUserMessageButton);
    }

    public void fillInUserName(String userName) {
        commonActions.enterText(userNameInput, userName);
    }

    public void fillInUserEmail(String userEmail) {
        commonActions.enterText(userEmailInput, userEmail);
    }

    public void fillInUserEnquiry(String userEnquiry) {
        commonActions.enterText(userInquiryInput, userEnquiry);
    }

    public void submitUserEnquiry() {
        commonActions.clickOnElement(submitUserMessageButton);
    }
}
