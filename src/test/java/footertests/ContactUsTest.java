package footertests;

import libs.ConfigProperties;
import libs.Utils;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parenttest.ParentTest;

public class ContactUsTest extends ParentTest {

    private ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Test
    public void successfullySentUserEnquiryTest() {
        mainPage.openMainPage();

        log.info("Moving to footer");
        mainPage.scrollToFooter();

        log.info("Proceeding to Contact Us page");
        footerElement.clickOnContactUs();
        contactPage.scrollToContactForm();

        log.info("Filling in and submitting User inquiry");
        contactPage.fillInUserName("Jack");
        contactPage.fillInUserEmail(configProperties.WRONG_USER_LOGIN());
        contactPage.fillInUserEnquiry("Help me! This site is complete hell!");
        contactPage.submitUserEnquiry();
        Utils.waitABit(5500);
    }

    @Test
    public void failedToSendUserEnquiryTest() {

    }
}
