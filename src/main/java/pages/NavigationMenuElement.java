package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class NavigationMenuElement extends ParentPage {

    @FindBy(className = "news-content-title")
    private WebElement newsBlogMenuOption;

    @FindBy(className = "video-content-title")
    private WebElement videoMenuOption;

    @FindBy(className = "films-content-title")
    private WebElement filmsMenuOption;

    @FindBy(className = "tvshows-content-title")
    private WebElement seriesMenuOption;

    public NavigationMenuElement(WebDriver driver, String partialUrl) {
        super(driver, partialUrl);
    }

    public void clickOnNewsBlog() {
        commonActions.clickOnElement(newsBlogMenuOption);
    }

    public void clickOnVideo() {
        commonActions.clickOnElement(videoMenuOption);
    }

    public void clickOnFilms() {
        commonActions.clickOnElement(filmsMenuOption);
    }

    public void clickOnSeries() {
        commonActions.clickOnElement(seriesMenuOption);
    }



}
