package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import parentpage.ParentPage;

public class HeadPage extends ParentPage {

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
}
