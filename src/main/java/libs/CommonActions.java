package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class CommonActions {

    private WebDriver driver;
    private Logger log = Logger.getLogger(getClass());
    private WebDriverWait driverWait_10;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        driverWait_10 = new WebDriverWait(driver, 10);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = driverWait_10.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
            log.info("Element displayed: " + state);
            return state;
        } catch (Exception e) {
            log.info("Element displayed: false");
            return false;
        }
    }

    public boolean isElementDisplayed(String locator) {
        try {
            boolean state = isElementDisplayed(driver.findElement(By.xpath(locator)));
            log.info("Element displayed: " + state);
            return state;
        } catch (Exception e) {
            log.info("Element displayed: false");
            return false;
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            driverWait_10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            log.info("Element was clicked.");
        } catch (Exception e) {
            failTest();
        }
    }

    public void enterText(WebElement element, String text) {
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
            log.info(text + " was input into text field");
        } catch (Exception e) {
            failTest();
        }
    }

    public void scrollToTheElement(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        try {
            log.info("Scrolling to desired element.");
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            log.info("Cannot find element to scroll to!");
            failTest();
        }
    }

    public void scrollElementToTheCenter(WebElement element)  {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void scrollToThePageBottom() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        log.info("Scrolling to the bottom of webpage.");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public List<String> getListOfTextsFromElements(List<WebElement> elements) {
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private void failTest() {
        log.info("Test failed! Unable to process the element.");
        Assert.fail("Test failed! Unable to process the element.");
    }
}
