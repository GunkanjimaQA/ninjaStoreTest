package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

import java.util.List;
import java.util.stream.Collectors;

public class GiftCertificatePage extends ParentPage {

    @FindBy(id="input-to-name")
    WebElement recipientNameInputField;

    @FindBy(id="input-to-email")
    WebElement recipientEmailInputField;

    @FindBy(id="input-from-name")
    WebElement senderNameInputField;

    @FindBy(id="input-from-email")
    WebElement senderEmailInputField;

    @FindBy(xpath = ".//input[@name='voucher_theme_id']")
    List<WebElement> certificateThemeRadioButtons;

    @FindBy(xpath = ".//div[@class='radio']/label")
    List<WebElement> certificateThemeRadioButtonsTextLabels;

    @FindBy(id="input-message")
    WebElement certificateMessageInputField;

    @FindBy(id="input-amount")
    WebElement giftAmountInput;

    @FindBy(xpath = ".//input[@name='agree']")
    WebElement nonRefundableAgreementCheckbox;

    @FindBy(xpath = ".//input[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = ".//div[@class='row']/div[@id='content']/p")
    WebElement successfulCertificateSubmitMessage;

    @FindBy(xpath = ".//div[@class='pull-right']/a[@href='http://tutorialsninja.com/demo/index.php?route=checkout/cart']")
    WebElement continueButton;

    @FindBy(xpath = ".//div[@class='text-danger']")
    List<WebElement> validationMessages;

    public GiftCertificatePage(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public void fillInRecipientName(String recipientName)  {
        commonActions.clickOnElement(recipientNameInputField);
        commonActions.enterText(recipientNameInputField, recipientName);
    }

    public void fillInRecipientEmail(String recipientEmail)  {
        commonActions.enterText(recipientEmailInputField, recipientEmail);
    }

    public void fillInSenderName(String senderName)  {
        commonActions.enterText(senderNameInputField, senderName);
    }
    public void fillInSenderEmail(String senderEmail)  {
        commonActions.enterText(senderEmailInputField, senderEmail);
    }

    public void chooseThemeRadioButton(String titleText) {
        commonActions.clickOnElementFromListWithText(certificateThemeRadioButtonsTextLabels, titleText);
    }

    public void fillInCertificateMessage(String certificateMessage) {
        commonActions.enterText(certificateMessageInputField, certificateMessage);
    }

    public void clearGiftAmount() {
        giftAmountInput.clear();
    }

    public void fillInGiftsAmount(String amount) {
        commonActions.enterText(giftAmountInput, amount);
    }

    public void agreeOnRefundable() {
        commonActions.toggleCheckbox(nonRefundableAgreementCheckbox, "check");
    }

    public void submitCertificateForm() {
        commonActions.clickOnElement(submitButton);
    }

    public void clickContinueButton() {
        commonActions.clickOnElement(continueButton);
    }

    public boolean isSuccessfulSubmitContainsExpectedText(String expectedText) {
        return successfulCertificateSubmitMessage.getText().contains(expectedText);
    }

    public List<String> getValidationMessages() {
        return commonActions.getListOfTextsFromElements(validationMessages);
    }
}
