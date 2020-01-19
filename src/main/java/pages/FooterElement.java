package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class FooterElement extends ParentPage {

    @FindBy(xpath = ".//ul[@class='list-unstyled']/li/a[@href='http://tutorialsninja.com/demo/index.php?route=information/contact']")
    WebElement contactUsButton;

    @FindBy(xpath = ".//ul[@class='list-unstyled']/li/a[@href='http://tutorialsninja.com/demo/index.php?route=account/voucher']")
    WebElement giftCertificateButton;

    public FooterElement(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public void clickOnContactUs() {
        commonActions.clickOnElement(contactUsButton);
    }

    public void clickOnGiftCertificateButton() {
        commonActions.clickOnElement(giftCertificateButton);
    }
}
