package footertests;

import libs.ConfigProperties;
import libs.Utils;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parenttest.ParentTest;

public class GiftCertificateTest extends ParentTest {

    private ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Test
    public void successfullyAddGiftCertificateToCartTest() {
        mainPage.openMainPage();

        log.info("Log in to the site");
        mainPage.openMainPage();
        headerElement.goToLogin();
        loginPage.logIn(configProperties.USER_LOGIN(), configProperties.USER_PASSWORD());

        log.info("Moving to footer");
        mainPage.scrollToFooter();

        log.info("Proceeding to gift certificate screen");
        footerElement.clickOnGiftCertificateButton();

        log.info("Filling in certificate information");
        giftCertificatePage.fillInRecipientName("Jack Daniels");
        giftCertificatePage.fillInRecipientEmail("jackdaniels@whiskey.com");
        giftCertificatePage.fillInSenderName("Johnny Walker");
        giftCertificatePage.fillInSenderEmail("johnnywalker@scotch.com");
        giftCertificatePage.chooseThemeRadioButton("Christmas");
        giftCertificatePage.fillInCertificateMessage("Merry Christmas, pal!");
        giftCertificatePage.fillInGiftsAmount("100");

        log.info("Agree with non-refundable status");
        giftCertificatePage.agreeOnRefundable();

        log.info("Submitting certificate form");
        giftCertificatePage.submitCertificateForm();

        log.info("Verifying that successful submit message is shown");
        checkExpectedResult("Gift certificate was not successfully submitted!"
                , giftCertificatePage.isSuccessfulSubmitContainsExpectedText(configProperties.SUCCESSFUL_CERT_MESSAGE_PART()));

        log.info("Proceeding further with Continue button");
        giftCertificatePage.clickContinueButton();

        log.info("Checking shopping cart is opened");
        checkExpectedResult("Shopping cart is not opened!", cartPage.isGiftCertificateTitleDisplayed());

        log.info("Checking shopping cart is opened");
        checkExpectedResult("Product name is wrong!"
                , cartPage.getProductName().contains(configProperties.CART_PAGE_GIFT_CERTIFICATE_TITLE()));

        log.info("Comparing certificate amount with price -- must be equal");
        checkExpectedResult("Amount and total are not equal!", "100.00".equals(cartPage.getPriceTotal()));
    }

    @Test
    public void checkValidationMessagesInGiftFormTest() {
        mainPage.openMainPage();

        log.info("Moving to footer");
        mainPage.scrollToFooter();

        log.info("Proceeding to gift certificate screen");
        footerElement.clickOnGiftCertificateButton();

        log.info("Clearing preset gift amount" );
        giftCertificatePage.clearGiftAmount();

        log.info("Triggering all validation messages at once");
        giftCertificatePage.submitCertificateForm();

        //Under construction
        System.out.println(giftCertificatePage.getValidationMessages());
        Utils.waitABit(5000);

        //to be continued

    }
}
