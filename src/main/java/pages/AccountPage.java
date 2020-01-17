package pages;

import libs.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

import java.util.List;

public class AccountPage extends ParentPage {

    public AccountPage(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    @FindBy(xpath = ".//h2")
    List<WebElement> accountPageTitles;

    public String getAccountPageTitleName(int titlePosition) {
        Utils.waitABit(3000);
        return accountPageTitles.get(titlePosition).getText();
    }
}
