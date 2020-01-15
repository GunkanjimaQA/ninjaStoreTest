package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class CartPage extends ParentPage {

    private ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @FindBy(xpath = ".//form/div/table/tbody/tr[1]/td[2]")
    WebElement productName;

    @FindBy(xpath = ".//button[@data-original-title='Remove']")
    WebElement removeProductButton;

    public CartPage(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public boolean isEmptyShoppingCartTitleDisplayed() {
        return  commonActions.isElementDisplayed(".//h1[text()='"
                + configProperties.CART_PAGE_EMPTY_TITLE()
                + "']");
    }

    public boolean isGiftCertificateTitleDisplayed() {
        return commonActions.isElementDisplayed(".//h1[contains(text(), '"
                + configProperties.CART_PAGE_GIFT_CERTIFICATE_TITLE()
                + "')]"
        );
    }

    public String getProductName() {
        return productName.getText();
    }

    public void removeProductFromCart() {
        commonActions.clickOnElement(removeProductButton);
    }
}
