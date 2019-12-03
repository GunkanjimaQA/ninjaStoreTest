package pages;

import libs.ConfigProperties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

import java.util.List;

public class HeadPage extends ParentPage {

    @FindBy(xpath = ".//*[@id='nav-utility']//*[@class='disid-login log-in-out']")
    private WebElement logInOutButton;

    public HeadPage(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public void openHeadPage() {
        try {
            driver.get(configProperties.base_url());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Browser has failed");
        }
    }

    public void clickLogInOutButton() {
        commonActions.clickOnElement(logInOutButton);
    }
}
